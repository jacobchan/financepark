<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
				<youi:grid id="grid_publicutilitiesmanagerReso" idKeys="resoId" caption="资源状态列表"  panel="false"
				src="esb/web/publicutilitiesmanagerResoManager/getPagerPublicutilitiesmanagerResos.json" dataFormId="form_publicutilitiesmanagerReso"
				editSrc="esb/web/publicutilitiesmanagerResoManager/getPublicutilitiesmanagerReso.json" edit="NOT" add="预定" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/publicutilitiesmanagerResoManager/removePublicutilitiesmanagerReso.json">
		<youi:fieldLayout>

			<youi:fieldCalendar property="resoDate"  caption="可用日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd"/>
			<youi:fieldSelect property="resoStatus"  caption="资源状态" convert="resoStatus">
				<%-- <youi:fieldOption caption="可用" value="00"></youi:fieldOption>
				<youi:fieldOption caption="已过期" value="01"></youi:fieldOption> --%>
			</youi:fieldSelect>
			<youi:fieldSelect property="resoTime"  caption="可用时段" convert="resoTime"/>
		</youi:fieldLayout>
       <%--  <youi:button name="reserve" caption="预约" active="1"/> --%>
		<youi:gridCol property="commodityId.commodityTitle"  caption="商品名称" width="20%"  align="center"/>
		<youi:gridCol property="resoStatus"  caption="资源状态" convert="resoStatus" width="20%" align="center"/>
		<youi:gridCol property="resoDate"  caption="可用日期" orderBy="desc" width="20%" align="center"/>
		<youi:gridCol property="resoTime"  caption="可用时段" convert="resoTime" width="20%" align="center"/>
		<youi:gridCol property="updateTime"  caption="更新时间" width="20%" align="center" orderBy="desc"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-资源状态编辑 -->
	<youi:form dialog="true" caption="资源状态" id="form_publicutilitiesmanagerReso" action="esb/web/publicutilitiesmanagerResoManager/savePublicutilitiesmanagerReso.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldSelect property="commodityId.genreId"  caption="商品类型" src="esb/web/purchasingmanagerGenreManager/getPurchasingmanagerGenresByGenreCode.json" code="genreId" show="genreName" notNull="true"/>	
			 <youi:fieldSelect property="commodityId.commodityId"  caption="商品" src="esb/web/purchasingmanagerCommodityManager/getCommodityRecordsByRecordType.json" notNull="true" parents="commodityId.genreId" parentsAlias="commodityId.genreId" code="commodityId" show="commodityTitle"/>
			 <youi:fieldCalendar property="resoDate"  caption="可用日期" textFormat="yyyy-MM-dd" format="yyyy-MM-dd" notNull="true"/>
			<youi:fieldSelect property="resoTime"  caption="可用时段" convert="resoTime" notNull="true"/>
			<youi:fieldSelect property="resoStatus"  caption="资源状态" convert="resoStatus"/>
			<youi:fieldHidden property="resoId"  caption="资源状态序列" />
			<youi:fieldHidden property="updateTime"  caption="更新时间" />
			<youi:fieldHidden property="updateUser"  caption="更新人" />
			<youi:fieldHidden property="createUser"  caption="创建人" />
			<youi:fieldHidden property="createTime"  caption="创建时间" />
			<%-- <youi:fieldHidden property="resoStatus"  caption="资源状态"/> --%>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
		<youi:func name="func_grid_reserve">
	var gridElement = $elem('grid_publicutilitiesmanagerReso',pageId);
	var select = gridElement.grid('getSelectedRecord');
	var resoId=select.resoId;
	$.youi.ajaxUtil.ajax({
		url:'esb/web/publicutilitiesmanagerResoManager/savePublicResoOrder.json',
	 	data:{resoId:resoId},
		success:function(result){
            alert("订单预约成功！");
			gridElement.grid('pReload');
		}
	});

	</youi:func>
	<!--**********************************页面函数End**********************************-->
	<!--**********************************页面函数End**********************************-->
</youi:page>