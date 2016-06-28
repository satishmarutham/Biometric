

function viewDetils(value) {
	
	var empid=value.id;
	window.location.href="employee.do?parameter=activateEmployee&empid="+empid;
	
	
	
	
}


function viewMoreDetils(value) {
	
	var empid=value.id;
	window.location.href="displayDeactiveEmployees.do?parameter=getDeactiveEmployeeDetails&selectEmployee="+empid;
	
	
	
	
}


