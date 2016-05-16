<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssuetype" idKeys="issueTypeId" caption="发布类型列表"  panel="false" pageSize="8" height="360"
				src="esb/web/nmIssuetypeManager/getPagerNmIssuetypesByCode.json?code=01" dataFormId="form_nmIssuetype"
				editSrc="esb/web/nmIssuetypeManager/getNmIssuetype.json" showCheckbox="true"
				removeSrc="esb/web/nmIssuetypeManager/removeNmIssuetype.json">
		<youi:fieldLayout prefix="search" columns="2" labelWidths="100,100">
			<youi:fieldText property="issueTypeCaption"  caption="发布类型描述" operator="LIKE"/>
			<youi:fieldText property="issueTypeCode"  caption="发布类型编码" operator="LIKE"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="issueTypeParentCaption"  caption="发布类型上级" width="40%" align="center"/>
		<youi:gridCol property="issueTypeCaption"  caption="发布类型描述" width="40%" align="center"/>
		<youi:gridCol property="issueTypeCode"  caption="发布类型编码" width="20%" align="center"/>
	</youi:grid>
	
	<!-- form-发布类型编辑 -->
	<youi:form dialog="true" caption="发布类型" id="form_nmIssuetype" action="esb/web/nmIssuetypeManager/saveNmIssuetypes.json?code=01">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="150px,150px">
			<youi:fieldText property="issueTypeCaption"  caption="发布类型描述" notNull="true"/>
			<youi:fieldText property="issueTypeCode"  caption="发布类型编码" notNull="true" validateSrc="esb/web/nmIssuetypeManager/codeExist.json"/>
			<youi:fieldHidden property="issueTypeId"  caption="发布类型ID"/>
			<youi:fieldHidden property="parentIssueTypeId" caption="上级发布类型"/>
			<youi:fieldHidden property="leaf" defaultValue="1" caption="是否子节点"/>
			<youi:fieldHidden property="issueTypeStatus"  caption="发布类型状态" defaultValue="1"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>