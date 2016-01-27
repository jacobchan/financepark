<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_busExportPort" idKeys="exportPortId" caption="服务接口列表"  panel="false"
				src="esb/web/busExportPortManager/getPagerBusExportPorts.json" dataFormId="form_busExportPort"
				editSrc="esb/web/busExportPortManager/getBusExportPort.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/busExportPortManager/removeBusExportPort.json">
		<youi:fieldLayout>
			<youi:fieldText property="exportPortName"  caption="接口名"/>
			<youi:fieldText property="protocolId"  caption="发布协议"/>
			<youi:fieldText property="exportPortCaption" column="2" caption="接口描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol width="20%" property="exportPortName"  caption="接口名"/>
		
		<youi:gridCol width="40%" property="exportPortCaption"  caption="接口描述"/>
		
		<youi:gridCol width="10%" property="protocolId"  caption="发布协议"/>
		<youi:gridCol width="10%" property="protocolPort"  caption="发布端口"/>
		<youi:gridCol width="10%" property="exportPortStatus"  caption="发布状态"/>
		<youi:gridCol width="10%" property="updateTime"  caption="发布时间"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-服务接口编辑 -->
	<youi:form dialog="true" caption="服务接口" id="form_busExportPort" action="esb/web/busExportPortManager/saveBusExportPort.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="exportPortId"  caption="服务接口主键"/>
			
			<youi:fieldText notNull="true" property="exportPortName" column="2" caption="接口名"/>
			<youi:fieldText property="exportPortCaption" column="2" caption="接口描述"/>
			
			<youi:fieldText property="protocolId"  caption="发布协议"/>
			<youi:fieldText property="protocolPort"  caption="发布端口"/>
			
			<youi:fieldText property="exportPortPassword"  caption="登录密码"/>
			<youi:fieldText property="exportPortUsername"  caption="登录用户"/>
			
			<youi:fieldLabel property="exportPortStatus"  caption="发布状态"/>
			<youi:fieldLabel property="updateTime"  caption="发布时间"/>
			
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	<youi:func name="grid_busExportPort_col_button_edit" params="record,rowDoc">
		$(this).grid('openFormEdit','修改',rowDoc);
	</youi:func>
	
	<youi:func name="grid_busExportPort_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>