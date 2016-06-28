$(document)
		.ready(
				function() {
					
					$('#getviewLeaveDetails')
							.click(
									function() {

										window.location.href = 'employeeMenu.do?parameter=getviewLeaveDetails';
									});
					$('#getleaveRequest')
							.click(
									function() {

										window.location.href = 'leaverequest.do?parameter=leaveRequestHome';
									});
								
					$('#getleaveRequestStatus')
							.click(
									function() {
										
										window.location.href = 'employeeMenu.do?parameter=employeeLeaveStatus';
									
									});
				
		   });

function goBack(){
	document.location.href="employeeMenu.do?parameter=home";
}