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
							<div class="inp-box ml20"><input placeholder="投诉单号查询" type="text" id="cosCode"><a class="fa fa-search" href=""></a></div>
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
									<th>投诉单号</th>
									<th>申请时间</th>
									<th>是否回访</th>
									<th>联系人</th>
									<th>联系电话</th>
									<th>投诉状态</th>
									<th>操作</th>
								</tr>
							</tbody>
						</table>
						<div class="tcdPageCode fr">
							
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
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
	<!--***弹窗 end****************************************-->
</youi:body>
	
	
	<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/lib/properties.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=5;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerCosManager/getPagerCos.json';
	
	$(function () {
		
		//分页页码显示
		 $.ajax({
			url:serviceURL, 
			success:function(results){	
							pageCount=Math.ceil(results.totalCount/pageSize);//页数
							
							 refreshData(1,pageSize);
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
		//格式化展示列表
		function _parseRecords(record){
			$("tbody").empty();
	     ht="<tr>"+
			"<th>订单号</th>"+
			"<th>申请时间</th>"+
			"<th>是否回访</th>"+
			"<th>联系人</th>"+
			"<th>联系电话</th>"+
			"<th>投诉状态</th>"+
			"<th>操作</th>"+
		    "</tr>";
		    $("tbody").append(ht);
			
		//	$("#count").append(record.length);
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
					crop = "取消";
					status = "受理中";
				}else if(record[i].cosStatus=='2'){
					status = "已受理";
				}else if(record[i].cosStatus=='3'){
					status = "已取消";
				}else if(record[i].cosStatus=='4'){
					status = "已回访";
				}else if(record[i].cosStatus=='5'){
					status = "待评价";
					crop = "评价";
				}else if(record[i].cosStatus=='6'){
					status = "已完成";
				}
				var html="<tr id='"+record[i].cosId+"' class='aaa'><td>"+
				"<a href='<%=request.getContextPath()%>/member/memberCenter/propertyService/propertyManageCosDetail.html'>"+record[i].cosCode+"</a>"+
				"</td>"+
				"<td>"+record[i].cosTime+"</td>"+
				"<td>"+bool+"</td><td>"+record[i].cosName+"</td>"+
				"<td>"+record[i].cosTelephone+"</td><td>"+status+"</td>"+
				"<td><a href='javascript:;' onclick='javascript:cancel(\""+record[i].cosId+"\")' class='ac-show'>"+crop+"</a></td></tr>";
				
				$("tbody").append(html);
			}
		};
		
		/*  function cancel(obj){
				var me=obj.parentNode.parentNode;
				var cosCode=me.childNodes[0].innerText;
				$(".cosCode").html(cosCode);
				$(".cosCode")[0].setAttribute("id",me.id);
				$(".bg-tanc").show();
			}; */
			//根据订单号查询
	/*  $('.hhf-submit').click(function(){	
				
				$(".aaa").empty();
				 var cosCode=$("#cosCode").val(); 
				 var startTime=$("#startTime").val(); 
				 var endTime=$("#endTime").val(); 
				 params=['cosCode='+cosCode+'','startTime='+startTime+'','endTime='+endTime+''];
			      $.ajax({
			    	 url:baseUrl+'propertyservicemanagerCosManager/getCoslistLikeCosCode.json',
			    	 //url:baseUrl+'propertyservicemanagerCosManager/getPagerCos.json',
			    	 data:params.join('&'),
			    	 success:function(result){					    		 
							console.log(result.records);           
							if(result&&result.records){						
								_parseRecords(result.records);							
							}
						}
				}); 
	});   */
	 $('.hhf-submit').click(function(){	
		var cosCode=$("#cosCode").val();
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['coslikeCode='+cosCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerCosManager/getPagerLikeCos.json',
			data:params.join('&'),
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数				
				
				 refreshData_query(1,pageSize);
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
        }); 			
    });	
		//根据订单号查询 分页列表
		function refreshData_query(pageIndex,pageSize){
			var cosCode=$("#cosCode").val();	
			 var startTime=$("#startTime").val(); 
			 var endTime=$("#endTime").val(); 
			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'coslikeCode='+cosCode,'startTime='+startTime,'endTime='+endTime];
			$.ajax({
				url:baseUrl+'propertyservicemanagerCosManager/getPagerLikeCos.json',
				data:params.join('&'),
				success:function(results){
					if(results&&results.records){
						 _parseRecords(results.records);
					}
				}
			});
		}
	 
	</script>
	
	<!-- 取消投诉 -->
	<script type="text/javascript">
	function cancel(cosId){
				
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
					data:'cosId='+cosId,
					success:function(result){
						if(result&&result.record){

							close("取消成功");
							
						}
					}
				});
			}
		
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
	//弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
      }
	</script>
	
</youi:html>
