<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业融资</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
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
					    						style = "yg-time            ";
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
			  		var financingRe=$("#financingRe").html();
			  		var financingName=$("#financingName").val();
			  		var financingAmount=$("#financingAmount").val();
			  		var financingCost=$("#financingCost").val();
					var financingPre=$("#financingPre").val();
					var financingTime=$("#financingTime").val();
					var financingDescribe=$("#financingDescribe").val();
					var financingSub=$('#roundFinancing li.selected').attr("data-id");
					var params = ['financingRe='+financingRe+'','financingName='+financingName+'','financingAmount='+financingAmount+'','financingCost='+financingCost+'','financingPre='+financingPre+'','financingTime='+financingTime+'','financingDescribe='+financingDescribe+'','financingSub='+financingSub+''];
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/informationFinancingManager/saveInformationFinancing.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								alert("保存成功");
								$("#financingAmount").val();
						  		$("#financingCost").val();
								$("#financingPre").val();
								$("#financingTime").val();
								$("#financingDescribe").val();
								location.reload();
							}
						}
					});
				});
				var start = {
					elem: '#financingTime',
					min: '2000-01-01 23:59:59', //设定最小日期为当前日期
					max: '2099-06-16 23:59:59', //最大日期
					istoday: false,
					choose: function(datas){
					    end.min = datas; //开始日选好后，重置结束日的最小日期
					    end.start = datas; //将结束日的初始值设定为开始日
					}
				};
				laydate(start);
				
				$.ajax({
					url:baseUrl+'/informationFinancingManager/findCodeitem.json?code=roundFinancing',
					success:function(result){
						if(result&&result.records){
							var records = result.records;
							$("#roundFinancing").empty();
							for(var i=0; i<records.length; i++){
								$("#roundFinancing").append("<li data-id='"+records[i].itemId+"' data-val='"+records[i].itemValue+"'>"+records[i].itemCaption+"</li>");
							}
						}
					}
				});
				
				$(".qiye_address").on("click",function(){
					$("#roundFinancing").toggle();
				});
		        
				$("#roundFinancing").on("click","li",function(){
					$(this).addClass("selected").siblings().removeClass("selected");
					var selecttext = $(this).text();
					var val = $(this).attr("data-val");
					$(".c-b1").text(selecttext).attr("data-val",val);
				});
			});
		</script>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
	    	<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
	    		<div class="main-wrapper-right mb40">
	        		<div class="main-title"><span>融资信息</span></div>
	            	<div class="xiangxi_xinxi mt40">
	            		<span id="financingRe" style="display:none;"></span>
						<div class="qiye_address">
	                    	<div class="qiye_word">融资轮次</div>
	                    	<div class="tct-select fl mr20" style="width:290px">
		                    	<div class="ic-select">
									<p class="c-b1"></p>
								</div>
								<ul id="roundFinancing" style="display: none;" class="select-nav"></ul>
							</div>
                        </div>
                        <div class="rongzi_rzmc">
		                    <div class="qiye_rzmc">融资企业名称</div>
		                    <div class="web_input"><input id="financingName" name="financingName" type="text"></div>
		                </div>
		                <div class="rongzi_je">
		                    <div class="qiye_rzje">融资金额</div>
		                    <div class="web_input"><input id="financingAmount" name="financingAmount" type="text"></div>
		                </div>
		                <div class="rongzi_gz">
		                    <div class="qiye_rzgz">融资估值</div>
		                    <div class="web_input"><input id="financingCost" name="financingCost" type="text"></div>
		                </div>
		                <div class="kechi_gf">
		                    <div class="qiye_kcgf">可持股份</div>
		                    <div class="web_input"><input id="financingPre" name="financingPre" type="text"></div>
		                </div>
		                <div class="rongzi_time">
		                	<div class="qiye_rzsj">融资时间</div>
		                    <div class="rongzi_chose">
		                    	<div class="time_input">
		                    		<input id="financingTime" name="financingTime" placeholder="请选择融资时间" class="laydate-icon" type="text" />
		                    	</div>
		                    </div>
		                </div>
		                <div class="rongzi_js">
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