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
	  .pn_btn{width: 42px;height: 64px;margin-top: 35px;}
	  #prev_btn1{border-radius: 0px 10px 10px 0px;left: 10px;}
	  #next_btn1{border-radius: 10px 0px 0px 10px;right: 13px;}
	  .a_left:hover{background: rgba(255,255,255,0.6);}
	  .a_right{background:rgba(255,255,255,0.2);right:0}
	  .czh-box.active{border-color:#FF6715}.czh-box.active h4{color:#FF6715}
	  .ac_box{border-bottom:1px #EFEEEE solid;}.ac_box a{padding:0 20px 0 0;color:#868686}
	  .ac_box .active{color:#FF6715; text-decoration:underline}
	  .img_list li{padding:20px;display:inline-block;float:left; text-align:center}
	  .czh-knowledge{width: 100%;}
	  .gr-czh-box{width: 204px;float: left;margin:10px;border:1px solid #fff;cursor: pointer;}
	  .gr-czh-box img{width: 100%;po}
	  .gr-czh-box:hover,.gr-czh-box.active{border:1px solid #FF6715;color: #FF6715;}
	  .gr-czh-box:hover a,.gr-czh-box.active a{color: #FF6715;}
	  .gr-czh-box p{font-size: 14px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;line-height: 40px;margin-left: 5px;}
	  .gr-czh-box a{color: #333;}
	  .gr-czh-box a:hover{color: #FF6715;text-decoration: underline;}
	  .gr-ck-group{width: 1000%;position: relative;left: 0px;}
	  .oh{overflow: hidden;}
    </style>
    <script type="text/javascript">
    	$(function () {
    		$(".gr-czh-box").click(function(){
    			$(".gr-czh-box").removeClass("active");
    			$(this).addClass("active");
    		})
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
    	})
    </script>
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
						<div class="clearfix czh-knowledge pr oh">
							<div class="gr-ck-group">
						<%-- 		<div class="gr-czh-box active">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动1</p></a>
	                            </div>
	                            <div class="gr-czh-box">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动2</p></a>
	                            </div>
	                            <div class="gr-czh-box">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动3</p></a>
	                            </div>
	                            <div class="gr-czh-box">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动4</p></a>
	                            </div>
	                            <div class="gr-czh-box">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动5</p></a>
	                            </div>
	                            <div class="gr-czh-box">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动6</p></a>
	                            </div>
	                            <div class="gr-czh-box">
	                                <img src="<%=request.getContextPath()%>/styles/images/czh/list-5.jpg">
	                                <a href=""><p>孩子不宜过早玩的10种运动7</p></a>
	                            </div> --%>
							</div>
                           
                            <div class="pn_btn" id="prev_btn1"><img src="<%=request.getContextPath()%>/styles/images/zs/arr-left.png" style="margin-top:16px;"></div>
                            <div class="pn_btn" id="next_btn1"><img src="<%=request.getContextPath()%>/styles/images/zs/arr-right.png" style="margin-top:16px;"></div>
                            
                         </div>
                         <div class="mt40 ac_box pb20">
                         	<a class="active" href="grzx21.html">报名的名单</a><a href="grzx21-2.html">活动评论</a><a href="grzx21-3.html">文档库</a>
                            <a href="javascript:;" class="ccheng fr">导出为Excel文档>></a>
                         </div>
                         <ul class="clearfix img_list">
                         	<%-- <li><img src="<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li>
                            <li><img src="<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png" border="0" height="59" width="59"><br/>斯大林</li> --%>
                         </ul>
                         <a href="" class="table-more">加载更多</a>
						<!---->
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
				cls="gr-czh-box active";
			}else{
				cls="gr-czh-box";
			}
			var html="<div class='"+cls+"'>"+
            		 "<img src='<%=request.getContextPath()%>/styles/images/czh/list-5.jpg'>"+
            		 " <a href=''><p>"+record[i].applyTitle+"</p></a>"+
       			 	 "</div>";
			 $(".gr-ck-group").append(html);

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
		for(var i=0;i<record.length;i++){
			var html="<li>"+
				 "<img src='<%=request.getContextPath()%>/styles/images/grzx/sl-i2.png' border='0' height='59' width='59'>"+
				 "<br/>"+record[i].memberName+
				 "</li>";

			$(".img_list").append(html);
		}
	};
	</script>
</body>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
</html>