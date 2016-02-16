<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page savable="true">

	<youi:form id="form_project_menus">
		<youi:fieldLayout columns="1">
			<youi:fieldLabel property="projectId" caption="项目ID"/>
			<youi:fieldLabel property="projectCaption" caption="项目名称"/>
			
			<youi:fieldGrid property="menus">
				<youi:grid id="grid_menus" editable="true" scrollHeight="360">
					<youi:gridCol width="20%" type="tree" fixed="false" property="menuCaption" caption="菜单"/>
					<youi:gridCol width="20%" property="menuCode" editor="fieldText" caption="菜单编号"/>
					<youi:gridCol width="60%" editor="fieldText" property="menuHref" caption="菜单地址" editorOptions=""/>
				</youi:grid>
			</youi:fieldGrid>
		</youi:fieldLayout>
	</youi:form>

</youi:page>