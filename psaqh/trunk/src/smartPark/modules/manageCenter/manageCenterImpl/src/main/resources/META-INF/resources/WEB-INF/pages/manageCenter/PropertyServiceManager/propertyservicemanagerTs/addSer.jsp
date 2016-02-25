<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<youi:grid id="grid_proSer" idKeys="serId" caption="维修费用清单"  panel="false" scrollHeight="240"
				src="esb/web/propertyservicemanagerSerManager/getPagerPropertyservicemanagerSers.json" dataFormId="form_sFproManage"
				showCheckbox="true" 
				submit="NOT" reset="NOT" usePager="false" editable="true" load="false">
		<youi:fieldLayout prefix="recordSer">
			<youi:fieldHidden property="propertyservicemanagerTs.tsId"  caption="派工单Id"/>
		</youi:fieldLayout>
		
		<youi:gridCol editor="fieldSelect" property="serName"  caption="材料名称" width="35%" convert="ser_name"/>
		<youi:gridCol editor="fieldSelect"  property="serType"  caption="材料类别" width="35%" convert="ser_type"/>
		<youi:gridCol editor="fieldText" property="serPrice"  caption="材料价格" width="30%"/>
		
		<youi:button name="serSubmit" caption="提交"></youi:button>
	</youi:grid>
	
	<!--**********************************页面函数********************************-->
	<!-- 初始化页面数据 -->
	<youi:func name="subpage_init" params="record">
		$elem('recordSer_propertyservicemanagerTs_tsId',pageId).fieldValue(record.tsId);
		$elem('grid_proSer',pageId).grid('pReload');
	</youi:func>
	<!-- 批量提交维修单 -->
	<youi:func name="func_grid_serSubmit" >
		var tsId = $elem('recordSer_propertyservicemanagerTs_tsId',pageId).fieldValue();
		var records = $elem('grid_proSer',pageId).grid('getRecords');
		var submitRecord = {'records':records};
		var fieldValues = $.youi.recordUtils.recordToParameters(submitRecord);
		var params = '';
		for(var i=0;i<fieldValues.length;i++){
			if($.youi.stringUtils.notEmpty(fieldValues[i].value)){
				params = params+$.youi.parameterUtils.propertyParameter(fieldValues[i].property,fieldValues[i].value)+'&';
			}
		}
		params = params+'tsId='+tsId;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/propertyservicemanagerSerManager/saveListSer.json',
			data:params,
			success:function(result){
				var record = result.record;
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>