<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssueflow" idKeys="issueFlowId" caption="流程定义列表"  panel="false"
				src="esb/web/nmIssueflowManager/getPagerNmIssueflows.json" dataFormId="form_nmIssueflow"
				editSrc="esb/web/nmIssueflowManager/getNmIssueflow.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssueflowManager/removeNmIssueflow.json">
		<youi:fieldLayout>
			<youi:fieldText property="issueFlowStatus"  caption="下步状态"/>
			<youi:fieldText property="issueFlowCaption"  caption="发布流程描述"/>
			<youi:fieldText property="flowInstance"  caption="对应实例"/>
			<youi:fieldText property="issueFlowStatus"  caption="当前状态"/>

			<youi:fieldText property="issueOperate"  caption="操作详细"/>
			<youi:fieldText property="flowUse"  caption="使用情况"/>
		</youi:fieldLayout>
		<youi:gridCol property="issueFlowStatus"  caption="下步状态"/>
		<youi:gridCol property="issueFlowCaption"  caption="发布流程描述"/>
		<youi:gridCol property="flowInstance"  caption="对应实例"/>
		<youi:gridCol property="issueFlowStatus"  caption="当前状态"/>

		<youi:gridCol property="issueOperate"  caption="操作详细"/>
		<youi:gridCol property="flowUse"  caption="使用情况"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-流程定义编辑 -->
	<youi:form dialog="true" caption="流程定义" id="form_nmIssueflow" action="esb/web/nmIssueflowManager/saveNmIssueflow.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="issueFlowStatus"  caption="下步状态"/>
			<youi:fieldText property="issueFlowCaption"  caption="发布流程描述"/>
			<youi:fieldText property="flowInstance"  caption="对应实例"/>
			<youi:fieldText property="issueFlowStatus"  caption="当前状态"/>
			<youi:fieldText property="issueFlowId"  caption="发布流程ID"/>
			<youi:fieldText property="issueOperate"  caption="操作详细"/>
			<youi:fieldText property="flowUse"  caption="使用情况"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>