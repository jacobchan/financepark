<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationMedia" idKeys="mediaId" caption="媒体报道信息列表"  panel="false"
				src="esb/web/informationMediaManager/getPagerInformationMedias.json" dataFormId="form_informationMedia"
				editSrc="esb/web/informationMediaManager/getInformationMedia.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/informationMediaManager/removeInformationMedia.json">
		<youi:fieldLayout>
			<youi:fieldText property="mediaTilurl"  caption="文章URL_"/>
			<youi:fieldText property="mediaTitle"  caption="标题"/>
			<youi:fieldSelect property="mediaStatus"  caption="发布状态" convert="financingStatus"/>
			<youi:fieldText property="mediaRe"  caption="企业信息ID"/>

		<%-- 	<youi:fieldText property="mediaUrl"  caption="图片URL"/>
			<youi:fieldText property="rzId"  caption="ID2"/>             --%>
		</youi:fieldLayout>
		<youi:gridCol property="mediaTilurl"  caption="文章URL_"/>
		<youi:gridCol property="mediaTitle"  caption="标题"/>
		<youi:gridCol property="mediaStatus"  caption="发布状态"/>
		<youi:gridCol property="mediaRe"  caption="企业信息ID"/>

		<youi:gridCol property="mediaUrl"  caption="图片URL"/>
		<%-- <youi:gridCol property="rzId"  caption="ID2"/> --%>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-媒体报道信息编辑 -->
	<youi:form dialog="true" caption="媒体报道信息" id="form_informationMedia" action="esb/web/informationMediaManager/saveInformationMedia.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="mediaTilurl"  caption="文章URL_"/>
			<youi:fieldText property="mediaTitle"  caption="标题"/>
			<youi:fieldSelect property="mediaStatus"  caption="发布状态" convert="financingStatus"/>
			<youi:fieldText property="mediaRe"  caption="企业信息ID"/>
			<%-- <youi:fieldText property="mediaId"  caption="ID"/> --%>
			<youi:fieldText property="mediaUrl"  caption="图片URL"/>
			<%-- <youi:fieldText property="rzId"  caption="ID2"/> --%>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>