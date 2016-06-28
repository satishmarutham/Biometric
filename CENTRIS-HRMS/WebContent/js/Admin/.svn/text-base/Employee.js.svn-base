function readURL(input, id) {

	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#' + id).attr('src', e.target.result);
		};

		reader.readAsDataURL(input.files[0]);
	}
}

function checkDuplicateEmailId(val) {
	var result = callAjax("employee.do?parameter=checkDuplicateEmailId", {
		'EmailId' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#officialEmailId').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#officialEmailId').removeClass("ui-state-error");
		return true;
	}
}

function checkDuplicateBiometricId(val) {
	var result = callAjax("employee.do?parameter=checkDuplicateBiometricId", {
		'BiometricId' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#biometricId').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#biometricId').removeClass("ui-state-error");
		return true;
	}
}

function checkPassportNoUnique(val) {
	var result = callAjax("employee.do?parameter=checkPassportNoUnique", {
		'PassportNo' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#passportNo').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#passportNo').removeClass("ui-state-error");
		return true;
	}
}

  function checkAccountNoUnique(val){
	  
	 
	  if(val.trim() != "")
		  {
	  
	var result = callAjax("employee.do?parameter=checkAccountNoUnique",{'AccountNo':val.trim(),'EmpCode':''});
	
			if(result.response!=""){
				$('.error-box').css({'visibility': 'visible'});
				$('.error-box').text(result.response);
				$('#hdfcAccountNo').addClass( "ui-state-error" );
				$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
				return false;
			}
			else{
				$('.error-box').css({'visibility': 'hidden'});
				$('.error-box').text("");
				$('#hdfcAccountNo').removeClass("ui-state-error");
				return true;
			}
		  }
}






function checkVoterIdUnique(val) {
	var result = callAjax("employee.do?parameter=checkVoterIdUnique", {
		'VoterId' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#voterIdNo').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#voterIdNo').removeClass("ui-state-error");
		return true;
	}
}

function checkPanCardUnique(val) {
	var result = callAjax("employee.do?parameter=checkPanCardUnique", {
		'PanCardNo' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#panCardNo').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#panCardNo').removeClass("ui-state-error");
		return true;
	}
}

function checkAddharCardUnique(val) {
	var result = callAjax("employee.do?parameter=checkAddharCardUnique", {
		'AddharCardNo' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#addharCardNo').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#addharCardNo').removeClass("ui-state-error");
		return true;
	}
}

function checkDLNoUnique(val) {
	var result = callAjax("employee.do?parameter=checkDLNoUnique", {
		'DLNo' : val,
		'EmpCode' : ''
	});
	if (result.response != "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text(result.response);
		$('#drivingLicenceNo').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$('.error-box').text("");
		$('#drivingLicenceNo').removeClass("ui-state-error");
		return true;
	}
}

$(document)
		.ready(
				function() {
					
					
	var cnt = 0;
					
					$("#fileUploaddynmic").click(function(){
						
							/*var deleteimage_input = null;*/
							var check = null;
							
							
							if(cnt<5){
								cnt++;
				    	   var tr1 = document.createElement("tr");
				    	   
				    	   var td0 = document.createElement("td");
							 check = document.createElement("span");
							check.id = "sno" + cnt;
							check.name = "sno";
							check.style.fontWeight='500';
							td0.appendChild(check);
							
							 tr1.appendChild(td0);
							 
				    	   
				    	   var td1 = document.createElement("td");
				    	   var forminput = document.createElement("input");
				    	   forminput.type="file";
				    	   forminput.setAttribute("class", "formFiles");
				    	   forminput.name = "testFile"+cnt;
				    	   td1.appendChild(forminput);
				    	   
				    	   tr1.appendChild(td1);
				    	   
				    	   /* deleteimage_input = document.createElement("input");
							
							deleteimage_input.type = "image";
							deleteimage_input.name = "delete";
							deleteimage_input.id = "delete"+cnt;
							deleteimage_input.src="images/trash.gif";
											
							var td2 = document.createElement("td");
							td2.appendChild(deleteimage_input);
							tr1.appendChild(td2);*/
				    	   
				    	   document.getElementById("biometric_1").appendChild(tr1);
				    	   
							}else{
								
								$('.error-box').css({
									'visibility' : 'visible'
								});
								$('.error-box').text("You can add only Five  files");
								
								$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
							}
							
				    	   $("#"+check.id).text("File Attachement"+cnt);
				    	  /* $("#"+deleteimage_input.id).click(function(){
				    		   cnt = deletMethod(this.id,cnt);
				    		   
							
							});*/
				    	   
					});
					
					
					
					var hBioId=$("#hbioId").val();
					if(hBioId!=""){
				
						$("#biometricId").val(hBioId);
						$("#biometricId").prop("readonly", true);
						 $("#biometricId").css({'background-color' : '#F2F0E7'});
						
					}
					
					$("#securityDocument").change(function() {
						readURL(this, 'securityDocumentPreview');
					});
					$("#empImage").change(function() {
						readURL(this, 'empImagePreview');
					});
					/*$("#biometricId_td").hide();*/
					$(".datePicker").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						

					});
					
					$(".dateofjoin").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,

					});
					
					$("#dateOfLeaving").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,

					});
					

					$(".dateAfterCurrentDate").datepicker({
						changeMonth : true,
						changeYear : true,
						dateFormat : 'dd-mm-yy'
					});

					$(".yearPicker").datepicker({
						dateFormat : "yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,

					});

					$("#emp")
							.autocomplete(
									{

										source : function(request, response) {
											$
													.ajax({
														url : "employee.do?parameter=getEmpIdNameBySerachTerm",
														dataType : "json",
														data : {
															featureClass : "P",
															style : "full",
															maxRows : 10,
															name_startsWith : request.term
														},
														success : function(data) {
															response($
																	.map(
																			data.response,
																			function(
																					item) {
																				return {
																					label : item.empFirstName,
																					value : item.empCode,
																				}
																			}));

														}

													});
										},
										minLength : 1,
										select : function(event, ui) {

											var searchTerm = ui.item.value;
											employeedetails = {
												'EmpId' : searchTerm
											};
											var employeeDetails = callAjax(
													"employee.do?parameter=searchEmployee",
													employeedetails);

											fillEmployeeDetails(employeeDetails.response);
											$("#emp").val(ui.item.label);
											return false;
										},
									});

					$('#reportingSupervisor')
							.change(
									function() {
										var managerId = $(this).val();
									

										var projectDetails = callAjax(
												"projectManagerMapping.do?parameter=getProjectHead",
												{
													'ManagerVal' : managerId
												});
										createSelectBox("#projectHead",
												projectDetails.ProjectHeadList);

									});
					
					
	$('#firstChildName').change(function(){
						
						if($('#firstChildName').val()==""){
							
							$(
							'#secondChildDOB')
							.after(
									'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
							$(
							'#secondChildName')
							.attr('readonly',
									'readonly');
							
						}else{
							
							$(
							'#secondChildDOB')
							.parent().find('.wrap')
							.css({
								'position' : ''
							});
						
						$('#secondChildName').removeAttr('readonly');
						
							
						}
						
					});
					
					
					var marriedFlag = true;
					$('#maritalStatus')
							.change(
									function() {

										if ($(this).val() == "Bachelor") {
											marriedFlag = false;
											$(
													'#spouseName,#firstChildName,#secondChildName,#dateOfMariage,#spouseDOB,#firstChildDOB,#secondChildDOB')
													.val('');

											$(
													'#dateOfMariage,#spouseDOB,#firstChildDOB,#secondChildDOB')
													.after(
															'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
											$(
													'#dateOfMariage,#spouseDOB,#firstChildDOB,#secondChildDOB')
													.parent().css({
														'position' : 'relative'
													});
											$(
													'#spouseName,#firstChildName,#secondChildName')
													.attr('readonly',
															'readonly');
										} else if (!marriedFlag) {
											$(
											'#dateOfMariage,#spouseDOB,#firstChildDOB,#secondChildDOB')
											.parent().find('.wrap')
											.css({
												'position' : ''
											});
									$(
											'#spouseName,#firstChildName')
											.removeAttr('readonly');
									

									if($('#firstChildName').val()!=""){
										
										$('#secondChildName').removeAttr('readonly');
										
									}

								}

									});
					var statusFlag = true;
					$('#empStatus')
							.change(
									function() {

										if ($(this).val() == "Present") {
											statusFlag = false;
											$('#dateOfLeaving').val('');
											$('#dateOfLeaving')
													.after(
															'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
											$('#dateOfLeaving').parent().css({
												'position' : 'relative'
											});
										} else if (!statusFlag) {
											$('#dateOfLeaving').parent().find(
													'.wrap').css({
												'position' : ''
											});
										}
									});

				});

function fillEmployeeDetails(employeeDetails) {
	

	
	$('#empStatus').val(employeeDetails[0].empStatus);
	$('#empFirstName').val(employeeDetails[0].empFirstName);
	$('#reportingSupervisor').val(employeeDetails[0].managerCode);
	$('#passportExpiryDate').val(employeeDetails[0].passportExpiryDate);
	$('#dateOfJoining').val(employeeDetails[0].dateOfJoining);
	$('#baseLocation').val(employeeDetails[0].baseLocation);
	$('#designation').val(employeeDetails[0].designation);
	$('#department').val(employeeDetails[0].department);
	$('#gender').val(employeeDetails[0].gender);
	$('#bloodGroup').val(employeeDetails[0].bloodGroup);
	$('#dateOfBirth').val(employeeDetails[0].dateOfBirth);
	$('#panCardNo').val(employeeDetails[0].panCardNo);
	$('#voterIdNo').val(employeeDetails[0].voterIdNo);
	$('#addharCardNo').val(employeeDetails[0].addharCardNo);
	$('#drivingLicenceNo').val(employeeDetails[0].drivingLicenceNo);
	$('#permanentAddress').val(employeeDetails[0].permanentAddress);
	$('#presentAddress').val(employeeDetails[0].presentAddress);
	$('#mobileNo').val(employeeDetails[0].mobileNo);
	$('#personalEmailId').val(employeeDetails[0].personalEmailId);
	$('#officialEmailId').val(employeeDetails[0].officialEmailId);
	$('#maritalStatus').val(employeeDetails[0].maritalStatus);
	$('#salaryOffered').val(employeeDetails[0].salaryOffered);
	$('#dateOfLeaving').val(employeeDetails[0].dateOfLeaving);
	$('#hdfcAccountNo').val(employeeDetails[0].hdfcAccountNo);
	$('#passportNo').val(employeeDetails[0].passportNo);
	$('#passportIssueDate').val(employeeDetails[0].passportIssueDate);
	$('#passportIssuePlace').val(employeeDetails[0].passportIssuePlace);
	$('#previousCompanyName').val(employeeDetails[0].previousCompanyName);
	$('#lastCompanyDesignation').val(employeeDetails[0].lastCompanyDesignation);
	$('#lastDrawnSalaryInRS').val(employeeDetails[0].lastDrawnSalaryInRS);
	$('#totalExperience').val(employeeDetails[0].totalExperience);
	$('#majorQualification').val(employeeDetails[0].majorQualification);
	$('#universityOrBoard').val(employeeDetails[0].universityOrBoard);
	$('#yearOfPassing').val(employeeDetails[0].yearOfPassing);
	$('#collegeOrInstituteName').val(employeeDetails[0].collegeOrInstituteName);
	$('#fatherName').val(employeeDetails[0].fatherName);
	$('#fatherDOB').val(employeeDetails[0].fatherDOB);
	$('#motherName').val(employeeDetails[0].motherName);
	$('#motherDOB').val(employeeDetails[0].motherDOB);
	$('#dateOfMariage').val(employeeDetails[0].dateOfMariage);
	$('#spouseName').val(employeeDetails[0].spouseName);
	$('#spouseDOB').val(employeeDetails[0].spouseDOB);
	$('#firstChildName').val(employeeDetails[0].firstChildName);
	$('#firstChildDOB').val(employeeDetails[0].firstChildDOB);
	$('#secondChildName').val(employeeDetails[0].secondChildName);
	$('#secondChildDOB').val(employeeDetails[0].secondChildDOB);
	$('#familyPhoneNo').val(employeeDetails[0].familyPhoneNo);

	$('#securityDocumentPreview').attr('src',
			employeeDetails[0].securityDocument);
	$('#empImagePreview').attr('src', employeeDetails[0].empImage);

	$('#remarks').val(employeeDetails[0].remarks);
	$('#emptype').val(employeeDetails[0].empType);

	$('#sunday').attr('checked', employeeDetails[0].sunday);
	$('#monday').attr('checked', [0].monday);
	$('#tuesday').attr('checked', employeeDetails[0].tuesday);
	$('#wednesday').attr('checked', employeeDetails[0].wednesday);
	$('#thrusday').attr('checked', employeeDetails[0].thrusday);
	$('#friday').attr('checked', employeeDetails[0].friday);
	$('#saturday').attr('checked', employeeDetails[0].saturday);

}

function validateEmployeeDetails() {
	var bValid = true;
	
	bValid = bValid
			&& checkRegexpText($('#empFirstName'), /^[a-zA-Z ]+$/i,
					"Employee name can be only Alphabet and space", false);
	

	bValid = bValid
			&& checkRegexpText($('#baseLocation'), /^[a-zA-Z ]+$/i,
					"Base Location can be only Alphabet and space",
					false);
	
	bValid = bValid
			&& selectBoxElement($('#designation'),
					" Select employee designation");
	
	bValid = bValid
	&& checkRegexpText($('#panCardNo'), /^(^\s*$|([A-Z0-9]+))$/,
			"Pan card no should be alphanumeric in capital letter",
			true);
	

	bValid = bValid
			&& selectBoxElement($('#gender'), " Select employee gender");
	
	bValid = bValid
			&& selectBoxElement($('#bloodGroup'), " Select blood group");
	
	bValid = bValid
			&& selectBoxElement($('#maritalStatus'), " Select marital Status");
	
	
	bValid = bValid
			&& checkRegexpText($('#dateOfBirth'), /^(.)+$/,
					" Select Date Of birth", false);
	
	bValid = bValid
	&& checkRegexpText($('#presentAddress'), /([^\s])+$/i,
			"Present Address Mandatory", false);
	
	bValid = bValid
			&& checkRegexpText($('#permanentAddress'), /([^\s])+$/i,
					"Permanent Address Mandatory", false);
	
	bValid = bValid
	&& checkRegexpText($('#dateOfJoining'), /^(.)+$/,
			" Select Date Of joining", false);

	bValid=bValid && checkMajor($('#dateOfJoining'),$('#dateOfBirth')," Employee age should greter than 18years", false);
	
	
	bValid = bValid
			&& checkRegexpText($('#mobileNo'), /^[0-9]+$/i,
					"Mobile No should be numeric", false);
	
	
	bValid = bValid
	&& checkLengthText($('#mobileNo'), "valid mobile number",
			10, 10);
	
	
	bValid = bValid
			&& checkRegexpText($('#voterIdNo'), /^(^\s*$|([A-Z0-9]+))$/,
					"VoterId no should be alphanumeric in capital letter", true);
	
	bValid = bValid
			&& checkRegexpText($('#addharCardNo'), /^(^\s*$|([A-Z0-9]+))$/,
					"Addhar Card no should be alphanumeric in capital letter",
					true);
	
	
	bValid = bValid
			&& checkRegexpText($('#drivingLicenceNo'), /^(^\s*$|([A-Z0-9]+))$/,
					"DL no should be alphanumeric in capital letter", true);
	
	
	bValid = bValid
			&& checkRegexpText($('#personalEmailId'),
					/(^\s*$|([A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+)+)$/i,
					" Enter valid personal Email id ", true);
	
	
	bValid = bValid
			&& checkRegexpText($('#officialEmailId'),
					/^([A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+)$/i,
					" Enter valid official Email id ", false);
	
	
	bValid = bValid
			&& selectBoxElement($('#empStatus'), " Select Employee Status");
	if (bValid && $('#empStatus').val() == "Left") {
		bValid = bValid
				&& checkRegexpText($('#dateOfLeaving'), /^(.)+$/,
						" Select Date Of leaving", false);
	}else{
		
		$('#dateOfLeaving').val("");
	}
	
	
	bValid = bValid && selectBoxElement($('#empType'), " Select employee Type");
	

	bValid = bValid
				&& checkRegexpText($('#biometricId'), /^[0-9]+$/i,
						"Biometric Id should be numeric", false);
		
	bValid = bValid && checkDuplicateBiometricId($('#biometricId').val());
	
	
	bValid = bValid
			&& checkRegexpText(
					$('#fatherName'),
					/^[a-zA-Z. ]+$/i,
					"Father name field only allow alphabet,space and dot symbol : a-z ",
					false);
	
	
	bValid = bValid
			&& checkRegexpText($('#fatherDOB'), /^(.)+$/,
					" Select father Date Of birth", false);
	
	
	bValid = bValid
			&& checkRegexpText(
					$('#motherName'),
					/^[a-zA-Z. ]+$/i,
					"Mother name field only allow alphabet,space and dot symbol : a-z ",
					false);
	
	
	bValid = bValid
			&& checkRegexpText($('#motherDOB'), /^(.)+$/,
					" Select mother Date Of birth", false);
	
	
	if (bValid && $('#maritalStatus').val() == "Married") {
		
		bValid = bValid
				&& checkRegexpText($('#dateOfMariage'), /^(.)+$/,
						" Select Date Of Marriage", false);
		bValid = bValid
				&& checkRegexpText(
						$('#spouseName'),
						/^[a-zA-Z. ]+$/i,
						"Spouse name field only allow alphabet,space and dot symbol : a-z ",
						false);
		bValid = bValid
				&& checkRegexpText($('#spouseDOB'), /^(.)+$/,
						" Select spouse Date Of birth", false);
	}
	
	bValid = bValid
			&& checkRegexpText(
					$('#firstChildName'),
					/^(^\s*$|([a-zA-Z. ]+))$/i,
					"Child 1 field only allow alphabet,space and dot symbol : a-z ",
					true);
	
	
	bValid = bValid
			&& checkRegexpText($('#firstChildDOB'), /^(^\s*$|((.)+))$/,
					" Select child 1 Date Of birth", true);
	
	
	
	if($('#firstChildName').val()!=""){
		
		$('#secondChildName').parent().find(
		'.wrap').css({
	'position' : ''
		});
		
		$('#secondChildDOB').parent().find(
		'.wrap').css({
	'position' : ''
		});
		
		
	bValid = bValid
			&& checkRegexpText(
					$('#secondChildName'),
					/^(^\s*$|([a-zA-Z. ]+))$/i,
					"Child 2 field only allow alphabet,space and dot symbol : a-z ",
					true);
	
	
	bValid = bValid
			&& checkRegexpText($('#secondChildDOB'), /^(^\s*$|((.)+))$/,
					" Select child 2 Date Of birth", true);
}else{
	
	$('#secondChildName').val('');
	$('#secondChildName')
			.after(
					'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
	$('#secondChildName').parent().css({
		'position' : 'relative'
	});
	
	$('#secondChildDOB').val('');
	$('#secondChildDOB')
			.after(
					'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
	$('#secondChildDOB').parent().css({
		'position' : 'relative'
	});

	
}
	bValid = bValid
			&& checkRegexpText($('#familyPhoneNo'), /^(.)+$/,
					"Family Phone No sholud not be empty", false);
	
	
	bValid = bValid
	&& checkRegexpText($('#familyPhoneNo'), /^[0-9]+$/i,
			"Family phone No should be numeric", false);
	


	bValid = bValid
			&& checkRegexpText($('#passportNo'), /^(^\s*$|([A-Z0-9]+))$/,
					"Passport no should be alphanumeric in capital letter",
					true);
	
	
	if($('#passportNo').val()!=""){
		
		bValid = bValid
		&& checkRegexpText($('#passportIssueDate'), /^(.)+$/,
				" Select pasport issue date", false);
		
		bValid = bValid
		&& checkRegexpText($('#passportExpiryDate'), /^(.)+$/,
				" Select passport expiry date", false);
		
		bValid = bValid
		&& checkRegexpText(
				$('#passportIssuePlace'),
				/^[a-zA-Z ]+$/i,
				"Passport issue place can be only Alphabet and space",
				true);
		
	}
	
	bValid = bValid
			&& checkRegexpText($('#passportIssueDate'), /^(^\s*$|((.)+))$/,
					" Select passport issue date", true);
	
	
	bValid = bValid
			&& checkRegexpText($('#passportExpiryDate'), /^(^\s*$|((.)+))$/,
					" Select passport expiry date", true);
	
	
	bValid = bValid
			&& checkRegexpText($('#passportIssuePlace'),
					/^(^\s*$|([a-zA-Z ]+))$/i,
					"Passport issue place field only allow alphabet : a-z",
					true);

	
	if (bValid && $('#hdfcAccountNo').val().length > 0) {
		bValid = bValid
				&& checkRegexpText($('#hdfcAccountNo'), /^([0-9]+)$/,
						"Account No field should be numeric", false);
		bValid = bValid
				&& checkRegexpText(
						$('#bankName'),
						/^([a-zA-Z. ]+)$/i,
						"Bank Name field only allow alphabet,space and dot symbol : a-z ",
						false);
		bValid = bValid
				&& checkRegexpText(
						$('#bankBranchName'),
						/^([a-zA-Z. ]+)$/i,
						"Branch Name field only allow alphabet,space and dot symbol : a-z ",
						false);
		bValid = bValid
		&& checkRegexpText($('#bankIfscCode'), /^([A-Z]{3,4}[0-9]+)$/,
						"Enter valid IFSC Code", false);
		

	}
	

	bValid = bValid
			&& checkRegexpText($('#totalExperience'), /^[0-9.]+$/i,
					"Total Experience should be numeric and dot symbol", false);
	

	if (bValid && parseFloat($('#totalExperience').val()) > 0) {
		
		bValid = bValid
				&& checkRegexpText(
						$('#previousCompanyName'),
						/([^\s])+$/i,
						"Previous company name field should not empty",
						false);
		
		bValid = bValid
				&& checkRegexpText(
						$('#lastCompanyDesignation'),
						/^[a-zA-Z ]+$/i,
						"Last company designation field only allow alphabet : a-z ",
						false);
		
		bValid = bValid
				&& checkRegexpText(
						$('#lastDrawnSalaryInRS'),
						/^[0-9.]+$/,
						"Last drawn salary In RS should be numeric and dot symbol",
						false);
	}
	

	bValid = bValid
			&& selectBoxElement($('#majorQualification'),
					" Select major qualification");
	
	
	bValid = bValid
			&& checkRegexpText(
					$('#universityOrBoard'),
					/([^\s])+$/i,
					"University Or Board field should not empty ",
					false);
	
	bValid = bValid
			&& checkRegexpText($('#yearOfPassing'), /^(.)+$/,
					" Select Year of passing", false);
	
	bValid = bValid
			&& checkRegexpText(
					$('#collegeOrInstituteName'),
					/([^\s])+$/i,
					"College Or Institute Name field should not empty",
					false);

	
	bValid = bValid
			&& checkRegexpText($('#empImage'), /^(.)+$/,
					"Employee Photo sholud not be empty", false);

	

	var d1 = Date.parse(dateConverter($('#dateOfBirth').val()));
	var d2 = Date.parse(dateConverter($('#dateOfJoining').val()));
	var d3 = Date.parse(dateConverter($('#dateOfMariage').val()));
	var d4 = Date.parse(dateConverter($('#spouseDOB').val()));
	var d5 = Date.parse(dateConverter($('#firstChildDOB').val()));
	var d6 = Date.parse(dateConverter($('#secondChildDOB').val()));
	var d7 = Date.parse(dateConverter($('#passportIssueDate').val()));
	var d8 = Date.parse(dateConverter($('#passportExpiryDate').val()));
	var d9 = Date.parse(dateConverter($('#fatherDOB').val()));
	var d10 = Date.parse(dateConverter($('#motherDOB').val()));
	

	if (d1 >= d2) {
		
		$('.error-box').text(
				"Date of birth Should Be Greater Than Date of joining");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	if (d1 >= d3) {
		$('.error-box').text(
				" Date of birth Should Be Greater Than Date of Marriage");
		
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	if (d4 >= d3) {
		$('.error-box').text(
				" Spouse Date of birth Should Be Greater Than Date of Marriage");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	if (d3 >= d5) {
		$('.error-box').text(
				" Child 1 Date of birth Should Be Less Than Date of Marriage");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	if (d3 >= d6) {
		$('.error-box').text(
				" Child 2 Date of birth Should Be Less Than Date of Marriage");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	
	if (d7 >= d8) {
		$('.error-box')
				.text(
						" Passport issue Date Should Be Greater Than Passport expiry Date");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	if (d9 >= d1) {
		$('.error-box')
				.text(
						" Father date Of birth Should Be Greater Than Employee Date of birth");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}
	if (d10 >= d1) {
		$('.error-box')
				.text(
						" Mother date Of birth Should Be Greater Than Employee Date of birth");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		bValid = false;
	}

	bValid = bValid && checkDuplicateEmailId($('#officialEmailId').val());

	if (!bValid) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
	} else {
		$('#doubleFormSubmition').prop('value', 'FirstTime');
	}

	
	
	if(bValid){
		
		$('#loader').show();
		$("#register").hide();
	}
	return bValid;

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

function getBioId(){
	
	var result = callAjax("employee.do?parameter=refreshBioId");
	
	if (result.BIoId != "") {
		
		$("#biometricId").val(result.BIoId);
		$('.error-box').css({'visibility': 'hidden'});
		$('.error-box').text("");
	}
	
}



