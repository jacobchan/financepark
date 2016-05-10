<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

 <youi:page>
 	<youi:subpage caption="新增" subpageId="creater"
		 src="/flow/{processDefinitionId}.html"
		 formAction="workflow/run/start.json"
		 width="600" height="150">
	</youi:subpage>

	<youi:subpage caption="修改" subpageId="edit"
		src="/flow/taskform/{taskId}.html?taskId={taskId}"
		formAction="workflow/run/completeTask.json"
		width="600" height="150">
	</youi:subpage>	
	
	<youi:subpage caption="处理" subpageId="process"
		src="/flow/taskform/{taskId}.html?taskId={taskId}"
		formAction="workflow/run/completeTask.json"
		width="600" height="150">
	</youi:subpage>
	
	<youi:grid id="grid_flowdOrder" idKeys="processDefinitionId,id,processInstanceId" caption="订单生成"  panel="false"
				src="workflow/run/getPagerTasks.json"
				edit="NOT" remove="NOT" showCheckbox="true"
				add="NOT">
		<youi:fieldLayout prefix="search" labelWidths="100,100">
			<youi:fieldText property="params.processDefinitionId"  caption="流程实例" defaultValue=""/>
			<youi:fieldText property="params.status"  caption="状态" defaultValue="01"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="params.orderName"  caption="订单名称" width="15%"/>
		<youi:gridCol property="params.status"  caption="状态" width="15%" align="center"/>
		<youi:gridCol property="params.orderContent"  caption="订单内容" width="40%"/>
		<youi:gridCol property="params.createUser"  caption="创建人" width="15%"/>
		<youi:gridCol property="params.createDate"  caption="创建时间" width="15%"/>
		

		<youi:button name="adder" icon="addRecord" active="0" caption="新建"/>
		<youi:button name="editer" icon="edit" active="1" caption="修改"/>
		<youi:button name="process" icon="addRecord" active="1" caption="处理"/>

	</youi:grid>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_process" params="record">//
		//id  ---taskId 

		var select = $elem('grid_flowdOrder',pageId).grid("getSelectedRecord");			
		alert(select.id);
//		alert(select['processInstanceId']);
        var subpageElem = $elem('subpage_process',pageId);
		subpageElem.subpage('open',{taskId:select.id,processDefinitionId:'floworder'},null,{processDefinitionId:'floworder',taskId:select.id});
	</youi:func>
	
	<youi:func name="subpage_process_afterSubmit">
		$elem('subpage_process',pageId).subpage('close');
		$elem('grid_flowdOrder',pageId).grid('pReload');
	</youi:func>
	
	<youi:func name="func_grid_adder">//新建
		$elem('subpage_creater',pageId).subpage('open',{processDefinitionId:'floworder'},null,{processDefinitionId:'floworder'});
	</youi:func>
	
	<youi:func name="subpage_creater_afterSubmit">
		$elem('subpage_creater',pageId).subpage('close');
		$elem('grid_flowdOrder',pageId).grid('pReload');
	</youi:func>
	
	<youi:func name="func_grid_editer">
		var select = $elem('grid_flowdOrder',pageId).grid("getSelectedRecord");			
        var subpageElem = $elem('subpage_edit',pageId);
		subpageElem.subpage('open',{taskId:select.id,processDefinitionId:'floworder'},null,{processDefinitionId:'floworder',taskId:select.id});	
	</youi:func>
	
	<youi:func name="subpage_edit_afterSubmit">
		$elem('subpage_edit',pageId).subpage('close');
		$elem('grid_flowdOrder',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>