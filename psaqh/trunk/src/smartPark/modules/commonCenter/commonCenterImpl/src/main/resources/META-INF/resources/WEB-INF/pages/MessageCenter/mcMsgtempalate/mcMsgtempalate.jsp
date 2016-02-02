<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgtempalate" idKeys="msgTempalateId" caption="消息模板列表"  panel="false"
				src="esb/web/mcMsgtempalateManager/getPagerMcMsgtempalates.json" dataFormId="form_mcMsgtempalate"
				editSrc="esb/web/mcMsgtempalateManager/getMcMsgtempalate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgtempalateManager/removeMcMsgtempalate.json">
		<youi:fieldLayout>

			<youi:fieldText property="msgTempalateCaption"  caption="消息模板标题"/>
			<youi:fieldText property="msgReceivetype"  caption="接收人类型"/>
			<youi:fieldText property="msgTempalateContent"  caption="模板内容"/>
			<youi:fieldText property="msgReceiver"  caption="接收人"/>
			<youi:fieldText property="msgTempuse"  caption="模板使用状态"/>
			<youi:fieldText property="msgTempalateParams"  caption="模板参数"/>
		</youi:fieldLayout>

		<youi:gridCol property="msgTempalateCaption"  caption="消息模板标题"/>
		<youi:gridCol property="msgReceivetype"  caption="接收人类型"/>
		<youi:gridCol property="msgTempalateContent"  caption="模板内容"/>
		<youi:gridCol property="msgReceiver"  caption="接收人"/>
		<youi:gridCol property="msgTempuse"  caption="模板使用状态"/>
		<youi:gridCol property="msgTempalateParams"  caption="模板参数"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息模板编辑 -->
	<youi:form dialog="true" caption="消息模板" id="form_mcMsgtempalate" action="esb/web/mcMsgtempalateManager/saveMcMsgtempalate.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="msgTempalateId"  caption="消息模板ID"/>
			<youi:fieldText property="msgTempalateCaption"  caption="消息模板标题"/>
			<youi:fieldText property="msgReceivetype"  caption="接收人类型"/>
			<youi:fieldText property="msgTempalateContent"  caption="模板内容"/>
			<youi:fieldText property="msgReceiver"  caption="接收人"/>
			<youi:fieldText property="msgTempuse"  caption="模板使用状态"/>
			<youi:fieldText property="msgTempalateParams"  caption="模板参数"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>