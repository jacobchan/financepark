<%@ page language="java" pageEncoding="UTF-8"%>
    <div class="mt20 gr-txl clearfix lh30">
	    <div class="tct-select fl mr20" style="width:200px">
			<div class="ic-select" style="background: url(<%=request.getContextPath()%>/styles/images/yqfw/down.png) no-repeat scroll right center;">
				<p class="c-b1" id="userorderProject" data="">请选择订单项目</p>
			</div>
				<ul style="display: none;" class="select-nav" >
					<!--  <li>园区地址1</li>
					<li>园区地址2</li>
					<li>园区地址3</li> -->
					<li id="userorderProject" data="">全部</li>
				</ul>
		</div>
		<div class="inp-box ml20" style="width:300px;">
			<input placeholder="请输入订单号"  id="userorderCode" type="text"style="width:260px;">
		</div>							
		<div class="pend_button">
			<input value="搜索" class="hhf-submit f14 fl ml20 pend" id="query" type="button">
			<input value="搜索全部" class="hhf-submit f14 fl ml20 all" id="queryAll" type="button">
		</div>							
    </div>
<div class="clearfix">
	<table class="gt-table mt20">
		<colgroup>
			<col width="120">
			<col width="120">
			<col width="120">
			<col width="120">
			<col width="120">
		</colgroup>
		<tbody>
		<tr>
			<th>订单号</th>
			<th>订单项目</th>
			<th>订单金额</th>
			<th>下单时间</th>
			<th>操作</th>
		</tr>				
		</tbody>
		<tbody class="pend_list"></tbody>
	</table>
	<div class="tcdPageCode fr"></div>
</div>
<!-- <!-------取消弹窗----------- --> 
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" id="toast_text" style="color:#ff6715">修改成功！</p>
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
	<div class="bg-tanc m2">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w70 tc mt40" style="margin-left:15%">
				<div id="qrcodeTable" style="margin-left: 50px;"></div>
				<p style="margin-top: 10px;">订单编号：<span class="fkcodes" id="payCode"></span></p>
				<p style="margin-top: 10px;">订单金额：<span class="c-o fkcodes" id="userorderAmount"></span> 元</p>
				<!-- <p style="float: left;">订单类型：<span class="bftime" id="userorderGenreName"></span></p> -->
				<p class="f14 mt10">请使用微信扫描二维码以完成支付</p>
			</div>
		</div>
	</div>
	<!--***弹窗 ****************************************-->	
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/orderCenterPend.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.qrcode.min.js"></script>
