<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>

<youi:html title="酒店订单详情">
	<youi:body decorator="memcenter"> 
	
	<div class="w1000">
	    <h3 class="per-h3">酒店订单详情
				<a style="cursor: pointer;" onclick="oc_goBack()" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5 a1" style="font-size:18px;"></i>返回</a>
		</h3>
		<div class="clearfix mt20">
						<div class="ot-head">
							<span class="c-333 f14">订单号：<span id="orderNo">123465</span>&nbsp;&nbsp;&nbsp;</span><span id="orderState"></span>
							<font class="fr" id="orderTime"></font>
						</div>
						<div class="pl20 pr20 order-table">
							<table class="w100 lh30 f12">
								<colgroup>
									<col></col>
									<col></col>
									<col></col>
									<col></col>
								</colgroup>
								<tbody>
									<tbody>
									<tr><td><h4 class="c-333 mb10 fb f14" style="word-break:break-all">入住信息</h4></td></tr>
									</tbody>
									<tr>
										<td>
											<p>酒店名：</p>
										    <p>入住时间：</p>											
											<p>离店时间：</p>																			
										</td>
										<td>
											<p id="hotelname"></p>
										    <p id="tm1"></p>											
											<p id="tm2"></p>																			
										</td>
										<td>
											<p>房间型号：</p>
										    <p>总金额：</p>											
											<p>房间数量：</p>																			
										</td>
										<td>
											<p id="xinghao"></p>
										    <p id="totalprice"></p>											
											<p id="roomsNum"></p>																			
										</td>
									</tr>
									<tbody>
									<tr><td><h4 class="c-333 mb10 fb f14" style="word-break:break-all">登记信息</h4></td></tr>
									</tbody>
									<tr>
										<td>
										    <p>联系人：</p>
										    <p>是否担保：</p>																	
										</td>
										<td>
										    <p id="rzname"></p>
										    <p id="iscard"></p>																
										</td>
										<td>
										    <p>手机号码：</p>
										    <p>担保状态：</p>																
										</td>
										<td>
										    <p id="rzmobile"></p>
										    <p id="cardstatus"></p>																	
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
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o ocCode">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
</youi:body>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/propertyService/hotelOrderInfo.js"></script>	
</youi:html>

<!-- 

	html +='<tr>'
				html +=		'<td style="word-wrap:.-word; ">'
				html +=			'<h4 class="c-333 mb10 fb f14" style="word-break:break-all">'+record[i].msgCaption+'</h4>'
				html +=			'<p>'+msgContent.substring(0,50)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" >'+msgContent.substring(50,100)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" >'+msgContent.substring(100,150)+'</p>'
				html +=			'<p id="'+record[i].msgId+'" >'+msgContent.substring(150,200)+'</p>'
				html +=			'<p class="f12">'+sendDate+'</p>'
				html +=		'</td>'					
				html +=		'<td align="right">'					
				//html +=			'<a href="#" class="see-it" onclick="show1(\''+record[i].msgId+'\')">查看</a>'					
				html +=		'</td>'					
				html +=	'</tr>'	 -->