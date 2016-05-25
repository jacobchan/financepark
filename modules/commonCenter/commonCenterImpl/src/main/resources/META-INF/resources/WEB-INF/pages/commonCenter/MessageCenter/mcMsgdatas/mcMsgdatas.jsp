<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgdatas" idKeys="msgId" caption="消息列表列表"  panel="false"
				src="esb/web/mcMsgdatasManager/getPagerMcMsgdatass.json" dataFormId="form_mcMsgdatas" add="NOT"
				editSrc="esb/web/mcMsgdatasManager/getMcMsgdatas.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgdatasManager/removeMcMsgdatas.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldTree property="msgType" caption="消息类型" tree="${typeTree}" simple="false"/>
			<youi:fieldText property="msgCaption"  caption="消息主题" operator="LIKE"/>
		</youi:fieldLayout>

		<youi:gridCol property="msgCaption"  caption="消息主题" width="15%" align="center"/>
		<youi:gridCol property="msgContent"  caption="消息内容" width="40%"/>
		<youi:gridCol property="receive"  caption="接收人" width="15%" align="center"/>
		<youi:gridCol property="sendDate"  caption="发送时间" width="15%" align="center"/>
		<youi:gridCol property="sendStatus"  caption="发送状态" width="15%" align="center" convert="msgSendStatus"/>
		<youi:gridCol property="readStatus"  caption="阅读状态" width="15%" align="center"/>
		
		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改" icon="search"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息列表编辑 -->
	<youi:form dialog="true" caption="消息列表" id="form_mcMsgdatas" action="esb/web/mcMsgdatasManager/saveMcMsgdatas.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="msgId"  caption="消息ID"/>
			<youi:fieldText property="msgCaption"  caption="消息主题" column="2" readonly="true"/>
			<youi:fieldArea property="msgContent"  caption="消息内容" column="2" rows="3" readonly="true"/>
			<youi:fieldSelect property="mcMsgtempalate.msgTempalateId" caption="消息模板" readonly="true"
				src="esb/web/mcMsgtempalateManager/getMcMsgtempalates.json" code="msgTempalateId" show="msgTempalateCaption"/>
			<youi:fieldText property="sendDate"  caption="发送时间"  readonly="true"/>
			<youi:fieldText property="sendStatus"  caption="发送状态" readonly="true"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>