$(function(){
        //加载会议室
        roomDetail();
        
      //在线预约
		$("#online").click(function(){
			var dates=new Array();
			var times=new Array();
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
				dates.push(date);
				times.push(time);
			});
			alert(dates);
			if(dates.length>0){
				$(".pop_layer").show();
			}else{
				$("#msg").text("请选择预约日期和时间段");
	            $(".toast").show();
				clearInterval(timer);
				$("#msg").text("请选择预约日期和时间段");
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
        		var userorderAmount=$('#commodityPrice').text();
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
		var pageSize = 5;
		var params = [ 'genreCode=0301', 'pager:pageSize=' + pageSize ];
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
			        + "<img src='"+imageUrl+"' width='118' height='66'></div><div class='fl ml10 lh30'><div class='f16 c3'>"
					+ title
					+ "</div>"
					+ "<p class='cc f14'>"
					+ record[i].commodityPrice
					+ "元/小时</p></div></li>";
			$("#roomDtail").append(html);

		}
	};
	
	
