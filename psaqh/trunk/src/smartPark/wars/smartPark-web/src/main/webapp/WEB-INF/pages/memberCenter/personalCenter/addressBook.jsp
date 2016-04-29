<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="企业通讯录">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">企业通讯录</h3>
			<div class="mt20 gr-txl clearfix lh30">
				<span class="f16" id="companyName"></span>
				<div class="fr">
					<input type="text" class="bd-input" id="memberName" placeholder="请输入姓名">
					<input value="查询" class="hhf-submit" type="button" style="padding:0px 20px;height:30px;">							
				</div>
			</div>
			<table class="gt-table mt20">
				<colgroup>
					<col width="220"></col>
					<col width="220"></col>
					<col height="50"></col>
					<col width="220"></col>
				</colgroup>						
				<tbody>
					<tr>
						<th>姓名</th>
						<th>联系电话</th>
						<th>一句话简介</th>
						<th>加入时间</th>
					</tr>	
				</tbody>
				<tbody class="list"></tbody>																	
			</table>
			<div class="tcdPageCode fr"></div>
		</div>
	</youi:body>
	<!--***bottom start****************************************-->

	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'memberInformationManager/getPager.json';	
 	$(function () {		
		//分页页码显示
		 $.ajax({
			url:baseUrl+'memberInformationManager/getPager.json', 
			beforeSend: function(){
				//开始显示dataLoading样式
				$.showBox.DataLoading();
			},
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数
				if(pageCount>0){
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
	
		//拼接卡号列表
	function _parseRecords(record){				
		var html="";		
		if(record.length>0){
	 		for(var i=0;i<record.length;i++){
	 			  var memberDescribe2="";
	 			 var createTime="";
	 			   if(record[i].memberDescribe2){
	 				  memberDescribe2=record[i].memberDescribe2;	 				  
	 			   }else{
	 				  memberDescribe2=""; 
	 			   }
	 			    if(record[i].createTime){
	 			    	createTime=record[i].createTime; 				 
	 			   }else{
	 				  createTime="";
	 				  } 
					html+= "<tr>"+
				      			 "<td >"+record[i].memberName+"</td>"+
				     			 "<td >"+record[i].memberPhoneNumber+"</td>"+
				      			 "<td >"+memberDescribe2+"</td>"+
				      			 "<td>"+createTime+"</td>"+				      				    					    
                      		  " </tr>"; 
			          
	 		   }
	 			$(".list").html(html);
	 	}else{
				var	html1 =  '<tr>'
					html1 += '	<td colspan="6">暂无数据</td>'
					html1 += '</tr>'
				$(".list").html(html1);	
			}			
	};
		//根据名字查询
	$('.hhf-submit').click(function(){					
		var memberName=$("#memberName").val(); 
		var params=['memberName='+memberName,'operator:memberName=LIKE'];
			$.ajax({
			url:baseUrl+'memberInformationManager/getPhoneNumberlistByName.json',
			data:params.join('&'),
			url:serviceURL, 
				success:function(results){	
						pageCount=Math.ceil(results.totalCount/pageSize);//页数
						//alert(pageCount);
						if(pageCount>0){
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
		      }
	     }); 			
    });	
	//分页列表
	function refreshData_query(pageIndex,pageSize){
		var memberName=$("#memberName").val(); 
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'memberName='+memberName,'operator:memberName=LIKE'];
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
	////公司名字
	$(function(){
		$.ajax({
			url:baseUrl+'enterbusinessmanagerRzManager/getCompanyIdName.json',		
			success:function(result){					
			   if(result&&result.record){					
			      var companyName=result.record.rzName;
			      $("#companyName").text(companyName);					
			   }
		     }
		});
	}); 		
	</script>
</youi:html>