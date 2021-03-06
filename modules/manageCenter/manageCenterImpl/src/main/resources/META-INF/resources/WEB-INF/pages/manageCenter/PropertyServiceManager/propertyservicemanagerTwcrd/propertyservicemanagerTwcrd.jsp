<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_propertyservicemanagerTwcrd" idKeys="twcrdId" caption="330214二维码记录列表"  panel="false"
				src="esb/web/propertyservicemanagerTwcrdManager/getPagerPropertyservicemanagerTwcrds.json" dataFormId="form_propertyservicemanagerTwcrd"
				editSrc="esb/web/propertyservicemanagerTwcrdManager/getPropertyservicemanagerTwcrd.json" edit="NOT" remove="NOT" add="NOT" showCheckbox="true"
				removeSrc="esb/web/propertyservicemanagerTwcrdManager/removePropertyservicemanagerTwcrd.json">
		<youi:fieldLayout labelWidths="120,120">
			<youi:fieldText property="propertyservicemanagerFkcode.fkcodeName"  caption="联系人"/>
			<youi:fieldText property="propertyservicemanagerFkcode.fkcodeTelephone"  caption="联系电话"/>
			<youi:fieldSelect property="status"  caption="二维码状态" convert="fx_status"/>
			<youi:fieldText property="twcrdAddrec"  caption="二维码URL"/>
		</youi:fieldLayout>
		<youi:button name="using" caption="使用" icon="edit" ></youi:button>
		<youi:gridCol property="propertyservicemanagerFkcode.fkcodeName"  caption="联系人" width="100" align="center"/>
		<youi:gridCol property="propertyservicemanagerFkcode.fkcodeTelephone"  caption="联系电话" width="160" align="center"/>
		<youi:gridCol property="status"  caption="二维码状态" width="100" align="center" convert="fx_status"/>
		<youi:gridCol property="twcrdAddrec"  caption="二维码URL" width="200"/>
		<%-- <youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol> --%>
	</youi:grid>
	
	<!-- form-330214二维码记录编辑 -->
	<%-- <youi:form dialog="true" caption="330214二维码记录" id="form_propertyservicemanagerTwcrd" action="esb/web/propertyservicemanagerTwcrdManager/savePropertyservicemanagerTwcrd.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="twcrdId"  caption="二维码记录序列"/>
			<youi:fieldText property="twcrdAddrec"  caption="二维码URL地址"/>
		</youi:fieldLayout>
	</youi:form> --%>
	
	<!--**********************************页面函数Start********************************-->
	<!-- 当点击使用按钮时 -->
	<youi:func name="func_grid_using">
		var gridElement = $elem('grid_propertyservicemanagerTwcrd',pageId);
		var	selectedRecord = gridElement.grid('getSelectedRecord');
		var status = selectedRecord.status ;
		if('01' == status){
			alert("此二维码已失效") ;
		}else if('00' == status){
			var twcrdId = selectedRecord.twcrdId ;
			$.youi.ajaxUtil.ajax({
				url:'/esb/web/propertyservicemanagerTwcrdManager/updateTwcrd.json',
				data:{twcrdId:twcrdId},
				success:function(result){
					alert("使用成功！") ;
				$elem('grid_propertyservicemanagerTwcrd',pageId).grid('pReload');
                } 
            });
		}

	</youi:func>
	<!--**********************************页面函数End**********************************-->
</youi:page>