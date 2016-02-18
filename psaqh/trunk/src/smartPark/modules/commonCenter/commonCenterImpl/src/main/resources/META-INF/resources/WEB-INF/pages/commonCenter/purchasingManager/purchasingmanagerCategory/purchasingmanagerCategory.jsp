<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerCategory" idKeys="categoryId" caption="商品类目表列表"  panel="false"
				src="esb/web/purchasingmanagerCategoryManager/getPagerPurchasingmanagerCategorys.json" dataFormId="form_purchasingmanagerCategory"
				editSrc="esb/web/purchasingmanagerCategoryManager/getPurchasingmanagerCategory.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCategoryManager/removePurchasingmanagerCategory.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe" convert="businessType"  caption="园区商业类型"/>
			<youi:fieldText property="categoryName"  caption="类目名称"/>
			<youi:fieldSelect property="categoryIsnotEnable" convert="ISNOT" caption="是否启用" />
		</youi:fieldLayout>
		<youi:gridCol property="categoryName"  caption="类目名称" align="center" width="33%"/>
		<youi:gridCol property="parkBusinessTupe"  convert="businessType"  caption="园区商业类型" align="center" width="33%"/>
		<youi:gridCol property="categoryIsnotEnable" convert="ISNOT" caption="是否启用" align="center" width="33%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品类目表编辑 -->
	<youi:form dialog="true" caption="商品类目表" id="form_purchasingmanagerCategory" action="esb/web/purchasingmanagerCategoryManager/savePurchasingmanagerCategory.json">
		<youi:fieldLayout prefix="record"  labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe" convert="businessType" caption="园区商业类型"/>
			<youi:fieldText property="categoryName"  caption="类目名称"/>
			<youi:fieldHidden property="categoryId"  caption="类目ID"/>
			<youi:fieldSelect property="categoryIsnotEnable" convert="ISNOT" caption="是否启用"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>