package com.lu.controller.authority;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.controller.home.MenuUtil;
import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.entity.authority.Role_Menu;
import com.lu.entity.vo.MenuVo;
import com.lu.entity.vo.Role_MenuVo;
import com.lu.service.AuthorityService;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/authoritylist")
	public String authoritylist(PagingVO pagingVo,Model model, HttpServletRequest request){
//		Long accountId= ((Account)WebUtils.getSessionAttribute(request, "account")).getId();
		PagingVO vo =authorityService.searchList(pagingVo);
		model.addAttribute("pageVO", vo);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "/view/background/authority/authority";
	}
	
	@RequestMapping("/toaddrole")
	public String toAddRole(Model model, HttpServletRequest request){
		
		return "/view/background/authority/addrole";
	}
	
	@RequestMapping("/toaddmenu")
	public String toAddMenu(Model model, HttpServletRequest request){
		List<Menu> menus=authorityService.getMenus();
		model.addAttribute("menus", menus);
		return "/view/background/authority/addmenu";
	}
	
	@RequestMapping("/toeditmenu/{id}")
	public String toEditMenu(@PathVariable("id")Long id,Model model, HttpServletRequest request){
		
		Menu menu=authorityService.getMenuById(id);
		model.addAttribute("menu", menu);
		return "/view/background/authority/editmenu";
	}
	
	
	@RequestMapping("/toassignment/{id}")
	public String toAssignment(@PathVariable("id")Long id,Model model, HttpServletRequest request){
		Role role=authorityService.getRoleById(id);
		List<Menu> menus=authorityService.getMenus(id);
		model.addAttribute("menus", menus);
		model.addAttribute("role", role);
		return "/view/background/authority/assignmentmenu";
	}
	
	@RequestMapping("/toaddaccounttype")
	public String toAccountType(Model model, HttpServletRequest request){
		
		return "/view/background/authority/addAccountType";
	}
	
	@RequestMapping("/showmenus")
	public String showMeuns(Model model, HttpServletRequest request){
		
		List<Menu> menus=authorityService.getMenus();
		model.addAttribute("menus", menus);
		return "/view/background/authority/showmenus";
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
	public ResultResponse createRole(HttpServletRequest request,Role role){
		ResultResponse result = new ResultResponse();
		if(role!=null){
			if(!authorityService.checkName(role.getName())){
				authorityService.saveRole(role);
				result.setMessage("Create Success");
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("Failure! Name Exists");
			}
		}
		return result; 
	}
	
	@RequestMapping("/editmenu")
	@ResponseBody
	public ResultResponse editMenu(HttpServletRequest request,MenuVo menuVo){
		ResultResponse result = new ResultResponse();
		if(menuVo!=null){
			//如果父节点不是根节点就将父节点改为不是叶子节点
			if(menuVo.getId()!=null){
				Menu menu=authorityService.getMenuById(menuVo.getId());
				menu.setName(menuVo.getName());
				menu.setUrl(menuVo.getUrl());
				menu.setIcon(menuVo.getIcon());
				authorityService.updateMenu(menu);
				result.setMessage("Success");
				return result;
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("Failure!");
			}
		}else {
			result.setResult(Boolean.FALSE);
			result.setMessage("Failure!");
		}
		return result; 
	}
	
	@RequestMapping("/addmenu")
	@ResponseBody
	public ResultResponse createMenu(HttpServletRequest request,MenuVo menuVo){
		ResultResponse result = new ResultResponse();
		if(menuVo!=null){
			//如果父节点不是根节点就将父节点改为不是叶子节点
			if(menuVo.getUpperLevelMenuId()!=0){
				Menu pmenu=authorityService.getMenuById(menuVo.getUpperLevelMenuId());
				pmenu.setLeaf(Boolean.FALSE);
				authorityService.updateMenu(pmenu);
			}
			Menu menu=new Menu();
			menu.setName(menuVo.getName());
			menu.setIcon(menuVo.getIcon());
			menu.setLevel(Integer.parseInt(menuVo.getLevel()));
			menu.setLeaf(menuVo.getLeaf());
			menu.setUpperLevelMenuId(menuVo.getUpperLevelMenuId());
			menu.setUrl(menuVo.getUrl());
			menu.setItem(menuVo.getItem());
			authorityService.saveMenu(menu);
			result.setMessage("Create Success");
		}else {
			result.setResult(Boolean.FALSE);
			result.setMessage("Failure!");
		}
		return result; 
	}
	
	
	@RequestMapping("/getmenu")
	public String getMenu(Model model, HttpServletRequest request){
		Long roleId=Long.parseLong(request.getParameter("roleId").trim());
		//此功能还没有进行测试   
		List<Menu> menus=authorityService.getMenuByRoleId(roleId);
		model.addAttribute("roleId", roleId);
		model.addAttribute("menus",menus);
		return "/view/background/authority/menu_data";
	}
	
	
	@RequestMapping("/addrolemenu")
	@ResponseBody
	public ResultResponse addRoleMenu(HttpServletRequest request,Role_MenuVo role_MenuVo){
		ResultResponse result = new ResultResponse();
		if(role_MenuVo!=null && role_MenuVo.getMenulists().length>0){
			for (int i = 0; i < role_MenuVo.getMenulists().length; i++) {
				Role_Menu role_Menu=new Role_Menu();
				role_Menu.setMenuId(role_MenuVo.getMenulists()[i]);
				role_Menu.setRoleId(role_MenuVo.getRoleId());
				authorityService.saveRoleMenu(role_Menu);
				result.setMessage("Success");
			}
			
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("Failure!");
		}
		return result; 
	}
	
	@RequestMapping("/delrolemenu")
	@ResponseBody
	public ResultResponse delRoleMenu(HttpServletRequest request,Model model){
		ResultResponse result = new ResultResponse();
		Long roleId=Long.parseLong(request.getParameter("roleId").trim());
		Long menuId=Long.parseLong(request.getParameter("menuId").trim());
		if(roleId!=null && roleId!=null){
			if(authorityService.delRoleMenu(roleId,menuId)){
				result.setMessage("success!");
				return result;
			}
		}
		result.setResult(Boolean.FALSE);
		result.setMessage("failure!");
		return result; 
	}
	
}
