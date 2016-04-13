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
			                	<div class="fr"><a href="javascript:;" class="c3 mr20" onclick="openUrl();">忘记密码？</a></div>
			                </div>
			              	 <div class="mt10 clearfix" style="text-align: center;">
			                    <youi:out value="${error}"/>
			                 </div>
		                    <button type="submit" class="btn-cheng tc lh40 mt20">登录</button>
		                </fieldset>
		            </form>
            
            <form class="login_form" style="display:none">
            	<div class="login_input mt15">
                	<label class="f16">用户名</label>
                    <input type="text" placeholder="请输入手机号码" id="mobile">
                    <a href="" style="color:#FB7730;">发送验证码</a>
                </div>
                <div class="login_input mt10">
                	<label class="f16">验证码</label>
                    <input type="text">
                </div>
                <div class="login_input mt10">
                	<label class="f16">密码</label>
                    <input type="password" id="passwd">
                </div>
                <div class="login_input mt10">
                	<label class="f16">确认密码</label>
                    <input type="password" id="repasswd">
                </div>
                <div class="btn-cheng tc lh40 mt20 xiaoqishabi" style="display:block;margin:35px;font-size:16px;" id="register">注册</div>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/giui.min.js"></script>
<%-- <script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/lib/properties.js"></script> --%>
<script type="text/javascript"  src="<%=request.getContextPath()%>/scripts/page/url.js"></script>
<script type="text/javascript">
$(function(){
	$(".login_ul li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".login_form").eq(index).show().siblings(".login_form").hide();
	});
});
function registClick(){
	$(".login_ul li").eq(1).addClass("active").siblings().removeClass("active");
	$(".login_form").eq(1).show().siblings(".login_form").hide();
};
</script>
<script type="text/javascript">
		$(function(){
			var url=location.href; 
			var tmp1=url.split("?")[1]; 
			var tmp2='';
			var tmp3='';
			if(tmp1!=''&&tmp1!=null){
				 tmp2=tmp1.split("&")[1]; 
			}
			if(tmp2!=''&&tmp2!=null){
				tmp3=tmp2.split("=")[1]; 
			}
			if(tmp3=='regist'){
				registClick();
			}
			
			$("#register").click(function(){
				var memberPhoneNumber = $("#mobile").val() ;
				var memberPassword = $("#passwd").val() ;
				var repasswd = $("#repasswd").val() ;
				
				var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
				if(! isMobile.test(memberPhoneNumber)){
					//alert("请输入正确的手机号！") ;
					clearInterval(timer);
					$(".tc.mt25").text("请输入正确的手机号！");
		           	$(".toast").show();
		           	pltime=1;
		           	timer=setInterval("closeTanc()",1000);
					return ;
				}
				var obj = ['memberPhoneNumber='+memberPhoneNumber] ;
				/* 判断手机号是否已经注册! */
				$.youi.ajaxUtils.ajax({
					url:baseUrl + "memberInformationManager/exsitMobile.json",
					data:obj.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
					 	var flag = result.record.flag ;//获取返回值
						if(flag == true){
							//alert("此手机号已经注册了！");
							clearInterval(timer);
							$(".tc.mt25").text("此手机号已经注册了！");
				           	$(".toast").show();
				           	pltime=3;
				           	timer=setInterval("closeTanc()",1000);
							return ;
						}else{
							if(memberPassword == '' || memberPassword==null){
								//alert("密码不能为空！") ;
								clearInterval(timer);
								$(".tc.mt25").text("密码不能为空！");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								return ;
							}
							if(repasswd == '' || repasswd==null){
								//alert("确认密码不能为空！") ;
								clearInterval(timer);
								$(".tc.mt25").text("确认密码不能为空！");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								return ;
							}
							if(memberPassword.length<6){
								clearInterval(timer);
								$(".tc.mt25").text("密码长度不能小于6！");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								//alert("密码长度不能小于6！") ;
								return ;
							}
							if(memberPassword.length>16){
								//alert("密码长度不能大于16！") ;
								clearInterval(timer);
								$(".tc.mt25").text("密码长度不能大于16！");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								return ;
							}
							
							if(memberPassword != repasswd){
								//alert("两次密码输入不一致！") ;
								$(".tc.mt25").text("两次密码输入不一致！");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								return ;
							}
							var params = [
							              "memberPhoneNumber="+memberPhoneNumber,
							              "memberPassword="+memberPassword,
							              "repasswd="+repasswd
										 ];
							$.youi.ajaxUtils.ajax({
								url:baseUrl +"memberInformationManager/saveReister.json",
								data:params.join('&'),
								jsonp:'data:jsonp',
								dataType:'jsonp',
								success:function(results){
									$("#mobile").val("");//将输入框内容置为空
									$("#passwd").val("") ;
									$("#repasswd").val("") ;
									//var url = cenUrl+"/smartPark-web/member/memberCenter/login.html";
									clearInterval(timer);
									$(".tc.mt25").text("注册成功！");
					           		$(".toast").show();
					           		pltime=1;
					           		timer=setInterval("closeTanc()",1000);
									location.reload();
								}
							});
						} 
					}
				});
			}); 
		});
		function openUrl(){
			var url=proUrl+"findpsw.html"; 
			window.location.assign(url); 
		};
</script>
<script type="text/javascript">
		//toast弹窗出来后，一秒自动关闭,请再调用弹窗toast的时候调用该方法
		 var pltime,timer;
		 function closeTanc(){
		     if(pltime>1){
		         pltime--;
		     }else{
		         $(".toast").hide();
		     }       
		 };
		 //关闭toast
	        $(".close-toast").click(function(){
	            $(".toast").hide();
	        });
		 //调用方法如下，哪里调用就放哪里
		 /**
		     clearInterval(timer);
		     $(".toast").show();
		     pltime=1;
		     timer=setInterval("closeTanc()",1000);
		 */
</script>
</body>
</html>