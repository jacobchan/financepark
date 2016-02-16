<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html>
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
	</head>
	
	<youi:body decorator="cms">
		<youi:fieldLayout>
			<youi:fieldSelect property="boolean" caption="boolean" convert="boolean"></youi:fieldSelect>
		</youi:fieldLayout>
	</youi:body>
	
</youi:html>