<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<youi:tabs id="tabs_dataSet" itemHeight="350">
		<youi:tabItem caption="基本信息" id="base">
			<youi:fieldLayout prefix="record" columns="1" labelWidths="110">
				<youi:fieldHidden property="dataSetId"  caption="数据集ID"/>
				<youi:fieldSelect notNull="true" property="rptDataSource.dataSourceId" caption="数据源" 
					src="esb/web/rptDataSourceManager/getRptDataSources.json" code="dataSourceId" show="dataSourceName"/>
				<youi:fieldText notNull="true" property="dataSetName"  caption="数据集名"/>
				<youi:fieldText property="dataSetCaption"  caption="数据集描述"/>
				<youi:fieldArea notNull="true" property="querySql" height="240" caption="查询语句"/>
			</youi:fieldLayout>
		</youi:tabItem>
		
		<youi:tabItem caption="参数" id="params">
			<youi:fieldLayout columns="1" labelWidths="0">
				<youi:fieldGrid property="dataSetParams">
					<youi:grid id="grid_rptDataSetParam" idKeys="paramId" caption="据集参数列表"  panel="false"
								 showCheckbox="true" editable="true" scrollHeight="280">
						<youi:gridCol editor="fieldText" width="20%" property="paramName"  caption="参数名"/>
						<youi:gridCol editor="fieldText" width="40%" property="paramCaption"  caption="参数描述"/>
				
						<youi:gridCol editor="fieldText" width="15%" property="dataType"  caption="数据类型"/>
						<youi:gridCol editor="fieldText" width="15%" property="dataLength"  caption="长度"/>
						
						<youi:gridCol editor="fieldText" width="10%" property="paramNum"  caption="序号"/>
					</youi:grid>
				</youi:fieldGrid>
			</youi:fieldLayout>
		</youi:tabItem>
		
		<youi:tabItem caption="输出字段" id="outFields">
			<youi:fieldLayout columns="1" labelWidths="0">
				<youi:fieldGrid property="dataSetColumns">
					<youi:grid id="grid_rptDataSetColumn" idKeys="columnId" caption="数据集列列表"  panel="false"
							showCheckbox="true" editable="true"  scrollHeight="280">
						<youi:gridCol editor="fieldText" width="20%" property="columnName"  caption="列名"/>
						<youi:gridCol editor="fieldText" width="20%" property="name"  caption="映射名"/>
						<youi:gridCol editor="fieldText" width="60%" property="columnCaption"  caption="列描述"/>
					</youi:grid>
				</youi:fieldGrid>
				
			</youi:fieldLayout>
		</youi:tabItem>
	</youi:tabs>
	
</youi:page>