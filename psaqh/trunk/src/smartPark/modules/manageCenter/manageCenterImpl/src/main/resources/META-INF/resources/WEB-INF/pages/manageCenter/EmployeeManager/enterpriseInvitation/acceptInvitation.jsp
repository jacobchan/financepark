<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:form caption="成为企业员工" id="form_acceptInvitation"
		action="esb/web/enterpriseEmployeesManager/acceptEnterpriseInvitation.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="invitationId" caption="邀请记录系列" />
			<youi:fieldSelect property="memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberName" caption="会员用户" notNull="true" />
			<youi:fieldText property="code" notNull="true" caption="企业邀请码" />
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="form_acceptInvitation_afterSubmit" params="result">
		var acceptInvitation = $elem('form_acceptInvitation',pageId);
		alert(result.record.html);
		acceptInvitation.form('reset').form('fillRecord',result.record.html);
	</youi:func>
</youi:page>