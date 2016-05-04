<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我的预约">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我的预约列表</h3>
					<div class="clearfix mt20 mb20">
						<ul class="order-nav">
							<li class="active" onclick="jump0();"><span class="pend">众创空间预约</span></li>
							<li class="active" onclick="jump1();"><span class="pend">入驻服务预约</span></li>
						</ul>
					</div>
					
					<div id="loadData"></div>
				</div>	
</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/myReservation.js"></script>	
</youi:html>