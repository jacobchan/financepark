<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_disRateConfig" idKeys="recId" caption="分佣比率配置列表"  panel="false"
				src="esb/web/disRateConfigManager/getPagerDisRateConfigs.json" dataFormId="form_disRateConfig"
				editSrc="esb/web/disRateConfigManager/getDisRateConfig.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/disRateConfigManager/removeDisRateConfig.json">
		<youi:fieldLayout>
			<youi:fieldText property="memLevel"  caption="会员等级"/>

			<youi:fieldText property="disRate"  caption="分佣比率"/>
			<youi:fieldText property="disLevel"  caption="分销等级"/>
		</youi:fieldLayout>
		<youi:gridCol property="memLevel"  caption="会员等级"/>

		<youi:gridCol property="disRate"  caption="分佣比率"/>
		<youi:gridCol property="disLevel"  caption="分销等级"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-分佣比率配置编辑 -->
	<youi:form dialog="true" caption="分佣比率配置" id="form_disRateConfig" action="esb/web/disRateConfigManager/saveDisRateConfig.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memLevel"  caption="会员等级"/>
			<youi:fieldText property="recId"  caption="记录ID"/>
			<youi:fieldText property="disRate"  caption="分佣比率"/>
			<youi:fieldText property="disLevel"  caption="分销等级"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>