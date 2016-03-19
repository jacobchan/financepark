<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationProduct" idKeys="productId"
		caption="产品信息列表" panel="false"
		src="esb/web/informationProductManager/getPagerInformationProducts.json"
		dataFormId="form_informationProduct"
		editSrc="esb/web/informationProductManager/getInformationProduct.json"
		edit="NOT" remove="NOT" showCheckbox="true"
		removeSrc="esb/web/informationProductManager/removeInformationProduct.json">
		<youi:fieldLayout>
			<youi:fieldSelect property="productRe" caption="企业"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" />
			<youi:fieldText property="productType" caption="产品类别" />
			<youi:fieldText property="productName" caption="产品名称" />
		</youi:fieldLayout>
		<youi:gridCol property="productRe" caption="企业信息" renderer="renderer_productRe" width="25%" />
		<youi:gridCol property="productName" caption="产品名称" width="25%" />
		<youi:gridCol property="productType" caption="产品类别" width="25%" />
		<youi:gridCol property="productContent" caption="产品描述" width="25%" />
		<youi:gridCol width="60" fixed="true" property="button" type="button"
			caption="操作">
			<youi:button name="edit" caption="修改" />
			<youi:button name="remove" caption="删除" />
		</youi:gridCol>
	</youi:grid>

	<!-- form-产品信息编辑 -->
	<youi:form dialog="true" caption="产品信息" id="form_informationProduct"
		action="esb/web/informationProductManager/saveInformationProduct.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldHidden property="productId"  caption="主键"/>
			<youi:fieldSelect property="productRe" caption="企业信息"
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json"
				code="rzId" show="rzName" notNull="true" />
			<youi:fieldText property="productName" caption="产品名称" notNull="true" />
			<youi:fieldText property="productType" caption="产品类别" notNull="true" />
			<youi:fieldArea property="productContent" caption="产品描述" notNull="true" rows="8" column="20" />
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="renderer_productRe" params="col,record">
        if(record.productRe !="" && record.productRe !=null){
	 		var rzName = ""; 
			$.youi.ajaxUtil.ajax({
				url:'esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
				data:'rzId='+record.productRe,
				async: false, 
				success:function(result){
					rzName=result.record.rzName;
				}
			});
			return rzName;
        }
	</youi:func>
</youi:page>