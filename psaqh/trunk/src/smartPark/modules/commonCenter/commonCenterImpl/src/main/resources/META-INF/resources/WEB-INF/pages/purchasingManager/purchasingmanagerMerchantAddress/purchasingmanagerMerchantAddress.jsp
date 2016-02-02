<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerMerchantAddress" idKeys="merchantAddressId" caption="商户地址库列表"  panel="false"
				src="esb/web/purchasingmanagerMerchantAddressManager/getPagerPurchasingmanagerMerchantAddresss.json" dataFormId="form_purchasingmanagerMerchantAddress"
				editSrc="esb/web/purchasingmanagerMerchantAddressManager/getPurchasingmanagerMerchantAddress.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerMerchantAddressManager/removePurchasingmanagerMerchantAddress.json">
		<youi:fieldLayout>
			<youi:fieldText property="merchantAddressAddress"  caption="地址"/>
			<youi:fieldText property="merchantAddressPhone"  caption="联系电话"/>
			<youi:fieldText property="merchantAddressIsnotDefault"  caption="是否默认"/>

			<youi:fieldText property="merchantAddressLinkman"  caption="联系人"/>
		</youi:fieldLayout>
		<youi:gridCol property="merchantAddressAddress"  caption="地址"/>
		<youi:gridCol property="merchantAddressPhone"  caption="联系电话"/>
		<youi:gridCol property="merchantAddressIsnotDefault"  caption="是否默认"/>

		<youi:gridCol property="merchantAddressLinkman"  caption="联系人"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商户地址库编辑 -->
	<youi:form dialog="true" caption="商户地址库" id="form_purchasingmanagerMerchantAddress" action="esb/web/purchasingmanagerMerchantAddressManager/savePurchasingmanagerMerchantAddress.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="merchantAddressAddress"  caption="地址"/>
			<youi:fieldText property="merchantAddressPhone"  caption="联系电话"/>
			<youi:fieldText property="merchantAddressIsnotDefault"  caption="是否默认"/>
			<youi:fieldText property="merchantAddressId"  caption="地址ID"/>
			<youi:fieldText property="merchantAddressLinkman"  caption="联系人"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>