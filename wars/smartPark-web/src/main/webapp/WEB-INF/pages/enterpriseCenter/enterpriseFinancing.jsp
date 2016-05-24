<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业融资</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/enterpriseCenter/enterpriseFinancing.js"></script>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
	    	<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
	    		<div class="main-wrapper-right mb40">
	    			<input id="financingId" name="financingId" style="display:none;" type="text">
	        		<div class="main-title"><span>融资信息</span></div>
	            	<div class="xiangxi_xinxi mt40">
	            		<span id="financingRe" style="display:none;"></span>
						<div class="qiye_address">
	                    	<div class="qiye_word">融资轮次</div>
	                    	<div class="tct-select fl mr20" style="width:290px">
		                    	<div class="ic-select">
									<p class="c-b1">&nbsp;</p>
								</div>
								<ul id="roundFinancing" style="display: none;" class="select-nav"></ul>
							</div>
                        </div>
                        <div class="rongzi_je">
		                    <div class="qiye_rzje">融资企业名称</div>
		                    <div class="web_input"><input id="financingName" name="financingName" type="text"></div>
		                </div>
		                <div class="rongzi_je">
		                    <div class="qiye_rzje">融资金额(万元)</div>
		                    <div class="web_input"><input id="financingAmount" name="financingAmount" type="text"></div>
		                </div>
		                <div class="rongzi_gz">
		                    <div class="qiye_rzgz">融资估值(万元)</div>
		                    <div class="web_input"><input id="financingCost" name="financingCost" type="text"></div>
		                </div>
		                <div class="kechi_gf">
		                    <div class="qiye_kcgf">可持股份(%)</div>
		                    <div class="web_input"><input id="financingPre" name="financingPre" type="text"></div>
		                </div>
		                <div class="rongzi_time">
		                	<div class="qiye_rzsj">融资时间</div>
		                    <div class="rongzi_chose">
		                    	<div class="time_input">
		                    		<input id="financingTime" name="financingTime" placeholder="请选择融资时间" class="laydate-icon" type="text" />
		                    	</div>
		                    </div>
		                </div>
		                <div class="rongzi_js">
		                    <div class="qiye_word">融资介绍</div>
		                    <div class="word_input">
		                        <textarea id="financingDescribe" name="financingDescribe"></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/200</div>
		                    </div>
		                </div>
		                <div class="meiti_save_btn"><div class="save_btn"><a>保存</a></div></div>
		            </div>
					<div class="rozi_main">
						<div class="clearfix yin-group undis">
							<div id="informationFinancing" class="yg-group-box">
								
							</div>
						</div>
		            </div>
		        </div>    
		    </div>
		</div>
		<!-- 弹出层样式 -->
		<div class="toast">
		    <div class="toast-con clearfix">
		        <div class="close-toast fr"></div>
		        <p class="tc mt25 f18" id="toast_text" style="color:#ff6715">请登录后重试！</p>
		    </div>
		</div>
	</body>
</html>