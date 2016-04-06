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
var proUrl = 'http://192.168.10.58:9088/';
$(function(){
	var _passportBaseUrl = cenUrl;
	
	$('#youi_page_header').load($.youi.serverConfig.contextPath+'/common/qy_head.html');
	$('#youi_page_left').load($.youi.serverConfig.contextPath+'/common/qy_left.html');
});