	$.youi.ajaxUtils.ajax({
			url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				if(result&&result.record){
					$("#moverecComp").val(result.record.rz.rzName);
					$("#phone").val(result.record.employeesTelephone);
					$("#moverecName").val(result.record.employeesName);
				}
			}
		});
		$(function(){
			$(".hhf-submit").click(function(){
				/* var obj={
					moverecComp:$("#moverecComp").val(),
					moverecWay:$("#moverecWay").text(),
					moverecUnit:$("#louyu").val()+$("#unit").val(),
					moverecName:$("#moverecName").val(),
					moverecRemark:$("#moverecRemark").val()
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
						var phone = $("#phone").val();
						var time = $('#timer').val();
						if(phone=="" || phone.length==0){
							clearInterval(timer);
							$(".tc.mt25").text("请输入联系电话！");
				           	$(".toast").show();
				           	pltime=1;
				           	timer=setInterval("closeTanc()",1000);
							return false;
						}else{
							if(isMobil(phone)){
								if(time=="" || time.length==0){
									clearInterval(timer);
									$(".tc.mt25").text("请输入搬家预约时间！");
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
		
						var params = ['moverecComp='+$("#moverecComp").val(),
										//'moverecWay='+$("#moverecWay")[0].getAttribute("value"),
										//'moverecUnit='+$("#louyu").val()+$("#unit").val(),
										'moverecName='+$("#moverecName").val(),
										'moverecPhone='+phone,
										'moverecTime='+time,
										'moverecRemark='+$("#moverecRemark").val()];
						var serviceURL = baseUrl+"propertyservicemanagerMoverecManager/savePropertyservicemanagerMoverec.json";
						
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
			
			//校验手机号格式
			function isMobil(s) {
			    	var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
			   		if (!patrn.exec(s)) return false
			   	 	return true
				}
			});
		});
	
		$(function(){
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"propertyservicemanagerMoverecManager/getMovcodemapforpage.json", 
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.records){
							_parseRecords(result.records);
						}
					}
				});
			});
		function _parseRecords(record){
				var html ="";
				html=html+"<div class='ic-select'>"+
				"<p id='moverecWay' value='"+record[0].itemValue+"'>"+record[0].itemName+"</p>"+
				"</div>"+
				"<ul style='display: none;' class='select-nav'>";
				for(var i=0;i<record.length;i++){
					html =html +"<li value='"+record[i].itemValue+"'>"+record[i].itemName+"</li>"
				}
					
				html=html+"</ul> ";
				$(".tct-select").append(html);
				activeclick();
		}
	
		function activeclick(){
			$(".ic-select").click(function(e){
				$(".select-nav").hide();
			    $(this).next(".select-nav").show();
			    e.stopPropagation();//
			});
			$(".select-nav li").click(function(){
				$(this).parents(".tct-select").find(".ic-select p").text($(this).text());
				 var livale = "0"+$(this).val(); 
				$(this).parents(".tct-select").find(".ic-select p")[0].setAttribute("value",livale);
				$(this).parent().hide();
			})
		}
	
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
			 //跳转搬家
			 function jump(){
			 	window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageMoverec.html";
			 }
			 //跳转个人中心
			 function jumpPerson(){
			 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
			 }
			 //跳转首页
			 function jumpIndex(){
			 	window.location.href=cenUrl;
			 }