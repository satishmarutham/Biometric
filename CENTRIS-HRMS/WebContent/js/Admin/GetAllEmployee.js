$(document).ready(function() {
	
	$("#allDetails").hide();
	$("#download").hide();
	if($('#tableId').find('table').length !=0){
		$("#download").show();
		$("#allDetails").show();
	}

$("#download")
		.click(
				function() {
               
						if ($('#tableId').find('table').length > 0) {
							
							var employeeIds=[];
							
							$("input[name='hiddenemployee']").map(function(){
								
								employeeIds.push($(this).val());
							});
							
							window.location.href = "getAllReports.do?method=downloadAllEmployees&Empids="+employeeIds;
						}
				});

$("#allDetails").click(
		function() {
			
			if ($('#tableId').find('table').length > 0) {
				
				var employeeIds=[];
					
					$("input[name='hiddenemployee']").map(function(){
						
						employeeIds.push($(this).val());
					});
						
				window.location.href = "getAllReports.do?method=downloadAllEmployeeDetails&Empids="+employeeIds;
			}
		});


	
	
	$("#searchempname").autocomplete({
		source : function(request, response) {

			$.ajax({

				url : "GetAllEmployees.do?parameter=autosearchemployee",
				data : {
					searchTerm : request.term
				},
				success : function(data) {
					var result = $.parseJSON(data);

					response($.map(result.jsonResponse, function(item) {

						return {

							label : item.empname,
							value : item.empid,
						};
					}));
				}

			});
		},
		select : function(event, ui) {

			$("#searchempname").val(ui.item.label);

			return false;

		}
	});
	

	
	$("#view-dialog")
	.dialog(
			{
				autoOpen : false,
				center : 1,
				dialogtop : top,
				height : 450,
				width : 750,
				resizable : false,
				modal : true,
				closeOnEscape: true,
				
				
			
			});
	
	//for manager
	
	$("#reset_manager_password")
	.click(
			function() {
				
				var officialMailId=$("#dilogmailId").val();
				
				var dataList = {
					"username" : officialMailId,
					"email" : officialMailId
				};
				$("#loader").show();
				$
						.ajax({
							type : 'POST',
							url : "GetAllEmployees.do?parameter=sendManagerPassword",
							data : dataList,
							success : function(data) {
								var result = $
										.parseJSON(data);

								if (result.message == "errorMessage") {
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Password changed successfully,Mail not sent");
									$('.error-box').css({'visibility' : 'visible'});
									
									
								} else if(result.message == "successMessage"){
									$("#hidecontent")
											.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#succeesDiv").text("We sent You an Email with password,Please check");
									$('.error-box').css({'visibility' : 'visible'});
									
								
								}else{
									
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Unable to reset the password, Try again");
									$('.error-box').css({'visibility' : 'visible'});
									
								}
							}
						});
			
			});
	
	//send admin password
	
	$("#view-dialog #reset_admin_password")
	.click(
			function() {
				
				var officialMailId=$("#dilogmailId").val();
				
				var dataList = {
					"username" : officialMailId,
					"email" : officialMailId
				};
				$("#loader").show();
				$
						.ajax({
							type : 'POST',
							url : "GetAllEmployees.do?parameter=sendAdminPassword",
							data : dataList,
							success : function(data) {
								var result = $
										.parseJSON(data);

								if (result.message == "errorMessage") {
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Password changed successfully,Mail not sent");
									$('.error-box').css({'visibility' : 'visible'});
									
									
								} else if(result.message == "successMessage"){
									$("#hidecontent")
											.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#succeesDiv").text("We sent You an Email with password,Please check");
									$('.error-box').css({'visibility' : 'visible'});
									
								
								}else{
									
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Unable to reset the password, Try again");
									$('.error-box').css({'visibility' : 'visible'});
									
								}
							}
						});
			
			});
	
	//send director password
	
	$("#reset_director_password")
	.click(
			function() {
				
				var officialMailId=$("#dilogmailId").val();
				
				var dataList = {
					"username" : officialMailId,
					"email" : officialMailId
				};
				$("#loader").show();
				$
						.ajax({
							type : 'POST',
							url : "GetAllEmployees.do?parameter=sendDirectorPassword",
							data : dataList,
							success : function(data) {
								var result = $
										.parseJSON(data);


								if (result.message == "errorMessage") {
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Password changed successfully,Mail not sent");
									$('.error-box').css({'visibility' : 'visible'});
									
									
								} else if(result.message == "successMessage"){
									$("#hidecontent")
											.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#succeesDiv").text("We sent You an Email with password,Please check");
									$('.error-box').css({'visibility' : 'visible'});
									
								
								}else{
									
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Unable to reset the password, Try again");
									$('.error-box').css({'visibility' : 'visible'});
									
								}
							}
						});
			
			});
	
	
	//send Employee password
	
	$("#reset_employee_password")
	.click(
			function() {
				
				var officialMailId=$("#dilogmailId").val();
				var dob=$("#dob").text();
				var dataList = {
					"dateofbirth" : dob,
					"emp_official_emailid" : officialMailId
				};
				$("#loader").show();
				$
						.ajax({
							type : 'POST',
							url : "GetAllEmployees.do?parameter=sendEmployeePassword",
							data : dataList,
							success : function(data) {
								var result = $
										.parseJSON(data);
								
								if (result.message == "errorMessage") {
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Password changed successfully,Mail not sent");
									$('.error-box').css({'visibility' : 'visible'});
									
									
								} else if(result.message == "successMessage"){
									$("#hidecontent")
											.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#succeesDiv").text("We sent You an Email with password,Please check");
									$('.error-box').css({'visibility' : 'visible'});
									
								
								}else{
									
									$("#hidecontent")
									.hide();
									$("#loader").hide();
									
									$("#error").show();
									$("#error").text("Unable to reset the password, Try again");
									$('.error-box').css({'visibility' : 'visible'});
									
								}
							}
						});
			
			});
	
	
	
	
});

