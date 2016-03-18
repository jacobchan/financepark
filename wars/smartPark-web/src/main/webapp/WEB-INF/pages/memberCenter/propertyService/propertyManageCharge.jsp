<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>缴费查询</title>
	
</head>
<body style="background-color:#f4f4f4;">
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">缴费查询列表</h3>
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
								<col width="120"></col>
								<col width="150"></col>
								<col></col>
							</colgroup>
							<tbody><tr>
								<th>订单号</th>
								<th>缴费项目</th>
								<th>总金额</th>
								<th>状态</th>
								<th>截止日期</th>
								<th>操作</th>
							</tr>
							<!-- <tr>
								<td><a href="">123456789</a></td>
								<td>水电费</td>
								<td>180元</td>
								<td>未缴费</td>
								<td>2016-1-12</td>
								<td><a href="javascript:;" class="ac-see">付款</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>水电费</td>
								<td>180元</td>
								<td>未缴费</td>
								<td>2016-1-12</td>
								<td><a href="javascript:;" class="ac-see">付款</a></td>
							</tr> -->
							<tr>
								<td><a href="">123456789</a></td>
								<td>水电费</td>
								<td>180元</td>
								<td>未缴费</td>
								<td>2016-1-12</td>
								<td><a href="javascript:;" class="ac-see lq-fp">领取发票</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>水电费</td>
								<td>180元</td>
								<td>未缴费</td>
								<td>2016-1-12</td>
								<td><a href="javascript:;" class="ac-see">已开发票</a></td>
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
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>领取发票</b></h3>
			<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
				<colgroup>
					<col width="110">
					<col>
				</colgroup>
				<tbody><tr>
					<td><b>单号</b></td>
					<td>123456789</td>
				</tr>
				<tr class="label">
					<td><b>发票抬头</b></td>
					<td>
						<label><input name="s-r" class="mr5"type="radio">个人</label>
						<label class="ml30"><input name="s-r" checked="checked" class="mr5" type="radio">企业</label>
					</td>
				</tr>
				<tr class="show2" >
					<td><b>企业名称</b></td>
					<td><input type="text" style="width:400px"></td>
				</tr>
				<tr>
					<td></td>
					<td class="add-sh">
						<label><input name="address" class="mr5" checked="checked" type="radio">寄送到报修地址</label>
						<label class="ml30"><input name="address" class="mr5" type="radio">自定义</label>
						<textarea class="mt20 so1 undis"></textarea>
						<div class="tct-select mt20 so2" style="width:400px;">
							<div class="ic-select">
								<p>文化创意园A302(张三 19855552222)</p>
							</div>
							<ul class="select-nav">
								<li>文化创意园A302(张三 19855552222)</li>
								<li>文化创意园A302(张三 19855552222)2</li>
								<li>文化创意园A302(张三 19855552222)3</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">领取发票</a></td>
				</tr>
			</tbody></table>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript">
	$(function () {
		$(".lq-fp").click(function(){
			$(".bg-tanc").show();
		});
		$(".wybx-tanc .add-sh label").click(function(){
			if($(this).children('input[type="radio"]').prop("checked")){
				if($(this).index()==0){
					$(".add-sh .so2").removeClass("undis");
					$(".add-sh .so1").addClass("undis");
				}else{
					$(".add-sh .so2").addClass("undis");
					$(".add-sh .so1").removeClass("undis");
				}
			}
		});
		$.ajax({
			url:baseUrl+'/esb/web/propertyservicemanagerChargeManager/getChargeListforpage.json', 
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
			var chargeStatus='';
			var userorderStatus=record[i].userorder.userorderStatus;
			var buttonHtml="<td><a href='javascript:;' class='ac-see' onclick='javascript:pay(this)'>付款</a></td>";
			if(userorderStatus=='01'){
				chargeStatus="未缴费";
			}else{
				chargeStatus="已缴费";
				buttonHtml="<td><a href='javascript:;' class='ac-see lq-fp'>领取发票</a></td>";
			}
			
			var html="<tr id='"+record[i].chargeId+"'>"+
				 	 "<td><a href=''>"+record[i].userorder.userorderCode+"</a></td>"+
					 "<td>"+record[i].userorder.userorderProject+"</td>"+
					 "<td>"+record[i].chargeAmount+"元</td>"+
					 "<td>"+chargeStatus+"</td>"+
					 "<td>"+record[i].chargeEndate+"</td>"+
					 buttonHtml+
					 "</tr>";
			 $("tbody").append(html);
		}
	};
	function pay(obj){
		var me=obj.parentNode.parentNode;
		alert(me.id+"          付款功能后续添加！");
	}
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>
