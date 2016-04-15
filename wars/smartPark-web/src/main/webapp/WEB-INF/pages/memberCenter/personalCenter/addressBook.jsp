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
						<tr>
							<th>姓名</th>
							<th>联系电话</th>
							<th>一句话简介</th>
							<th>加入时间</th>
						</tr>												
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
			// 	if(result&&result.records){
					_parseRecords(result.records);
				//} 
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
			
			$(".gt-table").empty();	
			ht=
				"<tr>"+
					"<th>姓名</th>"+
					"<th>联系电话</th>"+
					"<th>一句话简介</th>"+
					"<th>加入时间</th>"+
			   "</tr>";
			   $(".gt-table").append(ht);
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
					var html= "<tr class='aaa'>"+
				      "<td >"+record[i].memberName+"</td>"+
				      "<td >"+record[i].memberPhoneNumber+"</td>"+
				      "<td >"+memberDescribe2+"</td>"+
				      "<td>"+createTime+"</td>"+				      				    					    
                      " </tr>"; 
			          $(".gt-table").append(html);					  								 				
			}
		};
		//根据名字查询
		$('.hhf-submit').click(function(){					
			$(".aaa").empty();
			 var memberName=$("#memberName").val(); 
		      $.ajax({
		    	 url:baseUrl+'memberInformationManager/getPhoneNumberlistByName.json',
		    	 data:'memberName='+memberName,
		    	 success:function(result){					
						console.log(result.records);           
						if(result&&result.records){					
							_parseRecords(result.records);						
						}
					}
			}); 
		}); 
		$(function(){
			$.ajax({
			  url:baseUrl+'enterbusinessmanagerRzManager/getCompanyIdName.json',		
				success:function(result){					
					console.log(result.record);
					if(result&&result.record){					
						_companyRecords(result.record);						
					}
				}
			});
		}); 
		
		//公司名字
		function _companyRecords(record){	
			var companyName=record.rzName;
			$("#companyName").text(companyName);
		};
	
		
	</script>
</youi:html>