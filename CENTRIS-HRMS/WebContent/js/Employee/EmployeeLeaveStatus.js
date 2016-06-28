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
					$("#errordivUpdate").hide();
					$.ajax({
						type : "POST",
						url : "projectManagerMapping.do?parameter=getManager",
						success : function(response) {
							
							var result = $.parseJSON(response);

							var leaverequestTo = $("#requestedbyNotApproved");

							for ( var j = 0; j < result.managerList.length; j++) {

								$(leaverequestTo).append(
										'<option value="' + result.managerList[j].managerId + '">'
												+ result.managerList[j].managerName + '</option>');
							}
						}
					});	
					
					$("#downloadId").click(function(){
						window.location.href = "employeeLeaveStatus.do?method=employeeLeaveStatusDownload&filepath="
							+ $('#fileuploadNotApproved').attr('name');
					});
					
					
					
				setTimeout("removeMessage()", 5000);

				$('#getLeaveRequestDetails')
				.click(
						function() {
							window.location.href = 'leaverequest.do?parameter=leaveRequestHome';
						});
				
					$('#validateTable').hide();
					/* $('#success').hide(); */

					$("#LeaveConfirm")
							.dialog(
									{
										resizable : false,
										autoOpen : false,
										height : 370,
										width : 700,
										modal : true,
                                    buttons :{
										"Cancel":function(){
												$("#LeaveConfirm").dialog("close");
																				
											}
									
										}
											
									});
			

					$('#startdateNotApproved').datepicker({
						
						changeMonth : true,
						changeYear : true,
						dateFormat : "dd-mm-yy",

					});
					

$("#LeaveConfirmNotApproved")
.dialog(
		{
			resizable : false,
			autoOpen : false,
			height : 370,
			width : 800,
			modal : true,
        buttons :{
        	
        	"Update":function(){
				var sNo=$("#snoId").val();
			
				var noOfLeaves=$("#noofleavesNotApproved").val();
				var requestedTo=$("#requestedbyNotApproved").val();
				var startDate=$("#startdateNotApproved").val();
				var endDate=$("#enddateNotApproved").val();
				var reasonForLeave=$("#reasonforleavesNotApproved").val();
			var leaveFile=$("#fileuploadNotApproved").val();
			
			var  filePath = leaveFile.replace(/C:\\fakepath\\/i, '');
			var bValid=	validations();
			if(bValid){
				
				/*var leaveRequestUpdateDetails={"noOfLeaves":noOfLeaves,
						"requestedTo":requestedTo,
						"startDate":startDate,
						"endDate":endDate,
						"reasonForLeave":reasonForLeave,
						"sno":sNo,
						"leaveFile":filePath,*/
				document.getElementById("modalform").action = "leaverequest.do?parameter=updateLeaveRequest&Sno="+sNo;
				document.getElementById("modalform").submit();
				
				$('ul li ul').show();
				};
        	
	/*		$.ajax({

					type : "POST",
					url : "leaverequest.do?parameter=updateLeaveRequest",
					
				
					
					   data: $('#modalform').serialize(),
					 beforeSend: function() {
					       
						  $('#loading').show();
						  
					    },
					success : function(response) {
					
						var result = $.parseJSON(response);
						$('#loading').hide();
					var statusMessage=result.statusMessage;
					
						window.location.href="employeeMenu.do?parameter=employeeLeaveStatus&successMesage="+statusMessage;
						$('#LeaveConfirmNotApproved').dialog("close");
						
						 $('ul li ul').show();
				
					}
				});*/
				
			},
		
		
		"cancel":function(){
			$("#LeaveConfirmNotApproved").dialog("close");
		}
											
				},
		
		
		
		
		/*	}*/
		
				
		});



});



