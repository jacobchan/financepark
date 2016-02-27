<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="新增订单类型" height="110"
		width="780" subpageId="addOrderType"
		src="page/commonCenter.OrderManager.ordermanagerUserorder/orderTypeAdd.html?purchasingmanagerGenre.genreId={pruGenreId}"
		formAction="esb/web/purchasingmanagerGenreManager/savePurchasingmanagerGenre.json">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<!--**********************************页面内容********************************-->
	<youi:tree styleClass="page-height col-sm-2 youi-bgcolor" id="tree_orderType" dataFormId="form_orderType" idAttr="genreId"
					pidAttr="purchasingmanagerGenre.genreName" textAttr="genreName" tree="${orderTypeTree}"></youi:tree>
	
	<youi:form styleClass="page-height col-sm-10" caption="编辑订单类型" id="form_orderType" panel="false"
		action="esb/web/purchasingmanagerGenreManager/savePurchasingmanagerGenre.json" findAction="esb/web/purchasingmanagerGenreManager/getPurchasingmanagerGenre.json"
		idKeys="genreId" submit="保存订单类型" reset="NOT" >
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden styleClass="field-parent" property="purchasingmanagerGenre.genreId" />
			<youi:fieldHidden  property="genreId" caption="订单类型ID" />
			<youi:fieldText width="120" styleClass="autoAlign" property="genreName" caption="订单类型名称" notNull="true"/>
			<youi:fieldLabel width="120" styleClass="autoAlign" property="genreCode" caption="订单类型编码"/>
			<youi:fieldLabel  styleClass="autoAlign"  property="purchasingmanagerGenre.genreName" caption="上级订单类型" />
		</youi:fieldLayout>
		<youi:button name="addOrderType" caption="新增订单类型" />
	</youi:form>
	<!--**********************************页面内容********************************-->
	<!--**********************************页面函数********************************-->

	<youi:func name="func_form_addOrderType">
		var genreName = $elem('form_orderType',pageId).form('fieldValue','genreName');
		var genreId = $elem('form_orderType',pageId).form('fieldValue','genreId');
		var genreTree = $elem('tree_orderType',pageId);
		var selectedNode = genreTree.tree('getSelected');
		if(selectedNode&&selectedNode.hasClass('root')){
			genreId='';
		}
		$elem('subpage_addOrderType',pageId).subpage('open',{pruGenreId:genreId},null,{pruGenreId:genreId});
	</youi:func>

	<youi:func name="subpage_addOrderType_afterSubmit" params="results">
		if(results&&results.record){
			//增加树节点
			var genreTree = $elem('tree_orderType',pageId),
				record = results.record,
				relTreeNode;
			if(!record.purchasingmanagerGenre){
				relTreeNode = genreTree.find('li.treeNode:first');
			}else{
				relTreeNode = genreTree.find('li.treeNode#'+record.purchasingmanagerGenre.genreId);
			}
			genreTree.tree('addNode',relTreeNode,record.genreId,record.genreName);
			$(this).form('close');
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>