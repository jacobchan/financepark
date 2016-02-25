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
			<youi:fieldText property="applyTitle"  caption="活动标题"/>
			<youi:fieldCalendar property="startTime"  caption="活动开始时间"/>
			<youi:fieldCalendar property="endTime"  caption="活动结束时间"/>
			<youi:fieldSelect property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus" />
			<youi:fieldSelect property="memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			
		</youi:fieldLayout>
		<youi:gridCol property="applyNumber"  caption="活动申请编号" width="100px"/>
		<youi:gridCol property="applyOrderNumber"  caption="场地订单编号" width="100px"/>
		<youi:gridCol property="applyMaxuser"  caption="限制人数"  width="100px"/>
		<youi:gridCol property="applyTitle"  caption="活动标题" width="150px"/>
		<youi:gridCol property="startTime"  caption="活动开始时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" width="100px"/>
		<youi:gridCol property="endTime"  caption="活动结束时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" width="100px"/>
		<youi:gridCol property="commentContent"  caption="活动内容" width="200px"/>

		<youi:gridCol property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus" width="100px"/>
		<youi:gridCol property="memberId"  caption="会员用户" renderer="renderer_memberId" width="200px"/>
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
			<youi:fieldText property="applyTitle"  caption="活动标题" notNull="true"/>
			<youi:fieldText property="applyMaxuser"  caption="限制人数" expressionMessage="请输入整数" expression="^[1-9]\d*$" notNull="true"/>
			<youi:fieldSelect property="memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" notNull="true"/>
			<youi:fieldCalendar property="startTime"  caption="活动开始时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldCalendar property="endTime"  caption="活动结束时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldSelect property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus"/>
			<youi:fieldArea property="commentContent"  caption="活动内容" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
		<youi:func name="renderer_memberId" params="col,record">
 		var memberName = ""; 
		$.youi.ajaxUtil.ajax({
				url:'esb/web/memberInformationManager/getMemberInformation.json',
				data:'memberId='+record.memberId,
				async: false, 
				success:function(result){
					memberName=result.record.memberName;
				}
			});
		return memberName;
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>