<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="活动发布">
	<youi:body decorator="memcenter"> 
				<div class="w1000">
					<h3 class="per-h3"><!-- <a class="f14 c-333" href="">创智汇 / </a><a class="f14 c-333" href="">我发起的活动 / </a> -->发布新活动</h3>
					<div class="clearfix mt40">
						<div class="fb-activity">
							<ul class="clearfix" style="cursor: pointer;">
			            		<li class="active">活动内容</li>
			                	<li class="">活动文档</li>
			                	<li class="">场地选择</li>
			            	</ul>
						</div>
						<div class="clearfix">
							<div class="fb-list-box">
								<table>
									<colgroup>
										<col width="130"></col>
										<col></col>
									</colgroup>
									<tbody>
										<tr>
											<th>活动标题</th>
											<td><input type="text" id="applyTitle"></td>
										</tr>
										<tr>
											<th>活动时间</th>
											<td><input type="text" placeholder="请选择开始时间" id="startTime" class="laydate-icon"><span class="ml15 mr15">至</span><input type="text" placeholder="请选择结束时间" id="endTime" class="laydate-icon"></td>
										</tr>
										<tr>
											<th>截止报名时间</th>
											<td><input type="text" placeholder="请选择截止报名时间" id="enddate" class="laydate-icon"></td>
										</tr>
										<tr>
											<th>活动人数限制</th>
											<td><input type="text" id="applyMaxuser"></td>
										</tr>
										<tr>
											<th>活动封面</th>
											<td>
												 <div class="photo-edit" id="destination" style="width:200px;height:200px;margin-left:0px;">
							    					<input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
							    					<p>编辑 <span class="ml10">封面</span></p>
													<p class="f12">封面图片大小建议：288*195</p>
												</div>
												<div class="photoedit" style="left:22px">
													<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png"  width="200" height="200"/>
											</div>		
											</td>
										</tr>
										<tr>
											<th>活动地点</th>
											<td><input type="text" id="activityAdr"></td>
										</tr>
										<tr>
											<th>活动内容</th>
											<td><textarea id="editorproductDiscriptio" name="editorproductDiscriptio" cols="20" rows="5" class="ckeditor"></textarea></td>
										</tr>
										<tr>
											<td></td>
											<td><a href="javascript:;" class="ib-btn next-step" style="padding:0px 40px;">下一步</a></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="fb-list-box undis">
								<table>
									<colgroup>
										<col width="130"></col>
										<col></col>
									</colgroup>
									<tbody>
										<tr>
											<th>文档标题</th>
											<td><input type="text"></td>
										</tr>
										<tr>
											<th>文档上传</th>
											<td>
												<div class="photo-edit" style="width:200px;height:140px;padding:45px 10px;margin-left:0px;">
													<input type="file">
													<p style="letter-spacing:10px">点击上传</p>
												</div>
											</td>
										</tr>
										<tr>
											<th>文档列表</th>
											<td></td>
										</tr>
										<tr>
											<!-- <td colspan="2">
												<div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                           <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                            <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                            <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
					                            <div class="gr-czh-list">
					                                <img src="../styles/images/czh/list-5.jpg" height="114" width="202">
					                                <h3><a href="" class="c-333">孩子不宜过早玩的10种运动</a></h3>
					                                <p class="f12 mb5"><a href="javascript:;" class="c-b1 ml5 mr10">编辑</a> <a href="javascript:;" class="c-b1">删除</a></p>
					                            </div>
											</td> -->
										</tr>
									</tbody>
								</table>
								<a href="javascript:;" class="ib-btn tc  ml15 mr20 prev-step mb30" style="width:110px;">上一步</a>
								<a href="javascript:;" class="ib-btn next-step tc mb30" style="width:110px;">下一步</a>
							</div>
							<div class="fb-list-box undis">
								<table class="flb-table mt30 c-b1 f12 tc"  width="100%">
								<div class="per-h3" style="padding-bottom:0px;border-bottom: 0px;"><a href="javascript:;" class="fr c-333 f14" id="a1"><i class="fa fa-plus-square fl mr10"></i>新增场地</a></div>
									<colgroup>
										<col width="60"></col>
										<col width="23.5%"></col>
										<col width="23.5%"></col>
										<col width="23.5%"></col>
										<col></col>
									</colgroup>
									<tbody class="activeroom">
										<!-- <tr align="center" class="f14 c-333">
											<td colspan="2">地点</td>
											<td>时间</td>
											<td>价格</td>
											<td>操作</td>
										</tr>
										<tr>
											<td><input type="checkbox"></td>
											<td align="left">创智中心2号楼302</td>
											<td>2016-03-12 08:00 - 18:00</td>
											<td>588</td>
											<td><a href="" class="c-333">查看场地详情</a></td>
										</tr>
										<tr>
											<td><input type="checkbox"></td>
											<td align="left">创智中心2号楼302</td>
											<td>2016-03-12 08:00 - 18:00</td>
											<td>588</td>
											<td><a href="" class="c-333">查看场地详情</a></td>
										</tr>
										<tr>
											<td><input type="checkbox"></td>
											<td align="left">创智中心2号楼302</td>
											<td>2016-03-12 08:00 - 18:00</td>
											<td>588</td>
											<td><a href="" class="c-333">查看场地详情</a></td>
										</tr> -->
									</tbody>
								</table>
								<a href="javascript:;" class="ib-btn tc ml20 mr30 mb30" style="width:110px;" id="submit">保存</a>
								<a href="javascript:;" class="ib-btn tc prev-step mb30" style="width:110px;">上一步</a>
							</div>
						</div>
						
                    </div>  
				</div>
				
			</youi:body>
			<div class="toast">
		        	<div class="toast-con clearfix">
		            	<div class="close-toast fr"></div>
		           	 <p class="tc mt25 f18" style="color:#ff6715">请登录后重试！</p>
		        	</div>       
   			</div>
	<!--***bottom start****************************************-->
	<!--***bottom end****************************************-->
	<script type="text/javascript">
	$(function () {
		$("#submit").click(function(){
			var applyTitle = $("#applyTitle").val();
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			var deadline=$("#enddate").val();
			var applyMaxuser=$("#applyMaxuser").val();
			var imgUpload=$("#headImg").attr("src");
			var activityAdr = $("#activityAdr").val();
			var applyOrderNumber = $('input[name="com"]:checked').attr("id");
			var commentContent = editor.getData();
			if(applyTitle==''||applyTitle==null){
				clearInterval(timer);
				$(".tc.mt25").text("请输入活动标题！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}
			if(startTime==''||startTime==null){
				clearInterval(timer);
				$(".tc.mt25").text("请输入活动开始时间！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}
			if(endTime==''||endTime==null){
				clearInterval(timer);
				$(".tc.mt25").text("请输入活动开始时间！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}
			if(deadline==''||deadline==null){
				clearInterval(timer);
				$(".tc.mt25").text("请输入报名结束时间！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}
			if(applyMaxuser==''||applyMaxuser==null){
				clearInterval(timer);
				$(".tc.mt25").text("活动人数限制！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}else{
				var reg = /^[1-9]\d*$/;     
				if(!reg.test(applyMaxuser)){
					clearInterval(timer);
					$(".tc.mt25").text("请输入正确数字！");
	           		$(".toast").show();
	           		pltime=1;
	           		timer=setInterval("closeTanc()",1000);
	           		return false;
				}
			}
			if(activityAdr==''||activityAdr==null){
				clearInterval(timer);
				$(".tc.mt25").text("请输入活动地址！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}
			if(applyOrderNumber==''||applyOrderNumber==null){
				clearInterval(timer);
				$(".tc.mt25").text("请选择活动场地！");
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",1000);
           		return false;
			}
			//检查是否有选择头像图片
			var fileCount = uploader.files.length;
			//alert(fileCount);
			if(fileCount>0){
				//调用实例对象的start()方法开始上传文件，当然你也可以在其他地方调用该方法
				uploader.start(); 
				uploader.bind('FileUploaded',function(up, files,info) {
					var response = $.parseJSON(info.response);
	               	if ("0"==response.status){
	               		imgUpload = response.fileUrl[0];
	               		//var params=['applyTitle='+applyTitle,'startTime='+startTime,'endTime='+endTime,'deadline='+deadline,'applyMaxuser='+applyMaxuser,'applyOrderNumber='+applyOrderNumber,'activityImage='+imgUpload,'commentContent='+commentContent];
	    				//保存
	    				$.youi.ajaxUtils.ajax({
	    					url:baseUrl+'activityApplyManager/saveActivityApplyForPage.json',
	    					data:{applyTitle:applyTitle,startTime:startTime,endTime:endTime,deadline:deadline,applyMaxuser:applyMaxuser,activityAdr:activityAdr,applyOrderNumber:applyOrderNumber,activityImage:imgUpload,commentContent:commentContent},
	    					success:function(result){
	    						if(result&&result.record){
	    							//alert("发布成功");
	    							clearInterval(timer);
									$(".tc.mt25").text("发布成功！");
					           		$(".toast").show();
					           		pltime=1;
					           		timer=setInterval("closeTanc()",1000);
	    						}
	    					}
	    				});
	               	}
				});
			}else{
				//var params=['applyTitle='+applyTitle,'startTime='+startTime,'endTime='+endTime,'deadline='+deadline,'applyMaxuser='+applyMaxuser,'applyOrderNumber='+applyOrderNumber,'activityImage='+imgUpload,'commentContent='+commentContent];
				//保存
				$.youi.ajaxUtils.ajax({
					url:baseUrl+'activityApplyManager/saveActivityApplyForPage.json',
					data:{applyTitle:applyTitle,startTime:startTime,endTime:endTime,deadline:deadline,applyMaxuser:applyMaxuser,activityAdr:activityAdr,applyOrderNumber:applyOrderNumber,activityImage:imgUpload,commentContent:commentContent},
					success:function(result){
						if(result&&result.record){
							clearInterval(timer);
							$(".tc.mt25").text("发布成功！");
			           		$(".toast").show();
			           		pltime=1;
			           		timer=setInterval("closeTanc()",1000);
						}
					}
				});
			}
		})
	});
	</script>
	<script type="text/javascript">
		var uploader = new plupload.Uploader(
				{
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
	 <script type="text/javascript">
    	$(function () {
    		$(".gr-czh-box").click(function(){
    			$(".gr-czh-box").removeClass("active");
    			$(this).addClass("active");
    		})
		    var sbysf_index = 0;
		    var n=$(".gr-ck-group .gr-czh-box").length-4;
		    function sbysf_scroll_up(){
		        sbysf_index++;
		        if(sbysf_index > n){
		            sbysf_index = 0;
		        }
		        sbysf_show(sbysf_index);
		    }
		    function sbysf_scroll_down(){
		        sbysf_index--;
		        if(sbysf_index < 0){
		            sbysf_index = n;
		        }
		        sbysf_show(sbysf_index);
		    }
		    function sbysf_show(j){
		        var index = -(j*224);
		        $(".gr-ck-group").animate({left: index+'px'},200);
		    }
		    $("#next_btn1").click(function(){
		        sbysf_scroll_up();
		    });
		    $("#prev_btn1").click(function(){
		        sbysf_scroll_down();
		    });

		    var start = {
			    elem: '#startTime',
			    min: laydate.now(), //设定最小日期为当前日期
			    max: '2099-06-16 23:59:59', //最大日期
			    istoday: false,
			    choose: function(datas){
			         end.min = datas; //开始日选好后，重置结束日的最小日期
			         end.start = datas //将结束日的初始值设定为开始日
			    }
			};
			var end = {
			    elem: '#endTime',
			    min: laydate.now(),
			    max: '2099-06-16 23:59:59',
			    istoday: false,
			    choose: function(datas){
			        start.max = datas; //结束日选好后，重置开始日的最大日期
			    }
			};
			laydate(start);
			laydate(end);

			laydate({
			    elem: '#enddate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			    min: laydate.now(),
			    event: 'focus' //响应事件。如果没有传入event，则按照默认的click
			});

			$(".next-step").click(function(){
				var n=$(this).parents(".fb-list-box").index()+1;
				$(".fb-activity li").eq(n).addClass("active").siblings().removeClass("active");
				$(".fb-list-box").eq(n).show().siblings().hide();
			})
			$(".prev-step").click(function(){
				var n=$(this).parents(".fb-list-box").index()-1;
				$(".fb-activity li").eq(n).addClass("active").siblings().removeClass("active")
				$(".fb-list-box").eq(n).show().siblings().hide();
			})
    	})

			$(".fb-activity li").click(function(){
				$(".fb-activity li").removeClass("active");
				$(this).addClass("active");
				$(".fb-list-box").eq($(this).index()).show().siblings().hide();
			});
    </script>
    
    <script type="text/javascript">
		$(function(){
			$.ajax({
				url:baseUrl+'ordermanagerUserorderManager/getOrderlistforPage.json',
				data:['userorderStatus=01','genreCode=0301'].join('&'),
				success:function(result){
					if(result&&result.records){
						roomRecords(result.records);
					}
				}
			});
		});
	
	//拼接会议室
	function roomRecords(record){
		$(".activeroom").empty();
	  	var ht = "<tr align='center' class='f14 c-333'><td colspan='2'>地点</td>"+
		"<td>时间</td><td>价格</td><td>操作</td></tr>";
		$(".activeroom").append(ht);
		
		for(var i=0;i<record.length;i++){
			var html="";
			if(i==0){
				html+="<tr><td><input type='checkbox' name='com' id="+record[i].userorderId+"></td><td align='left' style='padding-left: 50px;'>"+record[i].userorderProject+"</td>"+
				"<td>2016-03-12 08:00 - 18:00</td><td>"+record[i].userorderAmount+"元/小时</td>"+
				"<td><a href='"+proUrl+"companyservice/room.html' class='c-333'>查看场地详情</a></td></tr>";
			}else{
				html+="<tr><td><input type='checkbox' name='com' id="+record[i].userorderId+"></td><td align='left' style='padding-left: 50px;'>"+record[i].userorderProject+"</td>"+
				"<td>2016-03-12 08:00 - 18:00</td><td>"+record[i].userorderAmount+"元/小时</td>"+
				"<td><a href='"+proUrl+"companyservice/room.html' class='c-333'>查看场地详情</a></td></tr>";
			}
			$(".activeroom").append(html);
			//aa();
		}
		

	}
	</script>
	<script type="text/javascript">
		var editor = CKEDITOR.replace('editorproductDiscriptio');
		editor.updateElement();
		$(document).on("click",".activeroom input",function(){
                if($(this).attr('checked')){
                    $(this).attr('checked',false);
                }else{
                $(this).parents("tr").siblings().find("input").attr('checked',false);
                	$(this).attr('checked',true);
                }
 
        });
		$("#a1").click(function(){			
			location.href = proUrl + "companyservice/room.html" ;
		})	
	</script>
	<script type="text/javascript">
		//toast弹窗出来后，一秒自动关闭,请再调用弹窗toast的时候调用该方法
		 var pltime,timer;
		 function closeTanc(){
		     if(pltime>1){
		         pltime--;
		     }else{
		         $(".toast").hide();
		     }       
		 };
		 //关闭toast
	        $(".close-toast").click(function(){
	            $(".toast").hide();
	        });
		 //调用方法如下，哪里调用就放哪里
		 /**
		     clearInterval(timer);
		     $(".toast").show();
		     pltime=1;
		     timer=setInterval("closeTanc()",1000);
		 */
	</script>
</youi:html>