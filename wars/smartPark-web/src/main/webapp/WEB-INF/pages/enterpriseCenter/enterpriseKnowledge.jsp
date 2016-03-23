<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業融资</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
    		<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
    			<div class="main-wrapper-right">
        			<div class="main-title"><span>媒体报道</span></div>
			        <div class="qiye_fm">
			            <div class="qiye_text"><span>专利图片</span></div>
			            <div>
			                <div class="img_upload"><img src="../styles/images/qiye/img_none.png"><br><p>图片未上传</p></div>
			                    <div class="upload_main">            	
			                        <div class="fengmian_pic"><img src="../styles/images/qiye/add_fmpic.png"></div>
			                        <div class="upload_input_fm1"><input type="file"></div>
			                    </div>
			                </div>
			            </div>
			            <div class="xiangxi_baodao">
			                <div class="qiye_fullname ">
			                    <div class="qiye_nametex">专利名称</div>
			                    <div class="name_input"><input type="text"></div>
			                </div>
			        	<div class="qiye_jianjie ">
			                <div class="qiye_word">专利描述</div>
			               	<div class="word_input">
			                    <textarea></textarea>
			                	<div class="font_xianzhi">字数限制：0/200</div>
			            	</div>
			            </div>
			            <div class="meiti_save_btn"><input type="submit" value="保存" class="hhf-submit" style="height:40px;" /></div>           
			            <div class="main-title"><span>专利&nbsp;/&nbsp;知识产权列表</span></div>
						<div class="baodao_list zuanli">
		                	<ul>
		                        <li>
		                            <div class="mt_list">
		                                <div class="list_pic"><img src="../styles/images/qiye/qiye_zheng.png"></div>
		                                <div class="list_tex">                               	
		                                    <table>
		                                        <tr>
		                                            <td colspan="2" height="40" valign="middle" align="left"><a class="tit">我的专利名称</a></td>
		                                        </tr>
		                                        <tr>
		                                            <td colspan="2" height="42" valign="top" align="left"><span class="baodao_main">神州知识产权15年只做一件事，为企业提供全方位的知识产权服务，为企业的发展保驾护航。因为专注，所以专业。公司具有强大的行政资源和专业优势，对于查询很难审批通过的商标或者已经驳回的商标，可以给出专业的建议方案，保证商标可以注册成功。</span></td>
		                                        </tr>                                       
		                                        <tr>
		                                            <td height="40" valign="middle" align="left"><a href="javascript:void(0);"><span>编辑</span></a>丨<a href="javascript:void(0);">删除</a></td>
		                                        </tr>
		                                    </table>
		                                </div>
		                            </div>
		                        </li>
		                        <li>
		                            <div class="mt_list">
		                                <div class="list_pic"><img src="../styles/images/qiye/qiye_zheng.png"></div>
		                                <div class="list_tex">                               	
		                                    <table>
		                                        <tr>
		                                            <td colspan="2" height="40" valign="middle" align="left"><a class="tit">我的专利名称</a></td>
		                                        </tr>
		                                        <tr>
		                                            <td colspan="2" height="42" valign="top" align="left"><span class="baodao_main">神州知识产权15年只做一件事，为企业提供全方位的知识产权服务，为企业的发展保驾护航。因为专注，所以专业。公司具有强大的行政资源和专业优势，对于查询很难审批通过的商标或者已经驳回的商标，可以给出专业的建议方案，保证商标可以注册成功。</span></td>
		                                        </tr>                                        
		                                        <tr>
		                                            <td height="40" valign="middle" align="left"><a href="javascript:void(0);"><span>编辑</span></a>丨<a href="javascript:void(0);">删除</a></td>
		                                            <td height="40" valign="middle" align="right"></td>
		                                        </tr>
		                                    </table>
		                                </div>
		                            </div>
		                        </li>                   
		                    </ul>
		                </div>
		            </div>
		        </div>    
		    </div>
		</div>
	</body>
</html>