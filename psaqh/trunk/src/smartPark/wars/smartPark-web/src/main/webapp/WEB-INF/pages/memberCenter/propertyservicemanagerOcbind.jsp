<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改一卡用绑定状态</title>
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
					<h3 class="per-h3">修改一卡用绑定状态</h3>
					<div class="clearfix mt40">
						<table class="gt-table mt20">
                         <tr>
					     	<td width="111">一卡通卡号 </td>
                         	<td width="111">绑定状态    </td>
                         	<td width="111">操作           </td>
                         </tr>
                           
                         </table>

                        
						<div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
							<a href="">首</a>
							<a href=""><i class="fa fa-angle-left"></i></a>
							<a>1</a>
							<a href=""><i class="fa fa-angle-right"></i></a>
							<a href="">末</a>
							<input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
							<a href="">Go</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->

	<script type="text/javascript">
	function bind(id){				
		var bindStatus='绑定';
		var ocId=id;	
		var params = ['ocId='+ocId+'','bindStatus='+bindStatus+''];
	     $.ajax({
			url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/updateBindStatus.json',

            data:params.join('&'),
	 		success:function(result){
				if(result&&result.record){					
					alert("已绑定");
					
					location.reload();
				}
			}
		});
	}
	function unbound(id){				
		var bindStatus='未绑定';
		var ocId=id;
		var params = ['ocId='+ocId+'','bindStatus='+bindStatus+''];
	     $.ajax({
			url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/updateBindStatus.json',
			 data:params.join('&'),
	 		success:function(result){
				if(result&&result.record){					
					alert("已解绑定");
					location.reload();
				}
			}
		});
	}
	
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOcListByLoginUser.json',
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
				var html= "<tr>"+
					      "<td width='111'>"+record[i].ocNumber+"</td>"+
                          "<td width='111'>"+record[i].bindStatus+"</td>"+
                          "<td > <input type='button' value='绑定'   onclick='bind("+record[i].ocId+")' />"+
                          "      <input type='button' value='解绑'   onclick='unbound("+record[i].ocId+")' /></td>"+                 
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};
		//增加绑定卡号
		$('.hhf-submit').click(function(){
			this.disabled=true;
			
			var ocNumber=$("#ocNumber").val();
			var memberId="40288ad7537422cc01537426c2dc0033";
			var bindStatus=1;
			var params = ['memberId='+memberId+'','bindStatus='+bindStatus+'','ocNumber='+ocNumber+''];
			$.youi.ajaxUtils.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/savePropertyservicemanagerOc.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						alert("增加成功");
						location.reload();
					}
				}
			});
		});	 


	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>