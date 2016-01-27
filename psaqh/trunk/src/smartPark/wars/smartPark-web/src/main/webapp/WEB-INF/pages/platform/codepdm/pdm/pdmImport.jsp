<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout columns="1">
		<youi:fieldSelect property="projectId" caption="项目" notNull="true" src="esb/web/codeProjectManager/getCodeProjects.json" code="projectId" show="projectCaption"/>
		<youi:fieldText property="tablePrefix" caption="表前缀" defaultValue="youi"/>
		<youi:fieldSwfupload property="uploads" fileTypes="pdm" caption="PDM文件" height="210"/>
	</youi:fieldLayout>
</youi:page>