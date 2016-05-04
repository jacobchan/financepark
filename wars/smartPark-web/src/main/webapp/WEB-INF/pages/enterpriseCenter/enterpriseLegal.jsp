<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业法人</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/ztree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ztree/js/jquery.ztree.excheck.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/enterpriseCenter/enterpriseLegal.js"></script>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
			<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right" id="main-wrapper-right">
		        	<div class="main-title"><span>企业创始人</span></div>
		            <div class="qiye_header-img clearfix">
		            	<div class="qiye_text"><span>头像</span></div>
		                <div class="upload_main">
		                	<span id="legalRe" class=""  style="display:none;"></span>
		                    <img id="legalImage" src="../styles/images/qiye/user-photo.png" border="0" class="fl" width="107" height="107"/>
							<div class="photo-edit">
								<input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
								编辑<br/>头像
							</div>
		            	</div>
		            </div>
		            <div class="csr_xinxi clearfix">
		                <div class="qiye_fullname clearfix">
		                	<input id="legalId" name="legalId" type="text" style="display:none;" />
		                    <div class="qiye_nametex">姓名</div>
		                    <div class="name_input"><input id="legalName" name="legalName" type="text"></div>
		                </div>
		                <div class="born_time clearfix">
		                    <div class="born_date">出生日期</div>
		                    <div class="born_input"><input id="legalBirthday" name="legalBirthday" readonly="readonly" placeholder="请选择出生日期" class="laydate-icon" type="text"></div>
		                </div>
		                <div class="born_time clearfix">
		                    <div class="born_date">手机号码</div>
		                    <div class="born_input"><input id="legalTelephone" name="legalTelephone" type="text"></div>
		                </div>
		                <div class="born_time clearfix">
		                    <div class="born_date">职位</div>
		                    <div class="born_input"><input id="legalBusiness" name="legalBusiness" type="text"></div>
		                </div>
		                <div class="qiye_jianjie clearfix">
		                    <div class="qiye_word">专利描述</div>
		                    <div class="word_input">
		                        <textarea id="legalRemark" name="legalRemark"></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/256</div>
		                    </div>
		                </div>
		                <div class="meiti_save_btn"><div class="save_btn"><a>保存</a></div></div>
		            </div>
		        </div>     
		    </div>
		</div>
		<!-- 弹出层样式 -->
		<div class="toast">
		    <div class="toast-con clearfix">
		        <div class="close-toast fr"></div>
		        <p class="tc mt25 f18" id="toast_text" style="color:#ff6715">请登录后重试！</p>
		    </div>
		</div>
	</body>
	<script type="text/javascript">
		var uploader = new plupload.Uploader({
			runtimes : 'html5,flash,silverlight',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
			browse_button : 'imgUpload',
			flash_swf_url : '../../scripts/fileUpload/Moxie.swf',
			silverlight_xap_url : '../../scripts/fileUpload/Moxie.xap',
			url : cenUrl+'fileUpload/goUpload.html',//上传文件路径
			max_file_size : '2048kb', //最大只能上传2048kb的文件
			prevent_duplicates : true, //不允许选取重复文件
			//此处是控制上传组件是否允许多文件选择还是单文件选择：true/多文件；false/单文件
			multi_selection: false,
			//给后台传入参数
			multipart_params: {
				//上传标识 0：图片上传;1：文件上传
				fileFlg:"0"
			},
			filters : [ {
				title : 'Image files',
				extensions : 'jpg,gif,png'
			} ],
			init : {
				FilesAdded : function(up, files) {
					//此处用户图片的回显（可根据自己的业务修改）
					previewImage(files[0], function(imgsrc) {
						$("#legalImage").attr("src",imgsrc);
					});
				}
			}
		});

		uploader.init();

		//图片回显预览
		function previewImage(file, callback) {//file为plupload事件监听函数参数中的file对象,callback为预览图片准备完成的回调函数
			if (!file || !/image\//.test(file.type))
				return; //确保文件是图片
			if (file.type == 'image/gif') {//gif使用FileReader进行预览,因为mOxie.Image只支持jpg和png
				var fr = new mOxie.FileReader();
				fr.onload = function() {
					callback(fr.result);
					fr.destroy();
					fr = null;
				}
				fr.readAsDataURL(file.getSource());
			} else {
				var preloader = new mOxie.Image();
				preloader.onload = function() {
					var imgsrc = preloader.type == 'image/jpeg' ? preloader
							.getAsDataURL('image/jpeg', 80) : preloader
							.getAsDataURL(); //得到图片src,实质为一个base64编码的数据
					callback && callback(imgsrc); //callback传入的参数为预览图片的url
					preloader.destroy();
					preloader = null;
				};
				preloader.load(file.getSource());
			}
		}
	</script>
</html>