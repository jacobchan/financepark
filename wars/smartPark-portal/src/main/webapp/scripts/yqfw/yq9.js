$.youi.ajaxUtils.ajax({
		url:baseUrl+"memberInformationManager/getMemberInformationByLoginUser.json", 
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.record){
				$("#name").val(result.record.memberName);
				$("#telphone").val(result.record.memberPhoneNumber);
			}
		}
	});
	
	$(function(){
		$(".hhf-submit").click(function(){
			if(!isLogin){
				clearInterval(timer);
	           	$(".toast").show();
	           	pltime=1;
	           	timer=setInterval("closeTanc()",1000);
			}
			var cosContent=$("#content").val();	
			var cosBool=$('input[name="yesNo"]:checked').val();
			var cosName=$("#name").val();
			var cosTelephone=$("#telphone").val();
			if(cosContent=="" || cosContent.length==0){
				clearInterval(timer);
				$(".tc.mt25").text("请输入投诉内容！");
	           	$(".toast").show();
	           	pltime=1;
	           	timer=setInterval("closeTanc()",1000);
				return false;
			}else{
				if(cosBool=="0"){
					if(cosTelephone=="" || cosTelephone.length==0){
						clearInterval(timer);
						$(".tc.mt25").text("请输入手机号！");
			           	$(".toast").show();
			           	pltime=1;
			           	timer=setInterval("closeTanc()",1000);
						return false;
					}else{
						if(isMobil(cosTelephone)){
							if(cosName=="" || cosName.length==0){
								clearInterval(timer);
								$(".tc.mt25").text("请输入联系人！");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								return false;
							}
						}else{
							clearInterval(timer);
							$(".tc.mt25").text("手机号格式不正确！");
				           	$(".toast").show();
				           	pltime=1;
				           	timer=setInterval("closeTanc()",1000);
							return false;
						}
					}
				}
				var params = ['cosContent='+cosContent,
								'cosBool='+cosBool,
								'cosName='+cosName,
								'cosTelephone='+cosTelephone];
				var serviceURL = baseUrl+"propertyservicemanagerCosManager/savePropertyservicemanagerCos.json";
				
				//公共方法
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:params.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
						if(results&&results.record){
							$(".bg-tanc.m2").show();
							countdown(3);
						}
					}
				});
			}
			//校验手机号格式
			function isMobil(s) {
			    	var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
			   		if (!patrn.exec(s)) return false
			   	 	return true
				};
	
		});
	});

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
		//定时跳转
		 function countdown(i){
		 	$("#ti-m1").text(i);
		     i = i - 1;
		     if(i > 0) {
		         setTimeout("countdown("+i+")", 1000);
		     }else{
		     	jump();
		     }
		 }
		 //跳转投诉
		 function jump(){
		 	window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageCos.html";
		 }
		 //跳转个人中心
		 function jumpPerson(){
		 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
		 }
		 //跳转首页
		 function jumpIndex(){
		 	window.location.href=cenUrl;
		 }