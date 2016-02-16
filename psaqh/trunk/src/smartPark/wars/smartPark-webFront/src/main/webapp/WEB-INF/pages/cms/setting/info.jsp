<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html>
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
	</head>
	<youi:body decorator="cms">
		个人资料
		
		<youi:grid styleClass="cms-grid-tcol-9" id="grid_role" idKeys="roleId" caption="角色列表" panel="false"
				src="/local/fuc/role/getPagerRoles.json" dataFormId="form_role" 
				editSrc="/local/fuc/role/getRole.json" edit="NOT" remove="NOT" scrollHeight="234"
				removeSrc="/local/fuc/role/removeRole.json">
		<youi:fieldLayout columns="1" styleClass="col-sm-3">
			<youi:fieldText operator="LIKE" property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>

		<youi:gridCol width="25%" property="roleId"  caption="角色名"/>
		<youi:gridCol width="55%" property="roleCaption"  caption="角色描述"/>
		<youi:gridCol width="20%" property="roleType" convert="roleType" caption="角色分类"/>
		
		<youi:button name="pageAuth" caption="页面授权" order="202" active="1"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="auth" authCode="addRole" icon="lock" caption="菜单授权"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	</youi:body>
	
</youi:html>