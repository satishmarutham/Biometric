$(document)
		.ready(
				function() {

				//$("#errordiv").hide();

					$("#view-dialog")
							.dialog(
									{
										autoOpen : false,
										center : 1,
										dialogtop : top,
										height : 250,
										width : 450,
										resizable : false,
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
	$("#errordiv").hide();
	$("#view-dialog").dialog("open");
}

function updateDepartment(depId,depName,desc,locManagerMail,hrManagerMail,onsiteManagerMail) {
	$("a.ui-dialog-titlebar-close").remove();
	$("span.ui-icon").remove();
	$('ul li ul').hide();

	$("#view-dialog")
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
	

}

function validateForm() {

	var deptname = $("#depName").val();
	var deptCode=$("#departmentid").val();

	var regexpforalphabets = /^[a-zA-Z ]+$/i;
	var regforMail= /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if ($("#depName").val() == "") {

		$("#error").show();
		$("#error").text("Department Name should not be Empty");
		$(".error-box").css({'visibility':'visible'});
		return false;
	} else if (!(regexpforalphabets.test(deptname.trim()))) {

		$("#error").show();
		$("#error").text("Departnent Name field only allow: a-z");
		$(".error-box").css({'visibility':'visible'});
		return false;

	}
	
	else {

		if (validateDeptName()) {

			$("#errordiv").show();
			$("#fail").text("Department Name Already Exists");

			return false;
		} else {
			return true;
		}
	}

	return true;

}



function validateDeptName() {
	var  deptnamecheck=false;
	var deptid = $("#departmentid").val();
	var deptname = $("#depName").val();

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

			deptnamecheck = true;
			$("#error").show();
				$("#error").text("Department Name already Exists");
				$(".error-box").css({'visibility':'visible'});
			} else {

				deptnamecheck = false;

			}

		}

	});
	return deptnamecheck;
}