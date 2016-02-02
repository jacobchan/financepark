<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerOrdermerchanNexus" idKeys="ordermerchanNexusId" caption="订单商户关系表列表"  panel="false"
				src="esb/web/ordermanagerOrdermerchanNexusManager/getPagerOrdermanagerOrdermerchanNexuss.json" dataFormId="form_ordermanagerOrdermerchanNexus"
				editSrc="esb/web/ordermanagerOrdermerchanNexusManager/getOrdermanagerOrdermerchanNexus.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerOrdermerchanNexusManager/removeOrdermanagerOrdermerchanNexus.json">
		<youi:fieldLayout>
			<youi:fieldText property="merchantId"  caption="商户ID"/>

			<youi:fieldText property="ordermerchanNexusExpressOrder"  caption="物流单号"/>
		</youi:fieldLayout>
		<youi:gridCol property="merchantId"  caption="商户ID"/>

		<youi:gridCol property="ordermerchanNexusExpressOrder"  caption="物流单号"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-订单商户关系表编辑 -->
	<youi:form dialog="true" caption="订单商户关系表" id="form_ordermanagerOrdermerchanNexus" action="esb/web/ordermanagerOrdermerchanNexusManager/saveOrdermanagerOrdermerchanNexus.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="merchantId"  caption="商户ID"/>
			<youi:fieldText property="ordermerchanNexusId"  caption="订单商户序列"/>
			<youi:fieldText property="ordermerchanNexusExpressOrder"  caption="物流单号"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>