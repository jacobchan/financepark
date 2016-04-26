<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_activityComment" idKeys="commentId" caption="-活动评论列表"  panel="false"
				src="esb/web/activityCommentManager/getPagerActivityComments.json" dataFormId="form_activityComment"
				editSrc="esb/web/activityCommentManager/getActivityComment.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityCommentManager/removeActivityComment.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="activityApply.applyId"  caption="活动" src="esb/web/activityApplyManager/getActivityApplys.json" code="applyId" show="applyTitle" notNull="ture"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
		</youi:fieldLayout>
		<youi:gridCol property="activityDocument.documentName"  caption="文档标题" width="20%"/>
		<youi:gridCol property="commentMember.memberName"  caption="评论人"  width="20%"/>
		<youi:gridCol property="commentTime"  caption="评论时间" width="10%"/>
		<youi:gridCol property="commentContent"  caption="评论内容" width="50%"/>
		<youi:gridCol width="100" fixed="true" property="button" type="button" caption="操作" >
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--活动评论编辑 -->
	<youi:form dialog="true" caption="-活动评论" id="form_activityComment" action="esb/web/activityCommentManager/saveActivityComment.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="commentId"  caption="评论ID"/>
			<youi:fieldSelect property="activityDocument.documentId"  caption="活动" src="esb/web/activityDocumentManager/getActivityDocuments.json" code="documentId" show="documentName" notNull="ture"/>
			<youi:fieldSelect property="commentMember.memberId"  caption="评论人" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" notNull="ture"/>			
			<youi:fieldArea property="commentContent"  caption="评论内容" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->

	<!--**********************************页面函数End**********************************-->
</youi:page>