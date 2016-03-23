<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業信息</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAndCss.jsp"%>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">    
		    <div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right">
		        	<div class="main-title"><span>企业资料修改</span></div>
		            <div class="qiye_logo">
		            	<div class="qiye_text"><span>企业logo</span></div>
		                <div class="upload_main">
		                    <div class="qiye_pic">添加标志</div>
		                    <div class="upload_input"><input type="file"></div>
		            	</div>
		            </div>
		            <div class="xiangxi_xinxi">
		                <div class="qiye_fullname ">
		                    <div class="qiye_nametex">企业全称</div>
		                    <div class="name_input"><input type="text"></div>
		                </div>
		                <div class="qiye_jianjie ">
		                    <div class="qiye_word">企业简介</div>
		                    <div class="word_input">
		                        <textarea></textarea>
		                        <div class="font_xianzhi">字数限制：0/200</div>
		                    </div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">地址</div>
		                    <div class="select_address">
		                        <div class="select_lou">
		                            <div class="tct-select fl mr20" style="width:290px">
										<div class="ic-select">
											<p class="c-b1">所在楼</p>
										</div>
										<ul style="display: none;" class="select-nav">
											<li>园区1楼</li>
											<li>园区2楼</li>
											<li>园区3楼</li>
										</ul>
									</div>
		                        </div>
		                        <div class="select_lou2">
		                           <div class="tct-select fl mr20" style="width:290px">
										<div class="ic-select">
											<p class="c-b1">所在层</p>
										</div>
										<ul style="display: none;" class="select-nav">
											<li>园区1层</li>
											<li>园区2层</li>
											<li>园区3层</li>
										</ul>
									</div>
		                        </div>
		                    </div>
		                </div>
		                <div class="qiye_web">
		                    <div class="qiye_webtex">官方网站</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">所在行业</div>
                            <div class="tct-select fl mr20" style="width:290px">
								<div class="ic-select">
									<p class="c-b1">互联网技术</p>
								</div>
								<ul style="display: none;" class="select-nav">
									<li>互联网技术1</li>
									<li>互联网技术2</li>
									<li>互联网技术3</li>
								</ul>
							</div>
                		</div>
            		</div>
           		<div class="jiesao_word">
	           		<div class="qiye_js">
	                	<div class="qiye_jieshao"><span>公司介绍</span></div>
	                    <div class="edit_tool"></div>
	                </div>
	                <div class="qiye_ms">
	                	<div class="qiye_miaoshu"><span>产品描述</span></div>
	                    <div class="edit_tool"></div>
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
	                                    <img src="images/photo_list1.png">                                        
	                                </div>
	                            </li>
	                            <li>
	                                <div style="position:relative">
	                                    <div class="overlay"></div>
	                                    <img src="images/photo_list1.png">                                        
	                                </div>
	                            </li>
	                            <li>
	                                <div style="position:relative">
	                                    <div class="overlay"></div>
	                                    <img src="images/photo_list1.png">                                        
	                                </div>
	                            </li>
	                            <li>
	                                <div style="position:relative">
	                                    <div class="overlay"></div>
	                                    <img src="images/photo_list1.png">                                        
	                                </div>
	                            </li>
	                            <li>
	                                <div style="position:relative">
	                                    <div class="overlay"></div>
	                                    <img src="images/photo_list1.png">                                        
	                                </div>
	                            </li>
	                            <li>
	                                <div style="position:relative">
	                                    <img src="images/add.png">
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