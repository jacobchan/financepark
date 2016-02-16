<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:form id="form_role_auth" panel="false" idKeys="roleId" 
		findAction="/local/fuc/role/getRoleAuth.json"  confirmMessage="确认授权？"
		action="/local/fuc/role/saveRolePageAuth.json">
		<youi:fieldLayout>
			<youi:fieldHidden property="roleType"/>
			<youi:fieldLabel property="roleId"  caption="角色名"/>
			<youi:fieldLabel property="roleCaption"  caption="角色描述"/>
		</youi:fieldLayout>
		
		<fieldset>
			<legend>选择页面元素</legend>
			<youi:fieldLayout styleClass="hideLabel" labelWidths="1" columns="1">
				<youi:fieldGrid property="rolePageElements"  
					treeSource="${menuTree}" idAttr="pk.menuId" textAttr="menuCaption">
					<youi:grid id="grid_rolePageElements" panel="false" idKeys="pk.menuId,pk.pageElementId" scrollHeight="350" showCheckbox="true">
						<youi:gridCol width="0" property="pk.roleId" caption="角色"/>
						<youi:gridCol width="210" property="pk.menuId" caption="菜单"/>
						<youi:gridCol width="210" property="pk.pageElementId" caption="页面元素"/>
					</youi:grid>
				</youi:fieldGrid>
			</youi:fieldLayout>
		</fieldset>
		
		<youi:button name="closeDialog" caption="关闭" icon="close" order="400"/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	<youi:func name="subpage_init" params="record">
		var formElement = $elem('form_role_auth',pageId);
		formElement.form('fillRecord',record);//填充数据
		//从后台查询数据填充到form中
		formElement.form('loadRecord',function(results){
			
		});
	</youi:func>
	<!-- 使用自定义的行记录添加函数  -->
	<youi:func name="field_rolePageElements_parseRecord" params="gridElement,treeNodeDom,idAttr,textAttr">
		var formElement =  $elem('form_role_auth',pageId),
			roleId = formElement.find('.youi-field[property=roleId]').fieldValue(),
			id = treeNodeDom.getAttribute('id'),
			menuId = id.split('_')[0],
			pageElementId = id.split('_')[1];
		
		if(gridElement.find('[id="'+menuId+','+pageElementId+'"]').length>0){
			return null;
		}

		return {
					pk:{
						roleId:roleId,
						menuId:menuId,
						pageElementId:pageElementId
					}
				};
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>