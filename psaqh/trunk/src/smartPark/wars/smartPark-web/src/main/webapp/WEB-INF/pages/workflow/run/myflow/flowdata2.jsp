<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldText property="processDefinitionId" caption="processDefinitionId"/>
			<youi:fieldText property="taskId"  caption="taskId"/>
			<youi:fieldText property="name" caption="名称"/>
			<youi:fieldText property="status" caption="状态"/>
		</youi:fieldLayout>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="subpage_init">
//		alert("open2");
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>