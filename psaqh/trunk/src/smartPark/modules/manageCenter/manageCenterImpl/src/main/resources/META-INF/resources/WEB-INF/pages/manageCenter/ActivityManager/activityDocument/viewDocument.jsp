<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<div style="position:absolute;left:50px;top:10px;">
	       <div id="documentViewer" class="flexpaper_viewer" style="width:1000px;height:600px"></div>          
   </div>
        
        
	<youi:func name="subpage_init" params="result">
alert(result.html);
	        var startDocument = "Paper";
	        $('#documentViewer').FlexPaperViewer(
	                { config : {

	                    SWFFile :result.html,
	                    Scale : 1,//缩放比例
	                    ZoomTransition : 'easeOut',    //Flexpaper中缩放样式，它使用和Tweener一样的样式，默认参数值为easeOut.其他可选值包括: easenone, easeout, linear, easeoutquad
	                    ZoomTime : 0.5,                //从一个缩放比例变为另外一个缩放比例需要花费的时间，该参数值应该为0或更大。
	                    ZoomInterval : 0.2,            //缩放比例之间间隔，默认值为0.1，该值为正数。
	                    FitPageOnLoad : true,          //初始化的时候自适应页面，与使用工具栏上的适应页面按钮同样的效果。
	                    FitWidthOnLoad : false,        //初始化的时候自适应页面宽度，与工具栏上的适应宽度按钮同样的效果。
	                   	PrintEnabled: true,            //是否支持打印
						FullScreenAsMaxWindow : false, //是否支持全屏,当设置为true的时候，单击全屏按钮会打开一个
	                    ProgressiveLoading : false,    //当设置为true的时候，展示文档时不会加载完整个文档，而是逐步加载，
	                    MinZoomSize : 0.2,             //最小的缩放比例。
	                    MaxZoomSize : 5,               //设置最大的缩放比例。
	                    SearchMatchAll : false,        //设置为true的时候，单击搜索所有符合条件的地方高亮显示。
	                    InitViewMode : 'Portrait',     //启动模式，如”Portrait” or “TwoPage”.
	                    RenderingOrder : 'flash',
	                    StartAtPage : '',

	                    ViewModeToolsVisible : true,   //工具栏上是否显示样式选择框(就是显示缩略图或分页显示的工具)
	                    ZoomToolsVisible : true,       //工具栏上是否显示缩放工具
	                    NavToolsVisible : true,        //工具栏上是否显示导航工具(也就是页码工具)
	                    CursorToolsVisible : true,     //工具栏上是否显示光标工具
	                    SearchToolsVisible : true,     //工具栏上是否显示搜索
	                    WMode : 'window',
	                    localeChain: 'en_US'
	                }}
	        );
	   
	</youi:func> 
</youi:page>