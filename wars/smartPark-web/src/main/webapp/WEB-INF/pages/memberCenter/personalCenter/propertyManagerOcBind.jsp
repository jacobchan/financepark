<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="一卡通绑定">
	<youi:body decorator="memcenter">  
		<div class="w1000">
			<h3 class="per-h3">一卡通绑定</h3>
			<h4 class="f16 mt20">绑定信息</h4>
			<div class="mt20">
				<input class="bd-input" type="text" id="ocNumber" style="width:290px;" placeholder="请输入卡号">
				<input value="绑定" class="hhf-submit bd" style="padding:0px 10px;height:30px;" type="button">
			</div>

		</div>
		<div class="w1000 a" id="list">
		</div>
	<div class="tcdPageCode fr"></div>
</youi:body>
	<div class="toast">
    	<div class="toast-con clearfix">
     		<div class="close-toast fr"></div>
     		<p class="tc mt25 f18" style="color:#ff6715"></p>
  		</div>         
    </div>
    <div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit" id="confirm">
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10; //每页默认显示10条
	var pageCount=1; //总页数
	var currentIndex = 1; //第几页
	var serviceURL = baseUrl+'propertyservicemanagerOcManager/getPagerOc.json';
	var bindStatus="1";
	$(function () {	
		
		//分页页码显示
		$.ajax({			 
			url:baseUrl+'propertyservicemanagerOcManager/getTotalCount.json', 
			data:'bindStatus='+bindStatus,
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
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
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'bindStatus='+bindStatus];
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
	//拼接卡号列表
	function _parseRecords(record){
		var html = "";
		var status = "";
		if(record.length>0){
			for(var i=0;i<record.length;i++){							
				 if(record[i].bindStatus=='1'){						
					html+=   "<div class='mt20'>"
					html +=     "<img src='<%=request.getContextPath()%>/styles/images/grzx/check.png' border='0' />"
					html +=	    "<span class='ml30 mr30'>已绑定卡号：<font class='c-o'>"+record[i].ocNumber+"</font></span>"
					html +=	 	"<input value='解除绑定' class='hhf-submit' style='padding:0px 10px;height:26px;' type='button' value='解绑'   onclick='unbound(\""+record[i].ocId+"\",\""+record[i].ocCode+"\")'>"
					html +=	 "</div>";	 
				}
				 $("#list").html(html);	
			}
		}else{
			var	html1 = 暂无绑定卡号				
			 $("#list").html(html1);	
			}
		};
		
	
	$('.hhf-submit').click(function(){
		this.disabled=true;			
		var ocNumber=$("#ocNumber").val();				
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'propertyservicemanagerOcManager/addBindOc.json',
			data:'ocNumber='+ocNumber,
			success:function(result){
				if(result&&result.record){
					close("增加成功");
				}
			}
		});
	});	 
	function close(content){		        
		$(".tc.mt25.f18").empty() ;
		$(".tc.mt25.f18").append(content) ;
		$(".toast").show();		      		        		       				
		setTimeout(function(){$(".toast").hide(); },1000);
		refreshData(currentIndex,pageSize);
	}
	//解绑
	function unbound(ocId,ocCode){
		$(".moverec").html(ocCode);//给弹窗插入订单号
		$(".moverec")[0].setAttribute("id",ocId);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//点击解绑
	$(function(){
		$("#confirm").click(function(){	
		    $(".bg-tanc.m1").hide();
			var id=$(".moverec")[0].getAttribute("id");				
			$.ajax({
				url:baseUrl+'propertyservicemanagerOcManager/updateBindStatus.json',
				data:'ocId='+id,
				success:function(result){
					if(result&&result.record){					
						close("修改成功");
					}
				}
			});
		});
	});		 
	</script>
</youi:html>