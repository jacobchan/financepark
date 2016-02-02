<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_favoritsFavoritgoods" idKeys="favoritGoodsId" caption="-商品收藏表列表"  panel="false"
				src="esb/web/favoritsFavoritgoodsManager/getPagerFavoritsFavoritgoodss.json" dataFormId="form_favoritsFavoritgoods"
				editSrc="esb/web/favoritsFavoritgoodsManager/getFavoritsFavoritgoods.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/favoritsFavoritgoodsManager/removeFavoritsFavoritgoods.json">
		<youi:fieldLayout>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>

		</youi:fieldLayout>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--商品收藏表编辑 -->
	<youi:form dialog="true" caption="-商品收藏表" id="form_favoritsFavoritgoods" action="esb/web/favoritsFavoritgoodsManager/saveFavoritsFavoritgoods.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="favoritGoodsId"  caption="商品收藏表ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>