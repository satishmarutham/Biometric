var currentPass = false;
$(document)
		.ready(
				function() {
					$(".error-box").show();
					$("#submit")
							.click(
									function() {

										var oldpasswordVal = $("#employeeoldId").val();
										var passwordVal = $("#employeenewId").val();
				var checkVal = $("#employeeconfirmId").val();
				
				var email = $("#emailId").val();
			
				
				
				
if (email == '') {

					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(
							"Enter Email");

					return false;
				}
				/*if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.text(emailCheck)){
				
					$('.error-box').css({'visibility' : 'visible'});
					$("#errordiv").text("Enter Valid Email");

					return false;
					
				}*/
			
				

										if (oldpasswordVal == '') {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Enter Current Password");

											return false;
										}
										if (currentPass) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv")
													.text(
															"Enter valid Current Password");

											return false;
										}
										if (passwordVal == '') {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Enter New Password");
											return false;

										}

										if (passwordVal.trim().length > 20
												|| passwordVal.trim().length < 3) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv")
													.text(
															"Length of New Password must be between 3 and 20 digits");

											return false;
										}

										if (checkVal == '') {
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Enter Confirm Password");
											return false;
										}
										if (checkVal.trim().length > 20
												|| checkVal.trim().length < 3) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv")
													.text(
															"Length of Confirm Password must be between 3 and 20 digits");

											return false;
										}
										if (passwordVal != checkVal) {
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv")
													.text(
															"New Password and Confirm Password Combination is Wrong");
											return false;
										}
										
										if (passwordVal == oldpasswordVal) {
											$('.error-box').css({'visibility' : 'visible'});
											$("#errordiv").text("Old Password and New Password should not be Same");
											return false;
										}
								
					
					var dataList={"oldpasswordVal":oldpasswordVal,"passwordVal":passwordVal,"checkVal":checkVal,"email":email
							
					}
			
					
					$.ajax({
						type : 'POST',
						url : "ChangePassword.do?parameter=updateEmployeePassword",
						data:dataList,
						success:function(response){
							var result= $.parseJSON(response);
						
							if(result.updatePassword=="successMessage"){
								var answer = confirm("Password Changed SuccessFully Please Login Again");
								window.location.href="GetDetails.do?parameter=logout";
								
							}
							else{
								$('.error-box').css({
									'visibility' : 'visible'
								});
								$("#errordiv").text("Incorrect Email or Current Password");

								var oldpasswordVal = $("#employeeoldId")
										.val('');
								var passwordVal = $("#employeenewId").val('');
		var checkVal = $("#employeeconfirmId").val('');
		
		var email = $("#emailId").val('');
		
		
										
							}
						}
					
					});
					
					return true;
									});
			
					
					});

function currentEmployeePasswordCkeck() {
	var oldpasswordval = $('#employeeoldId').val();

	var data = {
		"oldpasswordval" : oldpasswordval
	};
	$.ajax({

		type : "POST",
		url : "ChangePassword.do?parameter=getEmployeeCurrentPassword",
		data : data,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
			if (result.status) {

				currentPass = true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Enter valid Current Password");
			} else {
				currentPass = false;
				$('.error-box').css({
					'visibility' : 'hidden'
				});
			}
		}
	});
}
function employeeDOB() {
	var dob = $('.dateofBirthId').val();

	var data = {
		"dob" : dob
	};
	
	$.ajax({

		type : "POST",
		url : "ChangePassword.do?parameter=getEmployeeDOB",
		data : data,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
			if (result.status) {

				currentPass = true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Enter Valid DOB");
			} else {
				currentPass = false;
				$('.error-box').css({
					'visibility' : 'hidden'
				});
			}
		}
	});
}

function clearContent(){
	var oldpasswordVal = $("#employeeoldId")
	.val('');
var passwordVal = $("#employeenewId").val('');
var checkVal = $("#employeeconfirmId").val('');

var email = $("#emailId").val('');

}


