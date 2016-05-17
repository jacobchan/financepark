<%@ include file="/WEB-INF/pages/include.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
<script src="<%=request.getContextPath()%>/scripts/3.0/lib/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/page/url.js"></script>
<!--主内容页面居中js-->
<script type="text/javascript">
	window.onload=window.onresize=function () {
		var h=($(window).height()-$(".login_main").outerHeight())/2+"px";
		var w=($(window).width()-$(".login_main").outerWidth())/2+"px";
		$(".login_main").css({"margin-top":h,"margin-left":w});
		
	}
</script>
<youi:style href="/styles/3.0/login.css" />
<title>系统登录${userAdapter}</title>

</head>
<shiro:authenticated>
	<!-- authenticated -->
	<input id="hasLogin" type="hidden" value="true" />
	<jsp:forward page="index.html"></jsp:forward>
</shiro:authenticated>

<body>

	<div class="login_main">
	<div class="login_content">
    	<form class="login_form" action="login.html" method="post" name="form">
            <div class="form_control">
                <div class="user_main">
                    <span></span>
                    <input type="text" placeholder="请输入用户名" name="username" class="user_int"  value="demo-plt" placeholder="Username">
                </div>
                <span class="error1"></span><!--错误提示-->
            </div>
            <div class="form_control">
                <div class="password_main">
                    <span></span>
                    <input type="password" placeholder="请输入密码" class="paswd_int" name="password" value="123456">
                </div>
            <span class="error1"></span><!--错误提示-->
            </div>
            <div class="yzm">
            	<div class="form_control">
                    <div class="yz_tex"><input type="text" placeholder="验证码" class="yzm_int" name="kaptcha"></div>
                    <span class="error2"></span><!--错误提示-->
                </div>
                <div class="yzm_pic"><img src="<%=request.getContextPath()%>/Kaptcha.jpg" style="width: 94px;height: 40px;"id="img_randCode"><a href="javascript:;" onclick="changeRandcode();">换一换</a></div>
            </div>
            
            <div class="pasd_choose clearfix">
                <label class="re_pasd" style="cursor:pointer"><input type="checkbox" id="checkbox_a1" class="chk_1" /> <label for="checkbox_a1"></label><span class="vm">记住密码</span></label>
                <div class="fo_pasd"><a href="javascript:;" class="c3 mr20">忘记密码？</a></div>
            </div>
             
            <a class="login_btn" href="javascript:;" onclick="fsubmit(document.form);"></a>
         
              <span style="padding-left: 80px;color: red;float: right;"> <youi:out value="${error}"/> </span>

        </form>
    	
    </div>
	
		
</div>	
		
		
	<%-- <div class="container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
        	<br/>
            <div align="center"><h2>平台</h2></div>
        </div>
        <!--/span-->
    </div><!--/row-->

    <div class="row">
        <div class="well col-md-6 center login-box col-md-offset-3">
            <div class="alert alert-info">
                	请输入您的用户名和密码登录
            </div>
            <form class="form-horizontal" action="login.html" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" name="username" class="form-control" value="demo-plt" placeholder="Username">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" name="password" class="form-control" value="123456" placeholder="Password">
                    </div>
                    <br/>
                    <div class="clearfix">
                    </div>
                    <div class="login-error pull-right">
                    	<youi:out value="${error}"/>
                    </div>
                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div> --%>
</body>
<!--输入框输入状态边框变色js-->
<script>
 $(function(){
       $(function(){
        $(".user_main").click(function(){
			$(".password_main").removeClass("active");
			$(".yz_tex").removeClass("active");
            $(this).toggleClass("active");	
        })
		
		 $(".password_main").click(function(){
			$(".user_main").removeClass("active");
			$(".yz_tex").removeClass("active");
            $(this).toggleClass("active");	
        })
		
		 $(".yz_tex").click(function(){
			$(".user_main").removeClass("active");
			$(".password_main").removeClass("active");
            $(this).toggleClass("active");	
        })
		
      })
		
 });
 	function fsubmit(obj){
		 obj.submit();
	 };
	 function changeRandcode(){
			$('#img_randCode').attr("src",cenUrl+"Kaptcha.jpg?timeStamp="+new Date().getTime());
	};
</script>
</html>