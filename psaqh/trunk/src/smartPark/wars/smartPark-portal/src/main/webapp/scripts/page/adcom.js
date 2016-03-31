/*!
 * giui JavaScript Library v3.0.0
 * 
 *
 * Copyright 2016-2020, zhyi_12
 * Dual licensed under the MIT or GPL Version 2 licenses.
 *
 * Date: 2016-2-16
 */
$(function(){
	var _passportBaseUrl = 'http://220.249.113.12:8088/';
	
	$('#youi_page_header').load($.youi.serverConfig.contextPath+'/common/ad_head.html',function(){
		$.getScript(_passportBaseUrl+'portal/userInfo.html',function(){
			var loc = encodeURIComponent(window.location.href);
			if($.youi.serverConfig.authorization){
				console.log('user authorization = '+$.youi.serverConfig.authorization);
				$('#user_info:first').append('<a href="'+_passportBaseUrl+'portal/logout.html?redirect='+loc+'">退出</a>');
			}else{
				$('#user_info:first a:first').attr('href',_passportBaseUrl+'member/portal/login.html?redirect='+loc);
			}
		});
	});
	$('#youi_page_left').load($.youi.serverConfig.contextPath+'/common/ad_left.html');
	$('#youi_page_footer').load($.youi.serverConfig.contextPath+'/common/ad_foot.html');
});