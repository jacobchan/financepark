	$(function(){
				$("#tp3").removeClass("undis") ;
				var params=["issueTypeCode=0102"];
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"nmIssuenewsManager/getNmIssuenewsByIssueTypeCode.json",//得到新闻发布类型
					data:params.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.records){
							$("#tp3").addClass("undis") ;
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