<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_paymanagerOrdrePayflow" idKeys="orderPayflowId" caption="订单支付流水表列表"  panel="false"
				src="esb/web/paymanagerOrdrePayflowManager/getPagerPaymanagerOrdrePayflows.json" dataFormId="form_paymanagerOrdrePayflow"
				editSrc="esb/web/paymanagerOrdrePayflowManager/getPaymanagerOrdrePayflow.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/paymanagerOrdrePayflowManager/removePaymanagerOrdrePayflow.json">
		<youi:fieldLayout>
			<youi:fieldText property="orderPayflowOrderCode"  caption="订单号编号"/>
			<youi:fieldText property="orderPayflowPayProject"  caption="支付项目"/>
			<youi:fieldText property="orderPayflowOrderPaymode"  caption="支付方式"/>
			<youi:fieldText property="orderPayflowPayTime"  caption="支付时间"/>
			<youi:fieldText property="orderPayflowPayAmount"  caption="支付金额"/>

			<youi:fieldText property="orderPayflowCode"  caption="流水编号"/>
		</youi:fieldLayout>
		<youi:gridCol property="orderPayflowOrderCode"  caption="订单号编号"/>
		<youi:gridCol property="orderPayflowPayProject"  caption="支付项目"/>
		<youi:gridCol property="orderPayflowOrderPaymode"  caption="支付方式"/>
		<youi:gridCol property="orderPayflowPayTime"  caption="支付时间"/>
		<youi:gridCol property="orderPayflowPayAmount"  caption="支付金额"/>

		<youi:gridCol property="orderPayflowCode"  caption="流水编号"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-订单支付流水表编辑 -->
	<youi:form dialog="true" caption="订单支付流水表" id="form_paymanagerOrdrePayflow" action="esb/web/paymanagerOrdrePayflowManager/savePaymanagerOrdrePayflow.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="orderPayflowOrderCode"  caption="订单号编号"/>
			<youi:fieldText property="orderPayflowPayProject"  caption="支付项目"/>
			<youi:fieldText property="orderPayflowOrderPaymode"  caption="支付方式"/>
			<youi:fieldText property="orderPayflowPayTime"  caption="支付时间"/>
			<youi:fieldText property="orderPayflowPayAmount"  caption="支付金额"/>
			<youi:fieldText property="orderPayflowId"  caption="支付流水序列"/>
			<youi:fieldText property="orderPayflowCode"  caption="流水编号"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>