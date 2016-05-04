	var pageSize=4;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerMoverecManager/getPagerMoverec.json';
	$(function () {	
		//分页页码显示
		 $.ajax({
			url:serviceURL, 
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数							
				refreshData(1,pageSize);
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
	//拼接列表
	function _parseRecords(record){
		var html="";	
		if(record.length>0){
		for(var i=0;i<record.length;i++){
			var id = record[i].moverecId ;			
			var status="";
			var button=""; 
			var moverecStatus="";
			var moverecTime="";
			if(record[i].moverecStatus=="00"){
				moverecStatus="待审批";
				button="<a href='javascript:;' class='ib-btn ac-show tc' onclick='javascript:cancel(this)' style='width:120px;padding:0px;'>取消</a>";
			}else if(record[i].moverecStatus=="01"){
				moverecStatus="已审批";
			}else if(record[i].moverecStatus=="02"){
				moverecStatus="已放行";
			}else if(record[i].moverecStatus=="03"){
				moverecStatus="已取消";
			}
			 if(record[i].moverecTime){
				 moverecTime=record[i].moverecTime;
			}else if(record[i].moverecTime){
				moverecTime="";
			}			 
			 html+="<div class='gz-fx-box clearfix' id='"+id +"'  >"+
						    "<div class='gzb-thead'>"+
						        "<span class='c-o'>"+record[i].moverecCode+"</span>"+
							    "<a href='javascript:;' class='fr f12'><i class='fa fa-file-text-o mr10 f20' style='font-size:20px;margin-top:5px;'></i>查看订单详情</a>"+					
						    "</div>"+ 						   						  
							"<div class='fx-one p20'>"+
					      	  "<table class='w100 lh30'>"+
							    "<tr>"+
								  "<td>"+
								 	"<p class='f14 c-333'>"+record[i].moverecComp+"</p>"+
								    "<p>"+moverecTime.substring(0,10)+"</p>"+
								  "</td>"+
								  "<td><p>"+moverecStatus+"</p></td>"+
							     "</tr>"+							
					           "</table>"+
					           "<div>"+button+"</div>"+ 							
						    "</div>"+
						    "<div class='fx-two p20 lh30 undis'>"+							
							    "<p>放行物品描述</p>"+							
							    "<p>"+record[i].moverecRemark+"</p>"+							 							
						    "</div>"+
					"</div>";
			  			
		}
		$(".mlist").html(html);
	}else{
		var html1 = '<table class="gt-table mt20">'
		    html1 += '<tr>'
			html1 += '	<td colspan="6">暂无记录</td>'
			html1 += '</tr>'
			html1 += '</table>'
				$(".mlist").html(html1);	
		}
	};
	//取消弹窗
	function cancel(obj){
		var me=obj.parentNode.parentNode.parentNode;//找到父节点	
		//alert(me.id);
		var moverec=me.childNodes[0].childNodes[0].innerText; 
		$(".moverec").html(moverec);
		$(".moverec")[0].setAttribute("id",me.id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//点击确认取消搬家预约
	$(function(){
		$(".hhf-submit").click(function(){			
				var id=$(".moverec")[0].getAttribute("id");				
			 	$.ajax({
					url:baseUrl+'propertyservicemanagerMoverecManager/cancelStatus.json',
					data:'moverecId='+id,
					success:function(result){
						if(result&&result.record){
							//$(".bg-tanc.m1").close();
							close("取消成功!");													
						}
					}
				});
			});
		});
	//操作成功弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();	
	        setTimeout(function(){$(".bg-tanc.m1").hide(); },100);
			setTimeout(function(){$(".toast").hide(); },1000);
			refreshData(currentIndex,pageSize);
  }
		$(function () {
			$(".ac-show").click(function(){
				$(".bg-tanc.m1").show();
			})
			$(".ac-see").click(function(){
				$(".bg-tanc.m2").show();
			});
			$(document).on("mouseover mouseout",".gzb-thead a",function(){
				$(this).parents(".gz-fx-box").find(".fx-two").slideToggle("fast");
				$(this).parents(".gz-fx-box").find(".fx-one").slideToggle("fast");
			})
		})		
	    //点击跳转到搬家申请页面
		$("#a1").click(function(){			
			location.href = proUrl + "yqfw/yq8.html" ;
		})	