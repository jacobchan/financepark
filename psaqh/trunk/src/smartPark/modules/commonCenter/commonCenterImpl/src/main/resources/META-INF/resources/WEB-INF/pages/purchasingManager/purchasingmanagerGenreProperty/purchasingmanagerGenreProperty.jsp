<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerGenreProperty" idKeys="genrePropertyId" caption="商品类属性列表"  panel="false"
				src="esb/web/purchasingmanagerGenrePropertyManager/getPagerPurchasingmanagerGenrePropertys.json" dataFormId="form_purchasingmanagerGenreProperty"
				editSrc="esb/web/purchasingmanagerGenrePropertyManager/getPurchasingmanagerGenreProperty.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerGenrePropertyManager/removePurchasingmanagerGenreProperty.json">
		<youi:fieldLayout>
			<youi:fieldText property="genrePropertyFieldLength"  caption="字段长度"/>
			<youi:fieldText property="genrePropertyDefaultValue"  caption="默认值"/>
			<youi:fieldText property="genrePropertyIsnotMust"  caption="是否必须"/>

			<youi:fieldText property="genrePropertyIsnotDisplay"  caption="是否显示"/>
			<youi:fieldText property="genrePropertyFieldType"  caption="字段类型"/>
			<youi:fieldText property="genrePropertyDisplayName"  caption="显示名称"/>
			<youi:fieldText property="genrePropertyFieldName"  caption="字段名称"/>
		</youi:fieldLayout>
		<youi:gridCol property="genrePropertyFieldLength"  caption="字段长度"/>
		<youi:gridCol property="genrePropertyDefaultValue"  caption="默认值"/>
		<youi:gridCol property="genrePropertyIsnotMust"  caption="是否必须"/>

		<youi:gridCol property="genrePropertyIsnotDisplay"  caption="是否显示"/>
		<youi:gridCol property="genrePropertyFieldType"  caption="字段类型"/>
		<youi:gridCol property="genrePropertyDisplayName"  caption="显示名称"/>
		<youi:gridCol property="genrePropertyFieldName"  caption="字段名称"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品类属性编辑 -->
	<youi:form dialog="true" caption="商品类属性" id="form_purchasingmanagerGenreProperty" action="esb/web/purchasingmanagerGenrePropertyManager/savePurchasingmanagerGenreProperty.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="genrePropertyFieldLength"  caption="字段长度"/>
			<youi:fieldText property="genrePropertyDefaultValue"  caption="默认值"/>
			<youi:fieldText property="genrePropertyIsnotMust"  caption="是否必须"/>
			<youi:fieldText property="genrePropertyId"  caption="商品类别属性序列"/>
			<youi:fieldText property="genrePropertyIsnotDisplay"  caption="是否显示"/>
			<youi:fieldText property="genrePropertyFieldType"  caption="字段类型"/>
			<youi:fieldText property="genrePropertyDisplayName"  caption="显示名称"/>
			<youi:fieldText property="genrePropertyFieldName"  caption="字段名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>