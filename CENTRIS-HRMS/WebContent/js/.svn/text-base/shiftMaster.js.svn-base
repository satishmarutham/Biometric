$(document).ready(function() {
	//$("#UpdateAndDeleteMessage").hide();
	$("#errordiv").show();
	$("#modifybutton").hide();
	$("#deletebutton").hide();

	var errorVal = $("#UpdateAndDeleteMessage").text();
	
	if (errorVal != "") {
		$("#ErrorMessageValidation").hide();
		$("#errordiv").text(errorVal);
		$("#errordiv").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
	}
	
	$('#tableId tr').find('th:first').hide();
	$('#tableId tr').find('th:nth-last-child(2)').hide();
	$('#tableId tr').find('th:nth-last-child(3)').hide();
	$('#tableId tr').find('th:nth-last-child(4)').hide();
	$('#tableId tr').click(function(){
		var rowObject=$(this);
	
		PopulateData(rowObject.find('td:nth-child(1)').text().trim(), rowObject.find('td:nth-child(2)').text().trim(), rowObject.find('td:nth-child(3)').text().trim(), rowObject.find('td:nth-child(4)').text().trim(),
				rowObject.find('td:nth-child(5)').text().trim(), rowObject.find('td:nth-child(6)').text().trim(), rowObject.find('td:nth-child(7)').text().trim(), rowObject.find('td:nth-child(8)').text().trim(), rowObject.find('td:nth-child(9)').text().trim(), rowObject.find('td:nth-child(10)').text().trim(),
				rowObject.find('td:nth-child(11)').text().trim(), rowObject.find('td:nth-child(12)').text().trim(),rowObject.find('td:nth-child(13)').text().trim());
		
	});
	

});

/* Change the color of the table to default */
var jsonresult = "";
function ChangeColor() {
	var objTable = document.getElementById("tblData");
	for (i = 1; i < objTable.rows.length; i++) {
		if (i % 2 == 0)
			objTable.rows(i).className = "altLineTwo";
		else
			objTable.rows(i).className = "altLineOne";

	}
}

/* Populate the Data on the tabData Click to the textboxes */

function PopulateData(s_shift_id, s_shift_name, s_start_time, s_end_time,
		s_ltoc, s_etog, s_ltoc_gc, s_etog_gc, s_ltoc_exec, s_etog_exec,
		s_ltoc_deduct, s_etog_deduct, location) {

	$('.error-box').css({
		'visibility' : 'hidden'
	});
	$('.error-box').empty();
	$("#modifybutton").show();
	$("#deletebutton").show();
	$("#addbutton").hide();

	var shiftstarttime = s_start_time.split(":");
	var shiftendtime = s_end_time.split(":");
	var shiftlatetocome = s_ltoc.split(":");
	var shiftearliertogo = s_etog.split(":");

	document.frm_usercreation.ai_shift_id.value = s_shift_id;
	document.frm_usercreation.ai_shift_name.value = s_shift_name;
	document.frm_usercreation.ai_shift_start_t.value = shiftstarttime[0];
	document.frm_usercreation.ai_shift_start_m.value = shiftstarttime[1];

	document.frm_usercreation.ai_shift_end_t.value = shiftendtime[0];
	document.frm_usercreation.ai_shift_end_m.value = shiftendtime[1];
	document.frm_usercreation.ai_shift_ltoc_time.value = shiftlatetocome[0];
	$("#ai_shift_ltoc_Min option[value^=" + shiftlatetocome[1] + "]").attr(
			'selected', 'true');
	// document.frm_usercreation.ai_shift_ltoc_min.value = shiftlatetocome[1];
	document.frm_usercreation.ai_shift_etog_time.value = shiftearliertogo[0];
	$("#ai_shift_etog_min option[value^=" + shiftearliertogo[1] + "]").attr(
			'selected', 'true');
	// document.frm_usercreation.ai_shift_etog_min.value = shiftearliertogo[1];

	document.frm_usercreation.ai_shift_ltoc_g.value = s_ltoc_gc;
	document.frm_usercreation.ai_shift_etog_g.value = s_etog_gc;
	document.frm_usercreation.ai_shift_ltoc_no_e.value = s_ltoc_exec;
	document.frm_usercreation.ai_shift_etog_no_e.value = s_etog_exec;
	document.frm_usercreation.ai_shift_ltoc_dd.value = s_ltoc_deduct;
	document.frm_usercreation.ai_shift_etog_dd.value = s_etog_deduct;

	if (s_ltoc_deduct == 0.0) {
		document.frm_usercreation.ai_shift_ltoc_dd.value = 0;
	}
	if (s_etog_deduct == 0.0) {
		document.frm_usercreation.ai_shift_etog_dd.value = 0;
	}

	document.frm_usercreation.ai_shift_etog_dd.value = s_etog_deduct;
	$("#locationId").val(location);

	document.frm_usercreation.modify.disabled = false;
	document.frm_usercreation.ai_shift_id.readOnly = "readOnly";

}

