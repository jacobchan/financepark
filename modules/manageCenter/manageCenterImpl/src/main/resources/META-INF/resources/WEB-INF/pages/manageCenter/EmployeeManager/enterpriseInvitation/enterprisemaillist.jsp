<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterprisemaillist" idKeys="maillistId"
		caption="邀请记录表列表" panel="false"
		src="esb/web/enterpriseEmployeesManager/getPagerEnterpriseEmployeess.json"
		dataFormId="form_enterprisemaillist"
		editSrc="esb/web/enterpriseEmployeesManager/getEnterpriseEmployees.json"
		edit="NOT" remove="NOT" add="NOT" showCheckbox="false"
		removeSrc="esb/web/enterpriseEmployeesManager/removeEnterpriseEmployees.json">
		<youi:fieldLayout columns="3" labelWidths="120,120,120">
			<youi:fieldSelect property="employeesComId.rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzMem" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldText property="invitationTelephone" caption="会员电话" />
			<youi:fieldText property="invitationCode" caption="企业邀请码" />
		</youi:fieldLayout>
		<youi:button name="distribution" caption="分配角色" icon="search" active="1" />
		<youi:gridCol property="memberId.memberNickname" caption="会员用户" width="20%" />
		<youi:gridCol property="employeesName" caption="员工姓名" width="20%" />
		<youi:gridCol property="employeesTelephone" caption="员工电话" width="20%" />
		<youi:gridCol property="employeesComId.rzMem" caption="企业信息" width="40%" />
	</youi:grid>

	<!-- form-分配角色 -->
	<youi:form dialog="true" caption="分配角色" id="form_enterprisemaillist"
		action="esb/web/enterpriseRoleManager/saveEnterpriseRole.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="rId" caption="角色Id" />
			<youi:fieldText property="invitationCode" notNull="true" readonly="true" caption="企业邀请码" />
			<youi:fieldText property="invitationTelephone" notNull="true" caption="会员电话" />
			<youi:fieldSelect property="role.roleId"
				src="esb/web/roleManager/getPagerRoles.json"
				code="roleId" show="roleCaption" caption="企业角色" notNull="true" tooltips="企业角色" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->	
	<!-- 分配角色 -->
	<youi:func name="func_grid_distribution" params="value">
		var gridElement = $elem('grid_enterprisemaillist',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var employeesId = selectedRecord.employeesId;
		alert(employeesId);
		if(employeesId!=''){
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/enterpriseRoleManager/getEnterpriseRole.json',
				data:{rId:employeesId},
				success:function(result){
					alert(result.record.employees.employeesName);
				}
			});
		}
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>