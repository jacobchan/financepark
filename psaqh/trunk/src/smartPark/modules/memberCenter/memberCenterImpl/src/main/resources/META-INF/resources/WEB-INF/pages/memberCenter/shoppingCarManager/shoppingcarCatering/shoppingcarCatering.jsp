<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_shoppingcarCatering" idKeys="companyCateringId" caption="-餐饮购物车列表"  panel="false"
				src="esb/web/shoppingcarCateringManager/getPagerShoppingcarCaterings.json" dataFormId="form_shoppingcarCatering"
				editSrc="esb/web/shoppingcarCateringManager/getShoppingcarCatering.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/shoppingcarCateringManager/removeShoppingcarCatering.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName" />
			<youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" />	
		</youi:fieldLayout>
		<youi:gridCol property="memberId.memberName"  caption="会员用户" width="25%"/>
		<youi:gridCol property="commodityId.commodityTitle"  caption="商品 "  width="25%"/>
		<youi:gridCol property="companyCateringNum"  caption="餐饮数量" width="25%"/>
		<youi:gridCol property="companyCateringUnivalence"  caption="餐饮单价" width="25%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--餐饮购物车编辑 -->
	<youi:form dialog="true" caption="-餐饮购物车" id="form_shoppingcarCatering" action="esb/web/shoppingcarCateringManager/saveShoppingcarCatering.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="companyCateringId"  caption="餐饮购物车ID"/>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName" notNull="true"/>
			<youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" notNull="true" />							  
			<youi:fieldText  property="companyCateringNum"  caption="餐饮数量" expression="^[1-9]\d*$" expressionMessage="餐饮数量格式不正确，应为正整数" notNull="true"/>
			<youi:fieldText property="companyCateringUnivalence"  caption="餐饮单价" expression="^\d{0,8}\.{0,1}(\d{1,2})?$" expressionMessage="餐饮单价格式不正确，应为" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="renderer_commodityId" params="col,record">
 		var commodityTitle = ""; 
		$.youi.ajaxUtil.ajax({
				url:'esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommodity.json',
				data:'commodityId='+record.commodityId,
				async: false, 
				success:function(result){
					if(result.record!=""&&result.record!=null){
						commodityTitle=result.record.commodityTitle;
					}
				}
			});
		return commodityTitle;
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>