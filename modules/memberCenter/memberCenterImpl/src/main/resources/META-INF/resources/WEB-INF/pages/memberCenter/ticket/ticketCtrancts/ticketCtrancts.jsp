<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ticketCtrancts" idKeys="recId" caption="340504机票联系人关系列表"  panel="false"
				src="esb/web/ticketCtranctsManager/getPagerTicketCtranctss.json" dataFormId="form_ticketCtrancts"
				editSrc="esb/web/ticketCtranctsManager/getTicketCtrancts.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ticketCtranctsManager/removeTicketCtrancts.json">
		<youi:fieldLayout>
			<youi:fieldText property="contractsId"  caption="联系人ID"/>

		</youi:fieldLayout>
		<youi:gridCol property="contractsId"  caption="联系人ID"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-340504机票联系人关系编辑 -->
	<youi:form dialog="true" caption="340504机票联系人关系" id="form_ticketCtrancts" action="esb/web/ticketCtranctsManager/saveTicketCtrancts.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="contractsId"  caption="联系人ID"/>
			<youi:fieldText property="recId"  caption="REC_ID_"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>