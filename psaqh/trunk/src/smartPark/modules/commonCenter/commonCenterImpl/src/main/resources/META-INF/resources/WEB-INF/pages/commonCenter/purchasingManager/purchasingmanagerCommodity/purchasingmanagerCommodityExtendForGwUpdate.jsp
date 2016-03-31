<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- form-商品及其扩展属性增加编辑 -->
	<youi:form dialog="false" caption="工位及其扩展属性修改" id="form_purchasingmanagerCommodityRoom" submit="NOT"
		action="esb/web/purchasingmanagerPublicManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record_sFpro" labelWidths="120,120">
		    <youi:fieldHidden property="commodityId"  caption="商品ID"/>
		   <youi:fieldHidden property="genreCode"  caption="工位" defaultValue="040101"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>
			<youi:fieldSelect property="genreId" caption="商品类别"  src="esb/web/purchasingmanagerPublicManager/getRecordsByGenreCode.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="genreId" show="genreName"/>
		   <youi:fieldSelect property="gw.commodityId" show="itemName" code="itemValue"
				src="esb/web/reservationRecordManager/getRecordsByRecordType.json" notNull="true" caption="所属创立方"/>
			<youi:fieldSelect property="purchasingmanagerMerchant.merchantId" show="merchantName" code="merchantId"
				src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" caption="所属商户"
				parents="genreId" parentsAlias="genreId"/>
			<youi:fieldSwfupload property="commodityImage" caption="图像" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" />
			<youi:fieldSwfupload property="commodityCoverImage"  caption="封面图片" uploadUrl="/common/uploadImage.html" fileTypes="*.jpg;*.jpeg;*.png"  fileTypesDescription="所有类型" fileSizeLimit="3072" fileUploadLimit="1" fileQueueLimit="1"/>
			<youi:fieldArea property="commodityDescribe"  caption="描述" column="2" notNull="true"/>
		</youi:fieldLayout>
		<youi:button name="chargeSubmit" caption="提交"></youi:button>
		
	</youi:form>
	
   <!--**********************************页面函数********************************-->
   	<!-- 初始化页面数据 -->
	<youi:func name="subpage_init" params="record">
		$elem('record_sFpro_commodityId',pageId).fieldValue(record.commodityId);
		var commodityId=$elem('record_sFpro_commodityId',pageId).fieldValue();
		var params = '';
	    var genreCode = $elem('record_sFpro_genreCode',pageId).fieldValue();
		params = params+'genreCode='+genreCode+'&'+'commodityId='+commodityId;
			$.youi.ajaxUtil.ajax({
			url:'/esb/web/purchasingmanagerPublicManager/getPurchasingmanagerCommodityForPublic.json',
			data:params,
			success:function(result){
				var record = result.record;
				$elem('record_sFpro_commodityTitle',pageId).fieldValue(record.commodityTitle);
				$elem('record_sFpro_commodityPrice',pageId).fieldValue(record.commodityPrice);
				$elem('record_sFpro_genreId',pageId).fieldValue(record.genreId);
				$elem('record_sFpro_gw_commodityId',pageId).fieldValue(record.gw.commodityId);
				$elem('record_sFpro_commodityDescribe',pageId).fieldValue(record.commodityDescribe);
				if(record.commodityImage != null){
				   $elem('record_sFpro_commodityImage',pageId).fieldValue(record.commodityImage);
				}
				if(record.commodityCoverImage != null){
				   $elem('record_sFpro_commodityCoverImage',pageId).fieldValue(record.commodityCoverImage);
				}
				
				
				
			}
		});
		
	</youi:func>
   
	<!-- 行动作 -->
	<youi:func name="func_form_chargeSubmit" >
	    var commodityId = $elem('record_sFpro_commodityId',pageId).fieldValue();
		var commodityTitle = $elem('record_sFpro_commodityTitle',pageId).fieldValue();
		var commodityPrice = $elem('record_sFpro_commodityPrice',pageId).fieldValue();
	    var commodityName = $elem('record_sFpro_gw_commodityId',pageId).fieldValue();
	    var genreId = $elem('record_sFpro_genreId',pageId).fieldValue();
	    var merchantId = $elem('record_sFpro_purchasingmanagerMerchant_merchantId',pageId).fieldValue();
		var commodityImage = $elem('record_sFpro_commodityImage',pageId).fieldValue();
		var commodityCoverImage = $elem('record_sFpro_commodityCoverImage',pageId).fieldValue();
		var commodityDescribe = $elem('record_sFpro_commodityDescribe',pageId).fieldValue();
		if(!commodityTitle || commodityTitle==''){
		   alert("标题不能为空");
		   return false;
		}
		if(!commodityPrice || commodityPrice==''){
		   alert("标价不能为空");
		   return false;
		}
		if(!commodityName || commodityName==''){
		   alert("所属创立方不能为空");
		   return false;
		}
		
		if(!genreId || genreId==''){
		   alert("商品类别不能为空");
		   return false;
		}
		
		if(!commodityDescribe || commodityDescribe==''){
		   alert("描述不能为空");
		   return false;
		}
		var params = '';
		params = params+'commodityId='+commodityId+'&'+'commodityTitle='+commodityTitle+'&'+'commodityPrice='+commodityPrice+'&'+'gw.commodityId='+commodityName+'&'+
		'genreId='+genreId+'&'+'commodityImage='+commodityImage+'&'+'commodityCoverImage='+commodityCoverImage+'&'+'commodityDescribe='+commodityDescribe;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/purchasingmanagerPublicManager/saveCommodityAndPropertyForGw.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("修改成功!");
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>