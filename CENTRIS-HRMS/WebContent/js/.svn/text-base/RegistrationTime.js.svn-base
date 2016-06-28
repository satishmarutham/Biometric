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

	if (selectboxId != "#locationId") {
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

$(document).ready(
		function() {

			$('#groupId').change(
					function() {
						var sendGroup = {
							'group' : $(this).val()
						};
						var result = callAjax(
								"location.do?parameter=getLocationByGroup",
								sendGroup);
						createSelectBox("#locationId", result.locationList);
					});

			$('#RegistrationDetails').click(
					function() {
						var valid = validations();
						if (valid) {
							var locList = [];
							$('#locationId :selected').each(
									function(i, selected) {
										locList[i] = $(selected).val();
									});
							$("#getRegistrationDetails").attr(
									'action',
									'getRegistrationReportDetails.do?parameter=getRegistrationDetails&location='
											+ locList.join(","));
							$('#methodNameId').val('getDetailedMonthReport');
							$("#getRegistrationDetails").submit();
						}
					});

			if ($('#hgroupId').val() != "") {
				var sendGroup = {
					'group' : $('#hgroupId').val().trim()
				};
				var result = callAjax(
						"location.do?parameter=getLocationByGroup", sendGroup);
				createSelectBox("#locationId", result.locationList);

				$('#groupId [value=' + $('#hgroupId').val() + ']').attr(
						'selected', true);
				var locArray = $('#hlocationId').val().trim().split(",");
				for ( var p = 0; p < locArray.length; p++) {
					$('#locationId [value="' + locArray[p] + '"]').attr(
							'selected', true);
				}
				$('#month [value=' + $('#hmonth').val() + ']').attr('selected',
						true);
				$('#year [value=' + $('#hyear').val() + ']').attr('selected',
						true);

			}
			
			  $('#downloadRegistrationDetails').click( function() {
			  window.location.href ='getRegistrationReportDetails.do?parameter=downloadRegistrationDetails&group='
			   + $("#hgroupId").val() + ' &location=' + $("#hlocationId").val() + '&year=' + $("#hyear").val() + ' &month=' + $("#hmonth").val();
			  
			  });
			 
		});
function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
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

	} else if (month == "") {
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