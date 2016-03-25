<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業信息</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
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
				//CKEDITOR.replace('editorrzRemark');		
			  	var editor = CKEDITOR.replace('editorproductDiscriptio');
			  	editor.updateElement();
				$("#rzRemark").on('keyup', function() {
				    var len = getStrLength(this.value);
				    $("#currentCount").html(len);
				});
			  	$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#financingRe").html(result.record.companyId);
							$.ajax({
								url:baseUrl+'/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
								data : ['rzId='+result.record.companyId].join('&'),
								success:function(result){
									if(result&&result.record){
										$("#rzLogo").attr("src","/filestore/"+result.record.rzLogo);
										$("#financingRe").html(result.record.rzId);
										$("#rzName").val(result.record.rzName);
				    					$("#rzUrl").val(result.record.rzUrl);
				    					$("#rzRemark").val(result.record.rzRemark);
				    					editor.setData(result.record.productDiscriptio);
				    					$("#enTypeName").val(result.record.enTypeId.enTypeName);
				    					$("#editorproductDiscriptio").val(result.record.productDiscriptio);
				    					$("#currentCount").html(getStrLength(result.record.rzRemark));
									}
								}
							});
						}
					}
				});
			  	$.ajax({
					url:baseUrl+'/bbmRoomManager/getBbmRooms.json',
					success:function(results){
						if (results && results.records) {
		    				var records = results.records;
		    				$("#roomId").find("option").remove();
		    				for(var i=0; i<records.length; i++){
		    					$("#roomId").append("<option value='"+records[i].roomId+"'>"+records[i].roomNo+"</option>");
		    				}
						}
					}
				});
			  	$(".save_btn").click(function(){
			  		var rzId=$("#financingRe").html();
			  		var roomId=$("#roomId").val();
			  		var rzName=$("#rzName").val();
					var rzUrl=$("#rzUrl").val();
					var enTypeName=$("#enTypeName").val();
					var rzRemark=$("#rzRemark").val();
					var rzLogo = $("#rzLogo").attr("src");
					var productDiscriptio=editor.getData();
					var params = ['rzId='+rzId+'','rzLogo='+rzLogo+'','roomId.roomId='+roomId+'','rzName='+rzName+'','rzRemark='+rzRemark+'','rzUrl='+rzUrl+'','enTypeName='+enTypeName+'','productDiscriptio='+productDiscriptio+''];
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/enterbusinessmanagerRzManager/updateEnterbusinessmanagerRz.json',
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
		<script type="text/javascript">
			$(document).ready(function() {
				$('.sidebar-menu-mainul2').delegate('li', 'click', function() {
					$('.sidebar-menu-mainul2').find('li').each(function(i, dom) {
			            $(this).removeClass('active');
			        });
			        $(this).addClass('active');
			    });
			});
		</script>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">    
		    <div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right">
		        	<div class="main-title"><span>企业资料修改</span></div>
		        	<span class="" id="financingRe" style="display:none;"></span>
		            <div class="qiye_logo">
		            	<div class="qiye_text"><span>企业logo</span></div>
		            	<div class="photo-edit" id="destination"><img id="rzLogo" src="" width="107" height="107"/></div>
		                <div class="upload_main">
		                    <div class="qiye_pic">添加标志</div>
		                    <div class="upload_input"><input type="file"></div>
		            	</div>
		            </div>
		            <div class="xiangxi_xinxi">
		                <div class="qiye_fullname ">
		                    <div class="qiye_nametex">企业全称</div>
		                    <div class="name_input"><input id="rzName" name="rzName" type="text"></div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">地址</div>
		                    <div class="select_address">
		                        <select id="roomId" name="roomId.roomId" class="select-nav"></select>
		                    </div>
		                </div>
		                <div class="qiye_web">
		                    <div class="qiye_webtex">官方网站</div>
		                    <div class="web_input"><input id="rzUrl" name="rzUrl" type="text"></div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">所在行业</div>
                            <div class="tct-select fl mr20" style="width:290px">
                            	<select id="enTypeName" name="enTypeId.enTypeName" class="select-nav"></select>
							</div>
                		</div>
                		<div class="qiye_jianjie ">
		                    <div class="qiye_word">公司介绍</div>
		                    <div class="word_input">
		                        <textarea id="rzRemark" name="rzRemark"></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/200</div>
		                    </div>
		                </div>
            		</div>
           		<div class="jiesao_word">
	           		<!--<div class="qiye_js">
	                	<div class="qiye_jieshao"><span>公司介绍</span></div>
	                    <div class="edit_tool">
	                    	<textarea id="editorrzRemark" name="rzRemark" cols="20" rows="5" class="ckeditor"></textarea>
	                    </div>
	                </div>-->
	                <div class="qiye_ms">
	                	<div class="qiye_miaoshu"><span>产品描述</span></div>
	                    <div class="edit_tool">
	                    	<textarea id="editorproductDiscriptio" name="productDiscriptio" cols="20" rows="5" class="ckeditor"></textarea>
	                    </div>
	                </div>
				</div>
           		<div class="qiye_photo">
	                <div class="qiye_xc">
	                    <div class="qiye_xiangce"><span>企业相册</span></div>
	                    <div class="photo_list">
	                        <ul>
	                            <li>
	                                <div style="position:relative">
	                                    <div class="overlay"></div>
	                                    <img src="<%=request.getContextPath()%>/styles/images/qiye/photo_list1.png">                                        
	                                </div>
	                            </li>
	                            <li>
	                                <div style="position:relative">
	                                    <img src="<%=request.getContextPath()%>/styles/images/qiye/add.png">
	                                    <div class="upload_pic"><input type="file"></div>
	                                </div>
	                            </li>
                        	</ul>
                         	<div class="photo_btn">
                            	<div class="save_btn"><a>保存</a></div>
                            	<div class="quxiao_btn"><a>取消</a></div>
                        	</div>
                		</div>
           			</div>
        		</div>    
    		</div>
		</div>
	</body>
</html>