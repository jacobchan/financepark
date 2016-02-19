
<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String baseUrl = getServletContext().getContextPath();
%>

<youi:html>
	<head></head>
	<body>
		<form class="form-horizontal" id="regiestForm" method="post" action="<%= baseUrl %>/esb/web/memberInformationManager/saveReister.json">
	<div class="form-pane">
			<div class="control-group">
				<div>
					<div class="input-prepend">
					<span class="add-on" style="width:20px;"><i class="icon24 icon-person24"></i></span>
					<input type="text" required="required" pattern="^[a-zA-Z]{1}[a-zA-Z0-9]{5,31}$" name="userName" placeholder="请填写登录账号" class="unique" property="userNo"/>
					</div>
					<div class="help-inline">
						<span>用户名长度为6至32位，以字母与数字组成，</span>
						<br/>
						<span>且必须以字母开始，请尽量用字母数字组合。</span>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div>
					<div class="input-prepend">
					<span class="add-on" style="width:20px;" ><i class="icon24 icon-lock24"></i></span>
					<input type="password" required="required" pattern="^.{6,32}$"  name="passwd" placeholder="请填写登录密码" onkeyup="checklevel(this.value)" onchange="checklevel(this.value)" />
					</div>
					<div class="help-inline">请填写长度为6-32位的登录密码</div>
					<div>
						<div id="strength_L"></div>
						<div id="strength_M"></div>
						<div id="strength_H"></div>
					</div>
					<label id="st" style="position: absolute;color:#fff;"></label>
					
				</div>
			</div>
			
			<div class="control-group">
				<div>
					<div class="input-prepend">
					<span class="add-on" style="width:20px;"><i class="icon24 icon-lock24"></i></span>
					<input type="password" required="required" pattern="^.{6,32}$" name="repasswd" placeholder="请再次填写登录密码" oncopy="return false;" onpaste="return false;"/>
					</div>
					<span class="help-inline">请再次填写登录密码谨防输入了错误的密码</span>
				</div>
			</div>
			<div class="control-group">
				<div>
					<div class="input-prepend">
					<span class="add-on" style="width:20px;"><i class="icon24 icon-iphone24"></i></span>
					<input type="text" required="required" pattern="^\d{11,11}$" id="field_mobile" name="mobile" placeholder="请填写手机号码" />
					</div>
					<span class="help-inline">绑定手机号码</span>
				</div>
			</div>
			</div>
			<div class="buttons-group">
	            <button id="regSubmitButton" type="submit" class="yjs-img-btn btn-register"></button>
  	        </div>
		</form>
	</body>
</youi:html>