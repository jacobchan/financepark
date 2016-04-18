<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
	<meta charset="utf-8">
	<title>找回密码</title>
	<link href="<%=request.getContextPath()%>/styles/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/styles/css/login.css" rel="stylesheet" type="text/css">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/pwd.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/giui.min.js"></script>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/page/url.js"></script>
</head>
<shiro:authenticated>
	<!-- authenticated -->
	<input id="hasLogin" type="hidden" value="true" />
	<jsp:forward page="member/memberCenter/index.html"></jsp:forward>
</shiro:authenticated>
<body>
<div class="w1200">
    <div class="clearfix">
        <div class="w550">
            <ul class="clearfix fpsw-nav">
                <li class="li1 active"><em>1</em>确认账号</li>
                <li class="li1"><em>2</em>安全认证</li>
                <li class="li3"><em>3</em>重置密码</li>
            </ul>
            <form class="psw-form">
                <div class="psw-show">
                    <div class="clearfix mt25">
                        <span class="mr15 fl">登录名</span>
                        <input type="text" placeholder="手机号" id="phone">
                    </div>
                   <div class="clearfix mt25">
                        <span class="mr15 fl">验证码</span>
                        <input type="text" placeholder="请输入验证码" style="width:140px;" id="verificationCodePhone">
                        <img class="yan-img" src="Kaptcha.jpg" id="img_randCode">
                        <a class="help-inline code" href="#" style="margin-left:20px;font-size: 20px;" onclick="changeRandcode();">换一个</a>
                    </div>
                   <a class="ib-btn mt25" style="width:350px;margin-left:85px;margin-top: 18px;" href="javascript:;">下一步</a>
                </div>
           </form>
        </div>
    </div>
</div>

<div class="toast">
    <div class="toast-con clearfix">
       	<div class="close-toast fr"></div>
      	<p class="tc mt25 f18" style="color:#ff6715">请登录后重试！</p>
   	</div>       
</div>


<!--***bottom start****************************************-->
<div class="login_foot w1200 tc">
    <a href="javascript:;">关于我们</a><a href="javascript:;">园区服务平台</a><a href="javascript:;">客服中心</a>
    <a href="javascript:;">运营合作方</a><a href="javascript:;">帮助中心</a>
    <div class="tc caaa mt15 f12">&copy;2014-2015杭州富春硅谷投资有限公司  版权所以  浙  B14231237号</div>
</div>
<!--***bottom end****************************************-->
<script type="text/javascript">
	function changeRandcode(){
		$('#img_randCode').attr("src","Kaptcha.jpg?timeStamp="+new Date().getTime());
	};
	$(function() {
		//关闭toast
        $(".close-toast").click(function(){
            $(".toast").hide();
        });
		$(".ib-btn").click(function(){
			var phone = $('#phone').val();
			var verificationCodePhone = $('#verificationCodePhone').val();
			var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
			if(!isMobile.test(phone)){
				$(".tc.mt25").text("请输入正确的手机号！");
	           	$(".toast").show();
	           	setTimeout("$('.toast').hide();", 2000);
				return ;
			}
			$.youi.ajaxUtils.ajax({
				url:cenUrl +"web/loginUser/findpsw.json",
				data:{phone:phone,verificationCodePhone:verificationCodePhone},
				success:function(result){
					if(result && result.record){
						var res = result.record.html;
						if(!/^\d{6}$/.test(res)){
							$(".tc.mt25").text(res);
							$(".toast").show();
			           		setTimeout("$('.toast').hide();", 2000);
						}else{
							window.location=cenUrl+"findCheckPhone.html"; 
						}
					}
				}
			});
		});
	});
</script>
</body>
</html>