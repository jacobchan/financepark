<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>

<youi:html title="物业报修详情">
	<youi:body decorator="memcenter"> 
	
	<div class="w1000">
	    <h3 class="per-h3">物业报修详情
				<a style="cursor: pointer;" onclick="bx_goBack()" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5 a1" style="font-size:18px;"></i>返回</a>
		</h3>
		<div class="clearfix mt20">
						<div class="ot-head">
							<span class="c-333 f14">订单号：<span id="bxCode">123465</span></span><span id="bxStatus"></span>
							<font class="fr" id="applyTime"></font>
						</div>
						<div class="pl20 pr20 order-table">
							<table class="w100 lh30 f12">
								<colgroup>
									<col width="50%"></col>
									<col></col>
								</colgroup>
								<tbody>
									<tr>
										<td>
											<p id="bxProject"></p></p>
											<p id="bxRemark">报修描述</p>
											<p id="bxType"></p>											
										</td>
										
									</tr>
									<tr>
										
										<td>
											<p id="bxComp">企业名称:</p>
											<p id="bxAddress">地址：</p>
											<p id="memberName">保修人：</p>
											
										</td>
									</tr>
									
									
								</tbody>
							</table>
						</div>
						<div class="fr f12 m1">			</div>
					</div>
	
	</div>
	<!--***弹窗 start****************************************-->

	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
	<!--***弹窗 end****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
</youi:body>
	<script type="text/javascript">	
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
		</script>
		<script type="text/javascript">	
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
		    //alert(111);
			$.ajax({
				url:baseUrl+'propertyservicemanagerBxManager/getBx.json',
				data:'bxId='+bxId,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						var bxAddress="";
						var bxAmount="";
						var bxStatus="";
						var buttonHtml="";
						var buttonpay="<span class='mr30'> 订单总计费用：<font class='f24 c-o' id='bxAmount'>0元</font></span>"+
						              "<a href='' class='ib-btn mr15' style='width:120px;'>立即支付</a>";
						
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
							var buttonpay="";
						}else if(record.bxStatus=='07'){
							bxStatus='已完成';
							var buttonpay="";
						}else if(record.bxStatus=='08'){
							bxStatus='已取消';
							var buttonpay="";
						}
						$(".fr.f12.m1").html(buttonpay+buttonHtml);
						$('#bxCode').html(record.bxCode+"&nbsp&nbsp"+bxStatus);
						if(record.bxAmount==null){
							bxAmount=0;
						}
						$('#bxAmount').html(bxAmount+"元");
						}
					}		
		}); 
    }); 
	
		
	</script>
	<script type="text/javascript">
	    //点击返回
		  function bx_goBack(){
			 window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageBx.html";
		}; 
     </script>
</youi:html>
