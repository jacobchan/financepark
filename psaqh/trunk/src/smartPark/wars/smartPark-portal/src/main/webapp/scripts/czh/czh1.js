$(function(){

			$(".slideBox li").hover(function(){
	      		clearInterval(timer);
			},function(){ timer = setInterval(run,3000)});

		})
		$(".index-fr-nav li").click(function(){
			$(".index-fr-nav li").removeClass("active");
			$(this).addClass("active");
			$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
		});

		var sbysf_index = 0;
	    var n=$(".cic-nav ul li").length-5;
	    function sbysf_scroll_up(){
	        sbysf_index++;
	        if(sbysf_index > 1){
	            sbysf_index = 0;
	        }
	        sbysf_show(sbysf_index);
	    }
	    function sbysf_scroll_down(){
	        sbysf_index--;
	        if(sbysf_index < 0){
	            sbysf_index = 1;
	        }
	        sbysf_show(sbysf_index);
	    }
	    function sbysf_show(j){
	        var index = -(j*174);
	        $(".cic-nav ul").animate({left: index+'px'},200);
	    }
	    $(".cic-btn.fr").click(function(){
	        sbysf_scroll_up();
	    });
	    $(".cic-btn.fl").click(function(){
	        sbysf_scroll_down();
	    });
	
	$(function(){
		//活动类型数据
		$("#tp_51").removeClass("undis") ;
		var serviceURL = baseUrl+"applayTypeManager/getApplayTypes.json";
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				$("#tp_51").addClass("undis") ;
				if(results&&results.records){
					_parseTypeRecords(results.records);
				}
			}
		});	
		//园区推荐活动数据top4
		$("#tp_52").removeClass("undis") ;
		var serviceURL = baseUrl+"activityApplyManager/getPagerActivityApplys.json";	
		var status = "01";
		var postData = {'pager:pageIndex':1,'pager:pageSize':4,'isRecoomend':0,'applyStatus':status,orderBy:'desc:createTime'};	
		$.youi.ajaxUtils.ajax({
			url:serviceURL,
			data:postData,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				$("#tp_52").addClass("undis") ;
				if(results&&results.records){
				_parseRecoomends(results.records);
				}
			}
		});	
		
		//园区所有活动数据
		var pageSize=5;
		var pageCount=1;
		var activeURL = baseUrl+"activityApplyManager/getPagerActivityApplys.json?applyStatus=01";
		$.youi.ajaxUtils.ajax({
			url:activeURL,
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				pageCount=Math.ceil(results.totalCount/pageSize);
				 refreshData(1,pageSize);
					$(".tcdPageCode").createPage({
					    pageCount:pageCount,
					    current:1,
					    backFn:function(p){
					       this.pageCount=pageCount;
					        refreshData(p,pageSize);
					    }
					});
			}
			/* success:function(results){
				if(results&&results.records){
				_parseRecords(results.records);
				}
			} */
		});	
		function refreshData(pageIndex,pageSize){
			$("#tp_53").removeClass("undis") ;
			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
			$.youi.ajaxUtils.ajax({
				url:activeURL,
				jsonp:'data:jsonp',
				data:params.join('&'),
				dataType:'jsonp',
				success:function(results){
					$("#tp_53").addClass("undis") ;
					if(results&&results.records){
						_parseRecords(results.records);
					}
				}
			});
		}
	});
	//拼接类型数据
	function _parseTypeRecords(record){
		var html='';
		for(var i=0;i<record.length;i++){
			html+="<li>"+
					"<a href='javascript:;' onclick='redirectPageType(this)'; id="+record[i].typeId+"><div><img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].typeIcon+"&method=show' border='0' width='72' height='55' /></div>"+
					"<p>"+record[i].typeName+"</p></a>"+
				  "</li>";
		}
		$('.applayType').empty();
		$('.applayType').append(html);
	}

	//强烈推荐活动数据
	function _parseRecoomends(record){
		var html='';
		for(var i=0;i<record.length;i++){
			 html+="<div class='czh-box mr20' id='"+record[i].applyId+"'>"+
			 			"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].activityImage+"&method=show' width='288' height='195' class=\"loading-2\">"+
						"<div class='czh-group' style='border-bottom:1px solid #ecebeb' id="+record[i].applyId+">"+
							"<a href='javascript:;' onclick='rePage(this)'><h4>"+record[i].applyTitle+"</h4></a>"+
							"<span><img src='../styles/images/czh/clock.png'  class='mr5'>"+record[i].startTime+"</span>"+
							"<span class='fr'><img src=''../styles/images/czh/user.png'  class='mr5'>366</span>"+
							"<span style='border-left:1px solid #ecefef;line-height:16px;height:16px;margin-top:8px;' class='ml10 mr10 fr'></span>"+
							"<span class='fr'><img src=''../styles/images/czh/heart.png'  class='mr5'>183</span>"+
						"</div>"+
						"<div class='czh-group'>"+
							"<img src='../styles/images/czh/logo-1.png' border='0' class='fl mr5'/>"+
							"<span style='line-height:25px;'>创智汇</span>"+
						"</div>"+
					"</div>";
		}
		$('.recoomends').empty();
		$('.recoomends').append(html);	
	}
	function _parseRecords(record){
		var html='';
		for(var i=0;i<record.length;i++){
			html+="<li class='clearfix' onclick='openPage(this)' id='"+record[i].applyId+"'>"+
						"<div class='plg-photo'>"+
						"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].activityImage+"&method=show' border='0' width='100%' class=\"loading-2\"/>"+
							"<em>"+record[i].applayType.typeName+"</em>"+
						"</div>"+
						"<div class='plg-article pr' >"+
							"<h3>"+record[i].applyTitle+"</h3>"+
							"<div class='lh30 mb5'><span><img src='../styles/images/czh/clock.png' border='0' class='mr10'>"+record[i].startTime+"</span>"+
							"<span class='ml40'><img src='../styles/images/zs/user.png' border='0' class='mr10'>限制人数"+record[i].applyMaxuser+"人</span>"+"</div>"+
							"<div class='lh30 mb5'><span><img src='../styles/images/zs/map.png'  border='0' class='mr10'>"+record[i].activityAdr+"</span></div>"+
							"<div class='clearfix lh40' id='111'>"+
							"<div class='fl'><span><img src='../styles/images/czh/logo.png'  border='0' width='75' height='25' class='mr20'></span>"+
							"<span><img src='../styles/images/czh/user-l.png' border='0' class='mr10'>"+record[i].memberId.memberName+"</span>"+
							"</div>"+
								"<div class='fr' id='"+record[i].applyId+"'>";
								if(record[i].documentCount>0){
									html+="<a href='javascript:;' class='c-o mr25 pdf'>在线观看PDF/PPT <i class='fa fa-angle-double-right f16'></i></a>";
								}
								html+="<a href='javascript:;'  class='ib-btn acc' style='margin-top:0px;'>我要报名</a>"+
								"</div>"+
							"</div>"+
						"</div>"+
					"</li>";
		}

		$('.pb-list-group').empty();
		$('.pb-list-group').append(html);
		
		//文档跳转
		$(".c-o.mr25.pdf").click(function(e){
			var id  = $(this).parents("li").attr("id");
			var url="../czh/czh7.html"+"?"+"applyId="+id; 
			window.open(url); 
			e.stopPropagation();	
		});
		//报名弹出
		$(".ib-btn.acc").click(function(e){
			$(".bg-tanc").attr("id",$(this).parents("li").attr("id"));
			$("#applyMember").val('');
			$("#applyPhone").val('');
			$("#captcha").val('');
			$('#sendMobileCaptcha').html("发送验证码");
			$('#sendMobileCaptcha').attr('onclick','getCaptcha();');
			$(".bg-tanc").show();
			e.stopPropagation();	
		});
		$(".tc-close").click(function(){
			$(".bg-tanc").hide();
		});
	};
	function redirectPageType(obj){
		var typeId=obj.id;
		var url="../czh/czh4.html"+"?"+"typeId="+typeId; 
		window.location.assign(url); 
	}
	function rePage(obj){
		var applyId=obj.parentNode.id;
		var url="../czh/czh3.html"+"?"+"applyId="+applyId; 
		window.location.assign(url); 
	}
	function redirectPagePDF(obj){
		var applyId=obj.parentNode.id;
		var url="../czh/czh7.html"+"?"+"applyId="+applyId; 
		window.location.assign(url); 
	}
	function openPage(obj){
		var applyId=obj.id;
		var url="../czh/czh3.html"+"?"+"applyId="+applyId; 
		window.open(url); 
	}
	
	function getCaptcha(){
		var memberPhoneNumber = $("#applyPhone").val();
		var applyId = $(".bg-tanc").attr("id");
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
	}
	function enableSmsButton(sec,processText,enableText){
		$('#sendMobileCaptcha').html(processText + '(' + sec + ')');
		if(sec <= 0){
			$('#sendMobileCaptcha').html(enableText);
			$('#sendMobileCaptcha').attr('onclick','getCaptcha();');
		}
		else{
			t(sec,processText,enableText);
		}
	}
	function t(sec,processText,enableText){
		var m=setTimeout(function(){
			enableSmsButton(sec - 1,processText,enableText);
		},1000);
		if($(".bg-tanc").is(":hidden")){
			clearTimeout(m);
		}
	}
	//报名提交
	$('.submit1').click(function(){
		  	var applyId = $(".bg-tanc").attr("id");
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
			$(".submit1").addClass("undis") ;
			$(".submit2").removeClass("undis") ;
			var serviceURL = baseUrl+"activityApplylistManager/saveActivityApplylistForPage.json";
			var params = ['activityApply.applyId='+applyId,'applyMember='+applyMember,'applyPhone='+applyPhone,'captcha='+captcha];
			$.youi.ajaxUtils.ajax({
				url:serviceURL,
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					$(".submit2").addClass("undis") ;
					$(".submit1").removeClass("undis") ;
					if(results&&results.record){
						var record = results.record;
						if(record.flag){
							showMessagem(record.buff);
			         		setTimeout(function(){$(".bg-tanc").hide();},2000);
						}
					}
				},
				error:function(msg){
					$(".submit2").addClass("undis") ;
					$(".submit1").removeClass("undis") ;
					showMessagem(msg);
				}
			});			  
	});
	//校验手机号格式
	function isMobil(s) {
	    	var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	   		if (!patrn.exec(s)) return false
	   	 	return true
		}
	function showMessagem(message){
     	$(".error-toast").animate({top:"20px",opacity:"1"});
     	$(".error-toast p").html(message);
 		setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
     }
	
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