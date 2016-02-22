<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!--**********************************子页面**********************************-->
				
	<youi:subpage caption="商户地址管理" height="460"
		width="800" subpageId="sb_merchant_addressManage"
		src="page/commonCenter.purchasingManager.purchasingmanagerMerchantAddress/purchasingmanagerMerchantAddress.html?purchasingmanagerMerchant.merchantId={merchantId}">
	</youi:subpage>
	<!--**********************************子页面**********************************-->
	
	<youi:grid id="grid_purchasingmanagerMerchant" idKeys="merchantId" caption="商户信息表列表"  panel="false"
				src="esb/web/purchasingmanagerMerchantManager/getPagerPurchasingmanagerMerchants.json" dataFormId="form_purchasingmanagerMerchant"
				editSrc="esb/web/purchasingmanagerMerchantManager/getPurchasingmanagerMerchant.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerMerchantManager/removePurchasingmanagerMerchant.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe" convert="businessType"  caption="园区商业类型"/>
			<youi:fieldSelect property="merchantType" convert="merchant_type"   caption="商户类型"/>
			<youi:fieldText property="merchantName"  caption="商户名称"/>
			<youi:fieldText property="merchantEnterpriseName"  caption="企业名称"/>
		</youi:fieldLayout>
		
		<youi:button name="addressManage" caption="地址管理" active="1"/>
		
		<youi:gridCol property="merchantName"  caption="商户名称" align="center" width="15%"/>
		<youi:gridCol property="merchantEnterpriseName"  caption="企业名称" align="center" width="15%"/>
		<youi:gridCol property="merchantType"  caption="商户类型" align="center" convert="merchant_type" width="15%"/>
		<youi:gridCol property="parkBusinessTupe"  caption="园区商业类型" align="center" convert="businessType" width="15%"/>
		<youi:gridCol property="merchantLinkman"  caption="联系人" align="center" width="10%"/>
		<youi:gridCol property="merchantLinkmanPhone"  caption="联系人电话" align="center" width="10%"/>
		<youi:gridCol property="merchantSendAddress"  caption="发货地址" align="center" width="10%"/>
		<youi:gridCol property="merchantReturnAddress"  caption="退货地址" align="center" width="10%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商户信息表编辑 -->
	<youi:form dialog="true" caption="商户信息表" id="form_purchasingmanagerMerchant" 
		action="esb/web/purchasingmanagerMerchantManager/savePurchasingmanagerMerchant.json">
		<youi:fieldLayout prefix="record" labelWidths="110,110" >
			<youi:fieldText property="merchantName"  caption="商户名称"/>
			<youi:fieldText property="merchantEnterpriseName"  caption="企业名称"/>
			<youi:fieldSelect property="merchantType"  caption="商户类型" convert="merchant_type"/>
			<youi:fieldSelect property="parkBusinessTupe"  caption="园区商业类型" convert="businessType"/>
			<youi:fieldText property="merchantLinkman"  caption="联系人"/>
			<youi:fieldText property="merchantLinkmanPhone"  caption="联系人电话"/>
			<youi:fieldText property="merchantSendAddress"  caption="发货地址"/>
			<youi:fieldText property="merchantReturnAddress"  caption="退货地址"/>
			<youi:fieldHidden property="merchantId"  caption="商品ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-商户地址库编辑 -->
	<youi:form dialog="true" caption="商户地址库" id="form_purchasingmanagerMerchantAddress" action="esb/web/purchasingmanagerMerchantAddressManager/savePurchasingmanagerMerchantAddress.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="merchantAddressAddress"  caption="地址"/>
			<youi:fieldText property="merchantAddressLinkman"  caption="联系人"/>
			<youi:fieldText property="merchantAddressId"  caption="地址ID"/>
			<youi:fieldSelect property="merchantAddressIsnotDefault" convert="bool" caption="是否默认"/>
			<youi:fieldText property="merchantAddressPhone"  caption="联系电话"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_addressManage">
		var selectRecord = $elem('grid_purchasingmanagerMerchant',pageId).grid('getSelectedRecord');
		var merchantId = selectRecord['merchantId'];
		$elem('subpage_sb_merchant_addressManage',pageId).subpage('open',{merchantId:merchantId},null,{merchantId:merchantId});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>