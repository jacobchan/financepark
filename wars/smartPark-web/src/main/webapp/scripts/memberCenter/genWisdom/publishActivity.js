$(function(){
		$.ajax({
			url:baseUrl+'activityApplyManager/getPublishActivityList.json',
			success:function(result){
				if(result&&result.records){
					if(result.records.length>0){
						_parseRecords(result.records);
						openApplyList(result.records[0].applyId);
					}else{
						$(".clearfix.mt40").empty();
						var html ="<p class='tcv tc pt30'><img src='"+proUrl+"styles/images/none4.png'/></p>";
						$(".clearfix.mt40").append(html);
					}
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
			 "<img src='"+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].activityImage+"&method=show' width='202' height='114'>"+
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
			url:baseUrl+'activityApplyManager/getPublishActivityMembers.json',
			data:params.join('&'),
			success:function(result){
				if(result&&result.records){
					_parseApplyList(result.records);
				}
			}
		});	
		//评论内容
		/* $.ajax({
			url:baseUrl+'activityApplyManager/getPublishActivityComments.json',
			data:params.join('&'),
			success:function(result){
				if(result&&result.records){
					_parseApplyComments(result.records);
				}
			}
		});	 */
		//文档库
		$.ajax({
			url:baseUrl+'activityApplyManager/getPublishActivityDocuments.json',
			data:params.join('&'),
			success:function(result){
				//console.log(result);
				if(result&&result.records){
					_parseApplyDocuments(result.records);
				}
			}
		});	
		//活动地点
		$.ajax({
			url:baseUrl+'activityApplyManager/getPublishActivityOrder.json',
			data:params.join('&'),
			success:function(result){
				//console.log(result);
				if(result&&result.records){
					_parseApplyorder(result.records);
				}
			}
		});	
		
	};
	
	//拼接活动报名名单
	function _parseApplyList(record){
		var html="";
		for(var i=0;i<record.length;i++){
			var memberHeadPortrait ="";
			var add = record[i].memberHeadPortrait;
			if(add!=''&&add!=null){
				memberHeadPortrait = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+add+"&method=show";
			}else{
				memberHeadPortrait = cenUrl+"styles/images/grzx/sl-i2.png";
			}
			html+="<li>"+
				 "<img src="+memberHeadPortrait+" border='0' height='59' width='59'>"+
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
		              "<img src='../../../styles/images/grzx/user-photo.png' style='width: 220px;height: 123px;'>"+
		              "<div class='czh-group' style='border-bottom:1px solid #ecebeb'>"+
		                 "<h4>"+dn[0]+"</h4>"+
		                 "<span>月观看人数：12</span>"+
		                 "<span class='fr'>"+record[i].activityApply.applayType.typeName+"</span>"+
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
	
	//拼接活动场地
	function _parseApplyorder(record){
		$("tbody").empty();
		 var head = "<tr><td>地点</td><td>时间</td>"+
				"<td>价格</td><td>操作</td></tr>";
		$("tbody").append(head);
		var html="";
		for(var i=0;i<record.length;i++){
			html+="<tr><td align='left' style='padding-left: 75px;'>"+record[i].userorderProject+"</td>"+
			"<td>2016-03-12 08:00 - 18:00</td><td>"+record[i].userorderAmount+"元/小时</td>"+
			"<td><a href='"+proUrl+"companyservice/room.html' class='c-333'>查看场地详情</a></td></tr>";
		}
		$("tbody").append(html);
	}
	
	function redirectPage(obj){
		var id=obj.parentNode.id;
		window.location.href=proUrl+"czh/czh3.html?applyId="+id;
	}
	function redirectPagePDF(obj){
		var id=obj.id;
		alert("点击动作待定...");
	}
	
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