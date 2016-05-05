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
		} 
	//分页列表
	 function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'orderBy=desc:userorderTime'];
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
	    var html="";
	    if(record.length>0){
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
					status = "已完成";					
				}else if(record[i].userorderStatus=='08' || record[i].userorderStatus=='04'){
					status = "已取消";					
				}
				var method = "viewOrder(\""+record[i].userorderCode+"\",\""+record[i].genreId.genreCode+"\");";
			    html +=  "<tr>"+
				              "<td><a class='custor' onclick='"+method+"'>"+record[i].userorderCode+"</a></td>"+
                              "<td>"+record[i].userorderProject+"</td>"+
                              "<td>"+record[i].userorderAmount+"</td>"+
                          	  "<td>"+record[i].userorderTime.substring(0,10)+"</td>"+                                                                        
                          	  "<td>"+status  + button+                                                                    
						      "</td>"+
                          "</tr>";
				 //$(".hospital_list").append(html);	
				 $(".hospital_list").html(html);	
			}}else{
				var	html1 = '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
						$(".hospital_list").html(html1);	
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
	//下拉选项目名称 拼接列表
	function _selectRecords(record){		
		for(var i=0;i<record.length;i++){				
			var html= "<li data='"+record[i].genreId+"'>"+record[i].genreName+"</li>";                                                                                  
		 	$(".select-nav").append(html);	
	    }
		//样式
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
	$('#query').click(function(){	
		//订单类型id
	 	var genId = $(".c-b1").attr("data");	
	 	//订单号
	 	var userorderCodeLike=$("#userorderCode").val();			 
	 	var params=['userorderCode='+userorderCodeLike,'operator:userorderCode=LIKE','genId='+genId];
	 	$.ajax({
		    url : baseUrl + "ordermanagerUserorderManager/getTotalCountHospital.json",
		    data:params.join('&'),
		    success : function(results) {
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);//页数
				refreshData_hospital_query(1,pageSize);
				$(".tcdPageCode").empty();
				if(totalCount>0){
					$(".tcdPageCode").createPage({								
						pageCount:pageCount,
						current:1,
						backFn:function(p){
							currentIndex = p;
							this.pageCount=pageCount;
							refreshData_hospital_query(p,pageSize);
						}
					});			
				}
			}
		}); 		
	});
	function refreshData_hospital_query(pageIndex,pageSize){
		//订单类型
		 var genId = $(".c-b1").attr("data");	
		 //订单号
		 var userorderCodeLike=$("#userorderCode").val();			 		
	     var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCode='+userorderCodeLike,'operator:userorderCode=LIKE','genId='+genId,'orderBy=desc:userorderTime'];
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
	//查询全部
	$('#queryAll').click(function(){	
		loadData();
   });