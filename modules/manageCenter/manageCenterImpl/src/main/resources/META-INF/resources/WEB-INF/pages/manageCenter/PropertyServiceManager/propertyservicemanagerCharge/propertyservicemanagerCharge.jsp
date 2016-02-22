<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:table columns="1">
		<youi:cell>
			<!-- grid-代码集列表-->
			<youi:grid id="grid_propertyservicemanagerCharge" idKeys="chargeId" dataFormId="form_propertyservicemanagerCharge"  caption="物业收费登记表列表" 
						src="esb/web/propertyservicemanagerChargeManager/getPagerPropertyservicemanagerCharges.json" pageSize="8" height="360" ctrlCheck="true"
						editSrc="esb/web/propertyservicemanagerChargeManager/getPropertyservicemanagerCharge.json" showCheckbox="true" panel="false"
						removeSrc="esb/web/propertyservicemanagerChargeManager/removePropertyservicemanagerCharge.json">
				<youi:fieldLayout labelWidths="120,120">
					<youi:fieldText property="bbmRoom.roomNo"  caption="单元编号"/>
					<youi:fieldText property="ordermanagerUserorder.userorderCode"  caption="用户订单编号"/>
					<youi:fieldSelect property="chargeIsbool" convert="bool" caption="是否缴费"/>
					<youi:fieldCalendar property="chargeCreatetime"  caption="登记日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
					<youi:fieldCalendar property="chargeTime"  caption="缴费日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
				</youi:fieldLayout>
				
				<youi:gridCol property="ordermanagerUserorder.userorderCode"  caption="用户订单编号" width="15%"/>
				<youi:gridCol property="bbmRoom.roomNo"  caption="单元编号"  width="15%"/>
				<youi:gridCol property="chargeComp"  caption="收费企业名称"  width="10%"/>
				<youi:gridCol property="chargeAmount"  caption="应缴费总额"  width="10%"/>
				<youi:gridCol property="chargeIsbool"  caption="是否缴费"  width="10%"/>
				<youi:gridCol property="chargeCreatetime"  caption="登记日期"  width="10%"/>
				<youi:gridCol property="chargeTime"  caption="缴费日期"  width="10%"/>
				<youi:gridCol property="chargeBedate"  caption="起始日期"  width="10%"/>
				<youi:gridCol property="chargeEndate"  caption="截止日期"  width="10%"/>
				
			</youi:grid>
		</youi:cell>
			
		<youi:cell>
			<!-- grid-代码项列表-->
			<youi:grid id="grid_propertyservicemanagerSfpro" idKeys="sfproId" dataFormId="form_propertyservicemanagerSfpro"  caption="物业收费项目表列表" 
						src="esb/web/propertyservicemanagerSfproManager/getPagerPropertyservicemanagerSfprosByCharge.json" panel="false"  height="320"
						editSrc="esb/web/propertyservicemanagerSfproManager/getPropertyservicemanagerSfpro.json" submit="NOT" reset="NOT"
						removeSrc="esb/web/propertyservicemanagerSfproManager/removePropertyservicemanagerSfpro.json" showNum="true"
						parentId="grid_propertyservicemanagerCharge" parentAttr="propertyservicemanagerCharge">
				<youi:gridCol property="sfproName" convert="sfproName"  width="50%" caption="收费项目名称"/>
				<youi:gridCol property="sfproAmount" width="50%" caption="项目金额"/>
			</youi:grid>
		</youi:cell>
	</youi:table>
	
	
	
	<!-- form-物业收费登记表编辑 -->
	<youi:form dialog="true" caption="物业收费登记表" id="form_propertyservicemanagerCharge" action="esb/web/propertyservicemanagerChargeManager/savePropertyservicemanagerCharge.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="chargeId"  caption="收费登记序列"/>
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"></youi:fieldSelect>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingCaption" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorCaption" showProperty="bbmFloor.floorCaption"
				src="esb/web/bbmFloorManager/getBbmFloors.json" parents="bbmBuilding.buildingId" parentsAlias="bbmBuilding.buildingId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmRoom.roomId" caption="所属单元" code="roomId" show="roomNo" showProperty="bbmRoom.roomNo"
				src="esb/web/bbmRoomManager/getBbmRooms.json" parents="bbmFloor.floorId" parentsAlias="bbmFloor.floorId"></youi:fieldSelect>
			<youi:fieldSelect property="chargeIsbool" convert="bool" caption="是否缴费"/>
			<youi:fieldCalendar property="chargeCreatetime"  caption="登记日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldCalendar property="chargeBedate"  caption="起始日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldCalendar property="chargeEndate"  caption="截止日期" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-物业收费项目表编辑 -->
	<youi:form dialog="true" caption="物业收费项目表" id="form_propertyservicemanagerSfpro" action="esb/web/propertyservicemanagerSfproManager/savePropertyservicemanagerSfpro.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="sfproId"  caption="收费项目ID"/>
			<youi:fieldHidden property="propertyservicemanagerCharge.chargeId"  caption="收费登记表ID"/>
			<youi:fieldSelect property="sfproName" convert="sfproName" caption="收费项目名称"/>
			<youi:fieldText property="sfproAmount"  caption="项目金额"/>
		</youi:fieldLayout>
	</youi:form>
	
	
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>