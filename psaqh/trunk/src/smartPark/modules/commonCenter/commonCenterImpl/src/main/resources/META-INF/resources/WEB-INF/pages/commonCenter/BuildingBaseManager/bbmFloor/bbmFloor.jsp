<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmFloor" idKeys="floorId" caption="楼层基础信息列表"  panel="false"
				src="esb/web/bbmFloorManager/getPagerBbmFloors.json" dataFormId="form_bbmFloor"
				editSrc="esb/web/bbmFloorManager/getBbmFloor.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmFloorManager/removeBbmFloor.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<youi:fieldText property="floorNo"  caption="楼层编号" operator="LIKE"/>
			<youi:fieldText property="floorCaption"  caption="楼层说明" operator="LIKE"/>
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"/>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingName"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" />
		</youi:fieldLayout>
		<youi:gridCol property="floorNo"  caption="楼层编号" width="100" align="center"/>
		<youi:gridCol property="bbmPark.parkName" caption="所属园区" width="100" align="center"/>
		<youi:gridCol property="bbmBuilding.buildingName" caption="所属楼栋" width="100" align="center"/>
		<youi:gridCol property="floorRoomCount"  caption="楼层单元数量" width="100" align="center"/>
		<youi:gridCol property="floorCaption"  caption="楼层说明" width="150" align="center"/>
		<youi:gridCol property="floorImage"  caption="楼层布局图片" width="150" align="center"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼层基础信息编辑 -->
	<youi:form dialog="true" caption="楼层基础信息" id="form_bbmFloor" action="esb/web/bbmFloorManager/saveBbmFloor.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="110,110">
			<youi:fieldHidden property="floorId"  caption="楼层ID"/>
			<youi:fieldText property="floorNo"  caption="楼层编号" notNull="true"/>
			<youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingName"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" notNull="true"/>
			<youi:fieldText property="parkName" caption="所属园区"  readonly="true"/>
			<youi:fieldText property="floorRoomCount"  caption="楼层单元数量"/>
			<youi:fieldText property="floorCaption"  caption="楼层说明" column="2"/>
			<youi:fieldText property="floorImage" caption="楼层布局图片" column="2"/>
			
			<%-- <youi:fieldHidden property="roomNo" caption="招商房间编号"/>
			<youi:fieldHidden property="useStatus" caption="招商使用状态"/>
			<youi:fieldHidden property="roomNum" caption="招商房间个数"/>
			<youi:fieldHidden property="company" caption="招商所属企业"/> --%>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<!-- 楼栋发生变化时，对应的园区也发生变化 -->
		<youi:func name = "record_bbmBuilding_buildingId_change">
      		var buildingId = $('#P_'+pageId+'_record_bbmBuilding_buildingId').fieldValue();//获取当前选中楼栋的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/bbmFloorManager/findBbmParkByBuildingId.json',
				data:{buildingId:buildingId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_parkName').fieldValue('') ;//先将园区名称置空
                    $('#P_'+pageId+'_record_parkName').fieldValue(record.parkName);//将返回的对象里面的parkName赋值给公司名称
                  } 
            });
   	 </youi:func>
   	 <!-- 表单提交后刷新页面 -->
   	 <youi:func name = "form_bbmFloor_afterSubmit">
			var formbbmFloor = $elem('form_bbmFloor',pageId);
			formbbmFloor.form('close');
			$elem('grid_bbmFloor',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>