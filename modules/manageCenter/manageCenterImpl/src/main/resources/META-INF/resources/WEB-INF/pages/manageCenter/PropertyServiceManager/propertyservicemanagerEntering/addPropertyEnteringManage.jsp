<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

   <!-- form-可办理预约记录增加 -->
		<youi:grid id="grid_entering" idKeys="enteringId" caption="可办理预约记录增加"  panel="false" scrollHeight="240"
				submit="NOT" reset="NOT" usePager="false" editable="true" load="false">
		<youi:fieldLayout prefix="record_sFpro">
		<youi:fieldHidden property="enteringId"  caption="派工单Id"/>
		</youi:fieldLayout>
		<youi:gridCol editor="fieldCalendar" property="enteringDate"  caption="预约时间日期" width="50%" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
		<youi:gridCol editor="fieldText"  property="enteringSum"  caption="预约总量" width="50%"/>
		<youi:button name="chargeSubmit" caption="提交"></youi:button>
	</youi:grid>
	
	<!--**********************************页面函数********************************-->
	<!-- 初始化页面数据 -->
	<youi:func name="subpage_init" params="record">
		$elem('grid_entering',pageId).grid('pReload');
	</youi:func>
	<!-- 批量提交维修单 -->
	<youi:func name="func_grid_chargeSubmit" >
		var enteringId = $elem('record_sFpro_enteringId',pageId).fieldValue();
		var records = $elem('grid_entering',pageId).grid('getRecords');
		var submitRecord = {'records':records};
		var fieldValues = $.youi.recordUtils.recordToParameters(submitRecord);
		var params = '';
		for(var i=0;i<fieldValues.length;i++){
			if($.youi.stringUtils.notEmpty(fieldValues[i].value)){
				params = params+$.youi.parameterUtils.propertyParameter(fieldValues[i].property,fieldValues[i].value)+'&';
			}
		}
		params = params;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/propertyservicemanagerEnteringManager/saveListEntering.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("添加成功!");
				$elem('grid_entering',pageId).parents('.youi-subpage').subpage('close');
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
	
</youi:page>