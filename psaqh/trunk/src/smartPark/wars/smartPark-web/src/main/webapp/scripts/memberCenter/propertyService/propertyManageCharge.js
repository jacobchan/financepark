    var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerChargeManager/getPagerCharge.json';
	$(function () {		
		//分页页码显示
		 $.ajax({
			url:baseUrl+'propertyservicemanagerChargeManager/getTotalCount.json', 
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
		
	$(function () {
		$(".lq-fp").click(function(){
			$(".bg-tanc").show();
		});
		$(".wybx-tanc .add-sh label").click(function(){
			if($(this).children('input[type="radio"]').prop("checked")){
				if($(this).index()==0){
					$(".add-sh .so2").removeClass("undis");
					$(".add-sh .so1").addClass("undis");
				}else{
					$(".add-sh .so2").addClass("undis");
					$(".add-sh .so1").removeClass("undis");
				}
			}
		});
	});
	
	//拼接列表
	function _parseRecords(record){
		 $("chargelist").empty();
	  if(record.length>0){
		for(var i=0;i<record.length;i++){
			var chargeStatus='';
			var userorderStatus=record[i].userorder.userorderStatus;
			var buttonHtml="<td><a href='javascript:;' class='ac-see' onclick='javascript:pay(this)'>付款</a></td>";
			if(userorderStatus=='01'){
				chargeStatus="未缴费";
			}else{
				chargeStatus="已缴费";
				buttonHtml="<td><a href='javascript:;' class='ac-see lq-fp'>领取发票</a></td>";
			}			
			var html="<tr id='"+record[i].chargeId+"' class='aaa'>"+
				 	 	"<td><a href=''>"+record[i].userorder.userorderCode+"</a></td>"+
					 	"<td>"+record[i].userorder.userorderProject+"</td>"+
					 	"<td>"+record[i].chargeAmount+"元</td>"+
					 	"<td>"+chargeStatus+"</td>"+
					 	"<td>"+record[i].chargeEndate+"</td>"+
					 	buttonHtml+
					 "</tr>";
			 $("chargelist").append(html);
		}
	  }else{
			var	html1 = '<tr>'
				html1 += '	<td colspan="6">暂无记录</td>'
				html1 += '</tr>'
			$(".chargelist").html(html1);	
			}	
	};
	function pay(obj){
		var me=obj.parentNode.parentNode;
		alert(me.id+"          付款功能后续添加！");
	}
	//根据订单号查询 模糊查询
	$('.hhf-submit').click(function(){	
		var userorderCode=$("#userorderCode").val();
		//alert(ocCode);
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['LikeuserorderCode='+userorderCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerChargeManager/getTotalCount.json',
			data:params.join('&'),
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数				
				//alert(pageCount);
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
              }
        }); 			
    });	
		//根据订单号查询 分页列表
	function refreshData_query(pageIndex,pageSize){
	    var userorderCode=$("#userorderCode").val();
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'LikeuserorderCode='+userorderCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerBxManager/getPagerLikeBx.json',
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
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	})
	$(function(){
		laydate({
		    elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	})