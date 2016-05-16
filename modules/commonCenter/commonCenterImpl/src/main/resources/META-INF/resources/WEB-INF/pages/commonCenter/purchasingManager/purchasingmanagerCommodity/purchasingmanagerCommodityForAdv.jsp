<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
	<youi:subpage caption="商品扩展信息" 
		width="800" subpageId="sb_commodity_extend"
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodityExtend/purchasingmanagerCommodityExtend.html?commodity.commodityId={commodityId}">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<youi:grid id="grid_purchasingmanagerCommodity" idKeys="commodityId" caption="商品信息列表"  panel="false"
				src="esb/web/purchasingmanagerPublicManager/getPagerPurchasingmanagerCommoditys.json" dataFormId="form_purchasingmanagerCommodity"
				editSrc="esb/web/purchasingmanagerPublicManager/getPurchasingmanagerCommodityLed.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerPublicManager/removePurchasingmanagerCommodity.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldHidden property="genreCode"  caption="广告位" defaultValue="0303"/>
			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldTree simple="false" popup="true" tree="${genreTree}" property="purchasingmanagerGenre.genreId" caption="商品类别" onlyLeaf="true"/>
			<youi:fieldText property="purchasingmanagerMerchant.merchantName"  caption="商户名称"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="commodityTitle"  caption="标题" align="center" width="15%"/>
		<youi:gridCol property="purchasingmanagerMerchant.merchantName"  caption="商户名称" align="center" width="9%"/>
		<youi:gridCol property="purchasingmanagerGenre.genreName"  caption="商品类别" align="center" width="8%"/>
		<youi:gridCol property="commodityPrice"  caption="标价" align="center" width="8%"/>
		<youi:gridCol property="commodityStock"  caption="库存" align="center" width="8%"/>
		<youi:gridCol property="commodityDescribe"  caption="描述" align="center" width="22%"/>
		<youi:gridCol property="commodityUpTime"  caption="上架时间" align="center" width="15%"/>
		<youi:gridCol property="commodityDownTime"  caption="下架时间" align="center" width="15%"/>
		<youi:gridCol property="purchasingmanagerGenre.genreId"  caption="商品类别" align="center" width="0"/>
		
		<%-- <youi:button name="commodity_extend" active="1" caption="商品扩展属性"/> --%>
		<%-- <youi:button name="veiwCommodity" active="1" caption="查看详情"/> --%>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品信息编辑 -->
	<youi:form dialog="true" caption="商品信息" id="form_purchasingmanagerCommodity" 
		action="esb/web/purchasingmanagerPublicManager/saveCommodityAndPropertyForLed.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
		    <youi:fieldHidden property="genreCode"  caption="广告" defaultValue="0303"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>		
			<youi:fieldText property="billboard.size" caption="尺寸" notNull="true"/>
			<youi:fieldText property="billboard.unit"  caption="单位" notNull="true"/>
			<youi:fieldText property="billboard.loopType"  caption="轮播方式" notNull="true"/>	
			<youi:fieldText property="billboard.adr"  caption="地址" notNull="true"/>			
			<%-- <youi:fieldSelect property="genreId" caption="商品类别"  src="esb/web/purchasingmanagerPublicManager/getRecordsByGenreCode.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="genreId" show="genreName"/> --%>
			<youi:fieldSelect property="purchasingmanagerMerchant.merchantId" caption="所属商户" src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="merchantId" show="merchantName"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2" notNull="true"/>
			<youi:fieldHidden property="commodityId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-查看详情 
	<youi:form dialog="true" caption="商品详情" id="form_purchasingmanagerCommodity_view" action="esb/web/purchasingmanagerCommodityManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldLabel property="commodityTitle"  caption="标题"/>
			<youi:fieldLabel property="parkBusinessTupe"  caption="园区商业类型" convert="businessType" />
			<youi:fieldLabel property="commodityIsnotDisplayStock" convert="bool"  caption="是否显示库存"/>
			<youi:fieldLabel property="commodityPrice"  caption="标价"/>
			<youi:fieldLabel property="commodityBrand"  caption="品牌"/>
			<youi:fieldLabel property="commodityOriginalPrice"  caption="原价"/>
			<youi:fieldLabel property="commodityHighestPrice"  caption="最高价"/>
			<youi:fieldLabel property="commodityLowestPrice"  caption="最低价"/>
			<youi:fieldLabel property="purchasingmanagerGenre.genreName"  caption="商品类别"/>
			<youi:fieldLabel property="commodityUpTime"  caption="上架时间" />
			<youi:fieldLabel property="commodityDownTime"  caption="下架时间" />
			<youi:fieldLabel property="commodityStock"  caption="库存"/>
			<youi:fieldLabel property="commodityDescribe"  caption="描述" column="2"/>
			<youi:fieldHidden property="commodityId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>-->
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_commodity_extend">
		var selectRecord = $elem('grid_purchasingmanagerCommodity',pageId).grid('getSelectedRecord');
		var commodityId = selectRecord['commodityId'];
		var genreId = selectRecord['purchasingmanagerGenre.genreId'];
		$elem('subpage_sb_commodity_extend',pageId).subpage('open',{commodityId:commodityId},null,{commodityId:commodityId});
	</youi:func>
	<youi:func name="func_grid_veiwCommodity">
		var selectRecord = $elem('grid_purchasingmanagerCommodity',pageId).grid('getSelectedRecord');
		$elem('form_purchasingmanagerCommodity_view',pageId).form("reset").form('fillRecord',selectRecord).form('open');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>