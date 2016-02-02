<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_bbmPark" idKeys="parkId" caption="园区信息列表"  panel="false"
				src="esb/web/bbmParkManager/getPagerBbmParks.json" dataFormId="form_bbmPark"
				editSrc="esb/web/bbmParkManager/getBbmPark.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/bbmParkManager/removeBbmPark.json">
		<youi:fieldLayout>
			<youi:fieldText property="parkName"  caption="园区名称"/>
			<youi:fieldText property="mainIndustry"  caption="主导服务"/>
			<youi:fieldText property="address"  caption="地址"/>
			<youi:fieldText property="tel"  caption="联系电话"/>
			<youi:fieldText property="parkIntroduce"  caption="园区简介"/>
			<youi:fieldText property="manager"  caption="园区负责人"/>
			<youi:fieldText property="email"  caption="邮箱"/>
			<youi:fieldText property="buildDate"  caption="成立时间"/>

		</youi:fieldLayout>
		<youi:gridCol property="parkName"  caption="园区名称"/>
		<youi:gridCol property="mainIndustry"  caption="主导服务"/>
		<youi:gridCol property="address"  caption="地址"/>
		<youi:gridCol property="tel"  caption="联系电话"/>
		<youi:gridCol property="parkIntroduce"  caption="园区简介"/>
		<youi:gridCol property="manager"  caption="园区负责人"/>
		<youi:gridCol property="email"  caption="邮箱"/>
		<youi:gridCol property="buildDate"  caption="成立时间"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-园区信息编辑 -->
	<youi:form dialog="true" caption="园区信息" id="form_bbmPark" action="esb/web/bbmParkManager/saveBbmPark.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="parkName"  caption="园区名称"/>
			<youi:fieldText property="mainIndustry"  caption="主导服务"/>
			<youi:fieldText property="address"  caption="地址"/>
			<youi:fieldText property="tel"  caption="联系电话"/>
			<youi:fieldText property="parkIntroduce"  caption="园区简介"/>
			<youi:fieldText property="manager"  caption="园区负责人"/>
			<youi:fieldText property="email"  caption="邮箱"/>
			<youi:fieldText property="buildDate"  caption="成立时间"/>
			<youi:fieldText property="parkId"  caption="园区ID"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>