function search() {
	var sremp = $('#searchempname').val();
	if (sremp == '' || sremp == undefined) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$('.error-box').text("Enter any Search Item");
	} else {
		$('.error-box').css({
			'visibility' : 'hidden'
		});
		$("#allemployee").attr('action',
				'GetAllEmployees.do?parameter=searchEmployee');
		$('#searchemp').val('searchEmployee');
		$("#allemployee").submit();

	}

}

var result;
function callAjaxEmployee(urlWithMethod, dataToBeSend) {
	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				result = $.parseJSON(data);
				jsonResult = result;

			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}


function salaryDeatails(val){
	
	var empdetails=val.id;
	var emp=empdetails.split(",");
	var empid=emp[0];
	var empname=emp[1];
	var empsalary=emp[2];
	var empAcc=emp[3];
	
	
	
	window.location="GetDetails.do?parameter=getEmployeeSalaryDetails&empid="+empid+"&empname="+empname+"&empsal="+empsalary+"&accountNo="+empAcc;
	
	
	
}

function deleteEmployee(val1){
	
	
	var y=0 ;
	var x = confirm("Are you sure you want to delete this Employee");
	
	if (x) {
	
		$.ajax({
		type : "GET",
		url : "employee.do?parameter=checkEmployeeMap",
		data : {"empid":val1.id},
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
				
			if (result.Empdeletevo[0].status!=null) {
				$("#errordiv").show();
				$("#errordiv").text(result.Empdeletevo[0].status);
				$('.error-box').css({'visibility' : 'visible'});
				return false;
			}else{
													
					window.location="employee.do?parameter=deleteEmployee&empid="+val1.id;
					
			}
				
		}

	});
	
	}
}


