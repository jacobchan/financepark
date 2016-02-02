<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_lettermanagerLetter" idKeys="letterId" caption="私信列表"  panel="false"
				src="esb/web/lettermanagerLetterManager/getPagerLettermanagerLetters.json" dataFormId="form_lettermanagerLetter"
				editSrc="esb/web/lettermanagerLetterManager/getLettermanagerLetter.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/lettermanagerLetterManager/removeLettermanagerLetter.json">
		<youi:fieldLayout>
			<youi:fieldText property="letterContent"  caption="私信内容"/>

			<youi:fieldText property="letterTime"  caption="私信发送时间"/>
			<youi:fieldText property="letterEnterpriseId"  caption="企业信息ID"/>
			<youi:fieldText property="letterRecipientId"  caption="接收人ID"/>
			<youi:fieldText property="rzId"  caption="ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="letterContent"  caption="私信内容"/>

		<youi:gridCol property="letterTime"  caption="私信发送时间"/>
		<youi:gridCol property="letterEnterpriseId"  caption="企业信息ID"/>
		<youi:gridCol property="letterRecipientId"  caption="接收人ID"/>
		<youi:gridCol property="rzId"  caption="ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-私信编辑 -->
	<youi:form dialog="true" caption="私信" id="form_lettermanagerLetter" action="esb/web/lettermanagerLetterManager/saveLettermanagerLetter.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="letterContent"  caption="私信内容"/>
			<youi:fieldText property="letterId"  caption="私信ID"/>
			<youi:fieldText property="letterTime"  caption="私信发送时间"/>
			<youi:fieldText property="letterEnterpriseId"  caption="企业信息ID"/>
			<youi:fieldText property="letterRecipientId"  caption="接收人ID"/>
			<youi:fieldText property="rzId"  caption="ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>