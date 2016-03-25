<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="订单中心">
	<youi:body decorator="memcenter">
				<div class="w1000">
					<h3 class="per-h3">订单中心</h3>
					<div class="clearfix mt40">
						<table class="gt-table mt20">
								<colgroup>
									<col width="180">
									<col width="180">
									<col width="170">
									<col width="180">
									<col>
								</colgroup>
								<tbody><tr>
									<th>订单号</th>
									<th>订单项目</th>
									<th>订单金额</th>
									<th>下单时间</th>
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
			</youi:body>
	<!--***bottom start****************************************-->
	<script type="text/javascript">
	 
	
		$(function(){
			$.ajax({
				
				url:baseUrl+'/ordermanagerUserorderManager/getOrderListByLoginUser.json',
				success:function(result){	
					if(result&&result.records){					
						_parseRecords(result.records);						
					}
				}
			});
		});
		//拼接卡号列表
		function _parseRecords(record){		

			console.log(record);
			for(var i=0;i<record.length;i++){				
				var status = "";								
				if(record[i].userorderStatus=='1'){
					status = "申请中";					
				}else if(record[i].userorderStatus=='2'){
					status = "申请成功";
				}else if(record[i].userorderStatus=='3'){
					status = "申请失败";
				} else if(record[i].userorderStatus=='0'){
					status = "取消";
				} 
				var html= "<tr>"+
					      "<td width='111'>"+record[i].userorderCode+"</td>"+
                          "<td width='111'>"+record[i].userorderProject+"</td>"+
                          "<td width='111'>"+record[i].userorderAmount+"</td>"+
                          "<td width='111'>"+record[i].userorderTime+"</td>"+
                          
                          "<td width='155'>"+status+                          
                     
                          "<a href='grzx2-2.html'>评价</a><span class='f12 ml5 mr5'>"+
						  "<a href='javascript:;' class='ac-show lq-show'>发票领取</a>"+
						  "</td>"+
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};	
	</script>
</youi:html>