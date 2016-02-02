<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerSer" idKeys="serId" caption="费用清单列表"  panel="false"
				src="esb/web/propertyservicemanagerSerManager/getPagerPropertyservicemanagerSers.json" dataFormId="form_propertyservicemanagerSer"
				editSrc="esb/web/propertyservicemanagerSerManager/getPropertyservicemanagerSer.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerSerManager/removePropertyservicemanagerSer.json">
		<youi:fieldLayout>

			<youi:fieldText property="serName"  caption="材料名称"/>
			<youi:fieldText property="serType"  caption="材料类别"/>
			<youi:fieldText property="serPrice"  caption="材料价格"/>
			<youi:fieldText property="serPayStatus"  caption="支付状态"/>
		</youi:fieldLayout>

		<youi:gridCol property="serName"  caption="材料名称"/>
		<youi:gridCol property="serType"  caption="材料类别"/>
		<youi:gridCol property="serPrice"  caption="材料价格"/>
		<youi:gridCol property="serPayStatus"  caption="支付状态"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-费用清单编辑 -->
	<youi:form dialog="true" caption="费用清单" id="form_propertyservicemanagerSer" action="esb/web/propertyservicemanagerSerManager/savePropertyservicemanagerSer.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="serId"  caption="主键ID_"/>
			<youi:fieldText property="serName"  caption="材料名称"/>
			<youi:fieldText property="serType"  caption="材料类别"/>
			<youi:fieldText property="serPrice"  caption="材料价格"/>
			<youi:fieldText property="serPayStatus"  caption="支付状态"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>