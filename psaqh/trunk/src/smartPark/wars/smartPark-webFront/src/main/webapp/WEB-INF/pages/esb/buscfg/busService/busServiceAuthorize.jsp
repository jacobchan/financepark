<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout prefix="record" columns="1" labelWidths="90">
		<youi:fieldHidden property="serviceId" caption="服务主键"/>
		<youi:fieldLabel property="serviceName" caption="服务名"/>
		
		<youi:fieldCheckboxGroup property="refIds" width="500" caption="授权到应用"
			src="esb/web/busAppManager/getBusApps.json" code="appId" show="appCaption"/>
	</youi:fieldLayout>
</youi:page>