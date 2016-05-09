$(function(){
			var params=["issueTypeCode=01"];
			$.youi.ajaxUtils.ajax({
				url:baseUrl +"nmIssuetypeManager/getNewsType.json",
				jsonp:'data:jsonp',
				data:params.join('&'),
				dataType:'jsonp',
				success:function(results){
					getList(results.records) ;
				}
			});
		});
		
		function getParam() { 
			var url = document.URL ; //获取页面的URL
			var param = "" ; 
			if(url.lastIndexOf("=") != -1){
				param = url.substring(url.lastIndexOf("=")+1,url.length) ; //获取页面的参数
				return param ;
			}else {
				return null ;
			}
		}
		
		function getList(records){
			var len = records.length ;
			var html = "" ;
			for(var i=0;i<len;i++){
				var issueTypeCode = records[i].issueTypeCode ;
				var title = records[i].issueTypeCaption ;
				if(getParam() == null && i==0){
					html = "<li class='active' id="+issueTypeCode+">"+title+"</li>" ;
				}else if(getParam() == issueTypeCode){
					var index = getParam().substring(3)-1 ;
					html = "<li class='active' id="+issueTypeCode+">"+title+"</li>" ;
					$(".park-box ul").eq(index).removeClass("undis").siblings().addClass("undis");
				}else{
					html = "<li id="+issueTypeCode+">"+title+"</li>" ;
				}
		 		$(".ull").append(html);
			}
		}
		
		$(function(){
			//$("#loading").removeClass("undis") ;
			var pageSize=3;
		    var pageCount=1;
		    var serviceURL = baseUrl+"nmIssuenewsManager/getPagerAllPolicy.json?issueTypeCode=0101";
			$.youi.ajaxUtils.ajax({
 				url:serviceURL,
 				jsonp:'data:jsonp',
 				dataType:'jsonp',
 				success:function(results){
 					if(results.totalCount >0){
 						pageCount=Math.ceil(results.totalCount/pageSize);
 						refreshData(1,pageSize);
 						$("#11").createPage({
 						    pageCount:pageCount,
 						    current:1,
 						    backFn:function(p){
 						       this.pageCount=pageCount;
 						        refreshData(p,pageSize);
 						    }
 						});
 					}else{
 						//$("#loading").addClass("undis") ;
 						$("#01").empty() ;
 						$("#22").hide() ;
 						$("#33").hide() ;
						$("#01").append('<div class="tc pt50 pb50"><img src="../styles/images/none3.png" border="0"/></div>') ;
 					}
 				}
 			});
				
	        function refreshData(pageIndex,pageSize){
	        	$("#tp5").removeClass("undis") ;
	 			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
	 			$.youi.ajaxUtils.ajax({
	 				url:serviceURL,
	 				jsonp:'data:jsonp',
	 				data:params.join('&'),
	 				dataType:'jsonp',
	 				success:function(results){
	 					if(results&&results.records){
	 						getHtml(results.records);
	 						$("#tp5").addClass("undis") ;
	 					}
	 					$("#tp5").addClass("undis") ;
	 				}
	 			});
	 		}
		         
	         function getHtml(newsList){
	         	$("#01").empty() ;
	         	$("#11").show() ;
	         	$("#22").hide() ;
	         	$("#33").hide() ;
	         	for(var i=0;i<newsList.length;i++){
	         		var news = newsList[i] ;
	         		var temp = news.policyContent ;
	 				var start = temp.indexOf("<p>");
	 				var end = temp.indexOf("</p>");
	 				var content = temp.substring(start,end+4) ;
	 				var html = "<li>"+
				    				"<a href='zs7.html?policyId="+news.policyId+"'>"+
									'<div class="plg-photo">'+
										"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+news.imageUrl+"&method=show' border='0' width='100%'>"+
									"</div>"+
						 			"<div class='plg-article'>"+
										"<a href='zs7.html?policyId="+news.policyId+"'><h3>"+news.policyCaption+"</h3>"+content+"</a>"+
										"</div>"+
									"</a>"+
								"</li>";
					$("#01").append(html) ;
	         	}
	         	//$("#loading").addClass("undis") ;
	 		}
		});
		$(function(){
			var pageSize=5;
		    var pageCount=1;
		    var serviceURL = baseUrl+"nmIssuenewsManager/getPagerAllPolicy.json?issueTypeCode=0102";
			$.youi.ajaxUtils.ajax({
 				url:serviceURL,
 				jsonp:'data:jsonp',
 				dataType:'jsonp',
 				success:function(results){
 					if(results.totalCount >0){
 						pageCount=Math.ceil(results.totalCount/pageSize);
 						refreshData(1,pageSize);
 						$("#22").createPage({
 						    pageCount:pageCount,
 						    current:1,
 						    backFn:function(p){
 						       this.pageCount=pageCount;
 						        refreshData(p,pageSize);
 						    }
 						});
 					}else{
 						$("#02").empty() ;
						$("#02").append('<div class="tc pt50 pb50"><img src="../styles/images/none3.png" border="0"/></div>') ;
 					}
 				}
 			});
				
	        function refreshData(pageIndex,pageSize){
	        	$("#tp5").removeClass("undis") ;
	 			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
	 			$.youi.ajaxUtils.ajax({
	 				url:serviceURL,
	 				jsonp:'data:jsonp',
	 				data:params.join('&'),
	 				dataType:'jsonp',
	 				success:function(results){
	 					if(results&&results.records){
	 						getHtml(results.records);
	 						$("#tp5").addClass("undis") ;
	 					}
	 					$("#tp5").addClass("undis") ;
	 				}
	 			});
	 		}
		         
	         function getHtml(newsList){
	         	$("#02").empty() ; 
	         	for(var i=0;i<newsList.length;i++){
	         		var news = newsList[i] ;
	 				var html = "<a href='zs7.html?policyId="+news.policyId+"'>"+
					 			 "<li>"+news.policyCaption+"<span class='fr'>"+news.policyIssueDate+"</span></li>"+
				  				"</a>";
					$("#02").append(html) ;
	         	}
	 		}
		});
		$(function(){
			var pageSize=5;
		    var pageCount=1;
		    var serviceURL = baseUrl+"nmIssuenewsManager/getPagerAllPolicy.json?issueTypeCode=0103";
			$.youi.ajaxUtils.ajax({
 				url:serviceURL,
 				jsonp:'data:jsonp',
 				dataType:'jsonp',
 				success:function(results){
 					if(results.totalCount >0){
 						pageCount=Math.ceil(results.totalCount/pageSize);
 						refreshData(1,pageSize);
 						$("#33").createPage({
 						    pageCount:pageCount,
 						    current:1,
 						    backFn:function(p){
 						       this.pageCount=pageCount;
 						        refreshData(p,pageSize);
 						    }
 						});
 					}else{
 						$("#03").empty() ;
						$("#03").append('<div class="tc pt50 pb50"><img src="../styles/images/none3.png" border="0"/></div>') ;
 					}
 				}
 			});
				
	        function refreshData(pageIndex,pageSize){
	        	$("#tp5").removeClass("undis") ;
	 			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
	 			$.youi.ajaxUtils.ajax({
	 				url:serviceURL,
	 				jsonp:'data:jsonp',
	 				data:params.join('&'),
	 				dataType:'jsonp',
	 				success:function(results){
	 					if(results&&results.records){
	 						getHtml(results.records);
	 						$("#tp5").addClass("undis") ;
	 					}
	 					$("#tp5").addClass("undis") ;
	 				}
	 			});
	 		}
		         
	         function getHtml(newsList){
	         	$("#03").empty() ; 
	         	for(var i=0;i<newsList.length;i++){
	         		var news = newsList[i] ;
	 				var html = "<a href='zs7.html?policyId="+news.policyId+"'>"+
					 			 "<li>"+news.policyCaption+"<span class='fr'>"+news.policyIssueDate+"</span></li>"+
				  				"</a>";
					$("#03").append(html) ;
	         	}
	 		}
		});
		
		$(document).on("click",".park-nav li",function(){
			$(".park-nav li").removeClass("active");
			$(this).addClass("active");
			$(".park-box ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
			var issueTypeCode = $(this).attr("id") ;
			if(issueTypeCode == "0101"){
				$("#11").show() ;
				$("#22").hide() ;
				$("#33").hide() ;
			}
			if(issueTypeCode == "0102"){
				$("#11").hide() ;
				$("#22").show() ;
				$("#33").hide() ;
			}
			if(issueTypeCode == "0103"){
				$("#11").hide() ;
				$("#22").hide() ;
				$("#33").show() ;
			}
		});