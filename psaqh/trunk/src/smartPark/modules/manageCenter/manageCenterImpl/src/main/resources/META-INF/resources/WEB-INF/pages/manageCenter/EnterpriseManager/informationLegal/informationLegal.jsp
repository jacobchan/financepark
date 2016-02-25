<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationLegal" idKeys="legalId" caption="法人介绍列表"  panel="false"
				src="esb/web/informationLegalManager/getPagerInformationLegals.json" dataFormId="form_informationLegal"
				editSrc="esb/web/informationLegalManager/getInformationLegal.json" edit="NOT" remove="NOT" showCheckbox="true" 
				removeSrc="esb/web/informationLegalManager/removeInformationLegal.json">
		<youi:fieldLayout>
			<%-- <youi:fieldText property="rzId"  caption="ID2"/> --%>

			<youi:fieldText property="legalTelephone"  caption="联系方式"/>
			<youi:fieldText property="legalName"  caption="法人名字"/>
			<%-- <youi:fieldText property="legalRe"  caption="企业信息ID"/> --%>
			<youi:fieldSelect property="legalRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			 	
			<%-- 	
			<youi:fieldSelect property="rzManager"  caption="企业管理员" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>  
				 --%>
				<%-- <youi:fieldSelect property="bbmBuilding.buildingId" caption="所属楼栋" code="buildingId" show="buildingNo" showProperty="bbmBuilding.buildingCaption"
				src="esb/web/bbmBuildingManager/getBbmBuildings.json" parents="bbmPark.parkId" parentsAlias="bbmPark.parkId"></youi:fieldSelect>--%>
				
		</youi:fieldLayout>
		<%-- <youi:gridCol property="rzId"  caption="ID2"/> --%>
		<youi:gridCol property="legalTelephone"  caption="联系方式"/>
		<youi:gridCol property="legalName"  caption="法人名字"/>
		<youi:gridCol property="legalRe"  caption="企业信息ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-法人介绍编辑 -->
	<youi:form dialog="true" caption="法人介绍" id="form_informationLegal" action="esb/web/informationLegalManager/saveInformationLegal.json">
		<youi:fieldLayout prefix="record">
			 <youi:fieldText property="rzId"  caption="ID2"/>
			<%-- <youi:fieldHidden property="legalId"  caption="ID"/>  --%>
			<youi:fieldText property="legalTelephone"  caption="联系方式"/>
			<youi:fieldText property="legalName"  caption="法人信息"/>
			<%-- <youi:fieldText property="legalRe"  caption="企业信息ID"/> --%>
			<youi:fieldSelect property="legalRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			 	
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>