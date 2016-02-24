<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerEntrec" idKeys="entrecId" caption="入驻服务办理预约记录表列表"  panel="false"
				src="esb/web/propertyservicemanagerEntrecManager/getPagerPropertyservicemanagerEntrecs.json" dataFormId="form_propertyservicemanagerEntrec"
				editSrc="esb/web/propertyservicemanagerEntrecManager/getPropertyservicemanagerEntrec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerEntrecManager/removePropertyservicemanagerEntrec.json">
		<youi:fieldLayout labelWidths="90,100">
			<youi:fieldText property="enteringName"  caption="入驻申请人"/>
			<youi:fieldText property="enteringTelephone"  caption="入驻联系电话"/>

			<youi:fieldSelect property="enteringTime"  caption="预约时间段" convert="enteringTime"/>
			<youi:fieldSelect property="enterrecStatus"  caption="预约记录状态" convert="enterrecStatus"/>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:button name="changeStatues" caption="授理" active="1" ></youi:button> 
		<youi:gridCol property="enteringName"  caption="入驻申请人" width="100"/>
		<%-- <youi:gridCol property="enteringTelephone"  caption="入驻联系电话" width="100"/> --%>

		<youi:gridCol property="enteringTime"  caption="预约时间段" width="150" convert="enteringTime"/>
		<youi:gridCol property="enterrecStatus"  caption="预约记录状态" convert="enterrecStatus" width="100"/>
		<youi:gridCol property="enteringDate"  caption="预约时间日期" width="120"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻服务办理预约记录表编辑 -->
	<youi:form dialog="true" caption="入驻服务办理预约记录表" id="form_propertyservicemanagerEntrec" action="esb/web/propertyservicemanagerEntrecManager/savePropertyservicemanagerEntrec.json">
		<youi:fieldLayout prefix="record" labelWidths="90,100">
			<youi:fieldSelect property="enteringName"  caption="入驻申请人" notNull="true" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberName" show="memberName"/>
			<%-- <youi:fieldText property="enteringTelephone"  caption="入驻联系电话" expression="^1[3|4|5|8|9]{1}[0-9]{9,9}$" expressionMessage="请填写正确的手机号码" notNull="true"/>
			 --%><youi:fieldHidden property="memberId"  caption="会员用户ID"/>
			<youi:fieldSelect property="propertyservicemanagerEntering.enteringId"  caption="预约记录ID" src="esb/web/propertyservicemanagerEnteringManager/getPropertyservicemanagerEnteringsByStatus.json" code="enteringId" show="enteringId" notNull="true"/>
			<youi:fieldHidden property="entrecId"  caption="入驻预约记录ID"/>
			<youi:fieldSelect property="enterrecStatus"  caption="预约记录状态" convert="enterrecStatus" notNull="true"/>
			<youi:fieldLabel property="enteringTime"  caption="预约时间段" convert="enteringTime"/>
			<youi:fieldLabel property="enteringDate"  caption="预约时间日期" />
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
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
    	<youi:func name = "func_grid_changeStatues">
        var gridElement = $elem('grid_propertyservicemanagerEntrec',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
      	var entrecId = selectedRecord.entrecId;
        var enterrecStatus = selectedRecord.enterrecStatus;
        if(enterrecStatus == '01'){
             $.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerEntrecManager/enterApplication.json',
				data:{entrecId:entrecId},
				success:function(result){
					alert("授理成功");
                    $elem('grid_propertyservicemanagerEntrec',pageId).grid('pReload');
                  } 
            })
        }else{
            alert("已预约状态才能进行授理");

        }
			

    </youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>