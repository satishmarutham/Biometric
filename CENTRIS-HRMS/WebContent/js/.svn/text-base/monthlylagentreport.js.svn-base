/*function getShiftDept(){
	
	
	
	var locationid=$("#empLocation").val();
	var groupid=$("#group").val();
	
	
	
	var location={"locationid":locationid,"groupid":groupid};
	
	$.ajax({
		
		type: "GET",
		url:"monthlylagendreport.do?method=getShiftAndDept",
		data:location,
		async:false,
		
		success: function(data){
			
			var result=$.parseJSON(data);
			
			$("#shiftid").html("");
			$("#shiftid").append(
							'<option value="'
									+ ""
									+ '">'
									+ "-----select-----"
									+ '</option>');
			if(result.shiftlist.length!=0){
			$("#shiftid").append(
					'<option value="'
							+ "all"
							+ '">'
							+ "-----All-----"
							+ '</option>');
			}
			for(var j=0;j<result.shiftlist.length;j++){
			$("#shiftid").append('<option value="'
					+ result.shiftlist[j].shiftid
					+ '">'
					+ result.shiftlist[j].shiftname
					+ '</option>');
			}
			
			
			$("#department").html("");
			$("#department").append(
							'<option value="'
									+ ""
									+ '">'
									+ "-----select-----"
									+ '</option>');
			if(result.deptlist.length!=0){
			$("#department").append(
					'<option value="'
							+ "all"
							+ '">'
							+ "-----All-----"
							+ '</option>');
			}
			for(var i=0;i<result.deptlist.length;i++){
			$("#department").append('<option value="'
					+ result.deptlist[i].deptid
					+ '">'
					+ result.deptlist[i].deptname
					+ '</option>');
			}
			
		}
		
		
	});
}
 */

$(document).ready(
		function() {
			// After getting data append selected Filters


			if ($('#hgroupId').val() != "") {
				$('#group [value=' + $('#hgroupId').val() + ']').attr(
						'selected', true);
				
				getlocations();
				
				var locArray = $('#hlocationId').val().trim().split(",");
				for ( var p = 0; p < locArray.length; p++) {
					$('#empLocation [value="' + locArray[p] + '"]').attr(
							'selected', true);
				}

				$(
						'#designationId [value="'
								+ $('#hdesignationId').val().trim() + '"]')
						.attr('selected', true);

				$('#month [value=' + $('#hmonth').val() + ']').attr('selected',
						true);
				$('#year [value=' + $('#hyear').val() + ']').attr('selected',
						true);

			}
		});
function getlocations() {

	var group = $('#group').val();

	var groupid = {
		"groupid" : group
	};

	$.ajax({

		type : "GET",
		url : "monthlylagendreport.do?method=getLocationbyGroup",
		data : groupid,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			$("#empLocation").html("");
			$("#empLocation").append(
					'<option value="' + "" + '">' + "-----select-----"
							+ '</option>');
			if (result.locationlist.length != 0) {
				/*
				 * $("#empLocation").append( '<option value="' + "all" + '">' +
				 * "All" + '</option>');
				 */}
			for ( var j = 0; j < result.locationlist.length; j++) {

				$("#empLocation").append(
						'<option value="' + result.locationlist[j].locationid
								+ '">' + result.locationlist[j].locationname
								+ '</option>');
			}
		}

	});

}
function validation() {

	var group = $("#group").val();
	var empLocation = $("#empLocation").val();
	var designationid = $("#designationId").val();
	var year = $("#year").val();
	var month = $("#month").val();

	if (group == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Group");

		return false;
	} else if (empLocation == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Location");

		return false;

	} else if (designationid == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Designation");

		return false;

	} else if (year == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Year");

		return false;

	} else if (month == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Month");

		return false;

	} else {
		return true;
	}
}