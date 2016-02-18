<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerFxtdc" idKeys="fxtdcId" caption="搬家放行二维码记录表列表"  panel="false"
				src="esb/web/propertyservicemanagerFxtdcManager/getPagerPropertyservicemanagerFxtdcs.json" dataFormId="form_propertyservicemanagerFxtdc"
				editSrc="esb/web/propertyservicemanagerFxtdcManager/getPropertyservicemanagerFxtdc.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerFxtdcManager/removePropertyservicemanagerFxtdc.json">
		<youi:fieldLayout>
			<youi:fieldText property="twcrdAddrec"  caption="二维码URL地址"/>
		</youi:fieldLayout>

		<youi:gridCol property="twcrdAddrec"  caption="二维码URL地址"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-搬家放行二维码记录表编辑 -->
	<youi:form dialog="true" caption="搬家放行二维码记录表" id="form_propertyservicemanagerFxtdc" action="esb/web/propertyservicemanagerFxtdcManager/savePropertyservicemanagerFxtdc.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="fxtdcId"  caption="二维码记录序列"/>
			<youi:fieldText property="twcrdAddrec"  caption="二维码URL地址"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>