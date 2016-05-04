<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="个人资料">
	<youi:body decorator="memcenter"> 

				<div class="w1000">
					<h3 class="per-h3">基本资料</h3>
					<table class="setting-table grst-table">
						<colgroup>
							<col width="100"></col>
							<col></col>
						</colgroup>
						<tr style="display:none;">
							<td>ID</td>
							<td><span class="" id="memberId"> </span></td>
						</tr>
						<tr>
							<td>头像</td>
							<td>				   
							    <%-- <div class="photo-edit" id="destination">
							    	<input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
								</div>
								<div class="photoedit" style="left:22px">
									<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png"  width="107" height="107"/>
								</div> --%>
								<input type="hidden" id="memberHeadPortrait" >
								<img id="headImg" src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png" border="0" class="fl" width="107" height="107"/>
								<div class="photo-edit"><input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>编辑<br/>头像</div>
							</td>
						</tr>
						<tr>
							<td>账号</td>
							<td><span class="c-b1"> </span><span class="c-o"><a href="<%=request.getContextPath()%>/member/memberCenter/personalCenter/securityCenter.html">[更换手机号码]</a></span></td>
						</tr>
						<tr>
							<td>昵称</td>
							<td><input type="text" id="memberNickname"></td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td><input type="text" id="memberName"></td>
						</tr>
						<tr>
							<td>出生日期</td>
							<td>
								<div id="birthday_container">
									<select name="year" id="year" style="width:88px;"></select>
									<select name="month" id="month" style="width:65px;"></select>
									<select name="day" id="day" style="width:65px;"></select>
								</div>
							</td>
						</tr>
						<tr>
							<td>一句话介绍</td>
							<td><textarea style="height:60px;" id="memberDescribe2"></textarea></td>
						</tr>
						<tr>
							<td>公司</td>
							<td>
								<input type="text" readonly="readonly" id="companyName">
								<input type="hidden" readonly="readonly" id="companyId">
								<a href="javascript:;" class="ml15 open-tanc" id="ly1"><i class="fa fa-plus-circle mr5"></i>加入企业</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="保存" class="hhf-submit" style="height:36px;" />
							</td>
						</tr>
					</table>
				</div>
	
	<!--***bottom end****************************************-->
		<!--***弹窗 start****************************************-->
		<div class="bg-tanc">
			<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
				<a href="javascript:;" class="tc-close"></a>
				<h3 class="mb10 f16 c-333" style="font-size:16px;"><b>加入园区</b></h3>
				<table class="line-table cic-l-t " style="font-size:14px;">
					<colgroup>
						<col width="110">
						<col>
					</colgroup>
					<tbody>
					<tr class="show2" >
						<td ><b>企业邀请码</b></td>
						<td><input style="width:150px" type="text" id="companyInvitecode"></td>
						<td><span class="c-o aa"></span></td>
					</tr>					
					<tr>						
						<td colspan="2"><a class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">加入企业</a></td>
					</tr>
				</tbody></table>
			</div>
		</div>
			
	<!--***弹窗 end****************************************-->
	<!--***弹窗 start****************************************-->
	
		<!-- 弹出层样式 -->
     <div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
    	
	
	<!--***弹窗 end****************************************-->

	</youi:body>
	<script type="text/javascript">
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
	    							$(".toast").show(); 
	    							setTimeout(function(){location.reload(); },600);
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
							$(".toast").show(); 
							setTimeout(function(){location.reload(); },600);
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
		})
	</script>	
</youi:html>