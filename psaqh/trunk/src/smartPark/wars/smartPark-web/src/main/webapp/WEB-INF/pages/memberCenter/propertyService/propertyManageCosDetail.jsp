<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="物业投诉">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">物业投诉列表<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要投诉</a></h3>
				<div class="clearfix">
					<div class="mt20 gr-txl clearfix lh30">
						<label class="fl mr20 f16">申请时间：</label>
						<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
						<input class="bd-input fl" type="text" id="endTime">
						<div class="inp-box ml20"><input placeholder="投诉单号查询" type="text" id="cosCode"><a class="fa fa-search" href=""></a></div>
						<input value="搜索" class="hhf-submit query" id="query" type="button">
					</div>							
					<table class="gt-table mt20">
					<colgroup>
						<col width="190"></col>
						<col width="150"></col>
						<col width="150"></col>
						<col width="120"></col>
						<col width="120"></col>
						<col width="120"></col>
					</colgroup>
					<tbody>
						<tr>
							<th>投诉单号</th>
							<th>申请时间</th>								
							<th>联系人</th>
							<th>联系电话</th>
							<th>投诉状态</th>
							<th>操作</th>
						</tr>
					</tbody>
					<tbody class="knowledge a">
					</tbody>							
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
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/propertyService/propertyManageCos.js"></script>	
</youi:html>
