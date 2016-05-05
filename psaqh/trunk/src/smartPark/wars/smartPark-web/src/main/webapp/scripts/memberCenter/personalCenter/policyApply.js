		//政策申请
		function jump0(){
			$("#actionUrl").attr("href",proUrl + "zscenter/zs3.html");
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/policyApplyMyApplication.html");  
		}
		//创业加速申请
		function jump1(){
			$("#actionUrl").attr("href",proUrl + "czh/czh5.html?pUp=1");
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/policyApplySpEntrepreneurship.html");  
		}
		//融资申请
		function jump2(){
			$("#actionUrl").attr("href",proUrl + "czh/czh5.html?pUp=2");
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/policyApplyFinace.html");  
		}
		$(function(){
			$(function () {
				$(".order-nav li").click(function(){
					$(this).addClass("active").siblings().removeClass("active");			
				})		
			})
			//页面默认加载创业加速申请加载
			if(getRequest()=="1"){
				$(".order-nav li").eq(1).addClass("active").siblings().removeClass("active");
				jump1();
			}else if(getRequest()=="2"){
				$(".order-nav li").eq(2).addClass("active").siblings().removeClass("active");
				jump2();
			}else{
				$(".order-nav li").eq(0).addClass("active").siblings().removeClass("active");
				jump0();
			}
		});
		
		//获取链接后面的值
		function getRequest() {
			var url = location.search; //获取url中"?"符后的字串
			if (url.indexOf("?") != -1) { //判断是否有参数
				var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
				strs = str.split("="); //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
				return strs[1];
			}
		}
		 