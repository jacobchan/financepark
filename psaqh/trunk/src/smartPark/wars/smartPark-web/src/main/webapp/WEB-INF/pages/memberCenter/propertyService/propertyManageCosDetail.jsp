<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>

<youi:html title="物业投诉详情">
	<youi:body decorator="memcenter"> 
	
	<div class="w1000">
	    <h3 class="per-h3">物业投诉详情
				<a style="cursor: pointer;" onclick="oc_goBack()" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5 a1" style="font-size:18px;"></i>返回</a>
		</h3>
		<div class="clearfix mt20">
						<div class="ot-head">
							<span class="c-333 f14">订单号：<span id="cosCode"></span></span><span id="cosStatus"></span>
							<font class="fr" id="cosTime"></font>
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
										  								
											<p id="cosContent">投诉内容：</p>																			
										</td>
										
									</tr>
									<tr>										
										<td>											
											<p id="ocComp"></p>
											<p id="memberName"></p>
											<p id="memberPhoneNumber"></p>
										</td>
									</tr>									
								</tbody>
							</table>
						</div>
						<div class="fr f12">							
												
						</div>
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
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o cosCode">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
</youi:body>
<script type="text/javascript">
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
						$('#cosContent').html("预约详情："+record.cosContent);
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
     </script>
</youi:html>
