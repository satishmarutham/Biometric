$(document)
		.ready(
				function() {
					$("#empImage").change(function() {
						readURL(this, 'ImagePreview');
					});
					$('#getPersonalDetails')
							.click(
									function() {

										window.location.href = 'employeeMenu.do?parameter=getEmployeePersonalDetails';
									});
					$('#getAttendancePosting')
							.click(
									function() {

										window.location.href = 'employeeMenu.do?parameter=postattendance';
									});
					$('#getLeaveDetails')
							.click(
									function() {
										
										window.location.href = 'employeeMenu.do?parameter=leaveDetailsHome';

										/*window.location.href = 'leaverequest.do?parameter=leaveRequestHome';*/
									});
					$('#getPasswordDetails')
							.click(
									function() {

										window.location.href = 'employeeMenu.do?parameter=changePassword';
									});
					$('#getExpenseDetails')
							.click(
									function() {
										window.location.href = 'employeeMenu.do?parameter=expenseDetails';
									});
				});
function readURL(input, id) {

	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#' + id).attr('src', e.target.result);
		};

		reader.readAsDataURL(input.files[0]);
	}
}