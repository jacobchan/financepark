<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerUserorder" idKeys="userorderId" caption="用户订单表列表"  panel="false"
				src="esb/web/ordermanagerUserorderManager/getPagerOrdermanagerUserordersForPublic.json" dataFormId="form_ordermanagerUserorder"
				editSrc="esb/web/ordermanagerUserorderManager/getOrdermanagerUserorder.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerUserorderManager/removeOrdermanagerUserorder.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="userorderPayMode"  caption="支付方式" convert="payWay"/>
			<youi:fieldSelect property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus"/>
			<youi:fieldCalendar property="userorderTime"  caption="下单时间" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:gridCol property="userorderCode"  caption="订单编号" align="center" width="20%"/>
		<youi:gridCol property="userorderProject"  caption="订单项目" align="center" width="15%"/>
		<youi:gridCol property="userorderTime"  caption="下单时间" align="center" width="15%"/>
		<youi:gridCol property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" align="center" width="10%"/>
		<youi:gridCol property="userorderPayMode"  caption="支付方式" convert="payWay" align="center" width="15%"/>
		<youi:gridCol property="userorderBuyUser"  caption="购买人" align="center" width="10%"/>
		<youi:gridCol property="userorderAmount"  caption="订单金额" align="right" width="10%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		<youi:button name="cancel" caption="取消订单" active="1"/>
		<youi:button name="pay" caption="付款" active="1"/>
	</youi:grid>
	
	<!-- form-用户订单表编辑 -->
	<youi:form dialog="true" caption="用户订单表" id="form_ordermanagerUserorder" action="esb/web/ordermanagerUserorderManager/saveOrdermanagerUserorder.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldText property="userorderPayMode"  caption="支付方式"/>
			<youi:fieldText property="userorderBuyUser"  caption="购买人"/>
			<youi:fieldText property="userorderAmount"  caption="订单金额"/>
			<youi:fieldText property="userorderId"  caption="用户订单序列"/>
			<youi:fieldText property="bxId"  caption="报修记录ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldSelect property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus"></youi:fieldSelect>
			<youi:fieldText property="userorderProject"  caption="订单项目"/>
			<youi:fieldCalendar property="userorderTime"  caption="下单时间"/>
			<youi:fieldText property="userorderCode"  caption="订单编号"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="clear_button">
		var gridElement = $elem('grid_ordermanagerUserorder',pageId);
           gridElement.find('#button_cancel').addClass('disabled');
		gridElement.find('#button_pay').addClass('disabled');	
	</youi:func>
	<youi:func name="grid_ordermanagerUserorder_select">
        eval('P_'+pageId+'_clear_button();');
        var gridElement = $elem('grid_ordermanagerUserorder',pageId);
		var select = gridElement.grid('getSelectedRecord');
		var userorderStatus = select.userorderStatus;
         if(userorderStatus=='00'){
			gridElement.find('#button_cancel').removeClass('disabled');	
			gridElement.find('#button_pay').removeClass('disabled');	
		}
	</youi:func>
	
	<youi:func name="func_grid_pay">
	var gridElement = $elem('grid_ordermanagerUserorder',pageId);
	var select = gridElement.grid('getSelectedRecord');
	var userorderStatus='01';
	$.youi.ajaxUtil.ajax({
		url:'esb/web/ordermanagerUserorderManager/updateUserorderStatus.json',
	 	data:'userorderId='+select.userorderId+'&userorderStatus='+userorderStatus,
		success:function(result){
			gridElement.grid('pReload');
		}
	});
	</youi:func>
	<youi:func name="func_grid_cancel">
	var gridElement = $elem('grid_ordermanagerUserorder',pageId);
	var select = gridElement.grid('getSelectedRecord');
    var userorderId=select.userorderId;
	$.youi.ajaxUtil.ajax({
		url:'esb/web/publicutilitiesmanagerResoManager/updateUserorderStatus.json',
	 	data:{userorderId:userorderId},
		success:function(result){
            alert("订单取消成功！");
			gridElement.grid('pReload');
		}
	});

	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>