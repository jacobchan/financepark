	//弹窗
	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){location.reload(); },2000);
    }
    //加载页面
    $(function(){					
		var arg=getQueryStringArgs();
		var fkcodeId =arg.fkcodeId;
		  // alert(fkcodeId);
		$.ajax({
			url:baseUrl+'propertyservicemanagerFkcodeManager/getFkByFkcodeId.json',
			data:'fkcodeId='+fkcodeId,
			success:function(result){					    		           
				if(result&&result.record){
					var record = result.record;
					var fkcodeComp="";
					var cancelbutton="";
					var dksataus="";
					//alert(record.dksataus);
					if(record.dksataus=="00"){
						status = "未到访";	
						cancelbutton="<a href='javascript:;' class='pb-btn tc' onclick='javascript:cancel()'>取消访客</a>";
						//$('#fkCode').html(cancelbutton);
					}else if(record.dksataus=='01'){
						status = "未到访";				
					}else if(record.dksataus=='02'){
						status = "已到访";
					}else if(record.dksataus=='03'){
						status = "已取消";
					}
					$('#fkCode').html(record.fkCode+"&nbsp&nbsp"+status);
					$(".c-o.moverec").html(record.fkCode);//确认取消弹窗
					$(".fkcodes").html(record.fkCode);  //二维码弹窗
					$('#applyTime').html(record.applyTime.substring(0,10));
					if(!record.fkcodeComp==null){
						fkcodeComp="到访企业："+record.fkcodeComp;
					}
					$('#fkcodeComp').html(fkcodeComp);
					$('#fkcodeTime').html("到访时间："+record.fkcodeTime);									
					$('#fkcodeRemark').html("访客说明："+record.fkcodeRemark);															
					$('#memberName').html("访客姓名："+record.fkcodeName);
					$('#memberPhoneNumber').html("访客电话："+record.fkcodeTelephone);
					$(".bftime").html(record.fkcodeTime);  //二维码弹窗
					//var m="\""+record[i].fkcodeId+"\",\""+record[i].fkcodeId+"\"";
					$('.fr.f12').html("<a href='javascript:;' onclick='qrcode(this)' class='ib-btn mr15'>查看二维码</a>"+cancelbutton);
					}
				}
			}); 
		}); 	  
	//查看二维码
    function qrcode(obj){
    	var arg=getQueryStringArgs();
	    var fkcodeId =arg.fkcodeId;
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'propertyservicemanagerTwcrdManager/findTwcrdById.json',
			data:'fkcodeId='+fkcodeId,
			success:function(result){
				if(result&&result.record){			
					var url = result.record.twcrdAddrec;									
					$(".bg-tanc.m2").show();
				}
			}
		});
    };	
  //确认取消弹窗
	function cancel(){	
		$(".bg-tanc.m1").show();
	};	
	//取消
	$(function(){
		$(".hhf-submit.confirm").click(function(){
			$(".bg-tanc.m1").hide();
			var arg=getQueryStringArgs();
		    var fkcodeId =arg.fkcodeId;
			 	$.youi.ajaxUtils.ajax({
			 		url:baseUrl+'propertyservicemanagerFkcodeManager/cancelStatus.json',
					data:'fkcodeId='+fkcodeId,
					success:function(result){
						if(result&&result.record){
							close("取消成功!");														
						}
					}
				});
			});		
	});
	//点击返回
	function bx_goBack(){
		window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageFk.html";
	}; 