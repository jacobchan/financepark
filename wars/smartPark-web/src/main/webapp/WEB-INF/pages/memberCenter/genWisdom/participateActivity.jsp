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
						if(result.records.length>0){
							_parseRecords(result.records);
							_assignment_applyStatus();
						}else{
							 $(".clearfix .czh-knowledge").append("<p><h3>未找到相关记录!</h3></p>");
							 $(".fr.page-list-a").empty();
						}
					}
				}
			});
		});
		//拼接活动列表
		function _parseRecords(record){
			for(var i=0;i<record.length;i++){
				var star = record[i].startTime;
				var end = record[i].endTime;
				var startime = getmonth(star);
				var endtime = getmonth(end);
				var html="<a href='javascript:;' id='"+record[i].applyId+"' onclick='javascript:gotoDetails(this)'>"+
						 "<div class='czh-box'>"+
						 "<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].activityImage+"&method=show' style='width: 220px; height: 123px;'>"+
                		 "<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
                    	 "<h4>"+record[i].applyTitle+"</h4>"+
                    	 "<span>活动发起人："+record[i].memberId.memberName+"</span><br/>"+
                    	 "<span>举办时间："+startime+" - "+endtime+"</span>"+
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
			    }else if(text=="02"){
			    	span.html("已结束");
			    }else if(text=="03"){
			    	span.html("已取消");
			    }
			} 
		};
		//跳转方法
		function gotoDetails(obj){
			//alert(obj.id+"跳转到详情页面");
			window.location.href=proUrl+"czh/czh3.html?applyId="+obj.id;
		}
		//截取月年
		function getmonth(time){
			var data = "";
			var index1=time.indexOf("-"); 
			var index2=time.lastIndexOf("-"); 
			var cha=parseInt(index2)-(parseInt(index1)+1); 
			var month=time.substr((parseInt(index1)+1),cha); 
			var kg=time.indexOf(" ");
			cha=parseInt(kg)-(parseInt(index2)+1);
			var day=time.substr(parseInt(index2)+1,cha); 
			date = month+"/"+day;
			return date;
		}
		
	</script>
</youi:html>