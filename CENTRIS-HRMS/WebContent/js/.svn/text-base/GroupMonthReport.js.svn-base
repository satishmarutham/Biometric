$(document)
		.ready(
				function() {
					$.ajax({
						type : "GET",
						url : "groupmonthreport.do?parameter=getGroup",
						success : function(response) {

							var result = $.parseJSON(response);

							var group = $("#group");

							for ( var j = 0; j < result.grouplist.length; j++) {

								$(group).append(
										'<option value="'
												+ result.grouplist[j].groupId
												+ '">'
												+ result.grouplist[j].groupName
												+ '</option>');
							}

						}
					});
					$("#group").change(function() {
						groupDetailMapping();
					});
					function groupDetailMapping() {

						var groupVal = $("#group > option:selected").val();

						if (groupVal == 'all') {
							$("#department").empty();
							$("#department").append(
									'<option value="' + "all" + '">' + "All"
											+ '</option>');
						} else {
							$("#department").empty();
							$("#department").append(
									'<option value="' + "all" + '">' + "All"
											+ '</option>');
						}
						if (groupVal != 0) {
							$
									.ajax({
										type : "GET",
										url : "groupmonthreport.do?parameter=getDetailVal",
										data : "groupVal=" + groupVal,
										success : function(data) {
											var obj = $.parseJSON(data);

											for ( var i = 0; i < obj.grouplist.length; i++) {

												$('#department')
														.append(
																'<option value="'
																		+ obj.grouplist[i].departmentId
																		+ '">'
																		+ obj.grouplist[i].deptName
																		+ '</option>');
											}
										}
									});
						}
					}
					$("#submit").click(
							function() {

								var inputs = document
										.getElementsByTagName("input");
								var checks = [];
								for ( var i = 0; i < inputs.length; i++) {
									if (inputs[i].type == "checkbox"
											&& inputs[i].checked) {

										checks.push(inputs[i]);
									}
								}
							});
					$("#selectall")
							.click(
									function() {

										var selectall = document
												.getElementsByName("selectall");
										var checkboxArray = document
												.getElementsByName('selectBox');
										if (selectall[0].checked == true) {
											for ( var i = 0; i < checkboxArray.length; i++) {
												checkboxArray[i].checked = true;

											}
										} else {
											for ( var i = 0; i < checkboxArray.length; i++) {
												checkboxArray[i].checked = false;
											}
										}
									});

					
					$("#date").datepicker({
						dateFormat : "yy-mm-dd",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						onClose : function(selectedDate) {
							$("#date1").datepicker("option", "minDate", selectedDate);
						}
					});
					$("#date1").datepicker({
						dateFormat : "yy-mm-dd",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						onClose : function(selectedDate) {
							$("#date").datepicker("option", "maxDate", selectedDate);
						}
					});
					$("#date").attr("placeholder", "Select from date");
					$("#date1").attr("placeholder", "Select to date");
					$("#viewReport")
							.click(
									function() {
										if (document.getElementById('group').value == "") {

											document.getElementById('error').innerHTML = 'Please Select any Group';
											return false;
										}
										if (document.getElementById('department').value == "") {

											document.getElementById('error').innerHTML = 'Please Select any Department';
											return false;
										}
										var x = document.getElementById("date").value;
										if (x == null || x == "") {
											document.getElementById('error').innerHTML = 'Please Select From Date';
											return false;
										}
										var x = document.getElementById("date1").value;
										if (x == null || x == "") {
											document.getElementById('error').innerHTML = 'Please Select To Date';
											return false;
										}
									});
				});