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
							<input value="搜索" class="hhf-submit f14 fr query" type="button">
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
							
						</tbody></table>
						<div class="tcdPageCode fr"></div>
					</div>
					
				</div>
	
	
	<!--***弹窗 start****************************************-->

	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
	<!--***弹窗 end****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
</youi:body>
	
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerBxManager/getPagerBxs.json';
	$(function () {
		
		//分页页码显示
		 $.ajax({
			url:baseUrl+'propertyservicemanagerBxManager/getTotalCount.json', 
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
			/* 	if(result&&result.records){
					_parseRecords(result.records);
				} */
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
			$("tbody").empty();
			var ht="<tr>"+
			"<th>订单号</th>"+
			"<th>申请时间</th>"+
			"<th>状态</th>"+
			"<th>联系人</th>"+
			"<th>联系电话</th>"+
			"<th>操作</th>"+	
				"</tr>";
		$("tbody").append(ht);
			for(var i=0;i<record.length;i++){
				var bxStatus='';
				var buttonHtml='';
				if(record[i].bxStatus=='00'){
					bxStatus='待受理';
					buttonHtml="<a href='javascript:;' class='ac-show' onclick='javascript:cancel(this)'>取消</a>";
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
					buttonHtml="<td><a href='javascript:;'>付款</a><span class='f12 ml5 mr5'>|</span><a href='javascript:;' onclick='javascript:redeal(\""+record[i].bxId+"\")'>申请重修</a></td>";
				}else if(record[i].bxStatus=='06'){
					bxStatus='已付款';
				}else if(record[i].bxStatus=='07'){
					bxStatus='已完成';
				}else if(record[i].bxStatus=='08'){
					bxStatus='已取消';
				}
				var html="<tr id='"+record[i].bxId+"' class='aaa'>"+
						"<td><a href=''>"+record[i].bxCode+"</a></td>"+
						"<td>"+record[i].applyTime+"</td>"+
						"<td>"+bxStatus+"</td>"+
						//"<td>"+"张三"+"</td>"+
						"<td>"+record[i].member.memberName+"</td>"+
						"<td>18659786621</td>"+
						"<td>"+buttonHtml+"</td>"
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
		 function cancel(obj){
				var me=obj.parentNode.parentNode;//找到父节点	
				//alert(me.id);
				var bxCode=me.childNodes[0].childNodes[0].innerText; //获取订单号
				$(".moverec").html(bxCode);//给弹窗插入订单号
				$(".moverec")[0].setAttribute("id",me.id);//给弹窗设置id
				$(".bg-tanc.m1").show();
			};
			//点击确认取消搬家预约
			$(function(){
				$(".hhf-submit.confirm").click(function(){	
					    $(".bg-tanc.m1").hide();
						var id=$(".moverec")[0].getAttribute("id");				
					 	$.ajax({
					 		url:baseUrl+'propertyservicemanagerBxManager/updateBxforpage.json',
							data:'bxId='+id,
							success:function(result){
								if(result&&result.record){
									if(result.record.bxStatus=='08'){								
										close("取消成功")																
									}else if(result.record.bxStatus=='01'){								
										close("重新报修成功");								
									}													
								}
							}
						});
					});
				});	
	//根据订单号查询
		$('.hhf-submit.f14.fr.query').click(function(){	
		var bxCode=$("#bxCode").val();
		//alert(ocCode);
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['bxLikeCode='+bxCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerBxManager/getTotalCount.json',
			data:params.join('&'),
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数				
				//alert(pageCount);
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
			var bxCode=$("#bxCode").val();	
			 var startTime=$("#startTime").val(); 
			 var endTime=$("#endTime").val(); 
			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'bxLikeCode='+bxCode,'startTime='+startTime,'endTime='+endTime];
			$.ajax({
				url:baseUrl+'propertyservicemanagerBxManager/getPagerLikeBx.json',
				data:params.join('&'),
				success:function(results){
					if(results&&results.records){
						 _parseRecords(results.records);
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
	  function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			refreshData(currentIndex,pageSize);
      }
	</script>
	<script type="text/javascript">
	    //点击跳转到投诉页面
		$("#a1").click(function(){			
			location.href = proUrl + "yqfw/yq6.html" ;
		});	
     </script>
</youi:html>
