<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_reservationRecord" idKeys="recordId,recordCommdityId,recordMemberId,recordCustomer" caption="预约记录列表"  panel="false" 
				src="esb/web/reservationRecordManager/getPagerReservationRecords.json" dataFormId="form_reservationRecord"
				editSrc="esb/web/reservationRecordManager/getReservationRecord.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/reservationRecordManager/removeReservationRecord.json">
		<youi:fieldLayout labelWidths="100,100">
			<%-- <youi:fieldText property="recordServiceTel"  caption="客服电话"/> --%>
			<%-- <youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus"/> --%>
			<%-- <youi:fieldText property="recordCustomer"  caption="客服代表"/> --%>
			<youi:fieldSelect property="recordType"  caption="预约类型" convert="recordType"/>
			<youi:fieldSelect property="recordStatus"  caption="预约记录状态" convert="enterrecStatus"/>
			<youi:fieldCalendar property="visiteDate"  caption="来访日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:button name="cancelReservation" caption="取消预约" icon="edit" active="1"></youi:button> 
		<youi:button name="changeStatues" caption="预约受理" icon="edit" active="1"></youi:button> 
		<youi:gridCol property="recordCommdityName"  caption="预约商品"  width="10%" align="center"/>
		<youi:gridCol property="recordType"  caption="预约类型" convert="recordType"  width="10%" align="center"/>
		<youi:gridCol property="recordStatus"  caption="预约记录状态" convert="enterrecStatus"  width="10%" align="center"/>
		 <youi:gridCol property="visiteName"  caption="来访姓名"  width="10%" align="center" />
	    <youi:gridCol property="visiteTel"  caption="联系电话"  width="10%" align="center"/>
	    <youi:gridCol property="visiteDate"  caption="来访日期"  width="10%" align="center" />
	    <youi:gridCol property="visiteTime"  caption="来访时间"  width="10%" align="center"/>
	    <youi:gridCol property="recordCustomerName"  caption="客服代表"  width="10%" align="center"/>
		<youi:gridCol property="recordServiceTel"  caption="客服电话"  width="10%" align="center"/>
        <youi:gridCol property="updateTime"  caption="更新时间"  width="10%" align="center" orderBy="desc"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-预约记录编辑 -->
	<youi:form dialog="true" caption="预约记录" id="form_reservationRecord" action="esb/web/reservationRecordManager/saveReservationRecord.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
		    <youi:fieldSelect property="recordType"  caption="预约类型" convert="recordType" notNull="true"/>
		    <%-- <youi:fieldSelect property="recordMemberId"  caption="预约对象" src="esb/web/reservationRecordManager/getRecordsByRecordType.json" notNull="true" parents="recordType" parentsAlias="recordType" code="itemName" show="itemName"/>
		     --%><youi:fieldCalendar property="visiteDate"  caption="来访日期" width="120" notNull="true"/>
		    <youi:fieldText property="visiteTime"  caption="来访时间"/>
		  <%--  <youi:fieldSelect property="visiteTime"  caption="来访时间" convert="enteringTime" width="120" notNull="true"/>
			 <youi:fieldSelect property="recordStatus"  caption="recordStatus" convert="enterrecStatus" width="100" notNull="true"/> --%>
		<%-- <youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus" notNull="true"/>
			<youi:fieldText property="recordCustomer"  caption="客服代表"/>
			<youi:fieldText property="recordServiceTel"  caption="客服电话"/> --%>
			<youi:fieldHidden property="recordId"  caption="预约记录ID"/>
			<youi:fieldHidden property="recordStatus"  caption="预约记录状态"/>
			<youi:fieldHidden property="visiteName"  caption="来访姓名"/>
			<youi:fieldHidden property="visiteTel"  caption="联系电话" />
			<youi:fieldHidden property="recordCode"  caption="预约单号"/>
			<youi:fieldHidden property="recordVisiteStatus"  caption="是否到访"/>
			<youi:fieldHidden property="recordCustomer"  caption="客服代表"/>
			<youi:fieldHidden property="recordMemberId"  caption="预约对象"/>
			<youi:fieldHidden property="recordCommdityId"  caption="预约对象"/>
			<youi:fieldHidden property="recordServiceTel"  caption="客服电话"/>
		</youi:fieldLayout>
	</youi:form>
	
	<youi:form dialog="true" caption="预约授理" id="form_reservationRecordChange" action="esb/web/reservationRecordManager/changeReservationRecordByStatus.json">
		<youi:fieldLayout prefix="records" labelWidths="100,100">
		    <youi:fieldLabel property="recordType"  caption="预约类型" convert="recordType"/>
		    <youi:fieldLabel property="recordCommdityName"  caption="预约商品"/>
		    <youi:fieldLabel property="visiteName"  caption="来访姓名"/>
		    <youi:fieldLabel property="visiteTel"  caption="联系电话"/>
		    <youi:fieldLabel property="visiteDate"  caption="来访日期" width="120" />
		    <youi:fieldText property="visiteTime"  caption="来访时间"/>
		    <%-- <youi:fieldCalendar property="visiteTime"  caption="实际来访时间" width="120" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss"/>
			<youi:fieldSelect property="recordVisiteStatus"  caption="是否到访" convert="recordVisiteStatus"/> --%>
			<youi:fieldSelect property="recordCustomer"  caption="客服代表" notNull="true" src="esb/web/reservationRecordManager/getRoleSaleSer.json" code="loginValue" show="loginName"/>
			<%-- <youi:fieldText property="recordServiceTel"  caption="客服电话" notNull="true" expression="^1[3|4|5|8|9]{1}[0-9]{9,9}$" expressionMessage="请填写正确的手机号码"/> --%>
			<youi:fieldHidden property="recordId"  caption="预约记录ID"/>
			<youi:fieldHidden property="recordStatus"  caption="预约记录状态"/>
			<youi:fieldHidden property="recordServiceTel"  caption="客服电话"/>
			<youi:fieldHidden property="recordMemberId"  caption="预约对象"/>
			<youi:fieldHidden property="recordCommdityId"  caption="预约对象"/>
			<youi:fieldHidden property="recordVisiteStatus"  caption="是否到访"/>
		</youi:fieldLayout>
	</youi:form>
	
	  <!--**********************************页面函数Start:将已预约的记录进行授理，变更为已授理状态，并刷新页面********************************-->
    	<youi:func name = "func_grid_changeStatues">
        var gridElement = $elem('grid_reservationRecord',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
        var recordStatus = selectedRecord.recordStatus;
        var formCancel = $elem('form_reservationRecordChange',pageId);

        if(recordStatus == '01'){//01:已预约
            formCancel.form('fillRecord',selectedRecord).form('open');

        }else if(recordStatus == '02'){//02:已授理
          alert("该数据已经受理！");
        }else{
            alert("该状态下不能进行受理");

        }
    </youi:func>
    
	<!--**********************************页面函数End:将已预约的记录进行授理，变更为已授理状态，并刷新页面********************************-->
	
	 <!--**********************************页面函数Start:受理成功后，关闭页面并刷新父页面********************************-->
	<youi:func name = "form_reservationRecordChange_afterSubmit">
        var formloanApp = $elem('form_reservationRecordChange',pageId);
		formloanApp.form('close');
        alert("受理成功");
		$elem('grid_reservationRecord',pageId).grid('pReload');
     </youi:func>
    <!--**********************************页面函数End:受理成功后，关闭页面并刷新父页面********************************-->
    
    
	 <!--**********************************页面函数Start:取消预约并刷新父页面********************************-->
	<youi:func name = "func_grid_cancelReservation">
        var gridElement = $elem('grid_reservationRecord',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
  		var recordId=selectedRecord.recordId;
        var recordStatus = selectedRecord.recordStatus;
        if(recordStatus == '01'){//01:待受理
             $.youi.ajaxUtil.ajax({
				url:'/esb/web/reservationRecordManager/cancelReservation.json',
				data:{recordId:recordId},
				success:function(result){
					alert("预约成功取消");
                    $elem('grid_reservationRecord',pageId).grid('pReload');
                  } 
            })
        }else{
            alert("该状态不能进行取消操作");

        }
     </youi:func>
    <!--**********************************页面函数End:取消预约并刷新父页面********************************-->
</youi:page>