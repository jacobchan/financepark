/**
 * 
 */
package com.gsoft.framework.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.security.UserService;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.framework.util.StringUtils;

/**
 * 会员页面控制器
 * @author zhyi_12
 */

@Controller
@RequestMapping("/member")
public class MemberPageController {
	
	@Autowired
	private UserService userService;//用户服务
	
	@RequestMapping(value = "/{pageModule}/{pagePath}.html")
	public ModelAndView index(HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pagePath") String pagePath){
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pagePath}, "/"),null);
	}
	
	@RequestMapping(value = "/{pageModule}/{pageFile}/{pagePath}.html")
	public ModelAndView index(HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pageFile") String pageFile,
			@PathVariable("pagePath") String pagePath){
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pageFile,pagePath}, "/"),null);
	}
	
/*	//@PathVariable("subfolder") String subfolder
	@RequestMapping(value = "/{pageModule}/{pagePath}/{loginName}.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pagePath") String pagePath,
			@PathVariable("loginName") String loginName){
		
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pagePath}, "/"),loginName);
	}
	
	@RequestMapping(value = "/{pageModule}/{pagePath}/{subPath}/{loginName}.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("pageModule") String pageModule,
			@PathVariable("pagePath") String pagePath,
			@PathVariable("subPath") String subPath,
			@PathVariable("loginName") String loginName){
		
		return buildModelAndView(request,pageModule,StringUtils.arrayToDelimitedString(new String[]{pageModule,pagePath,subPath}, "/"),loginName);
	}
*/	
	private ModelAndView buildModelAndView(HttpServletRequest request,String pageModule,String pagePath,String loginName){
		AccountPrincipal account = SecurityUtils.getAccount();
/*		if(account==null||!loginName.equals(account.getLoginName())){
			//输出权限错误异常
			throw new BusException("010101","权限不足!");
		}*/
		ModelAndView model = new ModelAndView();
		model.setViewName(/*pageModule+"/"+*/pagePath);
		model.addObject("user", account);
		model.addObject("pagePath", pagePath);
		return model;
	}

}
