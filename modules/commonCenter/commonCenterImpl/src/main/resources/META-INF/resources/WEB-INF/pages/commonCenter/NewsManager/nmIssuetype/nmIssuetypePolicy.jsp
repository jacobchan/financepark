<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

<youi:table columns="1">
	<youi:cell>
		<youi:grid id="grid_nmIssuetype" idKeys="issueTypeId" caption="发布类型列表"  panel="false" pageSize="8" height="360"
					src="esb/web/nmIssuetypeManager/getPagerNmIssuetypesByCode.json?code=02" dataFormId="form_nmIssuetype"
					editSrc="esb/web/nmIssuetypeManager/getNmIssuetype.json" showCheckbox="true"
					removeSrc="esb/web/nmIssuetypeManager/removeNmIssuetype.json">
			<youi:fieldLayout prefix="search" columns="2" labelWidths="100,100">
				<youi:fieldText property="issueTypeCaption"  caption="发布类型描述" operator="LIKE"/>
				<youi:fieldText property="issueTypeCode"  caption="发布类型编码" operator="LIKE"/>
			</youi:fieldLayout>
			
			<youi:gridCol property="issueTypeParentCaption"  caption="发布类型上级" width="40%" align="center"/>
			<youi:gridCol property="issueTypeCaption"  caption="发布类型描述" width="40%" align="center"/>
			<youi:gridCol property="issueTypeCode"  caption="发布类型编码" width="20%" align="center"/>
		</youi:grid>
	</youi:cell>
	
	<youi:cell caption="流程定义">
		<youi:grid id="grid_nmIssueflow" idKeys="issueFlowId" caption="流程定义列表"  panel="false" height="320"
				src="esb/web/nmIssueflowManager/getPagerNmIssueflowByType.json" dataFormId="form_nmIssueflow" 
				editSrc="esb/web/nmIssueflowManager/getNmIssueflow.json" showCheckbox="false" showNum="true"
				removeSrc="esb/web/nmIssueflowManager/removeNmIssueflow.json" submit="NOT" reset="NOT" 
				parentId="grid_nmIssuetype" parentAttr="nmIssuetype">

		<youi:gridCol property="issueFlowCStatus"  caption="当前状态" width="30%" align="center"/>
		<youi:gridCol property="issueFlowNStatus"  caption="上步状态" width="30%" align="center"/>
		<youi:gridCol property="issueOperate"  caption="操作详细" width="30%" align="center"/>
	</youi:grid>
	</youi:cell>
</youi:table>	
	
	<!-- form-发布类型编辑 -->
	<youi:form dialog="true" caption="发布类型" id="form_nmIssuetype" action="esb/web/nmIssuetypeManager/saveNmIssuetypes.json?code=02">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="150px,150px">
			<youi:fieldHidden property="issueTypeId"  caption="发布类型ID"/>
			<youi:fieldText property="issueTypeCaption"  caption="发布类型描述" notNull="true"/>
			<youi:fieldText property="issueTypeCode"  caption="发布类型编码" notNull="true" validateSrc="esb/web/nmIssuetypeManager/codeExist.json"/>
			<youi:fieldHidden property="leaf" defaultValue="1" caption="是否子节点"/>
			<youi:fieldHidden property="issueTypeStatus"  caption="发布类型状态" defaultValue="1"/>
			<youi:fieldHidden property="parentIssueTypeId"  caption="上级发布类型" />
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-流程定义编辑 -->
	<youi:form dialog="true" caption="流程定义" id="form_nmIssueflow" action="esb/web/nmIssueflowManager/saveNmIssueflow.json">
		<youi:fieldLayout prefix="record" columns="1">
			<youi:fieldHidden property="issueFlowId"  caption="发布流程ID"/>
			<youi:fieldHidden property="nmIssuetype.issueTypeId" caption="发布类型ID"/>
			<youi:fieldLabel property="nmIssuetype.issueTypeCaption" caption="发布类型描述"/>
			<youi:fieldText property="issueFlowCStatus"  caption="当前状态" notNull="true"/>
			<%-- <youi:fieldText property="issueFlowNStatus"  caption="上步状态"/> --%>
			<youi:fieldSelect property="issueFlowNStatus" caption="上步状态" code="issueFlowCStatus" show="issueOperate"
				src="esb/web/nmIssueflowManager/getNmIssueflows.json" parents="nmIssuetype.issueTypeId" parentsAlias="nmIssuetype.issueTypeId"/>
			<youi:fieldText property="issueOperate"  caption="操作详细" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>