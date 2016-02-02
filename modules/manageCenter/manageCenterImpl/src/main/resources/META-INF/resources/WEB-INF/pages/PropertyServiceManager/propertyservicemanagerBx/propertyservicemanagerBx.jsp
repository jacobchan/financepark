<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerBx" idKeys="bxId" caption="物业报修记录列表"  panel="false"
				src="esb/web/propertyservicemanagerBxManager/getPagerPropertyservicemanagerBxs.json" dataFormId="form_propertyservicemanagerBx"
				editSrc="esb/web/propertyservicemanagerBxManager/getPropertyservicemanagerBx.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerBxManager/removePropertyservicemanagerBx.json">
		<youi:fieldLayout>
			<youi:fieldText property="bxFujian"  caption="附件"/>
			<youi:fieldText property="bxProject"  caption="报修项目"/>
			<youi:fieldText property="bxRemark"  caption="描述"/>
			<youi:fieldText property="bxWay"  caption="报修方式"/>
			<youi:fieldText property="bxComp"  caption="企业名称"/>

			<youi:fieldText property="bxAmount"  caption="维修总价"/>
			<youi:fieldText property="bxType"  caption="报修类型"/>
			<youi:fieldText property="bxAddress"  caption="维修地址"/>
		</youi:fieldLayout>
		<youi:gridCol property="bxFujian"  caption="附件"/>
		<youi:gridCol property="bxProject"  caption="报修项目"/>
		<youi:gridCol property="bxRemark"  caption="描述"/>
		<youi:gridCol property="bxWay"  caption="报修方式"/>
		<youi:gridCol property="bxComp"  caption="企业名称"/>

		<youi:gridCol property="bxAmount"  caption="维修总价"/>
		<youi:gridCol property="bxType"  caption="报修类型"/>
		<youi:gridCol property="bxAddress"  caption="维修地址"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-物业报修记录编辑 -->
	<youi:form dialog="true" caption="物业报修记录" id="form_propertyservicemanagerBx" action="esb/web/propertyservicemanagerBxManager/savePropertyservicemanagerBx.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="bxFujian"  caption="附件"/>
			<youi:fieldText property="bxProject"  caption="报修项目"/>
			<youi:fieldText property="bxRemark"  caption="描述"/>
			<youi:fieldText property="bxWay"  caption="报修方式"/>
			<youi:fieldText property="bxComp"  caption="企业名称"/>
			<youi:fieldText property="bxId"  caption="报修记录ID"/>
			<youi:fieldText property="bxAmount"  caption="维修总价"/>
			<youi:fieldText property="bxType"  caption="报修类型"/>
			<youi:fieldText property="bxAddress"  caption="维修地址"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>