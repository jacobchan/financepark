package com.common.MemberManager.security;

import com.gsoft.framework.security.DefaultFormAuthenticationFilter;
import com.gsoft.framework.util.StringUtils;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class MemberFormAuthenticationFilter extends DefaultFormAuthenticationFilter {
	protected boolean isLoginRequest(ServletRequest request, ServletResponse response)
	  {
	    return pathsMatch("/member/*/login.html", request);
	  }

	  protected void redirectToLogin(ServletRequest request, ServletResponse response)
	    throws IOException
	  {
	    String uri = ((HttpServletRequest)request).getRequestURI();
	    PathMatcher pathMatcher = new AntPathMatcher();
	    Map params = pathMatcher.extractUriTemplateVariables("/{context}/member/{loginType}/**", uri);

	    String loginType = (String)params.get("loginType");

	    if (StringUtils.isNotEmpty(loginType))
	    {
	      WebUtils.issueRedirect(request, response, "/member/login.html");
	    }
	    else super.redirectToLogin(request, response);
	  }
}
