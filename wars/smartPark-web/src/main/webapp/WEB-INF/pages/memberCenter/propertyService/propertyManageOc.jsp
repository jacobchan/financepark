<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="一卡通办理">
	<youi:body decorator="memcenter">  
				<div class="w1000">
					<h3 class="per-h3">一卡通绑定<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要申请一卡通</a></h3>
					<div class="clearfix mt40" rules=none>
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="ocCode"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
						</div>											   					    
						<table class="gt-table mt20">
							<colgroup>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col width="120"></col>
								<col width="150"></col>
								
							</colgroup>
							<tbody><tr>
								<th>订单号</th>
								<th>预约时间</th>
								<th>预约用户</th>
								<th>状态</th>
								<th>操作</th>
							</tr></tbody>							
                         <tbody class="oclist"></tbody>                        
                         </table>                     
					<div class="tcdPageCode fr"></div>
					</div>
				</div>
			</youi:body>
				
    <!--***弹窗start****************************************-->
  
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
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o fkCode"> [ 123456789 ] </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit c" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->
   
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10; //每页默认显示10条
	var pageCount=1; //总页数
	var currentIndex = 1; //第几页
	var serviceURL = baseUrl+'propertyservicemanagerOcManager/getPagerOc.json';
	$(function () {	
		//分页页码显示
		 $.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/getTotalCount.json', 
			success:function(results){	
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);//页数						
							 refreshData(1,pageSize);
							 $(".tcdPageCode").empty();
								 if(totalCount>0){
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
		//拼接列表
		function _parseRecords(record){	
			var html="";
			if(record.length>0){
	 			for(var i=0;i<record.length;i++){
					var status = "";	
					var button = "";	
				if(record[i].ocStatus=='01'){
					 status = "已处理";
				}else if(record[i].ocStatus=='02'){
					  status = "已领卡";
				}else if(record[i].ocStatus=='08'){
					status = "已取消";
				}else if(record[i].ocStatus=='00'){
					status = "待处理";
					button="<a href='#' onclick='cancel(this)'>取消</a>";
				}	
				html+= 	   "<tr id='"+record[i].ocId+"'>"+
				     		   	"<td><a href='javascript:;' onclick='viewDetail(\""+record[i].ocId+"\")' class='ac-show'>"+record[i].ocCode+"</a></td>"+		
				      			"<td>"+record[i].ocDate+"</td>"+
				      			"<td>"+record[i].member.memberName+"</td>"+
				      			"<td>"+status+"</td>"+				    
				      			"<td>"+button+"</td>"+                    
                      		" </tr>"; 									 				
			}
	 			$(".oclist").html(html);
			}else{
				var	html1 = '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
				 $(".oclist").html(html1);	
		}		
    };
		function hhf(id){						
			var ocId=id;			
		     $.ajax({
				url:baseUrl+'propertyservicemanagerOcManager/cancleOcStatus.json',
				data:'ocId='+ocId+'',
		 		success:function(result){
					if(result&&result.record){					
						close("取消成功");
						
					}
				}
			});
		}
		//根据订单号查询
    $('.hhf-submit').click(function(){	
		var ocCode=$("#ocCode").val();
		//alert(ocCode);
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['ocCode='+ocCode,'operator:ocCode=LIKE','startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/getTotalCount.json',
			//url:serviceURL, 
			data:params.join('&'),
			success:function(results){	
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);//页数						
				//alert(pageCount);
				 refreshData_query(1,pageSize);
				 $(".tcdPageCode").empty();
				 if(pageCount>0){
					$(".tcdPageCode").createPage({
					    pageCount:pageCount,
					    current:1,
					    backFn:function(p){
					    	currentIndex = p;
					       this.pageCount=pageCount;
					       refreshData_query(p,pageSize);
					    }
					});
				 }
              }
        }); 			
    });	
    //根据订单号查询 分页列表
    function refreshData_query(pageIndex,pageSize){
		var ocCode=$("#ocCode").val();	
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'ocLikeCode='+ocCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/getPagerLikeOc.json',
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					 _parseRecords(results.records);
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
	function close(content){		        
		$(".tc.mt25.f18").empty() ;
		$(".tc.mt25.f18").append(content) ;
	 	$(".toast").show();		      		        		       				
		setTimeout(function(){$(".toast").hide(); },2000);
		refreshData(currentIndex,pageSize);
    }		
	</script>
	<script type="text/javascript">
	//确认取消弹窗
	function cancel(obj){	
		var me=obj.parentNode.parentNode;
		var ocCode=me.childNodes[0].innerText;  
		$(".fkCode").html(ocCode);
		$(".fkCode")[0].setAttribute("id",me.id);
		$(".bg-tanc.m1").show();
	};	
	$(function(){
		$(".hhf-submit.c").click(function(){
			$(".bg-tanc.m1").hide(100);
			var id=$(".fkCode")[0].getAttribute("id");
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'propertyservicemanagerOcManager/cancleOcStatus.json',
				data:'ocId='+id,
				success:function(result){
					if(result&&result.record){
						close("取消成功!");														
					}
				}
			});
		});			
	});
	//点击跳转到一卡通申请页面
	$("#a1").click(function(){			
		location.href = proUrl + "yqfw/yq10.html" ;
	})
	//跳转到详情页面
	function viewDetail(ocId){			
		window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageOcDetail.html?ocId="+ocId;
	};
     </script>
</youi:html>