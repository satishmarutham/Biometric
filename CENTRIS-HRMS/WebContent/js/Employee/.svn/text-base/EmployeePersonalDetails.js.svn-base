$(document)
		.ready(
				function() {

					$('#updateEmpDetail').hide();
					$("#empImage").hide();
					$("#empImage").change(function() {
						readURL(this, 'empImagePreview');
					});

					$("#bloodGroup").css("background-color", "#F2F0E7");
					$("#gender").css("background-color", "#F2F0E7");
					$("#presentAddress").css("background-color", "#F2F0E7");
					$("#permanentAddress").css("background-color", "#F2F0E7");

					$('#employeeDob')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#employeeDob').parent().css({
						'position' : 'relative'
					});

					$('#dateOfJoining')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#dateOfJoining').parent().css({
						'position' : 'relative'
					});

					$('#fatherDOB')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#fatherDOB').parent().css({
						'position' : 'relative'
					});

					$('#motherDOB')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#motherDOB').parent().css({
						'position' : 'relative'
					});

					$('#dateOfMariage')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#dateOfMariage').parent().css({
						'position' : 'relative'
					});

					$('#spouseDOB')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#spouseDOB').parent().css({
						'position' : 'relative'
					});

					$('#firstChildDOB')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#firstChildDOB').parent().css({
						'position' : 'relative'
					});

					$('#secondChildDOB')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#secondChildDOB').parent().css({
						'position' : 'relative'
					});

					$('#passportIssueDate')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#passportIssueDate').parent().css({
						'position' : 'relative'
					});

					$('#passportExpiryDate')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
					$('#passportExpiryDate').parent().css({
						'position' : 'relative'
					});

					$('#main').find('textarea').each(function() {
						$(this).val($(this).val().trim());
					});
					$('#main').find('input[type=text]').each(function() {
						$(this).val($(this).val().trim());
					});
					$('#main').find('input[type=hidden]').each(function() {
						$(this).val($(this).val().trim());
					});

					$(
							"#gender option[value="
									+ $('#hgender').val().trim() + "]").attr(
							'selected', 'true');
					$('#gender').attr("disabled", true);
					$('#bloodGroup').attr("disabled", true);

					/*if ($('#empType').val().trim() != 'OffShore') {
						$('#show_bioId').hide();
					}*/

					$(
							"#bloodGroup option[value='"
									+ $('#hbloodGroup').val().trim() + "']")
							.attr('selected', 'true');

					$('#maritalStatus').attr("disabled", true);
					$("#maritalStatus").css("background-color", "#F2F0E7");
					$(
							"#maritalStatus option[value="
									+ $('#hmaritalStatus').val().trim() + "]")
							.attr('selected', 'true');

					if ($('#hmaritalStatus').val().trim() == "Married") {

					} else {
						$('#marriedRow1').hide();
						$('#marriedRow2').hide();
					}

					$('.accBody').css('display', 'none');
					$('.accBody:first').css('display', 'block');

					$('.head11').click(function() {
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
						$('div .head11:last-child', this).hide();
					});
					$('#downloadEmpDetail')
							.click(
									function() {
										window.location.href = 'getAllReports.do?method=downloadEmployeePersonalDetails';
									});
					$(".datePicker").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
					});
					$(".datePicker_1").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
					});

					$('#updateEmpDetail')
							.click(
									function() {
										var bValid = true;
										$('.error-box').css({
											'visibility' : 'visible'
										});
										
										bValid = bValid
										    && checkRegexpText(
												$('#empFirstName'),
												/^[a-zA-Z. ]+$/i,
												"Employee name field only allow alphabet : a-z ",
												false);
										bValid = bValid
										   && checkRegexpText(
												$('#employeeDob'),
												/^(.)+$/,
												" Select Date Of birth",
												false);
										bValid = bValid
										&& checkRegexpText($('#mobileNo'), /^[0-9]+$/i,
												"Mobile No should be numeric", false);
								
								    bValid = bValid
								        && checkLengthText($('#mobileNo'), "valid mobile number",
										10, 10);
								     
								    bValid = bValid
									&& checkRegexpText($('#personalEmailId'),
											/(^\s*$|([A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+)+)$/i,
											" Enter valid personal Email id ", true);
							
								    
								    
								    
										bValid = bValid
												&& checkRegexpText(
														$('#presentAddress'),
														/([^\s])+$/i,
														"Present address should not empty",
														false);

										bValid = bValid
												&& checkRegexpText(
														$('#fatherName'),
														/^[a-zA-Z. ]+$/i,
														"Father name field only allow alphabet : a-z ",
														false);
										bValid = bValid
												&& checkRegexpText(
														$('#fatherDOB'),
														/^(.)+$/,
														" Select father Date Of birth",
														false);
										bValid = bValid
												&& checkRegexpText(
														$('#motherName'),
														/^[a-zA-Z. ]+$/i,
														"Mother name field only allow alphabet,space and dot symbol : a-z ",
														false);
										bValid = bValid
												&& checkRegexpText(
														$('#motherDOB'),
														/^(.)+$/,
														" Select mother Date Of birth",
														false);
										bValid = bValid
												&& checkRegexpText(
														$('#familyPhoneNo'),
														/^[0-9]+$/i,
														"Family Phone No sholud not be empty",
														false);
										if (bValid
												&& $('#maritalStatus').val() == "Married") {
											bValid = bValid
													&& checkRegexpText(
															$('#dateOfMariage'),
															/^(.)+$/,
															" Select Date Of Marriage",
															false);
											bValid = bValid
													&& checkRegexpText(
															$('#spouseName'),
															/^[a-zA-Z. ]+$/i,
															"Spouse name field only allow alphabet,space and dot symbol : a-z ",
															false);
											bValid = bValid
													&& checkRegexpText(
															$('#spouseDOB'),
															/^(.)+$/,
															" Select spouse Date Of birth",
															false);
										}
									/*	bValid = bValid
												&& checkRegexpText(
														$('#firstChildName'),
														/^(^\s*$|([a-zA-Z. ]+))$/i,
														"Child 1 field only allow alphabet,space and dot symbol : a-z ",
														true);
										bValid = bValid
												&& checkRegexpText(
														$('#firstChildDOB'),
														/^(^\s*$|((.)+))$/,
														" Select child 1 Date Of birth",
														true);
										bValid = bValid
												&& checkRegexpText(
														$('#secondChildName'),
														/^(^\s*$|([a-zA-Z. ]+))$/i,
														"Child 2 field only allow alphabet : a-z ",
														true);
										bValid = bValid
												&& checkRegexpText(
														$('#secondChildDOB'),
														/^(^\s*$|((.)+))$/,
														" Select child 2 Date Of birth",
														true);
*/                                 bValid = bValid
                                         && selectBoxElement($('#majorQualification'),
                                           " Select major qualification");
                                   bValid = bValid
                                    && checkRegexpText($('#yearOfPassing'), /^(.)+$/,
		                              " Select Year of passing", false);	
										bValid = bValid
												&& checkRegexpText(
														$('#universityOrBoard'),
														/^[a-zA-Z. ]+$/i,
														"University Or Board field only allow alphabet : a-z ",
														false);
										bValid = bValid
												&& checkRegexpText(
														$('#collegeOrInstituteName'),
														/^[a-zA-Z. ]+$/i,
														"College Or Institute Name field only allow alphabet : a-z ",
														false);
										
										if (($('#passportNo').val() != '')
												&& ($('#passportNo').val() != undefined)) {
											bValid = bValid
													&& checkRegexpText(
															$('#passportIssueDate'),
															/^(.)+$/,
															" Select Passport Issue Date",
															false);
											bValid = bValid
													&& checkRegexpText(
															$('#passportExpiryDate'),
															/^(.)+$/,
															" Select Passport Expiry Date",
															false);
											bValid = bValid
													&& checkRegexpText(
															$('#passportIssuePlace'),
															/^[a-zA-Z. ]+$/i,
															"Passport Issue Place field only allow alphabet : a-z",
															false);
										}

										var d1 = Date.parse(dateConverter($(
												'#employeeDob').val()));
										var d2 = Date.parse(dateConverter($(
												'#dateOfJoining').val()));
										var d3 = Date.parse(dateConverter($(
												'#dateOfMariage').val()));
										var d4 = Date.parse(dateConverter($(
												'#spouseDOB').val()));
										var d5 = Date.parse(dateConverter($(
												'#firstChildDOB').val()));
										var d6 = Date.parse(dateConverter($(
												'#secondChildDOB').val()));
										var d7 = Date.parse(dateConverter($(
												'#passportIssueDate').val()));
										var d8 = Date.parse(dateConverter($(
												'#passportExpiryDate').val()));
										var d9 = Date.parse(dateConverter($(
												'#fatherDOB').val()));
										var d10 = Date.parse(dateConverter($(
												'#motherDOB').val()));

										if (d1 > d2) {
											$('.error-box')
													.text(
															"DOB Should Be Less than Date of joining");
											bValid = false;
										}
										if (d1 > d3) {
											$('.error-box')
													.text(
															" DOB Should Be Less than Date of Marriage");
											bValid = false;
										}
										if (d4 > d3) {
											$('.error-box')
													.text(
															" Spouse DOB Should Be Less than Date of Marriage");
											bValid = false;
										}
										if (d3 > d5) {
											$('.error-box')
													.text(
															" Child 1 DOB Should Be Greater than Date of Marriage");
											bValid = false;
										}
										if (d3 > d6) {
											$('.error-box')
													.text(
															" Child 2 DOB Should Be Greater than Date of Marriage");
											bValid = false;
										}
										if (d7 > d8) {
											$('.error-box')
													.text(
															" Passport issue Date Should Be Less than Passport expiry Date");
											bValid = false;
										}
										if (d9 > d1) {
											$('.error-box')
													.text(
															" Father DOB Should Be Less than Employee DOB");
											bValid = false;
										}
										if (d10 > d1) {
											$('.error-box')
													.text(
															" Mother DOB Should Be Less than Employee DOB");
											bValid = false;
										}

										if (!bValid) {
											$('.error-box').css({
												'visibility' : 'visible'
											});
										}

										return bValid;
									});

				});
