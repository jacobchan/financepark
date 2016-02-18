<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<div class="content">
	</div>
	
	<youi:func name="subpage_init" params="result">
	$('.content').html(result.html);
	</youi:func>
</youi:page>