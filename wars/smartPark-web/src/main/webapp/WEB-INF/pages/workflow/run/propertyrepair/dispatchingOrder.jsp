<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="taskId"  caption="ID"/>
			<youi:fieldHidden property="flowProcessId"  caption="工作流ID" defaultValue="propertyrepair"/>
			<youi:fieldHidden property="bxRemark" caption="报修描述"/>
			<youi:fieldHidden property="bxAddress" caption="报修地址"/>
			<youi:fieldArea property="bxRemark_show"  caption="报修描述" rows="2"   column="2" readonly="true"/>
			<youi:fieldArea property="bxAddress_show"  caption="报修地址" rows="2"   column="2" readonly="true"/>
			<youi:fieldSelect property="flowResultPg"  caption="是否派工" convert="bool" notNull="true"/>
			<youi:fieldArea property="flowSuggestPg"  caption="派工备注" rows="2"   column="2" />
			<youi:fieldSelect property="flowPersonId" caption="接单人" src="esb/web/reservationRecordManager/getRoleRepairer.json" code="loginValue" show="loginName"/>
			<youi:fieldHidden property="bxStatus"  caption="报修状态" defaultValue="02"/>
		</youi:fieldLayout>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="subpage_beforeSubmit">
		var flowResultPg = $elem('record_flowResultPg',pageId).fieldValue();
		var flowSuggestPg = $elem('record_flowSuggestPg',pageId).fieldValue();
		if('1' == flowResultPg){
			if(flowSuggestPg == ""){
				alert("请填写备注!");
				return false; 
			}
		}
		return true;
	</youi:func>
	<youi:func name="record_flowResultPg_change">
		var flowResultPg = $elem('record_flowResultPg',pageId).fieldValue();
		if('1' == flowResultPg){
			 $elem('record_bxStatus',pageId).fieldValue("99");
		}else{
			 $elem('record_bxStatus',pageId).fieldValue("02");
		}
	</youi:func>
	<youi:func name="subpage_init">
		var bxAddress = $elem('record_bxAddress',pageId).fieldValue();
		$elem('record_bxAddress_show',pageId).fieldValue(bxAddress);
		var bxRemark = $elem('record_bxRemark',pageId).fieldValue();
		$elem('record_bxRemark_show',pageId).fieldValue(bxRemark);
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>