<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationFinancing" idKeys="financingId"
		caption="融资信息列表" panel="false"
		src="esb/web/informationFinancingManager/getPagerInformationFinancings.json"
		dataFormId="form_informationFinancing"
		editSrc="esb/web/informationFinancingManager/getInformationFinancing.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/informationFinancingManager/removeInformationFinancing.json">
		<youi:fieldLayout labelWidths="122">
			<youi:fieldText property="financingName" caption="融资企业名称" />
			<youi:fieldCalendar property="financingTime" caption="融资时间" />
			<youi:fieldText property="financingCost" caption="融资估值" />
			<youi:fieldSelect property="financingRe" caption="企业信息"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" />
			<youi:fieldSelect property="financingTp" caption="融资状态"
				convert="financingType" />
			<youi:fieldSelect property="financingStatus" caption="发布状态"
				convert="financingStatus" />
		</youi:fieldLayout>
		<youi:gridCol property="financingSub" caption="投资主体" width="15%" />
		<youi:gridCol property="financingStatus" caption="发布状态" width="15%" />
		<youi:gridCol property="financingName" caption="融资企业名称" width="15%" />
		<youi:gridCol property="financingTime" caption="融资时间" width="15%" />
		<youi:gridCol property="financingCost" caption="融资估值" width="15%" />
		<youi:gridCol property="financingPre" caption="持股比例" width="15%" />
		<youi:gridCol property="financingRe" caption="企业信息" width="15%" />
		<youi:gridCol property="financingAmount" caption="融资金额" width="15%" />
		<youi:gridCol property="financingTp" caption="融资状态" width="15%" />
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-融资信息编辑 -->
	<youi:form dialog="true" caption="融资信息" id="form_informationFinancing"
		action="esb/web/informationFinancingManager/saveInformationFinancing.json">
		<youi:fieldLayout prefix="record" labelWidths="122">
			<youi:fieldHidden property="financingId"  caption="ID"/>
			<youi:fieldText property="financingSub" caption="投资主体" />
			<youi:fieldSelect property="financingStatus" caption="发布状态" convert="financingStatus" />
			<youi:fieldText property="financingName" caption="融资企业名称" />
			<youi:fieldSelect property="financingRe" caption="企业信息"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" />
			<youi:fieldCalendar property="financingTime" caption="融资时间" />
			<youi:fieldText property="financingCost" caption="融资估值" />
			<youi:fieldText property="financingPre" caption="持股比例" />
			<youi:fieldText property="financingAmount" caption="融资金额" />
			<youi:fieldSelect property="financingTp" caption="融资状态"
				convert="financingType" />
		</youi:fieldLayout>
	</youi:form>
</youi:page>