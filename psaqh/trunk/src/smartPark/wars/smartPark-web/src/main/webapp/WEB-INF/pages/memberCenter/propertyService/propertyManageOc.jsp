<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="一卡通办理">
	<youi:body decorator="memcenter">  
		<div class="w1000">
			<h3 class="per-h3">一卡通办理<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要申请一卡通</a></h3>
				<div class="clearfix mt40" rules=none>
					<div class="mt20 gr-txl clearfix lh30">
						<label class="fl mr20 f16">申请时间：</label>
						<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
						<input class="bd-input fl" type="text" id="endTime">
						<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="ocCode"><a class="fa fa-search" href=""></a></div>
						<input value="搜索" class="hhf-submit f14 fr" type="button">
					</div>											   					    
					<table class="gt-table mt20">
						<colgroup>
							<col width="150"></col>
							<col width="150"></col>
							<col width="150"></col>
							<col width="120"></col>
							<col width="150"></col>	
						</colgroup>
						<tbody><tr>
							<th>订单号</th>
							<th>预约时间</th>
							<th>预约用户</th>
							<th>状态</th>
							<th>操作</th>
						</tr></tbody>							
                        <tbody class="oclist"></tbody>                        
                    </table>                     
				<div class="tcdPageCode fr"></div>
			</div>
		</div>
	</youi:body>
				
    <!--***弹窗start****************************************-->
  
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
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o fkCode"> [ 123456789 ] </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit c" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->
   
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/propertyService/propertyManageOc.js"></script>
</youi:html>