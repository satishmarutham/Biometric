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
					/*$('#downloadPdf').hide();
					if ($('#tableId').find('table').length != 0) {
						$('#downloadPdf').show();
					}*/
				
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

					$('#locationId')
							.change(
									function() {
										var sendLocation = {
											'location' : $(this).val(),
											'group' : $("#groupId").val()
										};

										var result = callAjax(
												"shiftMaster.do?method=getShiftByLocation",
												sendLocation);

										createSelectBox("#shiftId",
												result.shiftList);
									});

					$('#shiftId')
							.change(
									function() {
										var sendshift = {
											'shift' : $(this).val(),
											'group' : $("#groupId").val(),
											'location' : $('#locationId').val()
										};

										var result = callAjax(
												"consolidateDetailedMonthReport.do?parameter=getEmpDetailsByShift",
												sendshift);

										createSelectBox("#employeeId",
												result.empList);
									});

					$('#viewYearlyReportId')
							.click(
									function() {
										var valid = validations();
										if (valid) {
											$("#YearlyReport").attr('action','yearlyReportinfo.do?parameter=getYearlyReportDetails');
											$('#methodNameId').val('getYearlyReportDetails');
											$("#YearlyReport").submit();
										}
									});

					$('#downloadPdf')
							.click(
									function() {

									window.location.href='yearlyReportinfo.do?parameter=yearlyReportPdfdownload&employee='+$("#hiddenemployeeId").val()+' &startmonth='+$("#hiddenstartmonthId").val()+' &endmonth='+$("#hiddenendmonthId").val()+' &year='+$("#hiddenyearId").val();
										
									});

				});

function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var locationName = $("#locationId").val();
	var shiftName = $("#shiftId").val();
	var employeeName = $("#employeeId").val();
	var startmonth = $("#startmonthId").val();
	var endmonth = $("#endmonthId").val();
	var year = $("#yearId").val();
	
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

	} else if (shiftName == "") {

		$("#errordiv").text("Select Shift");
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
else if (startmonth=="") {
		$("#errordiv").text("Select StartMonth");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	}
	else if (endmonth=="") {
		$("#errordiv").text("Select EndMonth");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	}
	
	else if(startmonth > endmonth){
		$("#errordiv").text("StartMonth Should be LessThen EndMonth");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
}
	else if (year=="") {
		$("#errordiv").text("Select Year");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	}
	
	return bvalid;

}

