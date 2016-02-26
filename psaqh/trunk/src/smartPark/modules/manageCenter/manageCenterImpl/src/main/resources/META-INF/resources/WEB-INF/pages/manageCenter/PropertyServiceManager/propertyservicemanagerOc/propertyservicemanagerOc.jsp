<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerOc" idKeys="ocId" caption="一卡通办理申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerOcManager/getPagerPropertyservicemanagerOcs.json" dataFormId="form_propertyservicemanagerOc"
				editSrc="esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOc.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerOcManager/removePropertyservicemanagerOc.json">
		<youi:fieldLayout labelWidths="122,122">
			<%-- <youi:fieldText property="memberId"  caption="会员用户ID"/> --%>
			<%-- <youi:fieldText property="ocComp"  caption="所属企业名称"/> --%>
			<youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="ocComp" caption="所属企业名称" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<%-- <youi:fieldText property="ocRemark"  caption="一卡通其他说明"/> --%>
			<youi:fieldText property="ocNumber"  caption="一卡通号码"/>

			<youi:fieldCalendar property="ocDate"  caption="一卡通预约时间"/>
			<%-- <youi:fieldText property="ocAddree"  caption="选择地址"/> --%>
			<youi:fieldSelect property="ocWay"  caption="一卡通办理方式" convert="ocWay" />
			
			 <youi:fieldSelect property="ocStatus"  caption="一卡通预约状态">
			
				<youi:fieldOption caption="未办理" value="00"></youi:fieldOption>
				<youi:fieldOption caption="已办理" value="01"></youi:fieldOption>
			</youi:fieldSelect>
		</youi:fieldLayout>
		<youi:gridCol property="memberId"  caption="会员用户ID" width="10%"/>
		<youi:gridCol property="ocComp"  caption="所属企业名称" width="12%"/>
	
		<youi:gridCol property="ocNumber"  caption="一卡通号码" width="10%"/>

		<youi:gridCol property="ocDate"  caption="一卡通预约时间" width="13%"/>
		<youi:gridCol property="ocAddree"  caption="选择地址" width="10%"/>
		<youi:gridCol property="ocWay"  caption="一卡通办理方式"  convert="ocWay"  width="13%"/>
		<youi:gridCol property="ocStatus"  caption="一卡通预约状态" convert="ocStatus" width="122" />
			
			
		
		
		<%-- <youi:gridCol property="ocRemark"  caption="一卡通其他说明" /> --%>
		<youi:button name="over" caption="已办理" active="1"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-一卡通办理申请记录编辑 -->
	<youi:form dialog="true" caption="一卡通办理申请记录" id="form_propertyservicemanagerOc" action="esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json">
		<youi:fieldLayout prefix="record" labelWidths="122,122">
		    <youi:fieldHidden property="ocId"  caption="ID"/>
			<%-- <youi:fieldText property="memberId"  caption="会员用户ID"/> --%>
			<youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<%-- <youi:fieldText property="ocComp"  caption="所属企业名称"/> --%>
			<youi:fieldSelect property="ocComp" caption="所属企业名称" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			
			<youi:fieldText property="ocNumber"  caption="一卡通号码"/>
			<%-- <youi:fieldHidden property="ocId"  caption="一卡通预约记录"/> --%>
			<youi:fieldCalendar property="ocDate"  caption="一卡通预约时间"/>
			<youi:fieldText property="ocAddree"  caption="选择地址"/>
		<youi:fieldSelect property="ocWay"  caption="一卡通办理方式" convert="ocWay" />
			<%-- <youi:fieldText property="ocStatus"  caption="一卡通预约状态"/> --%>
			<youi:fieldSelect property="ocStatus"  caption="一卡通预约状态">
			
				<youi:fieldOption caption="未办理" value="00"></youi:fieldOption>
				<youi:fieldOption caption="已办理" value="01"></youi:fieldOption>
				
			</youi:fieldSelect>
			<youi:fieldArea property="ocRemark"  caption="一卡通其他说明" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="func_grid_over">
	var gridElement = $elem('grid_propertyservicemanagerOc',pageId);
	var select = gridElement.grid('getSelectedRecord');
	var ocStatus='01';
	$.youi.ajaxUtil.ajax({
		url:'esb/web/propertyservicemanagerOcManager/updateOcStatus.json',
	 	data:'ocId='+select.ocId+'&ocStatus='+ocStatus,
		success:function(result){
			gridElement.grid('pReload');
		}
	});

	</youi:func>
	
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>