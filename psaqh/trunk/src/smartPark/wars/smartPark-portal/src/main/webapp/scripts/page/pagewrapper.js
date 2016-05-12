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
	var pageType =$('#youi_page_header').attr('dataType');
	var pageId =$('#youi_page_header').attr('dataId');
	$('#youi_page_header').load($.youi.serverConfig.contextPath+'/common/header.html',function(){
		$('.index-head-nav li:eq('+pageType+')').addClass('active').find('dd:eq('+pageId+')').addClass('active');
		$.getScript(cenUrl+'portal/userInfo.html',function(){
			var loc = encodeURIComponent(window.location.href);
			if($.youi.serverConfig.authorization){
				isLogin = true;
				//console.log('user authorization = '+$.youi.serverConfig.authorization);
				$('#user_info:first').append('<a href="'+cenUrl+'portal/logout.html?redirect='+loc+'">退出</a>');
			}else{
				$('#user_info:first a:first').attr('href',cenUrl+'member/memberCenter/login.html?redirect='+loc);
				$('#user_info a').eq(1).attr('href',cenUrl+'member/memberCenter/login.html?redirect='+loc+'&type=regist');
				isLogin = false;
			}
		});	
	});
		
	$('#youi_page_ri').load($.youi.serverConfig.contextPath+'/common/list_right.html');
	$('#youi_page_rg').load($.youi.serverConfig.contextPath+'/common/news_yqfw.html');
	$('#youi_page_rgt').load($.youi.serverConfig.contextPath+'/common/news_right.html');
	$('#youi_page_footer').load($.youi.serverConfig.contextPath+'/common/footer.html');
	$('#youi_page_czh').load($.youi.serverConfig.contextPath+'/common/czh_right.html');
});