<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业码</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
		<script type="text/javascript">
			$(document).ready(function() {
			  	$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#rzId").val(result.record.companyId);
							$.ajax({
								url:baseUrl+'/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
								data : ['rzId='+result.record.companyId].join('&'),
								success : function(result) {
					    			if (result && result.record) {
					    				var record = result.record;
					    				var rzsign = record.rzSign==null?"":record.rzSign;
					    				$("#codeDiv").empty();
					    				var codeStr = '<div class="yqm_left">'+
							                    '<span class="yqm_01">企业邀请码：<font id="rzSign">'+rzsign+'</font></span>'+
							                    '<span class="yam_02">（特别说明：为安全起见，可自行刷新更换邀请码刷新后，之前的邀请码将即刻失效。）</span>'+
							                '</div>'+
							                '<div class="yqm_right">'+
							                    '<a href="javascript:sendCode();" class="a-b a-b-fill mb15">发送邀请码</a>'+
							                    '<a href="javascript:updateCode(\''+record.rzId+'\');" class="a-b a-b-fill">更新邀请码</a>'+
							                '</div>';
										$("#codeDiv").append(codeStr);
									}
								}
							});
						}
					}
				});
			  	$(".tc-close").click(function(){
					$(".bg-tanc").hide();
				});
			  	$(".ib-btn").click(function(){
					var phoneArr = $("#enterprisePhone").val();
					var code = $("#rzSign").html();
					var phone = phoneArr.split(",");
					var regPhone = /^1[3|5|8][0-9]\d{4,8}$/;
					for(var i=0; i<phone.length; i++){
						if (!regPhone.test(phone[i])) { 
							alert("手机号码不正确！");
							return false;
						}else{
							$.youi.ajaxUtils.ajax({
	    						url:baseUrl+'/enterpriseInvitationManager/saveEnterpriseInvitation.json',
	    						data:['enterbusinessmanagerRz.rzId='+$("#rzId").val(), 'invitationCode='+code, 'invitationTelephone='+phone[i]].join('&'),
	    						success:function(result){
	    							if(result && result.record){
	    								return true;
	    							}
	    						}
	    					});
						}
					}
					$.ajax({
						url:baseUrl+'/informationFinancingManager/sendEnterpriseCode.json',
						data : ['mobile='+phoneArr, 'code='+code].join('&'),
						success : function(result) {
			    			if (result && result.record) {
			    				var msg = result.record.html.split(",");
			    				if(msg[1].substring(0,1)==0){
			    					alert("手机号码："+phoneArr+"\n\n发送时间："+msg[0].substring(0,4)+"年"+msg[0].substring(4,6)+"月"+msg[0].substring(6,8)+"日 "+msg[0].substring(8,10)+":"+msg[0].substring(10,12)+":"+msg[0].substring(12,14)+"\n\n发送状态：成功！");
			    				}
			    			}
						}
					});
				});
			  	/* $("#moreul").slideUp("slow"); */
			  	$(".sidebar-menu-mainul > li:eq(2)").addClass("active");
			  	
			  	//获取邀请记录
			  	$.ajax({
					url:baseUrl+'/enterpriseInvitationManager/getPagerEnterpriseInvitations.json',
					data : ['rzId='+$("#rzId").val()].join('&'),
					success : function(result) {
		    			if (result && result.records) {
		    				var record = result.records;
		    				$("#invication").empty();
		    				var codeStr = '<tr class="th"><td>邀请码</td><td>手机号码</td><td>邀请状态</td><td>邀请时间</td><td>操作</td></tr>';
		    				for(var i=0; i<record.length; i++){
		    					codeStr+='<tr>'+
			                        '<td>'+record[i].invitationCode+'</td>'+
			                        '<td>'+record[i].invitationTelephone+'</td>'+
			                        '<td>已邀请</td>'+
			                        '<td>'+record[i].createTime+'</td>'+
			                        '<td><a href="javascript:;">取消邀请</a><span></span><a href="javascript:;">重新邀请</a></td>'+
			                    '</tr>';
		    				}
		    				$("#invication").append(codeStr);
						}
					}
				});
			});
			function updateCode(rzId){
				$.ajax({
					url:baseUrl+'/enterbusinessmanagerRzManager/updateEnteringSign.json',
					data : ['rzId='+rzId].join('&'),
					success : function(result) {
						$("#rzSign").html(result.record.rzSign);
					}
				});
			}
			function sendCode(){
				$(".bg-tanc").show();
			}
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
		    		<input id="rzId" name="rzId" type="text" style="display:none;" />
		        	<div class="main-title"><span>企业邀请码</span></div>
		            <div id="codeDiv" class="qy_yqm"></div>
		        </div>
		        <div class="yam_tab">
		            <table>
		                <tbody id="invication"></tbody>
		            </table>
		            <div class="fr page-list-a clearfix lh30 mt20 f12">
		                <span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
		                <a href="">首</a>
		                <a href=""><i class="fa fa-angle-left"></i></a>
		                <a>1</a>
		                <a href=""><i class="fa fa-angle-right"></i></a>
		                <a href="">末</a>
		                <input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
		                <a href="">Go</a>
		            </div>
		        </div>
		    </div>
		</div>
		<div class="bg-tanc">
			<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
				<a href="javascript:;" class="tc-close"></a>
				<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>发送邀请码</b></h3>
				<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
					<colgroup>
						<col width="110">
						<col>
					</colgroup>
					<tbody>
						<tr class="show2">
							<td><b>手机号码</b></td>
							<td><input style="width:400px" type="text" id="enterprisePhone" name="enterprisePhone"></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2"><a href="javascript:;" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">发送</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>