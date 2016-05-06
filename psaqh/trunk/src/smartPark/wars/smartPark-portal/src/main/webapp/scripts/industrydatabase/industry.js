var a;
function jump1(){
	if(a>1){
		a--;
		$("#ti-m1").text(a);
	}else{
		//window.location="../grzx/grzx1.html";
		clearInterval(timer1); 
	}		
}
$(".tc-close").click(function(){
	 clearInterval(timer1); 
 });
var lb_two_index = 0;
var n=$(".lb-two ul li").length-2;
var m=$(".lt-circle a").length;
function lb_two_right(){
    lb_two_index++;
    if(lb_two_index > n){
        lb_two_index = 0;
    }
    lb_two_show(lb_two_index);
}
function lb_two_left(){
    lb_two_index--;
    if(lb_two_index < 0){
        lb_two_index = n;
    }
   lb_two_show(lb_two_index);
}
function lb_two_show(j){
	$(".lt-circle a").removeClass('current');
	var index = -(j*403);
    $(".lb-two ul").animate({left: index+'px'},400);
    
    if(j<2){
		$(".lt-circle a").eq(0).addClass('current');
	}else if(j % 2 == 0 && j >1){
		var i=j/2;
		$(".lt-circle a").eq(i).addClass('current');
	}else{
		if(j==n ){
			$(".lt-circle a").eq(m-1).addClass('current');
		}else{
			var i=(j-1)/2;
			$(".lt-circle a").eq(i).addClass('current');
		}
	}
}
function lb_two_show1(i){
	var index;
	if(i!= n/2 && i==m-1){
	 index = -((i-1)*806 + 403);
	}else{
		index = -(i*806);
	}
    $(".lb-two ul").animate({left: index+'px'},400);
    $(".lt-circle a").removeClass('current');
    $(".lt-circle a").eq(i).addClass('current');
}

