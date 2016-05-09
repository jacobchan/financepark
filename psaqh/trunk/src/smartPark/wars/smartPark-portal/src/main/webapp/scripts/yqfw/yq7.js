  function openURL(url){
		   if(!isLogin){
			   clearInterval(timer);
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000);
			 	 return false;
			}
		   if(url=='0'){
		  	 window.location=cenUrl+"member/memberCenter/propertyService/propertyManageCharge.html";
		   }else if(url=='4'||url=='6'||url=='8'||url=='10'){
			 //判断是否是企业员工
				$.youi.ajaxUtils.ajax({
				url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.record){
						window.location="yq"+url+".html";
						}else{
							clearInterval(timer);
							$(".tc.mt25").text("您不是企业用户,暂时无法申请!");
				           	$(".toast").show();
				           	pltime=2;
				           	timer=setInterval("closeTanc()",1000);
						}
					}
				});
		   }else if(url=='9'){
			   window.location="yq"+url+".html";
		   }else{
			   	clearInterval(timer);
				$(".tc.mt25").text("敬请期待!");
	           	$(".toast").show();
	           	pltime=2;
	           	timer=setInterval("closeTanc()",1000);
		   }
			   
	  };
 </script>
 <script type="text/javascript">
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
		 //调用方法如下，哪里调用就放哪里
		 /**
		     clearInterval(timer);
		     $(".toast").show();
		     pltime=1;
		     timer=setInterval("closeTanc()",1000);
		 */