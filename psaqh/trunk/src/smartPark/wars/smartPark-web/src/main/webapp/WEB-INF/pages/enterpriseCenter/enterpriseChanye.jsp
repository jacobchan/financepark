<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>产业链对接</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
		<script type="text/javascript">
			$(document).ready(function() {
				 var height = Math.max(document.documentElement.clientHeight, document.body.offsetHeight);
				  document.getElementById('main-wrapper-right').style.minHeight=height*6/7+'px';
				  
			  		$(".chanye_row").last().css("border-bottom", "none"); 

				  
				  $(".sidebar-menu-mainul > li:eq(4)").addClass("active");
				  //查选当前企业产业链信息
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'memberInformationManager/getMemberInformationByLoginUser.json',
						success:function(result){
							if(result&&result.record){
								//根据企业id获取产业链信息
								 getletter(result.record.companyId);
								$('.main-title').attr("id",result.record.companyId);
							}
						}
					});
			});
			
			function getletter(id){
				var letterEnterpriseId = id;
				var pageSize=2;
				var pageCount=1;	
				var srcUrl = baseUrl+"lettermanagerLetterManager/getPagerLettermanagerLetters.json";
				$.youi.ajaxUtils.ajax({
		    		url : srcUrl,
		    		data : ['letterEnterpriseId='+letterEnterpriseId].join('&'),
		    		success : function(results) {
		    			if (results && results.records) {
		    				if(results.records.length>0){
								pageCount=Math.ceil(results.totalCount/pageSize);
								 refreshData(1,pageSize);
									$(".tcdPageCode").createPage({
									    pageCount:pageCount,
									    current:1,
									    backFn:function(p){
									       this.pageCount=pageCount;
									        refreshData(p,pageSize);
									    }
									});
									$(".tcdPageCode").show();
							}else{
								$(".tcdPageCode").hide();
								$('.letter').empty();
								$('.letter').append("<p><h4 style='text-align: center;'>暂无产业链信息</h4></p>");
							}
		    			}
		    		}
		    	});
				
				function refreshData(pageIndex,pageSize){
					var params = {'pager:pageIndex':pageIndex,'pager:pageSize':pageSize,'letterEnterpriseId':letterEnterpriseId};
					$.youi.ajaxUtils.ajax({
						url:srcUrl,
						data:params,
						success:function(results){
							if(results&&results.records){
								if(results.records.length>0){
									commRecords(results.records);
								}
							}
						}
					});
				}
			}
			
			function commRecords(record){
				$('.letter').empty();
				var html="";
				for(var i=0;i<record.length;i++){
					var img ="";
					var name = "";
					if(record[i].member!=null){
						if(record[i].member.memberHeadPortrait!=null&&record[i].member.memberHeadPortrait!=''){
							img = ""+cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].member.memberHeadPortrait+"&method=show";
						}else{
							img = ""+cenUrl+"styles/images/qiye/default.jpg";
						}
						name = record[i].member.memberName;
					}else{
						img = ""+cenUrl+"styles/images/qiye/default.jpg";
						name =  "匿名";
					}
					var time = getmonth(record[i].letterTime);
					html+='<div class="chanye_row" id='+record[i].letterId+'>'+
                	'<div class="fl"><img src='+img+' style="width:59px;height:59px; " ></div>'+
                    '<div class="chanye_words">'+
                    	'<span class="speaker">'+name+'：</span>'+
                       '<div class="chanye_con">'+
                           '<p class="chanye_tex fl show">'+record[i].letterContent+'</p>'+   
                            '<a class="show_more" href="javascript:;"></a>'+
                        '</div>'+
                         '<span class="speaktime">'+time+'</span>'+
                           '</div>'+
                                '<div class="chanye_btn">'+
                                   '<a class="delete_anniu fr" href="javascript:;" onclick="dealeletter(this);">删除</a>'+
                                '</div>'+
                            '</div>';
				}
				$(".letter").append(html);
				showclick();
			}
			
			//格式化年月
			function getmonth(time){
				var year=time.substr(0,4); 
				var data = "";
				var index1=time.indexOf("-"); 
				var index2=time.lastIndexOf("-"); 
				var cha=parseInt(index2)-(parseInt(index1)+1); 
				var month=time.substr((parseInt(index1)+1),cha); 
				var kg=time.indexOf(" ");
				cha=parseInt(kg)-(parseInt(index2)+1);
				var day=time.substr(parseInt(index2)+1,cha); 
				var sec = time.substr(parseInt(kg));
				date = year+"年"+month+"月"+day+"日"+sec;
				return date;
			}
			
			function dealeletter(obj){
				var me = obj.parentNode.parentNode;
				var params = {'letterId':me.id};
				$.youi.ajaxUtils.ajax({
					url:baseUrl+"lettermanagerLetterManager/removeLettermanagerLetter.json",
					data:params,
					success:function(results){
						 	var id = $('.main-title').attr("id");
						 	getletter(id);
						 	close("删除成功!");
						}
					});
				
			}
			function showclick(){
				  $(".show_more").click(function(){
						$(this).parent().find("a").toggleClass("show_iconup");	
						$(this).parent().find("p").toggleClass("show");
					});
				
					$(".reply_anniu").click(function(){
						$(this).parents(".chanye_row").find(".reply_content").show();
						$(this).parents(".chanye_row").find(".chanye_btn").hide();
				  	});
					
					$(".reply_btn").click(function(){
						$(this).parents(".chanye_row").find(".reply_content").hide();
						$(this).parents(".chanye_row").find(".chanye_btn").show();
				  	});
			}
			//弹出框
		   	function close(content){		        
			        $(".tc.mt25.f18").empty() ;
			        $(".tc.mt25.f18").append(content) ;
			        $(".toast").show();		      		        		       				
					setTimeout(function(){$(".toast").hide(); },1000);
		      }
		</script>
	</head>
	<body class="page-header-fixed" style="background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">    
    <div id="youi_page_left" class="fl clearfix"></div>
	<div class="main-wrapper">
    	<div class="main-wrapper-right mb30" id="main-wrapper-right">
        	<div class="main-title"><span>产业链对接</span></div>
            <div class="all_pinglun">
                <div class="qiye_pinglun">
                        <!--评论-->
                        <div class="chanye_main letter">
                        
                        
                         <!--回复样式--> 
                        	<!-- <div class="chanye_row">
                            	<div class="fl"><img src="images/sl-i2.png"></div>
                                <div class="chanye_words">
                                	<span class="speaker">斯大林：</span>
                                    <div class="chanye_con">
                                        <p class="chanye_tex fl show">我发现你们家的产品非常符合我们采购的需求，我们在生产的某一环节需要用到，希望和你尽快取得联，我们在生产的某一环节需要用到，希望和你尽快取得联，我们在生产的某我们在生产的某一环节需要用到，希望和你尽快取得联，我们在生产的某一环节需要用到，希望和你尽快取得联，我们在生产的某一环节需要用到，希望和你尽快取得联，我们在
    生产的某一环节需要用到，希望和你尽快取得联</p>   
                                        <a class="show_more" href="javascript:;"></a>
                                    </div>
                                    
                                    <div class="reply_content">
                                        <div class="reply_kuang1">
                                            <span class="color_orange fl">回复@斯大林：</span>
                                            <textarea placeholder="一起做大做强！...发送一起做大做强！..." class="fl"></textarea>
                                    	</div>
                                        <div class="tr mt10">
                                            <a class="reply_btn a-c-o mr10" href="javascript:;">发送</a>
                                            <a class="reply_btn" href="javascript:;">取消</a>
                                        </div>
                                    
                                    </div>
                                    <span class="speaktime">2016年1月18日10:02:2</span>
                                </div>
                                <div class="chanye_btn">
                                	<a class="a-c-o fr reply_anniu mb10" href="javascript:;">回复</a>
                                    <a class="delete_anniu fr" href="javascript:;">删除</a>
                                </div>
                            </div> -->
                        </div>
                          
                        <div class="tcdPageCode">
					
						</div>
                        
                </div>
            </div>
        </div>          
    </div>
    <div class="toast">
	        <div class="toast-con clearfix">
	            <div class="close-toast fr"></div>
	            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
	        </div> 
		</div>
</div>
	</body>
</html>