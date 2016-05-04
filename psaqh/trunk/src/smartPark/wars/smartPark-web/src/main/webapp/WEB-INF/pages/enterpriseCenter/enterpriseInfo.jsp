<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业信息</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/styles/page/zs.css">
		<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/ztree/css/demo.css" type="text/css"> --%>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/ztree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ztree/js/jquery.ztree.excheck.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/enterpriseCenter/enterpriseInfo.js"></script>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">    
		    <div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
		    	<div class="main-wrapper-right">
		        	<div class="main-title"><span>企业资料修改</span></div>
		        	<span class="" id="financingRe" style="display:none;"></span>
		            <div class="qiye_logo">
		            	<div class="qiye_text"><span>企业logo</span></div>
		                <div class="upload_main">
		                	<div class="photoedit" style="float: left;">
								<img id="headImg" src="" width="168" height="168"/>
							</div>
		                    <div class="photo-edit" id="destination" style="width:168px;height:168px;float: left;">
							    <input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
							    <p>编辑 图像</p>
								<p class="f12" style="font-family:微软雅黑; ">图片大小建议：288*195</p>
							</div>
		            	</div>
		            </div>
		            <div class="xiangxi_xinxi">
		                <div class="qiye_fullname">
		                    <div class="qiye_nametex">企业全称</div>
		                    <div class="name_input"><input id="rzName" name="rzName" type="text" value=""></div>
		                </div>
		                <div class="qiye_web">
		                    <div class="qiye_webtex">官方网站</div>
		                    <div class="web_input"><input id="rzUrl" name="rzUrl" type="text" value=""></div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">所在行业</div>
		                    <div id="qiye_enType" class="tct-select fl mr20" style="width: 125px;">
		                    	<div class="ic-select">
									<p class="c-b1" id="enTypeName" ></p>
									<input id="enTypeId" style="display:none;" value=""/>
								</div>
								<ul id="enTypeNamesing" style="display: none;" class="select-nav"></ul>
							</div>
                		</div>
                		<div class="qiye_address">
		                    <div class="qiye_word">地址</div>
	                    	<div id="qiye_address" class="tct-select fl mr20" >
		                    	<div class="ic-select">
									<p class="c-b1" id="roomAddress" ></p>
									<input id="roomId" style="display:none;" value=""/>
								</div>
								<ul id="roomAddressing" style="display: none;" class="select-nav"></ul>
							</div>
		                </div>
                		<div class="qiye_jianjie ">
		                    <div class="qiye_word">公司介绍</div>
		                    <div class="word_input">
		                        <textarea id="rzRemark" name="rzRemark" ></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;"></span>/200</div>
		                    </div>
		                </div>
            		</div>
            	
	           		<div class="jiesao_word">
		                <div class="qiye_ms">
		                	<div class="qiye_miaoshu"><span>产品描述</span></div>
		                    <div class="edit_tool">
		                    	<textarea id="editorproductDiscriptio" name="productDiscriptio" cols="20" rows="5" class="ckeditor" ></textarea>
		                    </div>
		                </div>
					</div>
	           		<div class="qiye_photo">
		                <div class="qiye_xc">
		                    <div class="qiye_xiangce"><span>企业相册</span></div>
		                    <div class="photo_list">
			                    <div class="photoedit" id="qiye_photoedit" style="float: left;">
			                    	<img id="qiyeheadImg">
									<div class="photo-edit" style="width:220px;height:168px;margin-bottom: 50px;margin-left: 0px;">
									    <img style="height:168px; vertical-align:middle;border:0 none;" src="<%=request.getContextPath()%>/styles/images/qiye/add.png">
	                                    <input type="file" id="qiye_xiangce" name="qiye_xiangce" draggable="true" accept=".png,.jpg"/>
									</div>
								</div>
			                    
		                       <%--  <ul>
		                            <li>
		                                <div style="position:relative">
		                                    <div class="overlay"></div>
		                                    <img id="qiyeheadImg" src="<%=request.getContextPath()%>/common/uploadImage.html?repository=/swfupload&path=${qiyeheadImg }&method=show" width="168" height="168"/>                                        
		                                </div>
		                            </li>
		                            <li>
		                                <div style="position:relative">
		                                    <img src="<%=request.getContextPath()%>/styles/images/qiye/add.png">
		                                    <div class="upload_pic">
		                                    	<input type="file" id="qiye_xiangce" name="qiye_xiangce" draggable="true" accept=".png,.jpg"/>
		                                    </div>
		                                </div>
		                            </li>
	                        	</ul> --%>
	                         	<div class="photo_btn">
	                            	<div class="save_btn"><a>保存</a></div>
	                            	<!-- <div class="quxiao_btn"><a>取消</a></div> -->
	                        	</div>
	                		</div>
	           			</div>
	        		</div>    
	    			</div>
    		</div>
		</div>
		<!-- 行业类型下拉 -->
		<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="treeDemo" class="ztree" style="margin-top:0; width:285px; height: 300px;"></ul>
		</div>
		<!-- 单元地址下拉 -->
		<div id="roomContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="treeRoom" class="ztree" style="margin-top:0; width:285px; height: 200px;"></ul>
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
		var qiyeuploader = new plupload.Uploader({
			runtimes : 'html5,flash,silverlight',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
			browse_button : 'qiye_xiangce',
			flash_swf_url : '../../scripts/fileUpload/Moxie.swf',
			silverlight_xap_url : '../../scripts/fileUpload/Moxie.xap',
			url : cenUrl+'fileUpload/goUpload.html',//上传文件路径
			max_file_size : '2048kb', //最大只能上传2048kb的文件
			prevent_duplicates : true, //不允许选取重复文件
			//此处是控制上传组件是否允许多文件选择还是单文件选择：true/多文件；false/单文件
			multi_selection: true,
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
					for(var i = 0, len = files.length; i<len; i++){
						//构造html来更新UI，显示文件的名字（可根据自己的业务修改）
						var html = '<img id="qiyeheadImg-'+files[i].id+'" src="" width="220" height="168"/>';				
						$('#qiyeheadImg').after(html);
						!function(i){
							//此处用户图片的回显（可根据自己的业务修改）
							previewImage(files[i],function(imgsrc){
								/* $('#qiyeheadImg-'+files[i].id).append('<img src="'+ imgsrc +'" />'); */
								$('#qiyeheadImg-'+files[i].id).attr("src",imgsrc);
							});
					    }(i);
					};
				}
			}
		});

		qiyeuploader.init();

		//图片回显预览
		function previewQiyeImage(file, callback) {//file为plupload事件监听函数参数中的file对象,callback为预览图片准备完成的回调函数
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
						$("#headImg").attr("src",imgsrc);
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