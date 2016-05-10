<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	

		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="taskId"  caption="ID"/>
			<youi:fieldHidden property="processDefinitionId" caption="processDefinitionId"/>
			<youi:fieldText property="name" caption="订单名称"/>
			<youi:fieldText property="status" caption="操作" defaultValue="04"/>
			<youi:fieldText property="content" caption="订单内容" column="2"/>
			<youi:fieldText property="describe" caption="订单内容" column="2"/>
			
			<!-- 分派处理 -->
		</youi:fieldLayout>
	
	<!--**********************************页面函数Start********************************-->

	<!--**********************************页面函数End**********************************-->
</youi:page>