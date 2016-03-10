<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>物业投诉</title>	
</head>
<body style="background-color:#f4f4f4;">
	
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">物业投诉列表</h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
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
							<tbody><tr>
								<th>订单号</th>
								<th>投诉时间</th>
								<th>是否需要回复</th>
								<th>联系人</th>
								<th>联系电话</th>
								<th>操作</th>
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
					<!-- <div class="clearfix mt50">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit fr" type="button">
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
							<tbody><tr>
								<th>订单号</th>
								<th>投诉时间</th>
								<th>是否需要回复</th>
								<th>联系人</th>
								<th>联系电话</th>
								<th>操作</th>
							</tr>
							<tr>
								<td colspan="6">暂无记录</td>
							</tr>
						</tbody></table>
					</div> -->
				</div>
			</div>
		</div>
	</div>

	<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
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
			$(".ac-show").click(function(){
				$(".bg-tanc").show();
			});
		});
		//格式化展示列表
		function _parseRecords(record){
			$("#count").append(record.length);
			for(var i=0;i<record.length;i++){
				var bool = "";
				var status = "";
				var crop = "";
				if(record[i].cosBool=='0'){
					bool = "是";
				}else{
					bool = "否";
				}
				if(record[i].cosStatus=='0'){
					status = "待受理";
					crop = "取消";
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
					crop = "评价";
				}else if(record[i].cosStatus=='6'){
					status = "已评价";
				}
				var html="<tr><td>"+record[i].cosCode+"</td><td>"+record[i].cosTime+"</td><td>"+bool+"</td><td>"+record[i].cosName+"</td><td>"+record[i].cosTelephone+"</td><td>"+status+"</td><td><a href='javascript:;' class='ac-show'>"+crop+"</a></td></tr>";
				$("tbody").append(html);
			}
		};
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>
