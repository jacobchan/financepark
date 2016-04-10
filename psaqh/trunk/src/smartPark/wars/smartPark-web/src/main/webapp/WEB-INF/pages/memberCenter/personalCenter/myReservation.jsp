<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我的预约">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我的预约列表</h3>
					<div class="clearfix mt20 mb20">
						<ul class="order-nav">
							<li class="active">我的预约</li>
							<li>入驻申请预约</li>
						</ul>
					</div>
					<div class="clearfix-box">
					<div class="clearfix">
						<table class="gt-table mt20">
							<colgroup>
								<col width="180"></col>
								<col width="180"></col>
								<col width="180"></col>
								<col width="180"></col>
								<col></col>
							</colgroup>
							<tbody id="myRecord"><!--<tr>
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
					
					<div class="clearfix-box" style="display:none;">
					<div class="clearfix">
						<table class="gt-table mt20">
							<colgroup>
								<col width="180"></col>
								<col width="180"></col>
								<col width="180"></col>
								<col width="180"></col>
								<col></col>
							</colgroup>
							<tbody id="enterRecord"><!--<tr>
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
				</div>
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
				<span id="enterCode" style="display:none"></span>
				<span id="enterStatus" style="display:none"></span>
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消 <span class="c-o recordId">    </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
<script type="text/javascript">
		$(function () {
			$(".order-nav li").click(function(){
				$(this).addClass("active").siblings().removeClass("active");
				$(".clearfix-box").hide();
				$(".clearfix-box").eq($(this).index()).show();
			})
		})
	</script>
	<script type="text/javascript">
		$(function () {
			$.ajax({
				url:baseUrl+'reservationRecordManager/getReservationRecordsforpage.json', 
				success:function(result){
					console.log(result);
					if(result&&result.records){
						_parseRecord(result.records);
					}
				}
			});
		});
		
		//拼接列表
		function _parseRecord(record){
			var html="<tr><th>预约单号</th><th>预约时间</th><th>预约项目</th><th>状态</th><th>操作</th></tr>";
			for(var i=0;i<record.length;i++){
				var recordStatus=record[i].recordStatus;
			//	var buttonHtml="<td><a href='javascript:;' class='ac-show' onclick='javascript:cancelStatus(this)'>取消预约</a></td>";
				var vv = record[i].recordId+","+record[i].recordCode;
				var buttonHtml="<td><a href='javascript:;' class='ac-show'"+
				"onclick='javascript:cancelStatus(\""+record[i].recordId+"\",\""+record[i].recordCode+"\",\""+record[i].recordStatus+"\")'>取消预约</a></td>";
				if(recordStatus=="01"){
					recordStatus="已预约";
				}else if(recordStatus=="02"){
					recordStatus="已受理";
				}else if(recordStatus=="03"){
				    recordStatus="已入驻";
					buttonHtml="";
				}else if(recordStatus=="08"){
				    recordStatus="已取消";
				}
				html+="<tr id='"+record[i].recordId+"'>"+
					 "<td><a href=''>"+record[i].recordCode+"</a></td>"+ 
					 /*"<td>"+record[i].recordCode+"</td>"+*/
					"<td>"+record[i].visiteDate+"&nbsp;"+record[i].visiteTime+"</td>"+
					"<td>"+record[i].recordMemberId+"</td>"+
				//	"<td>"+record[i].recordType+"</td>"
					"<td>"+recordStatus+"</td>"+
					buttonHtml+
					"</tr>";
			}
			 $("#myRecord").empty();
			 $("#myRecord").append(html);
		};
		
		 function cancel(obj){
				var me=obj.parentNode.parentNode;
				var recordId=me.childNodes[0].childNodes[0].innerText; 
				$(".recordId").html(recordId);
				$(".bg-tanc.m1").show();
			}
	</script>
	
	<script type="text/javascript">
		$(function () {
			$.ajax({
				url:baseUrl+'propertyservicemanagerEntrecManager/getPropertyservicemanagerEntrecs.json', 
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
			var html="<tr><th>预约单号</th><th>预约时间</th><th>预约项目</th><th>状态</th><th>操作</th></tr>";
			for(var i=0;i<record.length;i++){
				var recordStatus=record[i].enterrecStatus;
				var enteringType=record[i].enteringType;
				var enteringTime=record[i].propertyservicemanagerEntering.enteringTime;
				if(enteringTime=="AM"){
					enteringTime="09:00-12:00";
				}else if(enteringTime=="PM"){
					enteringTime="14:00-17:00";
				}
				if(enteringType=="01"){
					enteringType="入驻申请";
				}else if(enteringType=="02"){
					enteringType="装修申请";
				}else if(enteringType=="03"){
					enteringType="合同主体变更";
				}else if(enteringType=="04"){
					enteringType="客户续约";
				}else if(enteringType=="05"){
					enteringType="客户退租";
				}
				var buttonHtml="<td id="+record[i].enterrecStatus+"><a href='javascript:;' class='ac-show' onclick='javascript:cancelForEnter(\""+record[i].entrecId+"\",\""+record[i].enterrecCode+"\",\""+record[i].enterrecStatus+"\")'>取消预约</a></td>";
				if(recordStatus=="01"){
					recordStatus="待受理";
				}else if(recordStatus=="02"){
					recordStatus="已受理";
				}else if(recordStatus=="03"){
					recordStatus="已到访";
				}else if(recordStatus=="04"){
					recordStatus="已取消";
				}else if(recordStatus=="05"){
					recordStatus="未到访";
				}
				html+="<tr id='"+record[i].entrecId+"'>"+
					 "<td><a href=''>"+record[i].enterrecCode+"</a></td>"+ 
					 /*"<td>"+record[i].enterrecCode+"</td>"+*/
					"<td>"+record[i].propertyservicemanagerEntering.enteringDate+"&nbsp;"+enteringTime+"</td>"+
					"<td>"+enteringType+"</td>"+
					"<td>"+recordStatus+"</td>"+
					buttonHtml+
					"</tr>";
			}
			 $("#enterRecord").empty();
			 $("#enterRecord").append(html);
		};
		//取消预约
		 function cancelForEnter(entrecId,enterrecCode,enterrecStatus){
				/* var me=obj.parentNode.parentNode;
				var enterrecCode=me.childNodes[0].childNodes[0].innerText; 
				$(".recordId").html(enterrecCode);
				$("#enterCode").val(me.id);
				$("#enterStatus").val(obj.parentNode.id);
				$(".bg-tanc.m1").show(); */
				 alert(entrecId);
				//alert(enterrecCode);
				//alert(enterrecStatus); 
			   if(enterrecStatus == '01'||enterrecStatus == '02'){
				 	$.youi.ajaxUtils.ajax({
						url:baseUrl+'propertyservicemanagerEntrecManager/cancelReservation.json',
						data:'entrecId='+entrecId,
						success:function(result){
								alert("取消成功!");
								location.reload();
							}
					});
					}else{
			            alert("该状态不能进行取消操作");

			        }			
			}
		
		  function cancelStatus(recordId,recordCode,recordStatus){			
				//$(".recordId").html(recordCode);
				//$("#enterCode").val(me.id);
				//$("#enterStatus").val(obj.parentNode.id);
				//$(".bg-tanc.m1").show();																
				if(recordStatus == '01'){
				 	$.youi.ajaxUtils.ajax({
						//url:baseUrl+'reservationRecordManager/cancelStatus.json',
						url:baseUrl+'reservationRecordManager/cancelReservation.json',
						//cancelReservation
						data:'recordId='+recordId,
						success:function(result){
								alert("取消成功!");
								location.reload();
							}
					});
					}else{
			         alert("该状态不能进行取消操作");

			      }
			} 
	</script>
	

</youi:html>