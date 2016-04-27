<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmRoom" idKeys="roomId" caption="单元基础信息列表"  panel="false"
				src="esb/web/bbmRoomManager/getPagerBbmRooms.json" dataFormId="form_bbmRoom"
				editSrc="esb/web/bbmRoomManager/getBbmRoom.json" edit="NOT" remove="NOT" add="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmRoomManager/removeBbmRoom.json">
		<youi:fieldLayout labelWidths="140,140">
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorNo" 
				src="esb/web/bbmFloorManager/getBbmFloors.json" />
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"/>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingNo"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" />
			<youi:fieldSelect property="status"  caption="使用状态" convert="roomstatus"/>
			<youi:fieldText property="aspect"  caption="招商_朝向"/>
			<youi:fieldSelect property="saleState"  caption="招商_销售状态" convert="saleState"/>
			<youi:fieldText property="area"  caption="招商_房间面积"/>
		</youi:fieldLayout>
		<youi:gridCol property="bbmPark.parkName" caption="所属园区" width="100" align="center"/>
		<youi:gridCol property="bbmBuilding.buildingNo" caption="所属楼栋" width="100" align="center"/>
		<youi:gridCol property="bbmFloor.floorNo" caption="所属楼层" width="100" align="center"/>
		<youi:gridCol property="roomNo"  caption="单元编号" width="100" align="center"/>
		<youi:gridCol property="roomHost"  caption="单元业主" width="100" align="center"/>
		<youi:gridCol property="status"  caption="使用状态" width="100" align="center" convert="roomstatus"/>
		<youi:gridCol property="saleState"  caption="招商_销售状态" convert="saleState" width="100" align="center"/>
		<youi:gridCol property="aspect"  caption="招商_朝向" align="center"/>
		<youi:gridCol property="salesPrice"  caption="招商_单价" align="center"/>
		<youi:gridCol property="rebate"  caption="招商_折扣" align="center"/>
		<youi:gridCol property="furnish"  caption="招商_装修" align="center"/>
		<youi:gridCol property="lowerPrice"  caption="招商_底价" align="center"/>
		<youi:gridCol property="roomModule"  caption="招商_户型" align="center"/>
		<youi:gridCol property="area"  caption="招商_房间面积" width="100" align="center"/>
		<youi:gridCol property="roomName"  caption="招商_房间名称" width="100" align="center"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼宇招商信息修改 -->
	<youi:form dialog="true" caption="楼宇招商信息修改" id="form_bbmRoom" action="esb/web/bbmRoomManager/saveBbmRoom.json">
		<youi:fieldLayout prefix="record" labelWidths="140,140">
			<youi:fieldHidden property="roomId"  caption="单元ID"/>
			<youi:fieldText property="roomNo"  caption="单元编号" notNull="true" readonly="true"/>
			<youi:fieldSelect property="bbmFloor.floorId" caption="所属楼层" code="floorId" show="floorNo" notNull="true"
				src="esb/web/bbmFloorManager/getBbmFloors.json" readonly="true"/>
			<youi:fieldText property="buildingNo"  caption="所属楼栋" readonly="true"/>
			<youi:fieldText property="parkName"  caption="所属园区" readonly="true"/>
			<youi:fieldSelect property="status"  caption="使用状态" convert="roomstatus"/>
			<youi:fieldText property="roomHost"  caption="单元业主" notNull="true"/>
			
			<youi:fieldHidden property="rzId"  caption="企业ID"/>
			<youi:fieldHidden property="roomAddress"  caption="详细地址"/>
			<youi:fieldHidden property="roomTenement"  caption="单元租户"/>
			<youi:fieldHidden property="rentCharge"  caption="物业_租金"/>
			<youi:fieldHidden property="eneryCharge"  caption="物业_电费" />
			<youi:fieldHidden property="waterCharge"  caption="物业_水费" />
			<youi:fieldHidden property="propertyCharge"  caption="物业_物业费"/>
			
			<youi:fieldText property="aspect"  caption="招商_朝向"/>
			<youi:fieldSelect property="saleState"  caption="招商_销售状态" convert="saleState"/>
			<youi:fieldText property="salesPrice"  caption="招商_单价"/>
			<youi:fieldText property="lowerPrice"  caption="招商_底价"/>
			<youi:fieldText property="roomModule"  caption="招商_户型"/>
			<youi:fieldText property="area"  caption="招商_房间面积"/>
			<youi:fieldText property="rebate"  caption="招商_折扣"/>
			<youi:fieldText property="furnish"  caption="招商_装修"/>
			<youi:fieldText property="roomName"  caption="招商_房间名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<!-- 单元发生变化时，对应的楼栋，园区，业主也发生变化 -->
		<%-- <youi:func name = "record_roomId_change">
      		var roomId = $('#P_'+pageId+'_record_roomId').fieldValue();//获取当前选中楼栋的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/bbmRoomManager/findBbmFloorByRoomId.json',
				data:{roomId:roomId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_parkName').fieldValue('') ;//先将园区名称置空
					$('#P_'+pageId+'_record_buildingNo').fieldValue('') ;//先将楼栋编号置空
					$('#P_'+pageId+'_record_floorNo').fieldValue('') ;//先将楼层编号置空
					$('#P_'+pageId+'_record_floorNo').fieldValue(record.floorNo);//将返回的对象里面的floorNo赋值给楼层编号
 					$('#P_'+pageId+'_record_buildingNo').fieldValue(record.bbmBuilding.buildingNo);//将返回的对象里面的buildingNo赋值给楼栋编号
                    $('#P_'+pageId+'_record_parkName').fieldValue(record.bbmBuilding.bbmPark.parkName);//将返回的对象里面的bbmPark.parkName赋值给园区名称
				} 
            });
   	 </youi:func> --%>
   	 
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