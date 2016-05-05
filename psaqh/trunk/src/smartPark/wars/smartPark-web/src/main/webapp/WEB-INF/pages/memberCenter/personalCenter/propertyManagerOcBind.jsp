<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="一卡通绑定">
	<youi:body decorator="memcenter">  
		<div class="w1000">
			<h3 class="per-h3">一卡通绑定</h3>
			<h4 class="f16 mt20">绑定信息</h4>
			<div class="mt20">
				<input class="bd-input" type="text" id="ocNumber" style="width:290px;" placeholder="请输入卡号">
				<input value="绑定" class="hhf-submit bd" style="padding:0px 10px;height:30px;" type="button">
			</div>

		</div>
		<div class="w1000 a" id="list">
		</div>
	<div class="tcdPageCode fr"></div>
</youi:body>
	<div class="toast">
    	<div class="toast-con clearfix">
     		<div class="close-toast fr"></div>
     		<p class="tc mt25 f18" style="color:#ff6715"></p>
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
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit" id="confirm">
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/propertyManagerOcBind.js"></script>	

</youi:html>