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
						<div class="fr f12" id="aa">
						<a href="javascript:;" class="ib-btn mr15" onclick="cancel()">取消访客</a>
						</div>
						<div id="aa">
						<a href="javascript:;" class="ib-btn mr15" onclick="cancel()">取消访客</a>
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
</youi:body>
	<script type="text/javascript">	
		 function cancel(obj){
				var me=obj.parentNode.parentNode;
				var bxCode=me.childNodes[0].childNodes[0].innerText; 
				$(".bxCode").html(bxCode);
				$(".bxCode")[0].setAttribute("id",me.id);
				$(".bg-tanc").show();
			};		
	//弹窗
	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
      }
	//加载页面
	  $(function(){					
			var arg=getQueryStringArgs();
		    var fkcodeId =arg.fkcodeId;
			$.ajax({
				url:baseUrl+'propertyservicemanagerFkcodeManager/getFkByFkcodeId.json',
				data:'fkcodeId='+fkcodeId,
				success:function(result){					    		           
					if(result&&result.record){
						var record = result.record;
						var fkcodeComp="";
						var cancelbutton="";
						var dksataus="";
						var button="";
						//alert(record.dksataus);
						if(record.dksataus=="00"){
							status = "未到访";							
							button="<a href='javascript:;' class='ib-btn mr15' onclick='cancel()'>取消访客</a>";
							//$(".fr.f12").html(button); 
						}else if(record.dksataus=='01'){
							status = "未到访";				
						}else if(record.dksataus=='02'){
							status = "已到访";
						}else if(record.dksataus=='03'){
							status = "已取消";
						}
						$('#fkCode').html(record.fkCode+"&nbsp&nbsp"+status);
						$(".fkcodes").html(record.fkCode);  //二维码弹窗
						$('#applyTime').html(record.applyTime);
						if(!record.fkcodeComp==null){
							fkcodeComp="到访企业："+record.fkcodeComp;
						}
						$('#fkcodeComp').html(fkcodeComp);
						$('#fkcodeTime').html("到访时间："+record.fkcodeTime);									
						$('#fkcodeRemark').html("访客说明："+record.fkcodeRemark);															
						$('#memberName').html("访客姓名："+record.fkcodeName);
						$('#memberPhoneNumber').html("访客电话："+record.fkcodeTelephone);
						$(".bftime").html(record.fkcodeTime);  //二维码弹窗
						$('.fr.f12').html("<a href='javascript:;' onclick='qrcode(this)' class='pb-btn tc'>查看二维码</a>"+button);
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
	function cancel(obj){
		var me=obj.parentNode.parentNode;
		var fkCode=me.childNodes[0].childNodes[0].innerText; 
		$(".fkCode").html(fkCode);
		$(".fkCode")[0].setAttribute("id",me.id);
		$(".bg-tanc.m1").show();
	};
	$(".hhf-submit.c").click(function(){	
		var id=$(".fkCode")[0].getAttribute("id");
	 	$.youi.ajaxUtils.ajax({
			url:baseUrl+'propertyservicemanagerFkcodeManager/cancelStatus.json',
			data:'fkcodeId='+id,
			success:function(result){
				if(result&&result.record){
					close("取消成功!");										
				}
			}
		});
	});
	</script>
	<script type="text/javascript">
	    //点击返回
		  function bx_goBack(){
			 window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageFk.html";
		}; 
     </script>
</youi:html>
