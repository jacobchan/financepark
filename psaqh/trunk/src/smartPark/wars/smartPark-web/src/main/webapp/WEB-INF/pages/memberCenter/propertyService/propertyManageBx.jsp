<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>

<youi:html title="物业报修">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">物业报修列表<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要报修</a></h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="bxCode"><a class="fa fa-search" href=""></a></div>
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
								<th>申请时间</th>
								<th>状态</th>
								<th>联系人</th>
								<th>联系电话</th>
								<th>操作</th>
							</tr>
							<!-- <tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12</td>
								<td>未受理</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-show">取消</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12</td>
								<td>已派工</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-show">取消</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12</td>
								<td>已完工</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;">付款</a><span class="f12 ml5 mr5">|</span><a href="">申请重修</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12</td>
								<td>已结束</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-show">取消</a></td>
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
								<th>申请时间</th>
								<th>状态</th>
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
	
	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> <span class="ifSure">确认要取消</span><span class="c-o bxCode"> [ 123456789 ] </span>吗？
				</div>
				<p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p>
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/lib/properties.js"></script>
	<script type="text/javascript">
		$(function () {
			$(".ac-show").click(function(e){
				$(".bg-tanc").show();
			});
			
			$.ajax({
				url:baseUrl+'/propertyservicemanagerBxManager/getBxListforpage.json', 
				success:function(result){
					if(result&&result.records){
						_parseRecords(result.records);
					}
				}
			});
			
		});
		
		//拼接列表
		function _parseRecords(record){
			for(var i=0;i<record.length;i++){
				var bxStatus='';
				var buttonHtml="<td><a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消</a></td>";
				if(record[i].bxStatus=='00'){
					bxStatus='待受理';
				}else if(record[i].bxStatus=='01'){
					bxStatus='已受理';
				}else if(record[i].bxStatus=='02'){
					bxStatus='待接单';
				}else if(record[i].bxStatus=='03'){
					bxStatus='已派工';
				}else if(record[i].bxStatus=='04'){
					bxStatus='已完工';
				}else if(record[i].bxStatus=='05'){
					bxStatus='已定价';
					buttonHtml="<td><a href='javascript:;'>付款</a><span class='f12 ml5 mr5'>|</span><a href='javascript:;' onclick='javascript:redeal(this)'>申请重修</a></td>";
				}else if(record[i].bxStatus=='06'){
					bxStatus='已付款';
				}else if(record[i].bxStatus=='07'){
					bxStatus='已完成';
				}else if(record[i].bxStatus=='08'){
					bxStatus='未受理';
				}
				var html="<tr id='"+record[i].bxId+"' class='aaa'>"+
						"<td><a href=''>"+record[i].bxCode+"</a></td>"+
						"<td>"+record[i].applyTime+"</td>"+
						"<td>"+bxStatus+"</td>"+
						"<td>"+record[i].memberId+"</td>"+
						"<td>18659786621</td>"+
						buttonHtml+
						"</tr>";
				 $("tbody").append(html);
			}
		};
		 function cancel(obj){
				var me=obj.parentNode.parentNode;
				var bxCode=me.childNodes[0].childNodes[0].innerText; 
				$(".bxCode").html(bxCode);
				$(".bxCode")[0].setAttribute("id",me.id);
				$(".bg-tanc").show();
			};
		 function redeal(obj){
				var me=obj.parentNode.parentNode;
				var bxCode=me.childNodes[0].childNodes[0].innerText; 
				$(".bxCode").html(bxCode);
				$(".ifSure").text("确定要重新报修");
				$(".bxCode")[0].setAttribute("id",me.id);
				$(".bg-tanc").show();
			};
	</script>
	<!-- 取消报修订单 -->
	<script type="text/javascript">
	$(function(){
		$(".hhf-submit").click(function(){
				var id=$(".bxCode")[0].getAttribute("id");
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'/propertyservicemanagerBxManager/updateBxforpage.json',
					data:'bxId='+id,
					success:function(result){
						if(result&&result.record){
							if(result.record.bxStatus=='08'){
								alert("取消成功!");
							}else if(result.record.bxStatus=='01'){
								alert("重新报修成功!");
							}
							
							location.reload();
						}
					}
				});
			});
		});
	//根据订单号查询
	$('.hhf-submit').click(function(){					
		$(".aaa").empty();
		 var bxCode=$("#bxCode").val(); 
		 var startTime=$("#startTime").val(); 
		 var endTime=$("#endTime").val(); 
		 params=['bxCode='+bxCode+'','startTime='+startTime+'','endTime='+endTime+''];
	      $.ajax({
	    	 url:baseUrl+'/propertyservicemanagerBxManager/getEnterprisemaillistLikeBxCode.json',
	    	 data:params.join('&'),
	    	 success:function(result){					
					console.log(result.records);           
					if(result&&result.records){				
						_parseRecords(result.records);					
					}
				}
		}); 
	}); 
	$(function(){
		laydate({
		    elem: '#startTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	})
	$(function(){
		laydate({
		    elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	})
	</script>
	<script type="text/javascript">
		$("#a1").click(function(){
			
			location.href = Portal + "yqfw/yq6.html" ;
		})	
</script>
</youi:html>
