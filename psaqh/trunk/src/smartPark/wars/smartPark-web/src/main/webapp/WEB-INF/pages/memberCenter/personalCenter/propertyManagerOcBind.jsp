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
	<div class="tcdPageCode fr"></div>
</youi:body>
	<div class="toast">
    	<div class="toast-con clearfix">
     		<div class="close-toast fr"></div>
     		<p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
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
		if(record.length>0){
			for(var i=0;i<record.length;i++){				
				var status = "";
				var html = "";
				 if(record[i].bindStatus=='1'){						
					html="<div class='mt20'>"+
							  //"<img src='../images/grzx/check.png' border='0' />"+
							  "<span class='ml30 mr30'>已绑定卡号：<font class='c-o'>"+record[i].ocNumber+"</font></span>"+
							  "<input value='解除绑定' class='hhf-submit' style='padding:0px 10px;height:26px;' type='button' value='解绑'   onclick='unbound(\""+record[i].ocId+"\")'>"+
							  "</div>";
					 $(".w1000").append(html);		 
				}
	
			}
		}else{
			var	html1 = '<tr>'
				html1 += '	<td colspan="6">暂无记录</td>'
				html1 += '</tr>'
			 $(".oclist").html(html1);	}
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
					location.reload();
				}
			}
		});
	});	 
		function unbound(id){					   			
			var ocId=id;			
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'propertyservicemanagerOcManager/updateBindStatus.json',
				data:'ocId='+ocId,
		 		success:function(result){
					if(result&&result.record){					
						alert("修改成功");
						location.reload();
					}
				}
			}); 
		}
		 function close(content){		        
		        $(".tc.mt25.f18").empty() ;
		        $(".tc.mt25.f18").append(content) ;
		        $(".toast").show();		      		        		       				
				setTimeout(function(){$(".toast").hide(); },1000);
				//refreshData(currentIndex,pageSize);
	      }
	</script>
</youi:html>