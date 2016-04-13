<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="订单中心">
	<youi:body decorator="memcenter">
				<div class="w1000">
					<h3 class="per-h3">我的订单</h3>
					<div class="clearfix mt20 mb20">
						<ul class="order-nav">
							<li class="active"><span class="pend">待处理订单</span></li>
							<li><span class="hospital">历史订单</span></li>
						</ul>
					</div>
					
					<div class="mt20 gr-txl clearfix lh30">
							<div class="tct-select fl mr20" style="width:200px">
								<div class="ic-select" style="background: url(<%=request.getContextPath()%>/styles/images/yqfw/down.png) no-repeat scroll right center;">
									<p class="c-b1" id="userorderProject">请选择订单项目</p>
									<%--   <img src="<%=request.getContextPath()%>/styles/images/yqfw/down.png" />  --%>
								</div>
								<ul style="display: none;" class="select-nav" >
									<!-- <li>园区地址1</li>
									<li>园区地址2</li>
									<li>园区地址3</li> -->
								</ul>
							</div>
							<div class="inp-box ml20" style="width:300px;"><input placeholder="请输入订单号"  id="userorderCode" type="text"style="width:260px;"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fl ml20" type="button">
						</div>
					
					<div class="clearfix mt40">
						<table class="gt-table mt20">
								<colgroup>
									<col width="180">
									<col width="180">
									<col width="170">
									<col width="180">
									<col>
								</colgroup>
								<tbody><tr>
									<th>订单号</th>
									<th>订单项目</th>
									<th>订单金额</th>
									<th>下单时间</th>
									
									<th>操作</th>
								</tr>
														
							</tbody></table>                      
						<div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
							<a href="">首</a>
							<a href=""><i class="fa fa-angle-left"></i></a>
							<a>1</a>
							<a href=""><i class="fa fa-angle-right"></i></a>
							<a href="">末</a>
							<input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
							<a href="">Go</a>
						</div>
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
	<script type="text/javascript">	
	
	function viewOrder(userorderCode,genreCode){
		if(genreCode == "0301"){
			window.location.href=cenUrl+"member/memberCenter/personalCenter/meetingRoomOrderDetails.html?userorderCode="+userorderCode;
		}else if(genreCode == "0302"){
			window.location.href=cenUrl+"member/memberCenter/personalCenter/carOrderDetails.html?userorderCode="+userorderCode;
		}else if(genreCode == "0303"){
			window.location.href=cenUrl+"member/memberCenter/personalCenter/adsenseOrderDetails.html?userorderCode="+userorderCode;
		}
	};
	//页面初始化显示未完成订单
	   $(function(){
		   var userorderStatus="01";
			$.ajax({				
				url:baseUrl+'/ordermanagerUserorderManager/getOrderlistLikeUserorderProject.json',
				data:'userorderStatus='+userorderStatus,
				success:function(result){	
					if(result&&result.records){					
						_parseRecords(result.records);						
					}
				}
			});
		});
		////页面初始化显示未完成订单      拼接列表
		function _parseRecords(record){		
			console.log(record);
			for(var i=0;i<record.length;i++){				
				var status = "";
				var button = "";
				if(record[i].userorderStatus=='01'){
					//status = "待付款";	
					button = "<a href=''>付款</a><span class='f12 ml5 mr5'>|</span><a href='#'   onclick='cancel(\""+record[i].userorderId+"\")'> 取消</a>";
				}else if(record[i].userorderStatus=='02'){
					//status = "已付款";
					button = "已付款<span class='f12 ml5 mr5'>|</span><a href=''>评价</a>";
				}else if(record[i].userorderStatus=='03'){
					//status = "已完成";					
				}else if(record[i].userorderStatus=='08'){
					status = "已取消";					
				}
				var method = "viewOrder(\""+record[i].userorderCode+"\",\""+record[i].genreId.genreCode+"\");";
				var html= "<tr class='aaa'>"+
					      "<td><a class='custor' onclick='"+method+"'>"+record[i].userorderCode+"</a></td>"+
                          "<td>"+record[i].userorderProject+"</td>"+
                          "<td>"+record[i].userorderAmount+"</td>"+
                          "<td>"+record[i].userorderTime+"</td>"+                                                                        
                          "<td>"+status  + button+                                                                    
						  "</td>"+
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};
		//显示未完成订单    
		$('.pend').click(function(){
			$(".aaa").empty();
			   var userorderStatus="01";
				$.ajax({				
					url:baseUrl+'/ordermanagerUserorderManager/getOrderlistLikeUserorderProject.json',
					data:'userorderStatus='+userorderStatus,
					success:function(result){	
						if(result&&result.records){					
							_parseRecords(result.records);						
						}
					}
				});
			});
			
		//显示历史订单      
		$('.hospital').click(function(){
			$(".aaa").empty();
			   var userorderStatus="01";
				$.ajax({				
					url:baseUrl+'/ordermanagerUserorderManager/getHospitalOrderlist.json',
					data:'userorderStatus='+userorderStatus,
					success:function(result){	
						if(result&&result.records){					
							_parseRecords(result.records);						
						}
					}
				});
			});
			
		//根据订单项目模糊查询
		$('.hhf-submit').click(function(){	
			$(".aaa").empty();
			 var userorderProject=$("#userorderProject").text();
			 if(userorderProject=="请选择订单项目"){
				 userorderProject="";		 				 
			 }
			 var userorderCode=$("#userorderCode").val();		
			 params=['userorderProject='+userorderProject+'','userorderCode='+userorderCode+''];
		      $.ajax({
		    	 url:baseUrl+'/ordermanagerUserorderManager/getOrderlistLikeUserorderProject.json',
		    	 data:params.join('&'),
		    	 success:function(result){					
						console.log(result.records);           
						if(result&&result.records){								
							_parseRecords(result.records);					
						}
					}
			}); 
		}); 
		//下拉选项目名称
 		$(function(){
			$.ajax({				
				url:baseUrl+'/purchasingmanagerGenreManager/getGenreProject.json',
				success:function(result){	
					if(result&&result.records){					
						_selectRecords(result.records);						
					}
				}
			});
		});
		
		function _selectRecords(record){		
			console.log(record);
			for(var i=0;i<record.length;i++){				
				var html= "<li>"+record[i].genreName+"</li>";                                                                                  
				 $(".select-nav").append(html);	
			}
			$(".ic-select").click(function(e){
				$(".select-nav").hide();
			    $(this).next(".select-nav").show();
			    e.stopPropagation();//阻止冒泡
			});
			$(".select-nav li").click(function(){
				$(this).parents(".tct-select").find(".ic-select p").text($(this).text()) ;
				$(this).parent().hide();
			});
		}; 
		//取消订单，前端调用
		 function cancel(id){		
					
			$.ajax({				
				url:baseUrl+'/ordermanagerUserorderManager/cancelStatus.json',
				data:'id='+id,
				success:function(result){
					if(result&&result.record){					
						close("已取消");
						//location.reload();
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
		$(function () {
			$(".order-nav li").click(function(){
				$(this).addClass("active").siblings().removeClass("active");			
			})		
		})
	</script>
</youi:html>