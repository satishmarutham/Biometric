$(document).ready(function() {
	$("#modifybutton").hide();
	$("#deletebutton").hide();

});

/* Change the color of the table to default */

function ChangeColor() {
	var objTable = document.getElementById("tblData");
	for (i = 1; i < objTable.rows.length; i++) {
		if (i % 2 == 0)
			objTable.rows(i).className = "altLineTwo";
		else
			objTable.rows(i).className = "altLineOne";

	}
}
/* clear data */
function clear12() {

	document.frm_usercreation.ai_shift_id.value = "";
	document.frm_usercreation.ai_shift_name.value = "";
	document.frm_usercreation.ai_shift_start_t.value = "";
	document.frm_usercreation.ai_shift_start_m.value = "";
	document.frm_usercreation.ai_shift_end_t.value = "";
	document.frm_usercreation.ai_shift_end_m.value = "";
	document.frm_usercreation.ai_shift_ltoc_time.value = "";
	document.frm_usercreation.ai_shift_ltoc_min.value = "";
	document.frm_usercreation.ai_shift_etog_time.value = "";
	document.frm_usercreation.ai_shift_etog_min.value = "";
	document.frm_usercreation.ai_shift_ltoc_g.value = "";
	document.frm_usercreation.ai_shift_etog_g.value = "";
	document.frm_usercreation.ai_shift_ltoc_no_e.value = "";
	document.frm_usercreation.ai_shift_etog_no_e.value = "";
	document.frm_usercreation.ai_shift_ltoc_dd.value = "";
	document.frm_usercreation.ai_shift_etog_dd.value = "";
	// document.frm_usercreation.shift_id.readOnly =false;

	document.frm_usercreation.insert.disabled = false;
	// document.frm_usercreation.insert.className='clickable button DarkGray';
	document.frm_usercreation.modify.disabled = true;
	document.frm_usercreation.ai_shift_id.value.disabled = false;
	// document.frm_usercreation.delete.disabled=true;
	// document.frm_usercreation.modify.className='buttonstyle';
}

/* Populate the Data on the tabData Click to the textboxes */

function PopulateData(s_shift_id, s_shift_name, s_start_time, s_end_time,
		s_ltoc, s_etog, s_ltoc_gc, s_etog_gc, s_ltoc_exec, s_etog_exec,
		s_ltoc_deduct, s_etog_deduct) {

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
	document.frm_usercreation.ai_shift_ltoc_min.value = shiftlatetocome[1];
	document.frm_usercreation.ai_shift_etog_time.value = shiftearliertogo[0];
	document.frm_usercreation.ai_shift_etog_min.value = shiftearliertogo[1];

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

	// document.frm_usercreation.chk_active.checked=false;
	// document.frm_usercreation.chk_inactive.checked=false;

	// document.frm_usercreation.insert.disabled=true;
	// document.frm_usercreation.insert.className='button1';
	document.frm_usercreation.modify.disabled = false;
	document.frm_usercreation.ai_shift_id.readOnly = "readOnly";
	// document.frm_usercreation.modify.className='clickable button DarkGray';
	/*
	 * if(s_pstatus=='Y') document.frm_usercreation.chk_active.checked=true;
	 * if(s_pstatus=='N') document.frm_usercreation.chk_inactive.checked=true;
	 */
	// return false;
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
function ins() {

	var ai_shift_id = document.frm_usercreation.ai_shift_id.value;
	var shift_name = document.frm_usercreation.ai_shift_name.value;
	var randno = Math.round(50 * Math.random());
	document.frm_usercreation.ai_shift_id.value = shift_name.substring(0, 4)
			+ randno;
	var ai_shift_name = document.frm_usercreation.ai_shift_name.value;
	var ai_shift_starttime = document.frm_usercreation.ai_shift_start_t.value
			+ ':' + document.frm_usercreation.ai_shift_start_m.value + ':00';
	var ai_shift_endtime = document.frm_usercreation.ai_shift_end_t.value + ':'
			+ document.frm_usercreation.ai_shift_end_m.value + ':00';
	var ai_shift_ltoc = document.frm_usercreation.ai_shift_ltoc_time.value
			+ ':' + document.frm_usercreation.ai_shift_ltoc_min.value + ':00';
	var ai_shift_etog = document.frm_usercreation.ai_shift_etog_time.value
			+ ':' + document.frm_usercreation.ai_shift_etog_min.value + ':00';
	var ai_shift_ltoc_g = document.frm_usercreation.ai_shift_ltoc_g.value;
	var ai_shift_etog_g = document.frm_usercreation.ai_shift_etog_g.value;
	var ai_shift_ltoc_exe = document.frm_usercreation.ai_shift_ltoc_no_e.value;
	var ai_shift_etog_exe = document.frm_usercreation.ai_shift_etog_no_e.value;
	var ai_shift_ltoc_deduct = document.frm_usercreation.ai_shift_ltoc_dd.value;
	var ai_shift_etog_deduct = document.frm_usercreation.ai_shift_etog_dd.value;

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

	if (ai_shift_name == "") {
		alert("Enter Shift Name");
		return false;
	}
	if (!isNaN(ai_shift_name)) {
		alert("Invalid Input: Enter String");
		return false;
	}

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
		alert("Late To Come Grace Time Shuld Be Valid You Given----" + x);
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
		alert("Early To Go Grace Time Shuld Be Valid You Given----" + y);
		return false;
	}

	var answer = confirm("Are you sure to insert?");
	if (answer) {
		document.frm_usercreation.action = 'shiftall.do?status=insert';
		document.frm_usercreation.submit();
	} else {
	}
}

