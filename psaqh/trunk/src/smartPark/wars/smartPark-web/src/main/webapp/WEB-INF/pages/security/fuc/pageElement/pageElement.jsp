<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<!-- grid-页面元素列表-->
	<youi:grid id="grid_pageElement" idKeys="pageElementId" caption="页面元素列表" 
				src="/fuc/pageElement/getPagerPageElements.json"  dataFormId="form_pageElement"
				editSrc="/fuc/pageElement/getPageElement.json"
				removeSrc="/fuc/pageElement/removePageElement.json">
		<youi:fieldLayout>
			<youi:fieldText property="pageElementName"  caption="页面元素名"></youi:fieldText>
			<youi:fieldText property="pageElementCaption"  caption="页面元素描述"></youi:fieldText>

		</youi:fieldLayout>
		
		<youi:gridCol property="pageElementName"  caption="页面元素名"/>
		<youi:gridCol property="pageElementCaption"  caption="页面元素描述"/>

	</youi:grid>
	
	<!-- form-页面元素编辑 -->
	<youi:form dialog="true" caption="编辑页面元素" id="form_pageElement" action="/fuc/pageElement/savePageElement.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="pageElementName"  caption="页面元素名"/>
			<youi:fieldText property="pageElementCaption"  caption="页面元素描述"/>
			<youi:fieldText property="pageElementId"  caption="页面元素ID"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>