<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	
	<youi:subpage subpageId="memberView" height="600" caption="售卖佣金记录"
		src="page/distribution.income.salesRec/nextMemberInfo.html?{parentMemberId:parentMember}">
	</youi:subpage>
	
	<youi:grid id="grid_memberInfo" idKeys="memberId" caption="会员列表"  panel="false"
				src="esb/web/memberInformationManager/getMemberInformations.json" dataFormId="form_salesRec"
				 edit="NOT" remove="NOT" showCheckbox="true" add="NOT">
		<youi:fieldLayout>
			<youi:fieldText property="memberName"  caption="姓名"/>
			<youi:fieldText property="memberPhoneNumber"  caption="手机号码"/>
		</youi:fieldLayout>
		<youi:gridCol property="memberName"  caption="姓名" width="25%"/>
		<youi:gridCol property="memberPhoneNumber"  caption="手机号码" width="25%"/>
		<youi:gridCol property="memberNickname"  caption="昵称" width="25%"/>
		<youi:gridCol property="level"  caption="会员等级" width="25%"/>
		<youi:fieldHidden property="memberId"></youi:fieldHidden>
		
		 <youi:button active="1" name="viewDmTabs" caption="详细信息"/>   
		
	</youi:grid>
	
	<!--**********************************页面函数Start********************************-->
	
	
	<youi:func name="func_grid_viewDmTabs">
		var selectRecord	 = $elem('grid_memberInfo',pageId).grid('getSelectedRecord');
		var parentMember = selectRecord['memberId'];
		var subpageElement = $elem('subpage_memberView',pageId);
		subpageElement.subpage('open',null,null,{parentMemberId:parentMember});
	</youi:func>
	
	<!--**********************************页面函数End**********************************-->
</youi:page>
