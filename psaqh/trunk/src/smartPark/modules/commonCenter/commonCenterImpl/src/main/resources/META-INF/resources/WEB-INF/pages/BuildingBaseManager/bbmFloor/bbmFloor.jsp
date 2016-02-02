<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmFloor" idKeys="floorId" caption="楼层基础信息列表"  panel="false"
				src="esb/web/bbmFloorManager/getPagerBbmFloors.json" dataFormId="form_bbmFloor"
				editSrc="esb/web/bbmFloorManager/getBbmFloor.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmFloorManager/removeBbmFloor.json">
		<youi:fieldLayout>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="floorNo"  caption="楼层编号"/>
			<youi:fieldText property="floorCaption"  caption="楼层说明"/>
			<youi:fieldText property="roomNum"  caption="招商_房间个数"/>
			<youi:fieldText property="company"  caption="招商_所属企业"/>
			<youi:fieldText property="floorRoomCount"  caption="楼层单元数量"/>
			<youi:fieldText property="useStatus"  caption="招商_使用状态"/>
			<youi:fieldText property="roomNo"  caption="招商_房间编号"/>

		</youi:fieldLayout>
		<youi:gridCol property="rzId"  caption="ID"/>
		<youi:gridCol property="floorNo"  caption="楼层编号"/>
		<youi:gridCol property="floorCaption"  caption="楼层说明"/>
		<youi:gridCol property="roomNum"  caption="招商_房间个数"/>
		<youi:gridCol property="company"  caption="招商_所属企业"/>
		<youi:gridCol property="floorRoomCount"  caption="楼层单元数量"/>
		<youi:gridCol property="useStatus"  caption="招商_使用状态"/>
		<youi:gridCol property="roomNo"  caption="招商_房间编号"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼层基础信息编辑 -->
	<youi:form dialog="true" caption="楼层基础信息" id="form_bbmFloor" action="esb/web/bbmFloorManager/saveBbmFloor.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="floorNo"  caption="楼层编号"/>
			<youi:fieldText property="floorCaption"  caption="楼层说明"/>
			<youi:fieldText property="roomNum"  caption="招商_房间个数"/>
			<youi:fieldText property="company"  caption="招商_所属企业"/>
			<youi:fieldText property="floorRoomCount"  caption="楼层单元数量"/>
			<youi:fieldText property="useStatus"  caption="招商_使用状态"/>
			<youi:fieldText property="roomNo"  caption="招商_房间编号"/>
			<youi:fieldText property="floorId"  caption="楼层ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>