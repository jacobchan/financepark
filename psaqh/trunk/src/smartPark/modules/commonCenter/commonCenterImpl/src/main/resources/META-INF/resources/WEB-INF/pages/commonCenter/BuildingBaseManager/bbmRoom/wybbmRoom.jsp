<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>
	<youi:grid id="grid_bbmRoom" idKeys="roomId" caption="单元基础信息列表"  panel="false"
				src="esb/web/bbmRoomManager/getPagerBbmRooms.json" dataFormId="form_bbmRoom"
				editSrc="esb/web/bbmRoomManager/getBbmRoom.json"  remove="NOT" showCheckbox="true" add="NOT" edit="NOT"
				removeSrc="esb/web/bbmRoomManager/removeBbmRoom.json">
		<youi:fieldLayout>
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorNo" 
				src="esb/web/bbmFloorManager/getBbmFloors.json" />
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"/>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingNo"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" />
			<youi:fieldSelect property="status"  caption="使用状态" convert="roomstatus"/>
			<%-- <youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"></youi:fieldSelect>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingCaption" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorCaption" showProperty="bbmFloor.floorCaption"
				src="esb/web/bbmFloorManager/getBbmFloors.json" parents="bbmBuilding.buildingId" parentsAlias="bbmBuilding.buildingId"></youi:fieldSelect> --%>
		</youi:fieldLayout>
		<%-- <youi:gridCol property="roomNo"  caption="单元编号" width="150px"/>
		<youi:gridCol property="bbmBuilding.buildingCaption" caption="所属楼栋" width="150px"/> --%>
		<youi:gridCol property="roomNo"  caption="单元编号" width="100" align="center"/>
		<youi:gridCol property="bbmPark.parkName" caption="所属园区" width="100" align="center"/>
		<youi:gridCol property="bbmBuilding.buildingNo" caption="所属楼栋" width="100" align="center"/>
		<youi:gridCol property="bbmFloor.floorNo" caption="所属楼层" width="100" align="center"/>
		<youi:gridCol property="roomHost"  caption="单元业主" width="100" align="center"/>
		<youi:gridCol property="roomTenement"  caption="单元租户"  width="100" align="center"/>
		<youi:gridCol property="status"  caption="使用状态" convert="roomstatus" width="150px" align="center"/>
		<youi:gridCol property="rentCharge"  caption="物业_租金" width="150px" align="center"/>
		<youi:gridCol property="eneryCharge"  caption="物业_电费" width="150px" align="center"/>
		<youi:gridCol property="waterCharge"  caption="物业_水费" width="150px" align="center"/>	
		<youi:gridCol property="propertyCharge"  caption="物业_物业费" width="150px" align="center"/>		
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">	
		<youi:button name="edit" caption="修改"/>		
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-单元基础信息编辑 -->
	<youi:form dialog="true" caption="单元基础信息" id="form_bbmRoom" action="esb/web/bbmRoomManager/saveBbmRoom.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			
			<%-- <youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldText property="roomCaption"  caption="单元说明"/>
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"></youi:fieldSelect>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingCaption" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorCaption" showProperty="bbmFloor.floorCaption"
				src="esb/web/bbmFloorManager/getBbmFloors.json" parents="bbmBuilding.buildingId" parentsAlias="bbmBuilding.buildingId"></youi:fieldSelect> --%>
			<youi:fieldHidden property="roomId" caption="单元ID"/>
			<youi:fieldText property="roomNo"  caption="单元编号" notNull="true"/>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorNo" notNull="true"
				src="esb/web/bbmFloorManager/getBbmFloors.json" />
			<youi:fieldText property="buildingNo"  caption="所属楼栋" readonly="true"/>
			<youi:fieldText property="parkName"  caption="所属园区" readonly="true"/>
			<youi:fieldText property="roomHost"  caption="单元业主" readonly="true"/>
			<youi:fieldText property="roomTenement"  caption="单元租户" />
			<youi:fieldSelect property="status"  caption="使用状态"  convert="roomstatus"/>
			<youi:fieldText property="rentCharge"  caption="物业_租金" width="150px"/>
			<youi:fieldText property="eneryCharge"  caption="物业_电费" width="150px"/>
			<youi:fieldText property="waterCharge"  caption="物业_水费" width="150px"/>
			<youi:fieldText property="propertyCharge"  caption="物业_物业费" width="150px"/>
			
			<youi:fieldHidden property="roomAddress"  caption="详细地址"/>
			<youi:fieldHidden property="saleState"  caption="招商_销售状态" />
			<youi:fieldHidden property="aspect"  caption="招商_朝向"/>		
			<youi:fieldHidden property="salesPrice"  caption="招商_单价"/>
			<youi:fieldHidden property="lowerPrice"  caption="招商_底价"/>						
			<youi:fieldHidden property="roomModule"  caption="招商_户型"/>			
			<youi:fieldHidden property="rebate"  caption="招商_折扣"/>
			<youi:fieldHidden property="furnish"  caption="招商_装修"/>
			<youi:fieldHidden property="roomName"  caption="招商_房间名称"/>
			<youi:fieldHidden property="area"  caption="招商_房间面积"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面函数Start********************************-->	
	<!-- 楼层发生变化时，对应的楼栋，园区也发生变化 -->
		<youi:func name = "record_bbmFloor_floorId_change">
      		var floorId = $('#P_'+pageId+'_record_bbmFloor_floorId').fieldValue();//获取当前选中楼栋的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/bbmRoomManager/findBbmBuildingByFloorId.json',
				data:{floorId:floorId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_parkName').fieldValue('') ;//先将园区名称置空
					$('#P_'+pageId+'_record_buildingNo').fieldValue('') ;//先将楼层编号置空
 					$('#P_'+pageId+'_record_buildingNo').fieldValue(record.buildingNo);//将返回的对象里面的buildingNo赋值给楼层编号
                    $('#P_'+pageId+'_record_parkName').fieldValue(record.bbmPark.parkName);//将返回的对象里面的bbmPark.parkName赋值给园区名称
                  } 
            });
   	 </youi:func>
   	 
   	 <!-- 表单提交后重新加载页面 -->
   	 <youi:func name = "form_bbmRoom_afterSubmit">
			var bbmRoom = $elem('form_bbmRoom',pageId);
			bbmRoom.form('close');
			$elem('grid_bbmRoom',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>