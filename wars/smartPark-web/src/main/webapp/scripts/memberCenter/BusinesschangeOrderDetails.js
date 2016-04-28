//返回
function orderDetails_goBack(){
	window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
};

$(function(){
	var arg=getQueryStringArgs();
	var userorderCode =arg.userorderCode;
	var serviceURL = baseUrl+"ordermanagerUserorderManager/getOrderByCode.json";
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		data:{userorderCode:userorderCode},
		success:function(results){
			if(results&&results.record){
				var record = results.record;
				$('#userorderCode').html("订单号："+record.userorderCode);
				$('#userorderStatus').html(record.status);
				$('#userorderTime').html(record.userorderTime);
				$('#userorderProject').html("订单项目："+record.userorderProject);
				$('#userorderAmount').html(record.userorderAmount+"元");
				$('#publicResoIdDate').html(record.mettingOrder.publicResoIdDate.substring(0,10));
			}
		}
	});
});

