<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="新增类别" height="260"
		width="780" subpageId="addGenre"
		src="page/commonCenter.purchasingManager.purchasingmanagerGenre/addPurchasingmanagerGenre.html?purchasingmanagerGenre.genreId={pruGenreId}"
		formAction="esb/web/purchasingmanagerGenreManager/savePurchasingmanagerGenre.json">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<!--**********************************页面内容********************************-->
	<%-- <youi:tree styleClass="page-height col-sm-2 youi-bgcolor" id="tree_genre" dataFormId="form_genre" idAttr="genreId"
					textAttr="genreName" iteratorParam="genreId" pidAttr="purchasingmanagerGenre.genreId"
					iteratorSrc="esb/web/purchasingmanagerGenreManager/getSubPurchasingmanagerGenreList.json"></youi:tree> --%>
					
	<youi:tree styleClass="page-height col-sm-2 youi-bgcolor" id="tree_genre" dataFormId="form_genre" idAttr="genreId"
					pidAttr="purchasingmanagerGenre.genreName" textAttr="genreName" tree="${genreTree}"></youi:tree>
	
	<youi:form styleClass="page-height col-sm-10" caption="编辑商品类别" id="form_genre" panel="false"
		action="esb/web/purchasingmanagerGenreManager/savePurchasingmanagerGenre.json" findAction="esb/web/purchasingmanagerGenreManager/getPurchasingmanagerGenre.json"
		idKeys="genreId" submit="保存类别" reset="NOT"
		removeAction="esb/web/purchasingmanagerGenreManager/removePurchasingmanagerGenre.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden styleClass="field-parent" property="purchasingmanagerGenre.genreId" />
			<youi:fieldHidden  property="genreId" caption="类别ID" />
			<youi:fieldText width="120" styleClass="autoAlign" property="genreName" caption="类别名称"/>
			<youi:fieldLabel  styleClass="autoAlign"  property="purchasingmanagerGenre.genreName" caption="上级类别" />
		</youi:fieldLayout>
		<youi:button icon="add" name="addGenre" caption="新增类别" />
	</youi:form>
	<!--**********************************页面内容********************************-->
	<!--**********************************页面函数********************************-->

	<youi:func name="func_form_addGenre">
		var genreName = $elem('form_genre',pageId).form('fieldValue','genreName');
		var genreId = $elem('form_genre',pageId).form('fieldValue','genreId');
		var genreTree = $elem('tree_genre',pageId);
		var selectedNode = genreTree.tree('getSelected');
		if(selectedNode&&selectedNode.hasClass('root')){
			genreId='';
		}
		$elem('subpage_addGenre',pageId).subpage('open',{pruGenreId:genreId},null,{pruGenreId:genreId});
	</youi:func>

	<youi:func name="subpage_addGenre_afterSubmit" params="results">
		if(results&&results.record){
			//增加树节点
			var genreTree = $elem('tree_genre',pageId),
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