var available = false;
var availableempregno = false;
var locationsid = [];
var locationsname = [];

function callAjax1(urlWithMethod, dataToBeSend) {

	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);
				jsonResult = result.emplist;

			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}

function viewTeacherDeatails(employeelist) {

	$('#empname').val(employeelist[0].empname);
	$('#empid').val(employeelist[0].empid);
	$('#empregnumber').val(employeelist[0].empregnumber);
	$('#father').val(employeelist[0].fathername);
	$('#empphone').val(employeelist[0].phone);
	$('#empmail').val(employeelist[0].email);
	$('#dob').val(employeelist[0].dob);
	$('#doj').val(employeelist[0].doj);
	$('#empaddresss').val(employeelist[0].address);
	$('#doj').val(employeelist[0].doj);
	$('#doj').val(employeelist[0].doj);
	$("#empshift option:selected").text(employeelist[0].shiftname);
	$("#empshift option:selected").val(employeelist[0].shiftid);

	$("#empdepartment option[value=" + employeelist[0].deptid + "]").attr(
			'selected', 'true');
	$("#locationId option[value=" + employeelist[0].emplocation + "]").attr(
			'selected', 'true');
	$("#empdesignation option[value=" + employeelist[0].designation + "]")
			.attr('selected', 'true');

	if (employeelist[0].isempreginmultilocations == 'Y') {

		$('#checknox').prop('checked', true);

		$('.selectedlocations').show();
		var locationslist = employeelist[0].locationslist;
		var locationid = "";
		var locationname = "";
		for ( var i = 0; i < locationslist.length; i++) {

			locationid = locationslist[i].locationid + "," + locationid;
			locationname = locationslist[i].locationname + "," + locationname;
			locationsid.push(locationslist[i].locationid);
			locationsname.push(locationslist[i].locationname);

		}

		$('.locations').text(locationname);
		$('#allselectedlocations').val(locationid);

	} else {

		$('#checknox').prop('checked', false);
	}

}

$(document)
		.ready(
				function() {

					$('.selectedlocations').hide();
					$('#emp').attr("placeholder", "Type Employee Name");

					$("#validateTable").hide();

					if (document.getElementById('checknox').checked) {

						/* $("#textarea").val(""); */

						$('.selectedlocations').show();

					}
					

					var result;

					$("#dob").datepicker(
							{
								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : -1,
								changeMonth : "true",
								changeYear : "true",
								numberOfMonths : 1,
								onClose : function(selectedDate) {
									$("#doj").datepicker("option", "minDate",
											selectedDate);
								}
							});
					$("#doj").datepicker(
							{
								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : 0,
								changeMonth : "true",
								changeYear : "true",
								numberOfMonths : 1,
								onClose : function(selectedDate) {
									$("#dob").datepicker("option", "maxDate",
											selectedDate);
								}
							});

					$('#addLocationsDialogmapping')
							.dialog(
									{

										autoOpen : false,
										height : 450,
										width : 620,
										modal : true,
										resizable : true,
										buttons : [
												{
													text : "Add",
													class : "submitbutton",
													click : function() {

														var updaterowsArray = new Array();
														for ( var i = 0; i < copy.options.length; i++) {
															updaterowsArray
																	.push(copy.options[i].value);
															copy.options[i].value = "";
														}

														if (updaterowsArray.length == 0) {

															alert("Select atleast one location");
														} else {

															var studentslist = {
																"updaterowsArray" : updaterowsArray
															};
															$
																	.ajax({

																		type : "GET",
																		url : "AddEmployee.do?parameter=getlocationnames",
																		data : studentslist,
																		async : false,

																		success : function(
																				data) {

																			result = $
																					.parseJSON(data);
																			var locationnames = "";
																			locationsname = [];
																			for ( var i = 0; i < result.status.length; i++) {

																				locationnames = result.status[i]
																						+ ","
																						+ locationnames;
																				locationsname
																						.push(result.status[i]);
																			}

																			$(
																					'.locations')
																					.text(
																							locationnames);

																		}

																	});

															var locations = "";
															locationsid = [];
															for ( var i = 0; i < updaterowsArray.length; i++) {

																locations = updaterowsArray[i]
																		+ ","
																		+ locations;
																locationsid
																		.push(updaterowsArray[i]);
															}

															$(
																	'#allselectedlocations')
																	.val(
																			locations);

															deSelectAllData();
															$('#copy').find(
																	'option')
																	.remove();

															for ( var i = 0; i < updaterowsArray.length; i++) {

																var option = document
																		.createElement("option");
																option
																		.setAttribute(
																				"value",
																				updaterowsArray[i]);
																option.innerHTML = result.status[i];
																document
																		.getElementById(
																				'original')
																		.appendChild(
																				option);

															}
															$(this).dialog(
																	'close');

														}

													}

												},
												{
													text : "Cancel",
													class : "submitbutton",
													click : function() {
														var a = document
																.getElementById('copy');
														for ( var i = 0; i < a.length; i++) {

															a[i].remove();
														}
														$(this).dialog('close');
													}
												} ]
									});

					$("#emp")
							.autocomplete(
									{

										source : function(request, response) {
											$
													.ajax({
														url : "modifyEmployee.do?parameter=getSearchEmployees",
														dataType : "json",
														data : {
															featureClass : "P",
															style : "full",
															maxRows : 100,
															name_startsWith : request.term
														},
														success : function(data) {

															response($
																	.map(
																			data.empVOlist,

																			function(
																					item) {
																				return {

																					label : item.empname,
																					value : item.empid,

																				}
																			}));

														}

													});
										},
										minLength : 1,
										select : function(event, ui) {

											var searchTerm = ui.item.value;
											employeedetails = {
												'searchTerm' : searchTerm
											};
											var employeelist = callAjax1(
													"modifyEmployee.do?parameter=getModifyEmployeeList",
													employeedetails);

											/* callAjax1(); */
											viewTeacherDeatails(employeelist);
											$("#emp").val(ui.item.label);
											return false;

										},

									});

					// +$('#addLocationsDialogmapping'.)

				});

