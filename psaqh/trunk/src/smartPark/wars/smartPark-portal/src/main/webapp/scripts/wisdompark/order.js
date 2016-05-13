$(function(){
        //加载会议室
        roomDetail();
        
      //在线预约
		$("#online").click(function(){
			if(!isLogin){
				clearInterval(timer);
				$("#msg").text("请登录后重试！");
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000)
				return;
				}
			var commodityId= $("#commodityId").val();
			var dates=new Array();
			var times=new Array();
			var dateAndTime=new Array();
			$("#data_timer td.clicktd").not("#data_timer td.today").each(function(){
				var active=$(this).index();
				var time=$(this).html();
				if(time=='8:00-9:00'){
					time = "01";
				}else if(time == "9:00-10:00"){
					time = '02';
				}else if(time == "10:00-11:00"){
					time = '03';
				}else if(time == "11:00-12:00"){
					time = '04';
				}else if(time == "12:00-13:00"){
					time = "05";
				}else if(time == "13:00-14:00"){
					time = "06";
				}else if(time == "14:00-15:00"){
					time = "07";
				}else if(time == "15:00-16:00"){
					time = "08";
				}else if(time == "16:00-17:00"){
					time = "09";
				}else{
					time = "10";
				}
				var date=$(".fc-day-header").eq(active).attr("data-date");
				dates.push(date);//获取日期
				dateAndTime.push(date+"_"+time);//获取日期和时间段
			});
			if(commodityId){
				if(dates.length>0){
					var datess=new Array();
					var dateAndTimes=new Array();
					var date0=dates[0];
					for(var i=0;i<dates.length;i++){
						//将日期去重
						if(datess.indexOf(dates[i]) == -1){
							datess.push(dates[i]);
						}

					}
					var a=new Array(datess.length);
					var b=new Array(datess.length);
					for(var i=0;i<datess.length;i++){
						a[i]=new Array();
						b[i]=new Array();
						//根据日期将时间段分组
						for(var j=0;j<dateAndTime.length;j++){
							if(dateAndTime[j].split("_")[0]==datess[i]){
								a[i].push(datess[i]);
								b[i].push(dateAndTime[j].split("_")[1]);//获取同一天的时间段值
							}
						}
					}
					var noContinue=new Array();
					for(var i=0;i<a.length;i++){
						var c=b[i];
						if(c.length>1){
							var n = c.length;
							var min = Number(c[0]), max = Number(c[0]);
							for (var j = 1; j < n; j++) {
								//比较是时间段是否连续
								if (Number(c[j]) != 0) {
									if (min > Number(c[j]))
										min = Number(c[j]);
									if (max < Number(c[j]))
										max = Number(c[j]);
								}
							}
							if (max - min > n - 1) {
								//时间段不连续
								noContinue.push(a[i]);
							}
						}
					}

					if (noContinue.length > 0) {
						clearInterval(timer);
						$("#msg").text("请选择连续的时间段");
						$(".toast").show();
						pltime = 2;
						timer = setInterval("closeTanc()", 1000)
					} else {
						$(".pop_layer").show();
					}

				}else{
					clearInterval(timer);
					$("#msg").text("请选择预约日期和时间段");
		            $(".toast").show();
		            pltime=2;
		            timer=setInterval("closeTanc()",1000);
					
				}
			}else{
				clearInterval(timer);
				$("#msg").text("请先选择会议室");
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000);
			}
			
			//alert("已预约id："+$("#resoIds").html().substring(0,$("#resoIds").html().length-1));
			
		});
		
		$(".close0").click(function(){
			$(".pop_layer").hide();
		});
		  //提交预约
		$('.btn-cheng').click(function(){
			if(!isLogin){
				clearInterval(timer);
				$("#msg").text("请登录后重试！");
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000)
				return;
				}
			var commodityId= $("#commodityId").val();
			var commodityPrice=$("#roomPrice").val();
			var enteringName=$("#enteringName").val();
			var enteringTelephone=$("#enteringTelephone").val();
			var tea=false;
		    if($(".ib-checkbox").children('input[type="checkbox"]').is(":checked")){
		    	tea=true;
	          }
            if(enteringName == null||enteringName == ""){
            	clearInterval(timer);
            	$("#msg").text("请填写联系人");
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000)
				return;
			}
            if(enteringTelephone !=null&& enteringTelephone!=""){
				 if(isMobil(enteringTelephone)){
						
					}else{
						clearInterval(timer);
						$("#msg").text("电话格式不正确！");
			            $(".toast").show();
			            pltime=2;
			            timer=setInterval("closeTanc()",1000)
						return;
					}
		    	}else{
		    		clearInterval(timer);
		    		$("#msg").text("请填写联系人电话");
		            $(".toast").show();
		            pltime=2;
		            timer=setInterval("closeTanc()",1000)
				    return;
		    	}
			
			
			
			var dates=new Array();
			var times=new Array();
			$("#data_timer td.clicktd").each(function(){
				var active=$(this).index();
				var time=$(this).html();
				if(time=='8:00-9:00'){
					time = "01";
				}else if(time == "9:00-10:00"){
					time = '02';
				}else if(time == "10:00-11:00"){
					time = '03';
				}else if(time == "11:00-12:00"){
					time = '04';
				}else if(time == "12:00-13:00"){
					time = "05";
				}else if(time == "13:00-14:00"){
					time = "06";
				}else if(time == "14:00-15:00"){
					time = "07";
				}else if(time == "15:00-16:00"){
					time = "08";
				}else if(time == "16:00-17:00"){
					time = "09";
				}else{
					time = "10";
				}
				var date=$(".fc-day-header").eq(active).attr("data-date");
				dates.push(date);
				times.push(time);
			});
			
			if(dates.length>0){
				var length=dates.length;
        		var userorderAmount=$("#roomPrice").val();
        		userorderAmount=userorderAmount*length;
				var string ="";
				for(var i=0;i<dates.length;i++){
					string+="records["+i+"].resoDate="+dates[i]+"&";
				}
				for(var i=0;i<times.length;i++){
					string+="records["+i+"].resoTime="+times[i]+"&";
				}
				string+="userorderAmount="+userorderAmount+"&"+"commodityId="+commodityId+"&"+"addService="+tea;
			   var serviceURL =baseUrl+"publicutilitiesmanagerResoManager/savePublicResoOrderByList.json";
				//公共方法
			 $.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:string,
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.record){
							$(".pop_layer").hide();
							$(".bg-tanc.m1").show();
							$('#ti-m1').text('5');
							a=5;
							timer1=setInterval("jump1()",1000);
						//	window.location="roomxq.html?id="+commodityId;
						}
					},error:function(XMLHttpRequest, textStatus, errorThrown){
						$(".pop_layer").hide();
						$("#errorText").text(XMLHttpRequest);
						$(".bg-tanc.m2").show();
						$('#ti-m2').text('5');
						b=5;
						timer2=setInterval("jump2()",1000);
					}
				});
            }else{
            	clearInterval(timer);
            	$("#msg").text("请选择预约日期和时间段");
	            $(".toast").show();
	            pltime=2;
	            timer=setInterval("closeTanc()",1000)
            }	
			
			//校验手机号格式
			function isMobil(s) {
			    	var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
			   		if (!patrn.exec(s)) return false
			   	 	return true
				}
                
		});
	});
	
