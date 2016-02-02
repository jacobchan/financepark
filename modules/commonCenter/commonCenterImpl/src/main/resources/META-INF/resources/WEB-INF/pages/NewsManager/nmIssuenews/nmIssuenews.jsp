<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssuenews" idKeys="policyId" caption="政策新闻内容列表"  panel="false"
				src="esb/web/nmIssuenewsManager/getPagerNmIssuenewss.json" dataFormId="form_nmIssuenews"
				editSrc="esb/web/nmIssuenewsManager/getNmIssuenews.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuenewsManager/removeNmIssuenews.json">
		<youi:fieldLayout>
			<youi:fieldText property="policyType"  caption="政策类别"/>
			<youi:fieldText property="policyCaption"  caption="政策名称"/>
			<youi:fieldText property="policyStatus"  caption="政策发布状态"/>

			<youi:fieldText property="policyCome"  caption="政策发布人"/>
			<youi:fieldText property="policyContent"  caption="政策内容"/>
			<youi:fieldText property="policyIssueDate"  caption="政策发布时间"/>
		</youi:fieldLayout>
		<youi:gridCol property="policyType"  caption="政策类别"/>
		<youi:gridCol property="policyCaption"  caption="政策名称"/>
		<youi:gridCol property="policyStatus"  caption="政策发布状态"/>

		<youi:gridCol property="policyCome"  caption="政策发布人"/>
		<youi:gridCol property="policyContent"  caption="政策内容"/>
		<youi:gridCol property="policyIssueDate"  caption="政策发布时间"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-政策新闻内容编辑 -->
	<youi:form dialog="true" caption="政策新闻内容" id="form_nmIssuenews" action="esb/web/nmIssuenewsManager/saveNmIssuenews.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="policyType"  caption="政策类别"/>
			<youi:fieldText property="policyCaption"  caption="政策名称"/>
			<youi:fieldText property="policyStatus"  caption="政策发布状态"/>
			<youi:fieldText property="policyId"  caption="政策ID"/>
			<youi:fieldText property="policyCome"  caption="政策发布人"/>
			<youi:fieldText property="policyContent"  caption="政策内容"/>
			<youi:fieldText property="policyIssueDate"  caption="政策发布时间"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>