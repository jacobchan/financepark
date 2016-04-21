<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="订单详情">
	<head>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
		<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/carOrderDetails.js"></script> --%>
	</head>
	<youi:body decorator="memcenter">
		<div class="w1000">
			<h3 class="per-h3">停车位预留订单详情
				<a style="cursor: pointer;" onclick="orderDetails_goBack();" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5" style="font-size:18px;"></i>返回</a>
			</h3>
			<div class="clearfix mt20">
						<div class="ot-head">
							<span class="c-333 f14" id="applayNo">订单号：wybx20160321983343</span><span> 未付款</span>
							<font class="fr" id="time">2016年2月18日14:09:04</font>
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
											<p>订单项目：停车位预留</p>
											<!-- <p>报修地址：T4创业园A201(李 四  15999889999)</p> -->
										</td>
										<td>
											<p id="cpEnName">企业名称: 深圳市怕啥科技有限公司</p>
											<!-- <p>报修地址：T4创业园A201(李 四  15999889999)</p> -->
										</td>
									</tr>
									<tr>
										<td>
											<p class="c-333 f14">订单内容</p>
											<p>预留停车位数量：<span class="ml30 mr30"></span> 单价：<span class="c-o" id="cpCount">1 </span> 位</p>
											<p>预留停车位时长：<span class="ml30 mr30"></span> 单价：<span class="c-o" id="carh">2 </span> 小时</p>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="fr f12">
							<span class="mr30"> 订单总计费用：<font class="f24 c-o" id="userorderAmount">200元</font></span>
							<a href="javascript:;" class="ib-btn mr15" style="width:120px;">立即支付</a>
							<!-- <a href="" class="pb-btn tc" style="width:120px;">申请退款</a> -->
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
		
		//返回
		function orderDetails_goBack(){
			window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
		};
		
		$(function(){
			var arg=getQueryStringArgs();
			var userorderCode =arg.userorderCode;
			var serviceURL = baseUrl+"ordermanagerUserorderManager/getOrderByCode.json";
			 $.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:{userorderCode:userorderCode},
				success:function(results){
					if(results&&results.record){
						var record = results.record;
						getCar(record.userorderId,record.userorderAmount)
						$("#applayNo").html("订单号："+userorderCode);
					}
				}
			}); 
		});
		
		//查询预留停车位
		
		function getCar(orderId,userorderAmount){
			var indexPage =1;
			var params = ['indexPage='+indexPage,'applayNo='+orderId];
			var serviceURL = baseUrl+"carportManager/getPagerCarports.json";
			 $.youi.ajaxUtils.ajax({
				url:serviceURL,
				data : params.join('&'),
				jsonp : 'data:jsonp',
				dataType : 'jsonp',
				success:function(results){
					if(results&&results.records){
						var record = results.records;
						//开始时间
						var cpBegionTime = record[0].cpBegionTime;
						var cpEntdTime = record[0].cpEntdTime;
						//计算相时间（小时）
		            	var regTime = /(\d{4})-(\d{1,2})-(\d{1,2})( \d{1,2}:\d{1,2})/g;
		            	var interval = Math.abs(Date.parse(cpBegionTime.replace(regTime, "$2-$3-$1$4")) - Date.parse(cpEntdTime.replace(regTime, "$2-$3-$1$4")))/2000;
		            	var h = Math.floor(interval / 3600);
		            	$("#userorderAmount").html(userorderAmount+"元");
		            	$("#carh").html(h);
		            	$("#cpCount").html(record[0].cpCount);
		            	$("#time").html(cpBegionTime+":00");
		            	$("#cpEnName").html("企业名称: "+record[0].cpEnName)
					} 
				}
			});
		}
	</script>
</youi:body>
</youi:html>