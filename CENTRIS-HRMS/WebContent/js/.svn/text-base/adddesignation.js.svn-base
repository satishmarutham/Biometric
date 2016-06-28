var desname_validate = 0;
var desname_validate_update = 0;
var edit_method = false;
function validateDesName() {

	var desname = $('#designationname').val();
	var desid = $('#designationid').val();

	var desname_object = {
		"desname" : desname,
		"desid" : desid
	};

	$.ajax({

		type : "GET",
		url : "adddesignation.do?parameter=validateDesignationName",
		data : desname_object,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			if (result) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Designation Already Exist");

				desname_validate = 1;

			} else {
				desname_validate = 0;
			}

		}

	});

	return desname_validate;

}

function validateDesNameUpdate() {

	var desname = $('#designationname').val();
	var desid = $('#designationid').val();

	var desname_object = {
		"desname" : desname,
		"desid" : desid
	};

	$.ajax({

		type : "GET",
		url : "adddesignation.do?parameter=validateDesNameUpdate",
		data : desname_object,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			if (result) {

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Designation Already Exist");

				desname_validate_update = 1;

			} else {
				desname_validate_update = 0;
			}

		}

	});

	return desname_validate_update;
}

function validations() {

	var desgname = $("#designationname").val();
	var desgdes = $("#designationdes").val();
	var desid = $("#designationid").val();
	var regexpforalphabets = /^[a-zA-Z ]+$/i;

	if (desid != "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text(
				"Designation Already Exist if you want you can update");

		return false;

	} else

	if (desgname == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter Designation Name");

		return false;

	} else if (!(regexpforalphabets.test(desgname.trim()))) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Designation Name field only allow Alphabet : a-z");

		return false;

	}

	else if (desgdes == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter Designation Descreption");

		return false;

	} else {

		if (validateDesName() == 1) {

			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Designation Already Exist");

			return false;

		} else {

			return true;

		}

	}

}

function validationsUpdate() {

	var desgname = $("#designationname").val();
	var desgdes = $("#designationdes").val();
	var desid = $("#designationid").val();

	if (desid == "" || desid == null) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Exist Designation ");

		return false;

	} else

	if (desgname == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter Designation Name");

		return false;

	} else if (desgdes == "") {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter Designation Description");

		return false;

	} else {

		if (validateDesNameUpdate() == 1) {

			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Designation Already Exist");

			return false;

		} else {

			return true;

		}

	}

}

function editDesignation() {

	edit_method = true;

	var count = 0;
	var des_id = null;

	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		des_id = this.value;

	});

	if (count > 1 || count == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select any one Designation ");

	} else {

		/* document.getElementById("add").value="Update"; */

		var des = {
			"des_name" : des_id
		};

		$.ajax({
			type : "GET",
			url : "adddesignation.do?parameter=editDesignation",
			data : des,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);

				$("#designationname").val(result.designationlist[0].desgname);
				$("#designationdes").val(result.designationlist[0].desgdes);
				$("#designationid").val(result.designationlist[0].desgid);

			}
		});

	}
}

function cleardata() {

	edit_method = false;

	/* document.getElementById("add").value=" Add "; */
	document.getElementById("designationid").value = "";
}

function deleteDesignation() {

	/*
	 * var count=0; var des_name=null;
	 * 
	 * $('input[name="selectBox"]:checked').each(function() { count = count+1;
	 * des_name=des_name+",,"+this.value;
	 * 
	 * 
	 * });
	 * 
	 * alert(count);
	 * 
	 * if(count==0 ){
	 * 
	 * $('.error-box').css({'visibility': 'visible'});
	 * $("#errordiv").text("Please Select Any one designation ");
	 * 
	 *  }
	 */
	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	var updaterowsArray = new Array();

	for ( var i = 0; i < checkboxArray.length; i++) {
		if (checkboxArray[i].checked == true) {
			updaterowsArray.push(checkboxArray[i].value);
		}
	}
	if (updaterowsArray.length <= 0) {
		$("#errordiv").show();
		$("#errordiv").text("Please Select any Designation to delete");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		var x = confirm("Are you sure you want to delete this Designation");
		if (x) {

			var datalist = 'des_name=' + updaterowsArray;

			/* / var veh={"des_name":des_name}; */

			$
					.ajax({
						type : "GET",
						url : "adddesignation.do?parameter=deleteDesignation",
						data : datalist,
						async : false,

						success : function(data) {
							var result = $.parseJSON(data);

							window.location = "adddesignation.do?parameter=addDesignation&status="
									+ result.success;

						}
					});

		}
	}
}

function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	if (selectall[0].checked == true) {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = true;

		}
	} else {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = false;
		}
	}
}