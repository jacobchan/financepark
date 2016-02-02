<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgdatas" idKeys="msgId" caption="消息列表列表"  panel="false"
				src="esb/web/mcMsgdatasManager/getPagerMcMsgdatass.json" dataFormId="form_mcMsgdatas"
				editSrc="esb/web/mcMsgdatasManager/getMcMsgdatas.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgdatasManager/removeMcMsgdatas.json">
		<youi:fieldLayout>

			<youi:fieldText property="msgType"  caption="消息类型"/>
			<youi:fieldText property="sendStatus"  caption="发送状态"/>
			<youi:fieldText property="receive"  caption="接收人"/>
			<youi:fieldText property="msgContent"  caption="消息内容"/>
			<youi:fieldText property="sendDate"  caption="发送时间"/>
			<youi:fieldText property="msgCaption"  caption="消息主题"/>
		</youi:fieldLayout>

		<youi:gridCol property="msgType"  caption="消息类型"/>
		<youi:gridCol property="sendStatus"  caption="发送状态"/>
		<youi:gridCol property="receive"  caption="接收人"/>
		<youi:gridCol property="msgContent"  caption="消息内容"/>
		<youi:gridCol property="sendDate"  caption="发送时间"/>
		<youi:gridCol property="msgCaption"  caption="消息主题"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息列表编辑 -->
	<youi:form dialog="true" caption="消息列表" id="form_mcMsgdatas" action="esb/web/mcMsgdatasManager/saveMcMsgdatas.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="msgId"  caption="消息ID"/>
			<youi:fieldText property="msgType"  caption="消息类型"/>
			<youi:fieldText property="sendStatus"  caption="发送状态"/>
			<youi:fieldText property="receive"  caption="接收人"/>
			<youi:fieldText property="msgContent"  caption="消息内容"/>
			<youi:fieldText property="sendDate"  caption="发送时间"/>
			<youi:fieldText property="msgCaption"  caption="消息主题"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>