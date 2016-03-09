<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:subpage caption="新增类别" height="100" width="780"
		subpageId="addType"
		src="page/commonCenter.EnterpriceTypeManager.etypeEnterprisetype/addEnterprisetype.html?etypeEnterprisetype.enTypeId={pruenTypeId}"
		formAction="esb/web/etypeEnterprisetypeManager/saveEtypeEnterprisetype.json">
	</youi:subpage>

	<youi:tree styleClass="page-height col-sm-2 youi-bgcolor"
		id="tree_etypeEnterprisetype" dataFormId="form_etypeEnterprisetype"
		idAttr="enTypeId" pidAttr="etypeEnterprisetype.enTypeId"
		textAttr="enTypeName" tree="${enetrTree}"></youi:tree>

	<youi:form styleClass="page-height col-sm-10" caption="企业行业类别"
		id="form_etypeEnterprisetype" panel="false"
		action="esb/web/etypeEnterprisetypeManager/saveEtypeEnterprisetype.json"
		findAction="esb/web/etypeEnterprisetypeManager/getEtypeEnterprisetype.json"
		idKeys="enTypeId" submit="保存类型" reset="NOT"
		removeAction="esb/web/etypeEnterprisetypeManager/removeEtypeEnterprisetype.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden styleClass="field-parent"
				property="etypeEnterprisetype.enTypeId" />
			<youi:fieldHidden property="enTypeId" caption="类别ID" />
			<youi:fieldText width="120" styleClass="autoAlign"
				property="enTypeName" caption="类别名称" notNull="true" />
			<youi:fieldLabel styleClass="autoAlign"
				property="etypeEnterprisetype.genreName" caption="上级类别" />
		</youi:fieldLayout>
		<youi:button icon="add" name="addType" caption="新增类型" />
	</youi:form>

	<youi:func name="func_form_addType">
		var enTypeName = $elem('form_etypeEnterprisetype',pageId).form('fieldValue','enTypeName');
		var enTypeId = $elem('form_etypeEnterprisetype',pageId).form('fieldValue','enTypeId');
		var typeTree = $elem('tree_etypeEnterprisetype',pageId);
		var selectedNode = typeTree.tree('getSelected');
		if(selectedNode&&selectedNode.hasClass('root')){
			enTypeId='';
		}
		$elem('subpage_addType',pageId).subpage('open',{pruenTypeId:enTypeId},null,{pruenTypeId:enTypeId});
	</youi:func>

	<!--**********************************页面函数Start********************************-->
	<youi:func name="subpage_addType_afterSubmit" params="results">
		if(results&&results.record){
			//增加树节点
			var enetrTree = $elem('tree_etypeEnterprisetype',pageId),
				record = results.record,
				relTreeNode;
			if(!record.etypeEnterprisetype){
				relTreeNode = enetrTree.find('li.treeNode:first');
			}else{
				relTreeNode = enetrTree.find('li.treeNode#'+record.etypeEnterprisetype.enTypeId);
			}
			enetrTree.tree('addNode',relTreeNode,record.enTypeId,record.enTypeName);
			$(this).form('close');
		}
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>