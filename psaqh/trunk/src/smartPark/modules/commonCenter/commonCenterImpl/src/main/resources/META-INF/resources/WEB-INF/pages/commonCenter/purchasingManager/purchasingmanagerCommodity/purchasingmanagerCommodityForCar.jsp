<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
	<youi:subpage
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodity/purchasingmanagerCommodityExtendForCarUpdate.html?commodityId={commodityId}" subpageId="updateCommodity" height="600" caption="车辆及其扩展属性修改">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	<youi:grid id="grid_purchasingmanagerCommodity" idKeys="commodityId" caption="商品信息列表"  panel="false"
				src="esb/web/purchasingmanagerPublicManager/getPagerPurchasingmanagerCommoditys.json" dataFormId="form_purchasingmanagerCommodity"
				editSrc="esb/web/purchasingmanagerPublicManager/getPurchasingmanagerCommodity.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerPublicManager/removePurchasingmanagerCommodity.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldHidden property="genreCode"  caption="车辆" defaultValue="0302"/>
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
		
		<youi:button active="1" name="commodityUpdate" caption="修改"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<%-- <youi:button name="edit" caption="修改"/> --%>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品信息编辑 -->
	<youi:form dialog="true" caption="商品信息" id="form_purchasingmanagerCommodity" 
		action="esb/web/purchasingmanagerPublicManager/saveCommodityAndPropertyForCar.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
		    <youi:fieldHidden property="genreCode"  caption="车辆" defaultValue="0302"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>
			<youi:fieldSelect property="stalls" caption="档位" convert="stalls" notNull="true"/>
			<youi:fieldText property="seat"  caption="座位" notNull="true"/>
			<youi:fieldText property="licensePlate"  caption="车牌" notNull="true"/>
			 <youi:fieldSelect property="purchasingmanagerGenre.genreId" caption="商品类别"  src="esb/web/purchasingmanagerPublicManager/getRecordsByGenreCode.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="genreId" show="genreName"/>
			<youi:fieldSelect property="purchasingmanagerMerchant.merchantId" caption="所属商户" src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" parents="purchasingmanagerGenre.genreId" parentsAlias="purchasingmanagerGenre.genreId" notNull="true" code="merchantId" show="merchantName"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_commodityUpdate">
		var selectRecord = $elem('grid_purchasingmanagerCommodity',pageId).grid('getSelectedRecord');
		var commodityId = selectRecord['commodityId'];
		var subpageElement = $elem('subpage_updateCommodity',pageId);
		subpageElement.subpage('open',{commodityId:commodityId},null,{commodityId:commodityId});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>