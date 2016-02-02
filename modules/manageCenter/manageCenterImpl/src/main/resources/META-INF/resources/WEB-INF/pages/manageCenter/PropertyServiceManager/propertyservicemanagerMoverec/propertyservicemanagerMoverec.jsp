<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerMoverec" idKeys="moverecId" caption="搬家申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerMoverecManager/getPagerPropertyservicemanagerMoverecs.json" dataFormId="form_propertyservicemanagerMoverec"
				editSrc="esb/web/propertyservicemanagerMoverecManager/getPropertyservicemanagerMoverec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerMoverecManager/removePropertyservicemanagerMoverec.json">
		<youi:fieldLayout>
			<youi:fieldText property="moverecUnit"  caption="楼宇单元"/>
			<youi:fieldText property="moverecComp"  caption="搬家企业名称"/>

			<youi:fieldText property="moverecRemark"  caption="物品描述"/>
			<youi:fieldText property="moverecName"  caption="搬家联系人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="moverecWay"  caption="搬家提交方式"/>
		</youi:fieldLayout>
		<youi:gridCol property="moverecUnit"  caption="楼宇单元"/>
		<youi:gridCol property="moverecComp"  caption="搬家企业名称"/>

		<youi:gridCol property="moverecRemark"  caption="物品描述"/>
		<youi:gridCol property="moverecName"  caption="搬家联系人"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="moverecWay"  caption="搬家提交方式"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-搬家申请记录编辑 -->
	<youi:form dialog="true" caption="搬家申请记录" id="form_propertyservicemanagerMoverec" action="esb/web/propertyservicemanagerMoverecManager/savePropertyservicemanagerMoverec.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="moverecUnit"  caption="楼宇单元"/>
			<youi:fieldText property="moverecComp"  caption="搬家企业名称"/>
			<youi:fieldText property="moverecId"  caption="搬家申请记录ID"/>
			<youi:fieldText property="moverecRemark"  caption="物品描述"/>
			<youi:fieldText property="moverecName"  caption="搬家联系人"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="moverecWay"  caption="搬家提交方式"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>