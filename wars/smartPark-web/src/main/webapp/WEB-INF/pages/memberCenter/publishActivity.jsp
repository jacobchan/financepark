<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我发布的活动</title>
    <style>
	  .ccheng{color:#FF6715}.a_left,.a_right{width:40px;height:65px;cursor:pointer;position:absolute;margin-top:-32px;top:50%; opacity:0.7}
	  .a_left{background:url(<%=request.getContextPath()%>/styles/images/grzx/a_left.png) no-repeat;left:0}
	  .a_right{background:url(<%=request.getContextPath()%>/styles/images/grzx/a_right.png) no-repeat;right:0}
	  .czh-box.active{border-color:#FF6715}.czh-box.active h4{color:#FF6715}
	  .ac_box{border-bottom:1px #EFEEEE solid;}.ac_box a{padding:0 20px 0 0;color:#868686}
	  .ac_box .active{color:#FF6715; text-decoration:underline}
	  .img_list li{padding:20px;display:inline-block;float:left; text-align:center}
    </style>
</head>
<body style="background-color:#f4f4f4;">
	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3">我发布的活动</h3>
					<div class="clearfix mt40">
						<div class="clearfix czh-knowledge pr">
 
                            <div class="a_left"></div>
                            <div class="a_right"></div>
                            
                         </div>
                         <div class="mt40 ac_box pb20">
                         	<a class="active" href="javascript:openApplyList()">报名的名单</a><a href="publishActivity-2.html">活动评论</a><a href="publishActivity-3.html">文档库</a>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                         </div>
                         <div class="activity-details"></div>
                     <%--
                         <a href="" class="table-more">加载更多</a>
						<!----> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$.ajax({
			url:'/smartPark-web/esb/web/activityApplyManager/getPublishActivityList.json',
			success:function(result){
				console.log(result.records);
				if(result&&result.records){
					_parseRecords(result.records);
					openApplyList(result.records);
				}
			}
		});
	});
	
	//拼接活动列表
	function _parseRecords(record){
		for(var i=0;i<record.length;i++){
			var cls="";
			if(i==0){
				cls="czh-box active";
			}else{
				cls="czh-box";
			}
			var html="<div class='"+cls+"'>"+
            		 "<img src='<%=request.getContextPath()%>/styles/images/czh/list-5.jpg'>"+
            		 "<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
               		 "<h4>"+record[i].applyTitle+"</h4>"+
           		 	 "</div>"+
       			 	 "</div>";
			 $(".czh-knowledge").append(html);

		}
	};
	
	function openApplyList(record){
		var params = ['applyId='+record[0].applyId];
		$.ajax({
			url:'/smartPark-web/esb/web/activityApplyManager/getPublishActivityMembers.json',
			data:params.join('&'),
			success:function(result){
				if(result&&result.records){
					_parseApplyList(result.records);
				}
			}
		});	
	};
	
	//拼接活动报名名单
	function _parseApplyList(record){
		var html="<ul class='clearfix img_list'>";
		for(var i=0;i<record.length;i++){
			html+="<li>"+
				 "<img src='<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png' border='0' height='59' width='59'>"+
				 "<br/>"+record[i].memberName+
				 "</li>";
		}
		html+="</ul>";
		alert(html);
		$(".activity-details").append(html);
	};
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>