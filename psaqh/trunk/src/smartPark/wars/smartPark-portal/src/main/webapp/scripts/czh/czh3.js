$(function(){
			var url=location.href; 
			var tmp1=url.split("?")[1];  
			var tmp2=tmp1.split("=")[1]; 
			var applyId=tmp2;
			var serviceURL = baseUrl+"activityApplyManager/getActivityApply.json";
			var params = ['applyId='+applyId];
			
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.record){
					_parseRecords(results.record);
				
					}
				}
			});	
			//获取文档列表
			getdocument(applyId);
			/* //获取是否收藏
			 if(!isLogin){
				getfavoritActivity(applyId);
			 }else{
				getboolfavorit(applyId);
			 } */
		});
		window.onload=function(){
			var url=location.href; 
			var tmp1=url.split("?")[1];  
			var tmp2=tmp1.split("=")[1]; 
			var applyId=tmp2;
			 if(!isLogin){
					getfavoritActivity(applyId);
				 }else{
					 getfaCount(applyId);
				 }
		}
		//活动详情赋值
		function _parseRecords(record){

			$(".activityImage").attr("src",cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record.activityImage+"&method=show");
			$(".h-bg").html(record.applyTitle);
			$(".time").html(record.startTime);
			//$(".address").html();
			$(".name").html("发布人："+record.memberId.memberName);
			$(".phoneNumber").html(record.memberId.memberPhoneNumber);
			$(".bd-box").html(record.commentContent);
			$("#activityAdr").html(record.activityAdr);
			var map = new BMap.Map("map");//创建Map实例
			map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
			local = new BMap.LocalSearch(map, {
				renderOptions: {map: map}
			});
			//, panel: "r-result"
			local.search($("#activityAdr").html().substring(3,$("#activityAdr").html().length));
			$('#map div.anchorBL').hide();
		}
		
		//加载文档
		function getdocument(id){
			var applyId = id;
			var serviceURL = baseUrl+"activityDocumentManager/getPagerActivityDocuments.json";
			var params = ['activityId.applyId='+applyId];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.records){
						if(results.records.length>0){
							documents(results.records);
						}else{
							$(".article-tab").empty();
							$(".article-tab").append("<tr><td align='center'><h3>暂无活动文档</h3></td></tr>");
						}
					}
				}
			});	
		}
		//拼接侧边栏
		function documents(record){
			$(".article-tab").empty();
			var html ="";
			html+="<colgroup><col width='42'></col><col width='230'></col></colgroup>";
			for(var i=0;i<record.length;i++){
				html+=
					"<tr id="+record[i].documentId+" onclick='openPage(this)' style='cursor:pointer;'><td><em>P</em></td>"+
					"<td><p>"+record[i].documentName.split('.')[0]+"</p>"+
					"<span>"+record[i].createTime+"</span>"+
					"</td></tr>";
			}
			$(".article-tab").append(html);
		}
		
		//文档跳转页面
		function openPage(obj){
			var url=location.href; 
			var tmp1=url.split("?")[1];  
			var tmp2=tmp1.split("=")[1]; 
			var applyId=tmp2;
			var documentId=obj.id;
			var url="../czh/czh7.html"+"?"+"applyId="+applyId+"&documendid="+documentId; 
			window.location.assign(url); 
		}
		//获取是否收藏
		function getboolfavorit(id,data){
			var applyId = id;
			var count = data;
			var serviceURL = baseUrl+"favoritsFavoritActivityManager/exsitFavoritsFavoritActivityforPage.json";
			var params = ['activityId.applyId='+applyId];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.record){
							$("a.a-c-p").attr("id",results.record.favoritActivityId);
							$("a.a-c-p").css("background-color","#ecebeb");
							$("a.a-c-p").attr("value","0");
							$("a.a-c-p").html('<img alt="收藏" src="../styles/images/czh/sc-o.png" border="0" class="mr10">收藏：'+count+'人');
					}else{
						getfavoritActivity(applyId);
					}
				}
			});	
		}
		
		function getfaCount(id){
			var applyId = id;
			var serviceURL = baseUrl+"favoritsFavoritActivityManager/getPagerFavoritsFavoritActivitys.json";
			var params = ['activityId.applyId='+applyId];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				async: false, 
				success:function(results){
					if(results&&results.records){
							var data = results.totalCount;
							getboolfavorit(applyId,data);
						}
					}
			});
		}
		
		//加载收藏数
		function getfavoritActivity(id){
			var applyId = id;
			$("a.a-c-p").attr("id",applyId);
			var serviceURL = baseUrl+"favoritsFavoritActivityManager/getPagerFavoritsFavoritActivitys.json";
			var params = ['activityId.applyId='+applyId];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.records){
						if(results.records.length>0){
							$("a.a-c-p").empty();
							$("a.a-c-p").attr("value","1");
							$("a.a-c-p").removeAttr("style");
							$("a.a-c-p").append('<img alt="收藏" src="../styles/images/czh/sc.png" border="0" class="mr5">收藏：'+results.totalCount+'人');
						}else{
							$("a.a-c-p").empty();
							$("a.a-c-p").attr("value","1");
							$("a.a-c-p").removeAttr("style");
							$("a.a-c-p").append('<img alt="收藏" src="../styles/images/czh/sc.png" border="0" class="mr5">收藏：0人');
						}
					}
				}
			});	
		}
		$(function(){
			$(".slideBox").hover(function(){
	      		clearInterval(timer);
			},function(){ timer = setInterval(run,3000)});

			$("a.a-c-p").click(function(){
				 if(!isLogin){
					 clearInterval(timer);
				     $(".toast").show();
				     $(".tc.mt25.f18").text("请登录!");
				     pltime=1;
				     timer=setInterval("closeTanc()",1000);
				     return false;
				 }
				 var val = $("a.a-c-p").attr("value");
				 if(val=='0'){//取消收藏
					 dealfavorits();
				 }else{//添加收藏
					 savefavorits();
				 }
				 
			});
			$("a.a-c-o").click(function(){
				$("#applyMember").val('');
				$("#applyPhone").val('');
				$("#captcha").val('');
				$('#sendMobileCaptcha').html("发送验证码");
				$('#sendMobileCaptcha').attr('onclick','getCaptcha();');
				$(".bg-tanc").show();	
			});
		});
		
		//添加收藏
		function savefavorits(){
			var applyId = $("a.a-c-p").attr("id");
			var serviceURL = baseUrl+"favoritsFavoritActivityManager/saveFavoritsFavoritActivity.json";
			var params = ['activityId.applyId='+applyId];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.record){
							 clearInterval(timer);
						     $(".toast").show();
						     $(".tc.mt25.f18").text("收藏成功!");
						     pltime=1;
						     timer=setInterval("closeTanc()",1000);
						  /*  $("a.a-c-p").attr("id",results.record.favoritActivityId),
						    $("a.a-c-p").attr("value","0");
							$("a.a-c-p").css("background-color","#ecebeb");
							var count = getfaCount(applyId);
							$("a.a-c-p").html('<img alt="收藏" src="../styles/images/czh/sc-o.png" border="0" class="mr10">收藏：'+count+'人');*/
						     getfaCount(applyId);
						}
					}
			});
		}
		//取消收藏
		function dealfavorits(){
				var url=location.href; 
				var tmp1=url.split("?")[1];  
				var tmp2=tmp1.split("=")[1]; 
				var applyId=tmp2;
				var favoritActivityId = $("a.a-c-p").attr("id");
			 	var serviceURL = baseUrl+"favoritsFavoritActivityManager/removeFavoritsFavoritActivity.json";
				var params = ['favoritActivityId='+favoritActivityId];
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:params.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
				
								 clearInterval(timer);
							     $(".toast").show();
							     $(".tc.mt25.f18").text("取消收藏成功!");
							     pltime=1;
							     timer=setInterval("closeTanc()",1000);
							     getfavoritActivity(applyId);
						}
				});
		}
		
		
		//获取验证码
		function getCaptcha(){
			var url=location.href; 
			var tmp1=url.split("?")[1];  
			var tmp2=tmp1.split("=")[1]; 
			var applyId=tmp2;
			var memberPhoneNumber = $("#applyPhone").val();
			if(!isMobil(memberPhoneNumber)){
				showMessagem("请输入正确的手机号!");
				return false;
			}
			$.youi.ajaxUtils.ajax({
				url:baseUrl+ "activityApplylistManager/getActivityCaptcha.json",
				data:{phone:memberPhoneNumber,applyId:applyId},
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					var record = result.record;
					if(!record.flag){
						enableSmsButton(3,capt,'重新获取');
					}else{
						enableSmsButton(60,'发送成功','重新获取');
					} 
					$('#sendMobileCaptcha').attr('onclick','volid(0);');
				},
				error:function(msg){
					enableSmsButton(3,msg,'重新获取');
				}
			});
		};
		function enableSmsButton(sec,processText,enableText){
			$('#sendMobileCaptcha').html(processText + '(' + sec + ')');
			if(sec <= 0){
				$('#sendMobileCaptcha').html(enableText);
				$('#sendMobileCaptcha').attr('onclick','getCaptcha();');
			}
			else{
				t(sec,processText,enableText);
			}
		};
		function t(sec,processText,enableText){
			var m=setTimeout(function(){
				enableSmsButton(sec - 1,processText,enableText);
			},1000);
			if($(".bg-tanc").is(":hidden")){
				clearTimeout(m);
			}
		};
		//报名提交
		$('.ib-btn').click(function(){
			var url=location.href; 
			var tmp1=url.split("?")[1];  
			var tmp2=tmp1.split("=")[1]; 
			var applyId=tmp2;
			var applyMember=$("#applyMember").val();
			var applyPhone=$("#applyPhone").val();
			var captcha = $("#captcha").val();
			if(applyMember==''||applyMember==null){
				showMessagem("请输入姓名!");
				return false;
			}
			if(!isMobil(applyPhone)){
				showMessagem("请输入正确的手机号!");
				return false;
			}
			if(captcha==''||captcha==null){
				showMessagem("请获取短信校验码!");
				return false;
			}
			var serviceURL = baseUrl+"activityApplylistManager/saveActivityApplylistForPage.json";
			var params = ['activityApply.applyId='+applyId,'applyMember='+applyMember,'applyPhone='+applyPhone,'captcha='+captcha];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.record){
						var record = results.record;
						if(record.flag){
							showMessagem(record.buff);
			         		setTimeout(function(){$(".bg-tanc").hide();},2000);
						}
					}
				},
				error:function(msg){
					showMessagem(msg);
				}
			});	
		});
		//校验手机号格式
		function isMobil(s) {
		    	var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
		   		if (!patrn.exec(s)) return false
		   	 	return true
		};
		function showMessagem(message){
	     	$(".error-toast").animate({top:"20px",opacity:"1"});
	     	$(".error-toast p").html(message);
	 		setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
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