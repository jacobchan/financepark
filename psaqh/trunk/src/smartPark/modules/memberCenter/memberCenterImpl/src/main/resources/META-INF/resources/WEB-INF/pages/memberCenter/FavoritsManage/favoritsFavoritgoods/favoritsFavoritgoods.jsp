<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_favoritsFavoritgoods" idKeys="favoritGoodsId,commodityId" caption="-商品收藏表列表"  panel="false"
				src="esb/web/favoritsFavoritgoodsManager/getPagerFavoritsFavoritgoodss.json" dataFormId="form_favoritsFavoritgoods"
				editSrc="esb/web/favoritsFavoritgoodsManager/getFavoritsFavoritgoods.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/favoritsFavoritgoodsManager/removeFavoritsFavoritgoods.json">
		<youi:fieldLayout>
		<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
						  code="memberId" show="memberName" />
		<youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle"/>
		</youi:fieldLayout>
		<youi:gridCol property="memberId.memberName"  caption="会员用户" width="50%"/>
		<youi:gridCol property="commodityId.commodityTitle"  caption="商品"  width="50%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--商品收藏表编辑 -->
	<youi:form dialog="true" caption="-商品收藏表" id="form_favoritsFavoritgoods" action="esb/web/favoritsFavoritgoodsManager/saveFavoritsFavoritgoods.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="favoritGoodsId"  caption="商品收藏表ID"/>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName" notNull="true"/>
			<youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" notNull="true"/>
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