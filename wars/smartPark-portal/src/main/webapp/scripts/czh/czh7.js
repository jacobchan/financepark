$(function(){
			var url=location.href; 
			var tmp1=url.split("?")[1];  
			var tmp2='';
			var tmp3='';
			var tmp4='';
			if(tmp1!=''&&tmp1!=null){
				tmp2=tmp1.split("=")[1]; 
				tmp3=tmp1.split("&")[1]; 
			}
			if(tmp3!=''&&tmp3!=null){
				tmp4=tmp3.split("=")[1]; 
			}
			var applyId='';
			if(tmp2!=''&&tmp1!=null){
				applyId=tmp2;
			}
			star(".starbox1 i");
			var serviceURL = baseUrl+"activityDocumentManager/getPagerActivityDocuments.json";
			var params = ['activityApply.applyId='+applyId];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					//console.log(results);
					if(results&&results.records){
						if(tmp4!=''&&tmp4!=null){//知识库进入
							knowpage(tmp4);
						}else{//活动进入
							_parseRecords(results.records);
						}
						documents(results.records);
					}
				}
			});		
		});
		//活动详情赋值
		function _parseRecords(record){
			var documentPath=record[0].documentPath;
			var documentId = record[0].documentId;
			//关联活动发布人
			var docname="<img src='../styles/images/czh/user-l.png' border='0' class='mr20'>主讲人："+record[0].activityApply.memberId.memberName+"";
			$(".docname").append(docname);
			//阅读数
			var ronum = getRandom(1000);
			$(".docread").html(""+ronum+"人阅读");
			//关联活动文档名称
			$(".documentName").html(record[0].documentName.split('.')[0]);
			$(".documentName").attr("id",record[0].documentId);
			//关联活动图片
			var img="<a href='czh3.html?applyId="+record[0].activityApply.applyId+"'>"+
			"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[0].activityApply.activityImage+"&method=show' border='0' width='288' height='195'/></a>";
            $("#associatedActivitiy").empty().append(img);
            getpdf(documentId);
            getComment(documentId);
		}
		//加载文档
		function getpdf(id){
			var params = ['documentId='+id];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'activityDocumentManager/getViewDocument.json',
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					var swfUrl=result.record.html;
					_parsePDF(swfUrl);
				}
			});
		}
		
		//pdf div赋值
		function _parsePDF(swfUrl){
			 $('#documentViewer').FlexPaperViewer(
		                { config : {

		                	SWFFile : escape(cenUrl+'common/upload.html?repository=/swfupload&path='+swfUrl+'&method=show'),	                    
		                    Scale : 0.6,//缩放比例
		                    ZoomTransition : 'easeOut',    //Flexpaper中缩放样式，它使用和Tweener一样的样式，默认参数值为easeOut.其他可选值包括: easenone, easeout, linear, easeoutquad
		                    ZoomTime : 0.5,                //从一个缩放比例变为另外一个缩放比例需要花费的时间，该参数值应该为0或更大。
		                    ZoomInterval : 0.1,            //缩放比例之间间隔，默认值为0.1，该值为正数。
		                    FitPageOnLoad : true,          //初始化的时候自适应页面，与使用工具栏上的适应页面按钮同样的效果。
		                    FitWidthOnLoad : true,        //初始化的时候自适应页面宽度，与工具栏上的适应宽度按钮同样的效果。
		                   	PrintEnabled: false,            //是否支持打印
							FullScreenAsMaxWindow : false, //是否支持全屏,当设置为true的时候，单击全屏按钮会打开一个
		                    ProgressiveLoading : true,    //当设置为true的时候，展示文档时不会加载完整个文档，而是逐步加载，
		                    MinZoomSize : 0.2,             //最小的缩放比例。
		                    MaxZoomSize : 5,               //设置最大的缩放比例。
		                    SearchMatchAll : false,        //设置为true的时候，单击搜索所有符合条件的地方高亮显示。
		                    InitViewMode : 'Portrait',     //启动模式，如”Portrait” or “TwoPage”.
		                    RenderingOrder : 'flash',
		                    StartAtPage : '',

		                    ViewModeToolsVisible : true,   //工具栏上是否显示样式选择框(就是显示缩略图或分页显示的工具)
		                    ZoomToolsVisible : true,       //工具栏上是否显示缩放工具
		                    NavToolsVisible : true,        //工具栏上是否显示导航工具(也就是页码工具)
		                    CursorToolsVisible : true,     //工具栏上是否显示光标工具
		                    SearchToolsVisible : true,     //工具栏上是否显示搜索
		                    WMode : 'window',
		                    localeChain: 'en_US'
		                }}
		        );
		}
		//拼接侧边栏
		function documents(record){
			$(".article-tab").empty();
			var html ="";
			html+="<colgroup><col width='42'></col><col width='230'></col></colgroup>";
			for(var i=0;i<record.length;i++){
				html+=
					"<tr id="+record[i].documentId+" onclick='openPage(this)' style='cursor:pointer;'><td><em>P</em></td>"+
					"<td><p>"+record[i].documentName.split('.')[0]+"</p>"+
					"<span>"+record[i].createTime+"</span>"+
					"</td></tr>";
			}
			$(".article-tab").append(html);
		}
		//侧边栏点击切换
		function openPage(obj){
			var documentId = obj.id;
			var documentIded = $(".documentName").attr("id");
			if(documentIded!=documentId){
				$(".documentName").html($(obj).find("p").text());
				$(".documentName").attr("id",obj.id);
				//阅读数
				var ronum = getRandom(1000);
				$(".docread").html(""+ronum+"人阅读")
				//变更文档展示
				getpdf(documentId);
				getComment(documentId);
			}
		}
		
		//知识库进入拼接
		function knowpage(id){
			var serviceURL = baseUrl+"activityDocumentManager/getPagerActivityDocuments.json";
			var params = ['documentId='+id];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.records){
						_parseRecords(results.records);
					}
				}
			});		
		};
		
		//评论数
		function star(ele){
			$(ele).hover(function(){
				var index=$(this).index()+1;
				$(ele).removeClass("star1").addClass("star2");
				var arr=$(ele).toArray().slice(0,index);
				for(var i=0;i<arr.length;i++){
					arr[i].className="star1";
				}
			});
		}
		
		//生成随机数
		function getRandom(n){
	        return Math.floor(Math.random()*n+1);
	     };
	     
	     //加载当前文档评论
	     function getComment(id){
	    	 var pageSize=3;
			var pageCount=1;	
	    	 var documentId = id;
	    	 var params ={'activityDocument.documentId':documentId,orderBy:'desc:commentTime'};
				$.youi.ajaxUtils.ajax({
					url:baseUrl+"activityCommentManager/getPagerActivityComments.json",
					data:params,
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
						if(results&&results.records){
							if(results.records.length>0){
								pageCount=Math.ceil(results.totalCount/pageSize);
								 refreshData(1,pageSize);
									$(".tcdPageCode").createPage({
									    pageCount:pageCount,
									    current:1,
									    backFn:function(p){
									       this.pageCount=pageCount;
									        refreshData(p,pageSize);
									    }
									});
									$(".tcdPageCode").show();
							}else{
								$(".comment").empty();
								$(".comment").append("<tr><td align='center'><h2>暂无评论</h2></td></tr>");
								$(".tcdPageCode").hide();
							}
						}
					}
				});	
				
				function refreshData(pageIndex,pageSize){
					var params = {'pager:pageIndex':pageIndex,'pager:pageSize':pageSize,'activityDocument.documentId':documentId,orderBy:'desc:commentTime'};
					$.youi.ajaxUtils.ajax({
						url:baseUrl+"activityCommentManager/getPagerActivityComments.json",
						jsonp:'data:jsonp',
						data:params,
						dataType:'jsonp',
						success:function(results){
							if(results&&results.records){
								if(results.records.length>0){
									commRecords(results.records);
								}
							}
						}
					});
				}
				
				
				$.youi.ajaxUtils.ajax({
					url:baseUrl+"activityCommentManager/getPagerActivityComments.json",
					data:['activityDocument.documentId='+documentId].join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
						if(results&&results.records){
							if(results.records.length>0){
								var comm = results.records;
								var len = comm.length;
								var count =0;
									for(var j=0;j<len;j++){
										count+=parseInt(comm[j].commentLevel);
									}
									var val = parseInt(count/len);
									$('.valcomm').empty();
									var html = "";
									for(var j=0;j<val;j++){
										html+="<i class='star1'></i>";
									}
									for(var k=0;k<5-val;k++){
										html+="<i class='star2'></i>";
									}
									$('.valcomm').append("<span class='lh26 fl'>评价文档：</span><span class='starbox2'>"+html+"</span>");
									$('.doceval').empty();
									$('.doceval').append(""+len+"人评价");
								}else{
									$('.valcomm').empty();
									$('.valcomm').append("<span class='lh26 fl'>评价文档：</span><img src='../styles/images/czh/star-h.png' border='0' class='mr20'>");
									$('.doceval').empty();
									$('.doceval').append("0人评价");
								}
							}
						}
					});
	     }
	     
	   	//拼接top3文档评论
			function commRecords(record){
				$(".comment").empty();
				var html ="";
				for(var i=0;i<record.length;i++){
					var count = record[i].commentLevel;
					var cont = "";
					for(var j=0;j<count;j++){
						cont+="<i class='star1'></i>";
					}
					for(var k=0;k<5-count;k++){
						cont+="<i class='star2'></i>";
					}
					var imsrc = "";
					if(record[i].commentMember.memberHeadPortrait!=null&&record[i].commentMember.memberHeadPortrait!=''){
						imsrc=cenUrl+'common/uploadImage.html?repository=/swfupload&path='+record[i].commentMember.memberHeadPortrait+'&method=show';
					}else{
						imsrc="../styles/images/yqfw/p1.png";
					}
					html+="<tr><td><img src='"+imsrc+"' style='width:58px;height:58px;'></td>"+
						"<td><h4>"+
						"<span class='starbox2'>"+cont+"</span>"+
						"<span class='ml5'>"+record[i].commentMember.memberNickname+"</span></h4>"+
						"<p class=f14'>"+record[i].commentContent+"</p></td>"+
						"<td class='tr'><p class='c-b1 f12'>"+record[i].commentTime+"</p></td></tr>";
				}
				$(".comment").append(html);
			}
	   	//发表评论
	   	function postcomm(){
	   		var documentId = $(".documentName").attr("id");
	   		if(!isLogin){
	   			close("请登录!");
				return false;
			}
	   		var commentContent = $('.commtext').val();
	   		if(commentContent==''||commentContent==null){
	   			close("请输入评论内容!");
				return false;
			}
	   		var commentLevel = 0;
			var arr=$('.starbox1 i').toArray();
			for(var i=0;i<arr.length;i++){
				if(arr[i].className=="star1"){
					commentLevel++;
				}
			}
	   		var params = ['activityDocument.documentId='+documentId,'commentContent='+commentContent,'commentLevel='+commentLevel];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+"activityCommentManager/saveActivityComment.json",
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.record){
						close("评论成功!");
						$('.commtext').val('');
						getComment(results.record.activityDocument.documentId);
					}
				}
			});
	   	}
	   	
	   	//弹出框
	   	function close(content){		        
		        $(".tc.mt25.f18").empty() ;
		        $(".tc.mt25.f18").append(content) ;
		        $(".toast").show();		      		        		       				
				setTimeout(function(){$(".toast").hide(); },1000);
	      }