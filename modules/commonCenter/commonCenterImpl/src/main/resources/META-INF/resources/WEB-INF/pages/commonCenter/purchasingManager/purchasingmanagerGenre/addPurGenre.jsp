<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout labelWidths="120,120" prefix="subGenre">
		<youi:fieldTree simple="false" popup="true" tree="${genreTree}" property="pagrenId" caption="上级类别"/>
		<%-- <youi:fieldSelect property="parkBusinessTupe" convert="businessType"  caption="园区商业类型"/> --%>
		<youi:fieldText property="genreName"  caption="商业类别名称" notNull="true"/>
	</youi:fieldLayout>
	<!--**********************************页面函数********************************-->
	<!--**********************************页面函数********************************-->
</youi:page>

