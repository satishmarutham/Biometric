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
					$('#detailedPdfId').hide();
					if ($('#tableId').find('table').length != 0) {
						$('#detailedPdfId').show();
					}
					$('#consolidatedPdfId').hide();
					if ($('#tableId').find('table').length != 0) {
						$('#consolidatedPdfId').show();
					}
					
					var result = callAjax("adddesignation.do?parameter=getDesignationDetails","");
					createSelectBox("#designationId",result.designationlist);

					$('.accBody').css('display','none');
					$('.accBody:first').css('display','block');
					
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

				

					$('#detailedId')
							.click(
									function() {
										var valid = validations();
										if (valid) {
											var locList = []; 
											$('#locationId :selected').each(function(i, selected){ 
												locList[i] = $(selected).val(); 
											});
											
											$("#MonthReport")
													.attr('action',
															'consolidateDetailedMonthReport.do?parameter=getDetailedMonthReport&location='+locList.join(","));
											$('#methodNameId').val(
													'getDetailedMonthReport');
											$("#MonthReport").submit();
										}
									});
					$('#consolidatedId')
							.click(
									function() {
										var valid = validations();
										if (valid) {
											var locList = []; 
											$('#locationId :selected').each(function(i, selected){ 
												locList[i] = $(selected).val(); 
											});
											$("#MonthReport")
													.attr('action',
															'consolidateDetailedMonthReport.do?parameter=getConsolidatedMonthReport&location='+locList.join(","));
											$('#methodNameId')
													.val(
															'getConsolidatedMonthReport');
											$("#MonthReport").submit();
										}
									});

					$('#detailedPdfId')
							.click(
									function() {

										window.location.href = 'consolidateDetailedMonthReport.do?parameter=detailedMonthReportPdfdownload&employee='
												+ $("#hemployeeId").val()
												+ ' &group='
												+ $("#hgroupId").val()
												+ ' &location='
												+ $("#hlocationId").val()
												+ ' &designation='
												+ $("#hdesignationId").val()
												+ ' &year='
												+ $("#hyear").val()
												+ ' &month='
												+ $("#hmonth").val();

									});

					$('#consolidatedPdfId').click(
									function() {

										window.location.href = 'consolidateDetailedMonthReport.do?parameter=consolidatedMonthReportPdfdownload&employee='
												+ $("#hemployeeId").val()
												+ ' &group='
												+ $("#hgroupId").val()
												+ ' &location='
												+ $("#hlocationId").val()
												+ ' &designation='
												+ $("#hdesignationId").val()
												+ ' &year='
												+ $("#hyear").val()
												+ ' &month='
												+ $("#hmonth").val();

									});

					if ($('#hgroupId').val() != "") {
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
						$('#month [value=' + $('#hmonth').val() + ']').attr(
								'selected', true);
						$('#year [value=' + $('#hyear').val() + ']').attr(
								'selected', true);

					}

					$('.accordHead').click(function() {
						var displaypro = $(this).next('div').css('display');
						if (displaypro == 'none') {
							$(this).next('div').css({
								'display' : 'block'
							});
						} else {
							$(this).next('div').css({
								'display' : 'none'
							});
						}
					});

					/*$('#downloadForthisDate')
							.click(
									function() {

										var date_Val = $('span.accordHead')
												.text().trim();
										alert(date_Val);
										window.location.href = 'consolidateDetailedMonthReport.do?parameter=consolidatedMonthReport_forDay&employee='
												+ $("#hemployeeId").val()
												+ ' &group='
												+ $("#hgroupId").val()
												+ ' &location='
												+ $("#hlocationId").val()
												+ ' &shift='
												+ $("#hshiftId").val()
												+ ' &year='
												+ $('span.accordHead').text()
														.trim();
									});*/
					
					
							

				});
function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var designationName = $("#designationId").val();
	var employeeName = $("#employeeId").val();
	var month = $("#month").val();
	var year = $("#year").val();

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

	else if (month == "") {
		$("#errordiv").text("Select Month");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	} else if (year == "") {
		$("#errordiv").text("Select Year");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}
	return bvalid;
}
function downloadForthisDay(date_key) {

	
	window.location.href = 'consolidateDetailedMonthReport.do?parameter=consolidatedMonthReport_forDay&employee='
			+ $("#hemployeeId").val()
			+ ' &group='
			+ $("#hgroupId").val()
			+ ' &location='
			+ $("#hlocationId").val()
			+ ' &designation='
			+ $("#hdesignationId").val()
			+ ' &year='
			+ date_key.trim()
			+ ' &groupName='
			+ $("#groupId option:selected").text();
	
	
}