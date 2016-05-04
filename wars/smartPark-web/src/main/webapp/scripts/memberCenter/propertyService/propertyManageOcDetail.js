	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){location.reload(); },2000);
			
      }
    $(function(){					
		var arg=getQueryStringArgs();
		var ocId =arg.ocId;
		$.ajax({
				url:baseUrl+'propertyservicemanagerOcManager/getOc.json',
				data:'ocId='+ocId,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						var ocComp="";
						var status="";
						var button="";
						//alert(record.ocCode);
						$(".ocCode").html(record.ocCode);//确认取消弹窗
						 if(record.ocStatus=='01'){
							  status = "已处理";
						  }else if(record.ocStatus=='02'){
							  status = "已领卡";
						  }	
						  else if(record.ocStatus=='08'){
							  status = "已取消";
						  }else if(record.ocStatus=='00'){
							  status = "待处理";
							  button="<a href='javascript:;' class='pb-btn tc' style='width:120px;' onclick='cancel()' align='center' >取消</a>";
						  }	
						$(".fr.f12").html(button); 
						$('#bxCode').html(record.ocCode+"&nbsp&nbsp"+status);
						$('#applyTime').html(record.applyTime.substring(0,10));
						$('#ocDate').html("预约时间："+record.ocDate.substring(0,10));										
						$('#ocRemark').html("预约详情："+record.ocRemark);
						if(!record.ocComp==null){
							ocComp="公司名称："+record.ocComp;
						}
						$('#ocComp').html(ocComp);
						$('#memberName').html("联系人："+record.member.memberName);
						$('#memberPhoneNumber').html("电话："+record.member.memberPhoneNumber);
						
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
		        var ocId =arg.ocId;
			 	$.youi.ajaxUtils.ajax({
			 		url:baseUrl+'propertyservicemanagerOcManager/cancleOcStatus.json',
					data:'ocId='+ocId,
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
			 window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageOc.html";
		}; 