<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerMerchant" idKeys="merchantId" caption="商户信息表列表"  panel="false"
				src="esb/web/purchasingmanagerMerchantManager/getPagerPurchasingmanagerMerchants.json" dataFormId="form_purchasingmanagerMerchant"
				editSrc="esb/web/purchasingmanagerMerchantManager/getPurchasingmanagerMerchant.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerMerchantManager/removePurchasingmanagerMerchant.json">
		<youi:fieldLayout>
			<youi:fieldText property="merchantReturnAddress"  caption="退货地址"/>
			<youi:fieldText property="merchantLinkman"  caption="联系人"/>
			<youi:fieldText property="merchantLinkmanPhone"  caption="联系人电话"/>
			<youi:fieldText property="merchantType"  caption="商户类型"/>
			<youi:fieldText property="parkBusinessTupe"  caption="园区商业类型"/>
			<youi:fieldText property="merchantEnterpriseName"  caption="企业名称"/>
			<youi:fieldText property="merchantName"  caption="商户名称"/>

			<youi:fieldText property="merchantSendAddress"  caption="发货地址"/>
		</youi:fieldLayout>
		<youi:gridCol property="merchantReturnAddress"  caption="退货地址"/>
		<youi:gridCol property="merchantLinkman"  caption="联系人"/>
		<youi:gridCol property="merchantLinkmanPhone"  caption="联系人电话"/>
		<youi:gridCol property="merchantType"  caption="商户类型"/>
		<youi:gridCol property="parkBusinessTupe"  caption="园区商业类型"/>
		<youi:gridCol property="merchantEnterpriseName"  caption="企业名称"/>
		<youi:gridCol property="merchantName"  caption="商户名称"/>

		<youi:gridCol property="merchantSendAddress"  caption="发货地址"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商户信息表编辑 -->
	<youi:form dialog="true" caption="商户信息表" id="form_purchasingmanagerMerchant" action="esb/web/purchasingmanagerMerchantManager/savePurchasingmanagerMerchant.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="merchantReturnAddress"  caption="退货地址"/>
			<youi:fieldText property="merchantLinkman"  caption="联系人"/>
			<youi:fieldText property="merchantLinkmanPhone"  caption="联系人电话"/>
			<youi:fieldText property="merchantType"  caption="商户类型"/>
			<youi:fieldText property="parkBusinessTupe"  caption="园区商业类型"/>
			<youi:fieldText property="merchantEnterpriseName"  caption="企业名称"/>
			<youi:fieldText property="merchantName"  caption="商户名称"/>
			<youi:fieldText property="merchantId"  caption="商户ID"/>
			<youi:fieldText property="merchantSendAddress"  caption="发货地址"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>