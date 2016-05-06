<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="安全中心">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">安全中心</h3>
			<h4 class="per-h4 mt20">密码安全</h4>
			<table class="setting-table mt20">
				<colgroup>
					<col width="100"></col>
					<col></col>
				</colgroup>
				<tr>
					<td>原密码</td>
					<td>
						<input type="password" style="width:200px;" class="w1" id="oldPassword"> 
						<span class="c-o ml20 " id="oldmsg"></span>
					</td>
				</tr>
				<tr>
					<td>新密码</td>
					<td>
						<input type="password" style="width:200px;" class="w1 clickpwd" id="password" >
						<span class="c-o ml20 " id="newmsg"></span>
					</td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td>
						<input type="password" style="width:200px;" class="w1" id="confirmPassword">
						<span class="c-o ml20 " id="conmsg"></span>
					</td>
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
				<!-- <tr>
					<td style="width:120px;">原手机号码</td>
					<td>
						<input type="text" id="oldmemberPhoneNumber" style="width:200px;" readonly="readonly"> 
					</td>
				</tr> -->
				<tr>
					<td style="width:120px;">新手机号码</td>
					<td>
						<input type="text" id="memberPhoneNumber" style="width:200px;" > 
						<input type="hidden" readonly="readonly" id="memberId">
						<a href="javascript:;" class="ml15 open-tanc" style="padding:0px 25px;" id="sendnewcaptcha"  onclick="getCaptcha();">获取验证码</a>
						<span class="c-o ml20 " id="phonetest"></span>
					</td>
				</tr>
				<tr>
					<td style="width:120px;">验证码</td>
					<td>
						<input type="text" style="width:200px;" id="newcaptcha"> 
						<span class="c-o ml20 " id="codetest"></span>
						
					</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="修改" class="hhf-submit changePhoneNumber" style="height:36px; margin-left:100px" />
						<span class="c-o ml20 " id="newmsg"></span>
					</td>			
				</tr>
			</table>
		</div>	
	<!--***弹窗 start****************************************-->
		<div class="toast">
       	 <div class="toast-con clearfix">
            	<div class="close-toast fr"></div>
            	<p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        	</div>        
    	</div>
	<!--***bottom end****************************************-->
	</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/securityCenter.js"></script>		
</youi:html>