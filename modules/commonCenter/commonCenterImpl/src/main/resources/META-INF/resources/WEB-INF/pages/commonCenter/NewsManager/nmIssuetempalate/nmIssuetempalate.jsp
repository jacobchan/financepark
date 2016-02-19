<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssuetempalate" idKeys="issueTempalateId" caption="发布模板列表"  panel="false"
				src="esb/web/nmIssuetempalateManager/getPagerNmIssuetempalates.json" dataFormId="form_nmIssuetempalate"
				editSrc="esb/web/nmIssuetempalateManager/getNmIssuetempalate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuetempalateManager/removeNmIssuetempalate.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">

			<youi:fieldText property="issueSendstatus"  caption="使用状态"/>
			<youi:fieldText property="issueTempalateCaption"  caption="发布模板名称"/>
		</youi:fieldLayout>

		<youi:gridCol property="issueTempalateCaption"  caption="发布模板名称" width="150px"/>
		<youi:gridCol property="issueTempalateContent"  caption="发布模板内容" width="150px"/>
		<youi:gridCol property="nmIssuetype.issueTypeCaption"  caption="发布类型" width="150px"/>
		<youi:gridCol property="issueTempalateTo"  caption="发送到" width="150px"/>
		<youi:gridCol property="issueSendstatus"  caption="使用状态" width="150px"/>
		<youi:gridCol property="issueTempalateSrc"  caption="模板路径" width="150px"/>
		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-发布模板编辑 -->
	<youi:form dialog="true" caption="发布模板" id="form_nmIssuetempalate" action="esb/web/nmIssuetempalateManager/saveNmIssuetempalate.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="issueTempalateId"  caption="发布模板ID"/>
			<youi:fieldText property="issueTempalateCaption"  caption="发布模板名称"/>
			<youi:fieldSelect property="nmIssuetype.issueTypeId"  caption="发布类型"
				src="esb/web/nmIssuetypeManager/getNmIssuetypes.json" code="issueTypeId" show="issueTypeCaption"/>
			<youi:fieldArea property="issueTempalateContent"  caption="发布模板内容" column="2" rows="3"/>
			<youi:fieldText property="issueTempalateTo"  caption="发送到"/>
			<youi:fieldText property="issueSendstatus"  caption="使用状态"/>
			<youi:fieldText property="issueTempalateSrc"  caption="模板路径" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>