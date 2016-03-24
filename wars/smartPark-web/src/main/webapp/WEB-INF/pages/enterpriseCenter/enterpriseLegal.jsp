<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業融资</title>
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
			$(document).ready(function() {
				$("#legalRemark").on('keyup', function() {
				    var len = getStrLength(this.value);
				    $("#currentCount").html(len);
				});
				
				var height = Math.max((document.documentElement.clientHeight -135), ($(".main-wrapper").height()));
			  	document.getElementById('main-wrapper-right').style.height=height+'px';
			  	
			  	$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#legalRe").html(result.record.companyId);
							$.ajax({
								url:baseUrl+'/informationLegalManager/findInformationLegal.json',
								data : ['legalRe='+result.record.companyId].join('&'),
								success:function(result){
									if(result&&result.record){
										$("#legalRe").html(result.record.legalRe);
										$("#legalImage").attr("src","/filestore/"+records.legalImage);
										$("#legalId").html(result.record.legalId);
				    					$("#legalName").val(result.record.legalName);
				    					$("#legalBusiness").val(result.record.legalBusiness);
				    					$("#legalBirthday").val(result.record.legalBirthday);
				    					$("#legalTelephone").val(result.record.legalTelephone);
				    					$("#legalRemark").val(result.record.legalRemark);
									}
								}
							});
						}
					}
				});
			  	
			  	$(".hhf-submit").click(function(){
					var legalRe=$("#legalRe").html();
					var legalName=$("#legalName").val();
					var legalBirthday=$("#legalBirthday").val();
					var legalTelephone=$("#legalTelephone").val();
					var legalBusiness=$("#legalBusiness").val();
					var legalRemark=$("#legalRemark").val();
					var params = ['legalRe='+legalRe+'','legalName='+legalName+'','legalBirthday='+legalBirthday+'','legalTelephone='+legalTelephone+'','legalBusiness='+legalBusiness+'','legalRemark='+legalRemark+''];
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/informationLegalManager/saveInformationLegal.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								alert("修改成功");
								$("#legalRe").html();
								$("#legalImage").attr("src","");
								$("#legalId").html();
		    					$("#legalName").val();
		    					$("#legalBusiness").val();
		    					$("#legalBirthday").val();
		    					$("#legalTelephone").val();
		    					$("#legalRemark").val();
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
		    	<div class="main-wrapper-right" id="main-wrapper-right">
		        	<div class="main-title"><span>企业创始人</span></div>
		            <div class="qiye_header-img clearfix">
		            	<div class="qiye_text"><span>头像</span></div>
		                <div class="upload_main">
		                	<span class="" id="legalRe" style="display:none;"></span>
		                    <img id="legalImage" src="../styles/images/qiye/user-photo.png" border="0" class="fl" width="107" height="107"/>
							<div class="photo-edit"><input type="file" />编辑<br/>头像</div>
		            	</div>
		            </div>
		            <div class="csr_xinxi clearfix">
		                <div class="qiye_fullname clearfix">
		                	<input id="legalId" name="legalId" type="text" style="display:none;" />
		                    <div class="qiye_nametex">姓名</div>
		                    <div class="name_input"><input id="legalName" name="legalName" type="text"></div>
		                </div>
		                <div class="born_time clearfix">
		                    <div class="born_date">出生日期</div>
		                    <div class="born_input"><input id="legalBirthday" name="legalBirthday" type="text"></div>
		                </div>
		                <div class="born_time clearfix">
		                    <div class="born_date">手机号码</div>
		                    <div class="born_input"><input id="legalTelephone" name="legalTelephone" type="text"></div>
		                </div>
		                <div class="born_time clearfix">
		                    <div class="born_date">职位</div>
		                    <div class="born_input"><input id="legalBusiness" name="legalBusiness" type="text"></div>
		                </div>
		                <div class="qiye_jianjie clearfix">
		                    <div class="qiye_word">专利描述</div>
		                    <div class="word_input">
		                        <textarea id="legalRemark" name="legalRemark"></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/256</div>
		                    </div>
		                </div>
		                <div class="meiti_save_btn"><input type="submit" value="保存" class="hhf-submit" style="height:40px;" /></div>
		            </div>
		        </div>     
		    </div>
		</div>
	</body>
</html>