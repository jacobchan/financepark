<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我的地址">
	<youi:body decorator="memcenter"> 
				 
				<div class="w1000">
					<h3 class="per-h3">我的地址</h3>
					<div class="mt30 addressList">
					</div>	
					<a href="#" class="add-box ga-edit address"><i class="fa fa-plus mr20"></i>新增地址</a>
					<div class="tcdPageCode fr"></div>
				</div>
				
			</youi:body>
	<!--***bottom end****************************************-->
		<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10"><b>新增地址</b></h3>
			<table class="line-table cic-l-t wybx-tanc">
				<colgroup>
					<col width="110"></col>
					<col></col>
				</colgroup>
				<tr>
					<td><b>姓名</b></td>
					<td><input type="text" id="addressName"></td>
				</tr>
				<tr>
					<td><b>电话</b></td>
					<td><input type="text" id="addressPhone"></td>
				</tr>
				<tr>
					<td><b>地址信息</b></td>
					<td><input type="text" style="width:450px;" id="ad2"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="javascript:;" onclick="javascript:saveadd();" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">保存</a></td>
				</tr>
			</table>
			<div class="error-toast m1">
				<p></p>
			</div>
		</div>
		
	</div>
	<div class="bg-tanc m3">
		<div class="tanc-con" style="top:50%;margin-top:-225px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10"><b>编辑地址</b></h3>
			<table class="line-table cic-l-t wybx-tanc">
				<colgroup>
					<col width="110"></col>
					<col></col>
				</colgroup>	
				<tr>
					<td><b>姓名</b></td>
					<td><input type="text" id="editaddressName"></td>
				</tr>
				<tr>
					<td><b>电话</b></td>
					<td><input type="text" id="editaddressPhone"></td>
				</tr>
				<tr>
					<td><b>地址信息</b></td>
					<td><input type="text" style="width:450px;" id="editad2"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="javascript:;" onclick="javascript:editadd();" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">保存</a></td>
				</tr>
			</table>
			<div class="error-toast m3">
				<p></p>
			</div>
		</div>
	</div>
	<div class="bg-tanc m2">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w70 tc mt40" style="margin-left:15%">
				<table>
					<tr>
						<td><img src="<%=request.getContextPath()%>/styles/images/grzx/check.png" class="mr40 mb20" border="0"></td>
						<td >
							<h4 class="f24 fl c-333"> 您已预约成功！</h4>
							<p class="f14 c-o fl mt20 mb20">如有问题，请拨打：0571-86508888</p>
						</td>
					<tr/>
				</table>
			</div>
		</div>
	</div>
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
    <!-- 确认取消弹窗 -->    
    <div class="bg-tanc a1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w60 tc mt40" style="margin-left:20%">
				<div class="mt20 mb20 f16 lh26">
					<img src="<%=request.getContextPath()%>/styles/images/grzx/warn.png" border="0" class="mr20"/> 确认要删除<span class="c-o moverec">  </span>吗？
				</div>
				<!-- <p class="mb30">相关内容：空调不制冷，应该需要补充雪种！</p> -->
				<input value="确定" class="hhf-submit confirm" style="height:36px;" type="submit">
			</div>
		</div>
	</div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/myAdderss.js"></script>	

</youi:html>