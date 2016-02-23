<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:table columns="1">
		<youi:cell>
			<youi:grid id="grid_propertyservicemanagerCos" idKeys="cosId"
				caption="物业投诉记录表列表" panel="false"
				src="esb/web/propertyservicemanagerCosManager/getPagerPropertyservicemanagerCoss.json"
				dataFormId="form_propertyservicemanagerCos"
				editSrc="esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCos.json"
				edit="NOT" remove="NOT" height="436"
				removeSrc="esb/web/propertyservicemanagerCosManager/removePropertyservicemanagerCos.json">
				<youi:fieldLayout labelWidths="120,120">
					<youi:fieldText property="cosCode" caption="投诉单号" />
					<youi:fieldText property="cosName" caption="投诉联系人" />
					<youi:fieldSelect property="memberId"
						src="esb/web/memberInformationManager/getMemberInformations.json"
						code="memberId" show="memberNickname" caption="会员用户" />
					<youi:fieldSelect property="cosStatus" caption="投诉受理状态"
						convert="acceptanceStatus" />
					<youi:fieldSelect property="cosBool" caption="是否接受回访"
						convert="isAbleVisible" />
					<youi:fieldText property="cosTelephone" caption="回访电话" />
					<youi:fieldCalendar property="cosTime" caption="投诉时间"
						format="yyyy-MM-dd" />
				</youi:fieldLayout>
				<youi:button name="invalid" caption="无效" icon="remove" active="1" />
				<youi:button name="visitrecord" caption="添加回访记录" icon="save"
					active="1" />
				<youi:gridCol property="cosCode" caption="投诉单号" width="100" />
				<youi:gridCol property="cosContent" caption="投诉内容" width="280" />
				<youi:gridCol property="cosName" caption="投诉联系人" width="100" />
				<youi:gridCol property="memberInformation.memberNickname" caption="会员用户" width="100" />
				<youi:gridCol property="cosStatus" caption="投诉受理状态"
					convert="acceptanceStatus" width="100" />
				<youi:gridCol property="cosBool" caption="是否接受回访"
					convert="isAbleVisible" width="100" />
				<youi:gridCol property="cosTelephone" caption="回访电话" width="100" />
				<youi:gridCol property="cosTime" caption="投诉时间" width="120" />
				<youi:gridCol width="60" fixed="true" property="button"
					type="button" caption="操作">
					<youi:button name="edit" caption="修改" />
					<youi:button name="remove" caption="删除" />
				</youi:gridCol>
			</youi:grid>
		</youi:cell>
		<youi:cell>
			<youi:grid id="grid_propertyservicenanagerBack" idKeys="backId"
				caption="投诉回访记录表列表" panel="false"
				src="esb/web/propertyservicenanagerBackManager/getPagerPropertyservicenanagerBacksByCos.json"
				dataFormId="form_propertyservicenanagerBack"
				editSrc="esb/web/propertyservicenanagerBackManager/getPropertyservicenanagerBack.json"
				edit="NOT" remove="NOT" submit="NOT" reset="NOT" add="NOT"
				height="280"
				removeSrc="esb/web/propertyservicenanagerBackManager/removePropertyservicenanagerBack.json"
				parentId="grid_propertyservicemanagerCos"
				parentAttr="propertyservicemanagerCos">
				<youi:gridCol property="propertyservicemanagerCos.cosCode"
					caption="投诉单号" width="180" />
				<youi:gridCol property="backCode" caption="回访单号" width="160" />
				<youi:gridCol property="backRecord" caption="回访记录" width="380" />
				<youi:gridCol width="60" fixed="true" property="button"
					type="button" caption="操作">
					<youi:button name="edit" caption="修改" />
					<youi:button name="remove" caption="删除" />
				</youi:gridCol>
			</youi:grid>
		</youi:cell>
	</youi:table>
	<!-- form-物业投诉记录表编辑 -->
	<youi:form dialog="true" caption="物业投诉记录表"
		id="form_propertyservicemanagerCos"
		action="esb/web/propertyservicemanagerCosManager/savePropertyservicemanagerCos.json">
		<youi:fieldLayout prefix="recordRecode" labelWidths="120,120">
			<youi:fieldHidden property="cosId" caption="投诉ID" />
			<youi:fieldText property="cosCode" caption="投诉单号" />
			<youi:fieldText property="cosName" caption="投诉联系人" />
			<youi:fieldSelect property="memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberNickname" caption="会员用户" />
			<youi:fieldSelect property="cosStatus" caption="投诉受理状态"
				convert="acceptanceStatus" />
			<youi:fieldSelect property="cosBool" caption="是否接受回访"
				convert="isAbleVisible" />
			<youi:fieldText property="cosTelephone" caption="回访电话" />
			<youi:fieldCalendar property="cosTime" caption="投诉时间"
				format="yyyy-MM-dd" />
			<youi:fieldArea property="cosContent" caption="投诉内容" rows="8"
				column="20" tooltips="投诉内容" notNull="true" />
		</youi:fieldLayout>
	</youi:form>

	<!-- form-投诉回访记录表 -->
	<youi:form dialog="true" caption="投诉回访记录表"
		id="form_propertyservicenanagerBack"
		action="esb/web/propertyservicenanagerBackManager/savePropertyservicenanagerBack.json">
		<youi:fieldLayout prefix="recordVisit" columns="1"
			labelWidths="120,120">
			<youi:fieldHidden property="backId" caption="回访ID" />
			<youi:fieldSelect property="propertyservicemanagerCos.cosId"
				src="esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCoss.json"
				code="cosId" show="cosCode" caption="投诉ID" notNull="true" />
			<youi:fieldText property="backCode" caption="回访单号" />
			<youi:fieldArea property="backRecord" caption="回访记录" rows="8"
				column="20" tooltips="回访记录" notNull="true" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_invalid">
		var gridElement = $elem('grid_propertyservicemanagerCos',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var cosstatus = selectedRecord.cosStatus;
		if(cosstatus=='0'){
			$.youi.messageUtils.confirm('确定无效处理?',function(){
				$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerCosManager/upCosbyId.json',
				data:{id:selectedRecord.cosId,code:'3'},
				success:function(result){	
					$elem('grid_propertyservicemanagerCos',pageId).grid('pReload');
						alert("操作成功!");
					}
				});
			});
		}else if(cosstatus=='3'){
			alert("该记录已无效!");
		}else{
			alert("该状态下不能作无效出来！");
		}	
	</youi:func>
	<youi:func name="func_grid_visitrecord">
		var gridElement = $elem('grid_propertyservicemanagerCos',pageId);
		selectedRecord = gridElement.grid('getSelectedRecord');
		$elem('recordVisit_propertyservicemanagerCos_cosId',pageId).fieldValue(selectedRecord.cosId);
        $elem('form_propertyservicenanagerBack',pageId).form('open');
	</youi:func>
	<youi:func name="form_propertyservicenanagerBack_afterSubmit">
		var propertyservicenanagerBack = $elem('form_propertyservicenanagerBack',pageId);
		propertyservicenanagerBack.form('close');
		$elem('grid_propertyservicenanagerBack',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>