<%@ page language="java" pageEncoding="UTF-8"%>
<div class="clearfix">
	<table class="gt-table mt20">
		<colgroup>
			<col width="200">
			<col width="120">
			<col width="100">
			<col width="120">
			<col width="120">
			<col width="120">
		</colgroup>
		<tbody>
			<tr>
				<th>申请编号</th>
				<th>政策类型</th>
				<th>申请人</th>
				<th>申请时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</tbody>
	</table>
	<div class="tcdPageCode fr"></div>
</div>
<!-- 操作成功弹窗 -->
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>       
    </div>
<!-- 确认取消弹窗 -->    
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
    <div id="loadingShow" class="clearfix"></div>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/policyApplyMyApplication.js"></script>	
