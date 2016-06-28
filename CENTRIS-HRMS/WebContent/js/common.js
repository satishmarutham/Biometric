$(document)
		.ready(
				function() {

					var userRole = $('#userRole').val();
					if (userRole != null && userRole != undefined
							&& userRole.trim() != '' && userRole != 'null'
							&& userRole != 'undefined') {
						if (userRole.trim() != "ROL1") {
							$('.USER_LOCATION').remove();
						} else {
							var result = callAjax(
									"GetDetails.do?parameter=getLocation", "");
							createSelectBox(".userLocationId",
									result.locationList);
							$('.userLocationId')
									.change(
											function() {
												var locationId = $(this).val()
														.split(",")[0];
												var result = callAjax(
														"GetDetails.do?parameter=getShiftBylocation",
														{
															'Location' : locationId
														});
												createSelectBox(
														".shiftClassForAdmin",
														result.shiftList);
											});

							$('.shiftClassForAdmin')
									.change(
											function() {
												var locationId = $(
														'.userLocationId')
														.val().split(",")[0];
												var shiftId = $(this).val()
														.split(",")[0];
												var result = callAjax(
														"GetDetails.do?parameter=getEmpBylocationShift",
														{
															'Location' : locationId,
															'Shift' : shiftId
														});
												// alert(JSON.stringify(result));
												if ($('.empClassForAdmin')
														.val() != undefined)
													createSelectBox(
															".empClassForAdmin",
															result.empList);
											});
						}
					}

					/* For Error Message Timeout */

					var errorBoxText = $('.error-box').text().trim();
					if (errorBoxText == "") {
						$('.error-box').css({
							'visibility' : 'hidden'
						});
					} else {
						setTimeout(function() {
							removeMessage();
						}, 5000);
					}
					$('.success-box').css({
						'visibility' : 'hidden'
					});
				});

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
		} else {
			jsonkey[0] = key;
		}
	}

	$(selectboxId).empty();
	var selectObject = $(selectboxId);
	var anOption = document.createElement("OPTION");
	anOption.setAttribute("value", "");
	anOption.innerHTML = "---Select Option---";
	selectObject.append(anOption);
	for ( var i = 0; i < dataForOption.length; i++) {
		if (dataForOption[i][jsonkey[1]] != "") {
			var anOption = document.createElement("OPTION");
			anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			anOption.innerHTML = dataForOption[i][jsonkey[1]];
			selectObject.append(anOption);
		}
	}

}

function createSelectBoxWithoutOption(selectboxId, dataForOption) {
	var jsonkey = [];
	for (key in dataForOption[0]) {
		if (key.indexOf("Name") != -1 || key.indexOf("name") != -1) {
			jsonkey[1] = key;
		} else if (/id$/.test(key) || /code$/.test(key) || /Id$/.test(key)) {
			jsonkey[0] = key;
		}
	}

	$(selectboxId).empty();
	var selectObject = $(selectboxId);

	for ( var i = 0; i < dataForOption.length; i++) {
		if (dataForOption[i][jsonkey[1]] != "") {
			var anOption = document.createElement("OPTION");
			anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			anOption.innerHTML = dataForOption[i][jsonkey[1]];
			selectObject.append(anOption);
		}
	}

}

/* For Error Message Timeout */
function removeMessage() {
	$.ajax({
		type : "GET",
		url : "removeErrorMessage.do?method=removeMessage",
		async : false,
		success : function(data) {
			var errorBoxText = $('.error-box').text().trim();
			if (errorBoxText == "")
				$('.error-box').empty();
		}
	});
}

function checkRegexpText(o, regexp, n, emptyAllowed) {
	if ((!emptyAllowed && !(regexp.test(o.val().trim())))
			|| (emptyAllowed && !(regexp.test(o.val().trim())))) {
		$(".error-box").parents('form').find('.ui-state-error').removeClass(
				"ui-state-error");
		$(".error-box").addClass("ui-state-error");

		$('html, body').animate({
			scrollTop : $('#errordiv').offset().top
		}, 'fast');

		updateTips(n);
		return false;
	} else {
		o.removeClass("ui-state-error");
		return true;
	}
}

function selectBoxElement(selectVal, errorMessage) {

	var selectId = selectVal.val().length;
	if (selectId == 0) {
		selectVal.parents('form').find('.ui-state-error').removeClass(
				"ui-state-error");
		selectVal.addClass("ui-state-error");
		$('html, body').animate({
			scrollTop : $('#errordiv').offset().top
		}, 'fast');
		updateTips(errorMessage);

		return false;
	} else {
		selectVal.removeClass("ui-state-error");
		return true;
	}
}

function checkMajor(doj, dob, message, previousstatus) {

	var birthYear = dob.val().split("-")[2];

	var joiningyear = doj.val().split("-")[2];

	var yearDiff = parseInt(joiningyear) - parseInt(birthYear);

	if ((yearDiff - 1) < 18) {
		dob.parents('form').find('.ui-state-error').removeClass(
				"ui-state-error");
		dob.addClass("ui-state-error");
		$('html, body').animate({
			scrollTop : $('#errordiv').offset().top
		}, 'fast');
		updateTips(message);
		return false;
	} else {
		dob.removeClass("ui-state-error");
		return true;
	}
}

function checkLengthText(o, n, min, max) {

	if (o.val() == 0) {

		o.addClass("ui-state-error");
		updateTips("Enter" + " " + n);
		return false;
	} else {
		if (o.val().length > max || o.val().length < min) {

			o.parents('form').find('.ui-state-error').removeClass(
					"ui-state-error");
			o.addClass("ui-state-error");
			updateTips("Length of " + n + " must be " + max + ".");
			$('html, body').animate({
				scrollTop : $('#errordiv').offset().top
			}, 'fast');
			return false;
		} else {
			o.removeClass("ui-state-error");
			return true;
		}
	}

}

function updateTips(t) {
	tips = $('.error-box');
	tips.text(t).addClass("ui-state-highlight");
	setTimeout(function() {
		tips.removeClass("ui-state-highlight", 500);
	}, 500);
}
