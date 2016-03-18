<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationKnowledge" idKeys="knowledgeId"
		caption="知识产权信息列表" panel="false"
		src="esb/web/informationKnowledgeManager/getPagerInformationKnowledges.json"
		dataFormId="form_informationKnowledge"
		editSrc="esb/web/informationKnowledgeManager/getInformationKnowledge.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/informationKnowledgeManager/removeInformationKnowledge.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="knowledgeRe" caption="企业信息"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" />
			<youi:fieldText property="knowledgeTitle" caption="标题" />
			<youi:fieldSelect property="knowledgeStatus" caption="发布状态"
				convert="financingStatus" />
		</youi:fieldLayout>
		<youi:gridCol property="knowledgeRe" caption="企业信息" width="20%" />
		<youi:gridCol property="knowledgeTitle" caption="标题" width="20%" />
		<youi:gridCol property="knowledgeUrl" caption="知识产权证书" width="20%" />
		<youi:gridCol property="knowledgeStatus" caption="发布状态" convert="financingStatus" width="8%" />
		<youi:gridCol property="knowledgeContent" caption="描述" width="32%" />
		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-知识产权信息编辑 -->
	<youi:form dialog="true" caption="知识产权信息"
		id="form_informationKnowledge"
		action="esb/web/informationKnowledgeManager/saveInformationKnowledge.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="knowledgeId" caption="主键" />
			<youi:fieldSelect property="knowledgeRe" caption="企业信息" notNull="true"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" />
			<youi:fieldText property="knowledgeTitle" caption="标题" notNull="true" />			
			<youi:fieldSwfupload property="knowledgeUrl" caption="知识产权证书" notNull="true" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072"/>
			<youi:fieldSelect property="knowledgeStatus" caption="发布状态" notNull="true" convert="financingStatus" />
			<youi:fieldArea property="knowledgeContent" caption="描述" notNull="true" rows="8" column="20" />
		</youi:fieldLayout>
	</youi:form>
</youi:page>