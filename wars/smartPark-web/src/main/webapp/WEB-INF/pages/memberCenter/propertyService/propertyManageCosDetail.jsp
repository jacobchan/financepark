<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="物业投诉">
	<youi:body decorator="memcenter"> 
					
	<div class="w1000">
			<h3 class="per-h3">物业投诉列表</h3>					
			<div class="clearfixa a">											
			</div>														    
	</div>
				<!-- //分页页码显示 -->
        <div class="tcdPageCode fr">
							每页四条
		</div>
		

	<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o cosCode"> [ 123456789 ] </span>吗？
				</div>
				<p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p>
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
	<!--***弹窗 end****************************************-->
</youi:body>
	
	
	<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/lib/properties.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=4;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerCosManager/getPagerFkcodes.json';
	var currentIndex = 1;
	$(function () {
		
		//分页页码显示
		 $.ajax({
			url:serviceURL, 
			success:function(results){	
							pageCount=Math.ceil(results.totalCount/pageSize);//页数
							
							 refreshData(1,pageSize);
								$(".tcdPageCode").createPage({
								    pageCount:pageCount,
								    current:1,
								    backFn:function(p){
								    	currentIndex = p;
								       this.pageCount=pageCount;
								        refreshData(p,pageSize);
								    }
								});			
			/* 	if(result&&result.records){
					_parseRecords(result.records);
				} */
			}
		}); 			
	});	
	
	
	//分页列表
	function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
		$.ajax({
			url:serviceURL,
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					 _parseRecords(results.records);
				}
			}
		});
	}
		//格式化展示列表
		function _parseRecords(record){
			$("#count").append(record.length);
			for(var i=0;i<record.length;i++){
				var bool = "";
				var status = "";
				var crop = "";
				if(record[i].cosBool=='0'){
					bool = "是";
				}else{
					bool = "否";
				}
				if(record[i].cosStatus=='0'){
					status = "待受理";
					crop = "取消";
				}else if(record[i].cosStatus=='1'){
					status = "受理中";
				}else if(record[i].cosStatus=='2'){
					status = "已受理";
				}else if(record[i].cosStatus=='3'){
					status = "已退回";
				}else if(record[i].cosStatus=='4'){
					status = "已回访";
				}else if(record[i].cosStatus=='5'){
					status = "待评价";
					crop = "评价";
				}else if(record[i].cosStatus=='6'){
					status = "已完成";
				}
				var html=/* "<tr id='"+record[i].cosId+"' class='aaa'><td>"+record[i].cosCode+"</td>"+
				"<td>"+record[i].cosTime+"</td>"+
				"<td>"+bool+"</td><td>"+record[i].cosName+"</td>"+
				"<td>"+record[i].cosTelephone+"</td><td>"+status+"</td>"+
				"<td><a href='javascript:;' onclick='javascript:cancel(this)' class='ac-show'>"+crop+"</a></td></tr>"; */
				/* "<div class='ot-head'>"+
				"<span class='c-333 f14' >订单号：wybx20160321983343</span>"+
				"<span style='margin-left: 10px;' >已付款</span>"+
				"<font class='fr' >2016年2月18日14:09:04</font>"+
			    "</div>"; */
			"<div class='clearfix mt20'>"+
			"<div class='ot-head'>"+
			"<span class='c-333 f14' >投诉单号："+record[i].cosCode+"</span>"+
			"<span style='margin-left: 10px;' >"+status+"</span>"+
			"<font class='fr' >2016年2月18日14:09:04</font>"+
		    "</div>"+
			 "<div class='pl20 pr20 order-table'>"+
				"<table class='w100 lh30 f12'>"+
					"<colgroup>"+
						"<col width='50%'''></col>"+
						"<col></col>"+
					"</colgroup>"+
					"<tbody>"+
						"<tr>"+
							"<td>"+
								"<p>投诉内容："+record[i].cosContent+"</p>"+
							//	"<p>报修地址：T4创业园A201(李 四  15999889999)</p>"+
							"</td>"+
						
						"</tr>"+
						"<tr>"+
						"<td>"+
							"<p>投诉人："+record[i].cosName+"</p>"+
							"<p>投诉电话："+record[i].cosTelephone+"</p>"+
						//	"<p>报修地址：T4创业园A201(李 四  15999889999)</p>"+
						"</td>"+
					
					"</tr>"+
						
					"</tbody>"+
				"</table>"+
			"</div>"+ 
			  "<div class='fr f12'>"+
				//"<span class='mr30'> 订单总计费用：<font class='f24 c-o'>1200元</font></span>"+
				"<a href='' class='pb-btn tc' style='width:120px;'>"+crop+"</a>"+
			//	"<input type='submit' value='"+crop+"' class='hhf-submit' style='height:36px;' />"+
			"</div>"+  
		"</div>	";
				$(".clearfixa.a").append(html);
			}
		};
		
		
			//根据订单号查询
			$('.pb-btn.tc').click(function(){	
				
				$(".aaa").empty();
				 var cosCode=$("#cosCode").val(); 
				 var startTime=$("#startTime").val(); 
				 var endTime=$("#endTime").val(); 
				 params=['cosCode='+cosCode+'','startTime='+startTime+'','endTime='+endTime+''];
			      $.ajax({
			    	 url:baseUrl+'propertyservicemanagerCosManager/getCoslistLikeCosCode.json',
			    	 data:params.join('&'),
			    	 success:function(result){					    		 
							console.log(result.records);           
							if(result&&result.records){						
								_parseRecords(result.records);							
							}
						}
				}); 
			}); 
	</script>
	
	<!-- 取消投诉 -->
	<script type="text/javascript">
	function cancel(cosId){
				
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
					data:'cosId='+cosId,
					success:function(result){
						if(result&&result.record){

							close("取消成功");
							
						}
					}
				});
			}
		
	$(function(){
		laydate({
		    elem: '#startTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	});
	$(function(){
		laydate({
		    elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	});
	//点击跳转到投诉页面
	$("#a1").click(function(){
		
		location.href = proUrl + "yqfw/yq9.html" ;
	})	
	//弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },1000);
			refreshData(currentIndex,pageSize);
      }
	</script>
	
</youi:html>
