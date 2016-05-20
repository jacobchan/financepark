<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
function validateTime(startTime,endTime){
	var oDate1 = new Date(startTime);
    var oDate2 = new Date(endTime);
    if(oDate1.getTime() > oDate2.getTime()){
        return -1;
    } else {
    	return 1;
    }
} 
</script>
<youi:page>
	<youi:subpage id="subpage_Document" subpageId="Document"
	src="page/manageCenter.ActivityManager.activityDocument/document.html?activityApply.applyId={applyId}" height="500" width="850"
		caption="文档信息">
	</youi:subpage>

	<youi:grid id="grid_activityApply" idKeys="applyId" caption="-活动申请内容列表列表"  panel="false"
				src="esb/web/activityApplyManager/getPagerActivityApplys.json" dataFormId="form_activityApply"
				editSrc="esb/web/activityApplyManager/getActivityApply.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityApplyManager/removeActivityApply.json">
		<youi:fieldLayout  labelWidths="100,100">
			<youi:fieldText property="applyNumber"  caption="活动申请编号"/>
			<youi:fieldText property="applyOrderNumber"  caption="场地订单编号"/>
			<youi:fieldText property="applyTitle"  caption="活动标题"/>
			<youi:fieldCalendar property="startTime"  caption="活动开始时间"/>
			<youi:fieldCalendar property="endTime"  caption="活动结束时间"/>
			<youi:fieldSelect property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus" />
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>		
		</youi:fieldLayout>
		<youi:gridCol property="applyNumber"  caption="活动申请编号" width="100px"/>
		<youi:gridCol property="activityAdr"  caption="活动地址" width="100px"/>
		<youi:gridCol property="applyOrderNumber"  caption="场地订单编号" width="100px"/>	
		<youi:gridCol property="applyTitle"  caption="活动标题" width="150px"/>
		<youi:gridCol property="applayType.typeName"  caption="活动类型" width="100px"/>
		<youi:gridCol property="applyMaxuser"  caption="限制人数"  width="100px"/>
		<youi:gridCol property="startTime"  caption="活动开始时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" width="100px"/>
		<youi:gridCol property="endTime"  caption="活动结束时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" width="100px"/>
		<%-- <youi:gridCol property="commentContent"  caption="活动内容" width="200px"/> --%>

		<youi:gridCol property="applyStatus"  caption="活动申请状态" convert="activityApplyStatus" width="100px" />
		<youi:gridCol property="isRecoomend"  caption="是否推荐" convert="bool" width="100px"/>
		<youi:gridCol property="memberId.memberName"  caption="会员用户"  width="200px"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		<youi:button name="document" caption="文档管理" active="1" icon="edit"></youi:button>
		<youi:button name="pass" caption="申请通过" active="1" icon="edit"></youi:button>
		<youi:button name="refuse" caption="拒绝申请" active="1" icon="edit"></youi:button>
	</youi:grid>
	
	<!-- form--活动申请内容列表编辑 -->
	<youi:form dialog="true" caption="-活动申请内容列表" id="form_activityApply" action="esb/web/activityApplyManager/saveActivityApply.json" width="1100" height="500">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="applyId"  caption="活动申请ID"/>
			<%-- <youi:fieldHidden property="commentContent"  caption="活动内容"/> --%>
			<youi:fieldHidden property="applyNumber"  caption="活动申请编号"/>
			<youi:fieldText property="applyTitle"  caption="活动标题" notNull="true"/>
			<youi:fieldText property="activityAdr"  caption="活动地址" notNull="true"/>
			<%-- <youi:fieldSelect property="applyOrderNumber"  caption="场地编号" src="esb/web/purchasingmanagerCommodityManager/getPurchasingmanagerCommoditys.json"
								code="commodityId"	show="commodityTitle" /> --%>
			<youi:fieldText property="applyMaxuser"  caption="限制人数" expressionMessage="请输入整数" expression="^[1-9]\d*$" notNull="true"/>
			<youi:fieldSelect property="memberId.memberId"  caption="会员用户" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" notNull="true"/>
			<youi:fieldCalendar property="startTime"  caption="活动开始时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldCalendar property="endTime"  caption="活动结束时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldCalendar property="deadline"  caption="报名截至时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldHidden property="applyStatus"  caption="活动申请状态"  defaultValue="01"/>
			<youi:fieldSelect property="applayType.typeId"  caption="活动类型" src="esb/web/applayTypeManager/getApplayTypes.json" code="typeId" show="typeName" notNull="true"/>
			<youi:fieldSelect property="isRecoomend"  caption="是否推荐" convert="bool"/>
			<youi:fieldSwfupload property="activityImage" caption="活动图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<%-- <youi:fieldSwfupload property="documentPath"  caption="文档" uploadUrl="/common/upload.html" fileTypes="*.doc;*.xls;*.ppt;*.docx;*.xlsx;*.pptx;*.pdf"  fileTypesDescription="所有类型" fileSizeLimit="10240" fileQueueLimit="1"/> --%>
			<%-- <youi:fieldArea property="commentContent"  caption="活动内容" column="2" notNull="true"/> --%>
			<youi:fieldCustom column="2" custom="fieldCkeditor" customOptions="{}" property="commentContent"  caption="活动内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_pass">
		var gridElement=$elem("grid_activityApply",pageId);
		var selectedRecord=gridElement.grid("getSelectedRecord");
		if(selectedRecord.applyStatus=="00"){
			$.youi.ajaxUtil.ajax({
				url:'esb/web/activityApplyManager/updateApplyStatus.json',
				data:'applyId='+selectedRecord.applyId+'&'+'applyStatus=01',
				success:function(result){
				gridElement.grid("pReload");
				}
			})
		}else{
			alert("状态为申请中的活动才可以通过！")
		}
		
	</youi:func>
	
	<youi:func name="func_grid_refuse">
		var gridElement=$elem("grid_activityApply",pageId);
		var selectedRecord=gridElement.grid("getSelectedRecord");
		if(selectedRecord.applyStatus=="00"){
			$.youi.ajaxUtil.ajax({
				url:'esb/web/activityApplyManager/updateApplyStatus.json',
				data:'applyId='+selectedRecord.applyId+'&'+'applyStatus=03',
				success:function(result){
				gridElement.grid("pReload");
				}
			})
		}else{
			alert("状态为申请中才可以拒绝！")
		}
		
	</youi:func>
	
	<youi:func name="form_activityApply_beforeSubmit">//校验
		var startTime=$elem('record_startTime',pageId).fieldValue();
		var endTime=$elem('record_endTime',pageId).fieldValue();
		var flag=validateTime(startTime,endTime);
      	if(flag==-1){
			         alert("活动结束时间应该大于活动开始时间");
					  return false;
			       }
  
        return true;
	</youi:func>
	
	<!-- 文档管理 -->
	<youi:func name="func_grid_document">
		var gridElement=$elem("grid_activityApply",pageId);
		var subpageElem = $elem('subpage_Document',pageId);
		var selectedRecord=gridElement.grid("getSelectedRecord");
		var applyId = selectedRecord['applyId'];
		subpageElem.subpage('open',{applyId:applyId},null,{applyId:applyId});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>