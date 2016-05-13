<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
				
	<youi:subpage caption="商户地址管理" height="460"
		width="800" subpageId="sb_merchant_addressManage"
		src="page/commonCenter.purchasingManager.purchasingmanagerMerchantAddress/purchasingmanagerMerchantAddress.html?purchasingmanagerMerchant.merchantId={merchantId}">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	
	<youi:grid id="grid_publicResoMerchant" idKeys="merchantId,merchantUrl,merchantAbout" caption="商户信息表列表"  panel="false"
				src="esb/web/purchasingmanagerMerchantManager/getPagerPublicResoMerchants.json" dataFormId="form_publicResoMerchant"
				editSrc="esb/web/purchasingmanagerMerchantManager/getPurchasingmanagerMerchant.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerMerchantManager/removePurchasingmanagerMerchant.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="merchantType.genreId" src="esb/web/purchasingmanagerGenreManager/getPublicResoOrderTypes.json" 
				show="genreName" code="genreId" caption="商户类型"/>
			<youi:fieldText property="merchantName"  caption="商户名称"/>
			<youi:fieldText property="merchantEnterpriseName"  caption="企业名称"/>
		</youi:fieldLayout>
		
		<youi:button name="addressManage" caption="地址管理" active="1"/>
		
		<youi:gridCol property="merchantName"  caption="商户名称" align="center" width="15%"/>
		<youi:gridCol property="merchantEnterpriseName"  caption="企业名称" align="center" width="15%"/>
		<youi:gridCol property="merchantType.genreName"  caption="商户类型" align="center" width="15%"/>
		<youi:gridCol property="merchantLinkman"  caption="联系人" align="center" width="10%"/>
		<youi:gridCol property="merchantLinkmanPhone"  caption="联系人电话" align="center" width="10%"/>
		<youi:gridCol property="merchantSendAddress"  caption="发货地址" align="center" width="17%"/>
		<youi:gridCol property="merchantReturnAddress"  caption="退货地址" align="center" width="18%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商户信息表编辑 -->
	<youi:form dialog="true" caption="商户信息表" id="form_publicResoMerchant" 
		action="esb/web/purchasingmanagerMerchantManager/savePurchasingmanagerMerchant.json">
		<youi:fieldLayout prefix="record" labelWidths="110,110" >
			<youi:fieldText property="merchantName"  caption="商户名称" notNull="true"/>
			<youi:fieldText property="merchantEnterpriseName"  caption="企业名称" notNull="true"/>
			<youi:fieldSelect property="merchantType.genreId" src="esb/web/purchasingmanagerGenreManager/getPublicResoOrderTypes.json" 
				show="genreName" code="genreId" caption="商户类型" notNull="true"/>
			<youi:fieldText property="merchantLinkman"  caption="联系人" notNull="true"/>
			<youi:fieldText property="merchantLinkmanPhone"  caption="联系人电话" notNull="true"/>
			<youi:fieldText property="merchantSendAddress"  caption="发货地址" notNull="true"/>
			<youi:fieldText property="merchantReturnAddress"  caption="退货地址" notNull="true"/>
			<youi:fieldText property="merchantUrl"  caption="商户网址" />
			<youi:fieldSwfupload property="merchantLogo" caption="商户LOGO" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="merchantAbout" column="2"  caption="商户简介" />
			<youi:fieldHidden property="merchantId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_addressManage">
		var selectRecord = $elem('grid_publicResoMerchant',pageId).grid('getSelectedRecord');
		var merchantId = selectRecord['merchantId'];
		$elem('subpage_sb_merchant_addressManage',pageId).subpage('open',{merchantId:merchantId},null,{merchantId:merchantId});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>