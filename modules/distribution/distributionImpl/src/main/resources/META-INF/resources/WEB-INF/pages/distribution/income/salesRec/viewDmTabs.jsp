<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>
<youi:tabs id="tabs_" >
			<youi:tabItem caption="一级" id="lev1">
				<youi:grid edit="NOT" remove="NOT" add="NOT" id="grid_distMember1"
				src="/settleRecManager/getPagerSettleRecs.json" >	
					<youi:fieldLayout prefix="record">
						<youi:fieldHidden property="disLevel" defaultValue="1"></youi:fieldHidden>
						<youi:fieldHidden property="salesRec"></youi:fieldHidden>
					</youi:fieldLayout>
					<youi:gridCol property="disLevel"  caption="收益链路层级" width="25%"/>
					<youi:gridCol property="disAmount"  caption="佣金结算金额" width="25%"/>
					<youi:gridCol property="disRate"  caption="收益层级比率" width="25%"/>
					<youi:gridCol property="memLevel"  caption="收益当前会员等级" width="25%"/>
				</youi:grid>
			</youi:tabItem>
			<youi:tabItem caption="二级" id="lev2">
				<youi:grid edit="NOT" remove="NOT" add="NOT" id="grid_distMember2"
				src="/settleRecManager/getPagerSettleRecs.json" >
					<youi:fieldLayout prefix="record">
						<youi:fieldHidden property="disLevel" defaultValue="2"></youi:fieldHidden>
						<youi:fieldHidden property="salesRec"></youi:fieldHidden>
					</youi:fieldLayout>
					<youi:gridCol property="disLevel"  caption="收益链路层级" width="25%"/>
					<youi:gridCol property="disAmount"  caption="佣金结算金额" width="25%"/>
					<youi:gridCol property="disRate"  caption="收益层级比率" width="25%"/>
					<youi:gridCol property="memLevel"  caption="收益当前会员等级" width="25%"/>
				</youi:grid>
			</youi:tabItem>
			<youi:tabItem caption="三级" id="lev3">
				<youi:grid edit="NOT" remove="NOT" add="NOT" id="grid_distMember3"
				src="/settleRecManager/getPagerSettleRecs.json" >
					<youi:fieldLayout prefix="record">
						<youi:fieldHidden property="disLevel" defaultValue="3"></youi:fieldHidden>
						<youi:fieldHidden property="salesRec"></youi:fieldHidden>
					</youi:fieldLayout>
					<youi:gridCol property="disLevel"  caption="收益链路层级" width="25%"/>
					<youi:gridCol property="disAmount"  caption="佣金结算金额" width="25%"/>
					<youi:gridCol property="disRate"  caption="收益层级比率" width="25%"/>
					<youi:gridCol property="memLevel"  caption="收益当前会员等级" width="25%"/>
				</youi:grid>
			</youi:tabItem>
		</youi:tabs>

</youi:page>