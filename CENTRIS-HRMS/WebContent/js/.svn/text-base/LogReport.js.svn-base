

$(document).ready(function(){
	var hdeptId = $('#hdeptId').val();
	var hmanagerId = $('#hmanagerId').val();
	var hemployeeId = $('#hemployeeId').val();
	
	if(hdeptId != undefined){
		
		$("#department option[value='"+hdeptId.trim()+"']").attr('selected', 'true');
		
		$("#manager option[value='"+hmanagerId.trim()+"']").attr('selected', 'true');
		$("#employee option[value='"+hemployeeId.trim()+"']").attr('selected', 'true');
		
	}
	
	$("#sDate,#eDate").datepicker({
		dateFormat : "dd-mm-yy",
		yearRange : 'c-65:c+65',
		maxDate :"-1D",
		changeMonth : "true",
		changeYear : "true",
	});
$('#downloadLog').hide();
if($('#logDetails').find('table').length!=0){
$('#downloadLog').show();
}

	$('#groupId').change(function(){
		var sendGroup = {'group':$(this).val()};
		var result = callAjax("location.do?parameter=getLocationByGroup",sendGroup);
		createSelectBox("#locationId",result.locationList);
	});
	
	$('#locationId').change(function(){
		var sendLocation = {'location':$(this).val(),'group':$("#groupId").val()};
		var result = callAjax("logReport.do?method=getEmpDetailsByLocation",sendLocation);
		createSelectBox("#employeeId",result.empList);
	});
	$('#downloadLog').click(function(){
		
		window.location.href='logReport.do?method=downloadLog&employee='+$("#hemployeeId").val()+' &startDate='+$("#hstartDate").val().trim()+' &endDate='+$("#hendDate").val().trim();
	});
/*	if($('#hgroupId').val().trim()!=""){
		var sendGroup = {'group':$('#hgroupId').val().trim()};
		var result = callAjax("location.do?parameter=getLocationByGroup",sendGroup);
		createSelectBox("#locationId",result.locationList);
		if($('#hlocationId').val().trim()!=""){
			var sendLocation = {'location':$('#hlocationId').val().trim(),'group':$('#hgroupId').val().trim()};
			var result = callAjax("logReport.do?method=getEmpDetailsByLocation",sendLocation);
			createSelectBox("#employeeId",result.empList);
		}
		$('#department [value="'+$('#hdeptId').val().trim()+'"]').attr('selected',true);
		$('#manager [value="'+$('#hmanagerId').val().trim()+'"]').attr('selected',true);
		$('#employee [value="'+$('#hemployeeId').val().trim()+'"]').attr('selected',true);
		
	}*/
	
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

			var result = callAjax("logReport.do?method=getManagers",departmentdetails);
			createSelectBoxWithoutOption("#manager", result.managerlist);
			$('#managercheckbox').attr('checked',false);
			
			

			createEmployee();
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

	/*	var managerid = $("#manager").val();
		var managerdetails = {
			"managerid" : managerid.join()
		};

		var result = callAjax("logReport.do?method=getProjects",managerdetails);
		createSelectBoxWithoutOption("#project", result.projectlist);
		$('#projectcheckbox').attr('checked',false);*/

		createEmployee();

	});
	


	
});



function callAjax(urlWithMethod,dataToBeSend){

	var jsonResult="";
	try{
	$.ajax({
		type : "GET",
		url : urlWithMethod,
		data : dataToBeSend,
		async:false,
		success : function(data) {
			var result = $.parseJSON(data);
			jsonResult=result;
		}
	});
	}
	catch (e) {
		jsonResult="";
	}
	return jsonResult;
}

function createSelectBox(selectboxId,dataForOption){
	var jsonkey=[];
	for( key in dataForOption[0] ){
		if(key.indexOf("Name")!=-1 || key.indexOf("name")!=-1 ){
			jsonkey[1]=key;
		}
		else if(/id$/.test(key) || /code$/.test(key) || /Id$/.test(key)){
			jsonkey[0]=key;
		}
	}
	
	$(selectboxId).empty();
	var selectObject=$(selectboxId);
	var anOption = document.createElement("OPTION");
	anOption.setAttribute("value","");
	anOption.text = "---Select Option---";
	selectObject.append(anOption);
	var anOptionAll = document.createElement("OPTION");
		anOptionAll.setAttribute("value","%%");
		anOptionAll.text = "All";
		selectObject.append(anOptionAll);
	
	for(var i=0;i<dataForOption.length;i++){
		if(dataForOption[i][jsonkey[1]]!=""){
		var anOption = document.createElement("OPTION");
		if(selectboxId==".empClassForAdmin" || selectboxId==".shiftClassForAdmin"){
			anOption.setAttribute("value",dataForOption[i][jsonkey[0]]);
		}
		else{
			anOption.setAttribute("value",dataForOption[i][jsonkey[0]]);
		}
		anOption.text = dataForOption[i][jsonkey[1]];
		selectObject.append(anOption);
		}
	}
	
}

function validateLog(){
	var bvalid=true;
	var department = $("#department").val();
	var manager = $("#manager").val();
	var employee = $("#employee").val();
	var startDate = $("#sDate").val();
	var endDate = $("#eDate").val();

	if (department == null) {

		$("#errordiv").text("Select Department");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid= false;
	} else if (manager == null) {

		$("#errordiv").text("Select Manager");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid= false;

	} else if (employee == null) {
		$("#errordiv").text("Select Employee");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid= false;
	}

	else if (startDate == "") {
		$("#errordiv").text("Select Start Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid= false;
	} else if (endDate == "") {
		$("#errordiv").text("Select End Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid= false;
	}

	return bvalid;	
}

function createEmployee() {
	$('#employeecheckbox').attr('checked', false);
	var departmentid = $('#department').val();
	//var designationid = $("#designation").val();
	var managerid = $("#manager").val();
	//var projectid = $("#project").val();

	if (managerid != null && departmentid != null) {
		var filterdetails = {
			"managerid" : managerid.join(),
			"departmentid" : departmentid.join()
		};

		var result = callAjax("logReport.do?method=getEmployees",filterdetails);
		createSelectBoxWithoutOption("#employee", result.employeeList);

	}
}

function selectAllDepartments() {

	if ($("#departmentcheckbox").is(':checked')) {

		$("#department option").attr('selected', true);

	} else {

		$("#department option").attr('selected', false);
	}

	var departmentid = $("#department").val();
	var departmentdetails = {
		"departmentid" : departmentid.join()
	};
	
	var result = callAjax("logReport.do?method=getManagers",departmentdetails);
	createSelectBoxWithoutOption("#manager", result.managerlist);
	$('#managercheckbox').attr('checked',false);

}


function selectAllManagers(){
	
	if ($("#managercheckbox").is(':checked')) {

		$("#manager option").attr('selected', true);

	} else {

		$("#manager option").attr('selected', false);
	}

	createEmployee();
	
	
}


function selectAllEmployees(){
	
	if ($("#employeecheckbox").is(':checked')) {

		$("#employee option").attr('selected', true);

	} else {

		$("#employee option").attr('selected', false);
	}

	
}
