<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_finace" idKeys="id" caption="340702融资申请列表"  panel="false"
				src="esb/web/finaceManager/getPagerFinaces.json" dataFormId="form_finace"
				editSrc="esb/web/finaceManager/getFinace.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/finaceManager/removeFinace.json">
		<youi:fieldLayout>
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="amountEnd"  caption="融资额度止"/>
			<youi:fieldText property="createUser"  caption="创建人"/>
			<youi:fieldText property="businessDis"  caption="业务简介"/>
			<youi:fieldText property="updateUser"  caption="修改人"/>
			<youi:fieldText property="companyName"  caption="公司名称"/>
			<youi:fieldText property="shareRate"  caption="股份占比"/>
			<youi:fieldText property="companyAdr"  caption="公司地址"/>
			<youi:fieldText property="applayStatus"  caption="申请状态"/>
			<youi:fieldText property="companyMerite"  caption="公司优势"/>
			<youi:fieldText property="bpUrl"  caption="BPURL"/>

			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="amountStart"  caption="融资额度起"/>
			<youi:fieldText property="corTeam"  caption="核心成员"/>
			<youi:fieldText property="applayNo"  caption="申请编号"/>
		</youi:fieldLayout>
		<youi:gridCol property="createTime"  caption="创建时间"/>
		<youi:gridCol property="updateTime"  caption="修改时间"/>
		<youi:gridCol property="amountEnd"  caption="融资额度止"/>
		<youi:gridCol property="createUser"  caption="创建人"/>
		<youi:gridCol property="businessDis"  caption="业务简介"/>
		<youi:gridCol property="updateUser"  caption="修改人"/>
		<youi:gridCol property="companyName"  caption="公司名称"/>
		<youi:gridCol property="shareRate"  caption="股份占比"/>
		<youi:gridCol property="companyAdr"  caption="公司地址"/>
		<youi:gridCol property="applayStatus"  caption="申请状态"/>
		<youi:gridCol property="companyMerite"  caption="公司优势"/>
		<youi:gridCol property="bpUrl"  caption="BPURL"/>

		<youi:gridCol property="parkId"  caption="园区ID"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="amountStart"  caption="融资额度起"/>
		<youi:gridCol property="corTeam"  caption="核心成员"/>
		<youi:gridCol property="applayNo"  caption="申请编号"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-340702融资申请编辑 -->
	<youi:form dialog="true" caption="340702融资申请" id="form_finace" action="esb/web/finaceManager/saveFinace.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="amountEnd"  caption="融资额度止"/>
			<youi:fieldText property="createUser"  caption="创建人"/>
			<youi:fieldText property="businessDis"  caption="业务简介"/>
			<youi:fieldText property="updateUser"  caption="修改人"/>
			<youi:fieldText property="companyName"  caption="公司名称"/>
			<youi:fieldText property="shareRate"  caption="股份占比"/>
			<youi:fieldText property="companyAdr"  caption="公司地址"/>
			<youi:fieldText property="applayStatus"  caption="申请状态"/>
			<youi:fieldText property="companyMerite"  caption="公司优势"/>
			<youi:fieldText property="bpUrl"  caption="BPURL"/>
			<youi:fieldText property="id"  caption="ID_"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="amountStart"  caption="融资额度起"/>
			<youi:fieldText property="corTeam"  caption="核心成员"/>
			<youi:fieldText property="applayNo"  caption="申请编号"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>