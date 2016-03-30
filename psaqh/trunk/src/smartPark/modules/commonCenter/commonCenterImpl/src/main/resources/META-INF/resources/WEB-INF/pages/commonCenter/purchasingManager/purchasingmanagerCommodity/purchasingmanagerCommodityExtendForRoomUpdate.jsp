<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- form-商品及其扩展属性增加编辑 -->
	<youi:form dialog="false" caption="会议室及其扩展属性修改" id="form_purchasingmanagerCommodityRoom" submit="NOT"
		action="esb/web/purchasingmanagerPublicManager/savePurchasingmanagerCommodity.json">
		<youi:fieldLayout prefix="record_sFpro" labelWidths="120,120">
		    <youi:fieldHidden property="commodityId"  caption="商品ID"/>
		    <youi:fieldHidden property="genreCode"  caption="会议室" defaultValue="0301"/>
			<youi:fieldText property="commodityTitle"  caption="标题" notNull="true"/>
			<youi:fieldText property="commodityPrice"  caption="标价" notNull="true"/>
			<youi:fieldTree simple="false" popup="true" tree="${bbmRoomTree}" property="meetingRoom.adr"  caption="会议室地址" onlyLeaf="true" notNull="true"/>
			<youi:fieldSelect property="meetingRoom.gm"  caption="规模人数" convert="roomGm" notNull="true"/>
			<youi:fieldSelect property="meetingRoom.lx"  caption="会议室类型" convert="roomType" notNull="true"/>
			<youi:fieldSelect property="meetingRoom.tyy"  caption="是否有投影仪" convert="roomProjector" notNull="true"/>
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
				$elem('record_sFpro_meetingRoom_gm',pageId).fieldValue(record.meetingRoom.gm);
				$elem('record_sFpro_meetingRoom_lx',pageId).fieldValue(record.meetingRoom.lx);
				$elem('record_sFpro_meetingRoom_tyy',pageId).fieldValue(record.meetingRoom.tyy);
				$elem('record_sFpro_commodityDescribe',pageId).fieldValue(record.commodityDescribe);
				if(record.commodityImage != null){
				   $elem('record_sFpro_commodityImage',pageId).fieldValue(record.commodityImage);
				}
				if(record.commodityCoverImage != null){
				   $elem('record_sFpro_commodityCoverImage',pageId).fieldValue(record.commodityCoverImage);
				}
				
				
				
			}
		});
		
		<!-- var param = ''+'commodity.commodityId='+commodityId;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/purchasingmanagerCommodityExtendManager/getCommodityExtList.json',
			data:param,
			success:function(result){
				var record = result.records;
				for(var i=0;i<record.length;i++){
					if(record[i].purchasingmanagerGenreProperty.genrePropertyFieldName=='gm'){
				       $elem('record_sFpro_roomContain',pageId).fieldValue(record[i].commodityExtendContent);
				    }
				    if(record[i].purchasingmanagerGenreProperty.genrePropertyFieldName=='lx'){
				       $elem('record_sFpro_roomType',pageId).fieldValue(record[i].commodityExtendContent);
				    }
				    if(record[i].purchasingmanagerGenreProperty.genrePropertyFieldName=='tyy'){
				       $elem('record_sFpro_roomProjector',pageId).fieldValue(record[i].commodityExtendContent);
				    }
				  }
			}
		});
		 -->
	</youi:func>
   
	<!-- 行动作 -->
	<youi:func name="func_form_chargeSubmit" >
	    var commodityId = $elem('record_sFpro_commodityId',pageId).fieldValue();
		var commodityTitle = $elem('record_sFpro_commodityTitle',pageId).fieldValue();
		var commodityPrice = $elem('record_sFpro_commodityPrice',pageId).fieldValue();
	    var roomId = $elem('record_sFpro_meetingRoom_adr',pageId).fieldValue();
	    var roomContain = $elem('record_sFpro_meetingRoom_gm',pageId).fieldValue();
	    var roomType = $elem('record_sFpro_meetingRoom_lx',pageId).fieldValue();
	    var roomProjector = $elem('record_sFpro_meetingRoom_tyy',pageId).fieldValue();
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
		if(!roomId || roomId==''){
		   alert("会议室地址不能为空");
		   return false;
		}
		if(!roomContain || roomContain==''){
		   alert("规模人数不能为空");
		   return false;
		}
		if(!roomType || roomType==''){
		   alert("会议室类型不能为空");
		   return false;
		}
		if(!roomProjector || roomProjector==''){
		   alert("会议室投影仪不能为空");
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
		params = params+'commodityId='+commodityId+'&'+'commodityTitle='+commodityTitle+'&'+'commodityPrice='+commodityPrice+'&'+'meetingRoom.adr='+roomId+'&'+'meetingRoom.gm='+roomContain+'&'+'meetingRoom.lx='+roomType+'&'+'meetingRoom.tyy='+roomProjector+'&'+
		'genreId='+genreId+'&'+'purchasingmanagerMerchant.merchantId='+merchantId+'&'+'commodityImage='+commodityImage+'&'+'commodityCoverImage='+commodityCoverImage+'&'+'commodityDescribe='+commodityDescribe;
		$.youi.ajaxUtil.ajax({
			url:'/esb/web/purchasingmanagerPublicManager/saveCommodityAndPropertyForRoom.json',
			data:params,
			success:function(result){
				var record = result.record;
				alert("修改成功!");
			}
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>