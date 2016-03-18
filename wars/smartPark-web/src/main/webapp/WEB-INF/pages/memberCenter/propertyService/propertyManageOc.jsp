<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>一卡通办理</title>
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
					<h3 class="per-h3">一卡用绑定</h3>
					<div class="clearfix mt40" rules=none>
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
						</div>
						
					   
					    
						<table class="gt-table mt20" border="0">
                        <tr>
					     	<td width="111">订单号 </td>
                         	<td width="111">企业名称    </td>
                         	<td width="111">预约时间          </td>
                         	<td width="111">预约用户          </td>
                         	<td width="111">状态        </td>
                         	<td width="111">操作  </td>
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
	
	
		$(function(){
			$.ajax({
			     url:baseUrl+'/esb/web/propertyservicemanagerOcManager/getPropertyservicemanagerOcListByLoginUser.json',
			
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
				if(record[i].ocStatus=='00'){
					status = "待处理";					
					var html= "<tr>"+
				      "<td >"+record[i].ocCode+"</td>"+
				      "<td >"+record[i].ocComp+"</td>"+
				      "<td >"+record[i].ocDate+"</td>"+
				      "<td>"+record[i].memberId+"</td>"+
				      "<td>"+status+"</td>"+				    					    
                      "<td > <input type='button' value='取消'   onclick='hhf(\""+record[i].ocId+"\")' class='hhf-submit' style='height:24px;'/>"+                               
                      " </tr>"; 
			          $(".gt-table").append(html);	
				  }
				  else 
				  {   
					  if(record[i].ocStatus=='01'){
						  status = "已处理";
					  }else if(record[i].ocStatus=='02'){
						  status = "已领卡";
					  }	
					  else if(record[i].ocStatus=='08'){
						  status = "已取消";
					  }	
					  var html= "<tr>"+
				      "<td width='111'>"+record[i].ocCode+"</td>"+
				      "<td width='111'>"+record[i].ocComp+"</td>"+
				      "<td width='111'>"+record[i].ocDate+"</td>"+
				      "<td width='111'>"+record[i].memberId+"</td>"+
				      "<td width='111'>"+status+"</td>"+				    
				      "<td width='111' >"+status+"</td>"+                    
                      " </tr>"; 
			 		$(".gt-table").append(html);	
				}
				 
				
			}
		};
		function hhf(id){						
			var ocId=id;			
		     $.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerOcManager/cancleOcStatus.json',
				data:'ocId='+ocId+'',
		 		success:function(result){
					if(result&&result.record){					
						alert("取消成功");
						location.reload();
					}
				}
			});
		}
	
		
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>