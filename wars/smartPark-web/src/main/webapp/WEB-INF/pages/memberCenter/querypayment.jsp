r<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>缴费查询</title>
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
					<h3 class="per-h3">缴费查询</h3>
					<div class="clearfix mt40">
						<table class="gt-table mt20">
							<colgroup>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col width="120"></col>
								<col width="150"></col>
								<col></col>
							</colgroup>
							<tbody><tr>
								<th>订单号</th>
								<th>缴费项目</th>
								<th>总金额</th>
								<th>状态</th>
								<th>截止日期</th>
								<th>操作</th>
							</tr>
							
						
							
						</tbody></table>

                        
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
	function pay(id){				
		var payStatus='已缴费';
		var sfproId=id;	

		var params = ['sfproId='+sfproId+'','payStatus='+payStatus+''];
	     $.ajax({
			url:'/smartPark-web/esb/web/propertyservicemanagerSfproManager/updatePayStatus.json',
            data:params.join('&'),
	 		success:function(result){
	 			alert(111);
				if(result&&result.record){					
					alert("已缴费");
					
					location.reload();
				}
			}
		});
	}
	
	
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerSfproManager/getPayListByLoginUser.json',
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
						  "<td>"+record[i].sfproId+"</td>"+
					      "<td>"+record[i].sfproName+"</td>"+
					      "<td>"+record[i].sfproAmount+"</td>"+
                          "<td>"+record[i].payStatus+"</td>"+
                          "<td>"+record[i].dueDate+"</td>"+
                          "<td> "+                       
                          "      <input type='button' value='付款'   onclick='pay("+record[i].sfproId+")' /></td>"+      
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>