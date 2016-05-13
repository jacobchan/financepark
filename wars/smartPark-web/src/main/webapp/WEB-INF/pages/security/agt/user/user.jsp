<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
		<youi:subpage caption="用户信息" 	width="800" subpageId="sp_user_info"
		src="page/security.agt.user/userinfo.html?userId={userId}">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-用户列表-->
	<youi:grid id="grid_user" idKeys="userId" caption="用户列表" panel="false"
				src="agt.91010203" dataFormId="form_user" exportTitle="我的文件"
				editSrc="agt.91010201" edit="NOT" remove="NOT" showCheckbox="true"
				exportXls="true" exportPdf="true" exportTxt="true"
				removeSrc="agt.91010205"
				>
		<youi:fieldLayout>
			<youi:fieldText property="loginName"  caption="登录名"></youi:fieldText>
			<youi:fieldText property="userCaption" caption="i18n.user.userName" operator="LIKE"/>
			
		</youi:fieldLayout>

		<youi:gridCol width="30%" property="loginName"  caption="登录名"/>
		<youi:gridCol width="70%"  property="userCaption"  caption="i18n.user.userName"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		
		<youi:button name="userInfo" caption="用户信息" active="1"/>
	</youi:grid>
	
	<!-- form-用户编辑 -->
	<youi:form dialog="true" caption="用户" id="form_user" action="agt.91010204">
		<youi:fieldLayout prefix="record" labelWidths="80,80" columns="1">
			<youi:fieldHidden property="userId" caption="用户ID"/>
			<youi:fieldText notNull="true" property="loginName" caption="登录名"/>
			<youi:fieldText notNull="true" property="userCaption" caption="用户名称"/>
			<youi:fieldPassword property="password" caption="密码" />
			<youi:fieldHidden property="userActive" caption="是否生效"/>
		</youi:fieldLayout>
		<fieldset>
			<legend>选择用户角色</legend>
			<youi:fieldLayout labelWidths="1" columns="1">
				<youi:fieldTree property="roles" popup="false" valueMode="object"
					show="roleCaption" code="roleId" caption=""
					tree="${roleTree}" check="true" simple="false"/>
			</youi:fieldLayout>
		</fieldset>
	</youi:form>
	
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!-- 行动作 -->
	<youi:func name="grid_user_col_button_edit" params="record,rowDoc" i18ns="user.userName">
		$(this).grid('openFormEdit','修改',rowDoc);
	</youi:func>
	
	<youi:func name="grid_user_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	
	<youi:func name="func_grid_userInfo">
		var userid = $elem('grid_user',pageId).grid('getSelectedRecord').userId;
		$elem('subpage_sp_user_info',pageId).subpage('open',{userId:userid},null,{userId:userid});
	</youi:func>

	<!--**********************************页面函数********************************-->
</youi:page>