	var pageSize=10; //每页默认显示10条
	var pageCount=1; //总页数
	var currentIndex = 1; //第几页
	var serviceURL = baseUrl+'propertyservicemanagerOcManager/getPagerOc.json';
	$(function () {	
		//分页页码显示
		$.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/getTotalCount.json', 
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
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
				//关闭dataLoading样式
				$.showBox.CloseDataLoading();
			}
		}); 			
	});	
	
	
	//分页列表
	function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'orderBy=desc:applyTime'];
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
				      			"<td>"+record[i].ocDate.substring(0,10)+"</td>"+
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
		var params = ['ocCode='+ocCode,'operator:ocCode=LIKE','startTime='+startTime,'endTime='+endTime,'orderBy=desc:applyTime'];
		$.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/getTotalCount.json',
			//url:serviceURL, 
			data:params.join('&'),
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
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
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'ocCode='+ocCode,'operator:ocCode=LIKE','startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/getPagerOc.json',
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