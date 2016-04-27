<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<div class="w200 fl">
		<dl>
			<dt>个人中心</dt>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/personInfo.html">个人资料</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/orderCenter.html">订单中心</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/securityCenter.html">安全中心</a></dd>
			<dd><a href="">消息</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/addressBook.html">企业通讯录</a></dd>
			 <dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/propertyManagerOcBind.html">一卡通绑定</a></dd> 
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/myAdderss.html">我的地址</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/myReservation.html">我的预约</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/policyApply.html">我的申请</a></dd>
			<dt>物业服务</dt>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageBx.html">物业报修</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageCos.html">物业投诉</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageFk.html">访客登记</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageMoverec.html">搬家放行</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageCharge.html">缴费查询</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageOc.html">一卡通办理</a></dd>
			<dt>全民营销</dt>
			<dd><a href="grzx15.html">我的人脉</a></dd>
			<dd><a href="grzx16.html">我的收益</a></dd>
			<dt>极速采购</dt>
			<dd>
				<a href="<%=request.getContextPath()%>/member/memberCenter/nationalMarketing/myOrder.html">我的订单 </a>
				<ul class="undis">
					<li><a href="grzx18-2.html">退货</a></li>
					<li class="active"><a href="grzx18-3.html">评价晒单</a></li>
					<li><a href="grzx18-4.html">订单详情</a></li>
				</ul>
			</dd>
			<dd><a href="">退货处理</a></dd>
			<dt>创智汇</dt>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/genWisdom/releaseActivity.html">发布活动</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/genWisdom/participateActivity.html">我参加的活动</a></dd>
			<dd><a href="<%=request.getContextPath()%>/member/memberCenter/genWisdom/publishActivity.html">我发布的活动</a></dd>
	
		</dl>
	</div>
	<script type="text/javascript">
	  $(function (){
		      var urlstr = location.href;
		      var vv = urlstr.split("?")[0];
  			  var urlstatus=false;
  			  if(vv == cenUrl+"member/memberCenter/personalCenter/meetingRoomOrderDetails.html"||
  					vv == cenUrl+"member/memberCenter/personalCenter/carOrderDetails.html"||
  					vv == cenUrl+"member/memberCenter/personalCenter/payWay.html"||
  					vv == cenUrl+"member/memberCenter/personalCenter/adsenseOrderDetails.html"){
  				urlstr = cenUrl+"member/memberCenter/personalCenter/orderCenter.html";
    	  	  };
		      $(".w200 dd").each(function (){
		    	    if ((urlstr + '/').indexOf($(this).find("a").attr('href')) > -1&&$(this).find("a").attr('href')!='') {
		    	      $(this).addClass('active'); urlstatus = true;
		    	    } else {
		    	      $(this).removeClass('active');
		    	    }
		    	  });
		      if (!urlstatus) {$(".w200 dd").eq(0).addClass('active'); }
		     });
</script>