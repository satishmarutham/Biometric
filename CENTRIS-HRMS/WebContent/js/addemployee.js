var available = false;
var availableempid = false;
var availableempregno = false;
var locationslist = [];

$(document)
		.ready(
				function() {

					$('.selectedlocations').hide();

					$('#dob').attr("placeholder", "Click here");
					$('#doj').attr("placeholder", "Click here");

					var result;
					var originaldialog;

					$('#addLocationsDialog')
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

														originaldialog = $(
																"#addLocationsDialog")
																.html();

														var updaterowsArray = new Array();
														for ( var i = 0; i < copy.options.length; i++) {
															updaterowsArray
																	.push(copy.options[i].value);
															copy.options[i].value = "";
														}

														if (updaterowsArray.length == 0) {

															alert("please select atleast one locations");
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
																			for ( var i = 0; i < result.status.length; i++) {

																				locationnames = result.status[i]
																						+ ","
																						+ locationnames;
																			}

																			$(
																					'.selectedlocations')
																					.show();
																			$(
																					'.locations')
																					.text(
																							locationnames);

																		}

																	});

															var locations = "";
															for ( var i = 0; i < updaterowsArray.length; i++) {

																locations = updaterowsArray[i]
																		+ ","
																		+ locations;
																locationslist
																		.push(updaterowsArray[i]);

															}

															$(
																	'#allselectedlocations')
																	.val(
																			locations);

															// alert($('#allselectedlocations').val());

															/* deSelectAllData(); */
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
														$("#addLocationsDialog")
																.html(
																		originaldialog);
														$(this).dialog('close');
													}
												} ]
									});

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

				});

function validateEmpForm() {

	var empdepartment = $("#empdepartment").val().trim();
	var father = $("#father").val();
	var dob = $("#dob").val();
	var doj = $("#doj").val();
	var empname = $("#empname").val();
	var empid = $("#empid").val().trim();
	var empmail = $("#empmail").val().trim();
	var empphone = $("#empphone").val();
	var empdesignation = $("#empdesignation").val();
	var empshift = $("#empshift").val();
	var empaddresss = $("#empaddresss").val();
	var emplocation = $("#empLocation").val();
	var empregno = $("#empregnumber").val();
	var regexpforInteger = /^([0-9])+$/;
	var regexpforalphabets = /^[a-zA-Z ]+$/i;
	var regexpforfathername = /^[a-zA-Z ]+\.*[a-zA-Z ]+$/i;
	var regexpforEmailId = /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+$/i;

	if (empid == "") {

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
	} else if (empregno == "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Reg / Roll  Number should not be Empty");

		return false;
	}

	else if (empname.trim() == "") {

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
		$("#errordiv").text("Father Name should not be Empty");

		return false;

	} else if (!(regexpforfathername.test(father.trim()))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Father Name field only allow Alphabet : a-z . ");

		return false;
	} else if (father.trim().length > 80 || father.trim().length < 4) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Length of Father Name must be in between 4 to 80");

		return false;

	} else if (empphone.trim().length > 10 || empphone.trim().length < 10) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Length of Phone Number must be 10");

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
		$("#errordiv").text("Select Date of Join ");

		return false;

	} else if (empaddresss.trim() == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Address field should not be Empty");

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
		$("#errordiv").text("Select Shift ");

		return false;
	}else if(DseCount){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("No.of employees exceeded for selected designation/location");

		return false;
	}
		else {
		

		if (document.getElementById('chechlocations').checked) {

			if (($('#allselectedlocations').val().trim() == "" && $(
					'.locations').val().trim() == "")) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Select Atleast One Location ");

				return false;
			}else {
				
				
				  if (availableempid) {

						$('.error-box').css({
							'visibility' : 'visible'
						});
						$("#errordiv").text(
								"Employee ID Already Exist, Enter new employee ID");

						return false;
					} else if (availableempregno) {

						$('.error-box').css({
							'visibility' : 'visible'
						});
						$("#errordiv").text("Employee Reg / Roll Number Already Exist");

						return false;

					}

					else if (empmail != "") {

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
							$("#errordiv")
									.text("Email ID Already Exist,Enter New Email ID");

							return false;

						} else if (availableempid) {

							$('.error-box').css({
								'visibility' : 'visible'
							});
							$("#errordiv").text(
									"Employee ID already exist, Enter New Employee ID");

							return false;
						} else if (availableempregno) {

							$('.error-box').css({
								'visibility' : 'visible'
							});
							$("#errordiv").text("Employee Reg / Roll Number Already Exist");

							return false;

						} else if (!(chechkemployeeidformat())) {

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

					} else if (availableempid) {

						$('.error-box').css({
							'visibility' : 'visible'
						});
						$("#errordiv").text(
								"Employee ID Already Exist,Enter New Employee ID");

						return false;
					} else if (availableempregno) {

						$('.error-box').css({
							'visibility' : 'visible'
						});
						$("#errordiv").text("Employee Reg / Roll Number already exist");

						return false;

					} else if (!(chechkemployeeidformat())) {

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

		} else if (availableempid) {

			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text(
					"Employee ID Already Exist, Enter new employee ID");

			return false;
		} else if (availableempregno) {

			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Employee Reg / Roll Number Already Exist");

			return false;

		}

		else if (empmail != "") {

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
				$("#errordiv")
						.text("Email ID Already Exist,Enter New Email ID");

				return false;

			} else if (availableempid) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text(
						"Employee ID already exist, Enter New Employee ID");

				return false;
			} else if (availableempregno) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Employee Reg / Roll Number Already Exist");

				return false;

			} else if (!(chechkemployeeidformat())) {

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

		} else if (availableempid) {

			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text(
					"Employee ID Already Exist,Enter New Employee ID");

			return false;
		} else if (availableempregno) {

			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Employee Reg / Roll Number already exist");

			return false;

		} else if (!(chechkemployeeidformat())) {

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

function emailcheck() {

	var empmail = $("#empmail").val().trim();

	var data = {
		"email" : empmail
	};

	if (empmail != "") {
		$.ajax({

			type : "GET",
			url : "AddEmployee.do?parameter=checkEmail",
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
							"Email ID already exist,Enter new Email ID");

				} else {

					available = false;

				}

			}
		});

	}

}

