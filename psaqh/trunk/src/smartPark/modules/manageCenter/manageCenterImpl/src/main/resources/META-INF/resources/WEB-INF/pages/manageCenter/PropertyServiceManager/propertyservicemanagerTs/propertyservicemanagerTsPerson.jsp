<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 跳转费用清单页面 -->
	<youi:subpage
		src="page/manageCenter.PropertyServiceManager.propertyservicemanagerTs/addSer.html" 
		subpageId="addSer" height="500" caption="维修费用清单新增">
	</youi:subpage>
	<youi:table columns="1">
		<youi:cell>
			<youi:grid id="grid_propertyservicemanagerTs" idKeys="tsId" caption="派工维修记录列表"  panel="false"
						src="esb/web/propertyservicemanagerTsManager/getPropertyTs.json" dataFormId="form_propertyservicemanagerTs"
						editSrc="esb/web/propertyservicemanagerTsManager/getPropertyservicemanagerTs.json" edit="NOT" remove="NOT" showCheckbox="true" height="400"
						removeSrc="esb/web/propertyservicemanagerTsManager/removePropertyservicemanagerTs.json">
				<youi:fieldLayout labelWidths="120,120">
					<youi:fieldSelect property="tsStatus"  caption="派工受理状态" convert="ts_status"/>
					<youi:fieldText property="tsTelephone"  caption="派工人员电话号码"/>
					<youi:fieldText property="tsName"  caption="派工人员"/>
				</youi:fieldLayout>
				<youi:button name="agree" caption="接单" icon="edit" active="1"/>
				<youi:button name="refuse" caption="拒单" icon="edit" active="1"/>
				<youi:button name="putfrom" caption="填报维修费用清单" icon="edit" active="1"/>
				
				<youi:gridCol property="tsName"  caption="派工人员" width="12%"/>
				<youi:gridCol property="tsStatus"  caption="派工受理状态" width="12%" convert="ts_status"/>
				<youi:gridCol property="tsTime"  caption="接单时间" width="10%"/>
				<youi:gridCol property="tsTelephone"  caption="派工人员电话号码" width="12%"/>
				<youi:gridCol property="propertyservicemanagerBx.bxComp" caption="报修企业" width="12%"/>
				<youi:gridCol property="propertyservicemanagerBx.bxRemark" caption="报修描述" width="18%"/>
				<youi:gridCol property="tsRemark"  caption="备注" width="20%"/>
				<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
					<youi:button name="edit" caption="修改"/>
					<youi:button name="remove" caption="删除"/>
				</youi:gridCol>
			</youi:grid>
	</youi:cell>
		
	<youi:cell>
		<youi:grid id="grid_propertyservicemanagerSer" idKeys="serId" caption="费用清单列表"  panel="false"
				src="esb/web/propertyservicemanagerSerManager/getPagerPropertyservicemanagerSersByTs.json" dataFormId="form_propertyservicemanagerSer"
				editSrc="esb/web/propertyservicemanagerSerManager/getPropertyservicemanagerSer.json" edit="NOT" remove="NOT" showNum="true" add="NOT"
				reset="NOT" height="320" submit="NOT" parentId="grid_propertyservicemanagerTs" parentAttr="propertyservicemanagerTs"
				removeSrc="esb/web/propertyservicemanagerSerManager/removePropertyservicemanagerSer.json">
			<youi:gridCol property="propertyservicemanagerTs.tsName" caption="维修人" width="10%"/>
			<youi:gridCol property="propertyservicemanagerTs.tsTelephone" caption="维修人电话" width="15%"/>
			<youi:gridCol property="propertyservicemanagerTs.propertyservicemanagerBx.bxComp" caption="报修企业" width="20%"/>
			<youi:gridCol property="serName"  caption="材料名称" width="20%" convert="ser_name"/>
			<youi:gridCol property="serPrice"  caption="材料价格" width="10%"/>
			<youi:gridCol property="serType"  caption="材料类别" width="15%" convert="ser_type"/>
		</youi:grid>
	</youi:cell>
	</youi:table>
	<!-- form-派工维修记录编辑 -->
	<youi:form dialog="true" caption="派工维修记录" id="form_propertyservicemanagerTs" action="esb/web/propertyservicemanagerTsManager/savePropertyservicemanagerTs.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="tsId"  caption="主键ID_"/>
			<youi:fieldText property="tsName"  caption="派工人员"/>
			<youi:fieldSelect property="tsStatus"  caption="派工受理状态" convert="ts_status" defaultValue="00"/>
			<youi:fieldText property="tsTelephone"  caption="派工人员电话号码"/>
			<youi:fieldText property="propertyservicemanagerBx.bxId" caption="报修记录单号"/>
			<youi:fieldArea property="tsRemark"  caption="备注" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	<!-- form-拒单回填 -->
	<youi:form dialog="true" caption="拒单" id="form_refuseTs" action="esb/web/propertyservicemanagerTsManager/savePropertyservicemanagerTs.json">
		<youi:fieldLayout prefix="recordrefuse" labelWidths="120,120">
			<youi:fieldHidden property="tsId"  caption="主键ID_"/>
			<youi:fieldHidden property="propertyservicemanagerBx.bxId" caption="报修记录单号"/>
			<youi:fieldSelect property="tsStatus"  caption="派工受理状态" convert="ts_status" readonly="true"/>
			<youi:fieldArea property="tsRemark"  caption="备注" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
		<!-- form-费用清单编辑 -->
	<youi:form dialog="true" caption="费用清单" id="form_propertyservicemanagerSer" action="esb/web/propertyservicemanagerSerManager/savePropertyservicemanagerSer.json">
		<youi:fieldLayout prefix="recordSer" labelWidths="100,100">
			<youi:fieldText property="propertyservicemanagerTs.tsId"  caption="派工ID"/>
			<youi:fieldSelect property="serName"  caption="材料名称" convert="ser_name"/>
			<youi:fieldSelect property="serType"  caption="材料类别" convert="ser_type"/>
			<youi:fieldText property="serPrice"  caption="材料价格" dataType="format" format="0,0.00"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<!-- 派工人员接单 -->
	<youi:func name="func_grid_agree">
			var gridElement = $elem('grid_propertyservicemanagerTs',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var tsstatus = selectedRecord.tsStatus;
			//待接单
			if(tsstatus=='00'){
				$.youi.messageUtils.confirm('确认接单?',function(){
					$.youi.ajaxUtil.ajax({
					url:'/esb/web/propertyservicemanagerTsManager/upTsbyId.json',
					data:{id:selectedRecord.tsId,code:'00'},
					success:function(result){	
						$elem('grid_propertyservicemanagerTs',pageId).grid('pReload');
						alert("接单成功!");
						}
					});
				});
			}else if(tsstatus=='01'){
				alert("您已接单!");
			}else if(tsstatus=='03'){
				alert("已处理!");
			}else{
				alert("派工单已拒绝!");
			}	
		</youi:func>
		<!-- 派工人员拒单 -->
		<youi:func name="func_grid_refuse">
			var gridElement = $elem('grid_propertyservicemanagerTs',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var tsstatus = selectedRecord.tsStatus;
			if(tsstatus=='00'){
				$.youi.messageUtils.confirm('确认拒单?',function(){
				$elem('form_refuseTs',pageId).form("reset").form('fillRecord',selectedRecord)
					.form('fillRecord',{tsStatus:'02'}).form('open');
					
					/*$.youi.ajaxUtil.ajax({
					url:'/esb/web/propertyservicemanagerTsManager/upTsbyId.json',
					data:{id:selectedRecord.tsId,code:'01'},
					success:function(result){	
						$elem('grid_propertyservicemanagerTs',pageId).grid('pReload');
						alert("拒单成功!");
						}
					});*/
				});
			}else if(tsstatus=="01"){
				alert("您已接单!");
			}else if(tsstatus=="03"){
				alert("已处理!");
			}else{
				alert("您已拒单!");
			}
		</youi:func>
		<!-- 派工人员填报维修单 -->
		<youi:func name="func_grid_putfrom">
			var gridElement = $elem('grid_propertyservicemanagerTs',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var tsstatus = selectedRecord.tsStatus;
			if(tsstatus=="01"){
				//$elem('form_propertyservicemanagerSer',pageId).form("reset").form('fillRecord',{propertyservicemanagerTs:{tsId:selectedRecord['tsId']}}).form('open');
				var gridElement = $elem('grid_propertyservicemanagerTs',pageId);
				var subpageElement = $elem('subpage_addSer',pageId);
				var selectedRecord = gridElement.grid('getSelectedRecord');
				//打开子页面
				subpageElement.subpage('open',{tsId:selectedRecord.tsId});
			}else{
				alert("只有接单成功才能填报!");
			}

			
		</youi:func>
		
		<!-- 维修费用清单填报完成 -->
		<youi:func name = "form_propertyservicemanagerSer_afterSubmit">
			var formpropertyservicemanagerSer = $elem('form_propertyservicemanagerSer',pageId);
			alert("添加完成！");
			formpropertyservicemanagerSer.form('close');
			$elem('grid_propertyservicemanagerTs',pageId).grid('pReload');
		</youi:func>
		<youi:func name = "form_refuseTs_afterSubmit">
			var formrefuseTs = $elem('form_refuseTs',pageId);
			alert("拒单成功！");
			formrefuseTs.form('close');
			$elem('grid_propertyservicemanagerTs',pageId).grid('pReload');
		</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>