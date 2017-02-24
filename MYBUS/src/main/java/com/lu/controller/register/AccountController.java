package com.lu.controller.register;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.Account;
import com.lu.entity.vo.AccountVo;
import com.lu.service.AccountService;


@ControllerAdvice
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request, AccountVo accountVo){
		System.out.println(accountVo.getName()+"---"+accountVo.getPassword()+"---"+accountVo.getPassword2());
		System.out.println("kk");
		
		String name=accountVo.getName();
		String password=accountVo.getPassword();
		String password2=accountVo.getPassword2();
		if(password.equals(password2)){
			Account account=new Account();
			account.setName(name);
			account.setPassword(password);
			accountService.save(account);
			System.out.println("ok");
		}else{
			System.out.println("«Î»∑»œ√‹¬Î!");
		}
		
		return null;
	}
	
	
	

}
