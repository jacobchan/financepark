<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_recommendMember" idKeys="recId" caption="350301推荐联系人列表"  panel="false"
				src="esb/web/recommendMemberManager/getPagerRecommendMembers.json" dataFormId="form_recommendMember"
				editSrc="esb/web/recommendMemberManager/getRecommendMember.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/recommendMemberManager/removeRecommendMember.json">
		<youi:fieldLayout>
			<youi:fieldText property="memRole"  caption="职位"/>
			<youi:fieldText property="memName"  caption="联系人姓名"/>
			<youi:fieldText property="memSex"  caption="性别"/>
			<youi:fieldText property="lastBuyTime"  caption="末次购买时间"/>
			<youi:fieldText property="recCode"  caption="推荐码"/>
			<youi:fieldText property="buyCount"  caption="购买次数"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="memPhone"  caption="联系电话"/>
			<youi:fieldText property="regTime"  caption="注册时间"/>
			<youi:fieldText property="isBuy"  caption="是否完成购买"/>

			<youi:fieldText property="regId"  caption="注册会员ID"/>
			<youi:fieldText property="isReg"  caption="是否注册"/>
		</youi:fieldLayout>
		<youi:gridCol property="memRole"  caption="职位"/>
		<youi:gridCol property="memName"  caption="联系人姓名"/>
		<youi:gridCol property="memSex"  caption="性别"/>
		<youi:gridCol property="lastBuyTime"  caption="末次购买时间"/>
		<youi:gridCol property="recCode"  caption="推荐码"/>
		<youi:gridCol property="buyCount"  caption="购买次数"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="memPhone"  caption="联系电话"/>
		<youi:gridCol property="regTime"  caption="注册时间"/>
		<youi:gridCol property="isBuy"  caption="是否完成购买"/>

		<youi:gridCol property="regId"  caption="注册会员ID"/>
		<youi:gridCol property="isReg"  caption="是否注册"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-350301推荐联系人编辑 -->
	<youi:form dialog="true" caption="350301推荐联系人" id="form_recommendMember" action="esb/web/recommendMemberManager/saveRecommendMember.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memRole"  caption="职位"/>
			<youi:fieldText property="memName"  caption="联系人姓名"/>
			<youi:fieldText property="memSex"  caption="性别"/>
			<youi:fieldText property="lastBuyTime"  caption="末次购买时间"/>
			<youi:fieldText property="recCode"  caption="推荐码"/>
			<youi:fieldText property="buyCount"  caption="购买次数"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="memPhone"  caption="联系电话"/>
			<youi:fieldText property="regTime"  caption="注册时间"/>
			<youi:fieldText property="isBuy"  caption="是否完成购买"/>
			<youi:fieldText property="recId"  caption="序列"/>
			<youi:fieldText property="regId"  caption="注册会员ID"/>
			<youi:fieldText property="isReg"  caption="是否注册"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>