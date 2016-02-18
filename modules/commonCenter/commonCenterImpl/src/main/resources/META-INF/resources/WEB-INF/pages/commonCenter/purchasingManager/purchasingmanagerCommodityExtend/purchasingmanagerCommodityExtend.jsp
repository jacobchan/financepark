<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerCommodityExtend" idKeys="commodityExtendId" caption="采购商品信息扩展列表"  panel="false"
				src="esb/web/purchasingmanagerCommodityExtendManager/getPagerPurchasingmanagerCommodityExtends.json" dataFormId="form_purchasingmanagerCommodityExtend"
				editSrc="esb/web/purchasingmanagerCommodityExtendManager/getPurchasingmanagerCommodityExtend.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCommodityExtendManager/removePurchasingmanagerCommodityExtend.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe" convert="businessType" caption="园区商业类型"/>
			<youi:fieldSelect property="commodityExtendInformationType"  caption="信息类型"/>
			<youi:fieldText property="commodityExtendDisplayName"  caption="显示名称"/>
			<youi:fieldText property="commodityExtendFieldName"  caption="字段名称"/>
			<youi:fieldSelect property="commodityExtendFieldType"  caption="字段类型"/>
			<youi:fieldSelect property="commodityExtendIsnotMust" convert="ISNOT"  caption="是否必须"/>
			<youi:fieldSelect property="commodityExtendIsnotDisplay" convert="ISNOT"  caption="是否显示"/>
		</youi:fieldLayout>

		<youi:gridCol property="parkBusinessTupe" convert="businessType" caption="园区商业类型" align="center" width="14%"/>
		<youi:gridCol property="commodityExtendFieldType"  caption="字段类型" align="center" width="14%"/>
		<youi:gridCol property="commodityExtendDisplayName"  caption="显示名称" align="center" width="16%"/>
		<youi:gridCol property="commodityExtendFieldName"  caption="字段名称" align="center" width="14%"/>
		<%-- <youi:gridCol property="commodityExtendContent"  caption="内容"/> --%>
		<youi:gridCol property="commodityExtendInformationType"  caption="信息类型" align="center" width="14%"/>
		<youi:gridCol property="commodityExtendIsnotMust" convert="ISNOT"  caption="是否必须" align="center" width="14%"/>
		<youi:gridCol property="commodityExtendIsnotDisplay"  convert="ISNOT"  caption="是否显示" align="center" width="14%"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-采购商品信息扩展编辑 -->
	<youi:form dialog="true" caption="采购商品信息扩展" id="form_purchasingmanagerCommodityExtend" action="esb/web/purchasingmanagerCommodityExtendManager/savePurchasingmanagerCommodityExtend.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldSelect property="parkBusinessTupe" convert="businessType" caption="园区商业类型"/>
			<youi:fieldSelect property="commodityExtendInformationType"  caption="信息类型"/>
			<youi:fieldText property="commodityExtendDisplayName"  caption="显示名称"/>
			<youi:fieldText property="commodityExtendFieldName"  caption="字段名称"/>
			<youi:fieldSelect property="commodityExtendFieldType"  caption="字段类型"/>
			<youi:fieldSelect property="commodityExtendIsnotMust" convert="ISNOT"  caption="是否必须"/>
			<youi:fieldSelect property="commodityExtendIsnotDisplay" convert="ISNOT"  caption="是否显示"/>
			<youi:fieldHidden property="commodityExtendId" caption="商品扩展信息ID"></youi:fieldHidden>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>