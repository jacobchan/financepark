<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="物业投诉详情">
	<youi:body decorator="memcenter"> 
					
	<div class="w1000">
			<h3 class="per-h3">物业投诉详情列表
				<a style="cursor: pointer;" onclick="oc_goBack()" class="c-333 fr f14"><i class="fa fa-angle-left f20 mr5 a1" style="font-size:18px;"></i>返回</a>
			</h3>					
			<div class="clearfixa a">											
			</div>														    
	</div>
				<!-- //分页页码显示 -->
        <div class="tcdPageCode fr">
							
		</div>
		

	<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要取消<span class="c-o cosCode"> [ 123456789 ] </span>吗？
				</div>
				<p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p>
				<input value="确定" class="hhf-submit" style="height:36px;" type="submit">
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
	
	
	<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/lib/properties.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	
		//格式化展示列表
		function _parseRecords(record){
			$(".clearfixa.a").empty();
			//$("#count").append(record.length);
			for(var i=0;i<record.length;i++){
				var bool = "";
				var status = "";
				var crop = "";
				if(record[i].cosBool=='0'){
					bool = "是";
				}else{
					bool = "否";
				}
				if(record[i].cosStatus=='01'){
					status = "待受理";
					crop = "<a href='' class='pb-btn tc' style='width:120px;' onclick='javascript:cancel(\""+record[i].cosId+"\")' >取消</a>";
				}else if(record[i].cosStatus=='02'){
					status = "已受理";
				}else if(record[i].cosStatus=='03'){
					status = "已取消";
				}else if(record[i].cosStatus=='04'){
					status = "已退回";
				}
				var html=
			"<div class='clearfix mt20'>"+
			"<div class='ot-head'>"+
			"<span class='c-333 f14' >投诉单号："+record[i].cosCode+"</span>"+
			"<span style='margin-left: 10px;' >"+status+"</span>"+
			"<font class='fr' >2016年2月18日14:09:04</font>"+
		    "</div>"+
			 "<div class='pl20 pr20 order-table'>"+
				"<table class='w100 lh30 f12'>"+
					"<colgroup>"+
						"<col width='50%'''></col>"+
						"<col></col>"+
					"</colgroup>"+
					"<tbody>"+
						"<tr>"+
							"<td>"+
								"<p>投诉内容："+record[i].cosContent+"</p>"+							
							"</td>"+						
						"</tr>"+
						"<tr>"+
						"<td>"+
							"<p>投诉人："+record[i].cosName+"</p>"+
							"<p>投诉电话："+record[i].cosTelephone+"</p>"+						
						"</td>"+					
					"</tr>"+						
					"</tbody>"+
				"</table>"+
			"</div>"+ 
			  "<div class='fr f12'>"+
				//"<span class='mr30'> 订单总计费用：<font class='f24 c-o'>1200元</font></span>"+
				crop+
				
			//	"<input type='submit' value='"+crop+"' class='hhf-submit' onclick='javascript:cancel(\""+record[i].cosId+"\")'  style='height:36px;' />"+
			"</div>"+  
		"</div>	";
				$(".clearfixa.a").append(html);
			}
		};
		
		
			//根据订单号查询
	$(function(){					
		var arg=getQueryStringArgs();
	    var cosCode =arg.cosCode;	    
		$.ajax({
			url:baseUrl+'propertyservicemanagerCosManager/getPagerCos.json',
			data:'cosCode='+cosCode,
			success:function(result){					    		 
							console.log(result.records);           
							if(result&&result.records){	
								//console.log(result.records);
								_parseRecords(result.records);							
							}
						}
				}); 
			}); 
	</script>
	
	<!-- 取消投诉 -->
	<script type="text/javascript">
	function cancel(cosId){
				
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'propertyservicemanagerCosManager/updateCosforpage.json',
					data:'cosId='+cosId,
					success:function(result){
						if(result&&result.record){
							close("取消成功");							
						}
					}
				});
			}
	//点击返回
	  function oc_goBack(){
		 window.location.href = cenUrl+"member/memberCenter/propertyService/propertyManageCos.html";
	}; 
	//弹窗
	 function close(content){		        
	        $(".tc.mt25.f18").empty() ;
	        $(".tc.mt25.f18").append(content) ;
	        $(".toast").show();		      		        		       				
			setTimeout(function(){$(".toast").hide(); },2000);
			setTimeout(function(){location.reload(); },2000);
      }
	</script>
	
</youi:html>
