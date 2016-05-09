<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ticketPassenger" idKeys="passengerId" caption="340505乘机人列表"  panel="false"
				src="esb/web/ticketPassengerManager/getPagerTicketPassengers.json" dataFormId="form_ticketPassenger"
				editSrc="esb/web/ticketPassengerManager/getTicketPassenger.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ticketPassengerManager/removeTicketPassenger.json">
		<youi:fieldLayout>
			<youi:fieldText property="identityNum"  caption="证件号码"/>

			<youi:fieldText property="insurance"  caption="保险"/>
			<youi:fieldText property="name"  caption="乘机人姓名"/>
			<youi:fieldText property="type"  caption="类型"/>
			<youi:fieldText property="identityType"  caption="证件类型"/>
			<youi:fieldText property="tel"  caption="联系电话"/>
			<youi:fieldText property="inputTime"  caption="时间"/>
		</youi:fieldLayout>
		<youi:gridCol property="identityNum"  caption="证件号码"/>

		<youi:gridCol property="insurance"  caption="保险"/>
		<youi:gridCol property="name"  caption="乘机人姓名"/>
		<youi:gridCol property="type"  caption="类型"/>
		<youi:gridCol property="identityType"  caption="证件类型"/>
		<youi:gridCol property="tel"  caption="联系电话"/>
		<youi:gridCol property="inputTime"  caption="时间"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-340505乘机人编辑 -->
	<youi:form dialog="true" caption="340505乘机人" id="form_ticketPassenger" action="esb/web/ticketPassengerManager/saveTicketPassenger.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="identityNum"  caption="证件号码"/>
			<youi:fieldText property="passengerId"  caption="PASSENGER_ID"/>
			<youi:fieldText property="insurance"  caption="保险"/>
			<youi:fieldText property="name"  caption="乘机人姓名"/>
			<youi:fieldText property="type"  caption="类型"/>
			<youi:fieldText property="identityType"  caption="证件类型"/>
			<youi:fieldText property="tel"  caption="联系电话"/>
			<youi:fieldText property="inputTime"  caption="时间"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>