<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业融资</title>
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
			//删除专利
			function removeFinancing(obj){
			 	$.youi.ajaxUtils.ajax({
					url:baseUrl+'/informationFinancingManager/removeInformationFinancing.json',
					data:'financingId='+obj,
					success:function(result){
						alert("删除成功");
						location.reload();
					}
				});
			}
			//修改地址
			function updateFinancing(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7){
				$("#financingId").val(obj0);
				$("#financingRe").html(obj1);
				$("#financingName").val(obj2);
				$("#financingAmount").val(obj3);
		  		$("#financingCost").val(obj4);
				$("#financingPre").val(obj5);
				$("#financingTime").val(obj6);
				$("#financingDescribe").val(obj7);
				$("#currentCount").html(getStrLength(obj7));
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
					    					var cssStyle = "";
					    					var itemCaption = "";
					    					var financingAmount=records[i].financingAmount;
					    					var financingCost=records[i].financingCost;
					    					var financingPre=records[i].financingPre;
					    					var financingDescribe=records[i].financingDescribe;
					    					var financingSub=records[i].financingSub;
					    					if(records[i].financingStatus=="1"){
					    						financingMsg = records[i].financingTime.substring(0,4)+"年"+records[i].financingTime.substring(5,7)+"月";
					    						cssStyle = "yg-time history_time";
					    					}else{
					    						financingMsg = "进行中...";
					    						cssStyle = "yg-time";
					    					}
					    					$.ajax({
					    						url:baseUrl+'/codeitemManager/getCodeitem.json?itemId='+financingSub,
					    						success:function(result){
					    							if(result&&result.record){
					    								itemCaption = result.record.itemCaption;
					    							}
					    						}
					    					});
					    					var financingDiv = '<div class="'+cssStyle+'">'+
												'<div class="yt-pa"><span>'+financingMsg+'</span></div>'+
												'<em class="em-pa_active"></em>'+
												'<div class="clearfix active">'+
													'<span>'+itemCaption+'</span><span>融资金额：<em class="c-o">'+financingAmount+'万元</em></span><span>融资估值：<em class="c-o">'+financingCost+'万元</em></span><span>可持股份：<em class="c-o">'+financingPre+'%</em></span>'+
												'</div>'+
												'<p>'+financingDescribe+'</p>'+
				                                '<p class="mt10"><a href="javascript:updateFinancing(\''+records[i].financingId+'\',\''+records[i].financingRe+'\',\''+records[i].financingName+'\',\''+records[i].financingAmount+'\',\''+records[i].financingCost+'\',\''+records[i].financingPre+'\',\''+records[i].financingTime+'\',\''+records[i].financingDescribe+'\');">编辑</a>&nbsp;丨&nbsp;<a href="javascript:removeFinancing(\''+records[i].financingId+'\');">删除</a></p>'+
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
					var financingId=$("#financingId").val();
			  		var financingRe=$("#financingRe").html();
			  		var financingName=$("#financingName").val();
			  		var financingAmount=$("#financingAmount").val();
			  		var financingCost=$("#financingCost").val();
					var financingPre=$("#financingPre").val();
					var financingTime=$("#financingTime").val();
					var financingDescribe=$("#financingDescribe").val();
					var financingSub=$('#roundFinancing li.selected').attr("data-id");
					var params = ['financingId='+financingId+'','financingRe='+financingRe+'','financingName='+financingName+'','financingAmount='+financingAmount+'','financingCost='+financingCost+'','financingPre='+financingPre+'','financingTime='+financingTime+'','financingDescribe='+financingDescribe+'','financingSub='+financingSub+''];
					//金额正则表达式
					var regex = /^\d+\.?\d{0,2}$/;
					if(financingSub==null || financingSub=="" || financingSub.length==0){
						alert("融资轮次不能为空！");
						return false;
					}
					if(financingName=="" || financingName.length==0){
						alert("融资企业名称不能为空！");
						return false;
					}
					if(financingAmount=="" || financingAmount.length==0){
						alert("融资金额不能为空！");
						return false;
					}
					if(!regex.test(financingAmount)){
						alert("融资金额格式不正确！");
						return false;
					}
					if(financingCost=="" || financingCost.length==0){
						alert("融资估值不能为空！");
						return false;
					}
					if(!regex.test(financingCost)){
						alert("融资估值格式不正确！");
						return false;
					}
					if(financingPre=="" || financingPre.length==0){
						alert("可持股份不能为空！");
						return false;
					}
					if(!regex.test(financingPre)){
						alert("可持股份格式不正确！");
						return false;
					}
					if(financingTime=="" || financingTime.length==0){
						alert("融资时间不能为空！");
						return false;
					}
					if(financingDescribe=="" || financingDescribe.length==0){
						alert("融资描述不能为空！");
						return false;
					}
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/informationFinancingManager/saveInformationFinancing.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								alert("保存成功");
								$("#financingName").val();
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
				
				$("#moreul").slideDown("slow");
			  	$("#moreul > li:eq(1)").addClass("active");
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
	    			<input id="financingId" name="financingId" style="display:none;" type="text">
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
                        <div class="rongzi_je">
		                    <div class="qiye_rzje">融资企业名称</div>
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