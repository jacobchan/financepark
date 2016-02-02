<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_publicutilitiesmanagerReso" idKeys="resoId" caption="资源状态列表"  panel="false"
				src="esb/web/publicutilitiesmanagerResoManager/getPagerPublicutilitiesmanagerResos.json" dataFormId="form_publicutilitiesmanagerReso"
				editSrc="esb/web/publicutilitiesmanagerResoManager/getPublicutilitiesmanagerReso.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/publicutilitiesmanagerResoManager/removePublicutilitiesmanagerReso.json">
		<youi:fieldLayout>

			<youi:fieldText property="resoDate"  caption="可用日期"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="resoStatus"  caption="资源状态"/>
			<youi:fieldText property="resoTime"  caption="可用时段"/>
		</youi:fieldLayout>

		<youi:gridCol property="resoDate"  caption="可用日期"/>
		<youi:gridCol property="commodityId"  caption="商品ID"/>
		<youi:gridCol property="resoStatus"  caption="资源状态"/>
		<youi:gridCol property="resoTime"  caption="可用时段"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-资源状态编辑 -->
	<youi:form dialog="true" caption="资源状态" id="form_publicutilitiesmanagerReso" action="esb/web/publicutilitiesmanagerResoManager/savePublicutilitiesmanagerReso.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="resoId"  caption="资源状态序列"/>
			<youi:fieldText property="resoDate"  caption="可用日期"/>
			<youi:fieldText property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="resoStatus"  caption="资源状态"/>
			<youi:fieldText property="resoTime"  caption="可用时段"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>