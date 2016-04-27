<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
			<youi:grid id="grid_reservationRecord" idKeys="recordId,recordCommdityId,recordCustomer,recordMemberId" caption="预约记录列表"  panel="false" 
				src="esb/web/reservationRecordManager/getPagerReservationRecords.json" dataFormId="form_reservationRecord"
				editSrc="esb/web/reservationRecordManager/getReservationRecord.json" add="NOT" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/reservationRecordManager/removeReservationRecord.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldSelect property="recordType"  caption="预约类型" convert="recordType"/>
			<youi:fieldHidden property="recordStatus"  caption="预约记录状态" defaultValue="02"/>
			<youi:fieldCalendar property="visiteDate"  caption="来访日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:button name="returnRecord" caption="回访记录" icon="edit" active="1"></youi:button> 
		<youi:gridCol property="recordCommdityName"  caption="预约商品"  width="10%" align="center"/>
		<youi:gridCol property="recordType"  caption="预约类型" convert="recordType"  width="10%" align="center"/>
		<youi:gridCol property="recordStatus"  caption="预约记录状态" convert="enterrecStatus"  width="10%" align="center"/>
	     <youi:gridCol property="visiteName"  caption="来访姓名"  width="10%" align="center" />
	    <youi:gridCol property="visiteTel"  caption="联系电话"  width="10%" align="center"/>
	    <youi:gridCol property="visiteDate"  caption="来访日期"  width="10%" align="center" orderBy="desc"/>
	    <youi:gridCol property="visiteTime"  caption="来访时间"  width="20%" align="center"/>
		<youi:gridCol property="recordCustomerName"  caption="客服代表"  width="10%" align="center"/>
		<youi:gridCol property="recordServiceTel"  caption="客服电话"  width="10%" align="center"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	
		<!-- form-预约记录编辑 -->
	<youi:form dialog="true" caption="预约记录" id="form_reservationRecord" action="esb/web/reservationRecordManager/saveReservationRecord.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
		     <youi:fieldLabel property="recordType"  caption="预约类型" convert="recordType"/>
		    <youi:fieldLabel property="recordCommdityName"  caption="预约商品"/>
		    <youi:fieldLabel property="visiteDate"  caption="来访日期" width="120" />
		    <youi:fieldLabel property="recordCustomer"  caption="客服代表" />
			<youi:fieldLabel property="recordServiceTel"  caption="客服电话" />
			<youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus" notNull="true"/>
			 <youi:fieldLabel property="visiteTime"  caption="来访时间" width="120"/>
			<youi:fieldHidden property="recordId"  caption="预约记录ID"/>
			<youi:fieldHidden property="recordStatus"  caption="预约记录状态"/>
			<youi:fieldHidden property="visiteName"  caption="来访姓名"/>
			<youi:fieldHidden property="visiteTel"  caption="联系电话" />
			<youi:fieldHidden property="recordCommdityId"  caption="预约对象"/>
			<youi:fieldHidden property="recordMemberId"  caption="预约对象" />
		</youi:fieldLayout>
	</youi:form>
	
	<youi:form dialog="true" caption="回访记录" id="form_returnRecord" action="esb/web/reservationRecordManager/saveReternRecords.json">
		<youi:fieldLayout prefix="records" labelWidths="100,100">
		    <youi:fieldLabel property="recordType"  caption="预约类型" convert="recordType"/>
		    <youi:fieldLabel property="recordCommdityName"  caption="预约商品"/>
		    <youi:fieldLabel property="visiteDate"  caption="来访日期" width="120" />
		    <youi:fieldLabel property="recordCustomer"  caption="客服代表" />
			<youi:fieldLabel property="recordServiceTel"  caption="客服电话" />
			 <youi:fieldLabel property="visiteTime"  caption="来访时间" width="120"/>
			 <youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus" notNull="true"/>
			<youi:fieldHidden property="recordId"  caption="预约记录ID"/>
			<youi:fieldHidden property="recordStatus"  caption="预约记录状态"/>
			<youi:fieldHidden property="visiteName"  caption="来访姓名"/>
			<youi:fieldHidden property="visiteTel"  caption="联系电话" />
			<youi:fieldHidden property="recordCommdityId"  caption="预约对象"/>
			<youi:fieldHidden property="recordMemberId"  caption="预约对象" />
		</youi:fieldLayout>
	</youi:form>
	
	  <!--**********************************页面函数Start:将已预约的记录进行授理，变更为已授理状态，并刷新页面********************************-->
    	<youi:func name = "func_grid_returnRecord">
        var gridElement = $elem('grid_reservationRecord',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
        var recordStatus = selectedRecord.recordStatus;
        var formCancel = $elem('form_returnRecord',pageId);
         formCancel.form('fillRecord',selectedRecord).form('open');
    </youi:func>
    
	<!--**********************************页面函数End:将已预约的记录进行授理，变更为已授理状态，并刷新页面********************************-->
	
	 <!--**********************************页面函数Start:受理成功后，关闭页面并刷新父页面********************************-->
	<youi:func name = "form_returnRecord_afterSubmit">
        var formloanApp = $elem('form_returnRecord',pageId);
		formloanApp.form('close');
        alert("回访完成");
		$elem('grid_reservationRecord',pageId).grid('pReload');
     </youi:func>
    <!--**********************************页面函数End:受理成功后，关闭页面并刷新父页面********************************-->
</youi:page>