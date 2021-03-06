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
		<youi:gridCol property="financingRe" caption="企业信息" renderer="renderer_financingRe" width="15%" />
		<youi:gridCol property="financingName" caption="融资企业名称" width="15%" />
		<youi:gridCol property="financingTime" caption="融资时间" width="15%" />
		<youi:gridCol property="financingCost" caption="融资估值" width="15%" />
		<youi:gridCol property="financingPre" caption="持股比例" width="15%" />
		<youi:gridCol property="financingAmount" caption="融资金额" width="15%" />
		<youi:gridCol property="financingStatus" caption="发布状态" convert="financingStatus" width="15%" />
		<youi:gridCol property="financingTp" caption="融资状态" convert="financingType" width="15%" />
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-融资信息编辑 -->
	<youi:form dialog="true" caption="融资信息" id="form_informationFinancing"
		action="esb/web/informationFinancingManager/saveInformationFinancing.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="financingId"  caption="ID"/>
			<youi:fieldSelect property="financingSub" caption="投资主体" convert="roundFinancing" />
			<youi:fieldSelect property="financingRe" caption="企业信息"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" />
			<youi:fieldText property="financingName" caption="融资企业" />
			<youi:fieldText property="financingCost" caption="融资估值" />
			<youi:fieldText property="financingAmount" caption="融资金额" />
			<youi:fieldText property="financingPre" caption="持股比例" />
			<youi:fieldCalendar property="financingTime" caption="融资时间" />
			<youi:fieldSelect property="financingStatus" caption="发布状态" convert="financingStatus" />
			<youi:fieldSelect property="financingTp" caption="融资状态" convert="financingType" />
			<youi:fieldArea property="financingDescribe" caption="融资描述" notNull="true" rows="8" column="20" />
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="renderer_financingRe" params="col,record">
        if(record.financingRe !="" && record.financingRe !=null){
	 		var rzName = ""; 
			$.youi.ajaxUtil.ajax({
				url:'esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
				data:'rzId='+record.financingRe,
				async: false, 
				success:function(result){
					rzName=result.record.rzName;
				}
			});
			return rzName;
        }
	</youi:func>
</youi:page>