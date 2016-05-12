<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerEntrec" idKeys="entrecId,propertyservicemanagerEntering.enteringId" caption="入驻服务办理预约记录表列表"  panel="false"
				src="esb/web/propertyservicemanagerEntrecManager/getPagerPropertyservicemanagerEntrecs.json" dataFormId="form_propertyservicemanagerEntrec"
				editSrc="esb/web/propertyservicemanagerEntrecManager/getPropertyservicemanagerEntrec.json" add="NOT" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerEntrecManager/removePropertyservicemanagerEntrec.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="enteringName"  caption="入驻申请人" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<%-- <youi:fieldText property="enteringTelephone"  caption="入驻联系电话"/> --%>
			<youi:fieldSelect property="enterrecStatus"  caption="预约记录状态" convert="enterrecStatus"/>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:button name="cancelReservation" caption="取消预约" icon="edit" active="1"></youi:button> 
		<youi:button name="changeStatues" caption="预约受理" icon="edit" active="1"></youi:button> 
		<youi:gridCol property="enterrecCode"  caption="入驻受理编号" width="20%" align="center"/>
		<youi:gridCol property="enteringName"  caption="入驻申请人" width="10%" align="center"/>
	    <youi:gridCol property="enteringTelephone"  caption="入驻联系电话" width="15%" align="center"/>

		<youi:gridCol property="propertyservicemanagerEntering.enteringTime"  caption="预约时间段" width="20%" convert="enteringTime" align="center"/>
		<youi:gridCol property="enterrecStatus"  caption="预约记录状态" convert="enterrecStatus" width="15%" align="center"/>
		<youi:gridCol property="enteringType"  caption="申请类型" convert="enteringType" width="15%" align="center"/>
		<youi:gridCol property="propertyservicemanagerEntering.enteringDate"  caption="预约时间日期" width="20%" align="center" orderBy="desc"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="查看详情"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻服务办理预约记录表编辑 -->
	<youi:form dialog="true" caption="入驻服务办理预约记录表" id="form_propertyservicemanagerEntrec" action="esb/web/propertyservicemanagerEntrecManager/savePropertyservicemanagerEntrec.json">
		<youi:fieldLayout prefix="record" labelWidths="90,100">
			<youi:fieldLabel property="enteringName"  caption="入驻申请人"/>
			 <youi:fieldLabel property="enteringTelephone"  caption="入驻联系电话"/>
			 <youi:fieldHidden property="memberId"  caption="会员用户ID"/>
			  <youi:fieldHidden property="enterrecCode"  caption="编号"/>
			<youi:fieldHidden property="entrecId"  caption="入驻预约记录ID"/>
			<youi:fieldHidden property="enteringType"  caption="申请类型"/>
			<youi:fieldHidden property="propertyservicemanagerEntering.enteringId"  caption="预约记录ID"/>
			<youi:fieldLabel property="propertyservicemanagerEntering.enteringTime"  caption="预约时间段" convert="enteringTime"/>
			<youi:fieldLabel property="propertyservicemanagerEntering.enteringDate"  caption="预约时间日期" />
			<youi:fieldLabel property="enterrecStatus"  caption="预约记录状态" convert="enterrecStatus"/> 
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start:选择预约记录ID,将预约记录表里的预约时间段和预约日期带出来********************************-->
	<youi:func name = "record_propertyservicemanagerEntering_enteringId_change">
      		var enteringId = $('#P_'+pageId+'_record_propertyservicemanagerEntering_enteringId').fieldValue();
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerEnteringManager/getPropertyservicemanagerEntering.json',
				data:{enteringId:enteringId},
				success:function(result){
					var record = result.record;
                    $('#P_'+pageId+'_record_enteringTime').fieldValue(record.enteringTime);
					$('#P_'+pageId+'_record_enteringDate').fieldValue(record.enteringDate);
                  } 
            })

    </youi:func>
    <!--**********************************页面函数End:选择预约记录ID,将预约记录表里的预约时间段和预约日期带出来********************************-->
    
    <!--**********************************页面函数Start:选择入驻申请人,将会员表里的会员电话号码信息带出来********************************-->
	<youi:func name = "record_enteringName_change">
      		var memberId = $('#P_'+pageId+'_record_enteringName').fieldValue();
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/memberInformationManager/getMemberInformation.json',
				data:{memberId:memberId},
				success:function(result){
					var record = result.record;
                     $('#P_'+pageId+'_record_enteringTelephone').fieldValue(record.memberPhoneNumber);
                  } 
            })

    </youi:func>
    <!--**********************************页面函数End:选择入驻申请人,将会员表里的会员电话号码信息带出来********************************-->
    
    <!--**********************************页面函数Start:将已预约的记录进行授理，变更为已授理状态，并刷新页面********************************-->
    	<youi:func name = "func_grid_changeStatues">
        var gridElement = $elem('grid_propertyservicemanagerEntrec',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
      	var entrecId = selectedRecord.entrecId;
        var enterrecStatus = selectedRecord.enterrecStatus;
        var enteringType= selectedRecord.enteringType;
        if(enterrecStatus == '01'){//01:已预约
                 $.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerEntrecManager/enterApplication.json',
				data:{entrecId:entrecId,enteringType:enteringType},
				success:function(result){
					alert("受理成功");
                    $elem('grid_propertyservicemanagerEntrec',pageId).grid('pReload');
                  } 
            })

        }else if(enterrecStatus == '02'){//02:已授理
          alert("已受理");
        }else{
            alert("该状态下不能进行授理");

        }
    </youi:func>
	<!--**********************************页面函数End:将已预约的记录进行授理，变更为已授理状态，并刷新页面********************************-->
	
	
	 <!--**********************************页面函数Start:取消预约并刷新父页面********************************-->
	<youi:func name = "func_grid_cancelReservation">
        var gridElement = $elem('grid_propertyservicemanagerEntrec',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
  		var entrecId=selectedRecord.entrecId;
        var enterrecStatus = selectedRecord.enterrecStatus;
        if(enterrecStatus == '01'){//01:待受理
             $.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerEntrecManager/cancelReservation.json',
				data:{entrecId:entrecId},
				success:function(result){
					alert("预约成功取消");
                    $elem('grid_propertyservicemanagerEntrec',pageId).grid('pReload');
                  } 
            })
        }else{
            alert("该状态不能进行取消操作");

        }
     </youi:func>
    <!--**********************************页面函数End:取消预约并刷新父页面********************************-->
</youi:page>