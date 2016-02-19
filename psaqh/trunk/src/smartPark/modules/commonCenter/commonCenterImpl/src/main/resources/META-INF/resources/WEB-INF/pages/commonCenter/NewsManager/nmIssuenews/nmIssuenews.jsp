<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>

	<youi:grid id="grid_nmIssuenews" idKeys="policyId" caption="政策新闻内容列表"  panel="false"
				src="esb/web/nmIssuenewsManager/getPagerNmIssuenewss.json" dataFormId="form_nmIssuenews" 
				editSrc="esb/web/nmIssuenewsManager/getNmIssuenews.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuenewsManager/removeNmIssuenews.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<youi:fieldText property="policyType"  caption="发布类型"/>
			<youi:fieldText property="policyCaption"  caption="政策名称"/>
		</youi:fieldLayout>

		<youi:gridCol property="policyCaption"  caption="政策名称" width="150px"/>
		<youi:gridCol property="policyType.issueTypeCaption"  caption="发布类型" width="150px"/>
		<youi:gridCol property="policyCome"  caption="政策发布人" width="150px"/>
		<youi:gridCol property="policyIssueDate"  caption="政策发布时间" width="150px"/>
		<youi:gridCol property="policyStatus"  caption="政策发布状态" width="150px"/>
		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-政策新闻内容编辑 -->
	<youi:form dialog="true" caption="政策新闻内容" id="form_nmIssuenews" 
			action="esb/web/nmIssuenewsManager/saveNmIssuenews.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="policyId"  caption="政策ID"/>
			<youi:fieldText property="policyCaption"  caption="政策名称" column="2"/>
			<youi:fieldSelect property="policyType.issueTypeId" caption="发布类型"
				src="esb/web/nmIssuetypeManager/getNmIssuetypes.json" code="issueTypeId" show="issueTypeCaption"/>
			<youi:fieldSelect property="nmIssuetempalate.issueTempalateId" caption="发布模板"
				src="esb/web/nmIssuetempalateManager/getNmIssuetempalates.json" code="issueTempalateId" show="issueTempalateCaption" parents="policyType.issueTypeId" parentsAlias="nmIssuetype.issueTypeId"/>
			<youi:fieldArea property="policyContent"  caption="政策内容" column="2" rows="4"/>
			<youi:fieldText property="policyCome"  caption="政策发布人"/>
			<youi:fieldText property="policyIssueDate"  caption="政策发布时间"/>
			<youi:fieldText property="policyStatus"  caption="政策发布状态"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>