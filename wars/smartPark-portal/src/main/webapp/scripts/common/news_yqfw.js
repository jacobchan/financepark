function GetRequest() {
   var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}
var Request = new Object();
Request = GetRequest();
var enteringType = Request['enteringType'];
	$(function(){
			$("#tp7").removeClass("undis") ;
			$.youi.ajaxUtils.ajax({
				url:baseUrl +"fileUploadManager/getFileUploadsByEnteringType.json?enteringType="+enteringType,//得到优惠政策的子类型
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.records){
						$("#tp7").addClass("undis") ;
						var record = result.records ;
						if(record.length==0){
							$("#file").empty("") ;
							$("#file").append("<li><p>目前还没有文档，敬请期待！</p></li>") ;
						}else{
							getHt(result.records) ;
						}
					}
				}
			});
	});
	function getHt(record){
		var len = record.length ;
		if(len > 5){
			len = 5 ;
		}
		var html = "" ;
		for(var i=0;i<len;i++){
			var fileName = record[i].fileName.toString() ;
	 			var leng = fileName.length ;
	 			if(leng > 10){
	 				fileName = fileName.substring(0,10) ;
	 				fileName += "..." ;
	 			}
			html += "<li>"+
							/* "<a href='' class='c-333'><img alt='' src='../styles/images/yqfw/word.png' class='mr5'>"+fileName+"</a>"+ */
							"<img alt='' src='../styles/images/yqfw/word.png' class='mr5'>"+fileName+
							"<a href='"+cenUrl+"common/upload.html?repository=/swfupload&path="+record[i].filePath+"&method=show&type=fileDown&fileId="+record[i].fileId+"' class='fr f12'>下载</a>"+
						'</li>' ;
		}
		$("#file").empty("") ;
		$("#file").append(html) ;
	}
	$(function(){
		$("#tp2").removeClass("undis") ;
		var params=["issueTypeCode=0102"];
		$.youi.ajaxUtils.ajax({
			url:baseUrl +"nmIssuenewsManager/getNmIssuenewsByIssueTypeCode.json",//得到新闻发布类型
			data:params.join('&'),
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				if(result&&result.records){
					$("#tp2").addClass("undis") ;
					appendHtml_1(result.records)
				}
			}
		});
	});
	function appendHtml_1(records){
		var len = records.length ;
		if(len == 0){
			$("#zxgg_1").append("<li>暂时还没有任何公告哦！</li>") ;
		}else if(len > 5){
			$("#zxgg_1").empty() ;
			len == 5 ;
		}
		var html = "" ;
		for(var i=0;i<len;i++){
			var news = records[i] ;
			var title = news.policyCaption;
			var id = news.policyId ;
			if(title.length > 10){
				title.substring(0,10) ;
				title += "..." ;
			}
			html += "<li>"+
						"<p>"+
							"<a href='../zscenter/zs7.html?policyId="+id+"' class='c-333'>"+title+"</a>"+ 
							"<span class='fr f12 c-b1'>"+news.policyIssueDate+"</span>"+
						"</p>"+
					"</li>" ;
		}
		$("#zxgg_1").append(html) ;
	}