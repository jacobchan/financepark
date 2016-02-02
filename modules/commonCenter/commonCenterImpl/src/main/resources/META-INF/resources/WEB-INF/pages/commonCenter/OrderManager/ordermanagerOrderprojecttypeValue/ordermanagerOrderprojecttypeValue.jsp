<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerOrderprojecttypeValue" idKeys="orderprojecttypeValueId" caption="订单项目值表列表"  panel="false"
				src="esb/web/ordermanagerOrderprojecttypeValueManager/getPagerOrdermanagerOrderprojecttypeValues.json" dataFormId="form_ordermanagerOrderprojecttypeValue"
				editSrc="esb/web/ordermanagerOrderprojecttypeValueManager/getOrdermanagerOrderprojecttypeValue.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerOrderprojecttypeValueManager/removeOrdermanagerOrderprojecttypeValue.json">
		<youi:fieldLayout>
			<youi:fieldText property="orderprojecttypeValueFieldValue"  caption="字段值"/>

			<youi:fieldText property="orderprojecttypeValueFieldName"  caption="字段名称"/>
			<youi:fieldText property="orderprojecttypeValueDisplayName"  caption="显示名称"/>
		</youi:fieldLayout>
		<youi:gridCol property="orderprojecttypeValueFieldValue"  caption="字段值"/>

		<youi:gridCol property="orderprojecttypeValueFieldName"  caption="字段名称"/>
		<youi:gridCol property="orderprojecttypeValueDisplayName"  caption="显示名称"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-订单项目值表编辑 -->
	<youi:form dialog="true" caption="订单项目值表" id="form_ordermanagerOrderprojecttypeValue" action="esb/web/ordermanagerOrderprojecttypeValueManager/saveOrdermanagerOrderprojecttypeValue.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="orderprojecttypeValueFieldValue"  caption="字段值"/>
			<youi:fieldText property="orderprojecttypeValueId"  caption="订单项目序列"/>
			<youi:fieldText property="orderprojecttypeValueFieldName"  caption="字段名称"/>
			<youi:fieldText property="orderprojecttypeValueDisplayName"  caption="显示名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>