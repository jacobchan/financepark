<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationLegal" idKeys="legalId" caption="法人介绍列表"  panel="false"
				src="esb/web/informationLegalManager/getPagerInformationLegals.json" dataFormId="form_informationLegal"
				editSrc="esb/web/informationLegalManager/getInformationLegal.json" edit="NOT" remove="NOT" showCheckbox="true" 
				removeSrc="esb/web/informationLegalManager/removeInformationLegal.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="legalRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>	
			<youi:fieldText property="legalName"  caption="法人名字"/>
			<youi:fieldText property="legalTelephone"  caption="联系方式"/>
		</youi:fieldLayout>
		<youi:gridCol property="legalRe" caption="企业信息" renderer="renderer_legalRe" width="20%"/>
		<youi:gridCol property="legalName" caption="法人名称" width="10%"/>
		<youi:gridCol property="legalImage" caption="法人图像" width="20%"/>
		<youi:gridCol property="legalBirthday" caption="法人生日" width="10%"/>
		<youi:gridCol property="legalBusiness" caption="法人职务" width="10%"/>
		<youi:gridCol property="legalRemark" caption="法人简介" width="20%"/>
		<youi:gridCol property="legalTelephone" caption="联系方式" width="10%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-法人介绍编辑 -->
	<youi:form dialog="true" caption="法人介绍" id="form_informationLegal" action="esb/web/informationLegalManager/saveInformationLegal.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="legalId" caption="主键"/>
			<youi:fieldSelect property="legalRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldText property="legalName" caption="法人名称"/>
			<youi:fieldSwfupload property="legalImage" caption="法人图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072"/>
			<youi:fieldCalendar property="legalBirthday" caption="法人生日" notNull="true"
				format="yyyy-MM-dd" />
			<youi:fieldText property="legalBusiness" caption="法人职务"/>			
			<youi:fieldText property="legalTelephone" caption="联系方式"/>
			<youi:fieldArea property="legalRemark" caption="法人简介" notNull="true" rows="8" column="20"/>
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="renderer_legalRe" params="col,record">
        if(record.legalRe !="" && record.legalRe !=null){
	 		var rzName = ""; 
			$.youi.ajaxUtil.ajax({
				url:'esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
				data:'rzId='+record.legalRe,
				async: false, 
				success:function(result){
					rzName=result.record.rzName;
				}
			});
			return rzName;
        }
	</youi:func>
</youi:page>