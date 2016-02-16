<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout columns="1" labelWidths="90">
		<youi:fieldHidden property="serviceId" caption="服务主键"/>
		<youi:fieldText property="serviceName" caption="服务名"/>
		
		<youi:fieldCheckboxGroup property="refIds" width="500" caption="发布到接口"
			src="esb/web/busExportPortManager/getBusExportPorts.json" code="exportPortId" show="exportPortCaption"/>
	</youi:fieldLayout>
</youi:page>