$(function(){
	$("#submit-ib").click(function(){
		var obj=["nmIssuenews.policyId="+$("form").attr("class")];//获取当前政策ID
		//判断是否是企业员工
		$.youi.ajaxUtils.ajax({
		url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.record){
				var policyApplyConpanyName = $("#policyApplyConpanyName").val();
				var policyApplyContactPeople = $("#policyApplyContactPeople").val();
				var policyApplyContactTel = $("#policyApplyContactTel").val() ;
				if(policyApplyConpanyName == ""){
					showMessage("请输入公司名称！");
					return ;
				}
				if(policyApplyContactPeople == ""){
					showMessage("请输入联系人！");
					return ;
				}
				if(policyApplyContactTel == ""){
					showMessage("请输入联系手机！");
					return ;
				}
				var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;//手机号的格式
				if(! isMobile.test(policyApplyContactTel)){
					showMessage("请输入正确的手机号！");
					return ;
				}  
				$("#loading").removeClass("undis") ;//页面加载显示动态效果
				var obj1=[
				 "policyApplyConpanyName="+policyApplyConpanyName,
		         "policyApplyContactPeople="+policyApplyContactPeople,
		         "policyApplyContactTel="+policyApplyContactTel
		         ];
				var newobj=obj.concat(obj1);//拼接数组，将政策ID与其他的字段拼接起来
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"policyApplyManager/savePolicyApply.json",
					data:newobj.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
						console.log(results) ;
						if(results.record){
							$("#policyApplyConpanyName").val("");//将输入框内容置为空
							$("#policyApplyContactPeople").val("");
							$("#policyApplyContactTel").val("");
							$(".bg-tanc.m1").hide();//隐藏表单
							$("#loading").addClass("undis") ;
							//弹出弹框，指定时间跳转，取消则不跳转
							$(".bg-tanc.m2").show() ;
							$('#ti-m1').text('5');
							a=5;
							timer=setInterval("jump1()",1000);
						}else{
							close("未知错误，申请失败！");
						}
					}
				});
			}
		}});
	});
});
$(function(){
	$("#zcyh").hide() ;//隐藏优惠政策div
	$("#loading").removeClass("undis") ;//页面加载显示动态效果
	var params=["issueTypeCode=02"];//02表示优惠政策
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"nmIssuetypeManager/getNewsType.json",//得到优惠政策的子类型
		data:params.join('&'),
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.records){
				_parseRecords(result.records);
			}
		}
	});
});
//拼接政策新闻列表
function _parseRecords(record){
	if(record.length == 0){
		$(".fl.w895").append("<div><p><h2>暂时还没有任何的政策优惠哦！</h2></p></div>");
		return ;
	}else{
		for(var i=0;i<record.length;i++){
			var issueTypeCode = record[i].issueTypeCode ;
			var t = "<h3 class='h3-c-o mt20' id='"+issueTypeCode+"'>"+record[i].issueTypeCaption+"</h3>" ;
			$(".fl.w895").append(t);
			var params=["issueTypeCode="+issueTypeCode];
			$.youi.ajaxUtils.ajax({
				url:baseUrl +"nmIssuenewsManager/getNmIssuenewsByIssueTypeCode.json",//得到优惠政策的子类型
				data:params.join('&'),
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.records){
						console.log(result.records) ;
						getH(result.records) ;
					}
				}
			});
		}
		/* $(".w895 >h3").each(function(i){
			
			var id = $(this).attr("id") ;
			if(i==1){
				var htm = '<div class="index-group mb30 mt40"><img src="../styles/images/zs/con2.jpg" /></div>';
				$("#"+id).before(htm) ;
			}
		}); */
	}
};
	function getH(record){
	for(var i=0;i<record.length;i++){
		var issueTypeCode = record[i].policyType.issueTypeCode ;
		var status = record[i].policyStatus ;
		if(status == 1){//状态为1表示已发布，为0表示未发布
			var html="<div class='index-group' id="+record[i].policyId+">"+
						 "<h5>"+record[i].policyCaption+"</h5>"+
	               		 "<div class='ig-box'>"+record[i].policyContent+
		                   	 "<a href='javascript:;' class='ib-btn ib-1' >在线申请</a>"+
		           			 "</div>"+
       				 "</div>";
       		$(".w895 >h3").each(function(i){
				var id = $(this).attr("id") ;
				if(id == issueTypeCode){
					$("#"+id).after(html) ;
				}
			});
		}
	}
	$("#zcyh").show() ;//显示优惠政策div
	$("#loading").addClass("undis") ;//页面加载显示动态效果关闭
} 
	$(function () {
		//点击关闭弹窗
		$(".close-toast").click(function(){
	            $(".toast").hide();
	    })
		$(".index-fr-nav li").click(function(){
			$(".index-fr-nav li").removeClass("active");
			$(this).addClass("active");
			$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
		});
		$(document).on("click",".ib-1",function(){
			
			obj = $(this).parent().parent().attr("id") ;
			$(".bg-tanc.m1").find("form").attr("class",obj);
			if(!isLogin){
				close("匿名用户不能申请！");
				return ;
			}else{
				$(".bg-tanc.m1").hide() ;//隐藏表单div
				$("#loading").removeClass("undis") ;//页面加载显示动态效果
				$.youi.ajaxUtils.ajax({
					url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.record){
							var obj = result.record ;
							var name = obj.member.memberName;
							var mobile = obj.member.memberPhoneNumber;
							var rzName = obj.rz.rzName ;
							$("#policyApplyConpanyName").val(rzName);
							$("#policyApplyContactPeople").val(name);
							$("#policyApplyContactTel").val(mobile) ;
							$("#loading").addClass("undis") ;//页面加载隐藏动态效果
							$(".bg-tanc.m1").show();
						}else{
							$("#loading").addClass("undis") ;//页面加载隐藏动态效果
							close("非企业会员不能申请哦！");
							return ;
						}
					}
				}) ;
			} 
		});
		$(".tc-close").click(function(){
			clearInterval(timer);
		});
	})
	
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
        $(".tc.mt25.f18").append(content) ;
        $(".toast").show();
        pltime=1;
        timer=setInterval("closeTanc()",1000);
    }
  //显示信息
 function showMessage(message){
  	$(".error-toast").animate({top:"20px",opacity:"1"});
  	$(".error-toast p").html(message);
		setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
  }
 	var a;
	function jump1(){
		if(a>1){
			a--;
			$("#ti-m1").text(a);
		}else{
			jump();
		}		
	}
	//跳转我的政策
	 function jump(){
	 	window.location.href=cenUrl+"member/memberCenter/personalCenter/policyApply.html";
	 }
	 //跳转个人中心
	 function jumpPerson(){
	 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
	 }
	 //跳转首页
	 function jumpIndex(){
	 	window.location.href=cenUrl;
	 }