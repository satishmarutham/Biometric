$(document)
		.ready(
				function() {
					$('#emp').focus();
					$("#emp").attr("placeholder", "Type employee name ");

					$("#emp")
							.autocomplete(
									{
										source : function(request, response) {
											$
													.ajax({
														url : "RemoveEmployeeAction.do?parameter=getSearchEmployeeNames",
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
																					id : item.email
																							+ "("
																							+ item.phone
																							+ "("
																							+ item.shiftname
																							+ "("
																							+ item.deptname
																							+ "("
																							+ item.locationname
																							+ "("
																							+ item.empid
																				}
																			}));
														}

													});
										},
										minLength : 1,
										select : function(event, ui) {
											var vals = ui.item.id.split("(");
											$("#emp").val(ui.item.label);
											$("#name").val(ui.item.label);
											$("#email").val(vals[0]);
											$("#shift").val(vals[2]);
											$("#dept").val(vals[3]);
											$("#location").val(vals[4]);
											$("#empid1").val(vals[5]);
											$("#empid").val(vals[5]);
											log(ui.item ? "Selected: "
													+ ui.item.id
													: "Nothing selected, input was "
															+ this.value);
										},

									});
				});

function validateForm() {
	var employeename = $("#emp").val();
	var employeeid = $("#empid").val();

	if (employeename == "" || employeeid == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Type Employee Name");
		return false;
	}
	var x = confirm("Are you sure you want to In-Activate this Employee")
	if (x == true) {
		return true;
	} else if (x == false) {
		return false;
	} else {
		return true;
	}
}
function log( message ) {
	$( "<div>" ).text( message ).prependTo( "#log" );
	$( "#log" ).scrollTop( 0 );
}