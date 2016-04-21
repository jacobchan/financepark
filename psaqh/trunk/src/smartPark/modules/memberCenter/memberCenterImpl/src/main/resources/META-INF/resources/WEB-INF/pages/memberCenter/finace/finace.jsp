<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_finace" idKeys="id" caption="340702融资申请列表"  panel="false"
				src="esb/web/finaceManager/getPagerFinaces.json" dataFormId="form_finace"
				editSrc="esb/web/finaceManager/getFinace.json" edit="NOT" add="NOT" remove="NOT" showCheckbox="false"
				removeSrc="esb/web/finaceManager/removeFinace.json">
		<youi:fieldLayout columns="1">
			<youi:fieldText property="applayNo"  caption="申请编号"/>
			<youi:fieldSelect property="applayStatus"   convert="applayStatus" caption="申请状态"></youi:fieldSelect>
		</youi:fieldLayout>
		<youi:gridCol property="applayNo"  caption="申请编号"/>
		<youi:gridCol property="companyName"  caption="公司名称"/>
		<youi:gridCol property="companyAdr"  caption="公司地址"/>
		<youi:gridCol property="amountStart"  caption="融资额度起"/>
		<youi:gridCol property="amountEnd"  caption="融资额度止"/>
		<youi:gridCol property="shareRate"  caption="股份占比"/>
		<youi:gridCol property="businessDis"  caption="业务简介"/>
		<youi:gridCol property="companyMerite"  caption="公司优势"/>
		<youi:gridCol property="corTeam"  caption="核心成员"/>
		<youi:gridCol property="bpUrl"  caption="BPURL"/>
		<youi:gridCol property="applayStatus" convert="applayStatus" caption="申请状态"/>
		<youi:gridCol property="memberId"  caption="会员用户ID" renderer="renderer_memberName"/>
		
		<youi:button name="cancel" caption="取消" icon="edit"></youi:button> 
	</youi:grid>
	
	<!-- form-340702融资申请编辑 -->
	<youi:form dialog="true" caption="340702融资申请" id="form_finace" action="esb/web/finaceManager/saveFinace.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="amountEnd"  caption="融资额度止"/>
			<youi:fieldText property="createUser"  caption="创建人"/>
			<youi:fieldText property="businessDis"  caption="业务简介"/>
			<youi:fieldText property="updateUser"  caption="修改人"/>
			<youi:fieldText property="companyName"  caption="公司名称"/>
			<youi:fieldText property="shareRate"  caption="股份占比"/>
			<youi:fieldText property="companyAdr"  caption="公司地址"/>
			<youi:fieldText property="applayStatus"  caption="申请状态"/>
			<youi:fieldText property="companyMerite"  caption="公司优势"/>
			<youi:fieldText property="bpUrl"  caption="BPURL"/>
			<youi:fieldText property="id"  caption="ID_"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="amountStart"  caption="融资额度起"/>
			<youi:fieldText property="corTeam"  caption="核心成员"/>
			<youi:fieldText property="applayNo"  caption="申请编号"/>
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
	
	<!-- 取消该条申请 -->
	<youi:func name = "func_grid_cancel">
        var gridElement = $elem('grid_finace',pageId);
		var selectedRecord = gridElement.grid('getSelectedRecord');
  		var id=selectedRecord.id;
        var applayStatus = selectedRecord.applayStatus;
		 if(applayStatus != '03'){//03:已取消
             $.youi.ajaxUtil.ajax({
				url:'/esb/web/finaceManager/goCancel.json',
				data:{id:id},
				success:function(result){
					alert("成功取消");
                    $elem('grid_finace',pageId).grid('pReload');
                  } 
            })
        }else{
            alert("该状态不能进行取消操作");

        }
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>