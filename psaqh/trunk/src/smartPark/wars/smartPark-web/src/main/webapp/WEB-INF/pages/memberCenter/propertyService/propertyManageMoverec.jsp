<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="搬家放行">
	<youi:body decorator="memcenter">  
		<div class="w1000">
			<h3 class="per-h3">搬家放行列表
				<a href="javascript:;" class="fr c-333 f14" id="a1">
					<i class="fa fa-plus-square fl mr10"></i>我要搬家
				</a>
			</h3>
		<div class="clearfix mt20 mlist"></div>
		<div class="tcdPageCode fr"></div>		
	</div>	
	<!--***弹窗 start****************************************-->

	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit c" style="height:36px;" type="submit">
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
 	var pageSize=4;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerMoverecManager/getPagerMoverec.json';
	$(function () {	
		//分页页码显示
		 $.ajax({
			url:serviceURL, 
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数							
				refreshData(1,pageSize);
				$(".tcdPageCode").empty();
				if(pageCount>0){
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
		var html="";	
		if(record.length>0){
		for(var i=0;i<record.length;i++){
			var id = record[i].moverecId ;			
			var status="";
			var button=""; 
			var moverecStatus="";
			var moverecTime="";
			if(record[i].moverecStatus=="00"){
				moverecStatus="待审批";
				button="<a href='javascript:;' class='ib-btn ac-show tc' onclick='javascript:cancel(this)' style='width:120px;padding:0px;'>取消</a>";
			}else if(record[i].moverecStatus=="01"){
				moverecStatus="已审批";
			}else if(record[i].moverecStatus=="02"){
				moverecStatus="已放行";
			}else if(record[i].moverecStatus=="03"){
				moverecStatus="已取消";
			}
			 if(record[i].moverecTime){
				 moverecTime=record[i].moverecTime;
			}else if(record[i].moverecTime){
				moverecTime="";
			}			 
			 html+="<div class='gz-fx-box clearfix' id='"+id +"'  >"+
						    "<div class='gzb-thead'>"+
						        "<span class='c-o'>"+record[i].moverecCode+"</span>"+
							    "<a href='javascript:;' class='fr f12'><i class='fa fa-file-text-o mr10 f20' style='font-size:20px;margin-top:5px;'></i>查看订单详情</a>"+					
						    "</div>"+ 						   						  
							"<div class='fx-one p20'>"+
					      	  "<table class='w100 lh30'>"+
							    "<tr>"+
								  "<td>"+
								 	"<p class='f14 c-333'>"+record[i].moverecComp+"</p>"+
								    "<p>"+moverecTime+"</p>"+
								  "</td>"+
								  "<td><p>"+moverecStatus+"</p></td>"+
							     "</tr>"+							
					           "</table>"+
					           "<div>"+button+"</div>"+ 							
						    "</div>"+
						    "<div class='fx-two p20 lh30 undis'>"+							
							    "<p>放行物品描述</p>"+							
							    "<p>"+record[i].moverecRemark+"</p>"+							 							
						    "</div>"+
					"</div>";
			  			
		}
		$(".mlist").html(html);
	}else{
		var html1 = '<table class="gt-table mt20">'
		    html1 += '<tr>'
			html1 += '	<td colspan="6">暂无记录</td>'
			html1 += '</tr>'
			html1 += '</table>'
				$(".mlist").html(html1);	
		}
	};
	//取消弹窗
	function cancel(obj){
		var me=obj.parentNode.parentNode.parentNode;//找到父节点	
		//alert(me.id);
		var moverec=me.childNodes[0].childNodes[0].innerText; 
		$(".moverec").html(moverec);
		$(".moverec")[0].setAttribute("id",me.id);//给弹窗设置id
		$(".bg-tanc.m1").show();
	};
	//点击确认取消搬家预约
	$(function(){
		$(".hhf-submit").click(function(){			
				var id=$(".moverec")[0].getAttribute("id");				
			 	$.ajax({
					url:baseUrl+'propertyservicemanagerMoverecManager/cancelStatus.json',
					data:'moverecId='+id,
					success:function(result){
						if(result&&result.record){
							//$(".bg-tanc.m1").close();
							close("取消成功!");													
						}
					}
				});
			});
		});
	//操作成功弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();	
	        setTimeout(function(){$(".bg-tanc.m1").hide(); },100);
			setTimeout(function(){$(".toast").hide(); },1000);
			refreshData(currentIndex,pageSize);
  }
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/right.js"></script>
	<script type="text/javascript">
		$(function () {
			$(".ac-show").click(function(){
				$(".bg-tanc.m1").show();
			})
			$(".ac-see").click(function(){
				$(".bg-tanc.m2").show();
			});
			$(document).on("mouseover mouseout",".gzb-thead a",function(){
				$(this).parents(".gz-fx-box").find(".fx-two").slideToggle("fast");
				$(this).parents(".gz-fx-box").find(".fx-one").slideToggle("fast");
			})
		})		
	</script>
	<script type="text/javascript">
	    //点击跳转到搬家申请页面
		$("#a1").click(function(){			
			location.href = proUrl + "yqfw/yq8.html" ;
		})	
     </script>
     
</youi:html>
