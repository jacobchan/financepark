$(function(){
		 $(".zan-cai").mouseover(function(){
			$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
		});
		$(".zan-cai").mouseout(function(){
			$(this).find(".show2").addClass("undis").siblings().removeClass("undis");
		});
		$(".zan-cai").click(function(){
			$(".zan-cai").find(".show2").addClass("undis").siblings().removeClass("undis");
			$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
			$(this).mouseout(function(){
				$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
			});
		}); 
		
	});
$(function(){
	$("#wb").hide() ;
	$("#loading").removeClass("undis") ;
	var policyId = "" ;
	policyId = getParam() ;//当前政策类型ID
	var params=["policyId="+policyId];
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"nmIssuenewsManager/setBrowseCountByPolicyId.json",//设置访问量
		data:params.join('&'),
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			$.youi.ajaxUtils.ajax({
				url:baseUrl +"nmIssuenewsManager/getNewsByPolicyId.json",
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					var record = result.record ;
					getHtml(record) ;
				}
			});
		}
	});
});
/* 获取页面传过来的参数 */
function getParam() { 
	var url = document.URL ; //获取页面的URL
	var param = "" ;  
	param = url.substring(url.lastIndexOf("=")+1,url.length) ; //获取页面的参数
	return param ;
}
/* 拼接HTML */
function getHtml(record){
	$('title')[0].innerHTML=record.policyCaption ;//给标题赋值
	var html = "<h2 style='font-size:26px;' class='lh35 mb20'>"+record.policyCaption+"</h2>"+
			   "<h5 class='f12 mb20'>"+record.policyIssueDate+"<span class='c-b1 ml10 mr10'>|</span> 来源："+record.policyCome+" <span class='c-b1 ml10 mr10'>|</span><img src='../styles/images/zs/page.png' border='0' class='mr5'/>"+record.browseCount+"</h5>"+
			   "<div class='article-con-p'>"+
			   "<p>"+record.policyContent+"</p>"+
			   "</div>" ;
	$("#id1").append(html) ;
	$("#loading").addClass("undis") ;
	$("#wb").show() ;
}
$(function(){
	var policyId = "" ;
	policyId = getParam() ;//当前政策类型ID
	var params=["policyId="+policyId];
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"nmIssuenewsManager/getPrePolicyByPolicyId.json",//得到上篇新闻
		data:params.join('&'),
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			var record = result.record ;
			if(record){
				var html = "上篇：<a href='zs7.html?policyId="+record.policyId+"'>"+record.policyCaption+"</a>"
				$("#p1").append(html) ;
			}
		}
	});
});
$(function(){
	var policyId = "" ;
	policyId = getParam() ;//当前政策类型ID
	var params=["policyId="+policyId];
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"nmIssuenewsManager/getNextPolicyByPilicyId.json",//得到下篇新闻
		data:params.join('&'),
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			var record = result.record ;
			if(record){
				var html = "<span class='fr'>下篇：<a href='zs7.html?policyId=" +record.policyId+"'>"+record.policyCaption+"</a></span>"
				$("#p1").append(html) ;
			}
		}
	});
});