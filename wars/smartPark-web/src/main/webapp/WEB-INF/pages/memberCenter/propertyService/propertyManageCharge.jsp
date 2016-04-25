<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="缴费查询">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">缴费查询列表</h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="userorderCode"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
						</div>
						<table class="gt-table mt20">
							<colgroup>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col width="120"></col>
								<col width="150"></col>
								<col></col>
							</colgroup>
							<tbody><tr>
								<th>订单号</th>
								<th>缴费项目</th>
								<th>总金额</th>
								<th>状态</th>
								<th>截止日期</th>
								<th>操作</th>
							</tr>
							</tbody><tbody class="chargelist">
							   <tr>
				     	          <td colspan="6">暂无记录</td>
				                </tr> 
						     </tbody>
						</table>
						<div class="tcdPageCode fr"></div>
					</div>
				</div>	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>领取发票</b></h3>
			<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
				<colgroup>
					<col width="110">
					<col>
				</colgroup>
				<tbody><tr>
					<td><b>单号</b></td>
					<td>123456789</td>
				</tr>
				<tr class="label">
					<td><b>发票抬头</b></td>
					<td>
						<label><input name="s-r" class="mr5"type="radio">个人</label>
						<label class="ml30"><input name="s-r" checked="checked" class="mr5" type="radio">企业</label>
					</td>
				</tr>
				<tr class="show2" >
					<td><b>企业名称</b></td>
					<td><input type="text" style="width:400px"></td>
				</tr>
				<tr>
					<td></td>
					<td class="add-sh">
						<label><input name="address" class="mr5" checked="checked" type="radio">寄送到报修地址</label>
						<label class="ml30"><input name="address" class="mr5" type="radio">自定义</label>
						<textarea class="mt20 so1 undis"></textarea>
						<div class="tct-select mt20 so2" style="width:400px;">
							<div class="ic-select">
								<p>文化创意园A302(张三 19855552222)</p>
							</div>
							<ul class="select-nav">
								<li>文化创意园A302(张三 19855552222)</li>
								<li>文化创意园A302(张三 19855552222)2</li>
								<li>文化创意园A302(张三 19855552222)3</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">领取发票</a></td>
				</tr>
			</tbody></table>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=10;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'propertyservicemanagerChargeManager/getPagerCharge.json';
	$(function () {		
		//分页页码显示
		 $.ajax({
			url:baseUrl+'propertyservicemanagerChargeManager/getTotalCount.json', 
			success:function(results){	
							pageCount=Math.ceil(results.totalCount/pageSize);//页数
							
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
		
	$(function () {
		$(".lq-fp").click(function(){
			$(".bg-tanc").show();
		});
		$(".wybx-tanc .add-sh label").click(function(){
			if($(this).children('input[type="radio"]').prop("checked")){
				if($(this).index()==0){
					$(".add-sh .so2").removeClass("undis");
					$(".add-sh .so1").addClass("undis");
				}else{
					$(".add-sh .so2").addClass("undis");
					$(".add-sh .so1").removeClass("undis");
				}
			}
		});
	});
	
	//拼接列表
	function _parseRecords(record){
		 $("chargelist").empty();
	  if(record.length>0){
		for(var i=0;i<record.length;i++){
			var chargeStatus='';
			var userorderStatus=record[i].userorder.userorderStatus;
			var buttonHtml="<td><a href='javascript:;' class='ac-see' onclick='javascript:pay(this)'>付款</a></td>";
			if(userorderStatus=='01'){
				chargeStatus="未缴费";
			}else{
				chargeStatus="已缴费";
				buttonHtml="<td><a href='javascript:;' class='ac-see lq-fp'>领取发票</a></td>";
			}			
			var html="<tr id='"+record[i].chargeId+"' class='aaa'>"+
				 	 	"<td><a href=''>"+record[i].userorder.userorderCode+"</a></td>"+
					 	"<td>"+record[i].userorder.userorderProject+"</td>"+
					 	"<td>"+record[i].chargeAmount+"元</td>"+
					 	"<td>"+chargeStatus+"</td>"+
					 	"<td>"+record[i].chargeEndate+"</td>"+
					 	buttonHtml+
					 "</tr>";
			 $("chargelist").append(html);
		}
	  }else{
			var	html1 = '<tr>'
				html1 += '	<td colspan="6">暂无记录</td>'
				html1 += '</tr>'
			$(".chargelist").html(html1);	
			}	
	};
	function pay(obj){
		var me=obj.parentNode.parentNode;
		alert(me.id+"          付款功能后续添加！");
	}
	//根据订单号查询 模糊查询
	$('.hhf-submit').click(function(){	
		var userorderCode=$("#userorderCode").val();
		//alert(ocCode);
		var startTime=$("#startTime").val(); 
		var endTime=$("#endTime").val(); 			
		var params = ['LikeuserorderCode='+userorderCode,'startTime='+startTime,'endTime='+endTime];
		$.ajax({
			url:baseUrl+'propertyservicemanagerChargeManager/getTotalCount.json',
			data:params.join('&'),
			success:function(results){	
				pageCount=Math.ceil(results.totalCount/pageSize);//页数				
				//alert(pageCount);
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
        }); 			
    });	
		//根据订单号查询 分页列表
		function refreshData_query(pageIndex,pageSize){
			var userorderCode=$("#userorderCode").val();
			 var startTime=$("#startTime").val(); 
			 var endTime=$("#endTime").val(); 
			var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'LikeuserorderCode='+userorderCode,'startTime='+startTime,'endTime='+endTime];
			$.ajax({
				url:baseUrl+'propertyservicemanagerBxManager/getPagerLikeBx.json',
				data:params.join('&'),
				success:function(results){
					if(results&&results.records){
						 _parseRecords(results.records);
					}
				}
			});
		}
	$(function(){
		laydate({
		    elem: '#startTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	})
	$(function(){
		laydate({
		    elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	        istime: true, //是否开启时间选择
		    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	})
	</script>
</youi:html>
