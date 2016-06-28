/**
 * 
 */
var filepath;
var Sno;
var check = 0;
function removeMessage() {
	$.ajax({
		type : "GET",
		url : "managerLeaveApproved.do?parameter=removeMessage",
		async : false,
		success : function(data) {
			$('#successmessage').empty();
		}
	});
}

$(document)
		.ready(
				function() {
				setTimeout("removeMessage()", 5000);

					$('#validateTable').hide();
					/* $('#success').hide(); */

					$("#LeaveConfirm")
							.dialog(
									{
										resizable : false,
										autoOpen : false,
										height : 400,
										width : 800,
										modal : true,

										buttons : {
											"Confirm" : function() {

												// approvedstartdate();
												var approved_leaves = $(
														'#totalleavesapproved')
														.val();

												var noofdays = Math
														.round(approved_leaves);

												if (approved_leaves == "") {
													$("#validateTable").show();
													$(".validateTips")
															.text(
																	"Total Leaves Approved Field should not be Empty");
													return false;
												}
												var total_leaves_approved = $(
														'#totalleavesapproved')
														.val();
												var ApprovedStartdate = $(
														'#approvedstartdate')
														.val();
												var ApprovedEndDate = $(
														'#approvedenddate')
														.val();
												var comments = $('#comments')
														.val();
												
											
														
												var d3 = Date
														.parse(dateConverter(ApprovedStartdate));
												var d4 = Date
														.parse(dateConverter(ApprovedEndDate));
												var d5 = d4 - d3;
												var days = Math
														.round((d5 / 1000 / 60 / 60 / 24) + 1);

												if (noofdays != days) {
													$("#validateTable").show();
													$(".validateTips")
															.text(
																	"Total Leaves Approved is not match with Start Date and End Date");
													return false;
												}
												

												var approved_data = {
													"sno" : Sno,
													"TotalLeavesApproved" : total_leaves_approved,
													"ApprovedStartdate" : ApprovedStartdate,
													"ApprovedEndDate" : ApprovedEndDate,
													"comments" : comments
												};

												if (check == 1) {
													var x = confirm("Are you sure to Confirm Leave Request");
													if (x) {
														$
																.ajax({

																	type : "GET",
																	url : "managerLeaveApproved.do?method=confirm",
																	data : approved_data,
																	beforeSend:function(){
																	$('#loader').show();
																	$(".submitbutton").hide();
																	},
																	success : function(data) {
																		var result = $.parseJSON(data);
																		$("#LeaveConfirm").dialog("close");
																	  	window.location.href="managerMenu.do?parameter=getLeaveRequestForApproved&status="+result.success;	
																												
																		
																	}
																});

													}

												}

											},
											"Hold" : function() {
												var requestedBy=$('#requestedby').val();
												var startDate=$('#startdate').val();
													var endDate=$('#enddate').val();
													var requestedDate=$('#requesteddate').val();
														var noOfLeaves=$('.noofleavesId').val();
													var reassonLeave=$('#reasonforleave').val();

												var comments = $('#comments')
														.val();
												var reject_data = {
													"sno" : Sno,
													"comments" : comments,
													"requestedBy":requestedBy,
														"startDate":startDate,
															"endDate":endDate,
																"requestedDate":requestedDate,
																	"noOfLeaves":noOfLeaves,
																	"reassonLeave":reassonLeave
													
												};

												var x = confirm("Are you sure to Hold Leave Request");
												if (x) {
													$.ajax({
														type : "POST",
																url : "managerLeaveApproved.do?method=hold",
																data : reject_data,
																beforeSend:function(){
																	$('#loader').show();
																	$(".submitbutton").hide();
																	},
															success : function(data) {

																	var result = $.parseJSON(data);

																	$("#LeaveConfirm").dialog("close");
																  	window.location.href="managerMenu.do?parameter=getLeaveRequestForApproved&status="+result.success;	
																		
																}

															});
												}

											},
											"Reject" : function() {

												var comments = $('#comments')
														.val();
												var reject_data = {
													"sno" : Sno,
													"comments" : comments
												};

												var x = confirm("Are you sure to Reject Leave Request");
												if (x) {
													$
															.ajax({

																type : "POST",
																url : "managerLeaveApproved.do?method=reject",
																data : reject_data,
																async : false,
																beforeSend:function(){
																	$('#loader').show();
																	$(".submitbutton").hide();
																	},
																success : function(data) {

																	var result = $
																			.parseJSON(data);

																	$("#LeaveConfirm").dialog("close");
																  	window.location.href="managerMenu.do?parameter=getLeaveRequestForApproved&status="+result.success;	
																		
																}

															});
												}

											},
											"Cancel" : function() {
												$("#LeaveConfirm").dialog(
														"close");
												$('ul li ul').show();
												
											}
										}

									});
				});

