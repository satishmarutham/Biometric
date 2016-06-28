$(document).ready(function() {
	
	$("#manager").change(function() {

		
		
			var optionlength = $('#manager > option').length;
			var selectedoptionlength = $('#manager :selected').length;

			if (optionlength == selectedoptionlength) {
				$("#managercheckbox").attr('checked', true);
			} 
			else {
				$("#managercheckbox").attr('checked', false);
			}

			

			createEmployee();

		});

	

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
				"departmentid" : departmentid.join()
			};

			var result = callAjax("adminMonthReport.do?parameter=getManagers",departmentdetails);
			
			createSelectBoxWithoutOption("#manager", result.managerlist);
		
			$('#managercheckbox').attr('checked',false);
			
			

			
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

	$('.downloadMonthReport').click(function() {
		var reportType = $(this).attr('id');
		if (reportType == "xls")
			window.location.href = "getAllReports.do?method=downloadMonthXLSReport";
		if (reportType == "pdf")
			window.location.href = "getAllReports.do?method=downloadMonthPDFReport";

	});

	if ($('#hManager').val() != "") {
				var managerManipulation = $('#hManager').val().replace('[', '').replace(']', '').replace(' ', '');
				var sendManger = {
					'managerid' : managerManipulation
				};
				var result = callAjax("adminMonthReport.do?parameter=getProjects",sendManger);
				createSelectBoxWithoutOption("#project",result.projectlist);
				SelectSelectBoxOption('#manager', managerManipulation.split(','));
				SelectCheckBox('#managercheckbox', '#manager');

				if ($('#hProject').val() != "") {
					var projectManipulation = $('#hProject').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#project',projectManipulation.split(','));
					SelectCheckBox('#projectcheckbox', '#project');

					var designationManipulation = $('#hDesignation').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#designation',designationManipulation.split(','));
					SelectCheckBox('#designationcheckbox','#designation');

					var departmentManipulation = $('#hDepartment').val().replace('[', '').replace(']', '').replace(' ', '');
					SelectSelectBoxOption('#department',departmentManipulation.split(','));
					SelectCheckBox('#departmentcheckbox', '#department');

					var hdepartmentid = $('#hDepartment').val().replace('[', '').replace(']', '').replace(' ', '');
					var hdesignationid = $('#hDesignation').val()	.replace('[', '').replace(']', '').replace(' ', '');
					var hmanagerid = $('#hManager').val().replace('[','').replace(']', '').replace(' ', '');
					var hprojectid = $('#hProject').val().replace('[','').replace(']', '').replace(' ', '');
					var hemployee = $('#hEmployee').val().replace('[','').replace(']', '').replace(' ', '');
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

					$('#month [value="'+ $('#hMonth').val().trim() + '"]').attr('selected', true);
					$('#year [value="' + $('#hYear').val().trim()+ '"]').attr('selected', true);

				}

			}

	});

function createEmployee() {
	
	$('#employeecheckbox').attr('checked', false);
	var managerid = $("#manager").val();

	if (managerid != null) {
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

	} else {

		$("#manager option").attr('selected', false);
	}

	
	createEmployee();
	
	
}
function selectAllProjects() {

	if ($("#projectcheckbox").is(':checked')) {

		$("#project option").attr('selected', true);

	} else {

		$("#project option").attr('selected', false);
	}
	createEmployee();

}

function selectAllDesignations() {

	if ($("#designationcheckbox").is(':checked')) {

		$("#designation option").attr('selected', true);

	} else {

		$("#designation option").attr('selected', false);
	}
	createEmployee();
}

function selectAllDepartments() {
	/*alert("select all ");*/

	if ($("#departmentcheckbox").is(':checked')) {

		$("#department option").attr('selected', true);

	} else {

		$("#department option").attr('selected', false);
	}


	
	var departmentid = $("#department").val();
	
		var departmentdetails = {
			"departmentid" : departmentid.join()
		};

		var result = callAjax("adminMonthReport.do?parameter=getManagers",departmentdetails);
		
		createSelectBoxWithoutOption("#manager", result.managerlist);
		
		$('#managercheckbox').attr('checked',false);
		
	
	
	

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
	var month = $('#month').val();
	var year = $('#year').val();

	if (managerid == null || managerid == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Manager");

		return false;

	}  else if (departmentid == null || departmentid == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Deparment");

		return false;
	} else if (employee == null || employee == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Employee");

		return false;
	} else if (month == null || month == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select month");

		return false;

	} else if (year == null || year == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select year");

		return false;

	} else {

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

function SelectSelectBoxOption(selectboxId, dataArray) {

	for ( var p = 0; p < dataArray.length; p++) {
		$(selectboxId + " [value='" + dataArray[p].trim() + "']").attr('selected',true);
	}

}
