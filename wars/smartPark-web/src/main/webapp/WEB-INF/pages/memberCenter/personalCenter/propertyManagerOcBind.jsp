<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>一卡用绑定</title>
	<style>
	  .ccheng{color:#FF6715}
    </style>
</head>
<body style="background-color:#f4f4f4;">

	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
			<div class="w1000">
					<h3 class="per-h3">一卡通绑定</h3>
					<h4 class="f16 mt20">绑定信息</h4>
					<div class="mt20">
						<input class="bd-input" type="text" id="ocNumber" style="width:290px;" placeholder="请输入卡号">
						<input value="绑定" class="hhf-submit bd" style="padding:0px 10px;height:30px;" type="button">
					</div>

				</div>

			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->

	<script type="text/javascript">
	
		$(function(){
			$.ajax({
			  url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOcListByLoginUser.json',
			//	 url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOcs.json',
				success:function(result){
					
					console.log(result.records);
					if(result&&result.records){					
						_parseRecords(result.records);						
					}
				}
			});
		});
		//拼接卡号列表
		function _parseRecords(record){				
			for(var i=0;i<record.length;i++){				
				var status = "";
				var html = "";
				 if(record[i].bindStatus=='1'){						
					var html="<div class='mt20'>"+
							  "<img src='../images/grzx/check.png' border='0' />"+
							  "<span class='ml30 mr30'>已绑定卡号：<font class='c-o'>"+record[i].ocNumber+"</font></span>"+
							  "<input value='解除绑定' class='hhf-submit' style='padding:0px 10px;height:26px;' type='button' value='解绑'   onclick='unbound(\""+record[i].ocId+"\")'>"+
							  "</div>";
					 $(".w1000").append(html);		 
				}
	
			}
		};
	
		$('.hhf-submit').click(function(){
			this.disabled=true;			
			var ocNumber=$("#ocNumber").val();	
			alert(ocNumber);
						
			$.youi.ajaxUtils.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/addBindOc.json',
				data:'ocNumber='+ocNumber,
				success:function(result){
					if(result&&result.record){
						alert("增加成功");
						location.reload();
					}
				}
			});
		});	 

		function unbound(id){					   			
			var ocId=id;			
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'/esb/web/propertyservicemanagerOcManager/updateBindStatus.json',
				data:'ocId='+ocId,
		 		success:function(result){
					if(result&&result.record){					
						alert("修改成功");
						location.reload();
					}
				}
			}); 
		}		
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>