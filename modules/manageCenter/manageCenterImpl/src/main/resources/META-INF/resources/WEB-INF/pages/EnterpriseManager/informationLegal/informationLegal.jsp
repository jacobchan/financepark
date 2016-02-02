<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationLegal" idKeys="legalId" caption="法人介绍列表"  panel="false"
				src="esb/web/informationLegalManager/getPagerInformationLegals.json" dataFormId="form_informationLegal"
				editSrc="esb/web/informationLegalManager/getInformationLegal.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/informationLegalManager/removeInformationLegal.json">
		<youi:fieldLayout>
			<youi:fieldText property="legalTelephone"  caption="联系方式"/>
			<youi:fieldText property="rzId"  caption="ID2"/>
			<youi:fieldText property="legalRe"  caption="企业信息ID"/>
			<youi:fieldText property="legalName"  caption="法人信息"/>

		</youi:fieldLayout>
		<youi:gridCol property="legalTelephone"  caption="联系方式"/>
		<youi:gridCol property="rzId"  caption="ID2"/>
		<youi:gridCol property="legalRe"  caption="企业信息ID"/>
		<youi:gridCol property="legalName"  caption="法人信息"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-法人介绍编辑 -->
	<youi:form dialog="true" caption="法人介绍" id="form_informationLegal" action="esb/web/informationLegalManager/saveInformationLegal.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="legalTelephone"  caption="联系方式"/>
			<youi:fieldText property="rzId"  caption="ID2"/>
			<youi:fieldText property="legalRe"  caption="企业信息ID"/>
			<youi:fieldText property="legalName"  caption="法人信息"/>
			<youi:fieldText property="legalId"  caption="ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>