		$(function(){
			//修改密码
			$(".changePassword").click(function(){
				$("#oldmsg").empty();
				$("#newmsg").empty();
				$("#conmsg").empty();
				var oldPassword=$("#oldPassword").val();
				var password=$("#password").val();
				var confirmPassword=$("#confirmPassword").val();
				var params=['password='+password,'confirmPassword='+confirmPassword,'oldPassword='+oldPassword];
				if(!oldPassword){
					$("#oldmsg").html("原密码为空");
					return false;
				}	
				if(!password){
					$("#newmsg").html("新密码为空");
					return false;
				}	
				if(!confirmPassword){
					$("#conmsg").html("确认密码为空");
					return false;
				}	
				if(oldPassword.length<19 && oldPassword.length>5){
					if(password.length<19 && password.length>5){
						if(confirmPassword.length<19 && confirmPassword.length>5){
								if(confirmPassword==password){
									$.youi.ajaxUtils.ajax({
										url:baseUrl+'memberInformationManager/doModifyPassword.json',
										data:params.join('&'),
										success:function(result){
											if(result&&result.record){
												if("修改成功"==result.record.msg){
													close("密码修改成功！");
												}else if("新旧密码不能一样"==result.record.msg){
													$("#newmsg").text(result.record.msg);
													$("#conmsg").text(result.record.msg);
												}else if("请输入正确的旧密码！"==result.record.msg){
													$("#oldmsg").text(result.record.msg);
												}
											}
										}
								    });	
								}else{
									$("#newmsg").text("两次输入的密码不一致");
									$("#conmsg").text("两次输入的密码不一致");
								}
						}else{
							$("#newmsg").text("新密码长度为6到18个字符");
						}	
					}else{
						$("#newmsg").text("新密码长度为6到18个字符");
					}					
				}else{
					$("#oldmsg").text("原密码长度为6到18个字符");
				}																	
			});
		});
		//弹窗
		function close(content){		        
		    $(".tc.mt25.f18").empty() ;
		    $(".tc.mt25.f18").append(content) ;
		    $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){showphone(); },2000);					
	    }
		//给新手机号发送短信验证码
		function getCaptcha(){
			$("#phonetest").empty();
			var newPhone=$("#memberPhoneNumber").val();		
			var params =['newPhone='+newPhone];
			var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
			if(!newPhone){
				 $("#phonetest").html("手机号为空");
				return false;
			}			
			 if(!isMobile.test(newPhone)){
				 $("#phonetest").html("手机号输入错误");
				return false;
			}			
			$.youi.ajaxUtils.ajax({
				url:cenUrl +"web/loginUser/sendnewcaptcha.json",
				data:params.join('&'),
				success:function(result){
					if(result && result.record){
						var capt = result.record.html;
						if(!/^\d{6}$/.test(capt)){
							enableSmsButton(3,capt,'重新获取');						
						}else{
							enableSmsButton(60,'发送成功','重新获取');						
						}
						$('#sendnewcaptcha').attr('onclick','volid();');
					}					
				}			
			});
		}
		//换手机号验证
		$(".changePhoneNumber").click(function(){	
			var memberId=$("#memberId").val();
			var newcaptcha=$("#newcaptcha").val();
			var memberPhoneNumber=$("#memberPhoneNumber").val();
			var params =['memberId='+memberId,'newcaptcha='+newcaptcha,'newPhone='+memberPhoneNumber];
			var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
			
			$.youi.ajaxUtils.ajax({
				url:cenUrl +"web/loginUser/changePhone.json",
				data:params.join('&'),
				success:function(result){
					if(result && result.record){
						var res = result.record.html;
						close(res);
					}					
				}	
			});				
		});
		//显示原手机号   加载用户id
		$(function(){					
			showphone();	
		});
		function showphone(){
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberInformationManager/getMember.json',				
				success:function(result){
					if(result && result.record){
						var res = result.record;
						$("#memberId").val(res.memberId);
						$("#oldmemberPhoneNumber").val(res.memberPhoneNumber);
					}					
				}	
			});
		}
		//验证码间隔60秒才能发送
		function enableSmsButton(sec,processText,enableText){
			$("#sendnewcaptcha").html(processText + '(' + sec + ')');
			if(sec <= 0){
				$('#sendnewcaptcha').html(enableText);
				$('#sendnewcaptcha').attr('onclick','getCaptcha();');
			}
			else{
				setTimeout(function(){
					enableSmsButton(sec - 1,processText,enableText);
				},1000);
			}
		}