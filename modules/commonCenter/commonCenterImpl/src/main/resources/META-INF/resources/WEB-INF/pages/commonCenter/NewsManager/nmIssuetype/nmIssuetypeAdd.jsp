<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout labelWidths="120,120" prefix="subOrderType">
		<youi:fieldTree simple="false" popup="true" tree="${issueTypeTree}" property="parentIssueTypeId" caption="发布类型上级"/>
		<youi:fieldText property="issueTypeCaption" caption="发布类型描述" notNull="true"/>
		<youi:fieldText property="issueTypeCode" caption="发布类型编码" notNull="true"/>
	</youi:fieldLayout>
	<!--**********************************页面函数********************************-->
	<!--**********************************页面函数********************************-->
</youi:page>

