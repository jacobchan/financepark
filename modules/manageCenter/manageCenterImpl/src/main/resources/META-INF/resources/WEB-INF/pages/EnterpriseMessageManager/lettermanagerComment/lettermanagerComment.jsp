<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_lettermanagerComment" idKeys="commentId" caption="评论列表"  panel="false"
				src="esb/web/lettermanagerCommentManager/getPagerLettermanagerComments.json" dataFormId="form_lettermanagerComment"
				editSrc="esb/web/lettermanagerCommentManager/getLettermanagerComment.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/lettermanagerCommentManager/removeLettermanagerComment.json">
		<youi:fieldLayout>
			<youi:fieldText property="commentContent"  caption="评论内容"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentEnterprise"  caption="企业信息"/>

			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="commentReplyTime"  caption="回复时间"/>
			<youi:fieldText property="commentReplyContent"  caption="回复内容"/>
		</youi:fieldLayout>
		<youi:gridCol property="commentContent"  caption="评论内容"/>
		<youi:gridCol property="commentTime"  caption="评论时间"/>
		<youi:gridCol property="commentEnterprise"  caption="企业信息"/>

		<youi:gridCol property="rzId"  caption="ID"/>
		<youi:gridCol property="commentReplyTime"  caption="回复时间"/>
		<youi:gridCol property="commentReplyContent"  caption="回复内容"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-评论编辑 -->
	<youi:form dialog="true" caption="评论" id="form_lettermanagerComment" action="esb/web/lettermanagerCommentManager/saveLettermanagerComment.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="commentContent"  caption="评论内容"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentEnterprise"  caption="企业信息"/>
			<youi:fieldText property="commentId"  caption="ID_"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="commentReplyTime"  caption="回复时间"/>
			<youi:fieldText property="commentReplyContent"  caption="回复内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>