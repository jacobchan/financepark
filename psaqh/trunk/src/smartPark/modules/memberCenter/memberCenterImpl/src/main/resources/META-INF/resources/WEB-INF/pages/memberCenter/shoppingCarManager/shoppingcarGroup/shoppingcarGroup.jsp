<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_shoppingcarGroup" idKeys="companyGroupId" caption="-集采购物车列表"  panel="false"
				src="esb/web/shoppingcarGroupManager/getPagerShoppingcarGroups.json" dataFormId="form_shoppingcarGroup"
				editSrc="esb/web/shoppingcarGroupManager/getShoppingcarGroup.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/shoppingcarGroupManager/removeShoppingcarGroup.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName" />
			<youi:fieldSelect property="commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" />	
		</youi:fieldLayout>	
		<youi:gridCol property="memberId.memberName"  caption="会员用户ID" width="20%"/>
		<youi:gridCol property="commodityId"  caption="商品" renderer="renderer_commodityId" width="20%"/>
		<youi:gridCol property="companyGroupCollectStatus"  caption="集采是否收藏" convert="bool" width="20%"/>
		<youi:gridCol property="companyCateringAmount"  caption="餐饮数量" width="20%"/>
		<youi:gridCol property="companyCateringUnivalence"  caption="餐饮单价" width="20%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--集采购物车编辑 -->
	<youi:form dialog="true" caption="-集采购物车" id="form_shoppingcarGroup" action="esb/web/shoppingcarGroupManager/saveShoppingcarGroup.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="companyGroupId"  caption="集采购物车ID"/>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName" notNull="true"/>
			<youi:fieldSelect property="commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" notNull="true"/>							  
			<youi:fieldText  property="companyCateringAmount"  caption="餐饮数量" expression="^[1-9]\d*$" expressionMessage="餐饮数量格式不正确，应为正整数" notNull="true"/>
			<youi:fieldText property="companyCateringUnivalence"  caption="餐饮单价" expression="^\d{0,8}\.{0,1}(\d{1,2})?$" expressionMessage="餐饮单价格式不正确，应为" notNull="true"/>
			<youi:fieldSelect property="companyGroupCollectStatus"  caption="集采是否收藏" convert="bool" notNull="" defaultValue="1"/>
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
					commodityTitle=result.record.commodityTitle;
				}
			});
		return commodityTitle;
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>