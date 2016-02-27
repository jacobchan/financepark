<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout labelWidths="120,120" prefix="subOrderType">
		<youi:fieldTree simple="false" popup="true" tree="${orderTypeTree}" property="purchasingmanagerGenre.genreId" caption="上级订单类型"/>
		<%-- <youi:fieldSelect property="parkBusinessTupe" convert="businessType"  caption="园区商业类型"/> --%>
		<youi:fieldText property="genreName" caption="订单类型名称" notNull="true"/>
		<youi:fieldText property="genreCode" caption="订单类型编码" notNull="true"/>
	</youi:fieldLayout>
	<!--**********************************页面函数********************************-->
	<!--**********************************页面函数********************************-->
</youi:page>

