$(document)
		.ready(
				function() {

					$('#managerforgetPassword')
							.click(
									function() {
										window.location.href = 'logincheck.do?method=getForgetPassword&checkType=manager';
									});

					$('#employeeforgetPassword')
							.click(
									function() {
										window.location.href = 'logincheck.do?method=getForgetPassword&checkType=employee';
									});

					$('#adminforgetPassword')
					.click(
							function() {
								
								window.location.href = 'logincheck.do?method=getForgetPassword&checkType=admin';
							});
					
					$('#directorforgetPassword')
					.click(
							function() {
								
								window.location.href = 'logincheck.do?method=getForgetPassword&checkType=director';
							});
					
					$('#home')
					.click(
							function() {
								
								
								window.location.href = 'logincheck.do?method=loginaction';
							});
					$('#adminLogin')
							.click(
									function() {
										var valid = adminValidation();

										if (valid) {

											$("#adminLoginSubmit")
													.attr('action',
															'logincheck.do?method=submitLogin');
											$("#adminLoginSubmit").submit();
										} else {
											return false;
										}
									});

					$('#managerLogin')
							.click(
									function() {
										var valid = managerValidation();

										if (valid) {

											$("#managerLoginSubmit")
													.attr('action',
															'logincheck.do?method=submitLogin');
											$("#managerLoginSubmit").submit();
										} else {
											return false;
										}
									});

					$('#employeeLogin')
							.click(
									function() {
										var valid = employeeValidation();

										if (valid) {

											$("#employeeLoginSubmit")
													.attr('action',
															'logincheck.do?method=submitLogin');
											$("#employeeLoginSubmit").submit();
										} else {
											return false;
										}
									});
					$('#directorLogin')
							.click(
									function() {
										var valid = directorValidation();

										if (valid) {

											$("#directorLoginSubmit")
													.attr('action',
															'logincheck.do?method=submitLogin');
											$("#directorLoginSubmit").submit();
										} else {
											return false;
										}
									});

				});
function adminValidation() {

	var uname = $("#admin_uname").val().trim();
	var pword = $("#admin_pword").val().trim();
	var type = "admin";
	var passChangeMessage = $("#passChangeMessage").text();
	if (passChangeMessage != "" || passChangeMessage != null) {
		$("#passChangeMessage").hide();
	}

	if (uname == "" || uname == null) {
		$("#adminerror").text("User Name should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else if (pword == "" || pword == null) {

		$("#adminerror").text("Password should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		if (checkLoginAuthenticationCase(uname, pword, type)) {

			$("#adminerror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else if (checkLoginAuthentication(uname, pword, type)) {
			$("#adminerror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else {
			return true;
		}

	}
}

function managerValidation() {

	var uname = $("#manager_uname").val().trim();
	var pword = $("#manager_pword").val().trim();
	var type = "manager";
	var passChangeMessage = $("#passChangeMessage").text();
	if (passChangeMessage != "" || passChangeMessage != null) {
		$("#passChangeMessage").hide();
	}

	if (uname == "" || uname == null) {
		$("#managererror").text("User Name should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else if (pword == "" || pword == null) {

		$("#managererror").text("Password should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		if (checkLoginAuthenticationCase(uname, pword, type)) {

			$("#managererror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else if (checkLoginAuthentication(uname, pword, type)) {
			$("#managererror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		}

		else {
			return true;
		}

	}
}

function employeeValidation() {

	var uname = $("#employee_uname").val().trim();
	var pword = $("#employee_pword").val().trim();
	var type = "employee";
	var passChangeMessage = $("#passChangeMessage").text();
	if (passChangeMessage != "" || passChangeMessage != null) {
		$("#passChangeMessage").hide();
	}

	if (uname == "" || uname == null) {
		$("#employeererror").text("User Name should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else if (pword == "" || pword == null) {

		$("#employeererror").text("Password should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		if (checkLoginAuthenticationCase(uname, pword, type)) {

			$("#employeererror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else if (checkLoginAuthentication(uname, pword, type)) {
			$("#employeererror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else {
			return true;
		}
	}
}

function directorValidation() {

	var uname = $("#director_uname").val().trim();
	var pword = $("#director_pword").val().trim();
	var type = "director";
	/*var passChangeMessage = $("#passChangeMessage").text();
	if (passChangeMessage != "" || passChangeMessage != null) {
		$("#passChangeMessage").hide();
	}*/

	if (uname == "" || uname == null) {
		$("#directorerror").text("User Name should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else if (pword == "" || pword == null) {

		$("#directorerror").text("Password should not be empty");
		$(".validateTips").css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		if (checkLoginAuthenticationCase(uname, pword, type)) {

			$("#directorerror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else if (checkLoginAuthentication(uname, pword, type)) {
			$("#directorerror").text("Incorrect User Name or Password");
			$(".validateTips").css({
				'visibility' : 'visible'
			});
			return false;
		} else {
			return true;
		}
	}
}

var loginuser;
var loginusercase;

function checkLoginAuthentication(get_uname, get_pword, get_type) {
	var logindetails = {
		"uname" : get_uname,
		"pword" : get_pword,
		"type" : get_type
	};
	$.ajax({
		type : "GET",
		url : "logincheck.do?method=checkLoginDetails",
		data : logindetails,
		async : false,
		success : function(data) {

			var result = $.parseJSON(data);
			if (result.status) {
				loginuser = false;
			} else {
				loginuser = true;
				$("#error").text("Incorrect User Name or Password");
				$(".validateTips").css({
					'visibility' : 'visible'
				});
			}
		}
	});
	return loginuser;
}

function checkLoginAuthenticationCase(get_uname, get_pword, get_type) {

	var logindetails = {
		"uname" : get_uname,
		"pword" : get_pword,
		"type" : get_type
	};

	$.ajax({
		type : "GET",
		url : "logincheck.do?method=userValidCase",
		data : logindetails,
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			if (result.status) {
				loginusercase = false;
			} else {
				loginusercase = true;
				$("#error").text("Incorrect User Name or Password");
			}
		}
	});
	return loginusercase;
}

function Close() {

	$(".parentDisable").hide();
	$("#adminloginPopup").hide();
	$("#managerloginPopup").hide();
	$("#directorloginPopup").hide();
	$("#employeeloginPopup").hide();
}

function myAdmin() {

	$(".parentDisable").show();
	$("#adminloginPopup").show();
	$("#managerloginPopup").hide();
	$("#employeeloginPopup").hide();
	$("#directorloginPopup").hide();
	$("#admin_uname").focus();
}
function myManager() {

	$(".parentDisable").show();
	$("#managerloginPopup").show();
	$("#employeeloginPopup").hide();
	$("#adminloginPopup").hide();
	$("#directorloginPopup").hide();
	$("#manager_uname").focus();
}
function myEmployee() {

	$(".parentDisable").show();
	$("#employeeloginPopup").show();
	$("#managerloginPopup").hide();
	$("#adminloginPopup").hide();
	$("#directorloginPopup").hide();
	$("#employee_uname").focus();
}

function myDirector() {
	
	$(".parentDisable").show();
	$("#employeeloginPopup").hide();
	$("#managerloginPopup").hide();
	$("#adminloginPopup").hide();
	$("#directorloginPopup").show();
	$("#director_uname").focus();
  
}
