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
//删除专利
function removeKnowledge(obj){
 	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/informationKnowledgeManager/removeInformationKnowledge.json',
		data:'knowledgeId='+obj,
		success:function(result){
			alert("删除成功");
			location.reload();
		}
	});
}
//修改地址
function updateKnowledge(obj0, obj1, obj2, obj3,obj4){
	$("#knowledgeId").val(obj0);
	$("#knowledgeRe").html(obj1);
	$("#knowledgeTitle").val(obj2);
	$("#knowledgeContent").val(obj3);
	$("#currentCount").html(getStrLength(obj3));
	$("#rzLogo").attr("src",obj4);
}
function submit(params){
	$.youi.ajaxUtils.ajax({
		url:baseUrl+'/informationKnowledgeManager/saveInformationKnowledge.json',
		data:params.join('&'),
		success:function(result){
			if(result && result.record){
				$('#toast_text').html('保存成功！');
				$(".toast").show();
	            setTimeout('$(".toast").hide();',2000);//1秒=1000
	            
	            $("#knowledgeId").val("");
	        	$("#knowledgeRe").html("");
	        	$("#knowledgeTitle").val("");
	        	$("#knowledgeContent").val("");
	        	$("#currentCount").html(0);
	            location.reload();
			}
		}
	});
}
$(document).ready(function() {
	$("#knowledgeContent").on('keyup', function() {
	    var len = getStrLength(this.value);
	    $("#currentCount").html(len);
	});
	$.ajax({
		url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
		success:function(result){
			if(result&&result.record){
				$("#knowledgeRe").html(result.record.companyId);
				//根据企业id获取融资信息
		    	$.ajax({
		    		url : baseUrl+"/informationKnowledgeManager/findInformationKnowledge.json",
		    		data : ['knowledgeRe='+result.record.companyId].join('&'),
		    		success : function(results) {
		    			if (results && results.records) {
		    				var records = results.records;
		    				$("#knowledgeDiv").empty();
		    				for(var i=0; i<records.length; i++){
		    					var imgsrc = "../styles/images/qiye/photo_list1.png";
		    					if(records[i].knowledgeUrl!=null && records[i].knowledgeUrl!=""){
		    						imgsrc = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+records[i].knowledgeUrl+"&method=show";
		    					}
		    					var knowledgeDiv = '<li>'+
		                            '<div class="mt_list">'+
		                                '<div class="list_pic"><img src="'+imgsrc+'"></div>'+
		                                '<div class="list_tex">'+
		                                    '<table>'+
		                                        '<tr>'+
		                                            '<td colspan="2" height="40" valign="middle" align="left"><a class="tit">'+records[i].knowledgeTitle+'</a></td>'+
		                                        '</tr>'+
		                                        '<tr>'+
		                                            '<td colspan="2" height="42" valign="top" align="left"><span class="baodao_main">'+records[i].knowledgeContent+'</span></td>'+
		                                        '</tr>'+
		                                        '<tr>'+
		                                            '<td height="40" valign="middle" align="left"><a href=\'javascript:updateKnowledge("'+
		                                            records[i].knowledgeId+'", "'+records[i].knowledgeRe+'", "'+records[i].knowledgeTitle+'", "'+records[i].knowledgeContent+'", "'+
		                                            imgsrc+'");\'><span>编辑</span></a>丨<a href=\'javascript:removeKnowledge("'+
		                                            records[i].knowledgeId+'");\'>删除</a></td>'+
		                                        '</tr>'+
		                                    '</table>'+
		                                '</div>'+
		                            '</div>'+
		                        '</li>';
		    					$("#knowledgeDiv").append(knowledgeDiv);
		    				}
		    			}
		    		}
		    	});
			}
		}
	});
	$(".save_btn").click(function(){
		var knowledgeId=$("#knowledgeId").val();
  		var knowledgeRe=$("#knowledgeRe").html();
  		var knowledgeTitle=$("#knowledgeTitle").val();
  		var knowledgeContent=$("#knowledgeContent").val();
  		var knowledgeUrl = "";
		
		//检查是否有选择专利图片
		var fileCount = uploader.files.length;
		if(fileCount>0){
			//调用实例对象的start()方法开始上传文件
			uploader.start(); 
			uploader.bind('FileUploaded',function(up, files,info) {
				var response = $.parseJSON(info.response);
               	if ("0"==response.status){
               		knowledgeUrl = response.fileUrl[0];
               		var params = ['knowledgeId='+knowledgeId+'','knowledgeRe='+knowledgeRe+'','knowledgeUrl='+knowledgeUrl+'',
               		              'knowledgeTitle='+knowledgeTitle+'','knowledgeContent='+knowledgeContent+''];
               		submit(params);
               	}
			});
		}else{
			var params = ['knowledgeId='+knowledgeId+'','knowledgeRe='+knowledgeRe+'','knowledgeUrl='+knowledgeUrl+'',
       		              'knowledgeTitle='+knowledgeTitle+'','knowledgeContent='+knowledgeContent+''];
			submit(params);
		}
		
	});
	$("#moreul").slideDown("slow");
  	$("#moreul > li:eq(2)").addClass("active");
});