$(document).on("click",".index-fr-nav li",function(){
		$(".index-fr-nav li").removeClass("active");
		$(this).addClass("active");
		$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
	});	

$(function(){
		//园区推荐活动数据top3
		var serviceURL = baseUrl + "activityApplyManager/getPagerActivityApplys.json";
		var status = "01";
		var postData = {
			'pager:pageIndex' : 1,
			'pager:pageSize' : 3,
			'isRecoomend' : 0,
			'applyStatus' : status,
			orderBy : 'desc:createTime'
		};
		$("#tp10").removeClass("undis") ;
		$.youi.ajaxUtils.ajax({
			url : serviceURL,
			data : postData,
			jsonp : 'data:jsonp',
			dataType : 'jsonp',
			success : function(results) {
				$("#tp10").addClass("undis") ;
				if (results && results.records) {
					var len = results.records.length;
					if(len>0){
						appendsHtml_11(results.records);
					}else{
						$("#lin_1").append("<li><p>暂无热门活动！</p></li>") ;
					}
				}
			}
		});
	});
	function appendsHtml_11(records){
		var html = "" ;
		for(var i=0;i<records.length;i++){
			var record = records[i] ;
			var title = record.applyTitle.toString() ;
			var length = title.length ;
			if(length > 17){
  	 			title = title.substring(0,17) ;
				title += "..." ;
	 		}
			html += "<li>"+
            			'<div class="in-photo">'+
            				"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record.activityImage+"&method=show' border='0' width='100%' class='loading-2'>"+
            			'</div>'+
            			'<div class="fr">'+
              			 	'<p>'+title+'</p>'+
                			'<a href="../czh/czh3.html?applyId='+ record.applyId+'" class="a-more">活动详情</a>'+
            			'</div>'+
        			'</li>'	;
		}
		$("#lin_1").append(html) ;
	}
	
	
	$(function(){
		//即将进行的活动top3
		var serviceURL1 = baseUrl + "activityApplyManager/getNewApplys.json";
		var postData = {
			'pager:pageIndex' : 1,
			'pager:pageSize' : 3
		};
		$("#tp10").removeClass("undis") ;
		$.youi.ajaxUtils.ajax({
			url : serviceURL1,
			data : postData,
			jsonp : 'data:jsonp',
			dataType : 'jsonp',
			success : function(results) {
				$("#tp10").addClass("undis") ;
				if (results && results.records) {
					var len = results.records.length;
					if(len>0){
						appendsHtml_12(results.records);
					}else{
						$("#lin_2").append("<li><p>暂无即将进行的活动！</p></li>") ;
					}
				}
			}
		});
	});
	function appendsHtml_12(records){
		var html = "" ;
		for(var i=0;i<records.length;i++){
			var record = records[i] ;
			var title = record.applyTitle.toString() ;
			var length = title.length ;
			if(length > 17){
  	 			title = title.substring(0,17) ;
				title += "..." ;
	 		}
			html += "<li>"+
            			'<div class="in-photo">'+
            				"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record.activityImage+"&method=show' border='0' width='100%' class='loading-2'>"+
            			'</div>'+
            			'<div class="fr">'+
              			 	'<p>'+title+'</p>'+
                			'<a href="../czh/czh3.html?applyId='+ record.applyId+'" class="a-more">活动详情</a>'+
            			'</div>'+
        			'</li>'	;
		}
		$("#lin_2").append(html) ;
	}
	
	$(function(){
		$("#tp10").removeClass("undis") ;
		var activeURL = baseUrl+"activityDocumentManager/getPagerActivityDocuments.json";
		var params = {'pager:pageIndex':1,'pager:pageSize':3,orderBy:'desc:createTime'};
		$.youi.ajaxUtils.ajax({
			url:activeURL,
			jsonp:'data:jsonp',
			data:params,
			dataType:'jsonp',
			success:function(results){
				$("#tp10").addClass("undis") ;
				if(results&&results.records){
					if(results.records.length>0){
						console.log(results.records) ;
						appendsHtml_13(results.records) ;
					}
				}
			}
		});
	});
	function appendsHtml_13(records){
		var html = "" ;
		for(var i=0;i<records.length;i++){
			var record = records[i] ;
			var title = record.documentName.toString() ;
			var length = title.length ;
			if(length > 17){
  	 			title = title.substring(0,17) ;
				title += "..." ;
	 		}
			html += "<li>"+
            			'<div class="in-photo">'+
            				"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record.activityApply.activityImage+"&method=show' border='0' width='100%' class='loading-2'>"+
            			'</div>'+
            			'<div class="fr">'+
              			 	'<p>'+title+'</p>'+
                			'<a href="../czh/czh7.html?applyId='+ record.activityApply.applyId+'&documendid="'+record.documentId+'" class="a-more">查看详情</a>'+
            			'</div>'+
        			'</li>'	;
		}
		$("#lin_3").append(html) ;
	}