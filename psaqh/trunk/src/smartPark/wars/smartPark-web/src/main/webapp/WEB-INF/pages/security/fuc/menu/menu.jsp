<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="新增菜单" height="260"
		width="780" subpageId="addMenu"
		src="page/security.fuc.menu/addmenu.html?parentMenuId={parentMenuId}"
		formAction="/local/fuc/menu/saveMenu.json">
	</youi:subpage>

	<youi:subpage caption="编辑菜单数据" height="460"
		width="780" subpageId="pagedatas"
		src="page/security.fuc.menu/pagedatas.html?menuId={menuId}"
		formAction="save.json">
		<youi:button name="close" caption="关闭" order="900"></youi:button>
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<!--**********************************页面内容********************************-->
	<youi:tree styleClass="page-height col-sm-2 youi-bgcolor" id="tree_menu" dataFormId="form_menu" idAttr="menuId"
					pidAttr="parentMenuId" textAttr="menuCaption" tree="${menuTree}"></youi:tree>
	
	
	<youi:form styleClass="page-height col-sm-10" caption="编辑系统菜单" id="form_menu" panel="false"
		action="/local/fuc/menu/saveMenu.json" findAction="/local/fuc/menu/getMenu.json"
		idKeys="menuId" submit="保存菜单"
		removeAction="esb/web/roleMenuManager/removeMenu.json">

		<youi:fieldLayout prefix="record" columns="3">
			<youi:fieldHidden styleClass="field-parent" property="parentMenuId" />

			<youi:fieldText width="120" styleClass="autoAlign" notNull="true"
				property="menuId" caption="菜单编号" />
			<youi:fieldText width="120" styleClass="autoAlign"
				property="menuNum" caption="菜单序号" />
			<youi:fieldLabel property="parentTextTrace" caption="上级菜单" />

			<youi:fieldText width="120" notNull="true" styleClass="autoAlign"
				property="menuCaption" caption="菜单名称" />
			<youi:fieldText width="120" styleClass="autoAlign"
				property="menuStyle" caption="菜单样式" />
			<youi:fieldRadioGroup property="subpage" convert="boolean"
				defaultValue="0" caption="是否子页面" />

			<youi:fieldText styleClass="autoAlign" column="2"
				property="menuSrc" caption="菜单地址" />
			<youi:fieldSelect property="target" defaultValue="1" width="120" caption="菜单目标"
				convert="targetType" />

		</youi:fieldLayout>
		<youi:tabs id="tabs_menu" itemHeight="360">
			<youi:tabItem caption="页面元素" id="pageElements">
				<youi:fieldGrid property="pageElements" width="0">
					<youi:grid editable="true" panel="false" showNum="true" scrollHeight="280"
						idKeys="pk.menuId,pk.pageElementId">
						<youi:gridCol editor="fieldText" property="pk.pageElementId"
							width="30%" caption="授权标识" />
						<youi:gridCol width="70%" editor="fieldText" property="pageElementCaption"
							caption="组件描述" />
					</youi:grid>
				</youi:fieldGrid>
			</youi:tabItem>
			<youi:tabItem caption="页面数据" id="pageDatas">
				<youi:grid id="grid_menu_datas" panel="false" usePager="false" scrollHeight="280"
					dataFormId="form_menu_datas" submit="NOT" reset="NOT" add="NOT"
					edit="NOT" remove="NOT">
					<youi:gridCol property="trancode" width="120" caption="交易码" />
					<youi:gridCol property="dataUrlPath" width="300" caption="数据路径" />
					<youi:gridCol property="dataUrlCaption" caption="数据描述" />

					<youi:button name="editMenuDatas" caption="编辑页面数据" />
				</youi:grid>
			</youi:tabItem>

		</youi:tabs>
		<youi:button icon="add" name="addMenu" caption="新增菜单" />
	</youi:form>
	<!--**********************************页面内容********************************-->
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_editMenuDatas" i18ns="not.selected,menu">
		var menuId = $elem('form_menu',pageId).form('fieldValue','menuId');
		if(menuId){
			$elem('subpage_pagedatas',pageId).subpage('open',{menuId:menuId},null,{menuId:menuId});
		}else{
			$.youi.messageUtils.showMessage(i18ns.join(''));
		}
	</youi:func>

	<youi:func name="func_form_addMenu">
		var menuId = $elem('form_menu',pageId).form('fieldValue','menuId')||'';

		var menuTree = $elem('tree_menu',pageId);
		
		var selectedNode = menuTree.tree('getSelected');
		if(selectedNode&&selectedNode.hasClass('root')){
			menuId='';
		}
		$elem('subpage_addMenu',pageId).subpage('open',{parentMenuId:menuId},null,{parentMenuId:menuId});
	</youi:func>

	<youi:func name="subpage_addMenu_afterSubmit" params="results">
		if(results&&results.record){
			//增加树节点
			var menuTree = $elem('tree_menu',pageId),
				record = results.record,
				relTreeNode;
		
			if(!record.parentMenuId){
				relTreeNode = menuTree.find('li.treeNode:first');
			}else{
				relTreeNode = menuTree.find('li.treeNode#'+record.parentMenuId);
			}
			menuTree.tree('addNode',relTreeNode,record.menuId,record.menuCaption);
			$(this).form('close');
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>