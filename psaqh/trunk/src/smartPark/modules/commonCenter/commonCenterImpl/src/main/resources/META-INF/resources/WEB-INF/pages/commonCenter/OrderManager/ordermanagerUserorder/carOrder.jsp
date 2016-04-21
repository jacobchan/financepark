<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_compSerOrderMg" idKeys="userorderId" caption="预留停车位订单列表"  panel="false"
				src="esb/web/ordermanagerUserorderManager/getUserorder.json?genreCode=0304" dataFormId="form_compSerOrderMg"
				editSrc="esb/web/ordermanagerUserorderManager/getOrdermanagerUserorder.json" edit="NOT" remove="NOT" showCheckbox="true" add="NOT"
				removeSrc="esb/web/ordermanagerUserorderManager/removeOrdermanagerUserorder.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="userorderCode"  caption="订单编号"/>
			<youi:fieldText property="userorderProject"  caption="订单项目名称"/>
			<youi:fieldText property="userorderBuyUser"  caption="购买人姓名"/>
			<youi:fieldSelect property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" />
			<youi:fieldSelect property="genreId.genreName"  caption="订单类型" code="genreId" show="genreName"
				src="esb/web/purchasingmanagerGenreManager/getCompSerOrderTypes.json"/> 
		</youi:fieldLayout>
		
		<youi:gridCol property="userorderCode"  caption="订单编号" align="center" width="15%"/>
		<youi:gridCol property="userorderProject"  caption="订单项目名称" align="center" width="15%"/>
		<youi:gridCol property="genreId.genreName"  caption="订单类型" align="center" width="15%"/>
		<youi:gridCol property="userorderAmount"  caption="订单金额" align="center" width="10%"/>
		<youi:gridCol property="userorderBuyUser"  caption="购买人姓名" align="center" width="10%"/>
		<youi:gridCol property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" align="center" width="10%"/>
		<youi:gridCol property="userorderPayMode"  caption="支付方式" align="center" convert="payWay" width="10%"/>
		<youi:gridCol property="userorderTime"  caption="下单时间" align="center" width="15%"/>
		
	</youi:grid>
	
	
	<!--**********************************页面函数Start********************************-->
	<!--**********************************页面函数End**********************************-->
</youi:page>