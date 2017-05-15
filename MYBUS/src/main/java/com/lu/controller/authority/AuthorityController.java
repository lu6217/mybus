package com.lu.controller.authority;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.service.AuthorityService;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/authoritylist")
	public String orderlist(PagingVO pagingVo,Model model, HttpServletRequest request){
//		Long accountId= ((Account)WebUtils.getSessionAttribute(request, "account")).getId();
		PagingVO vo =authorityService.searchList(pagingVo);
		model.addAttribute("pageVO", vo);
		return "/view/background/authority/authority";
	}
	
	@RequestMapping("/toaddrole")
	public String toAddRole(Model model, HttpServletRequest request){
		
		return "/view/background/authority/addrole";
	}
	
	@RequestMapping("/toaddmenu")
	public String toAddMenu(Model model, HttpServletRequest request){
		
		return "/view/background/authority/addmenu";
	}
	
	@RequestMapping("/checkrolename")
	@ResponseBody
	public ResultResponse checkName(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		
		String name=request.getParameter("name").trim();
		if(name!=null){
			boolean flag=authorityService.checkName(name);
			if(flag){
				result.setResult(Boolean.FALSE);
				result.setMessage("Name Exists!");
			}else{
				result.setMessage("Name Avaiable!");
			}
		}
		
		return result;
	}
	
	
	@RequestMapping("/addrole")
	@ResponseBody
	public ResultResponse createSite(HttpServletRequest request,Role role){
		ResultResponse result = new ResultResponse();
		if(role!=null){
			if(!authorityService.checkName(role.getName())){
				authorityService.save(role);
				result.setMessage("Create Success");
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("Failure! Name Exists");
			}
		}
		return result; 
	}
	
	
	@RequestMapping("/getmenu")
	public String getMenu(Model model, HttpServletRequest request){
		Long roleId=Long.parseLong(request.getParameter("roleId").trim());
		//此功能还没有进行测试   
		List<Menu> menus=authorityService.getMenuByRoleId(roleId);
		model.addAttribute("menulist",menus);
		return "/view/background/authority/menu_data";
	}
	
	
}
