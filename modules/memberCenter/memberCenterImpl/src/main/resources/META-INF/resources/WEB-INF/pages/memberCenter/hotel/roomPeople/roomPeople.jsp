<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_roomPeople" idKeys="recId" caption="房间联系人关系列表"  panel="false"
				src="esb/web/roomPeopleManager/getPagerRoomPeoples.json" dataFormId="form_roomPeople"
				editSrc="esb/web/roomPeopleManager/getRoomPeople.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/roomPeopleManager/removeRoomPeople.json">
		<youi:fieldLayout>
			<youi:fieldText property="contractsId"  caption="联系人ID"/>

		</youi:fieldLayout>
		<youi:gridCol property="contractsId"  caption="联系人ID"/>

		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-房间联系人关系编辑 -->
	<youi:form dialog="true" caption="房间联系人关系" id="form_roomPeople" action="esb/web/roomPeopleManager/saveRoomPeople.json">
		<youi:fieldLayout prefix="record">
			<youi:fieldText property="contractsId"  caption="联系人ID"/>
			<youi:fieldText property="recId"  caption="REC_ID_"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面函数Start********************************-->
	
	<!--**********************************页面函数End**********************************-->
</youi:page>