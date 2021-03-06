<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationMedia" idKeys="mediaId" caption="媒体报道信息列表"  panel="false"
		src="esb/web/informationMediaManager/getPagerInformationMedias.json" dataFormId="form_informationMedia"
		editSrc="esb/web/informationMediaManager/getInformationMedia.json" edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/informationMediaManager/removeInformationMedia.json">
		<youi:fieldLayout>
		<youi:fieldText property="mediaTitle"  caption="标题"/>
		<youi:fieldSelect property="mediaStatus"  caption="发布状态" convert="financingStatus"/>
		<youi:fieldSelect property="mediaRe" caption="企业信息" 
			src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
		</youi:fieldLayout>
		<youi:gridCol property="mediaRe" caption="企业信息" renderer="renderer_mediaRe" width="20%"/>
		<youi:gridCol property="mediaTitle" caption="标题" width="20%"/>
		<youi:gridCol property="mediaTilurl" caption="文章路径" width="25%"/>
		<youi:gridCol property="mediaStatus" caption="发布状态" convert="financingStatus" width="5%"/>
		<youi:gridCol property="mediaUrl" caption="图片URL" width="30%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-媒体报道信息编辑 -->
	<youi:form dialog="true" caption="媒体报道信息" id="form_informationMedia" action="esb/web/informationMediaManager/saveInformationMedia.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldText property="mediaTilurl"  caption="文章URL"/>
			<youi:fieldText property="mediaTitle"  caption="标题"/>
			<youi:fieldSelect property="mediaStatus"  caption="发布状态" convert="financingStatus"/>
			<youi:fieldSelect property="mediaRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldHidden property="mediaId"  caption="ID"/>
			<youi:fieldSwfupload property="mediaUrl" caption="媒体图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072"/>
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="renderer_mediaRe" params="col,record">
        if(record.mediaRe !="" && record.mediaRe !=null){
	 		var rzName = ""; 
			$.youi.ajaxUtil.ajax({
				url:'esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
				data:'rzId='+record.mediaRe,
				async: false, 
				success:function(result){
					rzName=result.record.rzName;
				}
			});
			return rzName;
        }
	</youi:func>
</youi:page>