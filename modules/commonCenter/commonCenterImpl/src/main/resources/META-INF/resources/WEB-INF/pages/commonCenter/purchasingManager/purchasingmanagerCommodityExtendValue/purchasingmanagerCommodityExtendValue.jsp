<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerCommodityExtendValue" idKeys="commodityExtendValueId" caption="商品扩展属性值表列表"  panel="false"
				src="esb/web/purchasingmanagerCommodityExtendValueManager/getPagerPurchasingmanagerCommodityExtendValues.json" dataFormId="form_purchasingmanagerCommodityExtendValue"
				editSrc="esb/web/purchasingmanagerCommodityExtendValueManager/getPurchasingmanagerCommodityExtendValue.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCommodityExtendValueManager/removePurchasingmanagerCommodityExtendValue.json">
		<youi:fieldLayout>
			<youi:fieldText property="commodityExtendValueDisplayContent"  caption="显示内容"/>

			<youi:fieldText property="commodityExtendValueDisplayName"  caption="显示名称"/>
			<youi:fieldText property="commodityExtendValueFieldName"  caption="字段名称"/>
		</youi:fieldLayout>
		<youi:gridCol property="commodityExtendValueDisplayContent"  caption="显示内容"/>

		<youi:gridCol property="commodityExtendValueDisplayName"  caption="显示名称"/>
		<youi:gridCol property="commodityExtendValueFieldName"  caption="字段名称"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品扩展属性值表编辑 -->
	<youi:form dialog="true" caption="商品扩展属性值表" id="form_purchasingmanagerCommodityExtendValue" action="esb/web/purchasingmanagerCommodityExtendValueManager/savePurchasingmanagerCommodityExtendValue.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="commodityExtendValueDisplayContent"  caption="显示内容"/>
			<youi:fieldText property="commodityExtendValueId"  caption="值序列"/>
			<youi:fieldText property="commodityExtendValueDisplayName"  caption="显示名称"/>
			<youi:fieldText property="commodityExtendValueFieldName"  caption="字段名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>