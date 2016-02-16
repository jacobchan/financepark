<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html title="表单设计">
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss_debug.jsp"%>
		<youi:script src="/scripts/3.0/lib/codemirror.js"/>
		<youi:script src="/scripts/3.0/lib/codemirror-js.js"/>
		
		<youi:script src="/scripts/3.0/youi/youi.pagedesigner.js"/>
		<youi:script src="/scripts/3.0/youi/youi.pageditor.js"/>
		
		<youi:style href="/styles/3.0/codemirror.css"/>
		<youi:style href="/styles/3.0/youi/youi.pageditor.css"/>
		<youi:style href="/styles/3.0/youi/youi.pagedesigner.css"/>
	</head>
	
	<body class="youi-bgcolor">
	
		<youi:convert name="orderBy"></youi:convert>
		<youi:convert name="booleanStr"></youi:convert>
		
		<youi:subpage src="/page/plt.dev.form/showCode.html?formId={formId}" subpageId="showCode" 
			caption="" height="560">
		
		</youi:subpage>
		
		<youi:subpage type="iframe" src="/page/plt.dev.form/run.html?formId={formId}" subpageId="runCode" 
			caption="表单" height="600" width="1000">
			
		</youi:subpage>
		
		<youi:fieldLayout styleClass="hide" prefix="ui">
			<youi:fieldHidden property="propertyGroupDescs" caption="1"/>
			<youi:fieldHidden property="formCaption" caption="当前编辑表单"/>
		</youi:fieldLayout>
		<youi:form styleClass="col-sm-12" id="panel_form_designer" caption="表单设计" submit="NOT" reset="NOT" panel="false">
			
			<div id="pagedesigner" class="youi-pagedesigner col-sm-12">
				<div class="pagedesigner-comp comp-toolbar youi-bg col-sm-12"></div>
				<div class="pagedesigner-comp layout-y comp-accordion col-sm-2"></div>
				<div class="pagedesigner-comp layout-y comp-pageditor col-sm-8">
					<ul id="tabs_pageditor" class="nav nav-tabs youi-tabs youi-bg">
						<li id="pageditor_main" class="active">
							<a aria-expanded="true" href="#pageditor_main_panel" data-toggle="tab">主页面</a>
						</li>
						<li id="pageditor_subpages">
						  <a href="#pageditor_subpages_panel" data-toggle="tab">子页面</a>
						</li>
						<li id="pageditor_funcs">
						  <a href="#pageditor_funcs_panel" data-toggle="tab">函数</a>
						</li>
					</ul>
					<div class="tab-content">
						<div id="pageditor_main_panel" data-widget="true" class="tab-pane pageditor-main pageditor-drop col-sm-12 active">
							<youi:out value="${pageditorHtml}" escapeXml="false"/>
						</div>
						<div id="pageditor_subpages_panel" data-subpage="true" class="tab-pane pageditor-subpages col-sm-12 pageditor-drop">
							
						</div>
						<div id="pageditor_funcs_panel" data-func="true" class="tab-pane pageditor-funcs col-sm-12 pageditor-drop">
							
						</div>
					</div>
					
				</div>
				<div class="pagedesigner-comp layout-y comp-propertytable col-sm-2">
				
				</div>
			</div>
			
			<div id="designer_footer" align="center" class="col-sm-12">
				Copyright © 2015-2020  All Rigths  Reserved.
			</div>
		</youi:form>
		<!-- 表单保存 -->
		<youi:form dialog="true" action="/des/form/saveForm.json" reset="NOT" submit="保存"
			 id="form_pagedesigner_save" caption="保存表单">
			<youi:fieldLayout columns="1">
				<youi:fieldHidden property="formId" caption="formId"/>
				<youi:fieldText  property="formCaption" caption="表单描述" width="498"/>
				<youi:fieldArea caption="表单xml" readonly="true" height="460" property="content"/>
				<youi:fieldHidden caption="表单html" property="contentHtml"/>
			</youi:fieldLayout>
		</youi:form>
		<!-- 表单函数编辑 -->
		<youi:form dialog="true" reset="NOT" submit="保存" id="pagedesigner_funcs" caption="页面函数">
			<div class="container_funcs" style="height:400px;overflow-y:auto;">
				
			</div>
		</youi:form>
		
		<youi:func name="init">
			$.youi.logLevel = 4;
			var designerElement = $('#pagedesigner'),
				value = $('#ui_propertyGroupDescs').fieldValue(),
				title = $('#ui_formCaption').fieldValue(),
				propertyGroupDescs = {"base":{"name":"base","caption":"基本属性","propertyDescs":[{"name":"widgetId","caption":"组件ID","type":"fieldHidden","defaultValue":null,"groups":["widget"]},{"name":"widgetName","caption":"组件","type":"fieldLabel","defaultValue":null,"groups":["widget"]},{"name":"caption","caption":"组件描述","type":"fieldText","defaultValue":"","groups":["widget"]},{"name":"column","caption":"占位","type":"fieldText","defaultValue":"1","groups":["div"]}]},"layout":{"name":"layout","caption":"布局属性","propertyDescs":[{"name":"layout_rows","caption":"rows","type":"fieldText","defaultValue":"2","groups":["table"]},{"name":"layout_cols","caption":"cols","type":"fieldText","defaultValue":"2","groups":["table"]},{"name":"layout_cellspacing","caption":"cellspacing","type":"fieldText","defaultValue":"","groups":["table"]},{"name":"layout_cellpading","caption":"cellpading","type":"fieldText","defaultValue":"","groups":["table"]}]},"component":{"name":"component","caption":"组件属性","propertyDescs":[{"name":"component_leaf","caption":"叶子节点","type":"fieldHidden","defaultValue":"","groups":["treeNode"]},{"name":"component_id","caption":"ID","type":"fieldText","defaultValue":"","groups":["component"]},{"name":"component_width","caption":"宽度","type":"fieldText","defaultValue":"","groups":["component"]},{"name":"component_columns","caption":"columns","type":"fieldText","defaultValue":"2","groups":["fieldLayout"]},{"name":"component_show-border","caption":"showBorder","type":"fieldText","defaultValue":"","groups":["fieldLayout"]},{"name":"component_show-checkbox","caption":"显示复选框","type":"fieldSelect","defaultValue":"","groups":["grid"]},{"name":"component_show-num","caption":"显示序号","type":"fieldSelect","defaultValue":"","groups":["grid"]},{"name":"component_page-size","caption":"每页条数","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_scroll-height","caption":"滚动高度","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_id-keys","caption":"主键属性","type":"fieldText","defaultValue":"","groups":["grid","form","subpage"]},{"name":"component_src","caption":"来源数据URL","type":"fieldText","defaultValue":"","groups":["grid","func","subpage"]},{"name":"component_edit-src","caption":"表单数据URL","type":"fieldText","defaultValue":"","groups":["grid","subpage"]},{"name":"component_pager-records","caption":"pagerRecords","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_panel","caption":"使用panel","type":"fieldSelect","defaultValue":"","groups":["grid","form"]},{"name":"component_submit","caption":"查询按钮","type":"fieldText","defaultValue":"查询","groups":["grid","form"]},{"name":"component_reset","caption":"重置按钮","type":"fieldText","defaultValue":"重置","groups":["grid","form"]},{"name":"component_data-form-id","caption":"数据表单","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_use-pager","caption":"使用分页","type":"fieldSelect","defaultValue":"","groups":["grid"]},{"name":"component_remove-src","caption":"removeSrc","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_export-xls","caption":"导出xls","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_export-pdf","caption":"导出pdf","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_print","caption":"打印","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_load","caption":"加载数据","type":"fieldSelect","defaultValue":"","groups":["grid"]},{"name":"component_add","caption":"增加按钮","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_edit","caption":"编辑按钮","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_remove","caption":"删除按钮","type":"fieldText","defaultValue":"","groups":["grid"]},{"name":"component_item-height","caption":"内容高度","type":"fieldText","defaultValue":"","groups":["tabs"]},{"name":"component_name","caption":"name","type":"fieldText","defaultValue":"","groups":["button","func"]},{"name":"component_active","caption":"active","type":"fieldText","defaultValue":"","groups":["button"]},{"name":"component_action","caption":"action","type":"fieldText","defaultValue":"","groups":["button","form"]},{"name":"component_icon","caption":"icon","type":"fieldText","defaultValue":"","groups":["button"]},{"name":"component_value","caption":"值","type":"fieldText","defaultValue":"","groups":["fieldOption"]},{"name":"component_property","caption":"属性","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_align","caption":"水平对齐","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_convert","caption":"代码集","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_type","caption":"列类型","type":"fieldText","defaultValue":"","groups":["gridCol","subpage"]},{"name":"component_href","caption":"href","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_params","caption":"params","type":"fieldText","defaultValue":"","groups":["gridCol","func"]},{"name":"component_target","caption":"target","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_not-convert-value","caption":"notConvertValue","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_order-by","caption":"排序","type":"fieldSelect","defaultValue":"","groups":["gridCol"]},{"name":"component_sort-property","caption":"排序属性","type":"fieldText","defaultValue":"","groups":["gridCol"]},{"name":"component_root-text","caption":"rootText","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_check","caption":"check","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_dragable","caption":"dragable","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_drop-style","caption":"dropStyle","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_items","caption":"items","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_tree","caption":"tree","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_item-root-id","caption":"itemRootId","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_hide-root","caption":"hideRoot","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_iterator-src","caption":"iteratorSrc","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_id-attr","caption":"idAttr","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_text-attr","caption":"textAttr","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_id-prefix","caption":"idPrefix","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_iterator-param","caption":"iteratorParam","type":"fieldText","defaultValue":"","groups":["tree"]},{"name":"component_i18ns","caption":"国际化","type":"fieldText","defaultValue":"","groups":["func"]},{"name":"component_execute","caption":"初始执行","type":"fieldSelect","defaultValue":"","groups":["func"]},{"name":"component_auto-open","caption":"自动打开","type":"fieldText","defaultValue":"","groups":["dialog"]},{"name":"component_modal","caption":"模态窗口","type":"fieldText","defaultValue":"","groups":["dialog"]},{"name":"component_z-index","caption":"zIndex","type":"fieldText","defaultValue":"","groups":["dialog"]},{"name":"component_dialog","caption":"弹出窗口","type":"fieldText","defaultValue":"false","groups":["form"]},{"name":"component_close","caption":"关闭按钮","type":"fieldText","defaultValue":"关 闭","groups":["form"]},{"name":"component_find-action","caption":"数据查找URL","type":"fieldText","defaultValue":"","groups":["form"]},{"name":"component_remove-action","caption":"数据删除URL","type":"fieldText","defaultValue":"","groups":["form"]},{"name":"component_confirm-message","caption":"删除确认提示","type":"fieldText","defaultValue":"","groups":["form"]},{"name":"component_subpage-id","caption":"页面ID","type":"fieldText","defaultValue":"","groups":["subpage"]},{"name":"component_form-action","caption":"提交地址","type":"fieldText","defaultValue":"","groups":["subpage"]},{"name":"component_form-submit","caption":"提交","type":"fieldText","defaultValue":"","groups":["subpage"]}]},"field":{"name":"field","caption":"表单属性","propertyDescs":[{"name":"field_property","caption":"属性","type":"fieldText","defaultValue":"","groups":["field"]},{"name":"field_default-value","caption":"默认值","type":"fieldText","defaultValue":"","groups":["field"]},{"name":"field_column","caption":"占位","type":"fieldText","defaultValue":"1","groups":["field"]},{"name":"field_not-null","caption":"非空","type":"fieldSelect","defaultValue":"","groups":["field"]},{"name":"field_not-visible","caption":"不可见","type":"fieldSelect","defaultValue":"","groups":["field"]},{"name":"field_readonly","caption":"只读","type":"fieldSelect","defaultValue":"","groups":["field"]},{"name":"field_principal-property","caption":"principalProperty","type":"fieldText","defaultValue":"","groups":["field"]},{"name":"field_height","caption":"高度","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldArea"]},{"name":"field_src","caption":"来源数据URL","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_src-data-type","caption":"来源数据类型","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_show","caption":"显示字段","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_code","caption":"值字段","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_parent-code","caption":"父值字段","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_mixed","caption":"混合显示","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_parents","caption":"父表单域","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_parents-alias","caption":"parentsAlias","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_convert","caption":"代码集","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_items","caption":"items","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldTree","fieldSelect"]},{"name":"field_item-text","caption":"itemText","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_item-value","caption":"itemValue","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_show-property","caption":"showProperty","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_popup","caption":"popup","type":"fieldText","defaultValue":"","groups":["fieldRadioGroup","fieldCheckboxGroup","fieldSelect"]},{"name":"field_data-type","caption":"数据格式","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_fraction-length","caption":"小数点位数","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_expression","caption":"校验表达式","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_expression-message","caption":"校验表达式提示信息","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_validate-src","caption":"ajax校验URL","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_min-length","caption":"最小长度","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_max-length","caption":"最大长度","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_operator","caption":"查询条件数据库操作符","type":"fieldText","defaultValue":"","groups":["fieldText"]},{"name":"field_item-root-id","caption":"itemRootId","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_root-text","caption":"rootText","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_check","caption":"check","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_tree","caption":"tree","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_pop-height","caption":"popHeight","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_only-leaf","caption":"onlyLeaf","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_simple","caption":"simple","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_iterator-parent-attr","caption":"iteratorParentAttr","type":"fieldText","defaultValue":"","groups":["fieldTree"]},{"name":"field_format","caption":"格式","type":"fieldText","defaultValue":"","groups":["fieldCalendar"]}]}};//$.parseJSON(value);
			var formRecord = $('#form_pagedesigner_save').form('getFormRecord');
			$('title',document).text('表单设计【'+(title||'新表单')+'】');			
			
			designerElement.pagedesigner({
				initHtml:!formRecord.formId?true:false,
				loadContent:function(event,ui){
					
				},
				propertytableOptions:{
					propertyGroupDescs:propertyGroupDescs,
					propertyConverts:{
						'component_order-by':'orderBy',
						'component_panel':'booleanStr',
						'component_show-num':'booleanStr',
						'component_show-checkbox':'booleanStr',
						'component_use-pager':'booleanStr',
						'field_not-null':'booleanStr',
						'field_readonly':'booleanStr',
						'field_not-visible':'booleanStr'
					}
				}
			});
		</youi:func>
		<!-- 保存表单 -->
		<youi:func name="pagedesigner_save" params="dom,ui">
			var record = $('#pagedesigner').pagedesigner('getEditorRecord');
			$('#form_pagedesigner_save').form('fillRecord',record).form('open');
		</youi:func>
		
		<!-- 运行表单 -->
		<youi:func name="pagedesigner_run" params="dom,ui">
			var record = $('#pagedesigner').pagedesigner('getEditorRecord');
			var saveFrom = $('#form_pagedesigner_save').form('fillRecord',record);
			var formRecord = saveFrom.form('getFormRecord');
			
			$('#subpage_runCode').subpage('open',formRecord,'运行',formRecord);
		</youi:func>
		
		<!-- 查看源代码 -->
		<youi:func name="pagedesigner_viewSource" params="dom,ui">
			var record = $('#pagedesigner').pagedesigner('getEditorRecord');
			var saveFrom = $('#form_pagedesigner_save').form('fillRecord',record);
			var formRecord = saveFrom.form('getFormRecord');
			
			$('#subpage_showCode').subpage('open',formRecord,'查看表单代码',formRecord);
		</youi:func>
		
		<youi:func name="form_pagedesigner_save_afterSubmit" params="result">
			$('#pagedesigner').pagedesigner('doSave');
			$('#form_pagedesigner_save').form('close');
		</youi:func>
	</body>
</youi:html>