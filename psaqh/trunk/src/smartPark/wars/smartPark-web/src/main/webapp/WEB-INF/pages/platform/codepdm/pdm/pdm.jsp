<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page savable="true">

	<youi:subpage formAction="esb/web/pdmManager/pdmImport.json" formSubmit="开始导入"
		src="page/platform.codepdm.pdm/pdmImport.html?timestamp={timestamp}" 
		subpageId="pdmImport" height="320" caption="PDM文件导入">
	</youi:subpage>
	
	<youi:ajaxUrl name="workspaceModelUrl" src="esb/web/pdmManager/getPdmWorkspaceTree.json"/>
	<youi:ajaxUrl name="moduleUrl" src="esb/web/pdmManager/getPdmModuleTreeNodes.json"/>
	<youi:ajaxUrl name="moduleGraphicsUrl" src="esb/web/pdmManager/getPdmModuleGraphics.json"/>
	<youi:ajaxUrl name="entityColumnsUrl" src="esb/web/pdmManager/getPdmEntityColumnTreeNodes.json"/>
	<youi:ajaxUrl name="savePdmUrl" src="esb/web/pdmManager/savePdm.json"/>
	<youi:ajaxUrl name="saveEntityUrl" src="esb/web/pdmEntityManager/savePdmEntity.json"/>
	<youi:ajaxUrl name="getEntityUrl" src="esb/web/pdmEntityManager/getPdmEntity.json"/>
	<youi:ajaxUrl name="removeEntityUrl" src="esb/web/pdmEntityManager/removePdmEntity.json"/>
	
	<div class="comp-toolbar page-width"></div>
	
	<youi:tree styleClass="comp-tree page-height col-sm-2" xmenu="xmenu_tree" script="false">
	
	</youi:tree>
	<div id="flow" class="comp-flow page-height col-sm-10">
			
	</div>
	<div class="comp-palette popover">palette</div>
	
	<youi:xmenu id="xmenu_tree" popup="true">
		<youi:xmenuItem caption="编辑{0}" name="edit"></youi:xmenuItem>
		<youi:xmenuItem caption="删除{0}" name="remove"></youi:xmenuItem>
	</youi:xmenu>
	
	<youi:form width="1000" id="form_entity" dialog="true" caption="实体编辑" action="esb/web/pdmEntityManager/savePdmEntity.json">
		<youi:tabs id="tabs_entity">
			<youi:tabItem caption="基本信息" id="tab_base">
				<youi:fieldLayout prefix="record" columns="1">
					<youi:fieldHidden property="entityId"  caption="实体ID"/>
					<youi:fieldHidden property="codeModule.moduleId"  caption="模块ID"/>
					<youi:fieldLabel property="codeModule.moduleCaption"  caption="模块"/>
					<youi:fieldText property="entityName" notNull="true" caption="实体名"/>
					<youi:fieldText property="entityCode" notNull="true"  caption="实体编码"/>
					<youi:fieldText property="entityCaption" notNull="true"  caption="实体描述"/>
					<youi:fieldText property="tableName" notNull="true" caption="表名"/>
				</youi:fieldLayout>
			</youi:tabItem>
			<youi:tabItem caption="实体属性" id="tab_entity_attrs">
				<youi:fieldLayout styleClass="hideLabel" prefix="record" columns="1" labelWidths="0">
					<youi:fieldGrid property="entityAttrs">
						<youi:grid scrollHeight="240" showNum="true" id="grid_pdmEntityAttr" idKeys="entityAttrId" caption="实体属性列表" editable="true" panel="false">
							<youi:gridCol width="15%" editor="fieldText" property="entityAttrName"  caption="属性名"/>
							<youi:gridCol width="17%" editor="fieldText" property="entityAttrCaption"  caption="属性描述"/>
							<youi:gridCol width="15%" editor="fieldText" property="tableColumn"  caption="数据库列"/>
							<youi:gridCol width="13%" editor="fieldSelect" convert="pdmDataType" property="entityDataType"  caption="数据类型"/>
							<youi:gridCol width="5%" editor="fieldText" property="length"  caption="长度"/>
							<youi:gridCol width="5%" editor="fieldText" property="dataPrecision"  caption="精度"/>
							<youi:gridCol width="5%" type="selection" property="coll"  caption="Arr"/>
							<youi:gridCol width="5%" type="selection" property="mandatory"  caption="M"/>
							<youi:gridCol width="5%" type="selection" property="primary"  caption="P"/>
							<youi:gridCol width="15%" editor="fieldText" property="domain"  caption="Domain"/>
						</youi:grid>
					</youi:fieldGrid>
				</youi:fieldLayout>
			</youi:tabItem>
		</youi:tabs>
	</youi:form>
	<!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	
	<!--**********************************页面函数********************************-->
	
	<youi:func name="init" urls="workspaceModelUrl,moduleUrl,moduleGraphicsUrl,savePdmUrl,saveEntityUrl,entityColumnsUrl,getEntityUrl,removeEntityUrl">
		$('.youi-page#P_'+pageId).dbdesigner({
			entityFormId:'P_'+pageId+'_form_entity',
			pdmImportSubpageId:'P_'+pageId+'_subpage_pdmImport',
			urls:funcUrls
		});
	</youi:func>
	
	<youi:func name="subpage_pdmImport_afterSubmit">
		$('.youi-page#P_'+pageId).dbdesigner('reloadWorkspaceTree');
	</youi:func>
</youi:page>