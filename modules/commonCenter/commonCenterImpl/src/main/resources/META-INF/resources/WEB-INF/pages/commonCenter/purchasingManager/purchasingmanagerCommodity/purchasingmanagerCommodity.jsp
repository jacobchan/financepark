<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerCommodity" idKeys="commodityId" caption="商品信息列表"  panel="false"
				src="esb/web/purchasingmanagerCommodityManager/getPagerPurchasingmanagerCommoditys.json" dataFormId="form_purchasingmanagerCommodity"
				editSrc="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommodity.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCommodityManager/removePurchasingmanagerCommodity.json">
		<youi:fieldLayout>
			<youi:fieldText property="companyServerId"  caption="企业服务购物车ID"/>
			<youi:fieldText property="commodityDescribe"  caption="描述"/>
			<youi:fieldText property="commodityImage"  caption="图像"/>

			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldText property="parkBusinessTupe"  caption="园区商业类型"/>
			<youi:fieldText property="favoritGoodsId"  caption="商品收藏表ID"/>
			<youi:fieldText property="commodityHighestPrice"  caption="最高价"/>
			<youi:fieldText property="commodityIsnotDisplayStock"  caption="是否显示库存"/>
			<youi:fieldText property="companyCateringId"  caption="餐饮购物车ID"/>
			<youi:fieldText property="commodityPrice"  caption="标价"/>
			<youi:fieldText property="commodityCoverImage"  caption="封面图片"/>
			<youi:fieldText property="commodityOriginalPrice"  caption="原价"/>
			<youi:fieldText property="commodityDownTime"  caption="下架时间"/>
			<youi:fieldText property="companyGroupId"  caption="集采购物车ID"/>
			<youi:fieldText property="commodityLowestPrice"  caption="最低价"/>
			<youi:fieldText property="commodityUpTime"  caption="上架时间"/>
			<youi:fieldText property="commodityStock"  caption="库存"/>
		</youi:fieldLayout>
		<youi:gridCol property="companyServerId"  caption="企业服务购物车ID"/>
		<youi:gridCol property="commodityDescribe"  caption="描述"/>
		<youi:gridCol property="commodityImage"  caption="图像"/>

		<youi:gridCol property="commodityTitle"  caption="标题"/>
		<youi:gridCol property="parkBusinessTupe"  caption="园区商业类型"/>
		<youi:gridCol property="favoritGoodsId"  caption="商品收藏表ID"/>
		<youi:gridCol property="commodityHighestPrice"  caption="最高价"/>
		<youi:gridCol property="commodityIsnotDisplayStock"  caption="是否显示库存"/>
		<youi:gridCol property="companyCateringId"  caption="餐饮购物车ID"/>
		<youi:gridCol property="commodityPrice"  caption="标价"/>
		<youi:gridCol property="commodityCoverImage"  caption="封面图片"/>
		<youi:gridCol property="commodityOriginalPrice"  caption="原价"/>
		<youi:gridCol property="commodityDownTime"  caption="下架时间"/>
		<youi:gridCol property="companyGroupId"  caption="集采购物车ID"/>
		<youi:gridCol property="commodityLowestPrice"  caption="最低价"/>
		<youi:gridCol property="commodityUpTime"  caption="上架时间"/>
		<youi:gridCol property="commodityStock"  caption="库存"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品信息编辑 -->
	<youi:form dialog="true" caption="商品信息" id="form_purchasingmanagerCommodity" action="esb/web/purchasingmanagerCommodityManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="companyServerId"  caption="企业服务购物车ID"/>
			<youi:fieldText property="commodityDescribe"  caption="描述"/>
			<youi:fieldText property="commodityImage"  caption="图像"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="commodityTitle"  caption="标题"/>
			<youi:fieldText property="parkBusinessTupe"  caption="园区商业类型"/>
			<youi:fieldText property="favoritGoodsId"  caption="商品收藏表ID"/>
			<youi:fieldText property="commodityHighestPrice"  caption="最高价"/>
			<youi:fieldText property="commodityIsnotDisplayStock"  caption="是否显示库存"/>
			<youi:fieldText property="companyCateringId"  caption="餐饮购物车ID"/>
			<youi:fieldText property="commodityPrice"  caption="标价"/>
			<youi:fieldText property="commodityCoverImage"  caption="封面图片"/>
			<youi:fieldText property="commodityOriginalPrice"  caption="原价"/>
			<youi:fieldText property="commodityDownTime"  caption="下架时间"/>
			<youi:fieldText property="companyGroupId"  caption="集采购物车ID"/>
			<youi:fieldText property="commodityLowestPrice"  caption="最低价"/>
			<youi:fieldText property="commodityUpTime"  caption="上架时间"/>
			<youi:fieldText property="commodityStock"  caption="库存"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>