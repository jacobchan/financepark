<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/url.js"></script>
<script>
	var redirect = '${account.redirect}';
	if(!redirect){
		redirect = proUrl;
	}
	window.location.href=redirect;
</script>
