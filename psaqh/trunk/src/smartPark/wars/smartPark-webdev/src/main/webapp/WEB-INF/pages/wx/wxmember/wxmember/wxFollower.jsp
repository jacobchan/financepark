<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:ajaxUrl name="wxGetUsers" src="esb/weixinAdapter/wxHttpServices/getUsers.json"/>
	<youi:ajaxUrl name="wxGetUserInfo" src="esb/weixinAdapter/wxHttpServices/getUserInfo.json"/>
	<youi:ajaxUrl name="saveFollower" src="esb/web/wxMemberManager/saveWxMember.json"></youi:ajaxUrl>
	
	<youi:grid id="grid_wxMember" idKeys="openid" caption="微信会员列表"  panel="false"
				src="esb/web/wxMemberManager/getPagerWxMembers.json" dataFormId="form_wxMember"
				editSrc="esb/web/wxMemberManager/getWxMember.json" edit="NOT" remove="NOT" add="NOT" showCheckbox="true"
				removeSrc="esb/web/wxMemberManager/removeWxMember.json">
		<youi:fieldLayout>
			<youi:fieldText property="nickname" operator="LIKE" caption="粉丝名"/>
			<youi:fieldSelect convert="sex" property="sex" caption="性别"/>
		</youi:fieldLayout>
		
		<youi:gridCol width="20%" property="openid" caption="openid"/>
		<youi:gridCol width="20%" property="nickname"  caption="粉丝名"/>
		<youi:gridCol width="10%" property="country"  caption="国家"/>
		<youi:gridCol width="10%" property="province"  caption="省"/>
		<youi:gridCol width="10%" property="city"  caption="城市"/>
		<youi:gridCol width="10%" property="sex" convert="sex" caption="性别"/>
		<youi:gridCol width="10%" property="subscribe"  caption="SUBSCRIBE"/>
		
		<youi:gridCol width="10%" fixed="false" property="button" type="button" caption="操作">
			<youi:button name="wxMemberViewer" icon="edit" caption="查看详细"/>
		</youi:gridCol>
		
		<youi:button name="syncFollowers" caption="同步粉丝"></youi:button>
	</youi:grid>
	
	<youi:form dialog="true" caption="微信会员" id="form_wxMember" idKeys="openid" submit="NOT" findAction="esb/weixinAdapter/wxHttpServices/getUserInfo.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden  property="openid"  caption="OPENID"/>
			<youi:fieldLabel column="2"  property="nickname"  caption="粉丝名"/>
			
			<youi:fieldLabel property="country"  caption="国家"/>
			<youi:fieldLabel property="province"  caption="省份"/>
			<youi:fieldLabel property="city"  caption="城市"/>
			<youi:fieldLabel property="sex"  caption="性别" convert="sex"/>
			
			<youi:fieldLabel styleClass="label-img" column="2" property="headimgurl" format="image" height="300" caption="头像"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="grid_wxMember_col_button_wxMemberViewer" params="record">
		$elem('form_wxMember',pageId).form('fillRecord',record).form('loadRecord').form('open');
	</youi:func>
	
	<youi:func name="func_grid_syncFollowers" urls="wxGetUsers">
		if(funcUrls.wxGetUsers){
			$.youi.ajaxUtil.ajax({
				url:funcUrls.wxGetUsers,
				success:function(results){
					//预览功能 
					$(results.records).each(function(){
						//$.youi.pageUtils.doPageFunc('findAndSaveFollower',pageId);
						var fullFuncName = 'P_'+pageId+'_findAndSaveFollower';
						if($.isFunction(window[fullFuncName])){
							window[fullFuncName](this.openid);
						}
					});
				}
			});
		}
	</youi:func>
	
	<youi:func name="findAndSaveFollower" params="openid" urls="wxGetUserInfo">
		if(funcUrls.wxGetUserInfo){
			$.youi.ajaxUtil.ajax({
				url:funcUrls.wxGetUserInfo,
				data:'openid='+openid,
				success:function(results){
					if(results.record){
						var fullFuncName = 'P_'+pageId+'_saveFollower';
						if($.isFunction(window[fullFuncName])){
							window[fullFuncName](results.record);
						}
					}
				}
			});
		}
	</youi:func>
	
	<youi:func name="saveFollower" params="record" urls="saveFollower">
		if(funcUrls.saveFollower){
			$.youi.ajaxUtil.ajax({
				url:funcUrls.saveFollower,
				data:record,
				success:function(results){
					
				}
			});
		}
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>