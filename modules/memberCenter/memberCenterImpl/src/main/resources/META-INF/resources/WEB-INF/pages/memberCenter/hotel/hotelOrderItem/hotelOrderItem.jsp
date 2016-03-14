<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_hotelOrderItem" idKeys="itemId" caption="酒店订单明细列表"  panel="false"
				src="esb/web/hotelOrderItemManager/getPagerHotelOrderItems.json" dataFormId="form_hotelOrderItem"
				editSrc="esb/web/hotelOrderItemManager/getHotelOrderItem.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/hotelOrderItemManager/removeHotelOrderItem.json">
		<youi:fieldLayout>
			<youi:fieldText property="roomPrice"  caption="单价"/>
			<youi:fieldText property="roomNo"  caption="房间号"/>

			<youi:fieldText property="roomCount"  caption="数量"/>
		</youi:fieldLayout>
		<youi:gridCol property="roomPrice"  caption="单价"/>
		<youi:gridCol property="roomNo"  caption="房间号"/>

		<youi:gridCol property="roomCount"  caption="数量"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-酒店订单明细编辑 -->
	<youi:form dialog="true" caption="酒店订单明细" id="form_hotelOrderItem" action="esb/web/hotelOrderItemManager/saveHotelOrderItem.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="roomPrice"  caption="单价"/>
			<youi:fieldText property="roomNo"  caption="房间号"/>
			<youi:fieldText property="itemId"  caption="ITEM_ID_"/>
			<youi:fieldText property="roomCount"  caption="数量"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>