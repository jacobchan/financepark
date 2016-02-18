<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<%-- <youi:grid id="grid_purchasingmanagerCommodityExtendValue" idKeys="commodityExtendValueId" caption="商品扩展属性值表列表"  panel="false"
				src="esb/web/purchasingmanagerCommodityExtendValueManager/getPagerPurchasingmanagerCommodityExtendValues.json" dataFormId="form_purchasingmanagerCommodityExtendValue"
				editSrc="esb/web/purchasingmanagerCommodityExtendValueManager/getPurchasingmanagerCommodityExtendValue.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/purchasingmanagerCommodityExtendValueManager/removePurchasingmanagerCommodityExtendValue.json">
		<youi:fieldLayout>
			<youi:fieldText property="purchasingmanagerCommodity.commodityTitle"  caption="商品名称"/>
			<youi:fieldText property="purchasingmanagerCommodityExtend.commodityExtendFieldName"  caption="字段名称"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="purchasingmanagerCommodity.commodityTitle"  caption="商品名称"/>
		<youi:gridCol property="purchasingmanagerCommodityExtend.commodityExtendFieldName"  caption="字段名称"/>
		<youi:gridCol property="commodityExtendValueDisplayContent"  caption="显示内容"/>
		
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid> --%>
	
	<!-- form-商品扩展属性值表编辑 -->
	<youi:form dialog="false" caption="" id="form_purchasingmanagerCommodityExtendValue" action="web/commodityExtend/saveCommodityExtend.json">
		<youi:fieldLayout prefix="record" labelWidths="120,120">
			<youi:fieldHidden property="commodityId"  caption="商品ID"/>
			<youi:fieldText property="pinpai"  caption="商品品牌"/>
			<%-- <youi:fieldText property="commodityExtendContent"  caption="内容"/> --%>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	<youi:func name="init">
		var commodityId = $elem('record_commodityId',pageId).fieldValue();
		$.youi.ajaxUtil.ajax({
			url:'web/commodityExtend/getValue.json',
			data:{commodityId:commodityId,commodityExtendValueFieldName:'pinpai'},
			success:function(result){
				var record = result.record;
				$elem('record_pinpai',pageId).fieldValue(record.buff);
			}
		});
	</youi:func>
	<youi:func name="form_purchasingmanagerCommodityExtendValue_beforeSubmit">
		var pinpai = $elem('record_pinpai',pageId).fieldValue();
		if(null != pinpai&&"" != pinpai){
			return true;
		}else{
			alert("内容不能为空！");
			return false;
		}
		
	</youi:func>
	<youi:func name="form_purchasingmanagerCommodityExtendValue_afterSubmit">
		alert('提交成功！');
	</youi:func>
	
	<!--**********************************页面函数End**********************************-->
</youi:page>