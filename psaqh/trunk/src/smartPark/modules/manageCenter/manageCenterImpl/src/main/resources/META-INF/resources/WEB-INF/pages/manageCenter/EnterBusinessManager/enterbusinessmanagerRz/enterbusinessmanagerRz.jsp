<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterbusinessmanagerRz" idKeys="rzId" caption="入驻企业基本信息列表"  panel="false"
				src="esb/web/enterbusinessmanagerRzManager/getPagerEnterbusinessmanagerRzs.json" dataFormId="form_enterbusinessmanagerRz"
				editSrc="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json" edit="NOT" remove="NOT" showCheckbox="true" add="NOT"
				removeSrc="esb/web/enterbusinessmanagerRzManager/removeEnterbusinessmanagerRz.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="rzManager"  caption="企业管理员" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldCalendar property="rzDate"  caption="入驻时间"/>
			<youi:fieldText property="rzRemark"  caption="企业备注"/>
			<youi:fieldText property="buildingId"  caption="楼栋ID"/>
			<youi:fieldText property="rzBuss"  caption="企业主营"/>
			<youi:fieldText property="enTypeId"  caption="企业类型ID"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>
			<youi:fieldText property="rzMem"  caption="会员信息"/>
			<youi:fieldText property="rzTelephone"  caption="联系方式"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="rzManager"  caption="企业管理员"/>
		<youi:gridCol property="rzDate"  caption="入驻时间"/>
		<youi:gridCol property="buildingId"  caption="楼栋ID"/>
		<youi:gridCol property="parkId"  caption="园区ID"/>
		<youi:gridCol property="rzBuss"  caption="企业主营" convert="pubStatus"/>
		<youi:gridCol property="enTypeId"  caption="企业类型ID"/>
		<youi:gridCol property="rzSign"  caption="企业码"/>
		<youi:gridCol property="rzMem"  caption="会员信息"/>
		<youi:gridCol property="rzTelephone"  caption="联系方式"/>
		<youi:gridCol property="rzStatus"  caption="入驻状态" convert="pubStatus"/>
		<youi:gridCol property="rzRemark"  caption="企业备注" width="200px"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻企业基本信息编辑 -->
	<youi:form dialog="true" caption="入驻企业基本信息" id="form_enterbusinessmanagerRz" action="esb/web/enterbusinessmanagerRzManager/saveEnterbusinessmanagerRz.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="rzId"  caption="ID"/>
			 <youi:fieldSelect property="rzManager"  caption="企业管理员" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/> 
			<youi:fieldCalendar property="rzDate"  caption="入驻时间"/>
			<youi:fieldSelect property="parkId"  caption="园区ID" src="esb/web/bbmParkManager/getBbmParks.json" code="parkId" show="parkName"/>
			<youi:fieldSelect property="buildingId"  caption="楼栋ID" src="esb/web/bbmBuildingManager/getBbmBuildings.json" code="buildingId" show="buildingNo"/>
			<youi:fieldSelect property="rzBuss"  caption="企业主营" convert="pubStatus"/>
			<%-- <youi:fieldTree property="enTypeId"  caption="企业类型" src="esb/web/etypeEnterprisetypeManager/getEtypeEnterprisetypes.json" code="enTypeId" show="enTypeName"/>
			 --%><youi:fieldTree property="etypeEnterprisetype.enTypeId"
						simple="false" caption="企业类型" 
						src="esb/web/etypeEnterprisetypeManager/getChildren.json" 
						show="enTypeName" code="enTypeId" iteratorParentAttr="enTypeId"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>
			<youi:fieldText property="rzMem"  caption="会员信息"/>
			<youi:fieldText property="rzTelephone"  caption="联系方式"/>
			<youi:fieldSelect property="rzStatus"  caption="入驻状态" convert="pubStatus"/>
			<youi:fieldArea property="rzRemark"  caption="企业备注"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
	<youi:func name="form_enterbusinessmanagerRz_afterSubmit" params="result">
		$.youi.ajaxUtil.ajax({
			url:'esb/web/enterbusinessmanagerRzManager/updateEnteringStatus.json',
			data:'rzId='+result.record.rzId,
			success:function(result){
				
			}
		});
	</youi:func>

</youi:page>