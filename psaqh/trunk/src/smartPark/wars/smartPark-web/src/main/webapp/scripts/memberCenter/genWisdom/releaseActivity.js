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
			}else{
				var aa = $("#"+applyOrderNumber+"").parent().parent();
				var dd = $(aa).children('td').eq(1);
				activityAdr = dd[0].innerText;
			}
			
			//检查是否有选择头像图片
			var fileCount = uploader.files.length;
			var docCount = fileuploader.files.length;
			var docPath ="";
			var allPath ="";
			if(fileCount>0&&docCount>0){
				uploader.start(); 
				uploader.bind('FileUploaded',function(up, files,info) {
					var response = $.parseJSON(info.response);
		           	if ("0"==response.status){
		           		imgUpload = response.fileUrl[0];	
		           		fileuploader.start(); 
		        		var i = 0;
		        		fileuploader.bind('FileUploaded',function(up, files,info) {
		        			i++;
		        			var response = $.parseJSON(info.response);
		                   	if ("0"==response.status){
		                   		docPath = docPath+response.fileUrl[0];
		                   		if(docCount==i){
		                   			allPath = docPath;
		                   			var params = {applyTitle:applyTitle,startTime:startTime,endTime:endTime,
		            						deadline:deadline,applyMaxuser:applyMaxuser,activityAdr:activityAdr,applyOrderNumber:applyOrderNumber,
		            						activityImage:imgUpload,commentContent:commentContent,documentPath:allPath};
		                   			console.log(params);
		                   			saveApply(params);
		                   		}else{
		                   			docPath = docPath+",";
		                   		}
		        			}
		        		});
		           	}
				});
			}else if(fileCount>0&&docCount<=0){
				uploader.start(); 
				uploader.bind('FileUploaded',function(up, files,info) {
					var response = $.parseJSON(info.response);
		           	if ("0"==response.status){
		           		imgUpload = response.fileUrl[0];	
		           		var params = {applyTitle:applyTitle,startTime:startTime,endTime:endTime,
        						deadline:deadline,applyMaxuser:applyMaxuser,activityAdr:activityAdr,applyOrderNumber:applyOrderNumber,
        						activityImage:imgUpload,commentContent:commentContent};
               			saveApply(params);
		           	}
				});
			}else if(fileCount<=0&&docCount>0){
				fileuploader.start(); 
        		var i = 0;
        		fileuploader.bind('FileUploaded',function(up, files,info) {
        			i++;
        			var response = $.parseJSON(info.response);
                   	if ("0"==response.status){
                   		docPath = docPath+response.fileUrl[0];
                   		if(docCount==i){
                   			allPath = docPath;
                   			var params = {applyTitle:applyTitle,startTime:startTime,endTime:endTime,
            						deadline:deadline,applyMaxuser:applyMaxuser,activityAdr:activityAdr,applyOrderNumber:applyOrderNumber,
            						commentContent:commentContent,documentPath:allPath};
                   			saveApply(params);
                   		}else{
                   			docPath = docPath+",";
                   		}
        			}
        		});
			}else{
				var params = {applyTitle:applyTitle,startTime:startTime,endTime:endTime,
					deadline:deadline,applyMaxuser:applyMaxuser,activityAdr:activityAdr,
					applyOrderNumber:applyOrderNumber,activityImage:imgUpload,commentContent:commentContent};
				saveApply(params);
			}
		})
	});
	
	function saveApply(params){
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'activityApplyManager/saveActivityApplyForPage.json',
			data:params,
			success:function(result){
				if(result&&result.record){
					clearInterval(timer);
					$(".tc.mt25").text("发布成功！");
	           		$(".toast").show();
	           		pltime=1;
	           		timer=setInterval("closeTanc()",1000);
				}
			},
			error:function(msg){
				clearInterval(timer);
				$(".tc.mt25").text(msg);
           		$(".toast").show();
           		pltime=1;
           		timer=setInterval("closeTanc()",2000);
			}
		});
	}
	
		var uploader = new plupload.Uploader(
				{
					runtimes : 'html5,flash,silverlight',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
					browse_button : 'imgUpload',
					flash_swf_url : '../fileUpload/Moxie.swf',
					silverlight_xap_url : '../fileUpload/Moxie.xap',
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
		
		var fileuploader = new plupload.Uploader(
				{
					runtimes : 'html5,flash,silverlight',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
					browse_button : 'imgFile',
					flash_swf_url : '../fileUpload/Moxie.swf',
					silverlight_xap_url : '../fileUpload/Moxie.xap',
					url : cenUrl+'fileUpload/goUpload.html',//上传文件路径
					max_file_size : '10240kb', //最大只能上传2048kb的文件
					prevent_duplicates : true, //不允许选取重复文件
					//此处是控制上传组件是否允许多文件选择还是单文件选择：true/多文件；false/单文件
					multi_selection: true,
					//给后台传入参数
					multipart_params: {
						//上传标识 0：图片上传;1：文件上传
						fileFlg:"1"
					},
					filters : [ {
						title : 'file files',
						extensions : 'doc,docx,xls,xlsx,ppt,pptx,pdf'
					} ],
					init : {
						FilesAdded : function(up, files) {
							for(var i = 0, len = files.length; i<len; i++){
								//构造html来更新UI，显示文件的名字（可根据自己的业务修改）
								var src = getPathtype(files[i].name);
								var html = '<div class="gr-czh-list">'+
	                                '<img src='+src+' height="114" width="202">'+
	                                '<h3><a href="javascript:;" class="c-333">'+files[i].name+'</a></h3>'+
	                                '<p class="f12 mb5"> <a href="javascript:;" class="c-b1 ml5 mr10" id='+files[i].id+' onclick="deldoc(this);">删除</a></p>'+
	                                '</div>';				
								$('.doclist').append(html);
								/*!function(i){
									//此处用户图片的回显（可根据自己的业务修改）
									previewImage(files[i],function(imgsrc){
										 $('#qiyeheadImg-'+files[i].id).append('<img src="'+ imgsrc +'" />'); 
										$('#qiyeheadImg-'+files[i].id).attr("src",imgsrc);
									});
							    }(i);*/
							};
						}
					}
				});
		
		fileuploader.init();
		
		//删除所选上传文档
		function deldoc(obj){
			var me = obj;
			fileuploader.removeFile(me.id); 
			$(me.parentNode.parentNode).remove();

		}
		
		//获取文件类型
	    function getPathtype(path){
	    	var type="";
	    	var index1=path.lastIndexOf("."); 
	    	var index2=path.length;
	    	var postf=path.substring(index1+1,index2);//后缀名  
	    	if(postf=='doc'||postf=='docx'){
	    		type="../../../styles/images/grzx/user-photo.png";
	    	}else if(postf=='xls'||postf=='xlsx'){
	    		type="../../../styles/images/grzx/user-photo.png";
	    	}else if(postf=='ppt'||postf=='pptx'){
	    		type="../../../styles/images/grzx/user-photo.png";
	    	}else if(postf=='pdf'){
	    		type="../../../styles/images/grzx/user-photo.png";
	    	}
	    	return type;
	    } 
		
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
			    format:"YYYY-MM-DD hh:mm:ss",
			    min: laydate.now(), //设定最小日期为当前日期
			    max: '2099-06-16 23:59:59', //最大日期
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			         end.min = datas; //开始日选好后，重置结束日的最小日期
			         end.start = datas //将结束日的初始值设定为开始日
			    }
			};
			var end = {
			    elem: '#endTime',
			    format:"YYYY-MM-DD hh:mm:ss",
			    min: laydate.now(),
			    max: '2099-06-16 23:59:59',
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			        start.max = datas; //结束日选好后，重置开始日的最大日期
			    }
			};
			laydate(start);
			laydate(end);

			laydate({
			    elem: '#enddate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			    format:"YYYY-MM-DD hh:mm:ss",
			    min: laydate.now(),
			    istime: true,
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
  
		$(function(){
			$.ajax({
				url:baseUrl+'ordermanagerUserorderManager/getOrderlistforPage.json',
				data:['userorderStatus=02','genreCode=0301'].join('&'),
				success:function(result){
					if(result&&result.records){
						roomRecords(result.records);
					}
				}
			});
		});
	
	//拼接时间段
	function getTimes(time){
		var beginTime = "0";
		var endTime = "0";
		var timeStrs = time.split(",");
		for(var i = 0;i<timeStrs.length;i++){
			var ss = timeStrs[i];
			var data1 = "";
			var data2 = "";
			var index1=ss.indexOf(":"); 
			var index2=ss.indexOf("-"); 
			var index3=ss.lastIndexOf(":");
			var chu = parseInt(index3)-(parseInt(index2)+1);
			data1 = ss.substr(0,(parseInt(index1)));
			data2 = ss.substr((parseInt(index2)+1),chu);
			if(beginTime=="0"){
				beginTime = data1;
			}
			if(endTime=="0"){
				endTime = data2;
			}
			if(parseInt(data1)<parseInt(beginTime)){
				beginTime = data1;
			}
			if(parseInt(data2)>parseInt(endTime)){
				endTime = data2;
			}
		}
		return beginTime+":00-"+endTime+":00";
	}
		
	//拼接会议室
	function roomRecords(record){
		$(".activeroom").empty();
	  	var ht = "<tr align='center' class='f14 c-333'><td colspan='2'>地点</td>"+
		"<td>时间</td><td>价格</td><td>操作</td></tr>";
		$(".activeroom").append(ht);
		
		for(var i=0;i<record.length;i++){
			var html="";
			var data = record[i].mettingOrder.publicResoIdDate;
			var time = record[i].mettingOrder.publicResoIdTime;
			var orderTime =data+" "+getTimes(time);
			if(i==0){
				html+="<tr><td><input type='checkbox' name='com' id="+record[i].userorderId+"></td><td align='left' style='padding-left: 50px;'>"+record[i].userorderProject+"</td>"+
				"<td>"+orderTime+"</td><td>"+record[i].userorderAmount+"元/小时</td>"+
				"<td><a href='"+proUrl+"companyservice/room.html' class='c-333'>查看场地详情</a></td></tr>";
			}else{
				html+="<tr><td><input type='checkbox' name='com' id="+record[i].userorderId+"></td><td align='left' style='padding-left: 50px;'>"+record[i].userorderProject+"</td>"+
				"<td>"+orderTime+"</td><td>"+record[i].userorderAmount+"元/小时</td>"+
				"<td><a href='"+proUrl+"companyservice/room.html' class='c-333'>查看场地详情</a></td></tr>";
			}
			$(".activeroom").append(html);
			//aa();
		}
		

	}
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
			window.open(proUrl + "companyservice/room.html") ;
		})	
	
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