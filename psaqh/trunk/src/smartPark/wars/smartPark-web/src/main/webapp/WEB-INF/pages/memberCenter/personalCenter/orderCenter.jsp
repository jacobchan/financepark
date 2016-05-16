<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="订单中心">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我的订单</h3>
					<div class="clearfix mt20 mb20">
						<ul class="order-nav">
							<li class="active" onclick="jump0();"><span class="pend">待处理订单</span></li>
							<li class="active" onclick="jump1();"><span class="pend">历史订单</span></li>
							
						</ul>
					</div>
					
					<div id="loadData"></div>
				</div>
		</youi:body>
		
	<!--***bottom start****************************************-->
 <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/orderCenter.js"></script>	
</youi:html>