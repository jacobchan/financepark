<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
 <youi:form  caption="一卡通申请管理"  action="esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json" id="">
		 <youi:fieldLayout labelWidths="120,120" width=""> 
			<youi:fieldText property="memberId"  caption="会员用户ID"/>
			<youi:fieldText property="ocComp"  caption="所属企业名称"/> 
		    <%-- <youi:fieldText property="ocRemark"  caption="一卡通其他说明"/> 
			<youi:fieldText property="ocNumber"  caption="一卡通号码"/>  --%>
			<youi:fieldText property="ocId"  caption="一卡通预约记录"/>    
			<youi:fieldCalendar property="ocDate"  caption="一卡通预约时间"/>
			<youi:fieldText property="ocAddree"  caption="选择地址"/>
            <youi:fieldText property="ocWay"  caption="一卡通办理方式"/>
		   <%--  <youi:fieldText property="ocStatus"  caption="一卡通预约状态"/>  --%>
	   	</youi:fieldLayout>
	</youi:form>
	
	
	
	
</youi:page>