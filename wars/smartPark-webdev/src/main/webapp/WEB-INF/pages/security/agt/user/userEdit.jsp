<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<youi:fieldLayout prefix="record">
		<youi:fieldHidden property="userId"  caption="用户ID"/>
		<youi:fieldText notNull="true" property="loginName"  caption="登录名"/>
		<youi:fieldText notNull="true" property="userCaption"  caption="用户名称"/>
		<youi:fieldHidden property="userActive"  caption="是否生效"/>
	</youi:fieldLayout>
	<fieldset>
		<legend>选择用户角色</legend>
		<youi:fieldLayout labelWidths="1" columns="1">
			<youi:fieldSelect property="roles" src="esb/web/roleManager/getRoles.json" show="roleId" code="roleCaption">
			</youi:fieldSelect>
		</youi:fieldLayout>
	</fieldset>
</youi:page>