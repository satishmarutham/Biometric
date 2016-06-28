$(document)
		.ready(
				function() {
					$(".error-box").show();
					$("#resetId")
							.click(
									function() {
										
										
									var username=$("#usernameId").val();
									var email=$("#emailId").val();
									var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

									if (username == '') {

										$('.error-box').css({
											'visibility' : 'visible'
										});
										$("#errordiv").text(
												"Enter Username");

										return false;
									}
									if (email == '') {

										$('.error-box').css({
											'visibility' : 'visible'
										});
										$("#errordiv").text(
												"Enter Email");

										return false;
									}
									if (!emailCheck.test(email)){

										$('.error-box').css({
											'visibility' : 'visible'
										});
										$("#errordiv").text(
												"Enter ValidEmail");
									

										return false;
									}
									
									$("#usernameId").val('');
								$("#emailId").val('');
								var dataList={"username":username,"email":email}
									$.ajax({
										type : 'POST',
										url : "managerForgetpassword.do?method=resetManagerPassword",
										data:dataList,
										success:function(data){
											var result = $.parseJSON(data);
											
										if(result.message==="errorMessage"){
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$(".error-box").text("Please Check Mail");
										}
										else
											{
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$(".error-box").text("Password was Sent to Mail");
											$(".error-box").css({'color':'green'});
											
											}
										
									
										
										}
									});
								return true;
									});
					
					
					
				});
