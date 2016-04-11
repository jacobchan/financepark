<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企业信息</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/ztree/css/demo.css" type="text/css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/ztree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ztree/js/jquery.ztree.excheck.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
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
			var zNodes = "";
			var roomNodes = "";
			var setting = {
				check: {
					enable: true,
					chkStyle: "radio",
					radioType: "all"
				},
				view: {
					dblClickExpand: false
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onClick: onClick,
					onCheck: onCheck
				}
			};
			var rooms = {
				check: {
					enable: true,
					chkStyle: "radio",
					radioType: "all"
				},
				view: {
					dblClickExpand: false
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onClick: roomClick,
					onCheck: roomCheck
				}
			};
			function onClick(e, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.checkNode(treeNode, !treeNode.checked, null, true);
				return false;
			}
			function onCheck(e, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				var nodes = zTree.getCheckedNodes(true);
				var v = "";
				var m = "";
				for (var i=0, l=nodes.length; i<l; i++) {
					v += nodes[i].id + ",";
					m += nodes[i].name + ",";
				}
				if (v.length > 0 ) v = v.substring(0, v.length-1);
				if (m.length > 0 ) m = m.substring(0, m.length-1);
				$("#enTypeId").val(v);
				$("#enTypeName").val(m);
			}
			function roomClick(e, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("treeRoom");
				zTree.checkNode(treeNode, !treeNode.checked, null, true);
				return false;
			}
			function roomCheck(e, treeId, treeNode) {
				var roomTree = $.fn.zTree.getZTreeObj("treeRoom");
				var nodesRoom = roomTree.getCheckedNodes(true);
				var k = "";
				var n = "";
				for (var j=0, l=nodesRoom.length; j<l; j++) {
					k += nodesRoom[j].id + ",";
					n += nodesRoom[j].name + ",";
				}
				if (k.length > 0 ) k = k.substring(0, k.length-1);
				if (n.length > 0 ) n = n.substring(0, n.length-1);
				$("#roomId").val(k);
				$("#roomAddress").val(n);
			}
			function showMenu() {
				var cityObj = $("#enTypeName");
				var cityOffset = $("#enTypeName").offset();
				$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
				$("body").bind("mousedown", onBodyDown);
			}
			function showRoom() {
				var roomObj = $("#roomAddress");
				var roomOffset = $("#roomAddress").offset();
				$("#roomContent").css({left:roomOffset.left + "px", top:roomOffset.top + roomObj.outerHeight() + "px"}).slideDown("fast");
				$("body").bind("mousedown", onBodyRoom);
			}
			function hideMenu() {
				$("#menuContent").fadeOut("fast");
				$("body").unbind("mousedown", onBodyDown);
			}
			function hideRoom() {
				$("#roomContent").fadeOut("fast");
				$("body").unbind("mousedown", onBodyRoom);
			}
			function dataJson(data) {
				zNodes = eval("[" + data + "]");
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
			function roomJson(data) {
				roomNodes = eval("[" + data + "]");
				$.fn.zTree.init($("#treeRoom"), rooms, roomNodes);
			}
			function onBodyDown(event) {
				if (!(event.target.id == "menuBtn" || event.target.id == "enTypeName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
					hideMenu();
				}
			}
			function onBodyRoom(event) {
				if (!(event.target.id == "menuBtn" || event.target.id == "roomAddress" || event.target.id == "roomContent" || $(event.target).parents("#roomContent").length>0)) {
					hideRoom();
				}
			}
			$(document).ready(function() {
				$.ajax({
					url:baseUrl+'/etypeEnterprisetypeManager/findEnterpriseTypeTree.json',
					success:function(result){
						dataJson(result.record.html);
					}
				});	
			  	var editor = CKEDITOR.replace('editorproductDiscriptio');
			  	editor.updateElement();
				$("#rzRemark").on('keyup', function() {
				    var len = getStrLength(this.value);
				    $("#currentCount").html(len);
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
										//$("#rzLogo").attr("src","http://localhost:9088/filestore/"+result.record.rzLogo);
										$("#financingRe").html(result.record.rzId);
										$("#rzName").val(result.record.rzName);
				    					$("#rzUrl").val(result.record.rzUrl);
				    					$("#rzRemark").val(result.record.rzRemark);
				    					$("#enTypeId").val(result.record.enTypeId.enTypeId);
				    					$("#enTypeName").val(result.record.enTypeId.enTypeName);
				    					$("#roomId").val(result.record.roomId.roomId);
				    					$("#roomAddress").val(result.record.roomId.roomAddress);
				    					$("#editorproductDiscriptio").val(result.record.productDiscriptio);
				    					editor.setData(result.record.productDiscriptio);
				    					$("#currentCount").html(getStrLength(result.record.rzRemark));
				    					
				    					$.ajax({
											url:baseUrl+'/bbmRoomManager/getRoomByRzId.json',
											data : ['rzId='+$("#financingRe").html()].join('&'),
											success:function(result){
												if(result&&result.record){
													roomJson(result.record.html);
												}
											}
				    					});
									}
								}
							});
						}
					}
				});
			  	$.ajax({
					url:baseUrl+'/bbmRoomManager/getBbmRooms.json',
					success:function(results){
						if (results && results.records) {
		    				var records = results.records;
		    				$("#roomId").find("option").remove();
		    				for(var i=0; i<records.length; i++){
		    					$("#roomId").append("<li value='"+records[i].roomId+"'>"+records[i].roomAdr+"</li>");
		    				}
						}
					}
				});
			  	$(".save_btn").click(function(){
			  		var rzId=$("#financingRe").html();
			  		var imgUpload=$("#headImg").attr("src");
			  		var roomId=$("#roomId").val();
			  		var rzName=$("#rzName").val();
					var rzUrl=$("#rzUrl").val();
					var enTypeId=$("#enTypeId").val();
					var rzRemark=$("#rzRemark").val();
					var rzLogo = $("#rzLogo").attr("src");
					var productDiscriptio=editor.getData();
					var params = ['rzId='+rzId+'','rzLogo='+rzLogo+'','roomId.roomId='+roomId+'','rzName='+rzName+'','rzRemark='+rzRemark+'','rzUrl='+rzUrl+'','enTypeId.enTypeId='+enTypeId+'','productDiscriptio='+productDiscriptio+'','rzLogo='+imgUpload+''];
					//url正则表达式
					var urlRegex = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
					if(rzName=="" || rzName.trim().length==0){
						alert("企业名称不能为空！");
						return false;
					}
					if(roomId=="" || roomId.trim().length==0){
						alert("地址不能为空！");
						return false;
					}
					if(rzUrl=="" || !urlRegex.test(rzUrl)){
						alert("网址输入错误！");
						return false;
					}
					if(enTypeId=="" || enTypeId.trim().length==0){
						alert("行业类型不能为空！");
						return false;
					}
					if(rzRemark=="" || rzRemark.trim().length==0){
						alert("公司介绍不能为空！");
						return false;
					}
					if(productDiscriptio=="" || productDiscriptio.trim().length==0){
						alert("产品描述不能为空！");
						return false;
					}
					$.youi.ajaxUtils.ajax({
						url:baseUrl+'/enterbusinessmanagerRzManager/updateEnterbusinessmanagerRz.json',
						data:params.join('&'),
						success:function(result){
							if(result && result.record){
								alert("保存成功");
								location.reload();
							}
						}
					});
				});
			  	$("#moreul").slideDown("slow");
			  	$("#moreul > li:eq(0)").addClass("active");
			});
		</script>
		<script type="text/javascript">
			var uploader = new plupload.Uploader({
				runtimes : 'html5,flash,silverlight',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
				browse_button : 'imgUpload',
				flash_swf_url : '../../scripts/fileUpload/Moxie.swf',
				silverlight_xap_url : '../../scripts/fileUpload/Moxie.xap',
				url : cenUrl+'fileUpload/goUpload.html',//上传文件路径
				max_file_size : '1024kb', //最大只能上传400kb的文件
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
		                    <div class="photo-edit" id="destination" style="width:168px;height:168px;margin-left:0px;">
							    <input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
							    <p>编辑 图像</p>
								<p class="f12">封面图片大小建议：288*195</p>
							</div>
							<div class="photoedit" style="left:22px;">
								<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png" width="168" height="168"/>
							</div>
		            	</div>
		            </div>
		            <div class="xiangxi_xinxi">
		                <div class="qiye_fullname">
		                    <div class="qiye_nametex">企业全称</div>
		                    <div class="name_input"><input id="rzName" name="rzName" type="text"></div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">地址</div>
		                    <div class="web_input">
		                        <input id="roomId" name="roomId.roomId" style="display:none;" />
                            	<input id="roomAddress" name="roomId.roomAddress" onclick="showRoom();" />
		                    </div>
		                </div>
		                <div class="qiye_web">
		                    <div class="qiye_webtex">官方网站</div>
		                    <div class="web_input"><input id="rzUrl" name="rzUrl" type="text"></div>
		                </div>
		                <div class="qiye_address">
		                    <div class="qiye_word">所在行业</div>
                            <div class="web_input">
                            	<input id="enTypeId" name="enTypeId.enTypeId" style="display:none;" />
                            	<input id="enTypeName" name="enTypeId.enTypeName" onclick="showMenu();" />
							</div>
                		</div>
                		<div class="qiye_jianjie ">
		                    <div class="qiye_word">公司介绍</div>
		                    <div class="word_input">
		                        <textarea id="rzRemark" name="rzRemark"></textarea>
		                        <div class="font_xianzhi">字数限制：<span id="currentCount" style="color:red;">0</span>/200</div>
		                    </div>
		                </div>
            		</div>
            	
	           		<div class="jiesao_word">
		                <div class="qiye_ms">
		                	<div class="qiye_miaoshu"><span>产品描述</span></div>
		                    <div class="edit_tool">
		                    	<textarea id="editorproductDiscriptio" name="productDiscriptio" cols="20" rows="5" class="ckeditor"></textarea>
		                    </div>
		                </div>
					</div>
	           		<div class="qiye_photo">
		                <div class="qiye_xc">
		                    <div class="qiye_xiangce"><span>企业相册</span></div>
		                    <div class="photo_list">
		                        <ul>
		                            <li>
		                                <div style="position:relative">
		                                    <div class="overlay"></div>
		                                    <img src="<%=request.getContextPath()%>/styles/images/qiye/photo_list1.png">                                        
		                                </div>
		                            </li>
		                            <li>
		                                <div style="position:relative">
		                                    <img src="<%=request.getContextPath()%>/styles/images/qiye/add.png">
		                                    <div class="upload_pic"><input type="file"></div>
		                                </div>
		                            </li>
	                        	</ul>
	                         	<div class="photo_btn">
	                            	<div class="save_btn"><a>保存</a></div>
	                            	<div class="quxiao_btn"><a>取消</a></div>
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
	</body>
</html>