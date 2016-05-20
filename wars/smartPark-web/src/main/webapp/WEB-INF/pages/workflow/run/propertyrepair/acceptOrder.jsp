<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:page>	

		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="taskId"  caption="ID"/>
			<youi:fieldHidden property="bxRemark" caption="报修描述"/>
			<youi:fieldHidden property="bxAddress" caption="报修地址"/>
			<youi:fieldHidden property="flowSuggestPg" caption="派工备注"/>
			<youi:fieldArea property="bxRemark_show"  caption="报修描述" rows="2"   column="2" readonly="true"/>
			<youi:fieldArea property="bxAddress_show"  caption="报修地址" rows="2"   column="2" readonly="true"/>
			<youi:fieldArea property="flowSuggestPg_show"  caption="派工备注" rows="2"   column="2" readonly="true"/>
			<youi:fieldSelect property="flowResultJg"  caption="是否接单" convert="bool" notNull="true"/>
			<youi:fieldArea property="flowSuggestJg"  caption="备注" rows="2"   column="2" />
			<youi:fieldHidden property="bxStatus"  caption="报修状态" defaultValue="03"/>
		</youi:fieldLayout>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="record_flowResultJg_change">
		var flowResultJg = $elem('record_flowResultJg',pageId).fieldValue();
		if('1' == flowResultJg){
			 $elem('record_bxStatus',pageId).fieldValue("00");
		}else{
			 $elem('record_bxStatus',pageId).fieldValue("03");
		}
	</youi:func>
	<youi:func name="subpage_beforeSubmit">
		var flowResultJg = $elem('record_flowResultJg',pageId).fieldValue();
		var flowSuggestJg = $elem('record_flowSuggestJg',pageId).fieldValue();
		if('1' == flowResultJg){
			if(flowSuggestJg == ""){
				alert("请填写备注!");
				return false; 
			}
		}
		return true;
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