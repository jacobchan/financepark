var currentIndex = 1;
var pageSize=10;
var pageCount=1;
	$(function(){
		loadData();
	});
	
	//加载数据
	function loadData(){
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "policyApplyManager/getTotalCount.json",
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
					    pageCount:pageCount,
					    current:1,
					    backFn:function(p){
					    	currentIndex = p;
					       this.pageCount=pageCount;
					        refreshData(p,pageSize);
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
			url : baseUrl + "policyApplyManager/getPagerPolicyApply.json",
			data : params.join('&'),
			success : function(results) {
				if (results && results.records) {
					_parseRecords(results.records);
				};
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
					html += '	<td>'+ recordList[index].applyCode+ '</td>'
					html += '	<td>'+ recordList[index].nmIssuenews.policyCaption+ '</td>'
					html += '	<td>'+ recordList[index].policyApplyContactPeople+ '</td>'
					html += '	<td>'+ recordList[index].createTime.substring(0,10)+ '</td>'
					if(recordList[index].policyApplyStatus=="01"){
						html += '	<td>未办理</td>'
						html += '	<td><a href="javascript:cancel(\''+recordList[index].policyApplyId+'\',\''+recordList[index].applyCode+'\');" class="ac-cancle">取消</a></td>'
					}else if(recordList[index].policyApplyStatus=="02"){
						html += '	<td>申请成功</td>'
						html += '	<td></td>'
					}else if(recordList[index].policyApplyStatus=="03"){
						html += '	<td>申请失败</td>'
						html += '	<td></td>'
					}else if(recordList[index].policyApplyStatus=="04"){
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
	// 确认取消弹窗
	function cancel(id,applyCode){
		//alert(aplaypNo);
		$(".moverec").html(applyCode);//给弹窗插入订单号
		$(".moverec")[0].setAttribute("id",id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//取消操作
	$(".hhf-submit.confirm").click(function(){	
	    $(".bg-tanc.m1").hide();
		var id=$(".moverec")[0].getAttribute("id");	
		var params = [ 'policyApplyId=' + id ];
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "policyApplyManager/cancelApply.json",
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
	$(".tc-close").click(function(){					
		$(".bg-tanc.m1").hide();
	});