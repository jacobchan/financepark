<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- form-商品及其扩展属性增加编辑 -->
	<youi:form dialog="false" caption="商品及其扩展属性增加" id="form_purchasingmanagerCommodity" submit="NOT"
		action="esb/web/purchasingmanagerPublicManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record_sFpro" labelWidths="120,120">
		    <youi:fieldHidden property="genreCode"  caption="车辆" defaultValue="0302"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>
				<%--<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="bbmRoom.roomId"  caption="单元编号" onlyLeaf="true"/>
		 <youi:fieldTree simple="false" popup="true" tree="${genreTree}" property="purchasingmanagerGenre.genreId" caption="商品类别" onlyLeaf="true" notNull="true"/> --%>
			 <youi:fieldSelect property="purchasingmanagerGenre.genreId" caption="商品类别"  src="esb/web/purchasingmanagerPublicManager/getRecordsByGenreCode.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="genreId" show="genreName"/>
			<youi:fieldSelect property="purchasingmanagerMerchant.merchantId" show="merchantName" code="merchantId" notNull="true"
				src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" caption="所属商户"
				parents="purchasingmanagerGenre.genreId" parentsAlias="purchasingmanagerGenre.genreId"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2" notNull="true"/>
		</youi:fieldLayout>
		<youi:button name="chargeSubmit" caption="提交"></youi:button>
		
	</youi:form>
	
	
	<youi:grid id="grid_purCommodityExtend" idKeys="commodityExtendId" caption="商品扩展信息"  panel="true" scrollHeight="240"
				src="esb/web/purchasingmanagerPublicManager/getPagerCommodityExtsByGenreId.json" 
				showCheckbox="true" 
				submit="NOT" reset="NOT" usePager="false" editable="true">
		<youi:fieldLayout>
			 <youi:fieldHidden property="genreCode"  caption="车辆" defaultValue="0302"/>
		</youi:fieldLayout>
		<youi:gridCol width="30%" property="purchasingmanagerGenreProperty.genrePropertyDisplayName" caption="字段显示名称"/>
		<youi:gridCol width="30%" property="purchasingmanagerGenreProperty.genrePropertyFieldName" caption="字段名称"/>
		<youi:gridCol width="40%" editor="fieldText" property="commodityExtendContent" caption="字段值"/>
		<youi:gridCol width="0" property="purchasingmanagerGenreProperty.genrePropertyId" caption="类别属性ID"/>
	</youi:grid>
	
   <!--**********************************页面函数********************************-->
	<!-- 行动作 -->
	<youi:func name="func_form_chargeSubmit" >
		var commodityTitle = $elem('record_sFpro_commodityTitle',pageId).fieldValue();
		var commodityPrice = $elem('record_sFpro_commodityPrice',pageId).fieldValue();
	    <!-- var roomId = $elem('record_sFpro_bbmRoom_roomId',pageId).fieldValue(); -->
	    var genreId = $elem('record_sFpro_purchasingmanagerGenre_genreId',pageId).fieldValue();
	    var merchantId =$elem('record_sFpro_purchasingmanagerGenre_merchantId',pageId).fieldValue();
		var commodityImage = $elem('record_sFpro_commodityImage',pageId).fieldValue();
		var commodityCoverImage = $elem('record_sFpro_commodityCoverImage',pageId).fieldValue();
		var commodityDescribe = $elem('record_sFpro_commodityDescribe',pageId).fieldValue();
		var records = $elem('grid_purCommodityExtend',pageId).grid('getRecords');
		var submitRecord = {'records':records};
alert(merchantId);
		var fieldValues = $.youi.recordUtils.recordToParameters(submitRecord);
		var params = '';
		for(var i=0;i<fieldValues.length;i++){
			if($.youi.stringUtils.notEmpty(fieldValues[i].value)){
				params = params+$.youi.parameterUtils.propertyParameter(fieldValues[i].property,fieldValues[i].value)+'&';
			}
		}
		params = params+'commodityTitle='+commodityTitle+'&'+'commodityPrice='+commodityPrice+'&'+
		'purchasingmanagerGenre.genreId='+genreId+'&'+'purchasingmanagerMerchant.merchantId='+merchantId+'&'+'commodityImage='+commodityImage+'&'+'commodityCoverImage='+commodityCoverImage+'&'+'commodityDescribe='+commodityDescribe;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/purchasingmanagerPublicManager/saveCommodityAndProperty.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("添加成功!");
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>