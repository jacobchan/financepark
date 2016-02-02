<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerSfpro" idKeys="sfproId" caption="物业收费项目表列表"  panel="false"
				src="esb/web/propertyservicemanagerSfproManager/getPagerPropertyservicemanagerSfpros.json" dataFormId="form_propertyservicemanagerSfpro"
				editSrc="esb/web/propertyservicemanagerSfproManager/getPropertyservicemanagerSfpro.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerSfproManager/removePropertyservicemanagerSfpro.json">
		<youi:fieldLayout>

			<youi:fieldText property="sfproName"  caption="收费项目名称"/>
			<youi:fieldText property="sfproAmount"  caption="项目金额"/>
		</youi:fieldLayout>

		<youi:gridCol property="sfproName"  caption="收费项目名称"/>
		<youi:gridCol property="sfproAmount"  caption="项目金额"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-物业收费项目表编辑 -->
	<youi:form dialog="true" caption="物业收费项目表" id="form_propertyservicemanagerSfpro" action="esb/web/propertyservicemanagerSfproManager/savePropertyservicemanagerSfpro.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="sfproId"  caption="收费项目序列"/>
			<youi:fieldText property="sfproName"  caption="收费项目名称"/>
			<youi:fieldText property="sfproAmount"  caption="项目金额"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>