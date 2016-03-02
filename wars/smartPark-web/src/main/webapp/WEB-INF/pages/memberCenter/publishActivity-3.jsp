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
                         	<a  href="publishActivity.html">报名的名单</a><a href="publishActivity-2.html">活动评论</a><a class="active" href="publishActivity-3.html">文档库</a>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                         </div>
                   		<!---->
                         <div class="clearfix czh-knowledge mt30">
                            <div class="czh-box">
                                <img src="../images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>UI设计-VIP课堂【云中帆教育】</h4>
                                    <span>月观看人数：12</span>
                                    <span class="fr">创智讲堂</span>
                                </div>
                                <div class="czh-group">
                                    <font class="cg-soan-btn">PPT</font>
                                </div>
                                <div class="new">NEW</div>
                            </div>
                            <div class="czh-box">
                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>UI设计-VIP课堂【云中帆教育】</h4>
                                    <span>月观看人数：12</span>
                                    <span class="fr">创智讲堂</span>
                                </div>
                                <div class="czh-group">
                                    <font class="cg-soan-btn">PPT</font>
                                </div>
                            </div>
                            <div class="czh-box">
                                <img src="../images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>UI设计-VIP课堂【云中帆教育】</h4>
                                    <span>月观看人数：12</span>
                                    <span class="fr">创智讲堂</span>
                                </div>
                                <div class="czh-group">
                                    <font class="cg-soan-btn">PPT</font>
                                </div>
                            </div>
                            <div class="czh-box">
                                <img src="../images/czh/list-5.jpg">
                                <div class="czh-group" style="border-bottom:1px solid #ecebeb">
                                    <h4>UI设计-VIP课堂【云中帆教育】</h4>
                                    <span>月观看人数：12</span>
                                    <span class="fr">创智讲堂</span>
                                </div>
                                <div class="czh-group">
                                    <font class="cg-soan-btn">PPT</font>
                                </div>
                            </div>
                         </div>
						<!---->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>