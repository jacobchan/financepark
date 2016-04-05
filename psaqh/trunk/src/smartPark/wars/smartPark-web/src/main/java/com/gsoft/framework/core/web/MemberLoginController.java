/**
 * 
 */
package com.gsoft.framework.core.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.member.base.entity.IMember;
import com.gsoft.member.base.service.IMemberService;

/**
 * 会员登录控制器
 * @author zhyi_12
 *
 */
@Controller
@RequestMapping("/member")
public class MemberLoginController {

	@Autowired(required=false)
	private IMemberService memberService;//会员服务
	@Value("#{configProperties['proUrl']}")
	private String prourl;
	/**
	 * 会员登录页面跳转
	 * @param request
	 * @param response
	 * @param pageModule
	 * @return
	 */
	@RequestMapping(value = "/{loginType}/login.html")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("loginType") String loginType){
		
		//会员登录类型
		
		//支持手机号，登录名，邮箱登录
		
		//公众号管理登录，不开放注册
		//广告主登录,开放注册
		//捧客登录,开放注册
		//切换登录
		AccountPrincipal account = SecurityUtils.getAccount();
		
		if(account instanceof IMember){
			String currentLoginType = ((IMember)account).getLoginType();
			if(currentLoginType!=null&&!currentLoginType.equals(loginType)){
				//已经登录其他类型,切换登录
			}
			//重定向到首页
			return new ModelAndView("redirect:/member/"+loginType+"/index.html");
		}
		return new ModelAndView("/member/"+loginType+"/login");
	}
	
	@RequestMapping(value = "/{loginType}/logout.html")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("loginType") String loginType){
		//shiro退出
		org.apache.shiro.SecurityUtils.getSubject().logout();
		try {
			//WebUtils.issueRedirect(request, response, "/member/"+loginType+"/login.html");
			WebUtils.issueRedirect(request, response, prourl);
		} catch (IOException e) {
//			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/{loginType}/index.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("loginType") String loginType){
		ModelAndView model = new ModelAndView(loginType+"/index");
		
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("loginType", loginType);
		model.addObject("account", account.getPrincipalConfig());
		model.addObject("user", account);
		return model;
	}
	
}
