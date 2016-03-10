<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人资料</title>
	
</head>
<body style="background-color:#f4f4f4;">


	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
			<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 

		
				<div class="w1000">
					<h3 class="per-h3">基本资料</h3>
					<table class="setting-table grst-table">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr style="display:none;">
							<td>ID</td>
							<td><span class="" id="memberId"> </span></td>
						</tr>
						
					
						<tr >
							<td>手机号码</td>
							<td>
							  <input type='text' id="memberPhoneNumber" />							  
							</td>
						</tr>						
						<tr >
							<td>
							新手机号码
							
							
							</td>
							<td>
							  <input type='text' id="newmemberPhoneNumber" />	
							  <a href="javascript:;" class="ml15 open-tanc" style="padding:0px 25px;">获取验证码</a>						  
							</td>
						</tr>
						<tr >
							<td>验证码</td>
							<td>
							  <input type='text' id="aaa" />							  
							</td>
						</tr>
						
						<tr>
							<td colspan="2">
								<input type="submit" value="修改" class="hhf-submit" style="height:36px;" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--***bottom end****************************************-->
	<script type="text/javascript">
	
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/memberInformationManager/getMemberInformation.json',
				//async: false, 
				success:function(result){
					if(result&&result.record){
						_parseRecords(result.record);
					}
				}
			});
		});				
		function _parseRecords(record){
			$("#memberId").html(record.memberId);									
			$("#memberPhoneNumber").val(record.memberPhoneNumber);			
		};					 
		$('.hhf-submit').click(function(){
			this.disabled=true;
			if (window.confirm("您确定要修改吗?")) {
				return true;
				}else{
				return false;
				}
			var memberId=$("#memberId").html();			
			var memberPhoneNumber=$("#newmemberPhoneNumber").val();			
			var params = ['memberId='+memberId+'','memberPhoneNumber='+memberPhoneNumber+''];
			$.youi.ajaxUtils.ajax({
				url:'/smartPark-web/esb/web/memberInformationManager/updatePhone.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						alert("修改成功");
						location.reload();
					}
				}
			});
		});	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>