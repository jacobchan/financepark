<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人资料</title>
	
</head>
<body style="background-color:#f4f4f4;">


	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
			<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 

		
				<div class="w1000">
					<h3 class="per-h3">基本资料</h3>
					<table class="setting-table grst-table">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr style="display:none;">
							<td>ID</td>
							<td><span class="" id="memberId"> </span></td>
						</tr>
						
					
						<tr>
							<td>密码</td>
							<td><span class="" id="memberPassword"> </span></td>
							
						</tr>
						<tr >
							<td>原密码</td>
							<td>
								<input type='password' id="oldpassword" class="oldpassword"/>
								<div class="tip1"></div>
							</td>
						</tr>
						<tr >
							<td>新密码</td>
							<td>
							  <input type='password' id="newpassword1" />
							  <div  id="tip2"></div>
							</td>
						</tr>
						<tr >
							<td>再次输入新密码</td>
							<td>
							  <input type='password' id="newpassword2" class="newpassword2"/>
							  <div  id="tip3"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="修改" class="hhf-submit" style="height:36px;" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--***bottom end****************************************-->
	<script type="text/javascript">
	
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/memberInformationManager/getMemberInformationByLoginUser.json',
				//async: false, 
				success:function(result){
					if(result&&result.record){
						_parseRecords(result.record);
					}
				}
			});
		});
		
		
		function _parseRecords(record){
			$("#memberId").html(record.memberId);									
			$("#memberPassword").val(record.memberPassword);
			
		};
		
	 ////验证原密码是否正确	
		  $("#oldpassword").blur(function(){				
			var memberPassword=$("#memberPassword").val();	
			
            var o=$("#oldpassword").val();       
            if(o==memberPassword){
            	
            	  $(".tip1").html("<font color=\"green\" size=\"2\">输入正确</font>");
            	  return true;
            }else{           	
            	$(".tip1").html("<font color=\"red\" size=\"2\">输入错误</font>");
        		return false;
        		}
		  }); 
		  //验证两次密码输入一致
		  $(".newpassword2").blur(function(){
              var n1=$("#newpassword1").val();
              var n2=$("#newpassword2").val();
              if(n1==n2){
      			
              	$("#tip3").html(" 两次输入的密码一样");
              	return true;
               }else{
              	$("#tip3").html("<font color=\"red\" size=\"2\"> 两次输入的密码不同，请重新输入</font>");
          		return false;
          		}
          });
		 
		$('.hhf-submit').click(function(){
			this.disabled=true;
			var memberId=$("#memberId").html();
			
			var memberPassword=$("#newpassword1").val();
			
			var params = ['memberId='+memberId+'','memberPassword='+memberPassword+''];
			$.youi.ajaxUtils.ajax({
				url:'/smartPark-web/esb/web/memberInformationManager/updatepassword.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						alert("修改成功");
						location.reload();
					}
				}
			});
		});	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>