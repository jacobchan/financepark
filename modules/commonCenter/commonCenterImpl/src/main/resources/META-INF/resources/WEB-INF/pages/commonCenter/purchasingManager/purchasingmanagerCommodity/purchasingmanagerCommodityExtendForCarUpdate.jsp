<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- form-商品及其扩展属性增加编辑 -->
	<youi:form dialog="false" caption="车辆及其扩展属性修改" id="form_purchasingmanagerCommodityRoom" submit="NOT"
		action="esb/web/purchasingmanagerPublicManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record_sFpro" labelWidths="120,120">
		    <youi:fieldHidden property="commodityId"  caption="商品ID"/>
		   <youi:fieldHidden property="genreCode"  caption="车辆" defaultValue="0302"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>
			<youi:fieldSelect property="car.dw" caption="档位" convert="stalls" notNull="true"/>
			<youi:fieldText property="car.zw"  caption="座位" notNull="true"/>
			<youi:fieldText property="car.chepai"  caption="车牌" notNull="true"/>
		    <youi:fieldSelect property="genreId" caption="商品类别"  src="esb/web/purchasingmanagerPublicManager/getRecordsByGenreCode.json" parents="genreCode" parentsAlias="genreCode" notNull="true" code="genreId" show="genreName"/>
			<youi:fieldSelect property="purchasingmanagerMerchant.merchantId" caption="所属商户" src="esb/web/purchasingmanagerMerchantManager/getMerchantsByGenre.json" parents="genreId" parentsAlias="genreId" notNull="true" code="merchantId" show="merchantName"/>
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
				$elem('record_sFpro_purchasingmanagerMerchant_merchantId',pageId).fieldValue(record.purchasingmanagerMerchant.merchantId);
				if(record.commodityImage != null){
				   $elem('record_sFpro_commodityImage',pageId).fieldValue(record.commodityImage);
				}
				if(record.commodityCoverImage != null){
				   $elem('record_sFpro_commodityCoverImage',pageId).fieldValue(record.commodityCoverImage);
				}
				$elem('record_sFpro_commodityDescribe',pageId).fieldValue(record.commodityDescribe);
				$elem('record_sFpro_car_dw',pageId).fieldValue(record.car.dw);
				$elem('record_sFpro_car_zw',pageId).fieldValue(record.car.zw);
				$elem('record_sFpro_car_chepai',pageId).fieldValue(record.car.chepai);
				
			}
		});
		
</youi:func>
   
	<!-- 行动作 -->
	<youi:func name="func_form_chargeSubmit" >
	    var commodityId = $elem('record_sFpro_commodityId',pageId).fieldValue();
		var commodityTitle = $elem('record_sFpro_commodityTitle',pageId).fieldValue();
		var commodityPrice = $elem('record_sFpro_commodityPrice',pageId).fieldValue();
	    var stalls = $elem('record_sFpro_car_dw',pageId).fieldValue();
	    var seat = $elem('record_sFpro_car_zw',pageId).fieldValue();
	    var licensePlate = $elem('record_sFpro_car_chepai',pageId).fieldValue();
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
		if(!stalls || stalls==''){
		   alert("档位不能为空");
		   return false;
		}
		if(!seat || seat==''){
		   alert("座位不能为空");
		   return false;
		}
		if(!licensePlate || licensePlate==''){
		   alert("车牌不能为空");
		   return false;
		}
		if(!genreId || genreId==''){
		   alert("商品类别不能为空");
		   return false;
		}
		if(!merchantId || merchantId==''){
		   alert("所属商户不能为空");
		   return false;
		}
		if(!commodityDescribe || commodityDescribe==''){
		   alert("描述不能为空");
		   return false;
		}
		var params = '';
		params = params+'commodityId='+commodityId+'&'+'commodityTitle='+commodityTitle+'&'+'commodityPrice='+commodityPrice+'&'+'car.dw='+stalls+'&'+'car.chepai='+licensePlate+'&'+'car.zw='+seat+'&'+
		'genreId='+genreId+'&'+'purchasingmanagerMerchant.merchantId='+merchantId+'&'+'commodityImage='+commodityImage+'&'+'commodityCoverImage='+commodityCoverImage+'&'+'commodityDescribe='+commodityDescribe;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/purchasingmanagerPublicManager/saveCommodityAndPropertyForCar.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("修改成功!");
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>