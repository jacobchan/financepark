<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html>
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">访客登记列表</h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="fkCode"><a class="fa fa-search" href=""></a></div>
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
								<th>到访时间</th>
								<th>到访状态</th>
								<th>访客姓名</th>
								<th>访客电话</th>
								<th>操作</th>
							</tr>
							<!-- <tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>4个小时</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-see">查看二维码</a><span class="f12 ml5 mr5">|</span><a href="javascript:;" class="ac-show">取消访客</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>4个小时</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-see">查看二维码</a><span class="f12 ml5 mr5">|</span><a href="javascript:;" class="ac-show">取消访客</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>4个小时</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-see">查看二维码</a><span class="f12 ml5 mr5">|</span><a href="javascript:;" class="ac-show">取消访客</a></td>
							</tr>
							<tr>
								<td><a href="">123456789</a></td>
								<td>2016-1-12 17:30</td>
								<td>4个小时</td>
								<td>乔布斯</td>
								<td>18659786621</td>
								<td><a href="javascript:;" class="ac-see">查看二维码</a><span class="f12 ml5 mr5">|</span><a href="javascript:;" class="ac-show">取消访客</a></td>
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
								<col width="120"></col>
								<col width="150"></col>
								<col></col>
							</colgroup>
							<tbody><tr>
								<th>订单号</th>
								<th>到访时间</th>
								<th>到访时长</th>
								<th>访客姓名</th>
								<th>访客电话</th>
								<th>操作</th>
							</tr>
							<tr>
								<td colspan="6">暂无记录</td>
							</tr>
						</tbody></table>
					</div> -->
				</div>


	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o fkCode"> [ 123456789 ] </span>吗？
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
				<img src="/styles/images/grzx/ewm.jpg" border="0" class="mb20 fkurl"/> 
				<p class="mb10">订单号：<span class="c-o fkcodes"> [ 123456789 ] </span></p>
				<p>到访时间：<span class="bftime">2016年1月21日15:30</span></p>
				<a href="javascript:;" class="ib-btn">分享到手机</a>
				<p class="c-o f12 mt20">提示:推送到手机，必须确保手机端已经安装我们的官方APP</p>
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript" src="../scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript">
		$(function () {
			star(".starbox1 i");
				star(".starbox2 i");
				star(".starbox3 i");
				star(".starbox4 i");
				function star(ele){
					$(ele).hover(function(){
						var index=$(this).index()+1;
						$(ele).removeClass("star1").addClass("star0");
						var arr=$(ele).toArray().slice(0,index);
						for(var i=0;i<arr.length;i++){
							arr[i].className="star1";
						}
					});
				}
			$(".ac-show").click(function(){
				$(".bg-tanc.m1").show();
			});
			$(".ac-see").click(function(){
				$(".bg-tanc.m2").show();
			});
			$.ajax({
				url:baseUrl+'/propertyservicemanagerFkcodeManager/getFkcodeListforpage.json', 
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
				var html="<tr id='"+record[i].fkcodeId+"' class='aaa'>"+
						"<td><a href=''>"+record[i].fkCode+"</a></td>"+
						"<td>"+record[i].fkcodeTime+"</td>"+
						"<td>"+record[i].applyStatus+"</td>"+
						"<td>"+record[i].fkcodeName+"</td>"+
						"<td>"+record[i].fkcodeTelephone+"</td>"+
						"<td><a href='javascript:;' onclick='javascript:qrcode(this)' class='ac-see'>查看二维码</a><span class='f12 ml5 mr5'>|</span><a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消访客</a></td>"+
						"</tr>";
				 $("tbody").append(html);
				
			/* 	 $(".ac-see").click(function(){
					 $(".bg-tanc.m2").show();
				 }); */
			}
		};
		function cancel(obj){
			var me=obj.parentNode.parentNode;
			var fkCode=me.childNodes[0].childNodes[0].innerText; 
			$(".fkCode").html(fkCode);
			$(".fkCode")[0].setAttribute("id",me.id);
			$(".bg-tanc.m1").show();
		};
		function qrcode(obj){
	 		var me=obj.parentNode.parentNode;
		/* 	var fkCode=me.childNodes[0].childNodes[0].innerText; 
			var bftime = me.childNodes[1].innerText;
			var url = queryUrl(me.id); 
			var url=""; */
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'/propertyservicemanagerTwcrdManager/findTwcrdById.json',
				data:'fkcodeId='+me.id,
				success:function(result){
					if(result&&result.record){
						var fkCode=me.childNodes[0].childNodes[0].innerText; 
						var bftime = me.childNodes[1].innerText;
						var url = result.record.twcrdAddrec;
						$(".fkcodes").html(fkCode);
						$(".bftime").html(bftime);
						$(".fkcodes")[0].setAttribute("id",me.id);
						$(".fkurl")[0].setAttribute("src",ImgUrl+"/filestore/"+url);
						$(".bg-tanc.m2").show();
					}
				}
			});
		};
		//根据订单号查询
		$('.hhf-submit').click(function(){				
			$(".aaa").empty();
			 var fkCode=$("#fkCode").val(); 
			 var startTime=$("#startTime").val(); 
			 var endTime=$("#endTime").val(); 
			 params=['fkCode='+fkCode+'','startTime='+startTime+'','endTime='+endTime+'']
		      $.ajax({
		    	 url:baseUrl+'/propertyservicemanagerFkcodeManager/getFkcodelistLikeFkcodeCode.json',
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
	<!-- 取消访客 -->
	<script type="text/javascript">
	$(function(){
		$(".hhf-submit").click(function(){
				var id=$(".fkCode")[0].getAttribute("id");
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'/propertyservicemanagerFkcodeManager/getFkcodeforpage.json',
					data:'fkcodeId='+id,
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
</youi:html>
