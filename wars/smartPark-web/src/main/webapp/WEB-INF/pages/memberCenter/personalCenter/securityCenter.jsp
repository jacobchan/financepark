<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>安全中心</title>
	
</head>
<body style="background-color:#f4f4f4;">


	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
			<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">基本资料</h3>
					<h4 class="per-h4 mt20">密码安全</h4>
					<table class="setting-table mt20">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr>
							<td>原密码</td>
							<td>
								<input type="password" style="width:200px;" id="oldPassword"> <span class="c-o ml20 undis">原始密码不正确！</span>
							</td>
						</tr>
						<tr>
							<td>新密码</td>
							<td><input type="password" style="width:200px;" id="password"></td>
						</tr>
						<tr>
							<td>确认密码</td>
							<td><input type="password" style="width:200px;" id="confirmPassword"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="修改" class="hhf-submit changePassword" style="height:36px;margin-left:100px" />
							</td>
						</tr>
					</table>
					<h3 class="per-h3">&nbsp;</h3>
					<h4 class="per-h4 mt20">更换手机号码</h4>
					<table class="setting-table mt20">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr>
							<td>新手机号码</td>
							<td>
								<input type="text" id="memberPhoneNumber" style="width:200px;"> <a href="javascript:;" class="ml15 open-tanc" style="padding:0px 25px;">获取验证码</a>
							</td>
						</tr>
						<tr>
							<td>验证码</td>
							<td><input type="text" style="width:200px;"> <span class="c-o ml20 undis">验证码不正确！</span></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="修改" class="hhf-submit changePhoneNumber" style="height:36px; margin-left:100px" />
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
			//修改密码
			$(".changePassword").click(function(){
				var oldPassword=$("#oldPassword").val();
				var password=$("#password").val();
				var confirmPassword=$("#confirmPassword").val();
				var params=['password='+password,'confirmPassword='+confirmPassword,'oldPassword='+oldPassword];
			 	$.youi.ajaxUtils.ajax({
					url:'/smartPark-web/esb/web/memberInformationManager/doModifyPassword.json',
					data:params.join('&'),
					success:function(result){
						alert("修改成功！");
						location.reload();
					},
					error:function(jqXHR, textStatus, errorThrown){
						alert(jqXHR);
					}
				});
			});
			
			//修改手机号
			$(".changePhoneNumber").click(function(){
				var memberPhoneNumber=$("#memberPhoneNumber").val();
				var params =['memberPhoneNumber='+memberPhoneNumber];
				$.youi.ajaxUtils.ajax({
					url:'/smartPark-web/esb/web/memberInformationManager/updatePhoneNumber.json',
					data:params.join('&'),
					success:function(result){
						alert("修改成功！");
						location.reload();
					},
					error:function(jqXHR, textStatus, errorThrown){
						alert(jqXHR);
					}
				});
				
			});	
		});	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>