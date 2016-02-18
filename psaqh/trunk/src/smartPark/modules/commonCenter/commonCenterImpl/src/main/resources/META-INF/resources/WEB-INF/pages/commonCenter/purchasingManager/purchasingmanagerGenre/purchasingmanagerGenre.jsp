<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerGenre" idKeys="genreId" caption="商品类别表列表"  panel="false"
				src="esb/web/purchasingmanagerGenreManager/getPagerPurchasingmanagerGenres.json" dataFormId="form_purchasingmanagerGenre"
				editSrc="esb/web/purchasingmanagerGenreManager/getPurchasingmanagerGenre.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerGenreManager/removePurchasingmanagerGenre.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe" convert="PARK_BUSINESS_TYPE"  caption="园区商业类型"/>
			<youi:fieldText property="purchasingmanagerGenre.genreName"  caption="上级类别名称"/>
			<youi:fieldText property="genreName"  caption="商业类别名称"/>
		</youi:fieldLayout>

		<youi:gridCol property="parkBusinessTupe" convert="PARK_BUSINESS_TYPE"  caption="园区商业类型" align="center" width="33%"/>
		<youi:gridCol property="purchasingmanagerGenre.genreName"  caption="上级类别名称"  align="center" width="33%"/>
		<youi:gridCol property="genreName"  caption="商业类别名称"  align="center" width="34%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品类别表编辑 -->
	<youi:form dialog="true" caption="商品类别表" id="form_purchasingmanagerGenre" action="esb/web/purchasingmanagerGenreManager/savePurchasingmanagerGenre.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="genreId"  caption="商业类别ID"/>
			<youi:fieldSelect property="parkBusinessTupe" convert="PARK_BUSINESS_TYPE"  caption="园区商业类型"/>
			<youi:fieldText property="genreName"  caption="商业类别名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>