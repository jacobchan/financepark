var pageSize=10;
	var pageCount=1;//共几页
	var currentIndex = 1;//第几页
	var serviceURL = baseUrl+'propertyservicemanagerFkcodeManager/getPagerFk.json';
    $(function () {		
		//分页页码显示
		 $.ajax({
			beforeSend: function(){
					//开始显示dataLoading样式
					$.showBox.DataLoading();
			},
			url: baseUrl+'propertyservicemanagerFkcodeManager/getTotalCount.json', 
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
				var id = record[i].fkcodeId ;
				var time = record[i].fkcodeTime ;
				var cancelbutton="";
				if(time){
					time = time.substring(0,10) ;
				}	
				if(record[i].dksataus=="00"){
					status = "未到访";	
					cancelbutton="<span class='f12 ml5 mr5'>|</span><a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消访客</a>";
				}else if(record[i].dksataus=='01'){
					status = "未到访";				
				}else if(record[i].dksataus=='02'){
					status = "已到访";
				}else if(record[i].dksataus=='03'){
					status = "已取消";
				}
				html+="<tr id='"+id +"' >"+
						  "<td><a href='javascript:;' onclick='viewDetail(\""+record[i].fkcodeId+"\")' class='ac-show'>"+record[i].fkCode+"</a></td>"+
						  "<td>"+time+"</td>" +	
						  "<td class='"+id+"'>"+status+"</td>"+
					      "<td>"+record[i].fkcodeName+"</td>"+
						  "<td>"+record[i].fkcodeTelephone+"</td>"+
						  "<td><a href='javascript:;' onclick='javascript:qrcode(this)' class='ac-see'>查看二维码</a>"+cancelbutton+"</td>"+
					   "</tr>";
				 $(".fklist").html(html);							
			}}else{
				var	html1 = '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
						$(".fklist").html(html1);	
				}
		};		
	//确认取消弹窗
	function cancel(obj){
		var me=obj.parentNode.parentNode;
		var fkCode=me.childNodes[0].childNodes[0].innerText; 
		$(".fkCode").html(fkCode);
		$(".fkCode")[0].setAttribute("id",me.id);
		$(".bg-tanc.m1").show();
	};
	//二维码弹窗
	function qrcode(obj){
	 	var me=obj.parentNode.parentNode;
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'propertyservicemanagerTwcrdManager/findTwcrdById.json',
			data:'fkcodeId='+me.id,
			success:function(result){
				if(result&&result.record){
					var fkCode=me.childNodes[0].childNodes[0].innerText; 
					var bftime = me.childNodes[1].innerText;
					var url = result.record.twcrdAddrec;
					$(".fkcodes").html(fkCode);
					$(".bftime").html(bftime);
					$(".fkcodes")[0].setAttribute("id",me.id);
					$(".fkurl")[0].setAttribute("src",cenUrl+"common/down.html?repository=/swfupload&path="+url);
					$(".bg-tanc.m2").show();
				}
			}
		});
	};
		//根据订单号查询
    $('.hhf-submit').click(function(){	
			var fkCode=$("#fkCode").val();
			var startTime=$("#startTime").val(); 
			var endTime=$("#endTime").val(); 			
			var params = ['fkCode='+fkCode,'operator:fkCode=LIKE','startTime='+startTime,'endTime='+endTime];
			$.ajax({
				url:baseUrl+'propertyservicemanagerFkcodeManager/getTotalCount.json',
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
		var fkCode=$("#fkCode").val();	
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'fkLikeCode='+fkCode,'startTime='+startTime,'endTime='+endTime,'orderBy=desc:applyTime'];
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
	// 确认取消弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
    }
	// 确认取消弹窗
	$(function(){
		$(".hhf-submit.c").click(function(){
			$(".bg-tanc.m1").hide();
			var id=$(".fkCode")[0].getAttribute("id");
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'propertyservicemanagerFkcodeManager/cancelStatus.json',
				data:'fkcodeId='+id,
				success:function(result){
					if(result&&result.record){
						close("取消成功!");													
					}
				}
			});
		});
	});
	//日期控件
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
					window.location.href = proUrl + "yqfw/yq4.html" ;
					}else{							
						$(".tc.mt25").text("您不是企业用户,暂时无法申请!");
			           	$(".toast").show();
			           	setTimeout(function(){$(".toast").hide(); },2000);		           	
					}
				}
			});
	});	
	//点击跳转到访客详情页面  并传访客id
	function viewDetail(fkcodeId){			
		window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageFkDetail.html?fkcodeId="+fkcodeId;
	};
	$(".close-toast").click(function(){					
		$(".toast").hide();		       
	});	