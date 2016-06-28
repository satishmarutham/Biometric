$(document)
		.ready(
				
				function() {
					$("#emp").val("");
					$('#emp').focus();
					$("#emp").attr("placeholder", "Type employee name ");
					$("#date").attr("placeholder", "Click here for date");
					function log(message) {
						$("<div>").text(message).prependTo("#log");
						$("#log").scrollTop(0);
					}

					$("#emp")
							.autocomplete(
									{
										
										source : function(request, response) {
											$
													.ajax({
														url : "offreportreconcil.do?parameter=getEmployeeNames",
														dataType : "json",
														data : {
															featureClass : "P",
															style : "full",
															maxRows : 12,
															name_startsWith : request.term
														},
														success : function(data) {
															
															response($
																	.map(
																			data.list1,
																			function(
																					item) {
																				return {
																					label : item.empname,
																					value : item.empname,
																					id : item.empid
																				}
																			}));
														}

													});
										},
										minLength : 1,
										select : function(event, ui) {
											var vals = ui.item.id.split("(");
											$("#name").val(ui.item.label);
											$("#empid1").val(vals[0]);
											log(ui.item ? "Selected: "
													+ ui.item.id
													: "Nothing selected, input was "
															+ this.value);
										},

										open : function() {
											$(this)
													.removeClass(
															"ui-corner-all")
													.addClass("ui-corner-top");
										},
										close : function() {
											$(this)
													.removeClass(
															"ui-corner-top")
													.addClass("ui-corner-all");
										}
									});
					$( "#date" ).datepicker({
						maxDate : 0,
						dateFormat : "yy-mm-dd",
						yearRange: 'c-50:c+50',
					    changeMonth:"true",
			       	changeYear:"true",		        
				});
				});

function validateForm() {
	var employeename = $("#emp").val();
	
	var empdate=$("#date").val();
	if (employeename == "") {

		$("#error").text("Please Select any Employee");
		$("#error1").hide();
		return false;
	} 
	if (empdate=="" || empdate=="Click here for date" ) {

		$("#error").text("Please Select Date");
		$("#error1").hide();
		return false;
	} 
	if (employeename == "" || empdate=="" || empdate=="Click here for date" ) {

		$("#error").text("Please Select Employee and Date");
		$("#error1").hide();
		return false;
	} 
	
	
	else {
		return true;
	}
}