<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/memberCenter/common/ad_head.jsp"%> 
<%@ include file="/WEB-INF/pages/common/memberCenterScriptAndCss.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>活动发布</title>
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
    </script>
</head>
<body style="background-color:#f4f4f4;">
	<!--***top start****************************************-->
	<!--***top end****************************************-->
	<div class="w100">
		<div class="w1200 clearfix pt30 pb50">
			<div class="per-center-box clearfix">
				<div id="youi_page_left" class="fl clearfix"></div>
				<%@ include file="/WEB-INF/pages/memberCenter/common/ad_left.jsp"%> 
				<div class="w1000">
					<h3 class="per-h3"><!-- <a class="f14 c-333" href="">创智汇 / </a><a class="f14 c-333" href="">我发起的活动 / </a> -->发布新活动</h3>
					<div class="clearfix mt40">
						<div class="fb-activity">
							<ul class="clearfix">
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
												<input type="file" id="imgUpload" name="imgUpload" draggable="true" accept=".png,.jpg"/>  <!--允许file控件接受的文件类型-->
												<div class="photo-edit" id="destination" style="width:200px;height:200px;margin-left:0px;">
													<p>编辑 <span class="ml10">封面</span></p>
													<p class="f12">封面图片大小建议：288*195</p>
												</div>				
											</td>
										</tr>
										<tr>
											<th>活动地点</th>
											<td><input type="text" id="applyOrderNumber"></td>
										</tr>
										<tr>
											<th>活动内容</th>
											<td><textarea rows="10" cols="100" id="commentContent"></textarea></td>
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
											<td colspan="2">
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
											</td>
										</tr>
									</tbody>
								</table>
								<a href="javascript:;" class="ib-btn tc  ml15 mr20 prev-step mb30" style="width:110px;">上一步</a>
								<a href="javascript:;" class="ib-btn next-step tc mb30" style="width:110px;">下一步</a>
							</div>
							<div class="fb-list-box undis">
								<table class="flb-table mt30 c-b1 f12 tc"  width="100%">
									<colgroup>
										<col width="60"></col>
										<col width="23.5%"></col>
										<col width="23.5%"></col>
										<col width="23.5%"></col>
										<col></col>
									</colgroup>
									<tbody>
										<tr align="center" class="f14 c-333">
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
										</tr>
									</tbody>
								</table>
								<a href="javascript:;" class="ib-btn tc ml20 mr30 mb30" style="width:110px;" id="submit">保存</a>
								<a href="javascript:;" class="ib-btn tc prev-step mb30" style="width:110px;">上一步</a>
							</div>
						</div>
						
                    </div>  
				</div>
			</div>
		</div>
	</div>
	<!--***bottom start****************************************-->
	<%@ include file="/WEB-INF/pages/memberCenter/common/ad_foot.jsp"%> 
	<!--***bottom end****************************************-->
	<script type="text/javascript">
	$(function () {
		$("#submit").click(function(){
			var applyTitle = $("#applyTitle").val();
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			var deadline=$("#enddate").val();
			var applyMaxuser=$("#applyMaxuser").val();
			var imgUpload=$("#imgUpload").val();
			var applyOrderNumber = $("#applyOrderNumber").val();
			var commentContent = $("#commentContent").val();
			var params=['applyTitle='+applyTitle,'startTime='+startTime,'endTime='+endTime,'deadline='+deadline,'applyMaxuser='+applyMaxuser,'applyOrderNumber='+applyOrderNumber,'commentContent='+commentContent,'activityImage='+imgUpload,];
			//保存
			$.ajax({
				url:baseUrl+'/activityApplyManager/saveActivityApplyForPage.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						alert("发布成功");
					}
				}
			});
		})
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
                      var img = '<img src="'+src+'" width="200px" height="200px" />';
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
                        var img = '<img src="'+event.target.files.item(i).getAsDataURL()+'" width="200px" height="200px"/>';
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
                            var img = '<img src="'+e.target.result+'" width="200px" height="200px"/>';
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
                  destDom.innerHTML = '<img src="'+event.target.result+'" width="200px" height="200px"/>';    
                  };
          },false);
    }
});
</script>
</body>
</html>