function addAttendanceStatus() {

	var statustypecode = $('#statustypecode').val().trim();
	var statustypename = $('#statustypename').val().trim();
	var shortname = $('#shortname').val().trim();
	var description = $('#description').val().trim();
	var count=0;

	$('input[name="selectBox"]:checked').each(function(){
		count = count + 1;
		
	});
	if(count > 0 ){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Uncheck the Selected Status Type");
		return false;
	}else if (statustypename == "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter your Status Type");
		return false;
	} else if (!statustypename.match(/^[a-zA-Z\s-, ]+$/)) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Status Type Allow Only alphabets");
		return false;
	} else if (shortname == "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter Your ShortName");
		return false;
	} else if (!shortname.match(/^[a-zA-Z\s-, ]+$/)) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Short Name allow Only alphabets");
		return false;
	}
	 else if (shortname.length < 2 || shortname.length > 2) {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Short Name Should Be Two Characters");
			return false;
		}	
	else if (description == "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter your Description");
		return false;
	} else if (statustypecode != "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Update the StatusType you can't Add");
		return false;
	} else if (valstypename) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Status Type Already Exists");
		return false;
	} else if (valshortname) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Short Name Already exists");
		return false;
	} else {
		return true;
	}
}

var valstypename;
function validationStatusType() {
	var statustypename = $('#statustypename').val();
	var statustype = {
		"statustypename" : statustypename
	};
	callAjax("GetAttendanceDetails.do?parameter=validationStatusType",
			statustype);
	valstypename = result.status;

}

var valshortname;
function validationshortname() {
	var shortname = $('#shortname').val();

	var shortnamedata = {
		"shortname" : shortname
	};
	callAjax("GetAttendanceDetails.do?parameter=validationshortname",
			shortnamedata);

	valshortname = result.status;

}

function DeleteAttendanceStatus() {

	var checkboxArray = document.getElementsByName('selectBox');
	var deletrowsArray = new Array();

	for (var i = 0; i < checkboxArray.length; i++) {
		if (checkboxArray[i].checked == true) {
			deletrowsArray.push(checkboxArray[i].value);
		}
	}
	if (deletrowsArray.length <= 0) {
		$("#errordiv").show();
		$("#errordiv").text("Select any one Status Type to delete");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		var x = confirm("Are you sure you want to delete this StatusType");
		if (x) {

			var datalist = {
				"AttendanceCode" : deletrowsArray
			};

			callAjax(
					"GetAttendanceDetails.do?parameter=deleteAttendanceStatus",
					datalist);
			var delmeggage = "";

			if (result.status) {
				delmeggage = "StatusType deleted successfully";
				window.location = "GetDetails.do?parameter=getAttendanceStatusDetails&deletemeggage="
						+ delmeggage;
			} else {

				$("#errordiv")
						.text(
								"It is already mapped by EmployeeAttendance Table you can't delete");
				$('.error-box').css({
					'visibility' : 'visible'
				});
			}

		}
	}

}

function editAttendanceStatus() {

	edit_method = true;
	var count = 0;
	var attendancecode = null;

	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		attendancecode = this.value;
	});

	if (count > 1 || count == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select any one Status Type");

	} else {

		var datalist = {
			"attendancecode" : attendancecode
		};
		callAjax("GetAttendanceDetails.do?parameter=editAttendanceStatus",
				datalist);
		$("#statustypecode").val(result.editstatuslist[0].statustypecode);
		$("#statustypename").val(result.editstatuslist[0].statustypename);
		$("#shortname").val(result.editstatuslist[0].shortname);
		$("#description").val(result.editstatuslist[0].description);

	}
}

function UpdateAttendanceStatus() {

	var statustypecode = $('#statustypecode').val().trim();
	var statustypename = $('#statustypename').val().trim();
	var shortname = $('#shortname').val().trim();
	var description = $('#description').val().trim();
	var count=0;

	$('input[name="selectBox"]:checked').each(function(){
		count = count + 1;
		
	});
	if (count==0) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("First Edit the Status Type then Update");
		return false;
	}else if (statustypename == "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter your Status Type");
		return false;
	} else if (!statustypename.match(/^[a-zA-Z\s-, ]+$/)) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Status Type Allow Only alphabets");
		return false;
	} else if (shortname == "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter your Short Name");
		return false;
	} else if (!shortname.match(/^[a-zA-Z\s-, ]+$/)) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Short Name allow Only Alphabets");
		return false;
	} 
	else if (shortname.length < 2 || shortname.length > 2) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Short Name Should Be Two Characters");
		return false;
	} 
	
	
	else if (description == "" || null) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter your Description");
		return false;
	}  else {

		var updateStatusDetails = {
			"statustypecode" : statustypecode,
			"statustypename" : statustypename,
			"shortname" : shortname,
			"description" : description
		};

		callAjax(
				"GetAttendanceDetails.do?parameter=updateAttendanceStatusDetails",
				updateStatusDetails);

		var updatetext = "";
		if (result.status) {
			updatetext = "StatusType successfully Updated";
			window.location = "GetDetails.do?parameter=getAttendanceStatusDetails&updateMessage="
					+ updatetext;
		} else {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text(
					"Updation failed StatusType or ShortName already exist");
		}
	}
}
function clearAttendanceStatus() {

	$('#statustypename').val("");
	$('#shortname').val(" ");
	$('#description').val(" ");
}

function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	if (selectall[0].checked == true) {
		for (var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = true;

		}
	} else {
		for (var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = false;
		}
	}
}

var result;
function callAjax(urlWithMethod, dataToBeSend) {
	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				result = $.parseJSON(data);
				jsonResult = result;
			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}