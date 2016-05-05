	//待处理订单
		function jump0(){
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/orderCenterPend.html");  
		}
		//历史订单
		function jump1(){
		    $("#loadData").load(cenUrl+"member/memberCenter/personalCenter/orderCenterHospital.html");  
		}
		
		$(function(){
			$(function () {
				$(".order-nav li").click(function(){
					$(this).addClass("active").siblings().removeClass("active");			
				})		
			})
			//页面默认加载待处理订单
			if(getRequest()=="1"){
				$(".order-nav li").eq(0).addClass("active").siblings().removeClass("active");
				jump1();
			}else if(getRequest()=="2"){
				$(".order-nav li").eq(1).addClass("active").siblings().removeClass("active");
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
		//订单中心详情跳转
		function viewOrder(userorderCode,genreCode){
			if(genreCode == "0301"){//会议室
				window.location.href=cenUrl+"member/memberCenter/personalCenter/meetingRoomOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0302"){//车辆
				window.location.href=cenUrl+"member/memberCenter/personalCenter/carOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0303"){//广告位
				window.location.href=cenUrl+"member/memberCenter/personalCenter/adsenseOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0304"){//预留停车位
				window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderCode="+userorderCode;
			}else if(genreCode == "0501"){//公司注册
				window.location.href=cenUrl+"member/memberCenter/personalCenter/companyRegistOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0502"){//工商变更
				window.location.href=cenUrl+"member/memberCenter/personalCenter/BusinesschangeOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0503"){//人事社保
				window.location.href=cenUrl+"member/memberCenter/personalCenter/socialSecurityOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0504"){//代理记账
				window.location.href=cenUrl+"member/memberCenter/personalCenter/bookkeepingOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0505"){//法律服务
				//window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderCode="+userorderCode;
			}else if(genreCode == "0506"){//商标专利
				window.location.href=cenUrl+"member/memberCenter/personalCenter/trademarkPatentOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0507"){//威客服务
				window.location.href=cenUrl+"member/memberCenter/personalCenter/wkServiceOrderDetails.html?userorderCode="+userorderCode;
			}else if(genreCode == "0508"){//IT服务
				window.location.href=cenUrl+"member/memberCenter/personalCenter/ITServiceOrderDetails.jsp.html?userorderCode="+userorderCode;
			}/* else if(genreCode == "0401"){//创立方
				window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderCode="+userorderCode;
			}else if(genreCode == "0601"){//物业报修
				window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderCode="+userorderCode;
			}else if(genreCode == "0602"){//物业缴费
				window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderCode="+userorderCode;
			}else if(genreCode == "02"){//园区饮食
				window.location.href=cenUrl+"member/memberCenter/personalCenter/orderCarNum.html?userorderCode="+userorderCode;
			} */
			 
		};