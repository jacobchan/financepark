<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssuenews" idKeys="policyId" caption="政策新闻内容列表"  panel="false"
				src="esb/web/nmIssuenewsManager/getPagerNmIssuenewss.json" dataFormId="form_nmIssuenews"
				editSrc="esb/web/nmIssuenewsManager/getNmIssuenews.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuenewsManager/removeNmIssuenews.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldText property="policyCaption"  caption="名称"/>
			<youi:fieldCalendar property="policyIssueDate"  caption="发布时间"/>
			<youi:fieldSelect property="policyType.issueTypeId"  caption="发布类型" 
				src="esb/web/nmIssuetypeManager/getNmIssuetypes.json" code="issueTypeId" show="issueTypeCaption"/>
			<youi:fieldSelect property="policyStatus"  caption="发布状态" convert="policyStatus"/>
		</youi:fieldLayout>
		<youi:gridCol property="policyId"  caption="政策ID" width="257"/>
		<youi:gridCol property="nmIssuetempalate"  caption="发布模板ID" width="257"/>
		<youi:gridCol property="policyType.issueTypeCaption"  caption="发布类型" width="110" />
		<youi:gridCol property="policyCaption"  caption="名称" width="100"/>
		<youi:gridCol property="policyCome"  caption="发布人" width="60"/>
		<youi:gridCol property="policyStatus"  caption="发布状态" width="60" convert="policyStatus"/>
		<youi:gridCol property="policyIssueDate"  caption="发布时间" width="80"/>
		<youi:gridCol property="policyContent"  caption="政策内容" width="257"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-政策新闻内容编辑 -->
	<youi:form dialog="true" caption="政策新闻内容" id="form_nmIssuenews" action="esb/web/nmIssuenewsManager/saveNmIssuenews.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="policyId"  caption="政策ID" />
			<youi:fieldText property="nmIssuetempalate"  caption="发布模板ID" />
			<youi:fieldSelect property="policyType.issueTypeId"  caption="发布类型" 
				src="esb/web/nmIssuetypeManager/getNmIssuetypes.json" code="issueTypeId" show="issueTypeCaption"/>
			<youi:fieldText property="policyCaption"  caption="名称" />
			<youi:fieldText property="policyCome"  caption="发布人" />
			<youi:fieldSelect property="policyStatus"  caption="发布状态" convert="policyStatus"/>
			<youi:fieldCalendar property="policyIssueDate"  caption="发布时间" />
			<youi:fieldArea property="policyContent"  caption="政策内容" column="2" rows="4"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>