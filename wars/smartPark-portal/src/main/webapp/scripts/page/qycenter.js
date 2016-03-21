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
$(function(){
	var _passportBaseUrl = 'http://220.249.113.12:8088/';
	
	$('#youi_page_header').load($.youi.serverConfig.contextPath+'/common/qy_head.html');
	$('#youi_page_left').load($.youi.serverConfig.contextPath+'/common/qy_left.html');
});