function editable() {
	
	$("#empFirstName").removeAttr("readonly");
	$("#employeeDob").removeAttr("readonly");
	$("#mobileNo").removeAttr("readonly");
	
	$('#updateEmpDetail').show();
	$("#empImage").show();

	if ($('#maritalStatus').val().trim() == "Bachelor") {
		$('#maritalStatus').attr("disabled", false);
		$("#maritalStatus").css("background-color", "white");
	}

	$("#presentAddress").css("background-color", "white");
	$("#presentAddress").removeAttr("readonly");

	$("#personalEmailId").css("background-color", "white");
	$("#personalEmailId").removeAttr("readonly");
	$('#employeeDob').parent().find('.wrap').css({
		'position' : ''
	});
	$('#dateOfJoining').parent().find('.wrap').css({
		'position' : ''
	});
	$('#fatherDOB').parent().find('.wrap').css({
		'position' : ''
	});
	$('#motherDOB').parent().find('.wrap').css({
		'position' : ''
	});
	$('#dateOfMariage').parent().find('.wrap').css({
		'position' : ''
	});
	$('#spouseDOB').parent().find('.wrap').css({
		'position' : ''
	});
	$('#firstChildDOB').parent().find('.wrap').css({
		'position' : ''
	});
	$('#secondChildDOB').parent().find('.wrap').css({
		'position' : ''
	});
	$('#passportIssueDate').parent().find('.wrap').css({
		'position' : ''
	});
	$('#passportExpiryDate').parent().find('.wrap').css({
		'position' : ''
	});

	$("#fatherDOB").css("background-color", "white");
	$("#motherDOB").css("background-color", "white");
	$("#dateOfMariage").css("background-color", "white");
	$("#spouseDOB").css("background-color", "white");
	$("#firstChildDOB").css("background-color", "white");
	$("#secondChildDOB").css("background-color", "white");
	$("#passportIssueDate").css("background-color", "white");
	$("#passportExpiryDate").css("background-color", "white");

	// family details

	$("#fatherName").removeAttr("readonly");
	$("#motherName").removeAttr("readonly");
	$("#spouseName").removeAttr("readonly");
	$("#firstChildName").removeAttr("readonly");
	$("#secondChildName").removeAttr("readonly");
	$("#familyPhoneNo").removeAttr("readonly");

	// Educational Details

	$("#universityOrBoard").removeAttr("readonly");
	$("#collegeOrInstituteName").removeAttr("readonly");

	// Passport Details

	$("#passportIssuePlace").removeAttr("readonly");

	// Company Details

	$("#previousCompanyName").removeAttr("readonly");
	$("#lastCompanyDesignation").removeAttr("readonly");
}
function readURL(input, id) {

	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#' + id).attr('src', e.target.result);
		};

		reader.readAsDataURL(input.files[0]);
	}
}
function getFamilyDetails() {

	if (($('#hmaritalStatus').val().trim() == "Bachelor")
			&& ($('#maritalStatus').val().trim() == "Married")) {
		$('#marriedRow1').show();
		$('#marriedRow2').show();
	} else {
		$('#marriedRow1').hide();
		$('#marriedRow2').hide();
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
function checkPersonalDuplicateEmailId(val) {

	if (val != '' && val != undefined) {
		var result = callAjax(
				"getEmployeePersonalDetails.do?method=checkDuplicatePersonalEmailId",
				{
					'Emp_EmailId' : val
				});
		if (result.response != "") {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$('.error-box').text(result.response);
			$('#personalEmailId').addClass("ui-state-error");
			$('#personalEmailId').focus();
			return false;
		} else {
			$('.error-box').css({
				'visibility' : 'hidden'
			});
			$('.error-box').text("");
			$('#personalEmailId').removeClass("ui-state-error");
			return true;
		}
	}

}
function goback(){
	
	document.location.href="employeeMenu.do?parameter=home";
	
}