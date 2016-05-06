<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>评论信息</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
		<script type="text/javascript">
			$(document).ready(function() {
				var height = Math.max((document.documentElement.clientHeight - 135),($(".main-wrapper").height()));
				document.getElementById('main-wrapper-right').style.height = height + 'px';
				
				/* $("#moreul").slideUp("slow"); */
			  	$(".sidebar-menu-mainul > li:eq(3)").addClass("active");
			  	
			  	$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#companyId").val(result.record.companyId);
							//根据企业id获取产业链信息
							 getletter(result.record.companyId);
						}
					}
				});
			  	
			});
			function getletter(id){
				var pageSize=2;
				var pageCount=1;	
				var commentEnterprise = id;
				//根据企业评论
		    	$.youi.ajaxUtils.ajax({
		    		url : baseUrl+"lettermanagerCommentManager/getPagerLettermanagerComments.json",
		    		data : ['commentEnterprise='+commentEnterprise].join('&'),
		    		success : function(results) {
		    			
		    			if (results && results.records) {
		    				if(results.records.length>0){
								pageCount=Math.ceil(results.totalCount/pageSize);
								 refreshData(1,pageSize);
									$(".tcdPageCode").createPage({
									    pageCount:pageCount,
									    current:1,
									    backFn:function(p){
									       this.pageCount=pageCount;
									        refreshData(p,pageSize);
									    }
									});
									$(".tcdPageCode").show();
							}else{
								$(".tcdPageCode").hide();
								$('.commentDiv').empty();
								$('.commentDiv').append("<p><h4 style='text-align: center;'>暂无评论消息</h4></p>");
							}
		    			}
		    		}
		    	});
				
		    	function refreshData(pageIndex,pageSize){
					var params = {'pager:pageIndex':pageIndex,'pager:pageSize':pageSize,'commentEnterprise':commentEnterprise};
					$.youi.ajaxUtils.ajax({
						url:baseUrl+"lettermanagerCommentManager/getPagerLettermanagerComments.json",
						data:params,
						success:function(results){
							if(results&&results.records){
								if(results.records.length>0){
									commRecords(results.records);
								}
							}
						}
					});
				}
			}
			
			function commRecords(records){
				var comment = "";
				$("#commentDiv").empty();
				for(var i=0; i<records.length; i++){
					var img ="";
					if(records[i].member.memberHeadPortrait!=null&&records[i].member.memberHeadPortrait!=''){
						img = ""+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+records[i].member.memberHeadPortrait+"&method=show";
					}else{
						img = ""+cenUrl+"styles/images/qiye/default.jpg";
					}
					comment+='<div class="fl" style="width: 80%">'+
						'<div class="pinglun_ren">'+
							'<table>'+
								'<tr>'+
									'<td>'+
										'<img src='+img+' width="40" height="40">'+
									'</td>'+
									'<td>'+
										'<span>'+records[i].member.memberName+'：</span>'+
									'</td>'+
								'</tr>'+
							'</table>'+
						'</div>'+
						'<div class="pinglun_main">'+records[i].commentContent+'</div>'+
						'<div class="pinglun_time">'+records[i].commentTime+'</div>'+
					'</div>'+
					'<a class="a-c-o fr reply_anniu" href="javascript:;">回复</a>';
				}
				$("#commentDiv").append(comment);
			}
		</script>
	</head>
	<body class="page-header-fixed" style="background-image: none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
			<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
				<div class="main-wrapper-right mb40" id="main-wrapper-right">
					<input id="companyId" name="companyId" type="text" style="display:none;" />
					<div class="main-title">
						<span>评论消息</span>
					</div>
					<div class="all_pinglun">
						<div class="qiye_pinglun">
							<div id="commentDiv" class="comment clearfix pr">
								
							</div>
						<!-- 	<div class="reply mt30 clearfix">
								<div class="pinglun_ren">
									<table>
										<tr>
											<td><img src="../styles/images/qiye/sl-i2.png" width="30"
												height="30"></td>
											<td><span>斯大林：</span></td>
										</tr>
									</table>
								</div>
								<div class="pinglun_main">在这次活动的过程中真的可以学到不少东西，希望官方能够举办更多类似的活动，我一定会积极的参加</div>
								<div class="reply_kuang">
									<span class="color_orange fl">回复@斯大林：</span>
									<textarea placeholder="一起做大做强！...发送一起做大做强！..." class="fl"></textarea>
								</div>
								<div class="tr mt10">
									<a class="reply_btn a-c-o a-c-fill" href="javascript:;">发送</a> <a
										class="reply_btn" href="javascript:;">取消</a>
								</div>
								<span class="cc">2016年1月18日 10：02</span>
							</div>
						
						</div> -->
						<div class="tcdPageCode fr">
					
						</div>
                        
					</div>
				</div>
			</div>
		</div>
	</body>
</html>