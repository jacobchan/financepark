<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssueflow" idKeys="issueFlowId" caption="流程定义列表"  panel="false"
				src="esb/web/nmIssueflowManager/getPagerNmIssueflows.json" dataFormId="form_nmIssueflow"
				editSrc="esb/web/nmIssueflowManager/getNmIssueflow.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssueflowManager/removeNmIssueflow.json">
		<youi:fieldLayout>
			<youi:fieldText property="issueFlowStatus"  caption="状态"/>
			<youi:fieldText property="issueOperate"  caption="操作详细"/>

		</youi:fieldLayout>
		<youi:gridCol property="issueFlowCStatus"  caption="状态" width="200px" align="center"/>
		<youi:gridCol property="issueOperate"  caption="操作详细" width="200px"/>
		<youi:gridCol property="nmIssuetype.issueTypeCaption"  caption="发布类型" width="200px" orderBy="true"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		
		<%-- <youi:button name="adds" caption="批量添加" icon="addRecord" active="0"/> --%>
	</youi:grid>
	
	<!-- form-流程定义编辑 -->
	<youi:form dialog="true" caption="流程定义" id="form_nmIssueflow" action="esb/web/nmIssueflowManager/saveNmIssueflow.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="issueFlowId"  caption="发布流程ID"/>
			<youi:fieldSelect property="nmIssuetype.issueTypeId" caption="发布类型" 
				 src="esb/web/nmIssuetypeManager/getPagerNmIssuetypes.json" 
				 show="issueTypeCaption" code="issueTypeId" />
			<youi:fieldSelect property="issueFlowNStatus" caption="上步状态" code="issueFlowCStatus" show="issueOperate"
				src="esb/web/nmIssueflowManager/getNmIssueflows.json" parents="nmIssuetype.issueTypeId" parentsAlias="nmIssuetype.issueTypeId"/>
			<youi:fieldText property="issueFlowCStatus"  caption="状态"/>
			<youi:fieldText property="issueOperate"  caption="操作详细"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-流程定义批量添加 -->
	<youi:form dialog="true" caption="流程定义" id="form_nmIssueflows" action="esb/web/nmIssueflowManager/saveNmIssueflows.json">
		<youi:fieldLayout prefix="records">
			<youi:fieldText property="issueOperate"  caption="操作详细"/>
			<youi:fieldText property="issueFlowCStatus"  caption="状态"/>
			<youi:fieldTree property="nmIssuetype.issueTypeId" caption="发布类型" rootText="发布类型"
				 src="esb/web/nmIssuetypeManager/getChildren.json" simple="false"
				 show="issueTypeCaption" code="issueTypeId" iteratorParentAttr="issueTypeId" />
		</youi:fieldLayout>
		
		<youi:grid>
		
		</youi:grid>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_adds">
		var addsForm = $elem("form_nmIssueflows",pageId);
		addsForm.form('open');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>