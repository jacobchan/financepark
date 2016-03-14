<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ticketOrder" idKeys="orderId" caption="机票订单列表"  panel="false"
				src="esb/web/ticketOrderManager/getPagerTicketOrders.json" dataFormId="form_ticketOrder"
				editSrc="esb/web/ticketOrderManager/getTicketOrder.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ticketOrderManager/removeTicketOrder.json">
		<youi:fieldLayout>
			<youi:fieldText property="payType"  caption="支付方式"/>
			<youi:fieldText property="orderAmount"  caption="订单金额"/>
			<youi:fieldText property="orderType"  caption="订单状态"/>

			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="orderTime"  caption="订单时间"/>
			<youi:fieldText property="orderNo"  caption="订单号码"/>
		</youi:fieldLayout>
		<youi:gridCol property="payType"  caption="支付方式"/>
		<youi:gridCol property="orderAmount"  caption="订单金额"/>
		<youi:gridCol property="orderType"  caption="订单状态"/>

		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="orderTime"  caption="订单时间"/>
		<youi:gridCol property="orderNo"  caption="订单号码"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-机票订单编辑 -->
	<youi:form dialog="true" caption="机票订单" id="form_ticketOrder" action="esb/web/ticketOrderManager/saveTicketOrder.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="payType"  caption="支付方式"/>
			<youi:fieldText property="orderAmount"  caption="订单金额"/>
			<youi:fieldText property="orderType"  caption="订单状态"/>
			<youi:fieldText property="orderId"  caption="ORDER_ID_"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="orderTime"  caption="订单时间"/>
			<youi:fieldText property="orderNo"  caption="订单号码"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>