/* For Modifying the Records */
function upd() {

	var ai_shift_id = document.frm_usercreation.ai_shift_id.value;
	var ai_shift_name = document.frm_usercreation.ai_shift_name.value;
	var ai_shift_starttime = document.frm_usercreation.ai_shift_start_t.value
			+ ':' + document.frm_usercreation.ai_shift_start_m.value + ':00';
	var ai_shift_endtime = document.frm_usercreation.ai_shift_end_t.value + ':'
			+ document.frm_usercreation.ai_shift_end_m.value + ':00';
	var ai_shift_ltoc = document.frm_usercreation.ai_shift_ltoc_time.value
			+ ':' + document.frm_usercreation.ai_shift_ltoc_min.value + ':00';
	var ai_shift_etog = document.frm_usercreation.ai_shift_etog_time.value
			+ ':' + document.frm_usercreation.ai_shift_etog_min.value + ':00';
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
	var answer = confirm("Are you sure to update?");
	if (answer) {
		document.frm_usercreation.action = 'shiftall.do?status=update';
		document.frm_usercreation.submit();
	} else {
	}
}

/* Deleting the records */
function del() {
	var ai_shift_id = document.frm_usercreation.ai_shift_id.value;
	var ai_shift_name = document.frm_usercreation.ai_shift_name.value;
	var ai_shift_starttime = document.frm_usercreation.ai_shift_start_t.value
			+ ':' + document.frm_usercreation.ai_shift_start_m.value + ':00';
	var ai_shift_endtime = document.frm_usercreation.ai_shift_end_t.value + ':'
			+ document.frm_usercreation.ai_shift_end_m.value + ':00';
	var ai_shift_ltoc = document.frm_usercreation.ai_shift_ltoc_time.value
			+ ':' + document.frm_usercreation.ai_shift_ltoc_min.value + ':00';
	var ai_shift_etog = document.frm_usercreation.ai_shift_etog_time.value
			+ ':' + document.frm_usercreation.ai_shift_etog_min.value + ':00';
	var ai_shift_ltoc_g = document.frm_usercreation.ai_shift_ltoc_g.value;
	var ai_shift_etog_g = document.frm_usercreation.ai_shift_etog_g.value;
	var ai_shift_ltoc_exe = document.frm_usercreation.ai_shift_ltoc_no_e.value;
	var ai_shift_etog_exe = document.frm_usercreation.ai_shift_etog_no_e.value;
	var ai_shift_ltoc_deduct = document.frm_usercreation.ai_shift_ltoc_dd.value;
	var ai_shift_etog_deduct = document.frm_usercreation.ai_shift_etog_dd.value;

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
	var answer = confirm("Are you sure to Delete?");
	if (answer) {
		document.frm_usercreation.action = 'shiftall.do?status=delete';
		document.frm_usercreation.submit();
	} else {
	}
}
/*
 * function deleteMode(){ var index=0; var infoArray = new Array(); var answer;
 * answer = confirm("Do you really want to delete?") //disable Delete if
 * statusEnable (hidden) value not equal to enable // if (
 * document.frm_usercreation.statusEnable.value != 'enable') // { // return
 * true; // }
 * 
 * 
 * 
 * 
 * if (answer !="0") { // when the mandatory fields are blank
 * 
 * if(window.frm_usercreation.txt_user_name.value=="") { infoArray[index]=new
 * Array(2); infoArray[index][0]="[SEC_003]&nbsp;&nbsp;";
 * infoArray[index][1]=SEC_003; index++; } // infoArray[index]="infoArray"; if
 * (index>0){ var message=""; for(msg_index=0; msg_index<infoArray.length;
 * msg_index++){ message+=infoArray[msg_index][1]+"\n"; } alert(message); }
 * else{ document.frm_usercreation.flag.value='delete';
 * document.frm_usercreation.action='UserCreationServlet';
 * document.frm_usercreation.submit(); } } }
 * 
 */
