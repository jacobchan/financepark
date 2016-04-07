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
							    <%-- <div class="photo-edit" id="destination"><input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>
								  
								</div>   --%>
								<div class="photoedit" style="left:22px">
								  <img src="<%=request.getContextPath()%>/styles/images/grzx/user-photo.png"  width="107" height="107"/>
								  </div>
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
									<select name="year" id="year"></select>
									<select name="month" id="month"></select>
									<select name="day" id="day"></select>
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
								<input type="text" readonly="readonly" id="companyId">
								<a href="javascript:;" class="ml15 open-tanc"><i class="fa fa-plus-circle mr5"></i>加入企业</a>
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
				<table class="line-table cic-l-t wybx-tanc" style="font-size:14px;">
					<colgroup>
						<col width="110">
						<col>
					</colgroup>
					<tbody>
					<tr class="show2">
						<td><b>企业邀请码</b></td>
						<td><input style="width:400px" type="text" id="companyInvitecode"></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"><a class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">加入企业</a></td>
					</tr>
				</tbody></table>
			</div>
		</div>
			
	<!--***弹窗 end****************************************-->
	<!--***弹窗 start****************************************-->
	<!-- <div class="bgtanc m2">
			<div class="tanccon" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
				<a href="javascript:;" class="tc-close"></a>
				<div class="w70 tc mt40" style="margin-left:15%">
					<table>
						<tr>
							<td><img src="../styles/images/grzx/check.png" class="mr40 mb20" border="0"></td>
							<td >
								<h4 class="f24 fl c-333">请登录!</h4>
								<h4 class="f24 fl c-333"> 还有<span class="tt">0</span>秒关闭弹出框</h4>
								<p class="f14 c-o fl mt20 mb20">如有问题，请拨打：0571-86508888</p>
							</td>
						<tr/>
					</table>
				</div>
			</div>
		</div> -->
			
	<!--***弹窗 end****************************************-->
	
	</youi:body>
	<script type="text/javascript">
		$(function(){			
			$.ajax({
				url:baseUrl+'memberInformationManager/getMemberInformationByLoginUser.json',
				//async: false, 
				success:function(result){
					if(result&&result.record){
						_parseRecords(result.record);
					}
				}
			});
		});
		
		
		function _parseRecords(record){
			$("#memberId").html(record.memberId);
			$(".c-b1").html(record.memberPhoneNumber);
			$("#memberNickname").val(record.memberNickname);
			$("#memberName").val(record.memberName);
			$("#year").val(record.memberBirthdate.substring(0,4));
			$("#month").val(record.memberBirthdate.substring(5,7));
			$("#day").val(record.memberBirthdate.substring(8,10));
			$("#memberDescribe2").val(record.memberDescribe2);
			getRzName(record.companyId);//获得公司名字
		};
		function getRzName(companyId){
			var id=companyId;
			 $.ajax({
					url:baseUrl+'enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json', 
					data:'rzId='+id,
					success:function(result){
						console.log(result);
						if(result&&result.record){
							_rzRecords(result.record);												
						}
					}
				}); 
		}; 
		//获得公司名字
		function _rzRecords(record){											
			$("#companyId").val(record.rzName);
			
		};
		$('.hhf-submit').click(function(){
			this.disabled=true;
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
			var params = ['memberId='+memberId+'','memberNickname='+memberNickname+'','memberPhoneNumber='+memberPhoneNumber+'','memberName='+memberName+'','memberBirthdate='+memberBirthdate+'','memberDescribe2='+memberDescribe2+'','companyId='+companyId+''];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberInformationManager/saveMemberInformation.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						alert("修改成功");
						location.reload();
					}
				}
			});
		});	
		//加入企业
		$('.ib-btn').click(function(){
			this.disabled=true;
			var memberId=$("#memberId").html();
			var companyInvitecode=$("#companyInvitecode").val();
			var params = ['memberId='+memberId+'','code='+companyInvitecode+''];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'enterpriseEmployeesManager/acceptEnterpriseInvitation.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						//alert(result.record.html);
						/* $(".f24.fl.c-333").text("您不是企业用户,暂时无法申请!");
						$(".bgtanc.m2").show(); */
						location.reload();
					}
				}
			});
		});	
	</script>
		<script type="text/javascript">
		//处理file input加载的图片文件
		$(document).ready(function(e) {
		    //判断浏览器是否有FileReader接口
		    if(typeof FileReader =='undefined')
		    {
		       $("#destination").css({'background':'none'}).html('亲,您的浏览器还不支持HTML5的FileReader接口,无法使用图片本地预览,请更新浏览器获得最好体验');
		        //如果浏览器是ie
		        if($.browser.msie===true)
		        {
		            //ie6直接用file input的value值本地预览
		            if($.browser.version==6)
		            {
		                $("#imgUpload").change(function(event){                        
		                      //ie6下怎么做图片格式判断?
		                      var src = event.target.value;
		                      //var src = document.selection.createRange().text;        //选中后 selection对象就产生了 这个对象只适合ie
		                      var img = '<img src="'+src+'" width="107px" height="107px" />';
		                      $("#destination").empty().append(img);
		                  });
		            }
		            //ie7,8使用滤镜本地预览
		            else if($.browser.version==7 || $.browser.version==8)
		            {
		                $("#imgUpload").change(function(event){
		                      $(event.target).select();
		                      var src = document.selection.createRange().text;
		                      var dom = document.getElementById('destination');
		                      //使用滤镜 成功率高
		                      dom.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src= src;
		                      dom.innerHTML = '';
		                      //使用和ie6相同的方式 设置src为绝对路径的方式 有些图片无法显示 效果没有使用滤镜好
		                      /*var img = '<img src="'+src+'" width="200px" height="200px" />';
		                      $("#destination").empty().append(img);*/
		                 });
		            }
		        }
		        //如果是不支持FileReader接口的低版本firefox 可以用getAsDataURL接口
		        else if($.browser.mozilla===true)
		        {
		            $("#imgUpload").change(function(event){
		                //firefox2.0没有event.target.files这个属性 就像ie6那样使用value值 但是firefox2.0不支持绝对路径嵌入图片 放弃firefox2.0
		                //firefox3.0开始具备event.target.files这个属性 并且开始支持getAsDataURL()这个接口 一直到firefox7.0结束 不过以后都可以用HTML5的FileReader接口了
		                if(event.target.files)
		                {
		                  //console.log(event.target.files);
		                  for(var i=0;i<event.target.files.length;i++)
		                  {    
		                        var img = '<img src="'+event.target.files.item(i).getAsDataURL()+'" width="107px" height="107px"/>';
		                      $("#destination").empty().append(img);
		                  }
		                }
		                else
		                {
		                    //console.log(event.target.value);
		                    //$("#imgPreview").attr({'src':event.target.value});
		                }
		                });
		        }
		    }
		    else
		    {
		        // version 1
		        /*$("#imgUpload").change(function(e){
		          var file = e.target.files[0];
		          var fReader = new FileReader();
		          //console.log(fReader);
		          //console.log(file);
		          fReader.onload=(function(var_file)
		          {
		              return function(e)
		              {
		                  $("#imgPreview").attr({'src':e.target.result,'alt':var_file.name});
		              }
		          })(file);
		          fReader.readAsDataURL(file);
		          });*/
		          
		          //单图上传 version 2 
		          /*$("#imgUpload").change(function(e){
		                var file = e.target.files[0];
		                var reader = new FileReader();  
		                reader.onload = function(e){
		                    //displayImage($('bd'),e.target.result);
		                    //alert('load');
		                    $("#imgPreview").attr({'src':e.target.result});
		                }
		                reader.readAsDataURL(file);
		              });*/
		          //多图上传 input file控件里指定multiple属性 e.target是dom类型
		           $("#imgUpload").change(function(e){  
		                   for(var i=0;i<e.target.files.length;i++)
		                       {
		                           var file = e.target.files.item(i);
		                        //允许文件MIME类型 也可以在input标签中指定accept属性
		                        //console.log(/^image\/.*$/i.test(file.type));
		                        if(!(/^image\/.*$/i.test(file.type)))
		                        {
		                            continue;            //不是图片 就跳出这一次循环
		                        }
		                        
		                        //实例化FileReader API
		                        var freader = new FileReader();
		                        freader.readAsDataURL(file);
		                        freader.onload=function(e)
		                        {
		                            var img = '<img src="'+e.target.result+'" width="107px" height="107px"/>';
		                            $("#destination").empty().append(img);
		                        }
		                       }
		               });
		               
		          //处理图片拖拽的代码
		          var destDom = document.getElementById('destination');
		          destDom.addEventListener('dragover',function(event){
		              event.stopPropagation();
		              event.preventDefault();
		              },false);
		              
		          destDom.addEventListener('drop',function(event){
		              event.stopPropagation();
		              event.preventDefault();
		              var img_file = event.dataTransfer.files.item(0);                //获取拖拽过来的文件信息 暂时取一个
		              //console.log(event.dataTransfer.files.item(0).type);
		              if(!(/^image\/.*$/.test(img_file.type)))
		              {
		                  alert('您还未拖拽任何图片过来,或者您拖拽的不是图片文件');
		                  return false;
		              }
		              fReader = new FileReader();
		              fReader.readAsDataURL(img_file);
		              fReader.onload = function(event){
		                  destDom.innerHTML='';
		                  destDom.innerHTML = '<img src="'+event.target.result+'" width="107px" height="107px"/>';    
		                  };
		          },false);
		    }
		});
		</script>
		<script type="text/javascript">
		$(function () {
			$("a.c-o").on("click",function(){
				$(this).parent("p").hide().siblings("p").show();
			});
			$(".open-tanc").click(function(){
				$(".bg-tanc").show();
			});
			$("#birthday_container").birthday();
		})
	</script>	
</youi:html>