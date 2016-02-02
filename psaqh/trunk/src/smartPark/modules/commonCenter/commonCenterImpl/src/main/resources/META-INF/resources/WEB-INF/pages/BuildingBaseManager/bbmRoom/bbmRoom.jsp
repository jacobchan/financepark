<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmRoom" idKeys="roomId" caption="单元基础信息列表"  panel="false"
				src="esb/web/bbmRoomManager/getPagerBbmRooms.json" dataFormId="form_bbmRoom"
				editSrc="esb/web/bbmRoomManager/getBbmRoom.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmRoomManager/removeBbmRoom.json">
		<youi:fieldLayout>
			<youi:fieldText property="rebate"  caption="招商_折扣"/>
			<youi:fieldText property="area"  caption="招商_房间面积"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="aspect"  caption="招商_朝向"/>
			<youi:fieldText property="rentCharge"  caption="物业_租金"/>
			<youi:fieldText property="status"  caption="使用状态"/>
			<youi:fieldText property="roomCaption"  caption="单元说明"/>
			<youi:fieldText property="lowerPrice"  caption="招商_底价"/>
			<youi:fieldText property="enteredEnt"  caption="包含企业"/>
			<youi:fieldText property="saleState"  caption="招商_销售状态"/>
			<youi:fieldText property="roomName"  caption="招商_房间名称"/>
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldText property="propertyCharge"  caption="物业_物业费"/>
			<youi:fieldText property="eneryCharge"  caption="物业_电费"/>
			<youi:fieldText property="salesPrice"  caption="招商_单价"/>
			<youi:fieldText property="furnish"  caption="招商_装修"/>
			<youi:fieldText property="waterCharge"  caption="物业_水费"/>
			<youi:fieldText property="roomModule"  caption="招商_户型"/>
			<youi:fieldText property="floor"  caption="所属楼层"/>

		</youi:fieldLayout>
		<youi:gridCol property="rebate"  caption="招商_折扣"/>
		<youi:gridCol property="area"  caption="招商_房间面积"/>
		<youi:gridCol property="rzId"  caption="ID"/>
		<youi:gridCol property="aspect"  caption="招商_朝向"/>
		<youi:gridCol property="rentCharge"  caption="物业_租金"/>
		<youi:gridCol property="status"  caption="使用状态"/>
		<youi:gridCol property="roomCaption"  caption="单元说明"/>
		<youi:gridCol property="lowerPrice"  caption="招商_底价"/>
		<youi:gridCol property="enteredEnt"  caption="包含企业"/>
		<youi:gridCol property="saleState"  caption="招商_销售状态"/>
		<youi:gridCol property="roomName"  caption="招商_房间名称"/>
		<youi:gridCol property="roomNo"  caption="单元编号"/>
		<youi:gridCol property="propertyCharge"  caption="物业_物业费"/>
		<youi:gridCol property="eneryCharge"  caption="物业_电费"/>
		<youi:gridCol property="salesPrice"  caption="招商_单价"/>
		<youi:gridCol property="furnish"  caption="招商_装修"/>
		<youi:gridCol property="waterCharge"  caption="物业_水费"/>
		<youi:gridCol property="roomModule"  caption="招商_户型"/>
		<youi:gridCol property="floor"  caption="所属楼层"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-单元基础信息编辑 -->
	<youi:form dialog="true" caption="单元基础信息" id="form_bbmRoom" action="esb/web/bbmRoomManager/saveBbmRoom.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="rebate"  caption="招商_折扣"/>
			<youi:fieldText property="area"  caption="招商_房间面积"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="aspect"  caption="招商_朝向"/>
			<youi:fieldText property="rentCharge"  caption="物业_租金"/>
			<youi:fieldText property="status"  caption="使用状态"/>
			<youi:fieldText property="roomCaption"  caption="单元说明"/>
			<youi:fieldText property="lowerPrice"  caption="招商_底价"/>
			<youi:fieldText property="enteredEnt"  caption="包含企业"/>
			<youi:fieldText property="saleState"  caption="招商_销售状态"/>
			<youi:fieldText property="roomName"  caption="招商_房间名称"/>
			<youi:fieldText property="roomNo"  caption="单元编号"/>
			<youi:fieldText property="propertyCharge"  caption="物业_物业费"/>
			<youi:fieldText property="eneryCharge"  caption="物业_电费"/>
			<youi:fieldText property="salesPrice"  caption="招商_单价"/>
			<youi:fieldText property="furnish"  caption="招商_装修"/>
			<youi:fieldText property="waterCharge"  caption="物业_水费"/>
			<youi:fieldText property="roomModule"  caption="招商_户型"/>
			<youi:fieldText property="floor"  caption="所属楼层"/>
			<youi:fieldText property="roomId"  caption="单元ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>