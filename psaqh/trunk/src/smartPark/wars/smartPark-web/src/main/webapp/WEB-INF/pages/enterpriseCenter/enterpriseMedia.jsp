<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業融资</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.sidebar-menu-mainul2 li a').click(function(){
			        $('.sidebar-menu-mainul2 li').removeClass('active');
			        $(this).parent().addClass('active');
			   	});
				$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#mediaRe").html(result.record.companyId);
							//根据企业id获取融资信息
					    	$.ajax({
					    		url : baseUrl+"/informationMediaManager/findInformationMedia.json",
					    		data : ['mediaRe='+result.record.companyId].join('&'),
					    		success : function(results) {
					    			if (results && results.records) {
					    				var records = results.records;
					    				$("#mediaDiv").empty();
					    				for(var i=0; i<records.length; i++){
					    					var mediaDiv = '<li>'+
					                            '<div class="mt_list">'+
					                                '<div class="list_pic"><img src="/filestore/'+records[i].mediaUrl+'"></div>'+
					                                '<div class="list_tex">'+
					                                    '<table>'+
					                                        '<tr>'+
					                                            '<td colspan="2" height="40" valign="middle" align="left"><a class="tit" href="'+records[i].mediaTilurl+'" target="_blank">'+records[i].mediaTitle+'</a></td>'+
					                                        '</tr>'+
					                                        '<tr>'+
					                                            '<td height="40" valign="middle" align="left"><a href="javascript:void(0);"><span>编辑</span></a>丨<a href="javascript:void(0);">删除</a></td>'+
					                                            '<td height="40" valign="middle" align="right"><span class="color_hui">'+records[i].createTime+'</span></td>'+
					                                        '</tr>'+
					                                    '</table>'+
					                                '</div>'+
					                            '</div>'+
					                        '</li>';
					    					$("#mediaDiv").html(mediaDiv);
					    				}
					    			}
					    		}
					    	});
						}
					}
				});
				
				$(".save_btn").click(function(){
			  		var mediaRe=$("#mediaRe").html();
			  		var mediaTitle=$("#mediaTitle").val();
			  		var mediaTilurl=$("#mediaTilurl").val();
					var params = ['mediaRe='+mediaRe+'','mediaTitle='+mediaTitle+'','mediaTilurl='+mediaTilurl+''];
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/informationMediaManager/saveInformationMedia.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								alert("修改成功");
								location.reload();
							}
						}
					});
				});
			});
		</script>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">    
			<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right">
		        	<div class="main-title"><span>媒体报道</span></div>
		            <div class="qiye_fm">
		            	<span class="" id="mediaRe" style="display:none;"></span>
		            	<div class="qiye_text"><span>封面图片</span></div>
		                <div class="upload_main">
		                    <div class="fengmian_pic"><img src="../styles/images/qiye/add_fmpic.png"></div>
		                    <div class="upload_input_fm"><input type="file"></div>
		            	</div>
		            </div>
		            <div class="xiangxi_baodao">
		                <div class="qiye_fullname ">
		                    <div class="qiye_nametex">标题</div>
		                    <div class="name_input"><input id="mediaTitle" name="mediaTitle" type="text"></div>
		                </div>
		                <div class="qiye_link">
		                    <div class="qiye_linktex">链接地址</div>
		                    <div class="link_input"><input id="mediaTilurl" name="mediaTilurl" type="text"></div>
		                </div>
		                <div class="photo_btn">
                            <div class="save_btn"><a>保存</a></div>
                        </div>
		                <div class="main-title"><span>媒体报道列表</span></div>
		                <div class="baodao_list">
		                	<ul id="mediaDiv">
		                        
		                    </ul>
		                </div>
		            </div>
		        </div>   
		    </div>
		</div>
	</body>
</html>