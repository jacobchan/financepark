<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_busAdapter" idKeys="adapterId" caption="适配器列表"  panel="false"
				src="esb/web/busAdapterManager/getPagerBusAdapters.json" dataFormId="form_busAdapter"
				editSrc="esb/web/busAdapterManager/getBusAdapter.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/busAdapterManager/removeBusAdapter.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldText property="adapterName"  caption="适配器名"/>
			<youi:fieldText property="adapterStatus"  caption="适配器状态"/>
			<youi:fieldText property="adapterCaption" column="2"  caption="适配器描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol width="15%" property="adapterName"  caption="适配器名"/>
		<youi:gridCol width="25%" property="adapterCaption"  caption="适配器描述"/>
		
		<youi:gridCol width="10%" property="youAdapterGroupId"  caption="适配器类型"/>
		
		
		<youi:gridCol width="20%" property="adapterUrl"  caption="适配器URL"/>
		<youi:gridCol width="10%" property="adapterPort"  caption="适配器端口"/>
		
		<youi:gridCol width="10%" property="adapterStatus"  caption="适配器状态"/>
		<youi:gridCol width="10%" property="updateTime"  caption="更新时间"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-服务适配器编辑 -->
	<youi:form dialog="true" caption="适配器" id="form_busAdapter" action="esb/web/busAdapterManager/saveBusAdapter.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldHidden property="adapterId"  caption="适配器ID"/>
			
			
			<youi:fieldText notNull="true" property="adapterName" column="2"  caption="适配器名"/>
			<youi:fieldText notNull="true" property="adapterCaption" column="2"  caption="适配器描述"/>
			
			<youi:fieldSelect property="youAdapterGroupId" column="2" convert="adapterGroup"  caption="适配器类型"/>
		</youi:fieldLayout>
		
		<youi:fieldLayout id="fieldlayout_adapter_expression" prefix="record" labelWidths="100,100">
			<youi:fieldText escapeSpecial="true" property="channelExpression" column="2"  caption="表达式"/>
		</youi:fieldLayout>
		
		<youi:fieldLayout id="fieldlayout_adapter_prop" prefix="record" labelWidths="100,100">
			<youi:fieldText property="adapterUsername"  caption="用户名"/>
			<youi:fieldPassword property="adapterPassword"  caption="密码"/>
			
			<youi:fieldText property="adapterUrl" column="2"  caption="适配器URL"/>
			<youi:fieldText property="adapterPort" column="2" caption="适配器端口"/>
			
			<youi:fieldLabel property="adapterStatus"  caption="适配器状态"/>
			<youi:fieldLabel property="updateTime"  caption="更新时间"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数********************************-->
	<youi:func name="record_youAdapterGroupId_change" params="value">
		if(value=='expression'){
			$elem('fieldlayout_adapter_expression',pageId).fieldLayout('fieldReadonly',false);
			$elem('fieldlayout_adapter_prop',pageId).fieldLayout('fieldReadonly',true);
		}else{
			$elem('fieldlayout_adapter_expression',pageId).fieldLayout('fieldReadonly',true);
			$elem('fieldlayout_adapter_prop',pageId).fieldLayout('fieldReadonly',false);
		}
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>