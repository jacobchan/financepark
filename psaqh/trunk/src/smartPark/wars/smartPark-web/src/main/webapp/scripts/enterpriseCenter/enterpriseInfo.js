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
function submit(rzId,rzLogo,roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio,rzImages){
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/enterbusinessmanagerRzManager/updateEnterbusinessmanagerRz.json',
		data:{rzId:rzId,rzLogo:rzLogo,roomId:roomId,rzName:rzName,rzRemark:rzRemark,
			rzUrl:rzUrl,enTypeId:enTypeId,productDiscriptio:productDiscriptio,rzImages:rzImages},
		success:function(result){
			if(result && result.record){
				$('#toast_text').html('保存成功！');
				$(".toast").show();
	            setTimeout('$(".toast").hide();',2000);//1秒=1000
			};
		}
	});
}
function check(roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio){
	//url正则表达式
	var urlRegex = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
	if(rzName=="" || rzName.trim().length==0){
		$('#toast_text').html('企业名称不能为空！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',2000);//1秒=1000
		return false;
	}
	if(roomId=="" || roomId.trim().length==0){
		$('#toast_text').html('地址不能为空！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',2000);//1秒=1000
		return false;
	}
	if(rzUrl=="" || !urlRegex.test(rzUrl)){
		$('#toast_text').html('网址输入错误！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',2000);//1秒=1000
		return false;
	}
	if(enTypeId=="" || enTypeId.trim().length==0){
		$('#toast_text').html('行业类型不能为空！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',2000);//1秒=1000
		return false;
	}
	if(rzRemark=="" || rzRemark.trim().length==0){
		$('#toast_text').html('公司介绍不能为空！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',2000);//1秒=1000
		return false;
	}
	if(productDiscriptio=="" || productDiscriptio.trim().length==0){
		$('#toast_text').html('产品描述不能为空！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',2000);//1秒=1000
		return false;
	}
	return true;
};
//根据企业ID获取企业所在单元列表
function roomAddress(rzId){
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/bbmRoomManager/getRoomListByRzId.json',
		data:{rzId:rzId},
		success:function(result){
			if(result&&result.records){
				var records = result.records;
				$("#roomAddressing").empty();
				for(var i=0; i<records.length; i++){
					$("#roomAddressing").append("<li data-id='"+records[i].roomId+"' data-val='"+records[i].roomAddress+"'>"+records[i].roomAddress+"</li>");
				}
			}
		}
	});
	$("#qiye_address").on("click",function(){
		$("#roomAddressing").toggle();
	});
	$("#roomAddressing").on("click","li",function(){
		$(this).addClass("selected").siblings().removeClass("selected");
		var roomId = $(this).attr("data-id");
		var roomAddress = $(this).attr("data-val");
		$("#roomId").val(roomId);
		$('#roomAddress').html(roomAddress);
	});
}
//获取所有的行业类型
function enType(){
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/etypeEnterprisetypeManager/getSubEnterpriseTypeList.json',
		success:function(result){
			if(result&&result.records){
				var records = result.records;
				$("#enTypeNamesing").empty();
				for(var i=0; i<records.length; i++){
					$("#enTypeNamesing").append("<li data-id='"+records[i].enTypeId+"' data-val='"+records[i].enTypeName+"'>"+records[i].enTypeName+"</li>");
				}
			}
		}
	});
	$("#qiye_enType").on("click",function(){
		$("#enTypeNamesing").toggle();
	});
	$("#enTypeNamesing").on("click","li",function(){
		$(this).addClass("selected").siblings().removeClass("selected");
		var enTypeId = $(this).attr("data-id");
		var enTypeName = $(this).attr("data-val");
		$("#enTypeId").val(enTypeId);
		$('#enTypeName').html(enTypeName);
	});
}

