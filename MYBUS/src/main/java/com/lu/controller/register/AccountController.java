package com.lu.controller.register;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.Account;
import com.lu.entity.vo.AccountRegisterVo;
import com.lu.entity.vo.AccountSearchVo;
import com.lu.service.AccountService;
import com.lu.util.PagingVO;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request,@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "password", required = false) String password){
		String result=null;
		Account account=accountService.findByName(name);
		Md5PasswordEncoder md5=new Md5PasswordEncoder();
		String pwd=md5.encodePassword(password, null);
		if(account==null){
			result="user not exis!";
		}else if(pwd.equals(account.getPassword())){
			result="success!";
			request.getSession().setAttribute("acount", account);
		}else{
			result="wrong password!";
		}
		return result;
	}
	
	
	@RequestMapping("/login/result")
	public String loginResult(){
		return "view/loginsuccess";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request, AccountRegisterVo accountVo){
		System.out.println(accountVo.getName()+"---"+accountVo.getPassword()+"---"+accountVo.getPassword2());
		//ResultResponse result = new ResultResponse();
		String result=null;
		String name=accountVo.getName().trim();
		String password=accountVo.getPassword().trim();//ȥ����ͷ�Ŀո�
		String password2=accountVo.getPassword2().trim();
		if(password!=null && password2!=null && !"".equals(password) && !"".equals(password2) && password.equals(password2)){
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			Account account=new Account();
			account.setName(name);
			account.setPassword(md5.encodePassword(password, null));
			accountService.save(account);
			result="success!";
		}else{
			result="failure!";
		}
		return result;
	}
	
	@RequestMapping("/register/checkname")
	@ResponseBody
	public String checkName(HttpServletRequest request){
		String flag=null;
		String name=request.getParameter("name").trim();
		if(name!=null){
			boolean f=accountService.checkName(name);
			if(f==true){
				flag="true";
			}else{
				flag="false";
			}
		}
		return flag;
	}
	@RequestMapping("/list")
	public String accountSearchList(PagingVO pagingVo,AccountSearchVo accountVo,Model model, HttpServletRequest request){
		PagingVO vo =accountService.searchList(pagingVo,accountVo);
		System.out.println(vo.getCount());
		return "";
	}
	
}