function openDailog(val) {
Sno = val;
var dataList={"Sno":Sno}
	$.ajax({

		type : "POST",
		url : "managerLeaveApproved.do?method=getSingleLeaveDetails",
		data : dataList,
		success : function(data) {
			var result = $.parseJSON(data);
			$("#requestedby").val(result.leaveDetailsBySno[0].requestedBy);
			$("#startdate").val(result.leaveDetailsBySno[0].startDate);
			$("#enddate").val(result.leaveDetailsBySno[0].endDate);
			$(".noofleavesId").val(result.leaveDetailsBySno[0].noofLeaves);
			$("#requesteddate").val(result.leaveDetailsBySno[0].requestedDate);
			$("#reasonforleave").val(result.leaveDetailsBySno[0].reasonforLeave);
			
			filepath = result.leaveDetailsBySno[0].filepaath;
			

if (filepath ==undefined) {

	$('#downloadlable').hide();
	$('#download').hide();
}
else
{

$('#downloadlable').show();
$('#download').show();

}
		}

	});

$("#LeaveConfirm").dialog("open");
	$("span.ui-button-text").removeClass("ui-button-text").addClass(
			"submitbutton");
	$("a.ui-dialog-titlebar-close").remove();
	$("span.ui-icon").remove();
	$('ul li ul').hide();
	$(".validateTips")
	.text("");
}

function approvedstartdate() {

	var approved_leaves = $('#totalleavesapproved').val();
	var start_date = $('#startdate').val();
	var end_date = $('#enddate').val();
	var teacherapliedleaves = $('.noofleavesId').val();

	if (approved_leaves.match(/[0-9]+[.][5]/)
			|| approved_leaves.match(/^[0-9]+$/)) {

		$('#validateTable').hide();
		var noofdays = Math.round(approved_leaves);

		var arr = start_date.split("-");

		var arr1 = end_date.split("-");

		var date2 = new Date(arr[2], arr[1] - 1, arr[0]);
		var date1 = new Date(arr1[2], arr1[1] - 1, arr1[0]);

		var diff = date1 - date2;

		var days = diff / 1000 / 60 / 60 / 24;

		if (noofdays == 1) {
			
			check = 1;
			var approved_startdate = new Date(arr[2] + '-' + arr[1] + '-'
					+ arr[0]);
			var approved_enddate = new Date(approved_startdate
					.setDate(approved_startdate.getDate()
							+ (parseInt(approved_leaves) - 1)));

			var dd = approved_enddate.getDate();

			var mm = approved_enddate.getMonth() + 1;
			var y = approved_enddate.getFullYear();
			var approveddate = dd + '-' + mm + '-' + y;

			$('#LeaveConfirm #approvedstartdate').datepicker({

				minDate : start_date,
				changeMonth : true,
				changeYear : true,
				dateFormat : "dd-mm-yy",
				maxDate : end_date,

			}).datepicker('setDate', start_date);

			$('#LeaveConfirm #approvedenddate').datepicker({

				minDate : start_date,
				changeMonth : true,
				changeYear : true,
				dateFormat : "dd-mm-yy",
				maxDate : end_date,

			}).datepicker('setDate', approveddate);
		}
		
		else if (teacherapliedleaves >= noofdays) {

			$('#validateTable').hide();

			if (approved_leaves != 0 || approved_leaves.equals("")) {

				check = 1;

				$('#validateTable').hide();

				var approved_startdate = new Date(arr[2] + '-' + arr[1] + '-'
						+ arr[0]);
				var approved_enddate = new Date(approved_startdate
						.setDate(approved_startdate.getDate()
								+ (parseInt(approved_leaves) - 1)));

				var dd = approved_enddate.getDate();

				var mm = approved_enddate.getMonth() + 1;
				var y = approved_enddate.getFullYear();
				var approveddate = dd + '-' + mm + '-' + y;

				$('#LeaveConfirm #approvedstartdate').datepicker({

					minDate : start_date,
					changeMonth : true,
					changeYear : true,
					dateFormat : "dd-mm-yy",
					maxDate : end_date,

				}).datepicker('setDate', start_date);

				$('#LeaveConfirm #approvedenddate').datepicker({

					minDate : start_date,
					changeMonth : true,
					changeYear : true,
					dateFormat : "dd-mm-yy",
					maxDate : end_date,

				}).datepicker('setDate', approveddate);

			} else {

				$("#validateTable").show();
				$(".validateTips").text("Approved leaves should not zero");

				$('#LeaveConfirm #approvedenddate').datepicker("destroy");
				$('#LeaveConfirm #approvedstartdate').datepicker("destroy");

			}

		} else {

			$("#validateTable").show();
			$(".validateTips").text(
					"Approved Leave not more than Number of leaves");

			$('#LeaveConfirm #approvedenddate').val("");
			$('#LeaveConfirm #approvedstartdate').val("");

			$('#LeaveConfirm #approvedenddate').datepicker("destroy");
			$('#LeaveConfirm #approvedstartdate').datepicker("destroy");

		}

	} else {

		$("#validateTable").show();
		$(".validateTips").text("Enter Total Leaves Approved");
	}
}

function download() {
	var filepath_obj = {
		"filepath" : filepath,
		"sno" : Sno
	};
	
$.ajax({

		type : "POST",
		url : "managerLeaveApproved.do?method=download",
		data : filepath_obj,
		success : function() {

		window.location ="managerLeaveApproved.do?method=download&filepath="+filepath+"&sno="+Sno;

			
		}
	});
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