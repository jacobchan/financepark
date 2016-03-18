<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>政策申请</title>
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
					<h3 class="per-h3">政策申请</h3>
					<div class="clearfix mt40">
						<table class="gt-table mt20">
							<colgroup>
								<col width="120"></col>
								<col width="120"></col>
								<col></col>
								<col width="120"></col>
								<col width="120"></col>
								<col width="120"></col>
							</colgroup>
							<tbody><tr>
								<th>申请编号</th>
								<th>政策类型</th>
								<th>申请人</th>
								<th>申请时间</th>
								
								<th>流程状态</th>
								<th>申请状态</th>
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
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->

	<script type="text/javascript">

	 function apply(id){			
		var policyApplyId=id;	
	     $.ajax({
			url:baseUrl+'/esb/web/policyApplyManager/updatePolicyApplyStatus.json',
			data:'policyApplyId='+policyApplyId,
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
				
				url:baseUrl+'/esb/web/policyApplyManager/getPolicyApplyListByLoginUser.json',
				success:function(result){	
					if(result&&result.records){					
						_parseRecords(result.records);						
					}
				}
			});
		});
		//拼接卡号列表
		function _parseRecords(record){		

			console.log(record);
			for(var i=0;i<record.length;i++){				
				var status = "";								
				if(record[i].policyApplyStatus=='1'){
					status = "申请中";					
				}else if(record[i].policyApplyStatus=='2'){
					status = "申请成功";
				}else if(record[i].policyApplyStatus=='3'){
					status = "申请失败";
				} else if(record[i].policyApplyStatus=='0'){
					status = "取消";
				} 
				var html= "<tr>"+
					      "<td width='111'>"+record[i].policyId+"</td>"+
                          "<td width='111'>"+record[i].nmIssuenews.policyCaption+"</td>"+
                          "<td width='111'>"+record[i].policyApplyContactPeople+"</td>"+
                          "<td width='111'>"+record[i].createTime+"</td>"+
                          "<td width='88'>"+record[i].nmIssueflow.issueFlowCStatus+"</td>"+
                          "<td width='88'>"+status+"</td>"+                          
                          "<td > <input type='button' value='取消'   onclick='apply(\""+record[i].policyApplyId+"\")' />"+                                   
                          " </tr>";
				 $(".gt-table").append(html);	
			}
		};	
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>