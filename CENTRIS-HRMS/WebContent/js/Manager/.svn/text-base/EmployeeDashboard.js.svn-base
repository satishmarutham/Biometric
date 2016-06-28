$(document).ready(function() {
	$('.pagebanner').hide();
	$('.pagelinks').hide();
	
	$('.accordHead').click(function() {
		var displaypro = $(this).next('div').css('display');
		if (displaypro == 'none') {
			$(this).next('div').css({
				'display' : 'block'
			});
		} else {
			$(this).next('div').css({
				'display' : 'none'
			});
		}
	});
});




function leaveDetails(){
	
	var empId=$("#hempId").val();
	document.location.href="managerMenu.do?parameter=getLeaveRequestForApproved&EMPID="+empId;
}


function notApprovedAttendance(){
	
	var startdate=$("#startdate").text();
	var enddate=$("#enddate").text();
	var empId=$("#hempId").val();
	
	
	document.location.href="managerLeaveApprovedbydate.do?parameter=getEmployeeAttendence&startdate="+startdate+"&enddate="+enddate+"&employeename="+empId;
}
function moreAllowanceDeatails(empId){
	
	document.location.href="employeeDashboard.do?method=moreAllowanceDeatailsHome&empId="+empId;
	
	
}

function claimesDetails(empId){
	
	
	document.location.href="managerMenu.do?parameter=getMoreExpenseDetails&empId="+empId;
}


function moreAdvanceSalaryDeatails(empId){
	
	document.location.href="GetDetails.do?parameter=getAdvanceSalaryDetailsFromDashBoard&empId="+empId;
	
}

function moreTravelAllowanceDeatails(empId){
	
	document.location.href="GetDetails.do?parameter=moreTravelAllowanceDeatailsHome&empId="+empId;

 }


function goBack(){
	
	
	document.location.href="managerMenu.do?parameter=home";
	
}

