<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>专利与知识产权</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript">
			// 中文字符判断
			function getStrLength(str) { 
				var len = str.length; 
			    var reLen = 0; 
			    for (var i = 0; i < len; i++) {        
			        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) { 
			            // 全角    
			            reLen += 2; 
			        } else { 
			            reLen++; 
			        } 
			    } 
			    return reLen;    
			}
			//删除专利
			function removeKnowledge(obj){
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'/informationKnowledgeManager/removeInformationKnowledge.json',
					data:'knowledgeId='+obj,
					success:function(result){
						alert("删除成功");
						location.reload();
					}
				});
			}
			//修改地址
			function updateKnowledge(obj0, obj1, obj2, obj3){
				$("#knowledgeId").val(obj0);
				$("#knowledgeRe").html(obj1);
		  		$("#knowledgeTitle").val(obj2);
		  		$("#knowledgeContent").val(obj3);
		  		$("#currentCount").html(getStrLength(obj3));
			}
			$(document).ready(function() {
				$("#knowledgeContent").on('keyup', function() {
				    var len = getStrLength(this.value);
				    $("#currentCount").html(len);
				});
				$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#knowledgeRe").html(result.record.companyId);
							//根据企业id获取融资信息
					    	$.ajax({
					    		url : baseUrl+"/informationKnowledgeManager/findInformationKnowledge.json",
					    		data : ['knowledgeRe='+result.record.companyId].join('&'),
					    		success : function(results) {
					    			if (results && results.records) {
					    				var records = results.records;
					    				$("#knowledgeDiv").empty();
					    				for(var i=0; i<records.length; i++){
					    					var knowledgeDiv = '<li>'+
					                            '<div class="mt_list">'+
					                                '<div class="list_pic"><img src="http://localhost:9088/filestore/'+records[i].knowledgeUrl+'"></div>'+
					                                '<div class="list_tex">'+
					                                    '<table>'+
					                                        '<tr>'+
					                                            '<td colspan="2" height="40" valign="middle" align="left"><a class="tit">'+records[i].knowledgeTitle+'</a></td>'+
					                                        '</tr>'+
					                                        '<tr>'+
					                                            '<td colspan="2" height="42" valign="top" align="left"><span class="baodao_main">'+records[i].knowledgeContent+'</span></td>'+
					                                        '</tr>'+
					                                        '<tr>'+
					                                            '<td height="40" valign="middle" align="left"><a href=\'javascript:updateKnowledge("'+records[i].knowledgeId+'", "'+records[i].knowledgeRe+'", "'+records[i].knowledgeTitle+'", "'+records[i].knowledgeContent+'");\'><span>编辑</span></a>丨<a href=\'javascript:removeKnowledge("'+records[i].knowledgeId+'");\'>删除</a></td>'+
					                                        '</tr>'+
					                                    '</table>'+
					                                '</div>'+
					                            '</div>'+
					                        '</li>';
					    					$("#knowledgeDiv").append(knowledgeDiv);
					    				}
					    			}
					    		}
					    	});
						}
					}
				});
				$(".hhf-submit").click(function(){
					var knowledgeId=$("#knowledgeId").val();
			  		var knowledgeRe=$("#knowledgeRe").html();
			  		var knowledgeTitle=$("#knowledgeTitle").val();
			  		var knowledgeContent=$("#knowledgeContent").val();
					var params = ['knowledgeId='+knowledgeId+'','knowledgeRe='+knowledgeRe+'','knowledgeTitle='+knowledgeTitle+'','knowledgeContent='+knowledgeContent+''];
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/informationKnowledgeManager/saveInformationKnowledge.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								$("#knowledgeTitle").val();
						  		$("#knowledgeContent").val();
								alert("保存成功");
								window.location.reload();
							}
						}
					});
				});
				$("#moreul").slideDown("slow");
			  	$("#moreul > li:eq(2)").addClass("active");
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
    				<input id="knowledgeId" name="knowledgeId" style="display:none;" type="text">
        			<div class="main-title"><span>专利/知识产权</span></div>
			        <div class="qiye_fm">
			        	<span class="" id="knowledgeRe" style="display:none;"></span>
			            <div class="qiye_text"><span>专利图片</span></div>
			            <div>
			                <div class="img_upload"><img src="../styles/images/qiye/img_none.png"><br><p>图片未上传</p></div>
			                    <div class="upload_main">            	
			                        <div class="fengmian_pic"><img src="../styles/images/qiye/add_fmpic.png"></div>
			                        <div class="upload_input_fm1"><input type="file"></div>
			                    </div>
			                </div>
			            </div>
			            <div class="xiangxi_baodao">
			                <div class="qiye_fullname ">
			                    <div class="qiye_nametex">专利名称</div>
			                    <div class="name_input"><input id="knowledgeTitle" name="knowledgeTitle" type="text"></div>
			                </div>
			        	<div class="qiye_jianjie ">
			                <div class="qiye_word">专利描述</div>
			               	<div class="word_input">
			                    <textarea id="knowledgeContent" name="knowledgeContent"></textarea>
			                	<div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/200</div>
			            	</div>
			            </div>
			            <div class="meiti_save_btn"><input type="submit" value="保存" class="hhf-submit" style="height:40px;" /></div>
			            <div class="main-title"><span>专利&nbsp;/&nbsp;知识产权列表</span></div>
						<div class="baodao_list zuanli">
		                	<ul id="knowledgeDiv">
		                        
		                    </ul>
		                </div>
		            </div>
		        </div>    
		    </div>
		</div>
	</body>
</html>