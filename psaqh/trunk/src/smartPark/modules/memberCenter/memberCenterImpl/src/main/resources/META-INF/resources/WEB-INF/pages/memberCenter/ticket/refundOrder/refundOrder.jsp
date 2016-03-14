<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_refundOrder" idKeys="orderId" caption="退票订单列表"  panel="false"
				src="esb/web/refundOrderManager/getPagerRefundOrders.json" dataFormId="form_refundOrder"
				editSrc="esb/web/refundOrderManager/getRefundOrder.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/refundOrderManager/removeRefundOrder.json">
		<youi:fieldLayout>

			<youi:fieldText property="refundOrderType"  caption="退票订单状态"/>
			<youi:fieldText property="feeAmount"  caption="退票手续费"/>
			<youi:fieldText property="refundOrderNo"  caption="退票订单号码"/>
			<youi:fieldText property="refundRecord"  caption="退票原因"/>
			<youi:fieldText property="refundOrderTime"  caption="退票时间"/>
			<youi:fieldText property="isSucess"  caption="是否成功"/>
			<youi:fieldText property="refundAmount"  caption="退票金额"/>
			<youi:fieldText property="preComeinTime"  caption="预计到账时间"/>
			<youi:fieldText property="manId"  caption="会员ID"/>
		</youi:fieldLayout>

		<youi:gridCol property="refundOrderType"  caption="退票订单状态"/>
		<youi:gridCol property="feeAmount"  caption="退票手续费"/>
		<youi:gridCol property="refundOrderNo"  caption="退票订单号码"/>
		<youi:gridCol property="refundRecord"  caption="退票原因"/>
		<youi:gridCol property="refundOrderTime"  caption="退票时间"/>
		<youi:gridCol property="isSucess"  caption="是否成功"/>
		<youi:gridCol property="refundAmount"  caption="退票金额"/>
		<youi:gridCol property="preComeinTime"  caption="预计到账时间"/>
		<youi:gridCol property="manId"  caption="会员ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-退票订单编辑 -->
	<youi:form dialog="true" caption="退票订单" id="form_refundOrder" action="esb/web/refundOrderManager/saveRefundOrder.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="orderId"  caption="ORDER_ID_"/>
			<youi:fieldText property="refundOrderType"  caption="退票订单状态"/>
			<youi:fieldText property="feeAmount"  caption="退票手续费"/>
			<youi:fieldText property="refundOrderNo"  caption="退票订单号码"/>
			<youi:fieldText property="refundRecord"  caption="退票原因"/>
			<youi:fieldText property="refundOrderTime"  caption="退票时间"/>
			<youi:fieldText property="isSucess"  caption="是否成功"/>
			<youi:fieldText property="refundAmount"  caption="退票金额"/>
			<youi:fieldText property="preComeinTime"  caption="预计到账时间"/>
			<youi:fieldText property="manId"  caption="会员ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>