function validateEmpForm() {
	

	var selectemployee = $('#emp').val().trim();
	var empdepartment = $("#empdepartment").val().trim();
	var father = $("#father").val().trim();
	var dob = $("#dob").val().trim();
	var doj = $("#doj").val().trim();
	var empname = $("#empname").val().trim();
	var empid = $("#empid").val().trim();
	var empmail = $("#empmail").val().trim();
	var empphone = $("#empphone").val().trim();
	var empdesignation = $("#empdesignation").val().trim();
	var empshift = $("#empshift").val();
	var empaddresss = $("#empaddresss").val().trim();
	var emplocation = $("#locationId").val().trim();
	var empregnumber = $("#empregnumber").val().trim();
	var regexpforInteger = /^([0-9])+$/;
	var regexpforalphabets = /^[a-zA-Z ]+$/i;
	var regexpforfathername = /^[a-zA-Z ]+\.*[a-zA-Z ]+$/i;
	var regexpforEmailId = /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+$/i;
	

	if (selectemployee == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Type Employee Name");

		return false;

	} else if (empid == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee ID should not be Empty");

		return false;
	} else if (empid.trim().length > 9 || empid.trim().length < 1) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Length of Employee ID must be in between 1 to 9");

		return false;
	} else if (!(regexpforInteger.test(empid.trim()))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee ID field only allow Integer : 0-9");

		return false;
	} else if (empregnumber == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Reg / Roll Number should not be Empty");

		return false;
	} else if (empname.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Name should not be Empty");

		return false;

	} else if (!(regexpforalphabets.test(empname.trim()))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Name field only allow Alphabet : a-z");

		return false;

	} else if (empname.trim().length > 80 || empname.trim().length < 4) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text(
				"Length of Employee Name must be in between 4 to 80");

		return false;
	} else if (father.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Father Name should not be empty");

		return false;

	} else if (!(regexpforfathername.test(father.trim()))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Father Name field only allow Alphabet : a-z");

		return false;
	} else if (father.trim().length > 80 || father.trim().length < 4) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Length of Father Name must be in between 4 to 80");

		return false;

	} else if (father.trim().length > 80 || father.trim().length < 4) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Length of Father Name must be 10");

		return false;

	} else if (empphone.trim().length > 10 || empphone.trim().length < 10) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Phone Number field only allow Integer : 0-9");

		return false;
	} else if (!(regexpforInteger.test(empphone.trim()))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Phone Number field only allow Integer : 0-9");

		return false;
	} else if (dob.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Date of Birth");

		return false;

	} else if (doj.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Date of Join");
		return false;

	} else if (empaddresss.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee adress should not be Empty");

		return false;

	} else if (empaddresss.trim().length > 80 || empaddresss.trim().length < 5) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text(
				"Length of Employee address must be in between 5 to 80");

		return false;

	} else if (empdesignation.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Designation");

		return false;
	} else if (empdepartment.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Department ");

		return false;
	} else if (emplocation.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Location");

		return false;
	} else if (empshift == null || empshift.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Shift");

		return false;
	}else if(DseCount){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("No.of employees exceeded for selected designation/location");

		return false;
	}

	else {

		if (document.getElementById('checknox').checked) {

			if (($('#allselectedlocations').val().trim() == "" && $(
					'.locations').val().trim() == "")) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Select Atleast One Location ");

				return false;
			}else if (empmail == "") {

				if (availableempregno) {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(
							"Employee Registration number already exist");

					return false;
				}else if (!(chechkemployeeidformat())) {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv")
							.html(
									"<a href = 'locationView.do?parameter=locationView' style='color:red;'>Employee ID not match with Location Index "
											+ locationindexid
											+ ", see all Location Indexes </a>");
					

					return false;
				} else {

					return true;
				}

			} else {

				if (!(regexpforEmailId.test(empmail.trim()))) {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text("Enter valid Email ID");

					return false;

				} else if (available) {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(
							"Email ID Already Exist, Enter New Email ID");

					return false;

				} else if (availableempregno) {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(
							"Employee Registration Number Already Exist");

					return false;
				}else if (!(chechkemployeeidformat())) {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv")
							.html(
											"<a href = 'locationView.do?parameter=locationView' style='color:red;'>Employee ID always start with "
													+ locationindexid
													+ ",for "+ locationnaem+ " see all Location Indexes </a>");
					

					return false;
				}
				else {

					return true;
				}

			}

		}else

		if (empmail == "") {

			if (availableempregno) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text(
						"Employee Registration number already exist");

				return false;
			}else if (!(chechkemployeeidformat())) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv")
						.html(
											"<a href = 'locationView.do?parameter=locationView' style='color:red;'>Employee ID always start with "
													+ locationindexid
													+ ",for "+ locationnaem+ " see all Location Indexes </a>");
				

				return false;
			} else {

				return true;
			}

		} else {

			if (!(regexpforEmailId.test(empmail.trim()))) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Enter valid Email ID");

				return false;

			} else if (available) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text(
						"Email ID Already Exist, Enter New Email ID");

				return false;

			} else if (availableempregno) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text(
						"Employee Registration Number Already Exist");

				return false;
			}else if (!(chechkemployeeidformat())) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv")
						.html(
											"<a href = 'locationView.do?parameter=locationView' style='color:red;'>Employee ID always start with "
													+ locationindexid
													+ ",for "+ locationnaem+ " see all Location Indexes </a>");
				

				return false;
			}
			else {

				return true;
			}

		}

	}

}

