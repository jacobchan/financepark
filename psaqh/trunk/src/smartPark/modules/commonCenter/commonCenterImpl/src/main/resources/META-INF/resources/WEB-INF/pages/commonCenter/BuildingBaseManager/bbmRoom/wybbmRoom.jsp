<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>
	<youi:grid id="grid_bbmRoom" idKeys="roomId" caption="单元基础信息列表"  panel="false"
				src="esb/web/bbmRoomManager/getPagerBbmRooms.json" dataFormId="form_bbmRoom"
				editSrc="esb/web/bbmRoomManager/getBbmRoom.json"  remove="NOT" showCheckbox="true" add="NOT" edit="NOT"
				removeSrc="esb/web/bbmRoomManager/removeBbmRoom.json">
		<youi:fieldLayout>
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<%-- <youi:fieldText property="roomCaption"  caption="单元说明"/> --%>
			<youi:fieldText property="enteredEnt"  caption="包含企业"/>
			<youi:fieldSelect property="status"  caption="使用状态" convert="roomstatus" />
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"></youi:fieldSelect>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingCaption" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorCaption" showProperty="bbmFloor.floorCaption"
				src="esb/web/bbmFloorManager/getBbmFloors.json" parents="bbmBuilding.buildingId" parentsAlias="bbmBuilding.buildingId"></youi:fieldSelect>
		</youi:fieldLayout>
		<youi:gridCol property="roomNo"  caption="单元编号" width="150px"/>
		<youi:gridCol property="roomCaption"  caption="单元说明" width="150px"/>
		<youi:gridCol property="enteredEnt"  caption="包含企业" width="150px"/>
		<youi:gridCol property="bbmBuilding.buildingCaption" caption="所属楼栋" width="150px"/>
		<youi:gridCol property="bbmFloor.floorCaption" caption="所属楼层" width="150px"/>
		<youi:gridCol property="status"  caption="使用状态" width="150px"/>
		<youi:gridCol property="rentCharge"  caption="物业_租金" width="150px"/>
		<youi:gridCol property="floor"  caption="所属楼层" width="150px"/>
		<youi:gridCol property="eneryCharge"  caption="物业_电费" width="150px"/>
		<youi:gridCol property="waterCharge"  caption="物业_水费" width="150px"/>		
		<youi:gridCol property="area"  caption="房间面积" width="150px"/>
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
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingCaption" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorCaption" showProperty="bbmFloor.floorCaption"
				src="esb/web/bbmFloorManager/getBbmFloors.json" parents="bbmBuilding.buildingId" parentsAlias="bbmBuilding.buildingId"></youi:fieldSelect>
			<youi:fieldSelect property="status"  caption="使用状态"  convert="roomstatus"/>
			<youi:fieldText property="enteredEnt"  caption="包含企业"/>
			<youi:fieldText property="rentCharge"  caption="物业_租金" width="150px"/>
			<youi:fieldText property="floor"  caption="所属楼层" width="150px"/>
			<youi:fieldText property="eneryCharge"  caption="物业_电费" width="150px"/>
			<youi:fieldText property="waterCharge"  caption="物业_水费" width="150px"/>
			<youi:fieldText property="area"  caption="房间面积" width="150px"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面函数Start********************************-->	
	<!--**********************************页面函数End**********************************-->
</youi:page>