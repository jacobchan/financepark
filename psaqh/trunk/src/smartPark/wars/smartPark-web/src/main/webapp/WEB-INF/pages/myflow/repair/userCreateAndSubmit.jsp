<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

 <youi:page>
 	<youi:subpage caption="新增" subpageId="creater"
		 src="/flow/{processDefinitionId}.html?processDefinitionId={processDefinitionId}"
		 formAction="workflow/run/start.json"
		 formSubmit="确定"
		 width="600" height="150">
	</youi:subpage>

	<youi:subpage caption="修改" subpageId="edit"
		src="/flow/taskform/{taskId}.html?taskId={taskId}&processDefinitionId={processDefinitionId}"
		formAction="workflow/run/completeTask.json"
		formSubmit="确定"
		width="600" height="150">
	</youi:subpage>	
	
	<youi:grid id="grid_repairOrder" idKeys="processDefinitionId,id,processInstanceId" caption="订单申请"  panel="false"
				src="workflow/run/getPagerTasks.json"
				edit="NOT" remove="NOT" showCheckbox="true"
				add="NOT">
		<youi:fieldLayout prefix="search" labelWidths="100,100">
			<youi:fieldText property="params.processDefinitionId"  caption="流程实例" defaultValue=""/>
			<youi:fieldText property="params.status"  caption="状态" defaultValue="01"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="params.name"  caption="订单名称" width="10%"/>
		<youi:gridCol property="params.status"  caption="状态" width="10%" align="center" convert="repairStatus"/>
		<youi:gridCol property="params.content"  caption="订单内容" width="20%"/>
		<youi:gridCol property="params.describe"  caption="订单描述" width="20%"/>
		<youi:gridCol property="params.price"  caption="维修价格" width="10%"/>
		<youi:gridCol property="params.appraise"  caption="用户评价" width="10%"/>
		
		<youi:gridCol property="params.createUser"  caption="创建人" width="10%"/>
		<youi:gridCol property="params.createDate"  caption="创建时间" width="10%"/>

		<youi:button name="adder" icon="addRecord" active="0" caption="新建"/>
		<youi:button name="editer" icon="edit" active="1" caption="修改"/>
	</youi:grid>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_adder">//新建
		$elem('subpage_creater',pageId).subpage('open',{processDefinitionId:'repair'},null,{processDefinitionId:'repair'});
	</youi:func>
	
	<youi:func name="subpage_creater_afterSubmit">
		$elem('subpage_creater',pageId).subpage('close');
		$elem('grid_repairOrder',pageId).grid('pReload');
	</youi:func>
	
	<youi:func name="func_grid_editer">
		var select = $elem('grid_repairOrder',pageId).grid("getSelectedRecord");			
        var subpageElem = $elem('subpage_edit',pageId);
		subpageElem.subpage('open',{taskId:select.id,processDefinitionId:'repair'},null,{processDefinitionId:'repair',taskId:select.id});	
	</youi:func>
	
	<youi:func name="subpage_edit_afterSubmit">
		$elem('subpage_edit',pageId).subpage('close');
		$elem('grid_repairOrder',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>