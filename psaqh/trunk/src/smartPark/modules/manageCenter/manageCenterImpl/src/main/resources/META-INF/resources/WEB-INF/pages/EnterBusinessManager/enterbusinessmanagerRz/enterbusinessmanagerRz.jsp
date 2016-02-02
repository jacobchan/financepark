<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterbusinessmanagerRz" idKeys="rzId" caption="入驻企业基本信息列表"  panel="false"
				src="esb/web/enterbusinessmanagerRzManager/getPagerEnterbusinessmanagerRzs.json" dataFormId="form_enterbusinessmanagerRz"
				editSrc="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/enterbusinessmanagerRzManager/removeEnterbusinessmanagerRz.json">
		<youi:fieldLayout>
			<youi:fieldText property="rzBuss"  caption="企业主营"/>
			<youi:fieldText property="rzDate"  caption="入驻时间"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="rzManager"  caption="企业管理员"/>
			<youi:fieldText property="rzTelephone"  caption="联系方式"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>

			<youi:fieldText property="rzRemark"  caption="企业备注"/>
			<youi:fieldText property="buildingId"  caption="楼栋ID"/>
			<youi:fieldText property="rzMem"  caption="会员信息"/>
		</youi:fieldLayout>
		<youi:gridCol property="rzBuss"  caption="企业主营"/>
		<youi:gridCol property="rzDate"  caption="入驻时间"/>
		<youi:gridCol property="parkId"  caption="园区ID"/>
		<youi:gridCol property="rzManager"  caption="企业管理员"/>
		<youi:gridCol property="rzTelephone"  caption="联系方式"/>
		<youi:gridCol property="rzSign"  caption="企业码"/>

		<youi:gridCol property="rzRemark"  caption="企业备注"/>
		<youi:gridCol property="buildingId"  caption="楼栋ID"/>
		<youi:gridCol property="rzMem"  caption="会员信息"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻企业基本信息编辑 -->
	<youi:form dialog="true" caption="入驻企业基本信息" id="form_enterbusinessmanagerRz" action="esb/web/enterbusinessmanagerRzManager/saveEnterbusinessmanagerRz.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="rzBuss"  caption="企业主营"/>
			<youi:fieldText property="rzDate"  caption="入驻时间"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="rzManager"  caption="企业管理员"/>
			<youi:fieldText property="rzTelephone"  caption="联系方式"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>
			<youi:fieldText property="rzId"  caption="ID"/>
			<youi:fieldText property="rzRemark"  caption="企业备注"/>
			<youi:fieldText property="buildingId"  caption="楼栋ID"/>
			<youi:fieldText property="rzMem"  caption="会员信息"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>