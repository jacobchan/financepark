<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>政策申请</title>
	
</head>
<body style="background-color:#f4f4f4;">
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">政策申请</h3>
					<div class="clearfix">
						<table class="gt-table mt20">
							<colgroup>
								<col width="120"></col>
								<col width="120"></col>
								<col></col>
								<col width="120"></col>
								<col width="120"></col>
								<col width="120"></col>
							</colgroup>
							<tbody><tr>
								<th>申请编号</th>
								<th>政策类型</th>
								<th>申请人</th>
								<th>申请时间</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>孵化器\租金</td>
								<td>鲁智深</td>
								<td>2016-02-01 10:30 </td>
								<td>未办理</td>
								<td><a href="javascript:;" class="ac-see">取消</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>孵化器\租金</td>
								<td>鲁智深</td>
								<td>2016-02-01 10:30 </td>
								<td>未办理</td>
								<td><a href="javascript:;" class="ac-see">重新提交</a></td>
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
		<div class="bg-tanc" >
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:900px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10" style="color:#666;"><b class="mr50">孵化器政策\租金</b><b class="ml50">申请编号：99999</b></h3>
			<div class="clearfix mt40 tc">
				<ul class="jc-nav clearfix mb30 ml40">
					<li class="active">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon1.png" class="undis">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon1-o.png">
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr.png" class="mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr-o.png" class="undis mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon2.png">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon2-o.png" class="undis">
					</li>	
					<li>
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr.png" class="mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr-o.png" class="undis mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon3.png">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon3-o.png" class="undis">
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr.png" class="mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr-o.png" class="undis mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon4.png">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon5-o.png" class="undis">
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr.png" class="mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/iconr-o.png" class="undis mr40">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon5.png">
						<img src="<%=request.getContextPath()%>/styles/images/grzx/icon5-o.png" class="undis">
					</li>
				</ul>
				<div class="bd-dash">
					申请人：鲁智深<span class="ml20">先生</span>
					<span class="ml40">联系电话：15399964578</span>
				</div>
				<div class="bd-dash">
					公司名称：深圳市前海怕啥科技有限公司
					<span class="ml40">职位：总经理助理</span>
				</div>
				<div class="bd-dash">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/map.png" class="mr20">
					创意文化园E6栋412
				</div>
				<a href="" class="pb-btn">取消申请</a><a href="javascript:;" class="ib-btn ml40">重新提交</a>
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript" src="../js/right.js"></script>
	<script type="text/javascript">
		$(function () {
			$(".ac-see").click(function(){
				$(".bg-tanc").show();
			})
		})
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>
