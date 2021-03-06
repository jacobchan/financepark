<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_memberInformation" idKeys="memberId" caption="-会员信息表列表"  panel="false"
				src="esb/web/memberInformationManager/getPagerMemberInformations.json" dataFormId="form_memberInformation"
				editSrc="esb/web/memberInformationManager/getMemberInformation.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/memberInformationManager/removeMemberInformation.json">
		<youi:fieldLayout>
			<youi:fieldCalendar property="memberBirthdate"  caption="出生日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldText property="memberNickname"  caption="昵称"/>
			<youi:fieldText property="memberDescribe2"  caption="简介"/>
			<youi:fieldText property="memberHeadPortrait"  caption="头像"/>
			<youi:fieldText property="memberName"  caption="姓名"/>
			<youi:fieldText property="memberPhoneNumber"  caption="电话号码"/>
			<youi:fieldText property="companyId"  caption="企业ID"/>

			<youi:fieldText property="companyInvitecode"  caption="企业邀请码"/>
		</youi:fieldLayout>
		<youi:gridCol property="memberName"  caption="姓名" width="10%"/>
		<youi:gridCol property="memberNickname"  caption="昵称" width="10%"/>
		<youi:gridCol property="memberBirthdate"  caption="出生日期" width="10%"/>
		<youi:gridCol property="memberNickname"  caption="昵称" width="10%"/>
		<youi:gridCol property="memberPhoneNumber"  caption="电话号码" width="10%"/>
		<youi:gridCol property="memberHeadPortrait"  caption="头像" width="10%"/>	
		<youi:gridCol property="memberDescribe2"  caption="简介" width="20%"/>
		<youi:gridCol property="companyId"  caption="企业ID" width="10%"/>
		<youi:gridCol property="companyInvitecode"  caption="企业邀请码" width="10%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--会员信息表编辑 -->
	<youi:form dialog="true" caption="-会员信息表" id="form_memberInformation" action="esb/web/memberInformationManager/saveMemberInformation.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="memberName"  caption="姓名" notNull="true"/>
			<youi:fieldText property="memberNickname"  caption="昵称" notNull="true"/>
			<youi:fieldText property="memberHeadPortrait"  caption="头像"/>
			<youi:fieldCalendar property="memberBirthdate"  caption="出生日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldText property="memberPhoneNumber"  caption="电话号码" expression="^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$" expressionMessage="手机号码格式不正确" notNull="true"/>
			<youi:fieldText property="companyId"  caption="企业ID"/>
			<youi:fieldText property="companyInvitecode"  caption="企业邀请码"/>
			<youi:fieldArea property="memberDescribe2"  caption="简介" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>