var currentUName = false;

$(document)
		.ready(
				function() {
					setTimeout(function() {
						removeMessage();
					}, 5000);
					var errorBoxText = $('.error-box').text().trim();
					if (errorBoxText == "")
						$('.error-box').css({
							'visibility' : 'hidden'
						});

					getRoleId('#roleCodeId');
					getLocation("#locationCodeId");
					getGroupId('#groupCodeId');
					$('#addDialog').dialog({

						autoOpen : false,
						height : 350,
						width : 600,
						modal : true,
						resizable : true,
						buttons : [ {
							text : "Add",
							class : "submitbutton",
							click : function() {

								var password = $('#passwordId').val();
								var username = $('#adduserId').val();
								var roleCode = $('#roleCodeId').val();
								var location = $('#locationCodeId').val();
								var group = $('#groupCodeId').val();

								dataList = {
									username : username,
									password : password,
									roleCode : roleCode,
									location : location,
									group : group,
								};

								var bvalid = addValidate();

								if (bvalid) {

									$.ajax({
										type : "POST",
										url : "user.do?parameter=addUser",
										data : dataList,
										async : false,
										success : function(data) {

											var result = $.parseJSON(data);
											$('ul li ul').show();
											window.location.reload();

										}
									});

								}
							}

						}, {
							text : "Cancel",
							class : "submitbutton",
							click : function() {
								$(this).dialog('close');
								$('ul li ul').show();
							}
						} ]
					});

					$('#createUserBtnId').click(
							function() {
								$('#passwordId').val('');
								$('#adduserId').val('');
								$('#confirmpasswordId').val('');

								$('#addDialog').dialog('option', 'title','Add  UserMaster');
								
								$('#addDialog').dialog('open');
								$("a.ui-dialog-titlebar-close").remove();	
								$("span.ui-icon").remove();
								$('ul li ul').hide();

							});

					$('#editDialog').dialog({

						autoOpen : false,
						height : 320,
						width : 600,
						modal : false,
						resizable : false,
						buttons : [ {
							text : "Update",
							class : "submitbutton",
							click : function() {
								var password = $('#editpasswordId').val();
								var username = $('#edituserId').val();
								var userCode = $('#userCodeId').val();
								var roleCode = $('#roleCodeEditId').val();
								var location = $('#locationEditCodeId').val();
								var group = $('#groupEditCodeId').val();

								dataList = {
									username : username,
									password : password,
									usercode : userCode,
									roleCode : roleCode,
									location : location,
									group : group,
								};

								var bvalid = editValidate();

								if (bvalid) {

									$.ajax({
										url : "user.do?parameter=editUser",
										data : dataList,
										async : false,
										success : function(data) {

											var result = $.parseJSON(data);
											$('ul li ul').show();
											window.location.reload();

										}
									});

								}
							}

						}, {
							text : "Cancel",
							class : "submitbutton",
							click : function() {
								$(this).dialog('close');
								$('ul li ul').show();
							}
						} ]
					});

					deleteUserUrl = "user.do?method=deleteUser";
					$('#editUserBtnId')
							.click(
									function() {
										var cnt = 0;
										$(
												'input.user_Checkbox_Class:checkbox:checked')
												.map(
														function() {
															if (cnt > 0) {
																$(
																		'.alertMessage')
																		.text(
																				"Select Only One Row");

																cnt++;
																return false;
															} else {
																var check_id = $(
																		this)
																		.attr(
																				"id");

																var split_id = check_id
																		.split('_');
																edit_Array = split_id[1]
																		.split(',');
																cnt++;
															}
														});
										if (cnt == 0 || cnt > 1) {
											$("#errordiv").text(
													"Select Any One User");
											$('.error-box').css({
												'visibility' : 'visible'
											});

										}

										if (cnt == 1) {
											$('#edituserId').val(edit_Array[1]);

											$('#userCodeId').val(edit_Array[2]);
											$('#editpasswordId').val(
													edit_Array[3]);
											$('#editconfirmpasswordId').val(
													edit_Array[3]);
											getRoleId("#roleCodeEditId");
											$('#roleCodeEditId').val(
													edit_Array[4]);

											getLocation("#locationEditCodeId");
											$(
													'#locationEditCodeId option[value="'
															+ edit_Array[6]
															+ '"]').prop(
													'selected', true);

											getGroupId("#groupEditCodeId");
											$('#groupEditCodeId').val(
													edit_Array[8]);
											$("#editDialog").dialog('option',
													'title',
													'Update User Details');
											$("a.ui-dialog-titlebar-close").remove();	
											$("span.ui-icon").remove();
											$('ul li ul').hide();
											
											$('#editDialog').dialog('open');
										}

									});

					$('#deleteUserBtnId')
							.click(
									function() {

										var count = 0;

										var user_details = null;

										$('input[name="usenname"]:checked')
												.each(
														function() {

															count++;
															user_details = user_details
																	+ ",,"
																	+ this.id;

														});

										if (count == 0) {

											$("#errordiv").text(
													"Select Any User");
											$('.error-box').css({
												'visibility' : 'visible'
											});

										} else {

											var user = {
												"user_details" : user_details
											};

											var x = confirm("Are You Sure To Delete");
											if (x) {

												$
														.ajax({

															url : "user.do?parameter=deleteUser",
															data : user,
															async : false,
															success : function(
																	data) {
																var result = $
																		.parseJSON(data);
																window.location
																		.reload();
																document.location.href = "GetDetails.do?parameter=getUsers&success="
																		+ result.jsonResponse;
															}
														});
											}
										}
									});
				});
