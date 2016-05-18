$(function(){
		$(".set-file").hover(function(){
			$(this).prev(".set-file1").css("background","#fff");
		},function(){
			$(this).prev(".set-file1").css("background","#fff");
		})
	
		$(".slideBox").hover(function(){
      		clearInterval(timer);
		},function(){ 
			//timer = setInterval(run,3000)
			});
		
		$(".index-fr-nav li").click(function(){
			$(".index-fr-nav li").removeClass("active");
			$(this).addClass("active");
			$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
		});
		$(".ib-btn.open-m1").click(function(){
			//加速申请页面弹出
			spEntrepreneurshipShow();
		});
		$(".ib-btn.open-m2").click(function(){
			//融资申请页面显示
			finaceShow();
		});
		$(".ib-btn.open-m3").click(function(){
			//$(".bg-tanc.m3").show();
			window.location="../zscenter/zs6.html";
		});
		$(".tc-close").click(function(){
			$('body').css("overflow","auto");
			$(".bg-tanc").hide();
		});
		$(document).on("click",".speed-sort li",function(){
			$(this).addClass("active").siblings().removeClass("active");
		})
		laydate({
		    elem: '#fkcodeDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		
		 //关闭toast
        $(".close-toast").click(function(){
            $(".toast").hide();
        })
		
        //从数据一览页面跳转判断弹出申请页面
        if(getRequest()=="1"){
        	//加速申请页面弹出
			spEntrepreneurshipShow();
        }else if(getRequest()=="2"){
        	//融资申请页面显示
			finaceShow();
        }
		//创业加速计划提交预约按钮操作
		$(".submit1").click(function(){
			//项目类型
			var projectType = $(".ic-select p").attr("data");
			if(projectType=="NODATA"){
				showMessage("请选择项目类型");
				//设置边框颜色变红
				$("#codeProjectType").addClass("bk2");     //添加样式bk2
				$("#codeProjectType").removeClass("bk1") ; //移除样式bk1
				//3秒后边框颜色还原
				setTimeout(function(){
					$("#codeProjectType").addClass("bk1");   //添加样式bk2
					$("#codeProjectType").removeClass("bk2");//移除样式bk1
					} ,3000);    //3000为3000毫秒，=3秒
				return false;
			}
			
			//项目简介
			var projectDis = $("#projectDis").val();
			if(projectDis==""){
				showMessage("请填写项目简介");
				//设置边框颜色变红
				$("#projectDis").addClass("bk2");     //添加样式bk2
				$("#projectDis").removeClass("bk1") ; //移除样式bk1
				//3秒后边框颜色还原
				setTimeout(function(){
					$("#projectDis").addClass("bk1");   //添加样式bk2
					$("#projectDis").removeClass("bk2");//移除样式bk1
					} ,3000);    //3000为3000毫秒，=3秒
				return false;
			}
			
			//是否融资选择
			var isFinace = $("#isFinace").find("span.active").attr("data");
			if(isFinace==""){
				showMessage("请选择是否融资");
				//设置边框颜色变红
				$("#isFinace").addClass("bk2");     //添加样式bk2
				$("#isFinace").removeClass("bk1") ; //移除样式bk1
				//3秒后边框颜色还原
				setTimeout(function(){
					$("#isFinace").addClass("bk1");   //添加样式bk2
					$("#isFinace").removeClass("bk2");//移除样式bk1
					} ,3000);    //3000为3000毫秒，=3秒
				return false;
			}
			
			//导师类型
			var teacherType = $("#teacherType").find("li.active").attr("data");
			var teacherTypeFlg="0";
			if(teacherType==undefined){
				teacherTypeFlg="1";
				teacherType = $("#teacherType").find("li.active input").val();
			}
			
			if(teacherType==""){
				showMessage("请选择导师类型");
				//设置边框颜色变红
				$("#teacherType").addClass("bk2");     //添加样式bk2
				$("#teacherType").removeClass("bk1") ; //移除样式bk1
				//3秒后边框颜色还原
				setTimeout(function(){
					$("#teacherType").addClass("bk1");   //添加样式bk2
					$("#teacherType").removeClass("bk2");//移除样式bk1
					} ,3000);    //3000为3000毫秒，=3秒
				return false;
			}
			$(".submit1").addClass("undis") ;
			$(".submit2").removeClass("undis") ;
			var params = ['projectType='+projectType,'projectDis='+projectDis,'isFinace='+isFinace,'teacherType='+teacherType,'teacherTypeFlg='+teacherTypeFlg];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+"entrepreneurshipManager/goSaveEntrepreneurship.json", 
				jsonp:'data:jsonp',
				dataType:'jsonp',
				data:params.join('&'),
				success:function(results){
					$(".submit2").addClass("undis") ;
					$(".submit1").removeClass("undis") ;
					if(results&&results.record){
						window.location.href=cenUrl+"member/memberCenter/personalCenter/policyApply.html?showFlg=1";
					}
				},
				error:function(msg){
					$(".submit2").addClass("undis") ;
					$(".submit1").removeClass("undis") ;
				}
			});
		});
        
        //加载硅谷创业营精彩活动top2、一览表
        plactive();
	});

	//限制融资额度（起）只能为数字
	$("#amountStart").on("input",function(){
		var amountStart=$(this).val();
		var reg=/^[+]?(([0-9]*\.[1-9]{0,2})|([0-9]*))$/;
		if(!reg.test(amountStart)){
			var subString=amountStart.substr(0,amountStart.length-1);
			$(this).val(subString);
		}
	});
	
	//限制融资额度（止）只能为数字
	$("#amountEnd").on("input",function(){
		var amountEnd=$(this).val();
		var reg=/^[+]?(([0-9]*\.[1-9]{0,2})|([0-9]*))$/;
		if(!reg.test(amountEnd)){
			var subString=amountEnd.substr(0,amountEnd.length-1);
			$(this).val(subString);
		}
	});
	
	//股份占比只能为数字
	$("#shareRate").on("input",function(){
		var shareRate=$(this).val();
		var reg=/^[+]?(([0-9]*\.[1-9])|([0-9]*))$/;
		if(!reg.test(shareRate)){
			var subString=shareRate.substr(0,shareRate.length-1);
			$(this).val(subString);
		}
	});
	
	//融资申请提交预约按钮操作
	$(".submit3").click(function(){
		//公司名称
		var companyName = $("#companyName").val();
		if(companyName==""){
			showMessage("请填写公司名称");
			//设置边框颜色变红
			$("#companyName").addClass("bk2");     //添加样式bk2
			$("#companyName").removeClass("bk1") ; //移除样式bk1
			//4秒后边框颜色还原
			setTimeout(function(){
				$("#companyName").addClass("bk1");   //添加样式bk2
				$("#companyName").removeClass("bk2");//移除样式bk1
				} ,3000);    //3000为3000毫秒，=3秒
			return false;
		}
		
		//主页地址
		var companyUrl = $("#companyUrl").val();
		if(companyUrl==""){
			showMessage("请填写主页地址");
			//设置边框颜色变红
			$("#companyUrl").addClass("bk2");     //添加样式bk2
			$("#companyUrl").removeClass("bk1") ; //移除样式bk1
			//4秒后边框颜色还原
			setTimeout(function(){
				$("#companyUrl").addClass("bk1");   //添加样式bk2
				$("#companyUrl").removeClass("bk2");//移除样式bk1
				} ,3000);    //3000为3000毫秒，=3秒
			return false;
		}
		//融资额度（起）
		var amountStart = $("#amountStart").val();
		if(amountStart==""){
			showMessage("请填写融资额度");
			//设置边框颜色变红
			$("#amountStart").addClass("bk2");     //添加样式bk2
			$("#amountStart").removeClass("bk1") ; //移除样式bk1
			//3秒后边框颜色还原
			setTimeout(function(){
				$("#amountStart").addClass("bk1");   //添加样式bk2
				$("#amountStart").removeClass("bk2");//移除样式bk1
				} ,4000);    //4000为4000毫秒，=4秒
			return false;
		}
		//融资额度（止）
		var amountEnd = $("#amountEnd").val();
		if(amountEnd==""){
			showMessage("请填写融资额度");
			//设置边框颜色变红
			$("#amountEnd").addClass("bk2");     //添加样式bk2
			$("#amountEnd").removeClass("bk1") ; //移除样式bk1
			//3秒后边框颜色还原
			setTimeout(function(){
				$("#amountEnd").addClass("bk1");   //添加样式bk2
				$("#amountEnd").removeClass("bk2");//移除样式bk1
				} ,3000);    //3000为3000毫秒，=3秒
			return false;
		}
		if(amountStart>=amountEnd){
			showMessage("请填写融资额度");
			//设置边框颜色变红
			$("#amountEnd").addClass("bk2");     //添加样式bk2
			$("#amountEnd").removeClass("bk1") ; //移除样式bk1
			//3秒后边框颜色还原
			setTimeout(function(){
				$("#amountEnd").addClass("bk1");   //添加样式bk2
				$("#amountEnd").removeClass("bk2");//移除样式bk1
				} ,3000);    //3000为3000毫秒，=3秒
			return false;
		}
		//股份占比
		var shareRate = $("#shareRate").val();
		if(shareRate==""){
			showMessage("请填写股份占比");
			//设置边框颜色变红
			$("#shareRate").addClass("bk2");     //添加样式bk2
			$("#shareRate").removeClass("bk1") ; //移除样式bk1
			//3秒后边框颜色还原
			setTimeout(function(){
				$("#shareRate").addClass("bk1");   //添加样式bk2
				$("#shareRate").removeClass("bk2");//移除样式bk1
				} ,3000);    //3000为3000毫秒，=3秒
			return false;
		}else{
			//判断比例是否大于100
			if(shareRate>100){
				showMessage("股份占比不能大于100%");
				//设置边框颜色变红
				$("#shareRate").addClass("bk2");     //添加样式bk2
				$("#shareRate").removeClass("bk1") ; //移除样式bk1
				//3秒后边框颜色还原
				setTimeout(function(){
					$("#shareRate").addClass("bk1");   //添加样式bk2
					$("#shareRate").removeClass("bk2");//移除样式bk1
					} ,3000);    //3000为3000毫秒，=3秒
				return false;
			}
		}
		//业务简介
		var businessDis = $("#businessDis").val();
		if(businessDis==""){
			showMessage("请填写业务简介");
			//设置边框颜色变红
			$("#businessDis").addClass("bk2");     //添加样式bk2
			$("#businessDis").removeClass("bk1") ; //移除样式bk1
			//3秒后边框颜色还原
			setTimeout(function(){
				$("#businessDis").addClass("bk1");   //添加样式bk2
				$("#businessDis").removeClass("bk2");//移除样式bk1
				} ,3000);    //3000为3000毫秒，=3秒
			return false;
		}
		//公司优势
		var companyMerite = $("#companyMerite").val();
		if(companyMerite==""){
			showMessage("请填写公司优势");
			//设置边框颜色变红
			$("#companyMerite").addClass("bk2");     //添加样式bk2
			$("#companyMerite").removeClass("bk1") ; //移除样式bk1
			//4秒后边框颜色还原
			setTimeout(function(){
				$("#companyMerite").addClass("bk1");   //添加样式bk2
				$("#companyMerite").removeClass("bk2");//移除样式bk1
				} ,4000);    //4000为4000毫秒，=4秒
			return false;
		}
		//核心成员
		var corTeam = $("#corTeam").val();
		if(corTeam==""){
			showMessage("请填写核心成员");
			//设置边框颜色变红
			$("#corTeam").addClass("bk2");     //添加样式bk2
			$("#corTeam").removeClass("bk1") ; //移除样式bk1
			//4秒后边框颜色还原
			setTimeout(function(){
				$("#corTeam").addClass("bk1");   //添加样式bk2
				$("#corTeam").removeClass("bk2");//移除样式bk1
				} ,4000);    //4000为4000毫秒，=4秒
			return false;
		}
		//防止表单重复提交
		$(".submit3").addClass("undis") ;
		//一秒钟后才能再次提交
		setTimeout(function(){
			$(".submit3").removeClass("undis") ;
		},2000);
		//$(".submit4").removeClass("undis") ;
		var params = ['companyName='+companyName,'companyUrl='+companyUrl,'amountStart='+amountStart,
		              'amountEnd='+amountEnd,'shareRate='+shareRate,'businessDis='+businessDis,
		              'companyMerite='+companyMerite,'corTeam='+corTeam];
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"finaceManager/goSaveFinace.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			data:params.join('&'),
			success:function(results){
				$(".submit3").removeClass("undis") ;
				$(".submit4").addClass("undis") ;
				if(results&&results.record){
					window.location.href=cenUrl+"member/memberCenter/personalCenter/policyApply.html?showFlg=2";
				}
			},
			error:function(msg){
				$(".submit3").removeClass("undis") ;
				$(".submit4").addClass("undis") ;
			}
		});
	});
	
	//获取精彩活动top2	、一览表
	function plactive(){
		//获取创业营类型id
		$("#tp_55").removeClass("undis") ;
		$("#tp_56").removeClass("undis") ;
		var name = "03";//创业营类型编码
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"applayTypeManager/getApplayTypes.json",
			data:['typeCode='+name].join('&'),
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(results){
				if(results&&results.records){
					if(results.records.length>0){
						pageplactive(results.records);//活动top2
						pagechart(results.records);//一览表
					}
				}
			}
		});
	}
	//活动top2
	function pageplactive(record){
		var typecode = record[0].typeId;
		var status = "01";
		var postData = {'pager:pageIndex':1,'pager:pageSize':2,'applayType.typeId':typecode,'applyStatus':status,orderBy:'desc:createTime'};	
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"activityApplyManager/getPagerActivityApplys.json",
			jsonp:'data:jsonp',
			data:postData,
			dataType:'jsonp',
			success:function(results){
				$("#tp_55").addClass("undis") ;
				if(results&&results.records){
					var record = results.records;
					var html = "";
					html +="<h3 class='cic-act'>精彩活动</h3>";
					for(var i=0;i<record.length;i++){
						var temp = record[i].commentContent ;
		 				var start = temp.indexOf("<p>");
		 				var end = temp.indexOf("</p>");
		 				var content = temp.substring(start+3,end) ;
		 				if(content.length>100){
		 					content = content.substring(0,86)+"......";
		 				}
						html+="<div class='cic-group' style='cursor:pointer' onclick='opPage(this)' id="+record[i].applyId+">"+
							"<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].activityImage+"&method=show' style='width: 277px;height: 164px;' border='0'>"+
							"<h4>"+record[i].applyTitle+"</h4>"+
							"<p>"+content+"</p></div>";
					}
					$('.spactive').empty();
					$('.spactive').append(html);
				}
			}
		});
	}
	
	//拼接一览表
	function pagechart(record){
		var typecode = record[0].typeId;
		var postData = {'applayType.typeId':typecode,orderBy:'desc:startTime'};	
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"activityApplyManager/getPagerActivityApplys.json",
			jsonp:'data:jsonp',
			data:postData,
			dataType:'jsonp',
			success:function(results){
				$("#tp_56").addClass("undis") ;
				if(results&&results.records){
					var record = results.records;
					var html = "";
					for(var i=0;i<record.length;i++){
						var status = record[i].applyStatus ;
		 				if(status=='01'){
		 					var star = record[i].startTime;
		 					var mon = getmonth(star);
		 					var min = gethour(star);
		 					html +="<div style='cursor:pointer' onclick='opPage(this)' id="+record[i].applyId+"><em class='em1'>"+mon+"</em><p>"+record[i].applyTitle+"</p><span>"+min+"</span></div>";
		 				}
		 				if(status=='02'){
		 					var star = record[i].startTime;
		 					var mon = getmonth(star);
		 					var min = gethour(star);
		 					html +="<div style='cursor:pointer' onclick='opPage(this)' id="+record[i].applyId+"><em class='em2'>"+mon+"</em><p>"+record[i].applyTitle+"</p><span>"+min+"</span></div>";
		 				}
					}
					$('.cic-trip').empty();
					$('.cic-trip').append(html);
				}
			}
		});
	}
	//跳转活动详情
	function opPage(obj){
		var applyId=obj.id;
		var url="../czh/czh3.html"+"?"+"applyId="+applyId; 
		window.location.assign(url); 
	}
	
	
	//截取月年
	function getmonth(time){
		var data = "";
		var index1=time.indexOf("-"); 
		var index2=time.lastIndexOf("-"); 
		var cha=parseInt(index2)-(parseInt(index1)+1); 
		var month=time.substr((parseInt(index1)+1),cha); 
		var kg=time.indexOf(" ");
		cha=parseInt(kg)-(parseInt(index2)+1); 
		var day=time.substr(parseInt(index2)+1,cha); 
		date = month+"月"+day+"日";
		return date;
	}
	
	//截取时间
	function gethour(time){
		var data = "";
		var kg=time.indexOf(" "); 
		var mh=time.indexOf(":"); 
		cha=parseInt(mh)-(parseInt(kg)+1); 
		var hour=time.substr(parseInt(kg)+1,cha); 
		var mh2=time.lastIndexOf(":"); 
		cha=parseInt(mh2)-(parseInt(mh)+1); 
		var min=time.substr(parseInt(mh)+1,cha); 
		date = hour+":"+min; 
		return date;
	}
	
	//项目类型加载数据
	function onloadProjectTypesData(){
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"entrepreneurshipManager/getProjectType.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				var codeProjectTypeList = result.records;
				var html = "";
					html += '<div class="ic-select" style="background: transparent url(../styles/images/yqfw/down.png) no-repeat scroll right center;">'
					html += '	<p class="c-b1" data="NODATA">请选择项目类型</p>'
					html += '</div>'
					html += '<ul style="display: none;" class="select-nav">'
					for(var index=0;index<codeProjectTypeList.length;index++){
						html += '	<li data='+codeProjectTypeList[index].itemValue+'>'+codeProjectTypeList[index].itemName+'</li>'
					}
					html += '</ul>'
				$("#codeProjectType").html(html);
				activeProjectTypesClick();
			}
		});
	}
	
	//融资是否加载数据
	function onloadFinancingBoolData(){
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"entrepreneurshipManager/getBool.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				var financingList = result.records;
				var html = "";
					html += '<span data='+financingList[0].itemValue+' class="active">'+financingList[0].itemName+'</span>'
					html += '<span data='+financingList[1].itemValue+'>'+financingList[1].itemName+'</span>'
				$("#isFinace").html(html);
				activeFinancingBool();
			}
		});
	}
	
	//导师类型加载数据
	function onloadTeacherTypeData(){
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"entrepreneurshipManager/getTeacherType.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				var teacherTypeList = result.records;
				var html = "";
					for(var index=0;index<teacherTypeList.length;index++){
						if(teacherTypeList[index].itemValue=="05"){
							html += '<li style="padding:0px 20px 0px 0px;">'
							html += '	<input type="text" placeholder="您还可以输入自定义的导师类型" style="width:195px;border:0px">'
							html += '</li>'
						}else{
							html += '<li '
							if(teacherTypeList[index].itemValue=="01"){
								html += 'class="active" '
							}
							html += 'data='+teacherTypeList[index].itemValue+'>'+teacherTypeList[index].itemName+'</li>'
						}
					}
				$("#teacherType").html(html);
			}
		});
	}
	
	//融资申请（公司名称、主页地址加载）
	function onloadCompanyData(){
		$.youi.ajaxUtils.ajax({
			url:baseUrl+"finaceManager/getCompanyData.json", 
			jsonp:'data:jsonp',
			dataType:'jsonp',
			success:function(result){
				var companyList = result.records;
				if(companyList.length>0){
					$("#companyName").val(companyList[0].rzName);
					$("#companyUrl").val(companyList[0].rzUrl);
				}
			}
		});
	}
	
	//项目类型下拉效果
	function activeProjectTypesClick(){
		$(".ic-select").click(function(e){
			$(".select-nav").hide();
		    $(this).next(".select-nav").show();
		    e.stopPropagation();//
		});
		$(".select-nav li").click(function(){
			$(this).parents(".tct-select").find(".ic-select p").text($(this).text());
			var livale = $(this).attr("data"); 
			$(this).parents(".tct-select").find(".ic-select p").attr("data",livale);
			$(this).parent().hide();
		})
	};
	
	//是否融资效果
	function activeFinancingBool(){
		$(".sex-group span").click(function(){
			$(this).addClass("active").siblings().removeClass("active");
		})
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
    
    //加速申请页面显示
    function spEntrepreneurshipShow(){
    	//判断用户是否登录了
    	$.getScript(cenUrl+'portal/userInfo.html',function(){
			var loc = encodeURIComponent(window.location.href);
			if($.youi.serverConfig.authorization){
				$(".bg-tanc.m1").show();
				//开始调用项目类型的下拉显示
				onloadProjectTypesData();
				//开始加载是否融资的数据
				onloadFinancingBoolData();
				//开始加载导师类型的数据
				onloadTeacherTypeData();
			}else{
				clearInterval(timer);
				$(".toast").show();
				pltime=2;
				timer=setInterval("closeTanc()",1000);
				return false;
			}
		});	
    }
    
    //融资申请页面显示
    function finaceShow(){
    	//判断用户是否登录了
    	$.getScript(cenUrl+'portal/userInfo.html',function(){
			var loc = encodeURIComponent(window.location.href);
			if($.youi.serverConfig.authorization){
				$('body').css("overflow","hidden");
				$(".bg-tanc.m2").show();
				//融资申请（公司名称、主页地址加载）
				onloadCompanyData();
			}else{
				clearInterval(timer);
				$(".toast").show();
				pltime=2;
				timer=setInterval("closeTanc()",1000);
				return false;
			}
		});	
    }
    
    //显示信息
    function showMessage(message){
    	$(".error-toast").animate({top:"800px",opacity:"1"});
    	$(".error-toast p").html(message);
    	setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
    }
    
  //获取链接后面的值
	function getRequest() {
		var url = location.search; //获取url中"?"符后的字串
		if (url.indexOf("?") != -1) { //判断是否有参数
			var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
			strs = str.split("="); //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
			return strs[1];
		}
	}