<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgtype" idKeys="msgTypeId" caption="消息类型列表"  panel="false"
				src="esb/web/mcMsgtypeManager/getPagerMcMsgtypes.json" dataFormId="form_mcMsgtype"
				editSrc="esb/web/mcMsgtypeManager/getMcMsgtype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgtypeManager/removeMcMsgtype.json">
		<youi:fieldLayout>
			<youi:fieldText property="msgTypeStatus"  caption="消息类型状态"/>
			<youi:fieldText property="msgTypeCaption"  caption="消息类型名称"/>
			<youi:fieldText property="msgTypeParent"  caption="消息类型上级"/>
			<youi:fieldText property="isLeaf"  caption="是否子节点"/>

		</youi:fieldLayout>
		<youi:gridCol property="msgTypeStatus"  caption="消息类型状态"/>
		<youi:gridCol property="msgTypeCaption"  caption="消息类型名称"/>
		<youi:gridCol property="msgTypeParent"  caption="消息类型上级"/>
		<youi:gridCol property="isLeaf"  caption="是否子节点"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息类型编辑 -->
	<youi:form dialog="true" caption="消息类型" id="form_mcMsgtype" action="esb/web/mcMsgtypeManager/saveMcMsgtype.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="msgTypeStatus"  caption="消息类型状态"/>
			<youi:fieldText property="msgTypeCaption"  caption="消息类型名称"/>
			<youi:fieldText property="msgTypeParent"  caption="消息类型上级"/>
			<youi:fieldText property="isLeaf"  caption="是否子节点"/>
			<youi:fieldText property="msgTypeId"  caption="消息类型ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>