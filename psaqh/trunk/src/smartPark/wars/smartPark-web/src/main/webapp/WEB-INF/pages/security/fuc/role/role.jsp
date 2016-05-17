<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<youi:func name="form_role_afterSubmit" params="results">
		$(this).form('close');
	</youi:func>
	
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="菜单授权" height="480" width="780"
		subpageId="menu_auth" src="page/security.fuc.role/auth.html"/>
	
	<youi:subpage caption="页面授权" height="520"
		subpageId="page_auth" src="page/security.fuc.role/pageAuth.html?roleId={roleId}"/>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-角色列表-->
	<youi:grid id="grid_role" idKeys="roleId" caption="角色列表" panel="false"
				src="esb/web/roleManager/getPagerRoles.json" dataFormId="form_role"  pageSize="10"
				editSrc="/local/fuc/role/getRole.json" edit="NOT" remove="NOT" exportXls="true" exportPdf="true" exportTxt="txt"
				removeSrc="esb/web/roleMenuManager/removeRole.json">
		<youi:fieldLayout styleClass="notFillQuery">
			<youi:fieldText operator="LIKE" property="roleId"  caption="角色名"/>
			<youi:fieldText operator="LIKE" property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol width="25%" property="roleId"  caption="角色名"/>
		<youi:gridCol width="55%" property="roleCaption"  caption="角色描述"/>
		<youi:gridCol width="20%" property="roleType" convert="roleType" caption="角色分类"/>
		
		<%-- <youi:button name="menuAuth" caption="菜单授权" order="200" active="1"/> --%>
		<youi:button name="pageAuth" caption="页面授权" order="202" active="1"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="auth" authCode="addRole" icon="lock" caption="菜单授权"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-角色编辑 -->
	<youi:form dialog="true" caption="角色" idKeys="roleId"
		id="form_role" action="/local/fuc/role/saveRole.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText notNull="true" property="roleId"  caption="角色名"/>
			<youi:fieldText property="roleType"  caption="角色类型"/>
			<youi:fieldText notNull="true" width="602" column="2" property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="grid_role_col_button_auth" params="record">
		var subpageElement = $elem('subpage_menu_auth',pageId);
		subpageElement.subpage('open',record);
	</youi:func>
	
	<youi:func name="func_grid_pageAuth">
		var subpageElement = $elem('subpage_page_auth',pageId),
			gridElement = $elem('grid_role',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord,null,selectedRecord);
	</youi:func>
	
	<youi:func name="func_grid_menuAuth">
		var subpageElement = $elem('subpage_menu_auth',pageId),
			gridElement = $elem('grid_role',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
		subpageElement.subpage('open',selectedRecord,null,selectedRecord);
	</youi:func>
	
	<!--**********************************页面函数********************************-->
</youi:page>