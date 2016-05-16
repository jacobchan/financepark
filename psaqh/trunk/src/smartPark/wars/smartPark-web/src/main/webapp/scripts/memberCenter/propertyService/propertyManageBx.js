   //<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	var pageSize=10;//默认每页10条
	var pageCount=1;//页数
	var currentIndex = 1;//第几页
	//var serviceURL = baseUrl+'propertyservicemanagerBxManager/getPagerBxs.json';
	$(function () {	
		//分页页码显示
	    $.ajax({
			url:baseUrl+'propertyservicemanagerBxManager/getTotalCount.json', 
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
			url:baseUrl+'propertyservicemanagerBxManager/getPagerBxs.json',
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
		var applyTime="";
		if(record.length>0){
			for(var i=0;i<record.length;i++){
		    	var bxStatus='';
				var buttonHtml='';
				if(record[i].bxStatus=='00'){
			    	bxStatus='待受理';
					buttonHtml="<a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消</a>";
				}else if(record[i].bxStatus=='01'){
					bxStatus='已受理';
				}else if(record[i].bxStatus=='02'){
					bxStatus='待接单';
				}else if(record[i].bxStatus=='03'){
					bxStatus='已派工';
				}else if(record[i].bxStatus=='04'){
					bxStatus='已完工';
				}else if(record[i].bxStatus=='05'){
					bxStatus='已定价';
					buttonHtml="<td><a href='javascript:;'>付款</a></td>";
				}else if(record[i].bxStatus=='06'){
					bxStatus='已付款';
				}else if(record[i].bxStatus=='07'){
					bxStatus='已完成';
				}else if(record[i].bxStatus=='08'){
					bxStatus='已取消';
				}
				if(record[i].applyTime){
					applyTime = record[i].applyTime.substring(0,10);
					//applyTime = record[i].applyTime.substring(0,4)+"年"+record[i].applyTime.substring(6,7)+"月"+record[i].applyTime.substring(9,10)+"日"+"&nbsp&nbsp"+record[i].applyTime.substring(12,13)+"点";				
				}                      
			    html += "<tr id='"+record[i].bxId+"' class='aaa'>"+
							"<td><a href='javascript:;' onclick='viewDetail(\""+record[i].bxId+"\")' class='ac-show'>"+record[i].bxCode+"</a></td>"+
							"<td>"+applyTime+"</td>"+
				   			"<td>"+bxStatus+"</td>"+
							"<td>"+record[i].member.memberName+"</td>"+
							"<td>"+record[i].member.memberPhoneNumber+"</td>"+
							"<td>"+buttonHtml+"</td>"
						"</tr>";			
			}
		    $(".knowledge").html(html);
			}else{
				var	html1 = '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
						$(".knowledge").html(html1);	
		}	
	};		
	//确认取消弹窗
    function cancel(obj){
		var me=obj.parentNode.parentNode;
		var bxCode=me.childNodes[0].childNodes[0].innerText; 
		$(".bxCode").html(bxCode);
		$(".bxCode")[0].setAttribute("id",me.id);
		$(".bg-tanc").show();
	};
	
	//<!-- 取消报修订单 -->
	function cancel(obj){
		var me=obj.parentNode.parentNode;//找到父节点	
		var bxCode=me.childNodes[0].childNodes[0].innerText; //获取订单号
		$(".moverec").html(bxCode);//给弹窗插入订单号
		$(".moverec")[0].setAttribute("id",me.id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//点击确认取消报修预约
	$(function(){
		$(".hhf-submit.confirm").click(function(){	
		    $(".bg-tanc.m1").hide();
			var id=$(".moverec")[0].getAttribute("id");				
			$.ajax({
				url:baseUrl+'propertyservicemanagerBxManager/updateBxforpage.json',
				data:'bxId='+id,
				success:function(result){
					if(result&&result.record){
						 if(result.record.bxStatus=='08'){								
							  close("取消成功")																
					     }											
					}
				}
			});
		});
	});	
	//根据订单号   报修时间查询
	$('.hhf-submit.f14.fr.query').click(function(){	
		var bxCode=$("#bxCode").val();
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['bxCode='+bxCode,'operator:bxCode=LIKE','startTime='+startTime,'endTime='+endTime,'orderBy=desc:applyTime'];
		$.ajax({
			url:baseUrl+'propertyservicemanagerBxManager/getTotalCount.json',
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
				if(totalCount>0){
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
		 var bxCode=$("#bxCode").val();	
		 var startTime=$("#startTime").val(); 
		 var endTime=$("#endTime").val(); 
		 var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'bxCode='+bxCode,'operator:bxCode=LIKE','startTime='+startTime,'endTime='+endTime,'orderBy=desc:createTime'];
		 $.ajax({
				url:baseUrl+'propertyservicemanagerBxManager/getPagerBxs.json',
				data:params.join('&'),
				success:function(results){
					if(results&&results.records){
						 _parseRecords(results.records);
					}
		        }
		});
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
		setTimeout(function(){$(".toast").hide(); },2000);
		refreshData(currentIndex,pageSize);
    }
	//跳转到详情页面
    function viewDetail(bxId){			
		window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageBxDetail.html?bxId="+bxId;
	};	
	//点击跳转到投诉页面      判断是否为企业用户
	$("#a1").click(function(){			
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				if(result&&result.record){					
					window.location.href = proUrl + "yqfw/yq6.html" ;
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