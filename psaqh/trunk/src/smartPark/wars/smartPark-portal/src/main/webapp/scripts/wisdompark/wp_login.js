$(function(){
		$(".tj_radio").click(function(){
			$(this).toggleClass("fa-square-o").toggleClass("fa-check-square-o").siblings("i").addClass("fa-square-o").removeClass("fa-check-square-o");
		});
		$("#closer").click(function(){
			$(".pop_layer").hide();
		});
		$("#tj_pop").click(function(){
			$(".pl2").show();
		});
		$(".close0").click(function(){
			$(".pl1").hide();
		});
		$("#clo").click(function(){
			clearInterval(timer2);
		}) ;
		 //选时间
		$("#lf_time").on("click",function(e){
            e.stopPropagation();
            $(this).next(".time-nav").toggle();               
        });
        $(".time-nav").on("click","li",function(){
            $(this).addClass("selected").siblings().removeClass("selected");
            var selecttext=$(this).text();
            var val=$(this).attr("data-val");
            $("#lf_time").val(selecttext).attr("data-val",val); 
            $(this).parents(".time-nav").hide();

        }); 
        laydate({
		    elem: '#fkcodeDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		$("body").bind("click", function(){
            $(".time-nav").hide();
        });
		
		$(".btn-chengk").click(function(){
			var roomId = $(".roomId").text() ;
			if(roomId == null || roomId == ""){
				close("请选择一个有效单元！") ;
			}else{
				$(".bg-tanc.n1").show() ;
			}
		}) ;
		
		function clear(){
			$("#name_1").val("") ;
			$("#mobile_1").val("") ;
			$("#fkcodeDate").val("") ;
			$("#lf_time").val("") ;
			$(".bg-tanc.n1").hide();
		}
		
		$(".submit3").click(function(){
			var lf_name = $("#name_1").val() ;
			var lf_tel = $("#mobile_1").val() ;
			var lf_date = $("#fkcodeDate").val() ;
			var lf_time = $("#lf_time").val() ;
			var roomId = $(".roomId").text() ;
			
			if(lf_name.trim() == ""){
				showMessage("姓名不能为空！") ;
				return ;
			}
			if(lf_tel.trim() == ""){
				showMessage("手机号不能为空！") ;
				return ;
			}
			var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
			if(! isMobile.test(lf_tel)){
				showMessage("请输入正确的手机号！");
				return ;
			}
			if(lf_date.trim() == ""){
				showMessage("来访日期不能为空！") ;
				return ;
			}
			if(lf_time.trim() == ""){
				showMessage("来访时间不能为空！") ;
				return ;
			}
			$(".submit3").addClass("undis") ;
			$(".submit4").removeClass("undis") ;
			var params=["recordCommdityId="+roomId,"visiteDate="+lf_date,
			            "visiteTime="+lf_time,"visiteTel="+lf_tel,
			            "visiteName="+lf_name,"recordType="+"03"] ;
			var serviceURL = baseUrl+ "reservationRecordManager/saveReservationRecord.json";
			//公共方法
			$.youi.ajaxUtils.ajax({
				url : serviceURL,
				data : params.join('&'),
				jsonp : 'data:jsonp',
				dataType : 'jsonp',
				success : function(result) {
					$(".submit3").removeClass("undis") ;
					$(".submit4").addClass("undis") ;
					if (result && result.record) {
						if (isLogin) {
							clear();
							$(".bg-tanc.m1").show();
							$('#ti-m1').text('5');
							b = 5;
							timer2 = setInterval("jump2()",1000);
						} else {
							clear() ;
							$(".pl1").show();
							a = 3;
							timer1 = setInterval("jump1()",1000);
						}
					}
				},error:function(XMLHttpRequest, textStatus, errorThrown){
					$(".submit3").removeClass("undis") ;
					$(".submit4").addClass("undis") ;
				}
			});
			
		}) ; 
		
	});

	 //跳转个人中心
	 function jumpPerson(){
	 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
	 }
	 //跳转首页
	 function jumpIndex(){
	 	window.location.href=cenUrl;
	 }
		
	 //显示信息
    function showMessage(message){
     	$(".error-toast").animate({top:"20px",opacity:"1"});
     	$(".error-toast p").html(message);
 		setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
     }
	 
    var a,timer1;
	function jump1() {
		if (a > 1) {
			a--;
			$("#ti-m1").text(a);
		} else {
				$(".pl1").hide();
		}
	}
	var b,timer2;
	function jump2() {
		if (b > 1) {
			b--;
			$("#ti-m1").text(b);
		} else {
			window.location = cenUrl+ "member/memberCenter/personalCenter/myReservation.html?showFlg=1";
		}
	}

	//跳转我的预约
	function jumpOrder() {
		window.location = cenUrl
				+ "member/memberCenter/personalCenter/myReservation.html";
	}
	//返回
	function jumpBack() {
		window.location = "index.html";
	}
	$(function(){
		$(".mhbg").hide() ;
		$("#loading").removeClass("undis") ;
		var floorId = "" ;
		floorId = getParam() ;
		var params = ["floorId="+floorId];
		$.youi.ajaxUtils.ajax({
			url:baseUrl +"bbmFloorManager/getInforByFloorId.json",//通过楼层ID获取要用的信息
			data:params.join('&'),
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				//console.log(result) ;
				$(".into_tit").text(result.record.html) ;
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"bbmFloorManager/getRoomByFloorId.json",//通过楼层ID获取对应的楼层单元
					data:params.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						 if(result&&result.records){
							_parseRecords(result.records) ; 
							appendHtml() ;
						} 
					}
				}); 
			}
		}); 
		
		//关闭事件
		
		$("#close").click(function(){
			$(".toast").hide();
		})
		
		//推荐提交事件
		$(".submit1").click(function(){
			if(!isLogin){
				$("#msg").html("请登录后重试！");
				$(".toast").show();
				setTimeout('$(".toast").hide();',2000);
				return;
			}
			$("#disName").hide();
			$("#disPhone").hide();
			var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
			var name = $("#name").val();
			if(name==''){
				$("#disName").show();
				return false;
			}
			var phone = $("#phone").val();
			if(phone==''){
				$("#disPhone").html("手机号码不能为空");
				$("#disPhone").show();
				return false;
			}else{
				if(! isMobile.test(phone)){
					$("#disPhone").html("请填写正确手机号");
					$("#disPhone").show();
					return false;
				} 
			}		
			var memRole = $("#memRole").val();
			var memSex = "0";
			$("#sex").find("i").each(function(){
				if($(this).attr("class")=="fa tj_radio fa-check-square-o"){
					memSex = $(this).attr("data");
					return false;
				}
			})
			
			var obj = ['memberPhoneNumber='+phone] ;
			/* 判断手机号是否已经注册! */
			$.youi.ajaxUtils.ajax({
				url:baseUrl + "memberInformationManager/exsitMobile.json",
				data:obj.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
				 	var flag = result.record.flag ;//获取返回值
					if(flag == true){
						alert("此手机号已经注册了！");
						return ;
					}else{
						$(".submit1").addClass("undis") ;
						$(".submit2").removeClass("undis") ;
						var remark = $("#remark").val();
						var stringData="memName="+name+"&"+"memPhone="+phone+"&"+"memRole="+memRole+"&"+"memSex="+memSex+"&"+"remark="+remark;
						var serviceURL = baseUrl+"recommendMemberManager/saveRecommendMember.json";
						$(this).html("提交中...");
						$.youi.ajaxUtils.ajax({
							url:serviceURL,
							data:stringData,
							jsonp:'data:jsonp',
							dataType:'jsonp',
							success:function(result){
								$(".submit1").removeClass("undis") ;
								$(".submit2").addClass("undis") ;
								$(this).html("提交");
								$("#msg").html("预约成功！");
								$(".toast").show();
								setTimeout('$(".toast").hide();',2000);
								$(".pl2").hide();
								$("#name").val('');
								$("#remark").val('');
								$("#memRole").val('');
								$("#phone").val('');
							},error:function(XMLHttpRequest, textStatus, errorThrown){
								$(".submit1").removeClass("undis") ;
								$(".submit2").addClass("undis") ;
								alert(XMLHttpRequest);
							}
						});
					}
				}
			});
			
			
		});
		
	}); 
	function getParam() { 
		var url = document.URL ; //获取页面的URL
		var param = "" ;  
		param = url.substring(url.lastIndexOf("=")+1,url.length) ; //获取页面的参数
		return param ;
	}
	function _parseRecords(record){//record为单元的list
		$(".hxpic >div").each(function(i){
				var roomNum = $(this).attr("title") ;//得到当前div的编号
				var room = roomByNo(record,roomNum) ;
				if(room){
					console.log(room) ;
					var status = room.saleState ;
					if(status == '00'){//00表示未售
						$(this).addClass("bgred") ;
						$(this).attr("id",room.roomId) ;
					}else if(status == '01'){//01表示已售未招
						$(this).addClass("bgyellow") ;
						$(this).attr("id",room.roomId) ;
					}else if(status == '02'){//02表示已售已招
						$(this).addClass("bggreen") ;
						$(this).attr("id",room.roomId) ;
					}else{
						$(this).addClass("bg-3c") ;
						$(this).attr("id","") ;
					}
				} else{
					$(this).addClass("bg-3c") ;
					$(this).attr("id","") ;
				}  
		});
		$("#loading").addClass("undis") ;
		$(".mhbg").show() ;
	} 
	
 	function appendHtml(){
		$(".hxpic >div").each(function(i){
			$(this).click(function(){
				var roomId = $(this).attr("id");
				var html = "" ;
				if(roomId){
					$("#loading").removeClass("undis") ;
					var params=[
						         "roomId="+roomId
						       ];
					$.youi.ajaxUtils.ajax({
						url:baseUrl +"bbmRoomManager/getRoomByRoomId.json",
						data:params.join('&'),
						jsonp:'data:jsonp',
						dataType:'jsonp',
						success:function(results){
							var record = results.record ;
							//console.log(record) ;
							if(record.saleState == "02"){//02表示已售已招
								
								$("#ws").addClass("undis") ;
								$("#ys").removeClass("undis") ;
								var rzId = record.rzId ;
								if(rzId == null){
									$("#rzName").text("") ;
								}else{
									var params=["rzId="+rzId];
									$.youi.ajaxUtils.ajax({
										url:baseUrl +"enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json",
										data:params.join('&'),
										jsonp:'data:jsonp',
										dataType:'jsonp',
										success:function(results){
											var rz = results.record ;
											var rzName = rz.rzName ;
											var id = rz.rzId ;
											//console.log(rzName) ;
											$("#rzName").text(rzName) ;
											$("#rzName").attr("href","../industrydatabase/industry.html?id="+id) ;
											$("#ck").attr("href","../industrydatabase/industry.html?id="+id) ;
										}
									});
								}
							}else{
								$("#ys").addClass("undis") ;
								$("#ws").removeClass("undis") ;
							}
							$("#loading").addClass("undis") ;
							if(record.roomNo){
								$(".roomNo").text(record.roomNo) ;
							}else{
								$(".roomNo").text("") ;
							}
							if(record.roomId){
								$(".roomId").text(record.roomId) ;
							}else{
								$(".roomId").text("") ;
							}
							if(record.area){
								$(".area").text(record.area+" 平方米") ;
							}else{
								$(".area").text("") ;
							}
							if(record.aspect){
								$(".aspect").text(record.aspect) ;
							}else{
								$(".aspect").text("") ;
							}
							if(record.roomModule){
								$(".module").text(record.roomModule) ;
							}else{
								$(".module").text("") ;
							}
							if(record.furnish){
								$(".furnish").text(record.furnish) ;
							}else{
								$(".furnish").text("") ;
							}
							if(record.salesPrice){
								$(".price").text(record.salesPrice+"/月") ;
							}else{
								$(".price").text("") ;
							}
						}
					});
				}else{
					//$(".roomId").text("") ;
					$("#roomNo").text("") ;
					$("#area").text("") ;
					$("#aspect").text("") ;
					$("#module").text("") ;
					$("#furnish").text("") ;
					$("#price").text("") ;
					close("暂时还没有该单元的信息哦！") ;
				}
			});
		});
		
	}
	
	function roomByNo(record,roomNum){//通过div编号得到对应的room
		for(var i=0;i<record.length;i++){
			var room = record[i] ;//得到当前单元
			var roomNo = room.roomNo ;//得到当前单元编号
			var num = roomNo.lastIndexOf("-");
			roomNo = roomNo.substring(num+1) ;//得到当前编号的后两位
			if(roomNo == roomNum){
				return record[i] ;
			}
		}
	}
	
	var pltime,timer;
    function closeTanc(){
        if(pltime>1){
            pltime--;
        }else{
            $(".toast").hide();
        }       
    }
    function close(content){
        clearInterval(timer);
        $(".tc.mt25.f18").empty() ;
        $(".tc.mt25.f18").append(content);
        $(".toast").show();
        pltime=1;
        timer=setInterval("closeTanc()",1000);
    	}