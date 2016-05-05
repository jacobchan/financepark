	//pageLoad Method
	$(function(){
		method() ;
	});
	function method(){
		$.ajax({
			url:baseUrl+'memberInformationManager/getMemberInformationByLoginUser.json',
			//async: false, 
			success:function(result){
				if(result&&result.record){
					//console.log(result.record) ;
					_parseRecords(result.record);
					
				}
			}
		});
		
		function _parseRecords(record){
			$("#memberId").html(record.memberId);
			$("#headImg").attr("src",cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record.memberHeadPortrait+"&method=show");
			$("#memberHeadPortrait").val(record.memberHeadPortrait);
			$(".c-b1").html(record.memberPhoneNumber);
			$("#memberNickname").val(record.memberNickname);
			$("#memberName").val(record.memberName);
			if(record.memberBirthdate != null){
				$("#year").val(record.memberBirthdate.substring(0,4));
				$("#month").val(record.memberBirthdate.substring(5,7));
				$("#day").val(record.memberBirthdate.substring(8,10));
			}
			$("#memberDescribe2").val(record.memberDescribe2);
			$("#companyId").val(record.companyId);
			if(record.companyId != null){
				getRzName(record.companyId);//获得公司名字
				$("#ly1").hide() ;
			}
			
		};
		function getRzName(companyId){
			var id=companyId;
			 $.ajax({
					url:baseUrl+'enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json', 
					data:'rzId='+id,
					success:function(result){
						if(result&&result.record){
							_rzRecords(result.record);												
						}
					}
				}); 
		}; 
		//获得公司名字
		function _rzRecords(record){											
			$("#companyName").val(record.rzName);
			
		};
	}
		
		$('.hhf-submit').click(function(){
			this.disabled=true;
			var flg = false;
			var memberId=$("#memberId").html();
			var memberNickname=$("#memberNickname").val();
			var memberPhoneNumber=$(".c-b1").html();
			var memberName=$("#memberName").val();
			var year=$("#year").val();
			var month=$("#month").val();
			var day=$("#day").val();
			var memberBirthdate=year+"-"+month+"-"+day;
			var memberDescribe2=$("#memberDescribe2").val();
			var companyId=$("#companyId").val();
			//检查是否有选择头像图片
			var fileCount = uploader.files.length;
			if(fileCount>0){
				//调用实例对象的start()方法开始上传文件，当然你也可以在其他地方调用该方法
				uploader.start(); 
				uploader.bind('FileUploaded',function(up, files,info) {
					var response = $.parseJSON(info.response);
	               	if ("0"==response.status){
	               		var memberHeadPortrait = response.fileUrl[0];
	    				var params = ['memberHeadPortrait='+memberHeadPortrait+'','memberId='+memberId+'','memberNickname='+memberNickname+'','memberPhoneNumber='+memberPhoneNumber+'','memberName='+memberName+'','memberBirthdate='+memberBirthdate+'','memberDescribe2='+memberDescribe2+'','companyId='+companyId+''];
	    				$.youi.ajaxUtils.ajax({
	    					url:baseUrl+'memberInformationManager/updateMemberInformation.json',
	    					data:params.join('&'),
	    					success:function(result){
	    						if(result&&result.record){	    						
	    							close();
	    						}
	    					}
	    				});
	               	}
				});
			}else{
				var memberHeadPortrait = $("#memberHeadPortrait").val();
				var params = ['memberHeadPortrait='+memberHeadPortrait+'','memberId='+memberId+'','memberNickname='+memberNickname+'','memberPhoneNumber='+memberPhoneNumber+'','memberName='+memberName+'','memberBirthdate='+memberBirthdate+'','memberDescribe2='+memberDescribe2+'','companyId='+companyId+''];
				$.youi.ajaxUtils.ajax({
					url:baseUrl+'memberInformationManager/updateMemberInformation.json',
					data:params.join('&'),
					success:function(result){
						if(result&&result.record){							
							close();
						}
					}
				});
			}
		});	
		//加入企业
		$('.ib-btn').click(function(){
			this.disabled=true;
			var memberId=$("#memberId").html();
			var companyInvitecode=$("#companyInvitecode").val();
			if(companyInvitecode){
					
			}else{
				$(".c-o.aa").text("企业码为空");
				return false;
			}
			
			var params = ['memberId='+memberId+'','code='+companyInvitecode+''];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'enterpriseEmployeesManager/acceptEnterpriseInvitation.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						//console.log(result.record) ;
						var record = result.record ;
						if(record.flag == '0'){
							$(".c-o.aa").text(record.msg);
						}else{
							method() ;
							$(".bg-tanc").hide() ;
							
						}
					}
				}
			});
		});	
	
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
		
		$(function () {
			$("a.c-o").on("click",function(){
				$(this).parent("p").hide().siblings("p").show();
			});
			$(".open-tanc").click(function(){
				$(".c-o.aa").text("") ;
				$("#companyInvitecode").val("") ;
				$(".bg-tanc").show();
			});
			$("#birthday_container").birthday();
			
			$("#companyName")
			
			/* $(".tcclose").click(function(){
				$(".bgtanc").hide();
			}); */
		})	//pageLoad Method
	//操作成功，提示信息
	function close(content){		        
        $(".toast").show();		      		        		       				
		setTimeout(function(){$(".toast").hide(); },2000);
		setTimeout(function(){metodh(); },2000);
  	}