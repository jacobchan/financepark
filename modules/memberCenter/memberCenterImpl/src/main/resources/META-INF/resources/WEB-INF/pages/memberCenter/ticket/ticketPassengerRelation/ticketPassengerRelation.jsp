<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ticketPassengerRelation" idKeys="ticketPassengerId" caption="340506乘机人机票关系列表"  panel="false"
				src="esb/web/ticketPassengerRelationManager/getPagerTicketPassengerRelations.json" dataFormId="form_ticketPassengerRelation"
				editSrc="esb/web/ticketPassengerRelationManager/getTicketPassengerRelation.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ticketPassengerRelationManager/removeTicketPassengerRelation.json">
		<youi:fieldLayout>
			<youi:fieldText property="itemId"  caption="ITEM_ID_"/>

			<youi:fieldText property="passengerId"  caption="PASSENGER_ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="itemId"  caption="ITEM_ID_"/>

		<youi:gridCol property="passengerId"  caption="PASSENGER_ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-340506乘机人机票关系编辑 -->
	<youi:form dialog="true" caption="340506乘机人机票关系" id="form_ticketPassengerRelation" action="esb/web/ticketPassengerRelationManager/saveTicketPassengerRelation.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="itemId"  caption="ITEM_ID_"/>
			<youi:fieldText property="ticketPassengerId"  caption="TICKET_PASSENGER_ID"/>
			<youi:fieldText property="passengerId"  caption="PASSENGER_ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>