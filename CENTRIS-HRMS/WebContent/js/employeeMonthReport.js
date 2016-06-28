$(document)
		.ready(
				function() {

					$("#download")
							.click(
									function() {
										window.location.href = "monthlyReport.do?method=downloadEmploueeinformation";

									});
					
					$("#externaldownload")
					.click(
							function() {
								window.location.href = "monthlyReport.do?method=downloadExternalEmploueeinformation";

							});
					
					$("#viewReport")
					.click(
							function() {
								if (document.getElementById('shiftid').value == "") {

									document.getElementById('error').innerHTML = 'Please Select any Shift';
									return false;
								}
								if (document.getElementById('empdepartment').value == "") {

									document.getElementById('error').innerHTML = 'Please Select any Department';
									return false;
								}
								var x = document.getElementById("year").value;
								if (x == null || x == "") {
									document.getElementById('error').innerHTML = 'Please Select Year';
									return false;
								}
								var x = document.getElementById("month").value;
								if (x == null || x == "") {
									document.getElementById('error').innerHTML = 'Please Select Month';
									return false;
								}
							});
				});