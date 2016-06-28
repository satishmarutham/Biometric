$(document).ready(function(){
	$('#imgNotification').click(function(){
		window.location.href="attendenceNotApproved.do?parameter=getAttendanceNotApprovedByManager";
	});
	setTimeout(getNotApprovedCount(), 1000);
	
	
});


function getNotApprovedCount(){
	$.ajax({
		url:"attendenceNotApproved.do?parameter=getNotApprovedEmployeeCount",
		async:false,
		success:function(data){
		var notApproved = $.parseJSON(data);
		var notApprovedCount=notApproved.response;
		$('.notification').attr('data-count',(notApprovedCount));
		}
	});
}