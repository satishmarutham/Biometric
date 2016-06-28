$(document).ready(function() {
	$('.error-box').css({'visibility' : 'hidden'});
	$("#startdateId").datepicker({
		dateFormat : "dd-mm-yy",
		defaultDate : "+1w",
		changeYear : true,
		changeMonth : true,
		numberOfMonths : 1
	});
	$("#enddateId").datepicker({
		dateFormat : "dd-mm-yy",
		defaultDate : "+1w",
		changeYear : true,
		changeMonth : true,
		numberOfMonths : 1
	});
	
	$("#manager").change(function() {

			var optionlength = $('#manager > option').length;
			var selectedoptionlength = $('#manager :selected').length;

			if (optionlength == selectedoptionlength) {
				$("#managercheckbox").attr('checked', true);
			} 
			else {
				$("#managercheckbox").attr('checked', false);
			}
/*
			var managerid = $("#manager").val();
			var managerdetails = {
				"managerid" : managerid.join()
			};*/

		/*	var result = callAjax("adminDayReport.do?method=getProjectssByManagerCode",managerdetails);
			alert(JSON.stringify( result.ProjectList));
			createSelectBoxWithoutOption("#project", result.ProjectList);
			$('#projectcheckbox').attr('checked',false);*/
			createEmployee();

		});
/*
	$("#project").change(function() {

			var optionlength = $('#project > option').length;
			var selectedoptionlength = $('#project :selected').length;

			if (optionlength == selectedoptionlength) {
				$("#projectcheckbox").attr('checked', true);
			} 
			else {
				$("#projectcheckbox").attr('checked', false);
			}

			
			
			
			
			createEmployee();

	});
*/
	

	$("#department").change(function() {
		
		

			var optionlength = $('#department > option').length;
			var selectedoptionlength = $('#department :selected').length;

			if (optionlength == selectedoptionlength) {
				$("#departmentcheckbox").attr('checked', true);
			} 
			else {
				$("#departmentcheckbox").attr('checked', false);
			}
			
			var departmentid = $("#department").val();
			var departmentdetails = {
				"departmentCode" : departmentid.join()
			};

			var result = callAjax("adminDayReport.do?method=getManagersByDirectorCode",departmentdetails);
			
			createSelectBoxWithoutOption("#manager", result.ManagerList);
			$('#managercheckbox').attr('checked',false);
			
			

		/*	createEmployee();*/
	});

	$("#employee").change(function() {

			var optionlength = $('#employee > option').length;
			var selectedoptionlength = $('#employee :selected').length;

			if (optionlength == selectedoptionlength) {
				$("#employeecheckbox").attr('checked', true);
			} 
			else {
				$("#employeecheckbox").attr('checked', false);
			}

	});

	 $('.downloadDayReport').click(function(){
	  	   var reportType=$(this).attr('id');
	  	   if(reportType=="xls")
	  	   window.location.href="getAllReports.do?method=downloadXLSDayReport";
	  	   if(reportType=="pdf")
	      	   window.location.href="getAllReports.do?method=downloadPDFDayReport";
	         
	     });
		

	/*if ($('#hManager').val() != "") {
				var managerManipulation = $('#hManager').val().replace('[', '').replace(']', '').replace(' ', '');
				var sendManger = {
					'managerid' : managerManipulation
				};*/
				/*var result = callAjax("adminMonthReport.do?parameter=getProjects",sendManger);
				createSelectBoxWithoutOption("#project",result.projectlist);
				SelectSelectBoxOption('#manager', managerManipulation.split(','));
				SelectCheckBox('#managercheckbox', '#manager');*/

			/*	if ($('#hProject').val() != "") {
					var projectManipulation = $('#hProject').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#project',projectManipulation.split(','));
					SelectCheckBox('#projectcheckbox', '#project');

					var designationManipulation = $('#hDesignation').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#designation',designationManipulation.split(','));
					SelectCheckBox('#designationcheckbox','#designation');*/
				if ($('#hDepartment').val() != "") {
				
					var departmentManipulation = $('#hDepartment').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#department',departmentManipulation.split(','));
					SelectCheckBox('#departmentcheckbox', '#department');

					/*var hdepartmentid = $('#hDepartment').val().replace('[', '').replace(']', '').replace(' ', '');*/
				}
});


if ($('#hManager').val() != ""){

				
					var managerManipulation = $('#hManager').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#manager',managerManipulation.split(','));
					SelectCheckBox('#managercheckbox', '#manager');

				
				/*	var hemployee = $('#hEmployee').val().replace('[','').replace(']', '').replace(' ', '');
					var filterdetails = {
						"managerid" : hmanagerid,
						"projectid" : hprojectid,
						"designationid" : hdesignationid,
						"departmentid" : hdepartmentid
					};

					var result = callAjax("adminMonthReport.do?parameter=getEmployees",filterdetails);
					createSelectBoxWithoutOption("#employee",result.employeeList);
					SelectSelectBoxOption('#employee', hemployee.split(','));
					SelectCheckBox('#employeecheckbox', '#employee');

					$('#startdateId [value="'+ $('#hstartDate').val().trim() + '"]').attr('selected', true);
					$('#enddateId [value="' + $('#hendDate').val().trim()+ '"]').attr('selected', true);
*/
			
}
		




