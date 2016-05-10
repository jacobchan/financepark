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
                <li class="li1"><em>1</em>确认账号</li>
                <li class="li1 active"><em>2</em>安全认证</li>
                <li class="li3"><em>3</em>重置密码</li>
            </ul>
            <form class="psw-form">
                <div class="psw-show">
                	<div class="clearfix mt25">
                		<span class="mr15 fl">手机号</span>${phone }
                	</div>
                   	<!--  <p class="f12">为了你的账户安全，请完成身份验证</p>
                    <p class="f14">手机验证</p> -->
                   <%--  <p class="f12" style="margin-left:55px;">手机：${phone }</p> --%>
                   <div class="clearfix mt25">
                        <span class="mr15 fl">验证码</span>
                        <input type="text" id="phoneCode" placeholder="请输入验证码" style="width:140px;">
                        <a href="javascript:;" class="ib-btn fl ml20 ib-o" id="sendCaptcha" onclick="getCaptcha();" style="margin-top:0px;">发送验证码</a>
                    </div>
                   <a class="ib-btn mt25" id="next" style="width:350px;margin-left:85px;" href="javascript:;">下一步</a>
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
</body>
<script type="text/javascript">
	function getCaptcha(){
		$.youi.ajaxUtils.ajax({
			url:cenUrl +"web/loginUser/findPhoneCaptcha.json",
			success:function(result){
				if(result && result.record){
					$('#sendCaptcha').attr('onclick','void(0);');
					var record = result.record;
					if(!record.flag){
						enableSmsButton(3,record.buff,'重新获取');
					}else{
						enableSmsButton(60,record.buff,'重新获取');
					}
				}
			},
			error:function(msg){
				enableSmsButton(3,msg,'重新获取');
			}
		});
	}
	function enableSmsButton(sec,processText,enableText){
		$('#sendCaptcha').html(processText + '(' + sec + ')');
		if(sec <= 0){
			$('#sendCaptcha').html(enableText);
			$('#sendCaptcha').attr('onclick','getCaptcha();');
		}
		else{
			setTimeout(function(){
				enableSmsButton(sec - 1,processText,enableText);
			},1000);
		}
	}
	$(function(){
		//关闭toast
        $(".close-toast").click(function(){
            $(".toast").hide();
        });
		/* $('#sendCaptcha').click(function(){
			$.youi.ajaxUtils.ajax({
				url:cenUrl +"web/loginUser/findPhoneCaptcha.json",
				success:function(result){
					if(result && result.record){
						var res = result.record.html;
						if(!/^\d{6}$/.test(res)){
							enableSmsButton(3,res,'重新获取');
							return;
						}else{
							enableSmsButton(60,'发送成功','重新获取');
						}
					}
				}
			});
		}); */
		$("#next").click(function(){
			var phoneCode = $('#phoneCode').val();
			$.youi.ajaxUtils.ajax({
				url:cenUrl +"web/loginUser/findPwdCheckPhone.json",
				data:{phoneCode:phoneCode},
				success:function(result){
					if(result && result.record){
						var res = result.record.html;
						if(!/^\d{6}$/.test(res)){
							$(".tc.mt25").text(res);
							$(".toast").show();
			           		setTimeout("$('.toast').hide();", 2000);
						}else{
							window.location=cenUrl+"findpswReset.html"; 
						}
					}
				}
			});
		});
	});
</script>
</html>