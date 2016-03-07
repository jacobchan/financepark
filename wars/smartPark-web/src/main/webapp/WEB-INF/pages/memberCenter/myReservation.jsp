<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我的预约</title>
	
</head>
<body style="background-color:#f4f4f4;">
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">我的预约列表</h3>
					<div class="clearfix">
						<table class="gt-table mt20">
							<colgroup>
								<col width="180"></col>
								<col width="180"></col>
								<col width="180"></col>
								<col width="180"></col>
								<col></col>
							</colgroup>
							<tbody><tr>
								<th>预约单号</th>
								<th>预约时间</th>
								<th>预约项目</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>展厅参观</td>
								<td>未受理</td>
								<td><a href="javascript:;" class="ac-show">取消预约</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>展厅参观</td>
								<td>已受理</td>
								<td><a href="javascript:;" class="ac-show">取消预约</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>展厅参观</td>
								<td>已完成</td>
								<td></td>
							</tr>
						</tbody></table>
						<div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
							<a href="">首</a>
							<a href=""><i class="fa fa-angle-left"></i></a>
							<a>1</a>
							<a href=""><i class="fa fa-angle-right"></i></a>
							<a href="">末</a>
							<input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
							<a href="">Go</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o"> [ 123456789 ] </span>吗？
				</div>
				<p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p>
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript">
		$(function () {
			$(".ac-show").click(function(){
				$(".bg-tanc.m1").show();
			})
		})
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>
