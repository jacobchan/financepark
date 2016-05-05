	//取消确认弹窗
	function cancel(){	
		$(".bg-tanc").show();
	};	
	//取消报修订
	$(function(){
		 $(".hhf-submit.confirm").click(function(){	
		 $(".bg-tanc.m1").hide();
		 var arg=getQueryStringArgs();
		 var bxId =arg.bxId;				
		 $.ajax({
			 url:baseUrl+'propertyservicemanagerBxManager/updateBxforpage.json',
			 data:'bxId='+bxId,
			 success:function(result){
						if(result&&result.record){
							if(result.record.bxStatus=='08'){								
								close("取消成功")																
							}											
						}
					}
				});
		});
	});	
	//弹窗
	function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){location.reload(); },2000);			
    }
	//初始化加载页面
    $(function(){					
			var arg=getQueryStringArgs();
		    var bxId =arg.bxId;
			$.ajax({
				url:baseUrl+'propertyservicemanagerBxManager/getBx.json',
				data:'bxId='+bxId,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						var bxAddress="";
						var bxStatus="";
						var bxAmount=0;
						var buttonHtml="";
						var buttonpay="<span class='mr30'> 订单总计费用：<font class='f24 c-o' id='bxAmount'>0元</font></span>"+
						              "<a href='' class='ib-btn mr15' style='width:120px;'>立即支付</a>";
						//alert(record.bxAmount);
						$(".moverec").html(record.bxCode);//给弹窗插入订单号
						$('#applyTime').html(record.applyTime.substring(0,10));
						$('#bxComp').html("企业名称："+record.bxComp);				
						$('#bxRemark').html("报修内容："+record.bxRemark);						
						if(!record.bxAddress==null){
							bxAddress=record.bxAddress;
						}
						$('#bxAddress').html("维修地址："+bxAddress);
						$('#memberName').html("联系人："+record.member.memberName+" &nbsp&nbsp"+record.member.memberPhoneNumber);						
						if(record.bxStatus=='00'){
							bxStatus='待受理';
							buttonHtml="<a href='javascript:;' class='pb-btn tc' onclick='javascript:cancel()'>取消</a>";							
						}else if(record.bxStatus=='01'){
							bxStatus='已受理';
						}else if(record.bxStatus=='02'){
							bxStatus='待接单';
						}else if(record.bxStatus=='03'){
							bxStatus='已派工';
						}else if(record.bxStatus=='04'){
							bxStatus='已完工';
						}else if(record.bxStatus=='05'){
							bxStatus='已定价';
							buttonHtml="<td><a href='javascript:;'>付款</a></td>";
						}else if(record.bxStatus=='06'){
							bxStatus='已付款';
							buttonpay="<span class='mr30'> 订单总计费用：<font class='f24 c-o' id='bxAmount'>0元</font></span>";
						}else if(record.bxStatus=='07'){
							bxStatus='已完成';
							buttonpay="<span class='mr30'> 订单总计费用：<font class='f24 c-o' id='bxAmount'>0元</font></span>";
						}else if(record.bxStatus=='08'){
							bxStatus='已取消';
							var buttonpay="";
						}
						$(".fr.f12.m1").html(buttonpay+buttonHtml);
						$('#bxCode').html(record.bxCode+"&nbsp&nbsp"+bxStatus);
						if(record.bxAmount){
							bxAmount=record.bxAmount;
						}
						$('#bxAmount').html(bxAmount+"元");
						}
					}		
		}); 
    }); 	
	//点击返回
	function bx_goBack(){
		window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageBx.html";
	}; 