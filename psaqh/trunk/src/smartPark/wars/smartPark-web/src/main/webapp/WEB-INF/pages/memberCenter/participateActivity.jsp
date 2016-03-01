<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我参加的活动</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/base.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/zs.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/awesome/css/font-awesome.min.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/js/jquery-1.11.0.js"></script>
    <style>
	  .ccheng{color:#FF6715}
    </style>
</head>
<body style="background-color:#f4f4f4;">
	<!--***top start****************************************-->
	<div style="background-color:#545454">
		<div class="w1200 tr head-top clearfix">
			<a>${user}</a>
			<a href="logout.html">退出</a>
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
						<dd><a href="grzx1.html">个人资料</a></dd>
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
						<dd class="active"><a href="participateActivity.html">我参加的活动</a></dd>
						<dd><a href="grzx21.html">我发布的活动</a></dd>
					</dl>
				</div>
				<div class="w1000">
					<h3 class="per-h3">我参加的活动</h3>
					<div class="clearfix mt40">
						<div class="clearfix czh-knowledge">
                            
                            
                         </div>

                        
						<div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
							<a href="">首</a>
							<a href=""><i class="fa fa-angle-left"></i></a>
							<a>1</a>
							<a href=""><i class="fa fa-angle-right"></i></a>
							<a href="">末</a>
							<input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
							<a href="">Go</a>
						</div>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/3.0/lib/jquery-ui.min.js?1=1"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/3.0/lib/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/lib/giui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:'/smartPark-web/esb/web/activityApplyManager/getParticipateActivityList.json',
				success:function(result){
					console.log(result.records);
					if(result&&result.records){
						_parseRecords(result.records);
						_assignment_applyStatus();
					}
				}
			});
		});
		//拼接活动列表
		function _parseRecords(record){
			for(var i=0;i<record.length;i++){
				var html="<div class='czh-box'>"+
                    	 "<img src='<%=request.getContextPath()%>/styles/images/czh/list-5.jpg'>"+
                		 "<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
                    	 "<h4>"+record[i].applyTitle+"</h4>"+
                    	 "<span>活动发起人："+record[i].memberId+"</span><br/>"+
                    	 "<span>举办时间："+record[i].startTime+"至"+record[i].endTime+"</span>"+
                		 "</div>"+
                		 "<div class='czh-group'>"+
                    	 "<font class='cg-soan-btn' style='background:#FF6715'>相关文档</font>"+
                    	 "<span class='fr' style='color:#FF6715'>"+record[i].applyStatus+"</span>"+
                		 "</div>"+
            			 "</div>";
				 $(".clearfix .czh-knowledge").append(html);
	
			}
		};
		//根据不同状态重新赋文字说明
		function _assignment_applyStatus(){
			var span = $("span.fr");
			if(span){
			    var text = span.html();
			    if(text=="00"){
			    	span.html("申请中");
			    }else if(text=="01"){
			    	span.html("进行中");
			    }else if(text=="01"){
			    	span.html("已结束");
			    }
			} 
		}
	</script>
</body>
</html>