<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
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
	<!--***top start****************************************-->
	<div style="background-color:#545454">
		<div class="w1200 tr head-top clearfix">
			<a href="">注册</a>
			<a href="">登录</a>
		</div>
	</div>
	<div class="header-cen clearfix">
		<div class="w1200  clearfix">
			<div class="logo fl">
		    	<a href=""><img src="<%=request.getContextPath()%>/styles/images/logo_3.png" class="fl" style="margin-top:3px"/></a>		        
		    </div>
		   	<div class="party-change">
		   		<span class="f28">会员中心</span>
		   	</div>
		    <ul class="index-head-nav">
		    	<li><a href="#">首页</a></li>
		        <li>
		        	<a href="#">招商中心</a>
		        	<dl>
		        		<dt></dt>
		        		<dd><a href="../zscenter/zs1.html">园区简介</a></dd>
		        		<dd><a href="../zscenter/zs2.html">服务配套</a></dd>
		        		<dd><a href="../zscenter/zs5.html">园区风采</a></dd>
		        		<dd><a href="../zscenter/zs3.html">优惠政策</a></dd>
		        		<dd><a href="../zscenter/zs4.html">园区资讯</a></dd>
		        		<dd><a href="../zscenter/zs6.html">众创空间</a></dd>
		        	</dl>
		        </li>
		        <li>
		        	<a href="#">智慧园区</a>
		        	<dl>
		        		<dt></dt>
			        	<dd><a href="">虚拟空间</a></dd>
		        		<dd><a href="">智慧商业</a></dd>
		        		<dd><a href="">安全园区</a></dd>
		        		<dd><a href="">30采购</a></dd>
	        		</dl>
		        </li>
		        <li>
		        	<a href="#">园区服务</a>
		        	<dl>
		        		<dt></dt>
		        		<dd><a href="">入驻服务</a></dd>
		        		<dd><a href="">物业服务</a></dd>
		        		<dd><a href="">公共资源</a></dd>
		        		<dd><a href="">产业数据库</a></dd>
		        	</dl>
		        </li>
		        <li><a href="#">企业服务</a></li>
		        <li>
		        	<a href="#">创智汇</a>
		        	<dl>
		        		<dt></dt>
		        		<dd><a href="">创智汇介绍</a></dd>
		        		<dd><a href="">创智讲堂</a></dd>
		        		<dd><a href="">硅谷创业营</a></dd>
		        		<dd><a href="">积分商城</a></dd>
		        	</dl>
		        </li>
		    </ul>
		    <div class="fr search-see">
			    <div class="fl">
			    	<input type="text" class="input-search">
			    </div>
		    	<div class="fl">
			    	<a href="" class="btn-search"></a>
			    </div>
		    </div>
		</div>
	</div>
	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<div class="w200 fl">
					<dl>
						<dt>个人中心</dt>
						<dd><a href="memberInformation.html">个人资料</a></dd>
						<dd><a href="grzx2.html">订单中心</a></dd>
						<dd><a href="grzx3.html">安全中心</a></dd>
						<dd><a href="grzx4.html">消息</a></dd>
						<dd><a href="grzx5.html">企业通讯录</a></dd>
						<dd><a href="grzx6.html">一卡通绑定</a></dd>
						<dd><a href="grzx7.html">我的地址</a></dd>
						<dd><a href="grzx14.html">我的预约</a></dd>
						<dd><a href="grzx23.html">政策申请</a></dd>
						<dt>物业服务</dt>
						<dd><a href="grzx8.html">物业报修</a></dd>
						<dd><a href="grzx9.html">物业投诉</a></dd>
						<dd><a href="grzx10.html">访客登记</a></dd>
						<dd><a href="grzx11.html">搬家放行</a></dd>
						<dd><a href="grzx12.html">缴费查询</a></dd>
						<dd><a href="grzx13.html">一卡通办理</a></dd>
						<dt>全民营销</dt>
						<dd><a href="grzx15.html">我的人脉</a></dd>
						<dd><a href="grzx16.html">我的收益</a></dd>
						<dt>极速采购</dt>
						<dd>
							<a href="grzx18.html">我的订单 <i class="fa fa-angle-down ml10" style="font-size:16px"></i></a>
							<ul class="undis">
								<li><a href="grzx18-2.html">退货</a></li>
								<li><a href="grzx18-3.html">评价晒单</a></li>
								<li><a href="grzx18-4.html">订单详情</a></li>
							</ul>
						</dd>
						<dd><a href="grzx19.html">退货处理</a></dd>
						<dt>创智汇</dt>
						<dd><a href="participateActivity.html">我参加的活动</a></dd>
						<dd class="active"><a href="publishActivity.html">我发布的活动</a></dd>
					</dl>
				</div>
				<div class="w1000">
					<h3 class="per-h3">我参加的活动</h3>
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
                         	<a class="active" href="grzx21.html">报名的名单</a><a href="grzx21-2.html">活动评论</a><a href="grzx21-3.html">文档库</a>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                         </div>
                         <ul class="clearfix img_list">
                         	<li><img src="<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="../images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                         </ul>
                         <a href="" class="table-more">加载更多</a>
						<!---->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->
	<div class="bottom clearfix pb20">
		<div class="w1200 pt50 index-bottom-nav">
	    	<div class="clearfix">
		    	<dl>
		    		<dt><a href="#">关于我们</a></dt>
		    		<dd><a href="#">富春硅谷简介</a></dd>
		    		<dd><a href="#">联系我们</a></dd>
		    		<dd><a href="#">园区新闻</a></dd>
				</dl>
				<dl>
		        	<dt><a href="#" class="f14 mb20">园区服务平台</a></dt>
		    		<dd><a href="#" >企业公园简介</a></dd>
		    		<dd><a href="#">服务条款</a></dd>
				</dl>
				<dl>
		    		<dt><a href="#">客服中心</a></dt>
		    		<dd><a href="#">客户服务</a></dd>
		    		<dd><a href="#">自助服务</a></dd>
		    		<dd><a href="#">相关下载</a></dd>
		    		<dd><a href="#">园区新闻</a></dd>
		    	</dl>
				<dl>
		    		<dt><a href="#">运营合作方</a></dt>
		    		<dd><a href="#">关注我们</a></dd>
		    		<dd><a href="#">APP下载</a></dd>
				</dl>
				<dl>
		    		<dt><a href="#">帮助中心</a></dt>
		    		<dd><a href="#">常见问题</a></dd>
		    		<dd><a href="#">意见反馈</a></dd>
		        </dl>
		        <div class="fr tc mt5 f12">
		        	<div class="fl mr50">
			        	<img src="<%=request.getContextPath()%>/styles/images/code.jpg" width="110">
			            <p class="mt10">企业公园官方微信号</p>
			        </div>
		        	<div class="fl ml20">
			        	<img src="<%=request.getContextPath()%>/styles/images/code.jpg" width="110">
			            <p class="mt10">富春硅谷官方微信号</p>
			        </div>
		        </div>
	        </div>
	        <div class="mt40 clearfix">
	        	<img src="<%=request.getContextPath()%>/styles/images/fot.png" class="fl mt20">
	            <div class="fl mt10 ml15 bottom-partners">
	            	<p class="f16">合作伙伴</p>
	                <p>
	                	<a href="#">马可波罗</a>  <a href="#">Onlylady女人志</a>  <a href="#">艺龙旅游指南</a>  <a href="#">欣欣旅游网</a>  <a href="#">马可波罗</a><a href="#">马可波罗</a>  <a href="#">Onlylady女人志</a>  <a href="#">艺龙旅游指南</a>  <a href="#">欣欣旅游网</a>  <a href="#">马可波罗</a><a href="#">马可波罗</a>  <a href="#">Onlylady女人志</a>  <a href="#">艺龙旅游指南</a>  <a href="#">欣欣旅游网</a>  <a href="#">马可波罗</a>
	                </p>
	                <div class="mt20 f12">©2014-2015杭州富春硅谷投资有限公司  版权所有  浙  B14231237号</div>
	            </div>
	        </div>
	    </div>
	</div>
	<!--***bottom end****************************************-->
</body>
</html>