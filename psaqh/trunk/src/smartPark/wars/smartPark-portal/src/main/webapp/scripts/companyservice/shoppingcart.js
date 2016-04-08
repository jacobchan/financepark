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
//修改购物车
function modify(id,num){
	var serviceURL = baseUrl+"shoppingcarCompanyserverManager/modifyShopCar.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{id:id,num:num},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			
		}
	}); 
}
//删除购物车
function delShopCar(id){
	var serviceURL = baseUrl+"shoppingcarCompanyserverManager/delShopCar.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{id:id},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			
		}
	}); 
}
//单选
function singleCheck(){
	var i=0;
    var amount = 0;
    $('input[name="single-check"]').each(function(){
        if($(this).prop("checked")){
        	 amount = accAdd(amount,$(this).parents("tr").find('#comAmount').html());
           i++;
        }else{
         i;
        }
    });
    $('.ccheng').html('¥'+amount);
    $("#all-num").text(i);
    if(i== $('input[name="single-check"]').length){
        $('.cg-pay-table').find('input[name="all-check"]').prop("checked","checked");
     }else{
    	 $('.cg-pay-table').find('input[name="all-check"]').prop("checked","");
    }
}
function click(){
	 //减1
    $(".space-num .num-reduce").click(function(){
    	var id = $(this).parents("tr").attr("data-id");
        var n=parseInt($(this).next("input").val());
        if(n>0){
            $(this).next("input").val(n-1);
            modify(id,n-1);
            var comPrice = $(this).parents("tr").attr("data-commodityPrice");
			var amount = parseFloat((n-1) * comPrice);
			$(this).parents("tr").find('#comAmount').html(amount);
			var amount = 0;
            $('input[name="single-check"]').each(function(){
	           	 amount = accAdd(amount,$(this).parents("tr").find('#comAmount').html());
	        });
            $('.ccheng').html('¥'+amount);
        }else{
            alert("已经是0了");
        }
    });
    //加1
    $(".space-num .num-plus").click(function(){
    	var id = $(this).parents("tr").attr("data-id");
        var n=parseInt($(this).prev("input").val()) ;
        if(n<100 && n>-1){
            $(this).prev("input").val(n+1);
            modify(id,n+1);
            var comPrice = $(this).parents("tr").attr("data-commodityPrice");
			var amount = parseFloat((n+1) * comPrice);
			$(this).parents("tr").find('#comAmount').html(amount);
			var amount = 0;
            $('input[name="single-check"]').each(function(){
	           	 amount = accAdd(amount,$(this).parents("tr").find('#comAmount').html());
	        });
            $('.ccheng').html('¥'+amount);
        }else if(n==100){
            alert("最大值了");
        }
    });

    //全选
    $('input[name="all-check"]').click(function(){
        if($(this).prop("checked")){
            $(this).parents(".cg-pay-table").find('input[name="single-check"]').prop("checked","checked");
            var l=$(this).parents(".cg-pay-table").find('input[name="single-check"]').length;
            $("#all-num").text(l);
            var amount = 0;
            $('input[name="single-check"]').each(function(){
	           	 amount = accAdd(amount,$(this).parents("tr").find('#comAmount').html());
	        });
            $('.ccheng').html('¥'+amount);
        }else{
            $(this).parents(".cg-pay-table").find('input[name="single-check"]').prop("checked","");
            $("#all-num").text(0);
            $('.ccheng').html('¥0.00');
        }
        
        
    });
    //单选
    $('input[name="single-check"]').click(function(){
    	singleCheck();
    });

    //删除这一排
    $(".a-del").click(function(){
        $(this).parents("tr").remove();
        var id = $(this).parents("tr").attr("data-id");
        delShopCar(id);
        singleCheck();
    });

    //删除所选
    $(".del-check").click(function(){
        $('input[name="single-check"]').each(function(){
            if($(this).prop("checked")){
                $(this).parents("tr").remove();
                var id = $(this).parents("tr").attr("data-id");
                delShopCar(id);
            }
        });
        singleCheck();
    });
}
$(function(){
  //购物车展示
	var genreCode = "0507";
	var serviceURL = baseUrl+"shoppingcarCompanyserverManager/getShopCarList.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{genreCode:genreCode},
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(results){
			if(results&&results.records){
				var htmls = [];
				for(var i=0;i<results.records.length;i++){
					if(i == 0){
						htmls.push('<tr><th colspan="2" style="text-align:left"><label><input type="checkbox" class="ml5 mr10" name="all-check">全选</label></th>'+
								' <th style="text-align:left">商品</th><th>单价</th><th>数量</th><th>小计（元）</th><th>操作</th></tr><tr>');
					}
					var image = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+results.records[i].commodityId.commodityImage+"&method=show";
					htmls.push('<tr name="shop_car" data-id="'+results.records[i].companyServerId+'" data-commodityPrice="'+results.records[i].commodityId.commodityPrice+
							'"><td align="right"><input type="checkbox"  name="single-check"></td>'+
							' <td style="padding-left:0px;"><img src="'+image+'" width="84" height="84"></td>'+
							'<td align="left"><div class="w70 fl pr20">'+results.records[i].commodityId.commodityTitle+'</div></td><td>'+
							results.records[i].commodityId.commodityPrice+'</td><td><div class="space-num"><a href="javascript:;" class="num-reduce">-</a>'+
							'<input class="num" value="'+results.records[i].companyCateringNum+'" type="text"><a href="javascript:;" class="num-plus">+</a>'+
							'</div></td><td id="comAmount">'+results.records[i].companyCateringUnivalence+'</td>'+
							'<td><p class="mb10"><a href="javascript:;" class="a-del">删除</a></p></td></tr>');
				}
				$('#shoppingcart').html(htmls.join(''));
			}
			click();
		}
	}); 
	//提交订单
	$('#settlement').click(function(){
		var i=0;
		var params = '';
		$('tr[name="shop_car"]').each(function(){
			var id = $(this).attr("data-id");
			if(i > 0){
				params = params+"&";
			}
			params = params+$.youi.parameterUtils.propertyParameter("records["+i+"].companyServerId",id);
			i++;
        });
		
		var serviceURL = baseUrl+"shoppingcarCompanyserverManager/saveWKserviceOrder.json";
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			data:params,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				if(results&&results.record){
					alert('订单提交成功！');
					window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
				}
			}
		});
	});
});