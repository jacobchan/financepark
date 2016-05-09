$(function(){
			laydate({
			    elem: '#timer', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
		        istime: true, //是否开启时间选择
			    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
			});
		})
$.youi.ajaxUtils.ajax({
		url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.record){
				$("#iphone").val(result.record.employeesTelephone);
				$("#user").val(result.record.employeesName);
			}
		}
	});
	
$(function(){
	$(".hhf-submit").click(function(){
		/* var obj={
			createUser:$("#user").val(),
			fkcodeSex:$(".sex-group span.active").index(),//0-男，1女
			fkcodeTelephone:$("#iphone").val(),
			fkcodeComp:$("#company").val(),
			fkcodeTime:$("#timer").val(),
			fkcodeRemark:$("#userinfo").val()
			};
		var str=JSON.stringify(obj);
		alert(str); */
		if(!isLogin){
			clearInterval(timer);
           	$(".toast").show();
           	pltime=1;
           	timer=setInterval("closeTanc()",1000);
		} 
		//判断是否是企业员工
		$.youi.ajaxUtils.ajax({
		url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.record){
				var phone = $("#iphone").val();
				var sex = $(".sex-group span.active").index()+1;
				var time = $("#timer").val();
				if(phone=="" || phone.length==0){
					clearInterval(timer);
					$(".tc.mt25").text("请输入联系电话！");
		           	$(".toast").show();
		           	pltime=1;
		           	timer=setInterval("closeTanc()",1000);
					return false;
				}else{
					if(!isMobil(phone)){
						clearInterval(timer);
						$(".tc.mt25").text("手机号格式不正确!");
			           	$(".toast").show();
			           	pltime=1;
			           	timer=setInterval("closeTanc()",1000);
						return false;
					}else{
						if(time=="" || time.length==0){
							clearInterval(timer);
							$(".tc.mt25").text("请输入到访时间!");
				           	$(".toast").show();
				           	pltime=1;
				           	timer=setInterval("closeTanc()",1000);
							return false;
						}
					}
				}
				
				var params = ['fkcodeName='+$("#user").val(),
								'fkcodeSex='+sex,
								'fkcodeTelephone='+phone,
							//	'fkcodeComp='+$("#company").val(),
								'fkcodeTime='+$("#timer").val(),
								'fkcodeRemark='+$("#userinfo").val()];
				var serviceURL = baseUrl+"propertyservicemanagerFkcodeManager/savePropertyservicemanagerFkcode.json";
				
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
							//window.location=cenUrl+"member/memberCenter/propertyService/propertyManageFk.html";
						}
					}
				});
			}else{
				clearInterval(timer);
				$(".tc.mt25").text("您不是企业用户,暂时无法申请!");
	           	$(".toast").show();
	           	pltime=1;
	           	timer=setInterval("closeTanc()",1000);
				return false;
			}
		}
		});
	});
	//校验手机号格式
	function isMobil(s) {
	    var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	    if (!patrn.exec(s)) return false
	    return true
	}
})

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
		 //跳转访客
		 function jump(){
		 	window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageFk.html";
		 }
		 //跳转个人中心
		 function jumpPerson(){
		 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
		 }
		 //跳转首页
		 function jumpIndex(){
		 	window.location.href=cenUrl;
		 }