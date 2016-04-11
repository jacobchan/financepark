<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<youi:grid id="grid_fileUpload" idKeys="fileId" caption="文件列表"  panel="false"
				src="esb/web/fileUploadManager/getFileUploads.json" dataFormId="form_fileUpload"
				editSrc="esb/web/fileUploadManager/getFileUpload.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/fileUploadManager/removeFileUpload.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldText property="fileName"  caption="文件名称"/>
		</youi:fieldLayout>
		<youi:gridCol property="fileName"  caption="文件名称" width="15%"/>
		<youi:gridCol property="fileType"  caption="文件类型" convert="enteringType" width="15%" align="center"/>
		<youi:gridCol property="downNum"  caption="下载次数" width="10%" align="center"/>
		<youi:gridCol property="createTime"  caption="上传时间" width="15%"/>
		<youi:gridCol property="filePath"  caption="文档路径" width="45%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--文档列表编辑 -->
	<youi:form dialog="true" caption="-文档列表" id="form_fileUpload" action="esb/web/fileUploadManager/saveFileUpload.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="fileId"  caption="文档ID"/>
			<youi:fieldHidden property="downNum"  caption="下载次数"/>
			<youi:fieldHidden property="createTime"  caption="上传时间"/>
			<youi:fieldText property="fileName"  caption="文件名称" notNull="true"/>
			<youi:fieldSelect property="fileType" convert="enteringType" caption="文件类型" notNull="true"/>
			<youi:fieldSwfupload property="filePath"  caption="文件上传" notNull="true" uploadUrl="/common/upload.html" fileTypes="*.doc;*.xls;*.ppt"  fileTypesDescription="所有类型" fileSizeLimit="10240" fileUploadLimit="1" fileQueueLimit="1"/>
		</youi:fieldLayout>
	</youi:form>
	
	
</youi:page>