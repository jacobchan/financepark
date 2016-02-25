<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:table columns="1">
		<youi:cell>
			<youi:grid id="grid_propertyservicemanagerBx" idKeys="bxId" caption="物业报修记录列表"  panel="false"
						src="esb/web/propertyservicemanagerBxManager/getPagerPropertyservicemanagerBxs.json" dataFormId="form_propertyservicemanagerBx"
						editSrc="esb/web/propertyservicemanagerBxManager/getPropertyservicemanagerBx.json" 
						edit="NOT" remove="NOT" showCheckbox="true"	height="420" 
						removeSrc="esb/web/propertyservicemanagerBxManager/removePropertyservicemanagerBx.json">
				<youi:fieldLayout labelWidths="120,120">
					<%-- <youi:fieldText property="bxRemark"  caption="描述"/>
					<youi:fieldText property="bxAddress"  caption="维修地址"/> --%>
					<youi:fieldSelect property="bxStatus"  caption="报修状态" convert="bx_status"/>
					<youi:fieldSelect property="bxWay"  caption="报修方式" convert="bx_way"/>
					<youi:fieldSelect property="bxType"  caption="报修类型" convert="bx_type"/>
					
					<youi:fieldSelect property="bxProject"  caption="报修项目" convert="bx_project"/>
				<%-- 	<youi:fieldText property="bxAmount"  caption="维修总价"/>
					<youi:fieldText property="bxFujian"  caption="附件"/> --%>
					<youi:fieldText property="bxComp"  caption="企业名称"/>
				</youi:fieldLayout>
					<youi:button name="refuse" caption="回绝" icon="edit" active="1"/>
					<youi:button name="deal" caption="处理任务" icon="edit" active="1"/>
					<youi:button name="pay" caption="支付订单" icon="edit" active="1"/>
					
				<youi:gridCol property="bxComp"  caption="企业名称" width="12%"/>
				<youi:gridCol property="bxAddress"  caption="维修地址" width="12%"/>
				<youi:gridCol property="bxStatus"  caption="报修状态" convert="bx_status" width="10%"/>
				<youi:gridCol property="bxWay"  caption="报修方式" width="8%" convert="bx_way"/>
				<youi:gridCol property="bxType"  caption="报修类型" width="8%" convert="bx_type"/>
				<youi:gridCol property="bxProject"  caption="报修项目" width="8%" convert="bx_project"/>
				<youi:gridCol property="bxRemark"  caption="描述" width="24%"/>
				<youi:gridCol property="bxAmount"  caption="维修总价" 	width="10%"/>
				<youi:gridCol property="bxFujian"  caption="附件" width="8%"/>
			
				<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
					<youi:button name="edit" caption="修改"/>
					<youi:button name="remove" caption="删除"/>
				</youi:gridCol>
			</youi:grid>
		</youi:cell>
		<youi:cell>
			<youi:grid id="grid_propertyservicemanagerTs" idKeys="tsId" caption="派工维修记录列表"  panel="false"
				src="esb/web/propertyservicemanagerTsManager/getPagerPropertyservicemanagerTssByBx.json" dataFormId="form_propertyservicemanagerTs"
				editSrc="esb/web/propertyservicemanagerTsManager/getPropertyservicemanagerTs.json" 
				edit="NOT" remove="NOT" submit="NOT" reset="NOT" showNum="true" add="NOT" height="320" 
				removeSrc="esb/web/propertyservicemanagerTsManager/removePropertyservicemanagerTs.json"
				parentId="grid_propertyservicemanagerBx" parentAttr="propertyservicemanagerBx">
				<youi:gridCol property="tsName"  caption="派工人员" width="15%"/>
				<youi:gridCol property="tsStatus"  caption="派工受理状态" width="15%" convert="ts_status"/>
				<youi:gridCol property="tsTelephone"  caption="派工人员电话号码" width="15%"/>
				<youi:gridCol property="propertyservicemanagerBx.bxComp" caption="报修企业" width="15%"/>
				<youi:gridCol property="propertyservicemanagerBx.bxRemark" caption="报修描述" width="20%"/>
				<youi:gridCol property="tsRemark"  caption="备注" width="20%"/>
			</youi:grid>
		</youi:cell>
	</youi:table>
	
	<!-- form-物业报修记录编辑 -->
	<youi:form dialog="true" caption="物业报修记录" id="form_propertyservicemanagerBx" action="esb/web/propertyservicemanagerBxManager/savePropertyservicemanagerBx.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="bxId" caption="ID"/>
			<%-- <youi:fieldText property="bxComp"  caption="企业名称"/> --%>
			<youi:fieldSelect property="bxComp" caption="企业名称" src="/memberInformationManager/getMemberInformations.json" code="memberName" show="memberName" notNull="true" />
			<youi:fieldLabel property="bxAddress"  caption="维修地址"/>
			<youi:fieldSelect property="bxStatus"  caption="报修状态" convert="bx_status"/>
			<youi:fieldSelect property="bxWay"  caption="报修方式" convert="bx_way"/>
			<youi:fieldSelect property="bxType"  caption="报修类型" convert="bx_type"/>
			<youi:fieldSelect property="bxProject"  caption="报修项目" convert="bx_project"/>
			<youi:fieldText property="bxAmount"  caption="维修总价" dataType="format" format="0,0.00"/>
			<youi:fieldUpload property="bxFujian"  caption="附件"/>
			<youi:fieldArea property="bxRemark"  caption="描述" column="3"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-派工维修记录编辑 -->
	<youi:form dialog="true" caption="派工维修记录" id="form_propertyservicemanagerTs" action="esb/web/propertyservicemanagerTsManager/savePropertyservicemanagerTs.json">
		<youi:fieldLayout prefix="recordTs" labelWidths="120,120">
			<youi:fieldHidden property="tsId"  caption="主键ID_"/>
			<youi:fieldText property="tsName"  caption="派工人员"/>
			<youi:fieldSelect property="tsStatus"  caption="派工受理状态" convert="ts_status" defaultValue="00"/>
			<youi:fieldText property="tsTelephone"  caption="派工人员电话号码"/>
			<youi:fieldText property="propertyservicemanagerBx.bxId" caption="报修记录单号"/>
			<youi:fieldArea property="tsRemark"  caption="备注" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
		<youi:func name="record_bxComp_change" params="value">
			if(value!=''){
				$.youi.ajaxUtil.ajax({
					url:'/esb/web/memberadrAddressManager/getAddressByname.json',
					data:{memberName:value},
					success:function(result){
							var record = result.record;
							$elem('record_bxAddress',pageId).fieldValue(record.addressDetail);
						}
					});
				
			}
			
		</youi:func> 
		<!-- 支付订单 -->
		<youi:func name="func_grid_refuse">
			var gridElement = $elem('grid_propertyservicemanagerBx',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var bxstatus = selectedRecord.bxStatus;
			if(bxstatus=='05'){
				$.youi.messageUtils.confirm('支付?',function(){
					$.youi.ajaxUtil.ajax({
					url:'/esb/web/propertyservicemanagerBxManager/upBxbyId.json',
					data:{id:selectedRecord.bxId,code:'00'},
					success:function(result){	
						$elem('grid_propertyservicemanagerBx',pageId).grid('pReload');
						alert("支付成功!");
						}
					});
				});
			}else if(bxstatus=='06'){
				alert("已支付成功!");
			}else{
				alert("已定价的记录才可以支付");
			}	
		</youi:func>
		<!-- 回绝物业报修 -->
		<youi:func name="func_grid_refuse">
			var gridElement = $elem('grid_propertyservicemanagerBx',pageId),
			selectedRecord = gridElement.grid('getSelectedRecord');
			var bxstatus = selectedRecord.bxStatus;
			if(bxstatus=='00'){
				$.youi.messageUtils.confirm('回绝报修?',function(){
					$.youi.ajaxUtil.ajax({
					url:'/esb/web/propertyservicemanagerBxManager/upBxbyId.json',
					data:{id:selectedRecord.bxId,code:'01'},
					success:function(result){	
						$elem('grid_propertyservicemanagerBx',pageId).grid('pReload');
						alert("回绝成功!");
						}
					});
				});
			}else if(bxstatus=='08'){
				alert("已回绝!");
			}else{
				alert("该状态下不能回绝报修请求");
			}	
		</youi:func>
		<!-- 流程处理物业报修 -->
		<youi:func name="func_grid_deal">
            $.youi.messageUtils.confirm('处理任务?',function(){
                var gridElement = $elem('grid_propertyservicemanagerBx',pageId),
                selectedRecord = gridElement.grid('getSelectedRecord');
                var bxstatus = selectedRecord.bxStatus;
				//待受理
                if(bxstatus=='00'){
                    $.youi.ajaxUtil.ajax({
                        url:'/esb/web/propertyservicemanagerBxManager/upBxbyId.json',
                        data:{id:selectedRecord.bxId,code:'00'},
                        success:function(result){    
                            $elem('grid_propertyservicemanagerBx',pageId).grid('pReload');
                            alert("处理成功!!");
                        }
                    });
				//已受理，进行派工
                }else if(bxstatus=='01'){
                    //$elem('recordTs_propertyservicemanagerBx_bxId',pageId).fieldValue(selectedRecord.bxId);
                    $elem('form_propertyservicemanagerTs',pageId).form("reset")
					.form('fillRecord',{propertyservicemanagerBx:{bxId:selectedRecord['bxId']}}).form('open');
				//已接单，
                }else if(bxstatus=='02'||bxstatus=='03'){
                    alert("维修人员处理中!");
				//已完工，待定价
                }else if(bxstatus=='04'){
                    var bxform = $elem('form_propertyservicemanagerBx',pageId);
                    bxform.form("reset").form('fillRecord',selectedRecord).form('fillRecord',{bxStatus:'05'}).form('open');
				//已定价，待付款
                }else if(bxstatus=='05'){
					alert("请等待报修人付款!");
				//已付款
				}else if(bxstatus=='06'){
					 $.youi.ajaxUtil.ajax({
                        url:'/esb/web/propertyservicemanagerBxManager/upBxbyId.json',
                        data:{id:selectedRecord.bxId,code:'00'},
                        success:function(result){    
                            $elem('grid_propertyservicemanagerBx',pageId).grid('pReload');
                            alert("处理成功!");
                        }
                    });
				//已完工
				}else if(bxstatus=='07'){
					alert("报修已完成!");
				}else{
                    alert("已拒单!");
                }
            });
        </youi:func>
        
        <youi:func name = "form_propertyservicemanagerTs_afterSubmit">
			var formpropertyservicemanagerTs = $elem('form_propertyservicemanagerTs',pageId);
			alert("派工完成！");
			formpropertyservicemanagerTs.form('close');
			$elem('grid_propertyservicemanagerBx',pageId).grid('pReload');
		</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>