<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_entrepreneurship" idKeys="id" caption="340703创业加速申请列表"  panel="false"
				src="esb/web/entrepreneurshipManager/getPagerEntrepreneurships.json" dataFormId="form_entrepreneurship"
				editSrc="esb/web/entrepreneurshipManager/getEntrepreneurship.json" edit="NOT" add="NOT" remove="NOT" showCheckbox="false"
				removeSrc="esb/web/entrepreneurshipManager/removeEntrepreneurship.json">
		<youi:fieldLayout columns="1">
			<youi:fieldText property="applayNo"  caption="申请编号" operator="LIKE"/>
			<youi:fieldSelect property="applayStatus"   convert="applayStatus" caption="申请状态"></youi:fieldSelect>
		</youi:fieldLayout>
		
		<youi:gridCol property="applayNo"  caption="申请编号" width="12%"/>
		<youi:gridCol property="applayStatus"  convert="applayStatus" caption="申请状态" width="10%"/>
		<youi:gridCol property="projectType"  convert="projectType"  caption="项目类型" width="10%"/>
		<youi:gridCol property="projectDis"  caption="项目简介" width="28%"/>
		<youi:gridCol property="teacherType"  caption="导师类型" width="10%" renderer="renderer_teacherType"/>
		<youi:gridCol property="memberId"  caption="会员用户ID" width="10%" renderer="renderer_memberName"/>
		<youi:gridCol property="createTime"  caption="创建时间" width="10%"/>
		<youi:gridCol property="isFinace" convert="bool" caption="是否融资" width="10%"/>
		
		<youi:button name="cancel" caption="取消" icon="edit"></youi:button> 
	</youi:grid>
	
	<!-- form-340703创业加速申请编辑 -->
	<youi:form dialog="true" caption="340703创业加速申请" id="form_entrepreneurship" action="esb/web/entrepreneurshipManager/saveEntrepreneurship.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="applayStatus"  caption="申请状态"/>
			<youi:fieldText property="applayNo"  caption="申请编号"/>
			<youi:fieldText property="projectType"  caption="项目类型"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="updateUser"  caption="修改人"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="teacherType"  caption="导师类型"/>
			<youi:fieldText property="projectDis"  caption="项目简介"/>
			<youi:fieldText property="createUser"  caption="创建人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="id"  caption="ID_"/>
			<youi:fieldText property="isFinace"  caption="是否融资"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<!-- 获取用户名称 -->
	<youi:func name="renderer_memberName" params="col,record">
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
	
	<!-- 获取导师类型名称 -->
	<youi:func name="renderer_teacherType" params="col,record">
 		var teacherType = record.teacherType;
		var teacherTypeName = ""; 
 		$.youi.ajaxUtil.ajax({
 			url:'esb/web/entrepreneurshipManager/getTeacherTypeName.json',
 			data:'id='+record.id,
			async: false, 
 			success:function(result){
				teacherTypeName = result.record.html;
 			}
 		});
 		return teacherTypeName;
	</youi:func>
	
	<!-- 取消该条申请 -->
	<youi:func name = "func_grid_cancel">
        var gridElement = $elem('grid_entrepreneurship',pageId);
		var selectedRecord = gridElement.grid('getSelectedRecord');
  		var id=selectedRecord.id;
        var applayStatus = selectedRecord.applayStatus;
		 if(applayStatus != '03'){//03:已取消
             $.youi.ajaxUtil.ajax({
				url:'/esb/web/entrepreneurshipManager/goCancel.json',
				data:{id:id},
				success:function(result){
					alert("成功取消");
                    $elem('grid_entrepreneurship',pageId).grid('pReload');
                  } 
            })
        }else{
            alert("该状态不能进行取消操作");

        }
       
	
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>