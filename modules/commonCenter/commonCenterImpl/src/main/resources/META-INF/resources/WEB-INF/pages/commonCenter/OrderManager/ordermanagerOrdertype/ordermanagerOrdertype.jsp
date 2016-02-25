<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerOrdertype" idKeys="ordertypeId" caption="订单类型表列表"  panel="false"
				src="esb/web/ordermanagerOrdertypeManager/getPagerOrdermanagerOrdertypes.json" dataFormId="form_ordermanagerOrdertype"
				editSrc="esb/web/ordermanagerOrdertypeManager/getOrdermanagerOrdertype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerOrdertypeManager/removeOrdermanagerOrdertype.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="ordertypeId"  caption="订单类型编码"/>
			<youi:fieldText property="ordertypeName"  caption="订单类型名称"/>
			<youi:fieldText property="ordertypeProjectName"  caption="订单项目名称"/>
		</youi:fieldLayout>
		<youi:button name="editOrderType" active="1" icon="edit" caption="修改"/>
		<youi:gridCol property="ordertypeId"  caption="订单类型编码" align="center" width="25%"/>
		<youi:gridCol property="ordertypeName"  caption="订单类型名称" align="center" width="25%"/>
		<youi:gridCol property="ordertypeProjectName"  caption="订单项目名称" align="center" width="25%"/>
		<youi:gridCol property="ordertypeProjectTemplateAddress"  caption="订单项目模板地址" align="center" width="25%"/>
	</youi:grid>
	
	<!-- form-订单类型表增加 -->
	<youi:form dialog="true" caption="订单类型表" id="form_ordermanagerOrdertype" action="esb/web/ordermanagerOrdertypeManager/saveOrdermanagerOrdertype.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldText property="ordertypeId"  caption="订单类型编码"/>
			<youi:fieldText property="ordertypeName"  caption="订单类型名称"/>
			<youi:fieldText property="ordertypeProjectName"  caption="订单项目名称"/>
			<youi:fieldText property="ordertypeProjectTemplateAddress"  caption="订单模板地址"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!-- form-订单类型表修改 -->
	<youi:form dialog="true" caption="订单类型表" id="form_updateOrdertype" action="esb/web/ordermanagerOrdertypeManager/saveOrdermanagerOrdertype.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldLabel property="ordertypeId"  caption="订单类型编码"/>
			<youi:fieldText property="ordertypeName"  caption="订单类型名称"/>
			<youi:fieldText property="ordertypeProjectName"  caption="订单项目名称"/>
			<youi:fieldText property="ordertypeProjectTemplateAddress"  caption="订单模板地址"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="func_grid_editOrderType">
		var selectRecord = $elem('grid_ordermanagerOrdertype',pageId).grid('getSelectedRecord');
		$elem('form_updateOrdertype',pageId).form('reset').form('fillRecord',selectRecord).form('open');
	</youi:func>
	<youi:func name="form_updateOrdertype_afterSubmit" params="result">
		var record = result.record;
		$elem('form_updateOrdertype',pageId).form('close');
		$elem('grid_ordermanagerOrdertype',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>