<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:grid id="grid_informationNotice" idKeys="noticeId" caption="公告信息列表"  panel="false"
				src="esb/web/informationNoticeManager/getPagerInformationNotices.json" dataFormId="form_informationNotice"
				editSrc="esb/web/informationNoticeManager/getInformationNotice.json" edit="NOT" remove="NOT" showCheckbox="true"
				removeSrc="esb/web/informationNoticeManager/removeInformationNotice.json">
		<youi:fieldLayout>
	     	<youi:fieldSelect property="noticeRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldCalendar property="noticeTime" caption="发布时间"/>
			<youi:fieldText property="noticeTitle" caption="标题"/>
		</youi:fieldLayout>
	    <youi:gridCol property="noticeRe" caption="企业信息" renderer="renderer_noticeRe" width="20%"/>
		<youi:gridCol property="noticeSum" caption="收藏次数" width="10%"/>
		<youi:gridCol property="noticeCount" caption="浏览次数" width="10%"/>
		<youi:gridCol property="noticeTime" caption="发布时间" width="20%"/>
		<youi:gridCol property="noticeTitle" caption="标题" width="20%"/>
		<youi:gridCol property="noticeContent" caption="内容" width="20%"/>
		<youi:gridCol width="60" fixed="true" property="button" type="button" caption="操作">
			<youi:button name="edit" caption="修改"/>
			<youi:button name="remove" caption="删除"/>
		</youi:gridCol>
	</youi:grid>
	
	<!-- form-公告信息编辑 -->
	<youi:form dialog="true" caption="公告信息" id="form_informationNotice" action="esb/web/informationNoticeManager/saveInformationNotice.json">
		<youi:fieldLayout prefix="record" columns="1" labelWidths="120,120">
			<youi:fieldSelect property="noticeRe" caption="企业信息" 
				src="esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json" code="rzId" show="rzName"/>
			<youi:fieldHidden property="noticeId"  caption="ID"/> 
			<youi:fieldText property="noticeTitle"  caption="标题" notNull="true"/>
			<youi:fieldCalendar property="noticeTime"  caption="发布时间" notNull="true"/>
			<youi:fieldText property="noticeSum"  caption="收藏次数"/> 
			<youi:fieldText property="noticeCount"  caption="浏览次数"/>
			<youi:fieldArea property="noticeContent"  caption="内容" notNull="true" rows="8" column="20"/>
		</youi:fieldLayout>
	</youi:form>
	<youi:func name="renderer_noticeRe" params="col,record">
        if(record.noticeRe !="" && record.noticeRe !=null){
	 		var rzName = ""; 
			$.youi.ajaxUtil.ajax({
				url:'esb/web/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
				data:'rzId='+record.noticeRe,
				async: false, 
				success:function(result){
					rzName=result.record.rzName;
				}
			});
			return rzName;
        }
	</youi:func>
</youi:page>