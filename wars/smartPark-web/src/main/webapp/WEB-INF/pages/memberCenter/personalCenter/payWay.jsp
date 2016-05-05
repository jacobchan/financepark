<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="订单详情">
	<head>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
	</head>
	<youi:body decorator="memcenter">
		<div class="w1000">
			<h3 class="per-h3">付款
				<a style="cursor: pointer;" onclick="payWay_goBack();" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5" style="font-size:18px;"></i>返回</a>
			</h3>
			<div class="bgfff c3">
		        <div class="clearfix pl30 pr30 pt20 pb20 bb">
		            <div class="fl f14 lh30">
		                <p id="userorderCode">订单编号：x0093777299933</p>
		                <p id="userorderGenreName">订单类型：企业采购</p>
		            </div>
		            <div class="fr f16 lh22 mt20">
		                <p>应付金额：¥ <span class="ccheng" id="userorderAmount">8999.45</span> 元</p>
		            </div>
		        </div>
		        <div class="clearfix pl30 pr30 pt20 pb20">
		            <p class="lh30 f16">微信支付，请扫码支付</p>
		            <div id="qrcodeTable" >
		            </div>
		        </div>
		    </div>	
		</div>
	<!--***弹窗 start****************************************-->
	<div class="toast">
	    <div class="toast-con clearfix">
	        <div class="close-toast fr"></div>
	        <p class="tc mt25 f18" id="toast_text" style="color:#ff6715">请登录后重试！</p>
	    </div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.qrcode.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/payWay.js"></script>	
</youi:body>
</youi:html>