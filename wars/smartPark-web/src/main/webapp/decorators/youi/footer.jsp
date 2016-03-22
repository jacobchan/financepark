<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="youi-page-footer well bottom">
	<div style="padding-top:3px">
		<span id="footer_user_login_info"  style="padding-left:10px;">
			<shiro:authenticated>
			登录信息:<shiro:principal></shiro:principal>
			</shiro:authenticated>
			
		</span>
		<span id="footer_user_login_info"  style="font-family:Helvetica, Tahoma, Arial, sans-serif;font-weight:bold;float:right;padding-right:10px;">
			&copy; 2010-2015   版权所有。
		</span>
	</div>
</div>
