<%@ page language="java" pageEncoding="UTF-8"%>
<div class="clearfix">
	<table class="gt-table mt20">
		<colgroup>
			<col width="120">
			<col width="120">
			<col width="120">
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
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
    <div id="loadingShow" class="clearfix"></div>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/policyApplyMyApplication.js"></script>	
