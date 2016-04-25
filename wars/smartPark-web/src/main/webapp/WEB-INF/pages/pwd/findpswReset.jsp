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
                <li class="li1"><em>2</em>安全认证</li>
                <li class="li3 active"><em>3</em>重置密码</li>
            </ul>
            <form class="psw-form">
                <div class="psw-show">
                    <div class="clearfix mt25">
                        <span class="mr15 fl">帐号</span>${memberName}
                    </div>
                    <input type="hidden" value="${memberId}" id=memberId >
                    <div class="clearfix mt25">
                        <span class="mr15 fl">新密码</span>
                        <input type="password" id="passwd" placeholder="新密码">
                    </div>
                   <div class="clearfix mt25">
                        <span class="mr15 fl">确认新密码</span>
                        <input type="password" id="repasswd" placeholder="确认新密码">
                    </div>
                   <a class="ib-btn mt25"  style="width:350px;margin-left:85px;" href="javascript:;">确定</a>
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
	function go(){
		window.location=cenUrl+"member/memberCenter/login.html";
	}
	$(function(){
		//关闭toast
        $(".close-toast").click(function(){
            $(".toast").hide();
        });
		$(".ib-btn").click(function(){
			var memberId = $('#memberId').val();
			var passwd = $('#passwd').val();
			var repasswd = $('#repasswd').val();
			$.youi.ajaxUtils.ajax({
				url:cenUrl +"web/loginUser/findpswReset.json",
				data:{memberId:memberId,passwd:passwd,repasswd:repasswd},
				success:function(result){
					if(result && result.record){
						var res = result.record.html;
						if(!/^\d{6}$/.test(res)){
							$(".tc.mt25").text(res);
							$(".toast").show();
			           		setTimeout("$('.toast').hide();", 2000);
						}else{
							$(".tc.mt25").text("密码重置成功！");
							$(".toast").show();
			           		setTimeout("$('.toast').hide();", 2000);
			           		setTimeout("go();", 2000);
						}
					}
				}
			});
		});
	});
</script>
</html>