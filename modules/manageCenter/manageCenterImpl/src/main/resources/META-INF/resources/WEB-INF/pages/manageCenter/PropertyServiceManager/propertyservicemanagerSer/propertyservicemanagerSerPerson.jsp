<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerSer" idKeys="serId" caption="费用清单列表"  panel="false"
				src="esb/web/propertyservicemanagerSerManager/getPropertySer.json" dataFormId="form_propertyservicemanagerSer"
				editSrc="esb/web/propertyservicemanagerSerManager/getPropertyservicemanagerSer.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerSerManager/removePropertyservicemanagerSer.json">
		<youi:fieldLayout labelWidths="100,100">
			<youi:fieldText property="propertyservicemanagerTs.tsName" caption="维修人"/>
			<youi:fieldText property="propertyservicemanagerTs.tsTelephone" caption="维修人电话"/>
			<youi:fieldSelect property="serName"  caption="材料名称" convert="ser_name"/>
		
			<youi:fieldSelect property="serType"  caption="材料类别" convert="ser_type"/>
		</youi:fieldLayout>
		<youi:gridCol property="propertyservicemanagerTs.tsName" caption="维修人" width="10%"/>
		<youi:gridCol property="propertyservicemanagerTs.tsTelephone" caption="维修人电话" width="15%"/>
		<youi:gridCol property="propertyservicemanagerTs.propertyservicemanagerBx.bxComp" caption="报修企业" width="20%"/>
		<youi:gridCol property="serName"  caption="材料名称" width="20%" convert="ser_name"/>

		<youi:gridCol property="serPrice"  caption="材料价格" width="10%"/>
		<youi:gridCol property="serType"  caption="材料类别" width="15%" convert="ser_type"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-费用清单编辑 -->
	<youi:form dialog="true" caption="费用清单" id="form_propertyservicemanagerSer" action="esb/web/propertyservicemanagerSerManager/savePropertyservicemanagerSer.json">
		<youi:fieldLayout prefix="record" labelWidths="100,100">
			<youi:fieldText property="propertyservicemanagerTs.tsId"  caption="派工ID"/>
			<youi:fieldSelect property="serName"  caption="材料名称" convert="ser_name"/>
			<youi:fieldText property="serPrice"  caption="材料价格" dataType="format" format="0,0.00"/>
			<youi:fieldSelect property="serType"  caption="材料类别" convert="ser_type"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>