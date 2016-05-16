<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="政策申请列表">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我的申请<a href="javascript:;" class="fr c-333 f14" id="actionUrl"><i class="fa fa-plus-square fl mr10"></i>申请政策</a></h3>
					<div class="clearfix mt20 mb20">
						<ul class="order-nav">
							<li class="active" onclick="jump0();"><span class="pend">政策申请</span></li>
							<li class="active" onclick="jump1();"><span class="pend">创业加速申请</span></li>
							<li onclick="jump2();"><span class="hospital">融资申请</span></li>
						</ul>
					</div>
					
					<div id="loadData"></div>
				</div>
		</youi:body>
		
	<!--***bottom start****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/policyApply.js"></script>		
</youi:html>