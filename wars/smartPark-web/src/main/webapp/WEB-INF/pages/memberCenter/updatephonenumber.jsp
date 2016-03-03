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
					<h3 class="per-h3">修改号码</h3>
					<table class="setting-table grst-table">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr style="display:none;">
							<td>ID</td>
							<td><span class="" id="memberId"> </span></td>
						</tr>
						
						
						
						
						
						<tr>
							<td>号码</td>
							<td>
								<input type="text" id="memberPhoneNumber">
								<a href="javascript:;" class="ml15 open-tanc"><i class="fa fa-plus-circle mr5"></i>发送验证码</a>
							</td>
						</tr>
						 <tr>
							<td>验证码</td>
							<td>
								<input type="text" id="aaaaa">
								
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
				url:'/smartPark-web/esb/web/memberInformationManager/getMemberInformationByLoginUser.json',
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
			var memberId=$("#memberId").html();			
			var memberPhoneNumber=$("#memberPhoneNumber").val();
			$.youi.ajaxUtils.ajax({
				url:'/smartPark-web/esb/web/memberInformationManager/saveMemberInformation.json',
				data:'memberId='+memberId+'memberPhoneNumber='+memberPhoneNumber,
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