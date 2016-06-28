$(document)
		.ready(
				function() {

					$("#successmsg").hide();

					$("#insertDep")
							.dialog(
									{
										autoOpen : false,
										center : 1,
										dialogtop : top,
										height : 300,
										width : 500,
										modal : true,
										buttons : {
											Add : function() {
												var validForm = validateForm();
												if (validForm) {
													document
															.getElementById("insertDepForm").action = "departmentMaster.do?parameter=addDepartment";
													document.getElementById(
															"insertDepForm")
															.submit();
													$('ul li ul').show();
												}
											},
											Cancel : function() {
												$(this).dialog("close");
												$('ul li ul').show();
											}
										}
									});
				});

function insertDepartment() {

	$("a.ui-dialog-titlebar-close").remove();
	$("span.ui-icon").remove();
	$('ul li ul').hide();

	$("#departmentid").val("");
	$("#depName").val("");
	$("#depDesc").val("");
	$("#hrManagerMailId").val("");
	$("#locManagerMailId").val("");
	$("#onsiteManagerMailId").val("");

	var text_box = document.getElementById('depName');
	if (text_box.hasAttribute('readonly')) {
		text_box.removeAttribute('readonly');
	}

	$("#insertDep").dialog("open");
}

function updateDepartment(depId,depName,desc,locManagerMail,hrManagerMail,onsiteManagerMail) {
	$("a.ui-dialog-titlebar-close").remove();
	$("span.ui-icon").remove();
	$('ul li ul').hide();

	$("#insertDep")
			.dialog(
					{
						autoOpen : true,
						center : 1,
						dialogtop : top,
						height : 300,
						width : 500,
						modal : true,
						buttons : {
							Update : function() {

								var validForm = validateForm();

								if (validForm) {
									document.getElementById("insertDepForm").action = "departmentMaster.do?parameter=updateDepartment&depId="+ depId;
									document.getElementById("insertDepForm").submit();
									$('ul li ul').show();
								}
							},
							Cancel : function() {
								$(this).dialog("close");
								$('ul li ul').show();
							}
						}
					});

	$("#depName").val(depName);
	$("#depDesc").val(desc);
	$("#departmentid").val(depId);
	$("#hrManagerMailId").val(hrManagerMail);
	$("#locManagerMailId").val(locManagerMail);
	$("#onsiteManagerMailId").val(onsiteManagerMail);

}

function validateForm() {

	var deptname = $("#depName").val();
	var hrmail=$("#hrManagerMailId").val();
	var localmanagermail=$("#locManagerMailId").val();
	var onsitemanagermail=$("#onsiteManagerMailId").val();
	var desc=$("#depDesc").val();
	
	var regexpforalphabets = /^[a-zA-Z ]+$/i;
	var regforMail= /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if ($("#depName").val() == "") {

		$("#successmsg").show();
		$("#fail").text("Department Name should not be Empty");
		return false;
	} else if (!(regexpforalphabets.test(deptname.trim()))) {

		$("#successmsg").show();
		$("#fail").text("Departnent Name field only allow: a-z");

		return false;

	}
	if ($("#depDesc").val() == "") {

		$("#successmsg").show();
		$("#fail").text("Description Name should not be Empty");
		return false;
	} 
	
	
	else if (!(regexpforalphabets.test(desc.trim()))) {

		$("#successmsg").show();
		$("#fail").text("Description Name field only allow: a-z");

		return false;

	}
	
	

	else if ($("#hrManagerMailId").val() == "") {

		$("#successmsg").show();
		$("#fail").text("HrManagerMail Should not be Empty");

		return false;

	}
	else if (!(regforMail.test(hrmail.trim()))) {

		$("#successmsg").show();
		$("#fail").text("Check HrManagerMail");

		return false;

	}
	
	
	
	else if ($("#locManagerMailId").val() == "") {

		$("#successmsg").show();
		$("#fail").text("LocalManagerMail Should not be Empty");

		return false;

	}
	else if (!(regforMail.test(localmanagermail.trim()))) {

		$("#successmsg").show();
		$("#fail").text(" Check Local ManagerMail");

		return false;

	}
	
	
	else if ($("#onsiteManagerMailId").val() == "") {

		$("#successmsg").show();
		$("#fail").text("LocalManagerMail Should not be Empty");

		return false;

	}
	else if (!(regforMail.test(onsitemanagermail.trim()))) {

		$("#successmsg").show();
		$("#fail").text("Check OnSiteManagerMail");

		return false;

	}

	
	
	else {

		if (deptnamecheck) {

			$("#successmsg").show();
			$("#fail").text("Department Name Already Exist");

			return false;
		} else {
			return true;
		}
	}

	return true;

}

var deptnamecheck = false;

function validateDeptName() {

	var deptid = $("#departmentid").val();
	var deptname = $("#depMasterTable #depName").val();

	var deptdetails = {
		"deptid" : deptid,
		"deptname" : deptname
	};

	$.ajax({

		type : "GET",
		url : "departmentMaster.do?parameter=validateDeptName",
		data : deptdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			if (result.status) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Department Name Already Exist");

				deptnamecheck = true;
			} else {

				deptnamecheck = false;

			}

		}

	});
}