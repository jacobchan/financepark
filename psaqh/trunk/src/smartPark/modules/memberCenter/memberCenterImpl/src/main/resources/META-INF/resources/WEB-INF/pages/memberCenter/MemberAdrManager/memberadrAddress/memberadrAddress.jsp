<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_memberadrAddress" idKeys="addressId" caption="-我的地址列表"  panel="false"
				src="esb/web/memberadrAddressManager/getPagerMemberadrAddresss.json" dataFormId="form_memberadrAddress"
				editSrc="esb/web/memberadrAddressManager/getMemberadrAddress.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/memberadrAddressManager/removeMemberadrAddress.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
		</youi:fieldLayout>
		<youi:gridCol property="memberId.memberName"  caption="会员用户" width="20%"/>
		<youi:gridCol property="addressName"  caption="联系人" width="20%"/>
		<youi:gridCol property="addressPhone"  caption="联系电话" width="20%"/>
		<youi:gridCol property="addressDetail"  caption="详细地址" width="20%"/>		
		<youi:gridCol property="addressStatus"  caption="默认状态" convert="addressStatus" width="20%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--我的地址编辑 -->
	<youi:form dialog="true" caption="-我的地址" id="form_memberadrAddress" action="esb/web/memberadrAddressManager/saveMemberadrAddress.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="addressId"  caption="地址ID"/>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" 
								code="memberId" show="memberName" notNull="true"/>
			<youi:fieldText property="addressName"  caption="联系人" notNull="true"/>
			<youi:fieldText property="addressPhone"  caption="联系电话" notNull="true"/>
			<youi:fieldText property="addressDetail"  caption="详细地址" notNull="true"/>
			<youi:fieldSelect property="addressStatus"  caption="默认状态" convert="addressStatus" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>