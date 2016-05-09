$(function () {
        //关闭toast
        $(".close-toast").click(function(){
            $(".toast").hide();
        })
	})
	
	 var pltime,timer;
    function closeTanc(){
        if(pltime>1){
            pltime--;
        }else{
            $(".toast").hide();
        }       
    }

    //toast弹窗出来后，一秒自动关闭,请再调用弹窗toast的时候调用该方法
	   function openURL(url){
		   if(!isLogin){
			   clearInterval(timer);
			   $("#msg").text("请登录后重试！");
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000);
			 	 return;
			}
	        if(url=='5'){
			   window.location="yq"+url+".html?enteringType=01";
		    }else if(url=='1'||url=='14'||url=='15'||url=='16'){
				 //判断是否是企业员工
				$.youi.ajaxUtils.ajax({
				url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.record){
						if(url=='16'){
							   window.location="yq"+url+".html?enteringType=02";
						   }
				        if(url=='1'){
							   window.location="yq"+url+".html?enteringType=03";
						   }
				        if(url=='15'){
							   window.location="yq"+url+".html?enteringType=04";
						   }
				        if(url=='14'){
							   window.location="yq"+url+".html?enteringType=05";
						   }
						}else{
							clearInterval(timer);
							$("#msg").text("您不是企业用户,暂时无法申请!");
				           	$(".toast").show();
				           	pltime=2;
				           	timer=setInterval("closeTanc()",1000);
						}
					}
				});
		   }
			   
	  };