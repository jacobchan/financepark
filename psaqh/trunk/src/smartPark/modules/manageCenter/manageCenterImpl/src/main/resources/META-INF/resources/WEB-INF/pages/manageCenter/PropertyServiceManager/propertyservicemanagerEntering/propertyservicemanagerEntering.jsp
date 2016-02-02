<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerEntering" idKeys="enteringId" caption="可办理预约记录列表"  panel="false"
				src="esb/web/propertyservicemanagerEnteringManager/getPagerPropertyservicemanagerEnterings.json" dataFormId="form_propertyservicemanagerEntering"
				editSrc="esb/web/propertyservicemanagerEnteringManager/getPropertyservicemanagerEntering.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerEnteringManager/removePropertyservicemanagerEntering.json">
		<youi:fieldLayout>
			<youi:fieldText property="enteringStatus"  caption="预约数量状态"/>
			<youi:fieldText property="enteringRemain"  caption="剩余数量"/>
			<youi:fieldText property="enteringTime"  caption="预约时间段"/>

			<youi:fieldText property="enteringAlre"  caption="已预约数"/>
			<youi:fieldText property="enteringSum"  caption="预约总量"/>
			<youi:fieldText property="enteringDate"  caption="预约时间日期"/>
		</youi:fieldLayout>
		<youi:gridCol property="enteringStatus"  caption="预约数量状态"/>
		<youi:gridCol property="enteringRemain"  caption="剩余数量"/>
		<youi:gridCol property="enteringTime"  caption="预约时间段"/>

		<youi:gridCol property="enteringAlre"  caption="已预约数"/>
		<youi:gridCol property="enteringSum"  caption="预约总量"/>
		<youi:gridCol property="enteringDate"  caption="预约时间日期"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-可办理预约记录编辑 -->
	<youi:form dialog="true" caption="可办理预约记录" id="form_propertyservicemanagerEntering" action="esb/web/propertyservicemanagerEnteringManager/savePropertyservicemanagerEntering.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="enteringStatus"  caption="预约数量状态"/>
			<youi:fieldText property="enteringRemain"  caption="剩余数量"/>
			<youi:fieldText property="enteringTime"  caption="预约时间段"/>
			<youi:fieldText property="enteringId"  caption="预约记录ID"/>
			<youi:fieldText property="enteringAlre"  caption="已预约数"/>
			<youi:fieldText property="enteringSum"  caption="预约总量"/>
			<youi:fieldText property="enteringDate"  caption="预约时间日期"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>