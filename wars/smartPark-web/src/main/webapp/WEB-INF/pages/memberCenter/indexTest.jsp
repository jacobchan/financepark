<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<%@ include file="/WEB-INF/pages/common/giuiScriptAndCss.jsp"%>
<youi:html i18n="i18n.index" title="个人中心">
<head>
	<meta charset="UTF-8">
	<title>个人资料</title>
	
</head>
	
	<youi:body decorator="giui">


	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">

		
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
							<td><span class="c-b1">8578778888 </span><span class="c-o"><a href="updatephonenumber.html">[更换手机号码]</a></span></td>
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
							<td><input type="text" id="memberBirthdate"></td>
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
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/memberInformationManager/getMap.json',
				//async: false, 
				success:function(result){
					console.log(result);
					if(result&&result.record){
						
					}
				}
			});
		});
		
	
	</script>
</youi:body>
</youi:html>