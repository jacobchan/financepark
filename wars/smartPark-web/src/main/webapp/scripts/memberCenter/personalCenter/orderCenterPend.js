var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var timeoutProcess;
	var serviceURL = baseUrl+'ordermanagerUserorderManager/getPagerPend_query.json';
	$(function(){
		loadData();
		$(".tc-close").click(function(){
			$(".bg-tanc").hide();
			clearTimeout(timeoutProcess);
		});
	});
	function payReturn(sec,userorderCode){
		if(sec > 0){
			var serviceURL = baseUrl+"ordermanagerUserorderManager/getOrderByCode.json";
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:{userorderCode:userorderCode},
				success:function(results){
					if(results&&results.record){
						var record = results.record;
						if("01" == record.payStatus){
							$(".bg-tanc").hide();
							$('#toast_text').html('支付成功！');
							$(".toast").show();
				            setTimeout('$(".toast").hide();',2000);//1秒=1000
				            setTimeout(function(){payWay_goBack();},2000);//1秒=1000
				            clearTimeout(timeoutProcess);
						}else{
							timeoutProcess = setTimeout(function(){payReturn(sec - 1,userorderCode);},2000);
						}
					}
				}
			});
		}else{
			$(".bg-tanc").hide();
			$('#toast_text').html('支付超时！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
            clearTimeout(timeoutProcess);
            setTimeout(function(){payWay_goBack();},2000);//1秒=1000
		}
	}
	
	function goPay(userorderCode){
		
		var serviceURL = baseUrl+"ordermanagerUserorderManager/getOrderByCode.json";
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			data:{userorderCode:userorderCode},
			success:function(results){
				if(results&&results.record){
					var record = results.record;
					$('#payCode').html(record.userorderCode);
					$('#userorderGenreName').html(record.genreId.genreName);
					$('#userorderAmount').html(record.userorderAmount);
					
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'ordermanagerUserorderManager/getPayQrcodeByCode.json',
						data:{userorderCode:userorderCode},
						success:function(result){
							if(result && result.record){
								console.log(result.record);
								console.log(result.record.html);
								$("#qrcodeTable").html('');
								jQuery('#qrcodeTable').qrcode({
									render	: "table",
									text	: result.record.html
								});	
								$(".bg-tanc.m2").show();
								payReturn(1800,userorderCode);
							}
						}
					});
					
				}
			}
		});
	};
	//加载数据
	function loadData(){	
		//分页页码显示
		 $.ajax({
			url : baseUrl + "ordermanagerUserorderManager/getTotalCountPend.json",
			//url:serviceURL,
			success : function(results) {
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);//页数
				//pageCount=Math.ceil(results.totalCount/pageSize);//页数
				//console.log(results.records);
				refreshData(1,pageSize);
				//插入页码
				$(".tcdPageCode").empty();
				if(pageCount>0){
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
	    var html="";
		if(record.length>0){
			for(var i=0;i<record.length;i++){				
				var status = "";
				var button = "";
				if(record[i].userorderStatus=='01'){
					var userorderCode = record[i].userorderCode;
					//status = "待付款";	
					button = "<a href='javascript:void(0);' onclick='goPay(\""+userorderCode+
					"\");'>付款</a><span class='f12 ml5 mr5'>|</span><a href='#' onclick='cancelStatus(this)'>取消</a>";
				}else if(record[i].userorderStatus=='02'){
					//status = "已付款";
					button = "<font color='green'>已付款</font><span class='f12 ml5 mr5'>|</span><a href='#'  onclick='comment(\""+record[i].userorderId+"\",\""+record[i].genreId.genreCode+"\")'>评价</a>";
				}else if(record[i].userorderStatus=='03'){
					//status = "已完成";					
				}else if(record[i].userorderStatus=='08'){
					status = "已取消";					
				}
				var method = "viewOrder(\""+record[i].userorderCode+"\",\""+record[i].genreId.genreCode+"\");";
				    html+= '<tr class="aaa" id="'+record[i].userorderId+'">'
				    html+=   "<td><a class='custor' onclick='"+method+"'>"+record[i].userorderCode+"</a></td>";
				    //html+=   '<td>'+record[i].userorderCode+'</td>';
					html+=   '<td>'+record[i].userorderProject+'</td>'
                    html+=   '<td>'+record[i].userorderAmount+'</td>'
                    html+=   '<td>'+record[i].userorderTime.substring(0,10)+'</td>' 
                    html+=   "<td>"+status+button+"</td>";
                    html+= '</tr>'				
			}
			 $(".pend_list").html(html);	
			}else{
				var	html1 =   '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
						$(".pend_list").html(html1);	
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
			 	$.ajax({
			 		url:baseUrl+'/ordermanagerUserorderManager/cancelStatus.json',
					data:'id='+id,
					success:function(result){
						if(result&&result.record){
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
		 var userorderCode=$("#userorderCode").val();	
		 var params=['userorderCode='+userorderCode,'operator:userorderCode=LIKE','genId='+genId];
		 $.ajax({
			    url:baseUrl + "ordermanagerUserorderManager/getTotalCountPend.json",
			    data:params.join('&'),
				success : function(results) {
					var totalCount=results.records[0].totalCount;
					pageCount = Math.ceil(totalCount / pageSize);//页数
					//pageCount=Math.ceil(results.totalCount/pageSize);//页数
					refreshData_pend_query(1,pageSize);
					$(".tcdPageCode").empty();//
					if(pageCount>0){
						$(".tcdPageCode").createPage({
							pageCount:pageCount,
							current:1,
							backFn:function(p){
								currentIndex = p;
								this.pageCount=pageCount;
								refreshData_pend_query(p,pageSize);
							}
						});	
					}
				}
			}); 		
	});
    function refreshData_pend_query(pageIndex,pageSize){
		//订单类型
	 	var genId = $(".c-b1").attr("data");	
	 	//订单号
	    var userorderCode=$("#userorderCode").val();	
	 	var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCode='+userorderCode,'operator:userorderCode=LIKE','genId='+genId];
		//var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'userorderCodeLike='+userorderCodeLike,'genId='+genId];
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
    	loadData();	
    });
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
    //下拉选择项目名称样式
    function _selectRecords(record){		
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
/*$('#a1').click(function(){	
	window.location.href = proUrl + "companyservice/ITserver.html#label" ;
});*/
function comment(userorderId,genreCode){
	/*if(genreCode == "0301"){//会议室
		window.location.href=proUrl+"member/memberCenter/personalCenter/meetingRoomOrderDetails.html?userorderId="+userorderId;
	}else if(genreCode == "0302"){//车辆
		window.location.href=proUrl+"member/memberCenter/personalCenter/carOrderDetails.html?userorderId="+userorderId;
	}else if(genreCode == "0303"){//广告位
		window.location.href=proUrl+"member/memberCenter/personalCenter/adsenseOrderDetails.html?userorderId="+userorderId;
	}else if(genreCode == "0304"){//预留停车位
		window.location.href=proUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderId="+userorderId;
	}else */if(genreCode == "0501"){//公司注册
		window.location.href=proUrl+"companyservice/com_register.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0502"){//工商变更
		window.location.href=proUrl+"companyservice/Business.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0503"){//人事社保
		window.location.href=proUrl+"companyservice/HRshebao.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0504"){//代理记账
		window.location.href=proUrl+"companyservice/Agencybook.html?userorderCode="+userorderId+"#comment";
	}else if(genreCode == "0505"){//法律服务
		window.location.href=proUrl+"companyservice/Lawserver.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0506"){//商标专利
		window.location.href=proUrl+"companyservice/patent.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0507"){//威客服务
		window.location.href=proUrl+"companyservice/Wkserver.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0508"){//IT服务
		window.location.href= proUrl + "companyservice/ITserver.html?userorderId="+userorderId+"#comment";
		
	}/* else if(genreCode == "0401"){//创立方
		window.location.href=proUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0601"){//物业报修
		window.location.href=proUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "0602"){//物业缴费
		window.location.href=proUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderId="+userorderId+"#comment";
	}else if(genreCode == "02"){//园区饮食
		window.location.href=proUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderId="+userorderId+"#comment";
	} */
}
