mypath
<br/>
<%@page import="org.springframework.core.io.Resource"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.util.WebUtils"%>
<%
	 ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());

	Resource resource = appContext.getResource("classpath:/");
	
	
	out.println(resource.getFile().getAbsolutePath());
	
%>