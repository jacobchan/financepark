package com.gsoft.framework.security.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.security.DefaultFormAuthenticationFilter;
import com.gsoft.framework.security.VerificationCodeException;
import com.gsoft.framework.util.PojoMapper;


public class LoginFormAuthenticationFilter extends DefaultFormAuthenticationFilter {
		

	  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response)
	  {
	    String isJson = request.getParameter("json");

	    if (Boolean.valueOf(isJson).booleanValue()) {
	      setFailureAttribute(request, e);
	      Map results = new HashMap();

	      Object error = request.getAttribute("error");
	      results.put("message", new Message("999999", error == null ? "登录失败" : error.toString()));
	      try
	      {
	        response.getOutputStream().write(PojoMapper.toJson(results, false).getBytes("UTF-8"));
	        return false;
	      }
	      catch (IOException localIOException) {
	      }
	    }
	    return super.onLoginFailure(token, e, request, response);
	  }

		  protected void setFailureAttribute(ServletRequest request, AuthenticationException ae)
		  {
		    super.setFailureAttribute(request, ae);

		    String username = getUsername(request);
		    String message;
		    if ((ae instanceof IncorrectCredentialsException)) {
		      message = "密码不正确！";
		    }else if ((ae instanceof CredentialsException)) {
		        message = ae.getMessage();
		    }else if ((ae instanceof UnknownAccountException)) {
		          message = "帐号[" + username + "]不存在！";
		    }else if (ae instanceof VerificationCodeException) {
				message = "验证码错误！";
			}else{
		            message = ae.getMessage(); 
		    }
		    request.setAttribute("error", message);
		  }

	
	
}
