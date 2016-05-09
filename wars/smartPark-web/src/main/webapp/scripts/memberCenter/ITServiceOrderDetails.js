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
				var describe="";
				$('#userorderCode').html("订单号："+record.userorderCode);
				$('#userorderStatus').html(record.status);
				$('#userorderTime').html(record.userorderTime.substring(0,10));
				/*if("预约单次"==record.userorderProject){
					describe="<p>服务描述：</p><p>7*24小时服务，随叫随到，专业技术团队，价格透明，服务一流</p><p>优惠报价： ¥67/次 （服务范围仅限软件维护，若涉及硬件则另收费）</p>";
				}else if("预约单次"==record.userorderProject){
					describe="<p>服务描述：</p><p>设备数量<10台7*24小时服务按月巡检备份支持耗材配送</p>";
				}	
				$('#userorderProject').html(describe);*/
				$('#userorderProject').html("订单项目："+record.userorderProject);
				$('#userorderAmount').html(record.userorderAmount+"元");
				//$('#publicResoIdDate').html(record.mettingOrder.userorderTime.substring(0,10));
			}
		}
	});
});

