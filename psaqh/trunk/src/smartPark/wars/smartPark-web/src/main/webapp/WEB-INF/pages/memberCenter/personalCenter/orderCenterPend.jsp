<%@ page language="java" pageEncoding="UTF-8"%>
				<div class="mt20 gr-txl clearfix lh30">
							<div class="tct-select fl mr20" style="width:200px">
								<div class="ic-select" style="background: url(<%=request.getContextPath()%>/styles/images/yqfw/down.png) no-repeat scroll right center;">
									<p class="c-b1" id="userorderProject" data="">请选择订单项目</p>
									<%--   <img src="<%=request.getContextPath()%>/styles/images/yqfw/down.png" />  --%>
								</div>
								<ul style="display: none;" class="select-nav" >
									<!--  <li>园区地址1</li>
									<li>园区地址2</li>
									<li>园区地址3</li> -->
								</ul>
							</div>
							<div class="inp-box ml20" style="width:300px;"><input placeholder="请输入订单号"  id="userorderCode" type="text"style="width:260px;"><a class="fa fa-search" href=""></a></div>
							
							<div class="pend_button">
							  <input value="搜索" class="hhf-submit f14 fl ml20 pend" type="button">
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
		<tbody class="pend_list">
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
<!-- <!-------取消弹窗----------- --> 
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>         
    </div>

	
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 ****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	//var serviceURL = baseUrl+'ordermanagerUserorderManager/getPagerPend.json';
	var serviceURL = baseUrl+'ordermanagerUserorderManager/getPagerPend_query.json';
	$(function(){
		loadData();
	});
	//加载数据
	function loadData(){	
		//分页页码显示
		 $.ajax({
			url : baseUrl + "ordermanagerUserorderManager/getTotalCountPend.json",
			success : function(results) {
								var totalCount=results.records[0].totalCount;
								pageCount = Math.ceil(totalCount / pageSize);//页数				
							//alert(pageCount);
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
					_parseRecords_pend(results.records);
				}
			}
		});
	}
	
		//拼接卡号列表
		function _parseRecords_pend(record){
			
			 $(".pend_list").empty();	
			ht="<tr>"+
				"<th>订单号</th>"+
				"<th>订单项目</th>"+
				"<th>订单金额</th>"+
				"<th>下单时间</th>"+
				"<th>操作</th>"+
			"</tr>";
			 $(".pend_list").append(ht);
			console.log(record);
			for(var i=0;i<record.length;i++){				
				var status = "";
				var button = "";
				if(record[i].userorderStatus=='01'){
					//status = "待付款";	
					button = "<a href=''>付款</a><span class='f12 ml5 mr5'>|</span><a href='#'   onclick='cancelStatus(this)'> 取消</a>";
				}else if(record[i].userorderStatus=='02'){
					//status = "已付款";
					button = "已付款<span class='f12 ml5 mr5'>|</span><a href=''>评价</a>";
				}else if(record[i].userorderStatus=='03'){
					//status = "已完成";					
				}else if(record[i].userorderStatus=='08'){
					status = "已取消";					
				}
				var method = "viewOrder(\""+record[i].userorderCode+"\",\""+record[i].genreId.genreCode+"\");";
				var html= "<tr class='aaa' id='"+record[i].userorderId+"'>"+
					      "<td><a class='custor' onclick='"+method+"'>"+record[i].userorderCode+"</a></td>"+
                          "<td>"+record[i].userorderProject+"</td>"+
                          "<td>"+record[i].userorderAmount+"</td>"+
                          "<td>"+record[i].userorderTime+"</td>"+                                                                        
                          "<td>"+status  + button+                                                                    
						  "</td>"+
                          " </tr>";
				 $(".pend_list").append(html);	
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
 
 	//取消弹窗
	 function cancelStatus(obj){
		var me=obj.parentNode.parentNode;//找到父节点
		//alert(me.id);
		var recordCode=me.childNodes[0].childNodes[0].innerText; 
		$(".moverec").html(recordCode);//给弹窗插入订单号
		$(".moverec")[0].setAttribute("id",me.id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//点击确认取消预约
	$(function(){
		$(".hhf-submit.confirm").click(function(){
			    $(".bg-tanc.m1").hide();
				var id=$(".moverec")[0].getAttribute("id");	
				//alert(id);
			 	$.ajax({
			 		url:baseUrl+'/ordermanagerUserorderManager/cancelStatus.json',
					data:'id='+id,
					success:function(result){
						if(result&&result.record){
							//$(".bg-tanc.m1").close();
							//$(".toast").show();
							close("取消成功!");						
							
						}
					}
				});
			});
		});
	$(".tc-close").click(function(){	
	$(".bg-tanc.m1").hide();
	});
	
	//根据订单项目 订单号模糊查询 待处理订单
	$('.hhf-submit.f14.fl.ml20.pend').click(function(){	
		//订单类型
		 var genId = $(".c-b1").attr("data");	
		 //订单号
		 var userorderCodeLike=$("#userorderCode").val();			 
		 var params=['userorderCodeLike='+userorderCodeLike,'genId='+genId];
		 $.ajax({
			 url:baseUrl + "ordermanagerUserorderManager/getTotalCountPend.json",
				success : function(results) {
									var totalCount=results.records[0].totalCount;
									pageCount = Math.ceil(totalCount / pageSize);//页数
									alert(pageCount);
								$(".tcdPageCode").empty();
								refreshData_pend_query(1,pageSize);
								    $(".tcdPageCode").createPage({
									//$(".tcdPageCode").createPage({
									    pageCount:pageCount,
									    current:1,
									    backFn:function(p){
									    	currentIndex = p;
									       this.pageCount=pageCount;
									       refreshData_pend_query(p,pageSize);
									    }
									});							
				}
			}); 		
	});
function refreshData_pend_query(pageIndex,pageSize){
	//订单类型
	 var genId = $(".c-b1").attr("data");	
	 //订单号
	 var userorderCodeLike=$("#userorderCode").val();					
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCodeLike='+userorderCodeLike,'genId='+genId];
		$.ajax({
			url:baseUrl+'ordermanagerUserorderManager/getPagerPend_query.json',
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					 _parseRecords_pend(results.records);
				}
			}
		});
	} 
//根据订单项目 订单号模糊   查询 全部订单
$('.hhf-submit.f14.fl.ml20.all').click(function(){	
	 var userorderProjecta=$("#userorderProject").text();		
	 //alert(userorderProjecta);
	 var userorderCodeLike=$("#userorderCode").val();			 
	 var params=['userorderProjecta='+userorderProjecta,'userorderCodeLike='+userorderCodeLike];
	 $.ajax({
		 url:baseUrl + "ordermanagerUserorderManager/getTotalCount.json",
			success : function(results) {
								var totalCount=results.records[0].totalCount;
								pageCount = Math.ceil(totalCount / pageSize);//页数
							//alert(pageCount);
								$(".tcdPageCode").empty();
							refreshData_All_query(1,pageSize);
							    $(".tcdPageCode").createPage({
								//$(".tcdPageCode").createPage({
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
var userorderProjecta=$("#userorderProject").text();	
//alert(userorderProjecta);
var userorderCodeLike=$("#userorderCode").val();	
	//var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
	var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCodeLike='+userorderCodeLike,'userorderProjecta='+userorderProjecta];
	$.ajax({
		url:baseUrl+'ordermanagerUserorderManager/getPagerAll.json',
		data:params.join('&'),
		success:function(results){
			if(results&&results.records){
				 _parseRecords_pend(results.records);
			}
		}
	});
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
</script>