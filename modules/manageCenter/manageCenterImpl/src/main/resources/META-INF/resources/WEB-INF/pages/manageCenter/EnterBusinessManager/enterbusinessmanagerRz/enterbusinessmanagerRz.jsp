<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_enterbusinessmanagerRz" idKeys="rzId,roomId.roomId" caption="入驻企业基本信息列表"  panel="false"
				src="esb/web/enterbusinessmanagerRzManager/getPagerEnterbusinessmanagerRzs.json" dataFormId="form_enterbusinessmanagerRz"
				editSrc="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/enterbusinessmanagerRzManager/removeEnterbusinessmanagerRz.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="rzManager.memberId"  caption="企业管理员" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="rzName"  caption="企业名称"/>
			<youi:fieldCalendar property="rzDate"  caption="入驻时间" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>			
			<%-- <youi:fieldSelect property="parkId"  caption="园区ID" src="esb/web/bbmParkManager/getBbmParks.json" code="parkId" show="parkName"/>
			<youi:fieldSelect property="buildingId"  caption="楼栋ID" src="esb/web/bbmBuildingManager/getBbmBuildings.json" 
								code="buildingId" show="buildingNo" parents="parkId" parentsAlias="parkId"/>  --%>
			<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="roomId.roomId"  caption="默认单元" onlyLeaf="true"/>
			<youi:fieldText property="enTypeId"  caption="企业类型ID"/>
			<youi:fieldText property="rzSign"  caption="企业码"/>
		</youi:fieldLayout>
		<youi:gridCol property="rzManager.memberName"  caption="企业管理员" width="10%" align="center"/>
		<youi:gridCol property="rzDate"  caption="入驻时间" format="yyyy-MM-dd HH:mm:ss" textFormat="yyyy-MM-dd HH:mm:ss" width="20%" align="center"/>
		<%-- <youi:gridCol property="buildingId"  caption="楼栋"  renderer="renderer_buildingId" width="10%" align="center"/>
		<youi:gridCol property="parkId"  caption="园区" renderer="renderer_parkId" width="10%" align="center"/> --%>
		<youi:gridCol property="roomId.roomNo"  caption="默认单元编号" width="10%" align="center"/>
		<youi:gridCol property="rzBuss"  caption="企业主营" convert="pubStatus" width="10%" align="center"/>
		<youi:gridCol property="enTypeId.enTypeName"  caption="企业类型" width="10%" align="center"/>
		<youi:gridCol property="rzSign"  caption="企业码" width="10%" align="center"/>
		<youi:gridCol property="rzUrl"  caption="会员网址" width="10%" align="center"/>
		<youi:gridCol property="rzTelephone"  caption="联系方式" width="10%" align="center"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻企业基本信息编辑 -->
	<youi:form dialog="true" caption="入驻企业基本信息" id="form_enterbusinessmanagerRz" action="esb/web/enterbusinessmanagerRzManager/saveEnterbusinessmanagerRz.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="rzId"  caption="ID"/>		
			<youi:fieldHidden property="entrecId.entrecId"  caption="物业入驻记录"/>
			<youi:fieldSelect property="rzManager.memberId"  caption="企业管理员" src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName" notNull="true"/> 
			<youi:fieldText property="rzName"  caption="企业名称" notNull="true"/>
			<youi:fieldCalendar property="rzDate"  caption="入驻时间" format="yyyy-MM-dd" textFormat="yyyy-MM-dd" notNull="true"/>
			<%-- <youi:fieldSelect property="parkId"  caption="园区" src="esb/web/bbmParkManager/getBbmParks.json" code="parkId" show="parkName" notNull="true"/>
			<youi:fieldSelect property="buildingId"  caption="楼栋" src="esb/web/bbmBuildingManager/getBbmBuildings.json" 
				code="buildingId" show="buildingNo" parents="parkId" parentsAlias="parkId" notNull="true"/> --%>
				
			<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="roomId.roomId"  caption="默认单元" onlyLeaf="true"/>
				
			<youi:fieldSelect property="rzBuss"  caption="企业主营" convert="pubStatus"/>
			<youi:fieldTree simple="false" popup="true" tree="${enetrTree}" property="enTypeId.enTypeId" caption="企业类型" onlyLeaf="true"/>
			<youi:fieldSelect property="rzType" caption="上市类型" convert="rzType"/>
			<youi:fieldSelect property="rzProperty" caption="企业性质" convert="rzProperty"/>
			<%-- <youi:fieldText property="rzSign"  caption="企业码"/> --%>
			<youi:fieldText property="rzUrl"  caption="企业网址"/>
			<youi:fieldText property="rzTelephone"  caption="联系方式" expression="^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$" expressionMessage="手机号码格式不正确" />
			<youi:fieldArea property="rzRemark"  caption="企业备注"/>			
			<youi:fieldSwfupload property="rzLogo" caption="企业logo" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072"/>
			<youi:fieldSwfupload property="rzImages" caption="企业宣传图" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072"/>
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="form_enterbusinessmanagerRz_afterSubmit" params="result">
		$.youi.ajaxUtil.ajax({
			url:'esb/web/enterbusinessmanagerRzManager/updateEnteringStatus.json',
			data:'rzId='+result.record.rzId,
			success:function(result){
				
			}
		});
	</youi:func>
	
	<youi:func name="renderer_parkId" params="col,record">
	if(record.parkId !="" && record.parkId !=null){
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
}
	</youi:func>
	
		<youi:func name="renderer_buildingId" params="col,record">
        if(record.buildingId !="" && record.buildingId !=null){
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

        }
	</youi:func>
</youi:page>