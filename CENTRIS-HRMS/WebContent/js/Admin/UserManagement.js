
$(document)
		.ready(
				function() {
					  $(".roleClass").hide();
					
					$("#employee").attr("checked",true);

						$("#emp")
							.autocomplete(
									{
										
										source : function(request, response) {
											
											$("#selectEmployee").val("");
											
											var designation=$("#designation").val();
											
											if(designation==""){
												
												$('.error-box').css({
													'visibility' : 'visible'
												});
												$("#errordiv").text("Select Designation");
												
											}else{

											$
													.ajax({
														url : "usermanagement.do?method=getEmpIdNameBySerachTerm",
														dataType : "json",
														async : false,
														data : {
															featureClass : "P",
															style : "full",
															maxRows : 100,
															name_startsWith : request.term,
															designation : designation
														},
														success : function(data) {
															response($
																	.map(
																			data.response,
																			function(
																					item) {
																				return {
																					label : item.empname+"-"+item.bioid+"-"+item.designation,
																					value : item.empid,
																					
																				}
																				
																			})
																			
																			
															);

														}

													});
										}
									
									},
										minLength : 1,
										select : function(event, ui) {

											var searchTerm = ui.item.value;
											employeedetails = {
												'EmpId' : searchTerm
											};
											var rolesDetails = callAjax(
													"usermanagement.do?method=getUserMangementRoles",
													employeedetails);

											fillEmployeeRoles(rolesDetails.response);
											$("#selectEmployee").val(ui.item.value);
											$("#emp").val(ui.item.label);
											
											return false;
										},
									});
						
					
						$("#designation").change(function(){
							
							$('#emp').val('');
							
							 $('.notdisabled').attr('checked', false);
							
						});

						
						  $("#HR").change(function(){
							 
							  if($(this).is(':checked')){
					        		$("#customrole").attr("checked",false);
					        		$('#customrole').attr('disabled',true);
					        	}else{
					        		
					        		$('#customrole').attr('disabled',false);
					        	}
						  });		
					        
						  $("#CLERK").change(function(){
								 
							  if($(this).is(':checked')){
					        		$("#customrole").attr("checked",false);
					        		$('#customrole').attr('disabled',true);
					        	}else{
					        		
					        		$('#customrole').attr('disabled',false);
					        	}
						  });	

						  $("#ACCOUNTS").change(function(){
								 
							  if($(this).is(':checked')){
					        		$("#customrole").attr("checked",false);
					        		$('#customrole').attr('disabled',true);
					        	}else{
					        		
					        		$('#customrole').attr('disabled',false);
					        	}
						  });	
						  
	        $("#role").change(function(){
		        	
	    	 $("#rolename").val($('#role  option:selected').text().trim());
							
			});			
				
	        
						
				});

function fillEmployeeRoles(roleDetails) {
	
	
	$('input:checkbox').removeAttr('checked');
	
	
	$("#employee").attr("checked",true);
	
	for(var i=0;i<roleDetails.length;i++){
	
	    var  rolecode =	roleDetails[i].substring(3,roleDetails[i].length);
	
	  if( parseInt(rolecode) > parseInt(15) ){
		
		  $("#customrole").attr("checked",true);
		   getAllroles("customrole",rolecode);
			
	 }else{		
		  $(".roleClass").hide();
		 $('#'+roleDetails[i]).val(roleDetails[i]);
		 $("#"+roleDetails[i]).attr("checked",true);
	 }

	}
	
}


function getAllroles(cutomerole,rolecode){
	
		
	if($("#"+cutomerole).is(':checked')){
		$("#HR").attr("checked",false);
		$("#CLERK").attr("checked",false);
		$("#ACCOUNTS").attr("checked",false);
		
		$('#HR').attr('disabled',true);
		$('#CLERK').attr('disabled',true);
		$('#ACCOUNTS').attr('disabled',true);
		
		var rolesDetails = callAjax("usermanagement.do?method=getAllNRoles","");

    	$("#role").html("");
		$("#role").append(
				'<option value="'
						+ ''
						+ '">'
						+ '-------select--------'
						+ '</option>');
		for(var i=0;i<rolesDetails.RolesList.length;i++){
		
			var listrole=rolesDetails.RolesList[i].roleId.substring(3,rolesDetails.RolesList[i].roleId.length);	
		
			if(parseInt(rolecode)==parseInt(listrole)){
				$("#role").append(
						'<option selected="selected"      value="'
								+ rolesDetails.RolesList[i].roleId
								+ '">'
								+ rolesDetails.RolesList[i].roleName
								+ '</option>');
			}else{
			$("#role").append(
					'<option value="'
							+ rolesDetails.RolesList[i].roleId
							+ '">'
							+ rolesDetails.RolesList[i].roleName
							+ '</option>');
			}
		}
		
		
		   $(".roleClass").show();
		
	
	}else{
	
		  $(".roleClass").hide();
		  
			  
		 $('#HR').attr('disabled',false);
		 $('#CLERK').attr('disabled',false); 
		 $('#ACCOUNTS').attr('disabled',false); 
	}
	
	
}





function validate(){
	
	var employee=$("#selectEmployee").val();
	var empName=$("#emp").val();
	
	var status=$("#customrole").is(':checked');
	var role=$('#role').val();
	
	

	if(empName.trim()==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Employee");
		
		return false;
	}else if(employee.trim()==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select valid Employee");
		
		return false;
	}else if( status  && role.trim()=="" ){
		
		 $('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Select Role");
			
			return false;
		
	}else if( status && (hr) ){
		
		 $('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Select Role");
			
			return false;
		
	}else{
		
		$('#loader').show();
		$("#register").hide();
		
		return true;
	}
	
}
