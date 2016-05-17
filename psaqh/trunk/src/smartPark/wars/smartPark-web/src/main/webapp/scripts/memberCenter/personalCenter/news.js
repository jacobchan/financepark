    var pageSize=5;
	var pageCount=1;
	var currentIndex = 1;
	var timeoutProcess;
	var serviceURL = baseUrl+'mcMsgdatasManager/getPager.json';
	$(function(){
		loadData();
	});
	//加载数据
	function loadData(){	
		//分页页码显示
		 $.ajax({
			url:baseUrl + "mcMsgdatasManager/getTotalCount.json",
			success : function(results){
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
		//var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'orderBy=desc:readStatus','orderBy=desc:sendDate'];
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
	    var sendDate="";
		if(record.length>0){
			for(var i=0;i<record.length;i++){	
				if(record[i].sendDate){
					sendDate=record[i].sendDate.substring(0,19);
				}
				html +='<tr>'
				html +=		'<td style="word-wrap:.-word; ">'
				html +=			'<h4 class="c-333 mb10 fb f14" style="word-break:break-all">'+record[i].msgCaption+'</h4>'
				html +=			'<p>'+record[i].msgContent.substring(0,50)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" style="display:none">'+record[i].msgContent.substring(50,100)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" style="display:none">'+record[i].msgContent.substring(100,200)+'</p>'
				html +=			'<p class="f12">'+sendDate+'</p>'
				html +=		'</td>'					
				html +=		'<td align="right">'					
				html +=			'<a href="#" class="see-it" onclick="show1(\''+record[i].msgId+'\')">查看</a>'					
				html +=		'</td>'					
				html +=	'</tr>'			    			
			}
			 $("#newslist").html(html);	
			}else{
				var	html1 =   '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
						$("#newslist").html(html1);	
			}	
	};	
	function show1(id){
		$("#"+id).show();
	};