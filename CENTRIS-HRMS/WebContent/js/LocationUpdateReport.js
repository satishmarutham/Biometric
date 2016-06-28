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

				


					if ($('#hgroupId').val() != "") {
						var sendGroup = {
							'group' : $('#hgroupId').val().trim()
						};
						var result = callAjax("location.do?parameter=getLocationByGroup",sendGroup);
						createSelectBox("#locationId", result.locationList);
						if ($('#hlocationId').val() != "") {}
						$('#groupId [value=' + $('#hgroupId').val() + ']').attr('selected', true);
						$('#locationId [value="'+ $('#hlocationId').val().trim() + '"]').attr('selected', true);
					}
				});
function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var locationName = $("#locationId").val();

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

	}
	return bvalid;
}
function downloadForthisDay(date_key) {

	
	window.location.href = 'locationUpdateReport.do?parameter=consolidatedMonthReport_forDay&employee='
			+ $("#hemployeeId").val()
			+ ' &group='
			+ $("#hgroupId").val()
			+ ' &location='
			+ $("#hlocationId").val()
			+ ' &shift='
			+ $("#hshiftId").val()
			+ ' &year='
			+ date_key.trim()
			+ ' &groupName='
			+ $("#groupId option:selected").text();
	
	
}