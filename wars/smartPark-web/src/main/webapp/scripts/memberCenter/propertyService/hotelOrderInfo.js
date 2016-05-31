	//弹窗
	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){location.reload(); },2000);
			
      }
    $(function(){					
    	var Request = new Object();
		Request = GetRequest();
		var orderNo =Request['orderNo'];
		var mobile = Request['mobile'];
		$.ajax({
				url:baseUrl+'hotelOrderService/getOrderInfo.json',
				data:'orderid='+orderNo,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						$("#orderNo").html(record.orderid);
						$("#hotelname").html(record.hotelname);
						$("#tm1").html(record.rztm1);
						$("#tm2").html(record.rztm2);
						$("#xinghao").html(record.xinghao);
						$("#totalprice").html(record.z_price);
						$("#roomsNum").html(record.rooms);
						$("#rzname").html(record.rzname);
						$("#rzmobile").html(mobile);
						$("#orderState").html(record.orderstatus);
						$("#iscard").html(record.iscard==0?"否":"是");
						$("#cardstatus").html(record.cardstatus);
						}
					}
			}); 
		});
    //获取传递的参数
    function GetRequest() {
		/* url=decodeURI(location.href);
		var tmp1=url.split("?")[1]; */
		var url = decodeURI(location.search); //获取url中"?"符后的字串
		var theRequest = new Object();
		if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			for (var i = 0; i < strs.length; i++) {
				theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
			}
		}
		return theRequest;
	}
	//确认取消弹窗
	function cancel(){	
		$(".bg-tanc.m1").show();
	};	
	//取消
	$(function(){
		$(".hhf-submit.confirm").click(function(){
			$(".bg-tanc.m1").hide(100);
				var arg=getQueryStringArgs();
		        var cosId =arg.cosId;
			 	$.youi.ajaxUtils.ajax({
			 		url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
					data:'cosId='+cosId,
					success:function(result){
						if(result&&result.record){
							close("取消成功!");														
						}
					}
				});
			});
		
	});
	
	
	    //点击返回
		  function oc_goBack(){
			 window.location.href = cenUrl+"member/memberCenter/personalCenter/hotelOrders.html";
			 
		}; 