$(document).on("click",".index-fr-nav li",function(){
			$(".index-fr-nav li").removeClass("active");
			$(this).addClass("active");
			var issueTypeCode = $(this).attr("id") ;
			getN_1(issueTypeCode) ;
		});
		
		$(function(){
			var params=["issueTypeCode=01"];
			$.youi.ajaxUtils.ajax({
				url:baseUrl +"nmIssuetypeManager/getNewsType.json",//得到新闻发布类型
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.records){
						var records = result.records ;
						appendHtml_l(records);
					}
				}
			});
		});
		
		function appendHtml_l(record){
			for(var i=0;i<record.length;i++){
				var html = "" ;
				if(i == 0){
					html = "<li class='active' id='"+ record[i].issueTypeCode +"'>"+ record[i].issueTypeCaption +"</li>"
					getN_1(record[i].issueTypeCode) ;
				}else{
					html = "<li id='"+ record[i].issueTypeCode +"'>"+ record[i].issueTypeCaption +"</li>"
				}
				$("#ly").append(html) ;
			}
		}
		
 		function getN_1(issueTypeCode){
 			$("#ly1").empty() ;
 			$("#tp1").removeClass("undis") ;
			var params=["issueTypeCode="+issueTypeCode];
			$.youi.ajaxUtils.ajax({
				url:baseUrl +"nmIssuenewsManager/getNmIssuenewsByIssueTypeCode.json",
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.records){
						var records = result.records ;
						if(records.length == 0){
							$("#tp1").addClass("undis") ;
							$("#ly1").empty() ;
							if(issueTypeCode == "0101"){
								$("#ly1").append("<ul class='ig-nav'><li><p>暂无新闻！</p></li></ul>") ;
							}else if(issueTypeCode == "0102"){
								$("#ly1").append("<ul class='yn-nav1'><li><p>暂时公告！</p></li></ul>") ;
							}else if(issueTypeCode == "0103"){
								$("#ly1").append("<ul class='yn-nav1'><li><p>暂时政策信息！</p></li></ul>") ;
							}
						}else{
							appendN_1(issueTypeCode,result.records) ;
						}
					}
				}
			});			
		}
		function appendN_1(issueTypeCode,records){
			$("#tp1").addClass("undis") ;
			var ul_1 = "<ul class='ig-nav'>" ;
			var ul_2 = "<ul class='yn-nav1'>" ;
			var ul_3 = "</ul>" ;
			var html = "" ;
			if(issueTypeCode == "0101"){
				var len = records.length ;
				if(len > 3){
					len = 3 ;
				}
				for(var i=0;i<len;i++){
					var title = records[i].policyCaption.toString() ;
					var length = title.length ;
					if(length > 21){
	      	 			title = title.substring(0,21) ;
						title += "..." ;
	  	 			}
					html += "<li>"+
								"<a href='../zscenter/zs7.html?policyId="+records[i].policyId+"'>"+
									"<div class='in-photo'>"+
										"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+records[i].imageUrl+"&method=show' border='0' width='100%' class='loading-2'>"+
									"</div>"+
									"<div class='fr'>"+
									"<p>"+title+"</p>"+
									"</div>"+
								"</a>"+
							"</li>" ;
				}
				$(".ifn-group").append(ul_1+html+ul_3) ;
			}else{
				var len = records.length ;
				if(len > 5){
					len = 5 ;
				}
				for(var i=0;i<len;i++){
					var title = records[i].policyCaption.toString() ;
					var length = title.length ;
					if(length > 17){
	      	 			title = title.substring(0,17) ;
						title += "..." ;
	  	 			}
					html += "<li>"+
								"<p>"+
									"<a href='../zscenter/zs7.html?policyId="+records[i].policyId+"' class='c-333'>"+title+"</a>"+
									"<span class='fr f12 c-b1'>"+records[i].policyIssueDate+"</span>"+
								"</p>"+
							"</li>"
				}
				$(".ifn-group").append(ul_2+html+ul_3) ;
			}
		} 