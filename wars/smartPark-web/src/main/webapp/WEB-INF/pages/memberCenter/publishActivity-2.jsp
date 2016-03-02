<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我发布的活动</title>
    <style>
	  .ccheng{color:#FF6715}.a_left,.a_right{width:40px;height:65px;cursor:pointer;position:absolute;margin-top:-32px;top:50%; opacity:0.7}
	  .a_left{background:url(<%=request.getContextPath()%>/styles/images/grzx/a_left.png) no-repeat;left:0}
	  .a_right{background:url(<%=request.getContextPath()%>/styles/images/grzx/a_right.png) no-repeat;right:0}
	  .czh-box.active{border-color:#FF6715}.czh-box.active h4{color:#FF6715}
	  .ac_box{border-bottom:1px #EFEEEE solid;}.ac_box a{padding:0 20px 0 0;color:#868686}
	  .ac_box .active{color:#FF6715; text-decoration:underline}
	  .img_list li{padding:20px;display:inline-block;float:left; text-align:center}
    </style>
</head>
<body style="background-color:#f4f4f4;">
	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">我发布的活动</h3>
					<div class="clearfix mt40">
						<div class="clearfix czh-knowledge pr">
                            <div class="czh-box">
                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>孩子不宜过早玩的10种运动</h4>
                                </div>
                            </div>
                            <div class="czh-box active">
                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>孩子不宜过早玩的10种运动</h4>
                                </div>
                            </div>
                            <div class="czh-box">
                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>孩子不宜过早玩的10种运动</h4>
                                </div>
                            </div>
                            <div class="czh-box">
                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>孩子不宜过早玩的10种运动</h4>
                                </div>
                            </div>
                            <div class="a_left"></div>
                            <div class="a_right"></div>
                            
                         </div>
                         <div class="mt40 ac_box pb20">
                         	<a  href="publishActivity.html">报名的名单</a><a class="active" href="publishActivity-2.html">活动评论</a><a href="publishActivity-3.html">文档库</a>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                         </div>
                          <!--评论-->
                         <div class="comment mt20 clearfix">
                         	<div class="fl">
                            	<img src="<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png"/>
                                <span class="pl15">斯大林</span>
                            </div>
                            <div class="fl ml40 com_info">
                            	<p>在这次活动中，我真的虚心学习到恒大，希望官方能多多举办，我一定会积极参加,奋斗粉搞</p>
                                <span class="cc">2016年1月18日 10：02</span>
                            </div>
                            <a class="a-c-o com_btn fr" href="javascript:;">回复</a>
                            <a href="javascript:;" class="com_close"><img src="../images/company/close0.png"/></a>
                         </div>
                         <div class="reply mt20 clearfix">
                         	<div class="fl">
                            	<img src="../images/grzx/sl-i2.png"/>
                                <span class="pl15">斯大林</span>
                            </div>
                            <div class="fl ml40 com_info">
                            	<p><span class="ccheng">@斯大林：</span>你的回复真好！</p>
                            </div>
                            <div class="fl ml40 mt30">
                            	<textarea placeholder="回复内容" class="reply_info"></textarea>
                                <div class="tr">
                                	<a class="reply_btn a-c-o" href="javascript:;">发送</a>
                                    <a class="reply_btn" href="javascript:;">取消</a>
                                </div>
                                <span class="cc">2016年1月18日 10：02</span>
                            </div>
                         </div>
                         
                         <div class="comment mt20 clearfix">
                         	<div class="fl">
                            	<img src="../images/grzx/sl-i2.png"/>
                                <span class="pl15">斯大林</span>
                            </div>
                            <div class="fl ml40 com_info">
                            	<p>在这次活动中，我真的虚心学习到恒大，希望官方能多多举办，我一定会积极参加,奋斗粉搞</p>
                                <span class="cc">2016年1月18日 10：02</span>
                            </div>
                            <a class="a-c-o com_btn fr" href="javascript:;">回复</a>
                            <a href="javascript:;" class="com_close"><img src="../images/company/close0.png"/></a>
                         </div>
                         <div class="comment mt20 clearfix">
                         	<div class="fl">
                            	<img src="../images/grzx/sl-i2.png"/>
                                <span class="pl15">斯大林</span>
                            </div>
                            <div class="fl ml40 com_info">
                            	<p>在这次活动中，我真的虚心学习到恒大，希望官方能多多举办，我一定会积极参加,奋斗粉搞</p>
                                <span class="cc">2016年1月18日 10：02</span>
                            </div>
                            <a class="a-c-o com_btn fr" href="javascript:;">回复</a>
                            <a href="javascript:;" class="com_close"><img src="../images/company/close0.png"/></a>
                         </div>
						<!---->
						<!---->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>