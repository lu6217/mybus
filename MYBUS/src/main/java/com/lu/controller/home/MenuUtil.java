package com.lu.controller.home;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lu.entity.account.Account;
import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.service.AuthorityService;
@Component
public class MenuUtil {

	@Autowired
	private AuthorityService authorityService;
	
	private static MenuUtil menuUtils;  
	  
    public void setUserInfo(AuthorityService authorityService) {  
        this.authorityService = authorityService;  
    }  
      
    @PostConstruct  
    public void init() {  
    	menuUtils = this;  
    	menuUtils.authorityService = this.authorityService;  
    }  
	
	public static List<Menu> getMenus(HttpServletRequest request){
		Account account = (Account)request.getSession().getAttribute("account");
		if(account!=null){
			Long number=account.getType();
			Role role=menuUtils.authorityService.getRoleByNumber(number);
			if(role!=null){
				List<Menu> menus=menuUtils.authorityService.getMenuByRoleId(role.getId());
				return menus;
			}
		}
		return null;
	}
	
	public static boolean isPermission(HttpServletRequest request,HttpServletResponse response,String uri){
		
		Account account = (Account)request.getSession().getAttribute("account");
		int start=uri.indexOf("luwei/")+"luwei/".length();
		int end=uri.indexOf("/", start);
		String auth=uri.substring(start, end);
		List<Menu> lists=menuUtils.authorityService.getMenus();
		if (lists!=null) {
			List<String> auths=new ArrayList<String>();
			for (int i = 0; i < lists.size(); i++) {
				auths.add(lists.get(i).getItem());
			}
			if(auths.contains(auth)){  //所有的权限中有此权限   然后判断此用户有没有此权限   若有则通过 若没有  则阻止
				if(account!=null){
					Long number=account.getType();
					Role role=menuUtils.authorityService.getRoleByNumber(number);
					if(role!=null){
						List<Menu> menus=menuUtils.authorityService.getMenuByRoleId(role.getId());
						if(menus!=null){
							List<String> authss=new ArrayList<String>();
							for (int i = 0; i < menus.size(); i++) {
								authss.add(menus.get(i).getItem());
							}
							if(!authss.contains(auth)){
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
}
