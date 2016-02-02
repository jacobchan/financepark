<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_memberInformation" idKeys="memberId" caption="-会员信息表列表"  panel="false"
				src="esb/web/memberInformationManager/getPagerMemberInformations.json" dataFormId="form_memberInformation"
				editSrc="esb/web/memberInformationManager/getMemberInformation.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/memberInformationManager/removeMemberInformation.json">
		<youi:fieldLayout>

			<youi:fieldText property="memberPhoneNumber"  caption="电话号码"/>
			<youi:fieldText property="companyInvitecode"  caption="企业邀请码"/>
			<youi:fieldText property="memberDescribe2"  caption="简介"/>
			<youi:fieldText property="memberHeadPortrait"  caption="头像"/>
			<youi:fieldText property="memberName"  caption="姓名"/>
			<youi:fieldText property="memberNickname"  caption="昵称"/>
			<youi:fieldText property="memberBirthdate"  caption="出生日期"/>
			<youi:fieldText property="companyId"  caption="企业ID"/>
		</youi:fieldLayout>

		<youi:gridCol property="memberPhoneNumber"  caption="电话号码"/>
		<youi:gridCol property="companyInvitecode"  caption="企业邀请码"/>
		<youi:gridCol property="memberDescribe2"  caption="简介"/>
		<youi:gridCol property="memberHeadPortrait"  caption="头像"/>
		<youi:gridCol property="memberName"  caption="姓名"/>
		<youi:gridCol property="memberNickname"  caption="昵称"/>
		<youi:gridCol property="memberBirthdate"  caption="出生日期"/>
		<youi:gridCol property="companyId"  caption="企业ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--会员信息表编辑 -->
	<youi:form dialog="true" caption="-会员信息表" id="form_memberInformation" action="esb/web/memberInformationManager/saveMemberInformation.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="memberPhoneNumber"  caption="电话号码"/>
			<youi:fieldText property="companyInvitecode"  caption="企业邀请码"/>
			<youi:fieldText property="memberDescribe2"  caption="简介"/>
			<youi:fieldText property="memberHeadPortrait"  caption="头像"/>
			<youi:fieldText property="memberName"  caption="姓名"/>
			<youi:fieldText property="memberNickname"  caption="昵称"/>
			<youi:fieldText property="memberBirthdate"  caption="出生日期"/>
			<youi:fieldText property="companyId"  caption="企业ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>