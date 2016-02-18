<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_activityApply" idKeys="applyId" caption="-活动申请内容列表列表"  panel="false"
				src="esb/web/activityApplyManager/getPagerActivityApplys.json" dataFormId="form_activityApply"
				editSrc="esb/web/activityApplyManager/getActivityApply.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityApplyManager/removeActivityApply.json">
		<youi:fieldLayout  labelWidths="100,100">
			<youi:fieldText property="applyNumber"  caption="活动申请编号"/>
			<youi:fieldText property="applyOrderNumber"  caption="场地订单编号"/>
			<youi:fieldText property="applyMaxuser"  caption="限制人数"/>
			<youi:fieldText property="applyTitle"  caption="活动标题"/>
			<youi:fieldText property="commentTime"  caption="评论时间"/>
			<youi:fieldText property="commentContent"  caption="评论内容"/>

			<youi:fieldSelect property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus" />
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="applyNumber"  caption="活动申请编号" width="100px"/>
		<youi:gridCol property="applyOrderNumber"  caption="场地订单编号" width="100px"/>
		<youi:gridCol property="applyMaxuser"  caption="限制人数" width="100px"/>
		<youi:gridCol property="applyTitle"  caption="活动标题" width="150px"/>
		<youi:gridCol property="commentTime"  caption="活动开始时间" width="100px"/>
		<youi:gridCol property="commentContent"  caption="活动内容" width="200px"/>

		<youi:gridCol property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus" width="100px"/>
		<youi:gridCol property="memberId"  caption="会员用户ID" width="200px"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--活动申请内容列表编辑 -->
	<youi:form dialog="true" caption="-活动申请内容列表" id="form_activityApply" action="esb/web/activityApplyManager/saveActivityApply.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="applyId"  caption="活动申请ID"/>
			<youi:fieldText property="applyNumber"  caption="活动申请编号"/>
			<youi:fieldText property="applyOrderNumber"  caption="场地订单编号"/>
			<youi:fieldText property="applyTitle"  caption="活动标题"/>
			<youi:fieldSpinner property="applyMaxuser"  caption="限制人数" min="0" step="1" styleClass="input-group"/>
			<youi:fieldSelect property="memberId"  caption="会员用户ID" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldCalendar property="commentTime"  caption="活动开始时间"/>
			<youi:fieldCalendar property="commentTimeEnd"  caption="活动结束时间"/>
			<youi:fieldSelect property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus"/>
			<youi:fieldArea property="commentContent"  caption="活动内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>