<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerCos" idKeys="cosId" caption="物业投诉记录表列表"  panel="false"
				src="esb/web/propertyservicemanagerCosManager/getPagerPropertyservicemanagerCoss.json" dataFormId="form_propertyservicemanagerCos"
				editSrc="esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCos.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerCosManager/removePropertyservicemanagerCos.json">
		<youi:fieldLayout>
			<youi:fieldText property="cosTime"  caption="投诉时间"/>
			<youi:fieldText property="cosContent"  caption="投诉内容"/>
			<youi:fieldText property="cosName"  caption="投诉联系人"/>

			<youi:fieldText property="cosTelephone"  caption="回访电话"/>
			<youi:fieldText property="cosCode"  caption="投诉单号"/>
			<youi:fieldText property="cosStatus"  caption="投诉受理状态"/>
			<youi:fieldText property="cosBool"  caption="是否接受回访"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
		<youi:gridCol property="cosTime"  caption="投诉时间"/>
		<youi:gridCol property="cosContent"  caption="投诉内容"/>
		<youi:gridCol property="cosName"  caption="投诉联系人"/>

		<youi:gridCol property="cosTelephone"  caption="回访电话"/>
		<youi:gridCol property="cosCode"  caption="投诉单号"/>
		<youi:gridCol property="cosStatus"  caption="投诉受理状态"/>
		<youi:gridCol property="cosBool"  caption="是否接受回访"/>
		<youi:gridCol property="memberId"  caption="会员用户ID"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-物业投诉记录表编辑 -->
	<youi:form dialog="true" caption="物业投诉记录表" id="form_propertyservicemanagerCos" action="esb/web/propertyservicemanagerCosManager/savePropertyservicemanagerCos.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="cosTime"  caption="投诉时间"/>
			<youi:fieldText property="cosContent"  caption="投诉内容"/>
			<youi:fieldText property="cosName"  caption="投诉联系人"/>
			<youi:fieldText property="cosId"  caption="投诉ID"/>
			<youi:fieldText property="cosTelephone"  caption="回访电话"/>
			<youi:fieldText property="cosCode"  caption="投诉单号"/>
			<youi:fieldText property="cosStatus"  caption="投诉受理状态"/>
			<youi:fieldText property="cosBool"  caption="是否接受回访"/>
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>