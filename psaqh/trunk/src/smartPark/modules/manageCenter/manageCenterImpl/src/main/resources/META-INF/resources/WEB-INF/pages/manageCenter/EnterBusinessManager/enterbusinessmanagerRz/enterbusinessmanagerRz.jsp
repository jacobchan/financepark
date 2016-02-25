<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterbusinessmanagerRz" idKeys="rzId" caption="入驻企业基本信息列表"  panel="false"
				src="esb/web/enterbusinessmanagerRzManager/getPagerEnterbusinessmanagerRzs.json" dataFormId="form_enterbusinessmanagerRz"
				editSrc="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/enterbusinessmanagerRzManager/removeEnterbusinessmanagerRz.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="rzManager"  caption="企业管理员" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="rzName"  caption="企业名称"/>
			<youi:fieldCalendar property="rzDate"  caption="入驻时间"/>			
			<youi:fieldSelect property="parkId"  caption="园区ID" src="esb/web/bbmParkManager/getBbmParks.json" code="parkId" show="parkName"/>
			<youi:fieldSelect property="buildingId"  caption="楼栋ID" src="esb/web/bbmBuildingManager/getBbmBuildings.json" 
								code="buildingId" show="buildingNo" parents="parkId" parentsAlias="parkId"/>
			<youi:fieldText property="enTypeId"  caption="企业类型ID"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>
		</youi:fieldLayout>
		<youi:gridCol property="rzManager"  caption="企业管理员" width="10%"/>
		<youi:gridCol property="rzDate"  caption="入驻时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" width="10%"/>
		<youi:gridCol property="buildingId"  caption="楼栋"  renderer="renderer_buildingId" width="10%"/>
		<youi:gridCol property="parkId"  caption="园区" renderer="renderer_parkId" width="10%"/>
		<youi:gridCol property="rzBuss"  caption="企业主营"  width="10%"/>
		<youi:gridCol property="enTypeId"  caption="企业类型" width="10%"/>
		<youi:gridCol property="rzSign"  caption="企业码" width="10%"/>
		<youi:gridCol property="rzMem"  caption="会员信息" width="10%"/>
		<youi:gridCol property="rzTelephone"  caption="联系方式" width="10%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻企业基本信息编辑 -->
	<youi:form dialog="true" caption="入驻企业基本信息" id="form_enterbusinessmanagerRz" action="esb/web/enterbusinessmanagerRzManager/saveEnterbusinessmanagerRz.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="rzId"  caption="ID"/>
			 <youi:fieldSelect property="rzManager"  caption="企业管理员" src="esb/web/memberInformationManager/getMemberInformations.json" 
			 					code="memberId" show="memberName" notNull="true"/> 
			<youi:fieldText property="rzName"  caption="企业名称" notNull="true"/>
			<youi:fieldCalendar property="rzDate"  caption="入驻时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" notNull="true"/>
			<youi:fieldSelect property="parkId"  caption="园区" src="esb/web/bbmParkManager/getBbmParks.json" code="parkId" show="parkName" notNull="true"/>
			<youi:fieldSelect property="buildingId"  caption="楼栋" src="esb/web/bbmBuildingManager/getBbmBuildings.json" 
								code="buildingId" show="buildingNo" parents="parkId" parentsAlias="parkId" notNull="true"/>
			<youi:fieldSelect property="rzBuss"  caption="企业主营" convert="pubStatus"/>
			<youi:fieldTree property="etypeEnterprisetype.enTypeId"
						simple="false" caption="企业类型" 
						src="esb/web/etypeEnterprisetypeManager/getChildren.json" 
						show="enTypeName" code="enTypeId" iteratorParentAttr="enTypeId"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>
			<youi:fieldText property="rzMem"  caption="会员信息"/>
			<youi:fieldText property="rzTelephone"  caption="联系方式" expression="^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$" expressionMessage="手机号码格式不正确" />
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
	
	<youi:func name="renderer_parkId" params="col,record">
	 	var parkName = ""; 
		$.youi.ajaxUtil.ajax({
				url:'esb/web/bbmParkManager/getBbmPark.json',
				data:'parkId='+record.parkId,
				async: false, 
				success:function(result){
					parkName=result.record.parkName;
				}
			});
		return parkName;
	</youi:func>
	
		<youi:func name="renderer_buildingId" params="col,record">
	 	var buildingNo = ""; 
		$.youi.ajaxUtil.ajax({
				url:'esb/web/bbmBuildingManager/getBbmBuilding.json',
				data:'buildingId='+record.buildingId,
				async: false, 
				success:function(result){
					buildingNo=result.record.buildingNo;
				}
			});
		return buildingNo;
	</youi:func>
</youi:page>