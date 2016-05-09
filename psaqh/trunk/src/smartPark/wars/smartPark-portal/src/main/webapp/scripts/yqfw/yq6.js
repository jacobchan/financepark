$.youi.ajaxUtils.ajax({
		url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.record){
				$("#bxComp").val(result.record.rz.rzName);
			}
		}
	});
	
		$(function(){
			$(".hhf-submit").click(function(){
				/* var obj={
				bxComp:$("#bxComp").val(),
				bxWay:$("#bxWay").text(),
				bxType:$("#bxType").text(),
				bxProject:$("#bxProject").text(),
				bxAddress:$(".select-address.active").text().replace(/\t|\n/ig,""),
				bxRemark:$("#bxRemark").val(),
				bxFujian:$("#upload").val()
				};
				var str=JSON.stringify(obj);
				alert(str); */
				if(!isLogin){
					clearInterval(timer);
		           	$(".toast").show();
		           	pltime=1;
		           	timer=setInterval("closeTanc()",1000);
				} 
				//判断是否是企业员工
				$.youi.ajaxUtils.ajax({
				url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.record){
						var remark = $("#bxRemark").val();
						if(remark=="" || remark.length==0){
							clearInterval(timer);
							$(".tc.mt25").text("请输入相关描述！");
				           	$(".toast").show();
				           	pltime=1;
				           	timer=setInterval("closeTanc()",1000);
							return false;
						}
						var add = "";
						if($('input[name="address"]')[0].getAttribute("value")==0){
							add = result.record.rz.rzName;
						}else{
							add = $('input[name="otheraddress"]').val();
						}
						var params = ['bxComp='+$("#bxComp").val(),
										'bxType='+$("#bxType")[0].getAttribute("value"),
										'bxRemark='+remark,
										'bxAddress='+add,
										'bxFujian='+$("#upload").val()];
						var serviceURL =baseUrl+"propertyservicemanagerBxManager/savePropertyservicemanagerBx.json";
						
						//公共方法
						$.youi.ajaxUtils.ajax({
							url:serviceURL,
							data:params.join('&'),
							jsonp:'data:jsonp',
							dataType:'jsonp',
							success:function(results){
								if(results&&results.record){
									$(".bg-tanc.m2").show();
									countdown(3);
								}
							}
						});
					}else{
						clearInterval(timer);
						$(".tc.mt25").text("您不是企业用户,暂时无法申请!");
			           	$(".toast").show();
			           	pltime=1;
			           	timer=setInterval("closeTanc()",1000);
						return false;
					}
				}
			});
			
				
			});
		});
	
		$(function(){
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"propertyservicemanagerBxManager/getBxcodemapforpage.json", 
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.records){
							_parseRecords(result.records);
						}
					}
				});
			});
		function _parseRecords(record){
				var html ="";
				html=html+"<div class='ic-select'>"+
				"<p id='bxType' value='"+record[0].itemValue+"'>"+record[0].itemName+"</p>"+
				"</div>"+
				"<ul style='display: none;' class='select-nav'>";
				for(var i=0;i<record.length;i++){
					html =html +"<li value='"+record[i].itemValue+"'>"+record[i].itemName+"</li>"
				}
					
				html=html+"</ul> ";
				$(".tct-select").append(html);
				activeclick();
		}
	
		$(function(){
				$.youi.ajaxUtils.ajax({
					url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.record){
							addressRecords(result.record);
						}
					}
				});
			});
		function addressRecords(record){
			var add =""; 
			var room = record.rz.roomId.roomAddress;
			if(room!=''&&room!=null){
				add = room;
			}else{
				add = "无默认地址";
			}
			
			var html = "<p class='mb10'><label><input type='radio' name='address' class='mr5' checked='checked' value='0'>默认地址:"+add+"</label></p>"+
			"<p class='mb10'><label><input type='radio' name='address' class='mr5'>其他地址</label></p>"+
			"<p class='mb10'><input type='text' name='otheraddress' class='input-show undis' placeholder='科技园a7'></p>";
			$(".sel-add").append(html);
			address();
	}
	
		function activeclick(){
			$(".ic-select").click(function(e){
				$(".select-nav").hide();
			    $(this).next(".select-nav").show();
			    e.stopPropagation();//
			});
			$(".select-nav li").click(function(){
				$(this).parents(".tct-select").find(".ic-select p").text($(this).text());
				 var livale = "0"+$(this).val(); 
				$(this).parents(".tct-select").find(".ic-select p")[0].setAttribute("value",livale);
				$(this).parent().hide();
			})
		};
		function address(){
			$(".sel-add label").click(function(){
				if($(this).children('input[name="address"]').prop("checked")){
					if($(this).parent().index()==0){
						$(this).parents(".sel-add").find(".input-show").addClass("undis");
						$('input[name="address"]')[0].setAttribute("value","0");
					}else{
						$(this).parents(".sel-add").find(".input-show").removeClass("undis");
						$('input[name="address"]')[0].setAttribute("value","1");
					}
				}
			});
		};
	
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
		//定时跳转
		 function countdown(i){
		 	$("#ti-m1").text(i);
		     i = i - 1;
		     if(i > 0) {
		         setTimeout("countdown("+i+")", 1000);
		     }else{
		     	jump();
		     }
		 }
		 //跳转报修
		 function jump(){
		 	window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageBx.html";
		 }
		 //跳转个人中心
		 function jumpPerson(){
		 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
		 }
		 //跳转首页
		 function jumpIndex(){
		 	window.location.href=cenUrl;
		 }