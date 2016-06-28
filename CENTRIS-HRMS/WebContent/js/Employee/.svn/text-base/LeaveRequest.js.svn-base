var noofleaves = 0;
$(document)
		.ready(
				function() {
					
					$.ajax({
						type : "POST",
						url : "projectManagerMapping.do?parameter=getManagerByPrevillages",
						success : function(response) {
							
							var result = $.parseJSON(response);

							var leaverequestTo = $("#leaverequestto");

							for ( var j = 0; j < result.managerList.length; j++) {

								$(leaverequestTo).append(
										'<option value="' + result.managerList[j].managerId + '">'
												+ result.managerList[j].managerName + '</option>');
							}
						}
					});	
					

					$('#getLeaveRequestStatusDetails')
							.click(
									function() {
										window.location.href = 'employeeMenu.do?parameter=employeeLeaveStatus';
									});

					$("#validateTable").hide();
					$('#startdate').datepicker({
					
						changeMonth : true,
						changeYear : true,
						dateFormat : "dd-mm-yy",

					});
					
					
					
					
					
					
				});

function setEndDate() {

	var totalNoofleave = $('#noofleaves').val().trim();
	var regexpforInteger = /^[0-9]+([\.][0-9]+)?$/g;

	if ((totalNoofleave != "") && (regexpforInteger.test(totalNoofleave))) {
		var startDate = $('#startdate').val();

		if(startDate!=""){
		
		startDate = startDate.split("-");

		var d = new Date(startDate[2], startDate[1] - 1, startDate[0]);

		var noofdays = Math.round($('#noofleaves').val());
		d.setDate(d.getDate() + (noofdays - 1));

		var str = (d.getMonth() + 1).toString();
		var pad = "00";

		pad.substring(0, pad.length - str.length) + str;

		var ee = d.getDate() + "-" + pad.substring(0, pad.length - str.length)
				+ str + "-" + d.getFullYear();
		$('#enddate').val(ee);
	}
	
	} else {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Total Days Of Leave Field should not be empty");

		return false;
	}
}

function validateLeave() {

	var noOfLeaves = $('#noofleaves').val();

	if (noOfLeaves.match(/^[0-9]+([\.][0-9]+)?+$/)
			|| noOfLeaves.match(/^[0-9]+$/)) {

		if (noOfLeaves != 0) {

			noofleaves = 0;

			$("#validateTable").hide();
		} else {

			noofleaves = 1;

			$("#leave").text("invalid No of Leaves");
		}
	} else {

		noofleaves = 1;

		$("#leave").text("invalid No of Leaves");

	}

}

function validations() {

	var leaverequest = $('#leaverequestto').val();
	var noofleave = $('#noofleaves').val();
	var resonfoleave = $('#reasonforleaves').val();
	var startdate = $('#startdate').val();
	var uploadedFile = $('#fileupload').val().trim();
	
	var leavetype=$("#leavetype").val();

	var regexpforInteger = /^[0-9]+([\.][0-9]+)?$/g;

	if (leaverequest == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Leave Requested To");

		return false;

	} else if (noofleave == null || noofleave == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Total Days Of Leave Field should not be empty");

		return false;

	} else if (!(regexpforInteger.test(noofleave))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv")
				.text(
						"Total Days Of Leave Field allow Integer : 0-9 or Decimals only ");

		return false;
	} else if (startdate == null || startdate == "") {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Start Date");

		return false;
	} else if (duplicateLeave(startdate, $('#enddate').val(), leaverequest)) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Leave already applied in between the dates");

		return false;

	}else if (leavetype == "" || leavetype == null) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Leave Type Should not be Empty");

		return false;
	} else if (resonfoleave == null || resonfoleave == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Reason for Leave Should not be Empty");

		return false;
	}else if (uploadedFile != "") {
		var result = isWordFile(uploadedFile);

		if (!result) {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Upload only Word document files");
			return false;
		}
	} else {
		if (noofleaves == 0) {
			  $('#loader').show();
			  $('#requestId').hide();
			  
			$('.error-box').css({
				'visibility' : 'hidden'
			});

			return true;
		} else {

			$("#validateTable").show();
			$(".validateTips").text("invalid No of Leaves");
			$("#leave").text("invalid No of Leaves");

			return false;
		}

		return false;

	}

}

function duplicateLeave(startdate, enddate, leaverequest) {

	var leavedetails = {
		"startdate" : startdate,
		"enddate" : enddate,
		"leaverequestto" : leaverequest
	};
	var status = false;

	$.ajax({
		type : "GET",
		url : "leaverequest.do?parameter=validateDuplicateLeave",
		data : leavedetails,
		async : false,
		success : function(data) {

			var result = $.parseJSON(data);

			status = result.statuscheck;

		}
	});

	return status;

}
function isWordFile(file) {
	var image = /\.(doc|docx|docb)$/i;
	if (image.test(file))
		return true;
	else
		return false;
}


