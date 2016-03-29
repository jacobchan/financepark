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
		        	<div class="main-title"><span>企业通讯录管理</span></div>
		            <div class="phone_book">
		            	<div class="total_p color_orange">通讯录共有&nbsp;88&nbsp;人</div>
		                <div class="search_name"><input type="text" placeholder="姓名搜索"></div>
		                <div class="search_ipt"><a href="javascript:void(0);">搜索</a></div>
		                <div class="show_all"><a href="javascript:void(0);">显示全部</a></div>
		                <div class="upload_out"><a href="javascript:void(0);">导出到Excel</a></div>
		            </div>
		            <div class="phone_no">
		            	<ul>
		                    <li>
								<table>
		                            <tr>
		                                <td rowspan="4" width="110"><img src="../styles/../styles/images/qiye/qiye/user-photo.png"></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20 hide_dian"><span class="f16 color_41 user_name">雷布斯</span><span class="f14 color_6 tel">联系方式：12345678966</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f14 color_6 hide_dian">如若明知水瓶座最爱是流泪，若然道别是下一次如若明知水瓶座最爱是流泪，若然道别是下一次</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f12 color_41"><a href="javascript:void(0);">编辑</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">设置权限</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">删除</a></span></td>
		                            </tr>
		                        </table>
		                    </li>
		                    <li>
								<table>
		                            <tr>
		                                <td rowspan="4" width="110"><img src="../styles/images/qiye/user-photo.png"></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20 hide_dian"><span class="f16 color_41 user_name">雷布斯</span><span class="f14 color_6 tel">联系方式：12345678966</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f14 color_6 hide_dian">如若明知水瓶座最爱是流泪，若然道别是下一次如若明知水瓶座最爱是流泪，若然道别是下一次</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f12 color_41"><a href="javascript:void(0);">编辑</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">设置权限</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">删除</a></span></td>
		                            </tr>
		                        </table>
		                    </li>
		                    <li>
								<table>
		                            <tr>
		                                <td rowspan="4" width="110"><img src="../styles/images/qiye/user-photo.png"></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20 hide_dian"><span class="f16 color_41 user_name">雷布斯</span><span class="f14 color_6 tel">联系方式：12345678966</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f14 color_6 hide_dian">如若明知水瓶座最爱是流泪，若然道别是下一次如若明知水瓶座最爱是流泪，若然道别是下一次</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f12 color_41"><a href="javascript:void(0);">编辑</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">设置权限</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">删除</a></span></td>
		                            </tr>
		                        </table>
		                    </li>
		                    <li>
								<table>
		                            <tr>
		                                <td rowspan="4" width="110"><img src="../styles/images/qiye/user-photo.png"></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20 hide_dian"><span class="f16 color_41 user_name">雷布斯</span><span class="f14 color_6 tel">联系方式：12345678966</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f14 color_6 hide_dian">如若明知水瓶座最爱是流泪，若然道别是下一次如若明知水瓶座最爱是流泪，若然道别是下一次</span></td>
		                            </tr>
		                            <tr>
		                                <td align="left" valign="middle" class="pl20"><span class="f12 color_41"><a href="javascript:void(0);">编辑</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">设置权限</a>&nbsp;丨&nbsp;<a href="javascript:void(0);">删除</a></span></td>
		                            </tr>
		                        </table>
		                    </li>
		                </ul>
		                <div class="fr page-list-a clearfix lh30 mt20 f12 mb30">
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
		    </div>
		</div>
	</body>
</html>