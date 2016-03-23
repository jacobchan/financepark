<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmBuilding" idKeys="buildingId" caption="楼栋基础信息列表"  panel="false"
				src="esb/web/bbmBuildingManager/getPagerBbmBuildings.json" dataFormId="form_bbmBuilding"
				editSrc="esb/web/bbmBuildingManager/getBbmBuilding.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmBuildingManager/removeBbmBuilding.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<youi:fieldText property="buildingNo"  caption="楼栋编号" operator="LIKE"/>
			<youi:fieldText property="buildingCaption"  caption="楼栋说明" operator="LIKE"/>
			<youi:fieldSelect property="buildingType"  caption="楼栋类别" convert="buildingType" />
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json"/>
		</youi:fieldLayout>
		<youi:gridCol property="buildingNo" caption="楼栋编号" width="80" align="center"/>
		<youi:gridCol property="buildingName" caption="楼栋名称" width="120" align="center"/>
		<youi:gridCol property="attributeFloorCount"  caption="楼栋层数" width="80" align="center"/>
		<youi:gridCol property="buildingUnitCount"  caption="楼栋单元数" width="80" align="center"/>
		<youi:gridCol property="buildingType"  caption="楼栋类别" width="100"  convert="buildingType" align="center"/>
		<youi:gridCol property="bbmPark.parkName" caption="所属园区" width="150" align="center"/>
		<youi:gridCol property="buildingCaption"  caption="楼栋说明" width="150" align="center"/>
		<youi:gridCol property="buildingImage"  caption="楼栋图片URL" width="150" align="center"/>
		<youi:gridCol property="createTime"  caption="创建时间" width="150" align="center"/>
		<youi:gridCol property="updateTime"  caption="更新时间" width="150" align="center"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼栋基础信息编辑 -->
	<youi:form dialog="true" caption="楼栋基础信息" id="form_bbmBuilding" action="esb/web/bbmBuildingManager/saveBbmBuilding.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="buildingId"  caption="楼栋ID"/>
			<youi:fieldHidden property="createTime"  caption="创建时间"/>
			<youi:fieldHidden property="updateTime"  caption="更新时间"/>
			<youi:fieldText property="buildingNo"  caption="楼栋编号" notNull="true"/>
			<youi:fieldText property="buildingName"  caption="楼栋名称" notNull="true"/>
			<youi:fieldText property="attributeFloorCount"  caption="楼宇层数" notNull="true"/>
			<youi:fieldText property="buildingUnitCount"  caption="楼宇单元数" notNull="true"/>
			<youi:fieldSelect property="bbmPark.parkId" caption="所属园区" code="parkId" show="parkName"
				src="esb/web/bbmParkManager/getBbmParks.json" notNull="true"/>
			<youi:fieldSelect property="buildingType"  caption="楼栋类别" convert="buildingType"/>
			<youi:fieldText property="buildingCaption"  caption="楼宇说明"/>
			<youi:fieldText property="buildingImage"  caption="楼栋图片URL" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<!-- 表单提交后刷新页面 -->
	<youi:func name="form_bbmBuilding_afterSubmit">
		$elem('grid_bbmBuilding',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>