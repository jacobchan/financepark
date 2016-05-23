    var pageSize=5;
	var pageCount=1;
	var currentIndex = 1;
	var timeoutProcess;
	var serviceURL = baseUrl+'purchasingmanagerGenreevaluateManager/getPager.json';
	$(function(){
		loadData();
	});
	//加载数据
	function loadData(){	
		//分页页码显示
		 $.ajax({
			url:baseUrl + "purchasingmanagerGenreevaluateManager/getTotalCount.json",
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
	    var time="";
		if(record.length>0){
			for(var i=0;i<record.length;i++){	
				if(record[i].createTime){
					time=record[i].createTime;
				}
				/*html +='<tr>'
				html +=		'<td style="word-wrap:.-word; ">'
				html +=			'<h4 class="c-333 mb10 fb f14" style="word-break:break-all">'+record[i].msgCaption+'</h4>'
				html +=			'<p>'+record[i].msgContent.substring(0,50)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" style="display:none">'+record[i].msgContent.substring(50,100)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" style="display:none">'+record[i].msgContent.substring(100,200)+'</p>'
				html +=			'<p class="f12">'+record[i].sendDate.substring(0,19)+'</p>'
				html +=		'</td>'					
				html +=		'<td align="right">'					
				html +=			'<a href="#" class="see-it" onclick="show1(\''+record[i].msgId+'\')">查看</a>'					
				html +=		'</td>'					
				html +=	'</tr>'	*/
				html +='<table class="message-box w100 f12">'
				html +=		'<colgroup>'
				html +=		'<col width="190"></col>'
				html +=		'<col></col>'
				html +=		'<col></col>'
				html +=		'</colgroup>'
				html +=		'<tbody>'
				html +=			'<tr>'
				html +=				'<td align="center"><img src=".../styles/images/grzx/user-photo.png" width="99" height="99" /></td>'
				html +=				'<td style="padding-right:30px;">'
				html +=					'<div class="clearfix lh40">'
				html +=						'<span class="f14 fb">汪峰</span>'
				html +=					'</div>'
				html +=						'<p class="c-b1 lh20">'+record[i].content+'</p>'
				html +=					'<div class="mes-has">'
				//html +=						'<b>回复我的评论：服务是很好，但是还不够开放！</b>'
				html +=					'</div>'
				html +=					'<p class="c-b1 tl mt10">'+time+'</p>'
				html +=				'</td>'
				html +=			'</tr>'
				html +='	</tbody>'
				html +='	<tfoot>'
				html +=			'<tr>'
				html +=				'<td align="center" colspan="2">'
				html +=					'<a href="javascript:;" class="a-reply">回复</a><img src="../styles/images/grzx/sj-top.png" class="tf-pa undis">'
				html +=				'</td>'
				html +=			'</tr>'
				html +=			'<tr class="reply-show undis">'
				html +=				'<th style="text-align:center;"><img src="../styles/images/grzx/tx.png" border="0" width="46" height="46" /></th>'
				html +=				'<th style="padding-right:30px;">'
				html +=					'<form>'
				//html +=						'<textarea placeholder="回复@汪峰"></textarea>'
				//html +=						'<input value="回复" class="hhf-submit mt20" style="height:36px;padding:0px 30px;font-size:14px;" type="submit">'
				html +=					'</form>'
				html +=				'</th>'
				html +=			'</tr>'
				html +=		'</tfoot>'
				html +='</table>'
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