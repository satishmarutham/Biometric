$(function() {
	$("#errordiv").hide();
	var groupchechk = null;
	var groupvalidate = null;
	var regexpforalphabets=/^[a-zA-Z ]+$/i;
	
	function validateForm() {
	
		var groupName = $("#groupName ").val();
	    var description = $("#description ").val();
		if(groupName=="" ||groupName==null){
		$(".validateTips").text("Enter Group Name");
		return false;	
		}else if(groupName.length<5 || groupName.length>80){
		 $(".validateTips").text("Group Name is less than 80");
			return false;	
		}else if( !( regexpforalphabets.test( groupName.trim() ) ) ){
			
			$(".validateTips").text("Group Name field only allow Alphabet : a-z");
			
			return false;
		}else if(groupchechk == groupName) {
			 $("#validateTips").text("Group Name already exists,Enter New Group Name");
			   	return false;
		}else if(description=="" ||description==null){
			$(".validateTips").text("Enter Description");
			
			return false;
		}
		return true;
	}

	function validateForm1() {
		
		
		var regexpforalphabets=/^[a-zA-Z ]+$/i;
		
		var groupName = $("#groupName ").val();
	    var description = $("#description ").val();
		if(groupName=="" ||groupName==null){
			$(".validateTips").text("Enter the Group Name");
			return false;	
		}else if(groupName.length<5 || groupName.length>80){
		 $(".validateTips").text("Group name is lessthan 50");
		
			return false;	
		}else if( !( regexpforalphabets.test( groupName.trim() ) ) ){
			
			$(".validateTips").text("Group Name field only allow Alphabet : a-z");
			
			return false;
		}else if(groupchechk == groupName) {
		 $(".validateTips").text("Group Name already exists, Enter New Group Name");
		
			return false;
		}else if(description=="" ||description==null){
			$(".validateTips").text("Enter Description");
			
			return false;
		}
		
	return true;
	}

	$("#update-dialog").dialog({

		autoOpen : false,
		center : 1,
		dialogtop : top,
		height : 330,
		width : 400,
		modal : true,
		buttons : {
			"Update" : function() {
				var bValid=validateForm1();
				if (bValid) {
					var groupName = $("#groupName").val();
					var description = $("#description").val();
					var groupId = $("#groupId").val();

					var datalst = {
						"groupName" : groupName,
						"description" : description,
						"groupId" : groupId
				};
					var condition = confirm("Are you sure to Update "+groupName+" Group");
					if(condition){
					$.ajax({
						type : "GET",
						url : "groupMaster.do?method=updateGroupDetailsVal",
						data : datalst,
						success : function(data) {
							$("#successdiv").text("Group Details Updated Successfully");
							$('ul li ul').show();
						}
					});
						setTimeout("location.reload();", 1000);
					}else{
						location.reload();
						$('ul li ul').show();
					}
						
				}
			},
			"Add" : function() {

				var bValid = validateForm();
				if (bValid) {
					var groupName = $("#groupName").val();
					var description = $("#description").val();
					var datalst = {
						"groupName" : groupName,
						"description" : description,
						};
					var condition = confirm("Are you sure insert this Group");
					if(condition){
					$.ajax({
						type : "GET",
						url : "groupMaster.do?method=addGroupDetails",
						data : datalst,
						success : function(response) {
								$("#successdiv").text("Group Added Successfully");
								$('ul li ul').show();					
						}
					});
					setTimeout("location.reload();", 1000);
					}else{
						location.reload();
						$('ul li ul').show();
					}
				}
			},

			Cancel : function() {
				$(this).dialog("close");
				$('ul li ul').show();
			}
		}
	});

	
	$("#updateGroup")
			.click(
					function() {
						
						var checkboxArray = document	.getElementsByName('selectBox');
						var updaterowsArray = new Array();

						for ( var i = 0; i < checkboxArray.length; i++) {
							if (checkboxArray[i].checked == true) {
								updaterowsArray.push(checkboxArray[i].value);
							}
						}
						if (updaterowsArray.length == 0) {
							$("#errordiv").show();
							$("#errordiv").text("Select any Group to Update");
							 $('.error-box').css({'visibility': 'visible'});
						return false;
						} else if (updaterowsArray.length > 1) {
							
							$("#errordiv").text("You can Update only one Group at a time");
							 $('.error-box').css({'visibility': 'visible'});
						return false;
						} else {
								var groupId = updaterowsArray[0];
									datalist = {"groupId" : groupId	},
										$
												.ajax({
													type : 'POST',
													url : "groupMaster.do?method=editGroupDetails",
													data : datalist,
													success : function(response) {

														var result = $
																.parseJSON(response);
														groupvalidate = result.updatelist[0].groupName;

														$("#groupId").val(
																		result.updatelist[0].groupId);
														$("#groupName")
																.val(
																		result.updatelist[0].groupName);
														$("#description")
																.val(
																		result.updatelist[0].description);
											}
												});
							
						}

						jQuery(
								".ui-dialog-buttonpane button:contains('Update')")
								.attr("disabled", false).removeClass(
										"ui-state-disabled").addClass(
										"ui-state-enabled");
						jQuery(".ui-dialog-buttonpane button:contains('Add')")
								.attr("disabled", true).addClass(
										"ui-state-disabled");
						$("a.ui-dialog-titlebar-close").remove();	
						$("span.ui-icon").remove();
						$('ul li ul').hide();
						
						$("#update-dialog").dialog("open");

					});



	$("#addGroup")
			.click(	function() {
						var checkboxArray = document
								.getElementsByName('selectBox');
						var updaterowsArray = new Array();

						for ( var i = 0; i < checkboxArray.length; i++) {
							if (checkboxArray[i].checked == true) {
								updaterowsArray.push(checkboxArray[i].value);
							}
						}
						if (updaterowsArray.length != 0) {
						$("#errordiv").show();
							$("#errordiv").text("Please Uncheck Group You selected..and click on Add again...");
							 $('.error-box').css({'visibility': 'visible'});
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
							$("a.ui-dialog-titlebar-close").remove();	
							$("span.ui-icon").remove();
							$('ul li ul').hide();
							
							$("#update-dialog").dialog("open");

						}
					});


	
	$("#groupName")
			.blur(
					function() {
					 var groupId = $("#groupId").val();;
						var groupName = $("#groupName").val();
                   
						if ($(this).val() != "")
									datalist = {
										"groupName" : groupName,"groupId":groupId
									},
									$		.ajax({
												type : 'POST',
												url : "groupMaster.do?method=checkValidate",
												data : datalist,
												success : function(response) {
													var result = $.parseJSON(response);
														if (result.groupNameVal == "Exit") {
														groupchechk = groupName;
														 $(".validateTips").text("Group Name Already Exists, Enter Another Group Name");
    												} else {

														$("p").empty();

													}
												}
											});
					});

	
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
							$("#errordiv").show();
							$("#errordiv").text("Please Select any Group to delete");
							 $('.error-box').css({'visibility': 'visible'});
						return false;
						} else {
							var condition = confirm("Are you sure delete the Group(s)"+updaterowsArray);
							if(condition){
							var datalist = 'groupId=' + updaterowsArray;
						$
									.ajax({
										type : 'POST',
										url : "groupMaster.do?method=deleteGroupDetails",
										data : datalist,
										success : function(response) {
											var result1 = $.parseJSON(response);
											$("#errordiv").show();
											$("#spanid").text(result1.result);									
											
										}
									});
						 setTimeout("location.reload();", 2000);
							 }else{
								 location.reload();
								 
							 }
							
						}
					});
	


	
});

function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	if (selectall[0].checked == true) {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = true;
		
		}
	} else {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = false;
		}
	}
}