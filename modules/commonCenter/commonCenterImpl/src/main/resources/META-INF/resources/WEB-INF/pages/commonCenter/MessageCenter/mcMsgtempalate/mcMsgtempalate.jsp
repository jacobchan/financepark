<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_mcMsgtempalate" idKeys="msgTempalateId" caption="消息模板列表"  panel="false"
				src="esb/web/mcMsgtempalateManager/getPagerMcMsgtempalates.json" dataFormId="form_mcMsgtempalate"
				editSrc="esb/web/mcMsgtempalateManager/getMcMsgtempalate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/mcMsgtempalateManager/removeMcMsgtempalate.json">
		<youi:fieldLayout columns="2" labelWidths="100,100">
			<youi:fieldText property="msgTempalateCaption"  caption="消息模板标题" operator="LIKE"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="uniqueCode"  caption="唯一码" width="15%" align="center"/>
		<youi:gridCol property="mcMsgtype.msgTypeCaption"  caption="模板类型" width="15%" align="center"/>
		<youi:gridCol property="msgTempalateCaption"  caption="消息模板标题" width="15%" align="center"/>
		<youi:gridCol property="msgTempalateContent"  caption="模板内容" width="40%"/>
		<youi:gridCol property="msgReceiver"  caption="接收对象" width="15%" align="center"/>
		
		<youi:gridCol width="80" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-消息模板编辑 -->
	<youi:form dialog="true" caption="消息模板" id="form_mcMsgtempalate" action="esb/web/mcMsgtempalateManager/saveMcMsgtempalate.json">
		<youi:fieldLayout prefix="record" columns="2" labelWidths="100,100">
			<youi:fieldHidden property="msgTempalateId"  caption="消息模板ID"/>
			<youi:fieldText property="uniqueCode" caption="模板唯一码" notNull="true"/>
			<youi:fieldText property="msgTempalateCaption"  caption="消息模板标题" notNull="true"/>
			<youi:fieldSelect property="mcMsgtype.msgTypeId" caption="消息类型" notNull="true"
				src="esb/web/mcMsgtypeManager/getMcMsgtypes.json" show="msgTypeCaption" code="msgTypeId"/>
			<youi:fieldSelect property="msgReceiver"  caption="接收对象"	notNull="true"
				src="esb/web/roleManager/getPagerRoles.json" code="roleId" show="roleCaption"/>
			<youi:fieldArea property="msgTempalateContent"  caption="模板内容" rows="3" column="2" notNull="true"/>
			<youi:fieldHidden property="msgTempalateParams"  caption="模板参数(个)"/>
		</youi:fieldLayout>
		
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->

	<youi:func name="init">
		var areaEle =  $elem("record_msgTempalateContent",pageId);
		areaEle.find('textarea').bind('blur',function(){
			var areaVal = areaEle.fieldValue();
		//	var count = check(areaVal);
			var count = 0;
			$.youi.ajaxUtil.ajax({
				url:'esb/web/mcMsgtempalateManager/getParamCount.json',
				data:'content='+areaVal,
				async: false,
				success:function(result){
					if(result)
						count = result.record.html;
				}
			});
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