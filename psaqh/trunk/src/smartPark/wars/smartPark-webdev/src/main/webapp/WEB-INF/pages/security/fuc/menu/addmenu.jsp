<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<youi:fieldLayout columns="2">
		<youi:fieldText notNull="true"  property="menuId"  caption="菜单编号"/>
		<youi:fieldText property="menuNum" styleClass="autoAlign"  caption="菜单序号"/>
		<youi:fieldTree simple="false" popup="true" tree="${menuTree}" property="parentMenuId"  caption="上级菜单"/>
		
		<youi:fieldText notNull="true" styleClass="autoAlign"  property="menuCaption"  caption="菜单名称"/>
		<youi:fieldText property="menuStyle"  caption="菜单样式"/>
		<youi:fieldRadioGroup property="subpage" convert="boolean" defaultValue="0" caption="是否子页面"/>
		<youi:fieldText styleClass="autoAlign" column="2" property="menuSrc"  caption="菜单地址"/>
	</youi:fieldLayout>
	
</youi:page>