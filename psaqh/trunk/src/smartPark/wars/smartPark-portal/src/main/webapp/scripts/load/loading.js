//web页面的loadingJS
(function () {
  $.showBox = {
    PageLoading: function () {
        GenerateHtml("pageLoading");
    },
    DataLoading: function () {
        GenerateHtml("dataLoading");
    },
  	ClosePageLoading: function () {
  		closePageLoading();
	},
	CloseDataLoading: function () {
  		closeDataLoading();
	}
  }
 
  //生成Html
  var GenerateHtml = function (type,msg,webRoot) {
    var _html = "";
	   if (type == "pageLoading") {
		   _html += '<div class="clearfix" id="pageLoading">'
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
	   if (type == "dataLoading") {
		   _html += '<div class="clearfix tc" id="dataLoading">'
		   _html += '<img src="../../../styles/images/loading_2.gif" border="0" />'
		   _html += '</div>'
	   }
	   
    $("#loadingShow").append(_html);
  }
  
  //关闭pageLoading页面的显示
  var closePageLoading = function () {
	  $("#pageLoading").addClass("undis");
	};
	
 //关闭dataLoading页面的显示
  var closeDataLoading = function () {
	  $("#dataLoading").addClass("undis");
	};
})();