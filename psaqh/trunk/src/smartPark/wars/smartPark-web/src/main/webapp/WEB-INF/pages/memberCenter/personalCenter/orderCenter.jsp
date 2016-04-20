<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="政策申请">
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
	<script type="text/javascript">
		//待处理订单
		function jump0(){
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/orderCenterPend.html");  
		}
		//历史订单
		function jump1(){
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/orderCenterHospital.html");  
		}
		
	</script>
	<script type="text/javascript">

		$(function(){
			$(function () {
				$(".order-nav li").click(function(){
					$(this).addClass("active").siblings().removeClass("active");			
				})		
			})
			//页面默认加载创业加速申请加载
			if(getRequest()=="1"){
				$(".order-nav li").eq(0).addClass("active").siblings().removeClass("active");
				jump1();
			}else if(getRequest()=="2"){
				$(".order-nav li").eq(1).addClass("active").siblings().removeClass("active");
				jump2();
			}else{
				$(".order-nav li").eq(0).addClass("active").siblings().removeClass("active");
				jump0();
			}
		});

		 //点击跳转到政策申请页面
		$("#a1").click(function(){			
			location.href = proUrl + "zscenter/zs3.html" ;
		})	
		
		//获取链接后面的值
		function getRequest() {
			var url = location.search; //获取url中"?"符后的字串
			if (url.indexOf("?") != -1) { //判断是否有参数
				var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
				strs = str.split("="); //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
				return strs[1];
			}
		}
		 
     </script>
</youi:html>