<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	
	<youi:subpage
		src="page/platform.codemng.codeProject/codeProjectModules.html?codeProject.projectId={projectId}" 
		subpageId="projectModules" height="600" caption="项目模块">
	</youi:subpage>
	
	<youi:subpage
		src="page/platform.codemng.codeProject/codeProjectExport.html?codeProject.projectId={projectId}" 
		formAction="esb/web/codeProjectManager/exportCodeProect.json"
		formSubmit="导出框架代码"
		subpageId="exportProject" height="600" caption="导出框架代码">
	</youi:subpage>

	<youi:grid id="grid_codeProject" idKeys="projectId" caption="项目列表"  panel="false" pageSize="2"
				src="esb/web/codeProjectManager/getPagerCodeProjects.json" dataFormId="form_codeProject"
				editSrc="esb/web/codeProjectManager/getCodeProject.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/codeProjectManager/removeCodeProject.json">
		<youi:fieldLayout>
			<youi:fieldText property="projectCodeName"  caption="项目名"/>
			<youi:fieldSelect property="projectType" emptyItemCaption="--全部--"  convert="codeProjectType" caption="项目类型">
				<youi:fieldOption caption="1111111111111" value="1111"></youi:fieldOption>
			</youi:fieldSelect>
		</youi:fieldLayout>
		<youi:gridCol width="20%" property="projectCodeName"  caption="项目名"/>
		<youi:gridCol width="15%" property="projectId"  caption="项目编码"/>
		<youi:gridCol width="20%" property="projectCaption"  caption="项目描述"/>
		<youi:gridCol width="10%" property="projectType"  convert="codeProjectType"  caption="项目类型"/>

		<youi:gridCol width="35%" property="svnUrl"  caption="项目SVN"/>
		
		<youi:button active="1" order="201" name="projectModules" caption="代码模块管理"/>
		<youi:button active="1" order="202" name="codeProjectMenus" caption="菜单模版定制" sysmenu="010200"/>
		<youi:button active="1" order="209" name="exportProject" caption="生成框架代码"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-项目编辑 -->
	<youi:form dialog="true" caption="项目" id="form_codeProject" action="esb/web/codeProjectManager/saveCodeProject.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="110">
			<youi:fieldHidden property="projectId"  caption="项目ID"/>
			<youi:fieldText property="projectCodeName"  caption="项目名"/>
			<youi:fieldLabel property="projectCode"  caption="项目编码"/>
			
			<youi:fieldText property="basePackage"  caption="包路径"/>
			<youi:fieldSelect property="projectType" emptyItemCaption="全部" convert="codeProjectType" caption="项目类型"/>
			
			<youi:fieldText property="projectCaption"  caption="项目描述" column="2"/>
			<youi:fieldText property="svnUrl"  caption="项目SVN"  column="2"/>
			<youi:fieldArea property="projectDetails"  caption="项目详细信息"  column="2"/>
			
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	<youi:func name="grid_codeProject_col_button_edit" params="record,rowDoc">
		$(this).grid('openFormEdit','修改',rowDoc);
	</youi:func>
	
	<youi:func name="grid_codeProject_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	
	<!-- grid按钮:打开项目模块窗口 -->
	<youi:func name="func_grid_projectModules">
		var gridElement = $elem('grid_codeProject',pageId),//
			subpageElement = $elem('subpage_projectModules',pageId),//
			selectedRecord = gridElement.grid('getSelectedRecord');
		//打开子页面
		subpageElement.subpage('open',selectedRecord,selectedRecord.projectCaption,selectedRecord);
	</youi:func>
	
	<!-- grid按钮:打开导出项目框架窗口 -->
	<youi:func name="func_grid_exportProject">
		var gridElement = $elem('grid_codeProject',pageId),//
			subpageElement = $elem('subpage_exportProject',pageId),//
			selectedRecord = gridElement.grid('getSelectedRecord');
		//打开子页面
		subpageElement.subpage('open',selectedRecord,selectedRecord.projectCaption,selectedRecord);
	</youi:func>
	
	<youi:func name="subpage_exportProject_afterSubmit" params="result">
		//通用的文件下载
		$.youi.fileUtils.download(result.record,function(flag){
			//alert(flag);
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>