<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgtype" idKeys="msgTypeId" caption="消息类型列表"  panel="false"
				src="esb/web/mcMsgtypeManager/getPagerMcMsgtypes.json" dataFormId="form_mcMsgtype"
				editSrc="esb/web/mcMsgtypeManager/getMcMsgtype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgtypeManager/removeMcMsgtype.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldText property="msgTypeCaption"  caption="消息类型名称"/>
			<youi:fieldText property="msgTypeParent"  caption="消息类型上级"/>
		</youi:fieldLayout>
		<youi:gridCol property="msgTypeCaption"  caption="消息类型名称" width="30%"/>
		<youi:gridCol property="parentTypeCaption"  caption="消息类型上级" width="30%"/>
		<youi:gridCol property="msgTypeStatus"  caption="消息类型状态" width="30%"/>

		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息类型编辑 -->
	<youi:form dialog="true" caption="消息类型" id="form_mcMsgtype" action="esb/web/mcMsgtypeManager/saveMcMsgtype.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="msgTypeId"  caption="消息类型ID"/>
			<youi:fieldText property="msgTypeCaption"  caption="消息类型名称"/>
			<%-- <youi:fieldText property="msgTypeParent"  caption="消息类型上级"/> --%>
			<youi:fieldSelect property="msgTypeParent" caption="消息类型上级"
				src="esb/web/mcMsgtypeManager/getMcMsgtypes.json" show="msgTypeCaption" code="msgTypeId"/>
			<youi:fieldText property="msgTypeStatus"  caption="消息类型状态"/>
			<youi:fieldLabel convert="booleanConvert" width="502" property="isLeaf" defaultValue="1" caption="是否子节点"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>