<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html>
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
	</head>
	
	
	<body>
		<youi:fieldLayout id="form" styleClass="form-record hide">
			<youi:fieldText caption="" property="formId"></youi:fieldText>
			<textarea><%=request.getParameter("content")%></textarea>
		</youi:fieldLayout>
		
		<div id="page_container">
			
		</div>
	</body>
	
	
	<youi:func name="init">
		var record = {
			formId : $('.form-record #field_formId  input.value')[0].getAttribute('value'),
			content : $('.form-record textarea').text(),
		};
		if(record.formId){
			var pageUrl = '/form/run/'+record.formId+'.html?page:pageId=run';
			$.youi.pageUtils.loadPage($('#page_container'),pageUrl,null,record);
		}
	</youi:func>
</youi:html>

