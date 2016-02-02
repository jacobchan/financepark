<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_shoppingcarCompanyserver" idKeys="companyServerId" caption="-企业服务购物车列表"  panel="false"
				src="esb/web/shoppingcarCompanyserverManager/getPagerShoppingcarCompanyservers.json" dataFormId="form_shoppingcarCompanyserver"
				editSrc="esb/web/shoppingcarCompanyserverManager/getShoppingcarCompanyserver.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/shoppingcarCompanyserverManager/removeShoppingcarCompanyserver.json">
		<youi:fieldLayout>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="companyCateringAmount"  caption="餐饮数量"/>
			<youi:fieldText property="companyCateringUnivalence"  caption="餐饮单价"/>

		</youi:fieldLayout>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="companyCateringAmount"  caption="餐饮数量"/>
		<youi:gridCol property="companyCateringUnivalence"  caption="餐饮单价"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--企业服务购物车编辑 -->
	<youi:form dialog="true" caption="-企业服务购物车" id="form_shoppingcarCompanyserver" action="esb/web/shoppingcarCompanyserverManager/saveShoppingcarCompanyserver.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="companyCateringAmount"  caption="餐饮数量"/>
			<youi:fieldText property="companyCateringUnivalence"  caption="餐饮单价"/>
			<youi:fieldText property="companyServerId"  caption="企业服务购物车ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>