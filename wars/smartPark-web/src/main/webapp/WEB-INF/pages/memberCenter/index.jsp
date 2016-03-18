<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人资料</title>
	<script type="text/javascript">
		$(function () {
			$("a.c-o").on("click",function(){
				$(this).parent("p").hide().siblings("p").show();
			});
			$(".open-tanc").click(function(){
				$(".bg-tanc").show();
			});
			$("#birthday_container").birthday();
		})
	</script>	
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
						<tr>
							<td>头像</td>
							<td>
								<img src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png" border="0" class="fl" width="107" height="107"/>
								<div class="photo-edit"><input type="file" />编辑<br/>头像</div>
							</td>
						</tr>
						<tr>
							<td>账号</td>
							<td><span class="c-b1">8578778888 </span><span class="c-o"><a href="personalCenter/securityCenter.html">[更换手机号码]</a></span></td>
						</tr>
						<tr>
							<td>昵称</td>
							<td><input type="text" id="memberNickname"></td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td><input type="text" id="memberName"></td>
						</tr>
						<tr>
							<td>出生日期</td>
							<td>
								<div id="birthday_container">
									<select name="year" id="year"></select>
									<select name="month" id="month"></select>
									<select name="day" id="day"></select>
								</div>
							</td>
						</tr>
						<tr>
							<td>一句话介绍</td>
							<td><textarea style="height:60px;" id="memberDescribe2"></textarea></td>
						</tr>
						<tr>
							<td>公司</td>
							<td>
								<input type="text" id="companyId">
								<a href="javascript:;" class="ml15 open-tanc"><i class="fa fa-plus-circle mr5"></i>加入企业</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="保存" class="hhf-submit" style="height:36px;" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--***bottom end****************************************-->
		<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>加入园区</b></h3>
			<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
				<colgroup>
					<col width="110">
					<col>
				</colgroup>
				<tbody>
				<tr class="show2">
					<td><b>企业邀请码</b></td>
					<td><input style="width:400px" type="text" id="companyInvitecode"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">加入企业</a></td>
				</tr>
			</tbody></table>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:baseUrl+'/esb/web/memberInformationManager/getMemberInformationByLoginUser.json',
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
			$(".c-b1").html(record.memberPhoneNumber);
			$("#memberNickname").val(record.memberNickname);
			$("#memberName").val(record.memberName);
			$("#year").val(record.memberBirthdate.substring(0,4));
			$("#month").val(record.memberBirthdate.substring(5,7));
			$("#day").val(record.memberBirthdate.substring(8,10));
			$("#memberDescribe2").val(record.memberDescribe2);
			$("#companyId").val(record.companyId);
		};
		
		$('.hhf-submit').click(function(){
			this.disabled=true;
			var memberId=$("#memberId").html();
			var memberNickname=$("#memberNickname").val();
			var memberPhoneNumber=$(".c-b1").html();
			var memberName=$("#memberName").val();
			var year=$("#year").val();
			var month=$("#month").val();
			var day=$("#day").val();
			var memberBirthdate=year+"-"+month+"-"+day;
			var memberDescribe2=$("#memberDescribe2").val();
			var companyId=$("#companyId").val();
			var params = ['memberId='+memberId+'','memberNickname='+memberNickname+'','memberPhoneNumber='+memberPhoneNumber+'','memberName='+memberName+'','memberBirthdate='+memberBirthdate+'','memberDescribe2='+memberDescribe2+'','companyId='+companyId+''];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'/esb/web/memberInformationManager/saveMemberInformation.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						alert("修改成功");
						location.reload();
					}
				}
			});
		});	
		
		$('.ib-btn').click(function(){
			this.disabled=true;
			var memberId=$("#memberId").html();
			var companyInvitecode=$("#companyInvitecode").val();
			var params = ['memberId='+memberId+'','companyInvitecode='+companyInvitecode+''];
			alert("加入企业！");
		});	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>