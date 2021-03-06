<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterpriseEmployees" idKeys="employeesId"
		caption="企业员工表列表" panel="false"
		src="esb/web/enterpriseEmployeesManager/getPagerEnterpriseEmployeess.json"
		dataFormId="form_enterpriseEmployees"
		editSrc="esb/web/enterpriseEmployeesManager/getEnterpriseEmployees.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/enterpriseEmployeesManager/removeEnterpriseEmployees.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="rz.rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldSelect property="member.memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberName" caption="会员用户" />
			<youi:fieldText property="employeesName" caption="员工姓名" />
			<youi:fieldText property="employeesTelephone" caption="员工电话" />
		</youi:fieldLayout>
		<youi:gridCol property="employeesDepartment" caption="所属部门" width="20%" />
		<youi:gridCol property="employeesTelephone" caption="员工电话" width="20%" />
		<youi:gridCol property="employeesName" caption="员工姓名" width="20%" />
		<youi:gridCol property="rz.rzName" caption="企业信息" width="20%" />
		<youi:gridCol property="member.memberName" caption="会员用户" width="20%" />
		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-企业员工表编辑 -->
	<youi:form dialog="true" caption="企业员工表" id="form_enterpriseEmployees"
		action="esb/web/enterpriseEmployeesManager/saveEnterpriseEmployees.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="employeesId" caption="ID" />
			<youi:fieldText property="employeesDepartment" caption="所属部门" />
			<youi:fieldText property="employeesTelephone" caption="员工电话" />
			<youi:fieldText property="employeesName" caption="员工姓名" />
			<youi:fieldSelect property="rz.rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldSelect property="member.memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberName" caption="会员用户" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->

	<!--**********************************页面函数End**********************************-->
</youi:page>