$(document)
		.ready(
				function() {
					
					
					
					$("#approveRecords tr").each(function(){
						
						
						if($(this).find('.approveAllowance').val()=='Approved'){
							
							$(this).find('.rejectAllowance').hide();
								
								$(this).find('.approveAllowance').css('color','white');
								$(this).find('.approveAllowance').css("background-color","#1267E9");
								
								$(this).find('.approveAllowance').closest('td').prev().find("input").prop('readonly', true);
								$(this).find('.approveAllowance').closest('td').prev().find("input").css("background-color","#D9D9D9");
								
								$(this).find('.approveAllowance').closest('td').prev().prev().find("textarea").prop('readonly', true);
								$(this).find('.approveAllowance').closest('td').prev().prev().find("textarea").css("background-color","#D9D9D9");
						}
						
						if($(this).find('.rejectAllowance').val()=='Rejected'){
							
							$(this).find('.approveAllowance').hide();
								
								$(this).find('.rejectAllowance').css('color','white');
								$(this).find('.rejectAllowance').css("background-color","#1267E9");
								
								$(this).find('.rejectAllowance').closest('td').prev().prev().find("input").prop('readonly', true);
								$(this).find('.rejectAllowance').closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
								
								$(this).find('.rejectAllowance').closest('td').prev().prev().prev().find("textarea").prop('readonly', true);
								$(this).find('.rejectAllowance').closest('td').prev().prev().prev().find("textarea").css("background-color","#D9D9D9");
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
						
						
						var datalst={"tktBookingCode":(this).id};
						
						$
						.ajax({
							type : 'POST',
							url : "approveTravelBooked.do?method=getsingleTicketDetailsAction",
							data : datalst,
							success : function(
									response) {
								
								$(".rightindialog").text("");

								var result = $.parseJSON(response);
								$("#postedby").text(result.tktVO[0].postedby);
								$("#posteddate").text(result.tktVO[0].posteddate);
								$("#debicreditcard").text(result.tktVO[0].creditcardused);
								$("#project").text(result.tktVO[0].project);
								$("#travellingdate").text(result.tktVO[0].travelling_date);
								$("#postedbyremarks").text(result.tktVO[0].remarks);
								$("#approvedby").text(result.tktVO[0].approvedby);
								$("#approveddate").text(result.tktVO[0].approvedtime);
								$("#projectrefcode").text(result.tktVO[0].projectrefcode);
								
								
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
								height : 350,
								width : 600,
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
				var approvedAmount=  parseFloat($(this).closest('td').prev().find("input").val().trim()).toFixed(2);
				var comments=  $(this).closest('td').prev().prev().find("textarea").val().trim();
				var acualamount= parseFloat($(this).closest('td').prev().prev().prev().text().trim()).toFixed(2);
						
						var re_for_double = '^[0-9]*\.[0-9]*$';
						var int_regex=/^\d+$/;
						
						if(approvedAmount=="" || approvedAmount=='NaN'){
							
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
						
							
						}else{
							
							var x = confirm("Are you sure you want approve Ticket? Approve amount="+approvedAmount);
							if (x) {
					
					
					var allowandcode=allowandcodedetails[1];
					
						
						var allowanceData={"tktBookingCOde":allowandcode,"approvedAmount":approvedAmount,"comments":comments};
						
						$
						.ajax({
							type : 'POST',
							url : "approveTravelBooked.do?method=approveSingleTicketAction",
							data : allowanceData,
							 beforeSend: function() {
							       
								  $('#loader').show();
								  
							    },
							success : function(
									response) {

								var result = $.parseJSON(response);
								$('#loader').hide();
								
								if(result.status=="true"){
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									
									$("#Reject_"+allowandcode).hide();
									
									$("#errordiv").text("Travel booking approved successfully,Mail not sent");
									$("#todate").addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									
									$("#"+approveId).val("Approved");
									$("#"+approveId).css('color','white');
									$("#"+approveId).css("background-color","#1267E9");
									
									$("#"+approveId).closest('td').prev().find("input").prop('readonly', true);
									$("#"+approveId).closest('td').prev().find("input").css("background-color","#D9D9D9");
									
									$("#"+approveId).closest('td').prev().prev().find("textarea").prop('readonly', true);
									$("#"+approveId).closest('td').prev().prev().find("textarea").css("background-color","#D9D9D9");
								
								}else if(result.status=="MialSent"){
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									
									$("#Reject_"+allowandcode).hide();
									
									$("#successmessge").text("Travel booking approved successfully");
									
									$("#"+approveId).val("Approved");
									$("#"+approveId).css('color','white');
									$("#"+approveId).css("background-color","#1267E9");
									
									$("#"+approveId).closest('td').prev().find("input").prop('readonly', true);
									$("#"+approveId).closest('td').prev().find("input").css("background-color","#D9D9D9");
									
									$("#"+approveId).closest('td').prev().prev().find("textarea").prop('readonly', true);
									$("#"+approveId).closest('td').prev().prev().find("textarea").css("background-color","#D9D9D9");
								
								}else{
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Travel booking not approved,Try agian");
									$("#todate").addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									

															}

																}

															});

												}

											}

										}
			
						
					});
				
				
	$(".rejectAllowance").click(function(){
					
					var rejectId=(this).id;
					
				if($("#"+rejectId).val()=="Reject"){
					
				var tktbkcodedetails=((this).id).split("_");
				var approvedAmount=  parseFloat($(this).closest('td').prev().prev().find("input").val().trim()).toFixed(2);
				var comments=  $(this).closest('td').prev().prev().prev().find("textarea").val().trim();
						
				var x = confirm("Are you sure you want reject travelbooking details?");
				if (x) {
			
			
					var travelbooking=tktbkcodedetails[1];
			
				
				var tktbkData={"tktBookingCOde":travelbooking,"approvedAmount":approvedAmount,"comments":comments};
				
				$
				.ajax({
					type : 'POST',
					url : "approveTravelBooked.do?method=rejectSingleTicketAction",
					data : tktbkData,
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
							$("#errordiv").text("Travel booking details rejected Successfully,Mail not Sent");
							
							
							$("#"+rejectId).val("Rejected");
							$("#"+rejectId).css('color','white');
							$("#"+rejectId).css("background-color","#1267E9");
							
							$("#"+rejectId).closest('td').prev().find("input").hide();
							
							$("#"+rejectId).closest('td').prev().prev().find("input").prop('readonly', true);
							$("#"+rejectId).closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
							
							
							$("#"+rejectId).closest('td').prev().prev().prev().find("textarea").prop('readonly', true);
							$("#"+rejectId).closest('td').prev().prev().prev().find("textarea").css("background-color","#D9D9D9");
							
							
							
							
						}else if( result.status=="MialSent"){
							
							$('.error-box').css({
								'visibility' : 'visible'
							});
							
							$("#successmessge").text("Allowance rejected successfully");
							
							
							$("#"+rejectId).val("Rejected");
							$("#"+rejectId).css('color','white');
							$("#"+rejectId).css("background-color","#1267E9");
							
							$("#"+rejectId).closest('td').prev().find("input").hide();
							
							$("#"+rejectId).closest('td').prev().prev().find("input").prop('readonly', true);
							$("#"+rejectId).closest('td').prev().prev().find("input").css("background-color","#D9D9D9");
							
							
							$("#"+rejectId).closest('td').prev().prev().prev().find("textarea").prop('readonly', true);
							$("#"+rejectId).closest('td').prev().prev().prev().find("textarea").css("background-color","#D9D9D9");
							
							
							
							
						}else{
							
							$('.error-box').css({
								'visibility' : 'visible'
							});
							$("#errordiv").text("Allowance rejection Failed,Try later");
						}
						
						
						
					}

				});
				
				}
						
					}
			
						
					});
				
				
				/*
				$("#approveRecords tr").each(function(){
					
					
				if($(this).find('.approveAllowance').val()!=undefined && $(this).find('.approveAllowance').val()=='Approved'){
						
						$(this).find('.approveAllowance').css('color','white');
						$(this).find('.approveAllowance').css("background-color","#1267E9");
						
						$(this).find('.approveAllowance').closest('td').prev().find("input").prop('readonly', true);
						$(this).find('.approveAllowance').closest('td').prev().find("input").css("background-color","#D9D9D9");
						
						$(this).find('.approveAllowance').closest('td').prev().prev().find("textarea").prop('readonly', true);
						$(this).find('.approveAllowance').closest('td').prev().prev().find("textarea").css("background-color","#D9D9D9");
				}
					
				});*/
					
				
				$("#downloadBookingDetails").click(function(){
					
					
					window.location.href = 'approveTravelBooked.do?method=downloadTravelBookingDetails&startdate='
										+ $("#todate").val()
										+ ' &enddate='
										+ $("#fromdate").val();
						
					
				});
				
				
				$("#downloadConflictBookingDetails").click(function(){
					
					window.location.href = 'approveTravelBooked.do?method=downloadConflictTravelBookingDetails&startdate='
										+ $("#todate").val()
										+ ' &enddate='
										+ $("#fromdate").val();
						
					
				});
					
				
	$("#approveAll").click(function(){
		
					var directorComments=[];
					var approvedAmount=[];
					var bookingCode=[];
					var actualAmount=[];
					
					 $("#approveRecords tr").each(function(){
						 
						 var approveStatus=$(this).find('.approveAllowance').val();
						 
						 if(approveStatus=='Approve'){
						 
						 
						    var comments=$(this).find('.directorComments').val();
							  
						    if(comments!=undefined ){
						    	
						    	
						    	if(comments.trim()==""){
						    		
						    		directorComments.push("null");
						    		
						    	}else{
						    	directorComments.push(comments.trim());
						    	}
							}
						    
						    
						    
						    var amount=$(this).find('.approvedamount').val();
							  
						    if(amount!=undefined && amount!=""){
						    	
						    	approvedAmount.push(parseFloat(amount.trim()).toFixed(2));
						    	
							}
						    
						    
						    var bookingCodeId=$(this).find('.hbookingId').val();
						    
						    if(bookingCodeId!=undefined && bookingCodeId!=""){
						    	
						    	bookingCode.push(bookingCodeId.trim());
						    	
							}
						    
							  var actualAmountVal=$(this).find('.actualAmount').text();
													    
									if(actualAmountVal!=undefined && actualAmountVal!=""){
													    	
										actualAmount.push(parseFloat(actualAmountVal.trim()).toFixed(2));
													    	
									}
									
						    
						 }
								
					});
					 
					 
					 for (var i = 0; i < bookingCode.length; i++) {
						    
					  		
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
								
									
								}/*else if(parseFloat(approvedAmount[i])>parseFloat(actualAmount[i])){
									
									
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Approved amount should not greater than Amount");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
								
									
								}*/else{
									
								}

								
					 }		
									
								
						var x = confirm("Are you sure you want approve TravelBooking Details?");
						if (x) {	
							
							
								var allowanceData={
										"tktBookingCOde":bookingCode.join(","),
										"approvedAmount":approvedAmount.join(","),
										"comments":directorComments.join("|")
										};
								
								
								$
								.ajax({
									type : 'POST',
									url : "approveTravelBooked.do?method=approveAllTravelBookingDetails",
									data : allowanceData,
									  beforeSend: function() {
									       
										  $('#loader').show();
										  
									    },
									success : function(
											response) {

										var result = $.parseJSON(response);
										$('#loader').hide();
									
										if(result.status=="true" || result.status=="MialSent"){
											
											window.location.href="GetDetails.do?parameter=getTravelBookingDetails&status="+result.status;
											
											
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
					
					
	
	    $('.download').click(function() {
		
	                var filepath = $(this).attr('id');
			 
		        window.location ="travelBooked.do?method=download&filepath="+filepath;
	
	    });
	
	
				});




function validate(){
	
	
	var startdate=$("#todate").val();
	var fromdate=$("#fromdate").val();
	
	
	
	if(startdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select StartDate");
		$("#todate").addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
	
		return false;
		
	}else if(fromdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select End Date");
		$("#fromdate").addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else{
		
		return true;
	}
	
	
}