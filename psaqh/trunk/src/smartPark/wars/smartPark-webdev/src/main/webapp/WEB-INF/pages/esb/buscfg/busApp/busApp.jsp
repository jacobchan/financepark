<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_busApp" idKeys="appId" caption="应用系统列表"  panel="false"
				src="esb/web/busAppManager/getPagerBusApps.json" dataFormId="form_busApp"
				editSrc="esb/web/busAppManager/getBusApp.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/busAppManager/removeBusApp.json">
		<youi:fieldLayout>
			<youi:fieldText property="appCaption"  caption="应用系统描述"/>
			<youi:fieldText property="appName"  caption="应用系统名"/>

		</youi:fieldLayout>
		
		<youi:gridCol width="20%" property="appName"  caption="应用系统名"/>
		<youi:gridCol width="50%" property="appCaption"  caption="应用系统描述"/>
		<youi:gridCol width="30%" property="appType"  caption="应用系统类型"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-应用系统编辑 -->
	<youi:form dialog="true" caption="应用系统" id="form_busApp" action="esb/web/busAppManager/saveBusApp.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="appId"  caption="应用系统ID"/>
			<youi:fieldText property="appName"  caption="系统名"/>
			<youi:fieldText property="appCaption"  caption="系统描述"/>
			<youi:fieldText property="appType"  caption="系统类型"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	

	<!--**********************************页面函数********************************-->
</youi:page>