<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_etypeEnterprisetype" idKeys="enTypeId"
		caption="企业行业类型表列表" panel="false"
		src="esb/web/etypeEnterprisetypeManager/getPagerEtypeEnterprisetypes.json"
		dataFormId="form_etypeEnterprisetype"
		editSrc="esb/web/etypeEnterprisetypeManager/getEtypeEnterprisetype.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/etypeEnterprisetypeManager/removeEtypeEnterprisetype.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldTree simple="false" popup="true" tree="${enetrTree}" property="enTypeId" caption="企业类型"/>
			<youi:fieldText property="enTypeName" caption="企业类型名称" />
		</youi:fieldLayout>
		<youi:gridCol property="etypeEnterprisetype.enTypeName" caption="上级" width="300" />
		<youi:gridCol property="enTypeName" caption="企业类型名称" width="280" />

		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-企业行业类型表编辑 -->
	<youi:form dialog="true" caption="企业行业类型表"
		id="form_etypeEnterprisetype"
		action="esb/web/etypeEnterprisetypeManager/saveEtypeEnterprisetype.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="enTypeId" caption="企业类型名称" />
			<youi:fieldTree simple="false" popup="true" tree="${enetrTree}" property="enTypeId" caption="企业类型"/>
			<youi:fieldText property="enTypeName" caption="企业类型名称" />
		</youi:fieldLayout>
	</youi:form>

	<!--**********************************页面函数Start********************************-->
	<youi:func name="form_etypeEnterprisetype_afterSubmit">
		var etypeEnterprisetype = $elem('form_etypeEnterprisetype',pageId);
		etypeEnterprisetype.form('reset');
		etypeEnterprisetype.form('close');
		$elem('grid_etypeEnterprisetype',pageId).grid('pReload');
	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>