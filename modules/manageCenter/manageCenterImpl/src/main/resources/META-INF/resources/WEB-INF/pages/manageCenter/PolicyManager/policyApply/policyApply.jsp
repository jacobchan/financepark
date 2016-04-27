<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_policyApply" idKeys="policyApplyId" caption="政策申请记录列表"  panel="false"
				src="esb/web/policyApplyManager/getPagerPolicyApplys.json" dataFormId="form_policyApply"
				editSrc="esb/web/policyApplyManager/getPolicyApply.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/policyApplyManager/removePolicyApply.json">
		<youi:fieldLayout>
			<youi:fieldText property="policyApplyContactPeople"  caption="联系人"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="policyApplyStatus"  caption="申请状态" convert="policyApplyStatus"/>
			<youi:fieldText property="policyApplyContactTel"  caption="联系电话"/>
		</youi:fieldLayout>
		<youi:button name="refuse" caption="拒绝申请" icon="edit" active="1"/>
		<youi:button name="deal" caption="处理任务" icon="edit" active="1"/>
		
		<youi:gridCol property="applyCode"  caption="政策申请单号" width="190" align="center"/>
		<youi:gridCol property="policyApplyContactPeople"  caption="联系人" width="100" align="center"/>
		<youi:gridCol property="member.memberName"  caption="会员姓名" width="100" align="center"/>
		<youi:gridCol property="policyApplyConpanyName"  caption="企业名称" width="150" align="center"/>
		<youi:gridCol property="policyApplyContactTel"  caption="联系电话" width="150" align="center"/>
		<youi:gridCol property="policyApplyStatus"  caption="申请状态" width="150" align="center" convert="policyApplyStatus"/>
		<youi:gridCol property="nmIssueflow.issueFlowCStatus"  caption="流程状态" width="150" align="center"/>
		<youi:gridCol property="nmIssuenews.policyCaption"  caption="申请新闻名称" width="150" align="center"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--政策申请记录编辑 -->
	<youi:form dialog="true" caption="-政策申请记录" id="form_policyApply" action="esb/web/policyApplyManager/savePolicyApply.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="policyApplyStatus"  caption="申请状态"/>
			<youi:fieldHidden property="applyCode"  caption="政策申请单号"/>
			<youi:fieldHidden property="nmIssueflow.issueFlowId"  caption="流程状态"/>
			<youi:fieldText property="policyApplyContactPeople"  caption="联系人" notNull="true"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" />
			<youi:fieldText property="policyApplyConpanyName"  caption="企业名称" readonly="true"/>
			<youi:fieldText property="policyApplyContactTel"  caption="联系电话" notNull="true"
				expression="^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$" expressionMessage="手机号码格式不正确"/>
			<youi:fieldSelect property="nmIssuenews.policyId"  caption="申请新闻名称" 
				src="esb/web/nmIssuenewsManager/getAllPolicyList.json" code="policyId" show="policyCaption" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--重新加载页面数据-->
	<youi:func name = "form_policyApply_afterSubmit">
			var formPolicyApply = $elem('form_policyApply',pageId);
			formPolicyApply.form('close');
			$elem('grid_policyApply',pageId).grid('pReload');
	</youi:func>
	
	<!--处理任务-->
	<youi:func name="func_grid_deal">
		var gridElement = $elem('grid_policyApply',pageId),
        selectedRecord = gridElement.grid('getSelectedRecord');
		var policyApplyStatus = selectedRecord.policyApplyStatus;
 		if(policyApplyStatus == '04'){
			alert("当前政策申请已取消，无法处理流程！") ;
		}else if(policyApplyStatus == '03'){
			alert("当前政策已经申请失败，无法处理流程！") ;
		}else if(policyApplyStatus == '02'){
			alert("当前政策流程已经处理完，无需再处理！") ;
		}else{
			$.youi.messageUtils.confirm('处理任务?',function(){
        	var gridElement = $elem('grid_policyApply',pageId),
            selectedRecord = gridElement.grid('getSelectedRecord');
            $.youi.ajaxUtil.ajax({
            	url:'/esb/web/policyApplyManager/updatePolicyApply.json',
                data:{id:selectedRecord.policyApplyId},
                success:function(result){    
                    $elem('grid_policyApply',pageId).grid('pReload');
                        alert("处理成功!");
                    }
                });
           	});
		}
        </youi:func>
        <youi:func name="func_grid_refuse">
			var gridElement = $elem('grid_policyApply',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var policyApplyStatus = selectedRecord.policyApplyStatus;
			if(policyApplyStatus == '01'){
				$.youi.messageUtils.confirm('确定拒绝申请?',function(){
					$.youi.ajaxUtil.ajax({
					url:'/esb/web/policyApplyManager/updatePolicyApplyStatus.json',
					data:{id:selectedRecord.policyApplyId},
					success:function(result){	
						$elem('grid_policyApply',pageId).grid('pReload');
						alert("拒绝申请成功!");
						}
					});
				});
			}else if(policyApplyStatus=='02'){
				alert("申请成功的状态无法拒绝申请!");
			}else if(policyApplyStatus=='03'){
				alert("申请状态已经是申请失败了！");
			}else{
				alert("申请为已取消，无法拒绝！");
			}	
		</youi:func>
		
		<!-- 会员发生变化时，对应的企业名称也发生变化 -->
		<youi:func name = "record_member_memberId_change">
      		var memberId = $('#P_'+pageId+'_record_member_memberId').fieldValue();//获取当前选中会员的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/policyApplyManager/findEnterpriseByMemberId.json',
				data:{memberId:memberId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_policyApplyConpanyName').fieldValue('') ;//先将公司名称置空
                    $('#P_'+pageId+'_record_policyApplyConpanyName').fieldValue(record.rzName);//将返回的对象里面的enName赋值给公司名称
                  } 
            })
   	 </youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>