<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="活动发布">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3"><!-- <a class="f14 c-333" href="">创智汇 / </a><a class="f14 c-333" href="">我发起的活动 / </a> -->发布新活动</h3>
					<div class="clearfix mt40">
						<div class="fb-activity">
							<ul class="clearfix" style="cursor: pointer;">
			            		<li class="active">活动内容</li>
			                	<li class="">活动文档</li>
			                	<li class="">场地选择</li>
			            	</ul>
						</div>
						<div class="clearfix">
							<div class="fb-list-box">
								<table>
									<colgroup>
										<col width="130"></col>
										<col></col>
									</colgroup>
									<tbody>
										<tr>
											<th>活动标题</th>
											<td><input type="text" id="applyTitle"></td>
										</tr>
										<tr>
											<th>活动时间</th>
											<td><input type="text" placeholder="请选择开始时间" id="startTime" class="laydate-icon"><span class="ml15 mr15">至</span><input type="text" placeholder="请选择结束时间" id="endTime" class="laydate-icon"></td>
										</tr>
										<tr>
											<th>截止报名时间</th>
											<td><input type="text" placeholder="请选择截止报名时间" id="enddate" class="laydate-icon"></td>
										</tr>
										<tr>
											<th>活动人数限制</th>
											<td><input type="text" id="applyMaxuser"></td>
										</tr>
										<tr>
											<th>活动封面</th>
											<td>
												 <div class="photo-edit" id="destination" style="width:200px;height:200px;margin-left:0px;">
							    					<input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
							    					<p>编辑 <span class="ml10">封面</span></p>
													<p class="f12">封面图片大小建议：288*195</p>
												</div>
												<div class="photoedit" style="left:22px">
													<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png"  width="200" height="200"/>
											</div>		
											</td>
										</tr>
										<tr>
											<th>活动地点</th>
											<td><input type="text" id="activityAdr"></td>
										</tr>
										<tr>
											<th>活动内容</th>
											<td><textarea id="editorproductDiscriptio" name="editorproductDiscriptio" cols="20" rows="5" class="ckeditor"></textarea></td>
										</tr>
										<tr>
											<td></td>
											<td><a href="javascript:;" class="ib-btn next-step" style="padding:0px 40px;">下一步</a></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="fb-list-box undis">
								<table>
									<colgroup>
										<col width="130"></col>
										<col></col>
									</colgroup>
									<tbody>
										<tr>
											<th>文档标题</th>
											<td><input type="text"></td>
										</tr>
										<tr>
											<th>文档上传</th>
											<td>
												<div class="photo-edit" style="width:200px;height:140px;padding:45px 10px;margin-left:0px;">
													<input type="file">
													<p style="letter-spacing:10px">点击上传</p>
												</div>
											</td>
										</tr>
										<tr>
											<th>文档列表</th>
											<td></td>
										</tr>
										<tr>
											<!-- <td colspan="2">
												<div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                           <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                            <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                            <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                            <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
											</td> -->
										</tr>
									</tbody>
								</table>
								<a href="javascript:;" class="ib-btn tc  ml15 mr20 prev-step mb30" style="width:110px;">上一步</a>
								<a href="javascript:;" class="ib-btn next-step tc mb30" style="width:110px;">下一步</a>
							</div>
							<div class="fb-list-box undis">
								<table class="flb-table mt30 c-b1 f12 tc"  width="100%">
								<div class="per-h3" style="padding-bottom:0px;border-bottom: 0px;"><a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>新增场地</a></div>
									<colgroup>
										<col width="60"></col>
										<col width="23.5%"></col>
										<col width="23.5%"></col>
										<col width="23.5%"></col>
										<col></col>
									</colgroup>
									<tbody class="activeroom">
										<!-- <tr align="center" class="f14 c-333">
											<td colspan="2">地点</td>
											<td>时间</td>
											<td>价格</td>
											<td>操作</td>
										</tr>
										<tr>
											<td><input type="checkbox"></td>
											<td align="left">创智中心2号楼302</td>
											<td>2016-03-12 08:00 - 18:00</td>
											<td>588</td>
											<td><a href="" class="c-333">查看场地详情</a></td>
										</tr>
										<tr>
											<td><input type="checkbox"></td>
											<td align="left">创智中心2号楼302</td>
											<td>2016-03-12 08:00 - 18:00</td>
											<td>588</td>
											<td><a href="" class="c-333">查看场地详情</a></td>
										</tr>
										<tr>
											<td><input type="checkbox"></td>
											<td align="left">创智中心2号楼302</td>
											<td>2016-03-12 08:00 - 18:00</td>
											<td>588</td>
											<td><a href="" class="c-333">查看场地详情</a></td>
										</tr> -->
									</tbody>
								</table>
								<a href="javascript:;" class="ib-btn tc ml20 mr30 mb30" style="width:110px;" id="submit">保存</a>
								<a href="javascript:;" class="ib-btn tc prev-step mb30" style="width:110px;">上一步</a>
							</div>
						</div>
						
                    </div>  
				</div>
				
			</youi:body>
			<div class="toast">
		        	<div class="toast-con clearfix">
		            	<div class="close-toast fr"></div>
		           	 <p class="tc mt25 f18" style="color:#ff6715">请登录后重试！</p>
		        	</div>       
   			</div>
	<!--***bottom start****************************************-->
	<!--***bottom end****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/genWisdom/releaseActivity.js"></script>	
</youi:html>