$(function() {
	enType();
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
							$("#headImg").attr("src",cenUrl+"common/uploadImage.html?repository=/swfupload&path="+result.record.rzLogo+"&method=show");
							$("#financingRe").html(result.record.rzId);
							$("#rzName").val(result.record.rzName);
	    					$("#rzUrl").val(result.record.rzUrl);
	    					$("#rzRemark").val(result.record.rzRemark);
	    					if(result.record.enTypeId != null){
	    						$("#enTypeId").val(result.record.enTypeId.enTypeId);
	    						$("#enTypeName").html(result.record.enTypeId.enTypeName);
	    					}
	    					if(result.record.roomId != null){
	    						$("#roomId").val(result.record.roomId.roomId);
		    					$("#roomAddress").html(result.record.roomId.roomAddress);
	    					}else{
	    						$("#roomAddress").html("请联系物业管理员，办理入驻！");
	    					}
	    					$("#editorproductDiscriptio").val(result.record.productDiscriptio);
	    					editor.setData(result.record.productDiscriptio);
	    					if(result.record.rzRemark != null){
	    						$("#currentCount").html(getStrLength(result.record.rzRemark));
	    					}
	    					roomAddress(result.record.rzId);
	    					var rImages = result.record.rzImages;
	    					if(rImages != null){
	    						var strs= new Array(); //定义一数组
		    					strs = rImages.split(","); //字符分割
		    					for (var i=0;i<strs.length ;i++ ){
		    						var src = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+strs[i]+"&method=show";
		    						var html = '<li><div style="position:relative"><div class="overlay"></div><img id="qiyeheadImg-'+src+'" src="'+src+'" width="168" height="168"/></div></li>';				
		    						$('#qiyeheadImg').before(html);
		    					} 
	    					}
						}
					}
				});
			}
		}
	});
	
  	$(".save_btn").click(function(){
  		var rzId=$("#financingRe").html();
  		var rzLogo="";
  		var roomId=$("#roomId").val();
  		var rzName=$("#rzName").val();
		var rzUrl=$("#rzUrl").val();
		var enTypeId=$("#enTypeId").val();
		var rzRemark=$("#rzRemark").val();
		var rzImages = "";
		var productDiscriptio=editor.getData();
		var bool = check(roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio);
		if(!bool){
			return;
		}
		
		//检查是否有选择企业LOGO图片和企业宣传图
		var fileCount = uploader.files.length;
		var qiyefileCount = qiyeuploader.files.length;
		if(fileCount>0){
			//调用实例对象的start()方法开始上传文件
			uploader.start(); 
			uploader.bind('FileUploaded',function(up, files,info) {
				var response = $.parseJSON(info.response);
               	if ("0"==response.status){
               		rzLogo = response.fileUrl[0];
               		if(qiyefileCount>0){
        				//调用实例对象的start()方法开始上传文件
        				qiyeuploader.start(); 
        				var i = 0;
        				qiyeuploader.bind('FileUploaded',function(up, files,info) {
        					i++;
        					var response = $.parseJSON(info.response);
        	               	if ("0"==response.status){
        	               		rzImages = rzImages+response.fileUrl[0];
        	               		if(i == qiyefileCount){
        	               			submit(rzId,rzLogo,roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio,rzImages);
        	               		}else{
        	               			rzImages = rzImages+',';
        	               		};
        	               	};
        				});
        			}else{
        				submit(rzId,rzLogo,roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio,rzImages);
        			}
               	};
			});
		}else{
			if(qiyefileCount>0){
				//调用实例对象的start()方法开始上传文件
				qiyeuploader.start(); 
				var i = 0;
				qiyeuploader.bind('FileUploaded',function(up, files,info) {
					i++;
					var response = $.parseJSON(info.response);
	               	if ("0"==response.status){
	               		rzImages = rzImages+response.fileUrl[0];
	               		if(i == qiyefileCount){
	               			submit(rzId,rzLogo,roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio,rzImages);
	               		}else{
	               			rzImages = rzImages+',';
	               		};
	               	};
				});
			}else{
				submit(rzId,rzLogo,roomId,rzName,rzRemark,rzUrl,enTypeId,productDiscriptio,rzImages);
			}
		};
	});
  	$("#moreul > li:eq(0)").addClass("active");
});
