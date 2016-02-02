<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationProduct" idKeys="productId" caption="产品信息列表"  panel="false"
				src="esb/web/informationProductManager/getPagerInformationProducts.json" dataFormId="form_informationProduct"
				editSrc="esb/web/informationProductManager/getInformationProduct.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/informationProductManager/removeInformationProduct.json">
		<youi:fieldLayout>

			<youi:fieldText property="productContent"  caption="产品描述"/>
			<youi:fieldText property="productRe"  caption="企业ID"/>
			<youi:fieldText property="rzId"  caption="ID2"/>
			<youi:fieldText property="productType"  caption="产品类别"/>
			<youi:fieldText property="productName"  caption="产品名称"/>
		</youi:fieldLayout>

		<youi:gridCol property="productContent"  caption="产品描述"/>
		<youi:gridCol property="productRe"  caption="企业ID"/>
		<youi:gridCol property="rzId"  caption="ID2"/>
		<youi:gridCol property="productType"  caption="产品类别"/>
		<youi:gridCol property="productName"  caption="产品名称"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-产品信息编辑 -->
	<youi:form dialog="true" caption="产品信息" id="form_informationProduct" action="esb/web/informationProductManager/saveInformationProduct.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="productId"  caption="ID"/>
			<youi:fieldText property="productContent"  caption="产品描述"/>
			<youi:fieldText property="productRe"  caption="企业ID"/>
			<youi:fieldText property="rzId"  caption="ID2"/>
			<youi:fieldText property="productType"  caption="产品类别"/>
			<youi:fieldText property="productName"  caption="产品名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>