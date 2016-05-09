<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="企业通讯录">
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
							<!-- <li><a href="grzx4-2.html">我的评论</a></li> -->
							<li class="active"><a href="grzx4-3.html">系统消息</a></li>
						</ul>
					</div>
					<div class="clearfix fl" style="width:898px;padding:30px">
						<table class="me-tz-show w100">
							<colgroup>
								<col></col>
								<col width="50"></col>
							</colgroup>
							<tbody id="newslist">
								<tr>
									<td>
										<h4 class="c-333 mb10 fb f14">物业服务通知</h4>
										<p>尊敬的用户，您的物业报修订单已经受理，我的维修人员将尽快上门为您服务，请耐心等候...</p>
										<p class="f12">2016 年 2 月 17 日 15:26:20</p>
									</td>
									<td align="right">
										<a href="" class="see-it">查看</a>
									</td>
								</tr>
							</tbody> 								
						</table>
						<div class="tcdPageCode fr"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/news.js"></script>	
</youi:html>