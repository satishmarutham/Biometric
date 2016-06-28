$(document)
		.ready(
				function() {
					/*$("#validateTable").hide();*/

					$("#datefrom").datepicker(
							{
								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : 0,
								changeMonth : "true",
								changeYear : "true",
								numberOfMonths : 1,
								onClose : function(selectedDate) {
									$("#dateto").datepicker("option",
											"minDate", selectedDate);
								}
							});
					$("#dateto").datepicker(
							{
								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : 0,
								changeMonth : "true",
								changeYear : "true",
								numberOfMonths : 1,
								onClose : function(selectedDate) {
									$("#datefrom").datepicker("option",
											"maxDate", selectedDate);
								}
							});

					// getting the employees
					$("#empdepartment")
							.change(
									function() {

										var shiftVal = $("#shiftid").val();
										var departmentVal = $("#empdepartment").val();
			
										var empdata = {
											"shiftid" : shiftVal,
											"deptid" : departmentVal,
										};
										$
												.ajax({
													type : 'POST',
													url : "timesheetreport.do?parameter=getEmpDetails",
													data : empdata,
													success : function(response) {
														var result = $
																.parseJSON(response);
													/*	$("#employeeId").empty();*/
														if(result.EMPDETAILS.length>0){
															
															$("#employeeId")
															.append(
															'<option value="all">All</option>');
											
														for ( var j = 0; j < result.EMPDETAILS.length; j++) {

															$("#employeeId")
																	.append(
																			
																			'<option value="'
																					+ result.EMPDETAILS[j].empId
																					+ '">'
																					+ result.EMPDETAILS[j].empName
																					+ '</option>');
														}
														}else{
															$("#employeeId").empty();	
														}
													}
												});
									});
					
					
					$("#shiftid")
					.change(
							function (){

								var shiftVal = $("#shiftid").val();
								var departmentVal = $("#empdepartment").val();
	
								var empdata = {
									"shiftid" : shiftVal,
									"deptid" : departmentVal,
								};
								$
										.ajax({
											type : 'POST',
											url : "timesheetreport.do?parameter=getEmpDetails",
											data : empdata,
											success : function(response) {
												var result = $
														.parseJSON(response);
											/*	$("#employeeId").empty();*/
												if(result.EMPDETAILS.length>0){
													
													$("#employeeId")
													.append(
													'<option value="all">All</option>');
									
												for ( var j = 0; j < result.EMPDETAILS.length; j++) {

													$("#employeeId")
															.append(
																	
																	'<option value="'
																			+ result.EMPDETAILS[j].empId
																			+ '">'
																			+ result.EMPDETAILS[j].empName
																			+ '</option>');
												}
												}else{
													$("#employeeId").empty();	
												}
											}
										});
							});
					

					//dialog open
					$("#update-dialog").dialog({
						autoOpen : false,
						center : 1,
						dialogtop : top,
						height : 320,
						width : 1100,
						modal : true,
						draggable : true,
						buttons : {
							"OK" : function() {
								$(this).dialog("close");
							},
						},
					});

					//for hiding the title
					/*$(".ui-dialog-titlebar").hide();*/

				});

// form validations
function validations() {

	var shiftid = $("#shiftid").val();
	var deptid = $("#empdepartment").val();
	var fromdate = $("#datefrom").val();
	var todate = $("#dateto").val();
	var empid = $("#employeeId").val();

	if (shiftid == "") {
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Select shift");
	

		return false;
	} else if (deptid == "") {
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Select department");

		return false;

	} else if (empid == "" || empid == null) {
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Select employee");
		
		return false;

	} else if (fromdate == "") {
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("From date should not be null");
		
		return false;

	} else if (!(todate == "")) {

		var startdate = dateConverter($("#datefrom").val());

		var endDate = dateConverter($("#dateto").val());

		if (startdate > endDate) {
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Enddate should be greterthan startdate");
			
			return false;
		} else {

			return true;
		}

	} else {

		return true;
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

function getTimesheet(parameter) {
	
	
	var timesheetdetails=parameter.split("&");
	var empid=timesheetdetails[0];
	var date=timesheetdetails[1];
	var time=timesheetdetails[2];
	
	var timesheetattendencedetails={"empid":empid,"date":date,"time":time};
	
	$.ajax({
				type : 'POST',
				url : "timesheetreport.do?parameter=getEmpTimeSheet",
				data : timesheetattendencedetails,
				async: false,
				
				success : function(response) {
					var result = $.parseJSON(response);
			
			for(var i=0;i<result.TimeSheet.length;i++){
				 
			
				document.getElementById("prev_intime").innerHTML=result.TimeSheet[i].previntime;
				document.getElementById("prev_outtime").innerHTML=result.TimeSheet[i].prev_outtime;
				document.getElementById("prev_totalhours").innerHTML=result.TimeSheet[i].prev_totalhours;
				document.getElementById("prev_workinghours").innerHTML=result.TimeSheet[i].prev_workinghours;
				document.getElementById("prev_mor_late").innerHTML=result.TimeSheet[i].prev_mor_late;
				document.getElementById("prev_eve_early").innerHTML=result.TimeSheet[i].prev_eve_early;
				document.getElementById("prev_latetime").innerHTML=result.TimeSheet[i].prev_latetime;
				document.getElementById("prev_earlytime").innerHTML=result.TimeSheet[i].prev_earlytime;
				document.getElementById("prev_updated_by").innerHTML=result.TimeSheet[i].modifiedby;
				document.getElementById("prev_updated_time").innerHTML=result.TimeSheet[i].modifieddate;
				
			
				document.getElementById("curr_intime").innerHTML=result.TimeSheet[i].curr_intime;
				document.getElementById("curr_outtime").innerHTML=result.TimeSheet[i].curr_outtime;
				document.getElementById("curr_totalhours").innerHTML=result.TimeSheet[i].curr_totalhours;
				document.getElementById("curr_workinghours").innerHTML=result.TimeSheet[i].curr_workinghours;
				document.getElementById("curr_mor_late").innerHTML=result.TimeSheet[i].curr_mor_late;
				document.getElementById("curr_eve_early").innerHTML=result.TimeSheet[i].curr_eve_early;
				document.getElementById("curr_latetime").innerHTML=result.TimeSheet[i].curr_latetime;
				document.getElementById("curr_earlytime").innerHTML=result.TimeSheet[i].curr_earlytime;
				document.getElementById("curr_updated_by").innerHTML=result.TimeSheet[i].modifiedby;
				document.getElementById("curr_updated_time").innerHTML=result.TimeSheet[i].modifieddate;
			
		  	}
		  
			 $("#update-dialog").dialog("open");
				}
			});

}