function filterdetails() {
	$('#employeecheckbox').attr('checked', false);
	var departmentid = $('#department').val();
	
	var managerid = $("#manager").val();
	var projectid = $("#project").val();

	if (managerid != null && projectid != null && departmentid != null) {
		var filterdetails = {
			"managerid" : managerid.join(),
			
		};

		var result = callAjax("adminMonthReport.do?parameter=getEmployees",filterdetails);
		
		createSelectBoxWithoutOption("#employee", result.employeeList);

	}
}

function selectAllManagers() {

	if ($("#managercheckbox").is(':checked')) {

		$("#manager option").attr('selected', true);
	}
		else {

			$("#manager option").attr('selected', false);
		}
	
		/*if (managerid != null) {
			var filterdetails = {
				"managerid" : managerid.join(),
				
			};

			var result = callAjax("adminDayReport.do?method=getEmployees",filterdetails);
			createSelectBoxWithoutOption("#employee",result.employeeList);
			createEmployee();	

		}
*/
	
	
	
	
	/*else {
		$("#manager option").attr('selected', false);
	}
	$('.error-box').css({'visibility' : 'visible'});
	$("#errordiv").text("Select project");
	return false;
	$('#projectcheckbox').attr('checked', false);
	
	*/

	createEmployee();	

	
}
/*function selectAllProjects() {

	if ($("#projectcheckbox").is(':checked')) {

		$("#project option").attr('selected', true);

	} else {

		$("#project option").attr('selected', false);
	}}*/
	





function selectAllDepartments() {

	if ($("#departmentcheckbox").is(':checked')) {

		$("#department option").attr('selected', true);

	} else {

		$("#department option").attr('selected', false);
	}
	var departmentid = $("#department").val();
	var departmentdetails = {
		"departmentCode" : departmentid.join()
	};

	var result = callAjax("adminDayReport.do?method=getManagersByDirectorCode",departmentdetails);
	
	createSelectBoxWithoutOption("#manager", result.ManagerList);
	$('#managercheckbox').attr('checked',false);
	createEmployee();

}

function selectAllEmployees() {

	if ($("#employeecheckbox").is(':checked')) {

		$("#employee option").attr('selected', true);

	} else {

		$("#employee option").attr('selected', false);
	}
	

}

function validations() {

	var managerid = $("#manager").val();
var departmentid = $('#department').val();

var employee = $('#employee').val();
var startdate = $('#startdateId').val();
	 var enddate = $('#enddateId').val();
	 var d1 = Date.parse(dateConverter(startdate));
		var d2 = Date.parse(dateConverter(enddate));
	if (departmentid == null) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Department");

		return false;

	}  else if (managerid == null || managerid == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Manager");

		return false;
	} else if (employee == null || employee == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Employee");

		return false;
	} else if(startdate==null || startdate==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select StartDate");
		
		return false;
		
	}else if(enddate==null || enddate==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select EndDate");
		
		return false;
		
	}
	else if(d1 > d2) {
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Start Date Should Less then End Date");
		

		return false;
	}else {

		return true;
	}

}

function SelectCheckBox(checkboxId, selectboxId) {
	var optionlength = $(selectboxId + ' > option').length;
	var selectedoptionlength = $(selectboxId + ' :selected').length;
	if (optionlength == selectedoptionlength) {
		$(checkboxId).attr('checked', true);
	} else {
		$(checkboxId).attr('checked', false);
	}

}

function SelectCheckBox(checkboxId, selectboxId) {
	var optionlength = $(selectboxId + ' > option').length;
	var selectedoptionlength = $(selectboxId + ' :selected').length;
	if (optionlength == selectedoptionlength) {
		$(checkboxId).attr('checked', true);
	} else {
		$(checkboxId).attr('checked', false);
	}

}

function SelectSelectBoxOption(selectboxId, dataArray) {

	for ( var p = 0; p < dataArray.length; p++) {
		$(selectboxId + " [value='" + dataArray[p].trim() + "']").attr('selected',true);
	}

}
function createEmployee() {
	
	
	$('#employeecheckbox').attr('checked', false);
	var managerid = $("#manager").val();

	if (managerid != null) {
		var filterdetails = {
			"managerid" : managerid.join(),
			
		};

		var result = callAjax("adminDayReport.do?method=getEmployees",filterdetails);
		createSelectBoxWithoutOption("#employee",result.employeeList);
		

	}
}
function dateConverter(dateString) {
	var dateArray = [];
	var dateStringArray = dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;

}
