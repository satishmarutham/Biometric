function callAjax(urlWithMethod, dataToBeSend) {

	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);
				jsonResult = result;
			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}

function createSelectBox(selectboxId, dataForOption) {
	var jsonkey = [];
	for (key in dataForOption[0]) {
		if (key.indexOf("Name") != -1 || key.indexOf("name") != -1) {
			jsonkey[1] = key;
		} else if (key.indexOf("id") != -1 || key.indexOf("code") != -1
				|| key.indexOf("Id") != -1) {

			jsonkey[0] = key;
		}
	}

	$(selectboxId).empty();
	var selectObject = $(selectboxId);
	var anOption = document.createElement("OPTION");
	anOption.setAttribute("value", "");
	anOption.text = "---Select Option---";
	selectObject.append(anOption);
	var anOptionAll = document.createElement("OPTION");
	anOptionAll.setAttribute("value", "%%");
	anOptionAll.text = "All";
	if (dataForOption.length > 0)
		selectObject.append(anOptionAll);
	for ( var i = 0; i < dataForOption.length; i++) {
		if (dataForOption[i][jsonkey[1]] != "") {
			var anOption = document.createElement("OPTION");
			if (selectboxId == ".empClassForAdmin"
					|| selectboxId == ".shiftClassForAdmin") {
				anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			} else {
				anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			}
			anOption.text = dataForOption[i][jsonkey[1]];
			selectObject.append(anOption);
		}
	}

}

$(document)
		.ready(
				function() {
					$('#downloadPdf').hide();
					if ($('#tableId').find('table').length != 0) {
						$('#downloadPdf').show();
					}
					$("#startdateId").datepicker({
						dateFormat : "dd-mm-yy",
						defaultDate : "+1w",
						maxDate : 0,
						changeYear : true,
						changeMonth : true,
						numberOfMonths : 1
					});
					$("#enddateId").datepicker({
						dateFormat : "dd-mm-yy",
						defaultDate : "+1w",
						maxDate : 0,
						changeYear : true,
						changeMonth : true,
						numberOfMonths : 1
					});
					
					$('#locationId')
					.change(
							function() {
					var result = callAjax("adddesignation.do?parameter=getDesignationDetails","");
					createSelectBox("#designationId",result.designationlist);
					
							});
					
					$('#groupId')
							.change(
									function() {
										var sendGroup = {
											'group' : $(this).val()
										};

										var result = callAjax(
												"location.do?parameter=getLocationByGroup",
												sendGroup);

										createSelectBox("#locationId",
												result.locationList);
									});

				

					   $('#designationId')
							.change(
									function() {
										
										var senddesignation = {
											'designation' : $(this).val(),
											'group' : $("#groupId").val(),
											'location' : $('#locationId').val()
										};

										var result = callAjax(
												"dailylogreport.do?parameter=getEmpDetailsByDesiWithLocation",
												senddesignation);
									

                                           createSelectBox("#employeeId",
												result.empList);
									});

					
					$('#downloadPdf')
							.click(
									function() {
                                 
								var hgroup=$("#hgroup").val();
								var hlocation=$("#hlocation").val();
								var hdesignation=$("#hdesignation").val();
								var hemployee=$("#hemployee").val();
								var hstartdate=$("#hstartdate").val();
								var henddate=$("#henddate").val();
								
                        document.location = 'dailylogreport.do?parameter=dailyLogReportPdfDownload&hgroup='+hgroup+'&hlocation='+hlocation+'&hdesignation='+hdesignation+'&hemployee='+hemployee+'&hstartdate='+hstartdate+'&henddate='+henddate;
									
									
									});

				});

function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var locationName = $("#locationId").val();
	var designationid = $("#designationId").val();
	var employeeName = $("#employeeId").val();
	var startDate = $("#startdateId").val();
	var endDate = $("#enddateId").val();

	var d1 = Date.parse(dateConverter(startDate));
	var d2 = Date.parse(dateConverter(endDate));

	/*
	 * if(d1>d2){ $('#alertMessage').text("Start Date Should Be Less Than End
	 * Date"); return false; }
	 */

	if (groupName == "") {

		$("#errordiv").text("Select Group");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	} else if (locationName == "") {

		$("#errordiv").text("Select Location");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;

	} else if (designationid == "") {

		$("#errordiv").text("Select Designation");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;

	} else if (employeeName == "") {
		$("#errordiv").text("Select Employee");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}

	else if ((startDate == "") && (endDate == "")) {
		$("#errordiv").text("Select Start Date or End Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}

	else if (d1 > d2) {
		$("#errordiv").text("Start Date Should not  Less than End Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	}

	return bvalid;

}

function dateConverter(dateString) {
	var dateArray = [];
	var dateStringArray = dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;

}