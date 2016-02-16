<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_codeModule" idKeys="moduleId" caption="选择导出的模块" panel="true" scrollHeight="160"
				src="esb/web/codeModuleManager/getCodeModules.json"
				showCheckbox="true" add="NOT" edit="NOT" remove="NOT"
				submit="NOT" reset="NOT" usePager="false" editable="false">
		<youi:fieldLayout>
			<youi:fieldHidden property="codeProject.projectId"  caption="项目代码"/>
		</youi:fieldLayout>
		<youi:gridCol width="30%" property="moduleName"  caption="模块名"/>
		<youi:gridCol width="70%" property="moduleCaption"  caption="模块描述"/>
	</youi:grid>
	
	<youi:grid id="grid_codeModuleWeb" idKeys="webModuleId" caption="选择导出的WEB模块" panel="true" scrollHeight="160" 
				src="esb/web/codeModuleWebManager/getCodeModuleWebs.json" 
				showCheckbox="true" add="NOT" edit="NOT" remove="NOT"
				submit="NOT" reset="NOT" save="保存WEB模块" usePager="false" editable="false">
		<youi:fieldLayout>
			<youi:fieldHidden property="codeProject.projectId"  caption="项目代码"/>
		</youi:fieldLayout>
		<youi:gridCol width="20%" property="webModuleName"  caption="WEB模块名"/>
		<youi:gridCol width="20%" property="webPort"  caption="WEB端口"/>
		<youi:gridCol width="60%" property="webModuleCaption"  caption="WEB模块描述"/>
	</youi:grid>
	
	<!--**********************************页面函数********************************-->
	<youi:func name="subpage_submit_record">
		
		var gridElement = $elem('grid_codeModule',pageId),//
			gridWebElement = $elem('grid_codeModuleWeb',pageId);
		return {
			'codeModules':gridElement.grid('getRecords',true),
			'codeModuleWebs':gridWebElement.grid('getRecords',true)};
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>