function emailcheck() {

	var empmail = $("#empmail").val();
	var empid = $("#empid").val();

	if (empmail == "") {

		available = false;

	} else {

		var data = {
			"email" : empmail,
			"empid" : empid
		};

		$.ajax({

			type : "POST",
			url : "modifyEmployee.do?parameter=checkEmail",
			data : data,
			async : false,

			success : function(response) {
				var result = $.parseJSON(response);

				if (result.status) {

					available = true;

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(
							"Email ID Already Exist, Enter New Email ID");

				} else {

					available = false;

				}

			}
		});

	}

}

function empregnumbercheckupdate() {

	var empregno = $("#empregnumber").val();
	var empid = $("#empid").val();

	var data = {
		"empregno" : empregno,
		"empid" : empid
	};

	$.ajax({

		type : "POST",
		url : "modifyEmployee.do?parameter=checkEmpregNo",
		data : data,
		async : false,

		success : function(response) {
			var result = $.parseJSON(response);

			if (result.status) {

				availableempregno = true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text(
						"Employee Registration Number Already Exist");

			} else {

				availableempregno = false;

			}

		}
	});

}

function locationEmployeemapping() {

	if (document.getElementById('checknox').checked) {

		$('.selectedlocations').show();

	} else {
		$('.selectedlocations').hide();
		$('#allselectedlocations').val("");
		/* $('#textarea').html(); */

	}
}

