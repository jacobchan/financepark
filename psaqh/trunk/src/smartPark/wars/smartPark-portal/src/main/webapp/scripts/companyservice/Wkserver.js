
var genreCode = "0507";
//评论星级
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
//添加购物车并跳转到购物车页面
function addShopCar(id){
	var serviceURL = baseUrl+"shoppingcarCompanyserverManager/addShoppingcarCompanyserver.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{commodityId:id},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.record){
				window.location.href="/companyservice/shoppingcart.html";
			}
		}
	});
};
//页面加载方法
$(function(){
	$(".tab_ul li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings("li").removeClass("active");
		$(".tabbox").eq(index).show().siblings(".tabbox").hide();
	});
	/**/
	$(".nav_1,.navsub").hover(function(){
		$(".navsub").show();
	},function(){
		$(".navsub").hide();
	});
	/**/
	$(".blend_ul>li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings("li").removeClass("active");
		$(".blend_item").eq(index).show().siblings(".blend_item").hide();
	});
	/**/
	$(".add_ul").on("click","li",function(){
		var html=$(this).remove();
		$(".yet_ul").append(html);
	});
	
	/**/
	star(".starbox1 i");
	star(".starbox2 i");
	star(".starbox3 i");
	star(".starbox4 i");
	
	//商品展示
	var serviceURL = baseUrl+"purchasingmanagerCommodityManager/getWkserverCommodityList.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.records){
				var htmls = [];
				for(var i=0;i<results.records.length;i++){
					htmls.push('<li style="background:url('+cenUrl+'common/uploadImage.html?repository=/swfupload&path='+
							results.records[i].commodityImage+'&method=show) no-repeat;"><div class="layer_zz"></div><div class="bgfff">'+
							'<span class="cc">&yen;'+results.records[i].commodityPrice+'</span><div class="clearfix">'+
							'<span class="fl">'+results.records[i].commodityTitle+'</span><a href="javascript:;" class="fr com_shop" data-id="'+
							results.records[i].commodityId+'"><img src="../styles/images/company/shopcar.png"/></a></div></div></li>');
				}
				$('.com_ul').html(htmls.join(''));
			}
			$(".com_shop").click(function(){
				if(!isLogin){
				   $(".bg-tanc.m2").show();
				 	 return;
				}
				var id = $(this).attr("data-id");
				addShopCar(id);
			});
		}
	}); 
	//评论列表展示
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
	//评论提交方法
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
	//咨询提交方法
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