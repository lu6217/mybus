package com.lu.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.lu.controller.home.MenuUtil;
import com.lu.entity.account.Account;
import com.lu.entity.account.Account_User;
import com.lu.entity.account.User;
import com.lu.entity.vo.UserVo;
import com.lu.service.AccountService;
import com.lu.service.Account_UserService;
import com.lu.service.UserService;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/accountuser")
public class AccountUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Account_UserService account_UserService;
	
	@RequestMapping("/getusers")
	public String getUsersByaccountId(HttpServletRequest request,Model model){
		Account account = (Account)request.getSession().getAttribute("account");
		
		List<User> users=userService.getUserByAccountId(account.getId());
		model.addAttribute("users", users);
		model.addAttribute("account", account);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "view/background/user/accountuserlist";
	}
	
	@RequestMapping("/toadduser/{id}")
	public String toAddUser(@PathVariable("id")Long id, Model model,HttpServletRequest request){
		if(id!=0){
			model.addAttribute("accountId", id);
		}else{
			Account account = (Account)request.getSession().getAttribute("account");
			model.addAttribute("accountId", account.getId());
		}
		return "view/background/user/adduser";
	}
	
	/**
	 * save or update
	 * @param request
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/saveOrUpdateUser")
	@ResponseBody
	public ResultResponse addUser(HttpServletRequest request, UserVo userVo){
		ResultResponse result = new ResultResponse();
		 Account account = (Account)WebUtils.getSessionAttribute(request, "account");
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
				if(userService.checkIdCard(userVo.getIDcard().trim())){
					result.setResult(Boolean.FALSE);
					result.setMessage("failure! IdCard Exists" );
					return result;
				}
				if(account!=null){
					User user=new User();
					user.setAccountId(account.getId());
					user.setAddress(userVo.getAddress().trim());
					user.setAge(Long.parseLong(userVo.getAge().trim()));
					user.setIDcard(userVo.getIDcard().trim());
					user.setName(userVo.getName().trim());
					user.setSex(Long.parseLong(userVo.getSex().trim()));
					user.setTelphone(userVo.getTelphone().trim());
					userService.saveOrUpdateUser(user);
					
					user=userService.getUserByIdCard(userVo.getIDcard());
					//保存account_user
					if(userVo.getAccountId()!=0){
						Account_User account_User=new Account_User();
						account_User.setAccountId(userVo.getAccountId());
						account_User.setUserId(user.getId());
						account_UserService.saveOrUpdate(account_User);
					}
					result.setMessage("OK!success!");
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
	@RequestMapping("/get/{id}")
	public String getUser(@PathVariable("id")Long id, Model model){
		User user=userService.getUserById(id);
		model.addAttribute("user", user);
		return "view/background/user/adduser";
	}
	
	@RequestMapping("/getuserinfo/{id}")
	public String getUserInfo(@PathVariable("id")Long id, Model model){
		User user=userService.getUserById(id);
		model.addAttribute("user", user);
		return "view/background/user/userinfo";
	}
	

	@RequestMapping("/deluser")
	@ResponseBody
	public ResultResponse delUser(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		Long id=Long.parseLong(request.getParameter("id").trim());
		Long accountId=Long.parseLong(request.getParameter("accountId").trim());
		Account account = accountService.findById(accountId);
		User user=userService.getUserById(id);
		if(user!=null){
			userService.delUser(user,account);
			result.setMessage("OK! 删除成功!");
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("falure!");
		}
		return result;
	}
}
