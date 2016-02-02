<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerOrderprojecttype" idKeys="orderprojecttypeId" caption="订单项目类型表列表"  panel="false"
				src="esb/web/ordermanagerOrderprojecttypeManager/getPagerOrdermanagerOrderprojecttypes.json" dataFormId="form_ordermanagerOrderprojecttype"
				editSrc="esb/web/ordermanagerOrderprojecttypeManager/getOrdermanagerOrderprojecttype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerOrderprojecttypeManager/removeOrdermanagerOrderprojecttype.json">
		<youi:fieldLayout>
			<youi:fieldText property="orderprojecttypeIsnotDisplay"  caption="是否显示"/>
			<youi:fieldText property="orderprojecttypeFieldType"  caption="字段类型"/>
			<youi:fieldText property="orderprojecttypeDefaultValue"  caption="默认值"/>
			<youi:fieldText property="orderprojecttypeFieldLength"  caption="字段长度"/>
			<youi:fieldText property="orderprojecttypeCheckFormat"  caption="校验格式"/>
			<youi:fieldText property="orderprojecttypeOptionCodeset"  caption="选项代码集"/>

			<youi:fieldText property="orderprojecttypeSortChar"  caption="排序字符"/>
			<youi:fieldText property="orderprojecttypeFieldName"  caption="字段名称"/>
			<youi:fieldText property="orderprojecttypeIsnotMust"  caption="是否必须"/>
			<youi:fieldText property="orderprojecttypeDisplayName"  caption="显示名称"/>
		</youi:fieldLayout>
		<youi:gridCol property="orderprojecttypeIsnotDisplay"  caption="是否显示"/>
		<youi:gridCol property="orderprojecttypeFieldType"  caption="字段类型"/>
		<youi:gridCol property="orderprojecttypeDefaultValue"  caption="默认值"/>
		<youi:gridCol property="orderprojecttypeFieldLength"  caption="字段长度"/>
		<youi:gridCol property="orderprojecttypeCheckFormat"  caption="校验格式"/>
		<youi:gridCol property="orderprojecttypeOptionCodeset"  caption="选项代码集"/>

		<youi:gridCol property="orderprojecttypeSortChar"  caption="排序字符"/>
		<youi:gridCol property="orderprojecttypeFieldName"  caption="字段名称"/>
		<youi:gridCol property="orderprojecttypeIsnotMust"  caption="是否必须"/>
		<youi:gridCol property="orderprojecttypeDisplayName"  caption="显示名称"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-订单项目类型表编辑 -->
	<youi:form dialog="true" caption="订单项目类型表" id="form_ordermanagerOrderprojecttype" action="esb/web/ordermanagerOrderprojecttypeManager/saveOrdermanagerOrderprojecttype.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="orderprojecttypeIsnotDisplay"  caption="是否显示"/>
			<youi:fieldText property="orderprojecttypeFieldType"  caption="字段类型"/>
			<youi:fieldText property="orderprojecttypeDefaultValue"  caption="默认值"/>
			<youi:fieldText property="orderprojecttypeFieldLength"  caption="字段长度"/>
			<youi:fieldText property="orderprojecttypeCheckFormat"  caption="校验格式"/>
			<youi:fieldText property="orderprojecttypeOptionCodeset"  caption="选项代码集"/>
			<youi:fieldText property="orderprojecttypeId"  caption="订单项目ID"/>
			<youi:fieldText property="orderprojecttypeSortChar"  caption="排序字符"/>
			<youi:fieldText property="orderprojecttypeFieldName"  caption="字段名称"/>
			<youi:fieldText property="orderprojecttypeIsnotMust"  caption="是否必须"/>
			<youi:fieldText property="orderprojecttypeDisplayName"  caption="显示名称"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>