function getRoleId(roleCode) {

	$.ajax({
		type : 'POST',
		url : "user.do?parameter=getRolesDetails",
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			$(roleCode).html("");
			$(roleCode).append(
					'<option value="' + "" + '">' + "-----select-----"
							+ '</option>');
			for ( var j = 0; j < result.jsonResponse.length; j++) {
				$(roleCode).append(
						'<option value="' + result.jsonResponse[j].roleCode
								+ '">' + result.jsonResponse[j].roleName
								+ '</option>');
			}

		}
	});
}

function getLocation(location) {
	$.ajax({
		type : 'POST',
		url : "user.do?parameter=getLocationDetails",
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			$(location).html("");
			$(location).append(
					'<option value="' + "" + '">' + "-----select-----"
							+ '</option>');
			for ( var j = 0; j < result.jsonResponse.length; j++) {
				$(location).append(
						'<option value="' + result.jsonResponse[j].locationid
								+ '">' + result.jsonResponse[j].locationname
								+ '</option>');
			}

		}
	});
}
function addValidate() {

	tips = $("#errordivaddDialog");

	var bValid = true;
	bValid = bValid && selectBoxElement($('#roleCodeId'), "Select RoleName");
	bValid = bValid
			&& selectBoxElement($('#locationCodeId'), "Select Location");
	bValid = bValid && selectBoxElement($('#groupCodeId'), "Select GroupName");
	bValid = bValid
			&& checkRegexpText($('#adduserId'), /^[a-zA-Z0-9_.-]*$/g,
					"Enter UserName");
	bValid = bValid && checkLengthTextPH($("#adduserId"), "User name", 4, 10);

	if (currentUName) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("User Name Already Exits, Change User Name");
		return false;
	}
	bValid = bValid && checkLengthTextPH($("#passwordId"), "Password", 4, 10);
	var password = $('#passwordId').val();

	var confirmpassword = $('#confirmpasswordId').val();

	if (password != confirmpassword) {
		$("#errordivaddDialog").text(
				"Password and Confirmation Password Combination is Wrong");
	} else {
		return bValid;
	}

}

function editValidate() {

	tips = $("#errordiveditDialog");
	$('.error-box').css({
		'visibility' : 'visible'
	});
	var bValid = true;
	bValid = bValid
			&& selectBoxElement($('#roleCodeEditId'), "Select RoleName");
	bValid = bValid
			&& selectBoxElement($('#locationEditCodeId'), "Select Location");
	bValid = bValid && selectBoxElement($('#groupEditCodeId'), "Select Group");
	bValid = bValid
			&& checkRegexpText($('#edituserId'), /^[a-zA-Z0-9_.-]*$/g,
					"Enter UserName");
	bValid = bValid && checkLengthTextPH($("#edituserId"), "User name", 4, 10);
	if (currentUName) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("User Name Already Exits, Change User Name");
		return false;
	}

	bValid = bValid
			&& checkLengthTextPH($("#editpasswordId"), "Password", 4, 10);
	var password = $('#editpasswordId').val();
	var confirmpassword = $('#editconfirmpasswordId').val();
	if (password != confirmpassword) {
		$("#errordiveditDialog").text(
				"Password and Confirmation Password Combination is Wrong");
	} else {
		return bValid;
	}
}
function getGroupId(groupCode) {

	$.ajax({
		type : 'POST',
		url : "user.do?parameter=getGroupDetails",
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			$(groupCode).html("");
			$(groupCode).append(
					'<option value="' + "" + '">' + "-----select-----"
							+ '</option>');
			for ( var j = 0; j < result.jsonResponse.length; j++) {
				$(groupCode).append(
						'<option value="' + result.jsonResponse[j].groupCode
								+ '">' + result.jsonResponse[j].groupName
								+ '</option>');
			}

		}
	});
}
function removeMessage() {

	$.ajax({
		type : "GET",
		url : "removeErrorMessage.do?method=removeMessage",
		async : false,
		success : function(data) {
			var errorBoxText = $('.error-box').text().trim();
			if (errorBoxText == "")
				$('.error-box').empty();
		}
	});
}
function currentUserNameCkeck() {

	var userNameval = $('#adduserId').val();

	if (userNameval != "") {

		var data = {
			"userNameval" : userNameval
		};
		$.ajax({

			type : "POST",
			url : "user.do?parameter=getCurrentUserNameCkeck",
			data : data,
			async : false,
			success : function(response) {
				var result = $.parseJSON(response);

				if (result.status) {
					currentUName = true;

					$("#errordivaddDialog").text(
							"User Name Already Exits, Change User Name");
				} else {
					currentUName = false;
					$("#errordivaddDialog").text("");
				}
			}
		});
	}
}