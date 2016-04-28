<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="订单详情">
	<head>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/legalServiceOrderDetails.js"></script>
	</head>
	<youi:body decorator="memcenter">
		<div class="w1000">
			<h3 class="per-h3">代理记账订单详情
				<a style="cursor: pointer;" onclick="orderDetails_goBack();" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5" style="font-size:18px;"></i>返回</a>
			</h3>
			<div class="clearfix mt20">
				<div class="ot-head">
					<span class="c-333 f14" id="userorderCode">订单号：wybx20160321983343</span>
					<span style="margin-left: 10px;" id="userorderStatus">已付款</span>
					<font class="fr" id="userorderTime" >2016年2月18日14:09:04</font>
				</div>
				<div class="pl20 pr20 order-table">
					<table class="w100 lh30 f12">
						<colgroup>
							<col width="50%"></col>
							<col></col>
						</colgroup>
						<tbody>
							<tr>
								<td>
									<p id="userorderProject">订单项目：代理记账</p>
								</td>
							</tr>
							<tr>
								<td>
									<!-- <p class="c-333 f14">订单内容</p> -->
									<p>预订日期：<span class="c-o" id="publicResoIdDate"></span></p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="fr f12">
					<span class="mr30"> 订单总计费用：<font class="f24 c-o" id="userorderAmount" >200元</font></span>
					<a href="javascript:;" class="ib-btn mr15" style="width:120px;">立即支付</a>
					<a href="" class="pb-btn tc" style="width:120px;">申请退款</a>
				</div>
			</div>		
		</div>
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-91px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w100 tc mt40">
				<div class="mt20 mb20 f16 lh26">
					<img src="../styles/images/grzx/check.png" border="0" class="mr20">您的机票信息，已经发送到手机，请注意查收！
				</div>
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript">
		$(function () {
			$(".order-nav li").click(function(){
				$(this).addClass("active").siblings().removeClass("active");
				$(".clearfix-box").hide();
				$(".clearfix-box").eq($(this).index()).show();
			})
			$(".ac-show").click(function(){
				$(".bg-tanc.m1").show();
			})
			$(".fs-btn").click(function(){
				$(".bg-tanc.m1").show();
			})
		})
	</script>
</youi:body>
</youi:html>