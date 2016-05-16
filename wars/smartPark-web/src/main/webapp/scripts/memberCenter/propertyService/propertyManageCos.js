	var pageSize=10; //每页默认显示10条
	var pageCount=1; //总页数
	var currentIndex = 1; //第几页
	var serviceURL = baseUrl+'propertyservicemanagerCosManager/getPagerCos.json';	
	$(function () {		
		//分页页码显示
		 $.ajax({
			url:baseUrl+'propertyservicemanagerCosManager/getTotalCount.json', 
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
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'orderBy=desc:cosTime'];
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
		var html="";
		if(record.length>0){
			for(var i=0;i<record.length;i++){			
				var status = "";
				var crop = "";		
				if(record[i].cosStatus=='01'){
					status = "待受理";
					crop = "取消";
				}else if(record[i].cosStatus=='02'){
					status = "已受理";
				}else if(record[i].cosStatus=='03'){
					status = "已取消";
				}else if(record[i].cosStatus=='04'){
					status = "已退回";
				}
				html   +="<tr id='"+record[i].cosId+"' >"+
							"<td><a href='javascript:;' onclick='viewOrder(\""+record[i].cosId+"\")' class='ac-show'>"+record[i].cosCode+"</a></td>"+
							"<td>"+record[i].cosTime.substring(0,10)+"</td>"+
							"<td>"+record[i].cosName+"</td>"+
							"<td>"+record[i].cosTelephone+"</td><td>"+status+"</td>"+
							"<td><a href='javascript:;' onclick='javascript:cancel(this)' class='ac-show'>"+crop+"</a></td>"+
						  "</tr>";
			}
			$(".knowledge.a").html(html);	
		}else{
			var	html1 =  '<tr>'
				html1 += '	<td colspan="6">暂无记录</td>'
				html1 += '</tr>'
						$(".knowledge.a").html(html1);	
		}		
	};
		//根据订单号，时间查询
    $("#query").click(function(){	
		var cosCode=$("#cosCode").val();
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['startTime='+startTime,'endTime='+endTime,'cosCode='+cosCode,'operator:cosCode=LIKE'];
		$.ajax({
			url:baseUrl+'propertyservicemanagerCosManager/getTotalCount.json', 
			data:params.join('&'),
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
			success:function(results){	
				var totalCount=results.records[0].totalCount;				
				 pageCount = Math.ceil(totalCount / pageSize);//页数	
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
					//关闭dataLoading样式
					$.showBox.CloseDataLoading();
              }
        }); 			
    });	
	//根据订单号查询 分页列表
	function refreshData_query(pageIndex,pageSize){
		var cosCode=$("#cosCode").val();	
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'cosCode='+cosCode,'operator:cosCode=LIKE','startTime='+startTime,'endTime='+endTime,'orderBy=desc:cosTime'];
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
	//取消投诉 
	function cancel(obj){
		var me=obj.parentNode.parentNode;//找到父节点	
		//alert(me.id);
		var cosCode=me.childNodes[0].childNodes[0].innerText; //获取订单号
		$(".moverec").html(cosCode);//给弹窗插入订单号
		$(".moverec")[0].setAttribute("id",me.id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//点击确认取消投诉
	$(function(){
		$(".hhf-submit.confirm").click(function(){	
		$(".bg-tanc.m1").hide();
		var id=$(".moverec")[0].getAttribute("id");				
		$.ajax({
			url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
			data:'cosId='+id,
			success:function(result){
				if(result&&result.record){
					close("取消成功");							
				}
			}
			});
		});
	});			
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
	//点击跳转到投诉页面      判断是否为企业用户
	$("#a1").click(function(){			
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				if(result&&result.record){					
					window.location.href = proUrl + "yqfw/yq9.html" ;
					}else{							
						$(".tc.mt25").text("您不是企业用户,暂时无法申请!");
			           	$(".toast").show();
			           	setTimeout(function(){$(".toast").hide(); },2000);			           	
					}
				}
			});
	});	
	$(".close-toast").click(function(){					
		$(".toast").hide();		       
	});	
	//弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
      }
	//显示订单详情
	function viewOrder(cosId){		
		window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageCosDetail.html?cosId="+cosId;
	};