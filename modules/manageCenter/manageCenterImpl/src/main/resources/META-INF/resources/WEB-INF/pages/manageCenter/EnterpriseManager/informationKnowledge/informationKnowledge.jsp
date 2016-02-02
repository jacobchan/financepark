<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationKnowledge" idKeys="knowledgeId" caption="知识产权信息列表"  panel="false"
				src="esb/web/informationKnowledgeManager/getPagerInformationKnowledges.json" dataFormId="form_informationKnowledge"
				editSrc="esb/web/informationKnowledgeManager/getInformationKnowledge.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/informationKnowledgeManager/removeInformationKnowledge.json">
		<youi:fieldLayout>
			<youi:fieldText property="rzId"  caption="ID2"/>

			<youi:fieldText property="knowledgeRe"  caption="企业信息ID"/>
			<youi:fieldText property="knowledgeTitle"  caption="标题"/>
			<youi:fieldText property="knowledgeContent"  caption="描述"/>
			<youi:fieldText property="knowledgeUrl"  caption="图片URL"/>
			<youi:fieldText property="knowledgeStatus"  caption="发布状态"/>
		</youi:fieldLayout>
		<youi:gridCol property="rzId"  caption="ID2"/>

		<youi:gridCol property="knowledgeRe"  caption="企业信息ID"/>
		<youi:gridCol property="knowledgeTitle"  caption="标题"/>
		<youi:gridCol property="knowledgeContent"  caption="描述"/>
		<youi:gridCol property="knowledgeUrl"  caption="图片URL"/>
		<youi:gridCol property="knowledgeStatus"  caption="发布状态"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-知识产权信息编辑 -->
	<youi:form dialog="true" caption="知识产权信息" id="form_informationKnowledge" action="esb/web/informationKnowledgeManager/saveInformationKnowledge.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="rzId"  caption="ID2"/>
			<youi:fieldText property="knowledgeId"  caption="ID"/>
			<youi:fieldText property="knowledgeRe"  caption="企业信息ID"/>
			<youi:fieldText property="knowledgeTitle"  caption="标题"/>
			<youi:fieldText property="knowledgeContent"  caption="描述"/>
			<youi:fieldText property="knowledgeUrl"  caption="图片URL"/>
			<youi:fieldText property="knowledgeStatus"  caption="发布状态"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>