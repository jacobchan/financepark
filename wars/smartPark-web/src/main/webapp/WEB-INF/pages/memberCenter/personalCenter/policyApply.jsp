<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="政策申请">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我的政策<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要申请政策</a></h3>
					<div class="clearfix mt40">
						<table class="gt-table mt20">
							<colgroup>
								<col width="120"></col>
								<col width="120"></col>
								<col></col>
								<col width="120"></col>
								<col width="120"></col>
								<col width="120"></col>
							</colgroup>
							<tbody><tr>
								<th>申请编号</th>
								<th>政策类型</th>
								<th>申请人</th>
								<th>申请时间</th>
								
								
								<th>申请状态</th>
								<th>操作</th>
							</tr>														
						</tbody></table>                       
						<div class="tcdPageCode fr"></div>
					</div>
				</div>
				<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
    <div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
		</youi:body>
		
	<!--***bottom start****************************************-->

	
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=5;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'policyApplyManager/getPagerPolicyApply.json';
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
	//取消政策申请，前端调用
	 function cancel(id){		
		var policyApplyId=id;	
		
	     $.ajax({
			url:baseUrl+'policyApplyManager/cancelApply.json',
			data:'policyApplyId='+policyApplyId,
	 		success:function(result){
				if(result&&result.record){					
					$(".tc.mt25.f18").text("取消成功");
					$(".toast").show(); 
					setTimeout(function(){location.reload(); },1000);
				}
			}
		});
	} 
	
	
		//拼接列表
		function _parseRecords(record){		
			ht="<tr>"+
				"<th>申请编号</th>"+
				"<th>政策类型</th>"+
				"<th>申请人</th>"+
				"<th>申请时间</th>	"+							
				"<th>申请状态</th>"+
				"<th>操作</th>"+
			    "</tr>";
			    $(".gt-table").append(ht);
			console.log(record);
			$("tbody").empty();
			for(var i=0;i<record.length;i++){				
				var status = "";
				var button = "";
			
				if(record[i].policyApplyStatus=='1'){
					status = "申请中";	
					button="<a href='#'   onclick='cancel(\""+record[i].policyApplyId+"\")'> 取消</a>";
				}else if(record[i].policyApplyStatus=='2'){
					status = "申请成功";
				}else if(record[i].policyApplyStatus=='3'){
					status = "申请失败";
				} else if(record[i].policyApplyStatus=='4'){
					status = "取消";
				} 
				var html= "<tr>"+
					      "<td width='111'>"+record[i].applyCode+"</td>"+
                          "<td width='111'>"+record[i].nmIssuenews.policyCaption+"</td>"+
                          "<td width='111'>"+record[i].policyApplyContactPeople+"</td>"+
                          "<td width='111'>"+record[i].createTime+"</td>"+
                          
                          "<td width='88'>"+status+"</td>"+                          
                          "<td >" +button+"</td>"+
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};	
	</script>
	<script type="text/javascript">
	//取消政策申请，前端调用
	 function cancel(id){		
		var policyApplyId=id;	
		$.ajax({				
			url:baseUrl+'policyApplyManager/cancelApply.json',
			data:'policyApplyId='+policyApplyId,
			success:function(result){
				if(result&&result.record){					
					close("已取消");
					
				}
			}
		});
	}; 
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },1000);
			refreshData(currentIndex,pageSize);
   }
	 </script>
	 <script type="text/javascript">
	    //点击跳转到政策申请页面
		$("#a1").click(function(){			
			location.href = proUrl + "zscenter/zs3.html" ;
		})	
     </script>
</youi:html>