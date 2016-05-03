function registClick(){
	$(".login_ul li").eq(1).addClass("active").siblings().removeClass("active");
	$(".login_form").eq(1).show().siblings(".login_form").hide();
};
function changeRandcode(){
	$('#img_randCode').attr("src",cenUrl+"Kaptcha.jpg?timeStamp="+new Date().getTime());
};
function enableSmsButton(sec,processText,enableText){
	$('#sendMobileCaptcha').html(processText + '(' + sec + ')');
	if(sec <= 0){
		$('#sendMobileCaptcha').html(enableText);
		$('#sendMobileCaptcha').attr('onclick','getCaptcha();');
	}
	else{
		setTimeout(function(){
			enableSmsButton(sec - 1,processText,enableText);
		},1000);
	}
}
function getCaptcha(){
	var memberPhoneNumber = $("#mobile").val() ;
	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
	if(!isMobile.test(memberPhoneNumber)){
		//alert("请输入正确的手机号！") ;
		$(".tc.mt25").text("请输入正确的手机号！");
		$(".toast").show();
   		setTimeout("$('.toast').hide();", 2000);
		return ;
	}
	$(".message-yz").toggle();
}
$(function(){
	$(".close-toast").click(function(){
	    $(".toast").hide();
	});
	$(".login_ul li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".login_form").eq(index).show().siblings(".login_form").hide();
	});
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
	
	$('#cancelCode').click(function(){
		$(".message-yz").hide();
	});
	$('#getCode').click(function(){
		var imageCode = $('#imageCode').val();
		var memberPhoneNumber = $("#mobile").val() ;
		var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
		if(!isMobile.test(memberPhoneNumber)){
			//alert("请输入正确的手机号！") ;
			$(".tc.mt25").text("请输入正确的手机号！");
           	$(".toast").show();
           	pltime=2;
           	timer=setInterval("closeTanc()",2000);
			return ;
		}
		$.youi.ajaxUtils.ajax({
			url:cenUrl + "web/loginUser/registerCaptcha.json",
			data:{phone:memberPhoneNumber,imageCode:imageCode},
			success:function(results){
				var record = results.record;
				if(!record.flag){
					enableSmsButton(3,record.buff,'重新获取');
					$(".message-yz").hide();
				}else{
					enableSmsButton(60,record.buff,'重新获取');
					$(".message-yz").hide();
					$('#imageCode').val('');
					changeRandcode();
				}
				$('#sendMobileCaptcha').attr('onclick','volid(0);');
			}
		});
	});
	
	$("#register").click(function(){
		if($("#register").hasClass("btn-disabled")){
			return ;
		}
		var memberPhoneNumber = $("#mobile").val() ;
		var memberPassword = $("#passwd").val() ;
		var repasswd = $("#repasswd").val() ;
		var captcha = $("#captcha").val();
		
		var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
		if(!isMobile.test(memberPhoneNumber)){
			//alert("请输入正确的手机号！") ;
			$(".tc.mt25").text("请输入正确的手机号！");
			$(".toast").show();
       		setTimeout("$('.toast').hide();", 2000);
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
					$(".tc.mt25").text("此手机号已经注册了！");
		           	$(".toast").show();
		           	pltime=3;
		           	timer=setInterval("closeTanc()",1000);
					return ;
				}else{
					if(memberPassword == '' || memberPassword==null){
						//alert("密码不能为空！") ;
						$(".tc.mt25").text("密码不能为空！");
						$(".toast").show();
		           		setTimeout("$('.toast').hide();", 2000);
						return ;
					}
					if(repasswd == '' || repasswd==null){
						//alert("确认密码不能为空！") ;
						$(".tc.mt25").text("确认密码不能为空！");
						$(".toast").show();
		           		setTimeout("$('.toast').hide();", 2000);
						return ;
					}
					if(memberPassword.length<6){
						$(".tc.mt25").text("密码长度不能小于6！");
						$(".toast").show();
		           		setTimeout("$('.toast').hide();", 2000);
						//alert("密码长度不能小于6！") ;
						return ;
					}
					if(memberPassword.length>16){
						//alert("密码长度不能大于16！") ;
						$(".tc.mt25").text("密码长度不能大于16！");
						$(".toast").show();
		           		setTimeout("$('.toast').hide();", 2000);
						return ;
					}
					
					if(memberPassword != repasswd){
						//alert("两次密码输入不一致！") ;
						$(".tc.mt25").text("两次密码输入不一致！");
						$(".toast").show();
		           		setTimeout("$('.toast').hide();", 2000);
						return ;
					}
					var params = [
					              "memberPhoneNumber="+memberPhoneNumber,
					              "memberPassword="+memberPassword,
					              "repasswd="+repasswd,
					              "captcha="+captcha
								 ];
					$.youi.ajaxUtils.ajax({
						url:cenUrl +"web/loginUser/registerUser.json",
						data:params.join('&'),
						success:function(results){
							var capt = results.record.html;
							if(!/^\d{6}$/.test(capt)){
								$(".tc.mt25").text(capt);
							}else{
								$(".tc.mt25").text("注册成功！");
								$("#mobile").val("");//将输入框内容置为空
								$("#passwd").val("") ;
								$("#repasswd").val("") ;
								$("#captcha").val("") ;
								setTimeout("location.reload();", 2000);
							}
			           		$(".toast").show();
			           		setTimeout("$('.toast').hide();", 2000);
						}
					});
				} 
			}
		});
	}); 
});
function openUrl(){
	var url=cenUrl+"member/memberCenter/findpsw.html"; 
	window.location=url; 
};
