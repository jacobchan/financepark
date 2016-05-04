	//弹窗
	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){location.reload(); },2000);
			
      }
    $(function(){					
		var arg=getQueryStringArgs();
		var cosId =arg.cosId;
		$.ajax({
				url:baseUrl+'propertyservicemanagerCosManager/getPropertyservicemanagerCos.json',
				data:'cosId='+cosId,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						var status="";
						var button="";
						//alert(record.cosStatus);
						$(".cosCode").html(record.cosCode);//确认取消弹窗
						 if('01'==record.cosStatus){
							  status = "待处理";
							  button="<a href='javascript:;' class='pb-btn tc' style='width:120px;' onclick='cancel()' align='center' >取消</a>";
						  }else if('02'==record.cosStatus){
							  status = "已处理";
						  }	
						  else if('03'==record.cosStatus){
							  status = "已取消";
						  }else if('04'==record.cosStatus){
							  status = "已退回";							 
						  }	
						$(".fr.f12").html(button); 
						$('#cosCode').html(record.cosCode+"&nbsp&nbsp"+status);
						$('#cosTime').html(record.cosTime.substring(0,10));													
						$('#cosContent').html("投诉内容："+record.cosContent);
						$('#memberName').html("投诉人："+record.memberInformation.memberName);
						$('#memberPhoneNumber').html("电话："+record.memberInformation.memberPhoneNumber);						
						}
					}
			}); 
		}); 
	//确认取消弹窗
	function cancel(){	
		$(".bg-tanc.m1").show();
	};	
	//取消
	$(function(){
		$(".hhf-submit.confirm").click(function(){
			$(".bg-tanc.m1").hide(100);
				var arg=getQueryStringArgs();
		        var cosId =arg.cosId;
			 	$.youi.ajaxUtils.ajax({
			 		url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
					data:'cosId='+cosId,
					success:function(result){
						if(result&&result.record){
							close("取消成功!");														
						}
					}
				});
			});
		
	});
	
	
	    //点击返回
		  function oc_goBack(){
			 window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageCos.html";
		}; 