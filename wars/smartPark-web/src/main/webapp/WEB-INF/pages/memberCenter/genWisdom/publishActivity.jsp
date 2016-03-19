<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我发布的活动</title>
    <script type="text/javascript">
	 	$(function(){
	 		$(".ac_box").on("click","span a",function(){
	 			$(this).addClass("active").siblings().removeClass("active");
	 			$(".clearfix.show").addClass("undis");
	 			$(".clearfix.show").eq($(this).index()).removeClass("undis");
	 		});
	 		$(".com_btn").on("click",function(){
	 			$(this).hide();
	 			$(this).parent().find(".dialog-show").show();
	 			$(this).parent().find("p.cc").css("margin-top","-10px");
	 		});
	 		$(".dialog-cancel").on("click",function(){
	 			$(this).parents(".dialog-box").find(".com_btn").show();
	 			$(this).parents(".dialog-show").hide();
	 			$(this).parents(".dialog-box").find("p.cc").css("margin-top","0px");
	 		});
	 		$(".dialog-close").on("click",function(){
	 			$(this).parent(".comment").remove();
	 		});
	 	});
    	function clickBox() {
    		$(".gr-czh-box").click(function(){
    			$(".gr-czh-box").removeClass("active");
    			$(this).addClass("active");
    			refreshList();
    		});
		    var sbysf_index = 0;
		    var n=$(".gr-ck-group .gr-czh-box").length-4;
		    function sbysf_scroll_up(){
		        sbysf_index++;
		        if(sbysf_index > n){
		            sbysf_index = 0;
		        }
		        sbysf_show(sbysf_index);
		    }
		    function sbysf_scroll_down(){
		        sbysf_index--;
		        if(sbysf_index < 0){
		            sbysf_index = n;
		        }
		        sbysf_show(sbysf_index);
		    }
		    function sbysf_show(j){
		        var index = -(j*224);
		        $(".gr-ck-group").animate({left: index+'px'},200);
		    }
		    $("#next_btn1").click(function(){
		        sbysf_scroll_up();
		    });
		    $("#prev_btn1").click(function(){
		        sbysf_scroll_down();
		    });
    	};
    	function refreshList(){
    		var applyId=$(".gr-czh-box.active").attr('id');
    		openApplyList(applyId);
    	}
    </script>