function viewDetils(value) {
	
	$("#reset_employee_password").hide();
	$("#reset_director_password").hide();
	$("#reset_manager_password").hide();
	$("#reset_admin_password").hide();
	
	$("#block_employee").hide();
	$("#block_director").hide();
	$("#block_manager").hide();
	$("#block_admin").hide();
	
	$.ajax({
		type : "GET",
		url : "GetAllEmployees.do?parameter=getEmpDetailsForView",
		data : {"empid":value.id},
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
				
	
	$("#dialogempId").val(result.dialogVoList[0].empId);
	$("#empName").text(result.dialogVoList[0].empName);
	$("#baseLocation").text(result.dialogVoList[0].location);
	$("#qualification").text(result.dialogVoList[0].qualification);
	$("#dob").text(result.dialogVoList[0].dob);
	$("#doj").text(result.dialogVoList[0].doj);
	$("#presentAddress").text(result.dialogVoList[0].presentAddress);
	$("#dilogmailId").val(result.dialogVoList[0].officialMailId);
	$('#empImagePreview').attr('src', result.dialogVoList[0].image);
				
		}

	});
	
	
	

	$("#errordiv").hide();
	$("#view-dialog").dialog("open");
	
	
}


function restPassword(){
	
	$("#block_employee").hide();
	$("#block_director").hide();
	$("#block_manager").hide();
	$("#block_admin").hide();
	
	var empId=$("#dialogempId").val();
	getPermissions(empId,'restpassword');
}


function blockUser(){
	
	
	$("#reset_employee_password").hide();
	$("#reset_director_password").hide();
	$("#reset_manager_password").hide();
	$("#reset_admin_password").hide();
	
	var empId=$("#dialogempId").val();
	getPermissions(empId,'blockuser');
	
	
}


function deleteEmployee(){
	
	var empId=$("#dialogempId").val();
	
	var x = confirm("Are you sure you want to delete this Employee");
	
	if (x) {
	
		$.ajax({
		type : "GET",
		url : "employee.do?parameter=checkEmployeeMap",
		data : {"empid":empId},
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			
				
			if (result.Empdeletevo[0].status!=null) {
		
				$("#error").show();
				$("#error").text(result.Empdeletevo[0].status);
				$('.error-box').css({'visibility' : 'visible'});
				
				return false;
			}else{
				
				window.location="employee.do?parameter=deleteEmployee&empid="+empId;
					
			}
				
		}

	});
	
	}

	
}

function getPermissions(empId,value){
	
	
	$.ajax({
		type : "GET",
		url : "employee.do?parameter=getEmployeePermissions",
		data : {"empid":empId},
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			
			if(value=="blockuser"){
				$("#block_employee").show();
			}else{
			$("#reset_employee_password").show();
			}
			
			
			
			for(var i=0;i<result.pemissionsList.length;i++){
				
				if(result.pemissionsList[i]=="DIRECTOR"){
					
					if(value=="blockuser"){
						$("#block_director").show();
					}else{
					$("#reset_director_password").show();
					}
				}
				
				if(result.pemissionsList[i]=="ADMIN"){
					
					if(value=="blockuser"){
						$("#block_admin").show();
					}else{
					$("#reset_admin_password").show();
					}
				}
				if(result.pemissionsList[i]=="MANAGER"){
				
					if(value=="blockuser"){
						$("#block_manager").show();
						
					}else{
					$("#reset_manager_password").show();
					}
				}
				
				
			}
				
		}

	});
	
}

function blockUserDetails(role){
	
	
	var empId=$("#dialogempId").val();
	
	$.ajax({
		type : "GET",
		url : "employee.do?parameter=blockUserDetails",
		data : {"empid":empId,"role":role},
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			
			
			if(result.status=="false"){
				
				$("#error").show();
				$("#error").text("Problem while blocking user,Try agian");
				$('.error-box').css({'visibility' : 'visible'});
				
			}else{
				
				$("#error").show();
				$("#succeesDiv").text(result.status);
				$('.error-box').css({'visibility' : 'visible'});
			}



				
		}

	});
	
}
