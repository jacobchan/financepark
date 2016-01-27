<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_codeModule" idKeys="moduleId" caption="代码模块列表"  panel="false" scrollHeight="240"
				src="esb/web/codeModuleManager/getPagerCodeModules.json" dataFormId="form_codeModule"
				showCheckbox="true" 
				saveRowsSrcs="esb/web/codeModuleManager/saveProjectCodeModules.json"
				submit="NOT" reset="NOT" save="保存模块" usePager="false" editable="true">
		<youi:fieldLayout>
			<youi:fieldHidden property="codeProject.projectId"  caption="项目代码"/>
		</youi:fieldLayout>
		<youi:gridCol editor="fieldText" width="30%" property="moduleName"  caption="模块名"/>
		<youi:gridCol editor="fieldText" width="70%" property="moduleCaption"  caption="模块描述"/>
	</youi:grid>
	
	<!-- form-代码模块编辑 -->
	<youi:form dialog="true" caption="编辑代码模块" id="form_codeModule" action="esb/web/codeModuleManager/saveCodeModule.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="moduleId"  caption="模块ID"/>
			<youi:fieldText property="moduleCode"  caption="模块代码"/>
			<youi:fieldText property="moduleName"  caption="模块名"/>
			<youi:fieldText property="moduleCaption"  caption="模块描述"/>
		</youi:fieldLayout>
	</youi:form>
	
	<youi:grid id="grid_codeModuleWeb" idKeys="webModuleId" caption="WEB模块列表"  panel="false" scrollHeight="200" 
				src="esb/web/codeModuleWebManager/getCodeModuleWebs.json" dataFormId="form_codeModuleWeb"
				saveRowsSrcs="esb/web/codeModuleWebManager/saveProjectCodeModuleWebs.json"
				showCheckbox="true"
				submit="NOT" reset="NOT" save="保存WEB模块" usePager="false"  editable="true">
		<youi:fieldLayout>
			<youi:fieldHidden property="codeProject.projectId"  caption="项目代码"/>
		</youi:fieldLayout>
		
		<youi:gridCol editor="fieldText" width="20%" property="webModuleName"  caption="WEB模块名"/>
		<youi:gridCol editor="fieldText" width="20%" property="webPort"  caption="WEB端口"/>
		<youi:gridCol editor="fieldText" width="60%" property="webModuleCaption"  caption="WEB模块描述"/>
	</youi:grid>
	
	<!-- form-WEB模块编辑 -->
	<youi:form dialog="true" caption="编辑WEB模块" id="form_codeModuleWeb" action="esb/web/codeModuleWebManager/saveCodeModuleWeb.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="webModuleName"  caption="WEB模块名"/>
			<youi:fieldText property="webModuleCode"  caption="WEB模块编码"/>
			<youi:fieldText property="webPort"  caption="WEB端口"/>
			<youi:fieldText property="webModuleId"  caption="WEB模块ID"/>
			<youi:fieldText property="webModuleCaption"  caption="WEB模块描述"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	<youi:func name="grid_codeModule_col_button_edit" params="record,rowDoc">
		$(this).grid('openFormEdit','修改',rowDoc);
	</youi:func>
	
	<youi:func name="grid_codeModule_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	
	<!-- 行动作 -->
	<youi:func name="grid_codeModuleWeb_col_button_edit" params="record,rowDoc">
		$(this).grid('openFormEdit','修改',rowDoc);
	</youi:func>
	
	<youi:func name="grid_codeModuleWeb_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>