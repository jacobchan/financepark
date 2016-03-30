package com.gsoft.framework.security.filter;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.security.DefaultFormAuthenticationFilter;
import com.gsoft.framework.security.EsbSecurityManager;
import com.gsoft.framework.util.PojoMapper;
import com.gsoft.framework.util.StringUtils;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class MemberFormAuthenticationFilter extends DefaultFormAuthenticationFilter {
	
	@Autowired
	private EsbSecurityManager esbSecurityManager;
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
		
	protected boolean isLoginRequest(ServletRequest request, ServletResponse response){
	    return pathsMatch("/member/*/login.html", request);
	}

	@SuppressWarnings("rawtypes")
	protected void redirectToLogin(ServletRequest request, ServletResponse response)
	    throws IOException{
	    String uri = ((HttpServletRequest)request).getRequestURI();
	    PathMatcher pathMatcher = new AntPathMatcher();
	    Map params = pathMatcher.extractUriTemplateVariables("/{context}/member/{loginType}/**", uri);
	    String loginType = (String)params.get("loginType");
	    if (StringUtils.isNotEmpty(loginType)){
	      WebUtils.issueRedirect(request, response, "/member/login.html");
	    }
	    else super.redirectToLogin(request, response);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
			throws Exception{
	    String isJson = request.getParameter("json");
	    if(Boolean.valueOf(isJson).booleanValue()){
	      Map params = new HashMap();
	      params.put("principal", token.getPrincipal());
	      params.put("username", getUsername(request));
	      MemberInformation mem = (MemberInformation) subject.getPrincipal();
	      params.put("memberInfoMation", mem);
	      params.put("companyId", mem.getCompanyId());
	      if(mem.getCompanyId() == null){
	    	  params.put("companyName", "");
		      params.put("companyAdr", ""); 
	      }else{
	    	  EnterbusinessmanagerRz rz = enterbusinessmanagerRzManager.getEnterbusinessmanagerRz(mem.getCompanyId());
		      params.put("companyName", rz.getRzName());
		      params.put("companyAdr", rz.getRoomId().getRoomAddress()); 
	      }
	     
	      params.put("authorization", this.esbSecurityManager.encryptSecurityInfo(null));
	      Map results = new HashMap();
	      response.setContentType("application/json;charset=UTF-8");
	      results.put("record", params);
	      results.put("message", new Message("000000", "登录成功"));
	      try{
	        response.getOutputStream().write(PojoMapper.toJson(results, false).getBytes("UTF-8"));
	        return false;
	      }catch (IOException ioe) {
	        ioe.printStackTrace();
	      }
	    }
	    return super.onLoginSuccess(token, subject, request, response);
	}
}
