<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="个人资料">
	<youi:body decorator="memcenter"> 

				<div class="w1000">
					<h3 class="per-h3">基本资料</h3>
					<table class="setting-table grst-table">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr style="display:none;">
							<td>ID</td>
							<td><span class="" id="memberId"> </span></td>
						</tr>
						<tr>
							<td>头像</td>
							<td>				   
							    <%-- <div class="photo-edit" id="destination">
							    	<input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
								</div>
								<div class="photoedit" style="left:22px">
									<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png"  width="107" height="107"/>
								</div> --%>
								<input type="hidden" id="memberHeadPortrait" >
								<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png" border="0" class="fl" width="107" height="107"/>
								<div class="photo-edit"><input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>编辑<br/>头像</div>
							</td>
						</tr>
						<tr>
							<td>账号</td>
							<td><span class="c-b1"> </span><span class="c-o"><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/securityCenter.html">[更换手机号码]</a></span></td>
						</tr>
						<tr>
							<td>昵称</td>
							<td><input type="text" id="memberNickname"></td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td><input type="text" id="memberName"></td>
						</tr>
						<tr>
							<td>出生日期</td>
							<td>
								<div id="birthday_container">
									<select name="year" id="year" style="width:88px;"></select>
									<select name="month" id="month" style="width:65px;"></select>
									<select name="day" id="day" style="width:65px;"></select>
								</div>
							</td>
						</tr>
						<tr>
							<td>一句话介绍</td>
							<td><textarea style="height:60px;" id="memberDescribe2"></textarea></td>
						</tr>
						<tr>
							<td>公司</td>
							<td>
								<input type="text" readonly="readonly" id="companyName">
								<input type="hidden" readonly="readonly" id="companyId">
								<a href="javascript:;" class="ml15 open-tanc" id="ly1"><i class="fa fa-plus-circle mr5"></i>加入企业</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="保存" class="hhf-submit" style="height:36px;" />
							</td>
						</tr>
					</table>
				</div>
	
	<!--***bottom end****************************************-->
		<!--***弹窗 start****************************************-->
		<div class="bg-tanc">
			<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
				<a href="javascript:;" class="tc-close"></a>
				<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>加入园区</b></h3>
				<table class="line-table cic-l-t " style="font-size:14px;">
					<colgroup>
						<col width="110">
						<col>
					</colgroup>
					<tbody>
					<tr class="show2" >
						<td ><b>企业邀请码</b></td>
						<td><input style="width:150px" type="text" id="companyInvitecode"></td>
						<td><span class="c-o aa"></span></td>
					</tr>					
					<tr>						
						<td colspan="2"><a class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">加入企业</a></td>
					</tr>
				</tbody></table>
			</div>
		</div>
			
	<!--***弹窗 end****************************************-->
	<!--***弹窗 start****************************************-->
	
		<!-- 弹出层样式 -->
     <div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
    	
	
	<!--***弹窗 end****************************************-->

	</youi:body>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/myReservationRecord.js"></script>	
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/personalCenter/personInfo.js"></script>		
</youi:html>