function check(bol) {
	if (bol == 'true') {
		frm_usercreation.chk_active.checked = true;
		frm_usercreation.chk_inactive.checked = false;
	} else {
		frm_usercreation.chk_inactive.checked = true;
		frm_usercreation.chk_active.checked = false;
	}
}

/* For inserting the record */
function insertShift() {

	// var regex = /^[a-zA-Z0-9 ]*$/;

	var regex = /^[A-Za-z][A-Za-z0-9 -]*$/;
	var reg2 = /^[a-zA-Z0-9 ]*$/;

	var shift_name = document.frm_usercreation.ai_shift_name.value.trim();
	if (shift_name == "") {
		$("#errordiv").show();
		$("#errordiv").text("Enter Shift Name");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else if (!(reg2.test(shift_name))) {

		$("#errordiv").show();
		$("#errordiv").text("Shift Name accept alphanumeric and space only");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;

	} else if (!(regex.test(shift_name))) {
		$("#errordiv").show();
		$("#errordiv").text("Shift Name should start with Alphabets");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}
	var starttime = document.frm_usercreation.ai_shift_start_t.value;
	var endtime = document.frm_usercreation.ai_shift_end_t.value;
	if (starttime == 00 || starttime == "") {
		$("#errordiv").show();
		$("#errordiv").text("Select Start Time");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else if (endtime == 00 || endtime == "") {
		$("#errordiv").show();
		$("#errordiv").text("Select End Time");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}

	var ai_shift_starttime = document.frm_usercreation.ai_shift_start_t.value
			+ ':' + document.frm_usercreation.ai_shift_start_m.value + ':00';
	var ai_shift_endtime = document.frm_usercreation.ai_shift_end_t.value + ':'
			+ document.frm_usercreation.ai_shift_end_m.value + ':00';
	var ai_shift_ltoc = document.frm_usercreation.ai_shift_ltoc_time.value
			+ ':' + $("#ai_shift_ltoc_Min").val() + ':00';
	var ai_shift_etog = document.frm_usercreation.ai_shift_etog_time.value
			+ ':' + $("#ai_shift_etog_min").val() + ':00';
	var ai_shift_ltoc_g = document.frm_usercreation.ai_shift_ltoc_g.value;
	var ai_shift_etog_g = document.frm_usercreation.ai_shift_etog_g.value;
	var ai_shift_ltoc_exe = document.frm_usercreation.ai_shift_ltoc_no_e.value;
	var ai_shift_etog_exe = document.frm_usercreation.ai_shift_etog_no_e.value;
	var ai_shift_ltoc_deduct = document.frm_usercreation.ai_shift_ltoc_dd.value;
	var ai_shift_etog_deduct = document.frm_usercreation.ai_shift_etog_dd.value;

	var Todaydate = new Date();
	var d1 = new Date(Todaydate.getFullYear(), Todaydate.getMonth(), Todaydate
			.getDate(), document.frm_usercreation.ai_shift_start_t.value,
			document.frm_usercreation.ai_shift_start_m.value, 00, 00);
	var d2 = new Date(Todaydate.getFullYear(), Todaydate.getMonth(), Todaydate
			.getDate(), document.frm_usercreation.ai_shift_end_t.value,
			document.frm_usercreation.ai_shift_end_m.value, 00, 00);
	if (d1 > d2) {
		$("#errordiv").show();
		$("#errordiv").text("Start Time Should not less than End Time");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}
	;

	document.frm_usercreation.ai_shift_start_time.value = ai_shift_starttime;
	document.frm_usercreation.ai_shift_end_time.value = ai_shift_endtime;
	document.frm_usercreation.ai_shift_ltoc.value = ai_shift_ltoc;
	document.frm_usercreation.ai_shift_etog.value = ai_shift_etog;
	document.frm_usercreation.ai_shift_ltoc_gc.value = ai_shift_ltoc_g;
	document.frm_usercreation.ai_shift_etog_gc.value = ai_shift_etog_g;
	document.frm_usercreation.ai_shift_ltoc_no_exec.value = ai_shift_ltoc_exe;
	document.frm_usercreation.ai_shift_etog_no_exec.value = ai_shift_etog_exe;
	document.frm_usercreation.ai_shift_ltoc_ld.value = ai_shift_ltoc_deduct;
	document.frm_usercreation.ai_shift_etog_ld.value = ai_shift_etog_deduct;

	// Grace Late To Come Validation
	var starttime_split = ai_shift_starttime.split(":");
	var stime_hours = Number(starttime_split[0]);
	var stime_mins = Number(starttime_split[1]);

	var late_to_come_split = ai_shift_ltoc.split(":");
	var etime_hours = Number(late_to_come_split[0]);
	var etime_mins = Number(late_to_come_split[1]);

	var difference_Time = Math.abs(((etime_hours - stime_hours) * 60 - Math
			.abs((etime_mins - stime_mins))));

	var x = Number(ai_shift_ltoc_g);
	if (difference_Time < x) {
		$("#errordiv").show();
		$("#errordiv").text(
				"Late To Come Grace Time Should Be Valid You Given----" + x);
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}
	// Grace Early To Go Validation
	var endtime_split = ai_shift_endtime.split(":");
	var endtime_hours = Number(endtime_split[0]);
	var endtime_mins = Number(endtime_split[1]);

	var early_to_go_split = ai_shift_etog.split(":");
	var earlytime_hours = Number(early_to_go_split[0]);
	var earlytime_mins = Number(early_to_go_split[1]);

	var difference_early_Time = Math
			.abs(((endtime_hours - earlytime_hours) * 60 - Math
					.abs((endtime_mins - earlytime_mins))));
	var y = Number(ai_shift_etog_g);
	if (difference_early_Time < y) {
		$("#errordiv").show();
		$("#errordiv").text(
				"Early To Go Grace Time Should Be Valid You Given----" + y);
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}

	var shiftname = $("#shiftname").val();

	if (jsonresult == shiftname) {
		$("#errordiv").show();
		$("#errordiv").text("Shift Name Is Unique");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}

	var location = $("#locationId").val();
	if (location == "" || location == undefined) {
		$("#errordiv").show();
		$("#errordiv").text("Select Location");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	}

	if (checkUniqueName()) {

		$("#errordiv").show();
		$("#errordiv").text("Shift and Location Combination should be Unique");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;

	}

	// validate the shift name

	document.frm_usercreation.action = 'shiftMaster.do?method=shiftCreation';
	document.frm_usercreation.submit();

}

/* For Modifying the Records */
function updateShift() {

	var locationname = $("#locationId").val();
	var regex = /^[A-Za-z][A-Za-z0-9 -]*$/;
	var reg2 = /^[a-zA-Z0-9 ]*$/;

	var ai_shift_id = document.frm_usercreation.ai_shift_id.value;

	var ai_shift_name = document.frm_usercreation.ai_shift_name.value;
	var ai_shift_starttime = document.frm_usercreation.ai_shift_start_t.value
			+ ':' + document.frm_usercreation.ai_shift_start_m.value + ':00';
	var ai_shift_endtime = document.frm_usercreation.ai_shift_end_t.value + ':'
			+ document.frm_usercreation.ai_shift_end_m.value + ':00';
	var ai_shift_ltoc = $("#ai_shift_ltoc_time").val() + ':'
			+ $("#ai_shift_ltoc_Min").val() + ':00';
	var ai_shift_etog = document.frm_usercreation.ai_shift_etog_time.value
			+ ':' + $("#ai_shift_etog_min").val() + ':00';
	var ai_shift_ltoc_g = document.frm_usercreation.ai_shift_ltoc_g.value;
	var ai_shift_etog_g = document.frm_usercreation.ai_shift_etog_g.value;
	var ai_shift_ltoc_exe = document.frm_usercreation.ai_shift_ltoc_no_e.value;
	var ai_shift_etog_exe = document.frm_usercreation.ai_shift_etog_no_e.value;
	var ai_shift_ltoc_deduct = document.frm_usercreation.ai_shift_ltoc_dd.value;
	var ai_shift_etog_deduct = document.frm_usercreation.ai_shift_etog_dd.value;

	document.frm_usercreation.ai_shift_id.value = ai_shift_id;
	document.frm_usercreation.ai_shift_name.value = ai_shift_name;
	document.frm_usercreation.ai_shift_start_time.value = ai_shift_starttime;
	document.frm_usercreation.ai_shift_end_time.value = ai_shift_endtime;
	document.frm_usercreation.ai_shift_ltoc.value = ai_shift_ltoc;
	document.frm_usercreation.ai_shift_etog.value = ai_shift_etog;
	document.frm_usercreation.ai_shift_ltoc_gc.value = ai_shift_ltoc_g;
	document.frm_usercreation.ai_shift_etog_gc.value = ai_shift_etog_g;
	document.frm_usercreation.ai_shift_ltoc_no_exec.value = ai_shift_ltoc_exe;
	document.frm_usercreation.ai_shift_etog_no_exec.value = ai_shift_etog_exe;
	document.frm_usercreation.ai_shift_ltoc_ld.value = ai_shift_ltoc_deduct;
	document.frm_usercreation.ai_shift_etog_ld.value = ai_shift_etog_deduct;

	var shift_name = document.frm_usercreation.ai_shift_name.value.trim();
	if (shift_name == "") {
		$("#errordiv").show();
		$("#errordiv").text("Enter Shift Name");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else if (!(reg2.test(shift_name))) {

		$("#errordiv").show();
		$("#errordiv").text("Shift Name accept alphanumeric and space only");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;

	} else if (!(regex.test(shift_name))) {
		$("#errordiv").show();
		$("#errordiv").text("Shift Name should start with Alphabets");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else if (locationname == "") {

		$("#errordiv").show();
		$("#errordiv").text("Select Location Name");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		var Todaydate = new Date();
		var d1 = new Date(Todaydate.getFullYear(), Todaydate.getMonth(),
				Todaydate.getDate(),
				document.frm_usercreation.ai_shift_start_t.value,
				document.frm_usercreation.ai_shift_start_m.value, 00, 00);
		var d2 = new Date(Todaydate.getFullYear(), Todaydate.getMonth(),
				Todaydate.getDate(),
				document.frm_usercreation.ai_shift_end_t.value,
				document.frm_usercreation.ai_shift_end_m.value, 00, 00);
		if (d1 > d2) {
			$("#errordiv").show();
			$("#errordiv").text("Start Time Should not less than End Time");
			$('.error-box').css({
				'visibility' : 'visible'
			});
			return false;
		} else

		if (checkUniqueNameUpdate(ai_shift_id)) {

			$("#errordiv").show();
			$("#errordiv").text(
					"Shift and location combination should be unique");
			$('.error-box').css({
				'visibility' : 'visible'
			});
			return false;

		} else {

			document.frm_usercreation.action = 'shiftMaster.do?method=shiftUpdate';
			document.frm_usercreation.submit();
		}
	}

}

/* Deleting the records */
function deleteShift() {
	var ai_shift_id = document.frm_usercreation.ai_shift_id.value;
	$("#locationId").val(location);
	document.frm_usercreation.action = 'shiftMaster.do?method=shiftDelete';
	document.frm_usercreation.submit();

}

var available;
var availableupdate;

function checkUniqueName() {

	var shiftname = $("#shiftname").val();
	var locationname = $("#locationId").val();
	var shiftlocationdetails = {
		"shiftname" : shiftname,
		"locationname" : locationname
	};
	$.ajax({
		type : 'POST',
		url : 'shiftMaster.do?method=checkShifName',
		data : shiftlocationdetails,
		async : false,

		success : function(response) {
			var result = $.parseJSON(response);

			var no = result.count;
			if (no > 0) {

				$("#errordiv").show();
				$("#errordiv").text(
						"Shift and Location Combination should be Unique");
				$('.error-box').css({
					'visibility' : 'visible'
				});
				available = true;
			} else {

				available = false;
			}

			/*
			 * for(var i=0;i<result.ShiftNameList.length;i++){
			 * jsonresult=result.ShiftNameList[i].ai_shift_name;
			 * 
			 * if(jsonresult==shiftname){ $("#errordiv").show();
			 * $("#errordiv").text("Shift Name Is Unique");
			 * $('.error-box').css({'visibility': 'visible'}); return false; } }
			 */

		}

	});
	return available;

}

function checkUniqueNameUpdate(shiftid) {

	var shiftname = $("#shiftname").val();
	var locationname = $("#locationId").val();
	var shiftlocationdetails = {
		"shiftname" : shiftname,
		"locationname" : locationname,
		"shiftid" : shiftid
	};
	$.ajax({
		type : 'POST',
		url : 'shiftMaster.do?method=checkShifNameUpdate',
		data : shiftlocationdetails,
		async : false,

		success : function(response) {
			var result = $.parseJSON(response);

			var no = result.count;
			if (no > 0) {

				$("#errordiv").show();
				$("#errordiv").text(
						"Shift and Location Combination should be Unique");
				$('.error-box').css({
					'visibility' : 'visible'
				});
				availableupdate = true;
			} else {

				availableupdate = false;
			}

			/*
			 * for(var i=0;i<result.ShiftNameList.length;i++){
			 * jsonresult=result.ShiftNameList[i].ai_shift_name;
			 * 
			 * if(jsonresult==shiftname){ $("#errordiv").show();
			 * $("#errordiv").text("Shift Name Is Unique");
			 * $('.error-box').css({'visibility': 'visible'}); return false; } }
			 */

		}

	});
	return availableupdate;

}