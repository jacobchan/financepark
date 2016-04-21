<%@ page language="java" pageEncoding="UTF-8"%>
				<div class="mt20 gr-txl clearfix lh30">
							<div class="tct-select fl mr20" style="width:200px">
								<div class="ic-select" style="background: url(<%=request.getContextPath()%>/styles/images/yqfw/down.png) no-repeat scroll right center;">
									<p class="c-b1" id="userorderProject">请选择订单项目</p>
									<%--   <img src="<%=request.getContextPath()%>/styles/images/yqfw/down.png" />  --%>
								</div>
								<ul style="display: none;" class="select-nav" >
									<!-- <li>园区地址1</li>
									<li>园区地址2</li>
									<li>园区地址3</li> -->
								</ul>
							</div>
							<div class="inp-box ml20" style="width:300px;"><input placeholder="请输入订单号"  id="userorderCode" type="text"style="width:260px;"><a class="fa fa-search" href=""></a></div>
							
							
							<div  class="hospital_button">
							  <input value="搜索" class="hhf-submit f14 fl ml20 hospital" type="button" style:"display:block;">
							  <input value="搜索全部" class="hhf-submit f14 fl ml20 all" type="button">
							</div>
						</div>
<div class="clearfix">
	<table class="gt-table mt20">
		<colgroup>
			<col width="120">
			<col width="120">
			<col>
			<col width="120">
			<col width="120">
			<col width="120">
		</colgroup>
		<tbody class="hospital_list">
		<tr>
			<th>订单号</th>
			<th>订单项目</th>
			<th>订单金额</th>
			<th>下单时间</th>
			<th>操作</th>
		</tr>			
		</tbody>
	</table>
	<div class="tcdPageCode fr"></div>
</div>
<!-- <!-------弹窗----------- --> 
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>         
    </div>
	<!--***弹窗 ****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'ordermanagerUserorderManager/getPagerHospital_query.json';
	$(function(){
		loadData();
	});
	//加载数据
	function loadData(){	
		//分页页码显示
		 $.ajax({
			 url : baseUrl + "ordermanagerUserorderManager/getTotalCountHospital.json",
				success : function(results) {
									var totalCount=results.records[0].totalCount;
									pageCount = Math.ceil(totalCount / pageSize);//页数
							 refreshData(1,pageSize);
							//插入页码
								$(".tcdPageCode").createPage({
								    pageCount:pageCount,
								    current:1,
								    backFn:function(p){
								    	currentIndex = p;
								       this.pageCount=pageCount;
								        refreshData(p,pageSize);
								    }
								});			
			}
		}); 			
		}
 
	//分页列表
	 function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
		$.ajax({
			url:serviceURL,
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					_parseRecords_hospital(results.records);
				}
			}
		});
	}
	
		//拼接卡号列表
		function _parseRecords_hospital(record){					
			$(".hospital_list").empty();	
			ht="<tr>"+
				"<th>订单号</th>"+
				"<th>订单项目</th>"+
				"<th>订单金额</th>"+
				"<th>下单时间</th>"+
				"<th>操作</th>"+
			   "</tr>";
			 $(".hospital_list").append(ht);
			console.log(record);
			for(var i=0;i<record.length;i++){				
				var status = "";
				var button = "";
				if(record[i].userorderStatus=='01'){
					//status = "待付款";	
					button = "<a href=''>付款</a><span class='f12 ml5 mr5'>|</span><a href='#'   onclick='cancel(this)'> 取消</a>";
				}else if(record[i].userorderStatus=='02'){
					//status = "已付款";
					button = "已付款<span class='f12 ml5 mr5'>|</span><a href=''>评价</a>";
				}else if(record[i].userorderStatus=='03'){
					//status = "已完成";					
				}else if(record[i].userorderStatus=='08'){
					status = "已取消";					
				}
				var method = "viewOrder(\""+record[i].userorderCode+"\",\""+record[i].genreId.genreCode+"\");";
				var html= "<tr class='aaa'>"+
					      "<td><a class='custor' onclick='"+method+"'>"+record[i].userorderCode+"</a></td>"+
                          "<td>"+record[i].userorderProject+"</td>"+
                          "<td>"+record[i].userorderAmount+"</td>"+
                          "<td>"+record[i].userorderTime+"</td>"+                                                                        
                          "<td>"+status  + button+                                                                    
						  "</td>"+
                          " </tr>";
				 $(".hospital_list").append(html);	
			}
		};  
		
	//取消成功弹窗
 	function close(content){	
        $(".tc.mt25.f18").empty() ;
        $(".tc.mt25.f18").append(content) ;
        $(".toast").show();		      		        		       				
		setTimeout(function(){$(".toast").hide(); },2000);
		refreshData(currentIndex,pageSize);
  }
 
 	//下拉选项目名称
	$(function(){
	$.ajax({				
		url:baseUrl+'/purchasingmanagerGenreManager/getGenreProject.json',
		success:function(result){	
			if(result&&result.records){					
				_selectRecords(result.records);						
			}
		}
	});
});

