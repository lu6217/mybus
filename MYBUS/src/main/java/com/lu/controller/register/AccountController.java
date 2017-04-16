package com.lu.controller.register;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.account.Account;
import com.lu.entity.account.User;
import com.lu.entity.vo.AccountRegisterVo;
import com.lu.entity.vo.AccountSearchVo;
import com.lu.entity.vo.UserVo;
import com.lu.service.AccountService;
import com.lu.service.UserService;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService; 
	
	/**
	 * login
	 * @param request
	 * @param name
	 * @param password
	 * @return
	 */
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
	public ResultResponse register(HttpServletRequest request, AccountRegisterVo accountVo){
		//ResultResponse result = new ResultResponse();
		ResultResponse result = new ResultResponse();
		String name=accountVo.getName().trim();
		if(!accountService.checkName(name)){
			String password=accountVo.getPassword().trim();//去除空格
			String password2=accountVo.getPassword2().trim();
			if(password!=null && password2!=null && !"".equals(password) && !"".equals(password2) && password.equals(password2)){
				Md5PasswordEncoder md5 = new Md5PasswordEncoder();
				Account account=new Account();
				account.setName(name);
				account.setPassword(md5.encodePassword(password, null));
				accountService.save(account);
				result.setMessage("Register Success!");
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("Register Failure! Password Error!");
			}
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("Register Failure! Name Exists");
		}
		return result;
	}
	
	@RequestMapping("/register/checkname")
	@ResponseBody
	public ResultResponse checkName(HttpServletRequest request){
		
		ResultResponse result = new ResultResponse();
		String name=request.getParameter("name").trim();
		if(name!=null){
			boolean flag=accountService.checkName(name);
			if(flag){
				result.setResult(Boolean.FALSE);
				result.setMessage("Name Exists");
			}else{
				result.setMessage("Name Avaiable");
			}
		}
		return result;
	}
	@RequestMapping("/accountlist")
	public String accountSearchList(PagingVO pagingVo,AccountSearchVo accountVo,Model model, HttpServletRequest request){
		PagingVO vo =accountService.searchList(pagingVo,accountVo);
		model.addAttribute("pageVO", vo);
		return "view/background/account/accountlist";
	}
	
	@RequestMapping("/get/{id}")
	public String getUser(@PathVariable("id")Long id, Model model){
		User user=userService.getUserById(id);
		model.addAttribute("user", user);
		return "view/background/account/adduser";
	}
	
	@RequestMapping("/getuserinfo/{id}")
	public String getUserInfo(@PathVariable("id")Long id, Model model){
		User user=userService.getUserById(id);
		model.addAttribute("user", user);
		return "view/background/account/userinfo";
	}
	
	@RequestMapping("/deluser")
	@ResponseBody
	public ResultResponse delUser(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		Long id=Long.parseLong(request.getParameter("id").trim());
		User user=userService.getUserById(id);
		if(user!=null){
			userService.delUser(user);
			result.setMessage("OK! 删除成功!");
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("falure!");
		}
		return result;
	}
	
	@RequestMapping("/updatetype")
	@ResponseBody
	public String updateAccountType(HttpServletRequest request,@RequestParam(value = "accountId", required = false) Long accountId,
			@RequestParam(value = "type", required = false) Long type){
		String result=null;
		Account account=accountService.findById(accountId);
		if(account!=null){
			account.setType(type);
			if(accountService.updateAccountType(account)){
				result="success!";
			}
		}else{
			result="user not exis!";
		}
		
		return result;
	}
	
	@RequestMapping("/toadduser/{id}")
	public String toAddUser(@PathVariable("id")Long id, Model model){
		model.addAttribute("accountId", id);
		return "view/background/account/adduser";
	}
	
	/**
	 * save or update
	 * @param request
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/adduser")
	@ResponseBody
	public ResultResponse addUser(HttpServletRequest request, UserVo userVo){
		ResultResponse result = new ResultResponse();
		if(userVo!=null && userVo.getId()!=null){
			User user=userService.getUserById(userVo.getId());
			user.setAddress(userVo.getAddress().trim());
			user.setAge(Long.parseLong(userVo.getAge().trim()));
			user.setIDcard(userVo.getIDcard().trim());
			user.setName(userVo.getName().trim());
			user.setSex(Long.parseLong(userVo.getSex().trim()));
			user.setTelphone(userVo.getTelphone().trim());
			userService.saveOrUpdateUser(user);
			result.setMessage("OK! success!");
		}else if(userVo!=null && userVo.getId()==null){
			if(userVo!=null && userVo.getAccountId()!=null){
				Account account=accountService.findById(userVo.getAccountId());
				if(account!=null){
					User user=new User();
					user.setAccountId(userVo.getAccountId());
					user.setAddress(userVo.getAddress().trim());
					user.setAge(Long.parseLong(userVo.getAge().trim()));
					user.setIDcard(userVo.getIDcard().trim());
					user.setName(userVo.getName().trim());
					user.setSex(Long.parseLong(userVo.getSex().trim()));
					user.setTelphone(userVo.getTelphone().trim());
					userService.saveOrUpdateUser(user);
					result.setMessage("OK!success!");
				}else{
					result.setResult(Boolean.FALSE);
					result.setMessage("failure!");
				}
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("failure!");
			}
		}else {
			result.setResult(Boolean.FALSE);
			result.setMessage("failure!");
		}
		return result;
	}
	
	@RequestMapping("/userlist")
	public String userSearchList(PagingVO pagingVo,UserVo userVo,Model model, HttpServletRequest request){
		PagingVO vo =userService.searchList(pagingVo,userVo);
		model.addAttribute("pageVO", vo);
		return "view/background/account/userlist";
	}
}
