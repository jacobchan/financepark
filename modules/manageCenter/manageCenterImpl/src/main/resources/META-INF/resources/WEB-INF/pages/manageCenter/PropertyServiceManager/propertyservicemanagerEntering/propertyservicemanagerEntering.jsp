<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:subpage
		src="page/manageCenter.PropertyServiceManager.propertyservicemanagerEntering/addPropertyEnteringManage.html" 
		subpageId="addEntering" height="600" caption="可办理预约记录增加">
	</youi:subpage>

	<youi:grid id="grid_propertyservicemanagerEntering" idKeys="enteringId" caption="可办理预约记录列表"  panel="false" add="NOT"
				src="esb/web/propertyservicemanagerEnteringManager/getPagerPropertyservicemanagerEnterings.json" dataFormId="form_propertyservicemanagerEntering"
				editSrc="esb/web/propertyservicemanagerEnteringManager/getPropertyservicemanagerEntering.json" edit="NOT" remove="NOT" showCheckbox="true" ctrlCheck="false"
				removeSrc="esb/web/propertyservicemanagerEnteringManager/removePropertyservicemanagerEntering.json">
		<youi:fieldLayout labelWidths="110,110">
			<youi:fieldSelect property="enteringStatus"  caption="可预约状态" convert="enteringStatus"/>
			<youi:fieldSelect property="enteringTime"  caption="预约时间段" convert="enteringTime"/>
           <%--  <youi:fieldText property="enteringRemain"  caption="剩余数量"/>
			<youi:fieldText property="enteringAlre"  caption="已预约数"/>
			<youi:fieldText property="enteringSum"  caption="预约总量"/> --%>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:gridCol property="enteringDate"  caption="预约时间日期" width="30%" align="center" orderBy="desc"/>
		<youi:gridCol property="enteringTime"  caption="预约时间段" convert="enteringTime" width="20%" align="center"/>
		<youi:gridCol property="enteringSum"  caption="预约总量" width="10%" align="right"/>
		<youi:gridCol property="enteringAlre"  caption="已预约数" width="10%" align="right"/>
		<youi:gridCol property="enteringRemain"  caption="剩余数量" width="10%" align="right"/>
		<youi:gridCol property="enteringStatus"  caption="可预约状态" convert="enteringStatus"  width="20%" align="center"/>
		<youi:button name="enteringAdd" caption="增加"/>
		<youi:button name="enteringDelete" caption="批量删除"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-可办理预约记录编辑 -->
	<youi:form dialog="true" caption="可办理预约记录" id="form_propertyservicemanagerEntering" action="esb/web/propertyservicemanagerEnteringManager/savePropertyservicemanagerEntering.json">
		<youi:fieldLayout prefix="record" labelWidths="90,100">
			<%-- <youi:fieldSelect property="enteringStatus"  caption="可预约状态" convert="enteringStatus" notNull="true"/> --%>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd" notNull="true"/>
			<youi:fieldText property="enteringSum"  caption="预约总量" expression="^[0-9]*$" expressionMessage="请输入数值" notNull="true"/>
			<youi:fieldLabel property="enteringRemain"  caption="剩余数量" />
			<youi:fieldLabel property="enteringAlre"  caption="已预约数" />
			<youi:fieldHidden property="enteringId"  caption="预约记录ID"/>
			<youi:fieldHidden property="enteringStatus"  caption="可预约状态"/>
			<youi:fieldHidden property="enteringTime"  caption="预约时间段"/>
			
		</youi:fieldLayout>
	</youi:form>
	   <!--**********************************页面函数Start:初次新增预约时，只需填预约总量，剩余数量和已预约数量默认********************************-->
	<youi:func name = "record_enteringSum_change">
      		var enteringId = $('#P_'+pageId+'_record_enteringId').fieldValue();
            var enteringAfter = $('#P_'+pageId+'_record_enteringSum').fieldValue();
            if(enteringId =="" || enteringId ==null){
               $('#P_'+pageId+'_record_enteringRemain').fieldValue(enteringAfter);
                $('#P_'+pageId+'_record_enteringAlre').fieldValue(0);
           }else{
			    $.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerEnteringManager/getPropertyservicemanagerEntering.json',
				data:{enteringId:enteringId},
				success:function(result){
                    var record = result.record;
                    var enteringSumBefore =record.enteringSum;
                    var enteringRemain =record.enteringRemain;
 					var enteringAlre =record.enteringAlre;
                    if(enteringSumBefore<enteringAfter){//预约总量增加
                    var diff=enteringAfter-enteringSumBefore;
					$('#P_'+pageId+'_record_enteringRemain').fieldValue(parseFloat(enteringRemain)+parseFloat(diff));

 					}else {
                        if(enteringSumBefore>enteringAfter){//预约总量减少
                            var diff=enteringSumBefore-enteringAfter;
 							$('#P_'+pageId+'_record_enteringRemain').fieldValue(parseFloat(enteringRemain)-parseFloat(diff));
						}
    				}
					
                 } 
            })

          }


    </youi:func>
    <!--**********************************页面函数End:初次新增预约时，只需填预约总量，剩余数量和已预约数量默认********************************-->
    
       <!--**********************************页面函数Start:选择预约日期，判断日期是否重复********************************-->
	<youi:func name = "record_enteringDate_change">
      		var enteringDate = $('#P_'+pageId+'_record_enteringDate').fieldValue();
           $.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerEnteringManager/exsitPropertyservicemanagerEnteringForDate.json',
				data:{propertyName:"enteringDate",value:enteringDate},
				success:function(result){
                    var record = result.record;
                 if(record.buff=="true"){
                     alert("该预约日期已经添加，无需重复添加！");
                     return false;

                  }
					
                 } 
            })

    </youi:func>
    <!--**********************************页面函数End:选择预约日期，判断日期是否重复********************************-->
    
    	<!--**********************************页面函数:增加可办理预约记录********************************-->
	
	<youi:func name="func_grid_enteringAdd">
		var gridElement = $elem('grid_propertyservicemanagerEntering',pageId);
		var subpageElement = $elem('subpage_addEntering',pageId);
		var selectedRecord = gridElement.grid('getSelectedRecord');
		//打开子页面
		subpageElement.subpage('open',null,null,null);
	</youi:func>
	
	<youi:func name="func_grid_enteringDelete" >
        var enteringId = $elem('record_sFpro_enteringId',pageId).fieldValue();
		var records = $elem('grid_propertyservicemanagerEntering',pageId).grid('getRecords','true');
		var submitRecord = {'records':records};
		var fieldValues = $.youi.recordUtils.recordToParameters(submitRecord);
		var params = '';
		for(var i=0;i<fieldValues.length;i++){
			if($.youi.stringUtils.notEmpty(fieldValues[i].value)){
				params = params+$.youi.parameterUtils.propertyParameter(fieldValues[i].property,fieldValues[i].value)+'&';
			}
		}
		params = params;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/propertyservicemanagerEnteringManager/removePropertyservicemanagerEnterings.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("删除成功!");
				$elem('grid_propertyservicemanagerEntering',pageId).grid('pReload');
			}
		});

	</youi:func>
	<!--**********************************页面函数:增加可办理预约记录********************************-->
</youi:page>