function _selectRecords(record){		
	console.log(record);
	for(var i=0;i<record.length;i++){				
		var html= "<li data='"+record[i].genreId+"'>"+record[i].genreName+"</li>";                                                                                  
		 $(".select-nav").append(html);	
	}
	$(".ic-select").click(function(e){
		$(".select-nav").hide();
	    $(this).next(".select-nav").show();
	    e.stopPropagation();//
	});
	$(".select-nav li").click(function(){
		$(this).parents(".tct-select").find(".ic-select p").text($(this).text());
		var livale = $(this).attr("data"); 
		$(this).parents(".tct-select").find(".ic-select p").attr("data",livale);
		$(this).parent().hide();
	});
}; 
//根据订单项目模糊查询 待处理订单
$('.hhf-submit.f14.fl.ml20.hospital').click(function(){	
	//订单类型id
	 var genId = $(".c-b1").attr("data");	
	 //订单号
	 var userorderCodeLike=$("#userorderCode").val();			 
	 var params=['userorderCodeLike='+userorderCodeLike,'genId='+genId];
	 $.ajax({
		 url : baseUrl + "ordermanagerUserorderManager/getPagerHospital_query.json",
			success : function(results) {
								var totalCount=results.records[0].totalCount;
								pageCount = Math.ceil(totalCount / pageSize);//页数
							//alert(pageCount);
							refreshData_hospital_query(1,pageSize);
							    $(".tcdPageCode").createPage({
								//$(".tcdPageCode").createPage({
								    pageCount:pageCount,
								    current:1,
								    backFn:function(p){
								    	currentIndex = p;
								       this.pageCount=pageCount;
								       refreshData_hospital_query(p,pageSize);
								    }
								});			
			
			}
		}); 		
});
	function refreshData_hospital_query(pageIndex,pageSize){
		//订单类型
		 var genId = $(".c-b1").attr("data");	
		 //订单号
		 var userorderCodeLike=$("#userorderCode").val();			 
		
	     var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCodeLike='+userorderCodeLike,'genId='+genId];
		 $.ajax({
				url:baseUrl+'ordermanagerUserorderManager/getPagerHospital_query.json', 
				data:params.join('&'),
				success:function(results){
				if(results&&results.records){
				 	_parseRecords_hospital(results.records);
				}
		}
	});
}
	$('.hhf-submit.f14.fl.ml20.all').click(function(){	
	 //订单类型id
	 var genId = $(".c-b1").attr("data");	
	 //订单号
	 var userorderCodeLike=$("#userorderCode").val();			 
	 var params=['userorderCodeLike='+userorderCodeLike,'genId='+genId];
	 $.ajax({
		 url : baseUrl + "ordermanagerUserorderManager/getTotalCount.json",
			success : function(results) {
								var totalCount=results.records[0].totalCount;
								pageCount = Math.ceil(totalCount / pageSize);//页数
							   refreshData_All_query(1,pageSize);
							    $(".tcdPageCode").createPage({
								
								    pageCount:pageCount,
								    current:1,
								    backFn:function(p){
								    	currentIndex = p;
								       this.pageCount=pageCount;
								       refreshData_All_query(p,pageSize);
								    }
								});			
			
			}
		}); 		
});
function refreshData_All_query(pageIndex,pageSize){
	//订单类型id
	 var genId = $(".c-b1").attr("data");	
	 //订单号
	 var userorderCodeLike=$("#userorderCode").val();			 
	 var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCodeLike='+userorderCodeLike,'genId='+genId];
	 $.ajax({
		url:baseUrl+'ordermanagerUserorderManager/getPagerAll.json',
		data:params.join('&'),
		success:function(results){
			if(results&&results.records){
				 _parseRecords_hospital(results.records);
			}
		}
	});
} 
</script>