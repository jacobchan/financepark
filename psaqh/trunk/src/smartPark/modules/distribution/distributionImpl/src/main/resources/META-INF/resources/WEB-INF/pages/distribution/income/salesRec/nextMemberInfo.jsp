<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>
<youi:tabs id="tabs_" >
			<youi:tabItem caption="一级" id="lev1">
				<youi:grid edit="NOT" remove="NOT" add="NOT" id="grid_distMember1"
				src="/salesRecManager/findNextMember.json">	
					<youi:fieldLayout prefix="record">
						<youi:fieldHidden property="lev" defaultValue="1"></youi:fieldHidden>
						<youi:fieldHidden property="parentMemberId"></youi:fieldHidden>
					</youi:fieldLayout>
					<youi:gridCol property="memberName"  caption="姓名" width="25%"/>
					<youi:gridCol property="memberPhoneNumber"  caption="手机号码" width="25%"/>
					<youi:gridCol property="memberNickname"  caption="昵称" width="25%"/>
					<youi:gridCol property="level"  caption="会员等级" width="25%"/>
				</youi:grid>
			</youi:tabItem>
			<youi:tabItem caption="二级" id="lev2">
				<youi:grid edit="NOT" remove="NOT" add="NOT" id="grid_distMember2"
				src="/salesRecManager/findNextMember.json" >
					<youi:fieldLayout prefix="record">
						<youi:fieldHidden property="lev" defaultValue="2"></youi:fieldHidden>
						<youi:fieldHidden property="parentMemberId"></youi:fieldHidden>
					</youi:fieldLayout>
					<youi:gridCol property="memberName"  caption="姓名" width="25%"/>
					<youi:gridCol property="memberPhoneNumber"  caption="手机号码" width="25%"/>
					<youi:gridCol property="memberNickname"  caption="昵称" width="25%"/>
					<youi:gridCol property="level"  caption="会员等级" width="25%"/>
				</youi:grid>
			</youi:tabItem>
			<youi:tabItem caption="三级" id="lev3">
				<youi:grid edit="NOT" remove="NOT" add="NOT" id="grid_distMember3"
				src="/salesRecManager/findNextMember.json">
					<youi:fieldLayout prefix="record">
						<youi:fieldHidden property="lev" defaultValue="3"></youi:fieldHidden>
						<youi:fieldHidden property="parentMemberId"></youi:fieldHidden>
					</youi:fieldLayout>
					<youi:gridCol property="memberName"  caption="姓名" width="25%"/>
					<youi:gridCol property="memberPhoneNumber"  caption="手机号码" width="25%"/>
					<youi:gridCol property="memberNickname"  caption="昵称" width="25%"/>
					<youi:gridCol property="level"  caption="会员等级" width="25%"/>
				</youi:grid>
			</youi:tabItem>
		</youi:tabs>
	
</youi:page>