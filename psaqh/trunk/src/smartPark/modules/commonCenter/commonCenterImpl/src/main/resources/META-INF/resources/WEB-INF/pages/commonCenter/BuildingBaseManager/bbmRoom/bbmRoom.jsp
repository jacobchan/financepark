<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmRoom" idKeys="roomId" caption="单元基础信息列表"  panel="false"
				src="esb/web/bbmRoomManager/getPagerBbmRooms.json" dataFormId="form_bbmRoom"
				editSrc="esb/web/bbmRoomManager/getBbmRoom.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmRoomManager/removeBbmRoom.json">
		<youi:fieldLayout>
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldText property="roomCaption"  caption="单元说明"/>
			<youi:fieldText property="enteredEnt"  caption="包含企业"/>
			<youi:fieldText property="status"  caption="使用状态"/>

		</youi:fieldLayout>
		<youi:gridCol property="roomNo"  caption="单元编号" width="150px"/>
		<youi:gridCol property="roomCaption"  caption="单元说明" width="150px"/>
		<youi:gridCol property="enteredEnt"  caption="包含企业" width="150px"/>
		<youi:gridCol property="bbmBuilding.buildingNo" caption="所属楼栋" width="150px"/>
		<youi:gridCol property="bbmFloor.floorNo" caption="所属楼层" width="150px"/>
		<youi:gridCol property="status"  caption="使用状态" width="150px"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-单元基础信息编辑 -->
	<youi:form dialog="true" caption="单元基础信息" id="form_bbmRoom" action="esb/web/bbmRoomManager/saveBbmRoom.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="roomId"  caption="单元ID"/>
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldText property="roomCaption"  caption="单元说明"/>
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"></youi:fieldSelect>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingNo" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorNo" showProperty="bbmFloor.floorCaption"
				src="esb/web/bbmFloorManager/getBbmFloors.json" parents="bbmBuilding.buildingId" parentsAlias="bbmBuilding.buildingId"></youi:fieldSelect>
			<youi:fieldText property="status"  caption="使用状态"/>
			<youi:fieldText property="enteredEnt"  caption="包含企业"/>
			
			<youi:fieldHidden property="rentCharge"  caption="物业_租金"/>
			<youi:fieldHidden property="floor"  caption="所属楼层" />
			<youi:fieldHidden property="eneryCharge"  caption="物业_电费" />
			<youi:fieldHidden property="waterCharge"  caption="物业_水费" />
			<youi:fieldHidden property="area"  caption="房间面积" />
			<youi:fieldHidden property="aspect"  caption="招商_朝向"/>
			<youi:fieldHidden property="saleState"  caption="招商_销售状态"/>
			<youi:fieldHidden property="salesPrice"  caption="招商_单价"/>
			<youi:fieldHidden property="lowerPrice"  caption="招商_底价"/>
			<youi:fieldHidden property="roomModule"  caption="招商_户型"/>
			<youi:fieldHidden property="area"  caption="招商_房间面积"/>
			<youi:fieldHidden property="rebate"  caption="招商_折扣"/>
			<youi:fieldHidden property="furnish"  caption="招商_装修"/>
			<youi:fieldHidden property="roomName"  caption="招商_房间名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>