$(".lt-circle a").click(function(){
    var index = $(".lt-circle a").index($(this));
    lb_two_show1(index);
    if(index == m-1){
    	lb_two_index=n;
    }else if(index < m){
    	lb_two_index = index*2;
    }
});
$(".lt-page .lp-right").click(function(){
	if(n>0){
		lb_two_right();
	}else{
		return false;
	}
    
});
$(".lt-page .lp-left").click(function(){
    if(n>0){
		lb_two_left();
	}else{
		return false;
	}
});
$(".open-d").click(function(e){
	e.stopPropagation();
	$(".dialog-con").toggle();
	$("#letterContent").val('');
});
//保存评论
function subComment(){
	if(!isLogin){
		close("请登录！");
		return false;
	}
	var Request = new Object();
	Request = GetRequest();
	var rzId = Request['id'];
	var commentContent = $("#commentContent").val();
	if(commentContent=="" || commentContent.trim().length==0){
		close("评论内容不能为空！");
		return false;
	}
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'memberInformationManager/getMemberInformationByLoginUser.json',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		success:function(result){
			if(result&&result.record){
				$.youi.ajaxUtils.ajax({
		    		url : baseUrl+"lettermanagerCommentManager/getLettermanagerComments.json",
					data : ['commentEnterprise='+rzId,'member.memberId='+result.record.memberId].join('&'),
					jsonp : 'data:jsonp',
		    		dataType : 'jsonp',
					success:function(results){
						if(results&&results.records&&results.records.length>0){
							close("不能重复评论！");
						}else{
							$.youi.ajaxUtils.ajax({
					    		url : baseUrl+"lettermanagerCommentManager/saveLettermanagerComment.json",
					    		data : ['commentEnterprise='+rzId,'commentContent='+commentContent].join('&'),
					    		jsonp : 'data:jsonp',
					    		dataType : 'jsonp',
					    		success : function(result) {
					    			if(result && result.record){
					    				close("评论提交成功！");
					    				$("#commentContent").val('');
					    				informeia(rzId);
					    				//window.location.reload();
					    			}
					    		}
					    	});
						}
					}
				});
			}
		}
	});
}
//保存私信
function subLetter(){
	var Request = new Object();
	Request = GetRequest();
	var rzId = Request['id'];
	var letterContent = $("#letterContent").val();
	if(letterContent=="" || letterContent.trim().length==0){
		close("评论内容不能为空！");
		return false;
	}
	$.youi.ajaxUtils.ajax({
		url : baseUrl+"lettermanagerLetterManager/saveLettermanagerLetter.json",
		data : ['letterEnterpriseId='+rzId,'letterContent='+letterContent].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		success : function(result) {
			if(result && result.record){
				close("私信提交成功！");
				 $(".dialog-con").hide();
				/*$("#letterContent").val();
				$('.bg-tanc.m1').show();
				$('#ti-m1').text('5');
				a=5;
				timer1=setInterval('jump1();',1000);*/
			}
		}
	});
}
function informeia(rzId){
	//根据企业id获取评论
	var pageSize=3;
	var pageCount=1;	
	var srcUrl =  baseUrl+"lettermanagerCommentManager/getPagerLettermanagerComments.json";
	$.youi.ajaxUtils.ajax({
		url : srcUrl,
		data : ['commentEnterprise='+rzId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		success : function(results) {
			if(results&&results.records){
				if(results.records.length>0){
					$("#commcount").html(results.totalCount);
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
					$("#commentDiv").empty();
					$("#commentDiv").append(" <colgroup><col width='95'></col><col></col></colgroup><tr><td align='center'><h2>暂无评论</h2></td></tr>");
					$(".tcdPageCode").hide();
					
				}
			}
		}
	});
	function refreshData(pageIndex,pageSize){
		var params = {'pager:pageIndex':pageIndex,'pager:pageSize':pageSize,'commentEnterprise':rzId};
		$.youi.ajaxUtils.ajax({
			url:srcUrl,
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
}
function commRecords(records){
	var comment = '<colgroup><col width="95"></col><col></col></colgroup>';
	$("#commentDiv").empty();
	for(var i=0; i<records.length; i++){
		var imsrc = "";
		if(records[i].member.memberHeadPortrait!=null&&records[i].member.memberHeadPortrait!=''){
			imsrc=cenUrl+'common/uploadImage.html?repository=/swfupload&path='+records[i].member.memberHeadPortrait+'&method=show';
		}else{
			imsrc="../styles/images/yqfw/p1.png";
		}
		comment+='<tr>'+
					'<td><img src='+imsrc+' style="width:70px;height:70px;"/></td>'+
					'<td>'+
						'<h4 class="f14 lh30">'+records[i].member.memberName+'<em class="em-box ml5">创</em></h4>'+
						'<p class="f14 lh30">'+records[i].commentContent+'<span class="f12">('+records[i].commentTime+')</span></p>'+
						'<!--<p class="tr f12 lh30"><a href="javascript:;" class="c-333"><i class="fa fa-thumbs-o-up c-o mr5" style="font-size:17px"></i>(0)赞</a><span class="ml10 mr10 c-o">|</span><a href="javscript:;" class="c-333">回复</a></p>-->'+
					'</td>'+
				'</tr>';
	}
	$("#commentDiv").append(comment);
}
function GetRequest() {
   var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}
$(document).ready(function() {
    var Request = new Object();
	Request = GetRequest();
	var rzId = Request['id'];
	var params = ['rzId='+rzId];
	var serviceURL = baseUrl+"enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json";
	//根据企业id获取企业信息
	$.youi.ajaxUtils.ajax({
		url : serviceURL,
		data:params.join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.record) {
				var record = results.record;
				$("#logo").attr("src", cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record.rzLogo+"&method=show");
				var rzName = record.rzName;
				if(rzName == null){
					rzName = "";
				}
				$("#rzName").html(rzName);
				var rzRemark = record.rzRemark;
				if(rzRemark == null){
					rzRemark = "";
				}
				$("#rzRemark").html(rzRemark);
				$("#introdaction").html(rzRemark);
				$("#rzAddress").append(record.roomId.roomAddress);
				$("#enTypeName").append(record.enTypeId.enTypeName);
				var rzUrl = record.rzUrl;
				if(rzUrl == null){
					rzUrl = "";
				}
				$("#rzUrl").append("<a href='"+rzUrl+"' target='_blank'><font class='c-o f14'>"+rzUrl+"</font></a>");
				$("#productDiv").html(record.productDiscriptio);
				$("#noticeTime").append(record.rzDate);
				if(record.attentionCount!=null && record.attentionCount!=""){
					$("#noticeCount").append(record.attentionCount);
				}else{
					$("#noticeCount").append("202");
				}
				if(record.scanCount!=null && record.scanCount!=""){
					$("#noticeSum").append(record.scanCount);
				}else{
					$("#noticeSum").append("238");
				}
				if(null!=record.rzImages){
					var images = record.rzImages.split(",");
					$("#rzImages").empty();
					$("#imagesDiv").empty();
    				for(var i=0; i<images.length; i++){
    					var src = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+images[i]+"&method=show";
    					$("#rzImages").append("<li><img src='"+src+"'></li>");
    				}
    				for(var j=0; j<images.length/2; j++){
    					if(j==0){
    						$("#imagesDiv").append("<a href='javascript:;' class='current'></a>");
    					}else{
    						$("#imagesDiv").append("<a href='javascript:;'></a>");
    					}
    				}	
				}
			}
			var map = new BMap.Map("map");//创建Map实例
			map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
			local = new BMap.LocalSearch(map, {
				renderOptions: {map: map}
			});
			//, panel: "r-result"
			local.search($("#rzAddress").html().substring(3,$("#rzAddress").html().length));
			$('#map div.anchorBL').hide();
		}
	});
	
	//根据企业id获取融资信息
	$.youi.ajaxUtils.ajax({
		url : baseUrl+"informationFinancingManager/findInformationFinancing.json",
		data : ['financingRe='+rzId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.records && results.records.length>0) {
				var records = results.records;
				$("#informationFinancing").empty();
				var financingDiv ='<div class="yg-group-box">';
				for(var i=0; i<records.length; i++){
					var financingMsg = "";
					if(records[i].financingStatus=="1"){
						financingMsg = records[i].financingTime.substring(0,4)+"年<p>"+records[i].financingTime.substring(5,7)+"月"+records[i].financingTime.substring(8,10)+"日</p>";
					}else{
						financingMsg = "发布中...";
					}
					financingDiv += '<div class="yg-time">'+
							'<div class="yt-pa">'+financingMsg+'</div><em class="em-pa"></em>'+
							'<div class="clearfix">'+
								'<span>'+records[i].financingSubValue+'</span><span>融资金额：<em class="c-o">'+records[i].financingAmount+'万元</em></span><span>融资估值：<em class="c-o">'+records[i].financingCost+'万元</em></span><span>可持股份：<em class="c-o">'+records[i].financingPre+'%</em></span>'+
							'</div>'+
							'<p>'+records[i].financingDescribe+'</p>'+
						'</div>';
				}
				$("#informationFinancing").html(financingDiv+"</div>");
			}
		}
	});
	
	//根据企业id获取媒体信息
	$.youi.ajaxUtils.ajax({
		url : baseUrl+"informationMediaManager/findInformationMedia.json",
		data : ['mediaRe='+rzId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.records && results.records.length>0) {
				var records = results.records;
				$("#mediaDiv").empty();
				for(var i=0; i<records.length; i++){
					var mediaDiv = '<div class="yin-box">'+
						'<a href="'+records[i].mediaTilurl+'" target="_blank"><img src="/filestore/'+records[i].mediaUrl+'" width="260" height="180" border="0" /></a>'+
						'<a href="'+records[i].mediaTilurl+'" target="_blank"><p class="mt10 mb10"><font class="c-o f14">'+records[i].mediaTitle+'</font></p></a>'+
					'</div>';
					$("#mediaDiv").append(mediaDiv);
				}
			}
		}
	});
	
	//根据企业id获取知识产权信息
	$.youi.ajaxUtils.ajax({
		url : baseUrl+"informationKnowledgeManager/findInformationKnowledge.json",
		data : ['knowledgeRe='+rzId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.records && results.records.length>0) {
				var records = results.records;
				var knowledgeDiv = '';
				var head = '<table width="100%"><colgroup><col width="260"></col><col></col></colgroup>';
				$("#knowledgeDiv").empty();
				for(var i=0; i<records.length; i++){
					var imgsrc = "../styles/images/yqfw/zz1.jpg";
					if(records[i].knowledgeUrl !=null && records[i].knowledgeUrl != "" && records[i].knowledgeUrl.length!=0){
						imgsrc = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+records[i].knowledgeUrl+"&method=show";
					}
					knowledgeDiv += '<tr>'+
						'<td><img src="'+imgsrc+'" width="223"></td>'+
						'<td>'+
							'<h4 class="f14 lh40 fb">'+records[i].knowledgeTitle+'</h4>'+
							'<p class="f12 lh24">'+records[i].knowledgeContent+'</p>'+
						'</td></tr>';
				}
				var end = '</table>';
				$("#knowledgeDiv").html(head+knowledgeDiv+end);
			}
		}
	});
	
	
	//根据企业id获取法定代表人信息
	$.youi.ajaxUtils.ajax({
		url : baseUrl+"informationLegalManager/findInformationLegal.json",
		data : ['legalRe='+rzId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.records && results.records.length>0) {
				var records = results.records;
				for(var i=0; i<records.length; i++){
					$("#legalImage").attr("src","/filestore/"+records[i].legalImage);
					$("#legalName").html(records[i].legalName);
					$("#legalBusiness").html(records[i].legalBusiness);
					$("#legalBirthday").append(records[i].legalBirthday);
					$("#legalRemark").html(records[i].legalRemark);
				}
			}
		}
	});
	
	//根据企业评论
	/*$.youi.ajaxUtils.ajax({
		url : baseUrl+"lettermanagerCommentManager/getLettermanagerComments.json",
		data : ['commentEnterprise='+rzId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			var comment = '<colgroup><col width="95"></col><col></col></colgroup>';
			if (results && results.records && results.records.length>0) {
				var records = results.records;
				$("#commentDiv").empty();
				for(var i=0; i<records.length; i++){
					comment+='<tr>'+
								'<td><img src="../styles/images/yqfw/p1.png" width="71" /></td>'+
								'<td>'+
									'<h4 class="f14 lh30">'+records[i].member.memberName+'<em class="em-box ml5">创</em></h4>'+
									'<p class="f14 lh30">'+records[i].commentContent+'<span class="f12">('+records[i].commentTime+')</span></p>'+
									'<!--<p class="tr f12 lh30"><a href="javascript:;" class="c-333"><i class="fa fa-thumbs-o-up c-o mr5" style="font-size:17px"></i>(0)赞</a><span class="ml10 mr10 c-o">|</span><a href="javscript:;" class="c-333">回复</a></p>-->'+
								'</td>'+
							'</tr>';
				}
				$("#commentDiv").append(comment);
			}
		}
	});*/
	informeia(rzId);
	//根据企业id获取公告信息
	//$.youi.ajaxUtils.ajax({
	//	url : baseUrl+"informationNoticeManager/findInformationNotice.json",
	//	data : ['noticeRe='+rzId].join('&'),
	//	jsonp : 'data:jsonp',
	//	dataType : 'jsonp',
	//	async : false,
	//	success : function(results) {
	//		if (results && results.records) {
	//			var records = results.records;
	//			for(var i=0; i<records.length; i++){
	//				$("#noticeTime").append(records[i].noticeTime);
	//				$("#noticeCount").append(records[i].noticeCount);
	//				$("#noticeSum").append(records[i].noticeSum);
	//			}
	//		}
	//	}
	//});
	
	//根据企业id获取产品信息
	//$.youi.ajaxUtils.ajax({
	//	url : baseUrl+"informationProductManager/findInformationProduct.json",
	//	data : ['productRe='+rzId].join('&'),
	//	jsonp : 'data:jsonp',
	//	dataType : 'jsonp',
	//	async : false,
	//	success : function(results) {
	//		if (results && results.records) {
	//			var records = results.records;
	//			for(var i=0; i<records.length; i++){
	//				$("#productDiv").html(records[i].productContent);
	//			}
	//		}
	//	}
	//});
});

$("body").bind("click", function(){
    $(".dialog-con").hide();
});
$(".dialog-con").click(function(e){
	e.stopPropagation();
	$(this).show();
})
//toast弹窗出来后，一秒自动关闭,请再调用弹窗toast的时候调用该方法
var pltime,timer;
 function closeTanc(){
 if(pltime>1){
	 pltime--;
  }else{
     $(".toast").hide();
	 }       
 };
//关闭toast
$(".close-toast").click(function(){
	   $(".toast").hide();
 });
function close(content){		        
    $(".tc.mt25.f18").empty() ;
    $(".tc.mt25.f18").append(content) ;
    $(".toast").show();		      		        		       				
	setTimeout(function(){$(".toast").hide(); },1000);
}