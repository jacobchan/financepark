<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_foodOrdermanager" idKeys="userorderId" caption="采购订单列表"  panel="false"
				src="esb/web/ordermanagerUserorderManager/getPagerOrdermanagerUserorders.json" dataFormId="form_foodOrdermanager"
				editSrc="esb/web/ordermanagerUserorderManager/getOrdermanagerUserorder.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerUserorderManager/removeOrdermanagerUserorder.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="userorderCode"  caption="订单编号"/>
			<youi:fieldText property="userorderProject"  caption="订单项目名称"/>
			<youi:fieldText property="userorderBuyUser.memberName"  caption="购买人姓名"/>
			<youi:fieldSelect property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" />
			<youi:fieldHidden property="ordermanagerOrdertype.ordertypeId"  caption="订单类型" defaultValue="02"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="userorderCode"  caption="订单编号" align="center" width="15%"/>
		<youi:gridCol property="userorderProject"  caption="订单项目名称" align="center" width="15%"/>
		<youi:gridCol property="userorderAmount"  caption="订单金额" align="center" width="10%"/>
		<youi:gridCol property="userorderBuyUser.memberName"  caption="购买人姓名" align="center" width="15%"/>
		<youi:gridCol property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" align="center" width="15%"/>
		<youi:gridCol property="userorderPayMode"  caption="支付方式" align="center" convert="payWay" width="15%"/>
		<youi:gridCol property="userorderTime"  caption="下单时间" align="center" width="15%"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-用户订单表编辑 -->
	<youi:form dialog="true" caption="采购订单编辑" id="form_foodOrdermanager" action="esb/web/ordermanagerUserorderManager/saveFoodOrdermanager.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldText property="userorderProject"  caption="订单项目名称"/>
			<youi:fieldText property="userorderAmount"  caption="订单金额"/>
			<youi:fieldSelect property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" />
			<youi:fieldSelect property="userorderPayMode"  caption="支付方式" convert="payWay"/>
			<youi:fieldHidden property="userorderId"  caption="用户订单序列"/>
			<youi:fieldHidden property="ordermanagerOrdertype.ordertypeId"  caption="订单类型" defaultValue="02"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<!--**********************************页面函数End**********************************-->
</youi:page>