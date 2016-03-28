<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業融资</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript">
			// 中文字符判断
			function getStrLength(str) { 
				var len = str.length; 
			    var reLen = 0; 
			    for (var i = 0; i < len; i++) {        
			        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) { 
			            // 全角    
			            reLen += 2; 
			        } else { 
			            reLen++; 
			        } 
			    } 
			    return reLen;    
			}
			$(document).ready(function() {
				$("#financingDescribe").on('keyup', function() {
				    var len = getStrLength(this.value);
				    $("#currentCount").html(len);
				});
				$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#financingRe").html(result.record.companyId);
							//根据企业id获取融资信息
					    	$.ajax({
					    		url : baseUrl+"/informationFinancingManager/findInformationFinancing.json",
					    		data : ['financingRe='+result.record.companyId].join('&'),
					    		success : function(results) {
					    			if (results && results.records) {
					    				var records = results.records;
					    				$("#informationFinancing").empty();
					    				for(var i=0; i<records.length; i++){
					    					var financingMsg = "";
					    					var style = "";
					    					if(records[i].financingStatus=="1"){
					    						financingMsg = records[i].financingTime.substring(0,4)+"年"+records[i].financingTime.substring(5,7)+"月";
					    						style = "yg-time history_time";
					    					}else{
					    						financingMsg = "进行中...";
					    						style = "yg-time";
					    					}
					    					var financingDiv = '<div class="'+style+'">'+
												'<div class="yt-pa"><span>'+financingMsg+'</span></div>'+
												'<em class="em-pa_active"></em>'+
												'<div class="clearfix active">'+
													'<span>'+records[i].financingSub+'</span><span>融资金额：<em class="c-o">'+records[i].financingAmount+'万元</em></span><span>融资估值：<em class="c-o">'+records[i].financingCost+'万元</em></span><span>可持股份：<em class="c-o">'+records[i].financingPre+'%</em></span>'+
												'</div>'+
												'<p>'+records[i].financingDescribe+'</p>'+
				                                '<p class="mt10"><a href="javascript:;">编辑</a>&nbsp;丨&nbsp;<a href="javascript:;">删除</a></p>'+
											'</div>';
											$("#informationFinancing").append(financingDiv);
					    				}
					    			}
					    		}
					    	});
						}
					}
				});
				$(".hhf-submit").click(function(){
			  		var rzId=$("#financingRe").html();
			  		var roomId=$("#roomId").val();
			  		var rzName=$("#rzName").val();
					var rzUrl=$("#rzUrl").val();
					var enTypeName=$("#enTypeName").val();
					var rzRemark=$("#rzRemark").val();
					var rzLogo = $("#rzLogo").attr("src");
					var productDiscriptio=editor.getData();
					var params = ['rzId='+rzId+'','rzLogo='+rzLogo+'','roomId.roomId='+roomId+'','rzName='+rzName+'','rzRemark='+rzRemark+'','rzUrl='+rzUrl+'','enTypeName='+enTypeName+'','productDiscriptio='+productDiscriptio+''];
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/enterbusinessmanagerRzManager/updateEnterbusinessmanagerRz.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								alert("修改成功");
								location.reload();
							}
						}
					});
				});
			});
		</script>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.sidebar-menu-mainul2').delegate('li', 'click', function() {
				$('.sidebar-menu-mainul2').find('li').each(function(i, dom) {
		            $(this).removeClass('active');
		        });
				$(".sidebar-menu-mainul2 li").eq(2).addClass("active");
		    });
		});
		</script>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
	    	<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
	    		<div class="main-wrapper-right mb40">
	        		<div class="main-title"><span>融资信息</span></div>
	        		<span id="financingRe" style="display:none;"></span>
	            	<div class="xiangxi_xinxi mt40">
						<div class="qiye_address">
	                    	<div class="qiye_word">融资轮次</div>
                            <div class="tct-select fl mr20" style="width:290px">
								<div class="ic-select" >
									<p class="c-b1">天使轮</p>
								</div>
								<ul style="display: none;" class="select-nav">
									<li>天使轮1</li>
									<li>天使轮2</li>
									<li>天使轮3</li>
								</ul>
							</div>
                        </div>
		                <div class="rongzi_je">
		                    <div class="qiye_rzje">融资金额</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="rongzi_gz">
		                    <div class="qiye_rzgz">融资估值</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="kechi_gf">
		                    <div class="qiye_kcgf">可持股份</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="rongzi_time">
		                	<div class="qiye_rzsj">融资时间</div>
		                    <div class="rongzi_chose">
		                    	<div class="time_input"><input type="text"></div>
		                        <span class="time_to">到</span>
		                        <div class="time_input"><input type="text"></div>
		                        <div class="search_time"><a href="javascript:void(0);">搜索</a></div>
		                    </div>
		                </div>
		                <div class="rongzi_js ">
		                    <div class="qiye_word">融资介绍</div>
		                    <div class="word_input">
		                        <textarea id="financingDescribe" name="financingDescribe"></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/200</div>
		                    </div>
		                </div>
		                <div class="meiti_save_btn"><input type="submit" value="保存" class="hhf-submit" style="height:40px;" /></div>
		            </div>
					<div class="rozi_main">
						<div class="clearfix yin-group undis">
							<div id="informationFinancing" class="yg-group-box">
								
							</div>
						</div>
		            </div>
		        </div>    
		    </div>
		</div>
	</body>
</html>