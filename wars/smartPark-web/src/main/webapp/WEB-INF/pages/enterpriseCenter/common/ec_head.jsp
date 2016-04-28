<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="top-nav">
	<script type="text/javascript">
		function goProperties(gohref){
			//alert(Portal);
			window.location.href=proUrl+gohref; 
		}
	</script>
	<div style="background-color:#545454">
		
		<div id="user_info" class="w1200 tr head-top clearfix">
			<span style="color:#cdcdcd;" class="mr10">当前用户:${user.loginName}</span>
			<a href="<%=request.getContextPath()%>/member/memberCenter/logout.html" class="brcd">退出</a>
			<a href="<%=request.getContextPath()%>/member/memberCenter/index.html" class="brcd">个人中心</a>
			<a href="#">客服体系</a>
		</div>
	</div>
	<div class="header-cen clearfix">
		<div class="w1200  clearfix">
			<div class="logo fl">
		    	<a href="javascript:void(0)" onclick="goProperties('index.html')"><img src="<%=request.getContextPath()%>/styles/images/logo_3.png" class="fl" style="margin-top:3px"/></a>		        
		    </div>
		   	<div class="party-change">
		   		<span class="f28">会员中心</span>
		   	</div>
		    <ul class="index-head-nav">
		    	<li><a href="javascript:void(0)" onclick="goProperties('index.html')">首页</a></li>
		        <li>
		        	<a href="#">招商中心</a>
		        	<dl>
		        		<dt></dt>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('zscenter/zs1.html')">园区简介</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('zscenter/zs2.html')">服务配套</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('zscenter/zs5.html')">园区风采</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('zscenter/zs3.html')">优惠政策</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('zscenter/zs4.html')">园区资讯</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('zscenter/zs6.html')">众创空间</a></dd>
		        	</dl>
		        </li>
		        <li>
		        	<a href="#">智慧园区</a>
		        	<dl>
		        		<dt></dt> 
			        	<dd><a href="javascript:void(0)" onclick="goProperties('wisdompark/office.html')">虚拟空间</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('wisdompark/business.html')">智慧商业</a></dd>
		        		<!-- <dd><a href="javascript:void(0)" onclick="goProperties('wisdompark/safa.html')">安全园区</a></dd> -->
		        		<dd><a href="javascript:void(0)" onclick="goProperties('industrydatabase/enterprise.html')">产业数据库</a></dd>
		        		<!-- <dd><a href="javascript:void(0)" onclick="goProperties('cg30/index.html')">30采购</a></dd> -->
	        		</dl>
		        </li>
		        <li>
		        	<a href="#">园区服务</a>
		        	<dl>
		        		<dt></dt>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('yqfw/yq13.html')">入驻服务</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('yqfw/yq7.html')">物业服务</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('companyservice/carLease.html')">公共资源</a></dd>
		        	</dl>
		        </li>
		        <li><a href="javascript:void(0)" onclick="goProperties('companyservice/ITserver.html')">企业服务</a></li>
		        <li>
		        	<a href="javascript:void(0)" onclick="goProperties('czh/czh1.html')" >创智汇</a>
		        	<dl>
		        		<dt></dt>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('czh/czh1.html')">创智汇</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('czh/czh2.html')">创智汇介绍</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('czh/czh4.html')">创智讲堂</a></dd>
		        		<dd><a href="javascript:void(0)" onclick="goProperties('czh/czh5.html')">硅谷创业营</a></dd>
		        		<!-- <dd><a href="javascript:void(0)" onclick="goProperties('cg30/store.html')">积分商城</a></dd> -->
		        	</dl>
		        </li>
		    </ul>
	
		    
		   
		</div>
	</div>
</header>