$(function(){
		$(".slideBox").hover(function(){
      		clearInterval(timer);
		},function(){ timer = setInterval(run,3000)});
		$(".index-fr-nav li").click(function(){
			$(".index-fr-nav li").removeClass("active");
			$(this).addClass("active");
			$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
		});
		$(".ib-btn.open-m1").click(function(){
			//判断用户是否登录了
			if(!isLogin){
				clearInterval(timer);
   				$(".toast").show();
   				pltime=2;
   				timer=setInterval("closeTanc()",1000);
				return false;
			}else{
				$(".bg-tanc.m1").show();
				//开始调用项目类型的下拉显示
				onloadProjectTypesData();
				//开始加载是否融资的数据
				onloadFinancingBoolData();
				//开始加载导师类型的数据
				onloadTeacherTypeData();
			}
		});
		$(".ib-btn.open-m2").click(function(){
			$('body').css("overflow","hidden");
			$(".bg-tanc.m2").show();
			
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
		
		//提交预约按钮操作
		$("#spEntrepreneurshipSubmit").click(function(){
			//项目类型
			var projectType = $(".ic-select p").attr("data");
			if(projectType=="NODATA"){
				alert("请选择项目类型");
				return false;
			}
			
			//项目简介
			var projectDis = $("#projectDis").val();
			if(projectDis==""){
				alert("请填写项目简介");
				return false;
			}
			
			//是否融资选择
			var isFinace = $("#isFinace").find("span.active").attr("data");
			if(isFinace==""){
				alert("请选择是否融资");
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
				alert("请选择导师类型");
				return false;
			}
			console.log(teacherType);
			var params = ['projectType='+projectType,'projectDis='+projectDis,'isFinace='+isFinace,'teacherType='+teacherType,'teacherTypeFlg='+teacherTypeFlg];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+"entrepreneurshipManager/goSaveEntrepreneurship.json", 
				jsonp:'data:jsonp',
				dataType:'jsonp',
				data:params.join('&'),
				success:function(results){
					console.log(results);
					if(results&&results.record){
						window.location.href=cenUrl+"member/memberCenter/personalCenter/policyApply.html";
					}
				}
			});
		});
	})
	
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
					html += '	<p class="c-b1" data="NODATA">请选择订单项目</p>'
					html += '</div>'
					html += '<ul style="display: none;" class="select-nav">'
					html += '	<li data="NODATA">请选择订单项目</li>'
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
				console.log(teacherTypeList);
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