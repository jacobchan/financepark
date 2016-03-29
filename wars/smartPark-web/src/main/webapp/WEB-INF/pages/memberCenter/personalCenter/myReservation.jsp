<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我的预约">
	<youi:body decorator="memcenter"> 
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
							<!-- <tr>
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
							</tr> -->
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
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o recordId"> [ 123456789 ] </span>吗？
				</div>
				<p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p>
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript">
		$(function () {
			$.ajax({
				url:baseUrl+'/reservationRecordManager/getReservationRecordsforpage.json', 
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
			var html="";
			for(var i=0;i<record.length;i++){
				var recordStatus=record[i].recordStatus;
				var buttonHtml="<td><a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消预约</a></td>";
				if(recordStatus=="01"){
					recordStatus="已预约";
				}else if(recordStatus=="02"){
					recordStatus="已受理";
				}else if(recordStatus=="03"){
					recordStatus="已入驻";
					buttonHtml="";
				}
				html+="<tr id='"+record[i].recordId+"'>"+
					"<td><a href=''>"+record[i].recordId+"</a></td>"+
					"<td>"+record[i].visiteDate+"</td>"+
				//	"<td>"+"展厅参观"+"</td>"+
					"<td>"+record[i].recordMemberId+"</td>"
					"<td>"+recordStatus+"</td>"+
					buttonHtml+
					"</tr>";
			}
			 $("tbody").append(html);
		};
		
		 function cancel(obj){
				var me=obj.parentNode.parentNode;
				var recordId=me.childNodes[0].childNodes[0].innerText; 
				$(".recordId").html(recordId);
				$(".bg-tanc.m1").show();
			}
	</script>
</youi:html>