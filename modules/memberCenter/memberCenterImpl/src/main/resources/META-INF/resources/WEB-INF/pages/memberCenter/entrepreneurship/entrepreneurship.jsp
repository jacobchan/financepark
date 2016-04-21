<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_entrepreneurship" idKeys="id" caption="340703创业加速申请列表"  panel="false"
				src="esb/web/entrepreneurshipManager/getPagerEntrepreneurships.json" dataFormId="form_entrepreneurship"
				editSrc="esb/web/entrepreneurshipManager/getEntrepreneurship.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/entrepreneurshipManager/removeEntrepreneurship.json">
		<youi:fieldLayout>
			<youi:fieldText property="applayStatus"  caption="申请状态"/>
			<youi:fieldText property="applayNo"  caption="申请编号"/>
			<youi:fieldText property="projectType"  caption="项目类型"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="updateUser"  caption="修改人"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="teacherType"  caption="导师类型"/>
			<youi:fieldText property="projectDis"  caption="项目简介"/>
			<youi:fieldText property="createUser"  caption="创建人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="createTime"  caption="创建时间"/>

			<youi:fieldText property="isFinace"  caption="是否融资"/>
		</youi:fieldLayout>
		<youi:gridCol property="applayStatus"  caption="申请状态"/>
		<youi:gridCol property="applayNo"  caption="申请编号"/>
		<youi:gridCol property="projectType"  caption="项目类型"/>
		<youi:gridCol property="parkId"  caption="园区ID"/>
		<youi:gridCol property="updateUser"  caption="修改人"/>
		<youi:gridCol property="updateTime"  caption="修改时间"/>
		<youi:gridCol property="teacherType"  caption="导师类型"/>
		<youi:gridCol property="projectDis"  caption="项目简介"/>
		<youi:gridCol property="createUser"  caption="创建人"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="createTime"  caption="创建时间"/>

		<youi:gridCol property="isFinace"  caption="是否融资"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-340703创业加速申请编辑 -->
	<youi:form dialog="true" caption="340703创业加速申请" id="form_entrepreneurship" action="esb/web/entrepreneurshipManager/saveEntrepreneurship.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="applayStatus"  caption="申请状态"/>
			<youi:fieldText property="applayNo"  caption="申请编号"/>
			<youi:fieldText property="projectType"  caption="项目类型"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
			<youi:fieldText property="updateUser"  caption="修改人"/>
			<youi:fieldText property="updateTime"  caption="修改时间"/>
			<youi:fieldText property="teacherType"  caption="导师类型"/>
			<youi:fieldText property="projectDis"  caption="项目简介"/>
			<youi:fieldText property="createUser"  caption="创建人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="createTime"  caption="创建时间"/>
			<youi:fieldText property="id"  caption="ID_"/>
			<youi:fieldText property="isFinace"  caption="是否融资"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>