<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_memberadrAddress" idKeys="addressId" caption="-我的地址列表"  panel="false"
				src="esb/web/memberadrAddressManager/getPagerMemberadrAddresss.json" dataFormId="form_memberadrAddress"
				editSrc="esb/web/memberadrAddressManager/getMemberadrAddress.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/memberadrAddressManager/removeMemberadrAddress.json">
		<youi:fieldLayout>

			<youi:fieldText property="addressStatus"  caption="默认状态"/>
			<youi:fieldText property="addressDetail"  caption="详细地址"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>

		<youi:gridCol property="addressStatus"  caption="默认状态"/>
		<youi:gridCol property="addressDetail"  caption="详细地址"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--我的地址编辑 -->
	<youi:form dialog="true" caption="-我的地址" id="form_memberadrAddress" action="esb/web/memberadrAddressManager/saveMemberadrAddress.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="addressId"  caption="地址ID"/>
			<youi:fieldText property="addressStatus"  caption="默认状态"/>
			<youi:fieldText property="addressDetail"  caption="详细地址"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>