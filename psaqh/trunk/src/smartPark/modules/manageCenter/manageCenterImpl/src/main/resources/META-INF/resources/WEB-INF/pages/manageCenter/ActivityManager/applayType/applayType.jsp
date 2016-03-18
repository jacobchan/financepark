<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_applayType" idKeys="typeId" caption="-活动类型列表"  panel="false"
				src="esb/web/applayTypeManager/getPagerApplayTypes.json" dataFormId="form_applayType"
				editSrc="esb/web/applayTypeManager/getApplayType.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/applayTypeManager/removeApplayType.json">
		<youi:fieldLayout  labelWidths="100,100">
			<youi:fieldText property="typeName"  caption="活动类型名"/>
		</youi:fieldLayout>
		<youi:gridCol property="typeName"  caption="活动类型名" width="20%"/>
		<youi:gridCol property="typeCode"  caption="类型编码" width="20%"/>	
		<youi:gridCol property="isRecoment"  caption="是否推荐" convert="bool" width="20%"/>
		<youi:gridCol property="typeIcon"  caption="类型图标"  width="40%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--活动类型列表编辑 -->
	<youi:form dialog="true" caption="-活动类型列表" id="form_applayType" action="esb/web/applayTypeManager/saveApplayType.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="typeId"  caption="活动类型ID"/>
			<youi:fieldText property="typeName"  caption="活动类型名"/>
			<youi:fieldText property="typeCode"  caption="类型编码"/>
			<youi:fieldSelect property="isRecoment"  caption="是否推荐" convert="bool"/>
			<youi:fieldSwfupload property="typeIcon" caption="类型图标" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->


	<!--**********************************页面函数End**********************************-->
</youi:page>