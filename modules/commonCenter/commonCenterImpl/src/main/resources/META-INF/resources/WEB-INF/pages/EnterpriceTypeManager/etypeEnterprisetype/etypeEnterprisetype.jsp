<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_etypeEnterprisetype" idKeys="enTypeId" caption="企业行业类型表列表"  panel="false"
				src="esb/web/etypeEnterprisetypeManager/getPagerEtypeEnterprisetypes.json" dataFormId="form_etypeEnterprisetype"
				editSrc="esb/web/etypeEnterprisetypeManager/getEtypeEnterprisetype.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/etypeEnterprisetypeManager/removeEtypeEnterprisetype.json">
		<youi:fieldLayout>
			<youi:fieldText property="parentId"  caption="父ID"/>
			<youi:fieldText property="enTypeName"  caption="企业类型名称"/>

		</youi:fieldLayout>
		<youi:gridCol property="parentId"  caption="父ID"/>
		<youi:gridCol property="enTypeName"  caption="企业类型名称"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-企业行业类型表编辑 -->
	<youi:form dialog="true" caption="企业行业类型表" id="form_etypeEnterprisetype" action="esb/web/etypeEnterprisetypeManager/saveEtypeEnterprisetype.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="parentId"  caption="父ID"/>
			<youi:fieldText property="enTypeName"  caption="企业类型名称"/>
			<youi:fieldText property="enTypeId"  caption="企业类型ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>