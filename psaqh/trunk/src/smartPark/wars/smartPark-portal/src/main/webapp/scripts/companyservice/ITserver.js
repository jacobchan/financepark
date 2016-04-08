//定时跳转
function countdown(i){
	$("#ti-m1").text(i);
    i = i - 1;
    if(i > 0) {
        setTimeout("countdown("+i+")", 1000);
    }else{
    	jump();
    }
}
//跳转订单中心
function jump(){
	window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
}
//跳转个人中心
function jumpPerson(){
	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
}
//跳转首页
function jumpIndex(){
	window.location.href=cenUrl;
}
function showCom(genreId,y){
	var serviceURL = baseUrl+"purchasingmanagerCommodityManager/getCommodityRecordsByGenreId.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{genreId:genreId},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.records){
				var htmls = [];
				for(var i=0;i<results.records.length;i++){
					if(i==0){
						htmls.push('<li class="it_selected" data-id="'+results.records[i].commodityId+'"data-commodityDescribe="'+
								results.records[i].commodityDescribe+'" data-commodityPrice="'+results.records[i].commodityPrice+'"><span>'+
								results.records[i].commodityTitle+'</span><i class="sel_icon"></i></li>');
						$('#commodityShow'+y).parents(".taocan").attr("data-id",results.records[i].commodityId);
						$('#commodityShow'+y).parents(".taocan").attr("data-commodityDescribe",results.records[i].commodityDescribe);
						$('#commodityPrice'+y).html('&yen;'+results.records[i].commodityPrice+'/次');
						var des = results.records[i].commodityDescribe.split(",");
						var buff = [];
						for(var j=0;j<des.length;j++){
							buff.push('<li class="bgf1 caaa"><span>'+des[j]+'</span></li>');
						}
						$('#wt_info'+y).html(buff);
					}else{
						htmls.push('<li data-id="'+results.records[i].commodityId+'"data-commodityDescribe="'+results.records[i].commodityDescribe+
								'" data-commodityPrice="'+results.records[i].commodityPrice+'"><span>'+
								results.records[i].commodityTitle+'</span><i class="sel_icon"></i></li>');
					}
				}
				$('#commodityShow'+y).html(htmls.join(''));
			}
			
			$(".goods li").click(function(){
				$(this).addClass("it_selected").siblings("li").removeClass("it_selected");
				var id=$(this).attr("data-id");
				$(this).parents(".taocan").attr("data-id",id);
				var commodityPrice=$(this).attr("data-commodityPrice");
				var y = $(this).parents(".taocan").attr("data-commodity");
				$('#commodityPrice'+y).html('&yen;'+commodityPrice+'/次');
				var commodityDescribe = $(this).attr("data-commodityDescribe");
				var des = commodityDescribe.split(",");
				var buff = [];
				for(var i=0;i<des.length;i++){
					buff.push('<li class="bgf1 caaa"><span>'+des[i]+'</span></li>');
				}
				$('#wt_info'+y).html(buff);
			});
			
			$(".pay li").click(function(){
				$(this).addClass("it_selected").siblings("li").removeClass("it_selected");
				var id=$(this).attr("data-id");
				$(this).parents(".taocan").attr("data-id",id);
				var commodityPrice=$(this).attr("data-commodityPrice");
				var y = $(this).parents(".taocan").attr("data-commodity");
				$('#commodityPrice'+y).html('&yen;'+commodityPrice+'/次');
				var commodityDescribe = $(this).attr("data-commodityDescribe");
				var des = commodityDescribe.split(",");
				var buff = [];
				for(var i=0;i<des.length;i++){
					buff.push('<li class="bgf1 caaa"><span>'+des[i]+'</span></li>');
				}
				$('#wt_info'+y).html(buff);
			});
		}
	});
}
function showAddress(companyId){
	var sURL = baseUrl+"enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json";
	$.youi.ajaxUtils.ajax({
		url:sURL,
		data:{rzId:companyId},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.record){
				$('#userorderAdr1').val(results.record.roomId.roomAddress);
				$('#userorderAdr2').val(results.record.roomId.roomAddress);
				$('#userorderAdr3').val(results.record.roomId.roomAddress);
				$('#userorderAdr4').val(results.record.roomId.roomAddress);
			}
		}
	});
}
function star(ele){
	$(ele).hover(function(){
		var index=$(this).index()+1;
		$(ele).removeClass("star1").addClass("star0");
		var arr=$(ele).toArray().slice(0,index);
		for(var i=0;i<arr.length;i++){
			arr[i].className="star1";
		}
	});
}
$(function(){
	//关闭toast
    $(".close-toast").click(function(){
        $(".toast").hide();
    });
	var genreCode = "0508";
	var sURL = baseUrl+"memberInformationManager/getMemberInformationByLoginUser.json";
	$.youi.ajaxUtils.ajax({
		url:sURL,
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.record){
				showAddress(results.record.companyId);
			}
		}
	});
	
	var serviceURL = baseUrl+"purchasingmanagerGenreevaluateManager/getPagerPurGenreEvaluatesByCode.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{genreCode:genreCode},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.records){
				var htmls = [];
				for(var i=0;i<results.records.length;i++){
					htmls.push('<li><div class="fl"><img src="../styles/images/company/user.png"/><span class="record_info ml20 c3 lh24">'+
					'<div>'+results.records[i].memberInformation.memberName+'<i class="chuang"></i></div><p>'+results.records[i].content
					+'<span>('+results.records[i].createTime+')</span></p></span></div></li>');
				}
				$('.record_ul').html(htmls.join(''));
			}
		}
	}); 
	
	var serviceURL = baseUrl+"purchasingmanagerGenreManager/getITSubGenreList.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.records){
				var htmls = [];
				for(var i=0;i<results.records.length;i++){
					if(i==0){
						htmls.push('<li class="it_selected" data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
						showCom(results.records[i].genreId,i+1);
					}else{
						htmls.push('<li data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
					}
				}
				$('#it_select1').html(htmls.join(''));
				htmls = [];
				for(var i=0;i<results.records.length;i++){
					if(i==1){
						htmls.push('<li class="it_selected" data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
						showCom(results.records[i].genreId,i+1);
					}else{
						htmls.push('<li data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
					}
				}
				$('#it_select2').html(htmls.join(''));
				htmls = [];
				for(var i=0;i<results.records.length;i++){
					if(i==2){
						htmls.push('<li class="it_selected" data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
						showCom(results.records[i].genreId,i+1);
					}else{
						htmls.push('<li data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
					}
				}
				$('#it_select3').html(htmls.join(''));
				htmls = [];
				for(var i=0;i<results.records.length;i++){
					if(i==3){
						htmls.push('<li class="it_selected" data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
						showCom(results.records[i].genreId,i+1);
					}else{
						htmls.push('<li data-id="'+results.records[i].genreId+'"><span>'+results.records[i].genreName+'</span><i class="sel_icon"></i></li>');
					}
				}
				$('#it_select4').html(htmls.join(''));
			}
		}
	});
	
	$(".nav_1,.navsub").hover(function(){
		$(".navsub").show();
	},function(){
		$(".navsub").hide();
	});
	/**/
	$(".choose").on("click","li",function(){
		var ac=$(this).index();
		$(".taocan").eq(ac).show().siblings(".taocan").hide();
	});
	
	/**/
	$(".blend_ul li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings("li").removeClass("active");
		$(".blend_item").eq(index).show().siblings(".blend_item").hide();
	});
	/*drop_list*/
	$(".drop_down").click(function(){
		$(".drop_list").show();
	});
	$(".drop_list").on("click","li",function(){
		var text=$(this).text();
		$(".drop_show").val(text);
		$(".drop_list").hide();
	});
	/*check*/
	$("#deal i").click(function(){
		$(this).toggleClass("fa-square").toggleClass("fa-check-square");
	});
	star(".starbox1 i");
	star(".starbox2 i");
	star(".starbox3 i");
	star(".starbox4 i");
	
	$('.subBuy').click(function(){
		if(!isLogin){
            $(".toast").show();
            setTimeout('$(".toast").hide();',1000);//1秒=1000
		 	return;
		}
		var commodityId = $(this).parents(".taocan").attr("data-id");
		var y = $(this).parents(".taocan").attr("data-commodity");
		var userorderAdr = $('#userorderAdr'+y).val();
		var faultDes = $('#faultDes').val();
		var params = $.youi.parameterUtils.propertyParameter("commodityId",commodityId)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("faultDes",faultDes)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("userorderAdr",userorderAdr);
		
		var serviceURL = baseUrl+"ordermanagerUserorderManager/saveITSerOrder.json";
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			data:params,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				if(results&&results.record){
					alert('订单提交成功！');
					$(".pop_layer").hide();
					window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
				}
			}
		});
	});
	
	$('#evaluate').click(function(){
		if(!isLogin){
            $(".toast").show();
            setTimeout('$(".toast").hide();',1000);//1秒=1000
		 	return;
		}
		
		var overallSatisfaction = 0;
		var arr=$('.starbox1 i').toArray();
		for(var i=0;i<arr.length;i++){
			if(arr[i].className=="star1"){
				overallSatisfaction++;
			}
		}
		var reactionRate = 0;
		var arr=$('.starbox2 i').toArray();
		for(var i=0;i<arr.length;i++){
			if(arr[i].className=="star1"){
				reactionRate++;
			}
		}
		var serviceAttitude = 0;
		var arr=$('.starbox3 i').toArray();
		for(var i=0;i<arr.length;i++){
			if(arr[i].className=="star1"){
				serviceAttitude++;
			}
		}
		var costPerformance = 0;
		var arr=$('.starbox4 i').toArray();
		for(var i=0;i<arr.length;i++){
			if(arr[i].className=="star1"){
				costPerformance++;
			}
		}
		
		var evaluateContent = $('#evaluateContent').val();
		var params = $.youi.parameterUtils.propertyParameter("overallSatisfaction",overallSatisfaction)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("reactionRate",reactionRate)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("serviceAttitude",serviceAttitude)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("costPerformance",costPerformance)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("genreCode",genreCode)+"&";
		params = params+$.youi.parameterUtils.propertyParameter("evaluateContent",evaluateContent);
		
		var serviceURL = baseUrl+"purchasingmanagerGenreevaluateManager/savePurGenreEvaluate.json";
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			data:params,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				if(results&&results.record){
					alert('评论成功！');
					location.reload([true]);
				}
			}
		});
	});
	
	$('#consult').click(function(){
		if(!isLogin){
            $(".toast").show();
            setTimeout('$(".toast").hide();',1000);//1秒=1000
		 	return;
		}
		var content = $('#consultContent').val();
		var serviceURL = baseUrl+"purchasingmanagerGenreevaluateManager/savePurGenreConsult.json";
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			data:{content:content,genreCode:genreCode},
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				if(results&&results.record){
					alert('提交成功！');
					location.reload([true]);
				}
			}
		});
	});
});