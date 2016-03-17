<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>一卡通办理</title>
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
					<h3 class="per-h3">企业通讯录</h3>
					<div class="mt20 gr-txl clearfix lh30">
						<span class="f16">深圳市前海怕啥科技有限公司</span>
						<div class="fr">
							<input type="text" class="bd-input">
							<input value="查询" class="hhf-submit" type="button" style="padding:0px 20px;height:30px;">
							<input value="全部" class="hhf-submit" type="button" style="padding:0px 20px;height:30px;">
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

			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->

	<script type="text/javascript">
	
	
		$(function(){
			$.ajax({
			  url:'/smartPark-web/esb/web/enterpriseEmployeesManager/getEnterprisemaillist.json',
			//	url:'/smartPark-web/esb/web/enterpriseEmployeesManager/getEnterpriseEmployeess.json',
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
				      "<td >"+record[i].employeesName+"</td>"+
				      "<td >"+record[i].employeesTelephone+"</td>"+
				      "<td >"+record[i].createTime+"</td>"+
				      "<td>"+record[i].createTime+"</td>"+				      				    					    
                      " </tr>"; 
			          $(".gt-table").append(html);					  								 				
			}
		};
		
	
		
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>