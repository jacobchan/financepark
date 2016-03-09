<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>物业报修</title>
	<style>
	  .ccheng{color:#FF6715}
    </style>
</head>
<body style="background-color:#f4f4f4;">

	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">物业报修</h3>
					<div class="clearfix mt40">
					<div class="mt20 gr-txl clearfix lh30">
					<div class="clearfix">
							<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">报修时间：</label>
							<input class="bd-input fl" type="text"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text">
							<div class="inp-box ml20"><input placeholder="报修单号查询" type="text"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
						</div>
					
						<table class="gt-table mt20">
                         <tr>
					     	<td width="111">订单号     </td>
                         	<td width="111">申请时间  </td>
                         	<td width="111">派工状态   </td>
                         	<td width="111">派工人员  </td>
                         	<td width="111">电话         </td>
                         	<td width="111">操作         </td>
                         </tr>
                           
                         </table>

                        
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
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->

	<script type="text/javascript">
 	function ts(id){				
		var tsStatus='取消';
		var tsId=id;	
		var params = ['tsId='+tsId+'','tsStatus='+tsStatus+''];
	     $.ajax({
			url:'/smartPark-web/esb/web/propertyservicemanagerTsManager/updateTsStatus.json',

            data:params.join('&'),
	 		success:function(result){
				if(result&&result.record){					
					alert("已取消");
					
					location.reload();
				}
			}
		});
	} 
	
	
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerTsManager/getTsListByLoginUser.json',
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
				var html= "<tr>"+
					      "<td width='111'>"+record[i].tsId+"</td>"+
                          "<td width='111'>"+record[i].applicationDate+"</td>"+
                          "<td width='111'>"+record[i].tsStatus+"</td>"+
                          "<td width='111'>"+record[i].tsName+"</td>"+
                          "<td width='111'>"+record[i].tsTelephone+"</td>"+
                          "<td > <input type='button' value='取消'   onclick='ts("+record[i].tsId+")' />"+ 
                         
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>