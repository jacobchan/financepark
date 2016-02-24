<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgtempalate" idKeys="msgTempalateId" caption="消息模板列表"  panel="false"
				src="esb/web/mcMsgtempalateManager/getPagerMcMsgtempalates.json" dataFormId="form_mcMsgtempalate"
				editSrc="esb/web/mcMsgtempalateManager/getMcMsgtempalate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgtempalateManager/removeMcMsgtempalate.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<youi:fieldText property="msgTempalateCaption"  caption="消息模板标题"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="msgTempalateCaption"  caption="消息模板标题" width="150"/>
		<youi:gridCol property="msgTempalateContent"  caption="模板内容" width="350"/>
		<youi:gridCol property="msgTempalateParams"  caption="模板参数(个)" width="150"/>
		<youi:gridCol property="msgReceiver"  caption="接收对象" width="150"/>
		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息模板编辑 -->
	<youi:form dialog="true" caption="消息模板" id="form_mcMsgtempalate" action="esb/web/mcMsgtempalateManager/saveMcMsgtempalate.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="msgTempalateId"  caption="消息模板ID"/>
			<youi:fieldText property="msgTempalateCaption"  caption="消息模板标题"/>
			<youi:fieldSelect property="mcMsgtype.msgTypeId" caption="消息类型"
				src="esb/web/mcMsgtypeManager/getMcMsgtypes.json" show="msgTypeCaption" code="msgTypeId"/>
			<youi:fieldArea property="msgTempalateContent"  caption="模板内容" rows="3" column="2"/>
			<youi:fieldSelect property="msgReceiver"  caption="接收对象"
				src="esb/web/roleManager/getPagerRoles.json" code="roleId" show="roleCaption"/>
			<youi:fieldText property="msgTempalateParams"  caption="模板参数(个)" readonly="true"/>
		</youi:fieldLayout>
		
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->

	<youi:func name="init">
		var areaEle =  $elem("record_msgTempalateContent",pageId);
		areaEle.find('textarea').bind('blur',function(){
			var areaVal = areaEle.fieldValue();
			var count = check(areaVal);
			$elem("record_msgTempalateParams",pageId).fieldValue(count);
		});

		function check(val){
			if(val!=''){
				 var reg = new RegExp('@',"gi");
				return val.match(reg).length;
			}else{
				return 0;
			}
		}
	</youi:func>
	
	<!--**********************************页面函数End**********************************-->
</youi:page>