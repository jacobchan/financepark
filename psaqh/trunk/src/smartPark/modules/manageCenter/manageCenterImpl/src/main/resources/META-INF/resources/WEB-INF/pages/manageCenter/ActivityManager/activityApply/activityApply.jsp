<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_activityApply" idKeys="applyId" caption="-活动申请内容列表列表"  panel="false"
				src="esb/web/activityApplyManager/getPagerActivityApplys.json" dataFormId="form_activityApply"
				editSrc="esb/web/activityApplyManager/getActivityApply.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityApplyManager/removeActivityApply.json">
		<youi:fieldLayout>
			<youi:fieldText property="applyNumber"  caption="活动申请编号"/>
			<youi:fieldText property="applyOrderNumber"  caption="场地订单编号"/>
			<youi:fieldText property="applyMaxuser"  caption="限制人数"/>
			<youi:fieldText property="applyTitle"  caption="活动标题"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentContent"  caption="评论内容"/>

			<youi:fieldText property="applyStatus"  caption="活动申请状态"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="applyNumber"  caption="活动申请编号"/>
		<youi:gridCol property="applyOrderNumber"  caption="场地订单编号"/>
		<youi:gridCol property="applyMaxuser"  caption="限制人数"/>
		<youi:gridCol property="applyTitle"  caption="活动标题"/>
		<youi:gridCol property="commentTime"  caption="评论时间"/>
		<youi:gridCol property="commentContent"  caption="评论内容"/>

		<youi:gridCol property="applyStatus"  caption="活动申请状态"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--活动申请内容列表编辑 -->
	<youi:form dialog="true" caption="-活动申请内容列表" id="form_activityApply" action="esb/web/activityApplyManager/saveActivityApply.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="applyNumber"  caption="活动申请编号"/>
			<youi:fieldText property="applyOrderNumber"  caption="场地订单编号"/>
			<youi:fieldText property="applyMaxuser"  caption="限制人数"/>
			<youi:fieldText property="applyTitle"  caption="活动标题"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentContent"  caption="评论内容"/>
			<youi:fieldText property="applyId"  caption="活动申请ID"/>
			<youi:fieldText property="applyStatus"  caption="活动申请状态"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>