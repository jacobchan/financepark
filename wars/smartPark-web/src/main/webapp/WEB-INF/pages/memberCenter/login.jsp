<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<title>登录/注册</title>
	<link href="<%=request.getContextPath()%>/styles/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/styles/css/login.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/giui.min.js"></script>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/page/url.js"></script>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/memberCenter/login.js"></script>
</head>
<shiro:authenticated>
	<!-- authenticated -->
	<input id="hasLogin" type="hidden" value="true" />
	<jsp:forward page="member/memberCenter/index.html"></jsp:forward>
</shiro:authenticated>
<body>
<div class="w1200">
	<div class="loginbox">
    	<div class="w350">
        	<ul class="clearfix login_ul">
            	<li class="active">登录</li>
                <li>注册</li>
            </ul>
               <form class="login_form" action="login.html" method="post">
		            	<input type="hidden" name="loginType" value="${loginType}"/>
		                <fieldset>
		                    <div class="login_input mt10">
		                        <label class="f16">手机号</label>
		                        <input type="text" name="username" class="form-control" value="${username}" placeholder="Username">
		                    </div>
		                    <div class="clearfix"></div><br>
		
		                    <div class="login_input mt10">
		                       <label class="f16">密码&nbsp;&nbsp;&nbsp;</label>
		                       <input type="password" name="password" class="form-control" value="123456" placeholder="Password">
		                    </div>
		                    <br/>
		                    <div class="clearfix">
		                    </div>
					        <div class="mt10 clearfix">
			                	<label class="fl ml20" style="cursor:pointer"><input type="checkbox" class="vm mr10">&nbsp;<span class="vm">记住密码</span></label>
			                	<div class="fr"><a href="<%=request.getContextPath()%>/findpsw.html" 
			                		class="c3 mr20" >忘记密码？</a></div>
			                </div>
			              	 <div class="mt10 clearfix" style="text-align: center;">
			                    <youi:out value="${error}"/>
			                 </div>
		                    <button type="submit" class="btn-cheng tc mt20" style="width:278px;line-height:50px; margin:35px;font-size:16px; font-family:'Microsoft YaHei','微软雅黑'">登录</button>
		                </fieldset>
		            </form>
            
            <form class="login_form pr" style="display:none">
            	<div class="login_input mt15">
                	<label class="f16">用户名</label>
                    <input type="text" style="width: 120px;font-size: 14px;" placeholder="请输入手机号码" id="mobile">
                    <a href="javascript:;" style="color:#FB7730;" id="sendMobileCaptcha" onclick="getCaptcha();">获取验证码</a>
                </div>
                <div class="message-yz">
                	<p class="bd">进行安全验证</p>
                	<div class="bd c3">
                		<p class="">请输入下图中的字符，不区分大小写</p>
                		<div>
                			<img class="yan-img" src="<%=request.getContextPath()%>/Kaptcha.jpg" id="img_randCode">
                		</div>
                		<a class="c3" href="javascript:;" onclick="changeRandcode();">看不清，换一张</a>
                	</div>
                	<div class="login_input mt15">
	                    <input type="text"  class="form-control" placeholder="请在此处输入图片验证码" style="width: 170px;font-size: 14px;" id="imageCode">
	                </div>
                	
                	<div class="clearfix pt20 pb20 my-hide">
                		<a href="javascript:;" class="btn-cheng-code f14 tc lh35 mr20" style="width:80px;border-radius:3px;" id="getCode" >获取短信</a>
                		<a href="javascript:;" class="pb-btn f14 tc lh35" style="width:80px;border-radius:3px;" id="cancelCode">取消</a>
                	</div>
                </div>
                <div class="login_input mt10">
                	<label class="f16">验证码</label>
                    <input type="text" id="captcha">
                </div>
                <div class="login_input mt10">
                	<label class="f16">密码</label>
                    <input type="password" id="passwd">
                </div>
                <div class="login_input mt10">
                	<label class="f16">确认密码</label>
                    <input type="password" id="repasswd">
                </div>
                <div class="p10 f12">
                	<label style="cursor:pointer" id="read-accept"><input autocomplete="off"  type="checkbox" class="mr10 fl" style="margin-top:2px;">我已阅读并接受<a href="javascript:;" class="co" onclick="goProperties('regxy.html')">《硅谷公园用户注册协议》</a></label>
                </div>
               <!--  <div class="btn-cheng tc lh40 mt20 xiaoqishabi" style="display:block;margin:35px;font-size:16px;" id="register">注册</div> -->
            	<div class="btn-disabled tc lh50 mt20 xiaoqishabi " style="display:block;margin:35px;font-size:16px;" id="register">注册</div>
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
    $(function(){
    	$("#read-accept").click(function(){
			if($(this).children('input[type="checkbox"]').prop("checked")){
				$(this).parent().next("#register").removeClass("btn-disabled").addClass("btn-cheng");
			}else{
				$(this).parent().next("#register").addClass("btn-disabled").removeClass("btn-cheng");
			}

		});
    })
	function goProperties(gohref){
		window.location.href=proUrl+gohref; 
	}
</script>
</body>
</html>