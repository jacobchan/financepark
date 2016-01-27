<%@ include file="/WEB-INF/pages/include.jsp"%>

<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_rptDataSource" idKeys="dataSourceId" caption="报表数据源列表"  panel="false"
				src="esb/web/rptDataSourceManager/getPagerRptDataSources.json" dataFormId="form_rptDataSource"
				editSrc="esb/web/rptDataSourceManager/getRptDataSource.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/rptDataSourceManager/removeRptDataSource.json">
		<youi:fieldLayout>
			<youi:fieldText property="jdbcDbtype"  caption="数据库类型"/>
		</youi:fieldLayout>
		
		<youi:gridCol width="10%" property="dataSourceName" caption="数据源名"/>
		<youi:gridCol width="25%" property="jdbcUrl"  caption="数据库URL"/>
		<youi:gridCol width="25%" property="jdbcDriver"  caption="数据库驱动"/>

		<youi:gridCol width="15%" property="jdbcDbtype"  caption="数据库类型"/>
		<youi:gridCol width="10%" property="jdbcSchema"  caption="SCHEMA"/>
		<youi:gridCol width="15%" property="jdbcUsername"  caption="用户名"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-报表数据源编辑 -->
	<youi:form dialog="true" caption="编辑报表数据源" id="form_rptDataSource" action="esb/web/rptDataSourceManager/saveRptDataSource.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="dataSourceId"  caption="主键"/>
			
			<youi:fieldText property="dataSourceName" caption="数据源名" column="2"/>
			<youi:fieldText property="jdbcUrl"  caption="数据库URL" column="2"/>
			<youi:fieldText property="jdbcDriver"  caption="数据库驱动" column="2"/>
			
			<youi:fieldText property="jdbcDbtype"  caption="数据库类型"/>
			<youi:fieldText property="jdbcSchema"  caption="SCHEMA"/>
			<youi:fieldText property="jdbcUsername"  caption="用户名"/>
			<youi:fieldPassword property="jdbcPassword"  caption="密码"/>
			
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	<youi:func name="grid_rptDataSource_col_button_edit" params="record,rowDoc">
		$(this).grid('openFormEdit','修改',rowDoc);
	</youi:func>
	
	<youi:func name="grid_rptDataSource_col_button_remove" params="record,rowDoc">
		$(this).grid('removeRecords',rowDoc);
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>