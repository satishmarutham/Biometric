$(document)
		.ready(
				function() {
					$('#emp').focus();
					$("#emp").attr("placeholder", "Type employee name ");

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
														url : "removeemp.do?parameter=getEmployeeNames",
														dataType : "json",
														data : {
															featureClass : "P",
															style : "full",
															maxRows : 12,
															name_startsWith : request.term
														},
														success : function(data) {
															// alert(data.list1[0].empname);
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
																							+ item.emplocation
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
				});

function validateForm() {
	var employeename = $("#emp").val();
	var employeeid = $("#empid").val();

	if (employeename == "" || employeeid == "") {

		$("#error").text("Please Select any Employee");
		$("#error1").hide();
		return false;
	} else {
		return true;
	}
}