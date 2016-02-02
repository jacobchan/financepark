<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerTs" idKeys="tsId" caption="派工维修记录列表"  panel="false"
				src="esb/web/propertyservicemanagerTsManager/getPagerPropertyservicemanagerTss.json" dataFormId="form_propertyservicemanagerTs"
				editSrc="esb/web/propertyservicemanagerTsManager/getPropertyservicemanagerTs.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerTsManager/removePropertyservicemanagerTs.json">
		<youi:fieldLayout>
			<youi:fieldText property="tsTelephone"  caption="派工人员电话号码"/>
			<youi:fieldText property="tsName"  caption="派工人员"/>
			<youi:fieldText property="tsRemark"  caption="备注"/>
			<youi:fieldText property="tsStatus"  caption="派工受理状态"/>

		</youi:fieldLayout>
		<youi:gridCol property="tsTelephone"  caption="派工人员电话号码"/>
		<youi:gridCol property="tsName"  caption="派工人员"/>
		<youi:gridCol property="tsRemark"  caption="备注"/>
		<youi:gridCol property="tsStatus"  caption="派工受理状态"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-派工维修记录编辑 -->
	<youi:form dialog="true" caption="派工维修记录" id="form_propertyservicemanagerTs" action="esb/web/propertyservicemanagerTsManager/savePropertyservicemanagerTs.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="tsTelephone"  caption="派工人员电话号码"/>
			<youi:fieldText property="tsName"  caption="派工人员"/>
			<youi:fieldText property="tsRemark"  caption="备注"/>
			<youi:fieldText property="tsStatus"  caption="派工受理状态"/>
			<youi:fieldText property="tsId"  caption="主键ID_"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>