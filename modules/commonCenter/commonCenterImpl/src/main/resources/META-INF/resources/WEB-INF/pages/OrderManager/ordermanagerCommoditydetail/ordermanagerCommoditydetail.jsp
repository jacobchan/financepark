<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerCommoditydetail" idKeys="commoditydetailId" caption="订单商品明细列表"  panel="false"
				src="esb/web/ordermanagerCommoditydetailManager/getPagerOrdermanagerCommoditydetails.json" dataFormId="form_ordermanagerCommoditydetail"
				editSrc="esb/web/ordermanagerCommoditydetailManager/getOrdermanagerCommoditydetail.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerCommoditydetailManager/removeOrdermanagerCommoditydetail.json">
		<youi:fieldLayout>

			<youi:fieldText property="commoditydetailCommodityId"  caption="商户ID"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="commoditydetailUrl"  caption="商品明细URL"/>
			<youi:fieldText property="commoditydetailNum"  caption="数量"/>
		</youi:fieldLayout>

		<youi:gridCol property="commoditydetailCommodityId"  caption="商户ID"/>
		<youi:gridCol property="commodityId"  caption="商品ID"/>
		<youi:gridCol property="commoditydetailUrl"  caption="商品明细URL"/>
		<youi:gridCol property="commoditydetailNum"  caption="数量"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-订单商品明细编辑 -->
	<youi:form dialog="true" caption="订单商品明细" id="form_ordermanagerCommoditydetail" action="esb/web/ordermanagerCommoditydetailManager/saveOrdermanagerCommoditydetail.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="commoditydetailId"  caption="明细序号"/>
			<youi:fieldText property="commoditydetailCommodityId"  caption="商户ID"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="commoditydetailUrl"  caption="商品明细URL"/>
			<youi:fieldText property="commoditydetailNum"  caption="数量"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>