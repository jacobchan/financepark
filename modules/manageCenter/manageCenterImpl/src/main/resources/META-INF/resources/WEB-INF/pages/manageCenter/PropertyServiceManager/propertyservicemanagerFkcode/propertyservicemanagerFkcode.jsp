<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerFkcode" idKeys="fkcodeId" caption="访客申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerFkcodeManager/getPagerPropertyservicemanagerFkcodes.json" dataFormId="form_propertyservicemanagerFkcode"
				editSrc="esb/web/propertyservicemanagerFkcodeManager/getPropertyservicemanagerFkcode.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerFkcodeManager/removePropertyservicemanagerFkcode.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="fkcodeName"  caption="联系人"/>
			<youi:fieldText property="fkcodeTelephone"  caption="联系电话" />
			<youi:fieldSelect property="fkcodeComp" caption="到访企业" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldCalendar property="fkcodeTime"  caption="到访时间"/>
			<%-- <youi:fieldText property="memberId"  caption="会员用户ID"/> --%>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="applyStatus"  caption="申请状态" convert="applyStatus" />	
		</youi:fieldLayout>
		<youi:button name="update" caption="修改" icon="edit" active="1"/>
		<youi:button name="agree" caption="同意" icon="edit" active="1"/>
		<youi:button name="refuse" caption="拒绝" icon="edit" active="1"/>
		
		<youi:gridCol property="fkcodeName"  caption="联系人" width="100" align="center"/>
		<youi:gridCol property="fkcodeSex"  caption="性别" convert="sex" width="50" align="center"/>
		<youi:gridCol property="fkcodeTelephone"  caption="联系电话" width="150" align="center"/>
		<youi:gridCol property="fkcodeTime"  caption="到访时间" width="100" align="center"/>
		<youi:gridCol property="member.memberName"  caption="会员姓名" width="100" align="center"/>
		<youi:gridCol property="fkcodeComp"  caption="到访企业" width="150" align="center"/>
		<youi:gridCol property="applyStatus"  caption="申请状态" width="100" align="center" convert="applyStatus"/>
		<youi:gridCol property="fkcodeRemark"  caption="访客说明" width="150"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<%-- <youi:button name="edit" caption="修改"/> --%>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-访客申请记录添加-->
	<youi:form dialog="true" caption="访客申请记录" id="form_propertyservicemanagerFkcode" action="esb/web/propertyservicemanagerFkcodeManager/savePropertyservicemanagerFkcode.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="fkcodeId"  caption="访客申请ID"/>
			<youi:fieldSelect property="member.memberId"  caption="会员姓名"
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldText property="fkcodeName"  caption="联系人"/>
			<youi:fieldSelect property="fkcodeSex"  caption="性别" convert="sex" />
			<youi:fieldText property="fkcodeTelephone"  caption="联系电话"/>
			<youi:fieldText property="fkcodeComp" caption="到访企业" />
			<youi:fieldCalendar property="fkcodeTime"  caption="到访时间" notNull="true"/>
			<youi:fieldArea property="fkcodeRemark"  caption="访客说明" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-访客申请记录修改 -->
	<youi:form dialog="true" caption="访客申请记录" id="form_fkcode" action="esb/web/propertyservicemanagerFkcodeManager/savePropertyservicemanagerFkcode.json">
		<youi:fieldLayout prefix="records" labelWidths="120,120">
			<youi:fieldHidden property="fkcodeId"  caption="访客申请ID"/>
			<youi:fieldHidden property="applyStatus"  caption="申请状态"/>
			<youi:fieldHidden property="member.memberId"  caption="会员ID"/>
			<youi:fieldText property="memberName"  caption="会员姓名" readonly="true"/>
			<youi:fieldText property="fkcodeName"  caption="联系人"/>
			<youi:fieldSelect property="fkcodeSex"  caption="性别" convert="sex" />
			<youi:fieldText property="fkcodeTelephone"  caption="联系电话"/>
			<youi:fieldText property="fkcodeComp" caption="到访企业" />
			<youi:fieldCalendar property="fkcodeTime"  caption="到访时间" notNull="true"/>
			<youi:fieldArea property="fkcodeRemark"  caption="访客说明" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面函数Start********************************-->
	<!-- 会员发生变化时，对应的企业名称也发生变化 -->
		<youi:func name = "record_member_memberId_change">
      		var memberId = $('#P_'+pageId+'_record_member_memberId').fieldValue();//获取当前选中会员的id
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/policyApplyManager/findEnterpriseByMemberId.json',
				data:{memberId:memberId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_fkcodeComp').fieldValue('') ;//先将公司名称置空
                    $('#P_'+pageId+'_record_fkcodeComp').fieldValue(record.rzName);//将返回的对象里面的enName赋值给公司名称
                  } 
            });
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/memberInformationManager/getMemberInformation.json',
				data:{memberId:memberId},
				success:function(result){
					var record = result.record;
					$('#P_'+pageId+'_record_fkcodeName').fieldValue('') ;//先将联系人置空
					$('#P_'+pageId+'_record_fkcodeTelephone').fieldValue('') ;//先将联系电话置空
                    $('#P_'+pageId+'_record_fkcodeName').fieldValue(record.memberName);//将返回的对象里面的memberName赋值给联系人
 					$('#P_'+pageId+'_record_fkcodeTelephone').fieldValue(record.memberPhoneNumber);//将返回的对象里面的memberPhoneNumber赋值给联系电话
                  } 
            });
   	 </youi:func>
   	 
   	 <!-- 修改表单 -->
   	 <youi:func name="func_grid_update">
		var gridElement = $elem('grid_propertyservicemanagerFkcode',pageId);
		var	selectedRecord = gridElement.grid('getSelectedRecord');
		var fkcodeId = selectedRecord.fkcodeId ;
   	 	$elem('form_fkcode',pageId).form("reset").form('fillRecord',selectedRecord).form('open') ;
		$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerFkcodeManager/getMemberByFkcodeId.json',
				data:{fkcodeId:fkcodeId},
				success:function(result){
					var record = result.record;
                    $('#P_'+pageId+'_records_member_memberId').fieldValue(record.memberId);//将返回的对象里面的memberId赋值给会员ID
 					$('#P_'+pageId+'_records_memberName').fieldValue(record.memberName);//将返回的对象里面的memberName赋值给会员名称
                  } 
        });
   	 </youi:func>
   	 
   	 <!-- 同意申请 -->
   	 <youi:func name="func_grid_agree">
		var gridElement = $elem('grid_propertyservicemanagerFkcode',pageId);
		var	selectedRecord = gridElement.grid('getSelectedRecord');
		var status = selectedRecord.applyStatus ;
		if('01' == status){//如果当前状态为申请状态，则可以同意
			var fkcodeId = selectedRecord.fkcodeId ;
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerFkcodeManager/updateFkcode.json',
				data:{fkcodeId:fkcodeId,code:'00'},//00表示同意
				success:function(result){
					alert("操作成功！") ;
                } 
       		});
		}else if('02' == status){
			alert("已经是申请成功状态了") ;
		}else{
			alert("申请失败无法再次同意申请！") ;
		}
		$elem('grid_propertyservicemanagerFkcode',pageId).grid('pReload');
   	 </youi:func>
   	 <!-- 拒绝申请 -->
   	 <youi:func name="func_grid_refuse">
		var gridElement = $elem('grid_propertyservicemanagerFkcode',pageId);
		var	selectedRecord = gridElement.grid('getSelectedRecord');
		var status = selectedRecord.applyStatus ;
		if('01' == status){//如果当前状态为申请状态，则可以拒绝
			var fkcodeId = selectedRecord.fkcodeId ;
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerFkcodeManager/updateFkcode.json',
				data:{fkcodeId:fkcodeId,code:'01'},//01表示拒绝
				success:function(result){
					alert("操作成功！") ;
                } 
       		});
		}else if('02' == status){
			alert("申请成功后无法拒绝") ;
		}else{
			alert("此状态已经是拒绝状态！") ;
		}
		$elem('grid_propertyservicemanagerFkcode',pageId).grid('pReload');
   	 </youi:func>
   	 <!-- 提交后，刷新页面 -->
   	 <youi:func name = "form_propertyservicemanagerFkcode_afterSubmit">
			var formPropertyservicemanagerFkcode = $elem('form_propertyservicemanagerFkcode',pageId);
			formPropertyservicemanagerFkcode.form('close');
			$elem('grid_propertyservicemanagerFkcode',pageId).grid('pReload');
	</youi:func>
	<!-- 修改表单提交后后，关闭该表单，并刷新页面 -->
	<youi:func name = "form_fkcode_afterSubmit">
			var formFkcode = $elem('form_fkcode',pageId);
			formFkcode.form('close');
			$elem('grid_propertyservicemanagerFkcode',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>