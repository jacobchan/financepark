<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>

<youi:html title="酒店订单">
	<youi:body decorator="memcenter"> 
	    <div class="w1000">
		    <h3 class="per-h3">酒店订单</h3>
			    <div class="clearfix">
				    <div class="mt20 gr-txl clearfix lh30">
					    <label class="fl mr20 f16">申请时间：</label>
						<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
						<input class="bd-input fl" type="text" id="endTime">
						<!-- <div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="bxCode"><a class="fa fa-search" href=""></a></div> -->
						<input value="搜索" class="hhf-submit f14 fr query" type="button" onclick="refreshData(1,pageSize)">
					</div>
					<table class="gt-table mt20">
					    <colgroup>
						    <col width="150"></col>
						    <col width="150"></col>
							<col width="150"></col>
							<col width="150"></col>
							<col width="120"></col>
							<col width="120"></col>
							<col width="120"></col>
						</colgroup>
						<tbody>
						    <tr>
							    <th>订单号</th>
							    <th>下单时间</th>
								<th>入住时间</th>
								<th>离店时间</th>
								<th>订单金额</th>
								<th>房间数量</th>
								<th>操作</th>
							</tr>							
						</tbody>
						<tbody class="hotelOrders">
						</tbody>
					</table>
					<div class="tcdPageCode fr"></div>
				</div>					
		</div>		
	<!--***弹窗 start****************************************-->
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>        
    </div>
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
	<!--***弹窗 end****************************************-->
</youi:body>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/propertyService/hotelOrders.js"></script>	
</youi:html>
