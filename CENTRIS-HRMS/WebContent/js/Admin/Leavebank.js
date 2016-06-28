$(document).ready(function() {

});
function valid() {

	var int_regex = /^\d+$/;

	var sno = $('#sno').val();
	var accyear = $('#accyear').val();

	var totalleaves = $('#totalleaves').val();
	var permonth = $('#permonth').val();
	
	var sl = $('#sl').val();
	var pl = $('#pl').val();
	var cl = $('#cl').val();
	
	if (accyear == 0) {

		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select Accademic Year");
		return false;
	
	}else if(sl==""|| sl == null){
		
		$("#errordiv").text("Enter SL");
		$('.error-box').css({'visibility' : 'visible'});
	
		return false;
	
	}else if (!(int_regex.test(sl.trim())) ) {
	
		$("#errordiv").text("SL should be Numeric");
		$('.error-box').css({'visibility' : 'visible'});
		
		return false;

	}else if(pl ==""|| pl == null){
	
		$("#errordiv").text("Enter PL");
		$('.error-box').css({'visibility' : 'visible'});
	
		return false;

	}else if (!(int_regex.test(pl.trim())) )  {
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("PL should be Numeric");
		return false;

	}else if(cl==""|| null){
	
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter CL");
		return false;
	
	}else if (!(int_regex.test(cl.trim())) ) {
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("CL should be Numeric");
		return false;

	}else if(totalleaves==""|| null){
	
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Total Leaves");
		return false;
	
	}else if(permonth == "" || null) {
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Leaves Allowed Per Month");
		return false;

	}else {
		
		return true;
	}
}

function AddLeave() {
	var accyear = $('#accyear').val();

	var sno = $('#sno').val();
	var count = 0;
	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;

	});
	if (count > 0) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("please uncheck selected items");
	} else {
		if (sno == 0) {
			if (valid() == true) {

				var leave = {
					"year" : accyear

				};
				callAjaxLeave("GetLeaves.do?parameter=validAddLeave", leave);

				if (result.validate == false) {
					$("#leave").attr('action',
							'GetLeaves.do?parameter=addLeave');
					$('#addLeave').val('addLeave');
					$("#leave").submit();
				} else {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text("Year exists already");
				}
			}
		} else {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("You cannot add update instead");
		}
	}
}

function editLeave() {

	var sno = null;
	var count = 0;
	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		sno = this.value;

	});

	if (count == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select atleast one Record");

		
		
	} 
	else if(count>1){
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select one Record");

	}
	
	
	else {
		var serialno = {
			"sno" : sno
		};

		callAjaxLeave("GetLeaves.do?parameter=editLeave", serialno);

		$("#accyear").val(result.editleave[0].accyear);
		$("#totalleaves").val(result.editleave[0].total_leaves);
		$("#permonth").val(result.editleave[0].allowed_per_month);
		$("#sl").val(result.editleave[0].sl);
		$("#pl").val(result.editleave[0].pl);
		$("#cl").val(result.editleave[0].cl);
		
		$("#sno").val(result.editleave[0].sno);
		
		
		
	}
}

function updateLeave() {

	var sno = $('#sno').val();

	if (sno == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("You cannot update add instead");
	}
	if (valid() == true) {
		var accyear = $('#accyear').val();
		var leave = {
			"year" : accyear,
			"sno" : sno
		};
		callAjaxLeave("GetLeaves.do?parameter=validUpdateLeave", leave);
		// alert("JSON..." + result.validate);

		if (result.validate == false) {
			var x = confirm("Are you sure to Update");
			if (x) {
				$("#leave")
						.attr('action', 'GetLeaves.do?parameter=updateLeave');
				$('#addLeave').val('updateLeave');
				$("#leave").submit();
			}
		} else {
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("AccademicYear already Exists");

		}
	}
}

function deleteLeave() {

	var snoList = new Array();
	var selectArray = document.getElementsByName('selectBox');
	var x = confirm("Are you sure to Delete");
	for ( var i = 0; i < selectArray.length; i++) {
		if (selectArray[i].checked == true) {

			snoList.push(selectArray[i].value);
		}
	}

	if (snoList.length < 1) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("please select atleast one record");

	} else if(x) {
		var leavelist = {
			"year" : snoList

		};
		callAjaxLeave("GetLeaves.do?parameter=deleteLeave", leavelist);

		if (result.deletestatus == true) {
			statusdelete = "Leave data deleted successfully";
		} else {
			statusdelete = "Deletion failed";
		}

	}

	window.location.href = "GetLeaves.do?parameter=getLeave&deletekey="
			+ statusdelete;

}
function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var selectArray = document.getElementsByName('selectBox');

	if (selectall[0].checked == true) {
		for ( var i = 0; i < selectArray.length; i++) {
			selectArray[i].checked = true;
		}
	} else {
		for ( var i = 0; i < selectArray.length; i++) {
			selectArray[i].checked = false;
		}
	}
}
var result;
function callAjaxLeave(urlWithMethod, dataToBeSend) {
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

function calculate(total) {

	var permonth = Math.round(total / 12);
	$("#permonth").val(permonth);

}


function calculateTotalleaves(){
	
	var sl = $('#sl').val();
	var pl = $('#pl').val();
	var cl = $('#cl').val();
	
	var int_regex = /^\d+$/;
	
	if(sl!="" && int_regex.test(sl.trim())){
		if(pl!="" && int_regex.test(pl.trim())){
			if(cl!="" && int_regex.test(cl.trim())){
				
				$('#totalleaves').val( parseInt(sl) + parseInt(pl) + parseInt(cl) );
				
				var total = $('#totalleaves').val();
				if (total <= 5 && total > 0) {
					var permonth = 1;
					$("#permonth").val(permonth);
				} else if (total == 0) {
					var permonth = 0;
					$("#permonth").val(permonth);
				} else {
					calculate(total);
				}
		
			
			}
			
		}
		
	}
	

}

