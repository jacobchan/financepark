<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<youi:script src="/decorators/youi/layout.js"></youi:script>
<youi:script src="/decorators/youi/menu.js"></youi:script>

<youi:style href="/decorators/youi/layout.css"></youi:style>
<youi:style href="/decorators/youi/menu.css"></youi:style>
<script type="text/javascript" >
function changePwd(){
	$('#headerChangePwd_').form('open');
	
}
function viewMemberBase(){
	$.youi.ajaxUtil.ajax({
		url:'/esb/web/memberBaseManager/isRealName.json',
		data:{},
		success:function(result){
			if(null!=result.record){
				$('#headerMemberBase').form('fillRecord',result.record).form('open');
			}
		}
	});
}
</script>
<div class="col-sm-12">
	<div class="pull-left sys-logo"></div>
	<div class="pull-left sys-title"><h3>
	<shiro:hasRole name="ROLE_FLOW">集联易捷流程管理平台</shiro:hasRole>
	<shiro:hasRole name="ROLE_RPT">集联易捷报表管理平台</shiro:hasRole>
	<shiro:hasRole name="ROLE_PLT">集联易捷代码管理平台</shiro:hasRole>
	</h3></div>
	
	<ul id="main-menu" class="nav navbar-nav navbar-right">
		<li class="dropdown hidden-xs">
			<a href="#" title="" class="dropdown-toggle" data-toggle="dropdown"> 
				<span class="glyphicon glyphicon-user padding-right-small"></span>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu">
				<!-- <li><a href="#" onclick="viewMemberBase();">账户信息</a></li> -->
				<li><a href="#" onclick="changePwd();">修改密码</a></li>
			</ul>
		</li>
		
		<li>
			<a tabindex="-1" href="logout.html"  title="退出系统" >
				<span class="glyphicon glyphicon-off padding-right-small"></span>
			</a>
		</li>
	</ul>
</div>

<youi:form dialog="true" caption="修改密码" id="headerChangePwd_" idKeys="id" action="web/loginUser/modifyPassword.json" width="400" reset="NOT">
			<youi:fieldLayout prefix="record"  labelWidths="120,120" columns="1">
				<youi:fieldPassword property="oldPwd" caption="旧密码" notNull="true" />
				<youi:fieldPassword property="newPwd" caption="新密码"  notNull="true" />
				<youi:fieldPassword property="newPwdConfirm" caption="确认密码" notNull="true" />
			</youi:fieldLayout>
			<br/>
</youi:form>
<youi:form dialog="true" id="headerMemberBase" idKeys="id" action="" width="800" 
	close="NOT" reset="NOT" submit="NOT">
	<youi:fieldLayout prefix="record" columns="2" labelWidths="120,120">
		<youi:fieldLabel property="userNo"  caption="用户账号"/>
		<youi:fieldLabel  property="phone"  caption="手机号"/>
		<youi:fieldLabel  property="name"  caption="姓名"/>
		<youi:fieldLabel property="lastLoginTime"  caption="上次登陆时间"/>
	</youi:fieldLayout>
	<div>&nbsp;</div>
</youi:form>
<youi:func name = "headerChangePwd__afterSubmit" >
		$.youi.messageUtils.showMessage("密码修改成功，下次登录生效");
		$('#headerChangePwd_').form("reset").form("close");
</youi:func>
