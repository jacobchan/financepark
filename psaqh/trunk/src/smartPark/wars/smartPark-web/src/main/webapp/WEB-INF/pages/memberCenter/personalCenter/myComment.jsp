<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我的评论">
	<youi:body decorator="memcenter"> 
			<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<div id="youi_page_left" class="fl clearfix"></div>
				<div class="fr clearfix">
					<div class="w100p fl" >
						<h3 class="lh30 f14 mb30">全部消息</h3>
						<ul class="mess-nav">
							<!-- <li><a href="grzx4.html">我的私信</a></li> -->
							<li class="active"><a href="#">我的评论</a></li>
							<li ><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/myComment.html">系统消息</a></li>
						</ul>
					</div>
					
					<div class="clearfix fl" style="width:898px;padding:30px"  ">
						<div id="newslist"></div>					
						<div class="tcdPageCode fr"></div>
					</div>				
				</div>
			</div>
		</div>
	</div>
	</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/myComment.js"></script>	
</youi:html>