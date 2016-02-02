<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_activityDocument" idKeys="documentId" caption="-文档列表列表"  panel="false"
				src="esb/web/activityDocumentManager/getPagerActivityDocuments.json" dataFormId="form_activityDocument"
				editSrc="esb/web/activityDocumentManager/getActivityDocument.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/activityDocumentManager/removeActivityDocument.json">
		<youi:fieldLayout>

			<youi:fieldText property="documentName"  caption="文档名"/>
			<youi:fieldText property="documentPath"  caption="文档路径"/>
		</youi:fieldLayout>

		<youi:gridCol property="documentName"  caption="文档名"/>
		<youi:gridCol property="documentPath"  caption="文档路径"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form--文档列表编辑 -->
	<youi:form dialog="true" caption="-文档列表" id="form_activityDocument" action="esb/web/activityDocumentManager/saveActivityDocument.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="documentId"  caption="文档ID"/>
			<youi:fieldText property="documentName"  caption="文档名"/>
			<youi:fieldText property="documentPath"  caption="文档路径"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>