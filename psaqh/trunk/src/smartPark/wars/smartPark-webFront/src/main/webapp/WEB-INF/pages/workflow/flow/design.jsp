<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:html>
<head>
<title>流程设计器</title>

	<%@ include file="/WEB-INF/pages/common/commonScriptAndCss_debug.jsp"%>
	<youi:script src="/scripts/3.0/youi/youi.workflowdesigner.js"/>
	<youi:style href="/styles/3.0/youi/youi.workflowdesigner.css"/>

</head>
<body>
	<youi:subpage caption="表单设计" subpageId="form_design"
		 type="window" src="/page/workflow.flow/formDesigner.html">
	</youi:subpage>
	
	<div class="header well well-sm" style="margin-bottom:0px;font-size:18px;font-weight:bold;">
		<span class="glyphicon glyphicon-modal-window" style="top:2px;" aria-hidden="true"></span> WEB流程设计器V0.1.0
	</div>
	
	<div id="workflow_designer" class="col-sm-12">
		
		<div class="col-sm-12 layout-x comp-toolbar">
		</div>
		<div class="comp-tree layout-y col-sm-2 youi-shell-left">
			<ul></ul>
		</div>
		<div id="workflow" class="comp-flow layout-y col-sm-8">
			<div class="lane-layout">
				<div class="lane">
					<div class="col-resize-handler"></div>
					<div class="lane-title content-editable"></div>
				</div>
				<div class="lane">
					<div class="col-resize-handler"></div>
					<div class="lane-title content-editable">开始</div>
				</div>
				<div class="lane">
					<div class="col-resize-handler"></div>
					<div class="lane-title content-editable">部门领导</div>
				</div>
				<div class="lane">
					<div class="col-resize-handler"></div>
					<div class="lane-title content-editable">公司领导</div>
				</div>
				<div class="lane">
					<div class="col-resize-handler"></div>
					<div class="lane-title content-editable">结束</div>
				</div>
	
				<div class="row-resize-handler"></div>
			</div>
			<div id="node1" data-form="startForm" class="node startEvent" style="left: 133px; top: 120px;"
				title="开始">开始</div>
			<div id="node2" class="node userTask" style="left: 314px; top: 120px;"
				title="部门审批">部门审批</div>
	
			<div id="end1" class="node endEvent"
				style="left: 736px; top: 227px;" title="结束">结束</div>
	
			<div id="node1_node2" class="transition" data-source-ref="node1"
				data-target-ref="node2">
				<div class="point in-straight-line" style="left: 153px; top: 186px;"></div>
				<div class="point" style="left: 155px; top: 84px;"></div>
				<div class="point in-straight-line"
					style="left: 253.5px; top: 250.5px;"></div>
				<div class="point" style="left: 351.109375px; top: 84px;"></div>
				<div class="point in-straight-line"
					style="left: 354px; top: 186.5px;"></div>
	
				<div class="point-text content-editable" data-radius="20"
					data-degree="30" style="left: 175.320508075689px; top: 97px;">node1_node2</div>
			</div>
	
			<div id="node4" class="node serviceTask"
				style="left: 611.109375px; top: 227px;" title="自动任务">自动任务</div>
	
			<div id="node4_end1" class="transition" data-source-ref="node4"
				data-target-ref="end1"></div>
			<div id="node5" class="node userTask" style="left: 220px; top: 227px;"
				title="销假">销假</div>
			<div id="node1_node5" class="transition" data-source-ref="node1"
				data-target-ref="node5">
				<div class="point in-straight-line"
					style="left: 155.5546875px; top: 195.5px;"></div>
				<div class="point" style="left: 155px; top: 249px;"></div>
				<div class="point in-straight-line"
					style="left: 268.5546875px; top: 248px;"></div>
			</div>
			<div id="node6" class="node endEvent ui-selected"
				style="left: 736px; top: 379px;" title=""></div>
			<div id="node5_node6" class="transition" data-source-ref="node5"
				data-target-ref="node6">
				<div class="point in-straight-line"
					style="left: 256.0546875px; top: 326.5px;"></div>
				<div class="point" style="left: 257px; top: 401px;"></div>
				<div class="point in-straight-line"
					style="left: 513.8984375px; top: 402.5px;"></div>
			</div>
			<div id="node3" class="node userTask" style="left: 518px; top: 120px;"
				title="经理审批">经理审批</div>
			<div id="node2_node3" class="transition" data-source-ref="node2"
				data-target-ref="node3">
				<div class="point-text content-editable" data-radius="150"
					data-degree="180" style="left: 408px; top: 145px;">node2_node3</div>
				<div class="point in-straight-line" style="left: 452px; top: 122px;"></div>
			</div>
			<div id="node3_node4" class="transition" data-source-ref="node3"
				data-target-ref="node4">
				<div class="point in-straight-line"
					style="left: 553.0546875px; top: 195.5px;"></div>
				<div class="point" style="left: 554.609375px; top: 248.5px;"></div>
				<div class="point in-straight-line"
					style="left: 601.5546875px; top: 249px;"></div>
			</div>
		</div>
		
		<div class="comp-propertytable layout-y col-sm-2">
			
		</div>
	</div>
	
	<div id="footer" class="col-sm-12 well well-sm" style="margin-bottom:0px;">
		Copyright © 2015-2020 gisoft, All Rights Reserved.</div>
</body>

<script type="text/javascript">
	$(function() {
		$.youi.logLevel = 4;
		$('#workflow_designer').workflowdesigner({});
	});
</script>
</youi:html>