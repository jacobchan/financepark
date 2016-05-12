<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerOc" idKeys="ocId" caption="一卡通办理申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerOcManager/getPagerPropertyservicemanagerOcs.json" dataFormId="form_propertyservicemanagerOc"
				editSrc="esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOc.json" edit="NOT" add="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerOcManager/removePropertyservicemanagerOc.json">
		<youi:fieldLayout labelWidths="122,122">
			<youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="ocComp" caption="所属企业名称" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldText property="ocNumber"  caption="一卡通号码"/>
			<youi:fieldText property="ocCode"  caption="一卡通申请编号"/>
			<youi:fieldCalendar property="ocDate"  caption="一卡通预约时间"/>
			<youi:fieldSelect property="ocWay"  caption="一卡通办理方式" convert="oc_way" />
			<youi:fieldSelect property="ocStatus"  caption="一卡通预约状态" convert="oc_status"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="memberId"  caption="会员姓名" width="10%" renderer="renderer_memberId"/>
		<youi:gridCol property="ocCode"  caption="一卡通申请编号" width="12%"/>
		<youi:gridCol property="ocComp"  caption="所属企业名称" width="12%"/>
		<youi:gridCol property="ocNumber"  caption="一卡通号码" width="12%"/>
		<youi:gridCol property="ocDate"  caption="一卡通预约时间" width="10%"/>
		<youi:gridCol property="ocAddree.addressName"  caption="联系人" width="10%"/>
		<youi:gridCol property="ocAddree.addressPhone"  caption="联系人电话" width="10%"/>
		<youi:gridCol property="ocAddree.addressDetail"  caption="联系人地址" width="10%"/>
		<youi:gridCol property="ocWay"  caption="一卡通办理方式"  convert="oc_way"  width="7%"/>
		<youi:gridCol property="ocStatus"  caption="一卡通预约状态" convert="oc_status" width="7%" />
		<%-- <youi:gridCol property="ocRemark"  caption="一卡通其他说明" /> --%>
		
		<youi:button name="over" caption="处理预约" icon="edit" active="1"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-一卡通办理申请记录编辑 -->
	<youi:form dialog="true" caption="一卡通办理申请记录" id="form_propertyservicemanagerOc" action="esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json">
		<youi:fieldLayout prefix="record" labelWidths="122,122">
		    <youi:fieldHidden property="ocId"  caption="ID"/>
			<youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="ocComp" caption="所属企业名称" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			
		<%-- 	<youi:fieldText property="ocNumber"  caption="一卡通号码"/>
			<youi:fieldCalendar property="ocDate"  caption="一卡通预约时间"/> --%>
			<youi:fieldText property="ocAddree"  caption="选择地址"/>
			<youi:fieldSelect property="ocWay"  caption="一卡通办理方式" convert="oc_way" defaultValue="00"/>
			<youi:fieldSelect property="ocStatus"  caption="一卡通预约状态" convert="oc_status" defaultValue="00"/>
		<%-- 	<youi:fieldArea property="ocRemark"  caption="一卡通其他说明" column="2"/> --%>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-一卡通办理申请记录编辑 -->
	<youi:form dialog="true" caption="一卡通处理" id="form_dealOc" action="esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json">
		<youi:fieldLayout prefix="recordcl" labelWidths="122,122">
		    <youi:fieldHidden property="ocId"  caption="ID"/>
			<%-- <youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="ocComp" caption="所属企业名称" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/> --%>
			<%-- <youi:fieldText property="ocNumber"  caption="一卡通号码" notNull="true"/> --%>
			<youi:fieldCalendar property="ocDate"  caption="一卡通预约时间" notNull="true"/>
			<youi:fieldArea property="ocRemark"  caption="一卡通其他说明" notNull="true" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	
	<!--**********************************页面函数Start********************************-->
	<!-- 获取用户名称 -->
	<youi:func name="renderer_memberId" params="col,record">
 		var memberName = ""; 
		$.youi.ajaxUtil.ajax({
				url:'esb/web/memberInformationManager/getMemberInformation.json',
				data:'memberId='+record.memberId,
				async: false, 
				success:function(result){
					if(result.record!=""&&result.record!=null){
						memberName=result.record.memberName;
					}
				}
			});
		return memberName;
	</youi:func>
	
	<!-- 处理一卡通申请 -->
	<youi:func name="func_grid_over">
		var gridElement = $elem('grid_propertyservicemanagerOc',pageId);
		var selectedRecord = gridElement.grid('getSelectedRecord');
		var ocstatus=selectedRecord.ocStatus;
		if(ocstatus=='00'){
		 $elem('form_dealOc',pageId).form("reset")
			.form('fillRecord',{ocId:selectedRecord['ocId']}).form('open');
		}else if(ocstatus=='01'){
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json',
				data:'ocId='+selectedRecord.ocId,
				success:function(result){
					alert("处理成功!");
					$elem('grid_propertyservicemanagerOc',pageId).grid('pReload');
				}
			});
		}else{
			alert("已处理!");
		}
	</youi:func>
	
	<youi:func name="form_dealOc_afterSubmit">
		var formdealOc = $elem('form_dealOc',pageId);
		alert("处理完成！");
		formdealOc.form('close');
		$elem('grid_propertyservicemanagerOc',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>