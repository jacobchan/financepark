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
					html+='<li>'+
							'<table>'+
		                    	'<tr>'+
		                        	'<td rowspan="4" width="110"><img src="'+memberHeadPortrait+'"></td>'+
		                    	'</tr>'+
		                    	'<tr>'+
		                       		'<td align="left" valign="middle" class="pl20 hide_dian"><span class="f16 color_41 user_name">'+record[i].memberName+'</span><span class="f14 color_6 tel">联系方式：'+record[i].memberPhoneNumber+'</span></td>'+
		                    	'</tr>'+
			                    '<tr>'+
			                        '<td align="left" valign="middle" class="pl20"><span class="f14 color_6 hide_dian">'+record[i].memberDescribe2+'</span></td>'+
			                    '</tr>'+
			                    '<!--<tr>'+
			                        '<td align="left" valign="middle" class="pl20"><span class="f12 color_41"><a href="javascript:void(0);">编辑</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">设置权限</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">删除</a></span></td>'+
			                    '</tr>-->'+
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
	</body>
</html>