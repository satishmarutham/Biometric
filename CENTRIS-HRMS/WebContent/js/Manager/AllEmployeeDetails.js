
$(document).ready(function(){
	$("#validateTable").hide();
	$(".pagebanner").hide();
	
	$('#search').click(
			function() {
				var searchTermVal = $('#searchTermId').val();
				if (searchTermVal == ""	|| searchTermVal == null) {
					$("#validateTable").show();
					$('.validateTips').text("Search any Employee Details");
					return false;

				} else {
				   document.location.href="EmpDashBoardInManager.do?method=getSearchEmployee&searchTerm="+searchTermVal;
				}
			});

});

