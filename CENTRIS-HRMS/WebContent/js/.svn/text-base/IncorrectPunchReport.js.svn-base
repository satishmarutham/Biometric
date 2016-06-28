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
	
	if(selectboxId!="#locationId"){
		var anOption = document.createElement("OPTION");
		anOption.setAttribute("value", "");
		anOption.text = "---Select Option---";
		selectObject.append(anOption);
		var anOptionAll = document.createElement("OPTION");
		anOptionAll.setAttribute("value", "%%");
		anOptionAll.text = "All";
		if (dataForOption.length > 0)
			selectObject.append(anOptionAll);
		
	}
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
					
					var result = callAjax("adddesignation.do?parameter=getDesignationDetails","");
					createSelectBox("#designationId",result.designationlist);
					
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

					$('#locationId,#designationId')
					.change(
							function() {
								var locList = []; 
								$('#locationId :selected').each(function(i, selected){ 
									locList[i] = $(selected).val(); 
								});
								
								var sendParam = {
									'designation' : $('#designationId').val(),
									'group' : $("#groupId").val(),
									'location' : locList.join(",")
								};
								if($('#locationId :selected').val() != undefined && $("#designationId").val()!=""){
									var result = callAjax("consolidateDetailedMonthReport.do?parameter=getEmpDetailsByDesiWithMultipleLocation",sendParam);
									createSelectBox("#employeeId",result.empList);
								}
						
							});

					$('#viewIncorrectPunchReport')
							.click(
									function() {
										var valid = validations();
										if (valid) {
											var locList = []; 
											$('#locationId :selected').each(function(i, selected){ 
												locList[i] = $(selected).val(); 
											});
											$('#locId').val(locList.join(","));
											$("#incorrectPunchReport").submit();
										}
									});

					$('#downloadPdf')
							.click(
									function() {
										var locList = []; 
										$('#locationId :selected').each(function(i, selected){ 
											locList[i] = $(selected).val(); 
										});
										$('#locId').val(locList.join(","));
										$("#incorrectPunchReport").attr('action','incorrectPunchReport.do?parameter=downloadIncorrectPunchReport&location='+locList.join(","));
										$("#incorrectPunchReport").submit();
									});
					
					
					if ($('#hgroupId').val() != "" && $('#hgroupId').val() != undefined) {
						var sendGroup = {
							'group' : $('#hgroupId').val().trim()
						};
						var result = callAjax(
								"location.do?parameter=getLocationByGroup",
								sendGroup);
						createSelectBox("#locationId", result.locationList);
						if ($('#hdesignationId').val() != "" &&  $('#hlocationId').val() != "" ) {
							var sendParam = {
								'designation' : $('#hdesignationId').val().trim(),
								'group' : $("#hgroupId").val().trim(),
								'location' : $('#hlocationId').val().trim()
							};
							var result = callAjax(
									"consolidateDetailedMonthReport.do?parameter=getEmpDetailsByDesiWithMultipleLocation",
									sendParam);
							createSelectBox("#employeeId", result.empList);
						
					}
					$('#groupId [value=' + $('#hgroupId').val() + ']')
							.attr('selected', true);
					var locArray=$('#hlocationId').val().trim().split(",");
					for(var p=0;p<locArray.length;p++){
						$('#locationId [value="'+ locArray[p] + '"]').attr('selected', true);
					}
					
					$(
							'#designationId [value="'
									+ $('#hdesignationId').val().trim() + '"]')
							.attr('selected', true);
					$(
							'#employeeId [value="'
									+ $('#hemployeeId').val().trim() + '"]')
							.attr('selected', true);
						
						$('#startdateId').val($('#hstartDate').val());
						$('#enddateId').val($('#hendDate').val());
						
					}

					});

function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var designationName = $("#designationId").val();
	var employeeName = $("#employeeId").val();
	var startDate = $("#startdateId").val();
	var endDate = $("#enddateId").val();

	var d1 = Date.parse(dateConverter(startDate));
	var d2 = Date.parse(dateConverter(endDate));

	if (groupName == "") {

		$("#errordiv").text("Select Group");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	} else if ($('#locationId :selected').val() == undefined) {

		$("#errordiv").text("Select Location");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;

	} else if (designationName == "") {

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

	else if (startDate == "")  {
		$("#errordiv").text("Select Start Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}
	else if (endDate == "") {
		$("#errordiv").text("Select End Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}
	else if (d1 > d2) {
		$("#errordiv").text("Start Date Should Less then End Date");
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