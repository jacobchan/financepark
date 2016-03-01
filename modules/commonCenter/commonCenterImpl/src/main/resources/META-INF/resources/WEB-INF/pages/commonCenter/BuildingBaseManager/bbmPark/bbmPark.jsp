<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmPark" idKeys="parkId" caption="园区信息列表"  panel="false"
				src="esb/web/bbmParkManager/getPagerBbmParks.json" dataFormId="form_bbmPark"
				editSrc="esb/web/bbmParkManager/getBbmPark.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmParkManager/removeBbmPark.json">
		<youi:fieldLayout prefix="search" labelWidths="100,100">
			<youi:fieldText property="parkName"  caption="园区名称" operator="LIKE"/>
			<youi:fieldText property="mainIndustry"  caption="主导服务" operator="LIKE"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="parkName"  caption="园区名称" width="150" align="center"/>
		<youi:gridCol property="email"  caption="园区邮箱" width="150"/>
		<youi:gridCol property="buildDate"  caption="成立时间" width="100" align="center"/>
		<youi:gridCol property="tel"  caption="联系电话" width="100" align="center"/>
		<youi:gridCol property="mainIndustry"  caption="主导服务" width="150" align="center"/>
		<youi:gridCol property="address"  caption="园区地址" width="150"/>
		<youi:gridCol property="parkIntroduce"  caption="园区简介" width="150"/>
		<youi:gridCol property="manager"  caption="园区负责人" width="80" align="center"/>
		<youi:gridCol property="backgroundImage"  caption="园区背景图URL" width="150" align="center"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-园区信息编辑 -->
	<youi:form dialog="true" caption="园区信息" id="form_bbmPark" action="esb/web/bbmParkManager/saveBbmPark.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="parkId"  caption="园区ID"/>
			<youi:fieldText property="parkName"  caption="园区名称" notNull="true" column="2"/>
			<youi:fieldArea property="parkIntroduce"  caption="园区简介" column="2" rows="3" />
			<youi:fieldText property="email"  caption="园区邮箱"/>
			<youi:fieldText property="tel"  caption="联系电话" />
			<youi:fieldCalendar property="buildDate"  caption="成立时间" format="yyyy-MM-dd" textFormat="yyyy-MM-dd"/>
			<youi:fieldText property="manager"  caption="园区负责人" />
			<youi:fieldText property="mainIndustry"  caption="主导服务" column="2"/>
			<youi:fieldText property="address"  caption="园区地址" column="2"/>
			<youi:fieldText property="backgroundImage"  caption="园区背景图URL" column="2"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>