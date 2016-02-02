<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_shoppingcarGroup" idKeys="companyGroupId" caption="-集采购物车列表"  panel="false"
				src="esb/web/shoppingcarGroupManager/getPagerShoppingcarGroups.json" dataFormId="form_shoppingcarGroup"
				editSrc="esb/web/shoppingcarGroupManager/getShoppingcarGroup.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/shoppingcarGroupManager/removeShoppingcarGroup.json">
		<youi:fieldLayout>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>

			<youi:fieldText property="companyCateringAmount"  caption="餐饮数量"/>
			<youi:fieldText property="companyGroupCollectStatus"  caption="集采是否收藏"/>
			<youi:fieldText property="companyCateringUnivalence"  caption="餐饮单价"/>
		</youi:fieldLayout>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>

		<youi:gridCol property="companyCateringAmount"  caption="餐饮数量"/>
		<youi:gridCol property="companyGroupCollectStatus"  caption="集采是否收藏"/>
		<youi:gridCol property="companyCateringUnivalence"  caption="餐饮单价"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--集采购物车编辑 -->
	<youi:form dialog="true" caption="-集采购物车" id="form_shoppingcarGroup" action="esb/web/shoppingcarGroupManager/saveShoppingcarGroup.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="companyGroupId"  caption="集采购物车ID"/>
			<youi:fieldText property="companyCateringAmount"  caption="餐饮数量"/>
			<youi:fieldText property="companyGroupCollectStatus"  caption="集采是否收藏"/>
			<youi:fieldText property="companyCateringUnivalence"  caption="餐饮单价"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>