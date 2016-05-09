	var pageSize=2;
	var pageCount=1;
	var serviceURL = baseUrl+"activityApplyManager/getPagerActivityApplys.json";
	$(function(){
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
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
			}
		});
	});

		function refreshData(pageIndex,pageSize){
			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				jsonp:'data:jsonp',
				data:params.join('&'),
				dataType:'jsonp',
				success:function(results){
					if(results&&results.records){
						_parseRecords(results.records);
					}
				}
			});
		}
		
		function _parseRecords(record){
			var html='';
			for(var i=0;i<record.length;i++){
				html+="<li class='clearfix'>"+record[i].applyTitle+"</li>";
			}
			$('#carfix').empty();
			$('#carfix').append(html);
		}	