function maplocations() {

	var locationsidlist = $("#hiddenlocationsid").val();

	var locationsidarray = locationsidlist.split(',');

	var locationsnameslist = $("#textarea").val();

	var locationsnamesarray = locationsnameslist.split(',');

	var a = document.getElementById('copy');
	var b = document.getElementById('original');

	for ( var j = 0; j < a.length; j++) {

		a[j].remove();

	}
	if (locationsidarray.length != 0) {

		for ( var j = 0; j < (locationsidarray.length) - 1; j++) {

			locationsid.push(locationsidarray[j]);
			locationsname.push(locationsnamesarray[j]);

		}

		$("#hiddenlocationsid").val("");
		locationsidarray = [];
	}

	for ( var i = 0; i < locationsid.length; i++) {
		var option = document.createElement("option");
		option.setAttribute("value", locationsid[i]);
		option.innerHTML = locationsname[i];
		document.getElementById('copy').appendChild(option);
	}

	for ( var i1 = 0; i1 < locationsid.length; i1++) {
		for ( var j1 = 0; j1 < b.length; j1++) {
			if (b[j1].value == locationsid[i1]) {
				b[j1].remove();
			}
		}
	}

	$('#addLocationsDialogmapping').dialog('open');

}

function deSelectData() {

	var a = document.getElementById('copy');
	var b = document.getElementById('original');
	var selectedValues = new Array();
	var seelctedTexts = new Array();
	var concatValues = "";
	var concattext = "";
	for ( var count = 0; count < a.length; count++) {
		if (a[count].selected) {
			concatValues = a[count].value + "@" + concatValues;
			concattext = a[count].text + "@" + concattext;
			// a[count].remove();
		}
	}

	var splitValues = concatValues.split("@");
	var splitsText = concattext.split("@");
	for ( var i = 0; i < splitValues.length; i++) {
		if (splitValues[i] != "") {
			selectedValues[i] = splitValues[i];
		}
	}
	for ( var i = 0; i < splitsText.length; i++) {
		if (splitsText[i] != "") {
			seelctedTexts[i] = splitsText[i];
		}
	}
	for ( var i = 0; i < selectedValues.length; i++) {
		var option = document.createElement("option");
		option.setAttribute("value", selectedValues[i]);
		option.innerHTML = seelctedTexts[i];
		document.getElementById('original').appendChild(option);
	}

	remove(concatValues, a);
}

function addtext() {

	var a = document.getElementById('original');
	var b = document.getElementById('copy');
	var selectedValues = new Array();
	var seelctedTexts = new Array();
	var concatValues = "";
	var concattext = "";
	var v = a.length;
	for ( var count = 0; count < a.length; count++) {

		if (a[count].selected) {
			concatValues = a[count].value + "@" + concatValues;
			concattext = a[count].text + "@" + concattext;
			// a[count].remove();
		}
	}

	var splitValues = concatValues.split("@");
	var splitsText = concattext.split("@");
	for ( var i = 0; i < splitValues.length; i++) {
		if (splitValues[i] != "") {
			selectedValues[i] = splitValues[i];
		}
	}
	for ( var i = 0; i < splitsText.length; i++) {
		if (splitsText[i] != "") {
			seelctedTexts[i] = splitsText[i];
		}
	}
	for ( var i = 0; i < selectedValues.length; i++) {
		var option = document.createElement("option");
		option.setAttribute("value", selectedValues[i]);
		option.innerHTML = seelctedTexts[i];
		// option.innerHTML = selectedValues[i];
		document.getElementById('copy').appendChild(option);
	}

	remove(concatValues, a);
}

function addAlltext() {

	var a = document.getElementById('original');
	var b = document.getElementById('copy');
	var selectedValues = new Array();
	var seelctedTexts = new Array();
	var concatValues = "";
	var concattext = "";
	var v = a.length;
	for ( var count = 0; count < a.length; count++) {

		/* if (a[count].selected) { */
		concatValues = a[count].value + "@" + concatValues;
		concattext = a[count].text + "@" + concattext;
		// a[count].remove();
		/* } */
	}

	var splitValues = concatValues.split("@");
	var splitsText = concattext.split("@");
	for ( var i = 0; i < splitValues.length; i++) {
		if (splitValues[i] != "") {
			selectedValues[i] = splitValues[i];
		}
	}
	for ( var i = 0; i < splitsText.length; i++) {
		if (splitsText[i] != "") {
			seelctedTexts[i] = splitsText[i];
		}
	}
	for ( var i = 0; i < selectedValues.length; i++) {
		var option = document.createElement("option");
		option.setAttribute("value", selectedValues[i]);
		option.innerHTML = seelctedTexts[i];
		// option.innerHTML = selectedValues[i];
		document.getElementById('copy').appendChild(option);
	}

	remove(concatValues, a);
}

