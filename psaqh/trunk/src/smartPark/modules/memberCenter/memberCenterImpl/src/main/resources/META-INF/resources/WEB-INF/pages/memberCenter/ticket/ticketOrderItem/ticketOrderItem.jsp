<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ticketOrderItem" idKeys="itemId" caption="机票订单详情列表"  panel="false"
				src="esb/web/ticketOrderItemManager/getPagerTicketOrderItems.json" dataFormId="form_ticketOrderItem"
				editSrc="esb/web/ticketOrderItemManager/getTicketOrderItem.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ticketOrderItemManager/removeTicketOrderItem.json">
		<youi:fieldLayout>

			<youi:fieldText property="ticketCount"  caption="商品数量"/>
			<youi:fieldText property="ticketNo"  caption="商品编码"/>
		</youi:fieldLayout>

		<youi:gridCol property="ticketCount"  caption="商品数量"/>
		<youi:gridCol property="ticketNo"  caption="商品编码"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-机票订单详情编辑 -->
	<youi:form dialog="true" caption="机票订单详情" id="form_ticketOrderItem" action="esb/web/ticketOrderItemManager/saveTicketOrderItem.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="itemId"  caption="ITEM_ID_"/>
			<youi:fieldText property="ticketCount"  caption="商品数量"/>
			<youi:fieldText property="ticketNo"  caption="商品编码"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>