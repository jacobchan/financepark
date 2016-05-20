<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

 <youi:page>
 
 	<youi:subpage caption="填写报修单" subpageId="process"
		src="/flow/taskform/{taskId}.html"
		formAction="workflow/run/completeTask.json" formSubmit="提 交"
		width="600">
	</youi:subpage>
	
	<youi:grid id="grid_repairOrder" idKeys="processDefinitionId,id,formKey" caption="填写报修单"  panel="false"
				src="workflow/run/getPagerTasks.json"
				edit="NOT" remove="NOT" showCheckbox="true" pageSize="20"
				add="NOT">
		<youi:fieldLayout prefix="search" labelWidths="100,100">
			<youi:fieldHidden property="params.flowProcessId"  caption="流程实例" defaultValue="propertyrepair"/>
			<youi:fieldHidden property="params.bxStatus"  caption="流程类型" defaultValue="03"/>
			<youi:fieldText property="params.flowPersonId" caption="接单人" defaultValue="40288acf5396c93e015398864e570009"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="params.bxCode"  caption="报修编号" width="17%" align="center"/>
		<youi:gridCol property="params.bxType"  caption="报修类型" width="10%" align="center" />
		<youi:gridCol property="params.bxStatus"  caption="报修状态" width="10%" align="center"/>
		<youi:gridCol property="params.bxRemark"  caption="报修描述" width="19%" align="center"/>
		<youi:gridCol property="params.flowSuggestPg"  caption="派工备注" width="19%" align="center"/>
		<youi:gridCol property="params.bxAddress"  caption="报修地址" width="0%" align="center"/>
		<youi:gridCol property="params.createUsercaption"  caption="创建人" width="10%" align="center"/>
		<youi:gridCol property="createTime"  type="date" caption="创建时间" width="15%" align="center"/>
		
		<youi:button name="process" icon="addRecord" active="1" caption="填写报修单"/>
	</youi:grid>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_process">
		var select = $elem('grid_repairOrder',pageId).grid("getSelectedRecord");			
        var subpageElem = $elem('subpage_process',pageId);
		var flowSuggestPg = select['params.flowSuggestPg'];
		var bxCode = select['params.bxCode'];
		var bxType = select['params.bxType'];
		var bxRemark = select['params.bxRemark'];
		var bxAddress = select['params.bxAddress'];
		subpageElem.subpage('open',select,null,{taskId:select.id,subpagePrefix:select.id,
			bxCode:bxCode,bxType:bxType,bxRemark:bxRemark,bxAddress:bxAddress,flowSuggestPg:flowSuggestPg});
	</youi:func>
	
	<%-- <youi:func name="form_completeTask_afterSubmit">
		var gridElement = $elem('grid_repairOrder',pageId);
		gridElement.grid('pReload');
	</youi:func> --%>
	
	<%-- <youi:func name="subpage_process_beforeSubmit">
		var subpageElem = $elem('subpage_process',pageId);
		var aa = subpageElem.flowResultJg;
		var flowResultJg = $elem('subpage_process_recordab_flowResultJg',pageId).fieldValue();
		return false;
	</youi:func> --%>
	
	<youi:func name="subpage_process_afterSubmit">
		var gridElement = $elem('grid_repairOrder',pageId);
		var subpageElem = $elem('subpage_process',pageId);
		
		gridElement.grid('pReload');
		subpageElem.subpage('close');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>