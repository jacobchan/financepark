<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_settleRec" idKeys="pocRecId" caption="佣金结算记录列表"  panel="false"
				src="esb/web/settleRecManager/getPagerSettleRecs.json" dataFormId="form_settleRec"
				editSrc="esb/web/settleRecManager/getSettleRec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/settleRecManager/removeSettleRec.json">
		<youi:fieldLayout>

			<youi:fieldText property="disLevel"  caption="收益链路层级"/>
			<youi:fieldText property="memId"  caption="佣金受益人"/>
			<youi:fieldText property="memLevel"  caption="收益当前会员等级"/>
			<youi:fieldText property="disAmount"  caption="佣金结算金额"/>
			<youi:fieldText property="disRate"  caption="收益层级比率"/>
		</youi:fieldLayout>

		<youi:gridCol property="disLevel"  caption="收益链路层级"/>
		<youi:gridCol property="memId"  caption="佣金受益人"/>
		<youi:gridCol property="memLevel"  caption="收益当前会员等级"/>
		<youi:gridCol property="disAmount"  caption="佣金结算金额"/>
		<youi:gridCol property="disRate"  caption="收益层级比率"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-佣金结算记录编辑 -->
	<youi:form dialog="true" caption="佣金结算记录" id="form_settleRec" action="esb/web/settleRecManager/saveSettleRec.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="pocRecId"  caption="POC_REC_ID_"/>
			<youi:fieldText property="disLevel"  caption="收益链路层级"/>
			<youi:fieldText property="memId"  caption="佣金受益人"/>
			<youi:fieldText property="memLevel"  caption="收益当前会员等级"/>
			<youi:fieldText property="disAmount"  caption="佣金结算金额"/>
			<youi:fieldText property="disRate"  caption="收益层级比率"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>