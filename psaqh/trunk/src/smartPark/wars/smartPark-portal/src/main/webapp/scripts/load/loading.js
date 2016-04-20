//web页面的loadingJS
(function () {
  $.showBox = {
    Loading: function () {
        GenerateHtml("loading");
    },
  	CloseLoading: function () {
  		closeLoading();
	}
  }
 
  //生成Html
  var GenerateHtml = function (type,msg,webRoot) {
    var _html = "";
	   if (type == "loading") {
		   _html += '<div class="clearfix" id="loading">'
		   _html += '	<div id="contain">'
		   _html += '		<div class="wrap" id="wrap1">'
		   _html += '			<div class="part" id="part1"></div>'
		   _html += '		</div>'
		   _html += '		<div class="wrap" id="wrap2">'
		   _html += '			<div class="part" id="part2"></div>'
		   _html += '		</div>'
		   _html += '		<div class="wrap" id="wrap3">'
		   _html += '			<div class="part" id="part3"></div>'
		   _html += '		</div>'
		   _html += '		<div class="wrap" id="wrap4">'
		   _html += '			<div class="part" id="part4"></div>'
		   _html += '		</div>'
		   _html += '	</div>'
		   _html += '</div>'
	   }
    $("#loadingShow").append(_html);
  }
  
  //关闭loadding页面的显示
  var closeLoading = function () {
	  $("#loading").addClass("undis");
	};
})();