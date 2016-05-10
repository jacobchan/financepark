<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

 <youi:page>
	
	<youi:subpage caption="修改" subpageId="process"
		src="flow/taskform/{taskId}.html?taskId={taskId}"
		formAction="myflow/run/completeTask.json"
		width="600" height="200">
	</youi:subpage>
	
	<youi:grid id="grid_flowdata" idKeys="processDefinitionId,id,processInstanceId" caption="流程数据"  panel="false"
				src="myflow/run/getPagerTasks.json" dataFormId="form_flowdata"
				edit="NOT" remove="NOT" showCheckbox="true"
				add="NOT">
		<youi:fieldLayout prefix="search" labelWidths="100,100">
			<youi:fieldText property="params.processDefinitionId"  caption="流程实例" defaultValue="myflow"/>
			<youi:fieldText property="params.status"  caption="状态" defaultValue="2"/>
		</youi:fieldLayout>
		
		<%-- <youi:gridCol property="id"  caption="ID" width="20%" align="center"/> --%>
		<youi:gridCol property="params.name"  caption="名称" width="40%"/>
		<youi:gridCol property="params.status"  caption="状态" width="40%" align="center"/>

		<%-- <youi:button name="adder" icon="addRecord" active="0" caption="新建"/> --%>
		<youi:button name="process" icon="addRecord" active="1" caption="处理"/>

	</youi:grid>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_process" params="record">//
		//id  ---taskId 
		var select = $elem('grid_flowdata',pageId).grid("getSelectedRecord");			
//		alert(select.id);

//		alert(select['processInstanceId']);
        var subpageElem = $elem('subpage_process',pageId);
		subpageElem.subpage('open',{taskId:select.id,processDefinitionId:'myflow'},null,{processDefinitionId:'myflow',taskId:select.id});
	</youi:func>
	
	<youi:func name="subpage_process_afterSubmit">
		$elem('subpage_process',pageId).subpage('close');
		$elem('grid_flowdata',pageId).grid('pReload');
	</youi:func>

	<!--**********************************页面函数End**********************************-->
</youi:page>