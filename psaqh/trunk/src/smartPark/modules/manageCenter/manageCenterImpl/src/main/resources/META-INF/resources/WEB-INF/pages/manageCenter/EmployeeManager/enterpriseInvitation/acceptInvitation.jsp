<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:form caption="邀请记录表" id="form_enterpriseInvitation"
		action="esb/web/enterpriseEmployeesManager/acceptEnterpriseInvitation.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="invitationId" caption="邀请记录系列" />
			<youi:fieldSelect property="rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzMem" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldText property="phone" caption="会员电话" />
			<youi:fieldText property="code" caption="企业邀请码" />
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="form_enterpriseInvitation_afterSubmit">
		var enterpriseInvitation = $elem('form_enterpriseInvitation',pageId);
		alert("1");
	</youi:func>
</youi:page>