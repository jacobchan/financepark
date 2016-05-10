
function GetRequest() {
   var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}

			var Request = new Object();
	    	Request = GetRequest();
	    	var enteringType = Request['enteringType'];
	    	var a,b;
				$(function(){
					var j=0,num=0,pageCount=1;
					var timer1,timer2;
					var o=$(".ht-table tr th").length;//得到th有多少个；
					var dd,dm,dt,dw;
					var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];//将得到的0-7转化为星期
					changeDate(num);
					pageLoadNum();
					//鼠标移上去时出现左右按钮
					$(".pr").hover(function(){
						$(this).children(".ht-table").nextAll().toggle();
					});
					//左按钮
					$(".cd-prev").click(function(){
						var n=$(this).parent().find(".ht-table th").eq(1).text().replace(/[^0-9]/ig,"-");//取得第一个th里的时间
						var m1=n.split("-")[0];
						var d1=n.split("-")[1];
						dd = new Date();
					  	dm=dd.getMonth()+1;
					  	dt=dd.getDate();
					  	if(m1==dm && d1==dt){
					  		clearInterval(timer);
					  		$("#msg").text("只能选择今天及以后的日期");
				            $(".toast").show();
				            pltime=1;
				            timer=setInterval("closeTanc()",1000);
					  	}else{
					  		num--;
					  		pageLoadNum();
							changeDate(num);
					  	}
					});
					//右按钮
					$(".cd-next").click(function(){
						num++;
						//根据商品id获取资源可用状态
						pageLoadNum();
						changeDate(num);
					})
					//7个日期的变化公共部分
					function changeDate(num){
						
			        		var z=7;
							for(j=1;j<o;j++){
								for(var i=0;i<j;i++){
									var dd = new Date();
								  	dd = new Date(dd.getTime() + 60*60*24*1000 *(i+z*num)); 
								  	dm=dd.getMonth()+1;
								  	dt=dd.getDate();
								  	dw=dd.getDay();	
								  	$(".ht-table tr th").eq(j).html(dm+"月"+dt+"日"+"<br/>"+weekDay[dw]);
								}
							}
				
					};
				    //关闭toast
			        $(".close-toast").click(function(){
			        	clearInterval(timer);
			            $(".toast").hide();
			        })
					
					 $("#sub").click(function(){	
						 if(!isLogin){
							    clearInterval(timer);
							    $("#msg").text("请登录后重试！");
					            $(".toast").show();
					            pltime=2;
					            timer=setInterval("closeTanc()",1000);
							 	return false;
							}
						var enteringName=$("#enteringName").val();
						var enteringTelephone=$("#enteringTelephone").val();
						
						var enteringIdd=$('#enteringIds').val();
						if(enteringIdd == null||enteringIdd == ""){
							
							clearInterval(timer);
							$("#msg").text("请选择预约时间");
       			    		$(".toast").show();
       			    	    pltime=2;
				            timer=setInterval("closeTanc()",1000);
							return;
						}
                        if(enteringName == null||enteringName == ""){
                        	clearInterval(timer);
							$("#msg").text("请填写申请人");
       			    		$(".toast").show();
       			    	     pltime=2;
				             timer=setInterval("closeTanc()",1000);
							return;
						}
                        if(enteringTelephone !=null&& enteringTelephone!=""){
       					 if(isMobil(enteringTelephone)){
       							
       						}else{
       							clearInterval(timer);
       							$("#msg").text("电话格式不正确！");
           			    		$(".toast").show();
           			    		pltime=2;
    				            timer=setInterval("closeTanc()",1000);
       							return false;
       						}
       			    	}else{
       			    		clearInterval(timer);
       			    		$("#msg").text("请填写申请人电话");
       			    		$(".toast").show();
       			    		pltime=2;
				            timer=setInterval("closeTanc()",1000);
							return;
       			    	}
                        $(".hhf-submit").addClass("undis") ;
                        $("#sub1").removeClass("undis") ;
						var params=['propertyservicemanagerEntering.enteringId='+enteringIdd,'enteringName='+enteringName,'enteringTelephone='+enteringTelephone,'enteringType='+enteringType];
						var serviceURL = baseUrl+"propertyservicemanagerEntrecManager/savePropertyservicemanagerEntrec.json";
						//公共方法
						$.youi.ajaxUtils.ajax({
							url:serviceURL,
							data:params.join('&'),
							jsonp:'data:jsonp',
							dataType:'jsonp',
							success:function(results){
								$(".hhf-submit").removeClass("undis") ;
		                        $("#sub1").addClass("undis") ;
								if(results&&results.record){
									$(".bg-tanc.m1").show();
									$('#ti-m1').text('5');
									a=5;
									timer1=setInterval("jump1()",1000);
									/* window.location="yq2.html?enteringType="+enteringType; */
									//window.location=cenUrl+"member/memberCenter/index.html";
								}
							},error:function(XMLHttpRequest, textStatus, errorThrown){
								$(".hhf-submit").removeClass("undis") ;
		                        $("#sub1").addClass("undis") ;
								$("#errorText").text(XMLHttpRequest);
								$(".bg-tanc.m2").show();
								$('#ti-m2').text('5');
								b=5;
								timer2=setInterval("jump2()",1000);
							}
						});
						//校验手机号格式
						function isMobil(s) {
						    	var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
						   		if (!patrn.exec(s)) return false
						   	 	return true
							}
						
					});
					 $(".tc-close").click(function(){
						 clearInterval(timer1);
						 clearInterval(timer2);
					 })
					
					/*  $(".ht-table").plists({
						template:'',
						jsonpSrc:'http://localhost:8081/jsonp/data.jsp?data:file=yq2-test.json'
					});
					$(".hhf-submit").click(function(){
						var obj={
						enteringName:$("#enteringName").val(),
						enteringTelephone:$("#enteringTelephone").val(),
						enteringEmail:$("#enteringEmail").val(),
						enteringNote:$("#enteringNote").val(),
						};
						var str=JSON.stringify(obj);
						alert(str);
					}); */
				});
				
				//跳转订单中心
				function jumpOrder(){
					window.location=cenUrl+"member/memberCenter/personalCenter/myReservation.html?showFlg=2";
				}
				//返回
				function jumpBack(){
					window.location="yq2.html?enteringType="+enteringType; 
				}
				
				var a,b;
				function jump1(){
					if(a>1){
						a--;
						$("#ti-m1").text(a);
					}else{
						window.location=cenUrl+"member/memberCenter/personalCenter/myReservation.html?showFlg=2";
					}		
				}
				function jump2(){
					if(b>1){
						b--;
						$("#ti-m2").text(b);
					}else{
						window.location="yq2.html?enteringType="+enteringType; 
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
		        function pageLoadNum(){
		    		var serviceURL = baseUrl+"propertyservicemanagerEnteringManager/getEnteringList.json";
		    		var pageIndex=1;
		    		var pageSize=12;
		    		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
		    		var enteringId;
		    		//根据商品id获取资源可用状态
		    		$.youi.ajaxUtils.ajax({
		    			url : serviceURL,
		    			jsonp : 'data:jsonp',
		    			data:params.join('&'),
		    			dataType : 'jsonp',
		    			async : false,
		    			success : function(results) {
		    				if (results && results.records) {
		    					var record = results.records;
		    				    var pageCount=Math.ceil(record[0].total/pageSize);
		    				    $("#pageTotal").val(pageCount);
		    				    $("#am td").slice(1,8).empty();
		    					$("#pm td").slice(1,8).empty();
		    					var html="";
		    					var htmls="";
		    					var dayb=new Array();
		    					var dayc=[1,2,3,4,5,6,7];
		    					for(var i=0; i<record.length; i++){
		    		                $("#enteringName").val(record[0].memName);
		    						$("#enteringTelephone").val(record[0].memPhone);
		    						var a=new Array();
		    						 for(var j=1;j<8;j++){
		    							  	var day=$(".ht-table tr th").eq(j).text();
		    							  	var month=day.split("月")[0];
		    							  	var days=day.split("月")[1].split("日")[0];
		    							  	if(month.length==1){
		    							  		month="0"+month;
		    							  	}
		    							  	if(days.length==1){
		    							  		days="0"+days;
		    							  	}
		    							  	a.push(month+"-"+days);
		    							  	
		    						 }
		    				     
		    						 var html1="<span id='enteringId' style='display:none'>"+record[i].enteringId+"</span>"+record[i].enteringStatusName+"("+record[i].enteringRemain+"个)";
		    						 if(record[i].enteringDate !=undefined){
		    						  		var enteringDate=record[i].enteringDate;
		    						  		//
		    						  		enteringDate=enteringDate.substring(5,enteringDate.length);
		    						  		/* alert(enteringDate) */
		    						  		for(var q=0;q<a.length;q++){
		    						  			var dates=a[q];
		    						  			if(enteringDate == dates){
		    						  				
		    						  				dayb.push(q+1);
		    						  				function abc(dm){
		    						  					if(dm.enteringStatus=='01'){
		    												html="<a href='javascript:;' class='em1'>"+html1+"</a>";
		    										    }
		    											else if(dm.enteringStatus=='02'){
		    												html="<a href='javascript:;' class='em2'>"+html1+"</a>";
		    											}else{
		    												html="<a href='javascript:;' class='em3'>"+html1+"</a>";
		    											}
		    						  				}
		    										if(record[i].enteringTime=='AM'){
		    											abc(record[i]);
		    											$("#am td").eq(q+1).append(html);
		    										}
		    											
		    										if(record[i].enteringTime=='PM'){
		    											abc(record[i]);
		    											$("#pm td").eq(q+1).append(html);
		    										}
		    										
		    						  			}
		    						  		}
		    						  	}
		    						 
		    						}
		    						var dayd=new Array();
		    						/* if(dayb.length==0){
		    							var htm='<td>09：00-12：00</td><td rowspan="2" colspan="7"><span class="f14">暂无记录</span></td>';
		    							$(".ht-table tbody #am").html(htm);
		    							$(".ht-table tbody #pm").html("<td>09：00-12：00</td>");
		    						}else{ */
		    							for(var m=0;m<dayc.length;m++){
		    								var dm1=dayc[m];
		    								var isExist = false;
		    								for (var n=0;n<dayb.length;n++){
		    									var dm2=dayb[n];
		    									if(dm1==dm2){
		    										isExist = true;
		    							            break;
		    									}
		    								}
		    								if(!isExist){
		    									var htmls1="<a href='javascript:;' class='em3'>暂无数据</a>";
		    									$("#am td").eq(dm1).append(htmls1);
		    									$("#pm td").eq(dm1).append(htmls1);
		    							    }
		    							}
		    					/* } */
		    					$(document).on("click",".em1",function(){
		    						$(".em1").removeClass("active");
		    						$(this).addClass("active");
		    						enteringId=$(this).find("span").text();
		    						$('#enteringIds').val(enteringId);
		    					})

		    				}
		    			}
		    		});
		    	}
		    	
		    		