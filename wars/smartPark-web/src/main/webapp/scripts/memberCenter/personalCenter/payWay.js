function payReturn(sec,userorderCode){
			if(sec > 0){
				var serviceURL = baseUrl+"ordermanagerUserorderManager/getOrderByCode.json";
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:{userorderCode:userorderCode},
					success:function(results){
						if(results&&results.record){
							var record = results.record;
							if("01" == record.payStatus){
								$('#toast_text').html('支付成功！');
								$(".toast").show();
					            setTimeout('$(".toast").hide();',2000);//1秒=1000
					            setTimeout(function(){payWay_goBack();},2000);//1秒=1000
							}else{
								setTimeout(function(){payReturn(sec - 1,userorderCode);},2000);
							}
						}
					}
				});
			}else{
				$('#toast_text').html('支付超时！');
				$(".toast").show();
	            setTimeout('$(".toast").hide();',2000);//1秒=1000
	            setTimeout(function(){payWay_goBack();},2000);//1秒=1000
			}
		}
		//返回
		function payWay_goBack(){
			window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
		};
		$(function () {
			$(".order-nav li").click(function(){
				$(this).addClass("active").siblings().removeClass("active");
				$(".clearfix-box").hide();
				$(".clearfix-box").eq($(this).index()).show();
			})
			$(".ac-show").click(function(){
				$(".bg-tanc.m1").show();
			})
			$(".fs-btn").click(function(){
				$(".bg-tanc.m1").show();
			})
			var arg=getQueryStringArgs();
			var userorderCode = arg.userorderCode;
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'ordermanagerUserorderManager/getPayQrcodeByCode.json',
				data:{userorderCode:userorderCode},
				success:function(result){
					if(result && result.record){
						console.log(result.record);
						console.log(result.record.html);
						$("#qrcodeTable").html('');
						jQuery('#qrcodeTable').qrcode({
							render	: "table",
							text	: result.record.html
						});	
						payReturn(60,userorderCode);
					}
				}
			});
			var serviceURL = baseUrl+"ordermanagerUserorderManager/getOrderByCode.json";
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:{userorderCode:userorderCode},
				success:function(results){
					if(results&&results.record){
						var record = results.record;
						$('#userorderCode').html("订单编号："+record.userorderCode);
						$('#userorderGenreName').html("订单类型："+record.genreId.genreName);
						$('#userorderAmount').html(record.userorderAmount);
					}
				}
			});
		})