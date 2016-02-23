<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>

	<div style="position:absolute;left:50px;top:10px;">
	       <div id="documentViewer" class="flexpaper_viewer" style="width:1000px;height:600px"></div>          
        </div>
        
        
	<youi:func name="subpage_init" params="result">
	        var startDocument = "Paper";
	        $('#documentViewer').FlexPaperViewer(
	                { config : {

	                    SWFFile :result.html,
	                    Scale : 0.6,
	                    ZoomTransition : 'easeOut',
	                    ZoomTime : 0.5,
	                    ZoomInterval : 0.2,
	                    FitPageOnLoad : true,
	                    FitWidthOnLoad : false,
	                    FullScreenAsMaxWindow : false,
	                    ProgressiveLoading : false,
	                    MinZoomSize : 0.2,
	                    MaxZoomSize : 5,
	                    SearchMatchAll : false,
	                    InitViewMode : 'Portrait',
	                    RenderingOrder : 'flash',
	                    StartAtPage : '',

	                    ViewModeToolsVisible : true,
	                    ZoomToolsVisible : true,
	                    NavToolsVisible : true,
	                    CursorToolsVisible : true,
	                    SearchToolsVisible : true,
	                    WMode : 'window',
	                    localeChain: 'en_US'
	                }}
	        );
	   
	</youi:func> 
</youi:page>