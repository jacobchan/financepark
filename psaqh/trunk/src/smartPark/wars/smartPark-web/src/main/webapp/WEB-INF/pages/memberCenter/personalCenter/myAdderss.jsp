<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人资料</title>
	
</head>
<body style="background-color:#f4f4f4;">

	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
			<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">我的地址</h3>
					<div class="mt30">
						
					</div>
					<a href="javascript:;" class="add-box ga-edit"><i class="fa fa-plus mr20"></i>新增地址</a>	
					
				</div>
			</div>
		</div>
	</div>
	<!--***bottom end****************************************-->
		<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10 f16" style="font-size:16px;"><b>添加地址</b></h3>
			<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
				<colgroup>
					<col width="110"></col>
					<col></col>
				</colgroup>
				<tr>
					<td><b>联系人</b></td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td><b>联系电话</b></td>
					<td><input type="text"></td>
				</tr>
				<tr class="label">
					<td valign="top"><b>地址类型</b></td>
					<td>
						<label><input type="radio" name="address" class="mr5" checked="checked">园区地址</label>
						<label class="ml30"><input type="radio" name="address" class="mr5">非园区地址</label>
						<input type="text" style="width:350px;" class="show2 mt15 undis">
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">保存</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript">
	$(function(){		
			$.ajax({
				url:'/smartPark-web/esb/web/memberadrAddressManager/getMemberadrAddresssByUser.json', 
				success:function(result){
					console.log(result);
					if(result&&result.records){
						_parseRecords(result.records);
					}
				}
			});
			
			$(".ga-edit").click(function(){
				$(".bg-tanc").show();
			});
		});
		
		//拼接地址列表
		function _parseRecords(record){
			var html="";
			for(var i=0;i<record.length;i++){
				if(record[i].addressStatus==0){			
					  html+="<div class='gr-address active'>"+
							"<div class='clearfix pl40 pr40'><span>姓名："+record[i].addressName+"</span><span class='fr'>手机号码："+record[i].addressPhone+"</span></div>"+
							"<div class='pl40 pr40 mt5 mb10'>园区地址："+record[i].addressDetail+"</div>"+
							"<div class='pl20 pr20 lh35 tr f12' style='border-top:1px solid #ebecec'>"+
							"<a href='javascript:;' class='mr10 ga-edit'>编辑</a>"+
							"<a href='javascript:;''>删除</a>"+
							"</div>"+
							"<em class='s-a-select'>默认</em>"+
							"</div>"
				}else{
					  html+="<div class='gr-address'>"+
							"<div class='clearfix pl40 pr40'><span>姓名："+record[i].addressName+"</span><span class='fr'>手机号码："+record[i].addressPhone+"</span></div>"+
							"<div class='pl40 pr40 mt5 mb10'>园区地址："+record[i].addressDetail+"</div>"+
							"<div class='pl20 pr20 lh35 tr f12' style='border-top:1px solid #ebecec'>"+
							"<a href='javascript:;' class='mr10'>设为默认</a>"+
							"<a href='javascript:;' class='mr10 ga-edit'>编辑</a>"+
							"<a href='javascript:;''>删除</a>"+
							"</div>"+
							"<em class='s-a-select'>默认</em>"+
							"</div>"
				}

			}
			$(".mt30").append(html);
		};
		
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>