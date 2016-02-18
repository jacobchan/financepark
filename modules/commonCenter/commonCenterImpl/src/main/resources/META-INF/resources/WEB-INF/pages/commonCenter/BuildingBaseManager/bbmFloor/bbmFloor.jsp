<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmFloor" idKeys="floorId" caption="楼层基础信息列表"  panel="false"
				src="esb/web/bbmFloorManager/getPagerBbmFloors.json" dataFormId="form_bbmFloor"
				editSrc="esb/web/bbmFloorManager/getBbmFloor.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmFloorManager/removeBbmFloor.json">
		<youi:fieldLayout>
			<youi:fieldText property="floorNo"  caption="楼层编号"/>
			<youi:fieldText property="floorCaption"  caption="楼层说明"/>
			<youi:fieldText property="floorRoomCount"  caption="楼层单元数量"/>
		</youi:fieldLayout>
		<youi:gridCol property="floorNo"  caption="楼层编号" width="150px"/>
		<youi:gridCol property="floorCaption"  caption="楼层说明" width="150px"/>
		<youi:gridCol property="floorRoomCount"  caption="楼层单元数量" width="150px"/>
		<youi:gridCol property="bbmBuilding.buildingCaption" caption="所属楼栋" width="150px"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼层基础信息编辑 -->
	<youi:form dialog="true" caption="楼层基础信息" id="form_bbmFloor" action="esb/web/bbmFloorManager/saveBbmFloor.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="floorId"  caption="楼层ID"/>
			<youi:fieldText property="floorNo"  caption="楼层编号"/>
			<youi:fieldText property="floorCaption"  caption="楼层说明"/>
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"></youi:fieldSelect>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingCaption" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldText property="floorRoomCount"  caption="楼层单元数量"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>