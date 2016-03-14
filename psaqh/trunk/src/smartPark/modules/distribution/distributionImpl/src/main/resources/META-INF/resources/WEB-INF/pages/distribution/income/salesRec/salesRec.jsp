<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_salesRec" idKeys="saleRecId" caption="楼宇售卖记录列表"  panel="false"
				src="esb/web/salesRecManager/getPagerSalesRecs.json" dataFormId="form_salesRec"
				editSrc="esb/web/salesRecManager/getSalesRec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/salesRecManager/removeSalesRec.json">
		<youi:fieldLayout>
			<youi:fieldText property="disLevelCount"  caption="分佣层数"/>
			<youi:fieldText property="factDisRate"  caption="分佣总比例"/>
			<youi:fieldText property="factDisAmount"  caption="分佣总额"/>
			<youi:fieldText property="roomId"  caption="单元ID"/>

			<youi:fieldText property="saleAmount"  caption="成交金额"/>
			<youi:fieldText property="preDisAmount"  caption="预计分佣总额"/>
			<youi:fieldText property="recId"  caption="序列"/>
			<youi:fieldText property="isOut"  caption="是否超额"/>
			<youi:fieldText property="isExtract"  caption="是否提佣"/>
		</youi:fieldLayout>
		<youi:gridCol property="disLevelCount"  caption="分佣层数"/>
		<youi:gridCol property="factDisRate"  caption="分佣总比例"/>
		<youi:gridCol property="factDisAmount"  caption="分佣总额"/>
		<youi:gridCol property="roomId"  caption="单元ID"/>

		<youi:gridCol property="saleAmount"  caption="成交金额"/>
		<youi:gridCol property="preDisAmount"  caption="预计分佣总额"/>
		<youi:gridCol property="recId"  caption="序列"/>
		<youi:gridCol property="isOut"  caption="是否超额"/>
		<youi:gridCol property="isExtract"  caption="是否提佣"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼宇售卖记录编辑 -->
	<youi:form dialog="true" caption="楼宇售卖记录" id="form_salesRec" action="esb/web/salesRecManager/saveSalesRec.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="disLevelCount"  caption="分佣层数"/>
			<youi:fieldText property="factDisRate"  caption="分佣总比例"/>
			<youi:fieldText property="factDisAmount"  caption="分佣总额"/>
			<youi:fieldText property="roomId"  caption="单元ID"/>
			<youi:fieldText property="saleRecId"  caption="SALE_REC_ID_"/>
			<youi:fieldText property="saleAmount"  caption="成交金额"/>
			<youi:fieldText property="preDisAmount"  caption="预计分佣总额"/>
			<youi:fieldText property="recId"  caption="序列"/>
			<youi:fieldText property="isOut"  caption="是否超额"/>
			<youi:fieldText property="isExtract"  caption="是否提佣"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>