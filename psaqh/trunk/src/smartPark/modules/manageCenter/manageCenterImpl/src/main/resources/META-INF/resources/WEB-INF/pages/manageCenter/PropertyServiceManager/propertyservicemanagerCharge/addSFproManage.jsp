<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- form-物业收费登记表编辑 -->
	<youi:form dialog="false" caption="物业收费登记表" id="form_propertyservicemanagerCharge" submit="NOT"
		action="esb/web/propertyservicemanagerChargeManager/savePropertyservicemanagerCharge.json">
		<youi:fieldLayout prefix="record_sFpro" labelWidths="120,120">
			<youi:fieldHidden property="chargeId"  caption="收费登记序列"/>
			<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="bbmRoom.roomId"  caption="单元编号" onlyLeaf="true"/>
			<youi:fieldCalendar property="chargeCreatetime"  caption="登记日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldCalendar property="chargeBedate"  caption="起始日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldCalendar property="chargeEndate"  caption="截止日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:button name="chargeSubmit" caption="提交"></youi:button>
		
	</youi:form>
	<youi:grid id="grid_sFproManage" idKeys="sfproId" caption="物业收费项目列表"  panel="true" scrollHeight="240"
				src="esb/web/propertyservicemanagerSfproManager/getPagerPropertyservicemanagerSfpros.json" dataFormId="form_sFproManage"
				showCheckbox="true" 
				submit="NOT" reset="NOT" usePager="false" editable="true">
		<youi:fieldLayout>
			<youi:fieldHidden property="propertyservicemanagerCharge.chargeId"  caption="物业收费登记序列"/>
		</youi:fieldLayout>
		<youi:gridCol editor="fieldSelect" width="30%" property="sfproName" convert="sfproName" caption="收费项目名称"/>
		<youi:gridCol editor="fieldText" width="70%" property="sfproAmount"  caption="项目金额"/>
	</youi:grid>
	
	<!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	<youi:func name="func_form_chargeSubmit" >
		var roomId = $elem('record_sFpro_bbmRoom_roomId',pageId).fieldValue();
		var chargeId = $elem('record_sFpro_chargeId',pageId).fieldValue();
		var chargeIsbool = '1';
		var chargeCreatetime = $elem('record_sFpro_chargeCreatetime',pageId).fieldValue();
		var chargeBedate = $elem('record_sFpro_chargeBedate',pageId).fieldValue();
		var chargeEndate = $elem('record_sFpro_chargeEndate',pageId).fieldValue();
		var records = $elem('grid_sFproManage',pageId).grid('getRecords');
		var submitRecord = {'records':records};

		var fieldValues = $.youi.recordUtils.recordToParameters(submitRecord);
		var params = '';
		for(var i=0;i<fieldValues.length;i++){
			if($.youi.stringUtils.notEmpty(fieldValues[i].value)){
				params = params+$.youi.parameterUtils.propertyParameter(fieldValues[i].property,fieldValues[i].value)+'&';
			}
		}
		params = params+'chargeId='+chargeId+'&'+'chargeIsbool='+chargeIsbool+'&'+'chargeCreatetime='+chargeCreatetime+'&'+
		'chargeBedate='+chargeBedate+'&'+'chargeEndate='+chargeEndate+'&'+'roomId='+roomId;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/propertyservicemanagerSfproManager/saveChargeSfpro.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("添加成功!");
				$elem('form_propertyservicemanagerCharge',pageId).parents('.youi-subpage').subpage('close');
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>