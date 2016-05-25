<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<youi:grid id="grid_disRateConfig" idKeys="recId" caption="分佣比率配置列表"  panel="true" add="NOT"
				src="esb/web/disRateConfigManager/getPagerDisRateConfigs.json" dataFormId="form_disRateConfig"
				editSrc="esb/web/disRateConfigManager/getDisRateConfig.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/disRateConfigManager/removeDisRateConfig.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="memLevel"  caption="会员等级" convert="memLevel"/>
			<youi:fieldSelect property="disLevel"  caption="分销等级" convert="disLevel"/>
		</youi:fieldLayout>
		<youi:gridCol property="memLevel"  caption="会员等级" width="20%" convert="memLevel" align="center"/>
		<youi:gridCol property="disRateShow"  caption="分佣比率" width="20%" align="right"/>
		<youi:gridCol property="disLevel"  caption="分销等级" convert="disLevel" width="20%" align="center"/>
		<youi:button name="enteringAdd" caption="添加"></youi:button>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-分佣比率配置编辑 -->
	<youi:form dialog="true" caption="分佣比率配置" id="form_disRateConfig" 
	action="esb/web/disRateConfigManager/saveDisRateConfig.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="recId"/>
			<youi:fieldSelect property="disLevel"  convert="disLevel" caption="分销等级" readonly="true"/>
			<youi:fieldSelect property="memLevel"  convert="memLevel" caption="会员等级" readonly="true"/>
			<youi:fieldText property="disRate"  caption="分佣比率"/>
		</youi:fieldLayout>
	</youi:form>	
	
	<!-- form-分佣比率配置编辑 -->
	<youi:form dialog="true" caption="分佣比率配置" id="form_addDisRateConfig"  
	action="esb/web/disRateConfigManager/saveDisRateConfig.json">
		<youi:fieldLayout prefix="records">
			<youi:fieldSelect property="disLevel" convert="disLevel" caption="分销等级" notNull="true"/>
			<youi:fieldText property="v1"  caption="初级会员" notNull="true"/>
			<youi:fieldText property="v2"  caption="中级会员" notNull="true"/>
			<youi:fieldText property="v3"  caption="高级会员" notNull="true"/>
		</youi:fieldLayout>
	</youi:form>
	
		
	<!--**********************************页面函数Start********************************-->
	 <!--添加之后关闭添加页面-->
	 <youi:func name = "form_addDisRateConfig_afterSubmit">
			var disForm = $elem('form_addDisRateConfig',pageId);
			disForm.form('close');
			$elem('grid_disRateConfig',pageId).grid('pReload');
			$elem('records_disLevel',pageId).fieldValue("");
			$elem('records_v1',pageId).fieldValue("");
			$elem('records_v2',pageId).fieldValue("");
			$elem('records_v3',pageId).fieldValue("");
	</youi:func>
	
	
	<youi:func name="func_grid_enteringAdd">
		$elem('form_addDisRateConfig',pageId).form('open');
	</youi:func>
	
	
	<!-- 验证是否分销等级已经配置 -->
	<youi:func name="records_disLevel_change">	
		var disLevel = $elem('records_disLevel',pageId).fieldValue();	
		if(disLevel!=''){
			$.youi.ajaxUtil.ajax({
				url:'esb/web/disRateConfigManager/getLevel.json',
				data:{level:disLevel},
				success:function(result){
					var record = result.record;
					if(record.html=='false'){
						alert("该分销等级已配置,请重新选择分销等级");
                  		$elem('records_disLevel',pageId).fieldValue("");	
					} 
				}
            })
		}
		
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>