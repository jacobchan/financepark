<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="安全中心">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">安全中心</h3>
			<h4 class="per-h4 mt20">密码安全</h4>
			<table class="setting-table mt20">
				<colgroup>
					<col width="100"></col>
					<col></col>
				</colgroup>
				<tr>
					<td>原密码</td>
					<td>
						<input type="password" style="width:200px;" class="w1" id="oldPassword"> 
						<span class="c-o ml20 " id="oldmsg"></span>
					</td>
				</tr>
				<tr>
					<td>新密码</td>
					<td>
						<input type="password" style="width:200px;" class="w1 clickpwd" id="password" >
						<span class="c-o ml20 " id="newmsg"></span>
					</td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td>
						<input type="password" style="width:200px;" class="w1" id="confirmPassword">
						<span class="c-o ml20 " id="conmsg"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="修改" class="hhf-submit changePassword" style="height:36px;margin-left:100px" />
					</td>
				</tr>
			</table>
			<h3 class="per-h3">&nbsp;</h3>
			<h4 class="per-h4 mt20">更换手机号码</h4>
			<table class="setting-table mt20">
				<colgroup>
					<col width="100"></col>
					<col></col>
				</colgroup>
				<tr>
					<td>新手机号码</td>
					<td>
						<input type="text" id="memberPhoneNumber" style="width:200px;" > <a href="javascript:;" class="ml15 open-tanc" style="padding:0px 25px;">获

取验证码</a>
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td><input type="text" style="width:200px;" > <span class="c-o ml20 undis" >验证码不正确！</span></td>
					</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="修改" class="hhf-submit changePhoneNumber" style="height:36px; margin-left:100px" />
					</td>			
				</tr>
			</table>
		</div>	
	<!--***弹窗 start****************************************-->
		<div class="toast">
       	 <div class="toast-con clearfix">
            	<div class="close-toast fr"></div>
            	<p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        	</div>        
    	</div>
	<!--***bottom end****************************************-->
	</youi:body>
	<script type="text/javascript">
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
				if(oldPassword.length<19 && oldPassword.length>5){
					if(password.length<19 && password.length>5){
						if(confirmPassword.length<19 && confirmPassword.length>5){
							if(!oldPassword==password){
								if(confirmPassword==password){
									$.youi.ajaxUtils.ajax({
										url:baseUrl+'memberInformationManager/doModifyPassword1.json',
										data:params.join('&'),
										success:function(result){
											if(result&&result.record){
												if("修改成功"==result.record.msg){
													close("密码修改成功！");
												}else{
													$("#oldmsg").text(result.record.msg);
													$("#newmsg").text(result.record.msg);
													//$("#conmsg").text(result.record.msg);
												}
											}
										}
								    });	
								}else{
									$("#newmsg").text("两次输入的密码不一致");
									$("#conmsg").text("两次输入的密码不一致");
								}
							}
							else{
								$("#newmsg").text("新密码原密码不能一样");								
							}	
						}else{
							$("#newmsg").text("新密码不能为空，长度为6到18个字符");
						}	
					}else{
						$("#newmsg").text("新密码不能为空，长度为6到18个字符");
					}					
				}else{
					$("#oldmsg").text("原密码不能为空，长度为6到18个字符");
				}												
					
			});
			
			//修改手机号
			$(".changePhoneNumber").click(function(){
				var memberPhoneNumber=$("#memberPhoneNumber").val();
				var params =['memberPhoneNumber='+memberPhoneNumber];
				$.youi.ajaxUtils.ajax({
					url:baseUrl+'memberInformationManager/updatePhoneNumber.json',
					data:params.join('&'),
					success:function(result){
						close("修改成功！");
						//location.reload();
					},
					error:function(jqXHR, textStatus, errorThrown){
						close(jqXHR);
					}
				});
				
			});	
		});
		//弹窗
		function close(content){		        
		    $(".tc.mt25.f18").empty() ;
		    $(".tc.mt25.f18").append(content) ;
		    $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			//setTimeout(function(){location.reload();},2000);
			
	    }
	</script>
</youi:html>