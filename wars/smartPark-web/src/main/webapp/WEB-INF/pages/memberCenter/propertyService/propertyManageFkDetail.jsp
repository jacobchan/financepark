<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>

<youi:html title="访客登记详情">
	<youi:body decorator="memcenter"> 
	
	<div class="w1000">
	    <h3 class="per-h3">访客登记详情
				<a style="cursor: pointer;" onclick="bx_goBack()" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5 a1" style="font-size:18px;"></i>返回</a>
		</h3>
		<div class="clearfix mt20">
						<div class="ot-head">
							<span class="c-333 f14">订单号：<span id="fkCode">123465</span></span><span id="bxStatus"></span>
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
										    <p id="fkcodeTime">到访时间：</p>
											<p id="fkcodeRemark">访客说明：</p>																					
										</td>										
									</tr>
									<tr>										
										<td>
											<p id="fkcodeComp">企业名称：</p>											
											<p id="memberName">访客姓名：</p>
											<p id="memberPhoneNumber">电话：</p>
										</td>
									</tr>
									
									
								</tbody>
							</table>
						</div>
						<div class="fr f12">
							
							<!-- <a href="javascript:;" class="ib-btn mr15" style="width:120px;">查看二维码</a> -->
							
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
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<div class="bg-tanc m2">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w70 tc mt40" style="margin-left:15%">
				<img src="<%=request.getContextPath()%>/styles/images/grzx/ewm.jpg" border="0" class="mb20 fkurl" style="width: 45%;"/> 
				<p class="mb10">订单号：<span class="c-o fkcodes"> [ 123456789 ] </span></p>
				<p>到访时间：<span class="bftime">2016年1月21日15:30</span></p>
			<!-- 	<a href="javascript:;" class="ib-btn">分享到手机</a> -->
				<p class="c-o f12 mt20">提示：如果你已经下载我们官方手机应用，可以在手机端分享访客二维码</p>
			</div>
		</div>
	</div>
</youi:body>
	<script type="text/javascript">
	
		 function cancel(obj){
				var me=obj.parentNode.parentNode;
				var bxCode=me.childNodes[0].childNodes[0].innerText; 
				$(".bxCode").html(bxCode);
				$(".bxCode")[0].setAttribute("id",me.id);
				$(".bg-tanc").show();
			};
		
	</script>
	<!-- 取消报修订单 -->
	<script type="text/javascript">	
	//弹窗
	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
      }
	  $(function(){					
			var arg=getQueryStringArgs();
		    var fkcodeId =arg.fkcodeId;
		   // alert(fkcodeId);
			$.ajax({
				url:baseUrl+'propertyservicemanagerFkcodeManager/getPropertyservicemanagerFkcode.json',
				data:'fkcodeId='+fkcodeId,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						var fkcodeComp="";						
						$('#fkCode').html(record.fkCode);
						$(".fkcodes").html(record.fkCode);  //二维码弹窗
						$('#applyTime').html(record.applyTime);
						if(record.fkcodeComp==null){
							fkcodeComp="";
						}
						$('#fkcodeComp').html("到访企业："+fkcodeComp);
						$('#fkcodeTime').html("到访时间："+fkcodeTime);									
						$('#fkcodeRemark').html("访客说明："+record.fkcodeRemark);															
						$('#memberName').html("访客姓名："+record.fkcodeName);
						$('#memberPhoneNumber').html("访客电话："+record.fkcodeTelephone);
						$(".bftime").html(record.fkcodeTime);  //二维码弹窗
						//var m="\""+record[i].fkcodeId+"\",\""+record[i].fkcodeId+"\"";
						$('.fr.f12').html("<a href='javascript:;' onclick='qrcode(this)' class='ib-btn mr15'>查看二维码</a>");
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
	</script>
	<script type="text/javascript">
	    //点击返回
		  function bx_goBack(){
			 window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageFk.html";
		}; 
     </script>
</youi:html>