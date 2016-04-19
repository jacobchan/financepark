<%@ page language="java" pageEncoding="UTF-8"%>
<div class="clearfix">
	<table class="gt-table mt20">
		<colgroup>
			<col width="120">
			<col width="120">
			<col>
			<col width="120">
			<col width="120">
			<col width="120">
		</colgroup>
		<tbody>
			<tr>
				<th>申请编号</th>
				<th>政策类型</th>
				<th>申请人</th>
				<th>申请时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</tbody>
	</table>
	<div class="tcdPageCode fr"></div>
</div>
<div class="toast">
    <div class="toast-con clearfix">
        <div class="close-toast fr"></div>
        <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
    </div> 
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
<script type="text/javascript"> 
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
			url : baseUrl + "entrepreneurshipManager/getTotalCount.json",
			success : function(results) {
				var totalCount=results.records[0].totalCount;
				pageCount = Math.ceil(totalCount / pageSize);
				//开始勾画页面
				refreshData(1, pageSize);
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
		});
	}
	
	//分页列表开始显示
	function refreshData(pageIndex, pageSize) {
		var params = [ 'pager:pageIndex=' + pageIndex,'pager:pageSize=' + pageSize ];
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "entrepreneurshipManager/getPagerEntrepreneurships.json",
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
		for (var index = 0; index < recordList.length; index++) {
			html += '<tr>'
			html += '	<td><a href="">'+ recordList[index].applayNo+ '</a></td>'
			html += '	<td>创业加速申请</td>'
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
	function cancel(id){
		var params = [ 'id=' + id ];
		$.youi.ajaxUtils.ajax({
			url : baseUrl + "entrepreneurshipManager/goCancel.json",
			data : params.join('&'),
			success : function(results) {
				//loadData();
				close("取消成功");
			}
		});
	}
	
	
	
</script>