<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>

	<youi:grid id="grid_nmIssuenews" idKeys="policyId" caption="政策新闻内容列表"  panel="false"
				src="esb/web/nmIssuenewsManager/getPagerNmIssuenewss.json" dataFormId="form_nmIssuenews" 
				editSrc="esb/web/nmIssuenewsManager/getNmIssuenews.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuenewsManager/removeNmIssuenews.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<%-- <youi:fieldTree property="parentIssueTypeId" caption="上级发布类型" tree="${typeTree}" simple="false"/> --%>
			
			<youi:fieldText property="policyCaption"  caption="政策名称" operator="LIKE"/>
			<youi:fieldTree property="policyType.issueTypeId" caption="发布类型" tree="${typeTree}" simple="false"/>
			<%-- <youi:fieldSelect property="policyType.issueTypeId" caption="发布类型" 
				src="esb/web/nmIssuetypeManager/getNmIssuetypes.json" code="issueTypeId" show="issueTypeCaption"/> --%>
			<youi:fieldSelect property="nmIssuetempalate.issueTempalateId" caption="发布模板" 
				src="esb/web/nmIssuetempalateManager/getNmIssuetempalates.json" code="issueTempalateId" show="issueTempalateCaption" />
			<youi:fieldSelect property="policyStatus"  caption="政策发布状态" convert="policyStatus"/>
			<youi:fieldCalendar property="policyIssueDate"  caption="政策发布时间"/>
		</youi:fieldLayout>

		<youi:gridCol property="policyCaption"  caption="政策名称" width="100" align="center"/>
		<youi:gridCol property="nmIssuetempalate.issueTempalateCaption"  caption="政策名称" width="100" align="center"/>
		<youi:gridCol property="policyType.issueTypeCaption"  caption="发布类型" width="100" align="center"/>
		<youi:gridCol property="policyCome"  caption="政策发布人" width="100" align="center"/>
		<youi:gridCol property="policyStatus"  caption="政策发布状态" width="100" align="center" convert="policyStatus"/>
		<youi:gridCol property="policyIssueDate"  caption="政策发布时间" width="100" align="center"/>
		<youi:gridCol property="policyContent"  caption="政策内容" width="150" align="center"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-政策新闻内容编辑 -->
	<youi:form dialog="true" caption="政策新闻内容" id="form_nmIssuenews" 
			action="esb/web/nmIssuenewsManager/saveNmIssuenews.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="120,120">
			<youi:fieldHidden property="policyId"  caption="政策ID"/>
			<youi:fieldText property="policyCaption"  caption="政策名称"  notNull="true"/>
			<%-- <youi:fieldSelect property="policyType.issueTypeId" caption="发布类型" notNull="true"
				src="esb/web/nmIssuetypeManager/getNmIssuetypes.json" code="issueTypeId" show="issueTypeCaption"/> --%>
			<youi:fieldTree property="policyType.issueTypeId" caption="发布类型" tree="${typeTree}" simple="false" notNull="true"/>
			<youi:fieldSelect property="nmIssuetempalate.issueTempalateId" caption="发布模板" 
				src="esb/web/nmIssuetempalateManager/getNmIssuetempalates.json" code="issueTempalateId" show="issueTempalateCaption" />
			<youi:fieldSelect property="policyStatus"  caption="政策发布状态" convert="policyStatus" notNull="true"/>
			<youi:fieldText property="policyCome"  caption="政策发布人"/>
			<youi:fieldCalendar property="policyIssueDate"  caption="政策发布时间" notNull="true"/>
			<youi:fieldArea property="policyContent"  caption="政策内容" column="2" rows="4" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="init">
		var formEle = $elem('form_nmIssuenews',pageId);
		
		$elem('record_tempalateParams',pageId).children(':first').keyup(function(){
		var tempalateParams = $elem('record_tempalateParams',pageId).fieldValue();
		var tempalateId = $elem('record_nmIssuetempalate_issueTempalateId',pageId).fieldValue();
		
		if(tempalateParams&&tempalateId){
			$.youi.ajaxUtil.ajax({
					url:'esb/web/nmIssuetempalateManager/genPolicyContent.json',
					data:'paramStr='+tempalateParams+'&nmIssuetempalateId='+tempalateId,
					success:function(result){
						$elem('record_policyContent',pageId).fieldValue(result.record.html);
					}
			});
		}
		});
	</youi:func>
	
	<!-- 表单提交后刷新页面 -->
	<youi:func name = "form_nmIssuenews_afterSubmit">
			var formNmIssuenews = $elem('form_nmIssuenews',pageId);
			formNmIssuenews.form('close');
			$elem('grid_nmIssuenews',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>