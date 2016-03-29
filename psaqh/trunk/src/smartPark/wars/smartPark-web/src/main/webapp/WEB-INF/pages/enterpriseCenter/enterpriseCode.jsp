<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业码</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript">
			$(document).ready(function() {
				var height = Math.max((document.documentElement.clientHeight -135), ($(".main-wrapper").height()));
				document.getElementById('main-wrapper-right').style.height=height+'px';
			  	$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#financingRe").html(result.record.companyId);
							$.ajax({
								url:baseUrl+'/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json',
								success : function(results) {
					    			if (results && results.records) {
					    				var records = results.records;
					    				$("#codeDiv").empty();
					    				for(var i=0; i<records.length; i++){
											var codeStr = '<li>'+
						                    	'<table>'+
						                        	'<tr>'+
						                            	'<td colspan="2"><p style=" width:100%; max-height:16px; overflow:hidden;display:inline-block;line-height:16px;text-overflow:ellipsis;white-space:nowrap;">企业全称：'+records[i].rzName+'</p></td>'+
						                            '</tr>'+
						                            '<tr>'+
						                            	'<td colspan="2">企业邀请码：<span class="color_orange">'+records[i].rzSign+'</span></td>'+
						                            '</tr>'+
						                            '<tr>'+
						                            	'<td><a href="javascript:updateCode(\''+records[i].rzId+'\');" class="yqm_btn">更新邀请码</a></td>'+
						                                '<td><a href="javascript:void(0);" class="yqm_btn">发送邀请码</a></td>'+
						                            '</tr>'+
						                        '</table>'+ 
						                    '</li>';
											$("#codeDiv").append(codeStr);
										}
									}
								}
							});
						}
					}
				});
			});
		</script>
	</head>
	<body class="page-header-fixed" style="background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
		    <div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right" id="main-wrapper-right">
		        	<div class="main-title"><span>企业邀请码</span></div>
		            <div class="qy_yqm">
		            	<ul id="codeDiv">
		                </ul>
		            </div>
		        </div>   
		    </div>
		</div>
	</body>
</html>