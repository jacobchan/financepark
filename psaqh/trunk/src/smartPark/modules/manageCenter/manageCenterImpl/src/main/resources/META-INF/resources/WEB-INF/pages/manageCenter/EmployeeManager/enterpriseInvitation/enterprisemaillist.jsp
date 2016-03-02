<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterprisemaillist" idKeys="employeesId"
		caption="邀请记录表列表" panel="false"
		src="esb/web/enterpriseEmployeesManager/getPagerEnterpriseEmployeess.json"
		dataFormId="form_enterprisemaillist"
		editSrc="esb/web/enterpriseEmployeesManager/getEnterpriseEmployees.json"
		edit="NOT" remove="NOT" add="NOT" showCheckbox="false"
		removeSrc="esb/web/enterpriseEmployeesManager/removeEnterpriseEmployees.json">
		<youi:fieldLayout columns="3" labelWidths="120,120,120">
			<youi:fieldSelect property="rz.rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzMem" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldText property="invitationTelephone" caption="会员电话" />
			<youi:fieldText property="invitationCode" caption="企业邀请码" />
		</youi:fieldLayout>
		<youi:button name="distribution" caption="分配角色" icon="search" active="1" />
		<youi:gridCol property="member.memberNickname" caption="会员用户" width="20%" />
		<youi:gridCol property="employeesName" caption="员工姓名" width="20%" />
		<youi:gridCol property="employeesTelephone" caption="员工电话" width="20%" />
		<youi:gridCol property="rz.rzMem" caption="企业信息" width="20%" />
		<youi:gridCol property="roleId" renderer="renderer_roleId" caption="角色" width="20%" />
		<youi:gridCol property="employeesId" caption="企业编号" width="0" />
	</youi:grid>

	<!-- form-分配角色 -->
	<youi:form dialog="true" caption="分配角色" id="form_enterprisemaillist"
		action="esb/web/enterpriseRoleManager/saveEnterpriseRole.json" width="450">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="rId" caption="编号" />
			<youi:fieldHidden property="employees.employeesId" caption="员工编号" />
			<youi:fieldSelect property="role.roleId"
				src="esb/web/roleManager/getPagerRoles.json"
				code="roleId" show="roleCaption" caption="员工角色" notNull="true" tooltips="员工角色" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->	
	<!-- 分配角色 -->
	<youi:func name="func_grid_distribution" params="value">
		var gridElement = $elem('grid_enterprisemaillist',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var eId = selectedRecord.employeesId;
		if(eId!=''){
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/enterpriseRoleManager/getEnterpriseRoleByEmployees.json',
				data:{eId:eId},
				success:function(result){
					var record = result.records;
					for(var i=0;i<record.length;i++){
						var roles = record[i];
						$elem('record_rId',pageId).fieldValue(roles.rId);
						$elem('record_employees_employeesId',pageId).fieldValue(eId);
						$elem('record_role_roleId',pageId).fieldValue(roles.role.roleId);
					}
					$elem('form_enterprisemaillist',pageId).form('open');
				}
			});
		}
	</youi:func>
	<youi:func name="renderer_roleId" params="col,record">
	 	var roleName = ""; 
		$.youi.ajaxUtil.ajax({
			url:'esb/web/enterpriseRoleManager/getEnterpriseRoleByEmployees.json',
			data:'eId='+record.employeesId,
			async: false, 
			success:function(result){
				var record = result.records;
				for(var i=0;i<record.length;i++){
					var roles = record[i];
					roleName += roles.role.roleCaption+",";
				}
			}
		});
		return roleName.substring(0,roleName.length-1);
	</youi:func>
	<youi:func name="form_enterprisemaillist_afterSubmit">
		var enterprisemaillist = $elem('form_enterprisemaillist',pageId);
		enterprisemaillist.form('reset');
		enterprisemaillist.form('close');
		$elem('grid_enterprisemaillist',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>