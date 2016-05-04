<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="访客登记">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">访客登记列表<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要邀请访客</a></h3>
			<div class="clearfix">
				<div class="mt20 gr-txl clearfix lh30">
					<label class="fl mr20 f16">申请时间：</label>
					<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
					<input class="bd-input fl" type="text" id="endTime">
					<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="fkCode"></div>
					<input value="搜索" class="hhf-submit a f14 fr" type="button">
				</div>
				<table class="gt-table mt20">
					<colgroup>
						<col width="200"></col>
						<col width="130"></col>
						<col width="130"></col>
						<col width="110"></col>
						<col width="150"></col>
						<col></col>
					</colgroup>
					<tbody>
						<tr>
							<th>订单号</th>
							<th>到访时间</th>
							<th>到访状态</th>
							<th>访客姓名</th>
							<th>访客电话</th>
							<th>操作</th>
						</tr>
					</tbody>
					<tbody class="fklist"></tbody>
				</table>
				<div class="tcdPageCode fr"></div>
			</div>
		</div>	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o fkCode"> [ 123456789 ] </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit c" style="height:36px;" type="submit">
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
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>       
    </div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/propertyService/propertyManageFk.js"></script>
</youi:html>
