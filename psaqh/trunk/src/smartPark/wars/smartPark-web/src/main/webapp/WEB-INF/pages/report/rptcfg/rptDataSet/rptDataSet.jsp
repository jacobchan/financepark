<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:subpage src="page/report.rptcfg.rptDataSet/rptDataSetEdit.html?dataSetId={dataSetId}" 
		editSrc="esb/web/rptDataSetManager/getRptDataSet.json" idKeys="dataSetId"
		formAction="esb/web/rptDataSetManager/saveRptDataSet.json" height="450"
		subpageId="dataSet_edit" caption="数据集"></youi:subpage>
	
	<youi:grid id="grid_rptDataSet" idKeys="dataSetId" caption="报表数据集列表"  panel="false"
				src="esb/web/rptDataSetManager/getPagerRptDataSets.json"
				add="NOT" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/rptDataSetManager/removeRptDataSet.json">
		<youi:fieldLayout>
			<youi:fieldText property="dataSetName"  caption="数据集名"/>
			<youi:fieldText property="dataSetCaption"  caption="数据集描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol width="20%" property="dataSetName"  caption="数据集名"/>
		<youi:gridCol width="30%" property="dataSetCaption"  caption="数据集描述"/>
		
		<youi:gridCol width="15%" property="rptDataSource.dataSourceName"  caption="数据源"/>
		
		<youi:gridCol width="35%" property="querySql"  caption="查询语句"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="editDataSet" icon="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		
		<youi:button name="addDataSet" caption="增加" icon="add"></youi:button>
	</youi:grid>
	
	<!--**********************************页面函数********************************-->
	<youi:func name="func_grid_addDataSet">
		$elem('subpage_dataSet_edit',pageId).subpage('open',null,'增加',{dataSetId:''});
	</youi:func>
	
	<!-- 行动作 -->
	<youi:func name="grid_rptDataSet_col_button_editDataSet" params="record,rowDoc">
		$elem('subpage_dataSet_edit',pageId).subpage('open',record,'修改',record);
	</youi:func>
	
	<youi:func name="grid_rptDataSet_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	
	<!-- 保存成功回调函数 -->
	<youi:func name="subpage_dataSet_edit_afterSubmit" params="result">
		$elem('subpage_dataSet_edit',pageId).subpage('close');
		$elem('grid_rptDataSet',pageId).grid('refresh');
	</youi:func>
	
	<!--**********************************页面函数********************************-->
</youi:page>