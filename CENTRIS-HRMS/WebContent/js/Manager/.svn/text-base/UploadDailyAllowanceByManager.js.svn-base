$(document)
		.ready(
				function() {
					$('#dailyAllowanceFormat')
							.click(
									function() {
										window.location.href = "getAllReports.do?method=downloadEmployeeDailyAllowanceFormat";
									});

					$("#uploadAllowance")
							.click(
									function() {

										var fileExtension = /([a-z]\w*)(.xlsx|.xlsm|.xls)+$/i;
										if (!(fileExtension.test($(
												'#dailyAllowanceFile').val()
												.trim()))) {
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv")
													.text(
															"Upload Daily Allowance Excel Sheet");
											return false;
										} else {
											$('.error-box').css({
												'visibility' : 'hidden'
											});
											return true;
										}
									});
				});

function downloadFile(path) {
	window.location = "empDailyAllowance.do?method=downloadEmployeeDailyAllowance&downloadFile="
			+ path;
}