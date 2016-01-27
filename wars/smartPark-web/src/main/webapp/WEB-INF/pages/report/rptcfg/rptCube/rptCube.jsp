<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:script src="/scripts/3.0/youi/youi.cubeDesigner.js?1=1"/>
	<youi:style href="/styles/3.0/youi/youi.cubeDesigner.css?1=1"/>
	
	<youi:ajaxUrl name="getColumnsByDataSet" src="esb/web/rptDataSetManager/getColumnsByDataSet.json"/>

	<youi:grid id="grid_rptCube" idKeys="cubeId" caption="立方体列表"  panel="false"
				src="esb/web/rptCubeManager/getPagerRptCubes.json" dataFormId="form_rptCube"
				editSrc="esb/web/rptCubeManager/getRptCube.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/rptCubeManager/removeRptCube.json">
		<youi:fieldLayout>
			<youi:fieldText property="name"  caption="立方体名"/>
			<youi:fieldText property="cubeData"  caption="维度计量"/>
		</youi:fieldLayout>

		<youi:gridCol width="15%" property="name"  caption="立方体名"/>
		<youi:gridCol width="85%" property="cubeData"  caption="维度计量" renderer="renderer_cubeData"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-立方体编辑 -->
	<youi:form width="1000" height="600" dialog="true" caption="立方体" id="form_rptCube" action="esb/web/rptCubeManager/saveRptCube.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="cubeId"  caption="立方体ID"/>
			<youi:fieldText property="name"  caption="立方体名"/>
			<youi:fieldSelect property="dataSet.dataSetId" caption="数据集" notNull="true" src="esb/web/rptDataSetManager/getRptDataSets.json" show="dataSetCaption" code="dataSetId"/>
		</youi:fieldLayout>
		<div id="cubeDesigner" class="col-sm-12">
			<youi:tree height="500" id="tree_dataSetColumns" styleClass="col-sm-3 cubeDesigner-panel" dragable="true" dropStyle="drop-item">
				<ul>
					<li id="cube_root" class="treeNode root last expandable lastExpandable">
						<span class="tree-span treeNode use-icon last expandable lastExpandable">
							<i class="youi-icon fa fa-th-list"></i><a class="tree-a">数据集输出列</a>
						</span>
						<ul>
							
						</ul>
					</li>
				</ul>
			</youi:tree>
			
			<div class="col-sm-6">
				<div class="groups drop-item drop-group"></div>
				<div class="measures drop-item drop-measure"></div>
			</div>
			
			<div class="col-sm-3 cubeDesigner-panel comp-propertytable">
			</div>
		</div>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<youi:func name="init">
		
		var fromElem = $elem('form_rptCube',pageId);
		fromElem.find('#cubeDesigner').cubeDesigner({
			groupsProperty:'groups',
			measuresProperty:'measures'
		});
	</youi:func>
	
	<!-- 下拉框值变化回调函数 -->
	<youi:func name="record_dataSet_dataSetId_change" urls="getColumnsByDataSet" params="value,oldValue">
		if(funcUrls.getColumnsByDataSet){
			var formElem = $elem('form_rptCube',pageId);			
			var datasetTree = $elem('tree_dataSetColumns',pageId);
			var root = formElem.find('#cube_root');
			root.find('>ul').empty();//清空
			
			if(value){
				var datasetSrc = funcUrls.getColumnsByDataSet+'?dataSetId='+value;
				
				var datas = {
					src:datasetSrc,idattr:'columnName',textattr:'columnCaption'
				};
				root.removeClass('loaded expanded').data(datas);
				datasetTree.tree('triggerNode',root);

				formElem.find('#cubeDesigner').cubeDesigner('clear');
			}
		}
	</youi:func>
	
	<youi:func name="tree_dataSetColumns_stop" params="event,ui">
		if(ui.dropNode&&!ui.dragNode.hasClass('root')){
			var nodeId = ui.dragNode.attr('id');
			$elem('form_rptCube',pageId).find('#cubeDesigner').cubeDesigner('addItem',
				{id:nodeId,name:nodeId,columnName:nodeId,caption:ui.dragNode.find('>span>a').text()},ui.dropNode);
		}
	</youi:func>
	
	<youi:func name="renderer_cubeData" params="col,record">
		var values = [];
		var cube = record;
			
		if(record.cubeData){
			cube = $.parseJSON(record.cubeData);
		}

		values.push('分组：[');
		$(cube.groups).each(function(){
			values.push(this.caption||this.name);
		});
		values.push('],计量：[');
		$(cube.measures).each(function(){
			values.push(this.caption||this.name);
		});
		values.push(']');

		return values.join(' ');
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>