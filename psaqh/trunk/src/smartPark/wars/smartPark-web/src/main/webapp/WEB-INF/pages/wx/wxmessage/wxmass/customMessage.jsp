<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<style>
		.send-msg{
			color:green;
		}
		.send-msg.sending{
			color:yellow;
		}
	</style>
	<youi:ajaxUrl name="sendCustomMessage" src="esb/weixinAdapter/wxHttpServices/sendCustomMessage.json"></youi:ajaxUrl>
	<youi:form id="form_customMessage" caption="说明：单个粉丝有值时优先单个发送，不填则可使用批量粉丝选择并群发。" 
		submit="群发链接消息"
		action="esb/weixinAdapter/wxHttpServices/sendCustomMessage.json">
		<youi:fieldLayout columns="1">
			<youi:fieldText notNull="true" property="title" caption="消息标题"></youi:fieldText>
			<youi:fieldText notNull="true" property="description" caption="消息描述"></youi:fieldText>
			<youi:fieldText notNull="true" property="url" caption="链接地址"></youi:fieldText>
			<youi:fieldText notNull="true" property="picurl" caption="图片地址"></youi:fieldText>
			<youi:fieldAutocomplete src="/wxMemberManager/findByNickNameTerm.json" 
				property="touser" code="openid" show="nickname" caption="单个粉丝" />
				
			<youi:fieldList property="openids"  caption="批量粉丝" height="280" code="openid" show="nickname">
				<youi:grid scrollHeight="182" id="grid_wxMember" usePager="true" pageSize="10" showCheckbox="true" ctrlCheck="false"
					showNum="true"
					idKeys="openid" src="/wxMemberManager/getPagerWxMembers.json">
					
					<youi:fieldLayout prefix="grid" columns="1">
						<youi:fieldText property="nickname" operator="LIKE" caption="粉丝名"/>
					</youi:fieldLayout>
					
					<youi:gridCol width="200" property="nickname"  caption="粉丝名"/>
					<youi:gridCol width="60" property="country"  caption="国家"/>
					<youi:gridCol width="60" property="province"  caption="省"/>
					<youi:gridCol width="60" property="city"  caption="城市"/>
				</youi:grid>
			</youi:fieldList>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数End**********************************-->
	
	<youi:func name="field_touser_change" params="value,text">
		//
	</youi:func>
	
	<youi:func name="form_customMessage_beforeSubmit" params="record" urls="sendCustomMessage">
		if(record&&record.openid){
			return true;//直接提交到后台
		}else if(record&&record.openids&&record.openids.length>0){//遍历选择的粉丝，依次发送
			var maxBatchCount = 1000;
			if(record.openids.length>maxBatchCount){
				$.youi.messageUtils.showMessage('一次最多选择'+maxBatchCount+'个粉丝.');
			}
			//批量发送
			var batchRecord = $.extend({},record,{openids:[]});
			var dialogId = 'dialog_msg_'+pageId;
			
			var dialogElem = $('#'+dialogId);
			if(dialogElem.length==0){
				dialogElem = $('<div style="height:300px;overflow-y:auto;" id="'+dialogId+'"></div>').appendTo($('body',document));
				dialogElem.dialog({
					width:508,
					title:'消息发送结果'
				});
			}
			
			dialogElem.empty();
			dialogElem.dialog('open').show();
			
			$(record.openids).each(function(index){
				dialogElem.append('<div id="msg_'+this+'" class="send-msg sending">'+(index+1)+': send to '+this+'</div>');
				$.youi.ajaxUtil.ajax({
					url:funcUrls.sendCustomMessage,
					currentToUser:this,
					data:$.extend({},batchRecord,{touser:this}),
					success:function(results){
						//console.log('send to '+this.currentToUser +' success.');
						dialogElem.find('#msg_'+this.currentToUser).removeClass('sending').append(' '+$('.option-item:visible#'+this.currentToUser).text()+' success.');
					},error:function(){
						//
					}
				});
			});
		}
		return false;
	</youi:func>
</youi:page>