<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我参加的活动">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3">我参加的活动</h3>
					<div class="clearfix mt40">
						<div class="clearfix czh-knowledge">
                            
                            
                         </div>

                        
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
				</div>
		</youi:body>
	<!--***bottom start****************************************-->

	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:baseUrl+'activityApplyManager/getParticipateActivityList.json',
				success:function(result){
					console.log(result.records);
					if(result&&result.records){
						_parseRecords(result.records);
						_assignment_applyStatus();
					}
				}
			});
		});
		//拼接活动列表
		function _parseRecords(record){
			for(var i=0;i<record.length;i++){
				var html="<a href='javascript:;' id='"+record[i].applyId+"' onclick='javascript:gotoDetails(this)'>"+
						 "<div class='czh-box'>"+
                    	 "<img src='"+cenUrl+"filestore/"+record[i].activityImage+"'style='width: 220px; height: 123px;'>"+
                		 "<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
                    	 "<h4>"+record[i].applyTitle+"</h4>"+
                    	 "<span>活动发起人："+record[i].memberId.memberName+"</span><br/>"+
                    	 "<span>举办时间："+record[i].startTime+"至"+record[i].endTime+"</span>"+
                		 "</div>"+
                		 "<div class='czh-group'>"+
                    	 "<font class='cg-soan-btn' style='background:#FF6715'>相关文档</font>"+
                    	 "<span class='fr' style='color:#FF6715'>"+record[i].applyStatus+"</span>"+
                		 "</div>"+
            			 "</div>"+
            			 "<a>";
				 $(".clearfix .czh-knowledge").append(html);
	
			}
		};
		//根据不同状态重新赋文字说明
		function _assignment_applyStatus(){
			var span = $("span.fr");
			if(span){
			    var text = span.html();
			    if(text=="00"){
			    	span.html("申请中");
			    }else if(text=="01"){
			    	span.html("进行中");
			    }else if(text=="01"){
			    	span.html("已结束");
			    }
			} 
		};
		//跳转方法
		function gotoDetails(obj){
			alert(obj.id+"跳转到详情页面");
		}
	</script>
</youi:html>