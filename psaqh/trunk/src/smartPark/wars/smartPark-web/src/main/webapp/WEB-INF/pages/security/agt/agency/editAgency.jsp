<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page i18n="i18n.security.messages">
	<!-- 页面描述： -->
	<youi:fieldLayout prefix="record" columns="1">
		<youi:fieldHidden property="agencyId"  caption="机构ID"/>
		<youi:fieldHidden property="leaf" defaultValue="1"/>
		<youi:fieldHidden property="agencyPath"/>
		
		
		
		<youi:fieldTree src="/agt/agency/getChildren.json" simple="false" iteratorParentAttr="agencyId" 
			 show="agencyCaption" code="agencyId" rootText="机构" itemRootId="TREE_ROOT_AGENCY"
			 property="parentAgencyId" width="652" caption="i18n.agency.parent"/>
		<youi:fieldText notNull="true" width="652" property="agencyCode"  caption="i18n.agency.code"/>
		<youi:fieldText notNull="true" width="652" property="agencyCaption"  caption="i18n.agency.caption"/>
	</youi:fieldLayout>
</youi:page>