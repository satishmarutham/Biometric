function validate() {

	var empname = $('#searchempname').val();

	if (empname == "" || empname == null) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Type Employee Name or ID");

		return false;
	} else {

		return true;
	}

}

$(document)
		.ready(
				function() {

					var size = $("#employeeSize").val();
					if (size < 0 || size == 0) {
						$("#download").hide();
					}

					$("#download")
							.click(
									function() {
										if (size > 0) {
											window.location.href = "GetDetails.do?parameter=downloadAllEmployees";
										}
									});
					$("#allDetails")
					.click(
							function() {
								if (size > 0) {
									window.location.href = "GetDetails.do?parameter=downloadAllEmployeeDetails";
								}
							});

				});

