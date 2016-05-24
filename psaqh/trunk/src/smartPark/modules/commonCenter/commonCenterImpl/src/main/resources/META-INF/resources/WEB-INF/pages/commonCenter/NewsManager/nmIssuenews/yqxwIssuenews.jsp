<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>

<youi:page>

	<youi:grid id="grid_nmIssuenews" idKeys="policyId" caption="园区新闻内容列表"  panel="false"
				src="esb/web/nmIssuenewsManager/getPagerNmIssuenewss.json?issueTypeCode=0101" dataFormId="form_nmIssuenews" 
				editSrc="esb/web/nmIssuenewsManager/getNmIssuenews.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuenewsManager/removeNmIssuenews.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<youi:fieldText property="policyCaption"  caption="新闻名称" operator="LIKE"/>
			<youi:fieldSelect property="nmIssuetempalate.issueTempalateId" caption="发布模板" 
				src="esb/web/nmIssuetempalateManager/getNmIssuetempalates.json" code="issueTempalateId" show="issueTempalateCaption" />
			<youi:fieldSelect property="policyStatus"  caption="发布状态" convert="policyStatus"/>
			<youi:fieldCalendar property="policyIssueDate"  caption="发布时间"/>
		</youi:fieldLayout>

		<youi:gridCol property="policyCaption"  caption="新闻名称" width="100" align="center"/>
		<youi:gridCol property="nmIssuetempalate.issueTempalateCaption"  caption="模板名称" width="100" align="center"/>
		<youi:gridCol property="policyType.issueTypeCaption"  caption="发布类型" width="100" align="center"/>
		<youi:gridCol property="policyCome"  caption="发布人" width="100" align="center"/>
		<youi:gridCol property="policyStatus"  caption="发布状态" width="100" align="center" convert="policyStatus"/>
		<youi:gridCol property="policyIssueDate"  caption="发布时间" width="100" align="center"/>
		<youi:gridCol property="browseCount"  caption="浏览次数" width="100" align="center"/>
		<youi:gridCol property="dingCount"  caption="顶的次数" width="100" align="center"/>
		<youi:gridCol property="caiCount"  caption="踩的次数" width="100" align="center"/>
		<youi:gridCol property="imageUrl"  caption="图片url" width="150" align="center"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-政策新闻内容编辑 -->
	<youi:form dialog="true" caption="园区新闻内容" id="form_nmIssuenews" 
			action="esb/web/nmIssuenewsManager/saveNmIssuenewss.json?code=0101" width="1100">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="120,120" >
			<youi:fieldHidden property="policyId"  caption="政策ID"/>
			<youi:fieldHidden property="policyType.issueTypeId"  caption="发布类型"/>
			<youi:fieldText property="policyCaption"  caption="新闻名称"  notNull="true"/>
			<youi:fieldSelect property="nmIssuetempalate.issueTempalateId" caption="发布模板" 
				src="esb/web/nmIssuetempalateManager/getNmIssuetempalates.json" code="issueTempalateId" show="issueTempalateCaption" />
			<youi:fieldText property="policyCome"  caption="发布人" notNull="true"/>
			<youi:fieldCalendar property="policyIssueDate"  caption="发布时间" notNull="true"/>
			
			<youi:fieldHidden property="browseCount"  caption="浏览次数" />
			<youi:fieldHidden property="dingCount"  caption="顶的次数"/>
			<youi:fieldHidden property="caiCount"  caption="踩的次数"/>
			<youi:fieldHidden property="policyStatus"  caption="发布状态"/>
			<youi:fieldSwfupload property="imageUrl" caption="图片URL" uploadUrl="/common/uploadImage.html" 
				fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="10240" />
			<youi:fieldCustom column="2" custom="fieldCkeditor" customOptions="{}" property="policyContent"  caption="新闻内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!-- 表单提交后刷新页面 -->
	<youi:func name = "form_nmIssuenews_afterSubmit">
			var formNmIssuenews = $elem('form_nmIssuenews',pageId);
			formNmIssuenews.form('close');
			$elem('grid_nmIssuenews',pageId).grid('pReload');
	</youi:func>
	
	<!--**********************************页面函数End**********************************-->
</youi:page>