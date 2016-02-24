<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_policyApply" idKeys="policyApplyId" caption="-政策申请记录列表"  panel="false"
				src="esb/web/policyApplyManager/getPagerPolicyApplys.json" dataFormId="form_policyApply"
				editSrc="esb/web/policyApplyManager/getPolicyApply.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/policyApplyManager/removePolicyApply.json">
		<youi:fieldLayout>
			<youi:fieldText property="policyApplyContactPeople"  caption="联系人"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="policyApplyConpanyName"  caption="企业名称"/>
			<youi:fieldSelect property="policyApplyStatus"  caption="申请状态" convert="policyApplyStatus"/>
			<youi:fieldText property="policyApplyContactTel"  caption="联系电话"/>
		</youi:fieldLayout>
		<youi:gridCol property="policyApplyContactPeople"  caption="联系人" width="100"/>
		<youi:gridCol property="member.memberName"  caption="会员姓名" width="100"/>
		<youi:gridCol property="policyApplyConpanyName"  caption="企业名称" width="150"/>
		<youi:gridCol property="policyApplyStatus"  caption="申请状态" width="100" convert="policyApplyStatus"/>
		<youi:gridCol property="policyApplyContactTel"  caption="联系电话" width="150"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--政策申请记录编辑 -->
	<youi:form dialog="true" caption="-政策申请记录" id="form_policyApply" action="esb/web/policyApplyManager/savePolicyApply.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="policyApplyId"  caption="政策申请记录ID"/>
			<youi:fieldText property="policyApplyContactPeople"  caption="联系人" />
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" />
			<youi:fieldText property="policyApplyConpanyName"  caption="企业名称" />
			<youi:fieldSelect property="policyApplyStatus"  caption="申请状态" convert="policyApplyStatus"/>
			<youi:fieldText property="policyApplyContactTel"  caption="联系电话" />
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name = "form_policyApply_afterSubmit">
			var formPolicyApply = $elem('form_policyApply',pageId);
			formPolicyApply.form('close');
			$elem('grid_policyApply',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>