<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmBuilding" idKeys="buildingId" caption="楼栋基础信息列表"  panel="false"
				src="esb/web/bbmBuildingManager/getPagerBbmBuildings.json" dataFormId="form_bbmBuilding"
				editSrc="esb/web/bbmBuildingManager/getBbmBuilding.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmBuildingManager/removeBbmBuilding.json">
		<youi:fieldLayout>
			<youi:fieldText property="attributeFloorCount"  caption="楼宇层数"/>
			<youi:fieldText property="buildingNo"  caption="楼栋编号"/>
			<youi:fieldText property="useStatus"  caption="招商_使用状态"/>
			<youi:fieldText property="floorNum"  caption="招商_楼层数量"/>
			<youi:fieldText property="company"  caption="入驻企业"/>
			<youi:fieldText property="buildingUnitCount"  caption="楼宇单元数"/>
			<youi:fieldText property="buildingCaption"  caption="楼宇说明"/>
			<youi:fieldText property="buildingType"  caption="楼栋类别"/>

		</youi:fieldLayout>
		<youi:gridCol property="attributeFloorCount"  caption="楼宇层数"/>
		<youi:gridCol property="buildingNo"  caption="楼栋编号"/>
		<youi:gridCol property="useStatus"  caption="招商_使用状态"/>
		<youi:gridCol property="floorNum"  caption="招商_楼层数量"/>
		<youi:gridCol property="company"  caption="入驻企业"/>
		<youi:gridCol property="buildingUnitCount"  caption="楼宇单元数"/>
		<youi:gridCol property="buildingCaption"  caption="楼宇说明"/>
		<youi:gridCol property="buildingType"  caption="楼栋类别"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼栋基础信息编辑 -->
	<youi:form dialog="true" caption="楼栋基础信息" id="form_bbmBuilding" action="esb/web/bbmBuildingManager/saveBbmBuilding.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="attributeFloorCount"  caption="楼宇层数"/>
			<youi:fieldText property="buildingNo"  caption="楼栋编号"/>
			<youi:fieldText property="useStatus"  caption="招商_使用状态"/>
			<youi:fieldText property="floorNum"  caption="招商_楼层数量"/>
			<youi:fieldText property="company"  caption="入驻企业"/>
			<youi:fieldText property="buildingUnitCount"  caption="楼宇单元数"/>
			<youi:fieldText property="buildingCaption"  caption="楼宇说明"/>
			<youi:fieldText property="buildingType"  caption="楼栋类别"/>
			<youi:fieldText property="buildingId"  caption="楼栋ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>