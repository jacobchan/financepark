<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerMoverec" idKeys="moverecId" caption="搬家申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerMoverecManager/getPagerPropertyservicemanagerMoverecs.json" dataFormId="form_propertyservicemanagerMoverec"
				editSrc="esb/web/propertyservicemanagerMoverecManager/getPropertyservicemanagerMoverec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerMoverecManager/removePropertyservicemanagerMoverec.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldCalendar property="moverecTime" caption="搬家时间"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="moverecName"  caption="搬家联系人"/>
			<youi:fieldText property="moverecCode"  caption="搬家申请编号"  operator="LIKE"/>
			<youi:fieldSelect property="moverecStatus"  caption="搬家申请状态" convert="moverec_status"/>
		</youi:fieldLayout>
		
		<youi:button name="dealmov" caption="处理申请" icon="edit" active="1"/>
		
		<youi:gridCol property="member.memberName"  caption="会员姓名" width="10%" />
		<youi:gridCol property="moverecUnit"  caption="楼宇单元" width="8%"/>
		<youi:gridCol property="moverecTime"  caption="搬家时间" width="10%"/>
		<youi:gridCol property="moverecCode"  caption="搬家申请编号" width="16%"/>
		<youi:gridCol property="moverecStatus"  caption="搬家申请状态" width="10%" convert="moverec_status"/>
		<youi:gridCol property="moverecName"  caption="搬家联系人" width="10%"  align="center"/>
		<youi:gridCol property="moverecComp"  caption="搬家企业名称" width="10%"/>
		<youi:gridCol property="moverecWay"  caption="搬家提交方式" width="10%" convert="oc_way"/>
		<youi:gridCol property="moverecRemark"  caption="物品描述" width="16%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-搬家申请记录编辑 -->
	<youi:form dialog="true" caption="搬家申请记录" id="form_propertyservicemanagerMoverec" action="esb/web/propertyservicemanagerMoverecManager/savePropertyservicemanagerMoverec.json">
		<youi:fieldLayout prefix="record" labelWidths="120,100">
			<youi:fieldHidden property="moverecId"  caption="搬家申请记录ID"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名"
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="moverecComp"  caption="搬家企业名称" readonly="true"/>
			<youi:fieldText property="moverecUnit"  caption="楼宇单元"/>
			<youi:fieldCalendar property="moverecTime" caption="搬家时间"/>
			<youi:fieldText property="moverecName"  caption="搬家联系人"/>
			<youi:fieldSelect property="moverecWay"  caption="搬家提交方式" convert="oc_way"/>
			<youi:fieldArea property="moverecRemark"  caption="物品描述"/>
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
   	 <!-- 搬家申请审批，改变申请状态，同时生成二维码 -->
   	 <youi:func name="func_grid_dealmov">
			var gridElement = $elem('grid_propertyservicemanagerMoverec',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var movstatus = selectedRecord.moverecStatus;
			if(movstatus=='00'){
				$.youi.messageUtils.confirm('处理申请?',function(){
					$.youi.ajaxUtil.ajax({
					url:'/esb/web/propertyservicemanagerMoverecManager/upMovById.json',
					data:{id:selectedRecord.moverecId},
					success:function(result){	
						$elem('grid_propertyservicemanagerMoverec',pageId).grid('pReload');
						alert("处理成功!");
						}
					});
				});
			}else{
				alert("已处理成功!");
			}	
		</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>