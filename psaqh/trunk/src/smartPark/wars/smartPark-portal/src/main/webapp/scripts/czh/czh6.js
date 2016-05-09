$(function(){
				//活动类型数据
				var serviceURL = baseUrl+"applayTypeManager/getApplayTypes.json";
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
						if(results&&results.records){
						_parseTypeRecords(results.records);
						initCheck();
						}
					}
				});		
			});
			//初始化类型选中
			function initCheck(){
				var url=location.href;
				var tmp1=url.split("?")[1],
					tmp2='',
					typeId='';
				if(tmp1!=null&&tmp1!=''){
					 tmp2=tmp1.split("=")[1]; 
					 typeId=tmp2;
				}
				if(typeId!=null&&typeId!=''){
					$(".czh-search.link a").removeClass("active");
					$("#"+typeId+"").addClass("active");
				}else{
					 typeId= $(".czh-search.link a").eq(0).attr('id');
					$(".czh-search.link a").removeClass("active");
					$("#"+typeId+"").addClass("active");
				}	
			  parseActivityList(typeId,'0');
			  uptime();
			}
		
			//拼接类型数据
			function _parseTypeRecords(record){
				var html='';
				html+="<span class='zs-span'>所属活动：</span>"; 
				for(var i=0;i<record.length;i++){
					if(i==0){
						html+="<a href='javascript:;' class='a-list active' id="+record[i].typeId+">"+record[i].typeName+"</li>";
					}else{
						html+="<a href='javascript:;' class='a-list' id="+record[i].typeId+">"+record[i].typeName+"</li>";
					}
				}
				$('.czh-search.link').empty();
				$('.czh-search.link').append(html);
				clickActive();
			}
			
			//拼接活动数据列表 desc:0表示默认为降序,1表示升序
			function parseActivityList(typeId,deac){
				var pageSize=8;
				var pageCount=1;	
				var typecode = typeId;
				var activeURL = baseUrl+"activityDocumentManager/getPagerActivityDocuments.json";	
				$.youi.ajaxUtils.ajax({
					url:activeURL,
					jsonp:'data:jsonp',
					data:['activityApply.applayType.typeId='+typecode].join('&'),
					dataType:'jsonp',
					success:function(results){
						pageCount=Math.ceil(results.totalCount/pageSize);
						 refreshData(1,pageSize,deac);
							$(".tcdPageCode").createPage({
							    pageCount:pageCount,
							    current:1,
							    backFn:function(p){
							       this.pageCount=pageCount;
							        refreshData(p,pageSize,deac);
							    }
							});
					}
				});	
				
				function refreshData(pageIndex,pageSize,deac){
					$("#tp_57").removeClass("undis") ;
					var params = "";
					if(deac=='0'){
						 params = {'pager:pageIndex':pageIndex,'pager:pageSize':pageSize,'activityApply.applayType.typeId':typecode,orderBy:'desc:createTime'};
					}else{
						 params = {'pager:pageIndex':pageIndex,'pager:pageSize':pageSize,'activityApply.applayType.typeId':typecode,orderBy:'asc:createTime'};
					}
					$.youi.ajaxUtils.ajax({
						url:activeURL,
						jsonp:'data:jsonp',
						data:params,
						dataType:'jsonp',
						success:function(results){
							$("#tp_57").addClass("undis") ;
							if(results&&results.records){
								//_parseRecords(results.records);
								if(results.records.length>0){
									$(".tcdPageCode").show();
									_parseRecords(results.records);
								}else{
									$('.czh-knowledge').empty();
									$(".czh-knowledge").append('<div class="tc pt50 pb50"><img src="../styles/images/none1.png" border="0"/></div>') ;
									$(".tcdPageCode").hide();
								}
								//console.log(results);
							}
						}
					});
				}
			}
			
		function _parseRecords(record){
				//根据不同类型获取数据
				$('.czh-knowledge').empty();
				var type = $('.a-list.active').text();
				var html='';
				for(var i=0;i<record.length;i++){
					   var count =  getRandom(1000); 
					   var path = getPathtype(record[i].documentPath);
						html+="<a href='czh7.html?applyId="+record[i].activityApply.applyId+"&documendid="+record[i].documentId+"'><div class='czh-box'>"+
						"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].activityApply.activityImage+"&method=show' style='width: 220px;height: 123px;'>"+
						"<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
						"<h4>"+record[i].documentName.split('.')[0]+"</h4>"+
						"<span>月观看人数："+count+"</span>"+
							"<span class='fr'>"+type+"</span>"+
						"</div>"+
						"<div class='czh-group'>"+
							"<font class='cg-soan-btn'>"+path+"</font>"+
						"</div></div></a>";
					}
				$('.czh-knowledge').append(html); 
			}
		
		//初始化时间排序
		function uptime(){
			$('.czh-search.clearfix').empty();
			var html ="<ul class='fl'><li class='active'>综合排序</li>"+
				"<li onclick='change()'>最新 <i class='fa fa-angle-down' id='licktime' data='0'></i></li></ul>";
			$('.czh-search.clearfix').append(html);
		}
		//生成随机数
		function getRandom(n){
	        return Math.floor(Math.random()*n+1);
	     };
		//获取文件类型
	    function getPathtype(path){
	    	var type="";
	    	var index1=path.lastIndexOf("."); 
	    	var index2=path.length;
	    	var postf=path.substring(index1+1,index2);//后缀名  
	    	if(postf=='doc'||postf=='docx'){
	    		type="WORD";
	    	}else if(postf=='xls'||postf=='xlsx'){
	    		type="EXCEL";
	    	}else if(postf=='ppt'||postf=='pptx'){
	    		type="PPT";
	    	}else if(postf=='pdf'){
	    		type="PDF";
	    	}
	    	return type;
	    } 
	    
		//按最新数据排序
		function change(){
			var id = $('.a-list.active').attr("id");
			if($("#licktime").attr("data")==0){
				$("#licktime").removeClass("fa-angle-down");
				$("#licktime").addClass("fa-angle-up");
				$("#licktime").attr("data","1");
				parseActivityList(id,'1');
			}else{
				$("#licktime").removeClass("fa-angle-up");
				$("#licktime").addClass("fa-angle-down");
				$("#licktime").attr("data","0");
				parseActivityList(id,'0');
			}
		}