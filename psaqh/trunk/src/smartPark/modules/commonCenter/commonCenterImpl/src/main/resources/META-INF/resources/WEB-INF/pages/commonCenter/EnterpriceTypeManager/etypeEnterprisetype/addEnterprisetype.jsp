<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout labelWidths="120,120" prefix="subType">
		<youi:fieldTree simple="false" popup="true" tree="${enetrTree}" property="etypeEnterprisetype.enTypeId" caption="上级类型"/>
		<youi:fieldText property="enTypeName"  caption="行业类型名称" notNull="true"/>
	</youi:fieldLayout>
</youi:page>