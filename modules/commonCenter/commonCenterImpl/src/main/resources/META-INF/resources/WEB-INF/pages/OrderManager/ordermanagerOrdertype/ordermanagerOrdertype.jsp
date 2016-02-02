<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_ordermanagerOrdertype" idKeys="ordertypeId" caption="订单类型表列表"  panel="false"
				src="esb/web/ordermanagerOrdertypeManager/getPagerOrdermanagerOrdertypes.json" dataFormId="form_ordermanagerOrdertype"
				editSrc="esb/web/ordermanagerOrdertypeManager/getOrdermanagerOrdertype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/ordermanagerOrdertypeManager/removeOrdermanagerOrdertype.json">
		<youi:fieldLayout>

			<youi:fieldText property="ordertypeProjectName"  caption="订单项目名称"/>
			<youi:fieldText property="ordertypeName"  caption="类型名称"/>
			<youi:fieldText property="ordertypeProjectTemplateAddress"  caption="订单项目模板地址"/>
		</youi:fieldLayout>

		<youi:gridCol property="ordertypeProjectName"  caption="订单项目名称"/>
		<youi:gridCol property="ordertypeName"  caption="类型名称"/>
		<youi:gridCol property="ordertypeProjectTemplateAddress"  caption="订单项目模板地址"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-订单类型表编辑 -->
	<youi:form dialog="true" caption="订单类型表" id="form_ordermanagerOrdertype" action="esb/web/ordermanagerOrdertypeManager/saveOrdermanagerOrdertype.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="ordertypeId"  caption="订单类型主键"/>
			<youi:fieldText property="ordertypeProjectName"  caption="订单项目名称"/>
			<youi:fieldText property="ordertypeName"  caption="类型名称"/>
			<youi:fieldText property="ordertypeProjectTemplateAddress"  caption="订单项目模板地址"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>