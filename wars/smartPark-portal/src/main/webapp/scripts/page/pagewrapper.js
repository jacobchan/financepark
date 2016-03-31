/*!
 * giui JavaScript Library v3.0.0
 * 
 *
 * Copyright 2016-2020, zhyi_12
 * Dual licensed under the MIT or GPL Version 2 licenses.
 *
 * Date: 2016-2-16
 */
var isLogin = false;
var baseUrl = "http://192.168.10.58:8088/esb/web/";
var cenUrl = 'http://192.168.10.58:8088/';
//var baseUrl = "http://localhost:8088/smartPark-web/esb/web/";
//var cenUrl = 'http://localhost:8088/smartPark-web/';
$(function(){
//	var _passportBaseUrl = 'http://localhost:8088/smartPark-web/';
	console.log($.youi.serverConfig.contextPath);
	$('#youi_page_header').load($.youi.serverConfig.contextPath+'/common/header.html',function(){
		$.getScript(cenUrl+'portal/userInfo.html',function(){
			var loc = encodeURIComponent(window.location.href);
			if($.youi.serverConfig.authorization){
				isLogin = true;
				console.log('user authorization = '+$.youi.serverConfig.authorization);
				$('#user_info:first').append('<a href="'+cenUrl+'portal/logout.html?redirect='+loc+'">退出</a>');
			}else{
				$('#user_info:first a:first').attr('href',cenUrl+'member/memberCenter/login.html?redirect='+loc);
				$('#user_info a').eq(1).attr('href',cenUrl+'member/memberCenter/login.html?redirect='+loc+'&type=regist');
				isLogin = false;
			}
		});
	});
	$('#youi_page_right').load($.youi.serverConfig.contextPath+'/common/list_right.html');
	$('#youi_page_footer').load($.youi.serverConfig.contextPath+'/common/footer.html');
});