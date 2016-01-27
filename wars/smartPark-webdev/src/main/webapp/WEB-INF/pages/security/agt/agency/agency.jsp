<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	
	<youi:ajaxUrl name="removeAgency" src="/local/agt/agency/removeAgency.json"></youi:ajaxUrl>
	<!--**********************************子页面**********************************-->
	<!-- 表单类型子页面：修改服务组 -->
	<youi:subpage caption="新增机构" height="240"
		width="780" subpageId="addAgency"
		src="page/security.agt.agency/editAgency.html?parentAgencyId={parentAgencyId}"
		formAction="/local/agt/agency/saveAgency.json" idKeys="agencyId">
		<youi:button name="close" caption="关闭" order="900"></youi:button>
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table styleClass="adapt-page-height">
		<youi:cell width="200">
			<div style="height:360px;overflow:auto;">
				<youi:tree id="tree_agency" dataFormId="form_agency"
					hideRoot="false" rootText="机构"
					iteratorSrc="/local/agt/agency/getChildren.json" iteratorParam="agencyId"
					idAttr="agencyId" textAttr="agencyCaption" pidAttr="parentAgencyId"/>
			</div>
		</youi:cell>
		<youi:cell>
			<!-- form-机构编辑 -->
			<youi:form caption="i18n.agency" id="form_agency"  submit="i18n.youi.tag.save"
				idKeys="agencyId" panel="NOT"
				findAction="/local/agt/agency/getAgency.json"
				action="/local/agt/agency/saveAgency.json">
				<youi:fieldLayout prefix="record" columns="1">
					<youi:fieldHidden property="agencyId"  caption="机构ID"/>
					<youi:fieldHidden property="parentAgencyId"  caption="父级机构"/>
					<youi:fieldLabel width="502" property="parentTextTrace"  caption="i18n.agency.parent"/>
					<youi:fieldText notNull="true" width="502" property="agencyCode"  caption="i18n.agency.code"/>
					<youi:fieldText notNull="true" width="502" property="agencyCaption"  caption="i18n.agency.caption"/>
					<youi:fieldLabel width="502" property="agencyPath"  caption="i18n.agency.path"/>
					<youi:fieldLabel convert="booleanConvert" width="502" property="leaf" defaultValue="1" caption="i18n.agency.leaf"/>
				</youi:fieldLayout>
			</youi:form>
		</youi:cell>
	</youi:table>
	
	<youi:xmenu id="xmenu_agency">
		<youi:xmenuItem caption="添加机构" name="addAgency" icon="addRecord" action="addAgency"/>
		<youi:xmenuItem caption="删除机构" name="removeAgency" icon="removeRecord" action="removeAgency"/>
	</youi:xmenu>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<!-- 树右键动作 -->
	<youi:func name="tree_agency_rightClick" params="event,nodeElement">
		$elem('xmenu_agency',pageId).xmenu('open',event,nodeElement);
	</youi:func>
	
	<!-- 弹出菜单动作：打开新增机构窗口 -->
	<youi:func name="func_xmenu_addAgency" params="treeNode">
		var id = treeNode.attr('id');
		if(treeNode.hasClass('root')){
			id = '';
		}
		$elem('subpage_addAgency',pageId).subpage('open',{parentAgencyId:id},null,{parentAgencyId:id});
	</youi:func>
	
	<!-- 弹出菜单动作：删除机构 -->
	<youi:func name="func_xmenu_removeAgency" params="treeNode"
		urls="removeAgency">
		var id = treeNode.attr('id');
		var funcSrc = funcUrls.removeAgency;
		if(id&&funcSrc){
			var removeSrc = funcSrc+'?agencyId='+id;
			$.youi.ajaxUtil.ajaxRemove(removeSrc,id,'确认删除？',function(treeNodeId){
				$elem('tree_agency',pageId).tree('removeNode',treeNodeId);
			});
		}
	</youi:func>
	
	<!-- 添加机构回调函数 -->
	<youi:func name="subpage_addAgency_afterSubmit" params="results">
		if(results&&results.record){
			//增加树节点
			var targetTree = $elem('tree_agency',pageId);
			$.youi.treeUtils.addNode(targetTree,results.record,'agencyId','agencyCaption','parentAgencyId');
			$(this).form('close');
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>