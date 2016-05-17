<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业通讯录</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
		<script type="text/javascript">
			var pageSize=4;
			var pageCount=1;
			var serviceURL = baseUrl+"/memberInformationManager/getPagerEnterMemberInformations.json";
			$(document).ready(function() {
				/* $.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#companyId").val(result.record.companyId);
						}
					}
				}); */
		        $(".tc-close").click(function(){
		            $(".bg-tanc").hide();
		        });
				$("#btnEdit").click(function(){
					var memberIds=$("#memberIds").val();
			  		var memberNames=$("#memberNames").val();
			  		var memberPhone=$("#memberPhone").val();
			  		var params = ['memberId='+memberIds+'','memberName='+memberNames+'','memberPhoneNumber='+memberPhone+''];
			  		$.youi.ajaxUtils.ajax({
						url:baseUrl+'/memberInformationManager/updateMemberBook.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								$('#toast_text').html('保存成功！');
								$(".toast").show();
					            setTimeout('$(".toast").hide();',2000);//1秒=1000
					            location.reload();
							}
						}
					});
		        });
			  	$.ajax({
					url:serviceURL,
					success:function(result){
						$("#totalCount").html(result.totalCount);
						pageCount=Math.ceil(result.totalCount/pageSize);
						refreshData(1,pageSize,null);
						$(".tcdPageCode").createPage({
							pageCount:pageCount,
							current:1,
							backFn:function(p){
							   	this.pageCount=pageCount;
							    refreshData(p,pageSize,null);
							}
						});
					}
				});
			  	
			  	/* $("#moreul").slideUp("slow"); */
			  	$(".sidebar-menu-mainul > li:eq(1)").addClass("active");
			});
			function refreshData(pageIndex,pageSize,memberName){
				var params = [];
				if(memberName == null){
					params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
				}else{
					params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'memberName='+memberName];
				}
				
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
			
			function _parseRecords(record){
				var html='';
				for(var i=0;i<record.length;i++){
					var memberHeadPortrait = "../styles/images/qiye/user-photo.png";
					if(record[i].memberHeadPortrait!=null && record[i].memberHeadPortrait!=""){
						memberHeadPortrait = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].memberHeadPortrait+"&method=show";
					}
					var describe = record[i].memberDescribe2==null?"":record[i].memberDescribe2;
					html+='<li>'+
							'<table>'+
		                    	'<tr>'+
		                        	'<td rowspan="4" width="110"><img src="'+memberHeadPortrait+'" style="width: 107px;height: 107px;"></td>'+
		                    	'</tr>'+
		                    	'<tr>'+
		                       		'<td align="left" valign="middle" class="pl20 hide_dian"><span class="f16 color_41 user_name">'+record[i].memberName+'</span><span class="f14 color_6 tel">联系方式：'+record[i].memberPhoneNumber+'</span></td>'+
		                    	'</tr>'+
			                    '<tr>'+
			                        '<td align="left" valign="middle" class="pl20"><span class="f14 color_6 hide_dian">'+describe+'</span></td>'+
			                    '</tr>'+
			                    '<tr>'+
			                        '<td align="left" valign="middle" class="pl20"><span class="f12 color_41"><a href="javascript:edit(\''+record[i].memberId+'\',\''+record[i].memberName+'\',\''+record[i].memberPhoneNumber+'\');" class="edit-show">编辑</a>&nbsp;丨&nbsp;<a href="javascript:show(\''+record[i].memberId+'\');" class="set-show">设置权限</a>&nbsp;丨&nbsp;<a href="javascript:removeBook(\''+record[i].memberId+'\');">删除</a></span></td>'+
			                    '</tr>'+
		                	'</table>'+
		            	'</li>';
				}
				$('#bookDiv').empty();
				$('#bookDiv').append(html);
			}
			function searchByName(){
				var memberName = $("#memberName").val();
				if(memberName == ""){
					memberName = null;
				}
				var params = [];
				if(memberName != null){
					params = ['memberName='+memberName];
				}
				$.ajax({
					url:serviceURL,
					data:params.join('&'),
					success:function(result){
						$("#totalCount").html(result.totalCount);
						pageCount=Math.ceil(result.totalCount/pageSize);
						refreshData(1,pageSize,memberName);
						$(".tcdPageCode").createPage({
							pageCount:pageCount,
							current:1,
							backFn:function(p){
							   	this.pageCount=pageCount;
							    refreshData(p,pageSize,memberName);
							}
						});
					}
				});
			}
			function searchAll(){
				$.ajax({
					url:serviceURL,
					success:function(result){
						$("#totalCount").html(result.totalCount);
						pageCount=Math.ceil(result.totalCount/pageSize);
						refreshData(1,pageSize,null);
						$(".tcdPageCode").createPage({
							pageCount:pageCount,
							current:1,
							backFn:function(p){
							   	this.pageCount=pageCount;
							    refreshData(p,pageSize,null);
							}
						});
					}
				});
			}
			function edit(id,name,phone){
				$(".bg-tanc.m1").show();
				$("#memberIds").val(id);
				$("#memberNames").val(name);
				$("#memberPhone").val(phone);
			}
			
			function show(){
				$(".bg-tanc.m2").show();
			}
			
			function removeBook(id){
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'/memberInformationManager/removeMemberInformation.json',
					data:'memberId='+id,
					success:function(result){
						alert("删除成功");
						location.reload();
					}
				});
			}
		</script>
	</head>
	<body class="page-header-fixed" style="background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
		    <div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right" id="main-wrapper-right">
		    		<input id="companyId" name="companyId" type="text" style="display:none;" />
		        	<div class="main-title"><span>企业通讯录管理</span></div>
		            <div class="phone_book">
		            	<div class="total_p color_orange">通讯录共有&nbsp;<span id="totalCount"></span>&nbsp;人</div>
		                <div class="search_name"><input id="memberName" name="memberName" type="text" placeholder="姓名搜索"></div>
		                <div class="search_ipt"><a href="javascript:searchByName();">搜索</a></div>
		                <div class="show_all"><a href="javascript:searchAll();">显示全部</a></div>
		                <div class="upload_out"><a href="javascript:void(0);">导出到Excel</a></div>
		            </div>
		            <div class="phone_no">
		            	<ul id="bookDiv"></ul>
		            </div>
		            <div class="tcdPageCode fr"></div>
		        </div>   
		    </div>
		</div>
		<div class="bg-tanc m1">
	        <div class="tanc-con c3" style="top:50%;margin-top:-180px;width:440px;padding:40px 30px;color:#333;">
	            <a href="javascript:;" class="tc-close"></a>
	            <h3 class="mb10 f16" style="font-size:16px;"><b>编辑信息</b></h3>
	            <table class="line-table" style="font-size:14px;width:360px">
	                <colgroup>
	                    <col width="100"></col>
	                    <col></col>
	                </colgroup>
	                <input type="text" id="memberIds" name="memberIds" style="display:none;">
	                <tr>
	                    <td><b>姓名</b></td>
	                    <td><input type="text" id="memberNames" name="memberNames" style="width:200px;"></td>
	                </tr>
	                <tr>
	                    <td><b>联系电话</b></td>
	                    <td><input type="text" id="memberPhone" name="memberPhone" style="width:200px;"></td>
	                </tr>
	                <tr>
	                    <td colspan="2" align="center"><input value="保存" id="btnEdit" class="hhf-submit tc" style="height:40px;width:100px;padding:0px;" type="submit"></td>
	                </tr>
	            </table>
	        </div>
	    </div>
	    <div class="bg-tanc m2"> 
	        <div class="tanc-con c3" style="top:50%;margin-top:-130px;width:550px;padding:40px 30px;color:#333;">
	            <a href="javascript:;" class="tc-close"></a>
	            <h3 class="mb10 f16" style="font-size:16px;"><b>权限设置</b><span class="ml30 f12 color_orange">员工：雷布斯</span></h3>
	             <table class="line-table" style="font-size:14px;width:490px">
	                <colgroup>
	                    <col width="100"></col>
	                    <col></col>
	                </colgroup>
	                <tr>
	                    <td><b>可分配角色</b></td>
	                    <td>
	                        <label class="mr30 lh30"><input type="checkbox" name="address" class="mr5" checked="checked">财务支付</label>
	                        <label class="mr30 lh30"><input type="checkbox" name="address" class="mr5">评论消息管理</label>
	                        <label class="mr30 lh30"><input type="checkbox" name="address" class="mr5">订单管理</label>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2" align="center"><input value="保存" class="hhf-submit tc mt20" style="height:40px;width:100px;padding:0px;" type="submit"></td>
	                </tr>
	            </table>
	        </div>
	    </div>
	</body>
</html>