function openDailog(val) {



var dataList={"Sno":val};
	$.ajax({

		type : "POST",
		url : "employeeLeaveStatus.do?method=employeeLeaveStatusBySno",
		data : dataList,
		success : function(data) {
			var result = $.parseJSON(data);
	
			var approvedStatus=result.leaveDetailsBySno[0].approvedStatus;

			if(approvedStatus=="Approved"){
				
			$("#requestedby").val(result.leaveDetailsBySno[0].requestedBy);
			$("#startdate").val(result.leaveDetailsBySno[0].startDate);
			$("#enddate").val(result.leaveDetailsBySno[0].endDate);
			$(".noofleavesId").val(result.leaveDetailsBySno[0].noofLeaves);
			$("#requesteddate").val(result.leaveDetailsBySno[0].requestedDate);
			$("#reasonforleave").val(result.leaveDetailsBySno[0].reasonforLeave);
			
			$("#reasonforleave").val(result.leaveDetailsBySno[0].reasonforLeave);
			$("#reasonforleave").val(result.leaveDetailsBySno[0].reasonforLeave);
			$("#reasonforleave").val(result.leaveDetailsBySno[0].reasonforLeave);
			$("#reasonforleave").val(result.leaveDetailsBySno[0].reasonforLeave);
			
			 $('#totalleavesapproved').val(result.leaveDetailsBySno[0].totalleavesApproved);
	$('#approvedstartdate').val(result.leaveDetailsBySno[0].approvedStartDate);
	$('#approvedenddate').val(result.leaveDetailsBySno[0].approvedEndDate);
$('#comments').val(result.leaveDetailsBySno[0].comments);
$("#leavetype option[value=" + result.leaveDetailsBySno[0].leavetype+ "]").attr('selected', 'true');



$("#LeaveConfirm").dialog("open");
$("span.ui-button-text").removeClass("ui-button-text").addClass(
		"submitbutton");
$("a.ui-dialog-titlebar-close").remove();
$("span.ui-icon").remove();
$('ul li ul').hide();
$(".validateTips")
.text("");
			}
else
	{


	$("#requestedbyNotApproved option[value=" + result.leaveDetailsBySno[0].managerCode+ "]").attr('selected', 'true');
$("#snoId").val(result.leaveDetailsBySno[0].sno);
	$("#startdateNotApproved").val(result.leaveDetailsBySno[0].startDate);
	$("#enddateNotApproved").val(result.leaveDetailsBySno[0].endDate);
	$("#noofleavesNotApproved").val(result.leaveDetailsBySno[0].noofLeaves);
	$("#requesteddateNotApproved").val(result.leaveDetailsBySno[0].requestedDate);
	$("#reasonforleaveNotApproved").val(result.leaveDetailsBySno[0].reasonforLeave);
	
	$("#reasonforleavesNotApproved").val(result.leaveDetailsBySno[0].reasonforLeave);
	$("#reasonforleavesNotApproved").val(result.leaveDetailsBySno[0].reasonforLeave);
	$("#reasonforleavesNotApproved").val(result.leaveDetailsBySno[0].reasonforLeave);
	$("#reasonforleavesNotApproved").val(result.leaveDetailsBySno[0].reasonforLeave);
	
	 $('#totalleavesapprovedNotApproved').val(result.leaveDetailsBySno[0].totalleavesApproved);
$('#approvedstartdateNotApproved').val(result.leaveDetailsBySno[0].approvedStartDate);
$('#approvedenddateNotApproved').val(result.leaveDetailsBySno[0].approvedEndDate);
$('#commentsNotApproved').val(result.leaveDetailsBySno[0].comments);
prevfilepath = result.leaveDetailsBySno[0].filepaath;
$("#fileuploadNotApproved").attr('name',result.leaveDetailsBySno[0].filepaath);

$("#leavetype option[value=" + result.leaveDetailsBySno[0].leavetype+ "]").attr('selected', 'true');



if (prevfilepath ==undefined) {

$('#downloadId').hide();
}
else
{


$('#downloadId').show();

}


	$("#LeaveConfirmNotApproved").dialog("open");
	$("span.ui-button-text").removeClass("ui-button-text").addClass(
			"submitbutton");
	$("a.ui-dialog-titlebar-close").remove();
	$("span.ui-icon").remove();
	$('ul li ul').hide();
	$(".validateTips")
	.text("");	
}

		}
	});
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

		window.location ="employeeLeaveStatus.do?method=download&filepath="+filepath+"&sno="+Sno;

			
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
function setEndDate() {

	var totalNoofleave = $('#noofleavesNotApproved').val().trim();
	var regexpforInteger = /^[0-9]+([\.][0-9]+)?$/g;

	if ((totalNoofleave != "") && (regexpforInteger.test(totalNoofleave))) {
		var startDate = $('#startdateNotApproved').val();

		startDate = startDate.split("-");

		var d = new Date(startDate[2], startDate[1] - 1, startDate[0]);

		var noofdays = Math.round($('#noofleavesNotApproved').val());
		d.setDate(d.getDate() + (noofdays - 1));

		var str = (d.getMonth() + 1).toString();
		var pad = "00";

		pad.substring(0, pad.length - str.length) + str;

		var ee = d.getDate() + "-" + pad.substring(0, pad.length - str.length)
				+ str + "-" + d.getFullYear();
		$('#enddateNotApproved').val(ee);
	} else {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Total Days Of Leave Field should not be empty");

		return false;
	}
}
function validations() {

	var leaverequest = $('#requestedbyNotApproved').val();
	var noofleave = $('#noofleavesNotApproved').val();
	var resonfoleave = $('#reasonforleavesNotApproved').val();
	var startdate = $('#startdateNotApproved').val();
	var uploadedFile = $('#fileuploadNotApproved').val().trim();

	var regexpforInteger = /^[0-9]+([\.][0-9]+)?$/g;

	if (leaverequest == "") {
		$("#errordivUpdate").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		
		$("#errordivUpdate").text("Select Leave Requested To");

		return false;

	} else if (noofleave == null || noofleave == "") {
		$("#errordivUpdate").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordivUpdate").text("Enter Total Days of Leaves");

		return false;

	} else if (!(regexpforInteger.test(noofleave))) {
		$("#errordivUpdate").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordivUpdate")
				.text(
						"Total Days Of Leave Should be Double or Integer");

		return false;
	} else if (startdate == null || startdate == "") {
		$("#errordivUpdate").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordivUpdate").text("Select From Date");

		return false;
	} else if (duplicateLeave(startdate,$('#enddateNotApproved').val(), leaverequest)) {
		$("#errordivUpdate").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordivUpdate").text("Leave already applied in between the dates");

		return false;

	} else if (resonfoleave == null || resonfoleave == "") {
		$("#errordivUpdate").show();

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordivUpdate").text("Reason for Leave Should not be empty");

		return false;
	}
	/*else if (uploadedFile != "") {
		$("#errordivUpdate").show();

		var result = isWordFile(uploadedFile);

		if (!result) {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordivUpdate").text("Upload only Word document Files");
			return false;
		}
		
	}*/else if (uploadedFile != "") {
		
		$("#errordivUpdate").show();
		var result = isWordFile(uploadedFile);

		
	
		if (!result) {
			
		
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordivUpdate").text("Upload only Word document files");
			return false;
		}else{
			
			return true;
		}
	}
	else
		{
		return true;
		}
	
	
	/* else if (uploadedFile == null || uploadedFile == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Upload File");

		return false;
	} else if (uploadedFile != "") {
		var result = isWordFile(uploadedFile);

		if (!result) {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Upload only Word document files");
			return false;
		}
	}*/ /*else {
		if (noofleaves == 0) {
			
			  $('#requestId').hide();
			  
			$('.error-box').css({
				'visibility' : 'hidden'
			});

			return true;
		} else {

			$("#validateTable").show();
			$(".validateTips").text("Invalid No of Leaves");
			$("#leave").text("Invalid No of Leaves");

			return false;
		}
*/
		

	
/*else
	{
	$("#errordivUpdate").hide();

	retrun true;
	}
*/
}

function duplicateLeave(startdate,enddate,leaverequest) {
	var sNo=$("#snoId").val();
	var leavedetails = {
		"startdate" : startdate,
		"enddate" : enddate,
		"leaverequestto" :leaverequest,
		"sno":sNo
	
	};
	var status = false;

	$.ajax({
		type : "POST",
		url : "leaverequest.do?parameter=checkUpdateDuplicateLeave",
		data : leavedetails,
		async : false,
		success : function(data) {

			var result = $.parseJSON(data);

			status = result.statuscheck;

		}
	});

	return status;

}

function download() {
	
}


function isWordFile(file) {
	
	var image = /\.(doc|docx|docb)$/i;
	
	if (image.test(file)){
		
		return true;
	}
	else{
		return false;
		}
}


