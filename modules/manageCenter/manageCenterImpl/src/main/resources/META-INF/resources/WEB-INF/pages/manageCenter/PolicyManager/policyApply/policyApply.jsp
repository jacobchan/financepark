<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_policyApply" idKeys="policyApplyId" caption="-政策申请记录列表"  panel="false"
				src="esb/web/policyApplyManager/getPagerPolicyApplys.json" dataFormId="form_policyApply"
				editSrc="esb/web/policyApplyManager/getPolicyApply.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/policyApplyManager/removePolicyApply.json">
		<youi:fieldLayout>
			<youi:fieldText property="policyApplyContactPeople"  caption="联系人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="policyApplyConpanyName"  caption="企业名称"/>
			<youi:fieldText property="policyApplyStatus"  caption="申请状态"/>

			<youi:fieldText property="policyApplyContactTel"  caption="联系电话"/>
		</youi:fieldLayout>
		<youi:gridCol property="policyApplyContactPeople"  caption="联系人"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="policyApplyConpanyName"  caption="企业名称"/>
		<youi:gridCol property="policyApplyStatus"  caption="申请状态"/>

		<youi:gridCol property="policyApplyContactTel"  caption="联系电话"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--政策申请记录编辑 -->
	<youi:form dialog="true" caption="-政策申请记录" id="form_policyApply" action="esb/web/policyApplyManager/savePolicyApply.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="policyApplyContactPeople"  caption="联系人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="policyApplyConpanyName"  caption="企业名称"/>
			<youi:fieldText property="policyApplyStatus"  caption="申请状态"/>
			<youi:fieldText property="policyApplyId"  caption="政策申请记录ID"/>
			<youi:fieldText property="policyApplyContactTel"  caption="联系电话"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>