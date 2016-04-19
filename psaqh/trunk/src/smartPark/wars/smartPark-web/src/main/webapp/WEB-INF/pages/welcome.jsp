<%@ include file="/WEB-INF/pages/include.jsp"%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<youi:script src="/scripts/3.0/lib/highcharts.js"/>
<youi:script src="/scripts/3.0/lib/highcharts-more.js"/>


<youi:page pageId="000000">
	<!-- 页面描述：欢迎页面-->
	<!--**********************************子页面**********************************-->

	<!--**********************************子页面**********************************-->
	<youi:ajaxUrl name="addUser" src="/esb001/addUser.json"></youi:ajaxUrl>
	<youi:ajaxUrl name="removeUser" src="/esb001/removeUser.json"></youi:ajaxUrl>
	<!-- 放在页面开始处，最先执行，根据实际情况调整-->
	<script type="text/javascript">
		function loadPage(pageId,pageUrl,pageTitle,id){
			pageUrl = $.youi.parameterUtils.connectParameter(pageUrl,'timeStamp_',new Date().getTime());
			pageUrl = $.youi.parameterUtils.connectParameter(pageUrl,'page:pageId',pageId);
			//加载页面
			$('body',document).bootstrapLayout('loadPage',pageId,pageUrl,pageTitle,"111");
		};
	</script>
		
	<div id="page_index_container">
		<%-- <youi:panel  caption="快捷访问" column="6" height="611" >
			<youi:form id="form_s" action="esb/fileupload/myservice/myfile.html" submit="NOT" >
				<youi:fieldLayout columns="1">
					<youi:fieldSpinner step="2" styleClass="input-group" property="spinner" caption="spinner"></youi:fieldSpinner>
					
				</youi:fieldLayout>
				<div>选择地址</div>
				<youi:fieldLayout columns="6" labelWidths="1,1,1" >
					<youi:fieldSelect column="1" src="/wxDistrictManager/getCountries.json" caption="国家" property="country" code="code" show="show"></youi:fieldSelect>
					<youi:fieldSelect column="1" src="/wxDistrictManager/getProvinces.json" caption="省份" parents="country" property="province"  code="code" show="show"></youi:fieldSelect>
					<youi:fieldSelect column="4" src="/wxDistrictManager/getCities.json" parents="country,province" property="city"  code="code" show="show"></youi:fieldSelect>
				</youi:fieldLayout>
			</youi:form>
			<!-- <div id="container">
			
			</div> -->
			<a onclick="$('body',document).bootstrapLayout('loadPage','012000','page/manageCenter.EmployeeManager.enterpriseEmployees/enterpriseEmployees.html','1111');" class="tree-a page-link">
				我的任务
			</a>
		</youi:panel> --%>
		<youi:panel caption="我的任务" column="6" height="300">
			<youi:grid id="grid_task" idKeys="RoleId,menuId,menuSrc" dataFormId="form_task"  caption="我的任务列表" 
						src="/taskManager/getAllTasks.json" reset="NOT" submit="NOT" edit="NOT" remove="NOT" add="NOT">
				<youi:gridCol property="taskName" width="50%"  caption="任务名" align="center"/>
				<youi:gridCol property="taskCount" type="link" caption="任务数" width="50%" align="center"/>
			</youi:grid>
		</youi:panel>
		
		<%-- <youi:panel caption="我的消息" column="6" height="350">
			<youi:form id="form_s" action="a.json">
				<youi:fieldLayout>
					<youi:fieldSwfupload property="uploads" column="2" caption="uploads"></youi:fieldSwfupload>
					<youi:fieldCalendar property="cale" format="yyyy-MM-dd" textFormat="yyyy-MM-dd" caption="日期"></youi:fieldCalendar>
					<youi:fieldCalendar property="cale1" format="yyyy-MM-dd" textFormat="yyyy-MM-dd" caption="日期"></youi:fieldCalendar>
					<youi:fieldCalendar property="cale2" format="yyyy-MM-dd" textFormat="yyyy-MM-dd" caption="日期"></youi:fieldCalendar>
					<youi:fieldCalendar property="cale3" format="yyyy-MM-dd" textFormat="yyyy-MM-dd" caption="日期"></youi:fieldCalendar>
					<youi:fieldSpinner step="2" styleClass="input-group" property="spinner" caption="spinner"></youi:fieldSpinner>
				</youi:fieldLayout>
			</youi:form>
			
		</youi:panel>
		
		<youi:panel caption="我的申请" column="6" height="440">
			<div id="container_polar"></div>
		</youi:panel> --%>
	</div>
	
	<!-- 监听通知变化 -->
	<youi:func name="grid_task_link_taskCount" params="idKeys">
		var gridElement = $elem('grid_task',pageId),
		selectedRecord = gridElement.grid('getSelectedRecord');
		var taskCount = selectedRecord.taskCount; 
		var taskName = selectedRecord.taskName; 
		var menuId = idKeys.menuId;
		var menuSrc = idKeys.menuSrc;
		if(taskCount > 0){
			loadPage(menuId,menuSrc,taskName,'1111');
		}
	</youi:func>
	
	<youi:func name="noticereceiver_notice_afterReceive" params="active">
		//alert(active);
	</youi:func>
	
	<youi:func name="grid_user_change" params="record">
		//alert(record.loginName);
	</youi:func>
	
	<youi:func name="grid_user_beforeSubmit">
		return true;
	</youi:func>
</youi:page>