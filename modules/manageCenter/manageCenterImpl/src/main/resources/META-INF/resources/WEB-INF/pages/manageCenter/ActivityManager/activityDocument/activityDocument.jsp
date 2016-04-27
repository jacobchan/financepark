<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:subpage caption="文档列表" height="600"
		width="1000" subpageId="viewDocument"
		src="page/manageCenter.ActivityManager.activityDocument/viewDocument.html">
	</youi:subpage>

	<youi:grid id="grid_activityDocument" idKeys="documentId" caption="-文档列表列表"  panel="false"
				src="esb/web/activityDocumentManager/getPagerActivityDocuments.json" dataFormId="form_activityDocument"
				editSrc="esb/web/activityDocumentManager/getActivityDocument.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityDocumentManager/removeActivityDocument.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldSelect property="activityApply.applyId"  caption="活动" src="esb/web/activityApplyManager/getActivityApplys.json" code="applyId" show="applyTitle" notNull="ture"/>
			<youi:fieldText property="documentName"  caption="文档名"/>
		</youi:fieldLayout>
		<youi:gridCol property="activityApply.applyTitle"  caption="活动" width="20%"/>
		<youi:gridCol property="documentName"  caption="文档名" width="20%"/>
		<youi:gridCol property="documentPath"  caption="文档路径" width="60%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
		<youi:button name="viewDocument" caption="文档查看" active="1"/>
	</youi:grid>
	
	<!-- form--文档列表编辑 -->
	<youi:form dialog="true" caption="-文档列表" id="form_activityDocument" action="esb/web/activityDocumentManager/saveActivityDocument.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="documentId"  caption="文档ID"/>
			<youi:fieldSelect property="activityApply.applyId"  caption="活动" src="esb/web/activityApplyManager/getActivityApplys.json" code="applyId" show="applyTitle"/>
			<youi:fieldSwfupload property="documentPath"  caption="文档" uploadUrl="/common/upload.html" fileTypes="*.doc;*.xls;*.ppt;*.docx;*.xlsx;*.pptx;*.pdf"  fileTypesDescription="所有类型" fileSizeLimit="10240" fileUploadLimit="1" fileQueueLimit="1"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_viewDocument">
		var gridElement=$elem('grid_activityDocument',pageId);
		var selectedRecord=gridElement.grid('getSelectedRecord');
		$.youi.ajaxUtil.ajax({
			url:'esb/web/activityDocumentManager/getViewDocument.json',
			data:'documentId='+selectedRecord.documentId,
			success:function(result){
			$elem('subpage_viewDocument',pageId).subpage('open',{html:result.record.html});
		}
		});
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>