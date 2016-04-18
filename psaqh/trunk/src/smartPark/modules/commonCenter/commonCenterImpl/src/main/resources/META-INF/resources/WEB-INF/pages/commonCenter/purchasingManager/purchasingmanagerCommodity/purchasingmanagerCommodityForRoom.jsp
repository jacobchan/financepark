<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
	<%-- <youi:subpage caption="商品扩展信息" 
		width="800" subpageId="sb_commodity_extend"
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodityExtend/purchasingmanagerCommodityExtend.html?commodity.commodityId={commodityId}">
	</youi:subpage> --%>
	
	<youi:subpage
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodity/purchasingmanagerCommodityExtendForRoom.html"
		subpageId="addSFproManage" height="600" caption="会议室及其扩展属性增加">
	</youi:subpage>
		<youi:subpage
		src="page/commonCenter.purchasingManager.purchasingmanagerCommodity/purchasingmanagerCommodityExtendForRoomUpdate.html?commodityId={commodityId}" subpageId="updateCommodity" height="600" caption="会议室及其扩展属性修改">
	</youi:subpage>
	
	<!--**********************************子页面**********************************-->
	<youi:grid id="grid_purchasingmanagerCommodity" idKeys="commodityId" caption="商品信息列表"  panel="false"
				src="esb/web/purchasingmanagerPublicManager/getPagerPurchasingmanagerCommoditys.json" dataFormId="form_purchasingmanagerCommodity"
				editSrc="esb/web/purchasingmanagerPublicManager/getPurchasingmanagerCommodity.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerPublicManager/removePurchasingmanagerCommodity.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldHidden property="genreCode"  caption="会议室" defaultValue="0301"/>
			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldTree simple="false" popup="true" tree="${genreTree}" property="genreId" caption="商品类别" onlyLeaf="true"/>
			<youi:fieldText property="purchasingmanagerMerchant.merchantName"  caption="商户名称"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="commodityTitle"  caption="标题" align="center" width="20%"/>
		<youi:gridCol property="purchasingmanagerMerchant.merchantName"  caption="商户名称" align="center" width="20%"/>
		<youi:gridCol property="purchasingmanagerGenre.genreName"  caption="商品类别" align="center" width="20%"/>
	<%-- 	<youi:gridCol property="purchasingmanagerGenre.genreName"  caption="商品类别" align="center" width="8%"/> --%>
		<youi:gridCol property="commodityPrice"  caption="标价" align="center" width="10%"/>
		<youi:gridCol property="commodityDescribe"  caption="描述" align="center" width="30%"/>
		<youi:gridCol property="genreId"  caption="商品类别" align="center" width="0"/>
		
		<%-- <youi:button name="commodityAdd" caption="增加"/> --%>
		<youi:button active="1" name="commodityUpdate" caption="修改"/>
		<%-- <youi:button name="veiwCommodity" active="1" caption="查看详情"/> --%>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
		   <%--  <youi:button name="edit" caption="修改"/>  --%>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品信息编辑 -->
	<youi:form dialog="true" caption="商品信息" id="form_purchasingmanagerCommodity" 
		action="esb/web/purchasingmanagerPublicManager/saveCommodityAndPropertyForRoom.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
		    <youi:fieldHidden property="genreCode"  caption="会议室" defaultValue="0301"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" expression="^[0-9]*$" expressionMessage="请输入正确数值" notNull="true"/>
			<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="meetingRoom.adr"  caption="会议室地址" onlyLeaf="true" notNull="true"/>
			<youi:fieldSelect property="meetingRoom.gm"  caption="规模人数" convert="roomGm" notNull="true"/>
			<youi:fieldSelect property="meetingRoom.lx"  caption="会议室类型" convert="roomType" notNull="true"/>
			<youi:fieldSelect property="meetingRoom.tyy"  caption="是否有投影仪" convert="roomProjector" notNull="true"/>
			<%-- <youi:fieldSelect property="genreId" caption="商品类别"  src="esb/web/purchasingmanagerPublicManager/getRecordsByGenreCode.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="genreId" show="genreName"/> --%>
			<youi:fieldSelect property="purchasingmanagerMerchant.merchantId" caption="所属商户" src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="merchantId" show="merchantName"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2" notNull="true"/>
			<youi:fieldHidden property="commodityId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
		<youi:func name="func_grid_commodityAdd">
		var subpageElement = $elem('subpage_addSFproManage',pageId);
		//打开子页面
		subpageElement.subpage('open',null,null,null);
	</youi:func>
<%-- 	<youi:func name="func_grid_commodity_extend">
		var selectRecord = $elem('grid_purchasingmanagerCommodity',pageId).grid('getSelectedRecord');
		var commodityId = selectRecord['commodityId'];
		var genreId = selectRecord['purchasingmanagerGenre.genreId'];
		$elem('subpage_sb_commodity_extend',pageId).subpage('open',{commodityId:commodityId},null,{commodityId:commodityId});
	</youi:func> --%>
	<youi:func name="func_grid_commodityUpdate">
		var selectRecord = $elem('grid_purchasingmanagerCommodity',pageId).grid('getSelectedRecord');
		var commodityId = selectRecord['commodityId'];
		var subpageElement = $elem('subpage_updateCommodity',pageId);
		subpageElement.subpage('open',{commodityId:commodityId},null,{commodityId:commodityId});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>