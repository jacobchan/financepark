<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业通讯录</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<script type="text/javascript">
			$(document).ready(function() {
				var height = Math.max((document.documentElement.clientHeight -135), ($(".main-wrapper").height()));
				document.getElementById('main-wrapper-right').style.height=height+'px';
				
				$(".order-nav li").click(function(){
					$(this).addClass("active").siblings().removeClass("active");
					$(".clearfix-box").hide();
					$(".clearfix-box").eq($(this).index()).show();
				});
				
			  	$.ajax({
					url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
					success:function(result){
						if(result&&result.record){
							$("#financingRe").html(result.record.companyId);
							$.ajax({
								url:baseUrl+'/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
								data : ['rzId='+result.record.companyId].join('&'),
								success:function(result){
									if(result&&result.record){
										
									}
								}
							});
						}
					}
				});
			});
		</script>
	</head>
	<body class="page-header-fixed" style="background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
		    <div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right" id="main-wrapper-right">
		        	<div class="main-title"><span>订单中心</span></div>
		            <div class="dingdan_main">
		                <div class="clearfix mt20">
		                    <ul class="order-nav">
		                        <li class="active">全部订单</li>
		                        <li>待付款</li>
		                        <li>待收货</li>
		                        <li>待评价</li>
		                    </ul>
		                </div>
		                <div class="clearfix-box">
                            <div class="clearfix">
                                <div class="gr-table-box">
                                    <div class="gtb-thead"><span>订单信息</span><span>2016年1月13日17:35:14</span><span>订单号：11755289026</span></div>
                                    <table class="sug-table">
                                        <colgroup>
                                            <col width="80"></col>
                                            <col width="300"></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                        </colgroup>
                                        <tbody>
                                            <tr>
                                                <td><img src="../styles/images/qiye/sl-i1.png" border="0" width="60" height="60"/></td>
                                                <td class="tl"><a>[小熊（Bear）电热饭盒 加热保温饭盒 双层密封</a></td>
                                                <td>900元/台</td>
                                                <td class="right_line">x2</td>
                                                <td class="right_line"><img src="../styles/images/qiye/sl-i2.png" width="40" height="40"><br><span class="mt10" style="display:block">陈先生</span></td>
                                                <td class="right_line">总额&nbsp;<i class="fa fa-jpy"></i>&nbsp;158.00<br><span class="mt30" style="display:block">在线支付</span></td>
                                                <td class="tr">
                                                <span><a href="javascript:void(0);">待付款</a></span><br>
                                                <span class="mt10 mb10" style="display:block"><a href="javascript:void(0);">订单详情</a></span>
                                                <span><a href="javascript:void(0);">取消</a></span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>   
                            </div>	
                        </div>
                        <div class="clearfix-box" style="display:none;">                           
                            <div class="clearfix">                                 
                                <div class="gr-table-box">
                                    <div class="gtb-thead"><span>订单信息</span><span>2016年1月13日17:35:14</span><span>订单号：11755289026</span></div>
                                    <table class="sug-table">
                                        <colgroup>
                                            <col width="80"></col>
                                            <col width="300"></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                        </colgroup>
                                        <tbody>
                                            <tr> 
                                                <td><img src="../styles/images/qiye/sl-i1.png" border="0" width="60" height="60"/></td>
                                                <td class="tl"><a>[小熊（Bear）电热饭盒 加热保温饭盒 双层密封</a></td>
                                                <td>900元/台</td>
                                                <td class="right_line">x3</td>
                                                <td class="right_line"><img src="../styles/images/qiye/sl-i2.png" width="40" height="40"><br><span class="mt10" style="display:block">陈先生</span></td>
                                                <td class="right_line">总额&nbsp;<i class="fa fa-jpy"></i>&nbsp;237.00<br><span class="mt30" style="display:block">在线支付</span></td>
                                                <td class="tr">
                                                <span><a href="javascript:void(0);">待付款</a></span><br>
                                                <span class="mt10 mb10" style="display:block"><a href="javascript:void(0);">订单详情</a></span>
                                                <span><a href="javascript:void(0);">取消</a></span></td>
                                            </tr>
                                        </tbody>
                                   </table> 
                                </div>    
                            </div>	
                        </div>
                        <div class="clearfix-box" style="display:none;">                           
                            <div class="clearfix">                                 
                                <div class="gr-table-box">
                                    <div class="gtb-thead"><span>订单信息</span><span>2016年1月13日17:35:14</span><span>订单号：11755289026</span></div>
                                   	<table class="sug-table">
                                        <colgroup>
                                            <col width="80"></col>
                                            <col width="300"></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                        </colgroup>
                                        <tbody>
                                            <tr>
                                                <td><img src="../styles/images/qiye/sl-i1.png" border="0" width="60" height="60"/></td>
                                                <td class="tl"><a>[小熊（Bear）电热饭盒 加热保温饭盒 双层密封</a></td>
                                                <td>900元/台</td>
                                                <td class="right_line">x1</td>
                                                <td class="right_line"><img src="../styles/images/qiye/sl-i2.png" width="40" height="40"><br><span class="mt10" style="display:block">陈先生</span></td>
                                                <td class="right_line">总额&nbsp;<i class="fa fa-jpy"></i>&nbsp;179.00<br><span class="mt30" style="display:block">在线支付</span></td>
                                                <td class="tr">
                                                <span><a href="javascript:void(0);">待收货</a></span><br>
                                                <span class="mt10 mb10" style="display:block"><a href="javascript:void(0);">订单详情</a></span>
                                                <span><a href="javascript:void(0);">退货</a></span></td>
                                            </tr>
                                        </tbody>
                                   </table>
                                </div>    
                            </div>	
                        </div>
                        <div class="clearfix-box" style="display:none;">                           
                            <div class="clearfix">                                 
                                <div class="gr-table-box">
                                    <div class="gtb-thead"><span>订单信息</span><span>2016年1月13日17:35:14</span><span>订单号：11755289026</span></div>
                                    <table class="sug-table">
                                        <colgroup>
                                            <col width="80"></col>
                                            <col width="300"></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                            <col></col>
                                        </colgroup>
                                        <tbody>
                                            <tr>                                               
                                                <td><img src="../styles/images/qiye/sl-i1.png" border="0" width="60" height="60"/></td>
                                                <td class="tl"><a>[小熊（Bear）电热饭盒 加热保温饭盒 双层密封</a></td>
                                                <td>900元/台</td>
                                                <td class="right_line">x4</td>
                                                <td class="right_line"><img src="../styles/images/qiye/sl-i2.png" width="40" height="40"><br><span class="mt10" style="display:block">陈先生</span></td>
                                                <td class="right_line">总额&nbsp;<i class="fa fa-jpy"></i>&nbsp;316.00<br><span class="mt10" style="display:block">在线支付</span></td>
                                                <td class="tr">
                                                <span><a href="javascript:void(0);">待评价</a></span><br>
                                                <span class="mt10 mb10" style="display:block"><a href="javascript:void(0);">订单详情</a></span>
                                                <span><a href="javascript:void(0);">评价晒单</a></span></td>
                                            </tr>
                                        </tbody>
                                   </table> 
                                </div>    
                            </div>	
                        </div>
            		</div>
        		</div>    
    		</div>
		</div>
	</body>
</html>