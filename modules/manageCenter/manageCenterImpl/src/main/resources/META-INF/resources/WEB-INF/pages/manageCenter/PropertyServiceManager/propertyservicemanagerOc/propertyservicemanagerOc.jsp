<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerOc" idKeys="ocId" caption="一卡通办理申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerOcManager/getPagerPropertyservicemanagerOcs.json" dataFormId="form_propertyservicemanagerOc"
				editSrc="esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOc.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerOcManager/removePropertyservicemanagerOc.json">
		<youi:fieldLayout>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="ocComp"  caption="所属企业名称"/>
			<youi:fieldText property="ocRemark"  caption="一卡通其他说明"/>
			<youi:fieldText property="ocNumber"  caption="一卡通号码"/>

			<youi:fieldText property="ocDate"  caption="一卡通预约时间"/>
			<youi:fieldText property="ocAddree"  caption="选择地址"/>
			<youi:fieldText property="ocWay"  caption="一卡通办理方式"/>
			<youi:fieldText property="ocStatus"  caption="一卡通预约状态"/>
		</youi:fieldLayout>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol property="ocComp"  caption="所属企业名称"/>
		<youi:gridCol property="ocRemark"  caption="一卡通其他说明"/>
		<youi:gridCol property="ocNumber"  caption="一卡通号码"/>

		<youi:gridCol property="ocDate"  caption="一卡通预约时间"/>
		<youi:gridCol property="ocAddree"  caption="选择地址"/>
		<youi:gridCol property="ocWay"  caption="一卡通办理方式"/>
		<youi:gridCol property="ocStatus"  caption="一卡通预约状态"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-一卡通办理申请记录编辑 -->
	<youi:form dialog="true" caption="一卡通办理申请记录" id="form_propertyservicemanagerOc" action="esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="ocComp"  caption="所属企业名称"/>
			<youi:fieldText property="ocRemark"  caption="一卡通其他说明"/>
			<youi:fieldText property="ocNumber"  caption="一卡通号码"/>
			<youi:fieldText property="ocId"  caption="一卡通预约记录"/>
			<youi:fieldText property="ocDate"  caption="一卡通预约时间"/>
			<youi:fieldText property="ocAddree"  caption="选择地址"/>
			<youi:fieldText property="ocWay"  caption="一卡通办理方式"/>
			<youi:fieldText property="ocStatus"  caption="一卡通预约状态"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>