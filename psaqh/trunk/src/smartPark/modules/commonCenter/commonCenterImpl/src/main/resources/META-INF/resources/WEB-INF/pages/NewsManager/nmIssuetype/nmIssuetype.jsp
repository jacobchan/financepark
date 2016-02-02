<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_nmIssuetype" idKeys="issueTypeId" caption="发布类型列表"  panel="false"
				src="esb/web/nmIssuetypeManager/getPagerNmIssuetypes.json" dataFormId="form_nmIssuetype"
				editSrc="esb/web/nmIssuetypeManager/getNmIssuetype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/nmIssuetypeManager/removeNmIssuetype.json">
		<youi:fieldLayout>
			<youi:fieldText property="isLeaf"  caption="是否子节点"/>
			<youi:fieldText property="issueParentType"  caption="发布类型上级"/>
			<youi:fieldText property="issueTypeCaption"  caption="发布类型描述"/>
			<youi:fieldText property="issueTypeStatus"  caption="发布类型状态"/>

		</youi:fieldLayout>
		<youi:gridCol property="isLeaf"  caption="是否子节点"/>
		<youi:gridCol property="issueParentType"  caption="发布类型上级"/>
		<youi:gridCol property="issueTypeCaption"  caption="发布类型描述"/>
		<youi:gridCol property="issueTypeStatus"  caption="发布类型状态"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-发布类型编辑 -->
	<youi:form dialog="true" caption="发布类型" id="form_nmIssuetype" action="esb/web/nmIssuetypeManager/saveNmIssuetype.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="isLeaf"  caption="是否子节点"/>
			<youi:fieldText property="issueParentType"  caption="发布类型上级"/>
			<youi:fieldText property="issueTypeCaption"  caption="发布类型描述"/>
			<youi:fieldText property="issueTypeStatus"  caption="发布类型状态"/>
			<youi:fieldText property="issueTypeId"  caption="发布类型ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>