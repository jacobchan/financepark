$(document).ready(function() {
	$('.sidebar-menu-mainul2 li a').click(function(){
        $('.sidebar-menu-mainul2 li').removeClass('active');
        $(this).parent().addClass('active');
   	});
	$.ajax({
		url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
		success:function(result){
			if(result&&result.record){
				$("#mediaRe").html(result.record.companyId);
				//根据企业id获取融资信息
		    	$.ajax({
		    		url : baseUrl+"/informationMediaManager/findInformationMedia.json",
		    		data : ['mediaRe='+result.record.companyId].join('&'),
		    		success : function(results) {
		    			if (results && results.records) {
		    				var records = results.records;
		    				$("#mediaDiv").empty();
		    				for(var i=0; i<records.length; i++){
		    					var imgsrc = "../styles/images/qiye/photo_list1.png";
		    					if(records[i].mediaUrl!=null && records[i].mediaUrl!=""){
		    						imgsrc = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+records[i].mediaUrl+"&method=show";
		    					}
		    					var mediaDiv = '<li>'+
		                            '<div class="mt_list">'+
		                                '<div class="list_pic"><img src="'+imgsrc+'"></div>'+
		                                '<div class="list_tex">'+
		                                    '<table>'+
		                                        '<tr>'+
		                                            '<td colspan="2" height="40" valign="middle" align="left"><a class="tit" href="'+records[i].mediaTilurl+'" target="_blank">'+records[i].mediaTitle+'</a></td>'+
		                                        '</tr>'+
		                                        '<tr>'+
		                                            '<td height="40" valign="middle" align="left"><a href=\'javascript:updateMedia("'+
		                                            records[i].mediaId+'", "'+records[i].mediaRe+'", "'+records[i].mediaTitle+'", "'+records[i].mediaTilurl+
		                                            '", "'+imgsrc+'");\'><span>编辑</span></a>丨<a href=\'javascript:removeMedia("'+records[i].mediaId+'");\'>删除</a></td>'+
		                                            '<td height="40" valign="middle" align="right"><span class="color_hui">'+records[i].createTime+'</span></td>'+
		                                        '</tr>'+
		                                    '</table>'+
		                                '</div>'+
		                            '</div>'+
		                        '</li>';
		    					$("#mediaDiv").append(mediaDiv);
		    				}
		    			}
		    		}
		    	});
			}
		}
	});
	
	$(".save_btn").click(function(){
		var mediaId=$("#mediaId").val();
  		var mediaRe=$("#mediaRe").html();
  		var mediaTitle=$("#mediaTitle").val();
  		var mediaTilurl=$("#mediaTilurl").val();
  		var mediaUrl = "";
		//检查是否有选择媒体图片
		var fileCount = uploader.files.length;
		if(fileCount>0){
			//调用实例对象的start()方法开始上传文件
			uploader.start(); 
			uploader.bind('FileUploaded',function(up, files,info) {
				var response = $.parseJSON(info.response);
               	if ("0"==response.status){
               		mediaUrl = response.fileUrl[0];
               		var params = ['mediaId='+mediaId+'','mediaRe='+mediaRe+'','mediaTitle='+mediaTitle+'',
               		              'mediaTilurl='+mediaTilurl+'','mediaUrl='+mediaUrl+''];
               		
               		submit(params);
               	}
			});
		}else{
			var params = ['mediaId='+mediaId+'','mediaRe='+mediaRe+'','mediaTitle='+mediaTitle+'',
       		              'mediaTilurl='+mediaTilurl+'','mediaUrl='+mediaUrl+''];
       		
       		submit(params);
		}
		
	});
	$("#moreul").slideDown("slow");
  	$("#moreul > li:eq(4)").addClass("active");
});
function submit(params){
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/informationMediaManager/saveInformationMedia.json',
		data:params.join('&'),
		success:function(result){
			if(result && result.record){
				$('#toast_text').html('保存成功！');
				$(".toast").show();
	            setTimeout('$(".toast").hide();',3000);//1秒=1000
	            $("#mediaId").val("");
	        	$("#mediaRe").html("");
	        	$("#mediaTitle").val("");
	        	$("#mediaTilurl").val("");
	            location.reload();
			}
		}
	});
}
//删除专利
function removeMedia(obj){
 	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/informationMediaManager/removeInformationMedia.json',
		data:'mediaId='+obj,
		success:function(result){
			$('#toast_text').html('删除成功！');
			$(".toast").show();
            setTimeout('$(".toast").hide();',3000);//1秒=1000
			location.reload();
		}
	});
}
//修改地址
function updateMedia(obj0, obj1, obj2, obj3,imgsrc){
	$("#mediaId").val(obj0);
	$("#mediaRe").html(obj1);
	$("#mediaTitle").val(obj2);
	$("#mediaTilurl").val(obj3);
	$("#rzLogo").attr("src",imgsrc);
}