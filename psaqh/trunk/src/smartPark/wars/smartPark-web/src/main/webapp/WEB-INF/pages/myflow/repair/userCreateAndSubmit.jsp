<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:html>
	<!-- form-物业报修 -->
		<youi:form  caption="物业报修" id="form_repair" idKeys="id" action="workflow/run/start.json" submit="提交申请">
		<youi:button caption="暂存申请" name="do_Cancel" active="1" ></youi:button>
		<youi:fieldLayout prefix="record"  labelWidths="150,0" columns="1"  showTooltips="true">
			<youi:fieldText property="bxComp" defaultValue="中粮集团"></youi:fieldText>
			<youi:fieldText property="bxType" defaultValue="00"></youi:fieldText>
			<youi:fieldText property="bxRemark" defaultValue="432114"></youi:fieldText>
			<youi:fieldText property="bxAddress" defaultValue="中粮集团12421"></youi:fieldText>
			<youi:fieldText property="bxFujian" defaultValue=""></youi:fieldText>
			<youi:fieldText property="processDefinitionId"  defaultValue="repair"/>
		</youi:fieldLayout>
		<br/>
	</youi:form>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->

	<youi:func name = "form_repair_afterSubmit">
		alert('保存成功!');
	</youi:func>


	<!--**********************************页面函数********************************-->
</youi:html>