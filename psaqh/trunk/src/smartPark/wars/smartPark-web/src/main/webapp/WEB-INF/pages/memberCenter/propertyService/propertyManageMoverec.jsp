<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>搬家放行</title>
	
</head>
<body style="background-color:#f4f4f4;">
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">搬家放行列表</h3>
					<div class="clearfix mt20 fklist">
						<!-- <div class="gz-fx-box clearfix">
							<div class="gzb-thead">
								<span class="c-o">订单号：44152444</span>
								<a href="grzx11-2.html" class="fr f12">查看订单详情</a>
							</div>
							<div class="w60 fl">
								<p class="f14 c-333">深圳市前海怕啥科技有限公司</p>
								<p>2016年1月25日12:29:09</p>
								<p>已放行</p>
							</div>
							<div class="w40 fr">
								<p class="p1"><i class="fa fa-file-text-o"></i>物品放行清单</p>
								<p>· 电脑主机</p>
								<p>· 一体式打印机</p>
								<p>· 办公桌椅</p>
								<p><a href="grzx11-2.html">……</a></p>
							</div>
						</div>
						<div class="gz-fx-box clearfix">
							<div class="gzb-thead">
								<span class="c-o">订单号：44152444</span>
								<a href="grzx11-2.html" class="fr f12">查看订单详情</a>
							</div>
							<div class="w60 fl">
								<p class="f14 c-333">深圳市前海怕啥科技有限公司</p>
								<p>2016年1月25日12:29:09</p>
								<p>待受理</p>
								<a href="javascript:;" class="ib-btn ac-show" style="margin-top:0px;">取消</a>
							</div>
							<div class="w40 fr">
								<p class="p1"><i class="fa fa-file-text-o"></i>物品放行清单</p>
								<p>· 电脑主机</p>
								<p>· 一体式打印机</p>
								<p>· 办公桌椅</p>
								<p><a href="grzx11-2.html">……</a></p>
							</div>
						</div>
						<div class="gz-fx-box clearfix">
							<div class="gzb-thead">
								<span class="c-o">订单号：44152444</span>
								<a href="grzx11-2.html" class="fr f12">查看订单详情</a>
							</div>
							<div class="w60 fl">
								<p class="f14 c-333">深圳市前海怕啥科技有限公司</p>
								<p>2016年1月25日12:29:09</p>
								<p>已通过</p>
								<a href="javascript:;" class="ib-btn mr10 ac-see" style="margin-top:0px;padding:0px 7.5px">查看二维码</a>
								<a href="javascript:;" class="ib-btn ac-show" style="margin-top:0px;">取消</a>
							</div>
							<div class="w40 fr">
								<p class="p1"><i class="fa fa-file-text-o"></i>物品放行清单</p>
								<p>· 电脑主机</p>
								<p>· 一体式打印机</p>
								<p>· 办公桌椅</p>
								<p><a href="grzx11-2.html">……</a></p>
							</div>
						</div>
						<div class="gz-fx-box clearfix">
							<div class="gzb-thead">
								<span class="c-o">订单号：44152444</span>
								<a href="" class="fr f12">查看订单详情</a>
							</div>
							<div class="w60 fl">
								<p class="f14 c-333">深圳市前海怕啥科技有限公司</p>
								<p>2016年1月25日12:29:09</p>
								<p class="c-o">已取消</p>
							</div>
							<div class="w40 fr">
								<p class="p1"><i class="fa fa-file-text-o"></i>物品放行清单</p>
								<p>· 电脑主机</p>
								<p>· 一体式打印机</p>
								<p>· 办公桌椅</p>
								<p><a href="">……</a></p>
							</div>
					</div>  -->
					</div>
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
	<div class="bg-tanc m2">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w70 tc mt40" style="margin-left:15%">
				<img src="<%=request.getContextPath()%>/styles/images/grzx/ewm.jpg" border="0" class="mb20"/> 
				<p class="mb10">订单号：<span class="c-o"> [ 123456789 ] </span></p>
				<p>到访时间：2016年1月21日15:30</p>
				<a href="javascript:;" class="ib-btn">分享到手机</a>
				<p class="c-o f12 mt20">提示:推送到手机，必须确保手机端已经安装我们的官方APP</p>
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript">
	$(function () {		
		$.ajax({
			url:baseUrl+'/esb/web/propertyservicemanagerMoverecManager/getMovListforpage.json', 
			success:function(result){
				console.log(result);
				if(result&&result.records){
					_parseRecords(result.records);
				}
			}
		});
	});
	
	//拼接列表
	function _parseRecords(record){
		for(var i=0;i<record.length;i++){
			  var html="<div class='gz-fx-box clearfix'>"+
							"<div class='gzb-thead'>"+
							"<span class='c-o'>订单号："+record[i].moverecCode+"</span>"+
							"<a href='grzx11-2.html' class='fr f12'>查看订单详情</a>"+
						"</div>"+
						"<div class='w60 fl'>"+
							"<p class='f14 c-333'>"+record[i].moverecComp+"</p>"+
							"<p>"+record[i].moverecTime+"</p>"+
							"<p>"+record[i].moverecStatus+"</p>"+
						"</div>"+
						"<div class='w40 fr'>"+
							"<p class='p1'><i class='fa fa-file-text-o'></i>物品放行清单</p>"+
							"<p>· 电脑主机</p>"+
							"<p>· 一体式打印机</p>"+
							"<p>· 办公桌椅</p>"+
							"<p><a href='grzx11-2.html'>……</a></p>"+
						"</div>"+
					"</div>";
			  $(".fklist").append(html);
				$(".ac-show").click(function(){
					$(".bg-tanc.m1").show();
				});
				$(".ac-see").click(function(){
					$(".bg-tanc.m2").show();
				});
		}
	};
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>
