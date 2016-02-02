<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerUserorder" idKeys="userorderId" caption="用户订单表列表"  panel="false"
				src="esb/web/ordermanagerUserorderManager/getPagerOrdermanagerUserorders.json" dataFormId="form_ordermanagerUserorder"
				editSrc="esb/web/ordermanagerUserorderManager/getOrdermanagerUserorder.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerUserorderManager/removeOrdermanagerUserorder.json">
		<youi:fieldLayout>
			<youi:fieldText property="userorderPayMode"  caption="支付方式"/>
			<youi:fieldText property="userorderBuyUser"  caption="购买人"/>
			<youi:fieldText property="userorderAmount"  caption="订单金额"/>

			<youi:fieldText property="bxId"  caption="报修记录ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="userorderStatus"  caption="订单状态"/>
			<youi:fieldText property="userorderProject"  caption="订单项目"/>
			<youi:fieldText property="userorderTime"  caption="下单时间"/>
			<youi:fieldText property="userorderCode"  caption="订单编号"/>
		</youi:fieldLayout>
		<youi:gridCol property="userorderPayMode"  caption="支付方式"/>
		<youi:gridCol property="userorderBuyUser"  caption="购买人"/>
		<youi:gridCol property="userorderAmount"  caption="订单金额"/>

		<youi:gridCol property="bxId"  caption="报修记录ID"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="userorderStatus"  caption="订单状态"/>
		<youi:gridCol property="userorderProject"  caption="订单项目"/>
		<youi:gridCol property="userorderTime"  caption="下单时间"/>
		<youi:gridCol property="userorderCode"  caption="订单编号"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-用户订单表编辑 -->
	<youi:form dialog="true" caption="用户订单表" id="form_ordermanagerUserorder" action="esb/web/ordermanagerUserorderManager/saveOrdermanagerUserorder.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="userorderPayMode"  caption="支付方式"/>
			<youi:fieldText property="userorderBuyUser"  caption="购买人"/>
			<youi:fieldText property="userorderAmount"  caption="订单金额"/>
			<youi:fieldText property="userorderId"  caption="用户订单序列"/>
			<youi:fieldText property="bxId"  caption="报修记录ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="userorderStatus"  caption="订单状态"/>
			<youi:fieldText property="userorderProject"  caption="订单项目"/>
			<youi:fieldText property="userorderTime"  caption="下单时间"/>
			<youi:fieldText property="userorderCode"  caption="订单编号"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>