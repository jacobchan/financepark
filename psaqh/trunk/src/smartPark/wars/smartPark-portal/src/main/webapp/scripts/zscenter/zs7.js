$(function(){
		/*$(".zan-cai").click(function(){
			var i=0;
			$(".zan-cai").each(function(){
				if($(this).find(".show2").hasClass("undis")){
					i=i+1;
				}else{
					i=i;						
				}
			})
			if(i==2){
				$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
			}
		});*/
		$(".zan-cai").click(function(){
			var dingId = $(".imageDing").attr("id") ;
			var caiId = $(".imageCai").attr("id") ;
			if(dingId||caiId){//已经顶过或踩过
				
			}else{//没有顶过和踩过
				var status = "" ;
				$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
				if($(this).hasClass("dingImage")){
					status = "00" ;
				}else if($(this).hasClass("caiImage")){
					status = "01" ;
				}
				var issueNewsId = getParam() ;
				var userIp = getfinger() ;
				var param = ["issueNewsId="+issueNewsId,"userIp="+userIp,"status="+status] ;
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"nmIssuenewsDorCManager/saveNmIssuenewsDorC.json",
					data:param.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.record){
							var record = result.record ;
							var status = record.status ;
							if(status == "00"){
								$(".imageDing").attr("id","00");
								$("#ding").text("("+record.currentDingCount+")") ;
							}
							if(status == "01"){
								$(".imageCai").attr("id","01");
								$("#cai").text("("+record.currentCaiCount+")") ;
							}
						}
					}
				});
			}
		});

		/*$("#dingImage").mouseover(function(){
			$("#imageDing1").addClass("undis") ;
			$("#imageDing").removeClass("undis") ;
		}) ;
		$("#dingImage").mouseout(function(){
			$("#imageDing").addClass("undis") ;
			$("#imageDing1").removeClass("undis") ;
		}) ;*/
		/* 
		$(".zan-cai").click(function(){
			$(".zan-cai").find(".show2").addClass("undis").siblings().removeClass("undis");
			$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
			$(this).mouseout(function(){
				$(this).find(".show2").removeClass("undis").siblings().addClass("undis");
			});
		}); */
		
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
					setDingAndCai(record)
					getHtml(record) ;
				}
			});
		}
	});
	var userIp = "";
	userIp = getfinger() ;
	var params1=["issueNewsId="+policyId,"userIp="+userIp];
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"nmIssuenewsDorCManager/getNmIssuenewsDorCByNewsIdAndIp.json",
		data:params1.join('&'),
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			var record = result.record ;
			console.log(record);
			if(record){
				var status = record.status ;
				if(status == "00"){
					$(".imageDing").removeClass("undis");
					$(".imageDing").attr("id","00");
					$(".imageDing1").addClass("undis");
				}
				if(status == "01"){
					$(".imageCai").removeClass("undis");
					$(".imageCai").attr("id","01");
					$(".imageCai1").addClass("undis");
				}
			}	
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

/*設置頂或踩的數量*/
function setDingAndCai(record){
	$("#ding").text("("+record.dingCount+")") ;
	$("#cai").text("("+record.caiCount+")") ;
}
/*获取指纹*/
function getfinger(){
	var fp1 = new Fingerprint();
	console.log(fp1) ;
	return fp1.get() ;
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