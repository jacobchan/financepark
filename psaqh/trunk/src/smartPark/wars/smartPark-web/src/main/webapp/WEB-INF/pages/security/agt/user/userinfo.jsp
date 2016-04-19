<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	
<!-- 	<style type="text/css">
		.pagination > li.addRow{display: none;}
		.pagination > li.removeRow{display: none;}
	</style> -->
	
	<!-- 用户信息展现 -->
	<youi:grid id="grid_userInfo" idKeys="id" panel="false" usePager="fasle" editable="true" showCheckbox="true"
		src="esb/web/baseUserManager/getUserConfigItems.json"
		saveRowsSrcs="esb/web/baseUserManager/saveUserConfigItems.json"
		submit="NOT" reset="NOT"  save="保存">
		<youi:fieldLayout prefix="r">
			<youi:fieldHidden property="userId"/>
		</youi:fieldLayout>
		<youi:gridCol editor="fieldText" property="caption" caption="属性描述" width="33%" align="center"/>
		<youi:gridCol editor="fieldText" property="name" caption="属性名" width="33%" align="center"/>
		<youi:gridCol editor="fieldText" property="value" caption="属性值" width="33%" align="center"/>
		<youi:gridCol property="userId" caption="userId" width="0" align="center"/>
		<youi:gridCol property="id" caption="ID" width="0" align="center"/>
	</youi:grid>
	
	<!--**********************************页面内容********************************-->
	<youi:func name="subpage_init" params="record">
		var userId = record.userId;
	</youi:func>
	<!--**********************************页面函数********************************-->
	
	
	<!--**********************************页面函数********************************-->
</youi:page>