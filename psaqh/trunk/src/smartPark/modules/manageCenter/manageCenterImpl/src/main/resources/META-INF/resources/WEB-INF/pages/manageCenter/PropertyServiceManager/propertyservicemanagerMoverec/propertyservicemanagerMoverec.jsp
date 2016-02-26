<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerMoverec" idKeys="moverecId" caption="搬家申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerMoverecManager/getPagerPropertyservicemanagerMoverecs.json" dataFormId="form_propertyservicemanagerMoverec"
				editSrc="esb/web/propertyservicemanagerMoverecManager/getPropertyservicemanagerMoverec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerMoverecManager/removePropertyservicemanagerMoverec.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldText property="moverecUnit"  caption="楼宇单元"/>
			<youi:fieldCalendar property="moverecTime" caption="搬家时间"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="moverecName"  caption="搬家联系人"/>
			<youi:fieldText property="moverecWay"  caption="搬家提交方式" />
		</youi:fieldLayout>
		<youi:gridCol property="member.memberName"  caption="会员姓名" width="100" />
		<youi:gridCol property="moverecUnit"  caption="楼宇单元"/>
		<youi:gridCol property="moverecRemark"  caption="物品描述"/>
		<youi:gridCol property="moverecTime"  caption="搬家时间"/>
		<youi:gridCol property="moverecName"  caption="搬家联系人"/>
		<youi:gridCol property="moverecComp"  caption="搬家企业名称" width="100"/>
		<youi:gridCol property="moverecWay"  caption="搬家提交方式" width="100"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-搬家申请记录编辑 -->
	<youi:form dialog="true" caption="搬家申请记录" id="form_propertyservicemanagerMoverec" action="esb/web/propertyservicemanagerMoverecManager/savePropertyservicemanagerMoverec.json">
		<youi:fieldLayout prefix="record" labelWidths="120,100">
			<youi:fieldHidden property="moverecId"  caption="搬家申请记录ID"/>
			
			<youi:fieldText property="moverecUnit"  caption="楼宇单元"/>
			<youi:fieldText property="moverecRemark"  caption="物品描述"/>
			<youi:fieldCalendar property="moverecTime" caption="搬家时间"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名"
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="moverecName"  caption="搬家联系人"/>
			<youi:fieldText property="moverecWay"  caption="搬家提交方式"/>
			<youi:fieldText property="moverecComp"  caption="搬家企业名称" readonly="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<youi:func name = "form_propertyservicemanagerMoverec_afterSubmit">
			var formPropertyservicemanagerMoverec = $elem('form_propertyservicemanagerMoverec',pageId);
			formPropertyservicemanagerMoverec.form('close');
			$elem('grid_propertyservicemanagerMoverec',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数Start********************************-->
	<!-- 会员发生变化时，对应的企业名称也发生变化 -->
		<youi:func name = "record_member_memberId_change">
      		var memberId = $('#P_'+pageId+'_record_member_memberId').fieldValue();//获取当前选中会员的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/policyApplyManager/findEnterpriseByMemberId.json',
				data:{memberId:memberId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_moverecComp').fieldValue('') ;//先将公司名称置空
                    $('#P_'+pageId+'_record_moverecComp').fieldValue(record.rzName);//将返回的对象里面的enName赋值给公司名称
                  } 
            })
   	 </youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>