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
function submit(params){
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/informationLegalManager/saveInformationLegal.json',
		data:params.join('&'),
		success:function(result){
			if(result && result.record){
				$('#toast_text').html('保存成功！');
				$(".toast").show();
	            setTimeout('$(".toast").hide();',3000);//1秒=1000
			}
		}
	});
}
$(document).ready(function() {
	$("#legalRemark").on('keyup', function() {
	    var len = getStrLength(this.value);
	    $("#currentCount").html(len);
	});
	
	var height = Math.max((document.documentElement.clientHeight -135), ($(".main-wrapper").height()));
  	document.getElementById('main-wrapper-right').style.height=height+'px';
  	
  	$.ajax({
		url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
		success:function(result){
			if(result&&result.record){
				$("#legalRe").html(result.record.companyId);
				$.ajax({
					url:baseUrl+'/informationLegalManager/findInformationLegal.json',
					data : ['legalRe='+result.record.companyId].join('&'),
					success:function(result){
						if(result&&result.records){
							var record = result.records;
		    				for(var i=0; i<record.length; i++){
		    					if(record[i].legalImage!=null && record[i].legalImage!=""){
		    						 var imgsrc = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+record[i].legalImage+"&method=show";
		    						$("#legalImage").attr("src",imgsrc);
		    					}
								$("#legalId").val(record[i].legalId);
		    					$("#legalName").val(record[i].legalName);
		    					$("#legalBusiness").val(record[i].legalBusiness);
		    					$("#legalBirthday").val(record[i].legalBirthday);
		    					$("#legalTelephone").val(record[i].legalTelephone);
		    					$("#legalRemark").val(record[i].legalRemark);
		    				}
						}
					}
				});
			}
		}
	});
  	
  	$(".save_btn").click(function(){
  		var legalId=$("#legalId").val();
		var legalRe=$("#legalRe").html();
		var legalName=$("#legalName").val();
		var legalBirthday=$("#legalBirthday").val();
		var legalTelephone=$("#legalTelephone").val();
		var legalBusiness=$("#legalBusiness").val();
		var legalRemark=$("#legalRemark").val();
		var legalImage = "";
		//检查是否有选择头像图片
		var fileCount = uploader.files.length;
		if(fileCount>0){
			//调用实例对象的start()方法开始上传文件
			uploader.start(); 
			uploader.bind('FileUploaded',function(up, files,info) {
				var response = $.parseJSON(info.response);
               	if ("0"==response.status){
               		legalImage = response.fileUrl[0];
               		var params = ['legalId='+legalId+'','legalRe='+legalRe+'','legalName='+legalName+'',
               		              'legalBirthday='+legalBirthday+'','legalTelephone='+legalTelephone+'',
               		              'legalBusiness='+legalBusiness+'','legalRemark='+legalRemark+'','legalImage='+legalImage+''];
               		submit(params);
               	}
			});
		}else{
			var params = ['legalId='+legalId+'','legalRe='+legalRe+'','legalName='+legalName+'',
       		              'legalBirthday='+legalBirthday+'','legalTelephone='+legalTelephone+'',
       		              'legalBusiness='+legalBusiness+'','legalRemark='+legalRemark+'','legalImage='+legalImage+''];
			submit(params);
		}
	});
  	
  	var start = {
		elem: '#legalBirthday',
		min: '1800-01-01 00:00:00', //设定最小日期为当前日期
		max: '2099-12-31 23:59:59', //最大日期
		istoday: false,
		choose: function(datas){
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas; //将结束日的初始值设定为开始日
		}
	};
	laydate(start);
	
	$("#moreul").slideDown("slow");
  	$("#moreul > li:eq(3)").addClass("active");
});