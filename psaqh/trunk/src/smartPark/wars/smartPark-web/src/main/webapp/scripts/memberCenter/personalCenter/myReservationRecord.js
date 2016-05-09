var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'reservationRecordManager/getReservationRecordsforpage.json';
	$(function(){
		loadData();
	});
	//加载数据
	function loadData(){	
		//分页页码显示
		 $.ajax({
			url:baseUrl+'reservationRecordManager/getTotalCount.json',
			beforeSend: function(){
				//开始显示loading样式
				$.showBox.DataLoading();
			},
			success:function(results){	
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);
							 refreshData(1,pageSize);
							//插入页码
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
							//关闭loading样式
							$.showBox.CloseDataLoading();
			}
		}); 			
		}
 
	//分页列表
	 function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'orderBy=desc:createTime','orderBy=desc:createTime'];
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
			if(record.length>0){
			var html="";
			for(var i=0;i<record.length;i++){
				var id = record[i].recordId ;
				var recordStatus=record[i].recordStatus;
				var buttonHtml="<td><a href='javascript:;' class='ac-show' onclick='javascript:cancelStatus(this)'>取消预约</a></td>";
				var vv = record[i].recordId+","+record[i].recordCode;
				if(recordStatus=="01"){
					recordStatus="已预约";
				}else if(recordStatus=="02"){
					recordStatus="已受理";
				}else if(recordStatus=="03"){
				    recordStatus="已入驻";
					buttonHtml="<td></td>";
				}else if(recordStatus=="04"){
				    recordStatus="已取消";
				    buttonHtml="<td></td>";
				}
				var visiteTime=record[i].visiteTime;
				visiteTime=visiteTime?visiteTime:"";
				html+="<tr id='"+id+"'>"+
					 "<td>"+record[i].recordCode+"</td>"+ 
					"<td>"+record[i].visiteDate+"&nbsp;"+visiteTime+"</td>"+
					"<td>"+record[i].recordCommdityName+"</td>"+				
					"<td>"+recordStatus+"</td>"+
					buttonHtml+
					"</tr>";
			}
			$("#myRecord").html(html);
			}else{
				var	html1 = '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
				$("#myRecord").html(html1);	
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
		$(".hhf-submit").click(function(){
			    $(".bg-tanc.m1").hide();
				var id=$(".moverec")[0].getAttribute("id");	
				//alert(id);
			 	$.ajax({
			 		url:baseUrl+'reservationRecordManager/cancelReservation.json',
					data:'recordId='+id,
					success:function(result){
						if(result&&result.record){
							//$(".bg-tanc.m1").close();
							//$(".toast").show();
							close("取消成功!");						
							
						}
					}
				});
			});
		});
	$(".tc-close").click(function(){	
		$(".bg-tanc.m1").hide();
	});