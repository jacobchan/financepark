<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	

		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="id"  caption="ID"/>
			<youi:fieldText property="processDefinitionId" caption="processDefinitionId"/>
			<youi:fieldText property="taskId" caption="taskId"/>
			<youi:fieldText property="orderName" caption="订单名称"/>
			<youi:fieldText property="status" caption="状态" defaultValue="03" readonly="true"/>
			<youi:fieldText property="orderContent" caption="订单内容"/>
		</youi:fieldLayout>
	
	<!--**********************************页面函数Start********************************-->

	<!--**********************************页面函数End**********************************-->
</youi:page>