/* For Clearing the Textboxes */
function clearMode() {
	var checkShowAll = document.frm_usercreation.chk_showall.checked;
	document.frm_usercreation.reset();
	if (checkShowAll == false) {
		document.frm_usercreation.chk_showall.checked = false;
	} else {
		document.frm_usercreation.chk_showall.checked = true;
	}

	document.frm_usercreation.flag.value = 'insert';
	document.frm_usercreation.chk_active.disabled = true;
	document.frm_usercreation.chk_inactive.disabled = true;
	document.frm_usercreation.img_modify.src = 'images/modify_disable.png';
	document.frm_usercreation.img_delete.src = 'images/delete_disable.png';
	document.frm_usercreation.img_submit.src = 'images/submit.png';
}

/* to Disable the txt_user_name and img_submit */
function makeDisable(s_module, s_username) {
	document.frm_usercreation.statusEnable.value = 'enable';
	document.frm_usercreation.chk_active.disabled = false;
	document.frm_usercreation.chk_inactive.disabled = false;

	document.frm_usercreation.modify.disabled = false;
	document.frm_usercreation.modify.className = 'clickable buttonstyle';
	document.frm_usercreation.insert.disabled = true;
	document.frm_usercreation.insert.className = 'button';
	// document.frm_usercreation.img_modify.src='images/modify.png';
	// document.frm_usercreation.img_modify.className='clickable';
	// document.frm_usercreation.img_delete.src='images/delete.png';
	// document.frm_usercreation.img_delete.className='clickable';
	// document.frm_usercreation.img_submit.src='images/submit_disable.png';
	// document.frm_usercreation.img_submit.className ='';
	document.frm_usercreation.flag.value = 'update';
	document.frm_usercreation.previous_module.value = s_module;
	document.frm_usercreation.previous_username.value = s_username;
}

/*
 * function reloadMode(){ document.frm_usercreation.flag.value='refresh';
 * document.frm_usercreation.action='UserCreationServlet';
 * document.frm_usercreation.submit(); }
 */

/* Allow to enter only numbers & Length */
function validateUser(e) {
	var characterCode;
	if (e && e.which) {
		e = e;
		characterCode = e.which;
	} else {
		e = event
		characterCode = e.keyCode
	}

	/* Allow only uppercase & nummbers */
	if ((characterCode > 47 && characterCode < 58)
			|| (characterCode > 64 && characterCode < 91)) {
		return true;
	} else {
		return false;
	}
	return true;
}

function validatePassword(e) {
	var characterCode;
	if (e && e.which) {
		e = e;
		characterCode = e.which;
	} else {
		e = event
		characterCode = e.keyCode
	}

	/* Allow only uppercase & nummbers */
	if ((characterCode > 47 && characterCode < 58)
			|| (characterCode > 64 && characterCode < 91)) {
		return true;
	} else {
		return false;
	}
	return true;
}

function validateModule() {
}

/*
 * To Show All or Show Only Active Records - when the Checkbox is checked &
 * unchecked
 */
function showAllActive() {
	if (document.frm_usercreation.chk_showall.checked == true) {
		document.frm_usercreation.action = 'shiftall.do?status=all';
		document.frm_usercreation.submit();
	} else {

	}
}

function shiftIDcreation() {

	var shift_name = document.frm_usercreation.ai_shift_name.value;
	var randno = Math.round(50 * Math.random());
	document.frm_usercreation.ai_shift_id.value = shift_name.substring(0, 4)
			+ randno;

}

/** Validation of Data */

function validateData(e) {
	var characterCode;
	if (e && e.which) {
		e = e;
		characterCode = e.which;
	} else {
		e = event
		characterCode = e.keyCode
	}

	if ((characterCode == 34 || characterCode == 39)
			|| (characterCode > 96 && characterCode < 123)) {
		// alert('Must be less than 20 characters');
		return false;
	}
	return true;
}
