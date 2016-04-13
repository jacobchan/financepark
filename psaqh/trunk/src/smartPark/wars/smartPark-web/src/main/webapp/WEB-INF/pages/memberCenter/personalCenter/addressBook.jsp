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
					<div class="fr page-list-a clearfix lh30 mt20 f12">
						<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
						<a href="">首</a>
						<a href=""><i class="fa fa-angle-left"></i></a>
						<a>1</a>
						<a href=""><i class="fa fa-angle-right"></i></a>
						<a href="">末</a>
						<input type="text" class="bd-input fl ml10 mr10" style="width:40px;">
						<a href="">Go</a>
					</div>
				</div>
		</youi:body>
	<!--***bottom start****************************************-->

	<script type="text/javascript">
	
	
		  $(function(){
			$.ajax({
			  url:baseUrl+'memberInformationManager/getPhoneNumberlist.json',		
				success:function(result){					
					console.log(result.records);
					if(result&&result.records){					
						_parseRecords(result.records);						
					}
				}
			});
		});  
		
		//拼接卡号列表
		function _parseRecords(record){		
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