</head>
<body style="background-color:#f4f4f4;">
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
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
                         	<span><a class="active" href="javascript:;">报名的名单</a><a href="javascript:;">活动评论</a><a href="javascript:;">文档库</a><a href="javascript:;">场地选择</a></span>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                        </div>
                        <div class="clearfix show">
                         	<ul class="clearfix img_list">
	                        </ul>
	                         <a href="" class="table-more">加载更多</a>
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

						<div class="clearfix show undis">
							<div class="clearfix czh-knowledge mt30">
	                           
	                        </div>
						</div>
						<div class="clearfix show undis">
							<table class="place-table mt30">
								<colgroup>
									<col width="25%"></col>
									<col width="25%"></col>
									<col width="25%"></col>
									<col width="25%"></col>
								</colgroup>
								<tbody>
									<tr>
										<td>地点</td>
										<td>时间</td>
										<td>价格</td>
										<td>操作</td>
									</tr>
									<tr>
										<td colspan="4"><a class="f12 c-333" href="">暂无场地，前往预定>></a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$.ajax({
			url:baseUrl+'/activityApplyManager/getPublishActivityList.json',
			success:function(result){
				if(result&&result.records){
					_parseRecords(result.records);
					openApplyList(result.records[0].applyId);
				}
			}
		});
	});
	
	//拼接活动列表
	function _parseRecords(record){
		var html="";
		for(var i=0;i<record.length;i++){
			var cls="";
			if(i==0){
				cls="gr-czh-box active";
			}else{
				cls="gr-czh-box";
			}
			html+="<div class='"+cls+"' id='"+record[i].applyId+"'>"+
            		 "<img src='http://localhost:9088/filestore/"+record[i].activityImage+"' width='202' height='114'>"+
            		 " <a  href='javascript:;' onclick='redirectPage(this)'><p>"+record[i].applyTitle+"</p></a>"+
       			 	 "</div>";
		};
		 $(".gr-ck-group").append(html);
		 clickBox();
	};
	
	function openApplyList(applyId){
		var params = ['applyId='+applyId];
		//活动名单
		$.ajax({
			url:baseUrl+'/activityApplyManager/getPublishActivityMembers.json',
			data:params.join('&'),
			success:function(result){
				if(result&&result.records){
					_parseApplyList(result.records);
				}
			}
		});	
		//评论内容
		$.ajax({
			url:baseUrl+'/activityApplyManager/getPublishActivityComments.json',
			data:params.join('&'),
			success:function(result){
				if(result&&result.records){
					_parseApplyComments(result.records);
				}
			}
		});	
		//文档库
		$.ajax({
			url:baseUrl+'/activityApplyManager/getPublishActivityDocuments.json',
			data:params.join('&'),
			success:function(result){
				console.log(result);
				if(result&&result.records){
					_parseApplyDocuments(result.records);
				}
			}
		});	
	};
	
	//拼接活动报名名单
	function _parseApplyList(record){
		var html="";
		for(var i=0;i<record.length;i++){
			html+="<li>"+
				 "<img src='<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png' border='0' height='59' width='59'>"+
				 "<br/>"+record[i].memberName+
				 "</li>";
		};
		$(".clearfix.img_list").empty();
		$(".clearfix.img_list").append(html);
	};
	
	//拼接活动评论
	function _parseApplyComments(record){
		var html="";
		for(var i=0;i<record.length;i++){
			  html+="<div class='comment mt20 clearfix pr'>"+
	        			"<a href='javascript:;' class='tc-close dialog-close'></a>"+
	        			"<div class='fl'>"+
	            			"<img src='<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png' border='0' height='59' width='59'/>"+
	                		"<span class='pl15'>"+record[i].commentMember.memberName+"</span>"+
	           			"</div>"+
	            		"<div class='dialog-box clearfix pr'>"+
	            			"<a class='a-c-o com_btn' href='javascript:;'>回复</a>"+
	        				"<div class='com_info f12 lh24'>"+
	            				"<p>"+record[i].commentContent+"</p>"+
	            			"</div>"+
	            			"<div class='mt20 dialog-show'>"+
	                			"<textarea placeholder='回复内容' class='reply_info'></textarea>"+
	                   			"<div class='tr mt10'>"+
	                    			"<a class='reply_btn a-c-o a-c-fill' href='javascript:;''>发送</a>"+
	                       			"<a class='reply_btn dialog-cancel' href='javascript:;'>取消</a>"+
	                  			"</div>"+
	               			"</div>"+
	            			"<p class='cc f12 clearfix'>"+record[i].commentTime+"</p>"+
	           			"</div>"+
       			 	"</div>";
		};
		$(".applyComments").empty();
		$(".applyComments").append(html);
	};
	
	//拼接文档库
	function _parseApplyDocuments(record){
		var html="";
		for(var i=0;i<record.length;i++){
			var documentName=record[i].documentName;
			var dn=documentName.split('.');
			  html+="<a href='javascript:;' onclick='redirectPagePDF(this)' id="+record[i].documentId+"><div class='czh-box'>"+
		              "<img src='<%=request.getContextPath()%>/styles/images/czh/list-5.jpg'>"+
		              "<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
		                 "<h4>"+dn[0]+"</h4>"+
		                 "<span>月观看人数：12</span>"+
		                 "<span class='fr'>创智讲堂</span>"+
		              "</div>"+
		              "<div class='czh-group'>"+
		                "  <font class='cg-soan-btn'>"+dn[1]+"</font>"+
		              "</div>"+
		              "<div class='new'>NEW</div>"+
		          	"</div></a>";
		}
		$(".clearfix.czh-knowledge.mt30").empty();
		$(".clearfix.czh-knowledge.mt30").append(html);
	}
	function redirectPage(obj){
		var id=obj.parentNode.id;
		alert("点击动作待定...");
	}
	function redirectPagePDF(obj){
		var id=obj.id;
		alert("点击动作待定...");
	}
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>