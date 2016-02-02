<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterpriseEmployees" idKeys="employeesId" caption="企业员工表列表"  panel="false"
				src="esb/web/enterpriseEmployeesManager/getPagerEnterpriseEmployeess.json" dataFormId="form_enterpriseEmployees"
				editSrc="esb/web/enterpriseEmployeesManager/getEnterpriseEmployees.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/enterpriseEmployeesManager/removeEnterpriseEmployees.json">
		<youi:fieldLayout>
			<youi:fieldText property="employeesComId"  caption="企业信息ID_"/>
			<youi:fieldText property="employeesDepartment"  caption="所属部门"/>

			<youi:fieldText property="employeesTelephone"  caption="员工电话"/>
			<youi:fieldText property="employeesName"  caption="员工姓名"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="employeesComId"  caption="企业信息ID_"/>
		<youi:gridCol property="employeesDepartment"  caption="所属部门"/>

		<youi:gridCol property="employeesTelephone"  caption="员工电话"/>
		<youi:gridCol property="employeesName"  caption="员工姓名"/>
		<youi:gridCol property="rzId"  caption="ID"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-企业员工表编辑 -->
	<youi:form dialog="true" caption="企业员工表" id="form_enterpriseEmployees" action="esb/web/enterpriseEmployeesManager/saveEnterpriseEmployees.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="employeesComId"  caption="企业信息ID_"/>
			<youi:fieldText property="employeesDepartment"  caption="所属部门"/>
			<youi:fieldText property="employeesId"  caption="ID_"/>
			<youi:fieldText property="employeesTelephone"  caption="员工电话"/>
			<youi:fieldText property="employeesName"  caption="员工姓名"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>