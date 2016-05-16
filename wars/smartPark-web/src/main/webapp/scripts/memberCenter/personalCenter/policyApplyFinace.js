//页面取消成功的Page页
	var currentIndex = 1;
	//页面显示的条数
	var pageSize=10;
	//默认显示在第1页
	var pageCount=1;
	$(function(){
		loadData();
	});
	
	//加载数据
	function loadData(){
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "finaceManager/getTotalCount.json",
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
			success : function(results) {
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);
				//开始勾画页面
				refreshData(1, pageSize);
				//判断是否有数据，有数据显示翻页样式
				if(totalCount>0){
					$(".tcdPageCode").createPage({
						pageCount : pageCount,
						current : 1,
						backFn : function(p) {
							currentIndex = p;
							this.pageCount = pageCount;
							refreshData(p, pageSize);
						}
					});
				}
				//关闭dataLoading样式
				$.showBox.CloseDataLoading();
			}
		});
	}
	
	//分页列表开始显示
	function refreshData(pageIndex, pageSize) {
		var params = [ 'pager:pageIndex=' + pageIndex,'pager:pageSize=' + pageSize,'orderBy=desc:createTime'];
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "finaceManager/getPagerFinaces.json",
			data : params.join('&'),
			success : function(results) {
				if (results && results.records) {
					_parseRecords(results.records);
				}
			}
		});
	}
	
	//拼接列表
	function _parseRecords(recordList){
		var headHtml = "";
			headHtml+='<tr>'
			headHtml+='	<th>申请编号</th>'
			headHtml+='	<th>政策类型</th>'
			headHtml+='	<th>申请人</th>'
			headHtml+='	<th>申请时间</th>'
			headHtml+='	<th>状态</th>'
			headHtml+='	<th>操作</th>'
			headHtml+='</tr>'
			var html = "";
			if(recordList.length>0){
				for (var index = 0; index < recordList.length; index++) {
					html += '<tr>'
					html += '	<td>'+ recordList[index].applayNo+ '</td>'
					html += '	<td>融资申请</td>'
					html += '	<td>'+ recordList[index].member.memberName+ '</td>'
					html += '	<td>'+ recordList[index].createTime+ '</td>'
					if(recordList[index].applayStatus=="01"){
						html += '	<td>未办理</td>'
						html += '	<td><a href="javascript:cancel(\''+recordList[index].id+'\');" class="ac-cancle">取消</a></td>'
					}else if(recordList[index].applayStatus=="02"){
						html += '	<td>已完成</td>'
						html += '	<td></td>'
					}else if(recordList[index].applayStatus=="03"){
						html += '	<td>已取消</td>'
						html += '	<td></td>'
					}
					html += '</tr>'
				}
			}else{
				$(".tcdPageCode").empty();
				html += '<tr>'
				html += '	<td colspan="6">暂无记录</td>'
				html += '</tr>'
			}
		
		$("tbody").html(headHtml+html);
	};
	//取消成功，提示信息
	function close(content){		        
        $(".tc.mt25.f18").empty() ;
        $(".tc.mt25.f18").append(content) ;
        $(".toast").show();		      		        		       				
		setTimeout(function(){$(".toast").hide(); },2000);
		refreshData(currentIndex,pageSize);
  	}
	
	
	//取消操作
	/*function cancel(id){
		var params = [ 'id=' + id ];
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "finaceManager/goCancel.json",
			data : params.join('&'),
			success : function(results) {
				//loadData();
				close("取消成功");
			}
		});
	}*/
	// 确认取消弹窗
	function cancel(id){
		//alert(aplaypNo);
		//$(".moverec").html(aplaypNo);//给弹窗插入订单号
		$(".moverec")[0].setAttribute("id",id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//取消操作
	$(".hhf-submit.confirm").click(function(){	
	    $(".bg-tanc.m1").hide();
		var id=$(".moverec")[0].getAttribute("id");	
		var params = [ 'id=' + id ];
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "finaceManager/goCancel.json",
			data : params.join('&'),
			success : function(results) {
				//loadData();
				close("取消成功");
			}
		});
	});
	$(".close-toast").click(function(){					
		$(".toast").hide();		       
	});	