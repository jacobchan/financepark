<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="物业投诉">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">物业投诉列表物业报修列表<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要投诉</a></h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="cosCode"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit" type="button">
						</div>
						
						<table class="gt-table mt20">
							<colgroup>
								<col width="150"></col>
								<col width="150"></col>
								<col width="80"></col>
								<col width="100"></col>
								<col width="120"></col>
								<col width="120"></col>
								<col></col>
							</colgroup>
							<tbody id="czh-knowledge">
								<tr>
									<th>订单号</th>
									<th>申请时间</th>
									<th>是否回访</th>
									<th>联系人</th>
									<th>联系电话</th>
									<th>投诉状态</th>
									<th>操作</th>
								</tr>
							</tbody>
						</table>
						<div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有  <span id="count"></span> 条，每页显示： 50 条</span>
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
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o cosCode"> [ 123456789 ] </span>吗？
				</div>
				<p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p>
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/page/laydate/laydate.js"></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/lib/properties.js"></script> --%>
	<script type="text/javascript">
		//读取当前用户投诉记录
		$(function(){
			$("#grzl").attr("class","");
			$("#property").attr("class","active");
			$.ajax({
				url:baseUrl+'propertyservicemanagerCosManager/getCosListByLoginUser.json',
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
					status = "已完成";
				}
				var html="<tr id='"+record[i].cosId+"' class='aaa'><td>"+record[i].cosCode+"</td>"+
				"<td>"+record[i].cosTime+"</td>"+
				"<td>"+bool+"</td><td>"+record[i].cosName+"</td>"+
				"<td>"+record[i].cosTelephone+"</td><td>"+status+"</td>"+
				"<td><a href='javascript:;' onclick='javascript:cancel(this)' class='ac-show'>"+crop+"</a></td></tr>";
				
				$("tbody").append(html);
			}
		};
		
		 function cancel(obj){
				var me=obj.parentNode.parentNode;
				var cosCode=me.childNodes[0].innerText;
				$(".cosCode").html(cosCode);
				$(".cosCode")[0].setAttribute("id",me.id);
				$(".bg-tanc").show();
			};
			//根据订单号查询
			$('.hhf-submit').click(function(){	
				
				$(".aaa").empty();
				 var cosCode=$("#cosCode").val(); 
				 var startTime=$("#startTime").val(); 
				 var endTime=$("#endTime").val(); 
				 params=['cosCode='+cosCode+'','startTime='+startTime+'','endTime='+endTime+''];
			      $.ajax({
			    	 url:baseUrl+'propertyservicemanagerCosManager/getCoslistLikeCosCode.json',
			    	 data:params.join('&'),
			    	 success:function(result){					    		 
							console.log(result.records);           
							if(result&&result.records){						
								_parseRecords(result.records);							
							}
						}
				}); 
			}); 
	</script>
	
	<!-- 取消投诉 -->
	<script type="text/javascript">
	$(function(){
		$(".hhf-submit").click(function(){
				var id=$(".cosCode")[0].getAttribute("id");
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
					data:'cosId='+id,
					success:function(result){
						if(result&&result.record){
							alert("取消成功!");		
							location.reload();
						}
					}
				});
			});
		});
	$(function(){
		laydate({
		    elem: '#startTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	});
	$(function(){
		laydate({
		    elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	});
	//点击跳转到投诉页面
	$("#a1").click(function(){
		
		location.href = proUrl + "yqfw/yq9.html" ;
	})	
	</script>
	
</youi:html>
