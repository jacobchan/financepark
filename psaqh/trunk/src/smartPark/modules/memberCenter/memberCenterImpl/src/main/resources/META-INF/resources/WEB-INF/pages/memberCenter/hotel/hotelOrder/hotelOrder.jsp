<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_hotelOrder" idKeys="orderId" caption="酒店订单列表"  panel="false"
				src="esb/web/hotelOrderManager/getPagerHotelOrders.json" dataFormId="form_hotelOrder"
				editSrc="esb/web/hotelOrderManager/getHotelOrder.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/hotelOrderManager/removeHotelOrder.json">
		<youi:fieldLayout>
			<youi:fieldText property="orderTime"  caption="订单时间"/>
			<youi:fieldText property="orderAmount"  caption="订单金额"/>
			<youi:fieldText property="orderStatus"  caption="订单状态"/>
			<youi:fieldText property="payType"  caption="支付方式"/>

			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="orderTime"  caption="订单时间"/>
		<youi:gridCol property="orderAmount"  caption="订单金额"/>
		<youi:gridCol property="orderStatus"  caption="订单状态"/>
		<youi:gridCol property="payType"  caption="支付方式"/>

		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-酒店订单编辑 -->
	<youi:form dialog="true" caption="酒店订单" id="form_hotelOrder" action="esb/web/hotelOrderManager/saveHotelOrder.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="orderTime"  caption="订单时间"/>
			<youi:fieldText property="orderAmount"  caption="订单金额"/>
			<youi:fieldText property="orderStatus"  caption="订单状态"/>
			<youi:fieldText property="payType"  caption="支付方式"/>
			<youi:fieldText property="orderId"  caption="ORDER_ID_"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>