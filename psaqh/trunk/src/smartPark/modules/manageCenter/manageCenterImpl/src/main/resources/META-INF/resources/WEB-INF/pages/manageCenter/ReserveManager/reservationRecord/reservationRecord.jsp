<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_reservationRecord" idKeys="recordId" caption="预约记录列表"  panel="false"
				src="esb/web/reservationRecordManager/getPagerReservationRecords.json" dataFormId="form_reservationRecord"
				editSrc="esb/web/reservationRecordManager/getReservationRecord.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/reservationRecordManager/removeReservationRecord.json">
		<youi:fieldLayout labelWidths="90,100">
			<youi:fieldText property="recordServiceTel"  caption="客服电话"/>
			<youi:fieldSelect property="recordStatus"  caption="预约记录状态" convert="enteringStatus"/>
			<youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus"/>
			<youi:fieldText property="recordCustomer"  caption="客服代表"/>
			<youi:fieldSelect property="recordType"  caption="预约类型" convert="recordType"/>
		</youi:fieldLayout>
		<youi:gridCol property="recordServiceTel"  caption="客服电话" width="100"/>
		<youi:gridCol property="recordStatus"  caption="预约记录状态" convert="enteringStatus" width="120"/>
		<youi:gridCol property="recordMemberId"  caption="预约对象"  width="100"/>
		<youi:gridCol property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus" width="100"/>
		<youi:gridCol property="recordCustomer"  caption="客服代表"/>
		<youi:gridCol property="recordType"  caption="预约类型" convert="recordType"/>
		 <youi:gridCol property="visiteDate"  caption="来访日期"/>
         <youi:gridCol property="visiteTime"  caption="来访时间" convert="enteringTime"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-预约记录编辑 -->
	<youi:form dialog="true" caption="预约记录" id="form_reservationRecord" action="esb/web/reservationRecordManager/saveReservationRecordByType.json">
		<youi:fieldLayout prefix="record">
		    <youi:fieldCalendar property="visiteDate"  caption="来访日期" width="120"/>
		    <youi:fieldSelect property="visiteTime"  caption="来访时间" convert="enteringTime" width="120"/>
			<youi:fieldSelect property="recordStatus"  caption="预约记录状态" convert="enteringStatus" width="100"/>
			<youi:fieldHidden property="recordMemberId"  caption="预约对象"/>
			<youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus"/>
			<youi:fieldText property="recordCustomer"  caption="客服代表"/>
			<youi:fieldText property="recordServiceTel"  caption="客服电话"/>
			<youi:fieldHidden property="recordId"  caption="预约记录ID"/>
			<youi:fieldSelect property="recordType"  caption="预约类型" convert="recordType"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>