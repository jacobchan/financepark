<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicenanagerBack" idKeys="backId"
		caption="投诉回访记录表列表" panel="false"
		src="esb/web/propertyservicenanagerBackManager/getPagerPropertyservicenanagerBacks.json"
		dataFormId="form_propertyservicenanagerBack"
		editSrc="esb/web/propertyservicenanagerBackManager/getPropertyservicenanagerBack.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/propertyservicenanagerBackManager/removePropertyservicenanagerBack.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="propertyservicemanagerCos.cosId"
				src="esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCoss.json"
				code="cosId" show="cosCode" caption="投诉ID" />
			<youi:fieldText property="backCode" caption="回访单号" />
		</youi:fieldLayout>
		<youi:gridCol property="propertyservicemanagerCos.cosCode" caption="投诉ID" width="180" />
		<youi:gridCol property="backCode" caption="回访单号" width="160" />
		<youi:gridCol property="backRecord" caption="回访记录" width="380" />
		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-投诉回访记录表编辑 -->
	<youi:form dialog="true" caption="投诉回访记录表"
		id="form_propertyservicenanagerBack"
		action="esb/web/propertyservicenanagerBackManager/savePropertyservicenanagerBack.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldText property="backId" caption="回访ID" />
			<youi:fieldSelect property="propertyservicemanagerCos.cosId"
				src="esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCoss.json"
				code="cosId" show="cosCode" caption="投诉ID" notNull="true" />
			<youi:fieldText property="backCode" caption="回访单号" />
			<youi:fieldArea property="backRecord" caption="回访记录" rows="8"
				column="20" tooltips="回访记录" notNull="true" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->

	<!--**********************************页面函数End**********************************-->
</youi:page>