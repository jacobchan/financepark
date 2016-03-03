<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%>
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
	<head>
	<meta charset="UTF-8">
	<title>我发布的活动</title>
</head>
<body style="background-color: #f4f4f4;">
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%>
				<div class="w1000">
					<h3 class="per-h3">物业投诉列表</h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">投诉时间：</label>
							<input class="bd-input fl" type="text"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text">
							<div class="inp-box ml20"><input placeholder="投诉单号查询" type="text"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
							<a href="addcomplaints.html" class="hhf-submit f14 fr">我要投诉</a>
						</div>
						<table class="gt-table mt20">
							<colgroup>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col></col>
							</colgroup>
							<tbody id="czh-knowledge">
								<tr>
									<th>订单号</th>
									<th>申请时间</th>
									<th>状态</th>
									<th>联系人</th>
									<th>联系电话</th>
									<th>操作</th>
								</tr>
							</tbody>
						</table>
						<div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有 <span id="count"></span> 条，每页显示： 50 条</span>
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
	<script type="text/javascript">
		//读取当前用户投诉记录
		$(function(){
			$("#grzl").attr("class","");
			$("#property").attr("class","active");
			$.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCoss.json',
				success:function(result){
					console.log(result.records);
					if(result&&result.records){
						_parseRecords(result.records);
					}
				}
			});
		});
		//格式化展示列表
		function _parseRecords(record){
			$("#count").append(record.length);
			for(var i=0;i<record.length;i++){
				var bool = "";
				var status = "";
				if(record[i].cosBool=='0'){
					bool = "是";
				}else{
					bool = "否";
				}
				if(record[i].cosStatus=='0'){
					status = "待受理";
				}else if(record[i].cosStatus=='1'){
					status = "受理中";
				}else if(record[i].cosStatus=='2'){
					status = "已受理";
				}else if(record[i].cosStatus=='3'){
					status = "已退回";
				}else if(record[i].cosStatus=='4'){
					status = "已回访";
				}else if(record[i].cosStatus=='5'){
					status = "待评价";
				}else if(record[i].cosStatus=='6'){
					status = "已评价";
				}
				var html="<tr><td>"+record[i].cosCode+"</td><td>"+record[i].cosTime+"</td><td>"+bool+"</td><td>"+record[i].cosName+"</td><td>"+record[i].cosTelephone+"</td><td>"+status+"</td></tr>";
				$("#czh-knowledge").append(html);
			}
		};
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%>
</html>