<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerCos" idKeys="cosId"
		caption="物业投诉记录表列表" panel="false"
		src="esb/web/propertyservicemanagerCosManager/getPagerPropertyservicemanagerCoss.json"
		dataFormId="form_propertyservicemanagerCos"
		editSrc="esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCos.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/propertyservicemanagerCosManager/removePropertyservicemanagerCos.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="cosCode" caption="投诉单号" />
			<youi:fieldText property="cosName" caption="投诉联系人" />
			<youi:fieldSelect property="memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberNickname" caption="会员用户" />
			<youi:fieldSelect property="cosStatus" caption="投诉受理状态" convert="acceptanceStatus" />
			<youi:fieldSelect property="cosBool" caption="是否接受回访" convert="isAbleVisible" />
			<youi:fieldText property="cosTelephone" caption="回访电话" />
			<youi:fieldCalendar property="cosTime" caption="投诉时间"
				format="yyyy-MM-dd" />
		</youi:fieldLayout>
		<youi:gridCol property="cosCode" caption="投诉单号" width="100" />
		<youi:gridCol property="cosContent" caption="投诉内容" width="280" />
		<youi:gridCol property="cosName" caption="投诉联系人" width="100" />
		<youi:gridCol property="memberId" caption="会员用户" width="100" />
		<youi:gridCol property="cosStatus" caption="投诉受理状态" convert="acceptanceStatus" width="100" />
		<youi:gridCol property="cosBool" caption="是否接受回访" convert="isAbleVisible" width="100" />
		<youi:gridCol property="cosTelephone" caption="回访电话" width="100" />
		<youi:gridCol property="cosTime" caption="投诉时间" width="120" />
		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-物业投诉记录表编辑 -->
	<youi:form dialog="true" caption="物业投诉记录表"
		id="form_propertyservicemanagerCos"
		action="esb/web/propertyservicemanagerCosManager/savePropertyservicemanagerCos.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldText property="cosId" caption="投诉ID" />
			<youi:fieldText property="cosCode" caption="投诉单号" />
			<youi:fieldText property="cosName" caption="投诉联系人" />
			<youi:fieldSelect property="memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberNickname" caption="会员用户" />
			<youi:fieldSelect property="cosStatus" caption="投诉受理状态" convert="acceptanceStatus" />
			<youi:fieldSelect property="cosBool" caption="是否接受回访" convert="isAbleVisible" />
			<youi:fieldText property="cosTelephone" caption="回访电话" />
			<youi:fieldCalendar property="cosTime" caption="投诉时间"
				format="yyyy-MM-dd" />
			<youi:fieldArea property="cosContent" caption="投诉内容" rows="8"
				column="20" tooltips="投诉内容" notNull="true" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->

	<!--**********************************页面函数End**********************************-->
</youi:page>