<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_activityApplylist" idKeys="applylistId" caption="-报名名单列表"  panel="false"
				src="esb/web/activityApplylistManager/getPagerActivityApplylists.json" dataFormId="form_activityApplylist"
				editSrc="esb/web/activityApplylistManager/getActivityApplylist.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityApplylistManager/removeActivityApplylist.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="activityApply.applyId"  caption="活动" src="esb/web/activityApplyManager/getActivityApplys.json" code="applyId" show="applyTitle" notNull="ture"/>
			<youi:fieldCalendar property="applylistTime"  caption="报名时间"/>

		</youi:fieldLayout>
		<youi:gridCol property="activityApply.applyTitle"  caption="活动标题" width="33%"/>
		<youi:gridCol property="applylistTime"  caption="报名时间" width="33%"/>
		<youi:gridCol property="applyMember.memberName"  caption="报名人"  width="33%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--报名名单编辑 -->
	<youi:form dialog="true" caption="-报名名单" id="form_activityApplylist" action="esb/web/activityApplylistManager/saveActivityApplylist.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="applylistId"  caption="报名名单ID"/>
			<youi:fieldSelect property="activityApply.applyId"  caption="活动" src="esb/web/activityApplyManager/getActivityApplys.json" code="applyId" show="applyTitle" notNull="ture"/>
			<youi:fieldSelect property="applyMember.memberId"  caption="报名人" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" notNull="ture"/>
			<youi:fieldCalendar property="applylistTime"  caption="报名时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="ture"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
<%-- 	<youi:func name="renderer_applyMember" params="col,record">
 		var memberName = ""; 
		$.youi.ajaxUtil.ajax({
				url:'esb/web/memberInformationManager/getMemberInformation.json',
				data:'memberId='+record.applyMember,
				async: false, 
				success:function(result){
					if(result.record!=""&&result.record!=null){
						memberName=result.record.memberName;
					}
				}
			});
		return memberName;
	</youi:func> --%>
	<!--**********************************页面函数End**********************************-->
</youi:page>