<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
	<head>
	<meta charset="UTF-8">
	<title>物业投诉</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%>
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="h-nav clearfix">
				<a href=""><span>首页</span></a><img src="<%=request.getContextPath()%>/styles/images/zs/right-j-b.png" border="0" />
				<a href=""><span>物业服务</span></a><img src="<%=request.getContextPath()%>/styles/images/zs/right-j-b.png" border="0" />
				<a href=""><span class="current">物业投诉</span></a>
			</div>
			<div class="clearfix">
				<div class="fl w895">				
					<div class="ht-bd-box">
						<table class="setting-table">
							<colgroup>
								<col width="80"></col>
								<col></col>
								<col width="120"></col>
								<col></col>
							</colgroup>
							<tr>
								<td align="center">投诉内容</td>
								<td colspan="3"><textarea></textarea></td>
							</tr>
							<tr>
								<td align="center">接受回访</td>
								<td>
									<label><input name="yesNo" class="mr5" checked="checked" type="radio">是</label>
									<label class="ml30"><input name="yesNo" class="mr5" type="radio">否</label>
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr class="yn-show">
								<td align="center">联系人</td>
								<td><input type="text"></td>
							</tr>
							<tr class="yn-show">
								<td align="center">回访电话</td>
								<td>
									<input type="text">
								</td>
							</tr>
							<tr>
								<td></td>
								<td><input value="提交" class="hhf-submit mt10" type="submit" style="margin-left:0px;"></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="fr w285">
					<h3 class="h3-bd">热点新闻</h3>
					<div class="ifn-group">
						<ul class="ig-nav">
							<li>
								<div class="in-photo">
									<img src="<%=request.getContextPath()%>/styles/images/zs/nav-img1.png" border="0" width="100%"/>
								</div>
								<div class="fr">
									<p>杭州，一场无关情爱的风月无边月无</p>
									<a href="" class="a-more">详细信息</a>
								</div>
							</li>
							<li>
								<div class="in-photo">
									<img src="<%=request.getContextPath()%>/styles/images/zs/nav-img2.png" border="0" width="100%"/>
								</div>
								<div class="fr">
									<p>杭州，一场无关情爱的风月无边月无</p>
									<a href="" class="a-more">详细信息</a>
								</div>
							</li>
							<li>
								<div class="in-photo">
									<img src="<%=request.getContextPath()%>/styles/images/zs/nav-img3.png" border="0" width="100%"/>
								</div>
								<div class="fr">
									<p>杭州，一场无关情爱的风月无边月无</p>
									<a href="" class="a-more">详细信息</a>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%>
	<script type="text/javascript">
		$(function(){
			$("#property").attr("class","active");
			$.ajax({
				url:'/smartPark-web/esb/web/propertyservicemanagerCosManager/getPropertyservicemanagerCoss.json',
				success:function(result){
					console.log(result.records);
					if(result&&result.records){
						_parseRecords(result.records);
					}
				}
			});
		});
		//拼接活动列表
		function _parseRecords(record){
			for(var i=0;i<record.length;i++){
				var html="<tr><td>"+record[i].cosCode+"</td><td>"+record[i].cosName+"</td><td>"+record[i].cosContent+"</td><td>"+record[i].cosStatus+"</td></tr>";
				$("#czh-knowledge").append(html);
			}
		};
	</script>
</body>
</html>