var a,b,timer1,timer2;
function jump1(){
	if(a>1){
		a--;
		$("#ti-m1").text(a);
	}else{
		window.location=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
	}		
}
function jump2(){
	if(b>1){
		b--;
		$("#ti-m2").text(b);
	}else{
		window.location="order.html";
	}		
}

//跳转订单中心
function jumpOrder(){
	window.location=cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
}
//返回
function jumpBack(){
	window.location="order.html";
}

//toast弹窗出来后，一秒自动关闭,请再调用弹窗toast的时候调用该方法
var pltime,timer;
function closeTanc(){
    if(pltime>1){
        pltime--;
    }else{
        $(".toast").hide();
    }       
}
	//加载会议室
	function roomDetail(){
		var params = [ 'genreCode=0301'];
        //0301:会议室
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"publicutilitiesmanagerResoManager/getPagerPublicCommoditys.json",
			data:params.join('&'),
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				if(results&&results.records){
					if(results.records.length>0){
						_sparseRecords(results.records);
					}
				}
			}
		});
	}
	//会议室列表展示
	function _sparseRecords(record) {
		for (var i = 0; i < record.length; i++) {
			var imageUrl = "../styles/images/index/room.jpg";
			if (record[i].commodityImage != null
					&& record[i].commodityImage != "") {
				imageUrl = cenUrl
						+ "common/uploadImage.html?repository=/swfupload&path="
						+ record[i].commodityImage + "&method=show";
			}
			var link = "location.href='./companyservice/roomxq.html?id="
					+ record[i].commodityId + "'";
			var title = record[i].commodityTitle;
			var leng = title.length;
			if (leng > 10) {
				title = title.substring(0, 10);
				title += "...";
			}
			var html = "<li class='clearfix'><div class='fl'><span id='commodityId' style='display:none'>"+record[i].commodityId+"</span>"
			        + "<span id='commodityTitle' style='display:none'>"+record[i].commodityTitle+"</span>"
			        + "<span id='roomType' style='display:none'>"+record[i].meetingRoom.lx+"</span>"
			        + "<span id='roomTyy' style='display:none'>"+record[i].meetingRoom.tyy+"</span>"
			        + "<span id='roomGm' style='display:none'>"+record[i].meetingRoom.gm+"</span>"
			        + "<span id='roomPrice' style='display:none'>"+record[i].commodityPrice+"</span>"
			        + "<img src='"+imageUrl+"' width='118' height='66'></div><div class='fl ml10 lh30'><div class='f16 c3'>"
					+ title
					+ "</div>"
					+ "<p class='cc f14'>"
					+ record[i].commodityPrice
					+ "元/小时</p></div></li>";
			console.log(html);
			$(".order-nav").append(html);

		}
		
        var i=0;
        var l=$(".order-nav li").size();
        var h=$(".order-nav li:first").outerHeight();
        $(".next-bottom").click(function(){
            if(i>5-l && l>5){
                i=i-1;
            }else if(i==5-l && l>5){
                i=0;
            }else if(l<6){
                i=0;
            }
            scholl(i);
        });
        $(".pre-top").click(function(){
            if(i>4-l&&i<0 && l>5){
                i=i+1;
            }else if(i==0 && l>5){
                i=5-l;
            }else if(l<6){
                i=0;
            }
            scholl(i);
        });
        function scholl(i){
            var topH=i*107+"px";
            $(".order-nav").animate({top:topH});
        }
        //一开始加载默认第一条数据
        $(".order-nav li:eq(0)").addClass("active");
        $("#data_timer td").removeClass("today");
        var roomType=$(".order-nav li:eq(0)").find("span").eq(2).text();
        var roomTyy=$(".order-nav li:eq(0)").find("span").eq(3).text();
        var roomGm=$(".order-nav li:eq(0)").find("span").eq(4).text();
        var roomPrice=$(".order-nav li:eq(0)").find("span").eq(5).text();
        var commodityTitle=$(".order-nav li:eq(0)").find("span").eq(1).text();
        var commodityId=$(".order-nav li:eq(0)").find("span").eq(0).text();
        $("#commodityId").val(commodityId);
        $("#roomPrice").val(roomPrice);
        $(".cblue.fw").text(commodityTitle);
        $('.od_tip').eq(0).text(roomType);
        $('.od_tip').eq(1).text(roomTyy+"投影仪");
        $('.od_tip').eq(2).text(roomGm);
        displayStatus(commodityId,"prev");
        $(".order-nav li").hide();
        $(".order-nav li").slice(0,5).show();
        var l=$(".order-nav li").length;
        var html="<span></span>";
        var html1="<span></span>";
        for (var n=1;n<10;n++){
            html=html+html1;
            if(l>5*n){
                $(".page-circle").empty()
                $(".page-circle").append(html);
                $(".page-circle span:first").addClass("current");
            }
        }
	};
	$(document).on("mouseover",".page-circle span",function(){
        $(this).addClass("current").siblings().removeClass("current");
        var m=$(this).index();
        $(".order-nav li").hide();
        $(".order-nav li").slice(5*m,5*(m+1)).show();

    })
	
    function displayStatus(commodityId,name){
    	$("#data_timer td").removeClass("today");
    	var params = ['commodityId='+commodityId];
    	var serviceURL = baseUrl+"publicutilitiesmanagerResoManager/getPublicutilitiesmanagerResoByCommodityId.json";
    	//根据商品id获取资源可用状态
    	$.youi.ajaxUtils.ajax({
    		url : serviceURL,
    		data:params.join('&'),
    		jsonp : 'data:jsonp',
    		dataType : 'jsonp',
    		async : false,
    		success : function(results) {
    			var numArray1 = new Array();
				var numArrayDate1 = new Array();
		    	var Request = new Object();
		    	var resoTime = "";
    			if (results && results.records) {
    				var records = results.records;
    				console.log(records);
    				$("#resoIds").empty();
    				var tr=0;
    				for(var i=0; i<records.length; i++){
    					var htmlObj = $(".fc-left").find('h2').html();
    					var month=htmlObj?htmlObj.substring(5,6):0;
    				   //var month=$(".fc-left").find('h2').html().substring(5,6);
    					$("#enteringName").val(records[0].name);
    					$("#enteringTelephone").val(records[0].phone);
    					if((Number(records[i].resoDate.substring(5,7)))==Number(month)){
    						//主键追加到隐藏域供预约使用
    						$("#resoIds").append(records[i].resoId+",");
    						if(records[i].resoTime=='01'){
    							resoTime = "8:00-9:00";
    							tr=0;
    						}else if(records[i].resoTime=='02'){
    							resoTime = "9:00-10:00";
    							tr=1;
    						}else if(records[i].resoTime=='03'){
    							resoTime = "10:00-11:00";
    							tr=2;
    						}else if(records[i].resoTime=='04'){
    							resoTime = "11:00-12:00";
    							tr=3;
    						}else if(records[i].resoTime=='05'){
    							resoTime = "12:00-13:00";
    							tr=4;
    						}else if(records[i].resoTime=='06'){
    							resoTime = "13:00-14:00";
    							tr=5;
    						}else if(records[i].resoTime=='07'){
    							resoTime = "14:00-15:00";
    							tr=6;
    						}else if(records[i].resoTime=='08'){
    							resoTime = "15:00-16:00";
    							tr=7;
    						}else if(records[i].resoTime=='09'){
    							resoTime = "16:00-17:00";
    							tr=8;
    						}else{
    							resoTime = "17:00-18:00";
    							tr=9;
    						}
    						var resoDate1=records[i].resoDate;
    						if(records[i].resoStatus=='02'){
    							var y=0;
    	    					var length=$(".fc-widget-header").find('tr').eq(0).find('th').length;
    	    					for(var p=1;p<length;p++){
    	    						var th=$(".fc-widget-header").find('tr').eq(0).find('th').eq(p).attr("data-date");
    	    						if(resoDate1==th){
	    	    						y=p;
	    	    						if(name=="next"){
	    	    							numArray1.push(y+"-"+tr);	
	    	    						}
    	    						}
    	    					}
    	    					if(name=="prev"){
    	    						if(y !=0){
    	    							numArray1.push(y+"-"+tr);
        	    					}
	    						}
    						}
    					}
    				}
					for(var i=0;i<numArray1.length;i++){
						var td1=numArray1[i].split("-")[0];
						var th1=numArray1[i].split("-")[1];
						td1--;
						$("#data_timer tr").eq(th1).children("td").eq(td1).addClass("today");
					}
					
    			}
    		}
    	});
	}
	
