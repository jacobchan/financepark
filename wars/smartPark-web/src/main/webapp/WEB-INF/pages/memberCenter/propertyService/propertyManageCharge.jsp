<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="缴费查询">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">缴费查询列表</h3>
					<div class="clearfix">
						<div class="mt20 gr-txl clearfix lh30">
							<label class="fl mr20 f16">申请时间：</label>
							<input class="bd-input fl" type="text" id="startTime"><span class="fl ml15 mr15">到</span>
							<input class="bd-input fl" type="text" id="endTime">
							<div class="inp-box ml20"><input placeholder="订单号查询" type="text" id="userorderCode"><a class="fa fa-search" href=""></a></div>
							<input value="搜索" class="hhf-submit f14 fr" type="button">
						</div>
						<table class="gt-table mt20">
							<colgroup>
								<col width="150"></col>
								<col width="150"></col>
								<col width="150"></col>
								<col width="120"></col>
								<col width="150"></col>
								<col></col>
							</colgroup>
							<tbody><tr>
								<th>订单号</th>
								<th>缴费项目</th>
								<th>总金额</th>
								<th>状态</th>
								<th>截止日期</th>
								<th>操作</th>
							</tr>
							</tbody><tbody class="chargelist">
							   <tr>
				     	          <td colspan="6">暂无记录</td>
				                </tr> 
						     </tbody>
						</table>
						<div class="tcdPageCode fr"></div>
					</div>
				</div>	
	<!--***弹窗 start****************************************-->
	<div class="bg-tanc">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>领取发票</b></h3>
			<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
				<colgroup>
					<col width="110">
					<col>
				</colgroup>
				<tbody><tr>
					<td><b>单号</b></td>
					<td>123456789</td>
				</tr>
				<tr class="label">
					<td><b>发票抬头</b></td>
					<td>
						<label><input name="s-r" class="mr5"type="radio">个人</label>
						<label class="ml30"><input name="s-r" checked="checked" class="mr5" type="radio">企业</label>
					</td>
				</tr>
				<tr class="show2" >
					<td><b>企业名称</b></td>
					<td><input type="text" style="width:400px"></td>
				</tr>
				<tr>
					<td></td>
					<td class="add-sh">
						<label><input name="address" class="mr5" checked="checked" type="radio">寄送到报修地址</label>
						<label class="ml30"><input name="address" class="mr5" type="radio">自定义</label>
						<textarea class="mt20 so1 undis"></textarea>
						<div class="tct-select mt20 so2" style="width:400px;">
							<div class="ic-select">
								<p>文化创意园A302(张三 19855552222)</p>
							</div>
							<ul class="select-nav">
								<li>文化创意园A302(张三 19855552222)</li>
								<li>文化创意园A302(张三 19855552222)2</li>
								<li>文化创意园A302(张三 19855552222)3</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">领取发票</a></td>
				</tr>
			</tbody></table>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/propertyService/propertyManageCos.js"></script>	
</youi:html>