function empidckeck()

{

	var empidv = $('#empid').val();

	var data = {
		"empid" : empidv
	};
	$.ajax({

		type : "GET",
		url : "AddEmployee.do?parameter=checkEmpId",
		data : data,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			if (result.status) {

				availableempid = true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text(
						"Employee ID already exist,Enter new Employee ID");

			} else {

				availableempid = false;

			}

		}
	});

}

function empregnumbercheck() {

	var empregno = $('#empregnumber').val();

	var empdata = {
		"empregno" : empregno
	};

	$
			.ajax({

				type : "GET",
				url : "AddEmployee.do?parameter=checkEmpRegNo",
				data : empdata,
				async : false,
				success : function(response) {
					var result = $.parseJSON(response);

					if (result.status) {

						availableempregno = true;

						$('.error-box').css({
							'visibility' : 'visible'
						});
						$("#errordiv").text(
								"Employee Reg / Roll Number Already Exist");

					} else {

						availableempregno = false;

					}

				}
			});

}

function ischeckedlocations() {

	if (document.getElementById('chechlocations').checked) {

		$('#addLocationsDialog').dialog('open');

	} else {

		/*
		 * var a = document.getElementById('copy'); var
		 * lengthoflocations=a.length; alert(lengthoflocations); for ( var j =
		 * 0; j <lengthoflocations; j++) {
		 * 
		 * a[j].remove();
		 *  }
		 */

		$('.selectedlocations').hide();
		$('#allselectedlocations').val("");
		// $("#allselectedlocations").find('option').attr("selected","") ;
	}
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

	// alert(" Selected values value - "+a[a.options.length].text);
	for ( var count = 0; count < a.length; count++) {
		/* if (a[count].selected) { */

		concatValues = a[count].value + "@" + concatValues;
		concattext = a[count].text + "@" + concattext;

		// a[count].remove();
		/* } */
	}
	// alert(" Selected Data : "+concatValues);

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

function getlocations() {

	var groupid = $("#usergroupid").val();

	var group = {
		"groupid" : groupid
	};

	$.ajax({

		type : "GET",
		url : "AddEmployee.do?parameter=getgroupbasedlocations",
		data : group,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			$("#empLocation").html("");
			$("#empLocation").append(
					'<option value="' + "" + '">' + "-----select-----"
							+ '</option>');
			for ( var j = 0; j < result.status.length; j++) {
				$("#empLocation").append(
						'<option value="' + result.status[j].locationid + '">'
								+ result.status[j].locationname + '</option>');
			}

		}
	});

}

function getshift() {
	
	checkDseCount();

	var locid = $("#empLocation").val();
	var groupid = $("#usergroupid").val();

	var location = {
		"locid" : locid,
		"groupid" : groupid
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
	var location = $('#empLocation').val();

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
	
	
	var locationid=$('#empLocation').val().trim();
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