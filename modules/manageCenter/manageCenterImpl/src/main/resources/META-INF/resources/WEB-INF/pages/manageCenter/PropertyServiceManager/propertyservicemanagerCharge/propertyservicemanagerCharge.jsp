<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	
	<youi:subpage
		src="page/manageCenter.PropertyServiceManager.propertyservicemanagerCharge/addSFproManage.html?propertyservicemanagerCharge.chargeId={chargeId}" 
		subpageId="addSFproManage" height="600" caption="物业收费登记增加">
	</youi:subpage>
	<youi:subpage
		src="page/manageCenter.PropertyServiceManager.propertyservicemanagerCharge/updateSFproManage.html?propertyservicemanagerCharge.chargeId={chargeId}" 
		subpageId="updateSFproManage" height="600" caption="物业收费登记修改">
	</youi:subpage>

	<youi:grid id="grid_propertyservicemanagerCharge" idKeys="chargeId" caption="物业收费登记表列表"  panel="false" pageSize="2" add="NOT"
				src="esb/web/propertyservicemanagerChargeManager/getPagerPropertyservicemanagerCharges.json" dataFormId="form_propertyservicemanagerCharge"
				editSrc="esb/web/propertyservicemanagerChargeManager/getPropertyservicemanagerCharge.json" exportXls="true" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerChargeManager/removePropertyservicemanagerCharge.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="bbmRoom.roomNo"  caption="单元编号" onlyLeaf="true"/>
			<youi:fieldText property="ordermanagerUserorder.userorderCode"  caption="用户订单编号"/>
			<youi:fieldSelect property="chargeIsbool" convert="bool" caption="是否缴费"/>
			<youi:fieldCalendar property="chargeCreatetime"  caption="登记日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldCalendar property="chargeTime"  caption="缴费日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:gridCol property="userorder.userorderCode"  caption="用户订单编号" width="17%" align="center"/>
		<youi:gridCol property="bbmRoom.roomNo"  caption="单元编号"  width="13%" align="center"/>
		<youi:gridCol property="chargeComp"  caption="收费企业名称"  width="10%" align="center"/>
		<youi:gridCol property="chargeAmount"  caption="应缴费总额"  width="10%" align="center"/>
		<youi:gridCol property="chargeIsbool"  caption="是否缴费"  width="10%" convert="bool" align="center"/>
		<youi:gridCol property="chargeCreatetime"  caption="登记日期"  width="10%" align="center"/>
		<youi:gridCol property="chargeTime"  caption="缴费日期"  width="10%" align="center"/>
		<youi:gridCol property="chargeBedate"  caption="起始日期"  width="10%" align="center"/>
		<youi:gridCol property="chargeEndate"  caption="截止日期"  width="10%" align="center"/>
		<youi:gridCol property="bbmRoom.roomId"  caption="单元Id"  width="0"/>
		
		<youi:button name="sFproAdd" caption="增加"/>
		<youi:button active="1" name="sFproUpdate" caption="修改"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	
	<!--**********************************页面函数********************************-->
	
	<youi:func name="func_grid_sFproAdd">
		var gridElement = $elem('grid_propertyservicemanagerCharge',pageId);
		var subpageElement = $elem('subpage_addSFproManage',pageId);
		var selectedRecord = gridElement.grid('getSelectedRecord');
		//打开子页面
		subpageElement.subpage('open',null,null,null);
	</youi:func>
	<youi:func name="func_grid_sFproUpdate">
		var gridElement = $elem('grid_propertyservicemanagerCharge',pageId);
		var subpageElement = $elem('subpage_updateSFproManage',pageId);
		var selectedRecord = gridElement.grid('getSelectedRecord');
		//打开子页面
		subpageElement.subpage('open',selectedRecord,null,selectedRecord);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>