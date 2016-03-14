<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_buildingRate" idKeys="recId" caption="楼宇佣金比率配置列表"  panel="false"
				src="esb/web/buildingRateManager/getPagerBuildingRates.json" dataFormId="form_buildingRate"
				editSrc="esb/web/buildingRateManager/getBuildingRate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/buildingRateManager/removeBuildingRate.json">
		<youi:fieldLayout>
			<youi:fieldText property="itemName"  caption="单元/楼宇名称"/>
			<youi:fieldText property="itemId"  caption="单元/楼宇ID"/>
			<youi:fieldText property="itemType"  caption="单元/楼宇"/>
			<youi:fieldText property="dicRate"  caption="提佣系数"/>

		</youi:fieldLayout>
		<youi:gridCol property="itemName"  caption="单元/楼宇名称"/>
		<youi:gridCol property="itemId"  caption="单元/楼宇ID"/>
		<youi:gridCol property="itemType"  caption="单元/楼宇"/>
		<youi:gridCol property="dicRate"  caption="提佣系数"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-楼宇佣金比率配置编辑 -->
	<youi:form dialog="true" caption="楼宇佣金比率配置" id="form_buildingRate" action="esb/web/buildingRateManager/saveBuildingRate.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="itemName"  caption="单元/楼宇名称"/>
			<youi:fieldText property="itemId"  caption="单元/楼宇ID"/>
			<youi:fieldText property="itemType"  caption="单元/楼宇"/>
			<youi:fieldText property="dicRate"  caption="提佣系数"/>
			<youi:fieldText property="recId"  caption="序列ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>