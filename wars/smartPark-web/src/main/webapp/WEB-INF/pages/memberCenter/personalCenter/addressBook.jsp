<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="企业通讯录">
	<youi:body decorator="memcenter"> 
		<div class="w1000">
			<h3 class="per-h3">企业通讯录</h3>
			<div class="mt20 gr-txl clearfix lh30">
				<span class="f16" id="companyName"></span>
				<div class="fr">
					<input type="text" class="bd-input" id="memberName" placeholder="请输入姓名">
					<input value="查询" class="hhf-submit" type="button" style="padding:0px 20px;height:30px;">							
				</div>
			</div>
			<table class="gt-table mt20">
				<colgroup>
					<col width="220"></col>
					<col width="220"></col>
					<col height="50"></col>
					<col width="220"></col>
				</colgroup>						
				<tbody>
					<tr>
						<th>姓名</th>
						<th>联系电话</th>
						<th>一句话简介</th>
						<th>加入时间</th>
					</tr>	
				</tbody>
				<tbody class="list"></tbody>																	
			</table>
			<div class="tcdPageCode fr"></div>
		</div>
	</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/addressBook.js"></script>	
</youi:html>