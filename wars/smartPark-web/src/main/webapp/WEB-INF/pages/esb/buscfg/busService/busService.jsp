<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<!-- 表单类型子页面：发布服务 -->
	<youi:subpage caption="服务发布" height="460"
		width="780" subpageId="export"
		formAction="esb/web/busServiceManager/saveExportServices.json"
		editSrc="esb/web/busServiceManager/getExportServices.json" idKeys="serviceId"
		src="page/esb.buscfg.busService/busServiceExport.html">
	</youi:subpage>
	
	<!-- 表单类型子页面：授权服务 -->
	<youi:subpage caption="服务授权" height="460"
		width="780" subpageId="authorize"
		formAction="esb/web/busServiceManager/saveAppServices.json"
		editSrc="esb/web/busServiceManager/getAppServices.json" idKeys="serviceId"
		src="page/esb.buscfg.busService/busServiceAuthorize.html">
	</youi:subpage>
	
	<!-- 表单类型子页面：授权服务 -->
	<youi:subpage caption="详细信息" height="460"
		width="780" subpageId="details"
		src="page/esb.buscfg.busService/busServiceDetails.html?serviceId={serviceId}&serviceName={serviceName}">
	</youi:subpage>
	
	
	<youi:grid id="grid_busService" idKeys="serviceId" caption="服务列表"  panel="false"
				src="esb/web/busServiceManager/getPagerBusServices.json" dataFormId="form_busService"
				editSrc="esb/web/busServiceManager/getBusService.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/busServiceManager/removeBusService.json">
		<youi:fieldLayout>
			<youi:fieldText property="serviceCode"  caption="服务编码"/>
			<youi:fieldText property="serviceName"  caption="服务名"/>
			<youi:fieldText column="2" property="serviceCaption"  caption="服务描述"/>
		</youi:fieldLayout>
		
		
		<youi:gridCol width="10%" property="serviceCode"  caption="服务编码"/>
		
		<youi:gridCol width="10%" type="link" property="serviceName"  caption="原子服务名"/>
		<youi:gridCol width="10%" property="serviceInterface"  caption="服务接口名"/>
		
		<youi:gridCol width="15%" property="serviceCaption"  caption="服务描述"/>
		<youi:gridCol width="10%" property="serviceExportName"  caption="服务发布名"/>
		
		<youi:gridCol width="15%" property="busAdapter.adapterCaption"  caption="服务适配器"/>
		
		<youi:gridCol width="10%" property="serviceVersion"  caption="版本号"/>
		<youi:gridCol width="10%" property="serviceStatus"  caption="服务状态"/>
		
		<youi:gridCol width="10%" property="updateTime"  caption="修改时间"/>
		
		<youi:button active="1" disableProperty="serviceStatus" name="enableServiceStatus" icon="play" caption="启用"/>
		<youi:button active="1" enableProperty="serviceStatus" name="disableServiceStatus" icon="stop" caption="停用"/>
		
		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="export" icon="mail-forward" caption="服务发布"/>
			<youi:button name="authorize" icon="lock" caption="服务授权"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-服务编辑 -->
	<youi:form dialog="true" caption="服务" id="form_busService" action="esb/web/busServiceManager/saveBusService.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
		
			<youi:fieldHidden property="serviceId"  caption="服务主键"/>
			
			<youi:fieldText notNull="true" property="serviceName"  caption="服务名"/>
			<youi:fieldText property="serviceCode"  caption="服务编码"/>
			
			<youi:fieldText property="serviceInterface"  caption="服务接口名"/>
			<youi:fieldText property="serviceExportName"  caption="服务发布名"/>
			
			<youi:fieldText property="serviceCaption" column="2" caption="服务描述"/>
			<youi:fieldSelect property="busAdapter.adapterId" column="2" caption="适配器"
				 src="esb/web/busAdapterManager/getBusAdapters.json" code="adapterId" show="adapterCaption"/>
			
			<youi:fieldText property="serviceVersion"  caption="版本号"/>
			<youi:fieldText property="serviceStatus"  caption="服务状态"/>
			
			<youi:fieldLabel property="createTime"  caption="创建时间"/>
			<youi:fieldLabel property="updateTime"  caption="修改时间"/>
			
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<!-- 行按钮：发布服务 -->
	<youi:func name="grid_busService_col_button_export" params="record">
		$elem('subpage_export',pageId).subpage('open',record,'');
	</youi:func>
	<!-- 行按钮：授权服务 -->
	<youi:func name="grid_busService_col_button_authorize" params="record">
		$elem('subpage_authorize',pageId).subpage('open',record,'');
	</youi:func>
	
	<!-- 行链接：查看信息 -->
	<youi:func name="grid_busService_link_serviceName" params="record">
		$elem('subpage_details',pageId).subpage('open',record,'',record);
	</youi:func>
	
	<youi:func name="subpage_export_afterSubmit" params="result">
		$elem('subpage_export',pageId).subpage('close');
		$elem('grid_busService',pageId).grid('refresh');
	</youi:func>
	
	
	<youi:func name="func_grid_enableServiceStatus">
		alert('en');
	</youi:func>
	
	<youi:func name="func_grid_disableServiceStatus">
		alert('di');
	</youi:func>
	
	<!--**********************************页面函数********************************-->
</youi:page>