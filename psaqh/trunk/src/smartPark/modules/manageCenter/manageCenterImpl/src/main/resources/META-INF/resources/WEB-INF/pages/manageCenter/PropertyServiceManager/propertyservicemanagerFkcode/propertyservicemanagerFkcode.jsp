<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerFkcode" idKeys="fkcodeId" caption="访客申请记录列表"  panel="false"
				src="esb/web/propertyservicemanagerFkcodeManager/getPagerPropertyservicemanagerFkcodes.json" dataFormId="form_propertyservicemanagerFkcode"
				editSrc="esb/web/propertyservicemanagerFkcodeManager/getPropertyservicemanagerFkcode.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerFkcodeManager/removePropertyservicemanagerFkcode.json">
		<youi:fieldLayout labelWidths="122,122">
			<youi:fieldText property="fkcodeTelephone"  caption="联系电话"/>
			<%-- <youi:fieldText property="fkcodeRemark"  caption="访客说明"/> --%>
		<%-- 	<youi:fieldText property="fkcodeComp"  caption="到访企业"/> --%>
		<youi:fieldSelect property="fkcodeComp" caption="到访企业" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldText property="fkcodeName"  caption="联系人"/>
			<youi:fieldCalendar property="fkcodeTime"  caption="到访时间"/>
			<%-- <youi:fieldText property="memberId"  caption="会员用户ID"/> --%>
			<youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="fkcodeSex"  caption="性别" convert="sex" />

		</youi:fieldLayout>
		<youi:gridCol property="fkcodeTelephone"  caption="联系电话"/>
		<%-- <youi:gridCol property="fkcodeRemark"  caption="访客说明"/> --%>
		<youi:gridCol property="fkcodeComp"  caption="到访企业"/>
		<youi:gridCol property="fkcodeName"  caption="联系人"/>
		<youi:gridCol property="fkcodeTime"  caption="到访时间"/>
		<youi:gridCol property="memberId"  caption="会员用户"/>
		<youi:gridCol property="fkcodeSex"  caption="性别"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-访客申请记录编辑 -->
	<youi:form dialog="true" caption="访客申请记录" id="form_propertyservicemanagerFkcode" action="esb/web/propertyservicemanagerFkcodeManager/savePropertyservicemanagerFkcode.json">
		<youi:fieldLayout prefix="record" labelWidths="122,122">
			<youi:fieldText property="fkcodeTelephone"  caption="联系电话"/>
			<youi:fieldArea property="fkcodeRemark"  caption="访客说明" column="2"/>
			<%-- <youi:fieldText property="fkcodeComp"  caption="到访企业"/> --%>
			<youi:fieldSelect property="fkcodeComp" caption="到访企业" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldText property="fkcodeName"  caption="联系人"/>
			<youi:fieldCalendar property="fkcodeTime"  caption="到访时间"/>
			<%-- <youi:fieldText property="memberId"  caption="会员用户ID"/> --%>
			<youi:fieldSelect property="memberId" caption="会员用户" 
				src="esb/web/memberInformationManager/getMemberInformations.json" code="memberId" show="memberName"/>
			<youi:fieldSelect property="fkcodeSex"  caption="性别" convert="sex" />
			<youi:fieldHidden property="fkcodeId"  caption="访客申请ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>