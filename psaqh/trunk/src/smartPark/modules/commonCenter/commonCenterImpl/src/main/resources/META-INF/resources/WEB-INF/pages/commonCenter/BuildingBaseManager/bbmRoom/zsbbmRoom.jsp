<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmRoom" idKeys="roomId" caption="单元基础信息列表"  panel="false"
				src="esb/web/bbmRoomManager/getPagerBbmRooms.json" dataFormId="form_bbmRoom"
				editSrc="esb/web/bbmRoomManager/getBbmRoom.json" edit="NOT" remove="NOT" add="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmRoomManager/removeBbmRoom.json">
		<youi:fieldLayout labelWidths="140,140">
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldText property="floor"  caption="所属楼层"/>
			<youi:fieldSelect property="status"  caption="使用状态" convert="floorUsingStatus"/>
			<youi:fieldText property="aspect"  caption="招商_朝向"/>
			<youi:fieldSelect property="saleState"  caption="招商_销售状态" convert="saleState"/>
			<youi:fieldText property="area"  caption="招商_房间面积"/>
			<youi:fieldText property="roomName"  caption="招商_房间名称"/>
		</youi:fieldLayout>
		<youi:gridCol property="floor"  caption="所属楼层"/>
		<youi:gridCol property="roomNo"  caption="单元编号"/>
		<youi:gridCol property="status"  caption="使用状态" convert="floorUsingStatus"/>
		
		
		<youi:gridCol property="aspect"  caption="招商_朝向"/>
		<youi:gridCol property="salesPrice"  caption="招商_单价"/>
		<youi:gridCol property="rebate"  caption="招商_折扣"/>
		<youi:gridCol property="furnish"  caption="招商_装修"/>
		<youi:gridCol property="lowerPrice"  caption="招商_底价"/>
		<youi:gridCol property="roomModule"  caption="招商_户型"/>
		<youi:gridCol property="saleState"  caption="招商_销售状态" convert="saleState" width="100"/>
		<youi:gridCol property="area"  caption="招商_房间面积" width="100"/>
		<youi:gridCol property="roomName"  caption="招商_房间名称" width="100"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼宇招商信息修改 -->
	<youi:form dialog="true" caption="楼宇招商信息修改" id="form_bbmRoom" action="esb/web/bbmRoomManager/saveBbmRoom.json">
		<youi:fieldLayout prefix="record" labelWidths="140,140">
			<youi:fieldHidden property="roomId" caption="单元ID"/>
			<youi:fieldHidden property="rentCharge" caption="物业_租金"/>
			<youi:fieldHidden property="eneryCharge" caption="物业_电费"/>
			<youi:fieldHidden property="waterCharge" caption="物业_水费"/>
			
			<youi:fieldText property="floor"  caption="所属楼层" readonly="true"/>
			<youi:fieldText property="roomNo"  caption="单元编号" readonly="true"/>
			<youi:fieldSelect property="status"  caption="使用状态" convert="floorUsingStatus"/>
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
	
	<!--**********************************页面函数End**********************************-->
</youi:page>