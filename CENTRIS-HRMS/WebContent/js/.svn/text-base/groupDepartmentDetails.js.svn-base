$(function() {

	$
			.ajax({
				type : "GET",
				url : "employeeRegistration.do?method=getDepartment",
				success : function(response) {
					var result = $.parseJSON(response);
					var original = $("#original");
					for ( var j = 0; j < result.employeeRegistrationVO.length; j++) {

						$(original)
								.append(
										'<option value="'
												+ result.employeeRegistrationVO[j].empdepartmentid
												+ '">'
												+ result.employeeRegistrationVO[j].empdepartmentname
												+ '</option>');
					}

				}
			});
	$.ajax({
		type : "GET",
		url : "groupDepartment.do?method=getGroup",
		success : function(response) {

			var result = $.parseJSON(response);

			var group = $("#group");

			for ( var j = 0; j < result.grouplist.length; j++) {

				$(group).append(
						'<option value="' + result.grouplist[j].groupId + '">'
								+ result.grouplist[j].groupName + '</option>');
			}

		}
	});
	/*
	 * $.ajax({
	 * 
	 * //type: "GET", url :
	 * "/PTS_PRO/controller1/loadListOfPermissionDetail.htm", success :
	 * function(data) {
	 * 
	 * var obj = $.parseJSON(data); alert("Length:"+obj.Permissions.length);
	 * 
	 * for ( var i = 0; i < obj.Permissions.length; i++) { var perName =
	 * obj.Permissions[i].permissionId;
	 * 
	 * $('#original').append( '<option value="' + perName + '">' + perName + '</option>'); } }
	 * 
	 * });
	 */
});

function assign() {

	var groupId = $("#group").val();

	if (groupId == "") {
		$("#error").html("Please Select any Group");
		return false;
	}
/*	if (copy.options.length == 0) {
		$("#error").html("Selected department should not be empty");
		return false;
	}*/
	/* var listboxArray =$("#copy.options").val(); */
	var updaterowsArray = new Array();
	for ( var i = 0; i < copy.options.length; i++) {
		updaterowsArray.push(copy.options[i].value);
		copy.options[i].value = "";
	}

	var myarray = JSON.stringify(updaterowsArray);
	$.ajax({

		// type: "GET",
		url : "groupDepartment.do?method=saveDetailsMappimg",
		cache : false,
		data : {
			"groupId" : groupId,
			"deptDetails" : myarray
		},
		success : function() {
			alert("Data Saved Successfully");
			location.reload();
		}

	});

}

$(document).ready(function() {
	$("#group").change(function() {
		groupDetailMapping();
	});
});
function groupDetailMapping() {

	var groupVal = $("#group > option:selected").val();

	$("#copy").empty();
	if (groupVal != 0) {
		$.ajax({
			type : "GET",
			url : "groupDepartment.do?method=getDetailVal",
			data : "groupVal=" + groupVal,
			success : function(data) {
				var obj = $.parseJSON(data);

				for ( var i = 0; i < obj.grouplist.length; i++) {

					$('#copy').append(
							'<option value="' + obj.grouplist[i].departmentId
									+ '">' + obj.grouplist[i].deptName
									+ '</option>');
				}
			}
		});
	}
	$("#original").empty();

	// var groupVal = $("#group > option:selected").val();
	$.ajax({
		type : "GET",
		url : "groupDepartment.do?method=getDepartmentMapping",
		// data : "groupVal=" + groupVal,
		success : function(response) {

			var result = $.parseJSON(response);

			var original = $("#original");

			for ( var j = 0; j < result.grouplist.length; j++) {

				$(original).append(
						'<option value="' + result.grouplist[j].departmentId
								+ '">' + result.grouplist[j].deptName
								+ '</option>');
			}

		}
	});

	/*
	 * $.ajax({
	 * 
	 * //type: "GET", url : "/PTS_PRO/controller1/listOfPermission.htm", data :
	 * "RoleName=" + roleName, success : function(data) { var obj =
	 * $.parseJSON(data);
	 * 
	 * for ( var i = 0; i < obj.RemainingPermissions.length; i++) { var perName =
	 * obj.RemainingPermissions[i].permissionName;
	 * 
	 * $('#original').append( '<option value="' + perName + '">' + perName + '</option>'); } }
	 * 
	 * });
	 */

}
// select * from ai_bio_department dp where dp.DEPT_ID NOT IN(select og.DEPT_ID
// from onsite_groupmapping og where og.Groupid='5')
