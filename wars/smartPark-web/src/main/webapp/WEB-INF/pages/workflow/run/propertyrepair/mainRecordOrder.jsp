<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	

		<!-- 跳转费用清单页面 -->
	<youi:subpage
		src="page/manageCenter.PropertyServiceManager.propertyservicemanagerTs/addSer.html" 
		subpageId="addSer" height="500" caption="维修费用清单新增">
	</youi:subpage>
	<youi:form id="" submit="NOT" reset="NOT" panel="false">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="bxCode"  caption="报修编号"/>
			<youi:fieldHidden property="taskId"  caption="ID"/>
			<youi:fieldHidden property="bxRemark" caption="报修描述"/>
			<youi:fieldHidden property="bxAddress" caption="报修地址"/>
			<youi:fieldHidden property="flowSuggestPg" caption="派工备注"/>
			<youi:fieldArea property="bxRemark_show"  caption="报修描述" rows="2"   column="2" readonly="true"/>
			<youi:fieldArea property="bxAddress_show"  caption="报修地址" rows="2"   column="2" readonly="true"/>
			<youi:fieldArea property="flowSuggestPg_show"  caption="派工备注" rows="2"   column="2" readonly="true"/>
			<youi:fieldHidden property="bxStatus"  caption="报修状态" defaultValue="04"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
		<!-- 填报维修费用清单 -->
		<youi:func name="func_form_putfrom">
			var bxCode =  $elem('record_bxCode',pageId).fieldValue();
			var subpageElement = $elem('subpage_addSer',pageId);
			subpageElement.subpage('open',{bxCode:bxCode});
		</youi:func>
		<youi:func name="subpage_init">
		var bxAddress = $elem('record_bxAddress',pageId).fieldValue();
		$elem('record_bxAddress_show',pageId).fieldValue(bxAddress);
		var bxRemark = $elem('record_bxRemark',pageId).fieldValue();
		$elem('record_bxRemark_show',pageId).fieldValue(bxRemark);
		var flowSuggestPg = $elem('record_flowSuggestPg',pageId).fieldValue();
		$elem('record_flowSuggestPg_show',pageId).fieldValue(flowSuggestPg);
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>