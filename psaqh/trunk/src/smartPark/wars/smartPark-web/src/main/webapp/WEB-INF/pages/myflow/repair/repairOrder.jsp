<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

 <youi:page>
 	<youi:subpage caption="详细" subpageId="detail"
		 src="/repairOrderManager/getRepairOrder.html?id={id}"
		 width="600" height="150">
	</youi:subpage>
	
	<youi:grid id="grid_repairOrder" idKeys="id" caption="维修单详情"  panel="false"
				src="/repairOrderManager/getPagerRepairOrders.json" dataFormId="form_repairOrder"
				edit="NOT" remove="NOT" showCheckbox="true"
				>
		<youi:fieldLayout prefix="search" labelWidths="100,100">
			<youi:fieldText property="params.processDefinitionId"  caption="流程实例" defaultValue=""/>
			<youi:fieldText property="params.status"  caption="状态" defaultValue="01"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="name"  caption="订单名称" width="10%"/>
		<youi:gridCol property="status"  caption="状态" width="10%" align="center"/>
		<youi:gridCol property="content"  caption="订单内容" width="20%"/>
		<youi:gridCol property="describe"  caption="订单描述" width="20%"/>
		<youi:gridCol property="price"  caption="维修价格" width="10%"/>
		<youi:gridCol property="appraise"  caption="用户评价" width="10%"/>
		
		<youi:gridCol property="createUser"  caption="创建人" width="10%"/>
		<youi:gridCol property="createDate"  caption="创建时间" width="10%"/>
		

		<youi:button name="detail" icon="searchRecord" active="1" caption="详情"/>

	</youi:grid>
	
	<youi:form id="form_repairOrder" dialog="true" action="/repairOrderManager/saveRepairOrder.json">
		<youi:fieldLayout prefix="re">
			<youi:fieldText property="name"  caption="订单名称" />
			<youi:fieldText property="status"  caption="状态" />
			<youi:fieldText property="content"  caption="订单内容" />
			<youi:fieldText property="describe"  caption="订单描述" />
			<youi:fieldText property="price"  caption="维修价格" />
			<youi:fieldText property="appraise"  caption="用户评价"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<youi:func name="func_grid_detail">//新建
		var select = $elem('grid_repairOrder',pageId).grid("getSelectedRecord");
		$elem('subpage_detail',pageId).subpage('open',null,null,{id:select.id});
	</youi:func>
	
	<youi:func name="subpage_creater_afterSubmit">
		$elem('subpage_detail',pageId).subpage('close');
		$elem('grid_repairOrder',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>