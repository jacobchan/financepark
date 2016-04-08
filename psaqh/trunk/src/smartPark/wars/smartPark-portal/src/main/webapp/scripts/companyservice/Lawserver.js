//加法函数  
function accAdd(arg1, arg2) {  
    var r1, r2, m;  
    try{  
        r1 = arg1.toString().split(".")[1].length;  
    }catch (e) {
        r1 = 0;  
    }
    try {
        r2 = arg2.toString().split(".")[1].length;  
    }catch (e) {  
        r2 = 0;  
    }  
    m = Math.pow(10, Math.max(r1, r2));  
    return (arg1 * m + arg2 * m) / m;  
}   

//减法函数  
function Subtr(arg1, arg2) {  
    var r1, r2, m, n;  
    try {  
        r1 = arg1.toString().split(".")[1].length;  
    }catch (e) {  
        r1 = 0;  
    }  
    try {  
        r2 = arg2.toString().split(".")[1].length;  
    }catch (e) {  
        r2 = 0;  
    }  
    m = Math.pow(10, Math.max(r1, r2));  
     //动态控制精度长度  
    n = (r1 >= r2) ? r1 : r2;  
    return ((arg1 * m - arg2 * m) / m).toFixed(n);  
} 

function click(){
	$(".cos_add").click(function(){
		var count = $(this).parents("tr").attr("data-num");
		count++;
		$(this).siblings(".numbox").text(count);
		$(this).parents("tr").attr("data-num",count);
		var comPrice = $(this).parents("tr").attr("data-commodityPrice");
		var amount = parseFloat(count * comPrice);
		$(this).parents("tr").find('#comAmount').html(amount);
		var comAmount = $('#payAmount').html();
		$('#payAmount').html(accAdd(comAmount,comPrice));
	});
	$(".cos_less").click(function(){
		var count = $(this).parents("tr").attr("data-num");
		if(count<=1){alert("购买数量不能小于1！");return ;}
		count--;
		$(this).siblings(".numbox").text(count);
		$(this).parents("tr").attr("data-num",count);
		var comPrice = $(this).parents("tr").attr("data-commodityPrice");
		var amount = parseFloat(count * comPrice);
		$(this).parents("tr").find('#comAmount').html(amount);
		var comAmount = $('#payAmount').html();
		$('#payAmount').html(Subtr(comAmount,comPrice));
	});
	$(".del").click(function(){
		var id = $(this).parents("tr").attr("data-id");
		var commodityTitle = $(this).parents("tr").attr("data-commodityTitle");
		var commodityPrice = $(this).parents("tr").attr("data-commodityPrice");
		$(this).parents("tr").remove();
		$('#'+id+'shopul').show();
		var amount = $(this).parents("tr").find('#comAmount').html();
		var comAmount = $('#payAmount').html();
		$('#payAmount').html(Subtr(comAmount,amount));
		$('.shopul').html($('.shopul').html()+'<li id ="'+id+'shopul">'+commodityTitle+'&nbsp;&nbsp;<span class="cc">'+
				commodityPrice+'</span>&nbsp;元/次&nbsp;<div class="shop0" data-id="'+id+
				'"data-commodityTitle="'+commodityTitle+
				'"data-commodityPrice="'+commodityPrice+'"></div></li>');
		
		$(".shop0").click(function(){
			var id = $(this).attr("data-id");
			var commodityTitle = $(this).attr("data-commodityTitle");
			var commodityPrice = $(this).attr("data-commodityPrice");
			$('#shopCar').html($('#shopCar').html()+'<tr data-id="'+id+'" data-num="1" data-commodityPrice="'+commodityPrice+
			'" data-commodityTitle="'+commodityTitle+'"><td class="">'+commodityTitle+'</td><td><span class="cc">'+commodityPrice+'</span>&nbsp;元/次</td><td>'+
			'<div class="inline_b" style="overflow:hidden;margin-top:5px"><div class="cos_less">-</div><div class="numbox">1</div>'+
			'<div class="cos_add">+</div></div></td><td><span class="cc" id="comAmount">'+commodityPrice+
			'</span>&nbsp;元</td><td></td><td><a class="del" style="cursor:pointer">删除</a></td></tr>');
			
			var comAmount = $('#payAmount').html();
			$('#payAmount').html(accAdd(comAmount,commodityPrice));
			$('#'+id+'shopul').remove();
			click();
		});
		
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
	var serviceURL = baseUrl+"purchasingmanagerCommodityManager/getLawSerCommodityList.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.records){
				var htmls = [];
				var htmlss = [];
				for(var i=0;i<results.records.length;i++){
					if(i==0){
						htmls.push('<span class="span_bold f20">'+results.records[i].commodityTitle+'</span><p class="f13 c3 mt20 mb20">'+
								results.records[i].commodityDescribe+'</p>'+
								'<span class="span_bold f20">&yen;'+results.records[i].commodityPrice+'</span><p class="caaa mt10 mb10">（服务期：'+
								results.records[i].lawserver.serTerm+'）</p>'+
								'<a href="javascript:;" class="btn-cheng inline_b law_pop" data-id="'+
								results.records[i].commodityId+'" data-commodityTitle="'+results.records[i].commodityTitle+
								'" data-commodityPrice="'+results.records[i].commodityPrice+'">立即购买</a>');
						htmlss.push('<li id ="'+results.records[i].commodityId+'shopul">'+results.records[i].commodityTitle+
								'&nbsp;&nbsp;<span class="cc">'+results.records[i].commodityPrice+
								'</span>&nbsp;元/次&nbsp;<div class="shop0" data-id="'+results.records[i].commodityId+
								'"data-commodityTitle="'+results.records[i].commodityTitle+
								'"data-commodityPrice="'+results.records[i].commodityPrice+'"></div></li>');
					}
				}
				$('.layer').html(htmls.join(''));
				$('.shopul').html(htmlss.join(''));
			}
			$(".nav_1,.navsub").hover(function(){
				$(".navsub").show();
			},function(){
				$(".navsub").hide();
			});
			/**/
			var $layer=$(".pop_layer");
			$(".law_pop").click(function(){
				if(!isLogin){
				   $(".bg-tanc.m2").show();
				 	 return;
				}
				var id = $(this).attr("data-id");
				var commodityTitle = $(this).attr("data-commodityTitle");
				var commodityPrice = $(this).attr("data-commodityPrice");
				$('#shopCar').html('<tr data-id="'+id+'" data-num="1" data-commodityPrice="'+commodityPrice+'" data-commodityTitle="'+commodityTitle+
				'"><td class="">'+commodityTitle+'</td><td><span class="cc">'+commodityPrice+'</span>&nbsp;元/次</td><td>'+
				'<div class="inline_b" style="overflow:hidden;margin-top:5px"><div class="cos_less">-</div>'+
				'<div class="numbox">1</div><div class="cos_add">+</div></div></td><td><span class="cc" id="comAmount">'+commodityPrice+
				'</span>&nbsp;元</td><td></td><td><a class="del" style="cursor:pointer">删除</a></td></tr>');
				
				$('#payAmount').html(commodityPrice);
				$('#'+id+'shopul').remove();
				$layer.show();
				click();
			});
			$(".shop0").click(function(){
				var id = $(this).attr("data-id");
				var commodityTitle = $(this).attr("data-commodityTitle");
				var commodityPrice = $(this).attr("data-commodityPrice");
				$('#shopCar').html($('#shopCar').html()+'<tr data-id="'+id+'" data-num="1" data-commodityPrice="'+commodityPrice+
				'" data-commodityTitle="'+commodityTitle+'"><td class="">'+commodityTitle+'</td><td><span class="cc">'+commodityPrice+'</span>&nbsp;元/次</td><td>'+
				'<div class="inline_b" style="overflow:hidden;margin-top:5px"><div class="cos_less">-</div><div class="numbox">1</div>'+
				'<div class="cos_add">+</div></div></td><td><span class="cc" id="comAmount">'+commodityPrice+
				'</span>&nbsp;元</td><td></td><td><a class="del" style="cursor:pointer">删除</a></td></tr>');
				
				var comAmount = $('#payAmount').html();
				$('#payAmount').html(accAdd(comAmount,commodityPrice));
				$('#'+id+'shopul').remove();
				click();
			});
			$(".pop_back").click(function(){
				$layer.hide();
			});
			$("i.fa").click(function(){
				$(this).toggleClass("fa-check-square-o").toggleClass("fa-square-o");
			});
			/**/
			$(".blend_ul>li").click(function(){
				var index=$(this).index();
				$(this).addClass("active").siblings("li").removeClass("active");
				$(".blend_item").eq(index).show().siblings(".blend_item").hide();
			});
		}
	});
	
	/**/
	star(".starbox1 i");
	star(".starbox2 i");
	star(".starbox3 i");
	star(".starbox4 i");
	
	$('#btn-sumbit').click(function(){
		if(!isLogin){
		   $(".bg-tanc.m2").show();
		 	 return;
		}
		var length = $('#shopCar').children("tr").length;
		var params = '';
		for(var i =0;i<length;i++){
			var object = $('#shopCar').children("tr").get(i);
			var commodityId = object[attribute = 'attributes'][attribute = 'data-id'][attribute = 'value'];
			var num = object[attribute = 'attributes'][attribute = 'data-num'][attribute = 'value'];
			if(i+1<length){
				params = params+$.youi.parameterUtils.propertyParameter("records["+i+"].commodityId.commodityId",commodityId)+"&";
				params = params+$.youi.parameterUtils.propertyParameter("records["+i+"].commoditydetailNum",num)+"&";
			}else{
				params = params+$.youi.parameterUtils.propertyParameter("records["+i+"].commodityId.commodityId",commodityId)+"&";
				params = params+$.youi.parameterUtils.propertyParameter("records["+i+"].commoditydetailNum",num);
			}
		}
		var serviceURL = baseUrl+"ordermanagerUserorderManager/saveLawSerOrder.json";
		
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
	var genreCode = "0505";
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
	$('#evaluate').click(function(){
		if(!isLogin){
		   $(".bg-tanc.m2").show();
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
		   $(".bg-tanc.m2").show();
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