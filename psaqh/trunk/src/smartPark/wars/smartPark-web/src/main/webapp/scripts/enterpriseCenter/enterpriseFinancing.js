// 中文字符判断
function getStrLength(str) { 
	var len = str.length; 
    var reLen = 0; 
    for (var i = 0; i < len; i++) {        
        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) { 
            // 全角    
            reLen += 2; 
        } else { 
            reLen++; 
        } 
    } 
    return reLen;    
}
//删除专利
function removeFinancing(obj){
 	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/informationFinancingManager/removeInformationFinancing.json',
		data:'financingId='+obj,
		success:function(result){
			$('#toast_text').html('删除成功！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',3000);//1秒=1000
			location.reload();
		}
	});
}
//修改地址
function updateFinancing(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8){
	$("#financingId").val(obj0);
	$("#financingRe").html(obj1);
	$("#financingName").val(obj2);
	$("#financingAmount").val(obj3);
	$("#financingCost").val(obj4);
	$("#financingPre").val(obj5);
	$("#financingTime").val(obj6);
	$("#financingDescribe").val(obj7);
	$("#currentCount").html(getStrLength(obj7));
	
	$("#roundFinancing li").each(function(index){
		$(this).removeClass('selected');
		var text = $(this).text();
	    if(obj8==text){
	    	$(this).addClass("selected");
	    	$(".c-b1").attr("data-val", $(this).attr("data-val"));
	    	$(".c-b1").html(obj8);
	    }
	});
}
$(function() {
	$("#financingDescribe").on('keyup', function() {
	    var len = getStrLength(this.value);
	    $("#currentCount").html(len);
	});
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
		success:function(result){
			if(result&&result.record){
				$("#financingRe").html(result.record.companyId);
				//根据企业id获取融资信息
		    	$.youi.ajaxUtils.ajax({
		    		url : baseUrl+"/informationFinancingManager/findInformationFinancing.json",
		    		data : ['financingRe='+result.record.companyId].join('&'),
		    		success : function(results) {
		    			if (results && results.records) {
		    				var record = results.records;
		    				$("#informationFinancing").empty();
		    				var htmls = [];
		    				for(var i=0; i<record.length; i++){
		    					var financingMsg = "";
		    					var cssStyle = "";
		    					var activeCss = "";
		    					var clearfixCss = "";
		    					var financingId=record[i].financingId;
		    					var financingRe=record[i].financingRe;
		    					var financingName=record[i].financingName;
		    					var financingAmount=record[i].financingAmount;
		    					var financingCost=record[i].financingCost;
		    					var financingPre=record[i].financingPre;
		    					var financingDescribe=record[i].financingDescribe;
		    					var financingSubValue=record[i].financingSubValue;
		    					var financingTime=record[i].financingTime;
		    					var financingStatus=record[i].financingStatus;
		    					if(financingStatus=="1"){
		    						financingMsg = financingTime.substring(0,4)+"年"+financingTime.substring(5,7)+"月";
		    						cssStyle = "yg-time history_time";
		    						activeCss = "em-pa";
		    						clearfixCss = "clearfix";
		    					}else{
		    						financingMsg = "进行中...";
		    						cssStyle = "yg-time";
		    						activeCss = "em-pa_active";
		    						clearfixCss = "clearfix active";
		    					}
		    					htmls.push('<div class="'+cssStyle+'">'+
			    					'<div class="yt-pa"><span>'+financingMsg+'</span></div>'+
			    					'<em class="'+activeCss+'"></em>'+
			    					'<div class="'+clearfixCss+'">'+
			    						'<span>'+financingSubValue+'</span><span>融资金额：<em class="c-o">'+financingAmount+'万元</em></span><span>融资估值：<em class="c-o">'+financingCost+'万元</em></span><span>可持股份：<em class="c-o">'+financingPre+'%</em></span>'+
			    					'</div>'+
			    					'<p>'+financingDescribe+'</p>'+
			    			        '<p class="mt10"><a href="javascript:updateFinancing(\''+financingId+'\',\''+financingRe+'\',\''+financingName+'\',\''+financingAmount+'\',\''+financingCost+'\',\''+financingPre+'\',\''+financingTime+'\',\''+financingDescribe+'\',\''+financingSubValue+'\');">编辑</a>&nbsp;丨&nbsp;<a href="javascript:removeFinancing(\''+financingId+'\');">删除</a></p>'+
			    				'</div>');
		    				}
		    				$("#informationFinancing").html(htmls.join(''));
		    			}
		    		}
		    	});
			}
		}
	});
	$(".save_btn").click(function(){
		var financingId=$("#financingId").val();
  		var financingRe=$("#financingRe").html();
  		var financingName=$("#financingName").val();
  		var financingAmount=$("#financingAmount").val();
  		var financingCost=$("#financingCost").val();
		var financingPre=$("#financingPre").val();
		var financingTime=$("#financingTime").val();
		var financingDescribe=$("#financingDescribe").val();
		var financingSub=$('#roundFinancing li.selected').attr("data-val");
		var params = ['financingId='+financingId+'','financingRe='+financingRe+'','financingName='+financingName+'','financingAmount='+financingAmount+'','financingCost='+financingCost+'','financingPre='+financingPre+'','financingTime='+financingTime+'','financingDescribe='+financingDescribe+'','financingSub='+financingSub+''];
		//金额正则表达式
		var regex = /^\d+\.?\d{0,2}$/;
		if(financingSub==null || financingSub=="" || financingSub.length==0){
			$('#toast_text').html('融资伦次不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(financingName=="" || financingName.length==0){
			$('#toast_text').html('融资企业名称不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(financingAmount=="" || financingAmount.length==0){
			$('#toast_text').html('融资金额不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(!regex.test(financingAmount)){
			$('#toast_text').html('融资金额格式不正确！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(financingCost=="" || financingCost.length==0){
			$('#toast_text').html('融资估值不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(!regex.test(financingCost)){
			$('#toast_text').html('融资估值格式不正确！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(financingPre=="" || financingPre.length==0){
			$('#toast_text').html('可持股份不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(!regex.test(financingPre)){
			$('#toast_text').html('可持股份格式不正确！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(financingTime=="" || financingTime.length==0){
			$('#toast_text').html('融资时间不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		if(financingDescribe=="" || financingDescribe.length==0){
			$('#toast_text').html('融资描述不能为空！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',2000);//1秒=1000
			return false;
		}
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'/informationFinancingManager/saveInformationFinancing.json',
			data:params.join('&'),
			success:function(result){
				if(result && result.record){
					$('#toast_text').html('保存成功！');
					$(".toast").show();
		            setTimeout('$(".toast").hide();',3000);//1秒=1000
		            location.reload();
				}
			}
		});
	});
	var start = {
		elem: '#financingTime',
		min: '2000-01-01 23:59:59', //设定最小日期为当前日期
		max: '2099-06-16 23:59:59', //最大日期
		istoday: false,
		choose: function(datas){
		    end.min = datas; //开始日选好后，重置结束日的最小日期
		    end.start = datas; //将结束日的初始值设定为开始日
		}
	};
	laydate(start);
	
	$.ajax({
		url:baseUrl+'/informationFinancingManager/findCodeitem.json?code=roundFinancing',
		success:function(result){
			if(result&&result.records){
				var records = result.records;
				$("#roundFinancing").empty();
				for(var i=0; i<records.length; i++){
					$("#roundFinancing").append("<li data-id='"+records[i].itemId+"' data-val='"+records[i].itemValue+"'>"+records[i].itemCaption+"</li>");
				}
			}
		}
	});
	
	$(".qiye_address").on("click",function(){
		$("#roundFinancing").toggle();
	});
    
	$("#roundFinancing").on("click","li",function(){
		$(this).addClass("selected").siblings().removeClass("selected");
		var selecttext = $(this).text();
		var val = $(this).attr("data-val");
		$(".c-b1").text(selecttext).attr("data-val",val);
	});
	
	$("#moreul").slideDown("slow");
  	$("#moreul > li:eq(1)").addClass("active");
});