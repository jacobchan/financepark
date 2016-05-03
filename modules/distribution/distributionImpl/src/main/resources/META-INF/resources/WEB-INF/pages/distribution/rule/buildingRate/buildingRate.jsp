<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_buildingRate" idKeys="recId" caption="楼宇佣金比率配置列表"  panel="false" add="NOT"
				src="esb/web/buildingRateManager/getPagerBuildingRates.json" dataFormId="form_buildingRate"
				editSrc="esb/web/buildingRateManager/getBuildingRate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/buildingRateManager/removeBuildingRate.json">
		<youi:fieldLayout>
			<youi:fieldText property="itemName"  caption="单元/楼宇名称"/>
			<youi:fieldText property="itemId"  caption="单元/楼宇ID"/>
			<youi:fieldText property="itemType"  caption="单元/楼宇"/>
			<youi:fieldText property="dicRate"  caption="提佣系数"/>
		</youi:fieldLayout>
		<youi:gridCol property="itemName"  caption="单元/楼宇名称" width="25%"/>
		<%-- <youi:gridCol property="itemId"  caption="单元/楼宇ID" width="25%"/>
		<youi:gridCol property="itemType"  caption="单元/楼宇" width="25%"/> --%>
		<youi:gridCol property="dicRate"  caption="提佣系数" width="25%"/>
		<youi:button name="enteringAdd" caption="添加"></youi:button>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	
	<!-- form-楼宇佣金比率配置编辑 -->
	<youi:form dialog="true" caption="楼宇佣金比率配置" id="form_buildingRate" action="esb/web/buildingRateManager/saveBuildingRate.json">
		<youi:fieldLayout prefix="records">
			<youi:fieldSelect property="itemId" caption="所属单元" code="roomId" show="roomNo" notNull="true"
				src="esb/web/bbmRoomManager/getBbmRooms.json" readonly="true"/>
			<youi:fieldText property="buildingNo"  caption="所属楼层" readonly="true"/>
			<youi:fieldText property="itemName"  caption="所属楼栋" readonly="true"/>
			<youi:fieldText property="parkName"  caption="所属园区" readonly="true"/>
			<%-- <youi:fieldText property="itemId"  caption="单元/楼宇ID"/>
			<youi:fieldText property="itemType"  caption="单元/楼宇"/>  --%>
			<youi:fieldText property="dicRate"  caption="提佣系数"/>
			<youi:fieldHidden property="recId"></youi:fieldHidden>
			<%-- <youi:fieldText property="recId"  caption="序列ID"/> --%>
		</youi:fieldLayout>
	</youi:form>
	
	
	<!-- form-楼宇佣金比率配置编辑 -->
	<youi:form dialog="true" caption="楼宇佣金比率配置" id="form_saveBuildingRate" action="esb/web/buildingRateManager/saveBuildingRate.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldSelect property="itemId" caption="所属单元" code="roomId" show="roomNo" notNull="true"
				src="esb/web/bbmRoomManager/getBbmRooms.json" />
			<youi:fieldText property="buildingNo"  caption="所属楼层" readonly="true"/>
			<youi:fieldText property="itemName"  caption="所属楼栋" readonly="true"/>
			<youi:fieldText property="parkName"  caption="所属园区" readonly="true"/>
			<%-- <youi:fieldText property="itemId"  caption="单元/楼宇ID"/>
			<youi:fieldText property="itemType"  caption="单元/楼宇"/>  --%>
			<youi:fieldText property="dicRate"  caption="提佣系数"/>
			<youi:fieldHidden property="recId"></youi:fieldHidden>
			<%-- <youi:fieldText property="recId"  caption="序列ID"/> --%>
		</youi:fieldLayout>
	</youi:form>
		
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_enteringAdd">
		$elem('form_saveBuildingRate',pageId).form('open');	
	</youi:func>
	
	<youi:func name = "records_itemId_change">
		var itemId = $('#P_'+pageId+'_records_itemId').fieldValue();//获取当前选中楼栋的id
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/bbmRoomManager/findBbmFloorByRoomId.json',
			data:{roomId:itemId},
			success:function(result){	
				var record = result.record;
				$('#P_'+pageId+'_records_parkName').fieldValue('') ;//先将园区名称置空
                $('#P_'+pageId+'_records_parkName').fieldValue(record.bbmPark.parkName);//将返回的对象里面的bbmPark.parkName赋值给园区名称
				$('#P_'+pageId+'_records_buildingNo').fieldValue('') ;//先将楼层编号置空
 				$('#P_'+pageId+'_records_buildingNo').fieldValue(record.bbmBuilding.buildingNo);//将返回的对象里面的buildingName赋值给楼栋编号
				$('#P_'+pageId+'_records_itemName').fieldValue('') ;//先将所属楼栋
               	$('#P_'+pageId+'_records_itemName').fieldValue(record.bbmBuilding.buildingName);
           	} 
        });
	</youi:func>
	<!--检查是否  -->
	<!-- 楼层发生变化时，对应的楼栋，园区也发生变化 -->	
		<youi:func name = "record_itemId_change">
			var itemId = $('#P_'+pageId+'_record_itemId').fieldValue();//获取当前选中楼栋的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/buildingRateManager/getPagerBuildingRates.json',
				data:{itemId:itemId},
				success:function(result){
					var record = result.records;
					if(record.length>0){
						alert("该单元以配置,请选择未配置单元");
						$elem('record_itemId',pageId).fieldValue("");
					}else{
						$.youi.ajaxUtil.ajax({
							url:'/esb/web/bbmRoomManager/findBbmFloorByRoomId.json',
							data:{roomId:itemId},
							success:function(result){	
								var record = result.record;
								$('#P_'+pageId+'_record_parkName').fieldValue('') ;//先将园区名称置空
                    			$('#P_'+pageId+'_record_parkName').fieldValue(record.bbmPark.parkName);//将返回的对象里面的bbmPark.parkName赋值给园区名称
								$('#P_'+pageId+'_record_buildingNo').fieldValue('') ;//先将楼层编号置空
 								$('#P_'+pageId+'_record_buildingNo').fieldValue(record.bbmBuilding.buildingNo);//将返回的对象里面的buildingName赋值给楼栋编号
								$('#P_'+pageId+'_record_itemName').fieldValue('') ;//先将所属楼栋
                    			$('#P_'+pageId+'_record_itemName').fieldValue(record.bbmBuilding.buildingName);
                  			} 
            			});
					}
				}
			});
   	 	</youi:func>
	
	<!--**********************************页面函数End**********************************-->

</youi:page>