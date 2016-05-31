	var pageSize=10; //每页默认显示10条
	var pageCount=1; //总页数
	var currentIndex = 1; //第几页
	var serviceURL = baseUrl+'hotelOrderManager/getPagerHotelOrders.json';
	var bindStatus="1";
	$(function () {	
		
		//分页页码显示
		$.ajax({			 
			url:baseUrl+'hotelOrderManager/getTotalCount.json', 
			data:'bindStatus='+bindStatus,
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
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'orderBy=desc:orderTime','startTime='+startTime,'endTime='+endTime];
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
	//拼接卡号列表
	function _parseRecords(record){				
		var html="";		
		if(record.length>0){
	 		for(var i=0;i<record.length;i++){
	 				var method = "viewOrder(\""+record[i].orderIdThird+"\",\""+record[i].rzMobile+"\");";
					html+= "<tr>"+
								 "<td><a class='custor' onclick='"+method+"'>"+record[i].orderIdThird+"</td>"+
								 "<td >"+record[i].orderTime+"</td>"+
				     			 "<td >"+record[i].comingTime+"</td>"+
				      			 "<td >"+record[i].outTime+"</td>"+
				      			 "<td >"+record[i].orderAmount+"</td>"+
				      			 "<td >"+record[i].roomCount+"</td>"+
				      			 "<td >"+"<a onclick='"+method+"'>查看</a>"+"</td>"+
                      		  " </tr>"; 
			          
	 		   }
	 			$(".hotelOrders").html(html);
	 	}else{
				var	html1 =  '<tr>'
					html1 += '	<td colspan="6">暂无数据</td>'
					html1 += '</tr>'
				$(".list").html(html1);	
			}			
	};
	//查看详情
	function viewOrder(orderNo,mobile){
		var url = "hotelOrderInfo.html?orderNo="+orderNo+"&mobile="+mobile;
   	 	window.location.href=url; 
	}
	//日历控件
	$(function(){
		laydate({
		    elem: '#startTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	});
	$(function(){
		laydate({
		    elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	}); 
	function close(content){		        
		$(".tc.mt25.f18").empty() ;
		$(".tc.mt25.f18").append(content) ;
		$(".toast").show();		      		        		       				
		setTimeout(function(){$(".toast").hide(); },1000);
		refreshData(currentIndex,pageSize);
	}