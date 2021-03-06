<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterpriseInvitation" idKeys="invitationId"
		caption="邀请记录表列表" panel="false"
		src="esb/web/enterpriseInvitationManager/getPagerEnterpriseInvitations.json"
		dataFormId="form_enterpriseInvitation"
		editSrc="esb/web/enterpriseInvitationManager/getEnterpriseInvitation.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/enterpriseInvitationManager/removeEnterpriseInvitation.json">
		<youi:fieldLayout columns="3" labelWidths="120,120,120">
			<youi:fieldSelect property="enterbusinessmanagerRz.rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldText property="invitationTelephone" caption="会员电话" />
			<youi:fieldText property="invitationCode" caption="企业邀请码" />
		</youi:fieldLayout>
		<youi:gridCol property="enterbusinessmanagerRz.rzName" caption="入驻企业" width="280" />
		<youi:gridCol property="invitationTelephone" caption="会员电话" width="120" />
		<youi:gridCol property="invitationCode" caption="企业邀请码" width="160" />
		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-邀请记录表编辑 -->
	<youi:form dialog="true" caption="邀请记录表" id="form_enterpriseInvitation"
		action="esb/web/enterpriseInvitationManager/saveEnterpriseInvitation.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="invitationId" caption="邀请记录系列" />
			<youi:fieldSelect property="enterbusinessmanagerRz.rzId"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" caption="入驻企业" tooltips="入驻企业" />
			<youi:fieldText property="invitationCode" readonly="true" caption="企业邀请码" />
			<youi:fieldText property="invitationTelephone" caption="会员电话" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->
	<youi:func name="record_enterbusinessmanagerRz_rzId_change" params="value">
		if(value!=''){
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
				data:{rzId:value},
				success:function(result){
					$elem('record_invitationCode',pageId).fieldValue(result.record.rzSign);
				}
			});
		}
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>