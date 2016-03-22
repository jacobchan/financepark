<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<youi:script src="/decorators/youi/layout.js"></youi:script>
<youi:script src="/decorators/youi/menu.js"></youi:script>

<youi:style href="/decorators/youi/layout.css"></youi:style>
<youi:style href="/decorators/youi/menu.css"></youi:style>

<div class="col-sm-12">
	<div class="pull-left sys-logo"></div>
	<div class="pull-left sys-title"><h3>
	<shiro:hasRole name="ROLE_FLOW">集联易捷流程管理平台</shiro:hasRole>
	<shiro:hasRole name="ROLE_RPT">集联易捷报表管理平台</shiro:hasRole>
	<shiro:hasRole name="ROLE_PLT">集联易捷代码管理平台</shiro:hasRole>
	</h3></div>
	
	<ul id="main-menu" class="nav navbar-nav navbar-right">
		<li class="dropdown hidden-xs">
			<a href="#" title="" class="dropdown-toggle" data-toggle="dropdown"> 
				<span class="glyphicon glyphicon-user padding-right-small"></span>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu">
				<li><a href="./">账户信息</a></li>
				<li><a href="./">修改密码</a></li>
			</ul>
		</li>
		
		<li>
			<a tabindex="-1" href="logout.html"  title="退出系统" >
				<span class="glyphicon glyphicon-off padding-right-small"></span>
			</a>
		</li>
	</ul>
</div>
