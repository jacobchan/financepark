<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<youi:subpage src="/page/youi.form/designer.html" subpageId="formdesigner" type="window" caption=""></youi:subpage>
	
	<youi:func name="init">
		$elem('subpage_formdesigner',pageId).subpage('open');
	</youi:func>
</youi:page>