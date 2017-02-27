package com.lu.controller.register;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.Account;
import com.lu.entity.vo.AccountVo;
import com.lu.service.AccountService;
import com.lu.util.ResultResponse;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/register")
	@ResponseBody
	public ResultResponse register(HttpServletRequest request, AccountVo accountVo){
		System.out.println(accountVo.getName()+"---"+accountVo.getPassword()+"---"+accountVo.getPassword2());
		System.out.println("kk");
		ResultResponse result = new ResultResponse();

		String name=accountVo.getName().trim();
		String password=accountVo.getPassword().trim();//去掉两头的空格
		String password2=accountVo.getPassword2().trim();
		if(password!=null && password2!=null && !"".equals(password) && !"".equals(password2) && password.equals(password2)){
			Account account=new Account();
			account.setName(name);
			account.setPassword(password);
			accountService.save(account);
			System.out.println("ok");
		}else{
			System.out.println("请确认密码!");
			result.setResult(Boolean.FALSE);
			result.setMessage("请确认密码！");
		}
		
		return result;
	}
	
	@RequestMapping("/register/checkname")
	@ResponseBody
	public String checkName(HttpServletRequest request){
		String flag=null;
		String name=request.getParameter("name");
		System.out.println(name);
		return flag;
	}
	

}
