<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_memberComment" idKeys="goodsCommentId" caption="-商品评价列表"  panel="false"
				src="esb/web/memberCommentManager/getPagerMemberComments.json" dataFormId="form_memberComment"
				editSrc="esb/web/memberCommentManager/getMemberComment.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/memberCommentManager/removeMemberComment.json">
		<youi:fieldLayout>

			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="goodsCommentReview"  caption="商品评价追评"/>
			<youi:fieldText property="goodsCommentTime"  caption="商品评价时间"/>
			<youi:fieldText property="goodsCommentLevel"  caption="商品评价等级"/>
			<youi:fieldText property="goodsCommentReviewtime"  caption="商品评价追评时间"/>
			<youi:fieldText property="goodsCommentContent"  caption="商品评价内容"/>
		</youi:fieldLayout>

		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="commodityId"  caption="商品ID"/>
		<youi:gridCol property="goodsCommentReview"  caption="商品评价追评"/>
		<youi:gridCol property="goodsCommentTime"  caption="商品评价时间"/>
		<youi:gridCol property="goodsCommentLevel"  caption="商品评价等级"/>
		<youi:gridCol property="goodsCommentReviewtime"  caption="商品评价追评时间"/>
		<youi:gridCol property="goodsCommentContent"  caption="商品评价内容"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--商品评价编辑 -->
	<youi:form dialog="true" caption="-商品评价" id="form_memberComment" action="esb/web/memberCommentManager/saveMemberComment.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="goodsCommentId"  caption="商品评价ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="goodsCommentReview"  caption="商品评价追评"/>
			<youi:fieldText property="goodsCommentTime"  caption="商品评价时间"/>
			<youi:fieldText property="goodsCommentLevel"  caption="商品评价等级"/>
			<youi:fieldText property="goodsCommentReviewtime"  caption="商品评价追评时间"/>
			<youi:fieldText property="goodsCommentContent"  caption="商品评价内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>