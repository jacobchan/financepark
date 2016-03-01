package com.gsoft.framework.core.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsoft.framework.util.SecurityUtils;


@Controller
@RequestMapping("/memberCenter")
public class MemberCenterController {
	
	
	@RequestMapping("/{pagePath}.html")
	public ModelAndView index(HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("pagePath") String pagePath){
		String userName=SecurityUtils.getAccount().getLoginName();
		request.setAttribute("user", userName);
		
		return new ModelAndView("memberCenter/"+pagePath);
	}
	
	/**
	 * 退出登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout.html")
	public ModelAndView logout(
    		HttpServletRequest request,
    		HttpServletResponse response){
		//退出系统
		org.apache.shiro.SecurityUtils.getSubject().logout();
		
		try {
			WebUtils.issueRedirect(request, response, "/login.html");
		} catch (IOException e) {
//			e.printStackTrace();
		}
		return null;
	}
}