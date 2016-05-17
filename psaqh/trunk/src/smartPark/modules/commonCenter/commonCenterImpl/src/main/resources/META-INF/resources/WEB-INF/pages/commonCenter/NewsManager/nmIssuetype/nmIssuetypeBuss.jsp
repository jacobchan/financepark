<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="发布类型列表" height="110" width="780" subpageId="addOrderType"
		src="page/commonCenter.NewsManager.nmIssuetype/nmIssuetypeAdd.html?parentIssueTypeId={parentIssueTypeId}"
		formAction="esb/web/nmIssuetypeManager/saveNmIssuetype.json">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<!--**********************************页面内容********************************-->
	<youi:tree styleClass="page-height col-sm-2 youi-bgcolor" id="tree_orderType" dataFormId="form_orderType" idAttr="issueTypeId"
					pidAttr="issueTypeParentCaption" textAttr="issueTypeCaption" tree="${issueTypeTree}"></youi:tree>
	
	<youi:form styleClass="page-height col-sm-10" caption="v" id="form_orderType" panel="false"
		action="esb/web/nmIssuetypeManager/saveNmIssuetype.json" findAction="esb/web/nmIssuetypeManager/getNmIssuetype.json"
		idKeys="issueTypeId" submit="保存发布类型" reset="NOT" 
		removeAction="esb/web/nmIssuetypeManager/removeNmIssuetype.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden styleClass="field-parent" property="parentIssueTypeId" caption="发布类型上级"/>
			<youi:fieldHidden  property="issueTypeId" caption="发布类型ID" />
			<youi:fieldText width="120" styleClass="autoAlign" property="issueTypeCaption" caption="发布类型描述" notNull="true"/>
			<youi:fieldLabel width="120" styleClass="autoAlign" property="issueTypeCode" caption="发布类型编码"/>
			<youi:fieldLabel  styleClass="autoAlign"  property="issueTypeParentCaption" caption="上级发布类型" />
		</youi:fieldLayout>
		<youi:button name="addOrderType" caption="新增发布类型" />
	</youi:form>
	<!--**********************************页面内容********************************-->
	<!--**********************************页面函数********************************-->

	<youi:func name="func_form_addOrderType">
		var issueTypeCaption = $elem('form_orderType',pageId).form('fieldValue','issueTypeCaption');
		var issueTypeId = $elem('form_orderType',pageId).form('fieldValue','issueTypeId');
		var genreTree = $elem('tree_orderType',pageId);
		var selectedNode = genreTree.tree('getSelected');
		if(selectedNode&&selectedNode.hasClass('root')){
			issueTypeId='';
		}
		$elem('subpage_addOrderType',pageId).subpage('open',{parentIssueTypeId:issueTypeId},null,{parentIssueTypeId:issueTypeId});
	</youi:func>

	<youi:func name="subpage_addOrderType_afterSubmit" params="results">
		if(results&&results.record){
			//增加树节点
			var genreTree = $elem('tree_orderType',pageId),
				record = results.record,
				relTreeNode;
			if(!record.parentIssueTypeId){
				relTreeNode = genreTree.find('li.treeNode:first');
			}else{
				relTreeNode = genreTree.find('li.treeNode#'+record.parentIssueTypeId);
			}
			genreTree.tree('addNode',relTreeNode,record.issueTypeId,record.issueTypeCaption);
			$(this).form('close');
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>