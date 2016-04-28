<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="访客登记">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">访客登记列表<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要邀请访客</a></h3>
			<div class="clearfix">
				<div class="mt20 gr-txl clearfix lh30">
					<label class="fl mr20 f16">申请时间：</label>
					<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
					<input class="bd-input fl" type="text" id="endTime">
					<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="fkCode"></div>
					<input value="搜索" class="hhf-submit a f14 fr" type="button">
				</div>
				<table class="gt-table mt20">
					<colgroup>
						<col width="200"></col>
						<col width="130"></col>
						<col width="130"></col>
						<col width="110"></col>
						<col width="150"></col>
						<col></col>
					</colgroup>
					<tbody>
						<tr>
							<th>订单号</th>
							<th>到访时间</th>
							<th>到访状态</th>
							<th>访客姓名</th>
							<th>访客电话</th>
							<th>操作</th>
						</tr>
					</tbody>
					<tbody class="fklist"></tbody>
				</table>
				<div class="tcdPageCode fr"></div>
			</div>
		</div>	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o fkCode"> [ 123456789 ] </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit c" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<div class="bg-tanc m2">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w70 tc mt40" style="margin-left:15%">
				<img src="<%=request.getContextPath()%>/styles/images/grzx/ewm.jpg" border="0" class="mb20 fkurl" style="width: 45%;"/> 
				<p class="mb10">订单号：<span class="c-o fkcodes"> [ 123456789 ] </span></p>
				<p>到访时间：<span class="bftime">2016年1月21日15:30</span></p>
			<!-- 	<a href="javascript:;" class="ib-btn">分享到手机</a> -->
				<p class="c-o f12 mt20">提示：如果你已经下载我们官方手机应用，可以在手机端分享访客二维码</p>
			</div>
		</div>
	</div>
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div>       
    </div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	//默认每页10条
	var pageSize=10;
	var pageCount=1;//共几页
	var currentIndex = 1;//第几页
	var serviceURL = baseUrl+'propertyservicemanagerFkcodeManager/getPagerFkcodes.json';
    $(function () {		
		//分页页码显示
		 $.ajax({
			beforeSend: function(){
					//开始显示dataLoading样式
					$.showBox.DataLoading();
			},
			url: baseUrl+'propertyservicemanagerFkcodeManager/getTotalCount.json', 
			success:function(results){	
				var totalCount=results.records[0].totalCount;				
				pageCount = Math.ceil(totalCount / pageSize);//页数					
				 refreshData(1,pageSize);
				 $(".tcdPageCode").empty();
				 if(totalCount>0){
				 $(".tcdPageCode").createPage({
					pageCount:pageCount,
					current:1,
					backFn:function(p){
					currentIndex = p;
					this.pageCount=pageCount;
					refreshData(p,pageSize);
					}
				 });	
				}
				//关闭dataLoading样式
				$.showBox.CloseDataLoading();
			}
		}); 			
	});		
	//分页列表
	function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
		$.ajax({
			url:serviceURL,
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					 _parseRecords(results.records);
				}
			}
		});
	}
		//拼接列表
	function _parseRecords(record){	
		var html="";
		if(record.length>0){
			for(var i=0;i<record.length;i++){
				var id = record[i].fkcodeId ;
				var time = record[i].fkcodeTime ;
				var cancelbutton="";
				if(time){
					time = time.substring(0,10) ;
				}	
				if(record[i].dksataus=="00"){
					status = "未到访";	
					cancelbutton="<span class='f12 ml5 mr5'>|</span><a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消访客</a>";
				}else if(record[i].dksataus=='01'){
					status = "未到访";				
				}else if(record[i].dksataus=='02'){
					status = "已到访";
				}else if(record[i].dksataus=='03'){
					status = "已取消";
				}
				html+="<tr id='"+id +"' >"+
						  "<td><a href='javascript:;' onclick='viewDetail(\""+record[i].fkcodeId+"\")' class='ac-show'>"+record[i].fkCode+"</a></td>"+
						  "<td>"+time+"</td>" +	
						  "<td class='"+id+"'>"+status+"</td>"+
					      "<td>"+record[i].fkcodeName+"</td>"+
						  "<td>"+record[i].fkcodeTelephone+"</td>"+
						  "<td><a href='javascript:;' onclick='javascript:qrcode(this)' class='ac-see'>查看二维码</a>"+cancelbutton+"</td>"+
					   "</tr>";
				 $(".fklist").html(html);							
			}}else{
				var	html1 = '<tr>'
					html1 += '	<td colspan="6">暂无记录</td>'
					html1 += '</tr>'
						$(".fklist").html(html1);	
				}
		};		
	//确认取消弹窗
	function cancel(obj){
		var me=obj.parentNode.parentNode;
		var fkCode=me.childNodes[0].childNodes[0].innerText; 
		$(".fkCode").html(fkCode);
		$(".fkCode")[0].setAttribute("id",me.id);
		$(".bg-tanc.m1").show();
	};
	//二维码弹窗
	function qrcode(obj){
	 	var me=obj.parentNode.parentNode;
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'propertyservicemanagerTwcrdManager/findTwcrdById.json',
			data:'fkcodeId='+me.id,
			success:function(result){
				if(result&&result.record){
					var fkCode=me.childNodes[0].childNodes[0].innerText; 
					var bftime = me.childNodes[1].innerText;
					var url = result.record.twcrdAddrec;
					$(".fkcodes").html(fkCode);
					$(".bftime").html(bftime);
					$(".fkcodes")[0].setAttribute("id",me.id);
					$(".fkurl")[0].setAttribute("src",cenUrl+"common/down.html?repository=/swfupload&path="+url);
					$(".bg-tanc.m2").show();
				}
			}
		});
	};
		//根据订单号查询
    $('.hhf-submit').click(function(){	
			var fkCode=$("#fkCode").val();
			var startTime=$("#startTime").val(); 
			var endTime=$("#endTime").val(); 			
			var params = ['fkCode='+fkCode,'operator:fkCode=LIKE','startTime='+startTime,'endTime='+endTime];
			$.ajax({
				url:baseUrl+'propertyservicemanagerFkcodeManager/getTotalCount.json',
				data:params.join('&'),
				beforeSend: function(){
					//开始显示dataLoading样式
					$.showBox.DataLoading();
				},
				success:function(results){	
					var totalCount=results.records[0].totalCount;				
					pageCount = Math.ceil(totalCount / pageSize);//页数				
					 refreshData_query(1,pageSize);
					 $(".tcdPageCode").empty();
					 if(pageCount>0){
						$(".tcdPageCode").createPage({
						    pageCount:pageCount,
						    current:1,
						    backFn:function(p){
						    	currentIndex = p;
						       this.pageCount=pageCount;
						       refreshData_query(p,pageSize);
						    }
						});
					 }
					//关闭dataLoading样式
						$.showBox.CloseDataLoading();
	              }
	        }); 			
    });	
	//根据订单号查询 分页列表
    function refreshData_query(pageIndex,pageSize){
		var fkCode=$("#fkCode").val();	
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'fkLikeCode='+fkCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerFkcodeManager/getPagerLikeFk.json',
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					_parseRecords(results.records);
				}
			}
		});
	}
	//<!-- 取消访客 -->	
	$(function(){
		$(".hhf-submit.c").click(function(){	
				var id=$(".fkCode")[0].getAttribute("id");
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'propertyservicemanagerFkcodeManager/cancelStatus.json',
					data:'fkcodeId='+id,
					success:function(result){
						if(result&&result.record){
							//$(".bg-tanc.m1").close();
							close("取消成功!");													
						}
					}
				});
			});
		});
	//日期控件
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
	//取消成功弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
   }
    $(function () {		
		$(".hhf-submit.c").click(function(){
			$(".bg-tanc.m1").hide();
		});									
	}) 	  
	    //点击跳转到访客申请页面
	$("#a1").click(function(){			
		location.href = proUrl + "yqfw/yq4.html" ;
	})	
		//点击跳转到访客详情页面
	function viewDetail(fkcodeId){			
		window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageFkDetail.html?fkcodeId="+fkcodeId;
	};
     </script>
</youi:html>
