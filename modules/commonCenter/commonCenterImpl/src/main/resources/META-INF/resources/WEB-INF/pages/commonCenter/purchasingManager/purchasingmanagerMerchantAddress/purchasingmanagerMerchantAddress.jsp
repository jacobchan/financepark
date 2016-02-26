<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerMerchantAddress" idKeys="merchantAddressId" caption="商户地址库列表"  panel="false"
				src="esb/web/purchasingmanagerMerchantAddressManager/getPagerPurchasingmanagerMerchantAddresss.json" dataFormId="form_purchasingmanagerMerchantAddress"
				editSrc="esb/web/purchasingmanagerMerchantAddressManager/getPurchasingmanagerMerchantAddress.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerMerchantAddressManager/removePurchasingmanagerMerchantAddress.json" submit="NOT" reset="NOT">
		<youi:fieldLayout>
			<youi:fieldHidden property="purchasingmanagerMerchant.merchantId"  caption="商户ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="merchantAddressLinkman"  caption="联系人" align="center" width="15%"/>
		<youi:gridCol property="merchantAddressPhone"  caption="联系电话" align="center" width="15%"/>
		<%-- <youi:gridCol property="merchantAddressIsnotDefault" convert="ISNOT" align="center"  caption="是否默认" width="10%"/> --%>
		<youi:gridCol property="merchantAddressAddress"  caption="地址" align="left" width="70%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商户地址库编辑 -->
	<youi:form dialog="true" caption="商户地址库" id="form_purchasingmanagerMerchantAddress" 
		action="esb/web/purchasingmanagerMerchantAddressManager/savePurchasingmanagerMerchantAddress.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="merchantAddressLinkman"  caption="联系人" notNull="true"/>
			<youi:fieldText property="merchantAddressPhone"  caption="联系电话" notNull="true"/>
			<youi:fieldArea property="merchantAddressAddress"  caption="地址" column="2" notNull="true"/>
			<%-- <youi:fieldSelect property="merchantAddressIsnotDefault" convert="bool"  caption="是否默认"/> --%>
			<youi:fieldHidden property="merchantAddressId"  caption="地址ID"/>
			<youi:fieldHidden property="purchasingmanagerMerchant.merchantId"  caption="商户ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>