<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我参加的活动">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我参加的活动</h3>
					<div class="clearfix mt40">
						<div class="clearfix czh-knowledge">
                            
                            
                         </div>

                        
						<!-- <div class="fr page-list-a clearfix lh30 mt20 f12">
							<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
							<a href="">首</a>
							<a href=""><i class="fa fa-angle-left"></i></a>
							<a>1</a>
							<a href=""><i class="fa fa-angle-right"></i></a>
							<a href="">末</a>
							<input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
							<a href="">Go</a>
						</div> -->
						<div class="tcdPageCode fr">
					
						</div>
					</div>
				</div>
		</youi:body>
	<!--***bottom start****************************************-->
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/genWisdom/participateActivity.js"></script>	
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
</youi:html>