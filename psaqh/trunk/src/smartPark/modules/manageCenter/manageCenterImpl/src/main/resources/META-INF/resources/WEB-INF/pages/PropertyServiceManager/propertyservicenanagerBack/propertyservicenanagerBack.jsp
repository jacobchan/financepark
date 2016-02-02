<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicenanagerBack" idKeys="backId" caption="投诉回访记录表列表"  panel="false"
				src="esb/web/propertyservicenanagerBackManager/getPagerPropertyservicenanagerBacks.json" dataFormId="form_propertyservicenanagerBack"
				editSrc="esb/web/propertyservicenanagerBackManager/getPropertyservicenanagerBack.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicenanagerBackManager/removePropertyservicenanagerBack.json">
		<youi:fieldLayout>
			<youi:fieldText property="backCode"  caption="回访单号"/>

			<youi:fieldText property="backRecord"  caption="回访记录"/>
		</youi:fieldLayout>
		<youi:gridCol property="backCode"  caption="回访单号"/>

		<youi:gridCol property="backRecord"  caption="回访记录"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-投诉回访记录表编辑 -->
	<youi:form dialog="true" caption="投诉回访记录表" id="form_propertyservicenanagerBack" action="esb/web/propertyservicenanagerBackManager/savePropertyservicenanagerBack.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="backCode"  caption="回访单号"/>
			<youi:fieldText property="backId"  caption="回访ID"/>
			<youi:fieldText property="backRecord"  caption="回访记录"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>