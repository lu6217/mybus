package com.lu.controller.register;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.account.Account;
import com.lu.entity.vo.ChangePasswordVo;
import com.lu.service.AccountService;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/accountinfo")
public class AccountInfoController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/tochangepassword")
	public String tochangePassword(HttpServletRequest request){
		
		return "view/background/account/changepassword";
	}
	
	@RequestMapping("/changepassword")
	@ResponseBody
	public ResultResponse updateAccount(HttpServletRequest request,ChangePasswordVo cpVo){
		
		ResultResponse result = new ResultResponse();
		
		if(cpVo!=null){
			Md5PasswordEncoder md5=new Md5PasswordEncoder();
			String pwd=md5.encodePassword(cpVo.getOriginalpassword(), null);
			Account account = (Account)request.getSession().getAttribute("account");
			if(pwd.equals(account.getPassword())){
				
//				if(cpVo.getPassword().equals(cpVo.getPassword2())){
					//
					account.setPassword(cpVo.getPassword());
					accountService.updateAccount(account);
					result.setMessage("success!");
//				}
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("original password error!");
			}
		}
		return result;
	}
}
