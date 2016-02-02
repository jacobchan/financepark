<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_activityComment" idKeys="commentId" caption="-活动评论列表"  panel="false"
				src="esb/web/activityCommentManager/getPagerActivityComments.json" dataFormId="form_activityComment"
				editSrc="esb/web/activityCommentManager/getActivityComment.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityCommentManager/removeActivityComment.json">
		<youi:fieldLayout>

			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentContent"  caption="评论内容"/>
		</youi:fieldLayout>

		<youi:gridCol property="commentTime"  caption="评论时间"/>
		<youi:gridCol property="commentContent"  caption="评论内容"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--活动评论编辑 -->
	<youi:form dialog="true" caption="-活动评论" id="form_activityComment" action="esb/web/activityCommentManager/saveActivityComment.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="commentId"  caption="评论ID"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentContent"  caption="评论内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>