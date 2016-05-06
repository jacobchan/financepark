<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我发布的活动">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我发布的活动</h3>
					<div class="clearfix mt40">
						<div class="clearfix czh-knowledge pr oh">
							<div class="gr-ck-group">
								
							</div>
                           
                            <div class="pn_btn" id="prev_btn1"><img src="<%=request.getContextPath()%>/styles/images/zs/arr-left.png" style="margin-top:16px;"></div>
                            <div class="pn_btn" id="next_btn1"><img src="<%=request.getContextPath()%>/styles/images/zs/arr-right.png" style="margin-top:16px;"></div>
                            
                        </div>

                        <script type="text/javascript">
                         	$(function(){
                         		$(".ac_box").on("click","span a",function(){
                         			$(this).addClass("active").siblings().removeClass("active");
                         			$(".clearfix.show").addClass("undis");
                         			$(".clearfix.show").eq($(this).index()).removeClass("undis");
                         		})
                         	})
                        </script>
                        <div class="mt40 ac_box pb20">
                         	<span><a class="active" href="javascript:;">报名的名单</a><!-- <a href="javascript:;">活动评论</a> --><a href="javascript:;">文档库</a><a href="javascript:;">场地选择</a></span>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                        </div>
                        <div class="clearfix show">
                         	<ul class="clearfix img_list">
	                        </ul>
	                         <!-- <a href="" class="table-more">加载更多</a> -->
                        </div>
                         
						<!---->

						<div class="clearfix show undis">
							<div class="applyComments"></div>
							<!--评论-->	                        
							<!---->
	                        <div class="fr page-list-a clearfix lh30 mt20 f12">
								<span class="mr20 fl">共有 0 条，每页显示： 50 条</span>
								<a href="">首</a>
								<a href=""><i class="fa fa-angle-left"></i></a>
								<a>1</a>
								<a href=""><i class="fa fa-angle-right"></i></a>
								<a href="">末</a>
								<input class="bd-input fl ml10 mr10" style="width:40px;" type="text">
								<a href="">Go</a>
							</div>
						</div>

						<!-- <div class="clearfix show undis">
							<div class="clearfix czh-knowledge mt30">
	                           
	                        </div>
						</div> -->
						<div class="clearfix show undis">
							<table class="place-table mt30">
								<colgroup>
									<col width="25%"></col>
									<col width="25%"></col>
									<col width="25%"></col>
									<col width="25%"></col>
								</colgroup>
								<tbody>
									<!-- <tr>
										<td>地点</td>
										<td>时间</td>
										<td>价格</td>
										<td>操作</td>
									</tr> -->
									<!-- <tr>
										<td colspan="4"><a class="f12 c-333" href="">暂无场地，前往预定>></a></td>
									</tr> -->
								</tbody>
							</table>
						</div>
					</div>
				</div>
		</youi:body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/memberCenter/genWisdom/publishActivity.js"></script>	

</youi:html>