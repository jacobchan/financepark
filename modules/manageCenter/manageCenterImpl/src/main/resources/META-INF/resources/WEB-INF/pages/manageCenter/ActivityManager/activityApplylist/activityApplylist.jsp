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
		<youi:gridCol property="activityApply.applyTitle"  caption="活动标题" width="30%"/>
		<youi:gridCol property="member.memberName"  caption="报名人"  width="20%"/>
		<youi:gridCol property="applyMember"  caption="联系人"  width="20%"/>
		<youi:gridCol property="applyPhone"  caption="联系电话"  width="15%"/>
		<youi:gridCol property="applylistTime"  caption="报名时间" width="15%"/>
		<youi:gridCol width="40" fixed="true" property="button" type="button" caption="操作">
			<%-- <youi:button name="edit" caption="修改"/> --%>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		<youi:button name="userInfo" caption="编辑" active="1" icon="edit"/>
	</youi:grid>
	
	<!-- form--报名名单编辑 -->
	<youi:form dialog="true" caption="-报名名单" id="form_activityApplylist" action="esb/web/activityApplylistManager/saveActivityApplylist.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="applylistId"  caption="报名名单ID"/>
			<youi:fieldSelect property="activityApply.applyId"  caption="活动" src="esb/web/activityApplyManager/getActivityApplys.json" code="applyId" show="applyTitle" notNull="ture"/>
			<youi:fieldSelect property="member.memberId"  caption="报名人" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" notNull="ture"/>
			<youi:fieldText property="applyMember" caption="联系人" notNull="ture"></youi:fieldText>
			<youi:fieldText property="applyPhone" caption="联系电话"  notNull="ture" expression="^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$" expressionMessage="手机号码格式不正确"></youi:fieldText>
			<youi:fieldCalendar property="applylistTime"  caption="报名时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="ture"/>
		</youi:fieldLayout>
	</youi:form>
	
	<youi:form dialog="true" caption="编辑报名名单" id="form_editactivityApplylist" action="esb/web/activityApplylistManager/saveActivityApplylist.json">
		<youi:fieldLayout prefix="editrecord" labelWidths="100,100">
			<youi:fieldHidden property="applylistId"  caption="报名名单ID"/>
			<youi:fieldText property="applyTitle"  caption="活动" readonly="true"/>
			<youi:fieldText property="memberName"  caption="报名人"  readonly="true"/>
			<youi:fieldText property="applyMember" caption="联系人" notNull="ture"></youi:fieldText>
			<youi:fieldText property="applyPhone" caption="联系电话"  notNull="ture" expression="^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$" expressionMessage="手机号码格式不正确"></youi:fieldText>
			<youi:fieldText property="applylistTime"  caption="报名时间"  readonly="true"/>
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
	<youi:func name="func_grid_userInfo">
		var gridElement = $elem('grid_activityApplylist',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var name = selectedRecord['member.memberName'];
		var applist = selectedRecord['activityApply.applyTitle'];
		var bxform = $elem('form_editactivityApplylist',pageId);
        bxform.form("reset").form('fillRecord',selectedRecord).form('fillRecord',{applyTitle:applist}).form('fillRecord',{memberName:name}).form('open');
	</youi:func>
	
	<youi:func name="form_editactivityApplylist_afterSubmit">
		var formBxchange = $elem('form_editactivityApplylist',pageId);
		alert("修改完成！");
		formBxchange.form('close');
		$elem('grid_activityApplylist',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>