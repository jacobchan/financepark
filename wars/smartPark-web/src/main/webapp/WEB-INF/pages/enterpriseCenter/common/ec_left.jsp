<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业中心左侧</title>
		<script type="text/javascript"> 
			$(document).ready(function(){
				$("#more").click(function(){
					$("#more1").slideToggle("slow");
				});
			});
		</script>
	</head>
	<body>
		<aside class="sidebar-menu fixed">
			<div class="sidebar-menu-inner">
	        	<div class="sidebar-menu-bread"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_home.png"></span>企业管理中心</div>
	        	<ul class="sidebar-menu-mainul">
	                <li>
	                    <a id="more">企业资料 <span class="down-icon"><img src="<%=request.getContextPath()%>/styles/images/qiye/angle-down.png"></span></a>
	                    <ul class="sidebar-menu-mainul2" id="more1">
	                        <li class="active"><a href="/enterprise/info.html"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_xinxi.png"></span>企业信息</a></li>
	                        <li><a href="/enterprise/financing.html"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_rongzi.png"></span>融资信息</a></li>
	                        <li><a href="/enterprise/knowledge.html"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_zuanli.png"></span>专利/知识产权</a></li>
	                        <li><a href="/enterprise/legal.html"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_chuangshi.png"></span>企业创始人</a></li>
	                        <li><a href="/enterprise/media.html"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_baodao.png"></span>媒体报道</a></li>
	                    </ul>
	                </li>
	            	<li><a href="qytx.html">企业通讯录管理</a></li>
	                <li><a href="qyyqm.html">企业邀请码</a></li>
	                <li><a href="qydd.html">订单中心</a></li>
	                <li><a href="plxx.html">评论消息</a></li>
	            </ul>
	            <div class="sidebar-menu-return"><span><img src="<%=request.getContextPath()%>/styles/images/qiye/icon_return.png"></span>返回个人中心</div>
	        </div>
		</aside>
	</body>
</html>