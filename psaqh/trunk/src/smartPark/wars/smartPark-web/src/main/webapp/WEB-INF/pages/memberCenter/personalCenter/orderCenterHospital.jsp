<%@ page language="java" pageEncoding="UTF-8"%>
    <div class="mt20 gr-txl clearfix lh30">
		<div class="tct-select fl mr20" style="width:200px">
			<div class="ic-select" style="background: url(<%=request.getContextPath()%>/styles/images/yqfw/down.png) no-repeat scroll right center;">
				<p class="c-b1" id="userorderProject" data="">请选择订单项目</p>
			</div>
			    <ul style="display: none;" class="select-nav" >
			        <li id="userorderProject" data="">全部</li>
					<!-- <li>园区地址1</li>
					<li>园区地址2</li>
					<li>园区地址3</li> -->
				</ul>
		</div>
		<div class="inp-box ml20" style="width:300px;">
			<input placeholder="请输入订单号"  id="userorderCode" type="text"style="width:260px;">
		</div>													
			<div  class="hospital_button">
				<input value="搜索" class="hhf-submit f14 fl ml20 hospital" id="query" type="button">
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
			<tbody class="hospital_list">		
			</tbody>
		</table>
		<div class="tcdPageCode fr"></div>
	</div>
    <!--***弹窗 start****************************************-->
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>         
    </div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/orderCenterHospital.js"></script>	
	