function deSelectAllData() {

	var a = document.getElementById('copy');
	var b = document.getElementById('original');
	var selectedValues = new Array();
	var seelctedTexts = new Array();
	var concatValues = "";
	var concattext = "";
	for ( var count = 0; count < a.length; count++) {
		/* if (a[count].selected) { */
		concatValues = a[count].value + "@" + concatValues;
		concattext = a[count].text + "@" + concattext;
		// a[count].remove();
		/* } */
	}

	var splitValues = concatValues.split("@");
	var splitsText = concattext.split("@");
	for ( var i = 0; i < splitValues.length; i++) {
		if (splitValues[i] != "") {
			selectedValues[i] = splitValues[i];
		}
	}
	for ( var i = 0; i < splitsText.length; i++) {
		if (splitsText[i] != "") {
			seelctedTexts[i] = splitsText[i];
		}
	}
	for ( var i = 0; i < selectedValues.length; i++) {
		var option = document.createElement("option");
		option.setAttribute("value", selectedValues[i]);
		option.innerHTML = seelctedTexts[i];
		document.getElementById('original').appendChild(option);
	}

	remove(concatValues, a);
}

function remove(concatValues, a) {
	var splitValues = concatValues.split("@");
	var selectedValues = new Array();
	for ( var i = 0; i < splitValues.length; i++) {
		if (splitValues[i] != "") {
			selectedValues[i] = splitValues[i];
		}
	}
	for ( var i = 0; i < selectedValues.length; i++) {
		for ( var j = 0; j < a.length; j++) {
			if (a[j].value == selectedValues[i]) {
				a[j].remove();
			}
		}
	}

}

function getshift() {
	
	checkDseCount();

	var locid = $("#locationId").val();

	var location = {
		"locid" : locid
	};

	$.ajax({

		type : "GET",
		url : "AddEmployee.do?parameter=getlocationbasedshift",
		data : location,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			$("#empshift").html("");
			$("#empshift").append(
					'<option value="' + "" + '">' + "-----select-----"
							+ '</option>');
			for ( var j = 0; j < result.status.length; j++) {
				$("#empshift").append(
						'<option value="' + result.status[j].ai_shift_id + '">'
								+ result.status[j].ai_shift_name + " - "
								+ result.status[j].location + '</option>');
			}

		}
	});

}

var checkempidformate = false;
var locationindexid = null;
var locationnaem=null;
function chechkemployeeidformat() {
	
	
	var empid = $('#empid').val();
	var location = $('#locationId').val();

	var empdata = {
		"empid" : empid,
		"location" : location
	};

	$.ajax({

		type : "GET",
		url : "AddEmployee.do?parameter=chechkemployeeidformat",
		data : empdata,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
			
			var locationdetails=(result.status).split(",");
			var indexid=locationdetails[0];
			var locationname1=locationdetails[1];
			

			var subempid = empid.substr(0, 3);
			var subindex = (indexid).substr(0, 3);

			if (subindex == subempid) {

				checkempidformate = true;

			} else {

				locationindexid = subindex;
				locationnaem=locationname1;

				checkempidformate = false;
			}

		}
	});

	return checkempidformate;

}


var DseCount=false;

function checkDseCount(){
	
	
	var locationid=$('#locationId').val().trim();
	var desid=$('#empdesignation').val().trim();
	
	
	if(locationid != "" && desid != ""){
		
		var dsedata={"locationid":locationid,"desid":desid};
		
		
		$.ajax({

			type : "GET",
			url : "AddEmployee.do?parameter=checkDseCount",
			data : dsedata,
			async : false,
			success : function(response) {
				var result = $.parseJSON(response);
				
			
				if(result.status!="false"){
					
					
					DseCount=true;
					
					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(result.status);
				
				}else{
					
					DseCount=false;
					
					
				}
				

			}
		});
		
		
		
	}
	
	
}
