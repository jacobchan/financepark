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
				<youi:button name="acceptance" caption="受理" icon="search" active="1" />
				<youi:button name="govisit" caption="回访" icon="save" active="1" />
				<youi:button name="evaluate" caption="评价" icon="edit" active="1" />
				<youi:gridCol property="cosCode" caption="投诉单号" width="16%" />
				<youi:gridCol property="backcode" caption="回访单号" width="16%" />
				<youi:gridCol property="cosContent" caption="投诉内容" width="15%" />
				<youi:gridCol property="backrecord" caption="回访内容" width="15%" />
				<youi:gridCol property="cosName" caption="投诉联系人" width="10%" />
				<youi:gridCol property="cosStatus" caption="投诉状态" convert="acceptanceStatus" width="8%" />
				<youi:gridCol property="cosTime" caption="投诉时间" width="10%" />
				<youi:gridCol property="backtime" caption="回访时间" width="10%" />
				<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
					<youi:button name="edit" caption="修改" />
					<youi:button name="remove" caption="删除" />
				</youi:gridCol>
			</youi:grid>
		</youi:cell>
		<!--<youi:cell>
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
				<youi:gridCol property="propertyservicemanagerCos.cosCode" caption="投诉单号" width="25%" />
				<youi:gridCol property="backCode" caption="回访单号" width="25%" />
				<youi:gridCol property="backRecord" caption="回访记录" width="50%" />
				<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
					<youi:button name="edit" caption="修改" />
					<youi:button name="remove" caption="删除" />
				</youi:gridCol>
			</youi:grid>
		</youi:cell>-->
	</youi:table>
	<!-- form-物业投诉记录表编辑 -->
	<youi:form dialog="true" caption="物业投诉记录表"
		id="form_propertyservicemanagerCos"
		action="esb/web/propertyservicemanagerCosManager/savePropertyservicemanagerCos.json">
		<youi:fieldLayout prefix="recordRecode" labelWidths="120,120">
			<youi:fieldHidden property="cosId" caption="投诉ID" />
			<youi:fieldText property="cosName" caption="投诉联系人" />
			<youi:fieldSelect property="memberInformation.memberId"
				src="esb/web/memberInformationManager/getMemberInformations.json"
				code="memberId" show="memberNickname" caption="会员用户" notNull="true" />
			<youi:fieldSelect property="cosBool" caption="是否接受回访" notNull="true"
				convert="isAbleVisible" />
			<youi:fieldText property="cosTelephone" caption="回访电话" />
			<youi:fieldCalendar property="cosTime" caption="投诉时间" notNull="true"
				format="yyyy-MM-dd" />
			<youi:fieldCalendar property="backtime" caption="回访时间" notNull="true"
				format="yyyy-MM-dd" />
			<youi:fieldArea property="cosContent" caption="投诉内容" rows="8"
				column="20" tooltips="投诉内容" notNull="true" />
			<youi:fieldArea property="backrecord" caption="回访内容" rows="8"
				column="20" tooltips="回访内容" notNull="true" />
		</youi:fieldLayout>
	</youi:form>

	<!-- form-投诉回访记录表 -->
	<youi:form dialog="true" caption="投诉回访记录表"
		id="form_propertyservicenanagerBack"
		action="esb/web/propertyservicemanagerCosManager/updatePropertyservicemanagerCos.json" width="600">
		<youi:fieldLayout prefix="recordVisit" columns="1"
			labelWidths="120,120">
			<youi:fieldHidden property="cosId" caption="投诉编号" />
			<youi:fieldArea property="backrecord" caption="回访记录" rows="8" column="20" tooltips="回访记录" notNull="true" />
		</youi:fieldLayout>
	</youi:form>

	<!-- form-评价投诉 -->
	<youi:form dialog="true" caption="投诉评价"
		id="form_evaluationcomplaints"
		action="esb/web/propertyservicemanagerCosManager/upCosbyId.json" width="350">
		<youi:fieldLayout prefix="recordevaluation" columns="1" labelWidths="150">
			<youi:fieldHidden property="id" caption="投诉编号" />
			<youi:fieldSelect property="code" caption="对投诉回访是否满意" notNull="true" defaultValue="6">
				<youi:fieldOption caption="满意并评价" value="6"></youi:fieldOption>
			</youi:fieldSelect>
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->
	<!-- 受理操作 -->
	<youi:func name="func_grid_acceptance">
		var gridElement = $elem('grid_propertyservicemanagerCos',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var cosstatus = selectedRecord.cosStatus;
		if(cosstatus=='0'){
			$.youi.messageUtils.confirm('确定受理此投诉?',function(){
				$.youi.ajaxUtil.ajax({
					url:'/esb/web/propertyservicemanagerCosManager/upCosbyId.json',
					data:{id:selectedRecord.cosId,code:'2'},
					success:function(result){	
						$elem('grid_propertyservicemanagerCos',pageId).grid('pReload');
						alert("操作成功!");
					}
				});
			});
		}else if(cosstatus=='2'){
			alert("该记录已在受理中!");
		}else{
			alert("该状态下不能作受理操作！");
		}
	</youi:func>
	<!-- 回访操作 -->
	<youi:func name="func_grid_govisit">
		var gridElement = $elem('grid_propertyservicemanagerCos',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var cosstatus = selectedRecord.cosStatus;
		if(cosstatus=='2' || cosstatus=='3'){
			$.youi.messageUtils.confirm('确定此投诉已回访?',function(){
				$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerCosManager/upCosbyId.json',
				data:{id:selectedRecord.cosId,code:'4'},
				success:function(result){	
					$elem('grid_propertyservicemanagerCos',pageId).grid('pReload');
						alert("操作成功!");
						$elem('recordVisit_cosId',pageId).fieldValue(selectedRecord.cosId);
        				$elem('form_propertyservicenanagerBack',pageId).form('open');
					}
				});
			});
		}else if(cosstatus=='4'){
			alert("该记录已回访!");
		}else{
			alert("该状态下不能作回访处理！");
		}
	</youi:func>
	<!-- 评价操作 -->
	<youi:func name="func_grid_evaluate">
		var gridElement = $elem('grid_propertyservicemanagerCos',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var cosstatus = selectedRecord.cosStatus;
		if(cosstatus=='4'){
			$elem('recordevaluation_id',pageId).fieldValue(selectedRecord.cosId);
			$elem('form_evaluationcomplaints',pageId).form('open');
		}else if(cosstatus=='6'){
			alert("该记录已评价!");
		}else{
			alert("该状态下不能作评价处理！");
		}
	</youi:func>
	<!-- 添加回访表单提交后事件 -->
	<youi:func name="form_propertyservicenanagerBack_afterSubmit">
		var propertyservicenanagerBack = $elem('form_propertyservicenanagerBack',pageId);
		propertyservicenanagerBack.form('reset');
		propertyservicenanagerBack.form('close');
		$elem('grid_propertyservicenanagerBack',pageId).grid('pReload');
		$elem('grid_propertyservicemanagerCos',pageId).grid('pReload');
	</youi:func>
	<!-- 添加回访表单提交后事件 -->
	<youi:func name="form_evaluationcomplaints_afterSubmit">
		var evaluationcomplaints = $elem('form_evaluationcomplaints',pageId);
		evaluationcomplaints.form('reset');
		evaluationcomplaints.form('close');
		$elem('grid_propertyservicenanagerBack',pageId).grid('pReload');
		$elem('grid_propertyservicemanagerCos',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>