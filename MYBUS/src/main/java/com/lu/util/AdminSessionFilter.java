package com.lu.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.lu.controller.home.MenuUtil;

@Controller
public class AdminSessionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String uriPath = request.getContextPath()+"/luwei/account/logon/";
		String uriPath2=request.getContextPath()+"/luwei/front/";
		String uri = request.getRequestURI();
//		Account account = (Account)WebUtils.getSessionAttribute(request, "account");
		//还要通过用户的类型进行判断用户是否可以访问某一个页面  
//		Object accountObj = WebUtils.getSessionAttribute(request, "account");
		Object accountObj = request.getSession().getAttribute("account");
		if(accountObj==null){
			List<String> urisList=new ArrayList<String>();
			urisList.add(uriPath);
			urisList.add(uriPath2);
			if(uri.contains(uriPath) || uri.contains(uriPath2)){
				chain.doFilter(arg0, arg1);
			}else{
				response.sendRedirect(request.getContextPath() + "/luwei/account/logon/tologin");
			}
		}else if(accountObj!=null){
			if(uri.contains(uriPath)){
				request.getSession().removeAttribute("account");
			}
			
			if(!MenuUtil.isPermission(request, response, uri)){
				request.setAttribute("message", "对不起，您没有权限，请联系管理员！！！");
	            request.getRequestDispatcher("/view/message.jsp").forward(request, response);
			}
			
			
			chain.doFilter(arg0, arg1);
		} 
		
//		if (accountObj != null|| uriPath.contains(uri)) {
//			chain.doFilter(arg0, arg1);
//		} else {
//			response.sendRedirect(request.getContextPath() + "/admin");
//		}
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
