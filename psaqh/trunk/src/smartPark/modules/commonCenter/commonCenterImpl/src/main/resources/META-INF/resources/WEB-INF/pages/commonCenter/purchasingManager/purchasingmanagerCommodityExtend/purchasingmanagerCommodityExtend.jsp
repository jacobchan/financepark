<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************页面样式Start********************************-->
	<style type="text/css">
		.pagination > li.addRow{display: none;}
		.pagination > li.removeRow{display: none;}
	</style>
	<!--**********************************页面样式End**********************************-->
	<!-- form-商品信息扩展编辑 -->
	<youi:grid id="grid_purCommodityExtend" idKeys="commodityExtendId" caption="商品扩展信息"  panel="false" scrollHeight="240"
				src="esb/web/purchasingmanagerCommodityExtendManager/getPagerCommodityExts.json" dataFormId="form_sFproManage"
				saveRowsSrcs="esb/web/purchasingmanagerCommodityExtendManager/saveCommodityExts.json"
				showCheckbox="false" 
				submit="NOT" reset="NOT" save="保存" usePager="fasle" editable="true" >
		<youi:fieldLayout>
			<youi:fieldHidden property="commodity.commodityId"  caption="商品ID"/>
		</youi:fieldLayout>
		<youi:gridCol width="30%" property="purchasingmanagerGenreProperty.genrePropertyDisplayName" caption="字段显示名称"/>
		<youi:gridCol width="30%" property="purchasingmanagerGenreProperty.genrePropertyFieldName" caption="字段名称"/>
		<youi:gridCol editor="fieldText" width="40%" property="commodityExtendContent"  caption="字段值"/>
		<youi:gridCol width="0" property="purchasingmanagerGenreProperty.genrePropertyId" caption="字段名称"/>
	</youi:grid>
	
	<!--**********************************页面函数Start********************************-->
	<!--**********************************页面函数End**********************************-->
</youi:page>