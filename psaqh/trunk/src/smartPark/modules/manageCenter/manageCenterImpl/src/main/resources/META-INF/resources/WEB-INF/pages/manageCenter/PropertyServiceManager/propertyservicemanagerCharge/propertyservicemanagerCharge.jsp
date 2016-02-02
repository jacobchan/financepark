<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerCharge" idKeys="chargeId" caption="物业收费登记表列表"  panel="false"
				src="esb/web/propertyservicemanagerChargeManager/getPagerPropertyservicemanagerCharges.json" dataFormId="form_propertyservicemanagerCharge"
				editSrc="esb/web/propertyservicemanagerChargeManager/getPropertyservicemanagerCharge.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerChargeManager/removePropertyservicemanagerCharge.json">
		<youi:fieldLayout>

			<youi:fieldText property="userorderId"  caption="用户订单序列"/>
			<youi:fieldText property="chargeCreatetime"  caption="登记日期"/>
			<youi:fieldText property="chargeAmount"  caption="应缴费总额"/>
			<youi:fieldText property="roomId"  caption="单元ID"/>
			<youi:fieldText property="chargeIsbool"  caption="是否缴费"/>
			<youi:fieldText property="chargeComp"  caption="收费企业名称"/>
			<youi:fieldText property="chargeUnit"  caption="单元号"/>
			<youi:fieldText property="chargeBedate"  caption="起始日期"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="chargeTime"  caption="缴费日期"/>
			<youi:fieldText property="chargeEndate"  caption="截止日期"/>
		</youi:fieldLayout>

		<youi:gridCol property="userorderId"  caption="用户订单序列"/>
		<youi:gridCol property="chargeCreatetime"  caption="登记日期"/>
		<youi:gridCol property="chargeAmount"  caption="应缴费总额"/>
		<youi:gridCol property="roomId"  caption="单元ID"/>
		<youi:gridCol property="chargeIsbool"  caption="是否缴费"/>
		<youi:gridCol property="chargeComp"  caption="收费企业名称"/>
		<youi:gridCol property="chargeUnit"  caption="单元号"/>
		<youi:gridCol property="chargeBedate"  caption="起始日期"/>
		<youi:gridCol property="rzId"  caption="ID"/>
		<youi:gridCol property="chargeTime"  caption="缴费日期"/>
		<youi:gridCol property="chargeEndate"  caption="截止日期"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-物业收费登记表编辑 -->
	<youi:form dialog="true" caption="物业收费登记表" id="form_propertyservicemanagerCharge" action="esb/web/propertyservicemanagerChargeManager/savePropertyservicemanagerCharge.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="chargeId"  caption="收费登记序列"/>
			<youi:fieldText property="userorderId"  caption="用户订单序列"/>
			<youi:fieldText property="chargeCreatetime"  caption="登记日期"/>
			<youi:fieldText property="chargeAmount"  caption="应缴费总额"/>
			<youi:fieldText property="roomId"  caption="单元ID"/>
			<youi:fieldText property="chargeIsbool"  caption="是否缴费"/>
			<youi:fieldText property="chargeComp"  caption="收费企业名称"/>
			<youi:fieldText property="chargeUnit"  caption="单元号"/>
			<youi:fieldText property="chargeBedate"  caption="起始日期"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="chargeTime"  caption="缴费日期"/>
			<youi:fieldText property="chargeEndate"  caption="截止日期"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>