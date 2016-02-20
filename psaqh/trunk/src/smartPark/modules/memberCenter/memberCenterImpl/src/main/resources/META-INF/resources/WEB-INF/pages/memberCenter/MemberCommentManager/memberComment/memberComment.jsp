<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_memberComment" idKeys="goodsCommentId" caption="-商品评价列表"  panel="false"
				src="esb/web/memberCommentManager/getPagerMemberComments.json" dataFormId="form_memberComment"
				editSrc="esb/web/memberCommentManager/getMemberComment.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/memberCommentManager/removeMemberComment.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName"/>
			<youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle"/>
			<youi:fieldCalendar property="goodsCommentTime"  caption="商品评价时间"/>
			<youi:fieldSelect property="goodsCommentLevel"  caption="商品评价等级">
			<youi:fieldOption caption="1" value="1"></youi:fieldOption>
				<youi:fieldOption caption="2" value="2"></youi:fieldOption>
				<youi:fieldOption caption="3" value="3"></youi:fieldOption>
				<youi:fieldOption caption="4" value="4"></youi:fieldOption>
			</youi:fieldSelect>
			<youi:fieldCalendar property="goodsCommentReviewtime"  caption="商品评价追评时间"/>
		</youi:fieldLayout>

		<youi:gridCol property="memberId.memberName"  caption="会员用户" width="100px"/>
		<youi:gridCol property="commodityId.commodityTitle"  caption="商品ID" width="100px"/>
		<youi:gridCol property="goodsCommentReview"  caption="商品评价追评" width="200px"/>
		<youi:gridCol property="goodsCommentTime"  caption="商品评价时间" width="100px"/>
		<youi:gridCol property="goodsCommentLevel"  caption="商品评价等级" width="100px"/>
		<youi:gridCol property="goodsCommentReviewtime"  caption="商品评价追评时间" width="100px"/>
		<youi:gridCol property="goodsCommentContent"  caption="商品评价内容" width="200px"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--商品评价编辑 -->
	<youi:form dialog="true" caption="-商品评价" id="form_memberComment" action="esb/web/memberCommentManager/saveMemberComment.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="goodsCommentId"  caption="商品评价ID"/>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
							  code="memberId" show="memberName" notNull="true"/>
			<youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" notNull="true"/>
			<youi:fieldCalendar property="goodsCommentTime"  caption="商品评价时间"/>
			<youi:fieldSelect property="goodsCommentLevel"  caption="商品评价等级">
				<youi:fieldOption caption="1" value="1"></youi:fieldOption>
				<youi:fieldOption caption="2" value="2"></youi:fieldOption>
				<youi:fieldOption caption="3" value="3"></youi:fieldOption>
				<youi:fieldOption caption="4" value="4"></youi:fieldOption>
			</youi:fieldSelect>
			<youi:fieldArea property="goodsCommentReview"  caption="商品评价追评"/>
			<youi:fieldCalendar property="goodsCommentReviewtime"  caption="商品评价追评时间"/>
			<youi:fieldArea property="goodsCommentContent"  caption="商品评价内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>