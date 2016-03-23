<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="top-nav">
	<div class="top-nav-inner">
		<div class="top-nav-left">
	    	<a><img src="<%=request.getContextPath()%>/styles/images/qiye/logo_park.png" width="110" height="29"></a>
	    </div>
	   	<div class="top-nav-right">
	        <div class="top_search">
	        	<form>
	            	<div class="search_input"><input type="text"><span class="search_btn"><a><img src="<%=request.getContextPath()%>/styles/images/qiye/search_btn.png" width="60" height="35"></a></span></div>
	            </form>
	        </div>
	        <div id="user_info" class="top_name">
	            <a href="">登录</a>
				<a href="../login.html">注册</a>
	        </div>
	    </div>  
	</div>
</header>