<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_purchasingmanagerGenreevaluate" idKeys="genreevaluateId,serviceAttitude,reactionRate,costPerformance,overallSatisfaction,member" caption="商品分类评价信息表列表"  panel="false" add="NOT"
				src="esb/web/purchasingmanagerGenreevaluateManager/getPagerPurchasingmanagerGenreevaluates.json" dataFormId="form_purchasingmanagerGenreevaluate"
				editSrc="esb/web/purchasingmanagerGenreevaluateManager/getPurchasingmanagerGenreevaluate.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerGenreevaluateManager/removePurchasingmanagerGenreevaluate.json">
		<youi:fieldLayout>
<%-- 			<youi:fieldSelect property="serviceAttitude"  convert="evaluateStar" caption="服务态度"/>
			<youi:fieldSelect property="reactionRate"  convert="evaluateStar" caption="反应速度"/>
			<youi:fieldSelect property="costPerformance"  convert="evaluateStar" caption="性价比"/>
			<youi:fieldSelect property="overallSatisfaction" convert="evaluateStar"  caption="整体满意度"/>
	
			<youi:fieldSelect property="type" convert="evaluateType"  caption="类型"/> --%>
			<youi:fieldSelect property="purGenre.genreId" src="esb/web/purchasingmanagerGenreManager/getCompSerOrderTypes.json" 
				show="genreName" code="genreId" caption="商品类别"/>
			<youi:fieldHidden property="type" caption="类型" defaultValue="02"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="purGenre.genreName"  caption="商品类别" align="center" width="15%" />
		<%-- <youi:gridCol property="type" convert="evaluateType" caption="类型" align="center" width="15%" /> --%>
		<youi:gridCol property="content"  caption="内容" align="center" width="40%" />
		<youi:gridCol property="memberInformation.memberName"  caption="评论人" align="center" width="15%" />
<%--         <youi:gridCol property="serviceAttitude" convert="evaluateStar" caption="服务态度" align="center" width="12%" />
		<youi:gridCol property="reactionRate"  convert="evaluateStar" caption="反应速度" align="center" width="12%" />
		<youi:gridCol property="costPerformance" convert="evaluateStar"  caption="性价比" align="center" width="12%" />
		<youi:gridCol property="overallSatisfaction" convert="evaluateStar"  caption="整体满意度" align="center" width="12%" /> --%>
		<youi:gridCol property="createTime"  caption="创建时间" align="center" width="15%" />
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<%-- <youi:button name="edit" caption="修改"/> --%>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-商品分类评价信息表编辑 -->
	<youi:form dialog="true" caption="商品分类评价信息表" id="form_purchasingmanagerGenreevaluate" 
	action="esb/web/purchasingmanagerGenreevaluateManager/savePurchasingmanagerGenreevaluate.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldSelect property="serviceAttitude"  convert="evaluateStar" caption="服务态度"/>
			<youi:fieldSelect property="reactionRate" convert="evaluateStar" caption="反应速度"/>
			<youi:fieldSelect property="costPerformance" convert="evaluateStar" caption="性价比"/>
			<youi:fieldSelect property="overallSatisfaction" convert="evaluateStar" caption="整体满意度"/>
			<youi:fieldHidden property="genreevaluateId"  caption="评价ID"/>
			<youi:fieldHidden property="member"  caption="会员"/>
			<youi:fieldHidden property="createTime"  caption="创建时间"/>
			<youi:fieldHidden property="createUser"  caption="创建人"/>
			<youi:fieldHidden property="updateUser"  caption="修改人"/>
			<youi:fieldSelect property="purGenre.genreId" src="esb/web/purchasingmanagerGenreManager/getCompSerOrderTypes.json" 
				show="genreName" code="genreId" caption="商品类别"/>
			<youi:fieldSelect property="type" convert="evaluateType" caption="类型"/>
			<youi:fieldArea column="2" property="content"  caption="内容"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>