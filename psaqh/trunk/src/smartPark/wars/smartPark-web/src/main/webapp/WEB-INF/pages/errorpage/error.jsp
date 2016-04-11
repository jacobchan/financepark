<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%>
<html>
	<head>
		<title>错误提示页面</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/giui.min.js"></script>
		<script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/page/url.js"></script>
		<link href="<%=request.getContextPath()%>/styles/css/base.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath()%>/styles/css/login.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="clearfix tc pt20 pb20">
            <img src="<%=request.getContextPath()%>/styles/images/404.png" border="0" />
        </div>
        <div class="login_foot w1200 tc">
		    <a href="javascript:;">关于我们</a><a href="javascript:;">园区服务平台</a><a href="javascript:;">客服中心</a>
		    <a href="javascript:;">运营合作方</a><a href="javascript:;">帮助中心</a>
		    <div class="tc caaa mt15 f12">&copy;2014-2015杭州富春硅谷投资有限公司  版权所以  浙  B14231237号</div>
		</div>
	</body>
</html>
