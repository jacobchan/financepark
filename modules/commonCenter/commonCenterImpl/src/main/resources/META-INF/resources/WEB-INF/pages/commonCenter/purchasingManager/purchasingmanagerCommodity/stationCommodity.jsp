<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="商品扩展信息" 
		width="800" subpageId="sb_commodity_extend"
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodityExtend/purchasingmanagerCommodityExtend.html?commodity.commodityId={commodityId}">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<youi:grid id="grid_stationCommodity" idKeys="commodityId,purchasingmanagerMerchant.merchantId" caption="商品信息列表"  panel="false"
				src="esb/web/purchasingmanagerCommodityManager/getPagerStationCommoditys.json" dataFormId="form_stationCommodity"
				editSrc="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommodity.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCommodityManager/removePurchasingmanagerCommodity.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldText property="purchasingmanagerMerchant.merchantName"  caption="商户名称"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="commodityTitle"  caption="标题" align="center" width="15%"/>
		<youi:gridCol property="purchasingmanagerMerchant.merchantName"  caption="商户名称" align="center" width="15%"/>
		<youi:gridCol property="commodityPrice"  caption="标价" align="center" width="10%"/>
		<youi:gridCol property="commodityStock"  caption="库存" align="center" width="10%"/>
		<youi:gridCol property="commodityDescribe"  caption="描述" align="center" width="20%"/>
		<youi:gridCol property="commodityUpTime"  caption="上架时间" align="center" width="15%"/>
		<youi:gridCol property="commodityDownTime"  caption="下架时间" align="center" width="15%"/>
		<youi:gridCol property="genreId"  caption="商品类别" align="center" width="0"/>
		
		<youi:button name="commodity_extend" active="1" caption="商品扩展属性"/>
		<%-- <youi:button name="veiwCommodity" active="1" caption="查看详情"/> --%>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品信息编辑 -->
	<youi:form dialog="true" caption="商品信息" id="form_stationCommodity" 
		action="esb/web/purchasingmanagerCommodityManager/saveStationCommodity.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>
			<%-- <youi:fieldSelect property="purchasingmanagerMerchant.merchantId" show="merchantName" code="merchantId" notNull="true"
				src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" caption="所属商户"/> --%>
			<youi:fieldText property="commodityStock"  caption="库存"/>
			<youi:fieldSelect property="commodityIsnotDisplayStock" convert="bool"  caption="是否显示库存" notNull="true"/>
			<youi:fieldCalendar property="commodityUpTime"  caption="上架时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldCalendar property="commodityDownTime"  caption="下架时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2" notNull="true"/>
			<youi:fieldHidden property="commodityId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_commodity_extend">
		var selectRecord = $elem('grid_stationCommodity',pageId).grid('getSelectedRecord');
		var commodityId = selectRecord['commodityId'];
		$elem('subpage_sb_commodity_extend',pageId).subpage('open',{commodityId:commodityId},null,{commodityId:commodityId});
	</youi:func>
	<youi:func name="func_grid_veiwCommodity">
		var selectRecord = $elem('grid_stationCommodity',pageId).grid('getSelectedRecord');
		$elem('form_stationCommodity_view',pageId).form("reset").form('fillRecord',selectRecord).form('open');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>