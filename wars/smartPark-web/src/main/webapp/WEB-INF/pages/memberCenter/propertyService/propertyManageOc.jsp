<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="一卡通办理">
	<youi:body decorator="memcenter">  
				<div class="w1000">
					<h3 class="per-h3">一卡用绑定<a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>我要申请一卡通</a></h3>
					<div class="clearfix mt40" rules=none>
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="ocCode"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
						</div>											   					    
						<table class="gt-table mt20" border="0">
                        <tr>
					     	<td width="111">订单号 </td>
                         	<!-- <td width="111">企业名称    </td> -->
                         	<td width="111">预约时间    </td>
                         	 <td width="111">预约用户  </td> 
                         	<td width="111">状态        </td>
                         	<td width="111">操作  </td>
                         </tr>                          
                         </table>                     
					<div class="tcdPageCode fr"></div>
					</div>
				</div>
			</youi:body>
				<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
	<!--***bottom start****************************************-->
   <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerOcManager/getPagerOc.json';
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
		//拼接列表
		function _parseRecords(record){	
			$("tbody").empty();
			ht="<tr>"+
	     	"<td>订单号       </td>"+
         	"<td>预约时间    </td>"+
         	"<td>预约用户  </td> "+
         	"<td>状态           </td>"+
         	"<td>操作          </td>"+
            "</tr>";
            $(".gt-table").append(ht);
	 		for(var i=0;i<record.length;i++){
				var status = "";	
				var button = "";	
					  if(record[i].ocStatus=='01'){
						  status = "已处理";
					  }else if(record[i].ocStatus=='02'){
						  status = "已领卡";
					  }	
					  else if(record[i].ocStatus=='08'){
						  status = "已取消";
					  }else if(record[i].ocStatus=='00'){
						  status = "待处理";
						  button="<a href='#' onclick='hhf(\""+record[i].ocId+"\")'>取消</a>";
					  }	
					  var html= "<tr class='aaa'>"+
				      "<td width='111'>"+record[i].ocCode+"</td>"+
				
				      "<td width='111'>"+record[i].ocDate+"</td>"+
				     "<td width='111'>"+record[i].member.memberName+"</td>"+
				      "<td width='111'>"+status+"</td>"+				    
				      "<td width='111' >"+button+"</td>"+                    
                      " </tr>"; 
			 		$(".gt-table").append(html);									 				
			}
		};
		function hhf(id){						
			var ocId=id;			
		     $.ajax({
				url:baseUrl+'propertyservicemanagerOcManager/cancleOcStatus.json',
				data:'ocId='+ocId+'',
		 		success:function(result){
					if(result&&result.record){					
						close("取消成功");
						
					}
				}
			});
		}
		//根据订单号查询
		$('.hhf-submit').click(function(){	
			
			$(".aaa").empty();
			 var ocCode=$("#ocCode").val(); 
			 var startTime=$("#startTime").val(); 
			 var endTime=$("#endTime").val(); 
			 params=['ocCode='+ocCode+'','startTime='+startTime+'','endTime='+endTime+''];
		      $.ajax({
		    	 url:baseUrl+'propertyservicemanagerOcManager/getOclistLikeOcCode.json',		    	
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
	    //点击跳转到一卡通申请页面
		$("#a1").click(function(){			
			location.href = proUrl + "yqfw/yq10.html" ;
		})	
     </script>
</youi:html>