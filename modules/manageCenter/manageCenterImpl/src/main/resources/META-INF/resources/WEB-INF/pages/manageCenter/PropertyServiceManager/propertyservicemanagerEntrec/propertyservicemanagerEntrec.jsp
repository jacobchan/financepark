<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerEntrec" idKeys="entrecId" caption="入驻服务办理预约记录表列表"  panel="false"
				src="esb/web/propertyservicemanagerEntrecManager/getPagerPropertyservicemanagerEntrecs.json" dataFormId="form_propertyservicemanagerEntrec"
				editSrc="esb/web/propertyservicemanagerEntrecManager/getPropertyservicemanagerEntrec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerEntrecManager/removePropertyservicemanagerEntrec.json">
		<youi:fieldLayout labelWidths="90,100">
			<youi:fieldText property="enteringName"  caption="入驻申请人"/>
			<youi:fieldText property="enteringTelephone"  caption="入驻联系电话"/>

			<youi:fieldText property="enteringTime"  caption="预约时间段"/>
			<youi:fieldSelect property="enteringStatus"  caption="预约数量状态" convert="enteringStatus"/>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:gridCol property="enteringName"  caption="入驻申请人" width="100"/>
		<youi:gridCol property="enteringTelephone"  caption="入驻联系电话" width="100"/>

		<youi:gridCol property="enteringTime"  caption="预约时间段" width="150"/>
		<youi:gridCol property="enteringStatus"  caption="预约数量状态" convert="enteringStatus" width="100"/>
		<youi:gridCol property="enteringDate"  caption="预约时间日期" width="120"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-入驻服务办理预约记录表编辑 -->
	<youi:form dialog="true" caption="入驻服务办理预约记录表" id="form_propertyservicemanagerEntrec" action="esb/web/propertyservicemanagerEntrecManager/savePropertyservicemanagerEntrec.json">
		<youi:fieldLayout prefix="record" labelWidths="90,100">
			<youi:fieldText property="enteringName"  caption="入驻申请人"/>
			<youi:fieldText property="enteringTelephone"  caption="入驻联系电话"/>
			<youi:fieldHidden property="memberId"  caption="会员用户ID"/>
			<youi:fieldHidden property="entrecId"  caption="入驻预约记录ID"/>
			<youi:fieldText property="enteringTime"  caption="预约时间段"/>
			<youi:fieldSelect property="enteringStatus"  caption="预约数量状态" convert="enteringStatus"/>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>