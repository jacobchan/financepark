<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_compSerOrderMg" idKeys="userorderId" caption="预留停车位订单列表"  panel="false" 
				src="esb/web/ordermanagerUserorderManager/getUserorder.json?genreCode=0304" dataFormId="form_carOrder"
				editSrc="esb/web/carportManager/getPagerCarports.json?indexPage=1&code=${userorderCode}" edit="NOT" remove="NOT" showCheckbox="true" add="NOT"
				removeSrc="esb/web/ordermanagerUserorderManager/removeOrdermanagerUserorder.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="userorderCode"  caption="订单编号"/>
			<youi:fieldText property="userorderProject"  caption="订单项目名称"/>
			<youi:fieldText property="userorderBuyUser"  caption="购买人姓名"/>
			<youi:fieldSelect property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" />
			<youi:fieldSelect property="genreId.genreName"  caption="订单类型" code="genreId" show="genreName"
				src="esb/web/purchasingmanagerGenreManager/getCompSerOrderTypes.json"/> 
		</youi:fieldLayout>
		<youi:button name="infoBut" caption="查看" active="1"></youi:button> 
		<youi:gridCol property="userorderCode"  caption="订单编号" align="center" width="15%"/>
		<youi:gridCol property="userorderProject"  caption="订单项目名称" align="center" width="15%"/>
		<youi:gridCol property="genreId.genreName"  caption="订单类型" align="center" width="15%"/>
		<youi:gridCol property="userorderAmount"  caption="订单金额" align="center" width="10%"/>
		<youi:gridCol property="userorderBuyUser"  caption="购买人姓名" align="center" width="10%"/>
		<youi:gridCol property="userorderStatus"  caption="订单状态" convert="commodityOrderStatus" align="center" width="10%"/>
		<youi:gridCol property="userorderPayMode"  caption="支付方式" align="center" convert="payWay" width="10%"/>
		<youi:gridCol property="userorderTime"  caption="下单时间" align="center" width="15%"/>

	</youi:grid>
	
	<!-- form-用户订单表编辑 -->
	<youi:form dialog="true" caption="企业服务订单编辑" id="form_carOrder"  submit="NOT" reset="NOT"
		action="esb/web/carportManager/getPagerCarports.json?indexPage=1">
		<youi:fieldLayout prefix="records" labelWidths="100,100">
			<youi:fieldText property="cpEnName"  caption="企业名称"/>
			<youi:fieldText property="cpCount"  caption="车辆数量"/>
			<youi:fieldText property="cpLinkMan"  caption="联系人"/>
			<youi:fieldText property="cpLinkTel"  caption="联系方式"/>
			<youi:fieldText property="cpEntdTime"  caption="结束时间"/>
			<youi:fieldText property="cpBegionTime"  caption="开始时间"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_infoBut">
		var gridElement = $elem('grid_compSerOrderMg',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
      	var userorderId = selectedRecord.userorderId;
		 $.youi.ajaxUtil.ajax({
				url:'esb/web/carportManager/getPagerCarports.json',
				data:{applayNo:userorderId,indexPage:'1'},
				success:function(result){
				var record = result.records;
					$elem('form_carOrder',pageId).form("reset")
							.form('fillRecord',record[0]).form('open');
                  } 
            })
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>