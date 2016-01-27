<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	
	<youi:subpage src="page/security.agt.user/userEdit.html"
		subpageId="userEdit" caption="用户" 
		editSrc="esb/web/userManager/getUser.json" idKeys="userId"
		formAction="esb/web/userManager/saveUser.json"
		formSubmit="提交"/>

	<!-- grid-用户列表-->
	<youi:grid id="grid_user" idKeys="userId" caption="用户列表" panel="false"
				src="esb/web/userManager/getPagerUsers.json" dataFormId="form_user"
				exportTitle="我的文件" pageSize="3"
				add="NOT" edit="NOT" remove="NOT" 
				showCheckbox="true" exportXls="true" exportPdf="true" exportTxt="true"
				removeSrc="esb/web/userManager/removeUser.json">
		<youi:fieldLayout styleClass="notFillQuery">
			<youi:fieldText property="loginName"  caption="登录名"/>
			<youi:fieldText operator="LIKE" property="userCaption" caption="i18n.user.userName"/>
		</youi:fieldLayout>

		<youi:gridCol width="30%" type="myStyle" property="loginName"  caption="登录名"/>
		<youi:gridCol width="70%"  property="userCaption"  caption="i18n.user.userName"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="editUser" icon="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		
		<youi:button name="addUser" icon="addRecord" caption="增加"/>
	</youi:grid>
	
	<!-- 增加按钮动作：打开新增子页面 -->
	<youi:func name="func_grid_addUser">
		var subpageElement = $elem('subpage_userEdit',pageId);
		subpageElement.subpage('open',{},'增加',{userId:''});
	</youi:func>
	
	<!-- 行编辑按钮动作：打开修改子页面 -->
	<youi:func name="grid_user_col_button_editUser" params="record,rowDoc">
		var subpageElement = $elem('subpage_userEdit',pageId);
		subpageElement.subpage('open',{},'修改',record);
	</youi:func>
	
	<youi:func name="subpage_userEdit_afterSubmit" params="results">
		$(this).subpage('close');
	</youi:func>
	
	<youi:func name="grid_user_reset">
		alert(reset);
	</youi:func>
	
</youi:page>