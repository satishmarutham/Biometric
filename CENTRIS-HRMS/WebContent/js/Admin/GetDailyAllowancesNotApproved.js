$(document)
		.ready(
				function() {
					
					
					$("#approveRecords tr").each(function(){
						
						
						if($(this).find('.approveAllowance').val()=='Approved'){
							
							$(this).find('.rejectAllowance').hide();
								
								$(this).find('.approveAllowance').css('color','white');
								$(this).find('.approveAllowance').css("background-color","#1267E9");
								
								$(this).find('.approveAllowance').closest('td').prev().prev().find("input").prop('readonly', true);
								$(this).find('.approveAllowance').closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
								
								$(this).find('.approveAllowance').closest('td').prev().find("textarea").prop('readonly', true);
								$(this).find('.approveAllowance').closest('td').prev().find("textarea").css("background-color","#D9D9D9");
						}
						
						if($(this).find('.rejectAllowance').val()=='Rejected'){
							
							$(this).find('.approveAllowance').hide();
								
								$(this).find('.rejectAllowance').css('color','white');
								$(this).find('.rejectAllowance').css("background-color","#1267E9");
								
								$(this).find('.rejectAllowance').closest('td').prev().prev().find("input").prop('readonly', true);
								$(this).find('.rejectAllowance').closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
								
								$(this).find('.rejectAllowance').closest('td').prev().find("textarea").prop('readonly', true);
								$(this).find('.rejectAllowance').closest('td').prev().find("textarea").css("background-color","#D9D9D9");
						}
							
						});
					
					$("#approveAll").hide();
					
					var normalTktPresent=$("#normalTktPresnt").val();
					var conflictTktPresent=$("#conflictTktPresnt").val();
					
					if(normalTktPresent=='Y' || conflictTktPresent=='Y'){
						
						$("#approveAll").show();
					}
					
					var htodate=$("#htodate").val().trim();
					var hfromdate=$("#hfromdate").val().trim();
					if(htodate!=""){
						
						$("#todate").val(htodate);
					}
					
					if(hfromdate!=""){
					
						$("#fromdate").val(hfromdate);
					}
					
					$("#todate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
						onClose : function(selectedDate) {
								
								
						         $("#fromdate").datepicker("option", "minDate", selectedDate);
								
							}

					});
					
					
					$("#fromdate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
						onClose : function(selectedDate) {
							
						         $("#todate").datepicker("option", "maxDate", selectedDate);
								
							}

					});
					
					
					$('.accordHead').click(function() {
						var displaypro = $(this).next('div').css('display');
						if (displaypro == 'none') {
							$(this).next('div').css({
								'display' : 'block'
							});
						} else {
							$(this).next('div').css({
								'display' : 'none'
							});
						}
					
					});
					
					$(".viewDeatails").click(function(){
						
						var datalst={"allowanceCode":(this).id};
						
						$
						.ajax({
							type : 'POST',
							url : "EmpAllowAprroveByDirectorAction.do?method=getsingleAllowances",
							data : datalst,
							success : function(
									response) {

								var result = $.parseJSON(response);
								
								$(".rightindialog").text("");
								
								$("#postedby").text(result.allowanceList[0].postedbyname);
								$("#postedDate").text(result.allowanceList[0].postedTime);
								
								$("#approvedby").text(result.allowanceList[0].approvedbyName);
								$("#approveddate").text(result.allowanceList[0].approvedTime);
								
								$("#projrctmgr").text(result.allowanceList[0].projectmanager);
								$("#clicent").text(result.allowanceList[0].clientname);
								
								$("#teamlead").text(result.allowanceList[0].teaamLead);
								$("#singleteamgh").text(result.allowanceList[0].singleteamgh);
								
								$("#datype").text(result.allowanceList[0].datype);
								$("#noofdays").text(result.allowanceList[0].noofdays);
							
								$("#location").text(result.allowanceList[0].location);
								$("#hdfcaccount").text(result.allowanceList[0].hdfcaccount);
								
								$("#managerremarks").text(result.allowanceList[0].remarks);
								$("#directorremarks").text(result.allowanceList[0].approvecoments);
								
								
								
								
							}

						});

						
						
						$("#view-dialog").dialog("open");
						
					});
					
					
					
					
					$("#view-dialog")
					.dialog(
							{

								autoOpen : false,
								center : 1,
								dialogtop : top,
								height : 380,
								width : 660,
								modal : true,
								resizable : false,
								
								buttons : {

									Cancel : function() {
										$(this).dialog("close");
										 $('ul li ul').show();

									}
								},

							});
					
					
					
				$(".approveAllowance").click(function(){
					
					var approveId=(this).id;
					
			
					if($("#"+approveId).val()=="Approve"){
						
						var allowandcodedetails=((this).id).split("_");
						
						var approvedAmount=  parseFloat($(this).closest('td').prev().prev().find("input").val().trim()).toFixed(2);
						var comments=  $(this).closest('td').prev().find("textarea").val().trim();
						var acualamount= parseFloat($(this).closest('td').prev().prev().prev().text().trim()).toFixed(2);
						
						
						var re_for_double = '^[0-9]*\.[0-9]*$';
						var int_regex=/^\d+$/;
						
						
						if(approvedAmount==""){
							
							$('.error-box').css({
								'visibility' : 'visible'
							});
							$("#errordiv").text("Approved amount should not empty");
							$(this).closest('td').prev().addClass("ui-state-error");
							$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
							
						}else if(!((int_regex.test(approvedAmount)) || (approvedAmount.match(re_for_double)))){
							
							
							$('.error-box').css({
								'visibility' : 'visible'
							});
							$("#errordiv").text("Enter valid approved amount");
							$(this).closest('td').prev().addClass("ui-state-error");
							$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
						
							
						}else if(parseFloat(approvedAmount)>parseFloat(acualamount)){
							
							
							$('.error-box').css({
								'visibility' : 'visible'
							});
							$("#errordiv").text("Accounts Approved amount should not greater than Director Approved Amount");
							$(this).closest('td').prev().addClass("ui-state-error");
							$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
						
							
						}else{
							
						var x = confirm("Are you sure you want approve allowance?");
						if (x) {
					
					
					var allowandcode=allowandcodedetails[1];
					
						
						var allowanceData={"allowandcode":allowandcode,"approvedAmount":approvedAmount,"comments":comments};
						
						$
						.ajax({
							type : 'POST',
							url : "EmpAllowAprroveByDirectorAction.do?method=approveSingleAllowance",
							data : allowanceData,
							 beforeSend: function() {
							       
								  $('#loader').show();
								  
							    },
							success : function(
									response) {

								var result = $.parseJSON(response);
								$('#loader').hide();
								
								
								if(result.status=="true" ){
									
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Allowance approved Successfully,Mail not Sent");
									
									$("#"+approveId).val("Approved");
									$("#"+approveId).css('color','white');
									$("#"+approveId).css("background-color","#1267E9");
									
									$("#"+approveId).closest('td').next().find("input").hide();
									
									$("#"+approveId).closest('td').prev().prev().find("input").prop('readonly', true);
									$("#"+approveId).closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
									
									
									$("#"+approveId).closest('td').prev().find("textarea").prop('readonly', true);
									$("#"+approveId).closest('td').prev().find("textarea").css("background-color","#D9D9D9");
									
									
									
									
								}else if( result.status=="MialSent"){
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									
									$("#successmessge").text("Allowance approved successfully");
									
									$("#"+approveId).val("Approved");
									$("#"+approveId).css('color','white');
									$("#"+approveId).css("background-color","#1267E9");
									
									$("#"+approveId).closest('td').next().find("input").hide();
									
									$("#"+approveId).closest('td').prev().prev().find("input").prop('readonly', true);
									$("#"+approveId).closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
									
									
									$("#"+approveId).closest('td').prev().find("textarea").prop('readonly', true);
									$("#"+approveId).closest('td').prev().find("textarea").css("background-color","#D9D9D9");
									
									
								}else{
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Allowance approval Failed,Try later");
								}
								
								
								
							}

						});
						
						}
						}
					
					}else{
						
						
					}
						
					});
				
				
	$(".rejectAllowance").click(function(){
		
					
					var approveId=(this).id;
					
					if($("#"+approveId).val()=="Reject"){
						
						var allowandcodedetails=((this).id).split("_");
						
						var approvedAmount=  parseFloat($(this).closest('td').prev().prev().prev().find("input").val().trim()).toFixed(2);
						var comments=  $(this).closest('td').prev().prev().find("textarea").val().trim();
						
					
						var x = confirm("Are you sure you want reject allowance?");
						if (x) {
					
					
					var allowandcode=allowandcodedetails[1];
					
						
						var allowanceData={"allowandcode":allowandcode,"approvedAmount":approvedAmount,"comments":comments};
						
						$
						.ajax({
							type : 'POST',
							url : "EmpAllowAprroveByDirectorAction.do?method=rejectSingleAllowance",
							data : allowanceData,
							 beforeSend: function() {
							       
								  $('#loader').show();
								  
							    },
							success : function(
									response) {

								var result = $.parseJSON(response);
								$('#loader').hide();
								
								
								if(result.status=="true" ){
									
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Allowance rejected Successfully,Mail not Sent");
									
									$("#"+approveId).val("Rejected");
									$("#"+approveId).css('color','white');
									$("#"+approveId).css("background-color","#1267E9");
									
									$("#"+approveId).closest('td').prev().find("input").hide();
									
									$("#"+approveId).closest('td').prev().prev().prev().find("input").prop('readonly', true);
									$("#"+approveId).closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
									
									
									$("#"+approveId).closest('td').prev().prev().find("textarea").prop('readonly', true);
									$("#"+approveId).closest('td').prev().find("textarea").css("background-color","#D9D9D9");
									
									
									
									
								}else if( result.status=="MialSent"){
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									
									$("#successmessge").text("Allowance rejected successfully");
									
									$("#"+approveId).val("Rejected");
									$("#"+approveId).css('color','white');
									$("#"+approveId).css("background-color","#1267E9");
									
									$("#"+approveId).closest('td').prev().find("input").hide();
									
									$("#"+approveId).closest('td').prev().prev().prev().find("input").prop('readonly', true);
									$("#"+approveId).closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
									
									
									$("#"+approveId).closest('td').prev().prev().find("textarea").prop('readonly', true);
									$("#"+approveId).closest('td').prev().find("textarea").css("background-color","#D9D9D9");
									
									
								}else{
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Allowance rejection Failed,Try later");
								}
								
								
								
							}

						});
						
						}
					
					}else{
						
						
					}
						
					});
				
				
				$("#approveRecords tr").each(function(){
					
					
				if($(this).find('.approveAllowance').val()!=undefined && $(this).find('.approveAllowance').val()=='Approved'){
						
						$(this).find('.approveAllowance').css('color','white');
						$(this).find('.approveAllowance').css("background-color","#1267E9");
						
				}
					
				});
					
					
				$("#downloadAllowanceDetails").click(function(){
					
					window.location.href = 'EmpAllowAprroveByDirectorAction.do?method=downloadAllowanceDetails&startdate='
										+ $("#todate").val()
										+ ' &enddate='
										+ $("#fromdate").val();
						
					
				});
				
				
				$("#downloadConflictAllowanceDetails").click(function(){
					
					window.location.href = 'EmpAllowAprroveByDirectorAction.do?method=downloadConflictAllowanceDetails&startdate='
										+ $("#todate").val()
										+ ' &enddate='
										+ $("#fromdate").val();
						
					
				});
					
				
	$("#approveAll").click(function(){
		
					
					var allowanceCode=[];
					var accountsComments=[];
					var approvedAmount=[];
					var actualAmount=[];
					
					
					$("#approveRecords tr").each(function(){
						 
						 var approveStatus=$(this).find('.approveAllowance').val();
						 var rejectstatus=$(this).find('.rejectAllowance').val();
						 
						 if(approveStatus!='Approved' && rejectstatus!='Rejected'){
						 
						 
						    var comments=$(this).find('.accountantComments').val();
							  
						    if(comments!=undefined ){
						    	
						    	
						    	if(comments.trim()==""){
						    		
						    		accountsComments.push("null");
						    		
						    	}else{
						    		accountsComments.push(comments.trim());
						    	}
							}
						    
						    
						    
						    var amount=$(this).find('.approveAmount').val();
							  
						    if(amount!=undefined && amount!=""){
						    	
						    	approvedAmount.push(parseFloat(amount.trim()).toFixed(2));
						    	
							}
						    
						    
						    var allowanceCodeId=$(this).find('.hallowancrId').val();
						    
						    if(allowanceCodeId!=undefined && allowanceCodeId!=""){
						    	
						    	
						    	allowanceCode.push(allowanceCodeId.trim());
						    	
							}
						    
							  var actualAmountVal=$(this).find('.directorApprovedAmt').text();
													    
									if(actualAmountVal!=undefined && actualAmountVal!=""){
													    	
										actualAmount.push(parseFloat(actualAmountVal.trim()).toFixed(2));
													    	
									}
									
						    
						 }
								
					});
					
							
					
					
					
					 for (var i = 0; i < allowanceCode.length; i++) {
						    
					  		
				  		 var re_for_double = '^[0-9]*\.[0-9]*$';
						 var int_regex=/^\d+$/;
							
							
							if(approvedAmount[i]==""){
								
								$('.error-box').css({
									'visibility' : 'visible'
								});
								$("#errordiv").text("Approved amount should not empty");
								$(this).closest('td').prev().addClass("ui-state-error");
								$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
								return false;
								
							}else if(!((int_regex.test(approvedAmount[i])) || (approvedAmount[i].match(re_for_double)))){
								
								
								$('.error-box').css({
									'visibility' : 'visible'
								});
								$("#errordiv").text("Enter valid approved amount");
								$(this).closest('td').prev().addClass("ui-state-error");
								$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
								return false;
							
								
							}else if(parseFloat(approvedAmount[i])>parseFloat(actualAmount[i])){
								
								
								$('.error-box').css({
									'visibility' : 'visible'
								});
								$("#errordiv").text("Account Approved amount should not greater than Director Approved Amount");
								$(this).closest('td').prev().addClass("ui-state-error");
								$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
								return false;
							
								
							}else{
								
							}

							
				 }		
					
					 
								
						var x = confirm("Are you sure you want approve allowanses?");
						if (x) {	
							
							
								var allowanceData={
										"allowandcode":allowanceCode.join(","),
										"approvedAmount":approvedAmount.join(","),
										"comments":accountsComments.join("|")
										};
								
								
								$
								.ajax({
									type : 'POST',
									url : "EmpAllowAprroveByDirectorAction.do?method=approveAllAllowanses",
									data : allowanceData,
									  beforeSend: function() {
									       
										  $('#loader').show();
										  
									    },
									success : function(
											response) {

										var result = $.parseJSON(response);
										$('#loader').hide();
										
										
									
										if(result.status=="true" || result.status=="MialSent"){
											
											
											window.location.href="GetDetails.do?parameter=getDailyAllowancesForApprove&status="+result.status;
											
											
										}else{
												
												$('.error-box').css({
													'visibility' : 'visible'
												});
												
												$("#errordiv").text("Allowanses not approved,Try again");
												$(this).closest('td').prev().addClass("ui-state-error");
												$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
											}
										
										
										
									}

								});
								
								}
								
					
				});
				
				
				
					
				});




function validate(){
	
	
	var startdate=$("#todate").val();
	var fromdate=$("#fromdate").val();
	
	
	
	if(startdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Todate");
		$("#todate").addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
	
		return false;
		
	}else if(fromdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select FromDate");
		$("#fromdate").addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else{
		
		return true;
	}
	
	
}