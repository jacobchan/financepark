<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	
	<youi:subpage subpageId="viewDmTabs" height="600" caption="售卖佣金记录"
		src="page/distribution.income.salesRec/viewDmTabs.html?saleRecId={saleRecId}" >
	</youi:subpage>
	
	<youi:grid id="grid_salesRec" idKeys="saleRecId" caption="楼宇售卖记录列表"  panel="false"
				src="esb/web/salesRecManager/getPagerSalesRecs.json" dataFormId="form_salesRec"
				editSrc="esb/web/salesRecManager/getSalesRec.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/salesRecManager/removeSalesRec.json">
		<youi:fieldLayout>
			<youi:fieldText property="disLevelCount"  caption="分佣层数"/>
			<youi:fieldText property="factDisRateShow"  caption="分佣总比例" />
			<youi:fieldText property="factDisAmount"  caption="分佣总额" />
			<youi:fieldText property="saleAmount"  caption="成交金额"/>
			<youi:fieldText property="preDisAmount"  caption="预计分佣总额" />
			<%-- <youi:fieldText property="recId"  caption="序列"/> --%>
			<%-- <youi:fieldText property="roomId"  caption="单元ID"/> --%>
			<youi:fieldText property="isOut"  caption="是否超额"/>
			<youi:fieldText property="isExtract"  caption="是否提佣" />
		</youi:fieldLayout>
		<youi:gridCol property="disLevelCount"  caption="分佣层数" align="center"/>
		<youi:gridCol property="factDisRate"  caption="分佣总比例" align="right"/>
		<youi:gridCol property="factDisAmount"  caption="分佣总额" align="right"/>
		<%-- <youi:gridCol property="roomId"  caption="单元ID"/> --%>
		<youi:fieldHidden property="roomId"></youi:fieldHidden>
		<%-- <youi:gridCol property="recId"  caption="序列"/> --%>

		<youi:gridCol property="saleAmount"  caption="成交金额"  />
		<youi:gridCol property="preDisAmount"  caption="预计分佣总额"/>
		<youi:gridCol property="isOut"  caption="是否超额"/>
		<youi:gridCol property="isExtract"  caption="是否提佣" convert="bool" />
		
		 <youi:button active="1" name="viewDmTabs" caption="详细信息"/>   
		<%-- <youi:gridCol width="10%" fixed="false" property="button" type="button" caption="详细信息">
			<youi:button name="viewDmTabs" icon="search" caption="详细信息"/> 
		</youi:gridCol> --%>
	
	</youi:grid>
	
	<!-- form-楼宇售卖记录编辑 -->
	<youi:form dialog="true" caption="楼宇售卖记录" id="form_salesRec" action="esb/web/salesRecManager/saveSalesRec.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldHidden property="saleRecId"/>
			<youi:fieldSelect property="roomId" caption="所属单元" code="roomId" show="roomNo" 
				src="esb/web/bbmRoomManager/getSaleBbmRooms.json" />
				
			<youi:fieldSelect property="memPhone" caption="联系方式" code="memPhone" show="memPhone" 
				src="esb/web/recommendMemberManager/getRecommendMembers.json" />
			
			<%-- <youi:fieldSelect property="itemName" caption="优惠单元" code="itemName" show="itemName" 
				src="esb/web/buildingRateManager/getBuildingRates.json" /> --%>
			
			<youi:fieldText property="saleAmount"  caption="成交金额"/>
			
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	
	<youi:func name="func_grid_viewDmTabs">
		var selectRecord = $elem('grid_salesRec',pageId).grid('getSelectedRecord');
		var saleRecId = selectRecord['saleRecId'];
		var subpageElement = $elem('subpage_viewDmTabs',pageId);
		subpageElement.subpage('open',{salesRec:saleRecId},null,{salesRec:saleRecId});
	</youi:func>
	
	<!--**********************************页面函数End**********************************-->
</youi:page>
