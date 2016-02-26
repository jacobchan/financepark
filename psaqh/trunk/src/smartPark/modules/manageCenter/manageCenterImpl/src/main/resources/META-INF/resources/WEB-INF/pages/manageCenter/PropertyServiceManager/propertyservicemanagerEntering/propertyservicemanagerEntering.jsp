<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
			<youi:grid id="grid_propertyservicemanagerEntering" idKeys="enteringId" caption="可办理预约记录列表"  panel="false"
				src="esb/web/propertyservicemanagerEnteringManager/getPagerPropertyservicemanagerEnterings.json" dataFormId="form_propertyservicemanagerEntering"
				editSrc="esb/web/propertyservicemanagerEnteringManager/getPropertyservicemanagerEntering.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerEnteringManager/removePropertyservicemanagerEntering.json">
		<youi:fieldLayout labelWidths="110,110">
			<youi:fieldSelect property="enteringStatus"  caption="可预约状态" convert="enteringStatus"/>
			<youi:fieldSelect property="enteringTime"  caption="预约时间段" convert="enteringTime"/>
           <%--  <youi:fieldText property="enteringRemain"  caption="剩余数量"/>
			<youi:fieldText property="enteringAlre"  caption="已预约数"/>
			<youi:fieldText property="enteringSum"  caption="预约总量"/> --%>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
		</youi:fieldLayout>
		<youi:gridCol property="enteringStatus"  caption="可预约状态" convert="enteringStatus"  width="20%" align="center"/>
		<youi:gridCol property="enteringTime"  caption="预约时间段" convert="enteringTime" width="20%" align="center"/>

		<youi:gridCol property="enteringSum"  caption="预约总量" width="10%" align="right"/>
		<youi:gridCol property="enteringAlre"  caption="已预约数" width="10%" align="right"/>
		<youi:gridCol property="enteringRemain"  caption="剩余数量" width="10%" align="right"/>
		<youi:gridCol property="enteringDate"  caption="预约时间日期" width="30%" align="center" orderBy="desc"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-可办理预约记录编辑 -->
	<youi:form dialog="true" caption="可办理预约记录" id="form_propertyservicemanagerEntering" action="esb/web/propertyservicemanagerEnteringManager/savePropertyservicemanagerEntering.json">
		<youi:fieldLayout prefix="record" labelWidths="90,100">
			<%-- <youi:fieldSelect property="enteringStatus"  caption="可预约状态" convert="enteringStatus" notNull="true"/> --%>
			<youi:fieldCalendar property="enteringDate"  caption="预约时间日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd" notNull="true"/>
			<youi:fieldSelect property="enteringTime"  caption="预约时间段" convert="enteringTime" notNull="true"/>
			<youi:fieldText property="enteringSum"  caption="预约总量" expression="^[0-9]*$" expressionMessage="请输入数值" notNull="true"/>
			<youi:fieldText property="enteringRemain"  caption="剩余数量" expression="^[0-9]*$" expressionMessage="请输入数值" notNull="true"/>
			<youi:fieldText property="enteringAlre"  caption="已预约数" expression="^[0-9]*$" expressionMessage="请输入数值" notNull="true"/>
			<youi:fieldHidden property="enteringId"  caption="预约记录ID"/>
			<youi:fieldHidden property="enteringStatus"  caption="可预约状态"/>
			
		</youi:fieldLayout>
	</youi:form>
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>