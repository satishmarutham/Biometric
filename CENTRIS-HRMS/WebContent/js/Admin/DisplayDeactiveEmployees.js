var statusFlagpresent = true;
var marriedstatusFlag=true;
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
	var empCode = $('#empCode').val();
	var result = callAjax("employee.do?parameter=checkDuplicateEmailId", {
		'EmailId' : val,
		'EmpCode' : empCode
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
function checkPassportNoUnique(val) {
	var empCode = $('#empCode').val();
	var result = callAjax("employee.do?parameter=checkPassportNoUnique", {
		'PassportNo' : val,
		'EmpCode' : empCode
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

function checkVoterIdUnique(val) {
	var empCode = $('#empCode').val();
	var result = callAjax("employee.do?parameter=checkVoterIdUnique", {
		'VoterId' : val,
		'EmpCode' : empCode
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
	var empCode = $('#empCode').val();
	var result = callAjax("employee.do?parameter=checkPanCardUnique", {
		'PanCardNo' : val,
		'EmpCode' : empCode
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
	var empCode = $('#empCode').val();
	var result = callAjax("employee.do?parameter=checkAddharCardUnique", {
		'AddharCardNo' : val,
		'EmpCode' : empCode
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
	var empCode = $('#empCode').val();
	var result = callAjax("employee.do?parameter=checkDLNoUnique", {
		'DLNo' : val,
		'EmpCode' : empCode
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


function checkAccountNoUnique(val){
	
	if(val.trim() != "")
		{
	var result = callAjax("employee.do?parameter=checkAccountNoUnique",{'AccountNo':val,'EmpCode':''});
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


$(document)
		.ready(
				function() {
					
					if($("#emp").val()!=""){
						
						var cnt=0;
						var check = null;
						var deleteimage_input=null;
						
						
							
						for(var i=1;i<=5;i++){
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
				    	   forminput.setAttribute("class", "docFile");
				    	   forminput.name = "testFile"+cnt;
				    	   td1.appendChild(forminput);
				    	   tr1.appendChild(td1);
				    	
				    	   var flag=false;
				    	   var hfile1=$("#hfile1").val();
				    	   var hfile2=$("#hfile2").val();
				    	   var hfile3=$("#hfile3").val();
				    	   var hfile4=$("#hfile4").val();
				    	   var hfile5=$("#hfile5").val();
				    	   
				    	   
				    	   if(cnt==1){
				    		   
				    	   if(hfile1 != undefined && hfile1 != ""){
				    		   
				    		flag=true;
				    	   
							var td2 = document.createElement("td");
							
							deleteimage_input = document.createElement("input");
							deleteimage_input.type = "button";
					    	deleteimage_input.id = "downloadFile"+cnt;
					    	deleteimage_input.setAttribute("class","downloadDoc");
					    	deleteimage_input.name=hfile1;
					    	
							td2.appendChild(deleteimage_input);
							
							tr1.appendChild(td2);
							
				    	   }
				    	   }
				    	      
				    	   if(cnt==2){
				    		   
				        	   if(hfile2 != undefined && hfile2 != ""){
				        		   
				        		   flag=true;
				        	   
				    			var td2 = document.createElement("td");
				    			
				    			deleteimage_input = document.createElement("input");
				    			deleteimage_input.type = "button";
				    	    	deleteimage_input.id = "downloadFile"+cnt;
				    	    	deleteimage_input.setAttribute("class","downloadDoc");
				    	    	deleteimage_input.name=hfile2;
				    	    	
				    			td2.appendChild(deleteimage_input);
				    			
				    			tr1.appendChild(td2);
				    			
				        	   }
				        	   }
				    	   
				    	   
				    	   
				    	   if(cnt==4){
				    		   
				        	   if(hfile4 != undefined && hfile4 != ""){
				        		   
				        		   flag=true;
				        	   
				    			var td2 = document.createElement("td");
				    			
				    			deleteimage_input = document.createElement("input");
				    			deleteimage_input.type = "button";
				    	    	deleteimage_input.id = "downloadFile"+cnt;
				    	    	deleteimage_input.setAttribute("class","downloadDoc");
				    	    	deleteimage_input.name=hfile4;
				    	    	
				    			td2.appendChild(deleteimage_input);
				    			
				    			tr1.appendChild(td2);
				    			
				        	   }
				        	   }
				    	   
				    	   
				    	   if(cnt==5){
				    		   
				        	   if(hfile5 != undefined && hfile5 != ""){
				        		   
				        		   flag=true;
				        	   
				    			var td2 = document.createElement("td");
				    			
				    			deleteimage_input = document.createElement("input");
				    			deleteimage_input.type = "button";
				    	    	deleteimage_input.id = "downloadFile"+cnt;
				    	    	deleteimage_input.setAttribute("class","downloadDoc");
				    	    	deleteimage_input.name=hfile5;
				    	    	
				    			td2.appendChild(deleteimage_input);
				    			
				    			tr1.appendChild(td2);
				    			
				        	   }
				        	   }
				    	   
				    	   if(cnt==3){
				    		   
				        	   if(hfile3 != undefined && hfile3 != ""){
				        		   
				        		   flag=true;
				        	   
				    			var td2 = document.createElement("td");
				    			
				    			deleteimage_input = document.createElement("input");
				    			deleteimage_input.type = "button";
				    	    	deleteimage_input.id = "downloadFile"+cnt;
				    	    	deleteimage_input.setAttribute("class","downloadDoc");
				    	    	deleteimage_input.name=hfile3;
				    	    	
				    			
				    			td2.appendChild(deleteimage_input);
				    			
				    			tr1.appendChild(td2);
				    			
				        	   }
				        	   }
				    	   
				    	   
				    	   document.getElementById("biometric_1").appendChild(tr1);
				    	   
				    	   $("#"+check.id).text("File Attachement"+cnt);
				    	   if(flag){
				    	   $("#"+deleteimage_input.id).val("Download File"+cnt);
				    	   $("#"+deleteimage_input.id).click(function(){
				   	    	
				   	    	downloadMethod(this.id);
						   
						
				   	    });
				    	   }
				    	   
				    	  
				    	   
				    	   }
					}
					
					
					$("#biometricId").attr("readonly", "readonly");
					

					var desid = $('#hdesignation').val();
					$("#designation option[value=" + desid + "]").attr(
							'selected', 'true');


					var gender = $('#hgender').val();
					$("#gender option[value=" + gender + "]").attr('selected',
							'true');

					var bloodgroup = $('#hbloodGroup').val();

					$("#bloodGroup option[value='" + bloodgroup.trim() + "']")
							.attr('selected', 'true');


	
	var desid=$('#hdesignation').val();
	$("#designation option[value="+desid+"]").attr('selected', 'true');
	
	var gender=$('#hgender').val();
	$("#gender option[value="+gender+"]").attr('selected', 'true');
	
	var bloodgroup=$('#hbloodGroup').val();
	
	$("#bloodGroup option[value='"+bloodgroup.trim()+"']").attr('selected', 'true');
	
	var maritalStatus=$('#hmaritalStatus').val();
	$("#maritalStatus option[value="+maritalStatus+"]").attr('selected', 'true');
	
	var empStatus=$('#hempStatus').val();
	$("#empStatus option[value="+empStatus+"]").attr('selected', 'true');
	
	var empType=$('#hempType').val();
	$("#empType option[value="+empType+"]").attr('selected', 'true');
	
	var majorQualification=$('#hmajorQualification').val();
	$("#majorQualification option[value='"+majorQualification.trim()+"']").attr('selected', 'true');
	
	/*var hprojectname=$('#hprojectname').val();
	
	$("#project option[value="+hprojectname+"]").attr('selected', 'true');*/
	
	
					var maritalStatus = $('#hmaritalStatus').val();
					$("#maritalStatus option[value=" + maritalStatus + "]")
							.attr('selected', 'true');

					var empStatus = $('#hempStatus').val();
					$("#empStatus option[value=" + empStatus + "]").attr(
							'selected', 'true');

					var empType = $('#hempType').val();
					$("#empType option[value=" + empType + "]").attr(
							'selected', 'true');

					var majorQualification = $('#hmajorQualification').val();
					$(
							"#majorQualification option[value='"
									+ majorQualification.trim() + "']").attr(
							'selected', 'true');

				

					$("#securityDocument").change(function() {
						readURL(this, 'securityDocumentPreview');
					});
					$("#empImage").change(function() {
						readURL(this, 'empImagePreview');
					});

					$(".datePicker").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
					/*	onClose : function(selectedDate) {
							
							 var date2 = $('.datePicker').datepicker('getDate');
					         date2.setDate(date2.getDate() + 1);
					         $(".dateofjoin").datepicker("option", "minDate", date2);
							
						}*/

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
					$(".dateofjoin").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
						/*onClose : function(selectedDate) {
							
							
							 var date2 = $('.dateofjoin').datepicker('getDate');
					         date2.setDate(date2.getDate() - 1);
					         $(".datePicker").datepicker("option", "maxDate", date2);
							
							
						}*/

					});
					$("#emp")
							.autocomplete(
									{

										source : function(request, response) {

											$
													.ajax({
														url : "employee.do?parameter=getEmpIdNameBySerachTerm",
														dataType : "json",
														async : false,
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
											
											
											var Table = document.getElementById("biometric_1");
											Table.innerHTML = "";

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
										
										
										if(!marriedstatusFlag){
											

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
										
										if(!statusFlagpresent){
											

											$('#dateOfLeaving').parent().find(
													'.wrap').css({
												'position' : ''
											});
										
											
										}

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

					$('#main').find('textarea').each(function() {
						$(this).val($(this).val().trim());
					});
					$('#main').find('input[type=text]').each(function() {
						$(this).val($(this).val().trim());
					});
					$('#main').find('input[type=hidden]').each(function() {
						$(this).val($(this).val().trim());
					});

					$('.downloadDoc')
							.click(
									function() {
										
										var path = $(this).attr('name');
										window.location.href = "employee.do?parameter=downloadDocument&Path="
												+ path.trim();
									});
				

					$('.downloadDoc')
							.each(
									function() {
										var path = $(this).attr('name');
										if (path != "") {
											
											var pathArray = path.split("__");
											var span = document
													.createElement("span");
											span.innerHTML = "  "
													+ pathArray[pathArray.length - 1];
											$(this).after(span);

											var spanCross = document
													.createElement("span");
											spanCross.innerHTML = "  x";
											spanCross
													.setAttribute('style',
															'font-size:20px;color:red;cursor:pointer;');
											spanCross.setAttribute('class',
													'deleteDoc');
											$(span).after(spanCross);
										}

									});

					$('span.deleteDoc').click(
							function() {/*
								var file = $(this).parent().find('.docFile')
										.css('display');
								if(file==undefined){
									
									file=$(this).parent().find('.downloadDoc')
									.css('display');
								}
								alert(file);
								var button = $(this).parent().find(
										'.downloadDoc').css('display');

								if (file == "none") {
									$(this).parent().find('.docFile').css(
											'display', '');
								}
								if (button == "inline-block") {
									$(this).parent().find('.downloadDoc').css(
											'display', 'none');
									$(this).parent().find('span').remove();
									
								}
							*/
								

								var file = $(this).parent().find('.docFile').css('display');
								var button = $(this).parent().find('.downloadDoc').css('display');
								
								var id = $(this).parent().find('.docFile').attr('id');
							
								var hiddenDocId = "";
								
								if(id==undefined){
									
									id=$(this).parent().find('.downloadDoc').attr('id');
								}

								if (id == "document1") {
									hiddenDocId = "hdoc1";
								}
								if (id == "document2") {
									hiddenDocId = "hdoc2";
								}
								if (id == "document3") {
									hiddenDocId = "hdoc3";
								}
								if (id == "document4") {
									hiddenDocId = "hdoc4";
								
								}if(id == "downloadFile1"){
									
									hiddenDocId = "hfile1";
									
								}if(id == "downloadFile2"){
									
									hiddenDocId = "hfile2";
									
								}if(id == "downloadFile3"){
									
									hiddenDocId = "hfile3";
									
								}if(id == "downloadFile4"){
									
									hiddenDocId = "hfile4";
									
								}if(id == "downloadFile5"){
									
									hiddenDocId = "hfile5";
									
								}
								

								if (file == "none") {
									$(this).parent().find('.docFile').css('display', '');
								}
								if (button == "inline-block") {
									$(this).parent().find('.downloadDoc').css('display', 'none');
									$(this).parent().find('span').remove();
									$('#' + hiddenDocId).prop('value', '');
								}
							
												
							
							
							});

					if ($('#hdoc1').val() == "") {
						$('#document1').css('display', '');
					}
					if ($('#hdoc2').val() == "") {
						$('#document2').css('display', '');
					}
					if ($('#hdoc3').val() == "") {
						$('#document3').css('display', '');
					}
					if ($('#hdoc4').val() == "") {
						$('#document4').css('display', '');
					}

				});


function fillEmployeeDetails(employeeDetails) {
	
	
	$('#empCode').val(employeeDetails[0].empCode);
	$('#empStatus').val(employeeDetails[0].empStatus);
	$('#empFirstName').val(employeeDetails[0].empFirstName);
	
	$('#passportExpiryDate').val(employeeDetails[0].passportExpiryDate);
	$('#dateOfJoining').val(employeeDetails[0].dateOfJoining);
	$('#baseLocation').val(employeeDetails[0].baseLocation);
	$('#designation').val(employeeDetails[0].designation);
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
	/*$('#salaryOffered').val(employeeDetails[0].salaryOffered);*/
	$('#dateOfLeaving').val(employeeDetails[0].dateOfLeaving);

	$('#hdfcAccountNo').val(employeeDetails[0].hdfcAccountNo);
	$('#bankName').val(employeeDetails[0].bankName);
	$('#bankBranchName').val(employeeDetails[0].bankBranchName);
	$('#bankIfscCode').val(employeeDetails[0].bankIfscCode);

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
	$('#empType option[value=' + employeeDetails[0].empType + ']').attr(
			'selected', 'selected');

	
	$('#biometricId').val(employeeDetails[0].biometricId);
	$('#hiddenBioId').val(employeeDetails[0].biometricId);
	



	if (employeeDetails[0].document1 != undefined
			&& employeeDetails[0].document1 != "") {
		$('#document1').css({
			'display' : 'none'
		});
		$('#document1btn').css({
			'display' : ''
		});
		$('#document1btn').attr('name', employeeDetails[0].document1);
		$('#hdoc1').prop('value', employeeDetails[0].document1);
	} else {
		$('#document1btn').css({
			'display' : 'none'
		});
		$('#document1').css({
			'display' : ''
		});

	}
	if (employeeDetails[0].document2 != undefined
			&& employeeDetails[0].document2 != "") {
		$('#document2').css({
			'display' : 'none'
		});
		$('#document2btn').css({
			'display' : ''
		});
		$('#document2btn').attr('name', employeeDetails[0].document2);
		$('#hdoc2').prop('value', employeeDetails[0].document2);
	} else {
		$('#document2btn').css({
			'display' : 'none'
		});
		$('#document2').css({
			'display' : ''
		});

	}
	if (employeeDetails[0].document3 != undefined
			&& employeeDetails[0].document3 != "") {
		$('#document3').css({
			'display' : 'none'
		});
		$('#document3btn').css({
			'display' : ''
		});
		$('#document3btn').attr('name', employeeDetails[0].document3);
		$('#hdoc3').prop('value', employeeDetails[0].document3);
	} else {
		$('#document3btn').css({
			'display' : 'none'
		});
		$('#document3').css({
			'display' : ''
		});

	}
	if (employeeDetails[0].document4 != undefined
			&& employeeDetails[0].document4 != "") {
		$('#document4').css({
			'display' : 'none'
		});
		$('#document4btn').css({
			'display' : ''
		});
		$('#document4btn').attr('name', employeeDetails[0].document4);
		$('#hdoc4').prop('value', employeeDetails[0].document4);
	} else {
		$('#document4btn').css({
			'display' : 'none'
		});
		$('#document4').css({
			'display' : ''
		});
	}
	
	
	if (employeeDetails[0].document4 != undefined
			&& employeeDetails[0].document4 != "") {
		$('#document4').css({
			'display' : 'none'
		});
		$('#document4btn').css({
			'display' : ''
		});
		$('#document4btn').attr('name', employeeDetails[0].document4);
		$('#hdoc4').prop('value', employeeDetails[0].document4);
	} else {
		$('#document4btn').css({
			'display' : 'none'
		});
		$('#document4').css({
			'display' : ''
		});
	}
	
	
	
		var cnt=0;
		var check = null;
		var deleteimage_input=null;
		
		
			
		for(var i=1;i<=5;i++){
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
    	   forminput.setAttribute("class", "docFile");
    	   forminput.name = "testFile"+cnt;
    	   td1.appendChild(forminput);
    	   tr1.appendChild(td1);
    	
    	   var flag=false;
    	   
    	   if(cnt==1){
    		   
    	   if(employeeDetails[0].file1 != undefined && employeeDetails[0].file1 != ""){
    		   
    		   flag=true;
    	   
			var td2 = document.createElement("td");
			
			deleteimage_input = document.createElement("input");
			deleteimage_input.type = "button";
	    	deleteimage_input.id = "downloadFile"+cnt;
	    	deleteimage_input.setAttribute("class","downloadDoc");
	    	deleteimage_input.name=employeeDetails[0].file1;
	    	
	    	$("#hfile1").val(employeeDetails[0].file1);
			
			td2.appendChild(deleteimage_input);
			
			tr1.appendChild(td2);
			
    	   }
    	   }
    	      
    	   if(cnt==2){
    		   
        	   if(employeeDetails[0].file2 != undefined && employeeDetails[0].file2 != ""){
        		   
        		   flag=true;
        	   
    			var td2 = document.createElement("td");
    			
    			deleteimage_input = document.createElement("input");
    			deleteimage_input.type = "button";
    	    	deleteimage_input.id = "downloadFile"+cnt;
    	    	deleteimage_input.setAttribute("class","downloadDoc");
    	    	deleteimage_input.name=employeeDetails[0].file2;
    	    	
    	    	$("#hfile2").val(employeeDetails[0].file2);
    			
    			td2.appendChild(deleteimage_input);
    			
    			tr1.appendChild(td2);
    			
        	   }
        	   }
    	   
    	   
    	   
    	   if(cnt==4){
    		   
        	   if(employeeDetails[0].file4 != undefined && employeeDetails[0].file4 != ""){
        		   
        		   flag=true;
        	   
    			var td2 = document.createElement("td");
    			
    			deleteimage_input = document.createElement("input");
    			deleteimage_input.type = "button";
    	    	deleteimage_input.id = "downloadFile"+cnt;
    	    	deleteimage_input.setAttribute("class","downloadDoc");
    	    	deleteimage_input.name=employeeDetails[0].file4;
    	    	
    	    	$("#hfile4").val(employeeDetails[0].file4);
    			
    			td2.appendChild(deleteimage_input);
    			
    			tr1.appendChild(td2);
    			
        	   }
        	   }
    	   
    	   
    	   if(cnt==5){
    		   
        	   if(employeeDetails[0].file5 != undefined && employeeDetails[0].file5 != ""){
        		   
        		   flag=true;
        	   
    			var td2 = document.createElement("td");
    			
    			deleteimage_input = document.createElement("input");
    			deleteimage_input.type = "button";
    	    	deleteimage_input.id = "downloadFile"+cnt;
    	    	deleteimage_input.setAttribute("class","downloadDoc");
    	    	deleteimage_input.name=employeeDetails[0].file5;
    	    	
    	    	$("#hfile5").val(employeeDetails[0].file5);
    	    	
    			td2.appendChild(deleteimage_input);
    			
    			tr1.appendChild(td2);
    			
        	   }
        	   }
    	   
    	   if(cnt==3){
    		   
        	   if(employeeDetails[0].file3 != undefined && employeeDetails[0].file3 != ""){
        		   
        		   flag=true;
        	   
    			var td2 = document.createElement("td");
    			
    			deleteimage_input = document.createElement("input");
    			deleteimage_input.type = "button";
    	    	deleteimage_input.id = "downloadFile"+cnt;
    	    	deleteimage_input.setAttribute("class","downloadDoc");
    	    	deleteimage_input.name=employeeDetails[0].file3;
    	    	
    	    	$("#hfile3").val(employeeDetails[0].file3);
    	    	
    			
    			td2.appendChild(deleteimage_input);
    			
    			tr1.appendChild(td2);
    			
        	   }
        	   }
    	   
    	   
    	   document.getElementById("biometric_1").appendChild(tr1);
    	   
    	   $("#"+check.id).text("File Attachement"+cnt);
    	   if(flag){
    	   $("#"+deleteimage_input.id).val("Download File"+cnt);
    	   $("#"+deleteimage_input.id).click(function(){
   	    	
   	    	downloadMethod(this.id);
		   
		
   	    });
    	   }
    	   
    	  
    	   
    	   }

	$('.downloadDoc').each(
			function() {
				
				
				var path = $(this).attr('name');
				
				if (path != "") {
					var pathArray = path.split("__");
					var span = document.createElement("span");
					span.innerHTML = "  " + pathArray[pathArray.length - 1];
					$(this).after(span);

					var spanCross = document.createElement("span");
					spanCross.innerHTML = "  x";
					spanCross.setAttribute('style',
							'font-size:20px;color:red;cursor:pointer;');
					spanCross.setAttribute('class', 'deleteDoc');
					$(span).after(spanCross);
				}
			});

	$('span.deleteDoc').click(function() {
		var file = $(this).parent().find('.docFile').css('display');
		var button = $(this).parent().find('.downloadDoc').css('display');
		
		var id = $(this).parent().find('.docFile').attr('id');
	
		var hiddenDocId = "";
		
		if(id==undefined){
			
			id=$(this).parent().find('.downloadDoc').attr('id');
		}

		if (id == "document1") {
			hiddenDocId = "hdoc1";
		}
		if (id == "document2") {
			hiddenDocId = "hdoc2";
		}
		if (id == "document3") {
			hiddenDocId = "hdoc3";
		}
		if (id == "document4") {
			hiddenDocId = "hdoc4";
		
		}if(id == "downloadFile1"){
			
			hiddenDocId = "hfile1";
			
		}if(id == "downloadFile2"){
			
			hiddenDocId = "hfile2";
			
		}if(id == "downloadFile3"){
			
			hiddenDocId = "hfile3";
			
		}if(id == "downloadFile4"){
			
			hiddenDocId = "hfile4";
			
		}if(id == "downloadFile5"){
			
			hiddenDocId = "hfile5";
			
		}
		

		if (file == "none") {
			$(this).parent().find('.docFile').css('display', '');
		}
		if (button == "inline-block") {
			$(this).parent().find('.downloadDoc').css('display', 'none');
			$(this).parent().find('span').remove();
			$('#' + hiddenDocId).prop('value', '');
		}
	});
	
	
	
	
	
	

						if ($('#empStatus').val() == "Present") {
							statusFlagpresent = false;
							$('#dateOfLeaving').val('');
							$('#dateOfLeaving')
									.after(
											'<div class="wrap" style="position:absolute;z-index:0;background: transparent;top: 0;left: 0;width: 100%;height: 100%;"></div>');
							$('#dateOfLeaving').parent().css({
								'position' : 'relative'
							});
						} else if (!statusFlagpresent) {
							$('#dateOfLeaving').parent().find(
									'.wrap').css({
								'position' : ''
							});
						}
						
						
						
						if ($('#maritalStatus').val() == "Bachelor") {
							marriedstatusFlag = false;
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
						} else if (!marriedstatusFlag) {
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
					

}

function validateEmployeeDetails() {
	var bValid = true;
	
	bValid = bValid
			&& checkRegexpText($('#emp'), /^(.)+$/i,
					"Please search any employee", false);
	
	bValid = bValid
			&& checkRegexpText($('#empFirstName'), /^[a-zA-Z ]+$/i,
					"Employee name field only allow alphabet : a-z", false);

	bValid = bValid
			&& checkRegexpText($('#baseLocation'), /^[a-zA-Z ]+$/i,
					"Base Location field only allow alphabet and space : a-z",
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
			"Present address should not empty", false);
	
	
	bValid = bValid
	&& checkRegexpText($('#permanentAddress'), /([^\s])+$/i,
			"Permanent address should not empty", false);
	
	
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
	&& checkRegexpText($('#totalExperience'),  /^[0-9.]+$/i,
			"Total Experience should be numeric and dot symbol", false);


if (bValid && parseFloat($('#totalExperience').val()) > 0) {
	
bValid = bValid
		&& checkRegexpText(
				$('#previousCompanyName'),
				/([^\s])+$/i,
				"Previous company name field only allow alphabet : a-z ",
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
			"University Or Board field should not empty",
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
    	$("#register").hide();
		$('#loader').show();
		
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

function clearALL() {

	$('input[type=text]').val('');
	$('textarea').val('');
	$('select option[value=""]').attr('selected', true);
	$('input[type=checkbox]').attr('checked', false);
	

}
function checkDuplicateBiometricId(val) {

	if (val != '') {

		var result = callAjax(
				"employee.do?parameter=checkDuplicateBiometricId", {
					'BiometricId' : val,
					'EmpCode' : $('#empCode').val()
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
}

function downloadMethod(val){
	
	
	var path = $("#"+val).attr('name');
	window.location.href = "employee.do?parameter=downloadDocument&Path="
			+ path.trim();

	
}
