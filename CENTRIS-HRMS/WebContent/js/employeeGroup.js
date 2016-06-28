$(function() {
	var groupvalidate = null;
	function validateForm() {

		var groupName = $("#groupName "), description = $("#description "), hr1mail = $("#hr1mail "), hr2mail = $("#hr2mail ");
		allFields = $([]).add(groupName).add(hr1mail).add(description).add(
				hr2mail), tips = $(".validateTips");

		var bValid = true;
		allFields.removeClass("ui-state-error");
		bValid = bValid && checkLengthText(groupName, "GroupName", 5, 80);
		// bValid = bValid && checkLength( groupName, "groupName", 1, 15);

		/*
		 * bValid = bValid && checkLengthText(hr1mail, "hr1mail", 5, 80); bValid =
		 * bValid && checkRegexpText( hr1mail,
		 * /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+$/i, "Please Enter Valid Mail ID");
		 * 
		 * if(hr2mail.val()!="") { bValid = bValid && checkLengthText(hr1mail,
		 * "hr2mail", 5, 80); bValid = bValid && checkRegexpText( hr2mail,
		 * /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+$/i, "Please Enter Valid Mail ID"); }
		 * 
		 * var groupName = $("#groupName").val(); if(groupchechk==groupName) {
		 * 
		 * var groupNameval = $("#groupName"); bValid = bValid &&
		 * checkRegexpTextVal(groupNameval, /^[a-z]([0-9a-z_])+$/i, "GroupName
		 * Exit"); }
		 */

		return bValid;
	}

	function validateForm1() {

		var groupName = $("#groupName "), description = $("#description "), hr1mail = $("#hr1mail "), hr2mail = $("#hr2mail ");
		allFields = $([]).add(groupName).add(hr1mail).add(description).add(
				hr2mail), tips = $(".validateTips");

		var bValid = true;
		allFields.removeClass("ui-state-error");
		bValid = bValid && checkLengthText(groupName, "GroupName", 5, 80);
		// bValid = bValid && checkLength( groupName, "groupName", 1, 15);

		bValid = bValid && checkLengthText(hr1mail, "hr1mail", 5, 80);
		bValid = bValid
				&& checkRegexpText(hr1mail,
						/[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+$/i,
						"Enter Valid Mail ID");

		if (hr2mail.val() != "") {
			bValid = bValid && checkLengthText(hr1mail, "hr2mail", 5, 80);
			bValid = bValid
					&& checkRegexpText(hr2mail,
							/[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]+$/i,
							"Enter Valid Mail ID");
		}

		var groupName = $("#groupName").val();
		if (groupvalidate != groupName) {
			if (groupchechk == groupName) {

				var groupNameval = $("#groupName");
				bValid = bValid
						&& checkRegexpTextVal(groupNameval,
								/^[a-z]([0-9a-z_])+$/i,
								"Group Name Already Exists, Enter New Group Name");
				return false;
			}

		}

		return bValid;
	}

	$("#update-dialog").dialog({

		autoOpen : false,
		center : 1,
		dialogtop : top,
		height : 270,
		width : 400,
		modal : true,
		buttons : {
			"Update" : function() {

				// var bValid=validateForm1();

				if (true) {

					var groupName = $("#groupName").val();
					var description = $("#description").val();
					var hr1mail = $("#hr1mail").val();
					var hr2mail = $("#hr2mail").val();
					var groupId = $("#groupId").val();

					var datalst = {
						"groupName" : groupName,
						"description" : description,
						"hr1mail" : hr1mail,
						"hr2mail" : hr2mail,
						"groupId" : groupId
					};

					$.ajax({

						type : "GET",
						url : "groupMaster.do?method=updateGroupDetailsVal",
						data : datalst,
						success : function(data) {

							location.reload();

						}

					});
					$(this).dialog("close");
				}
			},
			"Add" : function() {

				var bValid = validateForm();
				// var bValid="true";
				if (bValid) {
					var groupName = $("#groupName").val();
					var description = $("#description").val();
					var hr1mail = $("#hr1mail").val();
					var hr2mail = $("#hr2mail").val();

					var datalst = {
						"groupName" : groupName,
						"description" : description,
						"hr1mail" : hr1mail,
						"hr2mail" : hr2mail
					};

					$.ajax({
						type : "GET",
						url : "groupMaster.do?method=addGroupDetails",
						data : datalst,
						success : function(response) {
							location.reload();
						}
					});
				}
			},

			Cancel : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
			allFields.val("").removeClass("ui-state-error");
		}
	});

	// update project
	$("#updateGroup")
			.click(
					function() {

						var checkboxArray = document
								.getElementsByName('selectBox');
						var id = document.getElementById("groupId");
						var name = document.getElementById("groupName");

						var updaterowsArray = new Array();

						for ( var i = 0; i < checkboxArray.length; i++) {
							if (checkboxArray[i].checked == true) {
								updaterowsArray.push(checkboxArray[i].value);
							}
						}

						if (updaterowsArray.length == 0) {
							alert("Select any Group to update");

							return false;
						} else if (updaterowsArray.length > 1) {

							alert("You can update only one Group at a time");

							return false;
						} else {

							var upd = confirm("Are you Sure to Update");

							if (upd) {

								var groupId = updaterowsArray[0];
										// var
										// projectId=document.getElementById('projectId').value;
										// alert(projectId);
										datalist = {
											"groupId" : groupId
										},
										$
												.ajax({
													type : 'POST',
													url : "groupMaster.do?method=updateGroupDetails",
													data : datalist,
													success : function(response) {

														var result = $
																.parseJSON(response);
														groupvalidate = result.updatelist[0].groupName;

														$("#groupId")
																.val(
																		result.updatelist[0].groupId);
														$("#groupName")
																.val(
																		result.updatelist[0].groupName);
														$("#description")
																.val(
																		result.updatelist[0].description);
														$("#hr1mail")
																.val(
																		result.updatelist[0].hr1Email);
														$("#hr2mail")
																.val(
																		result.updatelist[0].hr2Email);
													}
												});
							}
							else
								{
								location.reload();
								}
						}

						jQuery(
								".ui-dialog-buttonpane button:contains('Update')")
								.attr("disabled", false).removeClass(
										"ui-state-disabled").addClass(
										"ui-state-enabled");
						jQuery(".ui-dialog-buttonpane button:contains('Add')")
								.attr("disabled", true).addClass(
										"ui-state-disabled");
						$("#update-dialog").dialog("open");

					});

	// end update project

	// add reosurces

	$("#addGroup")
			.click(
					function() {

						var checkboxArray = document
								.getElementsByName('selectBox');
						var updaterowsArray = new Array();

						for ( var i = 0; i < checkboxArray.length; i++) {
							if (checkboxArray[i].checked == true) {
								updaterowsArray.push(checkboxArray[i].value);
							}
						}

						if (updaterowsArray.length != 0) {
							alert("Please Uncheck Groupid's You selected..and click on Add again...");
							return false;
						} else {

							jQuery(
									".ui-dialog-buttonpane button:contains('Add')")
									.attr("disabled", false).removeClass(
											"ui-state-disabled").addClass(
											"ui-state-enabled");
							jQuery(
									".ui-dialog-buttonpane button:contains('Update')")
									.attr("disabled", true).addClass(
											"ui-state-disabled");
							$("#update-dialog").dialog("open");

						}
					});
	// end add project

	var groupchechk = null;
	$("#groupName")
			.blur(
					function() {

						var groupNameval = $("#groupName");
						tips = $(".validateTips");

						var groupName = $("#groupName").val();

						if ($(this).val() != "")
									datalist = {
										"groupName" : groupName
									},
									$
											.ajax({
												type : 'POST',
												url : "groupMaster.do?method=checkValidate",
												data : datalist,
												success : function(response) {
													var result = $
															.parseJSON(response);

													if (result.groupNameVal == "Exit") {

														groupchechk = groupName;
														checkRegexpTextVal(
																groupName,
																/^[a-z]([0-9a-z_])+$/i,
																"Group Name already exists, Enter New Name");
													} else {

														$("p").empty();

													}
												}
											});
					});

	// delete project
	$("#deleteGroup")
			.click(
					function() {

						var selectall = document.getElementsByName("selectall");
						var checkboxArray = document
								.getElementsByName('selectBox');
						var updaterowsArray = new Array();

						for ( var i = 0; i < checkboxArray.length; i++) {
							if (checkboxArray[i].checked == true) {
								updaterowsArray.push(checkboxArray[i].value);
							}
						}

						if (updaterowsArray.length <= 0) {

							alert("Please Select any Groupid to delete...");
							return false;
						} else {

							var condition = confirm("Are you sure delete the Groupid(s) ");
							if(condition)
								{
							var datalist = 'groupId=' + updaterowsArray;
							// var projectId=updaterowsArray[0];
							// alert("update data val"+projectId);
							// alert(projectId);
							// datalist={"projectId":projectId},
							$
									.ajax({
										type : 'POST',
										url : "groupMaster.do?method=deleteGroupDetails",
										data : datalist,
										success : function(response) {
											location.reload();

										}
									});
								}
							else
								{								
								location.reload();
								}
						}
					});
	// end delete project

	// search button
	$("#searchUser").click(function() {

		var searchItem = $("#searchitem").val();

		searchTable(searchItem);
	});

	// search functionality
	function searchTable(inputVal) {
		var table = $('#users');
		table.find('tr').each(function(index, row) {
			var allCells = $(row).find('td');
			if (allCells.length > 0) {
				var found = false;
				allCells.each(function(index, td) {
					var regExp = new RegExp(inputVal, 'i');
					if (regExp.test($(td).text())) {
						found = true;
						return false;
					}
				});
				if (found == true)
					$(row).show();
				else
					$(row).hide();

			}
		});
	}
});

function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	if (selectall[0].checked == true) {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = true;
			// alert(checkboxArray[i].value);
		}
	} else {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = false;
		}
	}
}