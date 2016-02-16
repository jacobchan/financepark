<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>
	<youi:style href="styles/3.0/youi/youi.reportviewer.css?1=1"></youi:style>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容cubetest********************************-->
	<youi:reportviewer reportFinderUrl="esb/report"
		reportTitle="用户统计报表" reportName="user_stats">
		<youi:fieldLayout>
			<youi:fieldText notNull="true" property="userActive" caption="用户状态"/>
		</youi:fieldLayout>
	</youi:reportviewer>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->

	<!--**********************************页面函数********************************-->
</youi:page>