<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="商品扩展信息" 
		width="800" subpageId="sb_commodity_extend"
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodityExtendValue/purchasingmanagerCommodityExtendValue.html?purchasingmanagerCommodity.commodityId={commodityId}">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<youi:grid id="grid_purchasingmanagerCommodity" idKeys="commodityId" caption="商品信息列表"  panel="false"
				src="esb/web/purchasingmanagerCommodityManager/getPagerPurchasingmanagerCommoditys.json" dataFormId="form_purchasingmanagerCommodity"
				editSrc="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommodity.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCommodityManager/removePurchasingmanagerCommodity.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe"  convert="businessType"  caption="园区商业类型"/>
			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldText property="commodityPrice"  caption="标价"/>
			<youi:fieldText property="commodityStock"  caption="库存"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="parkBusinessTupe" convert="businessType"  caption="园区商业类型" align="center" width="13%"/>
		<youi:gridCol property="commodityTitle"  caption="标题" align="center" width="13%"/>
		<youi:gridCol property="commodityDescribe"  caption="描述" align="center" width="8%"/>
		<youi:gridCol property="commodityPrice"  caption="标价" align="center" width="8%"/>
		<youi:gridCol property="commodityOriginalPrice"  caption="原价" align="center" width="8%"/>
		<youi:gridCol property="commodityHighestPrice"  caption="最高价" align="center" width="8%"/>
		<youi:gridCol property="commodityBrand"  caption="品牌" align="center" width="8%"/>
		<youi:gridCol property="commodityIsnotDisplayStock"  convert="ISNOT" caption="是否显示库存" align="center" width="10%"/>
		<youi:gridCol property="commodityStock"  caption="库存" align="center" width="8%"/>
		<youi:gridCol property="commodityUpTime"  caption="上架时间" align="center" width="8%"/>
		<youi:gridCol property="commodityDownTime"  caption="下架时间" align="center" width="8%"/>
		
		<youi:button name="commodity_extend" active="1" caption="商品扩展属性"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品信息编辑 -->
	<youi:form dialog="true" caption="商品信息" id="form_purchasingmanagerCommodity" action="esb/web/purchasingmanagerCommodityManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldSelect property="parkBusinessTupe"  caption="园区商业类型" convert="businessType" />
			<youi:fieldSelect property="commodityIsnotDisplayStock" convert="ISNOT"  caption="是否显示库存"/>
			<youi:fieldText property="commodityPrice"  caption="标价"/>
			<youi:fieldText property="commodityBrand"  caption="品牌"/>
			<youi:fieldText property="commodityOriginalPrice"  caption="原价"/>
			<youi:fieldText property="commodityHighestPrice"  caption="最高价"/>
			<youi:fieldText property="commodityLowestPrice"  caption="最低价"/>
			<youi:fieldCalendar property="commodityUpTime"  caption="上架时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss"/>
			<youi:fieldCalendar property="commodityDownTime"  caption="下架时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss"/>
			<youi:fieldText property="commodityStock"  caption="库存"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像"/>
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2"/>
			<youi:fieldHidden property="commodityId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_commodity_extend">
		var selectRecord = $elem('grid_purchasingmanagerCommodity',pageId).grid('getSelectedRecord');
		var commodityId = selectRecord['commodityId'];
		$elem('subpage_sb_commodity_extend',pageId).subpage('open',{commodityId:commodityId},null,{commodityId:commodityId});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>